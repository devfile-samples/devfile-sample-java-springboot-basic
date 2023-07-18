package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class LtcYtdRevSubTotals implements IModel {

	private String confirmationId;
	private String revType;
	private String subTotalRevYtd;
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
	public String getSubTotalRevYtd() {
		return subTotalRevYtd;
	}
	public void setSubTotalRevYtd(String subTotalRevYtd) {
		this.subTotalRevYtd = subTotalRevYtd;
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
		return Constants.LTC_YTD_REV_SUBTOTALS;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.getConfirmationId());
		elements.add(this.getRevType());
		elements.add(this.getSubTotalRevYtd());
		elements.add(this.getSubTotalRevNotes());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
}
