package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;
import java.util.List;
import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcYtdDep implements IModel {

	private String confirmationId;
	private String depName;
	private String depYtd;
	private String depNotes;
	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getDepYtd() {
		return depYtd;
	}
	public void setDepYtd(String depYtd) {
		this.depYtd = depYtd;
	}
	public String getDepNotes() {
		return depNotes;
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
		return Constants.LTC_YTD_DEP;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getDepName());
		elements.add(this.getDepYtd());
		elements.add(this.getDepNotes());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
}
