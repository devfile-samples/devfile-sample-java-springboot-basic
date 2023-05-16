package ca.bc.gov.chefs.etl.forms.ltc.staffing.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LTCStaffingPlan implements IModel{

    private String confirmationId;
    private String staffingPlanNum;
    private String staffPlanFor;
    private String periodStart;
    private String periodEnd;
    private String revisionDate;
    private String reasonForRev;
    private String nbTotalBeds;
    private String perf_4_1;
    private String perfOtherSpecify;
    private String staffPlanForOther;
    private String totalHrsNursMon;
    private String totalHrsNursTues;
    private String totalHrsNursWed;
    private String totalHrsNursThurs;
    private String totalHrsNursFri;
    private String totalHrsNursSat;
    private String totalHrsNursSun;
    private String totalHrsNursWkTotal;
    private String totalHrsNursAnnual;
    private String hprdTotalNursMon;
    private String hprdTotalNursTues;
    private String hprdTotalNursWed;
    private String hprdTotalNursThurs;
    private String hprdTotalNursFri;
    private String hprdTotalNursSat;
    private String hprdTotalNursSun;
    private String hprdTotalNursWkTotal;
    private String hprdTotalAlliedMon;
    private String hprdTotalAlliedTues;
    private String hprdTotalAlliedWed;
    private String hprdTotalAlliedThurs;
    private String hprdTotalAlliedFri;
    private String hprdTotalAlliedSat;
    private String hprdTotalAlliedSun;
    private String hprdTotalAlliedWkTotal;

    private List<LTCStaffPlanPerf> LTCStaffPlanPerf;
    private List<LTCStaffPlanPosType> LTCStaffPlanPosType;
    private List<LTCStaffingHrs> LTCStaffingHrs;
    private List<LTCStaffingAddPos> LTCStaffingAddPos;

	
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

    public String getStaffPlanFor() {
        return staffPlanFor;
    }

    public void setStaffPlanFor(String staffPlanFor) {
        this.staffPlanFor = staffPlanFor;
    }

    public String getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(String periodStart) {
        this.periodStart = periodStart;
    }

    public String getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(String periodEnd) {
        this.periodEnd = periodEnd;
    }

    public String getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(String revisionDate) {
        this.revisionDate = revisionDate;
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
        this.nbTotalBeds = nbTotalBeds;
    }

    public String getPerf_4_1() {
        return perf_4_1;
    }

    public void setPerf_4_1(String perf_4_1) {
        this.perf_4_1 = perf_4_1;
    }

    public String getPerfOtherSpecify() {
        return perfOtherSpecify;
    }

    public void setPerfOtherSpecify(String perfOtherSpecify) {
        this.perfOtherSpecify = perfOtherSpecify;
    }

    public String getStaffPlanForOther() {
        return staffPlanForOther;
    }

    public void setStaffPlanForOther(String staffPlanForOther) {
        this.staffPlanForOther = staffPlanForOther;
    }

    public String getTotalHrsNursMon() {
        return totalHrsNursMon;
    }

    public void setTotalHrsNursMon(String totalHrsNursMon) {
        this.totalHrsNursMon = totalHrsNursMon;
    }

    public String getTotalHrsNursTues() {
        return totalHrsNursTues;
    }

    public void setTotalHrsNursTues(String totalHrsNursTues) {
        this.totalHrsNursTues = totalHrsNursTues;
    }

    public String getTotalHrsNursWed() {
        return totalHrsNursWed;
    }

    public void setTotalHrsNursWed(String totalHrsNursWed) {
        this.totalHrsNursWed = totalHrsNursWed;
    }

    public String getTotalHrsNursThurs() {
        return totalHrsNursThurs;
    }

    public void setTotalHrsNursThurs(String totalHrsNursThurs) {
        this.totalHrsNursThurs = totalHrsNursThurs;
    }

    public String getTotalHrsNursFri() {
        return totalHrsNursFri;
    }

    public void setTotalHrsNursFri(String totalHrsNursFri) {
        this.totalHrsNursFri = totalHrsNursFri;
    }

    public String getTotalHrsNursSat() {
        return totalHrsNursSat;
    }

    public void setTotalHrsNursSat(String totalHrsNursSat) {
        this.totalHrsNursSat = totalHrsNursSat;
    }

    public String getTotalHrsNursSun() {
        return totalHrsNursSun;
    }

    public void setTotalHrsNursSun(String totalHrsNursSun) {
        this.totalHrsNursSun = totalHrsNursSun;
    }

    public String getTotalHrsNursWkTotal() {
        return totalHrsNursWkTotal;
    }

    public void setTotalHrsNursWkTotal(String totalHrsNursWkTotal) {
        this.totalHrsNursWkTotal = totalHrsNursWkTotal;
    }

    public String getTotalHrsNursAnnual() {
        return totalHrsNursAnnual;
    }

    public void setTotalHrsNursAnnual(String totalHrsNursAnnual) {
        this.totalHrsNursAnnual = totalHrsNursAnnual;
    }

    public String getHprdTotalNursMon() {
        return hprdTotalNursMon;
    }

    public void setHprdTotalNursMon(String hprdTotalNursMon) {
        this.hprdTotalNursMon = hprdTotalNursMon;
    }

    public String getHprdTotalNursTues() {
        return hprdTotalNursTues;
    }

    public void setHprdTotalNursTues(String hprdTotalNursTues) {
        this.hprdTotalNursTues = hprdTotalNursTues;
    }

    public String getHprdTotalNursWed() {
        return hprdTotalNursWed;
    }

    public void setHprdTotalNursWed(String hprdTotalNursWed) {
        this.hprdTotalNursWed = hprdTotalNursWed;
    }

    public String getHprdTotalNursThurs() {
        return hprdTotalNursThurs;
    }

    public void setHprdTotalNursThurs(String hprdTotalNursThurs) {
        this.hprdTotalNursThurs = hprdTotalNursThurs;
    }

    public String getHprdTotalNursFri() {
        return hprdTotalNursFri;
    }

    public void setHprdTotalNursFri(String hprdTotalNursFri) {
        this.hprdTotalNursFri = hprdTotalNursFri;
    }

    public String getHprdTotalNursSat() {
        return hprdTotalNursSat;
    }

    public void setHprdTotalNursSat(String hprdTotalNursSat) {
        this.hprdTotalNursSat = hprdTotalNursSat;
    }

    public String getHprdTotalNursSun() {
        return hprdTotalNursSun;
    }

    public void setHprdTotalNursSun(String hprdTotalNursSun) {
        this.hprdTotalNursSun = hprdTotalNursSun;
    }

    public String getHprdTotalNursWkTotal() {
        return hprdTotalNursWkTotal;
    }

    public void setHprdTotalNursWkTotal(String hprdTotalNursWkTotal) {
        this.hprdTotalNursWkTotal = hprdTotalNursWkTotal;
    }

    public String getHprdTotalAlliedMon() {
        return hprdTotalAlliedMon;
    }

    public void setHprdTotalAlliedMon(String hprdTotalAlliedMon) {
        this.hprdTotalAlliedMon = hprdTotalAlliedMon;
    }

    public String getHprdTotalAlliedTues() {
        return hprdTotalAlliedTues;
    }

    public void setHprdTotalAlliedTues(String hprdTotalAlliedTues) {
        this.hprdTotalAlliedTues = hprdTotalAlliedTues;
    }

    public String getHprdTotalAlliedWed() {
        return hprdTotalAlliedWed;
    }

    public void setHprdTotalAlliedWed(String hprdTotalAlliedWed) {
        this.hprdTotalAlliedWed = hprdTotalAlliedWed;
    }

    public String getHprdTotalAlliedThurs() {
        return hprdTotalAlliedThurs;
    }

    public void setHprdTotalAlliedThurs(String hprdTotalAlliedThurs) {
        this.hprdTotalAlliedThurs = hprdTotalAlliedThurs;
    }

    public String getHprdTotalAlliedFri() {
        return hprdTotalAlliedFri;
    }

    public void setHprdTotalAlliedFri(String hprdTotalAlliedFri) {
        this.hprdTotalAlliedFri = hprdTotalAlliedFri;
    }

    public String getHprdTotalAlliedSat() {
        return hprdTotalAlliedSat;
    }

    public void setHprdTotalAlliedSat(String hprdTotalAlliedSat) {
        this.hprdTotalAlliedSat = hprdTotalAlliedSat;
    }

    public String getHprdTotalAlliedSun() {
        return hprdTotalAlliedSun;
    }

    public void setHprdTotalAlliedSun(String hprdTotalAlliedSun) {
        this.hprdTotalAlliedSun = hprdTotalAlliedSun;
    }

    public String getHprdTotalAlliedWkTotal() {
        return hprdTotalAlliedWkTotal;
    }

    public void setHprdTotalAlliedWkTotal(String hprdTotalAlliedWkTotal) {
        this.hprdTotalAlliedWkTotal = hprdTotalAlliedWkTotal;
    }

    public List<LTCStaffPlanPerf> getLTCStaffPlanPerf() {
        return LTCStaffPlanPerf;
    }

    public void setLTCStaffPlanPerf(List<LTCStaffPlanPerf> lTCStaffPlanPerf) {
        LTCStaffPlanPerf = lTCStaffPlanPerf;
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
        elements.add(this.perf_4_1);
        elements.add(this.perfOtherSpecify);
        elements.add(this.totalHrsNursMon);
        elements.add(this.totalHrsNursTues);
        elements.add(this.totalHrsNursWed);
        elements.add(this.totalHrsNursThurs);
        elements.add(this.totalHrsNursFri);
        elements.add(this.totalHrsNursSat);
        elements.add(this.totalHrsNursSun);
        elements.add(this.totalHrsNursWkTotal);
        elements.add(this.totalHrsNursAnnual);
        elements.add(this.hprdTotalNursMon);
        elements.add(this.hprdTotalNursTues);
        elements.add(this.hprdTotalNursWed);
        elements.add(this.hprdTotalNursThurs);
        elements.add(this.hprdTotalNursFri);
        elements.add(this.hprdTotalNursSat);
        elements.add(this.hprdTotalNursSun);
        elements.add(this.hprdTotalNursWkTotal);
        elements.add(this.hprdTotalAlliedMon);
        elements.add(this.hprdTotalAlliedTues);
        elements.add(this.hprdTotalAlliedWed);
        elements.add(this.hprdTotalAlliedThurs);
        elements.add(this.hprdTotalAlliedFri);
        elements.add(this.hprdTotalAlliedSat);
        elements.add(this.hprdTotalAlliedSun);
        elements.add(this.hprdTotalAlliedWkTotal);
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
        List<IModel> ltcStaffingPlanIModels = new ArrayList<>();
        ltcStaffingPlanIModels.addAll(this.getLTCStaffPlanPerf());
        ltcStaffingPlanIModels.addAll(this.getLTCStaffPlanPosType());
        ltcStaffingPlanIModels.addAll(this.getLTCStaffingHrs());
        ltcStaffingPlanIModels.addAll(this.getLTCStaffingAddPos());
		return ltcStaffingPlanIModels;
	}

}
