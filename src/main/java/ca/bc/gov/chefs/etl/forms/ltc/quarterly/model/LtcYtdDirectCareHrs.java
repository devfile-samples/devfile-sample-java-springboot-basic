package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcYtdDirectCareHrs implements IModel{

	private String confirmationId;
	private String dirCareType; // nursing, allied, etc
	private String dirCareName;  // RN, OcP etc
	private String dirCareOtherValue;  // RN, OcP etc
	private String dirCareProdHrsRegYtd;
	private String dirCareProdHrsOtYtd;
	private String dirCareProdHrsOrientationYtd;
	private String dirCareProdHrsContractedYtd;
	private String dirCareProdHrsSubtotalYtd;
	private String dirCareProdHrsTotalYtd;
	private String dirCareNonProdHrsVacYtd;
	private String dirCareNonProdHrsSickYtd;
	private String dirCareNonProdHrsOtherYtd;
	private String dirCareNonProdHrsTotalYtd;
	private String dirCareTotalHrsPaidYtd;
	private String dirCareProdHrsAgencyStuffUtilYtd = Constants.DEFAULT_DECIMAL_VALUE;
	
	public String getDirCareProdHrsAgencyStuffUtilYtd() {
		return dirCareProdHrsAgencyStuffUtilYtd;
	}
	public void setDirCareProdHrsAgencyStuffUtilYtd(String dirCareProdHrsAgencyStuffUtilYtd) {
		this.dirCareProdHrsAgencyStuffUtilYtd = dirCareProdHrsAgencyStuffUtilYtd;
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
	public String getDirCareProdHrsRegYtd() {
		return dirCareProdHrsRegYtd;
	}
	public void setDirCareProdHrsRegYtd(String dirCareProdHrsRegYtd) {
		this.dirCareProdHrsRegYtd = StringUtils.defaultIfEmpty(dirCareProdHrsRegYtd, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getDirCareProdHrsOtYtd() {
		return dirCareProdHrsOtYtd;
	}
	public void setDirCareProdHrsOtYtd(String dirCareProdHrsOtYtd) {
		this.dirCareProdHrsOtYtd = StringUtils.defaultIfEmpty(dirCareProdHrsOtYtd, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getDirCareProdHrsOrientationYtd() {
		return dirCareProdHrsOrientationYtd;
	}
	public void setDirCareProdHrsOrientationYtd(String dirCareProdHrsOrientationYtd) {
		this.dirCareProdHrsOrientationYtd = dirCareProdHrsOrientationYtd;
	}
	public String getDirCareProdHrsContractedYtd() {
		return dirCareProdHrsContractedYtd;
	}
	public void setDirCareProdHrsContractedYtd(String dirCareProdHrsContractedYtd) {
		this.dirCareProdHrsContractedYtd = StringUtils.defaultIfEmpty(dirCareProdHrsContractedYtd, Constants.DEFAULT_DECIMAL_VALUE);
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
		elements.add(this.getDirCareOtherValue());	
		elements.add(this.getDirCareProdHrsRegYtd());
		elements.add(this.getDirCareProdHrsOtYtd());
		elements.add(this.getDirCareProdHrsOrientationYtd());
		elements.add(this.getDirCareProdHrsContractedYtd());
		elements.add(this.getDirCareProdHrsAgencyStuffUtilYtd());
		elements.add(this.getDirCareProdHrsSubtotalYtd());
		elements.add(this.getDirCareProdHrsTotalYtd());
		elements.add(this.getDirCareNonProdHrsVacYtd());
		elements.add(this.getDirCareNonProdHrsSickYtd());
		elements.add(this.getDirCareNonProdHrsOtherYtd());
		elements.add(this.getDirCareNonProdHrsTotalYtd());
		elements.add(this.getDirCareTotalHrsPaidYtd());	
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
}
