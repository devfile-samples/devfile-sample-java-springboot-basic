package ca.bc.gov.chefs.etl.core.processor;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.ChefsRequestPayload;
import ca.bc.gov.chefs.etl.util.AuthUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;
import ca.bc.gov.chefs.etl.util.PropertiesUtil;

public class BaseApiProcessor implements Processor {
    
    protected Map<String,String> sharedData = new HashMap<String,String>();
    protected String formPropertyName;
	

	@Override
	public void process(Exchange exchange) throws Exception {
		ChefsRequestPayload payload =  JsonUtil.parseJsonString((String)sharedData.get("body"), ChefsRequestPayload.class);
		String FORM_USERNAME = PropertiesUtil.buildFormProperty(formPropertyName, payload.getHealthAuthority(), true);
		String FORM_PASSWORD = PropertiesUtil.buildFormProperty(formPropertyName, payload.getHealthAuthority(), false);
		String uri = PropertiesUtil.getValue(Constants.CHEFS_API_URL).formatted(PropertiesUtil.getValue(FORM_USERNAME), payload.getVersion(),payload.getStartDate(),payload.getEndDate(),
						payload.getUpdatedMinDate(), payload.getUpdatedMaxDate(), payload.isDraft(), payload.isDeleted(), payload.getStatus());

		exchange.getIn().setHeader("RequestUri", uri);
		exchange.getIn().setHeader("CamelHttpMethod", "GET");
		exchange.getIn().setHeader("Content-Type", "application/json");
		exchange.getIn().setHeader("accept", "application/json");
		exchange.getIn().setHeader("Authorization",
				AuthUtil.getBasicAuth(PropertiesUtil.getValue(FORM_USERNAME),
						PropertiesUtil.getValue(FORM_PASSWORD)));
		exchange.setProperty(Constants.IS_HEADER_ADDED, payload.isHeaderAdded());
	}
}
