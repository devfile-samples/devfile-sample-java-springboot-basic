package ca.bc.gov.chefs.etl.forms.ltc.budget.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcBudgetCompSalTotals implements IModel {

	private String confirmationId;
	private String compSalType;
	private String totalCompSalStaffBudget;
	private String totalCompSalContractServicesBudget;
	private String totalCompSalTotalCostBudget;

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

	public String getTotalCompSalStaffBudget() {
		return StringUtils.isBlank(totalCompSalStaffBudget) ? "0" : totalCompSalStaffBudget;
	}

	public void setTotalCompSalStaffBudget(String totalCompSalStaffBudget) {
		this.totalCompSalStaffBudget = totalCompSalStaffBudget;
	}

	public String getTotalCompSalContractServicesBudget() {
		return StringUtils.isBlank(totalCompSalContractServicesBudget) ? "0" : totalCompSalContractServicesBudget;
	}

	public void setTotalCompSalContractServicesBudget(String totalCompSalContractServicesBudget) {
		this.totalCompSalContractServicesBudget = totalCompSalContractServicesBudget;
	}

	public String getTotalCompSalTotalCostBudget() {
		 return StringUtils.isBlank(totalCompSalTotalCostBudget) ? "0" : totalCompSalTotalCostBudget;
	}

	public void setTotalCompSalTotalCostBudget(String totalCompSalTotalCostBudget) {
		this.totalCompSalTotalCostBudget = totalCompSalTotalCostBudget;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_BUDGET_COMP_SAL_TOTALS;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.getConfirmationId());
		elements.add(this.getCompSalType());
		elements.add(this.getTotalCompSalStaffBudget());
		elements.add(this.getTotalCompSalContractServicesBudget());
		elements.add(this.getTotalCompSalTotalCostBudget());

		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

}
