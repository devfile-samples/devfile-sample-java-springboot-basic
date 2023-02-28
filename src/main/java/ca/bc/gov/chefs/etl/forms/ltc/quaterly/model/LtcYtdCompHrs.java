package ca.bc.gov.chefs.etl.forms.ltc.quaterly.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.parser.IModel;

public class LtcYtdCompHrs implements IModel {
	
	private String confirmationId;
	private String compHrsType;
	private String compHrsName;
	private String compHrsPerPayrollYtd;
	private String compHrsStaffYtd;
	private String compHrsContractServicesYtd;
	private String compHrsOfficeAllocYtd;
	private String compTotalWorkedHrsYtd;
	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}
	public String getCompHrsType() {
		return compHrsType;
	}
	public void setCompHrsType(String compHrsType) {
		this.compHrsType = compHrsType;
	}
	public String getCompHrsName() {
		return compHrsName;
	}
	public void setCompHrsName(String compHrsName) {
		this.compHrsName = compHrsName;
	}
	public String getCompHrsPerPayrollYtd() {
		return compHrsPerPayrollYtd;
	}
	public void setCompHrsPerPayrollYtd(String compHrsPerPayrollYtd) {
		this.compHrsPerPayrollYtd = compHrsPerPayrollYtd;
	}
	public String getCompHrsStaffYtd() {
		return compHrsStaffYtd;
	}
	public void setCompHrsStaffYtd(String compHrsStaffYtd) {
		this.compHrsStaffYtd = compHrsStaffYtd;
	}
	public String getCompHrsContractServicesYtd() {
		return compHrsContractServicesYtd;
	}
	public void setCompHrsContractServicesYtd(String compHrsContractServicesYtd) {
		this.compHrsContractServicesYtd = compHrsContractServicesYtd;
	}
	public String getCompHrsOfficeAllocYtd() {
		return compHrsOfficeAllocYtd;
	}
	public void setCompHrsOfficeAllocYtd(String compHrsOfficeAllocYtd) {
		this.compHrsOfficeAllocYtd = compHrsOfficeAllocYtd;
	}
	
	public String getCompTotalWorkedHrsYtd() {
		return compTotalWorkedHrsYtd;
	}
	public void setCompTotalWorkedHrsYtd(String compTotalWorkedHrsYtd) {
		this.compTotalWorkedHrsYtd = compTotalWorkedHrsYtd;
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
		elements.add(this.getCompHrsPerPayrollYtd());
		elements.add(this.getCompHrsStaffYtd());
		elements.add(this.getCompHrsContractServicesYtd());
		elements.add(this.getCompHrsOfficeAllocYtd());
		elements.add(this.getCompTotalWorkedHrsYtd());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
}
