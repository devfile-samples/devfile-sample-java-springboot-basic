package ca.bc.gov.chefs.etl.forms.ltc.budget.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcBudgetDirectCareHrsSubTotals implements IModel{

	private String confirmationID;
	private String dirCareType;
	private String subTotalDirCareProdHrsRegularBudget;
	private String subTotalDirCareProdHrsOTBudget;
	private String subTotalDirCareProdHrsOrientationBudget;
	private String subTotalDirCareProdHrsSubtotalBudget;
	private String subTotalDirCareProdHrsContServBudget;
	private String subTotalDirCareProdHrsAgencyStaffUtil = Constants.DEFAULT_DECIMAL_VALUE;
	private String subTotalDirCareProdHrsTotalBudget;
	private String subTotalDirCareNonProdHrsVacBudget;
	private String subTotalDirCareNonProdHrsSickBudget;
	private String subTotalDirCareNonProdHrsOtherServBudget;
	private String subTotalDirCareNonProdHrsTotalBudget;
	private String subTotalDirCareTotalHrsPaidBudget;

	
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

	public String getSubTotalDirCareProdHrsRegularBudget() {
		return subTotalDirCareProdHrsRegularBudget;
	}

	public void setSubTotalDirCareProdHrsRegularBudget(String subTotalDirCareProdHrsRegularBudget) {
		this.subTotalDirCareProdHrsRegularBudget = subTotalDirCareProdHrsRegularBudget;
	}

	public String getSubTotalDirCareProdHrsOTBudget() {
		return subTotalDirCareProdHrsOTBudget;
	}

	public void setSubTotalDirCareProdHrsOTBudget(String subTotalDirCareProdHrsOTBudget) {
		this.subTotalDirCareProdHrsOTBudget = subTotalDirCareProdHrsOTBudget;
	}
	public String getSubTotalDirCareProdHrsOrientationBudget() {
		return subTotalDirCareProdHrsOrientationBudget;
	}

	public void setSubTotalDirCareProdHrsOrientationBudget(String subTotalDirCareProdHrsOrientationBudget) {
		this.subTotalDirCareProdHrsOrientationBudget = subTotalDirCareProdHrsOrientationBudget;
	}
	public String getSubTotalDirCareProdHrsSubtotalBudget() {
		return subTotalDirCareProdHrsSubtotalBudget;
	}

	public void setSubTotalDirCareProdHrsSubtotalBudget(String subTotalDirCareProdHrsSubtotalBudget) {
		this.subTotalDirCareProdHrsSubtotalBudget = subTotalDirCareProdHrsSubtotalBudget;
	}

	public String getSubTotalDirCareProdHrsContServBudget() {
		return subTotalDirCareProdHrsContServBudget;
	}

	public void setSubTotalDirCareProdHrsContServBudget(String subTotalDirCareProdHrsContServBudget) {
		this.subTotalDirCareProdHrsContServBudget = subTotalDirCareProdHrsContServBudget;
	}

	public String getSubTotalDirCareProdHrsTotalBudget() {
		return subTotalDirCareProdHrsTotalBudget;
	}

	public void setSubTotalDirCareProdHrsTotalBudget(String subTotalDirCareProdHrsTotalBudget) {
		this.subTotalDirCareProdHrsTotalBudget = subTotalDirCareProdHrsTotalBudget;
	}

	public String getSubTotalDirCareNonProdHrsVacBudget() {
		return subTotalDirCareNonProdHrsVacBudget;
	}

	public void setSubTotalDirCareNonProdHrsVacBudget(String subTotalDirCareNonProdHrsVacBudget) {
		this.subTotalDirCareNonProdHrsVacBudget = subTotalDirCareNonProdHrsVacBudget;
	}

	public String getSubTotalDirCareNonProdHrsSickBudget() {
		return subTotalDirCareNonProdHrsSickBudget;
	}

	public void setSubTotalDirCareNonProdHrsSickBudget(String subTotalDirCareNonProdHrsSickBudget) {
		this.subTotalDirCareNonProdHrsSickBudget = subTotalDirCareNonProdHrsSickBudget;
	}

	public String getSubTotalDirCareNonProdHrsOtherServBudget() {
		return subTotalDirCareNonProdHrsOtherServBudget;
	}

	public void setSubTotalDirCareNonProdHrsOtherServBudget(String subTotalDirCareNonProdHrsOtherServBudget) {
		this.subTotalDirCareNonProdHrsOtherServBudget = subTotalDirCareNonProdHrsOtherServBudget;
	}

	public String getSubTotalDirCareNonProdHrsTotalBudget() {
		return subTotalDirCareNonProdHrsTotalBudget;
	}

	public void setSubTotalDirCareNonProdHrsTotalBudget(String subTotalDirCareNonProdHrsTotalBudget) {
		this.subTotalDirCareNonProdHrsTotalBudget = subTotalDirCareNonProdHrsTotalBudget;
	}

	public String getSubTotalDirCareTotalHrsPaidBudget() {
		return subTotalDirCareTotalHrsPaidBudget;
	}

	public void setSubTotalDirCareTotalHrsPaidBudget(String subTotalDirCareTotalHrsPaidBudget) {
		this.subTotalDirCareTotalHrsPaidBudget = subTotalDirCareTotalHrsPaidBudget;
	}

	public String getSubTotalDirCareProdHrsAgencyStaffUtil() {
		return subTotalDirCareProdHrsAgencyStaffUtil;
	}

	public void setSubTotalDirCareProdHrsAgencyStaffUtil(String subTotalDirCareProdHrsAgencyStaffUtil) {
		this.subTotalDirCareProdHrsAgencyStaffUtil = subTotalDirCareProdHrsAgencyStaffUtil;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_BUDGET_DIRECT_CARE_HRS_SUBS;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationID());
		elements.add(this.getDirCareType());
		elements.add(this.getSubTotalDirCareProdHrsRegularBudget());
		elements.add(this.getSubTotalDirCareProdHrsOTBudget());
		elements.add(this.getSubTotalDirCareProdHrsOrientationBudget());
		elements.add(this.getSubTotalDirCareProdHrsSubtotalBudget());
		elements.add(this.getSubTotalDirCareProdHrsContServBudget());
		elements.add(this.getSubTotalDirCareProdHrsAgencyStaffUtil());
		elements.add(this.getSubTotalDirCareProdHrsTotalBudget());
		elements.add(this.getSubTotalDirCareNonProdHrsVacBudget());
		elements.add(this.getSubTotalDirCareNonProdHrsSickBudget());
		elements.add(this.getSubTotalDirCareNonProdHrsOtherServBudget());
		elements.add(this.getSubTotalDirCareNonProdHrsTotalBudget());
		elements.add(this.getSubTotalDirCareTotalHrsPaidBudget());
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

	
}
