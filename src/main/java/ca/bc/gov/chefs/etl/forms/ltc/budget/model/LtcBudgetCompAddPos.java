package ca.bc.gov.chefs.etl.forms.ltc.budget.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcBudgetCompAddPos implements IModel{

	private String confirmationId;
	private String addPosType;
	private String addPosName;
	private String addPosContractedOutBudget;
	private String addPosLegalNameContractServiceBudget;
	private String addPosPercentServiceContractOutBudget;
	private String addPosAnotherName = Constants.DEFAULT_NA_VALUE;
	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
	}
	public String getAddPosType() {
		return addPosType;
	}
	public void setAddPosType(String addPosType) {
		this.addPosType = addPosType;
	}
	public String getAddPosName() {
		return addPosName;
	}
	public void setAddPosName(String addPosName) {
		this.addPosName = addPosName;
	}
	public String getAddPosContractedOutBudget() {
		return this.addPosContractedOutBudget;
	}
	// TODO set to Constant.DEFAULT_BOOLEAN_VALUE if needed 
	public void setAddPosContractedOutBudget(String addPosContractedOutBudget) {
		this.addPosContractedOutBudget = StringUtils.defaultIfEmpty(addPosContractedOutBudget, Constants.DEFAULT_STRING_VALUE);
	}
	public String getAddPosLegalNameContractServiceBudget() {
		return addPosLegalNameContractServiceBudget;
	}
	public void setAddPosLegalNameContractServiceBudget(String addPosLegalNameContractServiceBudget) {
		this.addPosLegalNameContractServiceBudget = StringUtils.defaultIfEmpty(addPosLegalNameContractServiceBudget, Constants.DEFAULT_STRING_VALUE);
	}
	public String getAddPosPercentServiceContractOutBudget() {
		return addPosPercentServiceContractOutBudget;
	}
	public void setAddPosPercentServiceContractOutBudget(String addPosPercentServiceContractOutBudget) {
		this.addPosPercentServiceContractOutBudget = StringUtils.defaultIfEmpty(addPosPercentServiceContractOutBudget, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getAddPosAnotherName() {
		return addPosAnotherName;
	}
	public void setAddPosAnotherName(String addPosAnotherName) {
		this.addPosAnotherName = addPosAnotherName;
	}

	public void determineAddPosContractedOutBudget() {
		if(this.addPosLegalNameContractServiceBudget != null && !this.addPosLegalNameContractServiceBudget.trim().isEmpty()){
			this.setAddPosContractedOutBudget("Y");
		} else {
			this.setAddPosContractedOutBudget("N");
		}
	}
	
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_BUDGET_COMP_ADD_POS;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getAddPosType());
		elements.add(this.getAddPosName());
		elements.add(this.getAddPosContractedOutBudget());
		elements.add(this.getAddPosLegalNameContractServiceBudget());
		elements.add(this.getAddPosPercentServiceContractOutBudget());
		elements.add(this.getAddPosAnotherName());
		
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
}
