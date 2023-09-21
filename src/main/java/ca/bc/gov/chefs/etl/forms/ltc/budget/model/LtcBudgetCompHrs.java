package ca.bc.gov.chefs.etl.forms.ltc.budget.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcBudgetCompHrs implements IModel {
	
	private String confirmationId;
	private String compHrsType;
	private String compHrsName;
	//private String compHrsPerPayrollBudget;
	private String compHrsStaffBudget;
	private String compHrsContractServicesBudget;
	private String compTotalWorkedHrsBudget;
	private String compHrsOtherName = Constants.DEFAULT_NA_VALUE;
	
	public String getCompHrsOtherName() {
		return compHrsOtherName;
	}
	public void setCompHrsOtherName(String compHrsOtherName) {
		this.compHrsOtherName = compHrsOtherName;
	}
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
	}
	public String getCompHrsType() {
		return compHrsType;
	}
	public void setCompHrsType(String compHrsType) {
		this.compHrsType = StringUtils.defaultIfEmpty(compHrsType, Constants.DEFAULT_STRING_VALUE);
	}
	public String getCompHrsName() {
		return compHrsName;
	}
	public void setCompHrsName(String compHrsName) {
		this.compHrsName = StringUtils.defaultIfEmpty(compHrsName, Constants.DEFAULT_STRING_VALUE);
	}
	
	public String getCompHrsStaffBudget() {
		return StringUtils.isEmpty(compHrsStaffBudget) ? "0" : compHrsStaffBudget;
	}
	public void setCompHrsStaffBudget(String compHrsStaffBudget) {
		this.compHrsStaffBudget = StringUtils.defaultIfEmpty(compHrsStaffBudget, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getCompHrsContractServicesBudget() {
		return compHrsContractServicesBudget.isBlank() ? "0" : compHrsContractServicesBudget;
	}
	public void setCompHrsContractServicesBudget(String compHrsContractServicesBudget) {
		this.compHrsContractServicesBudget = StringUtils.defaultIfEmpty(compHrsContractServicesBudget, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getCompTotalWorkedHrsBudget() {
		return compTotalWorkedHrsBudget.isBlank() ? "0" : compTotalWorkedHrsBudget;
	}
	public void setCompTotalWorkedHrsBudget(String compTotalWorkedHrsBudget) {
		this.compTotalWorkedHrsBudget = StringUtils.defaultIfEmpty(compTotalWorkedHrsBudget, Constants.DEFAULT_DECIMAL_VALUE);
	}
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_BUDGET_COMP_HRS;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getCompHrsType());
		elements.add(this.getCompHrsName());
		elements.add(this.getCompHrsStaffBudget());
		elements.add(this.getCompHrsContractServicesBudget());
		elements.add(this.getCompTotalWorkedHrsBudget());
		elements.add(this.getCompHrsOtherName());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
}
