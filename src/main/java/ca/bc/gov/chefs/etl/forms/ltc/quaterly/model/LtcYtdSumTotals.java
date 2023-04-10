package ca.bc.gov.chefs.etl.forms.ltc.quaterly.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcYtdSumTotals implements IModel {

	private String confirmationId;
	private String totName;
	private String sumYTD;
	private String totNotes;
	
	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}
	public String getTotName() {
		return totName;
	}
	public void setTotName(String totName) {
		this.totName = totName;
	}
	public String getSumYTD() {
		return sumYTD;
	}
	public void setSumYTD(String sumYTD) {
		this.sumYTD = sumYTD;
	}
	public String getTotNotes() {
		return totNotes;
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
