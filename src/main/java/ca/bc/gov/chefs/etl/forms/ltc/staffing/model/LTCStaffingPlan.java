package ca.bc.gov.chefs.etl.forms.ltc.staffing.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class LTCStaffingPlan implements IModel{

    private String confirmationId;
    private String staffingPlanNum;
    private String staffPlanFor;
    private String periodStart;
    private String periodEnd;
    private String revisionDate;
    private String reasonForRev;
    private String nbTotalBeds;
    private String cumulative_Total_DCH_Q1;
    private String cumulative_Total_DCH_Q2;
    private String cumulative_Total_DCH_Q3;
    private String cumulative_Total_DCH_Q4;
    private String perf_4_1;
    private String staffPlanForOther;
    private String professional_Staffing_Percentage;
    private String rn_lpn_Staffing_Percentage;


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

    public String getStaffPlanFor() {
        return staffPlanFor;
    }

    public void setStaffPlanFor(String staffPlanFor) {
        this.staffPlanFor = StringUtils.defaultIfEmpty(staffPlanFor, Constants.DEFAULT_STRING_VALUE);
    }

    public String getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(String periodStart) {
        this.periodStart = CSVUtil.getFormattedDate(periodStart);
    }

    public String getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(String periodEnd) {
        this.periodEnd = CSVUtil.getFormattedDate(periodEnd);
    }

    public String getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(String revisionDate) {
        this.revisionDate = CSVUtil.getFormattedDate(revisionDate);
    }

    public String getReasonForRev() {
        return reasonForRev;
    }

    public void setReasonForRev(String reasonForRev) {
        this.reasonForRev = reasonForRev;
    }

    public String getNbTotalBeds() {
        return nbTotalBeds;
    }

    public void setNbTotalBeds(String nbTotalBeds) {
        this.nbTotalBeds = StringUtils.defaultIfEmpty(nbTotalBeds, Constants.DEFAULT_DECIMAL_VALUE);
    }

    public String getCumulative_Total_DCH_Q1() {
        return cumulative_Total_DCH_Q1;
    }

    public void setCumulative_Total_DCH_Q1(String cumulative_Total_DCH_Q1) {
        this.cumulative_Total_DCH_Q1 = cumulative_Total_DCH_Q1;
    }

    public String getCumulative_Total_DCH_Q2() {
        return cumulative_Total_DCH_Q2;
    }

    public void setCumulative_Total_DCH_Q2(String cumulative_Total_DCH_Q2) {
        this.cumulative_Total_DCH_Q2 = cumulative_Total_DCH_Q2;
    }

    public String getCumulative_Total_DCH_Q3() {
        return cumulative_Total_DCH_Q3;
    }

    public void setCumulative_Total_DCH_Q3(String cumulative_Total_DCH_Q3) {
        this.cumulative_Total_DCH_Q3 = cumulative_Total_DCH_Q3;
    }

    public String getCumulative_Total_DCH_Q4() {
        return cumulative_Total_DCH_Q4;
    }

    public void setCumulative_Total_DCH_Q4(String cumulative_Total_DCH_Q4) {
        this.cumulative_Total_DCH_Q4 = cumulative_Total_DCH_Q4;
    }

    public String getPerf_4_1() {
        return perf_4_1;
    }

    public void setPerf_4_1(String perf_4_1) {
        this.perf_4_1 = StringUtils.defaultIfEmpty(perf_4_1, Constants.DEFAULT_STRING_VALUE);
    }

    public String getStaffPlanForOther() {
        return staffPlanForOther;
    }

    public void setStaffPlanForOther(String staffPlanForOther) {
        this.staffPlanForOther = staffPlanForOther;
    }

    public String getProfessional_Staffing_Percentage() {
        return professional_Staffing_Percentage;
    }

    public void setProfessional_Staffing_Percentage(String professional_Staffing_Percentage) {
        this.professional_Staffing_Percentage = professional_Staffing_Percentage;
    }

    public String getRn_lpn_Staffing_Percentage() {
        return rn_lpn_Staffing_Percentage;
    }

    public void setRn_lpn_Staffing_Percentage(String rn_lpn_Staffing_Percentage) {
        this.rn_lpn_Staffing_Percentage = rn_lpn_Staffing_Percentage;
    }

    @Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_STAFFING_PLAN;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
        elements.add(this.confirmationId);
        elements.add(this.staffingPlanNum);
        elements.add(this.staffPlanFor);
        elements.add(this.periodStart);
        elements.add(this.periodEnd);
        elements.add(this.revisionDate);
        elements.add(this.reasonForRev);
        elements.add(this.nbTotalBeds);
        elements.add(this.cumulative_Total_DCH_Q1);
        elements.add(this.cumulative_Total_DCH_Q2);
        elements.add(this.cumulative_Total_DCH_Q3);
        elements.add(this.cumulative_Total_DCH_Q4);
        elements.add(this.perf_4_1);
        elements.add(this.staffPlanForOther);
        elements.add(this.professional_Staffing_Percentage);
        elements.add(this.rn_lpn_Staffing_Percentage);
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
        return new ArrayList<>();
	}

}
