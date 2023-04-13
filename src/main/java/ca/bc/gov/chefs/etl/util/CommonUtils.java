package ca.bc.gov.chefs.etl.util;

import org.bouncycastle.openpgp.PGPException;

import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPLiteralDataGenerator;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;

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

}
