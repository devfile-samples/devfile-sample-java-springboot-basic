package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcYtdCompSal implements IModel{

	private String confirmationId;
	private String compSalType;
	private String compSalName;
	private String compSalStaffYtd;
	private String compSalContractServicesYtd;
	private String compSalTotalCostYtd;
	private String compSalOtherName = Constants.DEFAULT_STRING_VALUE;

	public String getCompSalTotalCostYtd() {
		return compSalTotalCostYtd;
	}
	public void setCompSalTotalCostYtd(String compSalTotalCostYtd) {
		this.compSalTotalCostYtd = compSalTotalCostYtd;
	}
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
	}
	public String getCompSalType() {
		return compSalType;
	}
	public void setCompSalType(String compSalType) {
		this.compSalType = StringUtils.defaultIfEmpty(compSalType, Constants.DEFAULT_STRING_VALUE);
	}
	public String getCompSalName() {
		return compSalName;
	}
	public void setCompSalName(String compSalName) {
		this.compSalName = StringUtils.defaultIfEmpty(compSalName, Constants.DEFAULT_STRING_VALUE);
	}
	public String getCompSalStaffYtd() {
		return compSalStaffYtd;
	}
	public void setCompSalStaffYtd(String compSalStaffYtd) {
		this.compSalStaffYtd = StringUtils.defaultIfEmpty(compSalStaffYtd, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getCompSalContractServicesYtd() {
		return compSalContractServicesYtd;
	}
	public void setCompSalContractServicesYtd(String compSalContractServicesYtd) {
		this.compSalContractServicesYtd = StringUtils.defaultIfEmpty(compSalContractServicesYtd, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getCompSalOtherName() {
		return compSalOtherName;
	}
	public void setCompSalOtherName(String compSalOtherName) {
		this.compSalOtherName = compSalOtherName;
	}
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_YTD_COMP_SAL;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getCompSalType());
		elements.add(this.getCompSalName());
		elements.add(this.getCompSalStaffYtd());
		elements.add(this.getCompSalContractServicesYtd());
		elements.add(this.getCompSalTotalCostYtd());
		elements.add(this.getCompSalOtherName());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
}
