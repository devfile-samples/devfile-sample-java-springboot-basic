package ca.bc.gov.chefs.etl.forms.ltc.budget.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class LtcBudgetDep implements IModel {

	private String confirmationId;
	private String depName;
	private String depAtApril;
	private String depAdjustment;
	private String depRevised;
	private String depNotes;
	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = StringUtils.defaultIfEmpty(depName, Constants.DEFAULT_STRING_VALUE);
	}
	public String getDepAtApril() {
		return depAtApril;
	}
	public void setDepAtApril(String depAtApril) {
		this.depAtApril = StringUtils.defaultIfEmpty(depAtApril, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getDepAdjustment() {
		return depAdjustment;
	}
	public void setDepAdjustment(String depAtAdjustment) {
		this.depAdjustment = StringUtils.defaultIfEmpty(depAtAdjustment, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getDepRevised() {
		return depRevised;
	}
	public void setDepRevised(String depAtRevised) {
		this.depRevised = depAtRevised;
	}
	public String getDepNotes() {
		return depNotes != null ? CSVUtil.replaceLineBreaks(depNotes) : depNotes;
	}
	public void setDepNotes(String depNotes) {
		this.depNotes = depNotes;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_BUDGET_DEP;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getDepName());
		elements.add(this.getDepAtApril());
		elements.add(this.getDepAdjustment());
		elements.add(this.getDepRevised());
		elements.add(this.getDepNotes());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
}
