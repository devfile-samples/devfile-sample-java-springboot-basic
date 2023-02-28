package ca.bc.gov.chefs.etl.forms.ltc.quaterly.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.aims.route.AIMSFormRoute;
import ca.bc.gov.chefs.etl.forms.ltc.quaterly.processor.LtcQuaterlyYtdApiProcessor;
import ca.bc.gov.chefs.etl.forms.ltc.quaterly.processor.LtcQuaterlyYtdApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.ltc.quaterly.processor.LtcQuaterlyYtdProcessor;

public class LtcQuaterlyYtdRoute extends BaseRoute {

	private static final Logger logger = LoggerFactory.getLogger(AIMSFormRoute.class);
	@Override
	public void configure() throws Exception {
		logger.info("Loaded LTC QYTD Form Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 * 
		 * 
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/ltc-quaterly-ytd").routeId("ltc-quaterly-ytd-form")
				.log("CHEFS-ETL received a request for LTCQ Form extraction")//.bean(AIMSFormPayloadExtractor.class)
				.process(new LtcQuaterlyYtdProcessor()).to("direct:ltc-quaterly-ytd").end();

		from("direct:ltc-quaterly-ytd").process(new LtcQuaterlyYtdApiProcessor())
				// to the http uri
				.to("https://submit.digital.gov.bc.ca/app/api/v1/forms/256760e7-6e8b-44c4-8b63-51fb72c8c2cf/export?bridgeEndpoint=true&format=json&type=submissions")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new LtcQuaterlyYtdApiResponseProcessor()).end();

		// file conversion
		/*
		 * from("direct:ltc-quarterly-csv-processing").routeId("")
		 * .log("CHEFS ETL received a request to encrypt files") .process()
		 */
	}

}
