package ca.bc.gov.chefs.etl.util;

//import org.apache.commons.io.IOUtils;
import org.bouncycastle.bcpg.ArmoredOutputStream;

import org.bouncycastle.bcpg.CompressionAlgorithmTags;
import org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedData;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedDataList;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKeyEncryptedData;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.jcajce.JcaPGPObjectFactory;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyDecryptorBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcePGPDataEncryptorBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcePublicKeyKeyEncryptionMethodGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.io.CsvListWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;
import org.supercsv.quote.AlwaysQuoteMode;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.FileProperties;

import static ca.bc.gov.chefs.etl.constant.Constants.HEADERS;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;

public class FileUtil {

	private int compressionAlgorithm = CompressionAlgorithmTags.ZIP;
	private int symmetricKeyAlgorithm = SymmetricKeyAlgorithmTags.AES_128;
	private boolean armor = true;
	private boolean withIntegrityCheck = true;
	private int bufferSize = 1 << 16;
	private static final Logger logger = LoggerFactory.getLogger(CSVUtil.class);
	private static final CsvPreference ALWAYS_USE_QUOTE = new CsvPreference.Builder(CsvPreference.STANDARD_PREFERENCE)
			.useQuoteMode(new AlwaysQuoteMode()).build();

	public void encrypt(OutputStream encryptOut, InputStream clearIn, long length, InputStream publicKeyIn)
			throws IOException, PGPException {
		PGPCompressedDataGenerator compressedDataGenerator = new PGPCompressedDataGenerator(compressionAlgorithm);
		PGPEncryptedDataGenerator pgpEncryptedDataGenerator = new PGPEncryptedDataGenerator(
				// This bit here configures the encrypted data generator
				new JcePGPDataEncryptorBuilder(symmetricKeyAlgorithm).setWithIntegrityPacket(withIntegrityCheck)
						.setSecureRandom(new SecureRandom()).setProvider(BouncyCastleProvider.PROVIDER_NAME));
		// Adding public key
		pgpEncryptedDataGenerator
				.addMethod(new JcePublicKeyKeyEncryptionMethodGenerator(CommonUtils.getPublicKey(publicKeyIn)));
		if (armor) {
			encryptOut = new ArmoredOutputStream(encryptOut);
		}
		OutputStream cipherOutStream = pgpEncryptedDataGenerator.open(encryptOut, new byte[bufferSize]);
		CommonUtils.copyAsLiteralData(compressedDataGenerator.open(cipherOutStream), clearIn, length, bufferSize);
		// Closing all output streams in sequence
		compressedDataGenerator.close();
		cipherOutStream.close();
		encryptOut.close();
	}

	public static void encryptFilesInDirectory(String directoryPath, String publicKeyFilePath,
		String outputDirectoryPath) throws Exception {
		FileUtil fU = new FileUtil();
		// Read the public key from the file
		InputStream publicKeyInputStream = new BufferedInputStream(new FileInputStream(new File(publicKeyFilePath)));

		// Get a list of all the files in the directory
		File dir = new File(directoryPath);
		File[] files = dir.listFiles();
		
		// Compress and encrypt each file
		for (File file : files) {

			String inputFilePath = file.getAbsolutePath();
			String outputFileName = file.getName() + ".gz" + ".gpg";
			String gzipFileName = file.getName() + ".gz";
			String outputFilePath = outputDirectoryPath + "/" + outputFileName;
			String gzipFilePath = outputDirectoryPath + "/" + gzipFileName;
			File outputFile = new File(outputDirectoryPath, outputFileName);
			if (!outputFile.exists()) {
				outputFile.createNewFile();
			}
			if (!new File(outputDirectoryPath, gzipFileName).exists()) {
				new File(outputDirectoryPath, gzipFileName).createNewFile();
			}

			fU.compressFileG(inputFilePath, gzipFilePath);
			InputStream gzipInputStream = new BufferedInputStream(new FileInputStream(gzipFilePath));

			OutputStream encryptedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFilePath));
			fU.encrypt(encryptedOutputStream, gzipInputStream, file.length(), publicKeyInputStream);
			encryptedOutputStream.close();

