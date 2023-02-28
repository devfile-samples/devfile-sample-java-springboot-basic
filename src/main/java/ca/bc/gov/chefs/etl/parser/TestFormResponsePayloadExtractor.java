package ca.bc.gov.chefs.etl.parser;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class TestFormResponsePayloadExtractor {
	private static final Logger logger = LoggerFactory.getLogger(TestFormPayloadExtractor.class);
	
	private TestFormResponsePayloadExtractor() {
	}


	@Handler
	public static void extractTestFormResponsePayload(Exchange exchange, String testFormPayload)
			throws ParseException {
		logger.info("");
		JSONParser jsonParser = new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE);
		JSONObject testFormExtracted = (JSONObject) jsonParser.parse(testFormPayload);
		exchange.getIn().setBody(testFormExtracted);
	}


}
