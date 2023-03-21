package ca.bc.gov.chefs.etl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.camel.main.Main;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.routes.HelloRoute;
import ca.bc.gov.chefs.etl.forms.ltc.facility.route.FacilityFormRoute;
import ca.bc.gov.chefs.etl.forms.ltc.quaterly.route.LtcQuaterlyYtdRoute;
import ca.bc.gov.chefs.etl.forms.aims.route.AIMSFormRoute;
/**
 * Camel Class runner.
 * */
public class ChefsETLMainMethod {
	
	static {
		/* Creating Necessary Directories for ETL */
		
		/* Encrypted and Non-Encrypted Directories */
		try {
			Files.createDirectories(Paths.get(Constants.DATA_DIRECTORY));
			Files.createDirectories(Paths.get(Constants.ENCRYPTED_DATA_DIRECTORY));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String... args) throws Exception {
		Main main = new Main();
		main.configure().addRoutesBuilder(HelloRoute.class);
		main.configure().addRoutesBuilder(AIMSFormRoute.class);
		main.configure().addRoutesBuilder(FacilityFormRoute.class);
		main.configure().addRoutesBuilder(LtcQuaterlyYtdRoute.class);
		main.run(args);
	}
}
