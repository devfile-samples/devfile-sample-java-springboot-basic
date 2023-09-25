package ca.bc.gov.chefs.etl.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPCompressedData;
import org.bouncycastle.openpgp.PGPException;

import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPLiteralDataGenerator;
import org.bouncycastle.openpgp.PGPOnePassSignatureList;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyEncryptedData;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.jcajce.JcaPGPObjectFactory;
import org.bouncycastle.openpgp.operator.PublicKeyDataDecryptorFactory;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcePublicKeyDataDecryptorFactoryBuilder;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.ChefsRequestPayload;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

public class CommonUtils {

	/**
	 * Copies "length" amount of data from the input stream and writes it pgp
	 * literal data to the provided output stream
	 *
	 * @param outputStream the output stream to which data is to be written
	 * @param in           the input stream from which data is to be read
	 * @param length       the length of data to be read
	 * @param bufferSize   the buffer size, as it uses buffer to speed up copying
	 * @throws IOException for IO related errors
	 */
	static void copyAsLiteralData(OutputStream outputStream, InputStream in, long length, int bufferSize)
			throws IOException {
		PGPLiteralDataGenerator lData = new PGPLiteralDataGenerator();
		OutputStream pOut = lData.open(outputStream, PGPLiteralData.BINARY, PGPLiteralData.CONSOLE,
				Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)), new byte[bufferSize]);
		byte[] buff = new byte[bufferSize];
		try {
			int len;
			long totalBytesWritten = 0L;
			while (totalBytesWritten <= length && (len = in.read(buff)) > 0) {
				pOut.write(buff, 0, len);
				totalBytesWritten += len;
			}
			pOut.close();
		} finally {
			// Clearing buffer
			Arrays.fill(buff, (byte) 0);
			// Closing inputstream
			in.close();
		}
	}

	/**
	 * Gets the public key from the key input stream
	 *
	 * @param keyInputStream the key input stream
	 * @return a PGPPublic key instance
	 * @throws IOException  for IO related errors
	 * @throws PGPException PGPException for pgp related errors
	 */
	static PGPPublicKey getPublicKey(InputStream keyInputStream) throws IOException, PGPException {
		PGPPublicKeyRingCollection pgpPublicKeyRings = new PGPPublicKeyRingCollection(
				PGPUtil.getDecoderStream(keyInputStream), new JcaKeyFingerprintCalculator());
		Iterator<PGPPublicKeyRing> keyRingIterator = pgpPublicKeyRings.getKeyRings();
		while (keyRingIterator.hasNext()) {
			PGPPublicKeyRing pgpPublicKeyRing = keyRingIterator.next();
			Optional<PGPPublicKey> pgpPublicKey = extractPGPKeyFromRing(pgpPublicKeyRing);
			if (pgpPublicKey.isPresent()) {
				keyInputStream.reset();
				return pgpPublicKey.get();
			}
		}
		keyInputStream.reset();
		throw new PGPException("Invalid public key");
	}

	private static Optional<PGPPublicKey> extractPGPKeyFromRing(PGPPublicKeyRing pgpPublicKeyRing) {
		for (PGPPublicKey publicKey : pgpPublicKeyRing) {
			if (publicKey.isEncryptionKey()) {
				return Optional.of(publicKey);
			}
		}
		return Optional.empty();
	}

	    /**
     * Decrypts the public Key encrypted data using the provided private key and writes it to the output stream
     *
     * @param clearOut               the output stream to which data is to be written
     * @param pgpPrivateKey          the private key instance
     * @param publicKeyEncryptedData the public key encrypted data instance
     * @throws IOException  for IO related error
     * @throws PGPException for pgp related errors
     */
	//TODO This part is for testing purposes only, remove when done
    static void decrypt(OutputStream clearOut, PGPPrivateKey pgpPrivateKey, PGPPublicKeyEncryptedData publicKeyEncryptedData) throws IOException, PGPException {
        PublicKeyDataDecryptorFactory decryptorFactory = new JcePublicKeyDataDecryptorFactoryBuilder()
                .setProvider(BouncyCastleProvider.PROVIDER_NAME).build(pgpPrivateKey);
        InputStream decryptedCompressedIn = publicKeyEncryptedData.getDataStream(decryptorFactory);

        JcaPGPObjectFactory decCompObjFac = new JcaPGPObjectFactory(decryptedCompressedIn);
        PGPCompressedData pgpCompressedData = (PGPCompressedData) decCompObjFac.nextObject();

        InputStream compressedDataStream = new BufferedInputStream(pgpCompressedData.getDataStream());
        JcaPGPObjectFactory pgpCompObjFac = new JcaPGPObjectFactory(compressedDataStream);

        Object message = pgpCompObjFac.nextObject();

        if (message instanceof PGPLiteralData) {
            PGPLiteralData pgpLiteralData = (PGPLiteralData) message;
            InputStream decDataStream = pgpLiteralData.getInputStream();
            IOUtils.copy(decDataStream, clearOut);
            clearOut.close();
        } else if (message instanceof PGPOnePassSignatureList) {
            throw new PGPException("Encrypted message contains a signed message not literal data");
        } else {
            throw new PGPException("Message is not a simple encrypted file - Type Unknown");
        }
        // Performing Integrity check
        if (publicKeyEncryptedData.isIntegrityProtected()) {
            if (!publicKeyEncryptedData.verify()) {
                throw new PGPException("Message failed integrity check");
            }
        }
    }

	public static String generateRequestUri(ChefsRequestPayload payload, String formUsername){
		String uri = PropertiesUtil.getValue(Constants.CHEFS_API_URL).formatted(PropertiesUtil.getValue(formUsername), payload.getVersion(),payload.getStartDate(),payload.getEndDate(),
		payload.getUpdatedMinDate(), payload.getUpdatedMaxDate(), payload.isDraft(), payload.isDeleted(), payload.getStatus());
		if(!payload.isDraft()){
			uri = uri.replaceAll("&drafts=false&", "&");
		}
		if(!payload.isDeleted()){
			uri = uri.replaceAll("&deleted=false&", "&");
		}
		return uri;
	}

	/* Method used for testing purposed only, allows to see transformations done to a json payload */
    public static void WriteStringToFile(String longString) {

        // Specify the file path where you want to write the string
        String filePath = "output.txt";

        try {
            // Create a FileWriter and BufferedWriter to write to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            // Write the long string to the file
            writer.write(longString);
            // Close the writer to release resources
            writer.close();
        } catch (IOException e) {
            // Handle any IO exceptions that may occur
            e.printStackTrace();
        }
    }
}
