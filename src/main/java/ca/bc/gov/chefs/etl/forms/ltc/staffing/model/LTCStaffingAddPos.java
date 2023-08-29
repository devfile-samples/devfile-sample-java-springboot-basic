package ca.bc.gov.chefs.etl.forms.ltc.staffing.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LTCStaffingAddPos implements IModel {

	/* Contracted Services Provider*/
	private String confirmationId;
	private String staffingPlanNum;
	private String staffingHrsPosType;
	private String staffHrsServiceContractOut;
	private String staffHrsLegalNameContractService;
	private String staffHoursPercentServiceContractOut;
	
	
	
	public String getConfirmationId() {
		return confirmationId;
	}

	public void setConfirmationId(String confirmationId) {
		this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
	}

	public String getStaffingPlanNum() {
		return staffingPlanNum;
	}

	public void setStaffingPlanNum(String staffingPlanNum) {
		this.staffingPlanNum = StringUtils.defaultIfEmpty(staffingPlanNum, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getStaffingHrsPosType() {
		return staffingHrsPosType;
	}

	public void setStaffingHrsPosType(String staffingHrsPosType) {
		this.staffingHrsPosType = StringUtils.defaultIfEmpty(staffingHrsPosType, Constants.DEFAULT_STRING_VALUE);
	}

	public String getStaffHrsServiceContractOut() {
		return staffHrsServiceContractOut;
	}

	public void setStaffHrsServiceContractOut(String staffHrsServiceContractOut) {
		this.staffHrsServiceContractOut = staffHrsServiceContractOut;
	}

	public String getStaffHrsLegalNameContractService() {
		return staffHrsLegalNameContractService;
	}

	public void setStaffHrsLegalNameContractService(String staffHrsLegalNameContractService) {
		this.staffHrsLegalNameContractService = StringUtils.defaultIfEmpty(staffHrsLegalNameContractService, Constants.DEFAULT_STRING_VALUE);
	}

	public String getStaffHoursPercentServiceContractOut() {
		return staffHoursPercentServiceContractOut;
	}

	public void setStaffHoursPercentServiceContractOut(String staffHoursPercentServiceContractOut) {
		this.staffHoursPercentServiceContractOut = StringUtils.defaultIfEmpty(staffHoursPercentServiceContractOut, Constants.DEFAULT_DECIMAL_VALUE);
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_STAFFING_ADD_POS;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.confirmationId);
		elements.add(this.staffingPlanNum);
		elements.add(this.staffingHrsPosType);
		elements.add(this.staffHrsServiceContractOut);
		elements.add(this.staffHrsLegalNameContractService);
		elements.add(this.staffHoursPercentServiceContractOut);
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

}
