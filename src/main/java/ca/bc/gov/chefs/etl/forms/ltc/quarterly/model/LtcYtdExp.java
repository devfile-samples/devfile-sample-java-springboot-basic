package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcYtdExp implements IModel {

	private String confirmationId;
	private String expType;
	private String expName;
	private String expYtd;
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
	public String getExpYtd() {
		return expYtd;
	}
	public void setExpYtd(String expYtd) {
		this.expYtd = StringUtils.defaultIfEmpty(expYtd, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getExpNotes() {
		return expNotes != null ? expNotes.replaceAll("\\R", " ") : expNotes;
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
		return Constants.LTC_YTD_EXP;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getExpType());
		elements.add(this.getExpName());
		elements.add(this.getExpYtd());
		elements.add(this.getExpNotes());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
}
