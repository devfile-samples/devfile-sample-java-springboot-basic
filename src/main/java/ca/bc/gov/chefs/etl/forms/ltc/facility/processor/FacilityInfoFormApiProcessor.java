package ca.bc.gov.chefs.etl.forms.ltc.facility.processor;
import java.util.Map;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;


public class FacilityInfoFormApiProcessor extends BaseApiProcessor{
	
	public FacilityInfoFormApiProcessor() {
		this.formPropertyName = Constants.LTC_FACILITY_PROPERTY;
	}
}
