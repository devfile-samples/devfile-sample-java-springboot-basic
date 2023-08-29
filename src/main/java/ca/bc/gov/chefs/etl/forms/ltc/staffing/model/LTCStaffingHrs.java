package ca.bc.gov.chefs.etl.forms.ltc.staffing.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LTCStaffingHrs implements IModel{
	
	private String confirmationId;
	private String staffingPlanNum;
	private String staffHrsPosType;
	private String staffHrsPosShiftType;
	private String staffHrsMon;
	private String staffHrsTue;
	private String staffHrsWed;
	private String staffHrsThurs;
	private String staffHrsFri;
	private String staffHrsSat;
	private String staffHrsSun;
	private String staffHrsWkTotal;
	private String staffHrsAnnual;

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

	public String getStaffHrsPosType() {
		return staffHrsPosType;
	}

	public void setStaffHrsPosType(String staffHrsPosType) {
		this.staffHrsPosType = StringUtils.defaultIfEmpty(staffHrsPosType, Constants.DEFAULT_STRING_VALUE);
	}

	public String getStaffHrsPosShiftType() {
		return staffHrsPosShiftType;
	}

	public void setStaffHrsPosShiftType(String staffHrsPosShiftType) {
		this.staffHrsPosShiftType = StringUtils.defaultIfEmpty(staffHrsPosShiftType, Constants.DEFAULT_STRING_VALUE);
	}

	public String getStaffHrsMon() {
		return staffHrsMon;
	}

	public void setStaffHrsMon(String staffHrsMon) {
		this.staffHrsMon = StringUtils.defaultIfEmpty(staffHrsMon, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getStaffHrsTue() {
		return staffHrsTue;
	}

	public void setStaffHrsTue(String staffHrsTue) {
		this.staffHrsTue = StringUtils.defaultIfEmpty(staffHrsTue, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getStaffHrsWed() {
		return staffHrsWed;
	}

	public void setStaffHrsWed(String staffHrsWed) {
		this.staffHrsWed = StringUtils.defaultIfEmpty(staffHrsWed, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getStaffHrsThurs() {
		return staffHrsThurs;
	}

	public void setStaffHrsThurs(String staffHrsThurs) {
		this.staffHrsThurs = StringUtils.defaultIfEmpty(staffHrsThurs, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getStaffHrsFri() {
		return staffHrsFri;
	}

	public void setStaffHrsFri(String staffHrsFri) {
		this.staffHrsFri = StringUtils.defaultIfEmpty(staffHrsFri, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getStaffHrsSat() {
		return staffHrsSat;
	}

	public void setStaffHrsSat(String staffHrsSat) {
		this.staffHrsSat = StringUtils.defaultIfEmpty(staffHrsSat, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getStaffHrsSun() {
		return staffHrsSun;
	}

	public void setStaffHrsSun(String staffHrsSun) {
		this.staffHrsSun = StringUtils.defaultIfEmpty(staffHrsSun, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getStaffHrsWkTotal() {
		return staffHrsWkTotal;
	}

	public void setStaffHrsWkTotal(String staffHrsWkTotal) {
		this.staffHrsWkTotal = staffHrsWkTotal;
	}

	public String getStaffHrsAnnual() {
		return staffHrsAnnual;
	}

	public void setStaffHrsAnnual(String staffHrsAnnual) {
		this.staffHrsAnnual = staffHrsAnnual;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_STAFFING_HRS;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.confirmationId);
		elements.add(this.staffingPlanNum);
		elements.add(this.staffHrsPosType);
		elements.add(this.staffHrsPosShiftType);
		elements.add(this.staffHrsMon);
		elements.add(this.staffHrsTue);
		elements.add(this.staffHrsWed);
		elements.add(this.staffHrsThurs);
		elements.add(this.staffHrsFri);
		elements.add(this.staffHrsSat);
		elements.add(this.staffHrsSun);
		elements.add(this.staffHrsWkTotal);
		elements.add(this.staffHrsAnnual);
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

}
