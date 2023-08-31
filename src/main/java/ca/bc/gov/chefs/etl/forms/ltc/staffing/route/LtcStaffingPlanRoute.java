package ca.bc.gov.chefs.etl.forms.ltc.staffing.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.aims.route.AIMSFormRoute;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.processor.LTCStaffingPlanApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.processor.LtcStaffingPlanApiProcessor;

public class LtcStaffingPlanRoute extends BaseRoute {

	private static final Logger logger = LoggerFactory.getLogger(AIMSFormRoute.class);
	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded LTC Staffing Plan Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 * 
		 * 
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/ltc-staffing-plan").routeId("ltc-staffing-plan-form")
				.log("CHEFS-ETL received a request for LTC Staffing Plan  Form extraction")
				.to("direct:ltc-staffing-plan").end();

		from("direct:ltc-staffing-plan")
				// to the http uri
				.process(new LtcStaffingPlanApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new LTCStaffingPlanApiResponseProcessor()).end();

		// file conversion
		/*
		 * from("direct:ltc-quarterly-csv-processing").routeId("")
		 * .log("CHEFS ETL received a request to encrypt files") .process()
		 */
	}

}
