package ca.bc.gov.chefs.etl.forms.ltc.facility.route;

import org.slf4j.Logger;


import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.ltc.facility.processor.FacilityInfoFormApiProcessor;
import ca.bc.gov.chefs.etl.forms.ltc.facility.processor.FacilityInfoFormApiResponseProcessor;

public class FacilityFormRoute extends BaseRoute {

	private static final Logger logger = LoggerFactory.getLogger(FacilityFormRoute.class);

	@Override
	public void configure() throws Exception {
		logger.info("Loaded Facility Info Form Route");
		super.configure();

		/**
		 * receive JSON payload, parse and set to make an API call
		 * 
		 * 
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/ltc/facility-information").routeId("ltc-facility-information-form")
				.log("CHEFS-ETL received a request for LTC Facility Information Form extraction")// .bean(AIMSFormPayloadExtractor.class)
				.to("direct:ltc-facility-information").end();

		from("direct:ltc-facility-information")
				// to the http uri
				.process(new FacilityInfoFormApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new FacilityInfoFormApiResponseProcessor())
				.setHeader("Content-Type",constant("application/json"))
				.end();
		// database phase
		
		

		// file conversion

	}

}
