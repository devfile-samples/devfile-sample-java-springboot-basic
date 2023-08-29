package ca.bc.gov.chefs.etl.forms.ltc.staffing.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LTCStaffPlanPosSubtotal implements IModel{

	private String confirmationId;
	private String staffingPlanNum;
	private String staffingType;
	private String sumHrsMon;
	private String sumHrsTue;
	private String sumHrsWed;
	private String sumHrsThu;
	private String sumHrsFri;
	private String sumHrsSat;
	private String sumHrsSun;
	private String sumHrsWeekTotal;
	private String sumHrsAnnual;

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

    public String getStaffingType() {
        return staffingType;
    }

    public void setStaffingType(String staffingType) {
        this.staffingType = StringUtils.defaultIfEmpty(staffingType, Constants.DEFAULT_STRING_VALUE);
    }

    public String getSumHrsMon() {
        return sumHrsMon;
    }

    public void setSumHrsMon(String sumHrsMon) {
        this.sumHrsMon = sumHrsMon;
    }

    public String getSumHrsTue() {
        return sumHrsTue;
    }

    public void setSumHrsTue(String sumHrsTue) {
        this.sumHrsTue = sumHrsTue;
    }

    public String getSumHrsWed() {
        return sumHrsWed;
    }

    public void setSumHrsWed(String sumHrsWed) {
        this.sumHrsWed = sumHrsWed;
    }

    public String getSumHrsThu() {
        return sumHrsThu;
    }

    public void setSumHrsThu(String sumHrsThu) {
        this.sumHrsThu = sumHrsThu;
    }

    public String getSumHrsFri() {
        return sumHrsFri;
    }

    public void setSumHrsFri(String sumHrsFri) {
        this.sumHrsFri = sumHrsFri;
    }

    public String getSumHrsSat() {
        return sumHrsSat;
    }

    public void setSumHrsSat(String sumHrsSat) {
        this.sumHrsSat = sumHrsSat;
    }

    public String getSumHrsSun() {
        return sumHrsSun;
    }

    public void setSumHrsSun(String sumHrsSun) {
        this.sumHrsSun = sumHrsSun;
    }

    public String getSumHrsWeekTotal() {
        return sumHrsWeekTotal;
    }

    public void setSumHrsWeekTotal(String sumHrsWeekTotal) {
        this.sumHrsWeekTotal = sumHrsWeekTotal;
    }

    public String getSumHrsAnnual() {
        return sumHrsAnnual;
    }

    public void setSumHrsAnnual(String sumHrsAnnual) {
        this.sumHrsAnnual = sumHrsAnnual;
    }

    @Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_STAFF_PLAN_POS_SUBTOTALS;
	}

	@Override
	public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getStaffingPlanNum());
		elements.add(this.getStaffingType());
		elements.add(this.getSumHrsMon());
		elements.add(this.getSumHrsTue());
		elements.add(this.getSumHrsWed());
		elements.add(this.getSumHrsThu());
		elements.add(this.getSumHrsFri());
		elements.add(this.getSumHrsSat());
		elements.add(this.getSumHrsSun());
		elements.add(this.getSumHrsWeekTotal());
		elements.add(this.getSumHrsAnnual());
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
        return new ArrayList<>();
	}

}
