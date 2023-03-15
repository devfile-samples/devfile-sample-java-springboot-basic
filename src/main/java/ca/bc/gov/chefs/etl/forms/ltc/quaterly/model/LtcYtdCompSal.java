package ca.bc.gov.chefs.etl.forms.ltc.quaterly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcYtdCompSal implements IModel{

	private String confirmationId;
	private String compSalType;
	private String compSalName;
	private String compSalStaffYtd;
	private String compSalContractServicesYtd;
	private String compSalOfficeAllocYtd;
	private String compSalTotalCostYtd;
	public String getCompSalTotalCostYtd() {
		return compSalTotalCostYtd;
	}
	public void setCompSalTotalCostYtd(String compSalTotalCostYtd) {
		this.compSalTotalCostYtd = compSalTotalCostYtd;
	}
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}
	public String getCompSalType() {
		return compSalType;
	}
	public void setCompSalType(String compSalType) {
		this.compSalType = compSalType;
	}
	public String getCompSalName() {
		return compSalName;
	}
	public void setCompSalName(String compSalName) {
		this.compSalName = compSalName;
	}
	public String getCompSalStaffYtd() {
		return StringUtils.isBlank(compSalStaffYtd) ? "0" : compSalStaffYtd;
	}
	public void setCompSalStaffYtd(String compSalStaffYtd) {
		this.compSalStaffYtd = compSalStaffYtd;
	}
	public String getCompSalContractServicesYtd() {
		return StringUtils.isBlank(compSalContractServicesYtd) ? "0" : compSalContractServicesYtd;
	}
	public void setCompSalContractServicesYtd(String compSalContractServicesYtd) {
		this.compSalContractServicesYtd = compSalContractServicesYtd;
	}
	public String getCompSalOfficeAllocYtd() {
		return StringUtils.isBlank(compSalOfficeAllocYtd) ? "0" : compSalOfficeAllocYtd;
	}
	public void setCompSalOfficeAllocYtd(String compSalOfficeAllocYtd) {
		this.compSalOfficeAllocYtd = compSalOfficeAllocYtd;
	}
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_YTD_COMP_SAL;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getCompSalType());
		elements.add(this.getCompSalName());
		elements.add(this.getCompSalStaffYtd());
		elements.add(this.getCompSalContractServicesYtd());
		elements.add(this.getCompSalOfficeAllocYtd());
		elements.add(this.getCompSalTotalCostYtd());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
}
