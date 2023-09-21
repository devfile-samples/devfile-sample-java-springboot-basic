package ca.bc.gov.chefs.etl.forms.ltc.budget.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcBudgetCompSal implements IModel{

	private String confirmationId;
	private String compSalType;
	private String compSalName;
	private String compSalStaffBudget;
	private String compSalContractServicesBudget;
	private String compSalTotalCostBudget;
	private String compSalOtherName = Constants.DEFAULT_NA_VALUE;

	public String getCompSalTotalCostBudget() {
		return compSalTotalCostBudget;
	}
	public void setCompSalTotalCostBudget(String compSalTotalCostBudget) {
		this.compSalTotalCostBudget = compSalTotalCostBudget;
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
	public String getCompSalStaffBudget() {
		return compSalStaffBudget;
	}
	public void setCompSalStaffBudget(String compSalStaffBudget) {
		this.compSalStaffBudget = StringUtils.defaultIfEmpty(compSalStaffBudget, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getCompSalContractServicesBudget() {
		return compSalContractServicesBudget;
	}
	public void setCompSalContractServicesBudget(String compSalContractServicesBudget) {
		this.compSalContractServicesBudget = StringUtils.defaultIfEmpty(compSalContractServicesBudget, Constants.DEFAULT_DECIMAL_VALUE);
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
		return Constants.LTC_BUDGET_COMP_SAL;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getCompSalType());
		elements.add(this.getCompSalName());
		elements.add(this.getCompSalStaffBudget());
		elements.add(this.getCompSalContractServicesBudget());
		elements.add(this.getCompSalTotalCostBudget());
		elements.add(this.getCompSalOtherName());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
}
