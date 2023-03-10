package ca.bc.gov.chefs.etl.util;

//import org.apache.commons.io.IOUtils;
import org.bouncycastle.bcpg.ArmoredOutputStream;

import org.bouncycastle.bcpg.CompressionAlgorithmTags;
import org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.operator.jcajce.JcePGPDataEncryptorBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcePublicKeyKeyEncryptionMethodGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.io.CsvListWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;
import org.supercsv.quote.AlwaysQuoteMode;

import ca.bc.gov.chefs.etl.parser.FileProperties;

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
import java.util.List;
import java.util.Map;
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
		InputStream publicKeyInputStream = new BufferedInputStream(new FileInputStream(publicKeyFilePath));
		System.out.println(publicKeyFilePath);

		// Get a list of all the files in the directory
		File dir = new File(directoryPath);
		File[] files = dir.listFiles();

		// Compress and encrypt each file
		for (File file : files) {

			String inputFilePath = file.getAbsolutePath();
			String outputFilePath = outputDirectoryPath + "/" + file.getName() + ".gz" + ".gpg";
			String gzipFilePath = outputDirectoryPath + "/" + file.getName() + ".gz";
			File outputFile = new File(outputFilePath);
			if (!outputFile.exists()) {
				outputFile.createNewFile();
			}
			if (!new File(gzipFilePath).exists()) {
				new File(gzipFilePath).createNewFile();
			}

			fU.compressFileG(inputFilePath, gzipFilePath);
			InputStream gzipInputStream = new BufferedInputStream(new FileInputStream(gzipFilePath));

			OutputStream encryptedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFilePath));
			fU.encrypt(encryptedOutputStream, gzipInputStream, file.length(), publicKeyInputStream);
			encryptedOutputStream.close();

			// Clean up the gzip file
			new File(gzipFilePath).delete();
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

			System.out.println("The file was compressed successfully!");

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static <T> void writeToCSVFile(Map<String, List<List<String>>> map,  FileProperties fileProperties) {
		ICsvListWriter listWriter = null;
		for (Map.Entry<String, List<List<String>>> entry : map.entrySet()) {
			String fileName = generateFileName(entry.getKey(),fileProperties);
			String[] headers = HEADERS.get(entry.getKey());
			logger.info("--------Generating CSV File---------------{}---------------", fileName);
			try {

				listWriter = new CsvListWriter(new FileWriter(fileName), ALWAYS_USE_QUOTE);
				listWriter.writeHeader(headers);

				for (List<String> items : entry.getValue()) {
					listWriter.write(items);
				}

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

	}

	public static String generateFileName(String fileType,FileProperties fileProperties) {
		String directoryForThisExchange = fileProperties.getUnEncDirForThisExchange();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		String dateTime = LocalDateTime.now().format(formatter);
		String directoryPath = directoryForThisExchange.concat(File.separator).concat(dateTime).concat(File.separator);
		try {
			Files.createDirectories(Paths.get(directoryPath));
		} catch (IOException e) {
			logger.error("File Write Exception: "+e.getMessage());
			e.printStackTrace();
		}
		return directoryPath+fileType.toLowerCase()+"_".concat(LocalDateTime.now().format(formatter)).concat(".txt");
	}
}
