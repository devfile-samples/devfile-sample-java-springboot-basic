package ca.bc.gov.chefs.etl.forms.ltc.budget.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcBudgetCompHrsTotals implements IModel{

	private String confirmationID;
	private String compHrsTotalType;
	private String totalCompHrsStaffBudget;
	private String totalCompHrsContractServicesBudget;
	private String totalCompTotalWorkedHrsBudget;
	
	
	
	public String getConfirmationID() {
		return confirmationID;
	}

	public void setConfirmationID(String confirmationID) {
		this.confirmationID = StringUtils.defaultIfEmpty(confirmationID, Constants.DEFAULT_STRING_VALUE);
	}

	public String getCompHrsTotalType() {
		return compHrsTotalType;
	}

	public void setCompHrsTotalType(String compHrsTotalType) {
		this.compHrsTotalType = StringUtils.defaultIfEmpty(compHrsTotalType, Constants.DEFAULT_STRING_VALUE);
	}

	public String getTotalCompHrsStaffBudget() {
		return StringUtils.isBlank(totalCompHrsStaffBudget) ? "0" : totalCompHrsStaffBudget;
	}

	public void setTotalCompHrsStaffBudget(String totalCompHrsStaffBudget) {
		this.totalCompHrsStaffBudget = totalCompHrsStaffBudget;
	}

	public String getTotalCompHrsContractServicesBudget() {
		return StringUtils.isBlank(totalCompHrsContractServicesBudget) ? "0" : totalCompHrsContractServicesBudget;
	}

	public void setTotalCompHrsContractServicesBudget(String totalCompHrsContractServicesBudget) {
		this.totalCompHrsContractServicesBudget = totalCompHrsContractServicesBudget;
	}

	public String getTotalCompTotalWorkedHrsBudget() {
		return StringUtils.isBlank(totalCompTotalWorkedHrsBudget) ? "0" : totalCompTotalWorkedHrsBudget;
	}

	public void setTotalCompTotalWorkedHrsBudget(String totalCompTotalWorkedHrsBudget) {
		this.totalCompTotalWorkedHrsBudget = totalCompTotalWorkedHrsBudget;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_BUDGET_COMP_HRS_TOTALS;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.getConfirmationID());
		elements.add(this.getCompHrsTotalType());
	//	elements.add(this.getTotalCompHrsPerPayrollBudget());
		elements.add(this.getTotalCompHrsStaffBudget());
		elements.add(this.getTotalCompHrsContractServicesBudget());
		elements.add(this.getTotalCompTotalWorkedHrsBudget());
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

	
	
}
