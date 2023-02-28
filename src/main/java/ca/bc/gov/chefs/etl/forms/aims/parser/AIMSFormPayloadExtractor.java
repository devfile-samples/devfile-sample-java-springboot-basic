package ca.bc.gov.chefs.etl.forms.aims.parser;

import java.util.Properties;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.parser.TestFormPayloadExtractor;
import ca.bc.gov.chefs.etl.util.PropertiesUtil;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class AIMSFormPayloadExtractor {
	private static final Logger logger = LoggerFactory.getLogger(TestFormPayloadExtractor.class);

	static Properties properties;

	private AIMSFormPayloadExtractor() {
	}

	@Handler
	public static void extractTestFormPayload(Exchange exchange, String testFormPayload) throws ParseException {

		try {
			properties = PropertiesUtil.loadProperties();
		} catch (Exception e) {

		}
		logger.info("Received payload data.. extracting now");
		logger.info("Received properties.. {}", properties.get("chefs.http.uri"));
		JSONParser jsonParser = new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE);
		JSONObject testFormExtracted = (JSONObject) jsonParser.parse(testFormPayload);
		exchange.getIn().setBody(testFormExtracted);
	}
}
