package ca.bc.gov.chefs.etl.forms.ltc.budget.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcBudgetDirectCareHrs implements IModel{

	private String confirmationId;
	private String dirCareType; // nursing, allied, etc
	private String dirCareName;  // RN, OcP etc
	private String dirCareOtherValue = Constants.DEFAULT_NA_VALUE;  // RN, OcP etc
	private String dirCareProdHrsRegBudget;
	private String dirCareProdHrsOtBudget;
	private String dirCareProdHrsOrientationBudget;
	private String dirCareProdHrsContractedBudget;
	private String dirCareProdHrsSubtotalBudget;
	private String dirCareProdHrsTotalBudget;
	private String dirCareNonProdHrsVacBudget;
	private String dirCareNonProdHrsSickBudget;
	private String dirCareNonProdHrsOtherBudget;
	private String dirCareNonProdHrsTotalBudget;
	private String dirCareTotalHrsPaidBudget;
	private String dirCareProdHrsAgencyStuffUtilBudget = Constants.DEFAULT_DECIMAL_VALUE;
	
	public String getDirCareProdHrsAgencyStuffUtilBudget() {
		return dirCareProdHrsAgencyStuffUtilBudget;
	}
	public void setDirCareProdHrsAgencyStuffUtilBudget(String dirCareProdHrsAgencyStuffUtilBudget) {
		this.dirCareProdHrsAgencyStuffUtilBudget = dirCareProdHrsAgencyStuffUtilBudget;
	}
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
	}
	public String getDirCareType() {
		return dirCareType;
	}
	public void setDirCareType(String dirCareType) {
		this.dirCareType = StringUtils.defaultIfEmpty(dirCareType, Constants.DEFAULT_STRING_VALUE);
	}
	public String getDirCareName() {
		return dirCareName;
	}
	public void setDirCareName(String dirCareName) {
		this.dirCareName = StringUtils.defaultIfEmpty(dirCareName, Constants.DEFAULT_STRING_VALUE);
	}
	public String getDirCareOtherValue() {
		return dirCareOtherValue;
	}
	public void setDirCareOtherValue(String dirCareOtherValue) {
		this.dirCareOtherValue = dirCareOtherValue;
	}
	public String getDirCareProdHrsRegBudget() {
		return dirCareProdHrsRegBudget;
	}
	public void setDirCareProdHrsRegBudget(String dirCareProdHrsRegBudget) {
		this.dirCareProdHrsRegBudget = StringUtils.defaultIfEmpty(dirCareProdHrsRegBudget, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getDirCareProdHrsOtBudget() {
		return dirCareProdHrsOtBudget;
	}
	public void setDirCareProdHrsOtBudget(String dirCareProdHrsOtBudget) {
		this.dirCareProdHrsOtBudget = StringUtils.defaultIfEmpty(dirCareProdHrsOtBudget, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getDirCareProdHrsOrientationBudget() {
		return dirCareProdHrsOrientationBudget;
	}
	public void setDirCareProdHrsOrientationBudget(String dirCareProdHrsOrientationBudget) {
		this.dirCareProdHrsOrientationBudget = StringUtils.defaultIfEmpty(dirCareProdHrsOrientationBudget, Constants.DEFAULT_STRING_VALUE);
	}
	public String getDirCareProdHrsContractedBudget() {
		return dirCareProdHrsContractedBudget;
	}
	public void setDirCareProdHrsContractedBudget(String dirCareProdHrsContractedBudget) {
		this.dirCareProdHrsContractedBudget = StringUtils.defaultIfEmpty(dirCareProdHrsContractedBudget, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getDirCareNonProdHrsVacBudget() {
		return dirCareNonProdHrsVacBudget;
	}
	public void setDirCareNonProdHrsVacBudget(String dirCareNonProdHrsVacBudget) {
		this.dirCareNonProdHrsVacBudget = dirCareNonProdHrsVacBudget;
	}
	public String getDirCareNonProdHrsSickBudget() {
		return dirCareNonProdHrsSickBudget;
	}
	public void setDirCareNonProdHrsSickBudget(String dirCareNonProdHrsSickBudget) {
		this.dirCareNonProdHrsSickBudget = dirCareNonProdHrsSickBudget;
	}
	public String getDirCareNonProdHrsOtherBudget() {
		return dirCareNonProdHrsOtherBudget;
	}
	public void setDirCareNonProdHrsOtherBudget(String dirCareNonProdHrsOtherBudget) {
		this.dirCareNonProdHrsOtherBudget = dirCareNonProdHrsOtherBudget;
	}	
	public String getDirCareProdHrsSubtotalBudget() {
		return dirCareProdHrsSubtotalBudget;
	}
	public void setDirCareProdHrsSubtotalBudget(String dirCareProdHrsSubtotalBudget) {
		this.dirCareProdHrsSubtotalBudget = dirCareProdHrsSubtotalBudget;
	}
	public String getDirCareProdHrsTotalBudget() {
		return dirCareProdHrsTotalBudget;
	}
	public void setDirCareProdHrsTotalBudget(String dirCareProdHrsTotalBudget) {
		this.dirCareProdHrsTotalBudget = dirCareProdHrsTotalBudget;
	}
	public String getDirCareNonProdHrsTotalBudget() {
		return dirCareNonProdHrsTotalBudget;
	}
	public void setDirCareNonProdHrsTotalBudget(String dirCareNonProdHrsTotalBudget) {
		this.dirCareNonProdHrsTotalBudget = dirCareNonProdHrsTotalBudget;
	}
	public String getDirCareTotalHrsPaidBudget() {
		return dirCareTotalHrsPaidBudget;
	}
	public void setDirCareTotalHrsPaidBudget(String dirCareTotalHrsPaidBudget) {
		this.dirCareTotalHrsPaidBudget = dirCareTotalHrsPaidBudget;
	}
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_BUDGET_DIRECT_CARE_HRS;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getDirCareType());
		elements.add(this.getDirCareName());
		elements.add(this.getDirCareOtherValue());	
		elements.add(this.getDirCareProdHrsRegBudget());
		elements.add(this.getDirCareProdHrsOtBudget());
		elements.add(this.getDirCareProdHrsOrientationBudget());
		elements.add(this.getDirCareProdHrsContractedBudget());
		elements.add(this.getDirCareProdHrsAgencyStuffUtilBudget());
		elements.add(this.getDirCareProdHrsSubtotalBudget());
		elements.add(this.getDirCareProdHrsTotalBudget());
		elements.add(this.getDirCareNonProdHrsVacBudget());
		elements.add(this.getDirCareNonProdHrsSickBudget());
		elements.add(this.getDirCareNonProdHrsOtherBudget());
		elements.add(this.getDirCareNonProdHrsTotalBudget());
		elements.add(this.getDirCareTotalHrsPaidBudget());	
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
}
