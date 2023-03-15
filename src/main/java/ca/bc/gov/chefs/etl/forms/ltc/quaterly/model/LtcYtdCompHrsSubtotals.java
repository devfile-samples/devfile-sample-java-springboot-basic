package ca.bc.gov.chefs.etl.forms.ltc.quaterly.model;

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
	private String subTotalCompHrsOfficeAllocYTD;
	private String subTotalCompTotalWorkedHrsYTD;
	
	public String getConfirmationID() {
		return confirmationID;
	}
	public void setConfirmationID(String confirmationID) {
		this.confirmationID = confirmationID;
	}
	public String getCompHrsType() {
		return compHrsType;
	}
	public void setCompHrsType(String compHrsType) {
		this.compHrsType = compHrsType;
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
	public String getSubTotalCompHrsOfficeAllocYTD() {
		return StringUtils.isBlank(subTotalCompHrsOfficeAllocYTD) ? "0" : subTotalCompHrsOfficeAllocYTD;
	}
	public void setSubTotalCompHrsOfficeAllocYTD(String subTotalCompHrsOfficeAllocYTD) {
		this.subTotalCompHrsOfficeAllocYTD = subTotalCompHrsOfficeAllocYTD;
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
		elements.add(this.getSubTotalCompHrsOfficeAllocYTD());
		elements.add(this.getSubTotalCompTotalWorkedHrsYTD());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	

}
