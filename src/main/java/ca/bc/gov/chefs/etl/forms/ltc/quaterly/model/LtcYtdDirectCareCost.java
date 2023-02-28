package ca.bc.gov.chefs.etl.forms.ltc.quaterly.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.parser.IModel;

public class LtcYtdDirectCareCost implements IModel{
	private String confirmationId;
	private String dirCareCostType;
	private String dirCareCostName;
	private String dirCareCostProdHrsRegYtd;
	private String dirCareCostProdHrsOtYtd;
	private String dirCareCostProdHrsContractedYtd;
	private String dirCareCostProdHrsSubtotalYtd;
	private String dirCareCostProdHrsTotalYtd;
	private String dirCareCostNonProdHrsVacYtd;
	private String dirCareCostNonProdHrsSickYtd;
	private String dirCareCostNonProdHrsOtherYtd;
	private String dirCareCostNonProdHrsTotalYtd;
	private String dirCareCostTotalHrsPaidYtd;
	private String dirCareCostHourlyRateStaffYtd;
	private String dirCareCostHourlyRateContractedYtd;

	private String dirCareCostYtdNotes;
	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}
	public String getDirCareCostType() {
		return dirCareCostType;
	}
	public void setDirCareCostType(String dirCareCostType) {
		this.dirCareCostType = dirCareCostType;
	}
	public String getDirCareCostName() {
		return dirCareCostName;
	}
	public void setDirCareCostName(String dirCareCostName) {
		this.dirCareCostName = dirCareCostName;
	}
	public String getDirCareCostProdHrsRegYtd() {
		return dirCareCostProdHrsRegYtd;
	}
	public void setDirCareCostProdHrsRegYtd(String dirCareCostProdHrsRegYtd) {
		this.dirCareCostProdHrsRegYtd = dirCareCostProdHrsRegYtd;
	}
	public String getDirCareCostProdHrsOtYtd() {
		return dirCareCostProdHrsOtYtd;
	}
	public void setDirCareCostProdHrsOtYtd(String dirCareCostProdHrsOtYtd) {
		this.dirCareCostProdHrsOtYtd = dirCareCostProdHrsOtYtd;
	}
	public String getDirCareCostProdHrsContractedYtd() {
		return dirCareCostProdHrsContractedYtd;
	}
	public void setDirCareCostProdHrsContractedYtd(String dirCareCostProdHrsContractedYtd) {
		this.dirCareCostProdHrsContractedYtd = dirCareCostProdHrsContractedYtd;
	}
	public String getDirCareCostNonProdHrsVacYtd() {
		return dirCareCostNonProdHrsVacYtd;
	}
	public void setDirCareCostNonProdHrsVacYtd(String dirCareCostNonProdHrsVacYtd) {
		this.dirCareCostNonProdHrsVacYtd = dirCareCostNonProdHrsVacYtd;
	}
	public String getDirCareCostNonProdHrsSickYtd() {
		return dirCareCostNonProdHrsSickYtd;
	}
	public void setDirCareCostNonProdHrsSickYtd(String dirCareCostNonProdHrsSickYtd) {
		this.dirCareCostNonProdHrsSickYtd = dirCareCostNonProdHrsSickYtd;
	}
	public String getDirCareCostNonProdHrsOtherYtd() {
		return dirCareCostNonProdHrsOtherYtd;
	}
	public void setDirCareCostNonProdHrsOtherYtd(String dirCareCostNonProdHrsOtherYtd) {
		this.dirCareCostNonProdHrsOtherYtd = dirCareCostNonProdHrsOtherYtd;
	}
	public String getDirCareCostYtdNotes() {
		return dirCareCostYtdNotes;
	}
	public void setDirCareCostYtdNotes(String dirCareCostYtdNotes) {
		this.dirCareCostYtdNotes = dirCareCostYtdNotes;
	}
	
	public String getDirCareCostProdHrsSubtotalYtd() {
		return dirCareCostProdHrsSubtotalYtd;
	}
	public void setDirCareCostProdHrsSubtotalYtd(String dirCareCostProdHrsSubtotalYtd) {
		this.dirCareCostProdHrsSubtotalYtd = dirCareCostProdHrsSubtotalYtd;
	}
	public String getDirCareCostProdHrsTotalYtd() {
		return dirCareCostProdHrsTotalYtd;
	}
	public void setDirCareCostProdHrsTotalYtd(String dirCareCostProdHrsTotalYtd) {
		this.dirCareCostProdHrsTotalYtd = dirCareCostProdHrsTotalYtd;
	}
	public String getDirCareCostNonProdHrsTotalYtd() {
		return dirCareCostNonProdHrsTotalYtd;
	}
	public void setDirCareCostNonProdHrsTotalYtd(String dirCareCostNonProdHrsTotalYtd) {
		this.dirCareCostNonProdHrsTotalYtd = dirCareCostNonProdHrsTotalYtd;
	}
	public String getDirCareCostTotalHrsPaidYtd() {
		return dirCareCostTotalHrsPaidYtd;
	}
	public void setDirCareCostTotalHrsPaidYtd(String dirCareCostTotalHrsPaidYtd) {
		this.dirCareCostTotalHrsPaidYtd = dirCareCostTotalHrsPaidYtd;
	}
	public String getDirCareCostHourlyRateStaffYtd() {
		return dirCareCostHourlyRateStaffYtd;
	}
	public void setDirCareCostHourlyRateStaffYtd(String dirCareCostHourlyRateStaffYtd) {
		this.dirCareCostHourlyRateStaffYtd = dirCareCostHourlyRateStaffYtd;
	}
	public String getDirCareCostHourlyRateContractedYtd() {
		return dirCareCostHourlyRateContractedYtd;
	}
	public void setDirCareCostHourlyRateContractedYtd(String dirCareCostHourlyRateContractedYtd) {
		this.dirCareCostHourlyRateContractedYtd = dirCareCostHourlyRateContractedYtd;
	}
	
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_YTD_DIRECT_CARE_COST;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getDirCareCostType());
		elements.add(this.getDirCareCostName());
		elements.add(this.getDirCareCostProdHrsRegYtd());
		elements.add(this.getDirCareCostProdHrsOtYtd());
		elements.add(this.getDirCareCostProdHrsContractedYtd());
		elements.add(this.getDirCareCostProdHrsSubtotalYtd());
		elements.add(this.getDirCareCostProdHrsTotalYtd());
		elements.add(this.getDirCareCostNonProdHrsVacYtd());
		elements.add(this.getDirCareCostNonProdHrsSickYtd());
		elements.add(this.getDirCareCostNonProdHrsOtherYtd());
		elements.add(this.getDirCareCostNonProdHrsTotalYtd());
		elements.add(this.getDirCareCostTotalHrsPaidYtd());
		elements.add(this.getDirCareCostHourlyRateStaffYtd());
		elements.add(this.getDirCareCostHourlyRateContractedYtd());
		elements.add(this.getDirCareCostYtdNotes());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
}
