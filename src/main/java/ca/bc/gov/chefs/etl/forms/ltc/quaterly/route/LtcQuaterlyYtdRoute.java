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
		super.configure();
		logger.info("Loaded LTC QYTD Form Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 * 
		 * 
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/ltc-quaterly-ytd").routeId("ltc-quaterly-ytd-form")
				.log("CHEFS-ETL received a request for LTCQ Form extraction")//.bean(AIMSFormPayloadExtractor.class)
				.process(exchange -> sharedData.put("body", exchange.getIn().getBody(String.class)))
				.process(new LtcQuaterlyYtdProcessor()).to("direct:ltc-quaterly-ytd").end();

		from("direct:ltc-quaterly-ytd")
				// to the http uri
				.process(new LtcQuaterlyYtdApiProcessor(sharedData))
				.toD("${header.RequestUri}")
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
