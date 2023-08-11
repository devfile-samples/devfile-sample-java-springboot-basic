package ca.bc.gov.chefs.etl.forms.ltc.staffing.model;

import java.util.ArrayList;
import java.util.List;

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

	public String getConfirmationId() {
		return confirmationId;
	}

	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}

	public String getStaffingPlanNum() {
		return staffingPlanNum;
	}

	public void setStaffingPlanNum(String staffingPlanNum) {
		this.staffingPlanNum = staffingPlanNum;
	}

	public String getStaffHrsPosType() {
		return staffHrsPosType;
	}

	public void setStaffHrsPosType(String staffHrsPosType) {
		this.staffHrsPosType = staffHrsPosType;
	}

	public String getStaffHrsPosOtherName() {
		return staffHrsPosOtherName;
	}

	public void setStaffHrsPosOtherName(String staffHrsPosOtherName) {
		this.staffHrsPosOtherName = staffHrsPosOtherName;
	}

	public String getSumStaffHrsMon() {
		return sumStaffHrsMon;
	}

	public void setSumStaffHrsMon(String sumStaffHrsMon) {
		this.sumStaffHrsMon = sumStaffHrsMon;
	}

	public String getSumStaffHrsTue() {
		return sumStaffHrsTue;
	}

	public void setSumStaffHrsTue(String sumStaffHrsTue) {
		this.sumStaffHrsTue = sumStaffHrsTue;
	}

	public String getSumStaffHrsWed() {
		return sumStaffHrsWed;
	}

	public void setSumStaffHrsWed(String sumStaffHrsWed) {
		this.sumStaffHrsWed = sumStaffHrsWed;
	}

	public String getSumStaffHrsThurs() {
		return sumStaffHrsThurs;
	}

	public void setSumStaffHrsThurs(String sumStaffHrsThurs) {
		this.sumStaffHrsThurs = sumStaffHrsThurs;
	}

	public String getSumStaffHrsFri() {
		return sumStaffHrsFri;
	}

	public void setSumStaffHrsFri(String sumStaffHrsFri) {
		this.sumStaffHrsFri = sumStaffHrsFri;
	}

	public String getSumStaffHrsSat() {
		return sumStaffHrsSat;
	}

	public void setSumStaffHrsSat(String sumStaffHrsSat) {
		this.sumStaffHrsSat = sumStaffHrsSat;
	}

	public String getSumStaffHrsSun() {
		return sumStaffHrsSun;
	}

	public void setSumStaffHrsSun(String sumStaffHrsSun) {
		this.sumStaffHrsSun = sumStaffHrsSun;
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
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

}
