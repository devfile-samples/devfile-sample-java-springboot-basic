package ca.bc.gov.chefs.etl.forms.ltc.facility.processor;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.ChefsRequestPayload;
import ca.bc.gov.chefs.etl.util.AuthUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;
import ca.bc.gov.chefs.etl.util.PropertiesUtil;

public class FacilityInfoFormApiProcessor implements Processor {

	private Map<String,String> sharedData = new HashMap<String,String>();
	
	
	public FacilityInfoFormApiProcessor(Map<String, String> sharedData) {
		this.sharedData=sharedData;
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		ChefsRequestPayload payload =  JsonUtil.parseJsonString((String)sharedData.get("body"), ChefsRequestPayload.class);
		String LTC_FACILITY_USERNAME = PropertiesUtil.buildFormProperty(Constants.LTC_FACILITY_PROPERTY, payload.getHealthAuthority(), true);
		String LTC_FACILITY_PASSWORD = PropertiesUtil.buildFormProperty(Constants.LTC_FACILITY_PROPERTY, payload.getHealthAuthority(), false);
		String uri = PropertiesUtil.getValue(Constants.CHEFS_API_URL).formatted(PropertiesUtil.getValue(LTC_FACILITY_USERNAME), payload.getVersion(),payload.getStartDate(),payload.getEndDate());

		exchange.getIn().setHeader("RequestUri", uri);
		exchange.getIn().setHeader("CamelHttpMethod", "GET");
		exchange.getIn().setHeader("Content-Type", "application/json");
		exchange.getIn().setHeader("accept", "application/json");
		exchange.getIn().setHeader("Authorization",
				AuthUtil.getBasicAuth(PropertiesUtil.getValue(LTC_FACILITY_USERNAME),
						PropertiesUtil.getValue(LTC_FACILITY_PASSWORD)));
		exchange.setProperty(Constants.IS_HEADER_ADDED, payload.isHeaderAdded());
	}

}
