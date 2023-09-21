package ca.bc.gov.chefs.etl.forms.ltc.budget.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcBudgetCompSalSubtotals implements IModel {

	private String confirmationId;
	private String compSalType;
	private String subTotalCompSalStaffBudget;
	private String subTotalCompSalContractServicesBudget;
	private String subTotalCompSalTotalCostBudget;

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

	public String getSubTotalCompSalStaffBudget() {
		return StringUtils.isBlank(subTotalCompSalStaffBudget) ? "0" : subTotalCompSalStaffBudget;
	}

	public void setSubTotalCompSalStaffBudget(String subTotalCompSalStaffBudget) {
		this.subTotalCompSalStaffBudget = subTotalCompSalStaffBudget;
	}

	public String getSubTotalCompSalContractServicesBudget() {
		return StringUtils.isBlank(subTotalCompSalContractServicesBudget) ? "0" : subTotalCompSalContractServicesBudget;
	}

	public void setSubTotalCompSalContractServicesBudget(String subTotalCompSalContractServicesBudget) {
		this.subTotalCompSalContractServicesBudget = subTotalCompSalContractServicesBudget;
	}

	public String getSubTotalCompSalTotalCostBudget() {
		return StringUtils.isBlank(subTotalCompSalTotalCostBudget) ? "0" : subTotalCompSalTotalCostBudget;
	}

	public void setSubTotalCompSalTotalCostBudget(String subTotalCompSalTotalCostBudget) {
		this.subTotalCompSalTotalCostBudget = subTotalCompSalTotalCostBudget;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_BUDGET_COMP_SAL_SUBTOTALS;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.getConfirmationId());
		elements.add(this.getCompSalType());
		elements.add(this.getSubTotalCompSalStaffBudget());
		elements.add(this.getSubTotalCompSalContractServicesBudget());
		elements.add(this.getSubTotalCompSalTotalCostBudget());
		
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

}
