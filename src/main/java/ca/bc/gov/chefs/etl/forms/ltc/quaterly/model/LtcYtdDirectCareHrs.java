package ca.bc.gov.chefs.etl.forms.ltc.quaterly.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.parser.IModel;

public class LtcYtdDirectCareHrs implements IModel{

	private String confirmationId;
	private String dirCareType; // nursing, allied, etc
	private String dirCareName;  // RN, OcP etc
	private String dirCareProdHrsRegYtd;
	private String dirCareProdHrsOtYtd;
	private String dirCareProdHrsContractedYtd;
	private String dirCareProdHrsSubtotalYtd;
	private String dirCareProdHrsTotalYtd;
	private String dirCareNonProdHrsVacYtd;
	private String dirCareNonProdHrsSickYtd;
	private String dirCareNonProdHrsOtherYtd;
	private String dirCareNonProdHrsTotalYtd;
	private String dirCareTotalHrsPaidYtd;
	private String dirCareYtdNotes;
	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}
	public String getDirCareType() {
		return dirCareType;
	}
	public void setDirCareType(String dirCareType) {
		this.dirCareType = dirCareType;
	}
	public String getDirCareName() {
		return dirCareName;
	}
	public void setDirCareName(String dirCareName) {
		this.dirCareName = dirCareName;
	}
	public String getDirCareProdHrsRegYtd() {
		return dirCareProdHrsRegYtd;
	}
	public void setDirCareProdHrsRegYtd(String dirCareProdHrsRegYtd) {
		this.dirCareProdHrsRegYtd = dirCareProdHrsRegYtd;
	}
	public String getDirCareProdHrsOtYtd() {
		return dirCareProdHrsOtYtd;
	}
	public void setDirCareProdHrsOtYtd(String dirCareProdHrsOtYtd) {
		this.dirCareProdHrsOtYtd = dirCareProdHrsOtYtd;
	}
	public String getDirCareProdHrsContractedYtd() {
		return dirCareProdHrsContractedYtd;
	}
	public void setDirCareProdHrsContractedYtd(String dirCareProdHrsContractedYtd) {
		this.dirCareProdHrsContractedYtd = dirCareProdHrsContractedYtd;
	}
	public String getDirCareNonProdHrsVacYtd() {
		return dirCareNonProdHrsVacYtd;
	}
	public void setDirCareNonProdHrsVacYtd(String dirCareNonProdHrsVacYtd) {
		this.dirCareNonProdHrsVacYtd = dirCareNonProdHrsVacYtd;
	}
	public String getDirCareNonProdHrsSickYtd() {
		return dirCareNonProdHrsSickYtd;
	}
	public void setDirCareNonProdHrsSickYtd(String dirCareNonProdHrsSickYtd) {
		this.dirCareNonProdHrsSickYtd = dirCareNonProdHrsSickYtd;
	}
	public String getDirCareNonProdHrsOtherYtd() {
		return dirCareNonProdHrsOtherYtd;
	}
	public void setDirCareNonProdHrsOtherYtd(String dirCareNonProdHrsOtherYtd) {
		this.dirCareNonProdHrsOtherYtd = dirCareNonProdHrsOtherYtd;
	}
	public String getDirCareYtdNotes() {
		return dirCareYtdNotes;
	}
	public void setDirCareYtdNotes(String dirCareYtdNotes) {
		this.dirCareYtdNotes = dirCareYtdNotes;
	}
	
	public String getDirCareProdHrsSubtotalYtd() {
		return dirCareProdHrsSubtotalYtd;
	}
	public void setDirCareProdHrsSubtotalYtd(String dirCareProdHrsSubtotalYtd) {
		this.dirCareProdHrsSubtotalYtd = dirCareProdHrsSubtotalYtd;
	}
	public String getDirCareProdHrsTotalYtd() {
		return dirCareProdHrsTotalYtd;
	}
	public void setDirCareProdHrsTotalYtd(String dirCareProdHrsTotalYtd) {
		this.dirCareProdHrsTotalYtd = dirCareProdHrsTotalYtd;
	}
	public String getDirCareNonProdHrsTotalYtd() {
		return dirCareNonProdHrsTotalYtd;
	}
	public void setDirCareNonProdHrsTotalYtd(String dirCareNonProdHrsTotalYtd) {
		this.dirCareNonProdHrsTotalYtd = dirCareNonProdHrsTotalYtd;
	}
	public String getDirCareTotalHrsPaidYtd() {
		return dirCareTotalHrsPaidYtd;
	}
	public void setDirCareTotalHrsPaidYtd(String dirCareTotalHrsPaidYtd) {
		this.dirCareTotalHrsPaidYtd = dirCareTotalHrsPaidYtd;
	}
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_YTD_DIRECT_CARE_HRS;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getDirCareType());
		elements.add(this.getDirCareName());
		elements.add(this.getDirCareProdHrsRegYtd());
		elements.add(this.getDirCareProdHrsOtYtd());
		elements.add(this.getDirCareProdHrsContractedYtd());
		elements.add(this.getDirCareProdHrsSubtotalYtd());
		elements.add(this.getDirCareProdHrsTotalYtd());
		elements.add(this.getDirCareNonProdHrsVacYtd());
		elements.add(this.getDirCareNonProdHrsSickYtd());
		elements.add(this.getDirCareNonProdHrsOtherYtd());
		elements.add(this.getDirCareNonProdHrsTotalYtd());
		elements.add(this.getDirCareTotalHrsPaidYtd());
		elements.add(this.getDirCareYtdNotes());		
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
	
	
}
