package ca.bc.gov.chefs.etl.forms.ltc.budget.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class LtcBudgetDepSubTotals implements IModel {

	private String confirmationId;
	private String subTotalDepAtApril;
	private String subTotalDepAdjustment;
	private String subTotalDepRevised;
	private String subTotalDepNotes;
	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
	}
	public String getSubTotalDepAtApril() {
		return subTotalDepAtApril;
	}
	public void setSubTotalDepAtApril(String subTotalDepAtApril) {
		this.subTotalDepAtApril = StringUtils.defaultIfEmpty(subTotalDepAtApril, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getSubTotalDepAdjustment() {
		return subTotalDepAdjustment;
	}
	public void setSubTotalDepAdjustment(String subTotalDepAdjustment) {
		this.subTotalDepAdjustment = StringUtils.defaultIfEmpty(subTotalDepAdjustment, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getSubTotalDepRevised() {
		return subTotalDepRevised;
	}
	public void setSubTotalDepRevised(String subTotalDepRevised) {
		this.subTotalDepRevised = subTotalDepRevised;
	}
	public String getSubTotalDepNotes() {
		return subTotalDepNotes != null ? CSVUtil.replaceLineBreaks(subTotalDepNotes) : subTotalDepNotes;
	}
	public void setSubTotalDepNotes(String subTotalDepNotes) {
		this.subTotalDepNotes = subTotalDepNotes;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_BUDGET_DEP_SUBTOTALS;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getSubTotalDepAtApril());
		elements.add(this.getSubTotalDepAdjustment());
		elements.add(this.getSubTotalDepRevised());
		elements.add(this.getSubTotalDepNotes());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
}
