package ca.bc.gov.chefs.etl.forms.ltc.staffing.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class LTCStaffingSubmission implements IModel{

	private String confirmationId;
	private String isDeleted;
	private String submissionDate;
	private String submittedBy;
	private String CCIMSID;
	private String submission_FY;

    private List<LTCStaffingPlan> LTCStaffingPlan;
    private List<LTCStaffPlanPerf> LTCStaffPlanPerf;
    private List<LTCStaffPlanPosSubtotal> LTCStaffPlanPosSubtotal;
    private List<LTCStaffPlanPosType> LTCStaffPlanPosType;
    private List<LTCStaffingHrs> LTCStaffingHrs;
    private List<LTCStaffingAddPos> LTCStaffingAddPos;
    private List<LTCStaffPlanSummarySubtotals> LTCStaffPlanSummarySubtotals;

    public String getConfirmationId() {
        return confirmationId;
    }

    public void setConfirmationId(String confirmationId) {
        this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = StringUtils.defaultIfEmpty(isDeleted, Constants.DEFAULT_STRING_VALUE);
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = CSVUtil.getFormattedDate(submissionDate);
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getCCIMSID() {
        return CCIMSID;
    }

    public void setCCIMSID(String cCIMSID) {
        CCIMSID = StringUtils.defaultIfEmpty(cCIMSID, Constants.DEFAULT_STRING_VALUE);
    }

    public String getSubmission_FY() {
        return submission_FY;
    }

    public void setSubmission_FY(String submission_FY) {
        this.submission_FY = StringUtils.defaultIfEmpty(submission_FY, Constants.DEFAULT_STRING_VALUE);
    }

    public List<LTCStaffingPlan> getLTCStaffingPlan() {
        return LTCStaffingPlan;
    }

    public void setLTCStaffingPlan(List<LTCStaffingPlan> lTCStaffingPlan) {
        LTCStaffingPlan = lTCStaffingPlan;
    }

    public List<LTCStaffPlanPerf> getLTCStaffPlanPerf() {
        return LTCStaffPlanPerf;
    }

    public void setLTCStaffPlanPerf(List<LTCStaffPlanPerf> lTCStaffPlanPerf) {
        LTCStaffPlanPerf = lTCStaffPlanPerf;
    }

    public List<LTCStaffPlanPosSubtotal> getLTCStaffPlanPosSubtotal() {
        return LTCStaffPlanPosSubtotal;
    }

    public void setLTCStaffPlanPosSubtotal(List<LTCStaffPlanPosSubtotal> lTCStaffPlanPosSubtotal) {
        LTCStaffPlanPosSubtotal = lTCStaffPlanPosSubtotal;
    }

    public List<LTCStaffPlanPosType> getLTCStaffPlanPosType() {
        return LTCStaffPlanPosType;
    }

    public void setLTCStaffPlanPosType(List<LTCStaffPlanPosType> lTCStaffPlanPosType) {
        LTCStaffPlanPosType = lTCStaffPlanPosType;
    }

    public List<LTCStaffingHrs> getLTCStaffingHrs() {
        return LTCStaffingHrs;
    }

    public void setLTCStaffingHrs(List<LTCStaffingHrs> lTCStaffingHrs) {
        LTCStaffingHrs = lTCStaffingHrs;
    }

    public List<LTCStaffingAddPos> getLTCStaffingAddPos() {
        return LTCStaffingAddPos;
    }

    public void setLTCStaffingAddPos(List<LTCStaffingAddPos> lTCStaffingAddPos) {
        LTCStaffingAddPos = lTCStaffingAddPos;
    }

    public List<LTCStaffPlanSummarySubtotals> getLTCStaffPlanSummarySubtotals() {
        return LTCStaffPlanSummarySubtotals;
    }

    public void setLTCStaffPlanSummarySubtotals(List<LTCStaffPlanSummarySubtotals> lTCStaffPlanSummarySubtotals) {
        LTCStaffPlanSummarySubtotals = lTCStaffPlanSummarySubtotals;
    }

    @Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_STAFFING_SUBMISSION;
	}

	@Override
	public List<String> getCsvElements() {
        List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getIsDeleted());
		elements.add(this.getSubmissionDate());
		elements.add(this.getSubmittedBy());
		elements.add(this.getCCIMSID());
		elements.add(this.getSubmission_FY());
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
        List<IModel> ltcStaffingPlanIModels = new ArrayList<>();
        ltcStaffingPlanIModels.addAll(this.getLTCStaffingPlan());
        ltcStaffingPlanIModels.addAll(this.getLTCStaffPlanPerf());
        ltcStaffingPlanIModels.addAll(this.getLTCStaffPlanPosSubtotal());
        ltcStaffingPlanIModels.addAll(this.getLTCStaffPlanPosType());
        ltcStaffingPlanIModels.addAll(this.getLTCStaffingHrs());
        ltcStaffingPlanIModels.addAll(this.getLTCStaffingAddPos());
        ltcStaffingPlanIModels.addAll(this.getLTCStaffPlanSummarySubtotals());
		return ltcStaffingPlanIModels;
	}

}
