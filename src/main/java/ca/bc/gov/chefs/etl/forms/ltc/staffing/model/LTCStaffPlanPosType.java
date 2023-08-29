package ca.bc.gov.chefs.etl.forms.ltc.staffing.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LTCStaffPlanPosType implements IModel {
	
	private String confirmationId;
	private String staffingPlanNum;
	private String staffHrsPosType;
	private String staffHrsPosOtherName;
	private String sumStaffHrsMon;
	private String sumStaffHrsTue;
	private String sumStaffHrsWed;
	private String sumStaffHrsThurs;
	private String sumStaffHrsFri;
	private String sumStaffHrsSat;
	private String sumStaffHrsSun;
	private String sumStaffHrsWkTotal;
	private String sumStaffHrsAnnual;
	private String sumPosAnnual;
	private String sumPosInhouse;
	private String sumPosContracted;

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

	public String getStaffHrsPosOtherName() {
		return staffHrsPosOtherName;
	}

	public void setStaffHrsPosOtherName(String staffHrsPosOtherName) {
		this.staffHrsPosOtherName = StringUtils.defaultIfEmpty(staffHrsPosOtherName, Constants.DEFAULT_STRING_VALUE);
	}

	public String getSumStaffHrsMon() {
		return sumStaffHrsMon;
	}

	public void setSumStaffHrsMon(String sumStaffHrsMon) {
		this.sumStaffHrsMon = StringUtils.defaultIfEmpty(sumStaffHrsMon, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getSumStaffHrsTue() {
		return sumStaffHrsTue;
	}

	public void setSumStaffHrsTue(String sumStaffHrsTue) {
		this.sumStaffHrsTue = StringUtils.defaultIfEmpty(sumStaffHrsTue, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getSumStaffHrsWed() {
		return sumStaffHrsWed;
	}

	public void setSumStaffHrsWed(String sumStaffHrsWed) {
		this.sumStaffHrsWed = StringUtils.defaultIfEmpty(sumStaffHrsWed, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getSumStaffHrsThurs() {
		return sumStaffHrsThurs;
	}

	public void setSumStaffHrsThurs(String sumStaffHrsThurs) {
		this.sumStaffHrsThurs = StringUtils.defaultIfEmpty(sumStaffHrsThurs, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getSumStaffHrsFri() {
		return sumStaffHrsFri;
	}

	public void setSumStaffHrsFri(String sumStaffHrsFri) {
		this.sumStaffHrsFri = StringUtils.defaultIfEmpty(sumStaffHrsFri, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getSumStaffHrsSat() {
		return sumStaffHrsSat;
	}

	public void setSumStaffHrsSat(String sumStaffHrsSat) {
		this.sumStaffHrsSat = StringUtils.defaultIfEmpty(sumStaffHrsSat, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getSumStaffHrsSun() {
		return sumStaffHrsSun;
	}

	public void setSumStaffHrsSun(String sumStaffHrsSun) {
		this.sumStaffHrsSun = StringUtils.defaultIfEmpty(sumStaffHrsSun, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getSumStaffHrsWkTotal() {
		return sumStaffHrsWkTotal;
	}

	public void setSumStaffHrsWkTotal(String sumStaffHrsWkTotal) {
		this.sumStaffHrsWkTotal = sumStaffHrsWkTotal;
	}

	public String getSumStaffHrsAnnual() {
		return sumStaffHrsAnnual;
	}

	public void setSumStaffHrsAnnual(String sumStaffHrsAnnual) {
		this.sumStaffHrsAnnual = sumStaffHrsAnnual;
	}

	public String getSumPosAnnual() {
		return sumPosAnnual;
	}

	public void setSumPosAnnual(String sumPosAnnual) {
		this.sumPosAnnual = sumPosAnnual;
	}

	public String getSumPosInhouse() {
		return sumPosInhouse;
	}

	public void setSumPosInhouse(String sumPosInhouse) {
		this.sumPosInhouse = sumPosInhouse;
	}

	public String getSumPosContracted() {
		return sumPosContracted;
	}

	public void setSumPosContracted(String sumPosContracted) {
		this.sumPosContracted = sumPosContracted;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_STAFF_PLAN_POS_TYPE;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.confirmationId);
		elements.add(this.staffingPlanNum);
		elements.add(this.staffHrsPosType);
		elements.add(this.staffHrsPosOtherName);
		elements.add(this.sumStaffHrsMon);
		elements.add(this.sumStaffHrsTue);
		elements.add(this.sumStaffHrsWed);
		elements.add(this.sumStaffHrsThurs);
		elements.add(this.sumStaffHrsFri);
		elements.add(this.sumStaffHrsSat);
		elements.add(this.sumStaffHrsSun);
		elements.add(this.sumStaffHrsWkTotal);
		elements.add(this.sumStaffHrsAnnual);
		elements.add(this.sumPosAnnual);
		elements.add(this.sumPosInhouse);
		elements.add(this.sumPosContracted);
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

}
