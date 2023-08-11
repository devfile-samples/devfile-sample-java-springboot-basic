package ca.bc.gov.chefs.etl.forms.ltc.staffing.processor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.eclipse.jetty.server.RequestLog.Collection;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.forms.ltc.facility.model.Approver;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.json.Root;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.model.LTCStaffPlanPerf;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.model.LTCStaffPlanPosSubtotal;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.model.LTCStaffPlanPosType;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.model.LTCStaffingAddPos;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.model.LTCStaffingHrs;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.model.LTCStaffingPlan;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.model.LTCStaffingSubmission;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.util.StaffingPlanUtil;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class LTCStaffingPlanApiResponseProcessor implements Processor {

	@Override
	@SuppressWarnings("unchecked")
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		payload = JsonUtil.roundDigitsNumber(payload);
		ObjectMapper mapper = new ObjectMapper();

		List<Root> staffingPlanModels = mapper.readValue(payload,
				new TypeReference<List<Root>>() {
				});
		List<LTCStaffingSubmission> parsedStaffingPlan = parseStaffingPlan(staffingPlanModels);
		List<IModel> iModels = (List<IModel>) (List<?>) parsedStaffingPlan;
		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
		//map = CSVUtil.removeAllNullKeys(map);
		boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map,Constants.LTC_STAFFING_PLAN_DIR, isHeaderAdded);
		// TODO remove successReponse or uncomment
		// SuccessResponse successResponse = new SuccessResponse();
		// successResponse.setFiles(filesGenerated);
		// exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
	}
	
	private List<LTCStaffingSubmission> parseStaffingPlan(List<Root> staffingPlans) {
		/* Mandatory fields */
		List<LTCStaffingSubmission> staffingPlanParsed = new ArrayList<>();
		for(Root root : staffingPlans) {
			
			LTCStaffingSubmission lTCstaffingPlanMainEntity = new LTCStaffingSubmission();
			List<LTCStaffingPlan> LTCstaffingPlan = new ArrayList<>();
			List<LTCStaffPlanPerf> LTCStaffPlanPerf = new ArrayList<>();
			List<LTCStaffPlanPosSubtotal> LTCStaffPlanPosSubtotal = new ArrayList<>();
			List<LTCStaffPlanPosType> LTCStaffPlanPosType = new ArrayList<>();
			List<LTCStaffingAddPos> LTCStaffingAddPos = new ArrayList<>();
			List<LTCStaffingHrs> LTCStaffingHrs = new ArrayList<>();

			/* mapping LTCstaffingSubmission */
			lTCstaffingPlanMainEntity.setConfirmationId(root.getForm().getConfirmationId());
			lTCstaffingPlanMainEntity.setIsDeleted(String.valueOf(root.getForm().isDeleted()));
			lTCstaffingPlanMainEntity.setSubmissionDate(root.getForm().getCreatedAt());
			lTCstaffingPlanMainEntity.setSubmittedBy(root.getForm().getFullName());
			lTCstaffingPlanMainEntity.setCCIMSID(root.getCcimsid());
			lTCstaffingPlanMainEntity.setSubmission_FY(root.getQuarter());


			/* mapping LTCstaffingPlan */
			LTCStaffingPlan LTCStaffingPlan1 = new LTCStaffingPlan();
			LTCStaffingPlan1.setConfirmationId(root.getForm().getConfirmationId());
			LTCStaffingPlan1.setStaffingPlanNum("1");
			LTCStaffingPlan1.setStaffPlanFor(root.getStaffingPlanType1());
			LTCStaffingPlan1.setPeriodStart(root.getPeriodStartDate1());
			LTCStaffingPlan1.setPeriodEnd(root.getPeriodEndDate1());
			LTCStaffingPlan1.setRevisionDate(root.getRevisionDate1());
			LTCStaffingPlan1.setReasonForRev(root.getRevisionReason1());
			LTCStaffingPlan1.setNbTotalBeds(root.getNumberOfTotalBeds1());
			LTCStaffingPlan1.setCumulative_Total_DCH_Q1(root.getDCH_q11());
			LTCStaffingPlan1.setCumulative_Total_DCH_Q2(root.getDCH_q21());
			LTCStaffingPlan1.setCumulative_Total_DCH_Q3(root.getDCH_q31());
			LTCStaffingPlan1.setCumulative_Total_DCH_Q4(root.getDCH_q41());
			LTCStaffingPlan1.setPerf_4_1(root.getMinimumRN1());
			LTCStaffingPlan1.setStaffPlanForOther(root.getDoesTheStaffingPatternProvideNote1());
			LTCStaffingPlan1.setProfessional_Staffing_Percentage(root.getProf_staff_percentage1());
			LTCStaffingPlan1.setRn_lpn_Staffing_Percentage(root.getRN_LPN_staff_percentage1());

			LTCstaffingPlan.add(LTCStaffingPlan1);

			//mapping LTC_STAFF_PLAN_POS_SUBTOTALS
			LTCStaffPlanPosSubtotal RNSubtotal1 = new LTCStaffPlanPosSubtotal();
			RNSubtotal1.setConfirmationId(root.getForm().getConfirmationId());
			RNSubtotal1.setStaffingPlanNum("1");
			RNSubtotal1.setStaffingType(root.getRn_label1());
			RNSubtotal1.setSumHrsMon(root.getRn_mon_total1());
			RNSubtotal1.setSumHrsTue(root.getRn_tue_total1());
			RNSubtotal1.setSumHrsWed(root.getRn_wed_total1());
			RNSubtotal1.setSumHrsThu(root.getRn_thu_total1());
			RNSubtotal1.setSumHrsFri(root.getRn_fri_total1());
			RNSubtotal1.setSumHrsSat(root.getRn_sat_total1());
			RNSubtotal1.setSumHrsSun(root.getRn_sun_total1());
			RNSubtotal1.setSumHrsWeekTotal(root.getRn_week_total1());
			RNSubtotal1.setSumHrsAnnual(root.getRn_annual_total1());

			LTCStaffPlanPosSubtotal LPNSubtotal1 = new LTCStaffPlanPosSubtotal();
			LPNSubtotal1.setConfirmationId(root.getForm().getConfirmationId());
			LPNSubtotal1.setStaffingPlanNum("1");
			LPNSubtotal1.setStaffingType(root.getLpn_label1());
			LPNSubtotal1.setSumHrsMon(root.getLpn_mon_total1());
			LPNSubtotal1.setSumHrsTue(root.getLpn_tue_total1());
			LPNSubtotal1.setSumHrsWed(root.getLpn_wed_total1());
			LPNSubtotal1.setSumHrsThu(root.getLpn_thu_total1());
			LPNSubtotal1.setSumHrsFri(root.getLpn_fri_total1());
			LPNSubtotal1.setSumHrsSat(root.getLpn_sat_total1());
			LPNSubtotal1.setSumHrsSun(root.getLpn_sun_total1());
			LPNSubtotal1.setSumHrsWeekTotal(root.getLpn_week_total1());
			LPNSubtotal1.setSumHrsAnnual(root.getLpn_annual_total1());

			LTCStaffPlanPosSubtotal NursingProfSubtotal1 = new LTCStaffPlanPosSubtotal();
			NursingProfSubtotal1.setConfirmationId(root.getForm().getConfirmationId());
			NursingProfSubtotal1.setStaffingPlanNum("1");
			NursingProfSubtotal1.setStaffingType(root.getNp_label1());
			NursingProfSubtotal1.setSumHrsMon(root.getNp_mon_total1());
			NursingProfSubtotal1.setSumHrsTue(root.getNp_tue_total1());
			NursingProfSubtotal1.setSumHrsWed(root.getNp_wed_total1());
			NursingProfSubtotal1.setSumHrsThu(root.getNp_thu_total1());
			NursingProfSubtotal1.setSumHrsFri(root.getNp_fri_total1());
			NursingProfSubtotal1.setSumHrsSat(root.getNp_sat_total1());
			NursingProfSubtotal1.setSumHrsSun(root.getNp_sun_total1());
			NursingProfSubtotal1.setSumHrsWeekTotal(root.getNp_week_total1());
			NursingProfSubtotal1.setSumHrsAnnual(root.getNp_annual_total1());

			LTCStaffPlanPosSubtotal HCASubtotal1 = new LTCStaffPlanPosSubtotal();
			HCASubtotal1.setConfirmationId(root.getForm().getConfirmationId());
			HCASubtotal1.setStaffingPlanNum("1");
			HCASubtotal1.setStaffingType(root.getHca_label1());
			HCASubtotal1.setSumHrsMon(root.getHca_mon_total1());
			HCASubtotal1.setSumHrsTue(root.getHca_tue_total1());
			HCASubtotal1.setSumHrsWed(root.getHca_wed_total1());
			HCASubtotal1.setSumHrsThu(root.getHca_thu_total1());
			HCASubtotal1.setSumHrsFri(root.getHca_fri_total1());
			HCASubtotal1.setSumHrsSat(root.getHca_sat_total1());
			HCASubtotal1.setSumHrsSun(root.getHca_sun_total1());
			HCASubtotal1.setSumHrsWeekTotal(root.getHca_week_total1());
			HCASubtotal1.setSumHrsAnnual(root.getHca_annual_total1());

			LTCStaffPlanPosSubtotal NursingNonProfSubtotal1 = new LTCStaffPlanPosSubtotal();
			NursingNonProfSubtotal1.setConfirmationId(root.getForm().getConfirmationId());
			NursingNonProfSubtotal1.setStaffingPlanNum("1");
			NursingNonProfSubtotal1.setStaffingType(root.getNnp_label1());
			NursingNonProfSubtotal1.setSumHrsMon(root.getNnp_mon_total1());
			NursingNonProfSubtotal1.setSumHrsTue(root.getNnp_tue_total1());
			NursingNonProfSubtotal1.setSumHrsWed(root.getNnp_wed_total1());
			NursingNonProfSubtotal1.setSumHrsThu(root.getNnp_thu_total1());
			NursingNonProfSubtotal1.setSumHrsFri(root.getNnp_fri_total1());
			NursingNonProfSubtotal1.setSumHrsSat(root.getNnp_sat_total1());
			NursingNonProfSubtotal1.setSumHrsSun(root.getNnp_sun_total1());
			NursingNonProfSubtotal1.setSumHrsWeekTotal(root.getNnp_week_total1());
			NursingNonProfSubtotal1.setSumHrsAnnual(root.getNnp_annual_total1());

			LTCStaffPlanPosSubtotal NursingSubtotal1 = new LTCStaffPlanPosSubtotal();
			NursingSubtotal1.setConfirmationId(root.getForm().getConfirmationId());
			NursingSubtotal1.setStaffingPlanNum("1");
			NursingSubtotal1.setStaffingType(root.getNursing_label1());
			NursingSubtotal1.setSumHrsMon(root.getNursing_mon_total1());
			NursingSubtotal1.setSumHrsTue(root.getNursing_tue_total1());
			NursingSubtotal1.setSumHrsWed(root.getNursing_wed_total1());
			NursingSubtotal1.setSumHrsThu(root.getNursing_thu_total1());
			NursingSubtotal1.setSumHrsFri(root.getNursing_fri_total1());
			NursingSubtotal1.setSumHrsSat(root.getNursing_sat_total1());
			NursingSubtotal1.setSumHrsSun(root.getNursing_sun_total1());
			NursingSubtotal1.setSumHrsWeekTotal(root.getNursing_week_total1());
			NursingSubtotal1.setSumHrsAnnual(root.getNursing_annual_total1());

			LTCStaffPlanPosSubtotal AlliedProfSubtotal1 = new LTCStaffPlanPosSubtotal();
			AlliedProfSubtotal1.setConfirmationId(root.getForm().getConfirmationId());
			AlliedProfSubtotal1.setStaffingPlanNum("1");
			AlliedProfSubtotal1.setStaffingType("Allied Professional");
			AlliedProfSubtotal1.setSumHrsMon(root.getAld_mon_total1());
			AlliedProfSubtotal1.setSumHrsTue(root.getAld_tue_total1());
			AlliedProfSubtotal1.setSumHrsWed(root.getAld_wed_total1());
			AlliedProfSubtotal1.setSumHrsThu(root.getAld_thu_total1());
			AlliedProfSubtotal1.setSumHrsFri(root.getAld_fri_total1());
			AlliedProfSubtotal1.setSumHrsSat(root.getAld_sat_total1());
			AlliedProfSubtotal1.setSumHrsSun(root.getAld_sun_total1());
			AlliedProfSubtotal1.setSumHrsWeekTotal(root.getAld_week_total1());
			AlliedProfSubtotal1.setSumHrsAnnual(root.getAld_annual_total1());

			LTCStaffPlanPosSubtotal AlliedProfScheduledSubtotal1 = new LTCStaffPlanPosSubtotal();
			AlliedProfScheduledSubtotal1.setConfirmationId(root.getForm().getConfirmationId());
			AlliedProfScheduledSubtotal1.setStaffingPlanNum("1");
			AlliedProfScheduledSubtotal1.setStaffingType(root.getAlliedProf_label1());
			AlliedProfScheduledSubtotal1.setSumHrsMon(root.getAlliedProf_mon_total1());
			AlliedProfScheduledSubtotal1.setSumHrsTue(root.getAlliedProf_tue_total1());
			AlliedProfScheduledSubtotal1.setSumHrsWed(root.getAlliedProf_wed_total1());
			AlliedProfScheduledSubtotal1.setSumHrsThu(root.getAlliedProf_thu_total1());
			AlliedProfScheduledSubtotal1.setSumHrsFri(root.getAlliedProf_fri_total1());
			AlliedProfScheduledSubtotal1.setSumHrsSat(root.getAlliedProf_sat_total1());
			AlliedProfScheduledSubtotal1.setSumHrsSun(root.getAlliedProf_sun_total1());
			AlliedProfScheduledSubtotal1.setSumHrsWeekTotal(root.getAlliedProf_week_total1());
			AlliedProfScheduledSubtotal1.setSumHrsAnnual(root.getAlliedProf_annual_total1());

			LTCStaffPlanPosSubtotal AlliedNonProfSubtotal1 = new LTCStaffPlanPosSubtotal();
			AlliedNonProfSubtotal1.setConfirmationId(root.getForm().getConfirmationId());
			AlliedNonProfSubtotal1.setStaffingPlanNum("1");
			AlliedNonProfSubtotal1.setStaffingType("Allied Non-Professional");
			AlliedNonProfSubtotal1.setSumHrsMon(root.getAldnop_mon_total1());
			AlliedNonProfSubtotal1.setSumHrsTue(root.getAldnop_tue_total1());
			AlliedNonProfSubtotal1.setSumHrsWed(root.getAldnop_wed_total1());
			AlliedNonProfSubtotal1.setSumHrsThu(root.getAldnop_thu_total1());
			AlliedNonProfSubtotal1.setSumHrsFri(root.getAldnop_fri_total1());
			AlliedNonProfSubtotal1.setSumHrsSat(root.getAldnop_sat_total1());
			AlliedNonProfSubtotal1.setSumHrsSun(root.getAldnop_sun_total1());
			AlliedNonProfSubtotal1.setSumHrsWeekTotal(root.getAldnop_week_total1());
			AlliedNonProfSubtotal1.setSumHrsAnnual(root.getAldnop_annual_total1());
			

			LTCStaffPlanPosSubtotal AlliedNonProfScheduledSubtotal1 = new LTCStaffPlanPosSubtotal();
			AlliedNonProfScheduledSubtotal1.setConfirmationId(root.getForm().getConfirmationId());
			AlliedNonProfScheduledSubtotal1.setStaffingPlanNum("1");
			AlliedNonProfScheduledSubtotal1.setStaffingType(root.getAlliedNP_label1());
			AlliedNonProfScheduledSubtotal1.setSumHrsMon(root.getAlliedNP_mon_total1());
			AlliedNonProfScheduledSubtotal1.setSumHrsTue(root.getAlliedNP_tue_total1());
			AlliedNonProfScheduledSubtotal1.setSumHrsWed(root.getAlliedNP_wed_total1());
			AlliedNonProfScheduledSubtotal1.setSumHrsThu(root.getAlliedNP_thu_total1());
			AlliedNonProfScheduledSubtotal1.setSumHrsFri(root.getAlliedNP_fri_total1());
			AlliedNonProfScheduledSubtotal1.setSumHrsSat(root.getAlliedNP_sat_total1());
			AlliedNonProfScheduledSubtotal1.setSumHrsSun(root.getAlliedNP_sun_total1());
			AlliedNonProfScheduledSubtotal1.setSumHrsWeekTotal(root.getAlliedNP_week_total1());
			AlliedNonProfScheduledSubtotal1.setSumHrsAnnual(root.getAlliedNP_annual_total1());
			

			LTCStaffPlanPosSubtotal AlliedSubtotal1 = new LTCStaffPlanPosSubtotal();
			AlliedSubtotal1.setConfirmationId(root.getForm().getConfirmationId());
			AlliedSubtotal1.setStaffingPlanNum("1");
			AlliedSubtotal1.setStaffingType(root.getAllied_label1());
			AlliedSubtotal1.setSumHrsMon(root.getAllied_mon_total1());
			AlliedSubtotal1.setSumHrsTue(root.getAllied_tue_total1());
			AlliedSubtotal1.setSumHrsWed(root.getAllied_wed_total1());
			AlliedSubtotal1.setSumHrsThu(root.getAllied_thu_total1());
			AlliedSubtotal1.setSumHrsFri(root.getAllied_fri_total1());
			AlliedSubtotal1.setSumHrsSat(root.getAllied_sat_total1());
			AlliedSubtotal1.setSumHrsSun(root.getAllied_sun_total1());
			AlliedSubtotal1.setSumHrsWeekTotal(root.getAllied_week_total1());
			AlliedSubtotal1.setSumHrsAnnual(root.getAllied_annual_total1());
			
			LTCStaffPlanPosSubtotal NursingAndAlliedSubtotal1 = new LTCStaffPlanPosSubtotal();
			NursingAndAlliedSubtotal1.setConfirmationId(root.getForm().getConfirmationId());
			NursingAndAlliedSubtotal1.setStaffingPlanNum("1");
			NursingAndAlliedSubtotal1.setStaffingType(root.getTotal_label1());
			NursingAndAlliedSubtotal1.setSumHrsMon(root.getMon_total1());
			NursingAndAlliedSubtotal1.setSumHrsTue(root.getTue_total1());
			NursingAndAlliedSubtotal1.setSumHrsWed(root.getWed_total1());
			NursingAndAlliedSubtotal1.setSumHrsThu(root.getThu_total1());
			NursingAndAlliedSubtotal1.setSumHrsFri(root.getFri_total1());
			NursingAndAlliedSubtotal1.setSumHrsSat(root.getSat_total1());
			NursingAndAlliedSubtotal1.setSumHrsSun(root.getSun_total1());
			NursingAndAlliedSubtotal1.setSumHrsWeekTotal(root.getWeek_total1());
			NursingAndAlliedSubtotal1.setSumHrsAnnual(root.getAnnual_total1());
			
			LTCStaffPlanPosSubtotal HPRDNursingTotal1 = new LTCStaffPlanPosSubtotal();
			HPRDNursingTotal1.setConfirmationId(root.getForm().getConfirmationId());
			HPRDNursingTotal1.setStaffingPlanNum("1");
			HPRDNursingTotal1.setStaffingType("HPRD Nursing");
			HPRDNursingTotal1.setSumHrsMon(root.getHPRD_nursing_mon1());
			HPRDNursingTotal1.setSumHrsTue(root.getHPRD_nursing_tue1());
			HPRDNursingTotal1.setSumHrsWed(root.getHPRD_nursing_wed1());
			HPRDNursingTotal1.setSumHrsThu(root.getHPRD_nursing_thu1());
			HPRDNursingTotal1.setSumHrsFri(root.getHPRD_nursing_fri1());
			HPRDNursingTotal1.setSumHrsSat(root.getHPRD_nursing_sat1());
			HPRDNursingTotal1.setSumHrsSun(root.getHPRD_nursing_sun1());
			HPRDNursingTotal1.setSumHrsWeekTotal(root.getHPRD_nursing_total1());
			HPRDNursingTotal1.setSumHrsAnnual(Constants.DEFAULT_DECIMAL_VALUE);
			
			LTCStaffPlanPosSubtotal HPRDAlliedTotal1 = new LTCStaffPlanPosSubtotal();
			HPRDAlliedTotal1.setConfirmationId(root.getForm().getConfirmationId());
			HPRDAlliedTotal1.setStaffingPlanNum("1");
			HPRDAlliedTotal1.setStaffingType("HPRD Allied");
			HPRDAlliedTotal1.setSumHrsMon(root.getHPRD_allied_mon1());
			HPRDAlliedTotal1.setSumHrsTue(root.getHPRD_allied_tue1());
			HPRDAlliedTotal1.setSumHrsWed(root.getHPRD_allied_wed1());
			HPRDAlliedTotal1.setSumHrsThu(root.getHPRD_allied_thu1());
			HPRDAlliedTotal1.setSumHrsFri(root.getHPRD_allied_fri1());
			HPRDAlliedTotal1.setSumHrsSat(root.getHPRD_allied_sat1());
			HPRDAlliedTotal1.setSumHrsSun(root.getHPRD_allied_sun1());
			HPRDAlliedTotal1.setSumHrsWeekTotal(root.getHPRD_allied_total1());
			HPRDAlliedTotal1.setSumHrsAnnual(Constants.DEFAULT_DECIMAL_VALUE);
			
			LTCStaffPlanPosSubtotal HPRDTotal1 = new LTCStaffPlanPosSubtotal();
			HPRDTotal1.setConfirmationId(root.getForm().getConfirmationId());
			HPRDTotal1.setStaffingPlanNum("1");
			HPRDTotal1.setStaffingType("HPRD Total");
			HPRDTotal1.setSumHrsMon(root.getHPRD_total_mon1());
			HPRDTotal1.setSumHrsTue(root.getHprdTotalTue1());
			HPRDTotal1.setSumHrsWed(root.getWed_total1());
			HPRDTotal1.setSumHrsThu(root.getHPRD_total_thu1());
			HPRDTotal1.setSumHrsFri(root.getHPRD_total_fri1());
			HPRDTotal1.setSumHrsSat(root.getHPRD_total_sat1());
			HPRDTotal1.setSumHrsSun(root.getHPRD_total_sun1());
			HPRDTotal1.setSumHrsWeekTotal(root.getHPRD_total1());
			HPRDTotal1.setSumHrsAnnual(Constants.DEFAULT_DECIMAL_VALUE);
			
			Collections.addAll(LTCStaffPlanPosSubtotal, RNSubtotal1, LPNSubtotal1, NursingProfSubtotal1, HCASubtotal1,
			NursingNonProfSubtotal1, NursingSubtotal1, AlliedProfSubtotal1, AlliedProfScheduledSubtotal1, AlliedNonProfSubtotal1,
			AlliedNonProfScheduledSubtotal1, AlliedSubtotal1, NursingAndAlliedSubtotal1, HPRDNursingTotal1, HPRDAlliedTotal1,
			HPRDTotal1);

			if(root.getStaffingPlanType2() != null && !root.getStaffingPlanType2().isEmpty()){
				LTCStaffingPlan LTCStaffingPlan2 = new LTCStaffingPlan();
				LTCStaffingPlan2.setConfirmationId(root.getForm().getConfirmationId());
				LTCStaffingPlan2.setStaffingPlanNum("2");
				LTCStaffingPlan2.setStaffPlanFor(root.getStaffingPlanType2());
				LTCStaffingPlan2.setPeriodStart(root.getPeriodStartDate2());
				LTCStaffingPlan2.setPeriodEnd(root.getPeriodEndDate2());
				LTCStaffingPlan2.setRevisionDate(root.getRevisionDate2());
				LTCStaffingPlan2.setReasonForRev(root.getRevisionReason2());
				LTCStaffingPlan2.setNbTotalBeds(root.getNumberOfTotalBeds2());
				LTCStaffingPlan2.setCumulative_Total_DCH_Q1(root.getDCH_q12());
				LTCStaffingPlan2.setCumulative_Total_DCH_Q2(root.getDCH_q22());
				LTCStaffingPlan2.setCumulative_Total_DCH_Q3(root.getDCH_q32());
				LTCStaffingPlan2.setCumulative_Total_DCH_Q4(root.getDCH_q42());
				LTCStaffingPlan2.setPerf_4_1(root.getMinimumRN2());
				LTCStaffingPlan2.setStaffPlanForOther(root.getDoesTheStaffingPatternProvideNote2());
				LTCStaffingPlan2.setProfessional_Staffing_Percentage(root.getProf_staff_percentage2());
				LTCStaffingPlan2.setRn_lpn_Staffing_Percentage(root.getRN_LPN_staff_percentage2());

				LTCstaffingPlan.add(LTCStaffingPlan2);

				LTCStaffPlanPosSubtotal RNSubtotal2 = new LTCStaffPlanPosSubtotal();
				RNSubtotal2.setConfirmationId(root.getForm().getConfirmationId());
				RNSubtotal2.setStaffingPlanNum("2");
				RNSubtotal2.setStaffingType(root.getRn_label1());
				RNSubtotal2.setSumHrsMon(root.getRn_mon_total2());
				RNSubtotal2.setSumHrsTue(root.getRn_tue_total2());
				RNSubtotal2.setSumHrsWed(root.getRn_wed_total2());
				RNSubtotal2.setSumHrsThu(root.getRn_thu_total2());
				RNSubtotal2.setSumHrsFri(root.getRn_fri_total2());
				RNSubtotal2.setSumHrsSat(root.getRn_sat_total2());
				RNSubtotal2.setSumHrsSun(root.getRn_sun_total2());
				RNSubtotal2.setSumHrsWeekTotal(root.getRn_week_total2());
				RNSubtotal2.setSumHrsAnnual(root.getRn_annual_total2());
	
				LTCStaffPlanPosSubtotal LPNSubtotal2 = new LTCStaffPlanPosSubtotal();
				LPNSubtotal2.setConfirmationId(root.getForm().getConfirmationId());
				LPNSubtotal2.setStaffingPlanNum("2");
				LPNSubtotal2.setStaffingType(root.getLpn_label1());
				LPNSubtotal2.setSumHrsMon(root.getLpn_mon_total2());
				LPNSubtotal2.setSumHrsTue(root.getLpn_tue_total2());
				LPNSubtotal2.setSumHrsWed(root.getLpn_wed_total2());
				LPNSubtotal2.setSumHrsThu(root.getLpn_thu_total2());
				LPNSubtotal2.setSumHrsFri(root.getLpn_fri_total2());
				LPNSubtotal2.setSumHrsSat(root.getLpn_sat_total2());
				LPNSubtotal2.setSumHrsSun(root.getLpn_sun_total2());
				LPNSubtotal2.setSumHrsWeekTotal(root.getLpn_week_total2());
				LPNSubtotal2.setSumHrsAnnual(root.getLpn_annual_total2());
	
				LTCStaffPlanPosSubtotal NursingProfSubtotal2 = new LTCStaffPlanPosSubtotal();
				NursingProfSubtotal2.setConfirmationId(root.getForm().getConfirmationId());
				NursingProfSubtotal2.setStaffingPlanNum("2");
				NursingProfSubtotal2.setStaffingType(root.getNp_label1());
				NursingProfSubtotal2.setSumHrsMon(root.getNp_mon_total2());
				NursingProfSubtotal2.setSumHrsTue(root.getNp_tue_total2());
				NursingProfSubtotal2.setSumHrsWed(root.getNp_wed_total2());
				NursingProfSubtotal2.setSumHrsThu(root.getNp_thu_total2());
				NursingProfSubtotal2.setSumHrsFri(root.getNp_fri_total2());
				NursingProfSubtotal2.setSumHrsSat(root.getNp_sat_total2());
				NursingProfSubtotal2.setSumHrsSun(root.getNp_sun_total2());
				NursingProfSubtotal2.setSumHrsWeekTotal(root.getNp_week_total2());
				NursingProfSubtotal2.setSumHrsAnnual(root.getNp_annual_total2());
	
				LTCStaffPlanPosSubtotal HCASubtotal2 = new LTCStaffPlanPosSubtotal();
				HCASubtotal2.setConfirmationId(root.getForm().getConfirmationId());
				HCASubtotal2.setStaffingPlanNum("2");
				HCASubtotal2.setStaffingType(root.getHca_label1());
				HCASubtotal2.setSumHrsMon(root.getHca_mon_total2());
				HCASubtotal2.setSumHrsTue(root.getHca_tue_total2());
				HCASubtotal2.setSumHrsWed(root.getHca_wed_total2());
				HCASubtotal2.setSumHrsThu(root.getHca_thu_total2());
				HCASubtotal2.setSumHrsFri(root.getHca_fri_total2());
				HCASubtotal2.setSumHrsSat(root.getHca_sat_total2());
				HCASubtotal2.setSumHrsSun(root.getHca_sun_total2());
				HCASubtotal2.setSumHrsWeekTotal(root.getHca_week_total2());
				HCASubtotal2.setSumHrsAnnual(root.getHca_annual_total2());
	
				LTCStaffPlanPosSubtotal NursingNonProfSubtotal2 = new LTCStaffPlanPosSubtotal();
				NursingNonProfSubtotal2.setConfirmationId(root.getForm().getConfirmationId());
				NursingNonProfSubtotal2.setStaffingPlanNum("2");
				NursingNonProfSubtotal2.setStaffingType(root.getNnp_label1());
				NursingNonProfSubtotal2.setSumHrsMon(root.getNnp_mon_total2());
				NursingNonProfSubtotal2.setSumHrsTue(root.getNnp_tue_total2());
				NursingNonProfSubtotal2.setSumHrsWed(root.getNnp_wed_total2());
				NursingNonProfSubtotal2.setSumHrsThu(root.getNnp_thu_total2());
				NursingNonProfSubtotal2.setSumHrsFri(root.getNnp_fri_total2());
				NursingNonProfSubtotal2.setSumHrsSat(root.getNnp_sat_total2());
				NursingNonProfSubtotal2.setSumHrsSun(root.getNnp_sun_total2());
				NursingNonProfSubtotal2.setSumHrsWeekTotal(root.getNnp_week_total2());
				NursingNonProfSubtotal2.setSumHrsAnnual(root.getNnp_annual_total2());
	
				LTCStaffPlanPosSubtotal NursingSubtotal2 = new LTCStaffPlanPosSubtotal();
				NursingSubtotal2.setConfirmationId(root.getForm().getConfirmationId());
				NursingSubtotal2.setStaffingPlanNum("2");
				NursingSubtotal2.setStaffingType(root.getNursing_label1());
				NursingSubtotal2.setSumHrsMon(root.getNursing_mon_total2());
				NursingSubtotal2.setSumHrsTue(root.getNursing_tue_total2());
				NursingSubtotal2.setSumHrsWed(root.getNursing_wed_total2());
				NursingSubtotal2.setSumHrsThu(root.getNursing_thu_total2());
				NursingSubtotal2.setSumHrsFri(root.getNursing_fri_total2());
				NursingSubtotal2.setSumHrsSat(root.getNursing_sat_total2());
				NursingSubtotal2.setSumHrsSun(root.getNursing_sun_total2());
				NursingSubtotal2.setSumHrsWeekTotal(root.getNursing_week_total2());
				NursingSubtotal2.setSumHrsAnnual(root.getNursing_annual_total2());
	
				LTCStaffPlanPosSubtotal AlliedProfSubtotal2 = new LTCStaffPlanPosSubtotal();
				AlliedProfSubtotal2.setConfirmationId(root.getForm().getConfirmationId());
				AlliedProfSubtotal2.setStaffingPlanNum("2");
				AlliedProfSubtotal2.setStaffingType("Allied Professional");
				AlliedProfSubtotal2.setSumHrsMon(root.getAld_mon_total2());
				AlliedProfSubtotal2.setSumHrsTue(root.getAld_tue_total2());
				AlliedProfSubtotal2.setSumHrsWed(root.getAld_wed_total2());
				AlliedProfSubtotal2.setSumHrsThu(root.getAld_thu_total2());
				AlliedProfSubtotal2.setSumHrsFri(root.getAld_fri_total2());
				AlliedProfSubtotal2.setSumHrsSat(root.getAld_sat_total2());
				AlliedProfSubtotal2.setSumHrsSun(root.getAld_sun_total2());
				AlliedProfSubtotal2.setSumHrsWeekTotal(root.getAld_week_total2());
				AlliedProfSubtotal2.setSumHrsAnnual(root.getAld_annual_total2());
	
				LTCStaffPlanPosSubtotal AlliedProfScheduledSubtotal2 = new LTCStaffPlanPosSubtotal();
				AlliedProfScheduledSubtotal2.setConfirmationId(root.getForm().getConfirmationId());
				AlliedProfScheduledSubtotal2.setStaffingPlanNum("2");
				AlliedProfScheduledSubtotal2.setStaffingType(root.getAlliedProf_label1());
				AlliedProfScheduledSubtotal2.setSumHrsMon(root.getAlliedProf_mon_total2());
				AlliedProfScheduledSubtotal2.setSumHrsTue(root.getAlliedProf_tue_total2());
				AlliedProfScheduledSubtotal2.setSumHrsWed(root.getAlliedProf_wed_total2());
				AlliedProfScheduledSubtotal2.setSumHrsThu(root.getAlliedProf_thu_total2());
				AlliedProfScheduledSubtotal2.setSumHrsFri(root.getAlliedProf_fri_total2());
				AlliedProfScheduledSubtotal2.setSumHrsSat(root.getAlliedProf_sat_total2());
				AlliedProfScheduledSubtotal2.setSumHrsSun(root.getAlliedProf_sun_total2());
				AlliedProfScheduledSubtotal2.setSumHrsWeekTotal(root.getAlliedProf_week_total2());
				AlliedProfScheduledSubtotal2.setSumHrsAnnual(root.getAlliedProf_annual_total2());
	
				LTCStaffPlanPosSubtotal AlliedNonProfSubtotal2 = new LTCStaffPlanPosSubtotal();
				AlliedNonProfSubtotal2.setConfirmationId(root.getForm().getConfirmationId());
				AlliedNonProfSubtotal2.setStaffingPlanNum("2");
				AlliedNonProfSubtotal2.setStaffingType("Allied Non-Professional");
				AlliedNonProfSubtotal2.setSumHrsMon(root.getAldnop_mon_total2());
				AlliedNonProfSubtotal2.setSumHrsTue(root.getAldnop_tue_total2());
				AlliedNonProfSubtotal2.setSumHrsWed(root.getAldnop_wed_total2());
				AlliedNonProfSubtotal2.setSumHrsThu(root.getAldnop_thu_total2());
				AlliedNonProfSubtotal2.setSumHrsFri(root.getAldnop_fri_total2());
				AlliedNonProfSubtotal2.setSumHrsSat(root.getAldnop_sat_total2());
				AlliedNonProfSubtotal2.setSumHrsSun(root.getAldnop_sun_total2());
				AlliedNonProfSubtotal2.setSumHrsWeekTotal(root.getAldnop_week_total2());
				AlliedNonProfSubtotal2.setSumHrsAnnual(root.getAldnop_annual_total2());
				
	
				LTCStaffPlanPosSubtotal AlliedNonProfScheduledSubtotal2 = new LTCStaffPlanPosSubtotal();
				AlliedNonProfScheduledSubtotal2.setConfirmationId(root.getForm().getConfirmationId());
				AlliedNonProfScheduledSubtotal2.setStaffingPlanNum("2");
				AlliedNonProfScheduledSubtotal2.setStaffingType(root.getAlliedNP_label1());
				AlliedNonProfScheduledSubtotal2.setSumHrsMon(root.getAlliedNP_mon_total2());
				AlliedNonProfScheduledSubtotal2.setSumHrsTue(root.getAlliedNP_tue_total2());
				AlliedNonProfScheduledSubtotal2.setSumHrsWed(root.getAlliedNP_wed_total2());
				AlliedNonProfScheduledSubtotal2.setSumHrsThu(root.getAlliedNP_thu_total2());
				AlliedNonProfScheduledSubtotal2.setSumHrsFri(root.getAlliedNP_fri_total2());
				AlliedNonProfScheduledSubtotal2.setSumHrsSat(root.getAlliedNP_sat_total2());
				AlliedNonProfScheduledSubtotal2.setSumHrsSun(root.getAlliedNP_sun_total2());
				AlliedNonProfScheduledSubtotal2.setSumHrsWeekTotal(root.getAlliedNP_week_total2());
				AlliedNonProfScheduledSubtotal2.setSumHrsAnnual(root.getAlliedNP_annual_total2());
				
	
				LTCStaffPlanPosSubtotal AlliedSubtotal2 = new LTCStaffPlanPosSubtotal();
				AlliedSubtotal2.setConfirmationId(root.getForm().getConfirmationId());
				AlliedSubtotal2.setStaffingPlanNum("2");
				AlliedSubtotal2.setStaffingType(root.getAllied_label1());
				AlliedSubtotal2.setSumHrsMon(root.getAllied_mon_total2());
				AlliedSubtotal2.setSumHrsTue(root.getAllied_tue_total2());
				AlliedSubtotal2.setSumHrsWed(root.getAllied_wed_total2());
				AlliedSubtotal2.setSumHrsThu(root.getAllied_thu_total2());
				AlliedSubtotal2.setSumHrsFri(root.getAllied_fri_total2());
				AlliedSubtotal2.setSumHrsSat(root.getAllied_sat_total2());
				AlliedSubtotal2.setSumHrsSun(root.getAllied_sun_total2());
				AlliedSubtotal2.setSumHrsWeekTotal(root.getAllied_week_total2());
				AlliedSubtotal2.setSumHrsAnnual(root.getAllied_annual_total2());
				
				LTCStaffPlanPosSubtotal NursingAndAlliedSubtotal2 = new LTCStaffPlanPosSubtotal();
				NursingAndAlliedSubtotal2.setConfirmationId(root.getForm().getConfirmationId());
				NursingAndAlliedSubtotal2.setStaffingPlanNum("2");
				NursingAndAlliedSubtotal2.setStaffingType(root.getTotal_label1());
				NursingAndAlliedSubtotal2.setSumHrsMon(root.getMon_total2());
				NursingAndAlliedSubtotal2.setSumHrsTue(root.getTue_total2());
				NursingAndAlliedSubtotal2.setSumHrsWed(root.getWed_total2());
				NursingAndAlliedSubtotal2.setSumHrsThu(root.getThu_total2());
				NursingAndAlliedSubtotal2.setSumHrsFri(root.getFri_total2());
				NursingAndAlliedSubtotal2.setSumHrsSat(root.getSat_total2());
				NursingAndAlliedSubtotal2.setSumHrsSun(root.getSun_total2());
				NursingAndAlliedSubtotal2.setSumHrsWeekTotal(root.getWeek_total2());
				NursingAndAlliedSubtotal2.setSumHrsAnnual(root.getAnnual_total2());
				
				LTCStaffPlanPosSubtotal HPRDNursingTotal2 = new LTCStaffPlanPosSubtotal();
				HPRDNursingTotal2.setConfirmationId(root.getForm().getConfirmationId());
				HPRDNursingTotal2.setStaffingPlanNum("2");
				HPRDNursingTotal2.setStaffingType("HPRD Nursing");
				HPRDNursingTotal2.setSumHrsMon(root.getHPRD_nursing_mon2());
				HPRDNursingTotal2.setSumHrsTue(root.getHPRD_nursing_tue2());
				HPRDNursingTotal2.setSumHrsWed(root.getHPRD_nursing_wed2());
				HPRDNursingTotal2.setSumHrsThu(root.getHPRD_nursing_thu2());
				HPRDNursingTotal2.setSumHrsFri(root.getHPRD_nursing_fri2());
				HPRDNursingTotal2.setSumHrsSat(root.getHPRD_nursing_sat2());
				HPRDNursingTotal2.setSumHrsSun(root.getHPRD_nursing_sun2());
				HPRDNursingTotal2.setSumHrsWeekTotal(root.getHPRD_nursing_total2());
				HPRDNursingTotal2.setSumHrsAnnual(Constants.DEFAULT_DECIMAL_VALUE);
				
				LTCStaffPlanPosSubtotal HPRDAlliedTotal2 = new LTCStaffPlanPosSubtotal();
				HPRDAlliedTotal2.setConfirmationId(root.getForm().getConfirmationId());
				HPRDAlliedTotal2.setStaffingPlanNum("2");
				HPRDAlliedTotal2.setStaffingType("HPRD Allied");
				HPRDAlliedTotal2.setSumHrsMon(root.getHPRD_allied_mon2());
				HPRDAlliedTotal2.setSumHrsTue(root.getHPRD_allied_tue2());
				HPRDAlliedTotal2.setSumHrsWed(root.getHPRD_allied_wed2());
				HPRDAlliedTotal2.setSumHrsThu(root.getHPRD_allied_thu2());
				HPRDAlliedTotal2.setSumHrsFri(root.getHPRD_allied_fri2());
				HPRDAlliedTotal2.setSumHrsSat(root.getHPRD_allied_sat2());
				HPRDAlliedTotal2.setSumHrsSun(root.getHPRD_allied_sun2());
				HPRDAlliedTotal2.setSumHrsWeekTotal(root.getHPRD_allied_total2());
				HPRDAlliedTotal2.setSumHrsAnnual(Constants.DEFAULT_DECIMAL_VALUE);
				
				LTCStaffPlanPosSubtotal HPRDTotal2 = new LTCStaffPlanPosSubtotal();
				HPRDTotal2.setConfirmationId(root.getForm().getConfirmationId());
				HPRDTotal2.setStaffingPlanNum("2");
				HPRDTotal2.setStaffingType("HPRD Total");
				HPRDTotal2.setSumHrsMon(root.getHPRD_total_mon2());
				HPRDTotal2.setSumHrsTue(root.getHprdTotalTue2());
				HPRDTotal2.setSumHrsWed(root.getWed_total2());
				HPRDTotal2.setSumHrsThu(root.getHPRD_total_thu2());
				HPRDTotal2.setSumHrsFri(root.getHPRD_total_fri2());
				HPRDTotal2.setSumHrsSat(root.getHPRD_total_sat2());
				HPRDTotal2.setSumHrsSun(root.getHPRD_total_sun2());
				HPRDTotal2.setSumHrsWeekTotal(root.getHPRD_total2());
				HPRDTotal2.setSumHrsAnnual(Constants.DEFAULT_DECIMAL_VALUE);
				
				Collections.addAll(LTCStaffPlanPosSubtotal, RNSubtotal2, LPNSubtotal2, NursingProfSubtotal2, HCASubtotal2,
				NursingNonProfSubtotal2, NursingSubtotal2, AlliedProfSubtotal2, AlliedProfScheduledSubtotal2, AlliedNonProfSubtotal2,
				AlliedNonProfScheduledSubtotal2, AlliedSubtotal2, NursingAndAlliedSubtotal2, HPRDNursingTotal2, HPRDAlliedTotal2,
				HPRDTotal2);

			}

			if(root.getStaffingPlanType3() != null && !root.getStaffingPlanType3().isEmpty()){
				LTCStaffingPlan LTCStaffingPlan3 = new LTCStaffingPlan();
				LTCStaffingPlan3.setConfirmationId(root.getForm().getConfirmationId());
				LTCStaffingPlan3.setStaffingPlanNum("3");
				LTCStaffingPlan3.setStaffPlanFor(root.getStaffingPlanType3());
				LTCStaffingPlan3.setPeriodStart(root.getPeriodStartDate3());
				LTCStaffingPlan3.setPeriodEnd(root.getPeriodEndDate3());
				LTCStaffingPlan3.setRevisionDate(root.getRevisionDate3());
				LTCStaffingPlan3.setReasonForRev(root.getRevisionReason3());
				LTCStaffingPlan3.setNbTotalBeds(root.getNumberOfTotalBeds3());
				LTCStaffingPlan3.setCumulative_Total_DCH_Q1(root.getDCH_q13());
				LTCStaffingPlan3.setCumulative_Total_DCH_Q2(root.getDCH_q23());
				LTCStaffingPlan3.setCumulative_Total_DCH_Q3(root.getDCH_q33());
				LTCStaffingPlan3.setCumulative_Total_DCH_Q4(root.getDCH_q43());
				LTCStaffingPlan3.setPerf_4_1(root.getMinimumRN3());
				LTCStaffingPlan3.setStaffPlanForOther(root.getDoesTheStaffingPatternProvideNote3());
				LTCStaffingPlan3.setProfessional_Staffing_Percentage(root.getProf_staff_percentage3());
				LTCStaffingPlan3.setRn_lpn_Staffing_Percentage(root.getRN_LPN_staff_percentage3());

				LTCstaffingPlan.add(LTCStaffingPlan3);

				LTCStaffPlanPosSubtotal RNSubtotal3 = new LTCStaffPlanPosSubtotal();
				RNSubtotal3.setConfirmationId(root.getForm().getConfirmationId());
				RNSubtotal3.setStaffingPlanNum("3");
				RNSubtotal3.setStaffingType(root.getRn_label1());
				RNSubtotal3.setSumHrsMon(root.getRn_mon_total3());
				RNSubtotal3.setSumHrsTue(root.getRn_tue_total3());
				RNSubtotal3.setSumHrsWed(root.getRn_wed_total3());
				RNSubtotal3.setSumHrsThu(root.getRn_thu_total3());
				RNSubtotal3.setSumHrsFri(root.getRn_fri_total3());
				RNSubtotal3.setSumHrsSat(root.getRn_sat_total3());
				RNSubtotal3.setSumHrsSun(root.getRn_sun_total3());
				RNSubtotal3.setSumHrsWeekTotal(root.getRn_week_total3());
				RNSubtotal3.setSumHrsAnnual(root.getRn_annual_total3());
	
				LTCStaffPlanPosSubtotal LPNSubtotal3 = new LTCStaffPlanPosSubtotal();
				LPNSubtotal3.setConfirmationId(root.getForm().getConfirmationId());
				LPNSubtotal3.setStaffingPlanNum("3");
				LPNSubtotal3.setStaffingType(root.getLpn_label1());
				LPNSubtotal3.setSumHrsMon(root.getLpn_mon_total3());
				LPNSubtotal3.setSumHrsTue(root.getLpn_tue_total3());
				LPNSubtotal3.setSumHrsWed(root.getLpn_wed_total3());
				LPNSubtotal3.setSumHrsThu(root.getLpn_thu_total3());
				LPNSubtotal3.setSumHrsFri(root.getLpn_fri_total3());
				LPNSubtotal3.setSumHrsSat(root.getLpn_sat_total3());
				LPNSubtotal3.setSumHrsSun(root.getLpn_sun_total3());
				LPNSubtotal3.setSumHrsWeekTotal(root.getLpn_week_total3());
				LPNSubtotal3.setSumHrsAnnual(root.getLpn_annual_total3());
	
				LTCStaffPlanPosSubtotal NursingProfSubtotal3 = new LTCStaffPlanPosSubtotal();
				NursingProfSubtotal3.setConfirmationId(root.getForm().getConfirmationId());
				NursingProfSubtotal3.setStaffingPlanNum("3");
				NursingProfSubtotal3.setStaffingType(root.getNp_label1());
				NursingProfSubtotal3.setSumHrsMon(root.getNp_mon_total3());
				NursingProfSubtotal3.setSumHrsTue(root.getNp_tue_total3());
				NursingProfSubtotal3.setSumHrsWed(root.getNp_wed_total3());
				NursingProfSubtotal3.setSumHrsThu(root.getNp_thu_total3());
				NursingProfSubtotal3.setSumHrsFri(root.getNp_fri_total3());
				NursingProfSubtotal3.setSumHrsSat(root.getNp_sat_total3());
				NursingProfSubtotal3.setSumHrsSun(root.getNp_sun_total3());
				NursingProfSubtotal3.setSumHrsWeekTotal(root.getNp_week_total3());
				NursingProfSubtotal3.setSumHrsAnnual(root.getNp_annual_total3());
	
				LTCStaffPlanPosSubtotal HCASubtotal3 = new LTCStaffPlanPosSubtotal();
				HCASubtotal3.setConfirmationId(root.getForm().getConfirmationId());
				HCASubtotal3.setStaffingPlanNum("3");
				HCASubtotal3.setStaffingType(root.getHca_label1());
				HCASubtotal3.setSumHrsMon(root.getHca_mon_total3());
				HCASubtotal3.setSumHrsTue(root.getHca_tue_total3());
				HCASubtotal3.setSumHrsWed(root.getHca_wed_total3());
				HCASubtotal3.setSumHrsThu(root.getHca_thu_total3());
				HCASubtotal3.setSumHrsFri(root.getHca_fri_total3());
				HCASubtotal3.setSumHrsSat(root.getHca_sat_total3());
				HCASubtotal3.setSumHrsSun(root.getHca_sun_total3());
				HCASubtotal3.setSumHrsWeekTotal(root.getHca_week_total3());
				HCASubtotal3.setSumHrsAnnual(root.getHca_annual_total3());
	
				LTCStaffPlanPosSubtotal NursingNonProfSubtotal3 = new LTCStaffPlanPosSubtotal();
				NursingNonProfSubtotal3.setConfirmationId(root.getForm().getConfirmationId());
				NursingNonProfSubtotal3.setStaffingPlanNum("3");
				NursingNonProfSubtotal3.setStaffingType(root.getNnp_label1());
				NursingNonProfSubtotal3.setSumHrsMon(root.getNnp_mon_total3());
				NursingNonProfSubtotal3.setSumHrsTue(root.getNnp_tue_total3());
				NursingNonProfSubtotal3.setSumHrsWed(root.getNnp_wed_total3());
				NursingNonProfSubtotal3.setSumHrsThu(root.getNnp_thu_total3());
				NursingNonProfSubtotal3.setSumHrsFri(root.getNnp_fri_total3());
				NursingNonProfSubtotal3.setSumHrsSat(root.getNnp_sat_total3());
				NursingNonProfSubtotal3.setSumHrsSun(root.getNnp_sun_total3());
				NursingNonProfSubtotal3.setSumHrsWeekTotal(root.getNnp_week_total3());
				NursingNonProfSubtotal3.setSumHrsAnnual(root.getNnp_annual_total3());
	
				LTCStaffPlanPosSubtotal NursingSubtotal3 = new LTCStaffPlanPosSubtotal();
				NursingSubtotal3.setConfirmationId(root.getForm().getConfirmationId());
				NursingSubtotal3.setStaffingPlanNum("3");
				NursingSubtotal3.setStaffingType(root.getNursing_label1());
				NursingSubtotal3.setSumHrsMon(root.getNursing_mon_total3());
				NursingSubtotal3.setSumHrsTue(root.getNursing_tue_total3());
				NursingSubtotal3.setSumHrsWed(root.getNursing_wed_total3());
				NursingSubtotal3.setSumHrsThu(root.getNursing_thu_total3());
				NursingSubtotal3.setSumHrsFri(root.getNursing_fri_total3());
				NursingSubtotal3.setSumHrsSat(root.getNursing_sat_total3());
				NursingSubtotal3.setSumHrsSun(root.getNursing_sun_total3());
				NursingSubtotal3.setSumHrsWeekTotal(root.getNursing_week_total3());
				NursingSubtotal3.setSumHrsAnnual(root.getNursing_annual_total3());
	
				LTCStaffPlanPosSubtotal AlliedProfSubtotal3 = new LTCStaffPlanPosSubtotal();
				AlliedProfSubtotal3.setConfirmationId(root.getForm().getConfirmationId());
				AlliedProfSubtotal3.setStaffingPlanNum("3");
				AlliedProfSubtotal3.setStaffingType("Allied Professional");
				AlliedProfSubtotal3.setSumHrsMon(root.getAld_mon_total3());
				AlliedProfSubtotal3.setSumHrsTue(root.getAld_tue_total3());
				AlliedProfSubtotal3.setSumHrsWed(root.getAld_wed_total3());
				AlliedProfSubtotal3.setSumHrsThu(root.getAld_thu_total3());
				AlliedProfSubtotal3.setSumHrsFri(root.getAld_fri_total3());
				AlliedProfSubtotal3.setSumHrsSat(root.getAld_sat_total3());
				AlliedProfSubtotal3.setSumHrsSun(root.getAld_sun_total3());
				AlliedProfSubtotal3.setSumHrsWeekTotal(root.getAld_week_total3());
				AlliedProfSubtotal3.setSumHrsAnnual(root.getAld_annual_total3());
	
				LTCStaffPlanPosSubtotal AlliedProfScheduledSubtotal3 = new LTCStaffPlanPosSubtotal();
				AlliedProfScheduledSubtotal3.setConfirmationId(root.getForm().getConfirmationId());
				AlliedProfScheduledSubtotal3.setStaffingPlanNum("3");
				AlliedProfScheduledSubtotal3.setStaffingType(root.getAlliedProf_label1());
				AlliedProfScheduledSubtotal3.setSumHrsMon(root.getAlliedProf_mon_total3());
				AlliedProfScheduledSubtotal3.setSumHrsTue(root.getAlliedProf_tue_total3());
				AlliedProfScheduledSubtotal3.setSumHrsWed(root.getAlliedProf_wed_total3());
				AlliedProfScheduledSubtotal3.setSumHrsThu(root.getAlliedProf_thu_total3());
				AlliedProfScheduledSubtotal3.setSumHrsFri(root.getAlliedProf_fri_total3());
				AlliedProfScheduledSubtotal3.setSumHrsSat(root.getAlliedProf_sat_total3());
				AlliedProfScheduledSubtotal3.setSumHrsSun(root.getAlliedProf_sun_total3());
				AlliedProfScheduledSubtotal3.setSumHrsWeekTotal(root.getAlliedProf_week_total3());
				AlliedProfScheduledSubtotal3.setSumHrsAnnual(root.getAlliedProf_annual_total3());
	
				LTCStaffPlanPosSubtotal AlliedNonProfSubtotal3 = new LTCStaffPlanPosSubtotal();
				AlliedNonProfSubtotal3.setConfirmationId(root.getForm().getConfirmationId());
				AlliedNonProfSubtotal3.setStaffingPlanNum("3");
				AlliedNonProfSubtotal3.setStaffingType("Allied Non-Professional");
				AlliedNonProfSubtotal3.setSumHrsMon(root.getAldnop_mon_total3());
				AlliedNonProfSubtotal3.setSumHrsTue(root.getAldnop_tue_total3());
				AlliedNonProfSubtotal3.setSumHrsWed(root.getAldnop_wed_total3());
				AlliedNonProfSubtotal3.setSumHrsThu(root.getAldnop_thu_total3());
				AlliedNonProfSubtotal3.setSumHrsFri(root.getAldnop_fri_total3());
				AlliedNonProfSubtotal3.setSumHrsSat(root.getAldnop_sat_total3());
				AlliedNonProfSubtotal3.setSumHrsSun(root.getAldnop_sun_total3());
				AlliedNonProfSubtotal3.setSumHrsWeekTotal(root.getAldnop_week_total3());
				AlliedNonProfSubtotal3.setSumHrsAnnual(root.getAldnop_annual_total3());
				
	
				LTCStaffPlanPosSubtotal AlliedNonProfScheduledSubtotal3 = new LTCStaffPlanPosSubtotal();
				AlliedNonProfScheduledSubtotal3.setConfirmationId(root.getForm().getConfirmationId());
				AlliedNonProfScheduledSubtotal3.setStaffingPlanNum("3");
				AlliedNonProfScheduledSubtotal3.setStaffingType(root.getAlliedNP_label1());
				AlliedNonProfScheduledSubtotal3.setSumHrsMon(root.getAlliedNP_mon_total3());
				AlliedNonProfScheduledSubtotal3.setSumHrsTue(root.getAlliedNP_tue_total3());
				AlliedNonProfScheduledSubtotal3.setSumHrsWed(root.getAlliedNP_wed_total3());
				AlliedNonProfScheduledSubtotal3.setSumHrsThu(root.getAlliedNP_thu_total3());
				AlliedNonProfScheduledSubtotal3.setSumHrsFri(root.getAlliedNP_fri_total3());
				AlliedNonProfScheduledSubtotal3.setSumHrsSat(root.getAlliedNP_sat_total3());
				AlliedNonProfScheduledSubtotal3.setSumHrsSun(root.getAlliedNP_sun_total3());
				AlliedNonProfScheduledSubtotal3.setSumHrsWeekTotal(root.getAlliedNP_week_total3());
				AlliedNonProfScheduledSubtotal3.setSumHrsAnnual(root.getAlliedNP_annual_total3());
				
	
				LTCStaffPlanPosSubtotal AlliedSubtotal3 = new LTCStaffPlanPosSubtotal();
				AlliedSubtotal3.setConfirmationId(root.getForm().getConfirmationId());
				AlliedSubtotal3.setStaffingPlanNum("3");
				AlliedSubtotal3.setStaffingType(root.getAllied_label1());
				AlliedSubtotal3.setSumHrsMon(root.getAllied_mon_total3());
				AlliedSubtotal3.setSumHrsTue(root.getAllied_tue_total3());
				AlliedSubtotal3.setSumHrsWed(root.getAllied_wed_total3());
				AlliedSubtotal3.setSumHrsThu(root.getAllied_thu_total3());
				AlliedSubtotal3.setSumHrsFri(root.getAllied_fri_total3());
				AlliedSubtotal3.setSumHrsSat(root.getAllied_sat_total3());
				AlliedSubtotal3.setSumHrsSun(root.getAllied_sun_total3());
				AlliedSubtotal3.setSumHrsWeekTotal(root.getAllied_week_total3());
				AlliedSubtotal3.setSumHrsAnnual(root.getAllied_annual_total3());
				
				LTCStaffPlanPosSubtotal NursingAndAlliedSubtotal3 = new LTCStaffPlanPosSubtotal();
				NursingAndAlliedSubtotal3.setConfirmationId(root.getForm().getConfirmationId());
				NursingAndAlliedSubtotal3.setStaffingPlanNum("3");
				NursingAndAlliedSubtotal3.setStaffingType(root.getTotal_label1());
				NursingAndAlliedSubtotal3.setSumHrsMon(root.getMon_total3());
				NursingAndAlliedSubtotal3.setSumHrsTue(root.getTue_total3());
				NursingAndAlliedSubtotal3.setSumHrsWed(root.getWed_total3());
				NursingAndAlliedSubtotal3.setSumHrsThu(root.getThu_total3());
				NursingAndAlliedSubtotal3.setSumHrsFri(root.getFri_total3());
				NursingAndAlliedSubtotal3.setSumHrsSat(root.getSat_total3());
				NursingAndAlliedSubtotal3.setSumHrsSun(root.getSun_total3());
				NursingAndAlliedSubtotal3.setSumHrsWeekTotal(root.getWeek_total3());
				NursingAndAlliedSubtotal3.setSumHrsAnnual(root.getAnnual_total3());
				
				LTCStaffPlanPosSubtotal HPRDNursingTotal3 = new LTCStaffPlanPosSubtotal();
				HPRDNursingTotal3.setConfirmationId(root.getForm().getConfirmationId());
				HPRDNursingTotal3.setStaffingPlanNum("3");
				HPRDNursingTotal3.setStaffingType("HPRD Nursing");
				HPRDNursingTotal3.setSumHrsMon(root.getHPRD_nursing_mon3());
				HPRDNursingTotal3.setSumHrsTue(root.getHPRD_nursing_tue3());
				HPRDNursingTotal3.setSumHrsWed(root.getHPRD_nursing_wed3());
				HPRDNursingTotal3.setSumHrsThu(root.getHPRD_nursing_thu3());
				HPRDNursingTotal3.setSumHrsFri(root.getHPRD_nursing_fri3());
				HPRDNursingTotal3.setSumHrsSat(root.getHPRD_nursing_sat3());
				HPRDNursingTotal3.setSumHrsSun(root.getHPRD_nursing_sun3());
				HPRDNursingTotal3.setSumHrsWeekTotal(root.getHPRD_nursing_total3());
				HPRDNursingTotal3.setSumHrsAnnual(Constants.DEFAULT_DECIMAL_VALUE);
				
				LTCStaffPlanPosSubtotal HPRDAlliedTotal3 = new LTCStaffPlanPosSubtotal();
				HPRDAlliedTotal3.setConfirmationId(root.getForm().getConfirmationId());
				HPRDAlliedTotal3.setStaffingPlanNum("3");
				HPRDAlliedTotal3.setStaffingType("HPRD Allied");
				HPRDAlliedTotal3.setSumHrsMon(root.getHPRD_allied_mon3());
				HPRDAlliedTotal3.setSumHrsTue(root.getHPRD_allied_tue3());
				HPRDAlliedTotal3.setSumHrsWed(root.getHPRD_allied_wed3());
				HPRDAlliedTotal3.setSumHrsThu(root.getHPRD_allied_thu3());
				HPRDAlliedTotal3.setSumHrsFri(root.getHPRD_allied_fri3());
				HPRDAlliedTotal3.setSumHrsSat(root.getHPRD_allied_sat3());
				HPRDAlliedTotal3.setSumHrsSun(root.getHPRD_allied_sun3());
				HPRDAlliedTotal3.setSumHrsWeekTotal(root.getHPRD_allied_total3());
				HPRDAlliedTotal3.setSumHrsAnnual(Constants.DEFAULT_DECIMAL_VALUE);
				
				LTCStaffPlanPosSubtotal HPRDTotal3 = new LTCStaffPlanPosSubtotal();
				HPRDTotal3.setConfirmationId(root.getForm().getConfirmationId());
				HPRDTotal3.setStaffingPlanNum("3");
				HPRDTotal3.setStaffingType("HPRD Total");
				HPRDTotal3.setSumHrsMon(root.getHPRD_total_mon3());
				HPRDTotal3.setSumHrsTue(root.getHprdTotalTue3());
				HPRDTotal3.setSumHrsWed(root.getWed_total3());
				HPRDTotal3.setSumHrsThu(root.getHPRD_total_thu3());
				HPRDTotal3.setSumHrsFri(root.getHPRD_total_fri3());
				HPRDTotal3.setSumHrsSat(root.getHPRD_total_sat3());
				HPRDTotal3.setSumHrsSun(root.getHPRD_total_sun3());
				HPRDTotal3.setSumHrsWeekTotal(root.getHPRD_total3());
				HPRDTotal3.setSumHrsAnnual(Constants.DEFAULT_DECIMAL_VALUE);
				
				Collections.addAll(LTCStaffPlanPosSubtotal, RNSubtotal3, LPNSubtotal3, NursingProfSubtotal3, HCASubtotal3,
				NursingNonProfSubtotal3, NursingSubtotal3, AlliedProfSubtotal3, AlliedProfScheduledSubtotal3, AlliedNonProfSubtotal3,
				AlliedNonProfScheduledSubtotal3, AlliedSubtotal3, NursingAndAlliedSubtotal3, HPRDNursingTotal3, HPRDAlliedTotal3,
				HPRDTotal3);

			}
			
			if(root.getStaffingPlanType4() != null && !root.getStaffingPlanType4().isEmpty()){
				LTCStaffingPlan LTCStaffingPlan4 = new LTCStaffingPlan();
				LTCStaffingPlan4.setConfirmationId(root.getForm().getConfirmationId());
				LTCStaffingPlan4.setStaffingPlanNum("4");
				LTCStaffingPlan4.setStaffPlanFor(root.getStaffingPlanType4());
				LTCStaffingPlan4.setPeriodStart(root.getPeriodStartDate4());
				LTCStaffingPlan4.setPeriodEnd(root.getPeriodEndDate4());
				LTCStaffingPlan4.setRevisionDate(root.getRevisionDate4());
				LTCStaffingPlan4.setReasonForRev(root.getRevisionReason4());
				LTCStaffingPlan4.setNbTotalBeds(root.getNumberOfTotalBeds4());
				LTCStaffingPlan4.setCumulative_Total_DCH_Q1(root.getDCH_q14());
				LTCStaffingPlan4.setCumulative_Total_DCH_Q2(root.getDCH_q24());
				LTCStaffingPlan4.setCumulative_Total_DCH_Q3(root.getDCH_q34());
				LTCStaffingPlan4.setCumulative_Total_DCH_Q4(root.getDCH_q44());
				LTCStaffingPlan4.setPerf_4_1(root.getMinimumRN4());
				LTCStaffingPlan4.setStaffPlanForOther(root.getDoesTheStaffingPatternProvideNote4());
				LTCStaffingPlan4.setProfessional_Staffing_Percentage(root.getProf_staff_percentage4());
				LTCStaffingPlan4.setRn_lpn_Staffing_Percentage(root.getRN_LPN_staff_percentage4());
				
				LTCstaffingPlan.add(LTCStaffingPlan4);

				LTCStaffPlanPosSubtotal RNSubtotal4 = new LTCStaffPlanPosSubtotal();
				RNSubtotal4.setConfirmationId(root.getForm().getConfirmationId());
				RNSubtotal4.setStaffingPlanNum("4");
				RNSubtotal4.setStaffingType(root.getRn_label1());
				RNSubtotal4.setSumHrsMon(root.getRn_mon_total4());
				RNSubtotal4.setSumHrsTue(root.getRn_tue_total4());
				RNSubtotal4.setSumHrsWed(root.getRn_wed_total4());
				RNSubtotal4.setSumHrsThu(root.getRn_thu_total4());
				RNSubtotal4.setSumHrsFri(root.getRn_fri_total4());
				RNSubtotal4.setSumHrsSat(root.getRn_sat_total4());
				RNSubtotal4.setSumHrsSun(root.getRn_sun_total4());
				RNSubtotal4.setSumHrsWeekTotal(root.getRn_week_total4());
				RNSubtotal4.setSumHrsAnnual(root.getRn_annual_total4());
	
				LTCStaffPlanPosSubtotal LPNSubtotal4 = new LTCStaffPlanPosSubtotal();
				LPNSubtotal4.setConfirmationId(root.getForm().getConfirmationId());
				LPNSubtotal4.setStaffingPlanNum("4");
				LPNSubtotal4.setStaffingType(root.getLpn_label1());
				LPNSubtotal4.setSumHrsMon(root.getLpn_mon_total4());
				LPNSubtotal4.setSumHrsTue(root.getLpn_tue_total4());
				LPNSubtotal4.setSumHrsWed(root.getLpn_wed_total4());
				LPNSubtotal4.setSumHrsThu(root.getLpn_thu_total4());
				LPNSubtotal4.setSumHrsFri(root.getLpn_fri_total4());
				LPNSubtotal4.setSumHrsSat(root.getLpn_sat_total4());
				LPNSubtotal4.setSumHrsSun(root.getLpn_sun_total4());
				LPNSubtotal4.setSumHrsWeekTotal(root.getLpn_week_total4());
				LPNSubtotal4.setSumHrsAnnual(root.getLpn_annual_total4());
	
				LTCStaffPlanPosSubtotal NursingProfSubtotal4 = new LTCStaffPlanPosSubtotal();
				NursingProfSubtotal4.setConfirmationId(root.getForm().getConfirmationId());
				NursingProfSubtotal4.setStaffingPlanNum("4");
				NursingProfSubtotal4.setStaffingType(root.getNp_label1());
				NursingProfSubtotal4.setSumHrsMon(root.getNp_mon_total4());
				NursingProfSubtotal4.setSumHrsTue(root.getNp_tue_total4());
				NursingProfSubtotal4.setSumHrsWed(root.getNp_wed_total4());
				NursingProfSubtotal4.setSumHrsThu(root.getNp_thu_total4());
				NursingProfSubtotal4.setSumHrsFri(root.getNp_fri_total4());
				NursingProfSubtotal4.setSumHrsSat(root.getNp_sat_total4());
				NursingProfSubtotal4.setSumHrsSun(root.getNp_sun_total4());
				NursingProfSubtotal4.setSumHrsWeekTotal(root.getNp_week_total4());
				NursingProfSubtotal4.setSumHrsAnnual(root.getNp_annual_total4());
	
				LTCStaffPlanPosSubtotal HCASubtotal4 = new LTCStaffPlanPosSubtotal();
				HCASubtotal4.setConfirmationId(root.getForm().getConfirmationId());
				HCASubtotal4.setStaffingPlanNum("4");
				HCASubtotal4.setStaffingType(root.getHca_label1());
				HCASubtotal4.setSumHrsMon(root.getHca_mon_total4());
				HCASubtotal4.setSumHrsTue(root.getHca_tue_total4());
				HCASubtotal4.setSumHrsWed(root.getHca_wed_total4());
				HCASubtotal4.setSumHrsThu(root.getHca_thu_total4());
				HCASubtotal4.setSumHrsFri(root.getHca_fri_total4());
				HCASubtotal4.setSumHrsSat(root.getHca_sat_total4());
				HCASubtotal4.setSumHrsSun(root.getHca_sun_total4());
				HCASubtotal4.setSumHrsWeekTotal(root.getHca_week_total4());
				HCASubtotal4.setSumHrsAnnual(root.getHca_annual_total4());
	
				LTCStaffPlanPosSubtotal NursingNonProfSubtotal4 = new LTCStaffPlanPosSubtotal();
				NursingNonProfSubtotal4.setConfirmationId(root.getForm().getConfirmationId());
				NursingNonProfSubtotal4.setStaffingPlanNum("4");
				NursingNonProfSubtotal4.setStaffingType(root.getNnp_label1());
				NursingNonProfSubtotal4.setSumHrsMon(root.getNnp_mon_total4());
				NursingNonProfSubtotal4.setSumHrsTue(root.getNnp_tue_total4());
				NursingNonProfSubtotal4.setSumHrsWed(root.getNnp_wed_total4());
				NursingNonProfSubtotal4.setSumHrsThu(root.getNnp_thu_total4());
				NursingNonProfSubtotal4.setSumHrsFri(root.getNnp_fri_total4());
				NursingNonProfSubtotal4.setSumHrsSat(root.getNnp_sat_total4());
				NursingNonProfSubtotal4.setSumHrsSun(root.getNnp_sun_total4());
				NursingNonProfSubtotal4.setSumHrsWeekTotal(root.getNnp_week_total4());
				NursingNonProfSubtotal4.setSumHrsAnnual(root.getNnp_annual_total4());
	
				LTCStaffPlanPosSubtotal NursingSubtotal4 = new LTCStaffPlanPosSubtotal();
				NursingSubtotal4.setConfirmationId(root.getForm().getConfirmationId());
				NursingSubtotal4.setStaffingPlanNum("4");
				NursingSubtotal4.setStaffingType(root.getNursing_label1());
				NursingSubtotal4.setSumHrsMon(root.getNursing_mon_total4());
				NursingSubtotal4.setSumHrsTue(root.getNursing_tue_total4());
				NursingSubtotal4.setSumHrsWed(root.getNursing_wed_total4());
				NursingSubtotal4.setSumHrsThu(root.getNursing_thu_total4());
				NursingSubtotal4.setSumHrsFri(root.getNursing_fri_total4());
				NursingSubtotal4.setSumHrsSat(root.getNursing_sat_total4());
				NursingSubtotal4.setSumHrsSun(root.getNursing_sun_total4());
				NursingSubtotal4.setSumHrsWeekTotal(root.getNursing_week_total4());
				NursingSubtotal4.setSumHrsAnnual(root.getNursing_annual_total4());
	
				LTCStaffPlanPosSubtotal AlliedProfSubtotal4 = new LTCStaffPlanPosSubtotal();
				AlliedProfSubtotal4.setConfirmationId(root.getForm().getConfirmationId());
				AlliedProfSubtotal4.setStaffingPlanNum("4");
				AlliedProfSubtotal4.setStaffingType("Allied Professional");
				AlliedProfSubtotal4.setSumHrsMon(root.getAld_mon_total4());
				AlliedProfSubtotal4.setSumHrsTue(root.getAld_tue_total4());
				AlliedProfSubtotal4.setSumHrsWed(root.getAld_wed_total4());
				AlliedProfSubtotal4.setSumHrsThu(root.getAld_thu_total4());
				AlliedProfSubtotal4.setSumHrsFri(root.getAld_fri_total4());
				AlliedProfSubtotal4.setSumHrsSat(root.getAld_sat_total4());
				AlliedProfSubtotal4.setSumHrsSun(root.getAld_sun_total4());
				AlliedProfSubtotal4.setSumHrsWeekTotal(root.getAld_week_total4());
				AlliedProfSubtotal4.setSumHrsAnnual(root.getAld_annual_total4());
	
				LTCStaffPlanPosSubtotal AlliedProfScheduledSubtotal4 = new LTCStaffPlanPosSubtotal();
				AlliedProfScheduledSubtotal4.setConfirmationId(root.getForm().getConfirmationId());
				AlliedProfScheduledSubtotal4.setStaffingPlanNum("4");
				AlliedProfScheduledSubtotal4.setStaffingType(root.getAlliedProf_label1());
				AlliedProfScheduledSubtotal4.setSumHrsMon(root.getAlliedProf_mon_total4());
				AlliedProfScheduledSubtotal4.setSumHrsTue(root.getAlliedProf_tue_total4());
				AlliedProfScheduledSubtotal4.setSumHrsWed(root.getAlliedProf_wed_total4());
				AlliedProfScheduledSubtotal4.setSumHrsThu(root.getAlliedProf_thu_total4());
				AlliedProfScheduledSubtotal4.setSumHrsFri(root.getAlliedProf_fri_total4());
				AlliedProfScheduledSubtotal4.setSumHrsSat(root.getAlliedProf_sat_total4());
				AlliedProfScheduledSubtotal4.setSumHrsSun(root.getAlliedProf_sun_total4());
				AlliedProfScheduledSubtotal4.setSumHrsWeekTotal(root.getAlliedProf_week_total4());
				AlliedProfScheduledSubtotal4.setSumHrsAnnual(root.getAlliedProf_annual_total4());
	
				LTCStaffPlanPosSubtotal AlliedNonProfSubtotal4 = new LTCStaffPlanPosSubtotal();
				AlliedNonProfSubtotal4.setConfirmationId(root.getForm().getConfirmationId());
				AlliedNonProfSubtotal4.setStaffingPlanNum("4");
				AlliedNonProfSubtotal4.setStaffingType("Allied Non-Professional");
				AlliedNonProfSubtotal4.setSumHrsMon(root.getAldnop_mon_total4());
				AlliedNonProfSubtotal4.setSumHrsTue(root.getAldnop_tue_total4());
				AlliedNonProfSubtotal4.setSumHrsWed(root.getAldnop_wed_total4());
				AlliedNonProfSubtotal4.setSumHrsThu(root.getAldnop_thu_total4());
				AlliedNonProfSubtotal4.setSumHrsFri(root.getAldnop_fri_total4());
				AlliedNonProfSubtotal4.setSumHrsSat(root.getAldnop_sat_total4());
				AlliedNonProfSubtotal4.setSumHrsSun(root.getAldnop_sun_total4());
				AlliedNonProfSubtotal4.setSumHrsWeekTotal(root.getAldnop_week_total4());
				AlliedNonProfSubtotal4.setSumHrsAnnual(root.getAldnop_annual_total4());
				
	
				LTCStaffPlanPosSubtotal AlliedNonProfScheduledSubtotal4 = new LTCStaffPlanPosSubtotal();
				AlliedNonProfScheduledSubtotal4.setConfirmationId(root.getForm().getConfirmationId());
				AlliedNonProfScheduledSubtotal4.setStaffingPlanNum("4");
				AlliedNonProfScheduledSubtotal4.setStaffingType(root.getAlliedNP_label1());
				AlliedNonProfScheduledSubtotal4.setSumHrsMon(root.getAlliedNP_mon_total4());
				AlliedNonProfScheduledSubtotal4.setSumHrsTue(root.getAlliedNP_tue_total4());
				AlliedNonProfScheduledSubtotal4.setSumHrsWed(root.getAlliedNP_wed_total4());
				AlliedNonProfScheduledSubtotal4.setSumHrsThu(root.getAlliedNP_thu_total4());
				AlliedNonProfScheduledSubtotal4.setSumHrsFri(root.getAlliedNP_fri_total4());
				AlliedNonProfScheduledSubtotal4.setSumHrsSat(root.getAlliedNP_sat_total4());
				AlliedNonProfScheduledSubtotal4.setSumHrsSun(root.getAlliedNP_sun_total4());
				AlliedNonProfScheduledSubtotal4.setSumHrsWeekTotal(root.getAlliedNP_week_total4());
				AlliedNonProfScheduledSubtotal4.setSumHrsAnnual(root.getAlliedNP_annual_total4());
				
	
				LTCStaffPlanPosSubtotal AlliedSubtotal4 = new LTCStaffPlanPosSubtotal();
				AlliedSubtotal4.setConfirmationId(root.getForm().getConfirmationId());
				AlliedSubtotal4.setStaffingPlanNum("4");
				AlliedSubtotal4.setStaffingType(root.getAllied_label1());
				AlliedSubtotal4.setSumHrsMon(root.getAllied_mon_total4());
				AlliedSubtotal4.setSumHrsTue(root.getAllied_tue_total4());
				AlliedSubtotal4.setSumHrsWed(root.getAllied_wed_total4());
				AlliedSubtotal4.setSumHrsThu(root.getAllied_thu_total4());
				AlliedSubtotal4.setSumHrsFri(root.getAllied_fri_total4());
				AlliedSubtotal4.setSumHrsSat(root.getAllied_sat_total4());
				AlliedSubtotal4.setSumHrsSun(root.getAllied_sun_total4());
				AlliedSubtotal4.setSumHrsWeekTotal(root.getAllied_week_total4());
				AlliedSubtotal4.setSumHrsAnnual(root.getAllied_annual_total4());
				
				LTCStaffPlanPosSubtotal NursingAndAlliedSubtotal4 = new LTCStaffPlanPosSubtotal();
				NursingAndAlliedSubtotal4.setConfirmationId(root.getForm().getConfirmationId());
				NursingAndAlliedSubtotal4.setStaffingPlanNum("4");
				NursingAndAlliedSubtotal4.setStaffingType(root.getTotal_label1());
				NursingAndAlliedSubtotal4.setSumHrsMon(root.getMon_total4());
				NursingAndAlliedSubtotal4.setSumHrsTue(root.getTue_total4());
				NursingAndAlliedSubtotal4.setSumHrsWed(root.getWed_total4());
				NursingAndAlliedSubtotal4.setSumHrsThu(root.getThu_total4());
				NursingAndAlliedSubtotal4.setSumHrsFri(root.getFri_total4());
				NursingAndAlliedSubtotal4.setSumHrsSat(root.getSat_total4());
				NursingAndAlliedSubtotal4.setSumHrsSun(root.getSun_total4());
				NursingAndAlliedSubtotal4.setSumHrsWeekTotal(root.getWeek_total4());
				NursingAndAlliedSubtotal4.setSumHrsAnnual(root.getAnnual_total4());
				
				LTCStaffPlanPosSubtotal HPRDNursingTotal4 = new LTCStaffPlanPosSubtotal();
				HPRDNursingTotal4.setConfirmationId(root.getForm().getConfirmationId());
				HPRDNursingTotal4.setStaffingPlanNum("4");
				HPRDNursingTotal4.setStaffingType("HPRD Nursing");
				HPRDNursingTotal4.setSumHrsMon(root.getHPRD_nursing_mon4());
				HPRDNursingTotal4.setSumHrsTue(root.getHPRD_nursing_tue4());
				HPRDNursingTotal4.setSumHrsWed(root.getHPRD_nursing_wed4());
				HPRDNursingTotal4.setSumHrsThu(root.getHPRD_nursing_thu4());
				HPRDNursingTotal4.setSumHrsFri(root.getHPRD_nursing_fri4());
				HPRDNursingTotal4.setSumHrsSat(root.getHPRD_nursing_sat4());
				HPRDNursingTotal4.setSumHrsSun(root.getHPRD_nursing_sun4());
				HPRDNursingTotal4.setSumHrsWeekTotal(root.getHPRD_nursing_total4());
				HPRDNursingTotal4.setSumHrsAnnual(Constants.DEFAULT_DECIMAL_VALUE);
				
				LTCStaffPlanPosSubtotal HPRDAlliedTotal4 = new LTCStaffPlanPosSubtotal();
				HPRDAlliedTotal4.setConfirmationId(root.getForm().getConfirmationId());
				HPRDAlliedTotal4.setStaffingPlanNum("4");
				HPRDAlliedTotal4.setStaffingType("HPRD Allied");
				HPRDAlliedTotal4.setSumHrsMon(root.getHPRD_allied_mon4());
				HPRDAlliedTotal4.setSumHrsTue(root.getHPRD_allied_tue4());
				HPRDAlliedTotal4.setSumHrsWed(root.getHPRD_allied_wed4());
				HPRDAlliedTotal4.setSumHrsThu(root.getHPRD_allied_thu4());
				HPRDAlliedTotal4.setSumHrsFri(root.getHPRD_allied_fri4());
				HPRDAlliedTotal4.setSumHrsSat(root.getHPRD_allied_sat4());
				HPRDAlliedTotal4.setSumHrsSun(root.getHPRD_allied_sun4());
				HPRDAlliedTotal4.setSumHrsWeekTotal(root.getHPRD_allied_total4());
				HPRDAlliedTotal4.setSumHrsAnnual(Constants.DEFAULT_DECIMAL_VALUE);
				
				LTCStaffPlanPosSubtotal HPRDTotal4 = new LTCStaffPlanPosSubtotal();
				HPRDTotal4.setConfirmationId(root.getForm().getConfirmationId());
				HPRDTotal4.setStaffingPlanNum("4");
				HPRDTotal4.setStaffingType("HPRD Total");
				HPRDTotal4.setSumHrsMon(root.getHPRD_total_mon4());
				HPRDTotal4.setSumHrsTue(root.getHprdTotalTue4());
				HPRDTotal4.setSumHrsWed(root.getWed_total4());
				HPRDTotal4.setSumHrsThu(root.getHPRD_total_thu4());
				HPRDTotal4.setSumHrsFri(root.getHPRD_total_fri4());
				HPRDTotal4.setSumHrsSat(root.getHPRD_total_sat4());
				HPRDTotal4.setSumHrsSun(root.getHPRD_total_sun4());
				HPRDTotal4.setSumHrsWeekTotal(root.getHPRD_total4());
				HPRDTotal4.setSumHrsAnnual(Constants.DEFAULT_DECIMAL_VALUE);
				
				Collections.addAll(LTCStaffPlanPosSubtotal, RNSubtotal4, LPNSubtotal4, NursingProfSubtotal4, HCASubtotal4,
				NursingNonProfSubtotal4, NursingSubtotal4, AlliedProfSubtotal4, AlliedProfScheduledSubtotal4, AlliedNonProfSubtotal4,
				AlliedNonProfScheduledSubtotal4, AlliedSubtotal4, NursingAndAlliedSubtotal4, HPRDNursingTotal4, HPRDAlliedTotal4,
				HPRDTotal4);
			}
			
			if(root.getStaffingPlanType5() != null && !root.getStaffingPlanType5().isEmpty()){
				LTCStaffingPlan LTCStaffingPlan5 = new LTCStaffingPlan();
				LTCStaffingPlan5.setConfirmationId(root.getForm().getConfirmationId());
				LTCStaffingPlan5.setStaffingPlanNum("5");
				LTCStaffingPlan5.setStaffPlanFor(root.getStaffingPlanType5());
				LTCStaffingPlan5.setPeriodStart(root.getPeriodStartDate5());
				LTCStaffingPlan5.setPeriodEnd(root.getPeriodEndDate5());
				LTCStaffingPlan5.setRevisionDate(root.getRevisionDate5());
				LTCStaffingPlan5.setReasonForRev(root.getRevisionReason5());
				LTCStaffingPlan5.setNbTotalBeds(root.getNumberOfTotalBeds5());
				LTCStaffingPlan5.setCumulative_Total_DCH_Q1(root.getDCH_q15());
				LTCStaffingPlan5.setCumulative_Total_DCH_Q2(root.getDCH_q25());
				LTCStaffingPlan5.setCumulative_Total_DCH_Q3(root.getDCH_q35());
				LTCStaffingPlan5.setCumulative_Total_DCH_Q4(root.getDCH_q45());
				LTCStaffingPlan5.setPerf_4_1(root.getMinimumRN5());
				LTCStaffingPlan5.setStaffPlanForOther(root.getDoesTheStaffingPatternProvideNote5());
				LTCStaffingPlan5.setProfessional_Staffing_Percentage(root.getProf_staff_percentage5());
				LTCStaffingPlan5.setRn_lpn_Staffing_Percentage(root.getRN_LPN_staff_percentage5());
	
				LTCstaffingPlan.add(LTCStaffingPlan5);

				LTCStaffPlanPosSubtotal RNSubtotal5 = new LTCStaffPlanPosSubtotal();
				RNSubtotal5.setConfirmationId(root.getForm().getConfirmationId());
				RNSubtotal5.setStaffingPlanNum("5");
				RNSubtotal5.setStaffingType(root.getRn_label1());
				RNSubtotal5.setSumHrsMon(root.getRn_mon_total5());
				RNSubtotal5.setSumHrsTue(root.getRn_tue_total5());
				RNSubtotal5.setSumHrsWed(root.getRn_wed_total5());
				RNSubtotal5.setSumHrsThu(root.getRn_thu_total5());
				RNSubtotal5.setSumHrsFri(root.getRn_fri_total5());
				RNSubtotal5.setSumHrsSat(root.getRn_sat_total5());
				RNSubtotal5.setSumHrsSun(root.getRn_sun_total5());
				RNSubtotal5.setSumHrsWeekTotal(root.getRn_week_total5());
				RNSubtotal5.setSumHrsAnnual(root.getRn_annual_total5());
	
				LTCStaffPlanPosSubtotal LPNSubtotal5 = new LTCStaffPlanPosSubtotal();
				LPNSubtotal5.setConfirmationId(root.getForm().getConfirmationId());
				LPNSubtotal5.setStaffingPlanNum("5");
				LPNSubtotal5.setStaffingType(root.getLpn_label1());
				LPNSubtotal5.setSumHrsMon(root.getLpn_mon_total5());
				LPNSubtotal5.setSumHrsTue(root.getLpn_tue_total5());
				LPNSubtotal5.setSumHrsWed(root.getLpn_wed_total5());
				LPNSubtotal5.setSumHrsThu(root.getLpn_thu_total5());
				LPNSubtotal5.setSumHrsFri(root.getLpn_fri_total5());
				LPNSubtotal5.setSumHrsSat(root.getLpn_sat_total5());
				LPNSubtotal5.setSumHrsSun(root.getLpn_sun_total5());
				LPNSubtotal5.setSumHrsWeekTotal(root.getLpn_week_total5());
				LPNSubtotal5.setSumHrsAnnual(root.getLpn_annual_total5());
	
				LTCStaffPlanPosSubtotal NursingProfSubtotal5 = new LTCStaffPlanPosSubtotal();
				NursingProfSubtotal5.setConfirmationId(root.getForm().getConfirmationId());
				NursingProfSubtotal5.setStaffingPlanNum("5");
				NursingProfSubtotal5.setStaffingType(root.getNp_label1());
				NursingProfSubtotal5.setSumHrsMon(root.getNp_mon_total5());
				NursingProfSubtotal5.setSumHrsTue(root.getNp_tue_total5());
				NursingProfSubtotal5.setSumHrsWed(root.getNp_wed_total5());
				NursingProfSubtotal5.setSumHrsThu(root.getNp_thu_total5());
				NursingProfSubtotal5.setSumHrsFri(root.getNp_fri_total5());
				NursingProfSubtotal5.setSumHrsSat(root.getNp_sat_total5());
				NursingProfSubtotal5.setSumHrsSun(root.getNp_sun_total5());
				NursingProfSubtotal5.setSumHrsWeekTotal(root.getNp_week_total5());
				NursingProfSubtotal5.setSumHrsAnnual(root.getNp_annual_total5());
	
				LTCStaffPlanPosSubtotal HCASubtotal5 = new LTCStaffPlanPosSubtotal();
				HCASubtotal5.setConfirmationId(root.getForm().getConfirmationId());
				HCASubtotal5.setStaffingPlanNum("5");
				HCASubtotal5.setStaffingType(root.getHca_label1());
				HCASubtotal5.setSumHrsMon(root.getHca_mon_total5());
				HCASubtotal5.setSumHrsTue(root.getHca_tue_total5());
				HCASubtotal5.setSumHrsWed(root.getHca_wed_total5());
				HCASubtotal5.setSumHrsThu(root.getHca_thu_total5());
				HCASubtotal5.setSumHrsFri(root.getHca_fri_total5());
				HCASubtotal5.setSumHrsSat(root.getHca_sat_total5());
				HCASubtotal5.setSumHrsSun(root.getHca_sun_total5());
				HCASubtotal5.setSumHrsWeekTotal(root.getHca_week_total5());
				HCASubtotal5.setSumHrsAnnual(root.getHca_annual_total5());
	
				LTCStaffPlanPosSubtotal NursingNonProfSubtotal5 = new LTCStaffPlanPosSubtotal();
				NursingNonProfSubtotal5.setConfirmationId(root.getForm().getConfirmationId());
				NursingNonProfSubtotal5.setStaffingPlanNum("5");
				NursingNonProfSubtotal5.setStaffingType(root.getNnp_label1());
				NursingNonProfSubtotal5.setSumHrsMon(root.getNnp_mon_total5());
				NursingNonProfSubtotal5.setSumHrsTue(root.getNnp_tue_total5());
				NursingNonProfSubtotal5.setSumHrsWed(root.getNnp_wed_total5());
				NursingNonProfSubtotal5.setSumHrsThu(root.getNnp_thu_total5());
				NursingNonProfSubtotal5.setSumHrsFri(root.getNnp_fri_total5());
				NursingNonProfSubtotal5.setSumHrsSat(root.getNnp_sat_total5());
				NursingNonProfSubtotal5.setSumHrsSun(root.getNnp_sun_total5());
				NursingNonProfSubtotal5.setSumHrsWeekTotal(root.getNnp_week_total5());
				NursingNonProfSubtotal5.setSumHrsAnnual(root.getNnp_annual_total5());
	
				LTCStaffPlanPosSubtotal NursingSubtotal5 = new LTCStaffPlanPosSubtotal();
				NursingSubtotal5.setConfirmationId(root.getForm().getConfirmationId());
				NursingSubtotal5.setStaffingPlanNum("5");
				NursingSubtotal5.setStaffingType(root.getNursing_label1());
				NursingSubtotal5.setSumHrsMon(root.getNursing_mon_total5());
				NursingSubtotal5.setSumHrsTue(root.getNursing_tue_total5());
				NursingSubtotal5.setSumHrsWed(root.getNursing_wed_total5());
				NursingSubtotal5.setSumHrsThu(root.getNursing_thu_total5());
				NursingSubtotal5.setSumHrsFri(root.getNursing_fri_total5());
				NursingSubtotal5.setSumHrsSat(root.getNursing_sat_total5());
				NursingSubtotal5.setSumHrsSun(root.getNursing_sun_total5());
				NursingSubtotal5.setSumHrsWeekTotal(root.getNursing_week_total5());
				NursingSubtotal5.setSumHrsAnnual(root.getNursing_annual_total5());
	
				LTCStaffPlanPosSubtotal AlliedProfSubtotal5 = new LTCStaffPlanPosSubtotal();
				AlliedProfSubtotal5.setConfirmationId(root.getForm().getConfirmationId());
				AlliedProfSubtotal5.setStaffingPlanNum("5");
				AlliedProfSubtotal5.setStaffingType("Allied Professional");
				AlliedProfSubtotal5.setSumHrsMon(root.getAld_mon_total5());
				AlliedProfSubtotal5.setSumHrsTue(root.getAld_tue_total5());
				AlliedProfSubtotal5.setSumHrsWed(root.getAld_wed_total5());
				AlliedProfSubtotal5.setSumHrsThu(root.getAld_thu_total5());
				AlliedProfSubtotal5.setSumHrsFri(root.getAld_fri_total5());
				AlliedProfSubtotal5.setSumHrsSat(root.getAld_sat_total5());
				AlliedProfSubtotal5.setSumHrsSun(root.getAld_sun_total5());
				AlliedProfSubtotal5.setSumHrsWeekTotal(root.getAld_week_total5());
				AlliedProfSubtotal5.setSumHrsAnnual(root.getAld_annual_total5());
	
				LTCStaffPlanPosSubtotal AlliedProfScheduledSubtotal5 = new LTCStaffPlanPosSubtotal();
				AlliedProfScheduledSubtotal5.setConfirmationId(root.getForm().getConfirmationId());
				AlliedProfScheduledSubtotal5.setStaffingPlanNum("5");
				AlliedProfScheduledSubtotal5.setStaffingType(root.getAlliedProf_label1());
				AlliedProfScheduledSubtotal5.setSumHrsMon(root.getAlliedProf_mon_total5());
				AlliedProfScheduledSubtotal5.setSumHrsTue(root.getAlliedProf_tue_total5());
				AlliedProfScheduledSubtotal5.setSumHrsWed(root.getAlliedProf_wed_total5());
				AlliedProfScheduledSubtotal5.setSumHrsThu(root.getAlliedProf_thu_total5());
				AlliedProfScheduledSubtotal5.setSumHrsFri(root.getAlliedProf_fri_total5());
				AlliedProfScheduledSubtotal5.setSumHrsSat(root.getAlliedProf_sat_total5());
				AlliedProfScheduledSubtotal5.setSumHrsSun(root.getAlliedProf_sun_total5());
				AlliedProfScheduledSubtotal5.setSumHrsWeekTotal(root.getAlliedProf_week_total5());
				AlliedProfScheduledSubtotal5.setSumHrsAnnual(root.getAlliedProf_annual_total5());
	
				LTCStaffPlanPosSubtotal AlliedNonProfSubtotal5 = new LTCStaffPlanPosSubtotal();
				AlliedNonProfSubtotal5.setConfirmationId(root.getForm().getConfirmationId());
				AlliedNonProfSubtotal5.setStaffingPlanNum("5");
				AlliedNonProfSubtotal5.setStaffingType("Allied Non-Professional");
				AlliedNonProfSubtotal5.setSumHrsMon(root.getAldnop_mon_total5());
				AlliedNonProfSubtotal5.setSumHrsTue(root.getAldnop_tue_total5());
				AlliedNonProfSubtotal5.setSumHrsWed(root.getAldnop_wed_total5());
				AlliedNonProfSubtotal5.setSumHrsThu(root.getAldnop_thu_total5());
				AlliedNonProfSubtotal5.setSumHrsFri(root.getAldnop_fri_total5());
				AlliedNonProfSubtotal5.setSumHrsSat(root.getAldnop_sat_total5());
				AlliedNonProfSubtotal5.setSumHrsSun(root.getAldnop_sun_total5());
				AlliedNonProfSubtotal5.setSumHrsWeekTotal(root.getAldnop_week_total5());
				AlliedNonProfSubtotal5.setSumHrsAnnual(root.getAldnop_annual_total5());
				
	
				LTCStaffPlanPosSubtotal AlliedNonProfScheduledSubtotal5 = new LTCStaffPlanPosSubtotal();
				AlliedNonProfScheduledSubtotal5.setConfirmationId(root.getForm().getConfirmationId());
				AlliedNonProfScheduledSubtotal5.setStaffingPlanNum("5");
				AlliedNonProfScheduledSubtotal5.setStaffingType(root.getAlliedNP_label1());
				AlliedNonProfScheduledSubtotal5.setSumHrsMon(root.getAlliedNP_mon_total5());
				AlliedNonProfScheduledSubtotal5.setSumHrsTue(root.getAlliedNP_tue_total5());
				AlliedNonProfScheduledSubtotal5.setSumHrsWed(root.getAlliedNP_wed_total5());
				AlliedNonProfScheduledSubtotal5.setSumHrsThu(root.getAlliedNP_thu_total5());
				AlliedNonProfScheduledSubtotal5.setSumHrsFri(root.getAlliedNP_fri_total5());
				AlliedNonProfScheduledSubtotal5.setSumHrsSat(root.getAlliedNP_sat_total5());
				AlliedNonProfScheduledSubtotal5.setSumHrsSun(root.getAlliedNP_sun_total5());
				AlliedNonProfScheduledSubtotal5.setSumHrsWeekTotal(root.getAlliedNP_week_total5());
				AlliedNonProfScheduledSubtotal5.setSumHrsAnnual(root.getAlliedNP_annual_total5());
				
	
				LTCStaffPlanPosSubtotal AlliedSubtotal5 = new LTCStaffPlanPosSubtotal();
				AlliedSubtotal5.setConfirmationId(root.getForm().getConfirmationId());
				AlliedSubtotal5.setStaffingPlanNum("5");
				AlliedSubtotal5.setStaffingType(root.getAllied_label1());
				AlliedSubtotal5.setSumHrsMon(root.getAllied_mon_total5());
				AlliedSubtotal5.setSumHrsTue(root.getAllied_tue_total5());
				AlliedSubtotal5.setSumHrsWed(root.getAllied_wed_total5());
				AlliedSubtotal5.setSumHrsThu(root.getAllied_thu_total5());
				AlliedSubtotal5.setSumHrsFri(root.getAllied_fri_total5());
				AlliedSubtotal5.setSumHrsSat(root.getAllied_sat_total5());
				AlliedSubtotal5.setSumHrsSun(root.getAllied_sun_total5());
				AlliedSubtotal5.setSumHrsWeekTotal(root.getAllied_week_total5());
				AlliedSubtotal5.setSumHrsAnnual(root.getAllied_annual_total5());
				
				LTCStaffPlanPosSubtotal NursingAndAlliedSubtotal5 = new LTCStaffPlanPosSubtotal();
				NursingAndAlliedSubtotal5.setConfirmationId(root.getForm().getConfirmationId());
				NursingAndAlliedSubtotal5.setStaffingPlanNum("5");
				NursingAndAlliedSubtotal5.setStaffingType(root.getTotal_label1());
				NursingAndAlliedSubtotal5.setSumHrsMon(root.getMon_total5());
				NursingAndAlliedSubtotal5.setSumHrsTue(root.getTue_total5());
				NursingAndAlliedSubtotal5.setSumHrsWed(root.getWed_total5());
				NursingAndAlliedSubtotal5.setSumHrsThu(root.getThu_total5());
				NursingAndAlliedSubtotal5.setSumHrsFri(root.getFri_total5());
				NursingAndAlliedSubtotal5.setSumHrsSat(root.getSat_total5());
				NursingAndAlliedSubtotal5.setSumHrsSun(root.getSun_total5());
				NursingAndAlliedSubtotal5.setSumHrsWeekTotal(root.getWeek_total5());
				NursingAndAlliedSubtotal5.setSumHrsAnnual(root.getAnnual_total5());
				
				LTCStaffPlanPosSubtotal HPRDNursingTotal5 = new LTCStaffPlanPosSubtotal();
				HPRDNursingTotal5.setConfirmationId(root.getForm().getConfirmationId());
				HPRDNursingTotal5.setStaffingPlanNum("5");
				HPRDNursingTotal5.setStaffingType("HPRD Nursing");
				HPRDNursingTotal5.setSumHrsMon(root.getHPRD_nursing_mon5());
				HPRDNursingTotal5.setSumHrsTue(root.getHPRD_nursing_tue5());
				HPRDNursingTotal5.setSumHrsWed(root.getHPRD_nursing_wed5());
				HPRDNursingTotal5.setSumHrsThu(root.getHPRD_nursing_thu5());
				HPRDNursingTotal5.setSumHrsFri(root.getHPRD_nursing_fri5());
				HPRDNursingTotal5.setSumHrsSat(root.getHPRD_nursing_sat5());
				HPRDNursingTotal5.setSumHrsSun(root.getHPRD_nursing_sun5());
				HPRDNursingTotal5.setSumHrsWeekTotal(root.getHPRD_nursing_total5());
				HPRDNursingTotal5.setSumHrsAnnual(Constants.DEFAULT_DECIMAL_VALUE);
				
				LTCStaffPlanPosSubtotal HPRDAlliedTotal5 = new LTCStaffPlanPosSubtotal();
				HPRDAlliedTotal5.setConfirmationId(root.getForm().getConfirmationId());
				HPRDAlliedTotal5.setStaffingPlanNum("5");
				HPRDAlliedTotal5.setStaffingType("HPRD Allied");
				HPRDAlliedTotal5.setSumHrsMon(root.getHPRD_allied_mon5());
				HPRDAlliedTotal5.setSumHrsTue(root.getHPRD_allied_tue5());
				HPRDAlliedTotal5.setSumHrsWed(root.getHPRD_allied_wed5());
				HPRDAlliedTotal5.setSumHrsThu(root.getHPRD_allied_thu5());
				HPRDAlliedTotal5.setSumHrsFri(root.getHPRD_allied_fri5());
				HPRDAlliedTotal5.setSumHrsSat(root.getHPRD_allied_sat5());
				HPRDAlliedTotal5.setSumHrsSun(root.getHPRD_allied_sun5());
				HPRDAlliedTotal5.setSumHrsWeekTotal(root.getHPRD_allied_total5());
				HPRDAlliedTotal5.setSumHrsAnnual(Constants.DEFAULT_DECIMAL_VALUE);
				
				LTCStaffPlanPosSubtotal HPRDTotal5 = new LTCStaffPlanPosSubtotal();
				HPRDTotal5.setConfirmationId(root.getForm().getConfirmationId());
				HPRDTotal5.setStaffingPlanNum("5");
				HPRDTotal5.setStaffingType("HPRD Total");
				HPRDTotal5.setSumHrsMon(root.getHPRD_total_mon5());
				HPRDTotal5.setSumHrsTue(root.getHprdTotalTue5());
				HPRDTotal5.setSumHrsWed(root.getWed_total5());
				HPRDTotal5.setSumHrsThu(root.getHPRD_total_thu5());
				HPRDTotal5.setSumHrsFri(root.getHPRD_total_fri5());
				HPRDTotal5.setSumHrsSat(root.getHPRD_total_sat5());
				HPRDTotal5.setSumHrsSun(root.getHPRD_total_sun5());
				HPRDTotal5.setSumHrsWeekTotal(root.getHPRD_total5());
				HPRDTotal5.setSumHrsAnnual(Constants.DEFAULT_DECIMAL_VALUE);
				
				Collections.addAll(LTCStaffPlanPosSubtotal, RNSubtotal5, LPNSubtotal5, NursingProfSubtotal5, HCASubtotal5,
				NursingNonProfSubtotal5, NursingSubtotal5, AlliedProfSubtotal5, AlliedProfScheduledSubtotal5, AlliedNonProfSubtotal5,
				AlliedNonProfScheduledSubtotal5, AlliedSubtotal5, NursingAndAlliedSubtotal5, HPRDNursingTotal5, HPRDAlliedTotal5,
				HPRDTotal5);
			}

			/* mapping LTC_STAFF_PLAN_PERF_4_2 */

			LTCStaffPlanPerf = StaffingPlanUtil.mapPlanPerf(LTCStaffPlanPerf, root.getDoesTheStaffingPatternProvide1(),
			root.getForm().getConfirmationId(), "1");

			LTCStaffPlanPerf = StaffingPlanUtil.mapPlanPerf(LTCStaffPlanPerf, root.getDoesTheStaffingPatternProvide2(),
			root.getForm().getConfirmationId(), "2");

			LTCStaffPlanPerf = StaffingPlanUtil.mapPlanPerf(LTCStaffPlanPerf, root.getDoesTheStaffingPatternProvide3(),
			root.getForm().getConfirmationId(), "3");

			LTCStaffPlanPerf = StaffingPlanUtil.mapPlanPerf(LTCStaffPlanPerf, root.getDoesTheStaffingPatternProvide4(),
			root.getForm().getConfirmationId(), "4");

			LTCStaffPlanPerf = StaffingPlanUtil.mapPlanPerf(LTCStaffPlanPerf, root.getDoesTheStaffingPatternProvide5(),
			root.getForm().getConfirmationId(), "5");

			/* mapping LTC_STAFF_PLAN_POS_TYPE */

			//LTCStaffPlanPosType LTCStaffPlan


			/* adding all other elements to LTCstaffingPlan */
			lTCstaffingPlanMainEntity.setLTCStaffingPlan(LTCstaffingPlan);
			lTCstaffingPlanMainEntity.setLTCStaffPlanPerf(LTCStaffPlanPerf);
			lTCstaffingPlanMainEntity.setLTCStaffPlanPosSubtotal(LTCStaffPlanPosSubtotal);
			lTCstaffingPlanMainEntity.setLTCStaffPlanPosType(LTCStaffPlanPosType);
			lTCstaffingPlanMainEntity.setLTCStaffingAddPos(LTCStaffingAddPos);
			lTCstaffingPlanMainEntity.setLTCStaffingHrs(LTCStaffingHrs);

			staffingPlanParsed.add(lTCstaffingPlanMainEntity);
		}
		return staffingPlanParsed;
	}
		
}
