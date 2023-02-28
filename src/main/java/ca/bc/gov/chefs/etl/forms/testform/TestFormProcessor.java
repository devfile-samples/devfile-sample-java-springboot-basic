package ca.bc.gov.chefs.etl.forms.testform;

import java.security.Security;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.TestFormRoute;
import ca.bc.gov.chefs.etl.parser.FileModel;
import ca.bc.gov.chefs.etl.util.FileUtil;

public class TestFormProcessor implements Processor {

	private static final Logger logger = LoggerFactory.getLogger(TestFormRoute.class);

	public void process(Exchange exchange) throws Exception {
		logger.info("Hello! Processing Now: current timestamp is: {}",System.currentTimeMillis());
		logger.info("Body Received: {}", exchange.getIn().getBody());                
		FileModel fm = new FileModel();
		fm.setFrom("files");
		fm.setTo("encfiles");
		fm.setPgpPublicKeyPath("keys/publickey.asc");
		
		// if provider is not present, add it
		if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
		    // insert at specific position
		    Security.insertProviderAt(new BouncyCastleProvider(), 1);
		}
		
		FileUtil.encryptFilesInDirectory(fm.getFrom(), fm.getPgpPublicKeyPath(), fm.getTo());
		
	}

}
