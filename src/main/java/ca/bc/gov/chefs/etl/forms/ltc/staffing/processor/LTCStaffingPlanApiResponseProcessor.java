package ca.bc.gov.chefs.etl.forms.ltc.staffing.processor;
import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

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
				//LTCstaffingPlan2.setPerfOtherSpecify("");
				//LTCstaffingPlan2.setStaffPlanForOther(root.getAdditionalNotes21());

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
