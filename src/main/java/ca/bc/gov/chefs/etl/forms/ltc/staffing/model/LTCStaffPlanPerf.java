package ca.bc.gov.chefs.etl.forms.ltc.staffing.model;

import java.util.ArrayList;
import java.util.List;

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
		this.confirmationId = confirmationId;
	}
	public String getStaffingPlanNum() {
		return staffingPlanNum;
	}
	public void setStaffingPlanNum(String staffingPlanNum) {
		this.staffingPlanNum = staffingPlanNum;
	}
	public String getPerf_4_2() {
		return perf_4_2;
	}
	public void setPerf_4_2(String perf_4_2) {
		this.perf_4_2 = perf_4_2;
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
