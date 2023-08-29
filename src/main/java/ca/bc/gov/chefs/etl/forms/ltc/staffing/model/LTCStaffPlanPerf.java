package ca.bc.gov.chefs.etl.forms.ltc.staffing.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LTCStaffPlanPerf implements IModel{

	private String confirmationId;
	private String staffingPlanNum;
	private String perf_4_2;

	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
	}
	public String getStaffingPlanNum() {
		return staffingPlanNum;
	}
	public void setStaffingPlanNum(String staffingPlanNum) {
		this.staffingPlanNum = StringUtils.defaultIfEmpty(staffingPlanNum, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getPerf_4_2() {
		return perf_4_2;
	}
	public void setPerf_4_2(String perf_4_2) {
		this.perf_4_2 = StringUtils.defaultIfEmpty(perf_4_2, Constants.DEFAULT_STRING_VALUE);
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_STAFF_PLAN_PERF_4_2;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.confirmationId);
		elements.add(this.staffingPlanNum);
		elements.add(this.perf_4_2);
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
}
