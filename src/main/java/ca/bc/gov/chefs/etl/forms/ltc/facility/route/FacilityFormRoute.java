package ca.bc.gov.chefs.etl.forms.ltc.facility.route;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.ltc.facility.processor.FacilityInfoFormApiProcessor;
import ca.bc.gov.chefs.etl.forms.ltc.facility.processor.FacilityInfoFormApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.ltc.facility.processor.FacilityInfoFormProcessor;

public class FacilityFormRoute extends BaseRoute {

	private static final Logger logger = LoggerFactory.getLogger(FacilityFormRoute.class);

	@Override
	public void configure() throws Exception {
		logger.info("Loaded Facility Info Form Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 * 
		 * 
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/ltc/facility-information").routeId("ltc-facility-information-form")
				.log("CHEFS-ETL received a request for LTC Facility Information Form extraction")// .bean(AIMSFormPayloadExtractor.class)
				.process(new FacilityInfoFormProcessor()).to("direct:ltc-facility-information").end();

		from("direct:ltc-facility-information").process(new FacilityInfoFormApiProcessor())
				// to the http uri
				.to("https://submit.digital.gov.bc.ca/app/api/v1/forms/e1f4761f-efdd-4529-805e-677d3ae21601/export?bridgeEndpoint=true&format=json&type=submissions&version=2")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new FacilityInfoFormApiResponseProcessor()).end();
		// database phase
		
		

		// file conversion

	}

}
