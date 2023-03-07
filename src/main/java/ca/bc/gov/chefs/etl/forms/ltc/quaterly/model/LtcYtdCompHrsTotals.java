package ca.bc.gov.chefs.etl.forms.ltc.quaterly.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.parser.IModel;

public class LtcYtdCompHrsTotals implements IModel{

	private String confirmationID;
	private String compHrsTotalType;
	private String totalCompHrsStaffYTD;
	private String totalCompHrsContractServicesYTD;
	private String totalCompHrsOfficeAllocYTD;
	private String totalCompTotalWorkedHrsYTD;
	
	
	
	public String getConfirmationID() {
		return confirmationID;
	}

	public void setConfirmationID(String confirmationID) {
		this.confirmationID = confirmationID;
	}

	public String getCompHrsTotalType() {
		return compHrsTotalType;
	}

	public void setCompHrsTotalType(String compHrsTotalType) {
		this.compHrsTotalType = compHrsTotalType;
	}

	public String getTotalCompHrsStaffYTD() {
		return totalCompHrsStaffYTD;
	}

	public void setTotalCompHrsStaffYTD(String totalCompHrsStaffYTD) {
		this.totalCompHrsStaffYTD = totalCompHrsStaffYTD;
	}

	public String getTotalCompHrsContractServicesYTD() {
		return totalCompHrsContractServicesYTD;
	}

	public void setTotalCompHrsContractServicesYTD(String totalCompHrsContractServicesYTD) {
		this.totalCompHrsContractServicesYTD = totalCompHrsContractServicesYTD;
	}

	public String getTotalCompHrsOfficeAllocYTD() {
		return totalCompHrsOfficeAllocYTD;
	}

	public void setTotalCompHrsOfficeAllocYTD(String totalCompHrsOfficeAllocYTD) {
		this.totalCompHrsOfficeAllocYTD = totalCompHrsOfficeAllocYTD;
	}

	public String getTotalCompTotalWorkedHrsYTD() {
		return totalCompTotalWorkedHrsYTD;
	}

	public void setTotalCompTotalWorkedHrsYTD(String totalCompTotalWorkedHrsYTD) {
		this.totalCompTotalWorkedHrsYTD = totalCompTotalWorkedHrsYTD;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_YTD_COMP_HRS_TOTALS;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.getConfirmationID());
		elements.add(this.getCompHrsTotalType());
	//	elements.add(this.getTotalCompHrsPerPayrollYTD());
		elements.add(this.getTotalCompHrsStaffYTD());
		elements.add(this.getTotalCompHrsContractServicesYTD());
		elements.add(this.getTotalCompHrsOfficeAllocYTD());
		elements.add(this.getTotalCompTotalWorkedHrsYTD());
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

	
	
}