			// Clean up the gzip file
			new File(outputDirectoryPath, gzipFileName).delete();
		}
	}

	private void compressFileG(String sourceFilePath, String destinationFilePath) {
		byte[] buffer = new byte[1024];

		try {

			FileOutputStream fileOutputStream = new FileOutputStream(destinationFilePath);

			GZIPOutputStream gzipOuputStream = new GZIPOutputStream(fileOutputStream);

			FileInputStream fileInput = new FileInputStream(sourceFilePath);

			int bytes_read;

			while ((bytes_read = fileInput.read(buffer)) > 0) {
				gzipOuputStream.write(buffer, 0, bytes_read);
			}

			fileInput.close();

			gzipOuputStream.finish();
			gzipOuputStream.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static List<String> writeToCSVFile(Map<String, List<List<String>>> map,  String directoryKey) throws IOException {
		FileProperties fileProperties = new FileProperties();
		fileProperties.setUnEncDirForThisExchange(Constants.UNENC_FILE_PATH.get(directoryKey));
		fileProperties.setEncDirForThisExchange(Constants.ENC_FILE_PATH.get(directoryKey));
		ICsvListWriter listWriter = null;
		List<String> filesGenerated = new ArrayList<String>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		String dateTime = LocalDateTime.now().format(formatter);
	
		for (Map.Entry<String, List<List<String>>> entry : map.entrySet()) {
			String fileName = generateFileName(entry.getKey(),dateTime,fileProperties);
			String[] headers = HEADERS.get(entry.getKey());
			logger.info("--------Generating CSV File---------------{}---------------", fileName);
			try {

				listWriter = new CsvListWriter(new FileWriter(fileName), ALWAYS_USE_QUOTE);
				listWriter.writeHeader(headers);
				
				for (List<String> items : entry.getValue()) {
					listWriter.write(items);
				}
				filesGenerated.add(fileName.substring(fileName.lastIndexOf(File.separator)+1));
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (listWriter != null) {
					try {
						listWriter.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}
		fileProperties.setExtension(".flag");
		String flagFileName = generateFileName("medis-etl", dateTime, fileProperties);
		File file = new File(flagFileName);
		FileWriter fileWriter = new FileWriter(file);
		logger.info("--------Generating Flag File---------------{}---------------", flagFileName);
		for(String fileName : filesGenerated) {
			fileWriter.append(fileName);
			fileWriter.append("\n");
		}
		filesGenerated.add(flagFileName.substring(flagFileName.lastIndexOf(File.separator)+1));
		fileWriter.close();
		try{
			encryptAllFiles(dateTime, fileProperties);
		} catch(Exception e){
			e.printStackTrace();
		}
		return filesGenerated;
	}


	public static void encryptAllFiles(String dateTime, FileProperties fileProperties) throws Exception{
		String directoryPath = generateFolderName(dateTime, fileProperties.getUnEncDirForThisExchange());
		String publicKeyFilePath = Constants.PUBLIC_KEY_PATH;
		String outputDirectoryPath = generateFolderName(dateTime, fileProperties.getEncDirForThisExchange());
		try {
			Files.createDirectories(Paths.get(directoryPath));
			Files.createDirectories(Paths.get(outputDirectoryPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		encryptFilesInDirectory(directoryPath, publicKeyFilePath, outputDirectoryPath);
	}

	public static String generateFolderName(String dateTime, String directoryName) {
		return directoryName.concat(File.separator).concat(dateTime).replace(File.separator, "/");
	}

	public static String generateFileName(String fileType,String dateTime,FileProperties fileProperties) {
		String directoryForThisExchange = fileProperties.getUnEncDirForThisExchange();
		String directoryPath = directoryForThisExchange.concat(File.separator).concat(dateTime).concat(File.separator);
		try {
			Files.createDirectories(Paths.get(directoryPath));
		} catch (IOException e) {
			logger.error("File Write Exception: "+e.getMessage());
			e.printStackTrace();
		}
		if(fileProperties.getExtension().equals(".flag")) {
			return directoryPath+fileType.toLowerCase().concat(fileProperties.getExtension());
		}
		return directoryPath+fileType.toLowerCase()+"_".concat(dateTime).concat(fileProperties.getExtension());
	}

	public static String buildDestinationPath(String propertyName, boolean isDataEncrypted){
		if (isDataEncrypted){
			return PropertiesUtil.getValue(Constants.PROPERTIES_ENC_DATA_DIR)+File.separator+PropertiesUtil.getValue(propertyName);
		}
		return PropertiesUtil.getValue(Constants.PROPERTIES_DATA_DIR)+File.separator+PropertiesUtil.getValue(propertyName);
	}

	public static String buildDirectoryPath(String propertyName){
		return PropertiesUtil.getValue(propertyName);
	}

	public static String buildPublicKeyPath(String propertyName){
		return "src/main/resources/"+PropertiesUtil.getValue(propertyName);
	}

	/** ----------------decryption starts here, testing encryption -------------------
	* TODO This part is for testing purposes only, remove when done */

    private static PGPPrivateKey findSecretKey(long keyID) throws Exception, PGPException {
		String privateKeyInPath = "src/main/resources/secret-Test.txt";
		String password = "789456123";
		char[] passCode = password.toCharArray();
		InputStream privateKeyIn = new BufferedInputStream(new FileInputStream(new File(privateKeyInPath)));
		PGPSecretKeyRingCollection pgpSecretKeyRingCollection = new PGPSecretKeyRingCollection(PGPUtil.getDecoderStream(privateKeyIn)
                , new JcaKeyFingerprintCalculator());
        PGPSecretKey pgpSecretKey = pgpSecretKeyRingCollection.getSecretKey(keyID);
        return pgpSecretKey == null ? null : pgpSecretKey.extractPrivateKey(new JcePBESecretKeyDecryptorBuilder()
                .setProvider(BouncyCastleProvider.PROVIDER_NAME).build(passCode));
    }

    public static void decrypt(InputStream encryptedIn, OutputStream clearOut)
            throws PGPException, IOException, Exception {
        // Removing armour and returning the underlying binary encrypted stream
        encryptedIn = PGPUtil.getDecoderStream(encryptedIn);
        JcaPGPObjectFactory pgpObjectFactory = new JcaPGPObjectFactory(encryptedIn);

        Object obj = pgpObjectFactory.nextObject();
        //The first object might be a marker packet
        PGPEncryptedDataList pgpEncryptedDataList = (obj instanceof PGPEncryptedDataList)
                ? (PGPEncryptedDataList) obj : (PGPEncryptedDataList) pgpObjectFactory.nextObject();

        PGPPrivateKey pgpPrivateKey = null;
        PGPPublicKeyEncryptedData publicKeyEncryptedData = null;

        Iterator<PGPEncryptedData> encryptedDataItr = pgpEncryptedDataList.getEncryptedDataObjects();
        while (pgpPrivateKey == null && encryptedDataItr.hasNext()) {
            publicKeyEncryptedData = (PGPPublicKeyEncryptedData) encryptedDataItr.next();
            pgpPrivateKey = FileUtil.findSecretKey(publicKeyEncryptedData.getKeyID());
        }

        if (Objects.isNull(publicKeyEncryptedData)) {
            throw new PGPException("Could not generate PGPPublicKeyEncryptedData object");
        }

        if (pgpPrivateKey == null) {
            throw new PGPException("Could Not Extract private key");
        }
        CommonUtils.decrypt(clearOut, pgpPrivateKey, publicKeyEncryptedData);
    }

	public static void decryptAllFiles(String directoryPath, String outputDirectoryPath) throws IOException, PGPException, Exception{
				// Get a list of all the files in the directory
				File dir = new File(directoryPath);
				File[] files = dir.listFiles();
				try {
					Files.createDirectories(Paths.get(outputDirectoryPath));
				} catch (IOException e) {
					e.printStackTrace();
				}

				for (File file : files) {
		
					//String inputFilePath = file.getAbsolutePath();
					String outputFileName = file.getName().replace(".gpg", "");
					//String outputFilePath = outputDirectoryPath + "/" + outputFileName;
					File outputFile = new File(outputDirectoryPath, outputFileName);
					if (!outputFile.exists()) {
						outputFile.createNewFile();
					}
		
					InputStream encryptedDataInputStream = new BufferedInputStream(new FileInputStream(file));
		
					OutputStream encryptedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFile));
					FileUtil.decrypt(encryptedDataInputStream, encryptedOutputStream);
					encryptedOutputStream.close();
				}
	}
}
