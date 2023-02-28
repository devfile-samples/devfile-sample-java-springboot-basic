package ca.bc.gov.chefs.etl;

import org.apache.camel.main.Main;


import ca.bc.gov.chefs.etl.core.routes.TestFormRoute;
import ca.bc.gov.chefs.etl.forms.ltc.facility.route.FacilityFormRoute;
import ca.bc.gov.chefs.etl.forms.ltc.quaterly.route.LtcQuaterlyYtdRoute;
import ca.bc.gov.chefs.etl.forms.aims.route.AIMSFormRoute;
/**
 * Camel Class runner.
 * */
public class ChefsETLMainMethod {

	public static void main(String... args) throws Exception {
		Main main = new Main();
		main.configure().addRoutesBuilder(TestFormRoute.class);
		main.configure().addRoutesBuilder(AIMSFormRoute.class);
		main.configure().addRoutesBuilder(FacilityFormRoute.class);
		main.configure().addRoutesBuilder(LtcQuaterlyYtdRoute.class);
		main.run(args);
	}
}
