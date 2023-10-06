package ca.bc.gov.chefs.etl.forms.ltc.budget.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class LtcBudgetRevTotals implements IModel {

	private String confirmationId;
	private String revType;
	private String subTotalRevAtApril;
	private String subTotalRevAdjustment;
	private String subTotalRevRevised;
	private String subTotalRevNotes;
	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
	}
	public String getRevType() {
		return revType;
	}
	public void setRevType(String revType) {
		this.revType = StringUtils.defaultIfEmpty(revType, Constants.DEFAULT_STRING_VALUE);
	}
	public String getSubTotalRevAtApril() {
		return subTotalRevAtApril;
	}
	public void setSubTotalRevAtApril(String subTotalRevAtApril) {
		this.subTotalRevAtApril = StringUtils.defaultIfEmpty(subTotalRevAtApril, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getSubTotalRevAdjustment() {
		return subTotalRevAdjustment;
	}
	public void setSubTotalRevAdjustment(String subTotalRevAdjustment) {
		this.subTotalRevAdjustment = StringUtils.defaultIfEmpty(subTotalRevAdjustment, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getSubTotalRevRevised() {
		return subTotalRevRevised;
	}
	public void setSubTotalRevRevised(String subTotalRevRevised) {
		this.subTotalRevRevised = subTotalRevRevised;
	}
	public String getSubTotalRevNotes() {
		return subTotalRevNotes != null ? CSVUtil.replaceLineBreaks(subTotalRevNotes) : subTotalRevNotes;
	}
	public void setSubTotalRevNotes(String subTotalRevNotes) {
		this.subTotalRevNotes = subTotalRevNotes;
	}
	
	
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_BUDGET_REV_TOTALS;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.getConfirmationId());
		elements.add(this.getRevType());
		elements.add(this.getSubTotalRevAtApril());
		elements.add(this.getSubTotalRevAdjustment());
		elements.add(this.getSubTotalRevRevised());
		elements.add(this.getSubTotalRevNotes());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
}
