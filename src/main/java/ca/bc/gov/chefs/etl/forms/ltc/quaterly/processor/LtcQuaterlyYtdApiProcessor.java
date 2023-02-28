package ca.bc.gov.chefs.etl.forms.ltc.quaterly.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.util.AuthUtil;
import ca.bc.gov.chefs.etl.util.PropertiesUtil;

public class LtcQuaterlyYtdApiProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getIn().setHeader("CamelHttpMethod", "GET");
		exchange.getIn().setHeader("Content-Type", "application/json");
		exchange.getIn().setHeader("accept", "application/json");
		exchange.getIn().setHeader("Authorization", AuthUtil.getBasicAuth(PropertiesUtil.getValue(Constants.LTC_YTD_USERNAME), PropertiesUtil.getValue(Constants.LTC_YTD_PASSWORD)));		
	}

}
