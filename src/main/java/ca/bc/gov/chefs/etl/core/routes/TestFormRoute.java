package ca.bc.gov.chefs.etl.core.routes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.forms.testform.TestFormApiProcessor;
import ca.bc.gov.chefs.etl.forms.testform.TestFormApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.testform.TestFormProcessor;
import ca.bc.gov.chefs.etl.parser.TestFormPayloadExtractor;

public class TestFormRoute extends BaseRoute {

	private static final Logger logger = LoggerFactory.getLogger(TestFormRoute.class);
	@Override
	public void configure() throws Exception {
		logger.info("Loaded TestFormRoute");

		/**
		 * receive JSON payload, parse and set to make an API call
		 * 
		 * 
		 */
		// trigger 
		from("jetty:http://{{hostname}}:{{port}}/test").routeId("test-form")
				.log("CHEFS-ETL received a request for TestForm extraction").bean(TestFormPayloadExtractor.class)
				.process(new TestFormProcessor()).to("direct:test").end();

		from("direct:test").process(new TestFormApiProcessor())
				// to the http uri
				.to("https://submit.digital.gov.bc.ca/app/api/v1/forms/07623d33-9f49-425a-b7d2-d849b3e0af5c/export?bridgeEndpoint=true&format=json")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK")
				.convertBodyTo(String.class)
				.process(new TestFormApiResponseProcessor())
				.end();
		// database phase
		from("jetty:http://{{hostname}}:{{port}}/testpgp").routeId("test-formpgp")
		.log("CHEFS-ETL received a request for TestForm extraction").bean(TestFormPayloadExtractor.class)
		.process(new TestFormProcessor()).to("direct:test").end();
		
		
		// file conversion

	}

}