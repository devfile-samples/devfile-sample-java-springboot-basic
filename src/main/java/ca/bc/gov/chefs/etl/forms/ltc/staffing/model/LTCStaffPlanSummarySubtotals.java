package ca.bc.gov.chefs.etl.forms.ltc.staffing.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LTCStaffPlanSummarySubtotals implements IModel {

	/* Contracted Services Provider*/
	private String confirmationId;
	private String staffingPlanNum;
	private String staffPlanSumSubtotalType;
	private String sumPosAnnual;
	private String sumPosInHouse;
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

	public String getStaffPlanSumSubtotalType() {
		return staffPlanSumSubtotalType;
	}

	public void setStaffPlanSumSubtotalType(String staffPlanSumSubtotalType) {
		this.staffPlanSumSubtotalType = StringUtils.defaultIfEmpty(staffPlanSumSubtotalType, Constants.DEFAULT_STRING_VALUE);
	}

	public String getSumPosAnnual() {
		return sumPosAnnual;
	}

	public void setSumPosAnnual(String sumPosAnnual) {
		this.sumPosAnnual = sumPosAnnual;
	}

	public String getSumPosInHouse() {
		return sumPosInHouse;
	}

	public void setSumPosInHouse(String sumPosInHouse) {
		this.sumPosInHouse = sumPosInHouse;
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
		return Constants.LTC_STAFF_PLAN_SUM_SUBTOTALS;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.confirmationId);
		elements.add(this.staffingPlanNum);
		elements.add(this.staffPlanSumSubtotalType);
		elements.add(this.sumPosAnnual);
		elements.add(this.sumPosInHouse);
		elements.add(this.sumPosContracted);
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

}
