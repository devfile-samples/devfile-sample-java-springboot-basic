package ca.bc.gov.chefs.etl.forms.ltc.facility.processor;
import java.util.Map;

import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;


public class FacilityInfoFormApiProcessor extends BaseApiProcessor{
	
	public FacilityInfoFormApiProcessor(Map<String, String> sharedData, String formPropertyName) {
		this.sharedData=sharedData;
		this.formPropertyName = formPropertyName;
	}
}
