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
import ca.bc.gov.chefs.etl.forms.ltc.staffing.json.AldDatagrid;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.json.AldNopDatagrid;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.json.NnpDatagrid;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.json.NpDatagrid;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.json.Root;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.model.LTCStaffPlanPerf;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.model.LTCStaffPlanPosSubtotal;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.model.LTCStaffPlanPosType;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.model.LTCStaffPlanSummarySubtotals;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.model.LTCStaffingAddPos;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.model.LTCStaffingHrs;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.model.LTCStaffingPlan;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.model.LTCStaffingSubmission;
import ca.bc.gov.chefs.etl.forms.ltc.staffing.util.StaffingPlanUtil;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.CommonUtils;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class LTCStaffingPlanApiResponseProcessor implements Processor {

	@Override
	@SuppressWarnings("unchecked")
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		payload = JsonUtil.roundDigitsNumber(payload);
		payload = StaffingPlanUtil.normaliseDoesTheStaffingPatternProvide(payload);
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
			List<LTCStaffPlanSummarySubtotals> LTCStaffPlanSummarySubtotals = new ArrayList<>();

			/* mapping LTCstaffingSubmission */
			lTCstaffingPlanMainEntity.setConfirmationId(root.getForm().getConfirmationId());
			lTCstaffingPlanMainEntity.setIsDeleted(String.valueOf(root.getForm().isDeleted()));
			lTCstaffingPlanMainEntity.setSubmissionDate(root.getForm().getCreatedAt());
			lTCstaffingPlanMainEntity.setSubmittedBy(root.getForm().getFullName());
			lTCstaffingPlanMainEntity.setCCIMSID(root.getCcimsid());
			lTCstaffingPlanMainEntity.setSubmission_FY(root.getFiscalYear());


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
	
			}

			//mapping LTC_STAFF_PLAN_POS_SUBTOTALS

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
			
			Collections.addAll(LTCStaffPlanPosSubtotal, NursingProfSubtotal1, NursingNonProfSubtotal1, NursingSubtotal1,
			AlliedProfSubtotal1, AlliedProfScheduledSubtotal1, AlliedNonProfSubtotal1,
			AlliedNonProfScheduledSubtotal1, AlliedSubtotal1, NursingAndAlliedSubtotal1, HPRDNursingTotal1, HPRDAlliedTotal1,
			HPRDTotal1);

			if(root.getStaffingPlanType2() != null && !root.getStaffingPlanType2().isEmpty()){
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
				
				Collections.addAll(LTCStaffPlanPosSubtotal, NursingProfSubtotal2, NursingNonProfSubtotal2, NursingSubtotal2,
				AlliedProfSubtotal2, AlliedProfScheduledSubtotal2, AlliedNonProfSubtotal2, AlliedNonProfScheduledSubtotal2,
				AlliedSubtotal2, NursingAndAlliedSubtotal2, HPRDNursingTotal2, HPRDAlliedTotal2, HPRDTotal2);
			}
			
			if(root.getStaffingPlanType3() != null && !root.getStaffingPlanType3().isEmpty()){

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
				
				Collections.addAll(LTCStaffPlanPosSubtotal, NursingProfSubtotal3, NursingNonProfSubtotal3, NursingSubtotal3,
				AlliedProfSubtotal3, AlliedProfScheduledSubtotal3, AlliedNonProfSubtotal3, AlliedNonProfScheduledSubtotal3,
				AlliedSubtotal3, NursingAndAlliedSubtotal3, HPRDNursingTotal3, HPRDAlliedTotal3, HPRDTotal3);
			}

			if(root.getStaffingPlanType4() != null && !root.getStaffingPlanType4().isEmpty()){
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
				
				Collections.addAll(LTCStaffPlanPosSubtotal, NursingProfSubtotal4, NursingNonProfSubtotal4, NursingSubtotal4, 
				AlliedProfSubtotal4, AlliedProfScheduledSubtotal4, AlliedNonProfSubtotal4, AlliedNonProfScheduledSubtotal4,
				AlliedSubtotal4, NursingAndAlliedSubtotal4, HPRDNursingTotal4, HPRDAlliedTotal4, HPRDTotal4);
			}

			if(root.getStaffingPlanType5() != null && !root.getStaffingPlanType5().isEmpty()){
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
				
				Collections.addAll(LTCStaffPlanPosSubtotal, NursingProfSubtotal5, NursingNonProfSubtotal5, NursingSubtotal5,
				AlliedProfSubtotal5, AlliedProfScheduledSubtotal5, AlliedNonProfSubtotal5, AlliedNonProfScheduledSubtotal5,
				AlliedSubtotal5, NursingAndAlliedSubtotal5, HPRDNursingTotal5, HPRDAlliedTotal5, HPRDTotal5);
			}
	
			/* Mapping Staffing Plan Pos Type */

			LTCStaffPlanPosType NurseRN1 = new LTCStaffPlanPosType();
			NurseRN1.setConfirmationId(root.getForm().getConfirmationId());
			NurseRN1.setStaffingPlanNum("1");
			NurseRN1.setStaffHrsPosType(root.getRn_label1());
			NurseRN1.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
			NurseRN1.setSumStaffHrsMon(root.getRn_mon_total1());
			NurseRN1.setSumStaffHrsTue(root.getRn_tue_total1());
			NurseRN1.setSumStaffHrsWed(root.getRn_wed_total1());
			NurseRN1.setSumStaffHrsThurs(root.getRn_thu_total1());
			NurseRN1.setSumStaffHrsFri(root.getRn_fri_total1());
			NurseRN1.setSumStaffHrsSat(root.getRn_sat_total1());
			NurseRN1.setSumStaffHrsSun(root.getRn_sun_total1());
			NurseRN1.setSumStaffHrsWkTotal(root.getRn_week_total1());
			NurseRN1.setSumStaffHrsAnnual(root.getRn_annual_total1());
			NurseRN1.setSumPosAnnual(root.getSummary_annual_RN1());
			NurseRN1.setSumPosInhouse(root.getSummary_inHouse_RN1());
			NurseRN1.setSumPosContracted(root.getSummary_contracted_RN1());

			LTCStaffPlanPosType NurseLPN1 = new LTCStaffPlanPosType();
			NurseLPN1.setConfirmationId(root.getForm().getConfirmationId());
			NurseLPN1.setStaffingPlanNum("1");
			NurseLPN1.setStaffHrsPosType(root.getLpn_label1());
			NurseLPN1.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
			NurseLPN1.setSumStaffHrsMon(root.getLpn_mon_total1());
			NurseLPN1.setSumStaffHrsTue(root.getLpn_tue_total1());
			NurseLPN1.setSumStaffHrsWed(root.getLpn_wed_total1());
			NurseLPN1.setSumStaffHrsThurs(root.getLpn_thu_total1());
			NurseLPN1.setSumStaffHrsFri(root.getLpn_fri_total1());
			NurseLPN1.setSumStaffHrsSat(root.getLpn_sat_total1());
			NurseLPN1.setSumStaffHrsSun(root.getLpn_sun_total1());
			NurseLPN1.setSumStaffHrsWkTotal(root.getLpn_week_total1());
			NurseLPN1.setSumStaffHrsAnnual(root.getLpn_annual_total1());
			NurseLPN1.setSumPosAnnual(root.getSummary_annual_LPN1());
			NurseLPN1.setSumPosInhouse(root.getSummary_inHouse_LPN1());
			NurseLPN1.setSumPosContracted(root.getSummary_contracted_LPN1());
			
			LTCStaffPlanPosType NpNurseHCA1 = new LTCStaffPlanPosType();
			NpNurseHCA1.setConfirmationId(root.getForm().getConfirmationId());
			NpNurseHCA1.setStaffingPlanNum("1");
			NpNurseHCA1.setStaffHrsPosType(root.getHca_label1());
			NpNurseHCA1.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
			NpNurseHCA1.setSumStaffHrsMon(root.getHca_mon_total1());
			NpNurseHCA1.setSumStaffHrsTue(root.getHca_tue_total1());
			NpNurseHCA1.setSumStaffHrsWed(root.getHca_wed_total1());
			NpNurseHCA1.setSumStaffHrsThurs(root.getHca_thu_total1());
			NpNurseHCA1.setSumStaffHrsFri(root.getHca_fri_total1());
			NpNurseHCA1.setSumStaffHrsSat(root.getHca_sat_total1());
			NpNurseHCA1.setSumStaffHrsSun(root.getHca_sun_total1());
			NpNurseHCA1.setSumStaffHrsWkTotal(root.getHca_week_total1());
			NpNurseHCA1.setSumStaffHrsAnnual(root.getHca_annual_total1());
			NpNurseHCA1.setSumPosAnnual(root.getSummary_annual_HCA1());
			NpNurseHCA1.setSumPosInhouse(root.getSummary_inHouse_HCA1());
			NpNurseHCA1.setSumPosContracted(root.getSummary_contracted_HCA1());

			LTCStaffPlanPosType OccTherapist1 = new LTCStaffPlanPosType();
			OccTherapist1.setConfirmationId(root.getForm().getConfirmationId());
			OccTherapist1.setStaffingPlanNum("1");
			OccTherapist1.setStaffHrsPosType(root.getAld_ot_label1());
			OccTherapist1.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
			OccTherapist1.setSumStaffHrsMon(root.getAld_ot_mon1());
			OccTherapist1.setSumStaffHrsTue(root.getAld_ot_tue1());
			OccTherapist1.setSumStaffHrsWed(root.getAld_ot_wed1());
			OccTherapist1.setSumStaffHrsThurs(root.getAld_ot_thu1());
			OccTherapist1.setSumStaffHrsFri(root.getAld_ot_fri1());
			OccTherapist1.setSumStaffHrsSat(root.getAld_ot_sat1());
			OccTherapist1.setSumStaffHrsSun(root.getAld_ot_sun1());
			OccTherapist1.setSumStaffHrsWkTotal(root.getAld_ot_total1());
			OccTherapist1.setSumStaffHrsAnnual(root.getAld_ot_annual1());
			OccTherapist1.setSumPosAnnual(root.getSummary_annual_OT1());
			OccTherapist1.setSumPosInhouse(root.getSummary_inHouse_OT1());
			OccTherapist1.setSumPosContracted(root.getSummary_contracted_OT1());

			LTCStaffPlanPosType Physiotherapist1  = new LTCStaffPlanPosType();
			Physiotherapist1.setConfirmationId(root.getForm().getConfirmationId());
			Physiotherapist1.setStaffingPlanNum("1");
			Physiotherapist1.setStaffHrsPosType(root.getAld_pt_label1());
			Physiotherapist1.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
			Physiotherapist1.setSumStaffHrsMon(root.getAld_pt_mon1());
			Physiotherapist1.setSumStaffHrsTue(root.getAld_pt_tue1());
			Physiotherapist1.setSumStaffHrsWed(root.getAld_pt_wed1());
			Physiotherapist1.setSumStaffHrsThurs(root.getAld_pt_thu1());
			Physiotherapist1.setSumStaffHrsFri(root.getAld_pt_fri1());
			Physiotherapist1.setSumStaffHrsSat(root.getAld_pt_sat1());
			Physiotherapist1.setSumStaffHrsSun(root.getAld_pt_sun1());
			Physiotherapist1.setSumStaffHrsWkTotal(root.getAld_pt_total1());
			Physiotherapist1.setSumStaffHrsAnnual(root.getAld_pt_annual1());
			Physiotherapist1.setSumPosAnnual(root.getSummary_annual_PT1());
			Physiotherapist1.setSumPosInhouse(root.getSummary_inHouse_PT1());
			Physiotherapist1.setSumPosContracted(root.getSummary_contracted_PT1());
			
			LTCStaffPlanPosType Dietitian1  = new LTCStaffPlanPosType();
			Dietitian1.setConfirmationId(root.getForm().getConfirmationId());
			Dietitian1.setStaffingPlanNum("1");
			Dietitian1.setStaffHrsPosType(root.getAld_dt_label1());
			Dietitian1.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
			Dietitian1.setSumStaffHrsMon(root.getAld_dt_mon1());
			Dietitian1.setSumStaffHrsTue(root.getAld_dt_tue1());
			Dietitian1.setSumStaffHrsWed(root.getAld_dt_wed1());
			Dietitian1.setSumStaffHrsThurs(root.getAld_dt_thu1());
			Dietitian1.setSumStaffHrsFri(root.getAld_dt_fri1());
			Dietitian1.setSumStaffHrsSat(root.getAld_dt_sat1());
			Dietitian1.setSumStaffHrsSun(root.getAld_dt_sun1());
			Dietitian1.setSumStaffHrsWkTotal(root.getAld_dt_total1());
			Dietitian1.setSumStaffHrsAnnual(root.getAld_dt_annual1());
			Dietitian1.setSumPosAnnual(root.getSummary_annual_DT1());
			Dietitian1.setSumPosInhouse(root.getSummary_inHouse_DT1());
			Dietitian1.setSumPosContracted(root.getSummary_contracted_DT1());
			
			LTCStaffPlanPosType SocialWorker1 = new LTCStaffPlanPosType();
			SocialWorker1.setConfirmationId(root.getForm().getConfirmationId());
			SocialWorker1.setStaffingPlanNum("1");
			SocialWorker1.setStaffHrsPosType(root.getAld_sw_label1());
			SocialWorker1.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
			SocialWorker1.setSumStaffHrsMon(root.getAld_sw_mon1());
			SocialWorker1.setSumStaffHrsTue(root.getAld_sw_tue1());
			SocialWorker1.setSumStaffHrsWed(root.getAld_sw_wed1());
			SocialWorker1.setSumStaffHrsThurs(root.getAld_sw_thu1());
			SocialWorker1.setSumStaffHrsFri(root.getAld_sw_fri1());
			SocialWorker1.setSumStaffHrsSat(root.getAld_sw_sat1());
			SocialWorker1.setSumStaffHrsSun(root.getAld_sw_sun1());
			SocialWorker1.setSumStaffHrsWkTotal(root.getAld_sw_total1());
			SocialWorker1.setSumStaffHrsAnnual(root.getAld_sw_annual1());
			SocialWorker1.setSumPosAnnual(root.getSummary_annual_SW1());
			SocialWorker1.setSumPosInhouse(root.getSummary_inHouse_SW1());
			SocialWorker1.setSumPosContracted(root.getSummary_contracted_SW1());
			
			LTCStaffPlanPosType SpeechPathologist1 = new LTCStaffPlanPosType();
			SpeechPathologist1.setConfirmationId(root.getForm().getConfirmationId());
			SpeechPathologist1.setStaffingPlanNum("1");
			SpeechPathologist1.setStaffHrsPosType(root.getAld_sp_label1());
			SpeechPathologist1.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
			SpeechPathologist1.setSumStaffHrsMon(root.getAld_sp_mon1());
			SpeechPathologist1.setSumStaffHrsTue(root.getAld_sp_tue1());
			SpeechPathologist1.setSumStaffHrsWed(root.getAld_sp_wed1());
			SpeechPathologist1.setSumStaffHrsThurs(root.getAld_sp_thu1());
			SpeechPathologist1.setSumStaffHrsFri(root.getAld_sp_fri1());
			SpeechPathologist1.setSumStaffHrsSat(root.getAld_sp_sat1());
			SpeechPathologist1.setSumStaffHrsSun(root.getAld_sp_sun1());
			SpeechPathologist1.setSumStaffHrsWkTotal(root.getAld_sp_total1());
			SpeechPathologist1.setSumStaffHrsAnnual(root.getAld_sp_annual1());
			SpeechPathologist1.setSumPosAnnual(root.getSummary_annual_SL1());
			SpeechPathologist1.setSumPosInhouse(root.getSummary_inHouse_SL1());
			SpeechPathologist1.setSumPosContracted(root.getSummary_contracted_SL1());
			
			LTCStaffPlanPosType RespTherapist1 = new LTCStaffPlanPosType();
			RespTherapist1.setConfirmationId(root.getForm().getConfirmationId());
			RespTherapist1.setStaffingPlanNum("1");
			RespTherapist1.setStaffHrsPosType(root.getAld_rt_label1());
			RespTherapist1.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
			RespTherapist1.setSumStaffHrsMon(root.getAld_rt_mon1());
			RespTherapist1.setSumStaffHrsTue(root.getAld_rt_tue1());
			RespTherapist1.setSumStaffHrsWed(root.getAld_rt_wed1());
			RespTherapist1.setSumStaffHrsThurs(root.getAld_rt_thu1());
			RespTherapist1.setSumStaffHrsFri(root.getAld_rt_fri1());
			RespTherapist1.setSumStaffHrsSat(root.getAld_rt_sat1());
			RespTherapist1.setSumStaffHrsSun(root.getAld_rt_sun1());
			RespTherapist1.setSumStaffHrsWkTotal(root.getAld_rt_total1());
			RespTherapist1.setSumStaffHrsAnnual(root.getAld_rt_annual1());
			RespTherapist1.setSumPosAnnual(root.getSummary_annual_resp1());
			RespTherapist1.setSumPosInhouse(root.getSummary_inHouse_resp1());
			RespTherapist1.setSumPosContracted(root.getSummary_contracted_resp1());
			
			LTCStaffPlanPosType RecTherapist1 = new LTCStaffPlanPosType();
			RecTherapist1.setConfirmationId(root.getForm().getConfirmationId());
			RecTherapist1.setStaffingPlanNum("1");
			RecTherapist1.setStaffHrsPosType(root.getAldnop_rt_label1());
			RecTherapist1.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
			RecTherapist1.setSumStaffHrsMon(root.getAldnop_rt_mon1());
			RecTherapist1.setSumStaffHrsTue(root.getAldnop_rt_tue1());
			RecTherapist1.setSumStaffHrsWed(root.getAldnop_rt_wed1());
			RecTherapist1.setSumStaffHrsThurs(root.getAldnop_rt_thu1());
			RecTherapist1.setSumStaffHrsFri(root.getAldnop_rt_fri1());
			RecTherapist1.setSumStaffHrsSat(root.getAldnop_rt_sat1());
			RecTherapist1.setSumStaffHrsSun(root.getAldnop_rt_sun1());
			RecTherapist1.setSumStaffHrsWkTotal(root.getAldnop_rt_total1());
			RecTherapist1.setSumStaffHrsAnnual(root.getAldnop_rt_annual1());
			RecTherapist1.setSumPosAnnual(root.getSummary_annual_RT1());
			RecTherapist1.setSumPosInhouse(root.getSummary_inHouse_RT1());
			RecTherapist1.setSumPosContracted(root.getSummary_contracted_RT1());
			
			LTCStaffPlanPosType RehabAssistant1 = new LTCStaffPlanPosType();
			RehabAssistant1.setConfirmationId(root.getForm().getConfirmationId());
			RehabAssistant1.setStaffingPlanNum("1");
			RehabAssistant1.setStaffHrsPosType(root.getAldnop_ra_label1());
			RehabAssistant1.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
			RehabAssistant1.setSumStaffHrsMon(root.getAldnop_ra_mon1());
			RehabAssistant1.setSumStaffHrsTue(root.getAldnop_ra_tue1());
			RehabAssistant1.setSumStaffHrsWed(root.getAldnop_ra_wed1());
			RehabAssistant1.setSumStaffHrsThurs(root.getAldnop_ra_thu1());
			RehabAssistant1.setSumStaffHrsFri(root.getAldnop_ra_fri1());
			RehabAssistant1.setSumStaffHrsSat(root.getAldnop_ra_sat1());
			RehabAssistant1.setSumStaffHrsSun(root.getAldnop_ra_sun1());
			RehabAssistant1.setSumStaffHrsWkTotal(root.getAldnop_ra_total1());
			RehabAssistant1.setSumStaffHrsAnnual(root.getAldnop_ra_annual1());
			RehabAssistant1.setSumPosAnnual(root.getSummary_annual_RA1());
			RehabAssistant1.setSumPosInhouse(root.getSummary_inHouse_RA1());
			RehabAssistant1.setSumPosContracted(root.getSummary_contracted_RA1());
			
			LTCStaffPlanPosType ActivityWorker1 = new LTCStaffPlanPosType();
			ActivityWorker1.setConfirmationId(root.getForm().getConfirmationId());
			ActivityWorker1.setStaffingPlanNum("1");
			ActivityWorker1.setStaffHrsPosType(root.getAldnop_aw_label1());
			ActivityWorker1.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
			ActivityWorker1.setSumStaffHrsMon(root.getAldnop_aw_mon1());
			ActivityWorker1.setSumStaffHrsTue(root.getAldnop_aw_tue1());
			ActivityWorker1.setSumStaffHrsWed(root.getAldnop_aw_wed1());
			ActivityWorker1.setSumStaffHrsThurs(root.getAldnop_aw_thu1());
			ActivityWorker1.setSumStaffHrsFri(root.getAldnop_aw_fri1());
			ActivityWorker1.setSumStaffHrsSat(root.getAldnop_aw_sat1());
			ActivityWorker1.setSumStaffHrsSun(root.getAldnop_aw_sun1());
			ActivityWorker1.setSumStaffHrsWkTotal(root.getAldnop_aw_total1());
			ActivityWorker1.setSumStaffHrsAnnual(root.getAldnop_aw_annual1());
			ActivityWorker1.setSumPosAnnual(root.getSummary_annual_AW1());
			ActivityWorker1.setSumPosInhouse(root.getSummary_inHouse_AW1());
			ActivityWorker1.setSumPosContracted(root.getSummary_contracted_AW1());
			
			LTCStaffPlanPosType MusicTherapist1 = new LTCStaffPlanPosType();
			MusicTherapist1.setConfirmationId(root.getForm().getConfirmationId());
			MusicTherapist1.setStaffingPlanNum("1");
			MusicTherapist1.setStaffHrsPosType(root.getAldnop_mt_label1());
			MusicTherapist1.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
			MusicTherapist1.setSumStaffHrsMon(root.getAldnop_mt_mon1());
			MusicTherapist1.setSumStaffHrsTue(root.getAldnop_mt_tue1());
			MusicTherapist1.setSumStaffHrsWed(root.getAldnop_mt_wed1());
			MusicTherapist1.setSumStaffHrsThurs(root.getAldnop_mt_thu1());
			MusicTherapist1.setSumStaffHrsFri(root.getAldnop_mt_fri1());
			MusicTherapist1.setSumStaffHrsSat(root.getAldnop_mt_sat1());
			MusicTherapist1.setSumStaffHrsSun(root.getAldnop_mt_sun1());
			MusicTherapist1.setSumStaffHrsWkTotal(root.getAldnop_mt_total1());
			MusicTherapist1.setSumStaffHrsAnnual(root.getAldnop_mt_annual1());
			MusicTherapist1.setSumPosAnnual(root.getSummary_annual_MT1());
			MusicTherapist1.setSumPosInhouse(root.getSummary_inHouse_MT1());
			MusicTherapist1.setSumPosContracted(root.getSummary_contracted_MT1());

			LTCStaffPlanPosType ArtTherapist1 = new LTCStaffPlanPosType();
			ArtTherapist1.setConfirmationId(root.getForm().getConfirmationId());
			ArtTherapist1.setStaffingPlanNum("1");
			ArtTherapist1.setStaffHrsPosType(root.getAldnop_at_label1());
			ArtTherapist1.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
			ArtTherapist1.setSumStaffHrsMon(root.getAldnop_at_mon1());
			ArtTherapist1.setSumStaffHrsTue(root.getAldnop_at_tue1());
			ArtTherapist1.setSumStaffHrsWed(root.getAldnop_at_wed1());
			ArtTherapist1.setSumStaffHrsThurs(root.getAldnop_at_thu1());
			ArtTherapist1.setSumStaffHrsFri(root.getAldnop_at_fri1());
			ArtTherapist1.setSumStaffHrsSat(root.getAldnop_at_sat1());
			ArtTherapist1.setSumStaffHrsSun(root.getAldnop_at_sun1());
			ArtTherapist1.setSumStaffHrsWkTotal(root.getAldnop_at_total1());
			ArtTherapist1.setSumStaffHrsAnnual(root.getAldnop_at_annual1());
			ArtTherapist1.setSumPosAnnual(root.getSummary_annual_AT1());
			ArtTherapist1.setSumPosInhouse(root.getSummary_inHouse_AT1());
			ArtTherapist1.setSumPosContracted(root.getSummary_contracted_AT1());

			Collections.addAll(LTCStaffPlanPosType, NurseRN1, NurseLPN1, NpNurseHCA1, OccTherapist1, Physiotherapist1, Dietitian1, SocialWorker1,
				SpeechPathologist1, RespTherapist1, RecTherapist1, RehabAssistant1, ActivityWorker1, MusicTherapist1,
				ArtTherapist1);

			if(root.getNpDatagrid1() != null){
				int indexnp1 = 0;
				for(NpDatagrid otherProfessionalNurse : root.getNpDatagrid1()){
					LTCStaffPlanPosType otherNurse = new LTCStaffPlanPosType();
					otherNurse.setConfirmationId(root.getForm().getConfirmationId());
					otherNurse.setStaffingPlanNum("1");
					otherNurse.setStaffHrsPosType(Constants.DEFAULT_OTHER_PROF_NURSE_VALUE);
					otherNurse.setStaffHrsPosOtherName(otherProfessionalNurse.getNpPositionType() + ++indexnp1);
					otherNurse.setSumStaffHrsMon(otherProfessionalNurse.getNp_other_mon());
					otherNurse.setSumStaffHrsTue(otherProfessionalNurse.getNp_other_tue());
					otherNurse.setSumStaffHrsWed(otherProfessionalNurse.getNp_other_wed());
					otherNurse.setSumStaffHrsThurs(otherProfessionalNurse.getNp_other_thu());
					otherNurse.setSumStaffHrsFri(otherProfessionalNurse.getNp_other_fri());
					otherNurse.setSumStaffHrsSat(otherProfessionalNurse.getNp_other_sat());
					otherNurse.setSumStaffHrsSun(otherProfessionalNurse.getNp_other_sun());
					otherNurse.setSumStaffHrsWkTotal(otherProfessionalNurse.getNp_other_total());
					otherNurse.setSumStaffHrsAnnual(otherProfessionalNurse.getNp_other_annual());
					otherNurse.setSumPosAnnual(root.getSummary_annual_otherNursingP1());
					otherNurse.setSumPosInhouse(root.getSummary_inHouse_otherNursingP1());
					otherNurse.setSumPosContracted(root.getSummary_contracted_otherNursingP1());
		
					LTCStaffPlanPosType.add(otherNurse);
					
				}
			}

			if(root.getNnpDatagrid1() != null){
				int indexnnp1 = 0;
				for(NnpDatagrid otherNonProfessionalNurse : root.getNnpDatagrid1()){
					LTCStaffPlanPosType otherNPNurse = new LTCStaffPlanPosType();
					otherNPNurse.setConfirmationId(root.getForm().getConfirmationId());
					otherNPNurse.setStaffingPlanNum("1");
					otherNPNurse.setStaffHrsPosType(Constants.DEFAULT_OTHER_NONPROF_NURSE_VALUE);
					otherNPNurse.setStaffHrsPosOtherName(otherNonProfessionalNurse.getNnpPositionType() + ++indexnnp1);
					otherNPNurse.setSumStaffHrsMon(otherNonProfessionalNurse.getNnp_other_mon());
					otherNPNurse.setSumStaffHrsTue(otherNonProfessionalNurse.getNnp_other_tue());
					otherNPNurse.setSumStaffHrsWed(otherNonProfessionalNurse.getNnp_other_wed());
					otherNPNurse.setSumStaffHrsThurs(otherNonProfessionalNurse.getNnp_other_thu());
					otherNPNurse.setSumStaffHrsFri(otherNonProfessionalNurse.getNnp_other_fri());
					otherNPNurse.setSumStaffHrsSat(otherNonProfessionalNurse.getNnp_other_sat());
					otherNPNurse.setSumStaffHrsSun(otherNonProfessionalNurse.getNnp_other_sun());
					otherNPNurse.setSumStaffHrsWkTotal(otherNonProfessionalNurse.getNnp_other_total());
					otherNPNurse.setSumStaffHrsAnnual(otherNonProfessionalNurse.getNnp_other_annual());
					otherNPNurse.setSumPosAnnual(root.getSummary_annual_otherNursingNP1());
					otherNPNurse.setSumPosInhouse(root.getSummary_inHouse_otherNursingNP1());
					otherNPNurse.setSumPosContracted(root.getSummary_contracted_otherNursingNP1());
	
					LTCStaffPlanPosType.add(otherNPNurse);
				}
			}

			if(root.getAldDatagrid1() != null){
				int indexald1 = 0;
				for(AldDatagrid otherProfessionalAllied : root.getAldDatagrid1()){
					LTCStaffPlanPosType otherProfAllied = new LTCStaffPlanPosType();
					otherProfAllied.setConfirmationId(root.getForm().getConfirmationId());
					otherProfAllied.setStaffingPlanNum("1");
					otherProfAllied.setStaffHrsPosType(Constants.DEFAULT_OTHER_PROF_ALLIED_VALUE);
					otherProfAllied.setStaffHrsPosOtherName(otherProfessionalAllied.getAldPositionType() + ++indexald1);
					otherProfAllied.setSumStaffHrsMon(otherProfessionalAllied.getAld_other_mon());
					otherProfAllied.setSumStaffHrsTue(otherProfessionalAllied.getAld_other_tue());
					otherProfAllied.setSumStaffHrsWed(otherProfessionalAllied.getAld_other_wed());
					otherProfAllied.setSumStaffHrsThurs(otherProfessionalAllied.getAld_other_thu());
					otherProfAllied.setSumStaffHrsFri(otherProfessionalAllied.getAld_other_fri());
					otherProfAllied.setSumStaffHrsSat(otherProfessionalAllied.getAld_other_sat());
					otherProfAllied.setSumStaffHrsSun(otherProfessionalAllied.getAld_other_sun());
					otherProfAllied.setSumStaffHrsWkTotal(otherProfessionalAllied.getAld_other_total());
					otherProfAllied.setSumStaffHrsAnnual(otherProfessionalAllied.getAld_other_annual());
					otherProfAllied.setSumPosAnnual(root.getSummary_annual_otherAlliedProf1());
					otherProfAllied.setSumPosInhouse(root.getSummary_inHouse_otherAlliedProf1());
					otherProfAllied.setSumPosContracted(root.getSummary_contracted_otherAlliedProf1());
	
					LTCStaffPlanPosType.add(otherProfAllied);
				}
			}

			if(root.getAldnopDatagrid1() != null){
				int indexaldnop1 = 0;
				for(AldNopDatagrid otherNonProfessionalAllied : root.getAldnopDatagrid1()){
					LTCStaffPlanPosType otherNonProfAllied = new LTCStaffPlanPosType();
					otherNonProfAllied.setConfirmationId(root.getForm().getConfirmationId());
					otherNonProfAllied.setStaffingPlanNum("1");
					otherNonProfAllied.setStaffHrsPosType(Constants.DEFAULT_OTHER_NONPROF_ALLIED_VALUE);
					otherNonProfAllied.setStaffHrsPosOtherName(otherNonProfessionalAllied.getAldnopPositionType() + ++indexaldnop1 );
					otherNonProfAllied.setSumStaffHrsMon(otherNonProfessionalAllied.getAldnop_other_mon());
					otherNonProfAllied.setSumStaffHrsTue(otherNonProfessionalAllied.getAldnop_other_tue());
					otherNonProfAllied.setSumStaffHrsWed(otherNonProfessionalAllied.getAldnop_other_wed());
					otherNonProfAllied.setSumStaffHrsThurs(otherNonProfessionalAllied.getAldnop_other_thu());
					otherNonProfAllied.setSumStaffHrsFri(otherNonProfessionalAllied.getAldnop_other_fri());
					otherNonProfAllied.setSumStaffHrsSat(otherNonProfessionalAllied.getAldnop_other_sat());
					otherNonProfAllied.setSumStaffHrsSun(otherNonProfessionalAllied.getAldnop_other_sun());
					otherNonProfAllied.setSumStaffHrsWkTotal(otherNonProfessionalAllied.getAldnop_other_total());
					otherNonProfAllied.setSumStaffHrsAnnual(otherNonProfessionalAllied.getAldnop_other_annual());
					otherNonProfAllied.setSumPosAnnual(root.getSummary_annual_otherAlliedNProf1());
					otherNonProfAllied.setSumPosInhouse(root.getSummary_inHouse_otherAlliedNProf1());
					otherNonProfAllied.setSumPosContracted(root.getSummary_contracted_otherAlliedNProf1());
	
					LTCStaffPlanPosType.add(otherNonProfAllied);
				}
			}

			if(root.getStaffingPlanType2() != null && !root.getStaffingPlanType2().isEmpty()){
				LTCStaffPlanPosType NurseRN2 = new LTCStaffPlanPosType();
				NurseRN2.setConfirmationId(root.getForm().getConfirmationId());
				NurseRN2.setStaffingPlanNum("2");
				NurseRN2.setStaffHrsPosType(root.getRn_label1());
				NurseRN2.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				NurseRN2.setSumStaffHrsMon(root.getRn_mon_total2());
				NurseRN2.setSumStaffHrsTue(root.getRn_tue_total2());
				NurseRN2.setSumStaffHrsWed(root.getRn_wed_total2());
				NurseRN2.setSumStaffHrsThurs(root.getRn_thu_total2());
				NurseRN2.setSumStaffHrsFri(root.getRn_fri_total2());
				NurseRN2.setSumStaffHrsSat(root.getRn_sat_total2());
				NurseRN2.setSumStaffHrsSun(root.getRn_sun_total2());
				NurseRN2.setSumStaffHrsWkTotal(root.getRn_week_total2());
				NurseRN2.setSumStaffHrsAnnual(root.getRn_annual_total2());
				NurseRN2.setSumPosAnnual(root.getSummary_annual_RN2());
				NurseRN2.setSumPosInhouse(root.getSummary_inHouse_RN2());
				NurseRN2.setSumPosContracted(root.getSummary_contracted_RN2());
	
				LTCStaffPlanPosType NurseLPN2 = new LTCStaffPlanPosType();
				NurseLPN2.setConfirmationId(root.getForm().getConfirmationId());
				NurseLPN2.setStaffingPlanNum("2");
				NurseLPN2.setStaffHrsPosType(root.getLpn_label1());
				NurseLPN2.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				NurseLPN2.setSumStaffHrsMon(root.getLpn_mon_total2());
				NurseLPN2.setSumStaffHrsTue(root.getLpn_tue_total2());
				NurseLPN2.setSumStaffHrsWed(root.getLpn_wed_total2());
				NurseLPN2.setSumStaffHrsThurs(root.getLpn_thu_total2());
				NurseLPN2.setSumStaffHrsFri(root.getLpn_fri_total2());
				NurseLPN2.setSumStaffHrsSat(root.getLpn_sat_total2());
				NurseLPN2.setSumStaffHrsSun(root.getLpn_sun_total2());
				NurseLPN2.setSumStaffHrsWkTotal(root.getLpn_week_total2());
				NurseLPN2.setSumStaffHrsAnnual(root.getLpn_annual_total2());
				NurseLPN2.setSumPosAnnual(root.getSummary_annual_LPN2());
				NurseLPN2.setSumPosInhouse(root.getSummary_inHouse_LPN2());
				NurseLPN2.setSumPosContracted(root.getSummary_contracted_LPN2());
				
				LTCStaffPlanPosType NpNurseHCA2 = new LTCStaffPlanPosType();
				NpNurseHCA2.setConfirmationId(root.getForm().getConfirmationId());
				NpNurseHCA2.setStaffingPlanNum("2");
				NpNurseHCA2.setStaffHrsPosType(root.getHca_label1());
				NpNurseHCA2.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				NpNurseHCA2.setSumStaffHrsMon(root.getHca_mon_total2());
				NpNurseHCA2.setSumStaffHrsTue(root.getHca_tue_total2());
				NpNurseHCA2.setSumStaffHrsWed(root.getHca_wed_total2());
				NpNurseHCA2.setSumStaffHrsThurs(root.getHca_thu_total2());
				NpNurseHCA2.setSumStaffHrsFri(root.getHca_fri_total2());
				NpNurseHCA2.setSumStaffHrsSat(root.getHca_sat_total2());
				NpNurseHCA2.setSumStaffHrsSun(root.getHca_sun_total2());
				NpNurseHCA2.setSumStaffHrsWkTotal(root.getHca_week_total2());
				NpNurseHCA2.setSumStaffHrsAnnual(root.getHca_annual_total2());
				NpNurseHCA2.setSumPosAnnual(root.getSummary_annual_HCA2());
				NpNurseHCA2.setSumPosInhouse(root.getSummary_inHouse_HCA2());
				NpNurseHCA2.setSumPosContracted(root.getSummary_contracted_HCA2());
	
				LTCStaffPlanPosType OccTherapist2 = new LTCStaffPlanPosType();
				OccTherapist2.setConfirmationId(root.getForm().getConfirmationId());
				OccTherapist2.setStaffingPlanNum("2");
				OccTherapist2.setStaffHrsPosType(root.getAld_ot_label1());
				OccTherapist2.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				OccTherapist2.setSumStaffHrsMon(root.getAld_ot_mon2());
				OccTherapist2.setSumStaffHrsTue(root.getAld_ot_tue2());
				OccTherapist2.setSumStaffHrsWed(root.getAld_ot_wed2());
				OccTherapist2.setSumStaffHrsThurs(root.getAld_ot_thu2());
				OccTherapist2.setSumStaffHrsFri(root.getAld_ot_fri2());
				OccTherapist2.setSumStaffHrsSat(root.getAld_ot_sat2());
				OccTherapist2.setSumStaffHrsSun(root.getAld_ot_sun2());
				OccTherapist2.setSumStaffHrsWkTotal(root.getAld_ot_total2());
				OccTherapist2.setSumStaffHrsAnnual(root.getAld_ot_annual2());
				OccTherapist2.setSumPosAnnual(root.getSummary_annual_OT2());
				OccTherapist2.setSumPosInhouse(root.getSummary_inHouse_OT2());
				OccTherapist2.setSumPosContracted(root.getSummary_contracted_OT2());
	
				LTCStaffPlanPosType Physiotherapist2  = new LTCStaffPlanPosType();
				Physiotherapist2.setConfirmationId(root.getForm().getConfirmationId());
				Physiotherapist2.setStaffingPlanNum("2");
				Physiotherapist2.setStaffHrsPosType(root.getAld_pt_label1());
				Physiotherapist2.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				Physiotherapist2.setSumStaffHrsMon(root.getAld_pt_mon2());
				Physiotherapist2.setSumStaffHrsTue(root.getAld_pt_tue2());
				Physiotherapist2.setSumStaffHrsWed(root.getAld_pt_wed2());
				Physiotherapist2.setSumStaffHrsThurs(root.getAld_pt_thu2());
				Physiotherapist2.setSumStaffHrsFri(root.getAld_pt_fri2());
				Physiotherapist2.setSumStaffHrsSat(root.getAld_pt_sat2());
				Physiotherapist2.setSumStaffHrsSun(root.getAld_pt_sun2());
				Physiotherapist2.setSumStaffHrsWkTotal(root.getAld_pt_total2());
				Physiotherapist2.setSumStaffHrsAnnual(root.getAld_pt_annual2());
				Physiotherapist2.setSumPosAnnual(root.getSummary_annual_PT2());
				Physiotherapist2.setSumPosInhouse(root.getSummary_inHouse_PT2());
				Physiotherapist2.setSumPosContracted(root.getSummary_contracted_PT2());
				
				LTCStaffPlanPosType Dietitian2  = new LTCStaffPlanPosType();
				Dietitian2.setConfirmationId(root.getForm().getConfirmationId());
				Dietitian2.setStaffingPlanNum("2");
				Dietitian2.setStaffHrsPosType(root.getAld_dt_label1());
				Dietitian2.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				Dietitian2.setSumStaffHrsMon(root.getAld_dt_mon2());
				Dietitian2.setSumStaffHrsTue(root.getAld_dt_tue2());
				Dietitian2.setSumStaffHrsWed(root.getAld_dt_wed2());
				Dietitian2.setSumStaffHrsThurs(root.getAld_dt_thu2());
				Dietitian2.setSumStaffHrsFri(root.getAld_dt_fri2());
				Dietitian2.setSumStaffHrsSat(root.getAld_dt_sat2());
				Dietitian2.setSumStaffHrsSun(root.getAld_dt_sun2());
				Dietitian2.setSumStaffHrsWkTotal(root.getAld_dt_total2());
				Dietitian2.setSumStaffHrsAnnual(root.getAld_dt_annual2());
				Dietitian2.setSumPosAnnual(root.getSummary_annual_DT2());
				Dietitian2.setSumPosInhouse(root.getSummary_inHouse_DT2());
				Dietitian2.setSumPosContracted(root.getSummary_contracted_DT2());
				
				LTCStaffPlanPosType SocialWorker2 = new LTCStaffPlanPosType();
				SocialWorker2.setConfirmationId(root.getForm().getConfirmationId());
				SocialWorker2.setStaffingPlanNum("2");
				SocialWorker2.setStaffHrsPosType(root.getAld_sw_label1());
				SocialWorker2.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				SocialWorker2.setSumStaffHrsMon(root.getAld_sw_mon2());
				SocialWorker2.setSumStaffHrsTue(root.getAld_sw_tue2());
				SocialWorker2.setSumStaffHrsWed(root.getAld_sw_wed2());
				SocialWorker2.setSumStaffHrsThurs(root.getAld_sw_thu2());
				SocialWorker2.setSumStaffHrsFri(root.getAld_sw_fri2());
				SocialWorker2.setSumStaffHrsSat(root.getAld_sw_sat2());
				SocialWorker2.setSumStaffHrsSun(root.getAld_sw_sun2());
				SocialWorker2.setSumStaffHrsWkTotal(root.getAld_sw_total2());
				SocialWorker2.setSumStaffHrsAnnual(root.getAld_sw_annual2());
				SocialWorker2.setSumPosAnnual(root.getSummary_annual_SW2());
				SocialWorker2.setSumPosInhouse(root.getSummary_inHouse_SW2());
				SocialWorker2.setSumPosContracted(root.getSummary_contracted_SW2());
				
				LTCStaffPlanPosType SpeechPathologist2 = new LTCStaffPlanPosType();
				SpeechPathologist2.setConfirmationId(root.getForm().getConfirmationId());
				SpeechPathologist2.setStaffingPlanNum("2");
				SpeechPathologist2.setStaffHrsPosType(root.getAld_sp_label1());
				SpeechPathologist2.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				SpeechPathologist2.setSumStaffHrsMon(root.getAld_sp_mon2());
				SpeechPathologist2.setSumStaffHrsTue(root.getAld_sp_tue2());
				SpeechPathologist2.setSumStaffHrsWed(root.getAld_sp_wed2());
				SpeechPathologist2.setSumStaffHrsThurs(root.getAld_sp_thu2());
				SpeechPathologist2.setSumStaffHrsFri(root.getAld_sp_fri2());
				SpeechPathologist2.setSumStaffHrsSat(root.getAld_sp_sat2());
				SpeechPathologist2.setSumStaffHrsSun(root.getAld_sp_sun2());
				SpeechPathologist2.setSumStaffHrsWkTotal(root.getAld_sp_total2());
				SpeechPathologist2.setSumStaffHrsAnnual(root.getAld_sp_annual2());
				SpeechPathologist2.setSumPosAnnual(root.getSummary_annual_SL2());
				SpeechPathologist2.setSumPosInhouse(root.getSummary_inHouse_SL2());
				SpeechPathologist2.setSumPosContracted(root.getSummary_contracted_SL2());
				
				LTCStaffPlanPosType RespTherapist2 = new LTCStaffPlanPosType();
				RespTherapist2.setConfirmationId(root.getForm().getConfirmationId());
				RespTherapist2.setStaffingPlanNum("2");
				RespTherapist2.setStaffHrsPosType(root.getAld_rt_label1());
				RespTherapist2.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				RespTherapist2.setSumStaffHrsMon(root.getAld_rt_mon2());
				RespTherapist2.setSumStaffHrsTue(root.getAld_rt_tue2());
				RespTherapist2.setSumStaffHrsWed(root.getAld_rt_wed2());
				RespTherapist2.setSumStaffHrsThurs(root.getAld_rt_thu2());
				RespTherapist2.setSumStaffHrsFri(root.getAld_rt_fri2());
				RespTherapist2.setSumStaffHrsSat(root.getAld_rt_sat2());
				RespTherapist2.setSumStaffHrsSun(root.getAld_rt_sun2());
				RespTherapist2.setSumStaffHrsWkTotal(root.getAld_rt_total2());
				RespTherapist2.setSumStaffHrsAnnual(root.getAld_rt_annual2());
				RespTherapist2.setSumPosAnnual(root.getSummary_annual_resp2());
				RespTherapist2.setSumPosInhouse(root.getSummary_inHouse_resp2());
				RespTherapist2.setSumPosContracted(root.getSummary_contracted_resp2());
				
				LTCStaffPlanPosType RecTherapist2 = new LTCStaffPlanPosType();
				RecTherapist2.setConfirmationId(root.getForm().getConfirmationId());
				RecTherapist2.setStaffingPlanNum("2");
				RecTherapist2.setStaffHrsPosType(root.getAldnop_rt_label1());
				RecTherapist2.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				RecTherapist2.setSumStaffHrsMon(root.getAldnop_rt_mon2());
				RecTherapist2.setSumStaffHrsTue(root.getAldnop_rt_tue2());
				RecTherapist2.setSumStaffHrsWed(root.getAldnop_rt_wed2());
				RecTherapist2.setSumStaffHrsThurs(root.getAldnop_rt_thu2());
				RecTherapist2.setSumStaffHrsFri(root.getAldnop_rt_fri2());
				RecTherapist2.setSumStaffHrsSat(root.getAldnop_rt_sat2());
				RecTherapist2.setSumStaffHrsSun(root.getAldnop_rt_sun2());
				RecTherapist2.setSumStaffHrsWkTotal(root.getAldnop_rt_total2());
				RecTherapist2.setSumStaffHrsAnnual(root.getAldnop_rt_annual2());
				RecTherapist2.setSumPosAnnual(root.getSummary_annual_RT2());
				RecTherapist2.setSumPosInhouse(root.getSummary_inHouse_RT2());
				RecTherapist2.setSumPosContracted(root.getSummary_contracted_RT2());
				
				LTCStaffPlanPosType RehabAssistant2 = new LTCStaffPlanPosType();
				RehabAssistant2.setConfirmationId(root.getForm().getConfirmationId());
				RehabAssistant2.setStaffingPlanNum("2");
				RehabAssistant2.setStaffHrsPosType(root.getAldnop_ra_label1());
				RehabAssistant2.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				RehabAssistant2.setSumStaffHrsMon(root.getAldnop_ra_mon2());
				RehabAssistant2.setSumStaffHrsTue(root.getAldnop_ra_tue2());
				RehabAssistant2.setSumStaffHrsWed(root.getAldnop_ra_wed2());
				RehabAssistant2.setSumStaffHrsThurs(root.getAldnop_ra_thu2());
				RehabAssistant2.setSumStaffHrsFri(root.getAldnop_ra_fri2());
				RehabAssistant2.setSumStaffHrsSat(root.getAldnop_ra_sat2());
				RehabAssistant2.setSumStaffHrsSun(root.getAldnop_ra_sun2());
				RehabAssistant2.setSumStaffHrsWkTotal(root.getAldnop_ra_total2());
				RehabAssistant2.setSumStaffHrsAnnual(root.getAldnop_ra_annual2());
				RehabAssistant2.setSumPosAnnual(root.getSummary_annual_RA2());
				RehabAssistant2.setSumPosInhouse(root.getSummary_inHouse_RA2());
				RehabAssistant2.setSumPosContracted(root.getSummary_contracted_RA2());
				
				LTCStaffPlanPosType ActivityWorker2 = new LTCStaffPlanPosType();
				ActivityWorker2.setConfirmationId(root.getForm().getConfirmationId());
				ActivityWorker2.setStaffingPlanNum("2");
				ActivityWorker2.setStaffHrsPosType(root.getAldnop_aw_label1());
				ActivityWorker2.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				ActivityWorker2.setSumStaffHrsMon(root.getAldnop_aw_mon2());
				ActivityWorker2.setSumStaffHrsTue(root.getAldnop_aw_tue2());
				ActivityWorker2.setSumStaffHrsWed(root.getAldnop_aw_wed2());
				ActivityWorker2.setSumStaffHrsThurs(root.getAldnop_aw_thu2());
				ActivityWorker2.setSumStaffHrsFri(root.getAldnop_aw_fri2());
				ActivityWorker2.setSumStaffHrsSat(root.getAldnop_aw_sat2());
				ActivityWorker2.setSumStaffHrsSun(root.getAldnop_aw_sun2());
				ActivityWorker2.setSumStaffHrsWkTotal(root.getAldnop_aw_total2());
				ActivityWorker2.setSumStaffHrsAnnual(root.getAldnop_aw_annual2());
				ActivityWorker2.setSumPosAnnual(root.getSummary_annual_AW2());
				ActivityWorker2.setSumPosInhouse(root.getSummary_inHouse_AW2());
				ActivityWorker2.setSumPosContracted(root.getSummary_contracted_AW2());
				
				LTCStaffPlanPosType MusicTherapist2 = new LTCStaffPlanPosType();
				MusicTherapist2.setConfirmationId(root.getForm().getConfirmationId());
				MusicTherapist2.setStaffingPlanNum("2");
				MusicTherapist2.setStaffHrsPosType(root.getAldnop_mt_label1());
				MusicTherapist2.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				MusicTherapist2.setSumStaffHrsMon(root.getAldnop_mt_mon2());
				MusicTherapist2.setSumStaffHrsTue(root.getAldnop_mt_tue2());
				MusicTherapist2.setSumStaffHrsWed(root.getAldnop_mt_wed2());
				MusicTherapist2.setSumStaffHrsThurs(root.getAldnop_mt_thu2());
				MusicTherapist2.setSumStaffHrsFri(root.getAldnop_mt_fri2());
				MusicTherapist2.setSumStaffHrsSat(root.getAldnop_mt_sat2());
				MusicTherapist2.setSumStaffHrsSun(root.getAldnop_mt_sun2());
				MusicTherapist2.setSumStaffHrsWkTotal(root.getAldnop_mt_total2());
				MusicTherapist2.setSumStaffHrsAnnual(root.getAldnop_mt_annual2());
				MusicTherapist2.setSumPosAnnual(root.getSummary_annual_MT2());
				MusicTherapist2.setSumPosInhouse(root.getSummary_inHouse_MT2());
				MusicTherapist2.setSumPosContracted(root.getSummary_contracted_MT2());
	
				LTCStaffPlanPosType ArtTherapist2 = new LTCStaffPlanPosType();
				ArtTherapist2.setConfirmationId(root.getForm().getConfirmationId());
				ArtTherapist2.setStaffingPlanNum("2");
				ArtTherapist2.setStaffHrsPosType(root.getAldnop_at_label1());
				ArtTherapist2.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				ArtTherapist2.setSumStaffHrsMon(root.getAldnop_at_mon2());
				ArtTherapist2.setSumStaffHrsTue(root.getAldnop_at_tue2());
				ArtTherapist2.setSumStaffHrsWed(root.getAldnop_at_wed2());
				ArtTherapist2.setSumStaffHrsThurs(root.getAldnop_at_thu2());
				ArtTherapist2.setSumStaffHrsFri(root.getAldnop_at_fri2());
				ArtTherapist2.setSumStaffHrsSat(root.getAldnop_at_sat2());
				ArtTherapist2.setSumStaffHrsSun(root.getAldnop_at_sun2());
				ArtTherapist2.setSumStaffHrsWkTotal(root.getAldnop_at_total2());
				ArtTherapist2.setSumStaffHrsAnnual(root.getAldnop_at_annual2());
				ArtTherapist2.setSumPosAnnual(root.getSummary_annual_AT2());
				ArtTherapist2.setSumPosInhouse(root.getSummary_inHouse_AT2());
				ArtTherapist2.setSumPosContracted(root.getSummary_contracted_AT2());
	
				Collections.addAll(LTCStaffPlanPosType, NurseRN2, NurseLPN2, NpNurseHCA2, OccTherapist2, Physiotherapist2, Dietitian2, SocialWorker2,
					SpeechPathologist2, RespTherapist2, RecTherapist2, RehabAssistant2, ActivityWorker2, MusicTherapist2,
					ArtTherapist2);
	
				if(root.getNpDatagrid2() != null){
					int indexnp2 = 0;
					for(NpDatagrid otherProfessionalNurse : root.getNpDatagrid2()){
						LTCStaffPlanPosType otherNurse = new LTCStaffPlanPosType();
						otherNurse.setConfirmationId(root.getForm().getConfirmationId());
						otherNurse.setStaffingPlanNum("2");
						otherNurse.setStaffHrsPosType(Constants.DEFAULT_OTHER_PROF_NURSE_VALUE);
						otherNurse.setStaffHrsPosOtherName(otherProfessionalNurse.getNpPositionType() + ++indexnp2);
						otherNurse.setSumStaffHrsMon(otherProfessionalNurse.getNp_other_mon());
						otherNurse.setSumStaffHrsTue(otherProfessionalNurse.getNp_other_tue());
						otherNurse.setSumStaffHrsWed(otherProfessionalNurse.getNp_other_wed());
						otherNurse.setSumStaffHrsThurs(otherProfessionalNurse.getNp_other_thu());
						otherNurse.setSumStaffHrsFri(otherProfessionalNurse.getNp_other_fri());
						otherNurse.setSumStaffHrsSat(otherProfessionalNurse.getNp_other_sat());
						otherNurse.setSumStaffHrsSun(otherProfessionalNurse.getNp_other_sun());
						otherNurse.setSumStaffHrsWkTotal(otherProfessionalNurse.getNp_other_total());
						otherNurse.setSumStaffHrsAnnual(otherProfessionalNurse.getNp_other_annual());
						otherNurse.setSumPosAnnual(root.getSummary_annual_otherNursingP2());
						otherNurse.setSumPosInhouse(root.getSummary_inHouse_otherNursingP2());
						otherNurse.setSumPosContracted(root.getSummary_contracted_otherNursingP2());
			
						LTCStaffPlanPosType.add(otherNurse);
						
					}
				}
	
				if(root.getNnpDatagrid2() != null){
					int indexnnp2 = 0;
					for(NnpDatagrid otherNonProfessionalNurse : root.getNnpDatagrid2()){
						LTCStaffPlanPosType otherNPNurse = new LTCStaffPlanPosType();
						otherNPNurse.setConfirmationId(root.getForm().getConfirmationId());
						otherNPNurse.setStaffingPlanNum("2");
						otherNPNurse.setStaffHrsPosType(Constants.DEFAULT_OTHER_NONPROF_NURSE_VALUE);
						otherNPNurse.setStaffHrsPosOtherName(otherNonProfessionalNurse.getNnpPositionType() + ++indexnnp2 );
						otherNPNurse.setSumStaffHrsMon(otherNonProfessionalNurse.getNnp_other_mon());
						otherNPNurse.setSumStaffHrsTue(otherNonProfessionalNurse.getNnp_other_tue());
						otherNPNurse.setSumStaffHrsWed(otherNonProfessionalNurse.getNnp_other_wed());
						otherNPNurse.setSumStaffHrsThurs(otherNonProfessionalNurse.getNnp_other_thu());
						otherNPNurse.setSumStaffHrsFri(otherNonProfessionalNurse.getNnp_other_fri());
						otherNPNurse.setSumStaffHrsSat(otherNonProfessionalNurse.getNnp_other_sat());
						otherNPNurse.setSumStaffHrsSun(otherNonProfessionalNurse.getNnp_other_sun());
						otherNPNurse.setSumStaffHrsWkTotal(otherNonProfessionalNurse.getNnp_other_total());
						otherNPNurse.setSumStaffHrsAnnual(otherNonProfessionalNurse.getNnp_other_annual());
						otherNPNurse.setSumPosAnnual(root.getSummary_annual_otherNursingNP2());
						otherNPNurse.setSumPosInhouse(root.getSummary_inHouse_otherNursingNP2());
						otherNPNurse.setSumPosContracted(root.getSummary_contracted_otherNursingNP2());
		
						LTCStaffPlanPosType.add(otherNPNurse);
					}
				}
	
				if(root.getAldDatagrid2() != null){
					int indexald2 = 0;
					for(AldDatagrid otherProfessionalAllied : root.getAldDatagrid2()){
						LTCStaffPlanPosType otherProfAllied = new LTCStaffPlanPosType();
						otherProfAllied.setConfirmationId(root.getForm().getConfirmationId());
						otherProfAllied.setStaffingPlanNum("2");
						otherProfAllied.setStaffHrsPosType(Constants.DEFAULT_OTHER_PROF_ALLIED_VALUE);
						otherProfAllied.setStaffHrsPosOtherName(otherProfessionalAllied.getAldPositionType() + ++indexald2);
						otherProfAllied.setSumStaffHrsMon(otherProfessionalAllied.getAld_other_mon());
						otherProfAllied.setSumStaffHrsTue(otherProfessionalAllied.getAld_other_tue());
						otherProfAllied.setSumStaffHrsWed(otherProfessionalAllied.getAld_other_wed());
						otherProfAllied.setSumStaffHrsThurs(otherProfessionalAllied.getAld_other_thu());
						otherProfAllied.setSumStaffHrsFri(otherProfessionalAllied.getAld_other_fri());
						otherProfAllied.setSumStaffHrsSat(otherProfessionalAllied.getAld_other_sat());
						otherProfAllied.setSumStaffHrsSun(otherProfessionalAllied.getAld_other_sun());
						otherProfAllied.setSumStaffHrsWkTotal(otherProfessionalAllied.getAld_other_total());
						otherProfAllied.setSumStaffHrsAnnual(otherProfessionalAllied.getAld_other_annual());
						otherProfAllied.setSumPosAnnual(root.getSummary_annual_otherAlliedProf2());
						otherProfAllied.setSumPosInhouse(root.getSummary_inHouse_otherAlliedProf2());
						otherProfAllied.setSumPosContracted(root.getSummary_contracted_otherAlliedProf2());
		
						LTCStaffPlanPosType.add(otherProfAllied);
					}
				}
	
				if(root.getAldnopDatagrid2() != null){
					int indexaldnop2 = 0;
					for(AldNopDatagrid otherNonProfessionalAllied : root.getAldnopDatagrid2()){
						LTCStaffPlanPosType otherNonProfAllied = new LTCStaffPlanPosType();
						otherNonProfAllied.setConfirmationId(root.getForm().getConfirmationId());
						otherNonProfAllied.setStaffingPlanNum("2");
						otherNonProfAllied.setStaffHrsPosType(Constants.DEFAULT_OTHER_NONPROF_ALLIED_VALUE);
						otherNonProfAllied.setStaffHrsPosOtherName(otherNonProfessionalAllied.getAldnopPositionType() + ++indexaldnop2);
						otherNonProfAllied.setSumStaffHrsMon(otherNonProfessionalAllied.getAldnop_other_mon());
						otherNonProfAllied.setSumStaffHrsTue(otherNonProfessionalAllied.getAldnop_other_tue());
						otherNonProfAllied.setSumStaffHrsWed(otherNonProfessionalAllied.getAldnop_other_wed());
						otherNonProfAllied.setSumStaffHrsThurs(otherNonProfessionalAllied.getAldnop_other_thu());
						otherNonProfAllied.setSumStaffHrsFri(otherNonProfessionalAllied.getAldnop_other_fri());
						otherNonProfAllied.setSumStaffHrsSat(otherNonProfessionalAllied.getAldnop_other_sat());
						otherNonProfAllied.setSumStaffHrsSun(otherNonProfessionalAllied.getAldnop_other_sun());
						otherNonProfAllied.setSumStaffHrsWkTotal(otherNonProfessionalAllied.getAldnop_other_total());
						otherNonProfAllied.setSumStaffHrsAnnual(otherNonProfessionalAllied.getAldnop_other_annual());
						otherNonProfAllied.setSumPosAnnual(root.getSummary_annual_otherAlliedNProf2());
						otherNonProfAllied.setSumPosInhouse(root.getSummary_inHouse_otherAlliedNProf2());
						otherNonProfAllied.setSumPosContracted(root.getSummary_contracted_otherAlliedNProf2());
		
						LTCStaffPlanPosType.add(otherNonProfAllied);
					}
				}
			}
			
			if(root.getStaffingPlanType3() != null && !root.getStaffingPlanType3().isEmpty()){
				LTCStaffPlanPosType NurseRN3 = new LTCStaffPlanPosType();
				NurseRN3.setConfirmationId(root.getForm().getConfirmationId());
				NurseRN3.setStaffingPlanNum("3");
				NurseRN3.setStaffHrsPosType(root.getRn_label1());
				NurseRN3.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				NurseRN3.setSumStaffHrsMon(root.getRn_mon_total3());
				NurseRN3.setSumStaffHrsTue(root.getRn_tue_total3());
				NurseRN3.setSumStaffHrsWed(root.getRn_wed_total3());
				NurseRN3.setSumStaffHrsThurs(root.getRn_thu_total3());
				NurseRN3.setSumStaffHrsFri(root.getRn_fri_total3());
				NurseRN3.setSumStaffHrsSat(root.getRn_sat_total3());
				NurseRN3.setSumStaffHrsSun(root.getRn_sun_total3());
				NurseRN3.setSumStaffHrsWkTotal(root.getRn_week_total3());
				NurseRN3.setSumStaffHrsAnnual(root.getRn_annual_total3());
				NurseRN3.setSumPosAnnual(root.getSummary_annual_RN3());
				NurseRN3.setSumPosInhouse(root.getSummary_inHouse_RN3());
				NurseRN3.setSumPosContracted(root.getSummary_contracted_RN3());
	
				LTCStaffPlanPosType NurseLPN3 = new LTCStaffPlanPosType();
				NurseLPN3.setConfirmationId(root.getForm().getConfirmationId());
				NurseLPN3.setStaffingPlanNum("3");
				NurseLPN3.setStaffHrsPosType(root.getLpn_label1());
				NurseLPN3.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				NurseLPN3.setSumStaffHrsMon(root.getLpn_mon_total3());
				NurseLPN3.setSumStaffHrsTue(root.getLpn_tue_total3());
				NurseLPN3.setSumStaffHrsWed(root.getLpn_wed_total3());
				NurseLPN3.setSumStaffHrsThurs(root.getLpn_thu_total3());
				NurseLPN3.setSumStaffHrsFri(root.getLpn_fri_total3());
				NurseLPN3.setSumStaffHrsSat(root.getLpn_sat_total3());
				NurseLPN3.setSumStaffHrsSun(root.getLpn_sun_total3());
				NurseLPN3.setSumStaffHrsWkTotal(root.getLpn_week_total3());
				NurseLPN3.setSumStaffHrsAnnual(root.getLpn_annual_total3());
				NurseLPN3.setSumPosAnnual(root.getSummary_annual_LPN3());
				NurseLPN3.setSumPosInhouse(root.getSummary_inHouse_LPN3());
				NurseLPN3.setSumPosContracted(root.getSummary_contracted_LPN3());
				
				LTCStaffPlanPosType NpNurseHCA3 = new LTCStaffPlanPosType();
				NpNurseHCA3.setConfirmationId(root.getForm().getConfirmationId());
				NpNurseHCA3.setStaffingPlanNum("3");
				NpNurseHCA3.setStaffHrsPosType(root.getHca_label1());
				NpNurseHCA3.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				NpNurseHCA3.setSumStaffHrsMon(root.getHca_mon_total3());
				NpNurseHCA3.setSumStaffHrsTue(root.getHca_tue_total3());
				NpNurseHCA3.setSumStaffHrsWed(root.getHca_wed_total3());
				NpNurseHCA3.setSumStaffHrsThurs(root.getHca_thu_total3());
				NpNurseHCA3.setSumStaffHrsFri(root.getHca_fri_total3());
				NpNurseHCA3.setSumStaffHrsSat(root.getHca_sat_total3());
				NpNurseHCA3.setSumStaffHrsSun(root.getHca_sun_total3());
				NpNurseHCA3.setSumStaffHrsWkTotal(root.getHca_week_total3());
				NpNurseHCA3.setSumStaffHrsAnnual(root.getHca_annual_total3());
				NpNurseHCA3.setSumPosAnnual(root.getSummary_annual_HCA3());
				NpNurseHCA3.setSumPosInhouse(root.getSummary_inHouse_HCA3());
				NpNurseHCA3.setSumPosContracted(root.getSummary_contracted_HCA3());
	
				LTCStaffPlanPosType OccTherapist3 = new LTCStaffPlanPosType();
				OccTherapist3.setConfirmationId(root.getForm().getConfirmationId());
				OccTherapist3.setStaffingPlanNum("3");
				OccTherapist3.setStaffHrsPosType(root.getAld_ot_label1());
				OccTherapist3.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				OccTherapist3.setSumStaffHrsMon(root.getAld_ot_mon3());
				OccTherapist3.setSumStaffHrsTue(root.getAld_ot_tue3());
				OccTherapist3.setSumStaffHrsWed(root.getAld_ot_wed3());
				OccTherapist3.setSumStaffHrsThurs(root.getAld_ot_thu3());
				OccTherapist3.setSumStaffHrsFri(root.getAld_ot_fri3());
				OccTherapist3.setSumStaffHrsSat(root.getAld_ot_sat3());
				OccTherapist3.setSumStaffHrsSun(root.getAld_ot_sun3());
				OccTherapist3.setSumStaffHrsWkTotal(root.getAld_ot_total3());
				OccTherapist3.setSumStaffHrsAnnual(root.getAld_ot_annual3());
				OccTherapist3.setSumPosAnnual(root.getSummary_annual_OT3());
				OccTherapist3.setSumPosInhouse(root.getSummary_inHouse_OT3());
				OccTherapist3.setSumPosContracted(root.getSummary_contracted_OT3());
	
				LTCStaffPlanPosType Physiotherapist3  = new LTCStaffPlanPosType();
				Physiotherapist3.setConfirmationId(root.getForm().getConfirmationId());
				Physiotherapist3.setStaffingPlanNum("3");
				Physiotherapist3.setStaffHrsPosType(root.getAld_pt_label1());
				Physiotherapist3.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				Physiotherapist3.setSumStaffHrsMon(root.getAld_pt_mon3());
				Physiotherapist3.setSumStaffHrsTue(root.getAld_pt_tue3());
				Physiotherapist3.setSumStaffHrsWed(root.getAld_pt_wed3());
				Physiotherapist3.setSumStaffHrsThurs(root.getAld_pt_thu3());
				Physiotherapist3.setSumStaffHrsFri(root.getAld_pt_fri3());
				Physiotherapist3.setSumStaffHrsSat(root.getAld_pt_sat3());
				Physiotherapist3.setSumStaffHrsSun(root.getAld_pt_sun3());
				Physiotherapist3.setSumStaffHrsWkTotal(root.getAld_pt_total3());
				Physiotherapist3.setSumStaffHrsAnnual(root.getAld_pt_annual3());
				Physiotherapist3.setSumPosAnnual(root.getSummary_annual_PT3());
				Physiotherapist3.setSumPosInhouse(root.getSummary_inHouse_PT3());
				Physiotherapist3.setSumPosContracted(root.getSummary_contracted_PT3());
				
				LTCStaffPlanPosType Dietitian3  = new LTCStaffPlanPosType();
				Dietitian3.setConfirmationId(root.getForm().getConfirmationId());
				Dietitian3.setStaffingPlanNum("3");
				Dietitian3.setStaffHrsPosType(root.getAld_dt_label1());
				Dietitian3.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				Dietitian3.setSumStaffHrsMon(root.getAld_dt_mon3());
				Dietitian3.setSumStaffHrsTue(root.getAld_dt_tue3());
				Dietitian3.setSumStaffHrsWed(root.getAld_dt_wed3());
				Dietitian3.setSumStaffHrsThurs(root.getAld_dt_thu3());
				Dietitian3.setSumStaffHrsFri(root.getAld_dt_fri3());
				Dietitian3.setSumStaffHrsSat(root.getAld_dt_sat3());
				Dietitian3.setSumStaffHrsSun(root.getAld_dt_sun3());
				Dietitian3.setSumStaffHrsWkTotal(root.getAld_dt_total3());
				Dietitian3.setSumStaffHrsAnnual(root.getAld_dt_annual3());
				Dietitian3.setSumPosAnnual(root.getSummary_annual_DT3());
				Dietitian3.setSumPosInhouse(root.getSummary_inHouse_DT3());
				Dietitian3.setSumPosContracted(root.getSummary_contracted_DT3());
				
				LTCStaffPlanPosType SocialWorker3 = new LTCStaffPlanPosType();
				SocialWorker3.setConfirmationId(root.getForm().getConfirmationId());
				SocialWorker3.setStaffingPlanNum("3");
				SocialWorker3.setStaffHrsPosType(root.getAld_sw_label1());
				SocialWorker3.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				SocialWorker3.setSumStaffHrsMon(root.getAld_sw_mon3());
				SocialWorker3.setSumStaffHrsTue(root.getAld_sw_tue3());
				SocialWorker3.setSumStaffHrsWed(root.getAld_sw_wed3());
				SocialWorker3.setSumStaffHrsThurs(root.getAld_sw_thu3());
				SocialWorker3.setSumStaffHrsFri(root.getAld_sw_fri3());
				SocialWorker3.setSumStaffHrsSat(root.getAld_sw_sat3());
				SocialWorker3.setSumStaffHrsSun(root.getAld_sw_sun3());
				SocialWorker3.setSumStaffHrsWkTotal(root.getAld_sw_total3());
				SocialWorker3.setSumStaffHrsAnnual(root.getAld_sw_annual3());
				SocialWorker3.setSumPosAnnual(root.getSummary_annual_SW3());
				SocialWorker3.setSumPosInhouse(root.getSummary_inHouse_SW3());
				SocialWorker3.setSumPosContracted(root.getSummary_contracted_SW3());
				
				LTCStaffPlanPosType SpeechPathologist3 = new LTCStaffPlanPosType();
				SpeechPathologist3.setConfirmationId(root.getForm().getConfirmationId());
				SpeechPathologist3.setStaffingPlanNum("3");
				SpeechPathologist3.setStaffHrsPosType(root.getAld_sp_label1());
				SpeechPathologist3.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				SpeechPathologist3.setSumStaffHrsMon(root.getAld_sp_mon3());
				SpeechPathologist3.setSumStaffHrsTue(root.getAld_sp_tue3());
				SpeechPathologist3.setSumStaffHrsWed(root.getAld_sp_wed3());
				SpeechPathologist3.setSumStaffHrsThurs(root.getAld_sp_thu3());
				SpeechPathologist3.setSumStaffHrsFri(root.getAld_sp_fri3());
				SpeechPathologist3.setSumStaffHrsSat(root.getAld_sp_sat3());
				SpeechPathologist3.setSumStaffHrsSun(root.getAld_sp_sun3());
				SpeechPathologist3.setSumStaffHrsWkTotal(root.getAld_sp_total3());
				SpeechPathologist3.setSumStaffHrsAnnual(root.getAld_sp_annual3());
				SpeechPathologist3.setSumPosAnnual(root.getSummary_annual_SL3());
				SpeechPathologist3.setSumPosInhouse(root.getSummary_inHouse_SL3());
				SpeechPathologist3.setSumPosContracted(root.getSummary_contracted_SL3());
				
				LTCStaffPlanPosType RespTherapist3 = new LTCStaffPlanPosType();
				RespTherapist3.setConfirmationId(root.getForm().getConfirmationId());
				RespTherapist3.setStaffingPlanNum("3");
				RespTherapist3.setStaffHrsPosType(root.getAld_rt_label1());
				RespTherapist3.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				RespTherapist3.setSumStaffHrsMon(root.getAld_rt_mon3());
				RespTherapist3.setSumStaffHrsTue(root.getAld_rt_tue3());
				RespTherapist3.setSumStaffHrsWed(root.getAld_rt_wed3());
				RespTherapist3.setSumStaffHrsThurs(root.getAld_rt_thu3());
				RespTherapist3.setSumStaffHrsFri(root.getAld_rt_fri3());
				RespTherapist3.setSumStaffHrsSat(root.getAld_rt_sat3());
				RespTherapist3.setSumStaffHrsSun(root.getAld_rt_sun3());
				RespTherapist3.setSumStaffHrsWkTotal(root.getAld_rt_total3());
				RespTherapist3.setSumStaffHrsAnnual(root.getAld_rt_annual3());
				RespTherapist3.setSumPosAnnual(root.getSummary_annual_resp3());
				RespTherapist3.setSumPosInhouse(root.getSummary_inHouse_resp3());
				RespTherapist3.setSumPosContracted(root.getSummary_contracted_resp3());
				
				LTCStaffPlanPosType RecTherapist3 = new LTCStaffPlanPosType();
				RecTherapist3.setConfirmationId(root.getForm().getConfirmationId());
				RecTherapist3.setStaffingPlanNum("3");
				RecTherapist3.setStaffHrsPosType(root.getAldnop_rt_label1());
				RecTherapist3.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				RecTherapist3.setSumStaffHrsMon(root.getAldnop_rt_mon3());
				RecTherapist3.setSumStaffHrsTue(root.getAldnop_rt_tue3());
				RecTherapist3.setSumStaffHrsWed(root.getAldnop_rt_wed3());
				RecTherapist3.setSumStaffHrsThurs(root.getAldnop_rt_thu3());
				RecTherapist3.setSumStaffHrsFri(root.getAldnop_rt_fri3());
				RecTherapist3.setSumStaffHrsSat(root.getAldnop_rt_sat3());
				RecTherapist3.setSumStaffHrsSun(root.getAldnop_rt_sun3());
				RecTherapist3.setSumStaffHrsWkTotal(root.getAldnop_rt_total3());
				RecTherapist3.setSumStaffHrsAnnual(root.getAldnop_rt_annual3());
				RecTherapist3.setSumPosAnnual(root.getSummary_annual_RT3());
				RecTherapist3.setSumPosInhouse(root.getSummary_inHouse_RT3());
				RecTherapist3.setSumPosContracted(root.getSummary_contracted_RT3());
				
				LTCStaffPlanPosType RehabAssistant3 = new LTCStaffPlanPosType();
				RehabAssistant3.setConfirmationId(root.getForm().getConfirmationId());
				RehabAssistant3.setStaffingPlanNum("3");
				RehabAssistant3.setStaffHrsPosType(root.getAldnop_ra_label1());
				RehabAssistant3.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				RehabAssistant3.setSumStaffHrsMon(root.getAldnop_ra_mon3());
				RehabAssistant3.setSumStaffHrsTue(root.getAldnop_ra_tue3());
				RehabAssistant3.setSumStaffHrsWed(root.getAldnop_ra_wed3());
				RehabAssistant3.setSumStaffHrsThurs(root.getAldnop_ra_thu3());
				RehabAssistant3.setSumStaffHrsFri(root.getAldnop_ra_fri3());
				RehabAssistant3.setSumStaffHrsSat(root.getAldnop_ra_sat3());
				RehabAssistant3.setSumStaffHrsSun(root.getAldnop_ra_sun3());
				RehabAssistant3.setSumStaffHrsWkTotal(root.getAldnop_ra_total3());
				RehabAssistant3.setSumStaffHrsAnnual(root.getAldnop_ra_annual3());
				RehabAssistant3.setSumPosAnnual(root.getSummary_annual_RA3());
				RehabAssistant3.setSumPosInhouse(root.getSummary_inHouse_RA3());
				RehabAssistant3.setSumPosContracted(root.getSummary_contracted_RA3());
				
				LTCStaffPlanPosType ActivityWorker3 = new LTCStaffPlanPosType();
				ActivityWorker3.setConfirmationId(root.getForm().getConfirmationId());
				ActivityWorker3.setStaffingPlanNum("3");
				ActivityWorker3.setStaffHrsPosType(root.getAldnop_aw_label1());
				ActivityWorker3.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				ActivityWorker3.setSumStaffHrsMon(root.getAldnop_aw_mon3());
				ActivityWorker3.setSumStaffHrsTue(root.getAldnop_aw_tue3());
				ActivityWorker3.setSumStaffHrsWed(root.getAldnop_aw_wed3());
				ActivityWorker3.setSumStaffHrsThurs(root.getAldnop_aw_thu3());
				ActivityWorker3.setSumStaffHrsFri(root.getAldnop_aw_fri3());
				ActivityWorker3.setSumStaffHrsSat(root.getAldnop_aw_sat3());
				ActivityWorker3.setSumStaffHrsSun(root.getAldnop_aw_sun3());
				ActivityWorker3.setSumStaffHrsWkTotal(root.getAldnop_aw_total3());
				ActivityWorker3.setSumStaffHrsAnnual(root.getAldnop_aw_annual3());
				ActivityWorker3.setSumPosAnnual(root.getSummary_annual_AW3());
				ActivityWorker3.setSumPosInhouse(root.getSummary_inHouse_AW3());
				ActivityWorker3.setSumPosContracted(root.getSummary_contracted_AW3());
				
				LTCStaffPlanPosType MusicTherapist3 = new LTCStaffPlanPosType();
				MusicTherapist3.setConfirmationId(root.getForm().getConfirmationId());
				MusicTherapist3.setStaffingPlanNum("3");
				MusicTherapist3.setStaffHrsPosType(root.getAldnop_mt_label1());
				MusicTherapist3.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				MusicTherapist3.setSumStaffHrsMon(root.getAldnop_mt_mon3());
				MusicTherapist3.setSumStaffHrsTue(root.getAldnop_mt_tue3());
				MusicTherapist3.setSumStaffHrsWed(root.getAldnop_mt_wed3());
				MusicTherapist3.setSumStaffHrsThurs(root.getAldnop_mt_thu3());
				MusicTherapist3.setSumStaffHrsFri(root.getAldnop_mt_fri3());
				MusicTherapist3.setSumStaffHrsSat(root.getAldnop_mt_sat3());
				MusicTherapist3.setSumStaffHrsSun(root.getAldnop_mt_sun3());
				MusicTherapist3.setSumStaffHrsWkTotal(root.getAldnop_mt_total3());
				MusicTherapist3.setSumStaffHrsAnnual(root.getAldnop_mt_annual3());
				MusicTherapist3.setSumPosAnnual(root.getSummary_annual_MT3());
				MusicTherapist3.setSumPosInhouse(root.getSummary_inHouse_MT3());
				MusicTherapist3.setSumPosContracted(root.getSummary_contracted_MT3());
	
				LTCStaffPlanPosType ArtTherapist3 = new LTCStaffPlanPosType();
				ArtTherapist3.setConfirmationId(root.getForm().getConfirmationId());
				ArtTherapist3.setStaffingPlanNum("3");
				ArtTherapist3.setStaffHrsPosType(root.getAldnop_at_label1());
				ArtTherapist3.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				ArtTherapist3.setSumStaffHrsMon(root.getAldnop_at_mon3());
				ArtTherapist3.setSumStaffHrsTue(root.getAldnop_at_tue3());
				ArtTherapist3.setSumStaffHrsWed(root.getAldnop_at_wed3());
				ArtTherapist3.setSumStaffHrsThurs(root.getAldnop_at_thu3());
				ArtTherapist3.setSumStaffHrsFri(root.getAldnop_at_fri3());
				ArtTherapist3.setSumStaffHrsSat(root.getAldnop_at_sat3());
				ArtTherapist3.setSumStaffHrsSun(root.getAldnop_at_sun3());
				ArtTherapist3.setSumStaffHrsWkTotal(root.getAldnop_at_total3());
				ArtTherapist3.setSumStaffHrsAnnual(root.getAldnop_at_annual3());
				ArtTherapist3.setSumPosAnnual(root.getSummary_annual_AT3());
				ArtTherapist3.setSumPosInhouse(root.getSummary_inHouse_AT3());
				ArtTherapist3.setSumPosContracted(root.getSummary_contracted_AT3());
	
				Collections.addAll(LTCStaffPlanPosType, NurseRN3, NurseLPN3, NpNurseHCA3, OccTherapist3, Physiotherapist3, Dietitian3, SocialWorker3,
					SpeechPathologist3, RespTherapist3, RecTherapist3, RehabAssistant3, ActivityWorker3, MusicTherapist3,
					ArtTherapist3);
	
				if(root.getNpDatagrid3() != null){
					int indexnp3 = 0;
					for(NpDatagrid otherProfessionalNurse : root.getNpDatagrid3()){
						LTCStaffPlanPosType otherNurse = new LTCStaffPlanPosType();
						otherNurse.setConfirmationId(root.getForm().getConfirmationId());
						otherNurse.setStaffingPlanNum("3");
						otherNurse.setStaffHrsPosType(Constants.DEFAULT_OTHER_PROF_NURSE_VALUE);
						otherNurse.setStaffHrsPosOtherName(otherProfessionalNurse.getNpPositionType() + ++indexnp3);
						otherNurse.setSumStaffHrsMon(otherProfessionalNurse.getNp_other_mon());
						otherNurse.setSumStaffHrsTue(otherProfessionalNurse.getNp_other_tue());
						otherNurse.setSumStaffHrsWed(otherProfessionalNurse.getNp_other_wed());
						otherNurse.setSumStaffHrsThurs(otherProfessionalNurse.getNp_other_thu());
						otherNurse.setSumStaffHrsFri(otherProfessionalNurse.getNp_other_fri());
						otherNurse.setSumStaffHrsSat(otherProfessionalNurse.getNp_other_sat());
						otherNurse.setSumStaffHrsSun(otherProfessionalNurse.getNp_other_sun());
						otherNurse.setSumStaffHrsWkTotal(otherProfessionalNurse.getNp_other_total());
						otherNurse.setSumStaffHrsAnnual(otherProfessionalNurse.getNp_other_annual());
						otherNurse.setSumPosAnnual(root.getSummary_annual_otherNursingP3());
						otherNurse.setSumPosInhouse(root.getSummary_inHouse_otherNursingP3());
						otherNurse.setSumPosContracted(root.getSummary_contracted_otherNursingP3());
			
						LTCStaffPlanPosType.add(otherNurse);
						
					}
				}
	
				if(root.getNnpDatagrid3() != null){
					int indexnnp3 = 0;
					for(NnpDatagrid otherNonProfessionalNurse : root.getNnpDatagrid3()){
						LTCStaffPlanPosType otherNPNurse = new LTCStaffPlanPosType();
						otherNPNurse.setConfirmationId(root.getForm().getConfirmationId());
						otherNPNurse.setStaffingPlanNum("3");
						otherNPNurse.setStaffHrsPosType(Constants.DEFAULT_OTHER_NONPROF_NURSE_VALUE);
						otherNPNurse.setStaffHrsPosOtherName(otherNonProfessionalNurse.getNnpPositionType() + ++indexnnp3);
						otherNPNurse.setSumStaffHrsMon(otherNonProfessionalNurse.getNnp_other_mon());
						otherNPNurse.setSumStaffHrsTue(otherNonProfessionalNurse.getNnp_other_tue());
						otherNPNurse.setSumStaffHrsWed(otherNonProfessionalNurse.getNnp_other_wed());
						otherNPNurse.setSumStaffHrsThurs(otherNonProfessionalNurse.getNnp_other_thu());
						otherNPNurse.setSumStaffHrsFri(otherNonProfessionalNurse.getNnp_other_fri());
						otherNPNurse.setSumStaffHrsSat(otherNonProfessionalNurse.getNnp_other_sat());
						otherNPNurse.setSumStaffHrsSun(otherNonProfessionalNurse.getNnp_other_sun());
						otherNPNurse.setSumStaffHrsWkTotal(otherNonProfessionalNurse.getNnp_other_total());
						otherNPNurse.setSumStaffHrsAnnual(otherNonProfessionalNurse.getNnp_other_annual());
						otherNPNurse.setSumPosAnnual(root.getSummary_annual_otherNursingNP3());
						otherNPNurse.setSumPosInhouse(root.getSummary_inHouse_otherNursingNP3());
						otherNPNurse.setSumPosContracted(root.getSummary_contracted_otherNursingNP3());
		
						LTCStaffPlanPosType.add(otherNPNurse);
					}
				}
	
				if(root.getAldDatagrid3() != null){
					int indexald3 = 0;
					for(AldDatagrid otherProfessionalAllied : root.getAldDatagrid3()){
						LTCStaffPlanPosType otherProfAllied = new LTCStaffPlanPosType();
						otherProfAllied.setConfirmationId(root.getForm().getConfirmationId());
						otherProfAllied.setStaffingPlanNum("3");
						otherProfAllied.setStaffHrsPosType(Constants.DEFAULT_OTHER_PROF_ALLIED_VALUE);
						otherProfAllied.setStaffHrsPosOtherName(otherProfessionalAllied.getAldPositionType() + ++indexald3);
						otherProfAllied.setSumStaffHrsMon(otherProfessionalAllied.getAld_other_mon());
						otherProfAllied.setSumStaffHrsTue(otherProfessionalAllied.getAld_other_tue());
						otherProfAllied.setSumStaffHrsWed(otherProfessionalAllied.getAld_other_wed());
						otherProfAllied.setSumStaffHrsThurs(otherProfessionalAllied.getAld_other_thu());
						otherProfAllied.setSumStaffHrsFri(otherProfessionalAllied.getAld_other_fri());
						otherProfAllied.setSumStaffHrsSat(otherProfessionalAllied.getAld_other_sat());
						otherProfAllied.setSumStaffHrsSun(otherProfessionalAllied.getAld_other_sun());
						otherProfAllied.setSumStaffHrsWkTotal(otherProfessionalAllied.getAld_other_total());
						otherProfAllied.setSumStaffHrsAnnual(otherProfessionalAllied.getAld_other_annual());
						otherProfAllied.setSumPosAnnual(root.getSummary_annual_otherAlliedProf3());
						otherProfAllied.setSumPosInhouse(root.getSummary_inHouse_otherAlliedProf3());
						otherProfAllied.setSumPosContracted(root.getSummary_contracted_otherAlliedProf3());
		
						LTCStaffPlanPosType.add(otherProfAllied);
					}
				}
	
				if(root.getAldnopDatagrid3() != null){
					int indexaldnop3 = 0;
					for(AldNopDatagrid otherNonProfessionalAllied : root.getAldnopDatagrid3()){
						LTCStaffPlanPosType otherNonProfAllied = new LTCStaffPlanPosType();
						otherNonProfAllied.setConfirmationId(root.getForm().getConfirmationId());
						otherNonProfAllied.setStaffingPlanNum("3");
						otherNonProfAllied.setStaffHrsPosType(Constants.DEFAULT_OTHER_NONPROF_ALLIED_VALUE);
						otherNonProfAllied.setStaffHrsPosOtherName(otherNonProfessionalAllied.getAldnopPositionType() + ++indexaldnop3);
						otherNonProfAllied.setSumStaffHrsMon(otherNonProfessionalAllied.getAldnop_other_mon());
						otherNonProfAllied.setSumStaffHrsTue(otherNonProfessionalAllied.getAldnop_other_tue());
						otherNonProfAllied.setSumStaffHrsWed(otherNonProfessionalAllied.getAldnop_other_wed());
						otherNonProfAllied.setSumStaffHrsThurs(otherNonProfessionalAllied.getAldnop_other_thu());
						otherNonProfAllied.setSumStaffHrsFri(otherNonProfessionalAllied.getAldnop_other_fri());
						otherNonProfAllied.setSumStaffHrsSat(otherNonProfessionalAllied.getAldnop_other_sat());
						otherNonProfAllied.setSumStaffHrsSun(otherNonProfessionalAllied.getAldnop_other_sun());
						otherNonProfAllied.setSumStaffHrsWkTotal(otherNonProfessionalAllied.getAldnop_other_total());
						otherNonProfAllied.setSumStaffHrsAnnual(otherNonProfessionalAllied.getAldnop_other_annual());
						otherNonProfAllied.setSumPosAnnual(root.getSummary_annual_otherAlliedNProf3());
						otherNonProfAllied.setSumPosInhouse(root.getSummary_inHouse_otherAlliedNProf3());
						otherNonProfAllied.setSumPosContracted(root.getSummary_contracted_otherAlliedNProf3());
		
						LTCStaffPlanPosType.add(otherNonProfAllied);
					}
				}
			}

			if(root.getStaffingPlanType4() != null && !root.getStaffingPlanType4().isEmpty()){
				LTCStaffPlanPosType NurseRN4 = new LTCStaffPlanPosType();
				NurseRN4.setConfirmationId(root.getForm().getConfirmationId());
				NurseRN4.setStaffingPlanNum("4");
				NurseRN4.setStaffHrsPosType(root.getRn_label1());
				NurseRN4.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				NurseRN4.setSumStaffHrsMon(root.getRn_mon_total4());
				NurseRN4.setSumStaffHrsTue(root.getRn_tue_total4());
				NurseRN4.setSumStaffHrsWed(root.getRn_wed_total4());
				NurseRN4.setSumStaffHrsThurs(root.getRn_thu_total4());
				NurseRN4.setSumStaffHrsFri(root.getRn_fri_total4());
				NurseRN4.setSumStaffHrsSat(root.getRn_sat_total4());
				NurseRN4.setSumStaffHrsSun(root.getRn_sun_total4());
				NurseRN4.setSumStaffHrsWkTotal(root.getRn_week_total4());
				NurseRN4.setSumStaffHrsAnnual(root.getRn_annual_total4());
				NurseRN4.setSumPosAnnual(root.getSummary_annual_RN4());
				NurseRN4.setSumPosInhouse(root.getSummary_inHouse_RN4());
				NurseRN4.setSumPosContracted(root.getSummary_contracted_RN4());
	
				LTCStaffPlanPosType NurseLPN4 = new LTCStaffPlanPosType();
				NurseLPN4.setConfirmationId(root.getForm().getConfirmationId());
				NurseLPN4.setStaffingPlanNum("4");
				NurseLPN4.setStaffHrsPosType(root.getLpn_label1());
				NurseLPN4.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				NurseLPN4.setSumStaffHrsMon(root.getLpn_mon_total4());
				NurseLPN4.setSumStaffHrsTue(root.getLpn_tue_total4());
				NurseLPN4.setSumStaffHrsWed(root.getLpn_wed_total4());
				NurseLPN4.setSumStaffHrsThurs(root.getLpn_thu_total4());
				NurseLPN4.setSumStaffHrsFri(root.getLpn_fri_total4());
				NurseLPN4.setSumStaffHrsSat(root.getLpn_sat_total4());
				NurseLPN4.setSumStaffHrsSun(root.getLpn_sun_total4());
				NurseLPN4.setSumStaffHrsWkTotal(root.getLpn_week_total4());
				NurseLPN4.setSumStaffHrsAnnual(root.getLpn_annual_total4());
				NurseLPN4.setSumPosAnnual(root.getSummary_annual_LPN4());
				NurseLPN4.setSumPosInhouse(root.getSummary_inHouse_LPN4());
				NurseLPN4.setSumPosContracted(root.getSummary_contracted_LPN4());
				
				LTCStaffPlanPosType NpNurseHCA4 = new LTCStaffPlanPosType();
				NpNurseHCA4.setConfirmationId(root.getForm().getConfirmationId());
				NpNurseHCA4.setStaffingPlanNum("4");
				NpNurseHCA4.setStaffHrsPosType(root.getHca_label1());
				NpNurseHCA4.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				NpNurseHCA4.setSumStaffHrsMon(root.getHca_mon_total4());
				NpNurseHCA4.setSumStaffHrsTue(root.getHca_tue_total4());
				NpNurseHCA4.setSumStaffHrsWed(root.getHca_wed_total4());
				NpNurseHCA4.setSumStaffHrsThurs(root.getHca_thu_total4());
				NpNurseHCA4.setSumStaffHrsFri(root.getHca_fri_total4());
				NpNurseHCA4.setSumStaffHrsSat(root.getHca_sat_total4());
				NpNurseHCA4.setSumStaffHrsSun(root.getHca_sun_total4());
				NpNurseHCA4.setSumStaffHrsWkTotal(root.getHca_week_total4());
				NpNurseHCA4.setSumStaffHrsAnnual(root.getHca_annual_total4());
				NpNurseHCA4.setSumPosAnnual(root.getSummary_annual_HCA4());
				NpNurseHCA4.setSumPosInhouse(root.getSummary_inHouse_HCA4());
				NpNurseHCA4.setSumPosContracted(root.getSummary_contracted_HCA4());
	
				LTCStaffPlanPosType OccTherapist4 = new LTCStaffPlanPosType();
				OccTherapist4.setConfirmationId(root.getForm().getConfirmationId());
				OccTherapist4.setStaffingPlanNum("4");
				OccTherapist4.setStaffHrsPosType(root.getAld_ot_label1());
				OccTherapist4.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				OccTherapist4.setSumStaffHrsMon(root.getAld_ot_mon4());
				OccTherapist4.setSumStaffHrsTue(root.getAld_ot_tue4());
				OccTherapist4.setSumStaffHrsWed(root.getAld_ot_wed4());
				OccTherapist4.setSumStaffHrsThurs(root.getAld_ot_thu4());
				OccTherapist4.setSumStaffHrsFri(root.getAld_ot_fri4());
				OccTherapist4.setSumStaffHrsSat(root.getAld_ot_sat4());
				OccTherapist4.setSumStaffHrsSun(root.getAld_ot_sun4());
				OccTherapist4.setSumStaffHrsWkTotal(root.getAld_ot_total4());
				OccTherapist4.setSumStaffHrsAnnual(root.getAld_ot_annual4());
				OccTherapist4.setSumPosAnnual(root.getSummary_annual_OT4());
				OccTherapist4.setSumPosInhouse(root.getSummary_inHouse_OT4());
				OccTherapist4.setSumPosContracted(root.getSummary_contracted_OT4());
	
				LTCStaffPlanPosType Physiotherapist4  = new LTCStaffPlanPosType();
				Physiotherapist4.setConfirmationId(root.getForm().getConfirmationId());
				Physiotherapist4.setStaffingPlanNum("4");
				Physiotherapist4.setStaffHrsPosType(root.getAld_pt_label1());
				Physiotherapist4.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				Physiotherapist4.setSumStaffHrsMon(root.getAld_pt_mon4());
				Physiotherapist4.setSumStaffHrsTue(root.getAld_pt_tue4());
				Physiotherapist4.setSumStaffHrsWed(root.getAld_pt_wed4());
				Physiotherapist4.setSumStaffHrsThurs(root.getAld_pt_thu4());
				Physiotherapist4.setSumStaffHrsFri(root.getAld_pt_fri4());
				Physiotherapist4.setSumStaffHrsSat(root.getAld_pt_sat4());
				Physiotherapist4.setSumStaffHrsSun(root.getAld_pt_sun4());
				Physiotherapist4.setSumStaffHrsWkTotal(root.getAld_pt_total4());
				Physiotherapist4.setSumStaffHrsAnnual(root.getAld_pt_annual4());
				Physiotherapist4.setSumPosAnnual(root.getSummary_annual_PT4());
				Physiotherapist4.setSumPosInhouse(root.getSummary_inHouse_PT4());
				Physiotherapist4.setSumPosContracted(root.getSummary_contracted_PT4());
				
				LTCStaffPlanPosType Dietitian4  = new LTCStaffPlanPosType();
				Dietitian4.setConfirmationId(root.getForm().getConfirmationId());
				Dietitian4.setStaffingPlanNum("4");
				Dietitian4.setStaffHrsPosType(root.getAld_dt_label1());
				Dietitian4.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				Dietitian4.setSumStaffHrsMon(root.getAld_dt_mon4());
				Dietitian4.setSumStaffHrsTue(root.getAld_dt_tue4());
				Dietitian4.setSumStaffHrsWed(root.getAld_dt_wed4());
				Dietitian4.setSumStaffHrsThurs(root.getAld_dt_thu4());
				Dietitian4.setSumStaffHrsFri(root.getAld_dt_fri4());
				Dietitian4.setSumStaffHrsSat(root.getAld_dt_sat4());
				Dietitian4.setSumStaffHrsSun(root.getAld_dt_sun4());
				Dietitian4.setSumStaffHrsWkTotal(root.getAld_dt_total4());
				Dietitian4.setSumStaffHrsAnnual(root.getAld_dt_annual4());
				Dietitian4.setSumPosAnnual(root.getSummary_annual_DT4());
				Dietitian4.setSumPosInhouse(root.getSummary_inHouse_DT4());
				Dietitian4.setSumPosContracted(root.getSummary_contracted_DT4());
				
				LTCStaffPlanPosType SocialWorker4 = new LTCStaffPlanPosType();
				SocialWorker4.setConfirmationId(root.getForm().getConfirmationId());
				SocialWorker4.setStaffingPlanNum("4");
				SocialWorker4.setStaffHrsPosType(root.getAld_sw_label1());
				SocialWorker4.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				SocialWorker4.setSumStaffHrsMon(root.getAld_sw_mon4());
				SocialWorker4.setSumStaffHrsTue(root.getAld_sw_tue4());
				SocialWorker4.setSumStaffHrsWed(root.getAld_sw_wed4());
				SocialWorker4.setSumStaffHrsThurs(root.getAld_sw_thu4());
				SocialWorker4.setSumStaffHrsFri(root.getAld_sw_fri4());
				SocialWorker4.setSumStaffHrsSat(root.getAld_sw_sat4());
				SocialWorker4.setSumStaffHrsSun(root.getAld_sw_sun4());
				SocialWorker4.setSumStaffHrsWkTotal(root.getAld_sw_total4());
				SocialWorker4.setSumStaffHrsAnnual(root.getAld_sw_annual4());
				SocialWorker4.setSumPosAnnual(root.getSummary_annual_SW4());
				SocialWorker4.setSumPosInhouse(root.getSummary_inHouse_SW4());
				SocialWorker4.setSumPosContracted(root.getSummary_contracted_SW4());
				
				LTCStaffPlanPosType SpeechPathologist4 = new LTCStaffPlanPosType();
				SpeechPathologist4.setConfirmationId(root.getForm().getConfirmationId());
				SpeechPathologist4.setStaffingPlanNum("4");
				SpeechPathologist4.setStaffHrsPosType(root.getAld_sp_label1());
				SpeechPathologist4.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				SpeechPathologist4.setSumStaffHrsMon(root.getAld_sp_mon4());
				SpeechPathologist4.setSumStaffHrsTue(root.getAld_sp_tue4());
				SpeechPathologist4.setSumStaffHrsWed(root.getAld_sp_wed4());
				SpeechPathologist4.setSumStaffHrsThurs(root.getAld_sp_thu4());
				SpeechPathologist4.setSumStaffHrsFri(root.getAld_sp_fri4());
				SpeechPathologist4.setSumStaffHrsSat(root.getAld_sp_sat4());
				SpeechPathologist4.setSumStaffHrsSun(root.getAld_sp_sun4());
				SpeechPathologist4.setSumStaffHrsWkTotal(root.getAld_sp_total4());
				SpeechPathologist4.setSumStaffHrsAnnual(root.getAld_sp_annual4());
				SpeechPathologist4.setSumPosAnnual(root.getSummary_annual_SL4());
				SpeechPathologist4.setSumPosInhouse(root.getSummary_inHouse_SL4());
				SpeechPathologist4.setSumPosContracted(root.getSummary_contracted_SL4());
				
				LTCStaffPlanPosType RespTherapist4 = new LTCStaffPlanPosType();
				RespTherapist4.setConfirmationId(root.getForm().getConfirmationId());
				RespTherapist4.setStaffingPlanNum("4");
				RespTherapist4.setStaffHrsPosType(root.getAld_rt_label1());
				RespTherapist4.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				RespTherapist4.setSumStaffHrsMon(root.getAld_rt_mon4());
				RespTherapist4.setSumStaffHrsTue(root.getAld_rt_tue4());
				RespTherapist4.setSumStaffHrsWed(root.getAld_rt_wed4());
				RespTherapist4.setSumStaffHrsThurs(root.getAld_rt_thu4());
				RespTherapist4.setSumStaffHrsFri(root.getAld_rt_fri4());
				RespTherapist4.setSumStaffHrsSat(root.getAld_rt_sat4());
				RespTherapist4.setSumStaffHrsSun(root.getAld_rt_sun4());
				RespTherapist4.setSumStaffHrsWkTotal(root.getAld_rt_total4());
				RespTherapist4.setSumStaffHrsAnnual(root.getAld_rt_annual4());
				RespTherapist4.setSumPosAnnual(root.getSummary_annual_resp4());
				RespTherapist4.setSumPosInhouse(root.getSummary_inHouse_resp4());
				RespTherapist4.setSumPosContracted(root.getSummary_contracted_resp4());
				
				LTCStaffPlanPosType RecTherapist4 = new LTCStaffPlanPosType();
				RecTherapist4.setConfirmationId(root.getForm().getConfirmationId());
				RecTherapist4.setStaffingPlanNum("4");
				RecTherapist4.setStaffHrsPosType(root.getAldnop_rt_label1());
				RecTherapist4.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				RecTherapist4.setSumStaffHrsMon(root.getAldnop_rt_mon4());
				RecTherapist4.setSumStaffHrsTue(root.getAldnop_rt_tue4());
				RecTherapist4.setSumStaffHrsWed(root.getAldnop_rt_wed4());
				RecTherapist4.setSumStaffHrsThurs(root.getAldnop_rt_thu4());
				RecTherapist4.setSumStaffHrsFri(root.getAldnop_rt_fri4());
				RecTherapist4.setSumStaffHrsSat(root.getAldnop_rt_sat4());
				RecTherapist4.setSumStaffHrsSun(root.getAldnop_rt_sun4());
				RecTherapist4.setSumStaffHrsWkTotal(root.getAldnop_rt_total4());
				RecTherapist4.setSumStaffHrsAnnual(root.getAldnop_rt_annual4());
				RecTherapist4.setSumPosAnnual(root.getSummary_annual_RT4());
				RecTherapist4.setSumPosInhouse(root.getSummary_inHouse_RT4());
				RecTherapist4.setSumPosContracted(root.getSummary_contracted_RT4());
				
				LTCStaffPlanPosType RehabAssistant4 = new LTCStaffPlanPosType();
				RehabAssistant4.setConfirmationId(root.getForm().getConfirmationId());
				RehabAssistant4.setStaffingPlanNum("4");
				RehabAssistant4.setStaffHrsPosType(root.getAldnop_ra_label1());
				RehabAssistant4.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				RehabAssistant4.setSumStaffHrsMon(root.getAldnop_ra_mon4());
				RehabAssistant4.setSumStaffHrsTue(root.getAldnop_ra_tue4());
				RehabAssistant4.setSumStaffHrsWed(root.getAldnop_ra_wed4());
				RehabAssistant4.setSumStaffHrsThurs(root.getAldnop_ra_thu4());
				RehabAssistant4.setSumStaffHrsFri(root.getAldnop_ra_fri4());
				RehabAssistant4.setSumStaffHrsSat(root.getAldnop_ra_sat4());
				RehabAssistant4.setSumStaffHrsSun(root.getAldnop_ra_sun4());
				RehabAssistant4.setSumStaffHrsWkTotal(root.getAldnop_ra_total4());
				RehabAssistant4.setSumStaffHrsAnnual(root.getAldnop_ra_annual4());
				RehabAssistant4.setSumPosAnnual(root.getSummary_annual_RA4());
				RehabAssistant4.setSumPosInhouse(root.getSummary_inHouse_RA4());
				RehabAssistant4.setSumPosContracted(root.getSummary_contracted_RA4());
				
				LTCStaffPlanPosType ActivityWorker4 = new LTCStaffPlanPosType();
				ActivityWorker4.setConfirmationId(root.getForm().getConfirmationId());
				ActivityWorker4.setStaffingPlanNum("4");
				ActivityWorker4.setStaffHrsPosType(root.getAldnop_aw_label1());
				ActivityWorker4.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				ActivityWorker4.setSumStaffHrsMon(root.getAldnop_aw_mon4());
				ActivityWorker4.setSumStaffHrsTue(root.getAldnop_aw_tue4());
				ActivityWorker4.setSumStaffHrsWed(root.getAldnop_aw_wed4());
				ActivityWorker4.setSumStaffHrsThurs(root.getAldnop_aw_thu4());
				ActivityWorker4.setSumStaffHrsFri(root.getAldnop_aw_fri4());
				ActivityWorker4.setSumStaffHrsSat(root.getAldnop_aw_sat4());
				ActivityWorker4.setSumStaffHrsSun(root.getAldnop_aw_sun4());
				ActivityWorker4.setSumStaffHrsWkTotal(root.getAldnop_aw_total4());
				ActivityWorker4.setSumStaffHrsAnnual(root.getAldnop_aw_annual4());
				ActivityWorker4.setSumPosAnnual(root.getSummary_annual_AW4());
				ActivityWorker4.setSumPosInhouse(root.getSummary_inHouse_AW4());
				ActivityWorker4.setSumPosContracted(root.getSummary_contracted_AW4());
				
				LTCStaffPlanPosType MusicTherapist4 = new LTCStaffPlanPosType();
				MusicTherapist4.setConfirmationId(root.getForm().getConfirmationId());
				MusicTherapist4.setStaffingPlanNum("4");
				MusicTherapist4.setStaffHrsPosType(root.getAldnop_mt_label1());
				MusicTherapist4.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				MusicTherapist4.setSumStaffHrsMon(root.getAldnop_mt_mon4());
				MusicTherapist4.setSumStaffHrsTue(root.getAldnop_mt_tue4());
				MusicTherapist4.setSumStaffHrsWed(root.getAldnop_mt_wed4());
				MusicTherapist4.setSumStaffHrsThurs(root.getAldnop_mt_thu4());
				MusicTherapist4.setSumStaffHrsFri(root.getAldnop_mt_fri4());
				MusicTherapist4.setSumStaffHrsSat(root.getAldnop_mt_sat4());
				MusicTherapist4.setSumStaffHrsSun(root.getAldnop_mt_sun4());
				MusicTherapist4.setSumStaffHrsWkTotal(root.getAldnop_mt_total4());
				MusicTherapist4.setSumStaffHrsAnnual(root.getAldnop_mt_annual4());
				MusicTherapist4.setSumPosAnnual(root.getSummary_annual_MT4());
				MusicTherapist4.setSumPosInhouse(root.getSummary_inHouse_MT4());
				MusicTherapist4.setSumPosContracted(root.getSummary_contracted_MT4());
	
				LTCStaffPlanPosType ArtTherapist4 = new LTCStaffPlanPosType();
				ArtTherapist4.setConfirmationId(root.getForm().getConfirmationId());
				ArtTherapist4.setStaffingPlanNum("4");
				ArtTherapist4.setStaffHrsPosType(root.getAldnop_at_label1());
				ArtTherapist4.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				ArtTherapist4.setSumStaffHrsMon(root.getAldnop_at_mon4());
				ArtTherapist4.setSumStaffHrsTue(root.getAldnop_at_tue4());
				ArtTherapist4.setSumStaffHrsWed(root.getAldnop_at_wed4());
				ArtTherapist4.setSumStaffHrsThurs(root.getAldnop_at_thu4());
				ArtTherapist4.setSumStaffHrsFri(root.getAldnop_at_fri4());
				ArtTherapist4.setSumStaffHrsSat(root.getAldnop_at_sat4());
				ArtTherapist4.setSumStaffHrsSun(root.getAldnop_at_sun4());
				ArtTherapist4.setSumStaffHrsWkTotal(root.getAldnop_at_total4());
				ArtTherapist4.setSumStaffHrsAnnual(root.getAldnop_at_annual4());
				ArtTherapist4.setSumPosAnnual(root.getSummary_annual_AT4());
				ArtTherapist4.setSumPosInhouse(root.getSummary_inHouse_AT4());
				ArtTherapist4.setSumPosContracted(root.getSummary_contracted_AT4());
	
				Collections.addAll(LTCStaffPlanPosType, NurseRN4, NurseLPN4, NpNurseHCA4, OccTherapist4, Physiotherapist4, Dietitian4, SocialWorker4,
					SpeechPathologist4, RespTherapist4, RecTherapist4, RehabAssistant4, ActivityWorker4, MusicTherapist4,
					ArtTherapist4);
	
				if(root.getNpDatagrid4() != null){
					int indexnp4 = 0;
					for(NpDatagrid otherProfessionalNurse : root.getNpDatagrid4()){
						LTCStaffPlanPosType otherNurse = new LTCStaffPlanPosType();
						otherNurse.setConfirmationId(root.getForm().getConfirmationId());
						otherNurse.setStaffingPlanNum("4");
						otherNurse.setStaffHrsPosType(Constants.DEFAULT_OTHER_PROF_NURSE_VALUE);
						otherNurse.setStaffHrsPosOtherName(otherProfessionalNurse.getNpPositionType() + ++indexnp4);
						otherNurse.setSumStaffHrsMon(otherProfessionalNurse.getNp_other_mon());
						otherNurse.setSumStaffHrsTue(otherProfessionalNurse.getNp_other_tue());
						otherNurse.setSumStaffHrsWed(otherProfessionalNurse.getNp_other_wed());
						otherNurse.setSumStaffHrsThurs(otherProfessionalNurse.getNp_other_thu());
						otherNurse.setSumStaffHrsFri(otherProfessionalNurse.getNp_other_fri());
						otherNurse.setSumStaffHrsSat(otherProfessionalNurse.getNp_other_sat());
						otherNurse.setSumStaffHrsSun(otherProfessionalNurse.getNp_other_sun());
						otherNurse.setSumStaffHrsWkTotal(otherProfessionalNurse.getNp_other_total());
						otherNurse.setSumStaffHrsAnnual(otherProfessionalNurse.getNp_other_annual());
						otherNurse.setSumPosAnnual(root.getSummary_annual_otherNursingP4());
						otherNurse.setSumPosInhouse(root.getSummary_inHouse_otherNursingP4());
						otherNurse.setSumPosContracted(root.getSummary_contracted_otherNursingP4());
			
						LTCStaffPlanPosType.add(otherNurse);
						
					}
				}
	
				if(root.getNnpDatagrid4() != null){
					int indexnnp4 = 0;
					for(NnpDatagrid otherNonProfessionalNurse : root.getNnpDatagrid4()){
						LTCStaffPlanPosType otherNPNurse = new LTCStaffPlanPosType();
						otherNPNurse.setConfirmationId(root.getForm().getConfirmationId());
						otherNPNurse.setStaffingPlanNum("4");
						otherNPNurse.setStaffHrsPosType(Constants.DEFAULT_OTHER_NONPROF_NURSE_VALUE);
						otherNPNurse.setStaffHrsPosOtherName(otherNonProfessionalNurse.getNnpPositionType() + ++indexnnp4);
						otherNPNurse.setSumStaffHrsMon(otherNonProfessionalNurse.getNnp_other_mon());
						otherNPNurse.setSumStaffHrsTue(otherNonProfessionalNurse.getNnp_other_tue());
						otherNPNurse.setSumStaffHrsWed(otherNonProfessionalNurse.getNnp_other_wed());
						otherNPNurse.setSumStaffHrsThurs(otherNonProfessionalNurse.getNnp_other_thu());
						otherNPNurse.setSumStaffHrsFri(otherNonProfessionalNurse.getNnp_other_fri());
						otherNPNurse.setSumStaffHrsSat(otherNonProfessionalNurse.getNnp_other_sat());
						otherNPNurse.setSumStaffHrsSun(otherNonProfessionalNurse.getNnp_other_sun());
						otherNPNurse.setSumStaffHrsWkTotal(otherNonProfessionalNurse.getNnp_other_total());
						otherNPNurse.setSumStaffHrsAnnual(otherNonProfessionalNurse.getNnp_other_annual());
						otherNPNurse.setSumPosAnnual(root.getSummary_annual_otherNursingNP4());
						otherNPNurse.setSumPosInhouse(root.getSummary_inHouse_otherNursingNP4());
						otherNPNurse.setSumPosContracted(root.getSummary_contracted_otherNursingNP4());
		
						LTCStaffPlanPosType.add(otherNPNurse);
					}
				}
	
				if(root.getAldDatagrid4() != null){
					int indexald4 = 0;
					for(AldDatagrid otherProfessionalAllied : root.getAldDatagrid4()){
						LTCStaffPlanPosType otherProfAllied = new LTCStaffPlanPosType();
						otherProfAllied.setConfirmationId(root.getForm().getConfirmationId());
						otherProfAllied.setStaffingPlanNum("4");
						otherProfAllied.setStaffHrsPosType(Constants.DEFAULT_OTHER_PROF_ALLIED_VALUE);
						otherProfAllied.setStaffHrsPosOtherName(otherProfessionalAllied.getAldPositionType() + ++indexald4);
						otherProfAllied.setSumStaffHrsMon(otherProfessionalAllied.getAld_other_mon());
						otherProfAllied.setSumStaffHrsTue(otherProfessionalAllied.getAld_other_tue());
						otherProfAllied.setSumStaffHrsWed(otherProfessionalAllied.getAld_other_wed());
						otherProfAllied.setSumStaffHrsThurs(otherProfessionalAllied.getAld_other_thu());
						otherProfAllied.setSumStaffHrsFri(otherProfessionalAllied.getAld_other_fri());
						otherProfAllied.setSumStaffHrsSat(otherProfessionalAllied.getAld_other_sat());
						otherProfAllied.setSumStaffHrsSun(otherProfessionalAllied.getAld_other_sun());
						otherProfAllied.setSumStaffHrsWkTotal(otherProfessionalAllied.getAld_other_total());
						otherProfAllied.setSumStaffHrsAnnual(otherProfessionalAllied.getAld_other_annual());
						otherProfAllied.setSumPosAnnual(root.getSummary_annual_otherAlliedProf4());
						otherProfAllied.setSumPosInhouse(root.getSummary_inHouse_otherAlliedProf4());
						otherProfAllied.setSumPosContracted(root.getSummary_contracted_otherAlliedProf4());
		
						LTCStaffPlanPosType.add(otherProfAllied);
					}
				}
	
				if(root.getAldnopDatagrid4() != null){
					int indexaldnop4 = 0;
					for(AldNopDatagrid otherNonProfessionalAllied : root.getAldnopDatagrid4()){
						LTCStaffPlanPosType otherNonProfAllied = new LTCStaffPlanPosType();
						otherNonProfAllied.setConfirmationId(root.getForm().getConfirmationId());
						otherNonProfAllied.setStaffingPlanNum("4");
						otherNonProfAllied.setStaffHrsPosType(Constants.DEFAULT_OTHER_NONPROF_ALLIED_VALUE);
						otherNonProfAllied.setStaffHrsPosOtherName(otherNonProfessionalAllied.getAldnopPositionType() + ++indexaldnop4);
						otherNonProfAllied.setSumStaffHrsMon(otherNonProfessionalAllied.getAldnop_other_mon());
						otherNonProfAllied.setSumStaffHrsTue(otherNonProfessionalAllied.getAldnop_other_tue());
						otherNonProfAllied.setSumStaffHrsWed(otherNonProfessionalAllied.getAldnop_other_wed());
						otherNonProfAllied.setSumStaffHrsThurs(otherNonProfessionalAllied.getAldnop_other_thu());
						otherNonProfAllied.setSumStaffHrsFri(otherNonProfessionalAllied.getAldnop_other_fri());
						otherNonProfAllied.setSumStaffHrsSat(otherNonProfessionalAllied.getAldnop_other_sat());
						otherNonProfAllied.setSumStaffHrsSun(otherNonProfessionalAllied.getAldnop_other_sun());
						otherNonProfAllied.setSumStaffHrsWkTotal(otherNonProfessionalAllied.getAldnop_other_total());
						otherNonProfAllied.setSumStaffHrsAnnual(otherNonProfessionalAllied.getAldnop_other_annual());
						otherNonProfAllied.setSumPosAnnual(root.getSummary_annual_otherAlliedNProf4());
						otherNonProfAllied.setSumPosInhouse(root.getSummary_inHouse_otherAlliedNProf4());
						otherNonProfAllied.setSumPosContracted(root.getSummary_contracted_otherAlliedNProf4());
		
						LTCStaffPlanPosType.add(otherNonProfAllied);
					}
				}
			}

			if(root.getStaffingPlanType5() != null && !root.getStaffingPlanType5().isEmpty()){
				LTCStaffPlanPosType NurseRN5 = new LTCStaffPlanPosType();
				NurseRN5.setConfirmationId(root.getForm().getConfirmationId());
				NurseRN5.setStaffingPlanNum("5");
				NurseRN5.setStaffHrsPosType(root.getRn_label1());
				NurseRN5.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				NurseRN5.setSumStaffHrsMon(root.getRn_mon_total5());
				NurseRN5.setSumStaffHrsTue(root.getRn_tue_total5());
				NurseRN5.setSumStaffHrsWed(root.getRn_wed_total5());
				NurseRN5.setSumStaffHrsThurs(root.getRn_thu_total5());
				NurseRN5.setSumStaffHrsFri(root.getRn_fri_total5());
				NurseRN5.setSumStaffHrsSat(root.getRn_sat_total5());
				NurseRN5.setSumStaffHrsSun(root.getRn_sun_total5());
				NurseRN5.setSumStaffHrsWkTotal(root.getRn_week_total5());
				NurseRN5.setSumStaffHrsAnnual(root.getRn_annual_total5());
				NurseRN5.setSumPosAnnual(root.getSummary_annual_RN5());
				NurseRN5.setSumPosInhouse(root.getSummary_inHouse_RN5());
				NurseRN5.setSumPosContracted(root.getSummary_contracted_RN5());
	
				LTCStaffPlanPosType NurseLPN5 = new LTCStaffPlanPosType();
				NurseLPN5.setConfirmationId(root.getForm().getConfirmationId());
				NurseLPN5.setStaffingPlanNum("5");
				NurseLPN5.setStaffHrsPosType(root.getLpn_label1());
				NurseLPN5.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				NurseLPN5.setSumStaffHrsMon(root.getLpn_mon_total5());
				NurseLPN5.setSumStaffHrsTue(root.getLpn_tue_total5());
				NurseLPN5.setSumStaffHrsWed(root.getLpn_wed_total5());
				NurseLPN5.setSumStaffHrsThurs(root.getLpn_thu_total5());
				NurseLPN5.setSumStaffHrsFri(root.getLpn_fri_total5());
				NurseLPN5.setSumStaffHrsSat(root.getLpn_sat_total5());
				NurseLPN5.setSumStaffHrsSun(root.getLpn_sun_total5());
				NurseLPN5.setSumStaffHrsWkTotal(root.getLpn_week_total5());
				NurseLPN5.setSumStaffHrsAnnual(root.getLpn_annual_total5());
				NurseLPN5.setSumPosAnnual(root.getSummary_annual_LPN5());
				NurseLPN5.setSumPosInhouse(root.getSummary_inHouse_LPN5());
				NurseLPN5.setSumPosContracted(root.getSummary_contracted_LPN5());
				
				LTCStaffPlanPosType NpNurseHCA5 = new LTCStaffPlanPosType();
				NpNurseHCA5.setConfirmationId(root.getForm().getConfirmationId());
				NpNurseHCA5.setStaffingPlanNum("5");
				NpNurseHCA5.setStaffHrsPosType(root.getHca_label1());
				NpNurseHCA5.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				NpNurseHCA5.setSumStaffHrsMon(root.getHca_mon_total5());
				NpNurseHCA5.setSumStaffHrsTue(root.getHca_tue_total5());
				NpNurseHCA5.setSumStaffHrsWed(root.getHca_wed_total5());
				NpNurseHCA5.setSumStaffHrsThurs(root.getHca_thu_total5());
				NpNurseHCA5.setSumStaffHrsFri(root.getHca_fri_total5());
				NpNurseHCA5.setSumStaffHrsSat(root.getHca_sat_total5());
				NpNurseHCA5.setSumStaffHrsSun(root.getHca_sun_total5());
				NpNurseHCA5.setSumStaffHrsWkTotal(root.getHca_week_total5());
				NpNurseHCA5.setSumStaffHrsAnnual(root.getHca_annual_total5());
				NpNurseHCA5.setSumPosAnnual(root.getSummary_annual_HCA5());
				NpNurseHCA5.setSumPosInhouse(root.getSummary_inHouse_HCA5());
				NpNurseHCA5.setSumPosContracted(root.getSummary_contracted_HCA5());
	
				LTCStaffPlanPosType OccTherapist5 = new LTCStaffPlanPosType();
				OccTherapist5.setConfirmationId(root.getForm().getConfirmationId());
				OccTherapist5.setStaffingPlanNum("5");
				OccTherapist5.setStaffHrsPosType(root.getAld_ot_label1());
				OccTherapist5.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				OccTherapist5.setSumStaffHrsMon(root.getAld_ot_mon5());
				OccTherapist5.setSumStaffHrsTue(root.getAld_ot_tue5());
				OccTherapist5.setSumStaffHrsWed(root.getAld_ot_wed5());
				OccTherapist5.setSumStaffHrsThurs(root.getAld_ot_thu5());
				OccTherapist5.setSumStaffHrsFri(root.getAld_ot_fri5());
				OccTherapist5.setSumStaffHrsSat(root.getAld_ot_sat5());
				OccTherapist5.setSumStaffHrsSun(root.getAld_ot_sun5());
				OccTherapist5.setSumStaffHrsWkTotal(root.getAld_ot_total5());
				OccTherapist5.setSumStaffHrsAnnual(root.getAld_ot_annual5());
				OccTherapist5.setSumPosAnnual(root.getSummary_annual_OT5());
				OccTherapist5.setSumPosInhouse(root.getSummary_inHouse_OT5());
				OccTherapist5.setSumPosContracted(root.getSummary_contracted_OT5());
	
				LTCStaffPlanPosType Physiotherapist5  = new LTCStaffPlanPosType();
				Physiotherapist5.setConfirmationId(root.getForm().getConfirmationId());
				Physiotherapist5.setStaffingPlanNum("5");
				Physiotherapist5.setStaffHrsPosType(root.getAld_pt_label1());
				Physiotherapist5.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				Physiotherapist5.setSumStaffHrsMon(root.getAld_pt_mon5());
				Physiotherapist5.setSumStaffHrsTue(root.getAld_pt_tue5());
				Physiotherapist5.setSumStaffHrsWed(root.getAld_pt_wed5());
				Physiotherapist5.setSumStaffHrsThurs(root.getAld_pt_thu5());
				Physiotherapist5.setSumStaffHrsFri(root.getAld_pt_fri5());
				Physiotherapist5.setSumStaffHrsSat(root.getAld_pt_sat5());
				Physiotherapist5.setSumStaffHrsSun(root.getAld_pt_sun5());
				Physiotherapist5.setSumStaffHrsWkTotal(root.getAld_pt_total5());
				Physiotherapist5.setSumStaffHrsAnnual(root.getAld_pt_annual5());
				Physiotherapist5.setSumPosAnnual(root.getSummary_annual_PT5());
				Physiotherapist5.setSumPosInhouse(root.getSummary_inHouse_PT5());
				Physiotherapist5.setSumPosContracted(root.getSummary_contracted_PT5());
				
				LTCStaffPlanPosType Dietitian5  = new LTCStaffPlanPosType();
				Dietitian5.setConfirmationId(root.getForm().getConfirmationId());
				Dietitian5.setStaffingPlanNum("5");
				Dietitian5.setStaffHrsPosType(root.getAld_dt_label1());
				Dietitian5.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				Dietitian5.setSumStaffHrsMon(root.getAld_dt_mon5());
				Dietitian5.setSumStaffHrsTue(root.getAld_dt_tue5());
				Dietitian5.setSumStaffHrsWed(root.getAld_dt_wed5());
				Dietitian5.setSumStaffHrsThurs(root.getAld_dt_thu5());
				Dietitian5.setSumStaffHrsFri(root.getAld_dt_fri5());
				Dietitian5.setSumStaffHrsSat(root.getAld_dt_sat5());
				Dietitian5.setSumStaffHrsSun(root.getAld_dt_sun5());
				Dietitian5.setSumStaffHrsWkTotal(root.getAld_dt_total5());
				Dietitian5.setSumStaffHrsAnnual(root.getAld_dt_annual5());
				Dietitian5.setSumPosAnnual(root.getSummary_annual_DT5());
				Dietitian5.setSumPosInhouse(root.getSummary_inHouse_DT5());
				Dietitian5.setSumPosContracted(root.getSummary_contracted_DT5());
				
				LTCStaffPlanPosType SocialWorker5 = new LTCStaffPlanPosType();
				SocialWorker5.setConfirmationId(root.getForm().getConfirmationId());
				SocialWorker5.setStaffingPlanNum("5");
				SocialWorker5.setStaffHrsPosType(root.getAld_sw_label1());
				SocialWorker5.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				SocialWorker5.setSumStaffHrsMon(root.getAld_sw_mon5());
				SocialWorker5.setSumStaffHrsTue(root.getAld_sw_tue5());
				SocialWorker5.setSumStaffHrsWed(root.getAld_sw_wed5());
				SocialWorker5.setSumStaffHrsThurs(root.getAld_sw_thu5());
				SocialWorker5.setSumStaffHrsFri(root.getAld_sw_fri5());
				SocialWorker5.setSumStaffHrsSat(root.getAld_sw_sat5());
				SocialWorker5.setSumStaffHrsSun(root.getAld_sw_sun5());
				SocialWorker5.setSumStaffHrsWkTotal(root.getAld_sw_total5());
				SocialWorker5.setSumStaffHrsAnnual(root.getAld_sw_annual5());
				SocialWorker5.setSumPosAnnual(root.getSummary_annual_SW5());
				SocialWorker5.setSumPosInhouse(root.getSummary_inHouse_SW5());
				SocialWorker5.setSumPosContracted(root.getSummary_contracted_SW5());
				
				LTCStaffPlanPosType SpeechPathologist5 = new LTCStaffPlanPosType();
				SpeechPathologist5.setConfirmationId(root.getForm().getConfirmationId());
				SpeechPathologist5.setStaffingPlanNum("5");
				SpeechPathologist5.setStaffHrsPosType(root.getAld_sp_label1());
				SpeechPathologist5.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				SpeechPathologist5.setSumStaffHrsMon(root.getAld_sp_mon5());
				SpeechPathologist5.setSumStaffHrsTue(root.getAld_sp_tue5());
				SpeechPathologist5.setSumStaffHrsWed(root.getAld_sp_wed5());
				SpeechPathologist5.setSumStaffHrsThurs(root.getAld_sp_thu5());
				SpeechPathologist5.setSumStaffHrsFri(root.getAld_sp_fri5());
				SpeechPathologist5.setSumStaffHrsSat(root.getAld_sp_sat5());
				SpeechPathologist5.setSumStaffHrsSun(root.getAld_sp_sun5());
				SpeechPathologist5.setSumStaffHrsWkTotal(root.getAld_sp_total5());
				SpeechPathologist5.setSumStaffHrsAnnual(root.getAld_sp_annual5());
				SpeechPathologist5.setSumPosAnnual(root.getSummary_annual_SL5());
				SpeechPathologist5.setSumPosInhouse(root.getSummary_inHouse_SL5());
				SpeechPathologist5.setSumPosContracted(root.getSummary_contracted_SL5());
				
				LTCStaffPlanPosType RespTherapist5 = new LTCStaffPlanPosType();
				RespTherapist5.setConfirmationId(root.getForm().getConfirmationId());
				RespTherapist5.setStaffingPlanNum("5");
				RespTherapist5.setStaffHrsPosType(root.getAld_rt_label1());
				RespTherapist5.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				RespTherapist5.setSumStaffHrsMon(root.getAld_rt_mon5());
				RespTherapist5.setSumStaffHrsTue(root.getAld_rt_tue5());
				RespTherapist5.setSumStaffHrsWed(root.getAld_rt_wed5());
				RespTherapist5.setSumStaffHrsThurs(root.getAld_rt_thu5());
				RespTherapist5.setSumStaffHrsFri(root.getAld_rt_fri5());
				RespTherapist5.setSumStaffHrsSat(root.getAld_rt_sat5());
				RespTherapist5.setSumStaffHrsSun(root.getAld_rt_sun5());
				RespTherapist5.setSumStaffHrsWkTotal(root.getAld_rt_total5());
				RespTherapist5.setSumStaffHrsAnnual(root.getAld_rt_annual5());
				RespTherapist5.setSumPosAnnual(root.getSummary_annual_resp5());
				RespTherapist5.setSumPosInhouse(root.getSummary_inHouse_resp5());
				RespTherapist5.setSumPosContracted(root.getSummary_contracted_resp5());
				
				LTCStaffPlanPosType RecTherapist5 = new LTCStaffPlanPosType();
				RecTherapist5.setConfirmationId(root.getForm().getConfirmationId());
				RecTherapist5.setStaffingPlanNum("5");
				RecTherapist5.setStaffHrsPosType(root.getAldnop_rt_label1());
				RecTherapist5.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				RecTherapist5.setSumStaffHrsMon(root.getAldnop_rt_mon5());
				RecTherapist5.setSumStaffHrsTue(root.getAldnop_rt_tue5());
				RecTherapist5.setSumStaffHrsWed(root.getAldnop_rt_wed5());
				RecTherapist5.setSumStaffHrsThurs(root.getAldnop_rt_thu5());
				RecTherapist5.setSumStaffHrsFri(root.getAldnop_rt_fri5());
				RecTherapist5.setSumStaffHrsSat(root.getAldnop_rt_sat5());
				RecTherapist5.setSumStaffHrsSun(root.getAldnop_rt_sun5());
				RecTherapist5.setSumStaffHrsWkTotal(root.getAldnop_rt_total5());
				RecTherapist5.setSumStaffHrsAnnual(root.getAldnop_rt_annual5());
				RecTherapist5.setSumPosAnnual(root.getSummary_annual_RT5());
				RecTherapist5.setSumPosInhouse(root.getSummary_inHouse_RT5());
				RecTherapist5.setSumPosContracted(root.getSummary_contracted_RT5());
				
				LTCStaffPlanPosType RehabAssistant5 = new LTCStaffPlanPosType();
				RehabAssistant5.setConfirmationId(root.getForm().getConfirmationId());
				RehabAssistant5.setStaffingPlanNum("5");
				RehabAssistant5.setStaffHrsPosType(root.getAldnop_ra_label1());
				RehabAssistant5.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				RehabAssistant5.setSumStaffHrsMon(root.getAldnop_ra_mon5());
				RehabAssistant5.setSumStaffHrsTue(root.getAldnop_ra_tue5());
				RehabAssistant5.setSumStaffHrsWed(root.getAldnop_ra_wed5());
				RehabAssistant5.setSumStaffHrsThurs(root.getAldnop_ra_thu5());
				RehabAssistant5.setSumStaffHrsFri(root.getAldnop_ra_fri5());
				RehabAssistant5.setSumStaffHrsSat(root.getAldnop_ra_sat5());
				RehabAssistant5.setSumStaffHrsSun(root.getAldnop_ra_sun5());
				RehabAssistant5.setSumStaffHrsWkTotal(root.getAldnop_ra_total5());
				RehabAssistant5.setSumStaffHrsAnnual(root.getAldnop_ra_annual5());
				RehabAssistant5.setSumPosAnnual(root.getSummary_annual_RA5());
				RehabAssistant5.setSumPosInhouse(root.getSummary_inHouse_RA5());
				RehabAssistant5.setSumPosContracted(root.getSummary_contracted_RA5());
				
				LTCStaffPlanPosType ActivityWorker5 = new LTCStaffPlanPosType();
				ActivityWorker5.setConfirmationId(root.getForm().getConfirmationId());
				ActivityWorker5.setStaffingPlanNum("5");
				ActivityWorker5.setStaffHrsPosType(root.getAldnop_aw_label1());
				ActivityWorker5.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				ActivityWorker5.setSumStaffHrsMon(root.getAldnop_aw_mon5());
				ActivityWorker5.setSumStaffHrsTue(root.getAldnop_aw_tue5());
				ActivityWorker5.setSumStaffHrsWed(root.getAldnop_aw_wed5());
				ActivityWorker5.setSumStaffHrsThurs(root.getAldnop_aw_thu5());
				ActivityWorker5.setSumStaffHrsFri(root.getAldnop_aw_fri5());
				ActivityWorker5.setSumStaffHrsSat(root.getAldnop_aw_sat5());
				ActivityWorker5.setSumStaffHrsSun(root.getAldnop_aw_sun5());
				ActivityWorker5.setSumStaffHrsWkTotal(root.getAldnop_aw_total5());
				ActivityWorker5.setSumStaffHrsAnnual(root.getAldnop_aw_annual5());
				ActivityWorker5.setSumPosAnnual(root.getSummary_annual_AW5());
				ActivityWorker5.setSumPosInhouse(root.getSummary_inHouse_AW5());
				ActivityWorker5.setSumPosContracted(root.getSummary_contracted_AW5());
				
				LTCStaffPlanPosType MusicTherapist5 = new LTCStaffPlanPosType();
				MusicTherapist5.setConfirmationId(root.getForm().getConfirmationId());
				MusicTherapist5.setStaffingPlanNum("5");
				MusicTherapist5.setStaffHrsPosType(root.getAldnop_mt_label1());
				MusicTherapist5.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				MusicTherapist5.setSumStaffHrsMon(root.getAldnop_mt_mon5());
				MusicTherapist5.setSumStaffHrsTue(root.getAldnop_mt_tue5());
				MusicTherapist5.setSumStaffHrsWed(root.getAldnop_mt_wed5());
				MusicTherapist5.setSumStaffHrsThurs(root.getAldnop_mt_thu5());
				MusicTherapist5.setSumStaffHrsFri(root.getAldnop_mt_fri5());
				MusicTherapist5.setSumStaffHrsSat(root.getAldnop_mt_sat5());
				MusicTherapist5.setSumStaffHrsSun(root.getAldnop_mt_sun5());
				MusicTherapist5.setSumStaffHrsWkTotal(root.getAldnop_mt_total5());
				MusicTherapist5.setSumStaffHrsAnnual(root.getAldnop_mt_annual5());
				MusicTherapist5.setSumPosAnnual(root.getSummary_annual_MT5());
				MusicTherapist5.setSumPosInhouse(root.getSummary_inHouse_MT5());
				MusicTherapist5.setSumPosContracted(root.getSummary_contracted_MT5());
	
				LTCStaffPlanPosType ArtTherapist5 = new LTCStaffPlanPosType();
				ArtTherapist5.setConfirmationId(root.getForm().getConfirmationId());
				ArtTherapist5.setStaffingPlanNum("5");
				ArtTherapist5.setStaffHrsPosType(root.getAldnop_at_label1());
				ArtTherapist5.setStaffHrsPosOtherName(Constants.DEFAULT_NA_VALUE);
				ArtTherapist5.setSumStaffHrsMon(root.getAldnop_at_mon5());
				ArtTherapist5.setSumStaffHrsTue(root.getAldnop_at_tue5());
				ArtTherapist5.setSumStaffHrsWed(root.getAldnop_at_wed5());
				ArtTherapist5.setSumStaffHrsThurs(root.getAldnop_at_thu5());
				ArtTherapist5.setSumStaffHrsFri(root.getAldnop_at_fri5());
				ArtTherapist5.setSumStaffHrsSat(root.getAldnop_at_sat5());
				ArtTherapist5.setSumStaffHrsSun(root.getAldnop_at_sun5());
				ArtTherapist5.setSumStaffHrsWkTotal(root.getAldnop_at_total5());
				ArtTherapist5.setSumStaffHrsAnnual(root.getAldnop_at_annual5());
				ArtTherapist5.setSumPosAnnual(root.getSummary_annual_AT5());
				ArtTherapist5.setSumPosInhouse(root.getSummary_inHouse_AT5());
				ArtTherapist5.setSumPosContracted(root.getSummary_contracted_AT5());
	
				Collections.addAll(LTCStaffPlanPosType, NurseRN5, NurseLPN5, NpNurseHCA5, OccTherapist5, Physiotherapist5, Dietitian5, SocialWorker5,
					SpeechPathologist5, RespTherapist5, RecTherapist5, RehabAssistant5, ActivityWorker5, MusicTherapist5,
					ArtTherapist5);
	
				if(root.getNpDatagrid5() != null){
					int indexnp5 = 0;
					for(NpDatagrid otherProfessionalNurse : root.getNpDatagrid5()){
						LTCStaffPlanPosType otherNurse = new LTCStaffPlanPosType();
						otherNurse.setConfirmationId(root.getForm().getConfirmationId());
						otherNurse.setStaffingPlanNum("5");
						otherNurse.setStaffHrsPosType(Constants.DEFAULT_OTHER_PROF_NURSE_VALUE);
						otherNurse.setStaffHrsPosOtherName(otherProfessionalNurse.getNpPositionType() + ++indexnp5);
						otherNurse.setSumStaffHrsMon(otherProfessionalNurse.getNp_other_mon());
						otherNurse.setSumStaffHrsTue(otherProfessionalNurse.getNp_other_tue());
						otherNurse.setSumStaffHrsWed(otherProfessionalNurse.getNp_other_wed());
						otherNurse.setSumStaffHrsThurs(otherProfessionalNurse.getNp_other_thu());
						otherNurse.setSumStaffHrsFri(otherProfessionalNurse.getNp_other_fri());
						otherNurse.setSumStaffHrsSat(otherProfessionalNurse.getNp_other_sat());
						otherNurse.setSumStaffHrsSun(otherProfessionalNurse.getNp_other_sun());
						otherNurse.setSumStaffHrsWkTotal(otherProfessionalNurse.getNp_other_total());
						otherNurse.setSumStaffHrsAnnual(otherProfessionalNurse.getNp_other_annual());
						otherNurse.setSumPosAnnual(root.getSummary_annual_otherNursingP5());
						otherNurse.setSumPosInhouse(root.getSummary_inHouse_otherNursingP5());
						otherNurse.setSumPosContracted(root.getSummary_contracted_otherNursingP5());
			
						LTCStaffPlanPosType.add(otherNurse);
						
					}
				}
	
				if(root.getNnpDatagrid5() != null){
					int indexnnp5 = 0;
					for(NnpDatagrid otherNonProfessionalNurse : root.getNnpDatagrid5()){
						LTCStaffPlanPosType otherNPNurse = new LTCStaffPlanPosType();
						otherNPNurse.setConfirmationId(root.getForm().getConfirmationId());
						otherNPNurse.setStaffingPlanNum("5");
						otherNPNurse.setStaffHrsPosType(Constants.DEFAULT_OTHER_NONPROF_NURSE_VALUE);
						otherNPNurse.setStaffHrsPosOtherName(otherNonProfessionalNurse.getNnpPositionType() + ++indexnnp5);
						otherNPNurse.setSumStaffHrsMon(otherNonProfessionalNurse.getNnp_other_mon());
						otherNPNurse.setSumStaffHrsTue(otherNonProfessionalNurse.getNnp_other_tue());
						otherNPNurse.setSumStaffHrsWed(otherNonProfessionalNurse.getNnp_other_wed());
						otherNPNurse.setSumStaffHrsThurs(otherNonProfessionalNurse.getNnp_other_thu());
						otherNPNurse.setSumStaffHrsFri(otherNonProfessionalNurse.getNnp_other_fri());
						otherNPNurse.setSumStaffHrsSat(otherNonProfessionalNurse.getNnp_other_sat());
						otherNPNurse.setSumStaffHrsSun(otherNonProfessionalNurse.getNnp_other_sun());
						otherNPNurse.setSumStaffHrsWkTotal(otherNonProfessionalNurse.getNnp_other_total());
						otherNPNurse.setSumStaffHrsAnnual(otherNonProfessionalNurse.getNnp_other_annual());
						otherNPNurse.setSumPosAnnual(root.getSummary_annual_otherNursingNP5());
						otherNPNurse.setSumPosInhouse(root.getSummary_inHouse_otherNursingNP5());
						otherNPNurse.setSumPosContracted(root.getSummary_contracted_otherNursingNP5());
		
						LTCStaffPlanPosType.add(otherNPNurse);
					}
				}
	
				if(root.getAldDatagrid5() != null){
					int indexald5 = 0;
					for(AldDatagrid otherProfessionalAllied : root.getAldDatagrid5()){
						LTCStaffPlanPosType otherProfAllied = new LTCStaffPlanPosType();
						otherProfAllied.setConfirmationId(root.getForm().getConfirmationId());
						otherProfAllied.setStaffingPlanNum("5");
						otherProfAllied.setStaffHrsPosType(Constants.DEFAULT_OTHER_PROF_ALLIED_VALUE);
						otherProfAllied.setStaffHrsPosOtherName(otherProfessionalAllied.getAldPositionType() + ++indexald5);
						otherProfAllied.setSumStaffHrsMon(otherProfessionalAllied.getAld_other_mon());
						otherProfAllied.setSumStaffHrsTue(otherProfessionalAllied.getAld_other_tue());
						otherProfAllied.setSumStaffHrsWed(otherProfessionalAllied.getAld_other_wed());
						otherProfAllied.setSumStaffHrsThurs(otherProfessionalAllied.getAld_other_thu());
						otherProfAllied.setSumStaffHrsFri(otherProfessionalAllied.getAld_other_fri());
						otherProfAllied.setSumStaffHrsSat(otherProfessionalAllied.getAld_other_sat());
						otherProfAllied.setSumStaffHrsSun(otherProfessionalAllied.getAld_other_sun());
						otherProfAllied.setSumStaffHrsWkTotal(otherProfessionalAllied.getAld_other_total());
						otherProfAllied.setSumStaffHrsAnnual(otherProfessionalAllied.getAld_other_annual());
						otherProfAllied.setSumPosAnnual(root.getSummary_annual_otherAlliedProf5());
						otherProfAllied.setSumPosInhouse(root.getSummary_inHouse_otherAlliedProf5());
						otherProfAllied.setSumPosContracted(root.getSummary_contracted_otherAlliedProf5());
		
						LTCStaffPlanPosType.add(otherProfAllied);
					}
				}
	
				if(root.getAldnopDatagrid5() != null){
					int indexaldnop5 = 0;
					for(AldNopDatagrid otherNonProfessionalAllied : root.getAldnopDatagrid5()){
						LTCStaffPlanPosType otherNonProfAllied = new LTCStaffPlanPosType();
						otherNonProfAllied.setConfirmationId(root.getForm().getConfirmationId());
						otherNonProfAllied.setStaffingPlanNum("5");
						otherNonProfAllied.setStaffHrsPosType(Constants.DEFAULT_OTHER_NONPROF_ALLIED_VALUE);
						otherNonProfAllied.setStaffHrsPosOtherName(otherNonProfessionalAllied.getAldnopPositionType() + ++indexaldnop5);
						otherNonProfAllied.setSumStaffHrsMon(otherNonProfessionalAllied.getAldnop_other_mon());
						otherNonProfAllied.setSumStaffHrsTue(otherNonProfessionalAllied.getAldnop_other_tue());
						otherNonProfAllied.setSumStaffHrsWed(otherNonProfessionalAllied.getAldnop_other_wed());
						otherNonProfAllied.setSumStaffHrsThurs(otherNonProfessionalAllied.getAldnop_other_thu());
						otherNonProfAllied.setSumStaffHrsFri(otherNonProfessionalAllied.getAldnop_other_fri());
						otherNonProfAllied.setSumStaffHrsSat(otherNonProfessionalAllied.getAldnop_other_sat());
						otherNonProfAllied.setSumStaffHrsSun(otherNonProfessionalAllied.getAldnop_other_sun());
						otherNonProfAllied.setSumStaffHrsWkTotal(otherNonProfessionalAllied.getAldnop_other_total());
						otherNonProfAllied.setSumStaffHrsAnnual(otherNonProfessionalAllied.getAldnop_other_annual());
						otherNonProfAllied.setSumPosAnnual(root.getSummary_annual_otherAlliedNProf5());
						otherNonProfAllied.setSumPosInhouse(root.getSummary_inHouse_otherAlliedNProf5());
						otherNonProfAllied.setSumPosContracted(root.getSummary_contracted_otherAlliedNProf5());
		
						LTCStaffPlanPosType.add(otherNonProfAllied);
					}
				}
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

			/* mapping LTC_STAFFING_HRS */
			LTCStaffingHrs rnDayShift1 = new LTCStaffingHrs();
			rnDayShift1.setConfirmationId(root.getForm().getConfirmationId());
			rnDayShift1.setStaffingPlanNum("1");
			rnDayShift1.setStaffHrsPosType(root.getRn_label1());
			rnDayShift1.setStaffHrsPosShiftType(root.getRn_day_label());
			rnDayShift1.setStaffHrsMon(root.getRn_day_mon1());
			rnDayShift1.setStaffHrsTue(root.getRn_day_tue1());
			rnDayShift1.setStaffHrsWed(root.getRn_day_wed1());
			rnDayShift1.setStaffHrsThurs(root.getRn_day_thu1());
			rnDayShift1.setStaffHrsFri(root.getRn_day_fri1());
			rnDayShift1.setStaffHrsSat(root.getRn_day_sat1());
			rnDayShift1.setStaffHrsSun(root.getRn_day_sun1());
			rnDayShift1.setStaffHrsWkTotal(root.getRn_day_total1());
			rnDayShift1.setStaffHrsAnnual(root.getRn_day_annual1());

			LTCStaffingHrs rnEveningShift1 = new LTCStaffingHrs();
			rnEveningShift1.setConfirmationId(root.getForm().getConfirmationId());
			rnEveningShift1.setStaffingPlanNum("1");
			rnEveningShift1.setStaffHrsPosType(root.getRn_label1());
			rnEveningShift1.setStaffHrsPosShiftType(root.getRn_eve_label());
			rnEveningShift1.setStaffHrsMon(root.getRn_eve_mon1());
			rnEveningShift1.setStaffHrsTue(root.getRn_eve_tue1());
			rnEveningShift1.setStaffHrsWed(root.getRn_eve_wed1());
			rnEveningShift1.setStaffHrsThurs(root.getRn_eve_thu1());
			rnEveningShift1.setStaffHrsFri(root.getRn_eve_fri1());
			rnEveningShift1.setStaffHrsSat(root.getRn_eve_sat1());
			rnEveningShift1.setStaffHrsSun(root.getRn_eve_sun1());
			rnEveningShift1.setStaffHrsWkTotal(root.getRn_eve_total1());
			rnEveningShift1.setStaffHrsAnnual(root.getRn_eve_annual1());

			LTCStaffingHrs rnNightShift1 = new LTCStaffingHrs();
			rnNightShift1.setConfirmationId(root.getForm().getConfirmationId());
			rnNightShift1.setStaffingPlanNum("1");
			rnNightShift1.setStaffHrsPosType(root.getRn_label1());
			rnNightShift1.setStaffHrsPosShiftType(root.getRn_night_label());
			rnNightShift1.setStaffHrsMon(root.getRn_night_mon1());
			rnNightShift1.setStaffHrsTue(root.getRn_night_tue1());
			rnNightShift1.setStaffHrsWed(root.getRn_night_wed1());
			rnNightShift1.setStaffHrsThurs(root.getRn_night_thu1());
			rnNightShift1.setStaffHrsFri(root.getRn_night_fri1());
			rnNightShift1.setStaffHrsSat(root.getRn_night_sat1());
			rnNightShift1.setStaffHrsSun(root.getRn_night_sun1());
			rnNightShift1.setStaffHrsWkTotal(root.getRn_night_total1());
			rnNightShift1.setStaffHrsAnnual(root.getRn_night_annual1());

			LTCStaffingHrs lpnDayShift1 = new LTCStaffingHrs();
			lpnDayShift1.setConfirmationId(root.getForm().getConfirmationId());
			lpnDayShift1.setStaffingPlanNum("1");
			lpnDayShift1.setStaffHrsPosType(root.getLpn_label1());
			lpnDayShift1.setStaffHrsPosShiftType("Days");
			lpnDayShift1.setStaffHrsMon(root.getLpn_day_mon1());
			lpnDayShift1.setStaffHrsTue(root.getLpn_day_tue1());
			lpnDayShift1.setStaffHrsWed(root.getLpn_day_wed1());
			lpnDayShift1.setStaffHrsThurs(root.getLpn_day_thu1());
			lpnDayShift1.setStaffHrsFri(root.getLpn_day_fri1());
			lpnDayShift1.setStaffHrsSat(root.getLpn_day_sat1());
			lpnDayShift1.setStaffHrsSun(root.getLpn_day_sun1());
			lpnDayShift1.setStaffHrsWkTotal(root.getLpn_day_total1());
			lpnDayShift1.setStaffHrsAnnual(root.getLpn_day_annual1());

			LTCStaffingHrs lpnEveningShift1 = new LTCStaffingHrs();
			lpnEveningShift1.setConfirmationId(root.getForm().getConfirmationId());
			lpnEveningShift1.setStaffingPlanNum("1");
			lpnEveningShift1.setStaffHrsPosType(root.getLpn_label1());
			lpnEveningShift1.setStaffHrsPosShiftType(root.getLpn_eve_label1());
			lpnEveningShift1.setStaffHrsMon(root.getLpn_eve_mon1());
			lpnEveningShift1.setStaffHrsTue(root.getLpn_eve_tue1());
			lpnEveningShift1.setStaffHrsWed(root.getLpn_eve_wed1());
			lpnEveningShift1.setStaffHrsThurs(root.getLpn_eve_thu1());
			lpnEveningShift1.setStaffHrsFri(root.getLpn_eve_fri1());
			lpnEveningShift1.setStaffHrsSat(root.getLpn_eve_sat1());
			lpnEveningShift1.setStaffHrsSun(root.getLpn_eve_sun1());
			lpnEveningShift1.setStaffHrsWkTotal(root.getLpn_eve_total1());
			lpnEveningShift1.setStaffHrsAnnual(root.getLpn_eve_annual1());

			LTCStaffingHrs lpnNightShift1 = new LTCStaffingHrs();
			lpnNightShift1.setConfirmationId(root.getForm().getConfirmationId());
			lpnNightShift1.setStaffingPlanNum("1");
			lpnNightShift1.setStaffHrsPosType(root.getLpn_label1());
			lpnNightShift1.setStaffHrsPosShiftType(root.getLpn_night_label1());
			lpnNightShift1.setStaffHrsMon(root.getLpn_night_mon1());
			lpnNightShift1.setStaffHrsTue(root.getLpn_night_tue1());
			lpnNightShift1.setStaffHrsWed(root.getLpn_night_wed1());
			lpnNightShift1.setStaffHrsThurs(root.getLpn_night_thu1());
			lpnNightShift1.setStaffHrsFri(root.getLpn_night_fri1());
			lpnNightShift1.setStaffHrsSat(root.getLpn_night_sat1());
			lpnNightShift1.setStaffHrsSun(root.getLpn_night_sun1());
			lpnNightShift1.setStaffHrsWkTotal(root.getLpn_night_total1());
			lpnNightShift1.setStaffHrsAnnual(root.getLpn_night_annual1());

			LTCStaffingHrs hcaDayShift1 = new LTCStaffingHrs();
			hcaDayShift1.setConfirmationId(root.getForm().getConfirmationId());
			hcaDayShift1.setStaffingPlanNum("1");
			hcaDayShift1.setStaffHrsPosType(root.getHca_label1());
			hcaDayShift1.setStaffHrsPosShiftType(root.getHca_day_label1());
			hcaDayShift1.setStaffHrsMon(root.getHca_day_mon1());
			hcaDayShift1.setStaffHrsTue(root.getHca_day_tue1());
			hcaDayShift1.setStaffHrsWed(root.getHca_day_wed1());
			hcaDayShift1.setStaffHrsThurs(root.getHca_day_thu1());
			hcaDayShift1.setStaffHrsFri(root.getHca_day_fri1());
			hcaDayShift1.setStaffHrsSat(root.getHca_day_sat1());
			hcaDayShift1.setStaffHrsSun(root.getHca_day_sun1());
			hcaDayShift1.setStaffHrsWkTotal(root.getHca_day_total1());
			hcaDayShift1.setStaffHrsAnnual(root.getHca_day_annual1());

			LTCStaffingHrs hcaEveningShift1 = new LTCStaffingHrs();
			hcaEveningShift1.setConfirmationId(root.getForm().getConfirmationId());
			hcaEveningShift1.setStaffingPlanNum("1");
			hcaEveningShift1.setStaffHrsPosType(root.getHca_label1());
			hcaEveningShift1.setStaffHrsPosShiftType(root.getHca_eve_label1());
			hcaEveningShift1.setStaffHrsMon(root.getHca_eve_mon1());
			hcaEveningShift1.setStaffHrsTue(root.getHca_eve_tue1());
			hcaEveningShift1.setStaffHrsWed(root.getHca_eve_wed1());
			hcaEveningShift1.setStaffHrsThurs(root.getHca_eve_thu1());
			hcaEveningShift1.setStaffHrsFri(root.getHca_eve_fri1());
			hcaEveningShift1.setStaffHrsSat(root.getHca_eve_sat1());
			hcaEveningShift1.setStaffHrsSun(root.getHca_eve_sun1());
			hcaEveningShift1.setStaffHrsWkTotal(root.getHca_eve_total1());
			hcaEveningShift1.setStaffHrsAnnual(root.getHca_eve_annual1());

			LTCStaffingHrs hcaNightShift1 = new LTCStaffingHrs();
			hcaNightShift1.setConfirmationId(root.getForm().getConfirmationId());
			hcaNightShift1.setStaffingPlanNum("1");
			hcaNightShift1.setStaffHrsPosType(root.getHca_label1());
			hcaNightShift1.setStaffHrsPosShiftType(root.getHca_night_label1());
			hcaNightShift1.setStaffHrsMon(root.getHca_night_mon1());
			hcaNightShift1.setStaffHrsTue(root.getHca_night_tue1());
			hcaNightShift1.setStaffHrsWed(root.getHca_night_wed1());
			hcaNightShift1.setStaffHrsThurs(root.getHca_night_thu1());
			hcaNightShift1.setStaffHrsFri(root.getHca_night_fri1());
			hcaNightShift1.setStaffHrsSat(root.getHca_night_sat1());
			hcaNightShift1.setStaffHrsSun(root.getHca_night_sun1());
			hcaNightShift1.setStaffHrsWkTotal(root.getHca_night_total1());
			hcaNightShift1.setStaffHrsAnnual(root.getHca_night_annual1());

			Collections.addAll(LTCStaffingHrs, rnDayShift1, rnEveningShift1, rnNightShift1, lpnDayShift1, 
			lpnEveningShift1, lpnNightShift1, hcaDayShift1, hcaEveningShift1, hcaNightShift1);

			if(root.getStaffingPlanType2() != null && !root.getStaffingPlanType2().isEmpty()){
				LTCStaffingHrs rnDayShift2 = new LTCStaffingHrs();
				rnDayShift2.setConfirmationId(root.getForm().getConfirmationId());
				rnDayShift2.setStaffingPlanNum("2");
				rnDayShift2.setStaffHrsPosType(root.getRn_label1());
				rnDayShift2.setStaffHrsPosShiftType(root.getRn_day_label());
				rnDayShift2.setStaffHrsMon(root.getRn_day_mon2());
				rnDayShift2.setStaffHrsTue(root.getRn_day_tue2());
				rnDayShift2.setStaffHrsWed(root.getRn_day_wed2());
				rnDayShift2.setStaffHrsThurs(root.getRn_day_thu2());
				rnDayShift2.setStaffHrsFri(root.getRn_day_fri2());
				rnDayShift2.setStaffHrsSat(root.getRn_day_sat2());
				rnDayShift2.setStaffHrsSun(root.getRn_day_sun2());
				rnDayShift2.setStaffHrsWkTotal(root.getRn_day_total2());
				rnDayShift2.setStaffHrsAnnual(root.getRn_day_annual2());
	
				LTCStaffingHrs rnEveningShift2 = new LTCStaffingHrs();
				rnEveningShift2.setConfirmationId(root.getForm().getConfirmationId());
				rnEveningShift2.setStaffingPlanNum("2");
				rnEveningShift2.setStaffHrsPosType(root.getRn_label1());
				rnEveningShift2.setStaffHrsPosShiftType(root.getRn_eve_label());
				rnEveningShift2.setStaffHrsMon(root.getRn_eve_mon2());
				rnEveningShift2.setStaffHrsTue(root.getRn_eve_tue2());
				rnEveningShift2.setStaffHrsWed(root.getRn_eve_wed2());
				rnEveningShift2.setStaffHrsThurs(root.getRn_eve_thu2());
				rnEveningShift2.setStaffHrsFri(root.getRn_eve_fri2());
				rnEveningShift2.setStaffHrsSat(root.getRn_eve_sat2());
				rnEveningShift2.setStaffHrsSun(root.getRn_eve_sun2());
				rnEveningShift2.setStaffHrsWkTotal(root.getRn_eve_total2());
				rnEveningShift2.setStaffHrsAnnual(root.getRn_eve_annual2());
	
				LTCStaffingHrs rnNightShift2 = new LTCStaffingHrs();
				rnNightShift2.setConfirmationId(root.getForm().getConfirmationId());
				rnNightShift2.setStaffingPlanNum("2");
				rnNightShift2.setStaffHrsPosType(root.getRn_label1());
				rnNightShift2.setStaffHrsPosShiftType(root.getRn_night_label());
				rnNightShift2.setStaffHrsMon(root.getRn_night_mon2());
				rnNightShift2.setStaffHrsTue(root.getRn_night_tue2());
				rnNightShift2.setStaffHrsWed(root.getRn_night_wed2());
				rnNightShift2.setStaffHrsThurs(root.getRn_night_thu2());
				rnNightShift2.setStaffHrsFri(root.getRn_night_fri2());
				rnNightShift2.setStaffHrsSat(root.getRn_night_sat2());
				rnNightShift2.setStaffHrsSun(root.getRn_night_sun2());
				rnNightShift2.setStaffHrsWkTotal(root.getRn_night_total2());
				rnNightShift2.setStaffHrsAnnual(root.getRn_night_annual2());
	
				LTCStaffingHrs lpnDayShift2 = new LTCStaffingHrs();
				lpnDayShift2.setConfirmationId(root.getForm().getConfirmationId());
				lpnDayShift2.setStaffingPlanNum("2");
				lpnDayShift2.setStaffHrsPosType(root.getLpn_label1());
				lpnDayShift2.setStaffHrsPosShiftType("Days");
				lpnDayShift2.setStaffHrsMon(root.getLpn_day_mon2());
				lpnDayShift2.setStaffHrsTue(root.getLpn_day_tue2());
				lpnDayShift2.setStaffHrsWed(root.getLpn_day_wed2());
				lpnDayShift2.setStaffHrsThurs(root.getLpn_day_thu2());
				lpnDayShift2.setStaffHrsFri(root.getLpn_day_fri2());
				lpnDayShift2.setStaffHrsSat(root.getLpn_day_sat2());
				lpnDayShift2.setStaffHrsSun(root.getLpn_day_sun2());
				lpnDayShift2.setStaffHrsWkTotal(root.getLpn_day_total2());
				lpnDayShift2.setStaffHrsAnnual(root.getLpn_day_annual2());
	
				LTCStaffingHrs lpnEveningShift2 = new LTCStaffingHrs();
				lpnEveningShift2.setConfirmationId(root.getForm().getConfirmationId());
				lpnEveningShift2.setStaffingPlanNum("2");
				lpnEveningShift2.setStaffHrsPosType(root.getLpn_label1());
				lpnEveningShift2.setStaffHrsPosShiftType(root.getLpn_eve_label1());
				lpnEveningShift2.setStaffHrsMon(root.getLpn_eve_mon2());
				lpnEveningShift2.setStaffHrsTue(root.getLpn_eve_tue2());
				lpnEveningShift2.setStaffHrsWed(root.getLpn_eve_wed2());
				lpnEveningShift2.setStaffHrsThurs(root.getLpn_eve_thu2());
				lpnEveningShift2.setStaffHrsFri(root.getLpn_eve_fri2());
				lpnEveningShift2.setStaffHrsSat(root.getLpn_eve_sat2());
				lpnEveningShift2.setStaffHrsSun(root.getLpn_eve_sun2());
				lpnEveningShift2.setStaffHrsWkTotal(root.getLpn_eve_total2());
				lpnEveningShift2.setStaffHrsAnnual(root.getLpn_eve_annual2());
	
				LTCStaffingHrs lpnNightShift2 = new LTCStaffingHrs();
				lpnNightShift2.setConfirmationId(root.getForm().getConfirmationId());
				lpnNightShift2.setStaffingPlanNum("2");
				lpnNightShift2.setStaffHrsPosType(root.getLpn_label1());
				lpnNightShift2.setStaffHrsPosShiftType(root.getLpn_night_label1());
				lpnNightShift2.setStaffHrsMon(root.getLpn_night_mon2());
				lpnNightShift2.setStaffHrsTue(root.getLpn_night_tue2());
				lpnNightShift2.setStaffHrsWed(root.getLpn_night_wed2());
				lpnNightShift2.setStaffHrsThurs(root.getLpn_night_thu2());
				lpnNightShift2.setStaffHrsFri(root.getLpn_night_fri2());
				lpnNightShift2.setStaffHrsSat(root.getLpn_night_sat2());
				lpnNightShift2.setStaffHrsSun(root.getLpn_night_sun2());
				lpnNightShift2.setStaffHrsWkTotal(root.getLpn_night_total2());
				lpnNightShift2.setStaffHrsAnnual(root.getLpn_night_annual2());
	
				LTCStaffingHrs hcaDayShift2 = new LTCStaffingHrs();
				hcaDayShift2.setConfirmationId(root.getForm().getConfirmationId());
				hcaDayShift2.setStaffingPlanNum("2");
				hcaDayShift2.setStaffHrsPosType(root.getHca_label1());
				hcaDayShift2.setStaffHrsPosShiftType(root.getHca_day_label1());
				hcaDayShift2.setStaffHrsMon(root.getHca_day_mon2());
				hcaDayShift2.setStaffHrsTue(root.getHca_day_tue2());
				hcaDayShift2.setStaffHrsWed(root.getHca_day_wed2());
				hcaDayShift2.setStaffHrsThurs(root.getHca_day_thu2());
				hcaDayShift2.setStaffHrsFri(root.getHca_day_fri2());
				hcaDayShift2.setStaffHrsSat(root.getHca_day_sat2());
				hcaDayShift2.setStaffHrsSun(root.getHca_day_sun2());
				hcaDayShift2.setStaffHrsWkTotal(root.getHca_day_total2());
				hcaDayShift2.setStaffHrsAnnual(root.getHca_day_annual2());
	
				LTCStaffingHrs hcaEveningShift2 = new LTCStaffingHrs();
				hcaEveningShift2.setConfirmationId(root.getForm().getConfirmationId());
				hcaEveningShift2.setStaffingPlanNum("2");
				hcaEveningShift2.setStaffHrsPosType(root.getHca_label1());
				hcaEveningShift2.setStaffHrsPosShiftType(root.getHca_eve_label1());
				hcaEveningShift2.setStaffHrsMon(root.getHca_eve_mon2());
				hcaEveningShift2.setStaffHrsTue(root.getHca_eve_tue2());
				hcaEveningShift2.setStaffHrsWed(root.getHca_eve_wed2());
				hcaEveningShift2.setStaffHrsThurs(root.getHca_eve_thu2());
				hcaEveningShift2.setStaffHrsFri(root.getHca_eve_fri2());
				hcaEveningShift2.setStaffHrsSat(root.getHca_eve_sat2());
				hcaEveningShift2.setStaffHrsSun(root.getHca_eve_sun2());
				hcaEveningShift2.setStaffHrsWkTotal(root.getHca_eve_total2());
				hcaEveningShift2.setStaffHrsAnnual(root.getHca_eve_annual2());
	
				LTCStaffingHrs hcaNightShift2 = new LTCStaffingHrs();
				hcaNightShift2.setConfirmationId(root.getForm().getConfirmationId());
				hcaNightShift2.setStaffingPlanNum("2");
				hcaNightShift2.setStaffHrsPosType(root.getHca_label1());
				hcaNightShift2.setStaffHrsPosShiftType(root.getHca_night_label1());
				hcaNightShift2.setStaffHrsMon(root.getHca_night_mon2());
				hcaNightShift2.setStaffHrsTue(root.getHca_night_tue2());
				hcaNightShift2.setStaffHrsWed(root.getHca_night_wed2());
				hcaNightShift2.setStaffHrsThurs(root.getHca_night_thu2());
				hcaNightShift2.setStaffHrsFri(root.getHca_night_fri2());
				hcaNightShift2.setStaffHrsSat(root.getHca_night_sat2());
				hcaNightShift2.setStaffHrsSun(root.getHca_night_sun2());
				hcaNightShift2.setStaffHrsWkTotal(root.getHca_night_total2());
				hcaNightShift2.setStaffHrsAnnual(root.getHca_night_annual2());
	
				Collections.addAll(LTCStaffingHrs, rnDayShift2, rnEveningShift2, rnNightShift2, lpnDayShift2, 
				lpnEveningShift2, lpnNightShift2, hcaDayShift2, hcaEveningShift2, hcaNightShift2);
			}
			
			if(root.getStaffingPlanType3() != null && !root.getStaffingPlanType3().isEmpty()){
				LTCStaffingHrs rnDayShift3 = new LTCStaffingHrs();
				rnDayShift3.setConfirmationId(root.getForm().getConfirmationId());
				rnDayShift3.setStaffingPlanNum("3");
				rnDayShift3.setStaffHrsPosType(root.getRn_label1());
				rnDayShift3.setStaffHrsPosShiftType(root.getRn_day_label());
				rnDayShift3.setStaffHrsMon(root.getRn_day_mon3());
				rnDayShift3.setStaffHrsTue(root.getRn_day_tue3());
				rnDayShift3.setStaffHrsWed(root.getRn_day_wed3());
				rnDayShift3.setStaffHrsThurs(root.getRn_day_thu3());
				rnDayShift3.setStaffHrsFri(root.getRn_day_fri3());
				rnDayShift3.setStaffHrsSat(root.getRn_day_sat3());
				rnDayShift3.setStaffHrsSun(root.getRn_day_sun3());
				rnDayShift3.setStaffHrsWkTotal(root.getRn_day_total3());
				rnDayShift3.setStaffHrsAnnual(root.getRn_day_annual3());
	
				LTCStaffingHrs rnEveningShift3 = new LTCStaffingHrs();
				rnEveningShift3.setConfirmationId(root.getForm().getConfirmationId());
				rnEveningShift3.setStaffingPlanNum("3");
				rnEveningShift3.setStaffHrsPosType(root.getRn_label1());
				rnEveningShift3.setStaffHrsPosShiftType(root.getRn_eve_label());
				rnEveningShift3.setStaffHrsMon(root.getRn_eve_mon3());
				rnEveningShift3.setStaffHrsTue(root.getRn_eve_tue3());
				rnEveningShift3.setStaffHrsWed(root.getRn_eve_wed3());
				rnEveningShift3.setStaffHrsThurs(root.getRn_eve_thu3());
				rnEveningShift3.setStaffHrsFri(root.getRn_eve_fri3());
				rnEveningShift3.setStaffHrsSat(root.getRn_eve_sat3());
				rnEveningShift3.setStaffHrsSun(root.getRn_eve_sun3());
				rnEveningShift3.setStaffHrsWkTotal(root.getRn_eve_total3());
				rnEveningShift3.setStaffHrsAnnual(root.getRn_eve_annual3());
	
				LTCStaffingHrs rnNightShift3 = new LTCStaffingHrs();
				rnNightShift3.setConfirmationId(root.getForm().getConfirmationId());
				rnNightShift3.setStaffingPlanNum("3");
				rnNightShift3.setStaffHrsPosType(root.getRn_label1());
				rnNightShift3.setStaffHrsPosShiftType(root.getRn_night_label());
				rnNightShift3.setStaffHrsMon(root.getRn_night_mon3());
				rnNightShift3.setStaffHrsTue(root.getRn_night_tue3());
				rnNightShift3.setStaffHrsWed(root.getRn_night_wed3());
				rnNightShift3.setStaffHrsThurs(root.getRn_night_thu3());
				rnNightShift3.setStaffHrsFri(root.getRn_night_fri3());
				rnNightShift3.setStaffHrsSat(root.getRn_night_sat3());
				rnNightShift3.setStaffHrsSun(root.getRn_night_sun3());
				rnNightShift3.setStaffHrsWkTotal(root.getRn_night_total3());
				rnNightShift3.setStaffHrsAnnual(root.getRn_night_annual3());
	
				LTCStaffingHrs lpnDayShift3 = new LTCStaffingHrs();
				lpnDayShift3.setConfirmationId(root.getForm().getConfirmationId());
				lpnDayShift3.setStaffingPlanNum("3");
				lpnDayShift3.setStaffHrsPosType(root.getLpn_label1());
				lpnDayShift3.setStaffHrsPosShiftType("Days");
				lpnDayShift3.setStaffHrsMon(root.getLpn_day_mon3());
				lpnDayShift3.setStaffHrsTue(root.getLpn_day_tue3());
				lpnDayShift3.setStaffHrsWed(root.getLpn_day_wed3());
				lpnDayShift3.setStaffHrsThurs(root.getLpn_day_thu3());
				lpnDayShift3.setStaffHrsFri(root.getLpn_day_fri3());
				lpnDayShift3.setStaffHrsSat(root.getLpn_day_sat3());
				lpnDayShift3.setStaffHrsSun(root.getLpn_day_sun3());
				lpnDayShift3.setStaffHrsWkTotal(root.getLpn_day_total3());
				lpnDayShift3.setStaffHrsAnnual(root.getLpn_day_annual3());
	
				LTCStaffingHrs lpnEveningShift3 = new LTCStaffingHrs();
				lpnEveningShift3.setConfirmationId(root.getForm().getConfirmationId());
				lpnEveningShift3.setStaffingPlanNum("3");
				lpnEveningShift3.setStaffHrsPosType(root.getLpn_label1());
				lpnEveningShift3.setStaffHrsPosShiftType(root.getLpn_eve_label1());
				lpnEveningShift3.setStaffHrsMon(root.getLpn_eve_mon3());
				lpnEveningShift3.setStaffHrsTue(root.getLpn_eve_tue3());
				lpnEveningShift3.setStaffHrsWed(root.getLpn_eve_wed3());
				lpnEveningShift3.setStaffHrsThurs(root.getLpn_eve_thu3());
				lpnEveningShift3.setStaffHrsFri(root.getLpn_eve_fri3());
				lpnEveningShift3.setStaffHrsSat(root.getLpn_eve_sat3());
				lpnEveningShift3.setStaffHrsSun(root.getLpn_eve_sun3());
				lpnEveningShift3.setStaffHrsWkTotal(root.getLpn_eve_total3());
				lpnEveningShift3.setStaffHrsAnnual(root.getLpn_eve_annual3());
	
				LTCStaffingHrs lpnNightShift3 = new LTCStaffingHrs();
				lpnNightShift3.setConfirmationId(root.getForm().getConfirmationId());
				lpnNightShift3.setStaffingPlanNum("3");
				lpnNightShift3.setStaffHrsPosType(root.getLpn_label1());
				lpnNightShift3.setStaffHrsPosShiftType(root.getLpn_night_label1());
				lpnNightShift3.setStaffHrsMon(root.getLpn_night_mon3());
				lpnNightShift3.setStaffHrsTue(root.getLpn_night_tue3());
				lpnNightShift3.setStaffHrsWed(root.getLpn_night_wed3());
				lpnNightShift3.setStaffHrsThurs(root.getLpn_night_thu3());
				lpnNightShift3.setStaffHrsFri(root.getLpn_night_fri3());
				lpnNightShift3.setStaffHrsSat(root.getLpn_night_sat3());
				lpnNightShift3.setStaffHrsSun(root.getLpn_night_sun3());
				lpnNightShift3.setStaffHrsWkTotal(root.getLpn_night_total3());
				lpnNightShift3.setStaffHrsAnnual(root.getLpn_night_annual3());
	
				LTCStaffingHrs hcaDayShift3 = new LTCStaffingHrs();
				hcaDayShift3.setConfirmationId(root.getForm().getConfirmationId());
				hcaDayShift3.setStaffingPlanNum("3");
				hcaDayShift3.setStaffHrsPosType(root.getHca_label1());
				hcaDayShift3.setStaffHrsPosShiftType(root.getHca_day_label1());
				hcaDayShift3.setStaffHrsMon(root.getHca_day_mon3());
				hcaDayShift3.setStaffHrsTue(root.getHca_day_tue3());
				hcaDayShift3.setStaffHrsWed(root.getHca_day_wed3());
				hcaDayShift3.setStaffHrsThurs(root.getHca_day_thu3());
				hcaDayShift3.setStaffHrsFri(root.getHca_day_fri3());
				hcaDayShift3.setStaffHrsSat(root.getHca_day_sat3());
				hcaDayShift3.setStaffHrsSun(root.getHca_day_sun3());
				hcaDayShift3.setStaffHrsWkTotal(root.getHca_day_total3());
				hcaDayShift3.setStaffHrsAnnual(root.getHca_day_annual3());
	
				LTCStaffingHrs hcaEveningShift3 = new LTCStaffingHrs();
				hcaEveningShift3.setConfirmationId(root.getForm().getConfirmationId());
				hcaEveningShift3.setStaffingPlanNum("3");
				hcaEveningShift3.setStaffHrsPosType(root.getHca_label1());
				hcaEveningShift3.setStaffHrsPosShiftType(root.getHca_eve_label1());
				hcaEveningShift3.setStaffHrsMon(root.getHca_eve_mon3());
				hcaEveningShift3.setStaffHrsTue(root.getHca_eve_tue3());
				hcaEveningShift3.setStaffHrsWed(root.getHca_eve_wed3());
				hcaEveningShift3.setStaffHrsThurs(root.getHca_eve_thu3());
				hcaEveningShift3.setStaffHrsFri(root.getHca_eve_fri3());
				hcaEveningShift3.setStaffHrsSat(root.getHca_eve_sat3());
				hcaEveningShift3.setStaffHrsSun(root.getHca_eve_sun3());
				hcaEveningShift3.setStaffHrsWkTotal(root.getHca_eve_total3());
				hcaEveningShift3.setStaffHrsAnnual(root.getHca_eve_annual3());
	
				LTCStaffingHrs hcaNightShift3 = new LTCStaffingHrs();
				hcaNightShift3.setConfirmationId(root.getForm().getConfirmationId());
				hcaNightShift3.setStaffingPlanNum("3");
				hcaNightShift3.setStaffHrsPosType(root.getHca_label1());
				hcaNightShift3.setStaffHrsPosShiftType(root.getHca_night_label1());
				hcaNightShift3.setStaffHrsMon(root.getHca_night_mon3());
				hcaNightShift3.setStaffHrsTue(root.getHca_night_tue3());
				hcaNightShift3.setStaffHrsWed(root.getHca_night_wed3());
				hcaNightShift3.setStaffHrsThurs(root.getHca_night_thu3());
				hcaNightShift3.setStaffHrsFri(root.getHca_night_fri3());
				hcaNightShift3.setStaffHrsSat(root.getHca_night_sat3());
				hcaNightShift3.setStaffHrsSun(root.getHca_night_sun3());
				hcaNightShift3.setStaffHrsWkTotal(root.getHca_night_total3());
				hcaNightShift3.setStaffHrsAnnual(root.getHca_night_annual3());
	
				Collections.addAll(LTCStaffingHrs, rnDayShift3, rnEveningShift3, rnNightShift3, lpnDayShift3, 
				lpnEveningShift3, lpnNightShift3, hcaDayShift3, hcaEveningShift3, hcaNightShift3);
			}

			if(root.getStaffingPlanType4() != null && !root.getStaffingPlanType4().isEmpty()){
				LTCStaffingHrs rnDayShift4 = new LTCStaffingHrs();
				rnDayShift4.setConfirmationId(root.getForm().getConfirmationId());
				rnDayShift4.setStaffingPlanNum("4");
				rnDayShift4.setStaffHrsPosType(root.getRn_label1());
				rnDayShift4.setStaffHrsPosShiftType(root.getRn_day_label());
				rnDayShift4.setStaffHrsMon(root.getRn_day_mon4());
				rnDayShift4.setStaffHrsTue(root.getRn_day_tue4());
				rnDayShift4.setStaffHrsWed(root.getRn_day_wed4());
				rnDayShift4.setStaffHrsThurs(root.getRn_day_thu4());
				rnDayShift4.setStaffHrsFri(root.getRn_day_fri4());
				rnDayShift4.setStaffHrsSat(root.getRn_day_sat4());
				rnDayShift4.setStaffHrsSun(root.getRn_day_sun4());
				rnDayShift4.setStaffHrsWkTotal(root.getRn_day_total4());
				rnDayShift4.setStaffHrsAnnual(root.getRn_day_annual4());
	
				LTCStaffingHrs rnEveningShift4 = new LTCStaffingHrs();
				rnEveningShift4.setConfirmationId(root.getForm().getConfirmationId());
				rnEveningShift4.setStaffingPlanNum("4");
				rnEveningShift4.setStaffHrsPosType(root.getRn_label1());
				rnEveningShift4.setStaffHrsPosShiftType(root.getRn_eve_label());
				rnEveningShift4.setStaffHrsMon(root.getRn_eve_mon4());
				rnEveningShift4.setStaffHrsTue(root.getRn_eve_tue4());
				rnEveningShift4.setStaffHrsWed(root.getRn_eve_wed4());
				rnEveningShift4.setStaffHrsThurs(root.getRn_eve_thu4());
				rnEveningShift4.setStaffHrsFri(root.getRn_eve_fri4());
				rnEveningShift4.setStaffHrsSat(root.getRn_eve_sat4());
				rnEveningShift4.setStaffHrsSun(root.getRn_eve_sun4());
				rnEveningShift4.setStaffHrsWkTotal(root.getRn_eve_total4());
				rnEveningShift4.setStaffHrsAnnual(root.getRn_eve_annual4());
	
				LTCStaffingHrs rnNightShift4 = new LTCStaffingHrs();
				rnNightShift4.setConfirmationId(root.getForm().getConfirmationId());
				rnNightShift4.setStaffingPlanNum("4");
				rnNightShift4.setStaffHrsPosType(root.getRn_label1());
				rnNightShift4.setStaffHrsPosShiftType(root.getRn_night_label());
				rnNightShift4.setStaffHrsMon(root.getRn_night_mon4());
				rnNightShift4.setStaffHrsTue(root.getRn_night_tue4());
				rnNightShift4.setStaffHrsWed(root.getRn_night_wed4());
				rnNightShift4.setStaffHrsThurs(root.getRn_night_thu4());
				rnNightShift4.setStaffHrsFri(root.getRn_night_fri4());
				rnNightShift4.setStaffHrsSat(root.getRn_night_sat4());
				rnNightShift4.setStaffHrsSun(root.getRn_night_sun4());
				rnNightShift4.setStaffHrsWkTotal(root.getRn_night_total4());
				rnNightShift4.setStaffHrsAnnual(root.getRn_night_annual4());
	
				LTCStaffingHrs lpnDayShift4 = new LTCStaffingHrs();
				lpnDayShift4.setConfirmationId(root.getForm().getConfirmationId());
				lpnDayShift4.setStaffingPlanNum("4");
				lpnDayShift4.setStaffHrsPosType(root.getLpn_label1());
				lpnDayShift4.setStaffHrsPosShiftType("Days");
				lpnDayShift4.setStaffHrsMon(root.getLpn_day_mon4());
				lpnDayShift4.setStaffHrsTue(root.getLpn_day_tue4());
				lpnDayShift4.setStaffHrsWed(root.getLpn_day_wed4());
				lpnDayShift4.setStaffHrsThurs(root.getLpn_day_thu4());
				lpnDayShift4.setStaffHrsFri(root.getLpn_day_fri4());
				lpnDayShift4.setStaffHrsSat(root.getLpn_day_sat4());
				lpnDayShift4.setStaffHrsSun(root.getLpn_day_sun4());
				lpnDayShift4.setStaffHrsWkTotal(root.getLpn_day_total4());
				lpnDayShift4.setStaffHrsAnnual(root.getLpn_day_annual4());
	
				LTCStaffingHrs lpnEveningShift4 = new LTCStaffingHrs();
				lpnEveningShift4.setConfirmationId(root.getForm().getConfirmationId());
				lpnEveningShift4.setStaffingPlanNum("4");
				lpnEveningShift4.setStaffHrsPosType(root.getLpn_label1());
				lpnEveningShift4.setStaffHrsPosShiftType(root.getLpn_eve_label1());
				lpnEveningShift4.setStaffHrsMon(root.getLpn_eve_mon4());
				lpnEveningShift4.setStaffHrsTue(root.getLpn_eve_tue4());
				lpnEveningShift4.setStaffHrsWed(root.getLpn_eve_wed4());
				lpnEveningShift4.setStaffHrsThurs(root.getLpn_eve_thu4());
				lpnEveningShift4.setStaffHrsFri(root.getLpn_eve_fri4());
				lpnEveningShift4.setStaffHrsSat(root.getLpn_eve_sat4());
				lpnEveningShift4.setStaffHrsSun(root.getLpn_eve_sun4());
				lpnEveningShift4.setStaffHrsWkTotal(root.getLpn_eve_total4());
				lpnEveningShift4.setStaffHrsAnnual(root.getLpn_eve_annual4());
	
				LTCStaffingHrs lpnNightShift4 = new LTCStaffingHrs();
				lpnNightShift4.setConfirmationId(root.getForm().getConfirmationId());
				lpnNightShift4.setStaffingPlanNum("4");
				lpnNightShift4.setStaffHrsPosType(root.getLpn_label1());
				lpnNightShift4.setStaffHrsPosShiftType(root.getLpn_night_label1());
				lpnNightShift4.setStaffHrsMon(root.getLpn_night_mon4());
				lpnNightShift4.setStaffHrsTue(root.getLpn_night_tue4());
				lpnNightShift4.setStaffHrsWed(root.getLpn_night_wed4());
				lpnNightShift4.setStaffHrsThurs(root.getLpn_night_thu4());
				lpnNightShift4.setStaffHrsFri(root.getLpn_night_fri4());
				lpnNightShift4.setStaffHrsSat(root.getLpn_night_sat4());
				lpnNightShift4.setStaffHrsSun(root.getLpn_night_sun4());
				lpnNightShift4.setStaffHrsWkTotal(root.getLpn_night_total4());
				lpnNightShift4.setStaffHrsAnnual(root.getLpn_night_annual4());
	
				LTCStaffingHrs hcaDayShift4 = new LTCStaffingHrs();
				hcaDayShift4.setConfirmationId(root.getForm().getConfirmationId());
				hcaDayShift4.setStaffingPlanNum("4");
				hcaDayShift4.setStaffHrsPosType(root.getHca_label1());
				hcaDayShift4.setStaffHrsPosShiftType(root.getHca_day_label1());
				hcaDayShift4.setStaffHrsMon(root.getHca_day_mon4());
				hcaDayShift4.setStaffHrsTue(root.getHca_day_tue4());
				hcaDayShift4.setStaffHrsWed(root.getHca_day_wed4());
				hcaDayShift4.setStaffHrsThurs(root.getHca_day_thu4());
				hcaDayShift4.setStaffHrsFri(root.getHca_day_fri4());
				hcaDayShift4.setStaffHrsSat(root.getHca_day_sat4());
				hcaDayShift4.setStaffHrsSun(root.getHca_day_sun4());
				hcaDayShift4.setStaffHrsWkTotal(root.getHca_day_total4());
				hcaDayShift4.setStaffHrsAnnual(root.getHca_day_annual4());
	
				LTCStaffingHrs hcaEveningShift4 = new LTCStaffingHrs();
				hcaEveningShift4.setConfirmationId(root.getForm().getConfirmationId());
				hcaEveningShift4.setStaffingPlanNum("4");
				hcaEveningShift4.setStaffHrsPosType(root.getHca_label1());
				hcaEveningShift4.setStaffHrsPosShiftType(root.getHca_eve_label1());
				hcaEveningShift4.setStaffHrsMon(root.getHca_eve_mon4());
				hcaEveningShift4.setStaffHrsTue(root.getHca_eve_tue4());
				hcaEveningShift4.setStaffHrsWed(root.getHca_eve_wed4());
				hcaEveningShift4.setStaffHrsThurs(root.getHca_eve_thu4());
				hcaEveningShift4.setStaffHrsFri(root.getHca_eve_fri4());
				hcaEveningShift4.setStaffHrsSat(root.getHca_eve_sat4());
				hcaEveningShift4.setStaffHrsSun(root.getHca_eve_sun4());
				hcaEveningShift4.setStaffHrsWkTotal(root.getHca_eve_total4());
				hcaEveningShift4.setStaffHrsAnnual(root.getHca_eve_annual4());
	
				LTCStaffingHrs hcaNightShift4 = new LTCStaffingHrs();
				hcaNightShift4.setConfirmationId(root.getForm().getConfirmationId());
				hcaNightShift4.setStaffingPlanNum("4");
				hcaNightShift4.setStaffHrsPosType(root.getHca_label1());
				hcaNightShift4.setStaffHrsPosShiftType(root.getHca_night_label1());
				hcaNightShift4.setStaffHrsMon(root.getHca_night_mon4());
				hcaNightShift4.setStaffHrsTue(root.getHca_night_tue4());
				hcaNightShift4.setStaffHrsWed(root.getHca_night_wed4());
				hcaNightShift4.setStaffHrsThurs(root.getHca_night_thu4());
				hcaNightShift4.setStaffHrsFri(root.getHca_night_fri4());
				hcaNightShift4.setStaffHrsSat(root.getHca_night_sat4());
				hcaNightShift4.setStaffHrsSun(root.getHca_night_sun4());
				hcaNightShift4.setStaffHrsWkTotal(root.getHca_night_total4());
				hcaNightShift4.setStaffHrsAnnual(root.getHca_night_annual4());
	
				Collections.addAll(LTCStaffingHrs, rnDayShift4, rnEveningShift4, rnNightShift4, lpnDayShift4, 
				lpnEveningShift4, lpnNightShift4, hcaDayShift4, hcaEveningShift4, hcaNightShift4);
			}

			if(root.getStaffingPlanType5() != null && !root.getStaffingPlanType5().isEmpty()){
				LTCStaffingHrs rnDayShift5 = new LTCStaffingHrs();
				rnDayShift5.setConfirmationId(root.getForm().getConfirmationId());
				rnDayShift5.setStaffingPlanNum("5");
				rnDayShift5.setStaffHrsPosType(root.getRn_label1());
				rnDayShift5.setStaffHrsPosShiftType(root.getRn_day_label());
				rnDayShift5.setStaffHrsMon(root.getRn_day_mon5());
				rnDayShift5.setStaffHrsTue(root.getRn_day_tue5());
				rnDayShift5.setStaffHrsWed(root.getRn_day_wed5());
				rnDayShift5.setStaffHrsThurs(root.getRn_day_thu5());
				rnDayShift5.setStaffHrsFri(root.getRn_day_fri5());
				rnDayShift5.setStaffHrsSat(root.getRn_day_sat5());
				rnDayShift5.setStaffHrsSun(root.getRn_day_sun5());
				rnDayShift5.setStaffHrsWkTotal(root.getRn_day_total5());
				rnDayShift5.setStaffHrsAnnual(root.getRn_day_annual5());
	
				LTCStaffingHrs rnEveningShift5 = new LTCStaffingHrs();
				rnEveningShift5.setConfirmationId(root.getForm().getConfirmationId());
				rnEveningShift5.setStaffingPlanNum("5");
				rnEveningShift5.setStaffHrsPosType(root.getRn_label1());
				rnEveningShift5.setStaffHrsPosShiftType(root.getRn_eve_label());
				rnEveningShift5.setStaffHrsMon(root.getRn_eve_mon5());
				rnEveningShift5.setStaffHrsTue(root.getRn_eve_tue5());
				rnEveningShift5.setStaffHrsWed(root.getRn_eve_wed5());
				rnEveningShift5.setStaffHrsThurs(root.getRn_eve_thu5());
				rnEveningShift5.setStaffHrsFri(root.getRn_eve_fri5());
				rnEveningShift5.setStaffHrsSat(root.getRn_eve_sat5());
				rnEveningShift5.setStaffHrsSun(root.getRn_eve_sun5());
				rnEveningShift5.setStaffHrsWkTotal(root.getRn_eve_total5());
				rnEveningShift5.setStaffHrsAnnual(root.getRn_eve_annual5());
	
				LTCStaffingHrs rnNightShift5 = new LTCStaffingHrs();
				rnNightShift5.setConfirmationId(root.getForm().getConfirmationId());
				rnNightShift5.setStaffingPlanNum("5");
				rnNightShift5.setStaffHrsPosType(root.getRn_label1());
				rnNightShift5.setStaffHrsPosShiftType(root.getRn_night_label());
				rnNightShift5.setStaffHrsMon(root.getRn_night_mon5());
				rnNightShift5.setStaffHrsTue(root.getRn_night_tue5());
				rnNightShift5.setStaffHrsWed(root.getRn_night_wed5());
				rnNightShift5.setStaffHrsThurs(root.getRn_night_thu5());
				rnNightShift5.setStaffHrsFri(root.getRn_night_fri5());
				rnNightShift5.setStaffHrsSat(root.getRn_night_sat5());
				rnNightShift5.setStaffHrsSun(root.getRn_night_sun5());
				rnNightShift5.setStaffHrsWkTotal(root.getRn_night_total5());
				rnNightShift5.setStaffHrsAnnual(root.getRn_night_annual5());
	
				LTCStaffingHrs lpnDayShift5 = new LTCStaffingHrs();
				lpnDayShift5.setConfirmationId(root.getForm().getConfirmationId());
				lpnDayShift5.setStaffingPlanNum("5");
				lpnDayShift5.setStaffHrsPosType(root.getLpn_label1());
				lpnDayShift5.setStaffHrsPosShiftType("Days");
				lpnDayShift5.setStaffHrsMon(root.getLpn_day_mon5());
				lpnDayShift5.setStaffHrsTue(root.getLpn_day_tue5());
				lpnDayShift5.setStaffHrsWed(root.getLpn_day_wed5());
				lpnDayShift5.setStaffHrsThurs(root.getLpn_day_thu5());
				lpnDayShift5.setStaffHrsFri(root.getLpn_day_fri5());
				lpnDayShift5.setStaffHrsSat(root.getLpn_day_sat5());
				lpnDayShift5.setStaffHrsSun(root.getLpn_day_sun5());
				lpnDayShift5.setStaffHrsWkTotal(root.getLpn_day_total5());
				lpnDayShift5.setStaffHrsAnnual(root.getLpn_day_annual5());
	
				LTCStaffingHrs lpnEveningShift5 = new LTCStaffingHrs();
				lpnEveningShift5.setConfirmationId(root.getForm().getConfirmationId());
				lpnEveningShift5.setStaffingPlanNum("5");
				lpnEveningShift5.setStaffHrsPosType(root.getLpn_label1());
				lpnEveningShift5.setStaffHrsPosShiftType(root.getLpn_eve_label1());
				lpnEveningShift5.setStaffHrsMon(root.getLpn_eve_mon5());
				lpnEveningShift5.setStaffHrsTue(root.getLpn_eve_tue5());
				lpnEveningShift5.setStaffHrsWed(root.getLpn_eve_wed5());
				lpnEveningShift5.setStaffHrsThurs(root.getLpn_eve_thu5());
				lpnEveningShift5.setStaffHrsFri(root.getLpn_eve_fri5());
				lpnEveningShift5.setStaffHrsSat(root.getLpn_eve_sat5());
				lpnEveningShift5.setStaffHrsSun(root.getLpn_eve_sun5());
				lpnEveningShift5.setStaffHrsWkTotal(root.getLpn_eve_total5());
				lpnEveningShift5.setStaffHrsAnnual(root.getLpn_eve_annual5());
	
				LTCStaffingHrs lpnNightShift5 = new LTCStaffingHrs();
				lpnNightShift5.setConfirmationId(root.getForm().getConfirmationId());
				lpnNightShift5.setStaffingPlanNum("5");
				lpnNightShift5.setStaffHrsPosType(root.getLpn_label1());
				lpnNightShift5.setStaffHrsPosShiftType(root.getLpn_night_label1());
				lpnNightShift5.setStaffHrsMon(root.getLpn_night_mon5());
				lpnNightShift5.setStaffHrsTue(root.getLpn_night_tue5());
				lpnNightShift5.setStaffHrsWed(root.getLpn_night_wed5());
				lpnNightShift5.setStaffHrsThurs(root.getLpn_night_thu5());
				lpnNightShift5.setStaffHrsFri(root.getLpn_night_fri5());
				lpnNightShift5.setStaffHrsSat(root.getLpn_night_sat5());
				lpnNightShift5.setStaffHrsSun(root.getLpn_night_sun5());
				lpnNightShift5.setStaffHrsWkTotal(root.getLpn_night_total5());
				lpnNightShift5.setStaffHrsAnnual(root.getLpn_night_annual5());
	
				LTCStaffingHrs hcaDayShift5 = new LTCStaffingHrs();
				hcaDayShift5.setConfirmationId(root.getForm().getConfirmationId());
				hcaDayShift5.setStaffingPlanNum("5");
				hcaDayShift5.setStaffHrsPosType(root.getHca_label1());
				hcaDayShift5.setStaffHrsPosShiftType(root.getHca_day_label1());
				hcaDayShift5.setStaffHrsMon(root.getHca_day_mon5());
				hcaDayShift5.setStaffHrsTue(root.getHca_day_tue5());
				hcaDayShift5.setStaffHrsWed(root.getHca_day_wed5());
				hcaDayShift5.setStaffHrsThurs(root.getHca_day_thu5());
				hcaDayShift5.setStaffHrsFri(root.getHca_day_fri5());
				hcaDayShift5.setStaffHrsSat(root.getHca_day_sat5());
				hcaDayShift5.setStaffHrsSun(root.getHca_day_sun5());
				hcaDayShift5.setStaffHrsWkTotal(root.getHca_day_total5());
				hcaDayShift5.setStaffHrsAnnual(root.getHca_day_annual5());
	
				LTCStaffingHrs hcaEveningShift5 = new LTCStaffingHrs();
				hcaEveningShift5.setConfirmationId(root.getForm().getConfirmationId());
				hcaEveningShift5.setStaffingPlanNum("5");
				hcaEveningShift5.setStaffHrsPosType(root.getHca_label1());
				hcaEveningShift5.setStaffHrsPosShiftType(root.getHca_eve_label1());
				hcaEveningShift5.setStaffHrsMon(root.getHca_eve_mon5());
				hcaEveningShift5.setStaffHrsTue(root.getHca_eve_tue5());
				hcaEveningShift5.setStaffHrsWed(root.getHca_eve_wed5());
				hcaEveningShift5.setStaffHrsThurs(root.getHca_eve_thu5());
				hcaEveningShift5.setStaffHrsFri(root.getHca_eve_fri5());
				hcaEveningShift5.setStaffHrsSat(root.getHca_eve_sat5());
				hcaEveningShift5.setStaffHrsSun(root.getHca_eve_sun5());
				hcaEveningShift5.setStaffHrsWkTotal(root.getHca_eve_total5());
				hcaEveningShift5.setStaffHrsAnnual(root.getHca_eve_annual5());
	
				LTCStaffingHrs hcaNightShift5 = new LTCStaffingHrs();
				hcaNightShift5.setConfirmationId(root.getForm().getConfirmationId());
				hcaNightShift5.setStaffingPlanNum("5");
				hcaNightShift5.setStaffHrsPosType(root.getHca_label1());
				hcaNightShift5.setStaffHrsPosShiftType(root.getHca_night_label1());
				hcaNightShift5.setStaffHrsMon(root.getHca_night_mon5());
				hcaNightShift5.setStaffHrsTue(root.getHca_night_tue5());
				hcaNightShift5.setStaffHrsWed(root.getHca_night_wed5());
				hcaNightShift5.setStaffHrsThurs(root.getHca_night_thu5());
				hcaNightShift5.setStaffHrsFri(root.getHca_night_fri5());
				hcaNightShift5.setStaffHrsSat(root.getHca_night_sat5());
				hcaNightShift5.setStaffHrsSun(root.getHca_night_sun5());
				hcaNightShift5.setStaffHrsWkTotal(root.getHca_night_total5());
				hcaNightShift5.setStaffHrsAnnual(root.getHca_night_annual5());
	
				Collections.addAll(LTCStaffingHrs, rnDayShift5, rnEveningShift5, rnNightShift5, lpnDayShift5, 
				lpnEveningShift5, lpnNightShift5, hcaDayShift5, hcaEveningShift5, hcaNightShift5);
			}

			/* Mapping LTC_STAFFING_ADD_POS */

			LTCStaffingAddPos addPosRN1 = new LTCStaffingAddPos();
			addPosRN1.setConfirmationId(root.getForm().getConfirmationId());
			addPosRN1.setStaffingPlanNum("1");
			addPosRN1.setStaffingHrsPosType(root.getRn_label1());
			addPosRN1.setStaffHrsServiceContractOut(root.getContractedOut_RN1());
			addPosRN1.setStaffHrsLegalNameContractService(root.getProviderName_RN1());
			addPosRN1.setStaffHoursPercentServiceContractOut(root.getPercentageOut_RN1());
			
			LTCStaffingAddPos addPosLPN1 = new LTCStaffingAddPos();
			addPosLPN1.setConfirmationId(root.getForm().getConfirmationId());
			addPosLPN1.setStaffingPlanNum("1");
			addPosLPN1.setStaffingHrsPosType(root.getLpn_label1());
			addPosLPN1.setStaffHrsServiceContractOut(root.getContractedOut_LPN1());
			addPosLPN1.setStaffHrsLegalNameContractService(root.getProviderName_LPN1());
			addPosLPN1.setStaffHoursPercentServiceContractOut(root.getPercentageOut_LPN1());

			LTCStaffingAddPos addPosOtherNurse1 = new LTCStaffingAddPos();
			addPosOtherNurse1.setConfirmationId(root.getForm().getConfirmationId());
			addPosOtherNurse1.setStaffingPlanNum("1");
			addPosOtherNurse1.setStaffingHrsPosType("Other Nursing Professional");
			addPosOtherNurse1.setStaffHrsServiceContractOut(root.getContractedOut_otherNursingP1());
			addPosOtherNurse1.setStaffHrsLegalNameContractService(root.getProviderName_otherNursingP1());
			addPosOtherNurse1.setStaffHoursPercentServiceContractOut(root.getPercentageOut_otherNursingP1());

			LTCStaffingAddPos addPosHCA1 = new LTCStaffingAddPos();
			addPosHCA1.setConfirmationId(root.getForm().getConfirmationId());
			addPosHCA1.setStaffingPlanNum("1");
			addPosHCA1.setStaffingHrsPosType(root.getHca_label1());
			addPosHCA1.setStaffHrsServiceContractOut(root.getContractedOut_HCA1());
			addPosHCA1.setStaffHrsLegalNameContractService(root.getProviderName_HCA21());
			addPosHCA1.setStaffHoursPercentServiceContractOut(root.getPercentageOut_HCA1());

			LTCStaffingAddPos addPosOtherNpNurse1 = new LTCStaffingAddPos();
			addPosOtherNpNurse1.setConfirmationId(root.getForm().getConfirmationId());
			addPosOtherNpNurse1.setStaffingPlanNum("1");
			addPosOtherNpNurse1.setStaffingHrsPosType("Other Nursing Non-Professional");
			addPosOtherNpNurse1.setStaffHrsServiceContractOut(root.getContractedOut_otherNursingNP1());
			addPosOtherNpNurse1.setStaffHrsLegalNameContractService(root.getProviderName_otherNursingNP1());
			addPosOtherNpNurse1.setStaffHoursPercentServiceContractOut(root.getPercentageOut_otherNursingNP1());

			LTCStaffingAddPos addPosOT1 = new LTCStaffingAddPos();
			addPosOT1.setConfirmationId(root.getForm().getConfirmationId());
			addPosOT1.setStaffingPlanNum("1");
			addPosOT1.setStaffingHrsPosType(root.getAld_ot_label1());
			addPosOT1.setStaffHrsServiceContractOut(root.getContractedOut_OT1());
			addPosOT1.setStaffHrsLegalNameContractService(root.getProviderName_OT1());
			addPosOT1.setStaffHoursPercentServiceContractOut(root.getPercentageOut_OT1());

			LTCStaffingAddPos addPosPT1 = new LTCStaffingAddPos();
			addPosPT1.setConfirmationId(root.getForm().getConfirmationId());
			addPosPT1.setStaffingPlanNum("1");
			addPosPT1.setStaffingHrsPosType(root.getAld_pt_label1());
			addPosPT1.setStaffHrsServiceContractOut(root.getContractedOut_PT1());
			addPosPT1.setStaffHrsLegalNameContractService(root.getProviderName_PT1());
			addPosPT1.setStaffHoursPercentServiceContractOut(root.getPercentageOut_PT1());
			
			LTCStaffingAddPos addPosDT1 = new LTCStaffingAddPos();
			addPosDT1.setConfirmationId(root.getForm().getConfirmationId());
			addPosDT1.setStaffingPlanNum("1");
			addPosDT1.setStaffingHrsPosType(root.getAld_dt_label1());
			addPosDT1.setStaffHrsServiceContractOut(root.getContractedOut_DT1());
			addPosDT1.setStaffHrsLegalNameContractService(root.getProviderName_DT1());
			addPosDT1.setStaffHoursPercentServiceContractOut(root.getPercentageOut_DT1());

			LTCStaffingAddPos addPosSW1 = new LTCStaffingAddPos();
			addPosSW1.setConfirmationId(root.getForm().getConfirmationId());
			addPosSW1.setStaffingPlanNum("1");
			addPosSW1.setStaffingHrsPosType(root.getAld_sw_label1());
			addPosSW1.setStaffHrsServiceContractOut(root.getContractedOut_SW1());
			addPosSW1.setStaffHrsLegalNameContractService(root.getProviderName_SW1());
			addPosSW1.setStaffHoursPercentServiceContractOut(root.getPercentageOut_SW1());

			LTCStaffingAddPos addPosSLP1 = new LTCStaffingAddPos();
			addPosSLP1.setConfirmationId(root.getForm().getConfirmationId());
			addPosSLP1.setStaffingPlanNum("1");
			addPosSLP1.setStaffingHrsPosType(root.getAld_sp_label1());
			addPosSLP1.setStaffHrsServiceContractOut(root.getContractedOut_SL1());
			addPosSLP1.setStaffHrsLegalNameContractService(root.getProviderName_SL1());
			addPosSLP1.setStaffHoursPercentServiceContractOut(root.getPercentageOut_SL1());

			LTCStaffingAddPos addPosRespT1 = new LTCStaffingAddPos();
			addPosRespT1.setConfirmationId(root.getForm().getConfirmationId());
			addPosRespT1.setStaffingPlanNum("1");
			addPosRespT1.setStaffingHrsPosType(root.getAld_rt_label1());
			addPosRespT1.setStaffHrsServiceContractOut(root.getContractedOut_resp1());
			addPosRespT1.setStaffHrsLegalNameContractService(root.getProviderName_resp1());
			addPosRespT1.setStaffHoursPercentServiceContractOut(root.getPercentageOut_resp1());

			LTCStaffingAddPos addPosOtherAllied1 = new LTCStaffingAddPos();
			addPosOtherAllied1.setConfirmationId(root.getForm().getConfirmationId());
			addPosOtherAllied1.setStaffingPlanNum("1");
			addPosOtherAllied1.setStaffingHrsPosType("Other Allied Professional");
			addPosOtherAllied1.setStaffHrsServiceContractOut(root.getContractedOut_otherAlliedProf1());
			addPosOtherAllied1.setStaffHrsLegalNameContractService(root.getProviderName_otherAlliedProf1());
			addPosOtherAllied1.setStaffHoursPercentServiceContractOut(root.getPercentageOut_otherAlliedProf1());

			LTCStaffingAddPos addPosRT1 = new LTCStaffingAddPos();
			addPosRT1.setConfirmationId(root.getForm().getConfirmationId());
			addPosRT1.setStaffingPlanNum("1");
			addPosRT1.setStaffingHrsPosType(root.getAldnop_rt_label1());
			addPosRT1.setStaffHrsServiceContractOut(root.getContractedOut_RT1());
			addPosRT1.setStaffHrsLegalNameContractService(root.getProviderName_RT1());
			addPosRT1.setStaffHoursPercentServiceContractOut(root.getPercentageOut_RT1());

			LTCStaffingAddPos addPosRA1 = new LTCStaffingAddPos();
			addPosRA1.setConfirmationId(root.getForm().getConfirmationId());
			addPosRA1.setStaffingPlanNum("1");
			addPosRA1.setStaffingHrsPosType(root.getAldnop_ra_label1());
			addPosRA1.setStaffHrsServiceContractOut(root.getContractedOut_RA1());
			addPosRA1.setStaffHrsLegalNameContractService(root.getProviderName_RA1());
			addPosRA1.setStaffHoursPercentServiceContractOut(root.getPercentageOut_RA1());

			LTCStaffingAddPos addPosAW1 = new LTCStaffingAddPos();
			addPosAW1.setConfirmationId(root.getForm().getConfirmationId());
			addPosAW1.setStaffingPlanNum("1");
			addPosAW1.setStaffingHrsPosType(root.getAldnop_aw_label1());
			addPosAW1.setStaffHrsServiceContractOut(root.getContractedOut_AW1());
			addPosAW1.setStaffHrsLegalNameContractService(root.getProviderName_AW1());
			addPosAW1.setStaffHoursPercentServiceContractOut(root.getPercentageOut_AW1());

			LTCStaffingAddPos addPosMT1 = new LTCStaffingAddPos();
			addPosMT1.setConfirmationId(root.getForm().getConfirmationId());
			addPosMT1.setStaffingPlanNum("1");
			addPosMT1.setStaffingHrsPosType(root.getAldnop_mt_label1());
			addPosMT1.setStaffHrsServiceContractOut(root.getContractedOut_MT1());
			addPosMT1.setStaffHrsLegalNameContractService(root.getProviderName_MT1());
			addPosMT1.setStaffHoursPercentServiceContractOut(root.getPercentageOut_MT1());

			LTCStaffingAddPos addPosAT1 = new LTCStaffingAddPos();
			addPosAT1.setConfirmationId(root.getForm().getConfirmationId());
			addPosAT1.setStaffingPlanNum("1");
			addPosAT1.setStaffingHrsPosType(root.getAldnop_at_label1());
			addPosAT1.setStaffHrsServiceContractOut(root.getContractedOut_AT1());
			addPosAT1.setStaffHrsLegalNameContractService(root.getProviderName_AT1());
			addPosAT1.setStaffHoursPercentServiceContractOut(root.getPercentageOut_AT1());

			LTCStaffingAddPos addPosOtherNpAllied1 = new LTCStaffingAddPos();
			addPosOtherNpAllied1.setConfirmationId(root.getForm().getConfirmationId());
			addPosOtherNpAllied1.setStaffingPlanNum("1");
			addPosOtherNpAllied1.setStaffingHrsPosType("Other Allied Non-Professional");
			addPosOtherNpAllied1.setStaffHrsServiceContractOut(root.getContractedOut_otherAlliedNProf1());
			addPosOtherNpAllied1.setStaffHrsLegalNameContractService(root.getProviderName_otherAlliedNProf1());
			addPosOtherNpAllied1.setStaffHoursPercentServiceContractOut(root.getPercentageOut_otherAlliedNProf1());

			Collections.addAll(LTCStaffingAddPos, addPosRN1, addPosLPN1, addPosOtherNurse1, addPosHCA1, addPosOtherNpNurse1,
			addPosOT1, addPosPT1, addPosDT1, addPosSW1, addPosSLP1, addPosRespT1, addPosOtherAllied1, addPosRT1, addPosRA1, 
			addPosAW1, addPosMT1, addPosAT1, addPosOtherNpAllied1);

			if(root.getStaffingPlanType2() != null && !root.getStaffingPlanType2().isEmpty()){
				LTCStaffingAddPos addPosRN2 = new LTCStaffingAddPos();
				addPosRN2.setConfirmationId(root.getForm().getConfirmationId());
				addPosRN2.setStaffingPlanNum("2");
				addPosRN2.setStaffingHrsPosType(root.getRn_label1());
				addPosRN2.setStaffHrsServiceContractOut(root.getContractedOut_RN2());
				addPosRN2.setStaffHrsLegalNameContractService(root.getProviderName_RN2());
				addPosRN2.setStaffHoursPercentServiceContractOut(root.getPercentageOut_RN2());
				
				LTCStaffingAddPos addPosLPN2 = new LTCStaffingAddPos();
				addPosLPN2.setConfirmationId(root.getForm().getConfirmationId());
				addPosLPN2.setStaffingPlanNum("2");
				addPosLPN2.setStaffingHrsPosType(root.getLpn_label1());
				addPosLPN2.setStaffHrsServiceContractOut(root.getContractedOut_LPN2());
				addPosLPN2.setStaffHrsLegalNameContractService(root.getProviderName_LPN2());
				addPosLPN2.setStaffHoursPercentServiceContractOut(root.getPercentageOut_LPN2());
	
				LTCStaffingAddPos addPosOtherNurse2 = new LTCStaffingAddPos();
				addPosOtherNurse2.setConfirmationId(root.getForm().getConfirmationId());
				addPosOtherNurse2.setStaffingPlanNum("2");
				addPosOtherNurse2.setStaffingHrsPosType("Other Nursing Professional");
				addPosOtherNurse2.setStaffHrsServiceContractOut(root.getContractedOut_otherNursingP2());
				addPosOtherNurse2.setStaffHrsLegalNameContractService(root.getProviderName_otherNursingP2());
				addPosOtherNurse2.setStaffHoursPercentServiceContractOut(root.getPercentageOut_otherNursingP2());
	
				LTCStaffingAddPos addPosHCA2 = new LTCStaffingAddPos();
				addPosHCA2.setConfirmationId(root.getForm().getConfirmationId());
				addPosHCA2.setStaffingPlanNum("2");
				addPosHCA2.setStaffingHrsPosType(root.getHca_label1());
				addPosHCA2.setStaffHrsServiceContractOut(root.getContractedOut_HCA2());
				addPosHCA2.setStaffHrsLegalNameContractService(root.getProviderName_HCA22());
				addPosHCA2.setStaffHoursPercentServiceContractOut(root.getPercentageOut_HCA2());
	
				LTCStaffingAddPos addPosOtherNpNurse2 = new LTCStaffingAddPos();
				addPosOtherNpNurse2.setConfirmationId(root.getForm().getConfirmationId());
				addPosOtherNpNurse2.setStaffingPlanNum("2");
				addPosOtherNpNurse2.setStaffingHrsPosType("Other Nursing Non-Professional");
				addPosOtherNpNurse2.setStaffHrsServiceContractOut(root.getContractedOut_otherNursingNP2());
				addPosOtherNpNurse2.setStaffHrsLegalNameContractService(root.getProviderName_otherNursingNP2());
				addPosOtherNpNurse2.setStaffHoursPercentServiceContractOut(root.getPercentageOut_otherNursingNP2());
	
				LTCStaffingAddPos addPosOT2 = new LTCStaffingAddPos();
				addPosOT2.setConfirmationId(root.getForm().getConfirmationId());
				addPosOT2.setStaffingPlanNum("2");
				addPosOT2.setStaffingHrsPosType(root.getAld_ot_label1());
				addPosOT2.setStaffHrsServiceContractOut(root.getContractedOut_OT2());
				addPosOT2.setStaffHrsLegalNameContractService(root.getProviderName_OT2());
				addPosOT2.setStaffHoursPercentServiceContractOut(root.getPercentageOut_OT2());
	
				LTCStaffingAddPos addPosPT2 = new LTCStaffingAddPos();
				addPosPT2.setConfirmationId(root.getForm().getConfirmationId());
				addPosPT2.setStaffingPlanNum("2");
				addPosPT2.setStaffingHrsPosType(root.getAld_pt_label1());
				addPosPT2.setStaffHrsServiceContractOut(root.getContractedOut_PT2());
				addPosPT2.setStaffHrsLegalNameContractService(root.getProviderName_PT2());
				addPosPT2.setStaffHoursPercentServiceContractOut(root.getPercentageOut_PT2());
				
				LTCStaffingAddPos addPosDT2 = new LTCStaffingAddPos();
				addPosDT2.setConfirmationId(root.getForm().getConfirmationId());
				addPosDT2.setStaffingPlanNum("2");
				addPosDT2.setStaffingHrsPosType(root.getAld_dt_label1());
				addPosDT2.setStaffHrsServiceContractOut(root.getContractedOut_DT2());
				addPosDT2.setStaffHrsLegalNameContractService(root.getProviderName_DT2());
				addPosDT2.setStaffHoursPercentServiceContractOut(root.getPercentageOut_DT2());
	
				LTCStaffingAddPos addPosSW2 = new LTCStaffingAddPos();
				addPosSW2.setConfirmationId(root.getForm().getConfirmationId());
				addPosSW2.setStaffingPlanNum("2");
				addPosSW2.setStaffingHrsPosType(root.getAld_sw_label1());
				addPosSW2.setStaffHrsServiceContractOut(root.getContractedOut_SW2());
				addPosSW2.setStaffHrsLegalNameContractService(root.getProviderName_SW2());
				addPosSW2.setStaffHoursPercentServiceContractOut(root.getPercentageOut_SW2());
	
				LTCStaffingAddPos addPosSLP2 = new LTCStaffingAddPos();
				addPosSLP2.setConfirmationId(root.getForm().getConfirmationId());
				addPosSLP2.setStaffingPlanNum("2");
				addPosSLP2.setStaffingHrsPosType(root.getAld_sp_label1());
				addPosSLP2.setStaffHrsServiceContractOut(root.getContractedOut_SL2());
				addPosSLP2.setStaffHrsLegalNameContractService(root.getProviderName_SL2());
				addPosSLP2.setStaffHoursPercentServiceContractOut(root.getPercentageOut_SL2());
	
				LTCStaffingAddPos addPosRespT2 = new LTCStaffingAddPos();
				addPosRespT2.setConfirmationId(root.getForm().getConfirmationId());
				addPosRespT2.setStaffingPlanNum("2");
				addPosRespT2.setStaffingHrsPosType(root.getAld_rt_label1());
				addPosRespT2.setStaffHrsServiceContractOut(root.getContractedOut_resp2());
				addPosRespT2.setStaffHrsLegalNameContractService(root.getProviderName_resp2());
				addPosRespT2.setStaffHoursPercentServiceContractOut(root.getPercentageOut_resp2());
	
				LTCStaffingAddPos addPosOtherAllied2 = new LTCStaffingAddPos();
				addPosOtherAllied2.setConfirmationId(root.getForm().getConfirmationId());
				addPosOtherAllied2.setStaffingPlanNum("2");
				addPosOtherAllied2.setStaffingHrsPosType("Other Allied Professional");
				addPosOtherAllied2.setStaffHrsServiceContractOut(root.getContractedOut_otherAlliedProf2());
				addPosOtherAllied2.setStaffHrsLegalNameContractService(root.getProviderName_otherAlliedProf2());
				addPosOtherAllied2.setStaffHoursPercentServiceContractOut(root.getPercentageOut_otherAlliedProf2());
	
				LTCStaffingAddPos addPosRT2 = new LTCStaffingAddPos();
				addPosRT2.setConfirmationId(root.getForm().getConfirmationId());
				addPosRT2.setStaffingPlanNum("2");
				addPosRT2.setStaffingHrsPosType(root.getAldnop_rt_label1());
				addPosRT2.setStaffHrsServiceContractOut(root.getContractedOut_RT2());
				addPosRT2.setStaffHrsLegalNameContractService(root.getProviderName_RT2());
				addPosRT2.setStaffHoursPercentServiceContractOut(root.getPercentageOut_RT2());
	
				LTCStaffingAddPos addPosRA2 = new LTCStaffingAddPos();
				addPosRA2.setConfirmationId(root.getForm().getConfirmationId());
				addPosRA2.setStaffingPlanNum("2");
				addPosRA2.setStaffingHrsPosType(root.getAldnop_ra_label1());
				addPosRA2.setStaffHrsServiceContractOut(root.getContractedOut_RA2());
				addPosRA2.setStaffHrsLegalNameContractService(root.getProviderName_RA2());
				addPosRA2.setStaffHoursPercentServiceContractOut(root.getPercentageOut_RA2());
	
				LTCStaffingAddPos addPosAW2 = new LTCStaffingAddPos();
				addPosAW2.setConfirmationId(root.getForm().getConfirmationId());
				addPosAW2.setStaffingPlanNum("2");
				addPosAW2.setStaffingHrsPosType(root.getAldnop_aw_label1());
				addPosAW2.setStaffHrsServiceContractOut(root.getContractedOut_AW2());
				addPosAW2.setStaffHrsLegalNameContractService(root.getProviderName_AW2());
				addPosAW2.setStaffHoursPercentServiceContractOut(root.getPercentageOut_AW2());
	
				LTCStaffingAddPos addPosMT2 = new LTCStaffingAddPos();
				addPosMT2.setConfirmationId(root.getForm().getConfirmationId());
				addPosMT2.setStaffingPlanNum("2");
				addPosMT2.setStaffingHrsPosType(root.getAldnop_mt_label1());
				addPosMT2.setStaffHrsServiceContractOut(root.getContractedOut_MT2());
				addPosMT2.setStaffHrsLegalNameContractService(root.getProviderName_MT2());
				addPosMT2.setStaffHoursPercentServiceContractOut(root.getPercentageOut_MT2());
	
				LTCStaffingAddPos addPosAT2 = new LTCStaffingAddPos();
				addPosAT2.setConfirmationId(root.getForm().getConfirmationId());
				addPosAT2.setStaffingPlanNum("2");
				addPosAT2.setStaffingHrsPosType(root.getAldnop_at_label1());
				addPosAT2.setStaffHrsServiceContractOut(root.getContractedOut_AT2());
				addPosAT2.setStaffHrsLegalNameContractService(root.getProviderName_AT2());
				addPosAT2.setStaffHoursPercentServiceContractOut(root.getPercentageOut_AT2());
	
				LTCStaffingAddPos addPosOtherNpAllied2 = new LTCStaffingAddPos();
				addPosOtherNpAllied2.setConfirmationId(root.getForm().getConfirmationId());
				addPosOtherNpAllied2.setStaffingPlanNum("2");
				addPosOtherNpAllied2.setStaffingHrsPosType("Other Allied Non-Professional");
				addPosOtherNpAllied2.setStaffHrsServiceContractOut(root.getContractedOut_otherAlliedNProf2());
				addPosOtherNpAllied2.setStaffHrsLegalNameContractService(root.getProviderName_otherAlliedNProf2());
				addPosOtherNpAllied2.setStaffHoursPercentServiceContractOut(root.getPercentageOut_otherAlliedNProf2());
	
				Collections.addAll(LTCStaffingAddPos, addPosRN2, addPosLPN2, addPosOtherNurse2, addPosHCA2, addPosOtherNpNurse2,
				addPosOT2, addPosPT2, addPosDT2, addPosSW2, addPosSLP2, addPosRespT2, addPosOtherAllied2, addPosRT2, addPosRA2, 
				addPosAW2, addPosMT2, addPosAT2, addPosOtherNpAllied2);
			}
			
			if(root.getStaffingPlanType3() != null && !root.getStaffingPlanType3().isEmpty()){
				LTCStaffingAddPos addPosRN3 = new LTCStaffingAddPos();
				addPosRN3.setConfirmationId(root.getForm().getConfirmationId());
				addPosRN3.setStaffingPlanNum("3");
				addPosRN3.setStaffingHrsPosType(root.getRn_label1());
				addPosRN3.setStaffHrsServiceContractOut(root.getContractedOut_RN3());
				addPosRN3.setStaffHrsLegalNameContractService(root.getProviderName_RN3());
				addPosRN3.setStaffHoursPercentServiceContractOut(root.getPercentageOut_RN3());
				
				LTCStaffingAddPos addPosLPN3 = new LTCStaffingAddPos();
				addPosLPN3.setConfirmationId(root.getForm().getConfirmationId());
				addPosLPN3.setStaffingPlanNum("3");
				addPosLPN3.setStaffingHrsPosType(root.getLpn_label1());
				addPosLPN3.setStaffHrsServiceContractOut(root.getContractedOut_LPN3());
				addPosLPN3.setStaffHrsLegalNameContractService(root.getProviderName_LPN3());
				addPosLPN3.setStaffHoursPercentServiceContractOut(root.getPercentageOut_LPN3());
	
				LTCStaffingAddPos addPosOtherNurse3 = new LTCStaffingAddPos();
				addPosOtherNurse3.setConfirmationId(root.getForm().getConfirmationId());
				addPosOtherNurse3.setStaffingPlanNum("3");
				addPosOtherNurse3.setStaffingHrsPosType("Other Nursing Professional");
				addPosOtherNurse3.setStaffHrsServiceContractOut(root.getContractedOut_otherNursingP3());
				addPosOtherNurse3.setStaffHrsLegalNameContractService(root.getProviderName_otherNursingP3());
				addPosOtherNurse3.setStaffHoursPercentServiceContractOut(root.getPercentageOut_otherNursingP3());
	
				LTCStaffingAddPos addPosHCA3 = new LTCStaffingAddPos();
				addPosHCA3.setConfirmationId(root.getForm().getConfirmationId());
				addPosHCA3.setStaffingPlanNum("3");
				addPosHCA3.setStaffingHrsPosType(root.getHca_label1());
				addPosHCA3.setStaffHrsServiceContractOut(root.getContractedOut_HCA3());
				addPosHCA3.setStaffHrsLegalNameContractService(root.getProviderName_HCA23());
				addPosHCA3.setStaffHoursPercentServiceContractOut(root.getPercentageOut_HCA3());
	
				LTCStaffingAddPos addPosOtherNpNurse3 = new LTCStaffingAddPos();
				addPosOtherNpNurse3.setConfirmationId(root.getForm().getConfirmationId());
				addPosOtherNpNurse3.setStaffingPlanNum("3");
				addPosOtherNpNurse3.setStaffingHrsPosType("Other Nursing Non-Professional");
				addPosOtherNpNurse3.setStaffHrsServiceContractOut(root.getContractedOut_otherNursingNP3());
				addPosOtherNpNurse3.setStaffHrsLegalNameContractService(root.getProviderName_otherNursingNP3());
				addPosOtherNpNurse3.setStaffHoursPercentServiceContractOut(root.getPercentageOut_otherNursingNP3());
	
				LTCStaffingAddPos addPosOT3 = new LTCStaffingAddPos();
				addPosOT3.setConfirmationId(root.getForm().getConfirmationId());
				addPosOT3.setStaffingPlanNum("3");
				addPosOT3.setStaffingHrsPosType(root.getAld_ot_label1());
				addPosOT3.setStaffHrsServiceContractOut(root.getContractedOut_OT3());
				addPosOT3.setStaffHrsLegalNameContractService(root.getProviderName_OT3());
				addPosOT3.setStaffHoursPercentServiceContractOut(root.getPercentageOut_OT3());
	
				LTCStaffingAddPos addPosPT3 = new LTCStaffingAddPos();
				addPosPT3.setConfirmationId(root.getForm().getConfirmationId());
				addPosPT3.setStaffingPlanNum("3");
				addPosPT3.setStaffingHrsPosType(root.getAld_pt_label1());
				addPosPT3.setStaffHrsServiceContractOut(root.getContractedOut_PT3());
				addPosPT3.setStaffHrsLegalNameContractService(root.getProviderName_PT3());
				addPosPT3.setStaffHoursPercentServiceContractOut(root.getPercentageOut_PT3());
				
				LTCStaffingAddPos addPosDT3 = new LTCStaffingAddPos();
				addPosDT3.setConfirmationId(root.getForm().getConfirmationId());
				addPosDT3.setStaffingPlanNum("3");
				addPosDT3.setStaffingHrsPosType(root.getAld_dt_label1());
				addPosDT3.setStaffHrsServiceContractOut(root.getContractedOut_DT3());
				addPosDT3.setStaffHrsLegalNameContractService(root.getProviderName_DT3());
				addPosDT3.setStaffHoursPercentServiceContractOut(root.getPercentageOut_DT3());
	
				LTCStaffingAddPos addPosSW3 = new LTCStaffingAddPos();
				addPosSW3.setConfirmationId(root.getForm().getConfirmationId());
				addPosSW3.setStaffingPlanNum("3");
				addPosSW3.setStaffingHrsPosType(root.getAld_sw_label1());
				addPosSW3.setStaffHrsServiceContractOut(root.getContractedOut_SW3());
				addPosSW3.setStaffHrsLegalNameContractService(root.getProviderName_SW3());
				addPosSW3.setStaffHoursPercentServiceContractOut(root.getPercentageOut_SW3());
	
				LTCStaffingAddPos addPosSLP3 = new LTCStaffingAddPos();
				addPosSLP3.setConfirmationId(root.getForm().getConfirmationId());
				addPosSLP3.setStaffingPlanNum("3");
				addPosSLP3.setStaffingHrsPosType(root.getAld_sp_label1());
				addPosSLP3.setStaffHrsServiceContractOut(root.getContractedOut_SL3());
				addPosSLP3.setStaffHrsLegalNameContractService(root.getProviderName_SL3());
				addPosSLP3.setStaffHoursPercentServiceContractOut(root.getPercentageOut_SL3());
	
				LTCStaffingAddPos addPosRespT3 = new LTCStaffingAddPos();
				addPosRespT3.setConfirmationId(root.getForm().getConfirmationId());
				addPosRespT3.setStaffingPlanNum("3");
				addPosRespT3.setStaffingHrsPosType(root.getAld_rt_label1());
				addPosRespT3.setStaffHrsServiceContractOut(root.getContractedOut_resp3());
				addPosRespT3.setStaffHrsLegalNameContractService(root.getProviderName_resp3());
				addPosRespT3.setStaffHoursPercentServiceContractOut(root.getPercentageOut_resp3());
	
				LTCStaffingAddPos addPosOtherAllied3 = new LTCStaffingAddPos();
				addPosOtherAllied3.setConfirmationId(root.getForm().getConfirmationId());
				addPosOtherAllied3.setStaffingPlanNum("3");
				addPosOtherAllied3.setStaffingHrsPosType("Other Allied Professional");
				addPosOtherAllied3.setStaffHrsServiceContractOut(root.getContractedOut_otherAlliedProf3());
				addPosOtherAllied3.setStaffHrsLegalNameContractService(root.getProviderName_otherAlliedProf3());
				addPosOtherAllied3.setStaffHoursPercentServiceContractOut(root.getPercentageOut_otherAlliedProf3());
	
				LTCStaffingAddPos addPosRT3 = new LTCStaffingAddPos();
				addPosRT3.setConfirmationId(root.getForm().getConfirmationId());
				addPosRT3.setStaffingPlanNum("3");
				addPosRT3.setStaffingHrsPosType(root.getAldnop_rt_label1());
				addPosRT3.setStaffHrsServiceContractOut(root.getContractedOut_RT3());
				addPosRT3.setStaffHrsLegalNameContractService(root.getProviderName_RT3());
				addPosRT3.setStaffHoursPercentServiceContractOut(root.getPercentageOut_RT3());
	
				LTCStaffingAddPos addPosRA3 = new LTCStaffingAddPos();
				addPosRA3.setConfirmationId(root.getForm().getConfirmationId());
				addPosRA3.setStaffingPlanNum("3");
				addPosRA3.setStaffingHrsPosType(root.getAldnop_ra_label1());
				addPosRA3.setStaffHrsServiceContractOut(root.getContractedOut_RA3());
				addPosRA3.setStaffHrsLegalNameContractService(root.getProviderName_RA3());
				addPosRA3.setStaffHoursPercentServiceContractOut(root.getPercentageOut_RA3());
	
				LTCStaffingAddPos addPosAW3 = new LTCStaffingAddPos();
				addPosAW3.setConfirmationId(root.getForm().getConfirmationId());
				addPosAW3.setStaffingPlanNum("3");
				addPosAW3.setStaffingHrsPosType(root.getAldnop_aw_label1());
				addPosAW3.setStaffHrsServiceContractOut(root.getContractedOut_AW3());
				addPosAW3.setStaffHrsLegalNameContractService(root.getProviderName_AW3());
				addPosAW3.setStaffHoursPercentServiceContractOut(root.getPercentageOut_AW3());
	
				LTCStaffingAddPos addPosMT3 = new LTCStaffingAddPos();
				addPosMT3.setConfirmationId(root.getForm().getConfirmationId());
				addPosMT3.setStaffingPlanNum("3");
				addPosMT3.setStaffingHrsPosType(root.getAldnop_mt_label1());
				addPosMT3.setStaffHrsServiceContractOut(root.getContractedOut_MT3());
				addPosMT3.setStaffHrsLegalNameContractService(root.getProviderName_MT3());
				addPosMT3.setStaffHoursPercentServiceContractOut(root.getPercentageOut_MT3());
	
				LTCStaffingAddPos addPosAT3 = new LTCStaffingAddPos();
				addPosAT3.setConfirmationId(root.getForm().getConfirmationId());
				addPosAT3.setStaffingPlanNum("3");
				addPosAT3.setStaffingHrsPosType(root.getAldnop_at_label1());
				addPosAT3.setStaffHrsServiceContractOut(root.getContractedOut_AT3());
				addPosAT3.setStaffHrsLegalNameContractService(root.getProviderName_AT3());
				addPosAT3.setStaffHoursPercentServiceContractOut(root.getPercentageOut_AT3());
	
				LTCStaffingAddPos addPosOtherNpAllied3 = new LTCStaffingAddPos();
				addPosOtherNpAllied3.setConfirmationId(root.getForm().getConfirmationId());
				addPosOtherNpAllied3.setStaffingPlanNum("3");
				addPosOtherNpAllied3.setStaffingHrsPosType("Other Allied Non-Professional");
				addPosOtherNpAllied3.setStaffHrsServiceContractOut(root.getContractedOut_otherAlliedNProf3());
				addPosOtherNpAllied3.setStaffHrsLegalNameContractService(root.getProviderName_otherAlliedNProf3());
				addPosOtherNpAllied3.setStaffHoursPercentServiceContractOut(root.getPercentageOut_otherAlliedNProf3());
	
				Collections.addAll(LTCStaffingAddPos, addPosRN3, addPosLPN3, addPosOtherNurse3, addPosHCA3, addPosOtherNpNurse3,
				addPosOT3, addPosPT3, addPosDT3, addPosSW3, addPosSLP3, addPosRespT3, addPosOtherAllied3, addPosRT3, addPosRA3, 
				addPosAW3, addPosMT3, addPosAT3, addPosOtherNpAllied3);
			}

			if(root.getStaffingPlanType4() != null && !root.getStaffingPlanType4().isEmpty()){
				LTCStaffingAddPos addPosRN4 = new LTCStaffingAddPos();
				addPosRN4.setConfirmationId(root.getForm().getConfirmationId());
				addPosRN4.setStaffingPlanNum("4");
				addPosRN4.setStaffingHrsPosType(root.getRn_label1());
				addPosRN4.setStaffHrsServiceContractOut(root.getContractedOut_RN4());
				addPosRN4.setStaffHrsLegalNameContractService(root.getProviderName_RN4());
				addPosRN4.setStaffHoursPercentServiceContractOut(root.getPercentageOut_RN4());
				
				LTCStaffingAddPos addPosLPN4 = new LTCStaffingAddPos();
				addPosLPN4.setConfirmationId(root.getForm().getConfirmationId());
				addPosLPN4.setStaffingPlanNum("4");
				addPosLPN4.setStaffingHrsPosType(root.getLpn_label1());
				addPosLPN4.setStaffHrsServiceContractOut(root.getContractedOut_LPN4());
				addPosLPN4.setStaffHrsLegalNameContractService(root.getProviderName_LPN4());
				addPosLPN4.setStaffHoursPercentServiceContractOut(root.getPercentageOut_LPN4());
	
				LTCStaffingAddPos addPosOtherNurse4 = new LTCStaffingAddPos();
				addPosOtherNurse4.setConfirmationId(root.getForm().getConfirmationId());
				addPosOtherNurse4.setStaffingPlanNum("4");
				addPosOtherNurse4.setStaffingHrsPosType("Other Nursing Professional");
				addPosOtherNurse4.setStaffHrsServiceContractOut(root.getContractedOut_otherNursingP4());
				addPosOtherNurse4.setStaffHrsLegalNameContractService(root.getProviderName_otherNursingP4());
				addPosOtherNurse4.setStaffHoursPercentServiceContractOut(root.getPercentageOut_otherNursingP4());
	
				LTCStaffingAddPos addPosHCA4 = new LTCStaffingAddPos();
				addPosHCA4.setConfirmationId(root.getForm().getConfirmationId());
				addPosHCA4.setStaffingPlanNum("4");
				addPosHCA4.setStaffingHrsPosType(root.getHca_label1());
				addPosHCA4.setStaffHrsServiceContractOut(root.getContractedOut_HCA4());
				addPosHCA4.setStaffHrsLegalNameContractService(root.getProviderName_HCA24());
				addPosHCA4.setStaffHoursPercentServiceContractOut(root.getPercentageOut_HCA4());
	
				LTCStaffingAddPos addPosOtherNpNurse4 = new LTCStaffingAddPos();
				addPosOtherNpNurse4.setConfirmationId(root.getForm().getConfirmationId());
				addPosOtherNpNurse4.setStaffingPlanNum("4");
				addPosOtherNpNurse4.setStaffingHrsPosType("Other Nursing Non-Professional");
				addPosOtherNpNurse4.setStaffHrsServiceContractOut(root.getContractedOut_otherNursingNP4());
				addPosOtherNpNurse4.setStaffHrsLegalNameContractService(root.getProviderName_otherNursingNP4());
				addPosOtherNpNurse4.setStaffHoursPercentServiceContractOut(root.getPercentageOut_otherNursingNP4());
	
				LTCStaffingAddPos addPosOT4 = new LTCStaffingAddPos();
				addPosOT4.setConfirmationId(root.getForm().getConfirmationId());
				addPosOT4.setStaffingPlanNum("4");
				addPosOT4.setStaffingHrsPosType(root.getAld_ot_label1());
				addPosOT4.setStaffHrsServiceContractOut(root.getContractedOut_OT4());
				addPosOT4.setStaffHrsLegalNameContractService(root.getProviderName_OT4());
				addPosOT4.setStaffHoursPercentServiceContractOut(root.getPercentageOut_OT4());
	
				LTCStaffingAddPos addPosPT4 = new LTCStaffingAddPos();
				addPosPT4.setConfirmationId(root.getForm().getConfirmationId());
				addPosPT4.setStaffingPlanNum("4");
				addPosPT4.setStaffingHrsPosType(root.getAld_pt_label1());
				addPosPT4.setStaffHrsServiceContractOut(root.getContractedOut_PT4());
				addPosPT4.setStaffHrsLegalNameContractService(root.getProviderName_PT4());
				addPosPT4.setStaffHoursPercentServiceContractOut(root.getPercentageOut_PT4());
				
				LTCStaffingAddPos addPosDT4 = new LTCStaffingAddPos();
				addPosDT4.setConfirmationId(root.getForm().getConfirmationId());
				addPosDT4.setStaffingPlanNum("4");
				addPosDT4.setStaffingHrsPosType(root.getAld_dt_label1());
				addPosDT4.setStaffHrsServiceContractOut(root.getContractedOut_DT4());
				addPosDT4.setStaffHrsLegalNameContractService(root.getProviderName_DT4());
				addPosDT4.setStaffHoursPercentServiceContractOut(root.getPercentageOut_DT4());
	
				LTCStaffingAddPos addPosSW4 = new LTCStaffingAddPos();
				addPosSW4.setConfirmationId(root.getForm().getConfirmationId());
				addPosSW4.setStaffingPlanNum("4");
				addPosSW4.setStaffingHrsPosType(root.getAld_sw_label1());
				addPosSW4.setStaffHrsServiceContractOut(root.getContractedOut_SW4());
				addPosSW4.setStaffHrsLegalNameContractService(root.getProviderName_SW4());
				addPosSW4.setStaffHoursPercentServiceContractOut(root.getPercentageOut_SW4());
	
				LTCStaffingAddPos addPosSLP4 = new LTCStaffingAddPos();
				addPosSLP4.setConfirmationId(root.getForm().getConfirmationId());
				addPosSLP4.setStaffingPlanNum("4");
				addPosSLP4.setStaffingHrsPosType(root.getAld_sp_label1());
				addPosSLP4.setStaffHrsServiceContractOut(root.getContractedOut_SL4());
				addPosSLP4.setStaffHrsLegalNameContractService(root.getProviderName_SL4());
				addPosSLP4.setStaffHoursPercentServiceContractOut(root.getPercentageOut_SL4());
	
				LTCStaffingAddPos addPosRespT4 = new LTCStaffingAddPos();
				addPosRespT4.setConfirmationId(root.getForm().getConfirmationId());
				addPosRespT4.setStaffingPlanNum("4");
				addPosRespT4.setStaffingHrsPosType(root.getAld_rt_label1());
				addPosRespT4.setStaffHrsServiceContractOut(root.getContractedOut_resp4());
				addPosRespT4.setStaffHrsLegalNameContractService(root.getProviderName_resp4());
				addPosRespT4.setStaffHoursPercentServiceContractOut(root.getPercentageOut_resp4());
	
				LTCStaffingAddPos addPosOtherAllied4 = new LTCStaffingAddPos();
				addPosOtherAllied4.setConfirmationId(root.getForm().getConfirmationId());
				addPosOtherAllied4.setStaffingPlanNum("4");
				addPosOtherAllied4.setStaffingHrsPosType("Other Allied Professional");
				addPosOtherAllied4.setStaffHrsServiceContractOut(root.getContractedOut_otherAlliedProf4());
				addPosOtherAllied4.setStaffHrsLegalNameContractService(root.getProviderName_otherAlliedProf4());
				addPosOtherAllied4.setStaffHoursPercentServiceContractOut(root.getPercentageOut_otherAlliedProf4());
	
				LTCStaffingAddPos addPosRT4 = new LTCStaffingAddPos();
				addPosRT4.setConfirmationId(root.getForm().getConfirmationId());
				addPosRT4.setStaffingPlanNum("4");
				addPosRT4.setStaffingHrsPosType(root.getAldnop_rt_label1());
				addPosRT4.setStaffHrsServiceContractOut(root.getContractedOut_RT4());
				addPosRT4.setStaffHrsLegalNameContractService(root.getProviderName_RT4());
				addPosRT4.setStaffHoursPercentServiceContractOut(root.getPercentageOut_RT4());
	
				LTCStaffingAddPos addPosRA4 = new LTCStaffingAddPos();
				addPosRA4.setConfirmationId(root.getForm().getConfirmationId());
				addPosRA4.setStaffingPlanNum("4");
				addPosRA4.setStaffingHrsPosType(root.getAldnop_ra_label1());
				addPosRA4.setStaffHrsServiceContractOut(root.getContractedOut_RA4());
				addPosRA4.setStaffHrsLegalNameContractService(root.getProviderName_RA4());
				addPosRA4.setStaffHoursPercentServiceContractOut(root.getPercentageOut_RA4());
	
				LTCStaffingAddPos addPosAW4 = new LTCStaffingAddPos();
				addPosAW4.setConfirmationId(root.getForm().getConfirmationId());
				addPosAW4.setStaffingPlanNum("4");
				addPosAW4.setStaffingHrsPosType(root.getAldnop_aw_label1());
				addPosAW4.setStaffHrsServiceContractOut(root.getContractedOut_AW4());
				addPosAW4.setStaffHrsLegalNameContractService(root.getProviderName_AW4());
				addPosAW4.setStaffHoursPercentServiceContractOut(root.getPercentageOut_AW4());
	
				LTCStaffingAddPos addPosMT4 = new LTCStaffingAddPos();
				addPosMT4.setConfirmationId(root.getForm().getConfirmationId());
				addPosMT4.setStaffingPlanNum("4");
				addPosMT4.setStaffingHrsPosType(root.getAldnop_mt_label1());
				addPosMT4.setStaffHrsServiceContractOut(root.getContractedOut_MT4());
				addPosMT4.setStaffHrsLegalNameContractService(root.getProviderName_MT4());
				addPosMT4.setStaffHoursPercentServiceContractOut(root.getPercentageOut_MT4());
	
				LTCStaffingAddPos addPosAT4 = new LTCStaffingAddPos();
				addPosAT4.setConfirmationId(root.getForm().getConfirmationId());
				addPosAT4.setStaffingPlanNum("4");
				addPosAT4.setStaffingHrsPosType(root.getAldnop_at_label1());
				addPosAT4.setStaffHrsServiceContractOut(root.getContractedOut_AT4());
				addPosAT4.setStaffHrsLegalNameContractService(root.getProviderName_AT4());
				addPosAT4.setStaffHoursPercentServiceContractOut(root.getPercentageOut_AT4());
	
				LTCStaffingAddPos addPosOtherNpAllied4 = new LTCStaffingAddPos();
				addPosOtherNpAllied4.setConfirmationId(root.getForm().getConfirmationId());
				addPosOtherNpAllied4.setStaffingPlanNum("4");
				addPosOtherNpAllied4.setStaffingHrsPosType("Other Allied Non-Professional");
				addPosOtherNpAllied4.setStaffHrsServiceContractOut(root.getContractedOut_otherAlliedNProf4());
				addPosOtherNpAllied4.setStaffHrsLegalNameContractService(root.getProviderName_otherAlliedNProf4());
				addPosOtherNpAllied4.setStaffHoursPercentServiceContractOut(root.getPercentageOut_otherAlliedNProf4());
	
				Collections.addAll(LTCStaffingAddPos, addPosRN4, addPosLPN4, addPosOtherNurse4, addPosHCA4, addPosOtherNpNurse4,
				addPosOT4, addPosPT4, addPosDT4, addPosSW4, addPosSLP4, addPosRespT4, addPosOtherAllied4, addPosRT4, addPosRA4, 
				addPosAW4, addPosMT4, addPosAT4, addPosOtherNpAllied4);
			}

			if(root.getStaffingPlanType5() != null && !root.getStaffingPlanType5().isEmpty()){
				LTCStaffingAddPos addPosRN5 = new LTCStaffingAddPos();
				addPosRN5.setConfirmationId(root.getForm().getConfirmationId());
				addPosRN5.setStaffingPlanNum("5");
				addPosRN5.setStaffingHrsPosType(root.getRn_label1());
				addPosRN5.setStaffHrsServiceContractOut(root.getContractedOut_RN5());
				addPosRN5.setStaffHrsLegalNameContractService(root.getProviderName_RN5());
				addPosRN5.setStaffHoursPercentServiceContractOut(root.getPercentageOut_RN5());
				
				LTCStaffingAddPos addPosLPN5 = new LTCStaffingAddPos();
				addPosLPN5.setConfirmationId(root.getForm().getConfirmationId());
				addPosLPN5.setStaffingPlanNum("5");
				addPosLPN5.setStaffingHrsPosType(root.getLpn_label1());
				addPosLPN5.setStaffHrsServiceContractOut(root.getContractedOut_LPN5());
				addPosLPN5.setStaffHrsLegalNameContractService(root.getProviderName_LPN5());
				addPosLPN5.setStaffHoursPercentServiceContractOut(root.getPercentageOut_LPN5());
	
				LTCStaffingAddPos addPosOtherNurse5 = new LTCStaffingAddPos();
				addPosOtherNurse5.setConfirmationId(root.getForm().getConfirmationId());
				addPosOtherNurse5.setStaffingPlanNum("5");
				addPosOtherNurse5.setStaffingHrsPosType("Other Nursing Professional");
				addPosOtherNurse5.setStaffHrsServiceContractOut(root.getContractedOut_otherNursingP5());
				addPosOtherNurse5.setStaffHrsLegalNameContractService(root.getProviderName_otherNursingP5());
				addPosOtherNurse5.setStaffHoursPercentServiceContractOut(root.getPercentageOut_otherNursingP5());
	
				LTCStaffingAddPos addPosHCA5 = new LTCStaffingAddPos();
				addPosHCA5.setConfirmationId(root.getForm().getConfirmationId());
				addPosHCA5.setStaffingPlanNum("5");
				addPosHCA5.setStaffingHrsPosType(root.getHca_label1());
				addPosHCA5.setStaffHrsServiceContractOut(root.getContractedOut_HCA5());
				addPosHCA5.setStaffHrsLegalNameContractService(root.getProviderName_HCA25());
				addPosHCA5.setStaffHoursPercentServiceContractOut(root.getPercentageOut_HCA5());
	
				LTCStaffingAddPos addPosOtherNpNurse5 = new LTCStaffingAddPos();
				addPosOtherNpNurse5.setConfirmationId(root.getForm().getConfirmationId());
				addPosOtherNpNurse5.setStaffingPlanNum("5");
				addPosOtherNpNurse5.setStaffingHrsPosType("Other Nursing Non-Professional");
				addPosOtherNpNurse5.setStaffHrsServiceContractOut(root.getContractedOut_otherNursingNP5());
				addPosOtherNpNurse5.setStaffHrsLegalNameContractService(root.getProviderName_otherNursingNP5());
				addPosOtherNpNurse5.setStaffHoursPercentServiceContractOut(root.getPercentageOut_otherNursingNP5());
	
				LTCStaffingAddPos addPosOT5 = new LTCStaffingAddPos();
				addPosOT5.setConfirmationId(root.getForm().getConfirmationId());
				addPosOT5.setStaffingPlanNum("5");
				addPosOT5.setStaffingHrsPosType(root.getAld_ot_label1());
				addPosOT5.setStaffHrsServiceContractOut(root.getContractedOut_OT5());
				addPosOT5.setStaffHrsLegalNameContractService(root.getProviderName_OT5());
				addPosOT5.setStaffHoursPercentServiceContractOut(root.getPercentageOut_OT5());
	
				LTCStaffingAddPos addPosPT5 = new LTCStaffingAddPos();
				addPosPT5.setConfirmationId(root.getForm().getConfirmationId());
				addPosPT5.setStaffingPlanNum("5");
				addPosPT5.setStaffingHrsPosType(root.getAld_pt_label1());
				addPosPT5.setStaffHrsServiceContractOut(root.getContractedOut_PT5());
				addPosPT5.setStaffHrsLegalNameContractService(root.getProviderName_PT5());
				addPosPT5.setStaffHoursPercentServiceContractOut(root.getPercentageOut_PT5());
				
				LTCStaffingAddPos addPosDT5 = new LTCStaffingAddPos();
				addPosDT5.setConfirmationId(root.getForm().getConfirmationId());
				addPosDT5.setStaffingPlanNum("5");
				addPosDT5.setStaffingHrsPosType(root.getAld_dt_label1());
				addPosDT5.setStaffHrsServiceContractOut(root.getContractedOut_DT5());
				addPosDT5.setStaffHrsLegalNameContractService(root.getProviderName_DT5());
				addPosDT5.setStaffHoursPercentServiceContractOut(root.getPercentageOut_DT5());
	
				LTCStaffingAddPos addPosSW5 = new LTCStaffingAddPos();
				addPosSW5.setConfirmationId(root.getForm().getConfirmationId());
				addPosSW5.setStaffingPlanNum("5");
				addPosSW5.setStaffingHrsPosType(root.getAld_sw_label1());
				addPosSW5.setStaffHrsServiceContractOut(root.getContractedOut_SW5());
				addPosSW5.setStaffHrsLegalNameContractService(root.getProviderName_SW5());
				addPosSW5.setStaffHoursPercentServiceContractOut(root.getPercentageOut_SW5());
	
				LTCStaffingAddPos addPosSLP5 = new LTCStaffingAddPos();
				addPosSLP5.setConfirmationId(root.getForm().getConfirmationId());
				addPosSLP5.setStaffingPlanNum("5");
				addPosSLP5.setStaffingHrsPosType(root.getAld_sp_label1());
				addPosSLP5.setStaffHrsServiceContractOut(root.getContractedOut_SL5());
				addPosSLP5.setStaffHrsLegalNameContractService(root.getProviderName_SL5());
				addPosSLP5.setStaffHoursPercentServiceContractOut(root.getPercentageOut_SL5());
	
				LTCStaffingAddPos addPosRespT5 = new LTCStaffingAddPos();
				addPosRespT5.setConfirmationId(root.getForm().getConfirmationId());
				addPosRespT5.setStaffingPlanNum("5");
				addPosRespT5.setStaffingHrsPosType(root.getAld_rt_label1());
				addPosRespT5.setStaffHrsServiceContractOut(root.getContractedOut_resp5());
				addPosRespT5.setStaffHrsLegalNameContractService(root.getProviderName_resp5());
				addPosRespT5.setStaffHoursPercentServiceContractOut(root.getPercentageOut_resp5());
	
				LTCStaffingAddPos addPosOtherAllied5 = new LTCStaffingAddPos();
				addPosOtherAllied5.setConfirmationId(root.getForm().getConfirmationId());
				addPosOtherAllied5.setStaffingPlanNum("5");
				addPosOtherAllied5.setStaffingHrsPosType("Other Allied Professional");
				addPosOtherAllied5.setStaffHrsServiceContractOut(root.getContractedOut_otherAlliedProf5());
				addPosOtherAllied5.setStaffHrsLegalNameContractService(root.getProviderName_otherAlliedProf5());
				addPosOtherAllied5.setStaffHoursPercentServiceContractOut(root.getPercentageOut_otherAlliedProf5());
	
				LTCStaffingAddPos addPosRT5 = new LTCStaffingAddPos();
				addPosRT5.setConfirmationId(root.getForm().getConfirmationId());
				addPosRT5.setStaffingPlanNum("5");
				addPosRT5.setStaffingHrsPosType(root.getAldnop_rt_label1());
				addPosRT5.setStaffHrsServiceContractOut(root.getContractedOut_RT5());
				addPosRT5.setStaffHrsLegalNameContractService(root.getProviderName_RT5());
				addPosRT5.setStaffHoursPercentServiceContractOut(root.getPercentageOut_RT5());
	
				LTCStaffingAddPos addPosRA5 = new LTCStaffingAddPos();
				addPosRA5.setConfirmationId(root.getForm().getConfirmationId());
				addPosRA5.setStaffingPlanNum("5");
				addPosRA5.setStaffingHrsPosType(root.getAldnop_ra_label1());
				addPosRA5.setStaffHrsServiceContractOut(root.getContractedOut_RA5());
				addPosRA5.setStaffHrsLegalNameContractService(root.getProviderName_RA5());
				addPosRA5.setStaffHoursPercentServiceContractOut(root.getPercentageOut_RA5());
	
				LTCStaffingAddPos addPosAW5 = new LTCStaffingAddPos();
				addPosAW5.setConfirmationId(root.getForm().getConfirmationId());
				addPosAW5.setStaffingPlanNum("5");
				addPosAW5.setStaffingHrsPosType(root.getAldnop_aw_label1());
				addPosAW5.setStaffHrsServiceContractOut(root.getContractedOut_AW5());
				addPosAW5.setStaffHrsLegalNameContractService(root.getProviderName_AW5());
				addPosAW5.setStaffHoursPercentServiceContractOut(root.getPercentageOut_AW5());
	
				LTCStaffingAddPos addPosMT5 = new LTCStaffingAddPos();
				addPosMT5.setConfirmationId(root.getForm().getConfirmationId());
				addPosMT5.setStaffingPlanNum("5");
				addPosMT5.setStaffingHrsPosType(root.getAldnop_mt_label1());
				addPosMT5.setStaffHrsServiceContractOut(root.getContractedOut_MT5());
				addPosMT5.setStaffHrsLegalNameContractService(root.getProviderName_MT5());
				addPosMT5.setStaffHoursPercentServiceContractOut(root.getPercentageOut_MT5());
	
				LTCStaffingAddPos addPosAT5 = new LTCStaffingAddPos();
				addPosAT5.setConfirmationId(root.getForm().getConfirmationId());
				addPosAT5.setStaffingPlanNum("5");
				addPosAT5.setStaffingHrsPosType(root.getAldnop_at_label1());
				addPosAT5.setStaffHrsServiceContractOut(root.getContractedOut_AT5());
				addPosAT5.setStaffHrsLegalNameContractService(root.getProviderName_AT5());
				addPosAT5.setStaffHoursPercentServiceContractOut(root.getPercentageOut_AT5());
	
				LTCStaffingAddPos addPosOtherNpAllied5 = new LTCStaffingAddPos();
				addPosOtherNpAllied5.setConfirmationId(root.getForm().getConfirmationId());
				addPosOtherNpAllied5.setStaffingPlanNum("5");
				addPosOtherNpAllied5.setStaffingHrsPosType("Other Allied Non-Professional");
				addPosOtherNpAllied5.setStaffHrsServiceContractOut(root.getContractedOut_otherAlliedNProf5());
				addPosOtherNpAllied5.setStaffHrsLegalNameContractService(root.getProviderName_otherAlliedNProf5());
				addPosOtherNpAllied5.setStaffHoursPercentServiceContractOut(root.getPercentageOut_otherAlliedNProf5());
	
				Collections.addAll(LTCStaffingAddPos, addPosRN5, addPosLPN5, addPosOtherNurse5, addPosHCA5, addPosOtherNpNurse5,
				addPosOT5, addPosPT5, addPosDT5, addPosSW5, addPosSLP5, addPosRespT5, addPosOtherAllied5, addPosRT5, addPosRA5, 
				addPosAW5, addPosMT5, addPosAT5, addPosOtherNpAllied5);
			}

			/* Mapping LTC_STAFF_PLAN_SUMMARY_SUBTOTALS */

			LTCStaffPlanSummarySubtotals nursingProfSummary1 = new LTCStaffPlanSummarySubtotals();
			nursingProfSummary1.setConfirmationId(root.getForm().getConfirmationId());
			nursingProfSummary1.setStaffingPlanNum("1");
			nursingProfSummary1.setStaffPlanSumSubtotalType("Nursing Professional");
			nursingProfSummary1.setSumPosAnnual(root.getSummary_annual_nursingP1());
			nursingProfSummary1.setSumPosInHouse(root.getSummary_inHouse_nursingP1());
			nursingProfSummary1.setSumPosContracted(root.getSummary_contracted_nursingP1());

			LTCStaffPlanSummarySubtotals nursingNProfSummary1 = new LTCStaffPlanSummarySubtotals();
			nursingNProfSummary1.setConfirmationId(root.getForm().getConfirmationId());
			nursingNProfSummary1.setStaffingPlanNum("1");
			nursingNProfSummary1.setStaffPlanSumSubtotalType("Nursing Non-Professional");
			nursingNProfSummary1.setSumPosAnnual(root.getSummary_annual_nursingNP1());
			nursingNProfSummary1.setSumPosInHouse(root.getSummary_inHouse_nursingNP1());
			nursingNProfSummary1.setSumPosContracted(root.getSummary_contracted_nursingNP1());

			LTCStaffPlanSummarySubtotals alliedProfSummary1 = new LTCStaffPlanSummarySubtotals();
			alliedProfSummary1.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfSummary1.setStaffingPlanNum("1");
			alliedProfSummary1.setStaffPlanSumSubtotalType("Allied Professional");
			alliedProfSummary1.setSumPosAnnual(root.getSummary_annual_alliedProf1());
			alliedProfSummary1.setSumPosInHouse(root.getSummary_inHouse_alliedProf1());
			alliedProfSummary1.setSumPosContracted(root.getSummary_contracted_alliedProf1());

			LTCStaffPlanSummarySubtotals alliedNProfSummary1 = new LTCStaffPlanSummarySubtotals();
			alliedNProfSummary1.setConfirmationId(root.getForm().getConfirmationId());
			alliedNProfSummary1.setStaffingPlanNum("1");
			alliedNProfSummary1.setStaffPlanSumSubtotalType("Allied Non-Professional");
			alliedNProfSummary1.setSumPosAnnual(root.getSummary_annual_alliedNProf1());
			alliedNProfSummary1.setSumPosInHouse(root.getSummary_inHouse_alliedNProf1());
			alliedNProfSummary1.setSumPosContracted(root.getSummary_contracted_alliedNProf1());

			LTCStaffPlanSummarySubtotals totalSummary1 = new LTCStaffPlanSummarySubtotals();
			totalSummary1.setConfirmationId(root.getForm().getConfirmationId());
			totalSummary1.setStaffingPlanNum("1");
			totalSummary1.setStaffPlanSumSubtotalType("Total");
			totalSummary1.setSumPosAnnual(root.getSummary_annual1());
			totalSummary1.setSumPosInHouse(root.getSummary_inHouse1());
			totalSummary1.setSumPosContracted(root.getSummary_contracted1());

			Collections.addAll(LTCStaffPlanSummarySubtotals, nursingProfSummary1, nursingNProfSummary1, alliedProfSummary1,
				alliedNProfSummary1, totalSummary1);

			if(root.getStaffingPlanType2() != null && !root.getStaffingPlanType2().isEmpty()){
				LTCStaffPlanSummarySubtotals nursingProfSummary2 = new LTCStaffPlanSummarySubtotals();
				nursingProfSummary2.setConfirmationId(root.getForm().getConfirmationId());
				nursingProfSummary2.setStaffingPlanNum("2");
				nursingProfSummary2.setStaffPlanSumSubtotalType("Nursing Professional");
				nursingProfSummary2.setSumPosAnnual(root.getSummary_annual_nursingP2());
				nursingProfSummary2.setSumPosInHouse(root.getSummary_inHouse_nursingP2());
				nursingProfSummary2.setSumPosContracted(root.getSummary_contracted_nursingP2());
	
				LTCStaffPlanSummarySubtotals nursingNProfSummary2 = new LTCStaffPlanSummarySubtotals();
				nursingNProfSummary2.setConfirmationId(root.getForm().getConfirmationId());
				nursingNProfSummary2.setStaffingPlanNum("2");
				nursingNProfSummary2.setStaffPlanSumSubtotalType("Nursing Non-Professional");
				nursingNProfSummary2.setSumPosAnnual(root.getSummary_annual_nursingNP2());
				nursingNProfSummary2.setSumPosInHouse(root.getSummary_inHouse_nursingNP2());
				nursingNProfSummary2.setSumPosContracted(root.getSummary_contracted_nursingNP2());
	
				LTCStaffPlanSummarySubtotals alliedProfSummary2 = new LTCStaffPlanSummarySubtotals();
				alliedProfSummary2.setConfirmationId(root.getForm().getConfirmationId());
				alliedProfSummary2.setStaffingPlanNum("2");
				alliedProfSummary2.setStaffPlanSumSubtotalType("Allied Professional");
				alliedProfSummary2.setSumPosAnnual(root.getSummary_annual_alliedProf2());
				alliedProfSummary2.setSumPosInHouse(root.getSummary_inHouse_alliedProf2());
				alliedProfSummary2.setSumPosContracted(root.getSummary_contracted_alliedProf2());
	
				LTCStaffPlanSummarySubtotals alliedNProfSummary2 = new LTCStaffPlanSummarySubtotals();
				alliedNProfSummary2.setConfirmationId(root.getForm().getConfirmationId());
				alliedNProfSummary2.setStaffingPlanNum("2");
				alliedNProfSummary2.setStaffPlanSumSubtotalType("Allied Non-Professional");
				alliedNProfSummary2.setSumPosAnnual(root.getSummary_annual_alliedNProf2());
				alliedNProfSummary2.setSumPosInHouse(root.getSummary_inHouse_alliedNProf2());
				alliedNProfSummary2.setSumPosContracted(root.getSummary_contracted_alliedNProf2());
	
				LTCStaffPlanSummarySubtotals totalSummary2 = new LTCStaffPlanSummarySubtotals();
				totalSummary2.setConfirmationId(root.getForm().getConfirmationId());
				totalSummary2.setStaffingPlanNum("2");
				totalSummary2.setStaffPlanSumSubtotalType("Total");
				totalSummary2.setSumPosAnnual(root.getSummary_annual2());
				totalSummary2.setSumPosInHouse(root.getSummary_inHouse2());
				totalSummary2.setSumPosContracted(root.getSummary_contracted2());
	
				Collections.addAll(LTCStaffPlanSummarySubtotals, nursingProfSummary2, nursingNProfSummary2, alliedProfSummary2,
					alliedNProfSummary2, totalSummary2);
			}
		
			if(root.getStaffingPlanType3() != null && !root.getStaffingPlanType3().isEmpty()){
				LTCStaffPlanSummarySubtotals nursingProfSummary3 = new LTCStaffPlanSummarySubtotals();
				nursingProfSummary3.setConfirmationId(root.getForm().getConfirmationId());
				nursingProfSummary3.setStaffingPlanNum("3");
				nursingProfSummary3.setStaffPlanSumSubtotalType("Nursing Professional");
				nursingProfSummary3.setSumPosAnnual(root.getSummary_annual_nursingP3());
				nursingProfSummary3.setSumPosInHouse(root.getSummary_inHouse_nursingP3());
				nursingProfSummary3.setSumPosContracted(root.getSummary_contracted_nursingP3());
	
				LTCStaffPlanSummarySubtotals nursingNProfSummary3 = new LTCStaffPlanSummarySubtotals();
				nursingNProfSummary3.setConfirmationId(root.getForm().getConfirmationId());
				nursingNProfSummary3.setStaffingPlanNum("3");
				nursingNProfSummary3.setStaffPlanSumSubtotalType("Nursing Non-Professional");
				nursingNProfSummary3.setSumPosAnnual(root.getSummary_annual_nursingNP3());
				nursingNProfSummary3.setSumPosInHouse(root.getSummary_inHouse_nursingNP3());
				nursingNProfSummary3.setSumPosContracted(root.getSummary_contracted_nursingNP3());
	
				LTCStaffPlanSummarySubtotals alliedProfSummary3 = new LTCStaffPlanSummarySubtotals();
				alliedProfSummary3.setConfirmationId(root.getForm().getConfirmationId());
				alliedProfSummary3.setStaffingPlanNum("3");
				alliedProfSummary3.setStaffPlanSumSubtotalType("Allied Professional");
				alliedProfSummary3.setSumPosAnnual(root.getSummary_annual_alliedProf3());
				alliedProfSummary3.setSumPosInHouse(root.getSummary_inHouse_alliedProf3());
				alliedProfSummary3.setSumPosContracted(root.getSummary_contracted_alliedProf3());
	
				LTCStaffPlanSummarySubtotals alliedNProfSummary3 = new LTCStaffPlanSummarySubtotals();
				alliedNProfSummary3.setConfirmationId(root.getForm().getConfirmationId());
				alliedNProfSummary3.setStaffingPlanNum("3");
				alliedNProfSummary3.setStaffPlanSumSubtotalType("Allied Non-Professional");
				alliedNProfSummary3.setSumPosAnnual(root.getSummary_annual_alliedNProf3());
				alliedNProfSummary3.setSumPosInHouse(root.getSummary_inHouse_alliedNProf3());
				alliedNProfSummary3.setSumPosContracted(root.getSummary_contracted_alliedNProf3());
	
				LTCStaffPlanSummarySubtotals totalSummary3 = new LTCStaffPlanSummarySubtotals();
				totalSummary3.setConfirmationId(root.getForm().getConfirmationId());
				totalSummary3.setStaffingPlanNum("3");
				totalSummary3.setStaffPlanSumSubtotalType("Total");
				totalSummary3.setSumPosAnnual(root.getSummary_annual3());
				totalSummary3.setSumPosInHouse(root.getSummary_inHouse3());
				totalSummary3.setSumPosContracted(root.getSummary_contracted3());
	
				Collections.addAll(LTCStaffPlanSummarySubtotals, nursingProfSummary3, nursingNProfSummary3, alliedProfSummary3,
					alliedNProfSummary3, totalSummary3);
			}

			if(root.getStaffingPlanType4() != null && !root.getStaffingPlanType4().isEmpty()){
				LTCStaffPlanSummarySubtotals nursingProfSummary4 = new LTCStaffPlanSummarySubtotals();
				nursingProfSummary4.setConfirmationId(root.getForm().getConfirmationId());
				nursingProfSummary4.setStaffingPlanNum("4");
				nursingProfSummary4.setStaffPlanSumSubtotalType("Nursing Professional");
				nursingProfSummary4.setSumPosAnnual(root.getSummary_annual_nursingP4());
				nursingProfSummary4.setSumPosInHouse(root.getSummary_inHouse_nursingP4());
				nursingProfSummary4.setSumPosContracted(root.getSummary_contracted_nursingP4());
	
				LTCStaffPlanSummarySubtotals nursingNProfSummary4 = new LTCStaffPlanSummarySubtotals();
				nursingNProfSummary4.setConfirmationId(root.getForm().getConfirmationId());
				nursingNProfSummary4.setStaffingPlanNum("4");
				nursingNProfSummary4.setStaffPlanSumSubtotalType("Nursing Non-Professional");
				nursingNProfSummary4.setSumPosAnnual(root.getSummary_annual_nursingNP4());
				nursingNProfSummary4.setSumPosInHouse(root.getSummary_inHouse_nursingNP4());
				nursingNProfSummary4.setSumPosContracted(root.getSummary_contracted_nursingNP4());
	
				LTCStaffPlanSummarySubtotals alliedProfSummary4 = new LTCStaffPlanSummarySubtotals();
				alliedProfSummary4.setConfirmationId(root.getForm().getConfirmationId());
				alliedProfSummary4.setStaffingPlanNum("4");
				alliedProfSummary4.setStaffPlanSumSubtotalType("Allied Professional");
				alliedProfSummary4.setSumPosAnnual(root.getSummary_annual_alliedProf4());
				alliedProfSummary4.setSumPosInHouse(root.getSummary_inHouse_alliedProf4());
				alliedProfSummary4.setSumPosContracted(root.getSummary_contracted_alliedProf4());
	
				LTCStaffPlanSummarySubtotals alliedNProfSummary4 = new LTCStaffPlanSummarySubtotals();
				alliedNProfSummary4.setConfirmationId(root.getForm().getConfirmationId());
				alliedNProfSummary4.setStaffingPlanNum("4");
				alliedNProfSummary4.setStaffPlanSumSubtotalType("Allied Non-Professional");
				alliedNProfSummary4.setSumPosAnnual(root.getSummary_annual_alliedNProf4());
				alliedNProfSummary4.setSumPosInHouse(root.getSummary_inHouse_alliedNProf4());
				alliedNProfSummary4.setSumPosContracted(root.getSummary_contracted_alliedNProf4());
	
				LTCStaffPlanSummarySubtotals totalSummary4 = new LTCStaffPlanSummarySubtotals();
				totalSummary4.setConfirmationId(root.getForm().getConfirmationId());
				totalSummary4.setStaffingPlanNum("4");
				totalSummary4.setStaffPlanSumSubtotalType("Total");
				totalSummary4.setSumPosAnnual(root.getSummary_annual4());
				totalSummary4.setSumPosInHouse(root.getSummary_inHouse4());
				totalSummary4.setSumPosContracted(root.getSummary_contracted4());
	
				Collections.addAll(LTCStaffPlanSummarySubtotals, nursingProfSummary4, nursingNProfSummary4, alliedProfSummary4,
					alliedNProfSummary4, totalSummary4);
			}

			if(root.getStaffingPlanType5() != null && !root.getStaffingPlanType5().isEmpty()){
				LTCStaffPlanSummarySubtotals nursingProfSummary5 = new LTCStaffPlanSummarySubtotals();
				nursingProfSummary5.setConfirmationId(root.getForm().getConfirmationId());
				nursingProfSummary5.setStaffingPlanNum("5");
				nursingProfSummary5.setStaffPlanSumSubtotalType("Nursing Professional");
				nursingProfSummary5.setSumPosAnnual(root.getSummary_annual_nursingP5());
				nursingProfSummary5.setSumPosInHouse(root.getSummary_inHouse_nursingP5());
				nursingProfSummary5.setSumPosContracted(root.getSummary_contracted_nursingP5());
	
				LTCStaffPlanSummarySubtotals nursingNProfSummary5 = new LTCStaffPlanSummarySubtotals();
				nursingNProfSummary5.setConfirmationId(root.getForm().getConfirmationId());
				nursingNProfSummary5.setStaffingPlanNum("5");
				nursingNProfSummary5.setStaffPlanSumSubtotalType("Nursing Non-Professional");
				nursingNProfSummary5.setSumPosAnnual(root.getSummary_annual_nursingNP5());
				nursingNProfSummary5.setSumPosInHouse(root.getSummary_inHouse_nursingNP5());
				nursingNProfSummary5.setSumPosContracted(root.getSummary_contracted_nursingNP5());
	
				LTCStaffPlanSummarySubtotals alliedProfSummary5 = new LTCStaffPlanSummarySubtotals();
				alliedProfSummary5.setConfirmationId(root.getForm().getConfirmationId());
				alliedProfSummary5.setStaffingPlanNum("5");
				alliedProfSummary5.setStaffPlanSumSubtotalType("Allied Professional");
				alliedProfSummary5.setSumPosAnnual(root.getSummary_annual_alliedProf5());
				alliedProfSummary5.setSumPosInHouse(root.getSummary_inHouse_alliedProf5());
				alliedProfSummary5.setSumPosContracted(root.getSummary_contracted_alliedProf5());
	
				LTCStaffPlanSummarySubtotals alliedNProfSummary5 = new LTCStaffPlanSummarySubtotals();
				alliedNProfSummary5.setConfirmationId(root.getForm().getConfirmationId());
				alliedNProfSummary5.setStaffingPlanNum("5");
				alliedNProfSummary5.setStaffPlanSumSubtotalType("Allied Non-Professional");
				alliedNProfSummary5.setSumPosAnnual(root.getSummary_annual_alliedNProf5());
				alliedNProfSummary5.setSumPosInHouse(root.getSummary_inHouse_alliedNProf5());
				alliedNProfSummary5.setSumPosContracted(root.getSummary_contracted_alliedNProf5());
	
				LTCStaffPlanSummarySubtotals totalSummary5 = new LTCStaffPlanSummarySubtotals();
				totalSummary5.setConfirmationId(root.getForm().getConfirmationId());
				totalSummary5.setStaffingPlanNum("5");
				totalSummary5.setStaffPlanSumSubtotalType("Total");
				totalSummary5.setSumPosAnnual(root.getSummary_annual5());
				totalSummary5.setSumPosInHouse(root.getSummary_inHouse5());
				totalSummary5.setSumPosContracted(root.getSummary_contracted5());
	
				Collections.addAll(LTCStaffPlanSummarySubtotals, nursingProfSummary5, nursingNProfSummary5, alliedProfSummary5,
					alliedNProfSummary5, totalSummary5);
			}


			/* adding all other elements to LTCstaffingPlan */
			lTCstaffingPlanMainEntity.setLTCStaffingPlan(LTCstaffingPlan);
			lTCstaffingPlanMainEntity.setLTCStaffPlanPerf(LTCStaffPlanPerf);
			lTCstaffingPlanMainEntity.setLTCStaffPlanPosSubtotal(LTCStaffPlanPosSubtotal);
			lTCstaffingPlanMainEntity.setLTCStaffPlanPosType(LTCStaffPlanPosType);
			lTCstaffingPlanMainEntity.setLTCStaffingAddPos(LTCStaffingAddPos);
			lTCstaffingPlanMainEntity.setLTCStaffingHrs(LTCStaffingHrs);
			lTCstaffingPlanMainEntity.setLTCStaffPlanSummarySubtotals(LTCStaffPlanSummarySubtotals);

			staffingPlanParsed.add(lTCstaffingPlanMainEntity);
		}
		return staffingPlanParsed;
	}
		
}
