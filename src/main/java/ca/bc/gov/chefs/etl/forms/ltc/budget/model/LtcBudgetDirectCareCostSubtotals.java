package ca.bc.gov.chefs.etl.forms.ltc.budget.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcBudgetDirectCareCostSubtotals implements IModel{

	private String confirmationID;
	private String dirCareType;
	private String subTotalDirCareCostProdHrsRegularBudget;
	private String subTotalDirCareCostProdHrsOTBudget;
	private String subTotalDirCareCostProdHrsOrientationBudget;
	private String subTotalDirCareCostProdHrsSubtotalBudget;
	private String subTotalDirCareCostProdHrsContServBudget;
	private String subTotalDirCareCostProdHrsAgencyStaffUtil = Constants.DEFAULT_DECIMAL_VALUE;
	private String subTotalDirCareCostProdHrsTotalBudget;
	private String subTotalDirCareCostNonProdHrsVacBudget;
	private String subTotalDirCareCostNonProdHrsSickBudget;
	private String subTotalDirCareCostNonProdHrsOtherServBudget;
	private String subTotalDirCareCostNonProdHrsTotalBudget;
	private String subTotalDirCareCostTotalHrsPaidBudget;
	private String subTotalDirCareCostHourlyRateStaffBudget;
	private String subTotalDirCareCostHourlyRateContractedBudget;
	

	public String getConfirmationID() {
		return confirmationID;
	}

	public void setConfirmationID(String confirmationID) {
		this.confirmationID = StringUtils.defaultIfEmpty(confirmationID, Constants.DEFAULT_STRING_VALUE);
	}

	public String getDirCareType() {
		return dirCareType;
	}

	public void setDirCareType(String dirCareType) {
		this.dirCareType = StringUtils.defaultIfEmpty(dirCareType, Constants.DEFAULT_STRING_VALUE);
	}

	public String getSubTotalDirCareCostProdHrsRegularBudget() {
		return subTotalDirCareCostProdHrsRegularBudget;
	}

	public void setSubTotalDirCareCostProdHrsRegularBudget(String subTotalDirCareCostProdHrsRegularBudget) {
		this.subTotalDirCareCostProdHrsRegularBudget = subTotalDirCareCostProdHrsRegularBudget;
	}

	public String getSubTotalDirCareCostProdHrsOTBudget() {
		return subTotalDirCareCostProdHrsOTBudget;
	}

	public void setSubTotalDirCareCostProdHrsOTBudget(String subTotalDirCareCostProdHrsOTBudget) {
		this.subTotalDirCareCostProdHrsOTBudget = subTotalDirCareCostProdHrsOTBudget;
	}

	public String getSubTotalDirCareCostProdHrsOrientationBudget() {
		return subTotalDirCareCostProdHrsOrientationBudget;
	}

	public void setSubTotalDirCareCostProdHrsOrientationBudget(String subTotalDirCareCostProdHrsOrientationBudget) {
		this.subTotalDirCareCostProdHrsOrientationBudget = subTotalDirCareCostProdHrsOrientationBudget;
	}

	public String getSubTotalDirCareCostProdHrsSubtotalBudget() {
		return subTotalDirCareCostProdHrsSubtotalBudget;
	}

	public void setSubTotalDirCareCostProdHrsSubtotalBudget(String subTotalDirCareCostProdHrsSubtotalBudget) {
		this.subTotalDirCareCostProdHrsSubtotalBudget = subTotalDirCareCostProdHrsSubtotalBudget;
	}

	public String getSubTotalDirCareCostProdHrsContServBudget() {
		return subTotalDirCareCostProdHrsContServBudget;
	}

	public void setSubTotalDirCareCostProdHrsContServBudget(String subTotalDirCareCostProdHrsContServBudget) {
		this.subTotalDirCareCostProdHrsContServBudget = subTotalDirCareCostProdHrsContServBudget;
	}

	public String getSubTotalDirCareCostProdHrsAgencyStaffUtil() {
		return subTotalDirCareCostProdHrsAgencyStaffUtil;
	}

	public void setSubTotalDirCareCostProdHrsAgencyStaffUtil(String subTotalDirCareCostProdHrsAgencyStaffUtil) {
		this.subTotalDirCareCostProdHrsAgencyStaffUtil = subTotalDirCareCostProdHrsAgencyStaffUtil;
	}

	public String getSubTotalDirCareCostProdHrsTotalBudget() {
		return subTotalDirCareCostProdHrsTotalBudget;
	}

	public void setSubTotalDirCareCostProdHrsTotalBudget(String subTotalDirCareCostProdHrsTotalBudget) {
		this.subTotalDirCareCostProdHrsTotalBudget = subTotalDirCareCostProdHrsTotalBudget;
	}

	public String getSubTotalDirCareCostNonProdHrsVacBudget() {
		return subTotalDirCareCostNonProdHrsVacBudget;
	}

	public void setSubTotalDirCareCostNonProdHrsVacBudget(String subTotalDirCareCostNonProdHrsVacBudget) {
		this.subTotalDirCareCostNonProdHrsVacBudget = subTotalDirCareCostNonProdHrsVacBudget;
	}

	public String getSubTotalDirCareCostNonProdHrsSickBudget() {
		return subTotalDirCareCostNonProdHrsSickBudget;
	}

	public void setSubTotalDirCareCostNonProdHrsSickBudget(String subTotalDirCareCostNonProdHrsSickBudget) {
		this.subTotalDirCareCostNonProdHrsSickBudget = subTotalDirCareCostNonProdHrsSickBudget;
	}

	public String getSubTotalDirCareCostNonProdHrsOtherServBudget() {
		return subTotalDirCareCostNonProdHrsOtherServBudget;
	}

	public void setSubTotalDirCareCostNonProdHrsOtherServBudget(String subTotalDirCareCostNonProdHrsOtherServBudget) {
		this.subTotalDirCareCostNonProdHrsOtherServBudget = subTotalDirCareCostNonProdHrsOtherServBudget;
	}

	public String getSubTotalDirCareCostNonProdHrsTotalBudget() {
		return subTotalDirCareCostNonProdHrsTotalBudget;
	}

	public void setSubTotalDirCareCostNonProdHrsTotalBudget(String subTotalDirCareCostNonProdHrsTotalBudget) {
		this.subTotalDirCareCostNonProdHrsTotalBudget = subTotalDirCareCostNonProdHrsTotalBudget;
	}

	public String getSubTotalDirCareCostTotalHrsPaidBudget() {
		return subTotalDirCareCostTotalHrsPaidBudget;
	}

	public void setSubTotalDirCareCostTotalHrsPaidBudget(String subTotalDirCareCostTotalHrsPaidBudget) {
		this.subTotalDirCareCostTotalHrsPaidBudget = subTotalDirCareCostTotalHrsPaidBudget;
	}

	public String getSubTotalDirCareCostHourlyRateStaffBudget() {
		return subTotalDirCareCostHourlyRateStaffBudget;
	}

	public void setSubTotalDirCareCostHourlyRateStaffBudget(String subTotalDirCareCostHourlyRateStaffBudget) {
		this.subTotalDirCareCostHourlyRateStaffBudget = StringUtils.defaultIfEmpty(subTotalDirCareCostHourlyRateStaffBudget, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getSubTotalDirCareCostHourlyRateContractedBudget() {
		return subTotalDirCareCostHourlyRateContractedBudget;
	}

	public void setSubTotalDirCareCostHourlyRateContractedBudget(String subTotalDirCareCostHourlyRateContractedBudget) {
		this.subTotalDirCareCostHourlyRateContractedBudget = StringUtils.defaultIfEmpty(subTotalDirCareCostHourlyRateContractedBudget, Constants.DEFAULT_DECIMAL_VALUE);
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_BUDGET_DIRECT_CARE_COST_SUBS;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationID());
		elements.add(this.getDirCareType());
		elements.add(this.getSubTotalDirCareCostProdHrsRegularBudget());
		elements.add(this.getSubTotalDirCareCostProdHrsOTBudget());
		elements.add(this.getSubTotalDirCareCostProdHrsOrientationBudget());
		elements.add(this.getSubTotalDirCareCostProdHrsSubtotalBudget());
		elements.add(this.getSubTotalDirCareCostProdHrsContServBudget());
		elements.add(this.getSubTotalDirCareCostProdHrsAgencyStaffUtil());
		elements.add(this.getSubTotalDirCareCostProdHrsTotalBudget());
		elements.add(this.getSubTotalDirCareCostNonProdHrsVacBudget());
		elements.add(this.getSubTotalDirCareCostNonProdHrsSickBudget());
		elements.add(this.getSubTotalDirCareCostNonProdHrsOtherServBudget());
		elements.add(this.getSubTotalDirCareCostNonProdHrsTotalBudget());
		elements.add(this.getSubTotalDirCareCostTotalHrsPaidBudget());
		elements.add(this.getSubTotalDirCareCostHourlyRateStaffBudget());
		elements.add(this.getSubTotalDirCareCostHourlyRateContractedBudget());
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

}
