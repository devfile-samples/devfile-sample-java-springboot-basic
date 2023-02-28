package ca.bc.gov.chefs.etl.forms.ltc.staffing;

import java.util.List;

import ca.bc.gov.chefs.etl.parser.IModel;

public class LTCStaffPlanPerf implements IModel{

	private String confirmationId;
	private String staffingPlanNum;
	private String perf;
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
	public String getPerf() {
		return perf;
	}
	public void setPerf(String perf) {
		this.perf = perf;
	}
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<String> getCsvElements() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<IModel> getObjects() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
