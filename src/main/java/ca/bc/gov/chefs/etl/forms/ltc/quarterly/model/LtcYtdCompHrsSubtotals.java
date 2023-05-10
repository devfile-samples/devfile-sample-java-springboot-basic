package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcYtdCompHrsSubtotals implements IModel {

	private String confirmationID;
	private String compHrsType;
	private String subTotalCompHrsStaffYTD;
	private String subTotalCompHrsContractServicesYTD;
	private String subTotalCompTotalWorkedHrsYTD;
	
	public String getConfirmationID() {
		return confirmationID;
	}
	public void setConfirmationID(String confirmationID) {
		this.confirmationID = StringUtils.defaultIfEmpty(confirmationID, Constants.DEFAULT_STRING_VALUE);
	}
	public String getCompHrsType() {
		return compHrsType;
	}
	public void setCompHrsType(String compHrsType) {
		this.compHrsType = StringUtils.defaultIfEmpty(compHrsType, Constants.DEFAULT_STRING_VALUE);
	}
	public String getSubTotalCompHrsStaffYTD() {
		return StringUtils.isBlank(subTotalCompHrsStaffYTD) ? "0" : subTotalCompHrsStaffYTD;
	}
	public void setSubTotalCompHrsStaffYTD(String subTotalCompHrsStaffYTD) {
		this.subTotalCompHrsStaffYTD = subTotalCompHrsStaffYTD;
	}
	public String getSubTotalCompHrsContractServicesYTD() {
		return StringUtils.isEmpty(subTotalCompHrsContractServicesYTD) ? "0" : subTotalCompHrsContractServicesYTD;
	}
	public void setSubTotalCompHrsContractServicesYTD(String subTotalCompHrsContractServicesYTD) {
		this.subTotalCompHrsContractServicesYTD = subTotalCompHrsContractServicesYTD;
	}
	public String getSubTotalCompTotalWorkedHrsYTD() {
		return StringUtils.isBlank(subTotalCompTotalWorkedHrsYTD) ? "0" : subTotalCompTotalWorkedHrsYTD;
	}
	public void setSubTotalCompTotalWorkedHrsYTD(String subTotalCompTotalWorkedHrsYTD) {
		this.subTotalCompTotalWorkedHrsYTD = subTotalCompTotalWorkedHrsYTD;
	}
	
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_YTD_COMP_HRS_SUBTOTALS;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationID());
		elements.add(this.getCompHrsType());
		elements.add(this.getSubTotalCompHrsStaffYTD());
		elements.add(this.getSubTotalCompHrsContractServicesYTD());
		elements.add(this.getSubTotalCompTotalWorkedHrsYTD());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	

}
