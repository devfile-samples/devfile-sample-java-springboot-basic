package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcYtdCompHrs implements IModel {
	
	private String confirmationId;
	private String compHrsType;
	private String compHrsName;
	//private String compHrsPerPayrollYtd;
	private String compHrsStaffYtd;
	private String compHrsContractServicesYtd;
	private String compTotalWorkedHrsYtd;
	private String compHrsOtherName = Constants.DEFAULT_STRING_VALUE;
	
	public String getCompHrsOtherName() {
		return compHrsOtherName;
	}
	public void setCompHrsOtherName(String compHrsOtherName) {
		this.compHrsOtherName = compHrsOtherName;
	}
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
	}
	public String getCompHrsType() {
		return compHrsType;
	}
	public void setCompHrsType(String compHrsType) {
		this.compHrsType = StringUtils.defaultIfEmpty(compHrsType, Constants.DEFAULT_STRING_VALUE);
	}
	public String getCompHrsName() {
		return compHrsName;
	}
	public void setCompHrsName(String compHrsName) {
		this.compHrsName = StringUtils.defaultIfEmpty(compHrsName, Constants.DEFAULT_STRING_VALUE);
	}
	
	public String getCompHrsStaffYtd() {
		return StringUtils.isEmpty(compHrsStaffYtd) ? "0" : compHrsStaffYtd;
	}
	public void setCompHrsStaffYtd(String compHrsStaffYtd) {
		this.compHrsStaffYtd = StringUtils.defaultIfEmpty(compHrsStaffYtd, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getCompHrsContractServicesYtd() {
		return compHrsContractServicesYtd.isBlank() ? "0" : compHrsContractServicesYtd;
	}
	public void setCompHrsContractServicesYtd(String compHrsContractServicesYtd) {
		this.compHrsContractServicesYtd = StringUtils.defaultIfEmpty(compHrsContractServicesYtd, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getCompTotalWorkedHrsYtd() {
		return compTotalWorkedHrsYtd.isBlank() ? "0" : compTotalWorkedHrsYtd;
	}
	public void setCompTotalWorkedHrsYtd(String compTotalWorkedHrsYtd) {
		this.compTotalWorkedHrsYtd = StringUtils.defaultIfEmpty(compTotalWorkedHrsYtd, Constants.DEFAULT_DECIMAL_VALUE);
	}
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_YTD_COMP_HRS;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getCompHrsType());
		elements.add(this.getCompHrsName());
		elements.add(this.getCompHrsStaffYtd());
		elements.add(this.getCompHrsContractServicesYtd());
		elements.add(this.getCompTotalWorkedHrsYtd());
		elements.add(this.getCompHrsOtherName());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
}
