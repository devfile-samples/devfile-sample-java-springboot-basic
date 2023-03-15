package ca.bc.gov.chefs.etl.forms.ltc.quaterly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcYtdRev implements IModel {

	private String confirmationId;
	private String revType;
	private String revName;
	private String revYTD;
	private String revNotes;
	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}
	public String getRevType() {
		return revType;
	}
	public void setRevType(String revType) {
		this.revType = revType;
	}
	public String getRevName() {
		return revName;
	}
	public void setRevName(String revName) {
		this.revName = revName;
	}
	public String getRevYTD() {
		return StringUtils.isBlank(revYTD) ? "0" : revYTD;
	}
	public void setRevYTD(String revYTD) {
		this.revYTD = revYTD;
	}
	public String getRevNotes() {
		return revNotes;
	}
	public void setRevNotes(String revNotes) {
		this.revNotes = revNotes;
	}
	
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_YTD_REV;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getRevType());
		elements.add(this.getRevName());
		elements.add(this.getRevYTD());
		elements.add(this.getRevNotes());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
}
