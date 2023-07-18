package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class LtcYtdSumTotals implements IModel {

	private String confirmationId;
	private String totName;
	private String sumYTD;
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
	public String getSumYTD() {
		return sumYTD;
	}
	public void setSumYTD(String sumYTD) {
		this.sumYTD = StringUtils.defaultIfEmpty(sumYTD, Constants.DEFAULT_DECIMAL_VALUE);
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
		return Constants.LTC_YTD_SUM_TOTALS;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.getConfirmationId());
		elements.add(this.getTotName());
		elements.add(this.getSumYTD());
		elements.add(this.getTotNotes());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
	
}
