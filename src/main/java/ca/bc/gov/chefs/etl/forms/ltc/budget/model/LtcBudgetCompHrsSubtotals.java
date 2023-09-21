package ca.bc.gov.chefs.etl.forms.ltc.budget.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcBudgetCompHrsSubtotals implements IModel {

	private String confirmationID;
	private String compHrsType;
	private String subTotalCompHrsStaffBudget;
	private String subTotalCompHrsContractServicesBudget;
	private String subTotalCompTotalWorkedHrsBudget;
	
	public String getConfirmationID() {
		return confirmationID;
	}
	public void setConfirmationID(String confirmationID) {
		this.confirmationID = StringUtils.defaultIfEmpty(confirmationID, Constants.DEFAULT_STRING_VALUE);
	}
	public String getCompHrsType() {
		return compHrsType;
	}
	public void setCompHrsType(String compHrsType) {
		this.compHrsType = StringUtils.defaultIfEmpty(compHrsType, Constants.DEFAULT_STRING_VALUE);
	}
	public String getSubTotalCompHrsStaffBudget() {
		return StringUtils.isBlank(subTotalCompHrsStaffBudget) ? "0" : subTotalCompHrsStaffBudget;
	}
	public void setSubTotalCompHrsStaffBudget(String subTotalCompHrsStaffBudget) {
		this.subTotalCompHrsStaffBudget = subTotalCompHrsStaffBudget;
	}
	public String getSubTotalCompHrsContractServicesBudget() {
		return StringUtils.isEmpty(subTotalCompHrsContractServicesBudget) ? "0" : subTotalCompHrsContractServicesBudget;
	}
	public void setSubTotalCompHrsContractServicesBudget(String subTotalCompHrsContractServicesBudget) {
		this.subTotalCompHrsContractServicesBudget = subTotalCompHrsContractServicesBudget;
	}
	public String getSubTotalCompTotalWorkedHrsBudget() {
		return StringUtils.isBlank(subTotalCompTotalWorkedHrsBudget) ? "0" : subTotalCompTotalWorkedHrsBudget;
	}
	public void setSubTotalCompTotalWorkedHrsBudget(String subTotalCompTotalWorkedHrsBudget) {
		this.subTotalCompTotalWorkedHrsBudget = subTotalCompTotalWorkedHrsBudget;
	}
	
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_BUDGET_COMP_HRS_SUBTOTALS;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationID());
		elements.add(this.getCompHrsType());
		elements.add(this.getSubTotalCompHrsStaffBudget());
		elements.add(this.getSubTotalCompHrsContractServicesBudget());
		elements.add(this.getSubTotalCompTotalWorkedHrsBudget());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	

}
