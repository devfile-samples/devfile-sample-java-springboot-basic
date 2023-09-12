package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcYtdDirectCareCostSubtotals implements IModel{

	private String confirmationID;
	private String dirCareType;
	private String subTotalDirCareCostProdHrsRegularYTD;
	private String subTotalDirCareCostProdHrsOTYTD;
	private String subTotalDirCareCostProdHrsOrientationYTD;
	private String subTotalDirCareCostProdHrsSubtotalYTD;
	private String subTotalDirCareCostProdHrsContServYTD;
	private String subTotalDirCareCostProdHrsAgencyStaffUtil = Constants.DEFAULT_DECIMAL_VALUE;
	private String subTotalDirCareCostProdHrsTotalYTD;
	private String subTotalDirCareCostNonProdHrsVacYTD;
	private String subTotalDirCareCostNonProdHrsSickYTD;
	private String subTotalDirCareCostNonProdHrsOtherServYTD;
	private String subTotalDirCareCostNonProdHrsTotalYTD;
	private String subTotalDirCareCostTotalHrsPaidYTD;
	private String subTotalDirCareCostHourlyRateStaffYTD;
	private String subTotalDirCareCostHourlyRateContractedYTD;
	

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

	public String getSubTotalDirCareCostProdHrsRegularYTD() {
		return subTotalDirCareCostProdHrsRegularYTD;
	}

	public void setSubTotalDirCareCostProdHrsRegularYTD(String subTotalDirCareCostProdHrsRegularYTD) {
		this.subTotalDirCareCostProdHrsRegularYTD = subTotalDirCareCostProdHrsRegularYTD;
	}

	public String getSubTotalDirCareCostProdHrsOTYTD() {
		return subTotalDirCareCostProdHrsOTYTD;
	}

	public void setSubTotalDirCareCostProdHrsOTYTD(String subTotalDirCareCostProdHrsOTYTD) {
		this.subTotalDirCareCostProdHrsOTYTD = subTotalDirCareCostProdHrsOTYTD;
	}

	public String getSubTotalDirCareCostProdHrsOrientationYTD() {
		return subTotalDirCareCostProdHrsOrientationYTD;
	}

	public void setSubTotalDirCareCostProdHrsOrientationYTD(String subTotalDirCareCostProdHrsOrientationYTD) {
		this.subTotalDirCareCostProdHrsOrientationYTD = subTotalDirCareCostProdHrsOrientationYTD;
	}

	public String getSubTotalDirCareCostProdHrsSubtotalYTD() {
		return subTotalDirCareCostProdHrsSubtotalYTD;
	}

	public void setSubTotalDirCareCostProdHrsSubtotalYTD(String subTotalDirCareCostProdHrsSubtotalYTD) {
		this.subTotalDirCareCostProdHrsSubtotalYTD = subTotalDirCareCostProdHrsSubtotalYTD;
	}

	public String getSubTotalDirCareCostProdHrsContServYTD() {
		return subTotalDirCareCostProdHrsContServYTD;
	}

	public void setSubTotalDirCareCostProdHrsContServYTD(String subTotalDirCareCostProdHrsContServYTD) {
		this.subTotalDirCareCostProdHrsContServYTD = subTotalDirCareCostProdHrsContServYTD;
	}

	public String getSubTotalDirCareCostProdHrsAgencyStaffUtil() {
		return subTotalDirCareCostProdHrsAgencyStaffUtil;
	}

	public void setSubTotalDirCareCostProdHrsAgencyStaffUtil(String subTotalDirCareCostProdHrsAgencyStaffUtil) {
		this.subTotalDirCareCostProdHrsAgencyStaffUtil = subTotalDirCareCostProdHrsAgencyStaffUtil;
	}

	public String getSubTotalDirCareCostProdHrsTotalYTD() {
		return subTotalDirCareCostProdHrsTotalYTD;
	}

	public void setSubTotalDirCareCostProdHrsTotalYTD(String subTotalDirCareCostProdHrsTotalYTD) {
		this.subTotalDirCareCostProdHrsTotalYTD = subTotalDirCareCostProdHrsTotalYTD;
	}

	public String getSubTotalDirCareCostNonProdHrsVacYTD() {
		return subTotalDirCareCostNonProdHrsVacYTD;
	}

	public void setSubTotalDirCareCostNonProdHrsVacYTD(String subTotalDirCareCostNonProdHrsVacYTD) {
		this.subTotalDirCareCostNonProdHrsVacYTD = subTotalDirCareCostNonProdHrsVacYTD;
	}

	public String getSubTotalDirCareCostNonProdHrsSickYTD() {
		return subTotalDirCareCostNonProdHrsSickYTD;
	}

	public void setSubTotalDirCareCostNonProdHrsSickYTD(String subTotalDirCareCostNonProdHrsSickYTD) {
		this.subTotalDirCareCostNonProdHrsSickYTD = subTotalDirCareCostNonProdHrsSickYTD;
	}

	public String getSubTotalDirCareCostNonProdHrsOtherServYTD() {
		return subTotalDirCareCostNonProdHrsOtherServYTD;
	}

	public void setSubTotalDirCareCostNonProdHrsOtherServYTD(String subTotalDirCareCostNonProdHrsOtherServYTD) {
		this.subTotalDirCareCostNonProdHrsOtherServYTD = subTotalDirCareCostNonProdHrsOtherServYTD;
	}

	public String getSubTotalDirCareCostNonProdHrsTotalYTD() {
		return subTotalDirCareCostNonProdHrsTotalYTD;
	}

	public void setSubTotalDirCareCostNonProdHrsTotalYTD(String subTotalDirCareCostNonProdHrsTotalYTD) {
		this.subTotalDirCareCostNonProdHrsTotalYTD = subTotalDirCareCostNonProdHrsTotalYTD;
	}

	public String getSubTotalDirCareCostTotalHrsPaidYTD() {
		return subTotalDirCareCostTotalHrsPaidYTD;
	}

	public void setSubTotalDirCareCostTotalHrsPaidYTD(String subTotalDirCareCostTotalHrsPaidYTD) {
		this.subTotalDirCareCostTotalHrsPaidYTD = subTotalDirCareCostTotalHrsPaidYTD;
	}

	public String getSubTotalDirCareCostHourlyRateStaffYTD() {
		return subTotalDirCareCostHourlyRateStaffYTD;
	}

	public void setSubTotalDirCareCostHourlyRateStaffYTD(String subTotalDirCareCostHourlyRateStaffYTD) {
		this.subTotalDirCareCostHourlyRateStaffYTD = StringUtils.defaultIfEmpty(subTotalDirCareCostHourlyRateStaffYTD, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getSubTotalDirCareCostHourlyRateContractedYTD() {
		return subTotalDirCareCostHourlyRateContractedYTD;
	}

	public void setSubTotalDirCareCostHourlyRateContractedYTD(String subTotalDirCareCostHourlyRateContractedYTD) {
		this.subTotalDirCareCostHourlyRateContractedYTD = StringUtils.defaultIfEmpty(subTotalDirCareCostHourlyRateContractedYTD, Constants.DEFAULT_DECIMAL_VALUE);
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_YTD_DIRECT_CARE_COST_SUBS;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationID());
		elements.add(this.getDirCareType());
		elements.add(this.getSubTotalDirCareCostProdHrsRegularYTD());
		elements.add(this.getSubTotalDirCareCostProdHrsOTYTD());
		elements.add(this.getSubTotalDirCareCostProdHrsOrientationYTD());
		elements.add(this.getSubTotalDirCareCostProdHrsSubtotalYTD());
		elements.add(this.getSubTotalDirCareCostProdHrsContServYTD());
		elements.add(this.getSubTotalDirCareCostProdHrsAgencyStaffUtil());
		elements.add(this.getSubTotalDirCareCostProdHrsTotalYTD());
		elements.add(this.getSubTotalDirCareCostNonProdHrsVacYTD());
		elements.add(this.getSubTotalDirCareCostNonProdHrsSickYTD());
		elements.add(this.getSubTotalDirCareCostNonProdHrsOtherServYTD());
		elements.add(this.getSubTotalDirCareCostNonProdHrsTotalYTD());
		elements.add(this.getSubTotalDirCareCostTotalHrsPaidYTD());
		elements.add(this.getSubTotalDirCareCostHourlyRateStaffYTD());
		elements.add(this.getSubTotalDirCareCostHourlyRateContractedYTD());
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

}
