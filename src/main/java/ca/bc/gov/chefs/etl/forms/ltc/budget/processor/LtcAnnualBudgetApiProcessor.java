package ca.bc.gov.chefs.etl.forms.ltc.budget.processor;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class LtcAnnualBudgetApiProcessor extends BaseApiProcessor{

	public LtcAnnualBudgetApiProcessor() {
		this.formPropertyName = Constants.LTC_ANNUAL_BUDGET_PROPERTY;
	}
}
