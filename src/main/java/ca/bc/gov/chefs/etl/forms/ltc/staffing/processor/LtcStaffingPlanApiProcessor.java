package ca.bc.gov.chefs.etl.forms.ltc.staffing.processor;

import java.util.Map;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class LtcStaffingPlanApiProcessor extends BaseApiProcessor {
	public LtcStaffingPlanApiProcessor() {
		this.formPropertyName = Constants.LTC_STAFFING_PLAN_PROPERTY;
	}
}
