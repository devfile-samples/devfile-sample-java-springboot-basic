package ca.bc.gov.chefs.etl.forms.ltc.staffing.model;
//package ca.bc.gov.chefs.etl.forms.ltc.staffing;
//
//import java.util.ArrayList;
//
//import java.util.List;
//import java.util.Map;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//import ca.bc.gov.chefs.etl.parser.IModel;
//
//public class LTCStaffingPlan implements IModel{
//	
//	/* data which occurs only one*/
//	private String confirmationId;
//	private String staffingPlanNum; // sequential not captured by json
//	private String staffPlanFor;
//	private String periodStart;
//	private String periodEnd;
//	private String revisionDate;
//	private String reasonForRev;
//	private String nbTotalBeds;
//	/* ends */
//	
//	/* 4.1, 4.2 */
//	private String perfIndicator;
//	private String perfOtherSpecify;
//	private String staffPlanForOther;
//	/* 4.3 */
//	
//	/* Total Scheduled Hours (Prof and Non Prof) */
//	private String totalHrsNursMon;
//	private String totalHrsNursTue;
//	private String totalHrsNursWed;
//	private String totalHrsNursThurs;
//	private String totalHrsNursFri;
//	private String totalHrsNursSat;
//	private String totalHrsNursSun;
//	private String totalHrsNursWkTotal;
//	private String totalHrsNursAnnual;
//	
//	/* main page nursing, allied and total, occurs once.*/
//	private String hprdTotalNursMon;
//	private String hprdTotalNursTues;
//	private String hprdTotalNursWed;
//	private String hprdTotalNursThurs;
//	private String hprdTotalNursFri;
//	private String hprdTotalNursSat;
//	private String hprdTotalNursSun;
//	private String hprdTotalNursWkTotal;
//	private String hprdTotalAlliedMon;
//	private String hprdTotalAlliedTues;
//	private String hprdTotalAlliedWed;
//	private String hprdTotalAlliedThurs;
//	private String hprdTotalAlliedFri;
//	private String hprdTotalAlliedSat;
//	private String hprdTotalAlliedSun;
//	private String hprdTotalAlliedWkTotal;
//	
//	/* Scheduled Worked Hours By Position type */
//	private List<LTCStaffingHrs> ltcStaffingHours = new ArrayList<>();
//	
//	/* Additional Position Type Information */
//	private List<LTCStaffingAddPos> ltcStaffingAddPos;
//	
//	
//	@JsonProperty("dataGrid")
//	private void unpackDataGrid(Map<String,Object>[] maps) {
//		for(Map<String,Object> map : maps) {
//			/* Considering NP */
//			Map<String,Object> np = (Map<String,Object>) map.get("np");
//			/* days evenings and nights */
//			LTCStaffingHrs ltcRnDay = new LTCStaffingHrs();
//			ltcRnDay.setConfirmationId(this.confirmationId);
//			ltcRnDay.setStaffHrsPosType("rn");
//			ltcRnDay.setStaffHrsPosShiftType("day");
//			ltcRnDay.setStaffHrsMon((String) np.get("rn_day_mon"));
//			ltcRnDay.setStaffHrsTue((String) np.get("rn_day_tue"));
//			ltcRnDay.setStaffHrsWed((String) np.get("rn_day_wed"));
//			ltcRnDay.setStaffHrsThurs((String) np.get("rn_day_thurs"));
//			ltcRnDay.setStaffHrsFri((String) np.get("rn_day_fri"));
//			ltcRnDay.setStaffHrsSat((String) np.get("rn_day_sat"));
//			ltcRnDay.setStaffHrsSun((String) np.get("rn_day_sun"));
//			ltcRnDay.setStaffHrsWkTotal((String) np.get("rn_day_total_week"));
//			ltcRnDay.setStaffHrsAnnual((String) np.get("rn_day_total_annual"));
//			
//			LTCStaffingHrs ltcRnEvening = new LTCStaffingHrs();
//			ltcRnEvening.setStaffHrsPosType("rn");
//			ltcRnEvening.setStaffHrsPosShiftType("eve");
//			ltcRnEvening.setStaffHrsMon((String) np.get("rn_eve_mon"));
//			ltcRnEvening.setConfirmationId(this.confirmationId);
//			ltcRnEvening.setStaffHrsMon((String) np.get("rn_eve_mon"));
//			ltcRnEvening.setStaffHrsTue((String) np.get("rn_eve_tue"));
//			ltcRnEvening.setStaffHrsWed((String) np.get("rn_eve_wed"));
//			ltcRnEvening.setStaffHrsThurs((String) np.get("rn_eve_thurs"));
//			ltcRnEvening.setStaffHrsFri((String) np.get("rn_eve_fri"));
//			ltcRnEvening.setStaffHrsSat((String) np.get("rn_eve_sat"));
//			ltcRnEvening.setStaffHrsSun((String) np.get("rn_eve_sun"));
//			ltcRnEvening.setStaffHrsWkTotal((String) np.get("rn_eve_total_week"));
//			ltcRnEvening.setStaffHrsAnnual((String) np.get("rn_eve_total_annual"));
//			
//			LTCStaffingHrs ltcRnNight = new LTCStaffingHrs();
//			ltcRnNight.setConfirmationId(this.confirmationId);
//			ltcRnNight.setStaffHrsPosType("rn");
//			ltcRnNight.setStaffHrsPosShiftType("night");
//			ltcRnNight.setStaffHrsMon((String) np.get("rn_night_mon"));
//			ltcRnNight.setStaffHrsTue((String) np.get("rn_night_tue"));
//			ltcRnNight.setStaffHrsWed((String) np.get("rn_night_wed"));
//			ltcRnNight.setStaffHrsThurs((String) np.get("rn_night_thurs"));
//			ltcRnNight.setStaffHrsFri((String) np.get("rn_night_fri"));
//			ltcRnNight.setStaffHrsSat((String) np.get("rn_night_sat"));
//			ltcRnNight.setStaffHrsSun((String) np.get("rn_night_sun"));
//			ltcRnNight.setStaffHrsWkTotal((String) np.get("rn_night_total_week"));
//			ltcRnNight.setStaffHrsAnnual((String) np.get("rn_night_total_annual"));
//			
//			
//			/* Allied Professional */
//			LTCStaffingHrs allOcTherapist = new LTCStaffingHrs();
//			allOcTherapist.setConfirmationId(this.confirmationId);
//			allOcTherapist.setStaffHrsPosType("ot");
//			//allOcTherapist.setStaffHrsPosShiftType("night");
//			allOcTherapist.setStaffHrsMon((String) np.get("ald_ot_mon"));
//			allOcTherapist.setStaffHrsTue((String) np.get("ald_ot_tue"));
//			allOcTherapist.setStaffHrsWed((String) np.get("ald_ot_wed"));
//			allOcTherapist.setStaffHrsThurs((String) np.get("ald_ot_thurs"));
//			allOcTherapist.setStaffHrsFri((String) np.get("ald_ot_fri"));
//			allOcTherapist.setStaffHrsSat((String) np.get("ald_ot_sat"));
//			allOcTherapist.setStaffHrsSun((String) np.get("ald_ot_sun"));
//			allOcTherapist.setStaffHrsWkTotal((String) np.get("ald_ot_total_week"));
//			allOcTherapist.setStaffHrsAnnual((String) np.get("ald_ot_total_annual"));
//			
//			LTCStaffingHrs allPhysiotherapist = new LTCStaffingHrs();
//			allPhysiotherapist.setConfirmationId(this.confirmationId);
//			allPhysiotherapist.setStaffHrsPosType("dt");
//			//allOcTherapist.setStaffHrsPosShiftType("night");
//			allPhysiotherapist.setStaffHrsMon((String) np.get("ald_dt_mon"));
//			allPhysiotherapist.setStaffHrsTue((String) np.get("ald_dt_tue"));
//			allPhysiotherapist.setStaffHrsWed((String) np.get("ald_dt_wed"));
//			allPhysiotherapist.setStaffHrsThurs((String) np.get("ald_dt_thurs"));
//			allPhysiotherapist.setStaffHrsFri((String) np.get("ald_dt_fri"));
//			allPhysiotherapist.setStaffHrsSat((String) np.get("ald_dt_sat"));
//			allPhysiotherapist.setStaffHrsSun((String) np.get("ald_dt_sun"));
//			allPhysiotherapist.setStaffHrsWkTotal((String) np.get("ald_dt_total_week"));
//			allPhysiotherapist.setStaffHrsAnnual((String) np.get("ald_dt_total_annual"));
//			
//			LTCStaffingHrs allDietician = new LTCStaffingHrs();
//			allDietician.setConfirmationId(this.confirmationId);
//			allDietician.setStaffHrsPosType("dt");
//			//allOcTherapist.setStaffHrsPosShiftType("night");
//			allDietician.setStaffHrsMon((String) np.get("ald_dt_mon"));
//			allDietician.setStaffHrsTue((String) np.get("ald_dt_tue"));
//			allDietician.setStaffHrsWed((String) np.get("ald_dt_wed"));
//			allDietician.setStaffHrsThurs((String) np.get("ald_dt_thurs"));
//			allDietician.setStaffHrsFri((String) np.get("ald_dt_fri"));
//			allDietician.setStaffHrsSat((String) np.get("ald_dt_sat"));
//			allDietician.setStaffHrsSun((String) np.get("ald_dt_sun"));
//			allDietician.setStaffHrsWkTotal((String) np.get("ald_dt_total_week"));
//			allDietician.setStaffHrsAnnual((String) np.get("ald_dt_total_annual"));
//			
//			LTCStaffingHrs allSocialWorker = new LTCStaffingHrs();
//			allSocialWorker.setConfirmationId(this.confirmationId);
//			allSocialWorker.setStaffHrsPosType("sw");
//			//allOcTherapist.setStaffHrsPosShiftType("night");
//			allSocialWorker.setStaffHrsMon((String) np.get("ald_sw_mon"));
//			allSocialWorker.setStaffHrsTue((String) np.get("ald_sw_tue"));
//			allSocialWorker.setStaffHrsWed((String) np.get("ald_sw_wed"));
//			allSocialWorker.setStaffHrsThurs((String) np.get("ald_sw_thurs"));
//			allSocialWorker.setStaffHrsFri((String) np.get("ald_sw_fri"));
//			allSocialWorker.setStaffHrsSat((String) np.get("ald_sw_sat"));
//			allSocialWorker.setStaffHrsSun((String) np.get("ald_sw_sun"));
//			allSocialWorker.setStaffHrsWkTotal((String) np.get("ald_sw_total_week"));
//			allSocialWorker.setStaffHrsAnnual((String) np.get("ald_sw_total_annual"));
//			
//			
//			LTCStaffingHrs allSpeechPath = new LTCStaffingHrs();
//			allSpeechPath.setConfirmationId(this.confirmationId);
//			allSpeechPath.setStaffHrsPosType("sw");
//			//allOcTherapist.setStaffHrsPosShiftType("night");
//			allSpeechPath.setStaffHrsMon((String) np.get("ald_sw_mon"));
//			allSpeechPath.setStaffHrsTue((String) np.get("ald_sw_tue"));
//			allSpeechPath.setStaffHrsWed((String) np.get("ald_sw_wed"));
//			allSpeechPath.setStaffHrsThurs((String) np.get("ald_sw_thurs"));
//			allSpeechPath.setStaffHrsFri((String) np.get("ald_sw_fri"));
//			allSpeechPath.setStaffHrsSat((String) np.get("ald_sw_sat"));
//			allSpeechPath.setStaffHrsSun((String) np.get("ald_sw_sun"));
//			allSpeechPath.setStaffHrsWkTotal((String) np.get("ald_sw_total_week"));
//			allSpeechPath.setStaffHrsAnnual((String) np.get("ald_sw_total_annual"));
//			
//			
//			
//			
//			
//		}
//	}
//
//	public List<LTCStaffingAddPos> getLtcStaffingAddPos() {
//		return ltcStaffingAddPos;
//	}
//
//	public void setLtcStaffingAddPos(List<LTCStaffingAddPos> ltcStaffingAddPos) {
//		this.ltcStaffingAddPos = ltcStaffingAddPos;
//	}
//
//	public String getConfirmationId() {
//		return confirmationId;
//	}
//
//	public void setConfirmationId(String confirmationId) {
//		this.confirmationId = confirmationId;
//	}
//
//	public String getStaffingPlanNum() {
//		return staffingPlanNum;
//	}
//
//	public void setStaffingPlanNum(String staffingPlanNum) {
//		this.staffingPlanNum = staffingPlanNum;
//	}
//
//	public String getStaffPlanFor() {
//		return staffPlanFor;
//	}
//
//	public void setStaffPlanFor(String staffPlanFor) {
//		this.staffPlanFor = staffPlanFor;
//	}
//
//	public String getPeriodStart() {
//		return periodStart;
//	}
//
//	public void setPeriodStart(String periodStart) {
//		this.periodStart = periodStart;
//	}
//
//	public String getPeriodEnd() {
//		return periodEnd;
//	}
//
//	public void setPeriodEnd(String periodEnd) {
//		this.periodEnd = periodEnd;
//	}
//
//	public String getRevisionDate() {
//		return revisionDate;
//	}
//
//	public void setRevisionDate(String revisionDate) {
//		this.revisionDate = revisionDate;
//	}
//
//	public String getReasonForRev() {
//		return reasonForRev;
//	}
//
//	public void setReasonForRev(String reasonForRev) {
//		this.reasonForRev = reasonForRev;
//	}
//
//	public String getNbTotalBeds() {
//		return nbTotalBeds;
//	}
//
//	public void setNbTotalBeds(String nbTotalBeds) {
//		this.nbTotalBeds = nbTotalBeds;
//	}
//
//	public String getPerfIndicator() {
//		return perfIndicator;
//	}
//
//	public void setPerfIndicator(String perfIndicator) {
//		this.perfIndicator = perfIndicator;
//	}
//
//	public String getPerfOtherSpecify() {
//		return perfOtherSpecify;
//	}
//
//	public void setPerfOtherSpecify(String perfOtherSpecify) {
//		this.perfOtherSpecify = perfOtherSpecify;
//	}
//
//	public String getStaffPlanForOther() {
//		return staffPlanForOther;
//	}
//
//	public void setStaffPlanForOther(String staffPlanForOther) {
//		this.staffPlanForOther = staffPlanForOther;
//	}
//
//	public String getTotalHrsNursMon() {
//		return totalHrsNursMon;
//	}
//
//	public void setTotalHrsNursMon(String totalHrsNursMon) {
//		this.totalHrsNursMon = totalHrsNursMon;
//	}
//
//	public String getTotalHrsNursTue() {
//		return totalHrsNursTue;
//	}
//
//	public void setTotalHrsNursTue(String totalHrsNursTue) {
//		this.totalHrsNursTue = totalHrsNursTue;
//	}
//
//	public String getTotalHrsNursWed() {
//		return totalHrsNursWed;
//	}
//
//	public void setTotalHrsNursWed(String totalHrsNursWed) {
//		this.totalHrsNursWed = totalHrsNursWed;
//	}
//
//	public String getTotalHrsNursThurs() {
//		return totalHrsNursThurs;
//	}
//
//	public void setTotalHrsNursThurs(String totalHrsNursThurs) {
//		this.totalHrsNursThurs = totalHrsNursThurs;
//	}
//
//	public String getTotalHrsNursFri() {
//		return totalHrsNursFri;
//	}
//
//	public void setTotalHrsNursFri(String totalHrsNursFri) {
//		this.totalHrsNursFri = totalHrsNursFri;
//	}
//
//	public String getTotalHrsNursSat() {
//		return totalHrsNursSat;
//	}
//
//	public void setTotalHrsNursSat(String totalHrsNursSat) {
//		this.totalHrsNursSat = totalHrsNursSat;
//	}
//
//	public String getTotalHrsNursSun() {
//		return totalHrsNursSun;
//	}
//
//	public void setTotalHrsNursSun(String totalHrsNursSun) {
//		this.totalHrsNursSun = totalHrsNursSun;
//	}
//
//	public String getTotalHrsNursWkTotal() {
//		return totalHrsNursWkTotal;
//	}
//
//	public void setTotalHrsNursWkTotal(String totalHrsNursWkTotal) {
//		this.totalHrsNursWkTotal = totalHrsNursWkTotal;
//	}
//
//	public String getTotalHrsNursAnnual() {
//		return totalHrsNursAnnual;
//	}
//
//	public void setTotalHrsNursAnnual(String totalHrsNursAnnual) {
//		this.totalHrsNursAnnual = totalHrsNursAnnual;
//	}
//
//	public String getHprdTotalNursMon() {
//		return hprdTotalNursMon;
//	}
//
//	public void setHprdTotalNursMon(String hprdTotalNursMon) {
//		this.hprdTotalNursMon = hprdTotalNursMon;
//	}
//
//	public String getHprdTotalNursTues() {
//		return hprdTotalNursTues;
//	}
//
//	public void setHprdTotalNursTues(String hprdTotalNursTues) {
//		this.hprdTotalNursTues = hprdTotalNursTues;
//	}
//
//	public String getHprdTotalNursWed() {
//		return hprdTotalNursWed;
//	}
//
//	public void setHprdTotalNursWed(String hprdTotalNursWed) {
//		this.hprdTotalNursWed = hprdTotalNursWed;
//	}
//
//	public String getHprdTotalNursThurs() {
//		return hprdTotalNursThurs;
//	}
//
//	public void setHprdTotalNursThurs(String hprdTotalNursThurs) {
//		this.hprdTotalNursThurs = hprdTotalNursThurs;
//	}
//
//	public String getHprdTotalNursFri() {
//		return hprdTotalNursFri;
//	}
//
//	public void setHprdTotalNursFri(String hprdTotalNursFri) {
//		this.hprdTotalNursFri = hprdTotalNursFri;
//	}
//
//	public String getHprdTotalNursSat() {
//		return hprdTotalNursSat;
//	}
//
//	public void setHprdTotalNursSat(String hprdTotalNursSat) {
//		this.hprdTotalNursSat = hprdTotalNursSat;
//	}
//
//	public String getHprdTotalNursSun() {
//		return hprdTotalNursSun;
//	}
//
//	public void setHprdTotalNursSun(String hprdTotalNursSun) {
//		this.hprdTotalNursSun = hprdTotalNursSun;
//	}
//
//	public String getHprdTotalNursWkTotal() {
//		return hprdTotalNursWkTotal;
//	}
//
//	public void setHprdTotalNursWkTotal(String hprdTotalNursWkTotal) {
//		this.hprdTotalNursWkTotal = hprdTotalNursWkTotal;
//	}
//
//	public String getHprdTotalAlliedMon() {
//		return hprdTotalAlliedMon;
//	}
//
//	public void setHprdTotalAlliedMon(String hprdTotalAlliedMon) {
//		this.hprdTotalAlliedMon = hprdTotalAlliedMon;
//	}
//
//	public String getHprdTotalAlliedTues() {
//		return hprdTotalAlliedTues;
//	}
//
//	public void setHprdTotalAlliedTues(String hprdTotalAlliedTues) {
//		this.hprdTotalAlliedTues = hprdTotalAlliedTues;
//	}
//
//	public String getHprdTotalAlliedWed() {
//		return hprdTotalAlliedWed;
//	}
//
//	public void setHprdTotalAlliedWed(String hprdTotalAlliedWed) {
//		this.hprdTotalAlliedWed = hprdTotalAlliedWed;
//	}
//
//	public String getHprdTotalAlliedThurs() {
//		return hprdTotalAlliedThurs;
//	}
//
//	public void setHprdTotalAlliedThurs(String hprdTotalAlliedThurs) {
//		this.hprdTotalAlliedThurs = hprdTotalAlliedThurs;
//	}
//
//	public String getHprdTotalAlliedFri() {
//		return hprdTotalAlliedFri;
//	}
//
//	public void setHprdTotalAlliedFri(String hprdTotalAlliedFri) {
//		this.hprdTotalAlliedFri = hprdTotalAlliedFri;
//	}
//
//	public String getHprdTotalAlliedSat() {
//		return hprdTotalAlliedSat;
//	}
//
//	public void setHprdTotalAlliedSat(String hprdTotalAlliedSat) {
//		this.hprdTotalAlliedSat = hprdTotalAlliedSat;
//	}
//
//	public String getHprdTotalAlliedSun() {
//		return hprdTotalAlliedSun;
//	}
//
//	public void setHprdTotalAlliedSun(String hprdTotalAlliedSun) {
//		this.hprdTotalAlliedSun = hprdTotalAlliedSun;
//	}
//
//	public String getHprdTotalAlliedWkTotal() {
//		return hprdTotalAlliedWkTotal;
//	}
//
//	public void setHprdTotalAlliedWkTotal(String hprdTotalAlliedWkTotal) {
//		this.hprdTotalAlliedWkTotal = hprdTotalAlliedWkTotal;
//	}
//
//	@Override
//	public String getFileName() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getFormType() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<String> getCsvElements() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<IModel> getObjects() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
