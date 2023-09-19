package ca.bc.gov.chefs.etl.forms.ltc.budget.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class LtcBudgetExp implements IModel {

	private String confirmationId;
	private String expType;
	private String expName;
	private String expAtApril;
	private String expAdjustment;
	private String expRevised;
	private String expNotes;
	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
	}
	public String getExpType() {
		return expType;
	}
	public void setExpType(String expType) {
		this.expType = StringUtils.defaultIfEmpty(expType, Constants.DEFAULT_STRING_VALUE);
	}
	public String getExpName() {
		return expName;
	}
	public void setExpName(String expName) {
		this.expName = StringUtils.defaultIfEmpty(expName, Constants.DEFAULT_STRING_VALUE);
	}
	public String getExpAtApril() {
		return expAtApril;
	}
	public void setExpAtApril(String expAtApril) {
		this.expAtApril = StringUtils.defaultIfEmpty(expAtApril, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getExpAdjustment() {
		return expAdjustment;
	}
	public void setExpAdjustment(String expAdjustment) {
		this.expAdjustment = StringUtils.defaultIfEmpty(expAdjustment, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getExpRevised() {
		return expRevised;
	}
	public void setExpRevised(String expRevised) {
		this.expRevised = expRevised;
	}
	public String getExpNotes() {
		return expNotes != null ? CSVUtil.replaceLineBreaks(expNotes) : expNotes;
	}
	public void setExpNotes(String expNotes) {
		this.expNotes = expNotes;
	}
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_BUDGET_EXP;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getExpType());
		elements.add(this.getExpName());
		elements.add(this.getExpAtApril());
		elements.add(this.getExpAdjustment());
		elements.add(this.getExpRevised());
		elements.add(this.getExpNotes());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
}
