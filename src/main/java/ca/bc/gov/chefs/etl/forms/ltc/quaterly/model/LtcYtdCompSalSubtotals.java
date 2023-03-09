package ca.bc.gov.chefs.etl.forms.ltc.quaterly.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.parser.IModel;

public class LtcYtdCompSalSubtotals implements IModel {

	private String confirmationId;
	private String compSalType;
	private String subTotalCompSalStaffYTD;
	private String subTotalCompSalContractServicesYTD;
	private String subTotalCompSalOfficeAllocYTD;
	private String subTotalCompSalTotalCostYTD;

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

	public String getSubTotalCompSalStaffYTD() {
		return subTotalCompSalStaffYTD.isBlank() ? "0" : subTotalCompSalStaffYTD;
	}

	public void setSubTotalCompSalStaffYTD(String subTotalCompSalStaffYTD) {
		this.subTotalCompSalStaffYTD = subTotalCompSalStaffYTD;
	}

	public String getSubTotalCompSalContractServicesYTD() {
		return subTotalCompSalContractServicesYTD.isBlank() ? "0" : subTotalCompSalContractServicesYTD;
	}

	public void setSubTotalCompSalContractServicesYTD(String subTotalCompSalContractServicesYTD) {
		this.subTotalCompSalContractServicesYTD = subTotalCompSalContractServicesYTD;
	}

	public String getSubTotalCompSalOfficeAllocYTD() {
		return subTotalCompSalOfficeAllocYTD.isBlank() ? "0" : subTotalCompSalOfficeAllocYTD;
	}

	public void setSubTotalCompSalOfficeAllocYTD(String subTotalCompSalOfficeAllocYTD) {
		this.subTotalCompSalOfficeAllocYTD = subTotalCompSalOfficeAllocYTD;
	}

	public String getSubTotalCompSalTotalCostYTD() {
		return subTotalCompSalTotalCostYTD.isBlank() ? "0" : subTotalCompSalTotalCostYTD;
	}

	public void setSubTotalCompSalTotalCostYTD(String subTotalCompSalTotalCostYTD) {
		this.subTotalCompSalTotalCostYTD = subTotalCompSalTotalCostYTD;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_YTD_COMP_SAL_SUBTOTALS;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.getConfirmationId());
		elements.add(this.getCompSalType());
		elements.add(this.getSubTotalCompSalStaffYTD());
		elements.add(this.getSubTotalCompSalContractServicesYTD());
		elements.add(this.getSubTotalCompSalOfficeAllocYTD());
		elements.add(this.getSubTotalCompSalTotalCostYTD());
		
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

}
