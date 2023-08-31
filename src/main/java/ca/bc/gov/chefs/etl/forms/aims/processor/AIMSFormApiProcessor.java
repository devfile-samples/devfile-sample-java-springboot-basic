package ca.bc.gov.chefs.etl.forms.aims.processor;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.ChefsRequestPayload;
import ca.bc.gov.chefs.etl.util.AuthUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;
import ca.bc.gov.chefs.etl.util.PropertiesUtil;

public class AIMSFormApiProcessor implements Processor {

///  https://submit.digital.gov.bc.ca/app/api/v1/forms/%s/export?format=json&bridgeEndpoint=true&version=%s&type=submissions&minDate=%s&maxDate=%s
	@Override
	public void process(Exchange exchange) throws Exception {
		ChefsRequestPayload payload =  JsonUtil.parseJsonString(exchange.getIn().getBody(String.class), ChefsRequestPayload.class) ;
		String uri = PropertiesUtil.getValue(Constants.CHEFS_API_URL).formatted(PropertiesUtil.getValue(Constants.AIMS_USERNAME), payload.getVersion(),payload.getStartDate(),payload.getEndDate());
		exchange.getIn().setHeader("RequestUri", uri);
		exchange.getIn().setHeader("CamelHttpMethod", "GET");
		exchange.getIn().setHeader("Content-Type", "application/json");
		exchange.getIn().setHeader("accept", "application/json");
		exchange.getIn().setHeader("Authorization", AuthUtil.getBasicAuth(PropertiesUtil.getValue(Constants.AIMS_USERNAME), PropertiesUtil.getValue(Constants.AIMS_PASSWORD)));
		exchange.setProperty(Constants.IS_HEADER_ADDED, payload.isHeaderAdded());		
	}

}
