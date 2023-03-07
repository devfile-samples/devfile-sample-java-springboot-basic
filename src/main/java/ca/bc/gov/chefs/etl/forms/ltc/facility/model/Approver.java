package ca.bc.gov.chefs.etl.forms.ltc.facility.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.parser.IModel;

public class Approver implements IModel{
	private String confirmationID;
	private String approverNum;
	private String approverContactName;
	private String approverContactPosition;
	private String approverContactPhone;
	private String approverContactEmail;
	public String getConfirmationID() {
		return confirmationID;
	}
	public void setConfirmationID(String confirmationID) {
		this.confirmationID = confirmationID;
	}
	public String getApproverNum() {
		return approverNum;
	}
	public void setApproverNum(String approverNum) {
		this.approverNum = approverNum;
	}
	public String getApproverContactName() {
		return approverContactName;
	}
	public void setApproverContactName(String approverContactName) {
		this.approverContactName = approverContactName;
	}
	public String getApproverContactPosition() {
		return approverContactPosition;
	}
	public void setApproverContactPosition(String approverContactPosition) {
		this.approverContactPosition = approverContactPosition;
	}
	public String getApproverContactPhone() {
		return approverContactPhone;
	}
	public void setApproverContactPhone(String approverContactPhone) {
		this.approverContactPhone = approverContactPhone;
	}
	public String getApproverContactEmail() {
		return approverContactEmail;
	}
	public void setApproverContactEmail(String approverContactEmail) {
		this.approverContactEmail = approverContactEmail;
	}
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_FACILITY_APPROVER;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationID());
		elements.add(this.getApproverNum());
		elements.add(this.getApproverContactName());
		elements.add(this.getApproverContactPosition());
		elements.add(this.getApproverContactPhone());
		elements.add(this.getApproverContactEmail());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
	
}
