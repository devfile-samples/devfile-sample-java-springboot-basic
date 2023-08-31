package ca.bc.gov.chefs.etl.forms.aims.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.aims.processor.AIMSFormApiProcessor;
import ca.bc.gov.chefs.etl.forms.aims.processor.AIMSFormApiResponseProcessor;

public class AIMSFormRoute extends BaseRoute {
	private static final Logger logger = LoggerFactory.getLogger(AIMSFormRoute.class);
	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded AIMS Form Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 * 
		 * 
		 */
	
		// trigger
		
		
		from("jetty:http://{{hostname}}:{{port}}/aims").routeId("aims-form")
				.log("CHEFS-ETL received a request for AIMS Form extraction")//.bean(AIMSFormPayloadExtractor.class)
				.to("direct:aims").end();

		from("direct:aims")// to the http uri
				.process(new AIMSFormApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new AIMSFormApiResponseProcessor()).end();
		// database phase

		// file conversion

	}

}
