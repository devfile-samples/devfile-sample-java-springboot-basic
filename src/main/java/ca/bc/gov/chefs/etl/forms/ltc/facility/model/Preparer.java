package ca.bc.gov.chefs.etl.forms.ltc.facility.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class Preparer implements IModel{
	private String confirmationID;
	private String preparerNum;
	private String preparerContactName;
	private String preparerContactPosition;
	private String preparerContactPhone;
	private String preparerContactEmail;
	
	public String getConfirmationID() {
		return confirmationID;
	}
	public void setConfirmationID(String confirmationID) {
		this.confirmationID = StringUtils.defaultIfEmpty(confirmationID, Constants.DEFAULT_STRING_VALUE);
	}
	public String getPreparerNum() {
		return preparerNum;
	}
	public void setPreparerNum(String preparerNum) {
		this.preparerNum = StringUtils.defaultIfEmpty(preparerNum, Constants.DEFAULT_STRING_VALUE);
	}
	public String getPreparerContactName() {
		return preparerContactName;
	}
	public void setPreparerContactName(String preparerContactName) {
		this.preparerContactName = StringUtils.defaultIfEmpty(preparerContactName, Constants.DEFAULT_STRING_VALUE);
	}
	public String getPreparerContactPosition() {
		return preparerContactPosition;
	}
	public void setPreparerContactPosition(String preparerContactPosition) {
		this.preparerContactPosition = StringUtils.defaultIfEmpty(preparerContactPosition, Constants.DEFAULT_STRING_VALUE);
	}
	public String getPreparerContactPhone() {
		return preparerContactPhone;
	}
	public void setPreparerContactPhone(String preparerContactPhone) {
		this.preparerContactPhone = StringUtils.defaultIfEmpty(preparerContactPhone, Constants.DEFAULT_STRING_VALUE);
	}
	public String getPreparerContactEmail() {
		return preparerContactEmail;
	}
	public void setPreparerContactEmail(String preparerContactEmail) {
		this.preparerContactEmail = StringUtils.defaultIfEmpty(preparerContactEmail, Constants.DEFAULT_STRING_VALUE);
	}
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_FACILITY_PREPARER;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.getConfirmationID());
		elements.add(this.getPreparerNum());
		elements.add(this.getPreparerContactName());
		elements.add(this.getPreparerContactPosition());
		elements.add(this.getPreparerContactPhone());
		elements.add(this.getPreparerContactEmail());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
	

}
