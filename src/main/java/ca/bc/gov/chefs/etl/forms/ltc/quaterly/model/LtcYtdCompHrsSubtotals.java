package ca.bc.gov.chefs.etl.forms.ltc.quaterly.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.parser.IModel;

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
		return subTotalCompHrsStaffYTD;
	}
	public void setSubTotalCompHrsStaffYTD(String subTotalCompHrsStaffYTD) {
		this.subTotalCompHrsStaffYTD = subTotalCompHrsStaffYTD;
	}
	public String getSubTotalCompHrsContractServicesYTD() {
		return subTotalCompHrsContractServicesYTD;
	}
	public void setSubTotalCompHrsContractServicesYTD(String subTotalCompHrsContractServicesYTD) {
		this.subTotalCompHrsContractServicesYTD = subTotalCompHrsContractServicesYTD;
	}
	public String getSubTotalCompHrsOfficeAllocYTD() {
		return subTotalCompHrsOfficeAllocYTD;
	}
	public void setSubTotalCompHrsOfficeAllocYTD(String subTotalCompHrsOfficeAllocYTD) {
		this.subTotalCompHrsOfficeAllocYTD = subTotalCompHrsOfficeAllocYTD;
	}
	public String getSubTotalCompTotalWorkedHrsYTD() {
		return subTotalCompTotalWorkedHrsYTD;
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
		return "LTC_YTD_COMP_HRS_SUB_TOTALS";
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
