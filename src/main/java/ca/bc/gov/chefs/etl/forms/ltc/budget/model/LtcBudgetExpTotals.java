package ca.bc.gov.chefs.etl.forms.ltc.budget.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class LtcBudgetExpTotals implements IModel {

	private String confirmationId;
	private String expType;
	private String subTotalExpAtApril;
	private String subTotalExpAdjustment;
	private String subTotalExpRevised;
	private String subTotalExpNotes;
	
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
	public String getSubTotalExpAtApril() {
		return subTotalExpAtApril;
	}
	public void setSubTotalExpAtApril(String subTotalExpAtApril) {
		this.subTotalExpAtApril = StringUtils.defaultIfEmpty(subTotalExpAtApril, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getSubTotalExpAdjustment() {
		return subTotalExpAdjustment;
	}
	public void setSubTotalExpAdjustment(String subTotalExpAdjustment) {
		this.subTotalExpAdjustment = StringUtils.defaultIfEmpty(subTotalExpAdjustment, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getSubTotalExpRevised() {
		return subTotalExpRevised;
	}
	public void setSubTotalExpRevised(String subTotalExpRevised) {
		this.subTotalExpRevised = subTotalExpRevised;
	}
	public String getSubTotalExpNotes() {
		return subTotalExpNotes != null ? CSVUtil.replaceLineBreaks(subTotalExpNotes) : subTotalExpNotes;
	}
	public void setSubTotalExpNotes(String subTotalExpNotes) {
		this.subTotalExpNotes = subTotalExpNotes;
	}
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_BUDGET_EXP_TOTALS;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.getConfirmationId());
		elements.add(this.getExpType());
		elements.add(this.getSubTotalExpAtApril());
		elements.add(this.getSubTotalExpAdjustment());
		elements.add(this.getSubTotalExpRevised());
		elements.add(this.getSubTotalExpNotes());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
	
}
