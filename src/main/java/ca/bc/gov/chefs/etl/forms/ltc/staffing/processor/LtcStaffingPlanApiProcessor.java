package ca.bc.gov.chefs.etl.forms.ltc.staffing.processor;

import java.util.Map;

import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class LtcStaffingPlanApiProcessor extends BaseApiProcessor {
	public LtcStaffingPlanApiProcessor(Map<String, String> sharedData, String formPropertyName) {
		this.sharedData = sharedData;
		this.formPropertyName = formPropertyName;
	}
}
