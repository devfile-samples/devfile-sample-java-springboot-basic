package ca.bc.gov.chefs.etl.forms.ltc.budget.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcBudgetDirectCareCost implements IModel{
	private String confirmationId;
	private String dirCareCostType;
	private String dirCareCostName;
	private String dirCareOtherValue = Constants.DEFAULT_NA_VALUE;
	private String dirCareCostProdHrsRegBudget;
	private String dirCareCostProdHrsOtBudget;
	private String dirCareCostProdHrsOrientationBudget;
	private String dirCareCostProdHrsContractedBudget;
	private String dirCareCostProdHrsSubtotalBudget;
	private String dirCareCostProdHrsTotalBudget;
	private String dirCareCostNonProdHrsVacBudget;
	private String dirCareCostNonProdHrsSickBudget;
	private String dirCareCostNonProdHrsOtherBudget;
	private String dirCareCostNonProdHrsTotalBudget;
	private String dirCareCostTotalHrsPaidBudget;
	private String dirCareCostHourlyRateStaffBudget;
	private String dirCareCostHourlyRateContractedBudget;
	private String dirCareCostProdHrsAgencyStaffUtil = Constants.DEFAULT_DECIMAL_VALUE;
	
	public String getDirCareCostProdHrsAgencyStaffUtil() {
		return dirCareCostProdHrsAgencyStaffUtil;
	}
	public void setDirCareCostProdHrsAgencyStaffUtil(String dirCareCostProdHrsAgencyStaffUtil) {
		this.dirCareCostProdHrsAgencyStaffUtil = dirCareCostProdHrsAgencyStaffUtil;
	}
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
	}
	public String getDirCareCostType() {
		return dirCareCostType;
	}
	public void setDirCareCostType(String dirCareCostType) {
		this.dirCareCostType = StringUtils.defaultIfEmpty(dirCareCostType, Constants.DEFAULT_STRING_VALUE);
	}
	public String getDirCareCostName() {
		return dirCareCostName;
	}
	public void setDirCareCostName(String dirCareCostName) {
		this.dirCareCostName = StringUtils.defaultIfEmpty(dirCareCostName, Constants.DEFAULT_STRING_VALUE);
	}
	public String getDirCareOtherValue() {
		return dirCareOtherValue;
	}
	public void setDirCareOtherValue(String dirCareOtherValue) {
		this.dirCareOtherValue = dirCareOtherValue;
	}
	public String getDirCareCostProdHrsRegBudget() {
		return StringUtils.isBlank(dirCareCostProdHrsRegBudget) ? "0" : dirCareCostProdHrsRegBudget;
	}
	public void setDirCareCostProdHrsRegBudget(String dirCareCostProdHrsRegBudget) {
		this.dirCareCostProdHrsRegBudget = StringUtils.defaultIfEmpty(dirCareCostProdHrsRegBudget, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getDirCareCostProdHrsOtBudget() {
		return StringUtils.isBlank(dirCareCostProdHrsOtBudget) ? "0" : dirCareCostProdHrsOtBudget;
	}
	public void setDirCareCostProdHrsOtBudget(String dirCareCostProdHrsOtBudget) {
		this.dirCareCostProdHrsOtBudget = StringUtils.defaultIfEmpty(dirCareCostProdHrsOtBudget, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getDirCareCostProdHrsOrientationBudget() {
		return dirCareCostProdHrsOrientationBudget;
	}
	public void setDirCareCostProdHrsOrientationBudget(String dirCareCostProdHrsOrientationBudget) {
		this.dirCareCostProdHrsOrientationBudget = StringUtils.defaultIfEmpty(dirCareCostProdHrsOrientationBudget, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getDirCareCostProdHrsContractedBudget() {
		return StringUtils.isBlank(dirCareCostProdHrsContractedBudget) ? "0" : dirCareCostProdHrsContractedBudget;
	}
	public void setDirCareCostProdHrsContractedBudget(String dirCareCostProdHrsContractedBudget) {
		this.dirCareCostProdHrsContractedBudget = StringUtils.defaultIfEmpty(dirCareCostProdHrsContractedBudget, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getDirCareCostNonProdHrsVacBudget() {
		return dirCareCostNonProdHrsVacBudget;
	}
	public void setDirCareCostNonProdHrsVacBudget(String dirCareCostNonProdHrsVacBudget) {
		this.dirCareCostNonProdHrsVacBudget = dirCareCostNonProdHrsVacBudget;
	}
	public String getDirCareCostNonProdHrsSickBudget() {
		return dirCareCostNonProdHrsSickBudget;
	}
	public void setDirCareCostNonProdHrsSickBudget(String dirCareCostNonProdHrsSickBudget) {
		this.dirCareCostNonProdHrsSickBudget = dirCareCostNonProdHrsSickBudget;
	}
	public String getDirCareCostNonProdHrsOtherBudget() {
		return dirCareCostNonProdHrsOtherBudget;
	}
	public void setDirCareCostNonProdHrsOtherBudget(String dirCareCostNonProdHrsOtherBudget) {
		this.dirCareCostNonProdHrsOtherBudget = dirCareCostNonProdHrsOtherBudget;
	}
	public String getDirCareCostProdHrsSubtotalBudget() {
		return dirCareCostProdHrsSubtotalBudget;
	}
	public void setDirCareCostProdHrsSubtotalBudget(String dirCareCostProdHrsSubtotalBudget) {
		this.dirCareCostProdHrsSubtotalBudget = dirCareCostProdHrsSubtotalBudget;
	}
	public String getDirCareCostProdHrsTotalBudget() {
		return dirCareCostProdHrsTotalBudget;
	}
	public void setDirCareCostProdHrsTotalBudget(String dirCareCostProdHrsTotalBudget) {
		this.dirCareCostProdHrsTotalBudget = dirCareCostProdHrsTotalBudget;
	}
	public String getDirCareCostNonProdHrsTotalBudget() {
		return dirCareCostNonProdHrsTotalBudget;
	}
	public void setDirCareCostNonProdHrsTotalBudget(String dirCareCostNonProdHrsTotalBudget) {
		this.dirCareCostNonProdHrsTotalBudget = dirCareCostNonProdHrsTotalBudget;
	}
	public String getDirCareCostTotalHrsPaidBudget() {
		return dirCareCostTotalHrsPaidBudget;
	}
	public void setDirCareCostTotalHrsPaidBudget(String dirCareCostTotalHrsPaidBudget) {
		this.dirCareCostTotalHrsPaidBudget = dirCareCostTotalHrsPaidBudget;
	}
	public String getDirCareCostHourlyRateStaffBudget() {
		return dirCareCostHourlyRateStaffBudget;
	}
	public void setDirCareCostHourlyRateStaffBudget(String dirCareCostHourlyRateStaffBudget) {
		this.dirCareCostHourlyRateStaffBudget = dirCareCostHourlyRateStaffBudget;
	}
	public String getDirCareCostHourlyRateContractedBudget() {
		return dirCareCostHourlyRateContractedBudget;
	}
	public void setDirCareCostHourlyRateContractedBudget(String dirCareCostHourlyRateContractedBudget) {
		this.dirCareCostHourlyRateContractedBudget = dirCareCostHourlyRateContractedBudget;
	}
	
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_BUDGET_DIRECT_CARE_COST;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getDirCareCostType());
		elements.add(this.getDirCareCostName());
		elements.add(this.getDirCareOtherValue());
		elements.add(this.getDirCareCostProdHrsRegBudget());
		elements.add(this.getDirCareCostProdHrsOtBudget());
		elements.add(this.getDirCareCostProdHrsOrientationBudget());
		elements.add(this.getDirCareCostProdHrsContractedBudget());
		elements.add(this.getDirCareCostProdHrsAgencyStaffUtil());
		elements.add(this.getDirCareCostProdHrsSubtotalBudget());
		elements.add(this.getDirCareCostProdHrsTotalBudget());
		elements.add(this.getDirCareCostNonProdHrsVacBudget());
		elements.add(this.getDirCareCostNonProdHrsSickBudget());
		elements.add(this.getDirCareCostNonProdHrsOtherBudget());
		elements.add(this.getDirCareCostNonProdHrsTotalBudget());
		elements.add(this.getDirCareCostTotalHrsPaidBudget());
		elements.add(this.getDirCareCostHourlyRateStaffBudget());
		elements.add(this.getDirCareCostHourlyRateContractedBudget());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
}
