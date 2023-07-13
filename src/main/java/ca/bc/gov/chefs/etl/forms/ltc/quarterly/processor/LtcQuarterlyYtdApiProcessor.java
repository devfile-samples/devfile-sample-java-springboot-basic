package ca.bc.gov.chefs.etl.forms.ltc.quarterly.processor;

import java.util.Map;

import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class LtcQuarterlyYtdApiProcessor extends BaseApiProcessor{

	public LtcQuarterlyYtdApiProcessor(Map<String, String> sharedData, String formPropertyName) {
		this.sharedData = sharedData;
		this.formPropertyName = formPropertyName;
	}
}
