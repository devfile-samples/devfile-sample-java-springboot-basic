package ca.bc.gov.chefs.etl.forms.ltc.quarterly.processor;

import java.util.Map;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.processor.BaseApiProcessor;

public class LtcQuarterlyYtdApiProcessor extends BaseApiProcessor{

	public LtcQuarterlyYtdApiProcessor() {
		this.formPropertyName = Constants.LTC_YTD_PROPERTY;
	}
}
