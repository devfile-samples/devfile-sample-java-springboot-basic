package ca.bc.gov.chefs.etl.forms.ltc.staffing.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LTCStaffPlanPosType implements IModel {
	
	private String confirmationId;
	private String staffingPlanNum;
	private String staffHrsPosType;
	private String sumStaffHrsMon;
	private String sumStaffHrsTue;
	private String sumStaffHrsWed;
	private String sumStaffHrsThurs;
	private String sumStaffHrsFri;
	private String sumStaffHrsSat;
	private String sumStaffHrsSun;
	private String sumStaffHrsWkTotal;
	private String sumStaffHrsAnnual;
	
	/* Summary of Annual Hours Paid  one and only*/
	private String sumNursAnnual;
	private String sumNursInhouse;
	private String sumNursContracted;
	private String sumNursTotal;
	private String sumAlliedNpAnnual;
	private String sumAlliedNpInhouse;
	private String sumAlliedNpContracted;
	private String sumAlliedNpTotal;
	private String sumAlliedProfAnnual;
	private String sumAlliedProfInhouse;
	private String sumAlliedProfContracted;
	private String sumAlliedProfTotal;
	

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

	public String getSumNursAnnual() {
		return sumNursAnnual;
	}

	public void setSumNursAnnual(String sumNursAnnual) {
		this.sumNursAnnual = sumNursAnnual;
	}

	public String getSumNursInhouse() {
		return sumNursInhouse;
	}

	public void setSumNursInhouse(String sumNursInhouse) {
		this.sumNursInhouse = sumNursInhouse;
	}

	public String getSumNursContracted() {
		return sumNursContracted;
	}

	public void setSumNursContracted(String sumNursContracted) {
		this.sumNursContracted = sumNursContracted;
	}

	public String getSumNursTotal() {
		return sumNursTotal;
	}

	public void setSumNursTotal(String sumNursTotal) {
		this.sumNursTotal = sumNursTotal;
	}

	public String getSumAlliedNpAnnual() {
		return sumAlliedNpAnnual;
	}

	public void setSumAlliedNpAnnual(String sumAlliedNpAnnual) {
		this.sumAlliedNpAnnual = sumAlliedNpAnnual;
	}

	public String getSumAlliedNpInhouse() {
		return sumAlliedNpInhouse;
	}

	public void setSumAlliedNpInhouse(String sumAlliedNpInhouse) {
		this.sumAlliedNpInhouse = sumAlliedNpInhouse;
	}

	public String getSumAlliedNpContracted() {
		return sumAlliedNpContracted;
	}

	public void setSumAlliedNpContracted(String sumAlliedNpContracted) {
		this.sumAlliedNpContracted = sumAlliedNpContracted;
	}

	public String getSumAlliedNpTotal() {
		return sumAlliedNpTotal;
	}

	public void setSumAlliedNpTotal(String sumAlliedNpTotal) {
		this.sumAlliedNpTotal = sumAlliedNpTotal;
	}

	public String getSumAlliedProfAnnual() {
		return sumAlliedProfAnnual;
	}

	public void setSumAlliedProfAnnual(String sumAlliedProfAnnual) {
		this.sumAlliedProfAnnual = sumAlliedProfAnnual;
	}

	public String getSumAlliedProfInhouse() {
		return sumAlliedProfInhouse;
	}

	public void setSumAlliedProfInhouse(String sumAlliedProfInhouse) {
		this.sumAlliedProfInhouse = sumAlliedProfInhouse;
	}

	public String getSumAlliedProfContracted() {
		return sumAlliedProfContracted;
	}

	public void setSumAlliedProfContracted(String sumAlliedProfContracted) {
		this.sumAlliedProfContracted = sumAlliedProfContracted;
	}

	public String getSumAlliedProfTotal() {
		return sumAlliedProfTotal;
	}

	public void setSumAlliedProfTotal(String sumAlliedProfTotal) {
		this.sumAlliedProfTotal = sumAlliedProfTotal;
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
		elements.add(this.sumStaffHrsMon);
		elements.add(this.sumStaffHrsTue);
		elements.add(this.sumStaffHrsWed);
		elements.add(this.sumStaffHrsThurs);
		elements.add(this.sumStaffHrsFri);
		elements.add(this.sumStaffHrsSat);
		elements.add(this.sumStaffHrsSun);
		elements.add(this.sumStaffHrsWkTotal);
		elements.add(this.sumStaffHrsAnnual);
		elements.add(this.sumNursAnnual);
		elements.add(this.sumNursInhouse);
		elements.add(this.sumNursContracted);
		elements.add(this.sumNursTotal);
		elements.add(this.sumAlliedNpAnnual);
		elements.add(this.sumAlliedNpInhouse);
		elements.add(this.sumAlliedNpContracted);
		elements.add(this.sumAlliedNpTotal);
		elements.add(this.sumAlliedProfAnnual);
		elements.add(this.sumAlliedProfInhouse);
		elements.add(this.sumAlliedProfContracted);
		elements.add(this.sumAlliedProfTotal);
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

}
