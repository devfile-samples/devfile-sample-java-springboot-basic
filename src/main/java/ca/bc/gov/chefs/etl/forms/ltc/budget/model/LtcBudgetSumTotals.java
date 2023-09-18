package ca.bc.gov.chefs.etl.forms.ltc.budget.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class LtcBudgetSumTotals implements IModel {

	private String confirmationId;
	private String totName;
	private String sumBudget;
	private String totNotes;
	
	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
	}
	public String getTotName() {
		return totName;
	}
	public void setTotName(String totName) {
		this.totName = StringUtils.defaultIfEmpty(totName, Constants.DEFAULT_STRING_VALUE);
	}
	public String getSumBudget() {
		return sumBudget;
	}
	public void setSumBudget(String sumBudget) {
		this.sumBudget = StringUtils.defaultIfEmpty(sumBudget, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getTotNotes() {
		return totNotes != null ? CSVUtil.replaceLineBreaks(totNotes) : totNotes;
	}
	public void setTotNotes(String totNotes) {
		this.totNotes = totNotes;
	}
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_BUDGET_SUM_TOTALS;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.getConfirmationId());
		elements.add(this.getTotName());
		elements.add(this.getSumBudget());
		elements.add(this.getTotNotes());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
	
}
