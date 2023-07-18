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
			LTCStaffingPlan1.setPerf_4_1(root.getMinimumRN1());
			LTCStaffingPlan1.setTotalHrsNursMon(root.getNursing_mon_total1());
			LTCStaffingPlan1.setTotalHrsNursTues(root.getNursing_tue_total1());
			LTCStaffingPlan1.setTotalHrsNursWed(root.getNursing_wed_total1());
			LTCStaffingPlan1.setTotalHrsNursThurs(root.getNursing_thu_total1());
			LTCStaffingPlan1.setTotalHrsNursFri(root.getNursing_fri_total1());
			LTCStaffingPlan1.setTotalHrsNursSat(root.getNursing_sat_total1());
			LTCStaffingPlan1.setTotalHrsNursSun(root.getNursing_sun_total1());
			LTCStaffingPlan1.setTotalHrsNursWkTotal(root.getNursing_week_total1());
			LTCStaffingPlan1.setTotalHrsNursAnnual(root.getNursing_annual_total1());
			LTCStaffingPlan1.setHprdTotalNursMon(root.getHPRD_nursing_mon1());
			LTCStaffingPlan1.setHprdTotalNursTues(root.getHPRD_nursing_tue1());
			LTCStaffingPlan1.setHprdTotalNursWed(root.getHPRD_nursing_wed1());
			LTCStaffingPlan1.setHprdTotalNursThurs(root.getHPRD_nursing_thu1());
			LTCStaffingPlan1.setHprdTotalNursFri(root.getHPRD_nursing_fri1());
			LTCStaffingPlan1.setHprdTotalNursSat(root.getHPRD_nursing_sat1());
			LTCStaffingPlan1.setHprdTotalNursSun(root.getHPRD_nursing_sun1());
			LTCStaffingPlan1.setHprdTotalNursWkTotal(root.getHPRD_nursing_total1());
			LTCStaffingPlan1.setHprdTotalAlliedMon(root.getHPRD_allied_mon1());
			LTCStaffingPlan1.setHprdTotalAlliedTues(root.getHPRD_allied_tue1());
			LTCStaffingPlan1.setHprdTotalAlliedWed(root.getHPRD_allied_wed1());
			LTCStaffingPlan1.setHprdTotalAlliedThurs(root.getHPRD_allied_thu1());
			LTCStaffingPlan1.setHprdTotalAlliedFri(root.getHPRD_allied_fri1());
			LTCStaffingPlan1.setHprdTotalAlliedSat(root.getHPRD_allied_sat1());
			LTCStaffingPlan1.setHprdTotalAlliedSun(root.getHPRD_allied_sun1());
			LTCStaffingPlan1.setHprdTotalAlliedWkTotal(root.getHPRD_allied_total1());
			//LTCstaffingPlan1.setPerfOtherSpecify("");
			//LTCstaffingPlan1.setStaffPlanForOther(root.getAdditionalNotes21());

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
				LTCStaffingPlan2.setPerf_4_1(root.getMinimumRN2());
				LTCStaffingPlan2.setTotalHrsNursMon(root.getNursing_mon_total2());
				LTCStaffingPlan2.setTotalHrsNursTues(root.getNursing_tue_total2());
				LTCStaffingPlan2.setTotalHrsNursWed(root.getNursing_wed_total2());
				LTCStaffingPlan2.setTotalHrsNursThurs(root.getNursing_thu_total2());
				LTCStaffingPlan2.setTotalHrsNursFri(root.getNursing_fri_total2());
				LTCStaffingPlan2.setTotalHrsNursSat(root.getNursing_sat_total2());
				LTCStaffingPlan2.setTotalHrsNursSun(root.getNursing_sun_total2());
				LTCStaffingPlan2.setTotalHrsNursWkTotal(root.getNursing_week_total2());
				LTCStaffingPlan2.setTotalHrsNursAnnual(root.getNursing_annual_total2());
				LTCStaffingPlan2.setHprdTotalNursMon(root.getHPRD_nursing_mon2());
				LTCStaffingPlan2.setHprdTotalNursTues(root.getHPRD_nursing_tue2());
				LTCStaffingPlan2.setHprdTotalNursWed(root.getHPRD_nursing_wed2());
				LTCStaffingPlan2.setHprdTotalNursThurs(root.getHPRD_nursing_thu2());
				LTCStaffingPlan2.setHprdTotalNursFri(root.getHPRD_nursing_fri2());
				LTCStaffingPlan2.setHprdTotalNursSat(root.getHPRD_nursing_sat2());
				LTCStaffingPlan2.setHprdTotalNursSun(root.getHPRD_nursing_sun2());
				LTCStaffingPlan2.setHprdTotalNursWkTotal(root.getHPRD_nursing_total2());
				LTCStaffingPlan2.setHprdTotalAlliedMon(root.getHPRD_allied_mon2());
				LTCStaffingPlan2.setHprdTotalAlliedTues(root.getHPRD_allied_tue2());
				LTCStaffingPlan2.setHprdTotalAlliedWed(root.getHPRD_allied_wed2());
				LTCStaffingPlan2.setHprdTotalAlliedThurs(root.getHPRD_allied_thu2());
				LTCStaffingPlan2.setHprdTotalAlliedFri(root.getHPRD_allied_fri2());
				LTCStaffingPlan2.setHprdTotalAlliedSat(root.getHPRD_allied_sat2());
				LTCStaffingPlan2.setHprdTotalAlliedSun(root.getHPRD_allied_sun2());
				LTCStaffingPlan2.setHprdTotalAlliedWkTotal(root.getHPRD_allied_total2());
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
				LTCStaffingPlan3.setPerf_4_1(root.getMinimumRN3());
				LTCStaffingPlan3.setTotalHrsNursMon(root.getNursing_mon_total3());
				LTCStaffingPlan3.setTotalHrsNursTues(root.getNursing_tue_total3());
				LTCStaffingPlan3.setTotalHrsNursWed(root.getNursing_wed_total3());
				LTCStaffingPlan3.setTotalHrsNursThurs(root.getNursing_thu_total3());
				LTCStaffingPlan3.setTotalHrsNursFri(root.getNursing_fri_total3());
				LTCStaffingPlan3.setTotalHrsNursSat(root.getNursing_sat_total3());
				LTCStaffingPlan3.setTotalHrsNursSun(root.getNursing_sun_total3());
				LTCStaffingPlan3.setTotalHrsNursWkTotal(root.getNursing_week_total3());
				LTCStaffingPlan3.setTotalHrsNursAnnual(root.getNursing_annual_total3());
				LTCStaffingPlan3.setHprdTotalNursMon(root.getHPRD_nursing_mon3());
				LTCStaffingPlan3.setHprdTotalNursTues(root.getHPRD_nursing_tue3());
				LTCStaffingPlan3.setHprdTotalNursWed(root.getHPRD_nursing_wed3());
				LTCStaffingPlan3.setHprdTotalNursThurs(root.getHPRD_nursing_thu3());
				LTCStaffingPlan3.setHprdTotalNursFri(root.getHPRD_nursing_fri3());
				LTCStaffingPlan3.setHprdTotalNursSat(root.getHPRD_nursing_sat3());
				LTCStaffingPlan3.setHprdTotalNursSun(root.getHPRD_nursing_sun3());
				LTCStaffingPlan3.setHprdTotalNursWkTotal(root.getHPRD_nursing_total3());
				LTCStaffingPlan3.setHprdTotalAlliedMon(root.getHPRD_allied_mon3());
				LTCStaffingPlan3.setHprdTotalAlliedTues(root.getHPRD_allied_tue3());
				LTCStaffingPlan3.setHprdTotalAlliedWed(root.getHPRD_allied_wed3());
				LTCStaffingPlan3.setHprdTotalAlliedThurs(root.getHPRD_allied_thu3());
				LTCStaffingPlan3.setHprdTotalAlliedFri(root.getHPRD_allied_fri3());
				LTCStaffingPlan3.setHprdTotalAlliedSat(root.getHPRD_allied_sat3());
				LTCStaffingPlan3.setHprdTotalAlliedSun(root.getHPRD_allied_sun3());
				LTCStaffingPlan3.setHprdTotalAlliedWkTotal(root.getHPRD_allied_total3());
				//LTCstaffingPlan3.setPerfOtherSpecify("");
				//LTCstaffingPlan3.setStaffPlanForOther(root.getAdditionalNotes21());

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
				LTCStaffingPlan4.setPerf_4_1(root.getMinimumRN4());
				LTCStaffingPlan4.setTotalHrsNursMon(root.getNursing_mon_total4());
				LTCStaffingPlan4.setTotalHrsNursTues(root.getNursing_tue_total4());
				LTCStaffingPlan4.setTotalHrsNursWed(root.getNursing_wed_total4());
				LTCStaffingPlan4.setTotalHrsNursThurs(root.getNursing_thu_total4());
				LTCStaffingPlan4.setTotalHrsNursFri(root.getNursing_fri_total4());
				LTCStaffingPlan4.setTotalHrsNursSat(root.getNursing_sat_total4());
				LTCStaffingPlan4.setTotalHrsNursSun(root.getNursing_sun_total4());
				LTCStaffingPlan4.setTotalHrsNursWkTotal(root.getNursing_week_total4());
				LTCStaffingPlan4.setTotalHrsNursAnnual(root.getNursing_annual_total4());
				LTCStaffingPlan4.setHprdTotalNursMon(root.getHPRD_nursing_mon4());
				LTCStaffingPlan4.setHprdTotalNursTues(root.getHPRD_nursing_tue4());
				LTCStaffingPlan4.setHprdTotalNursWed(root.getHPRD_nursing_wed4());
				LTCStaffingPlan4.setHprdTotalNursThurs(root.getHPRD_nursing_thu4());
				LTCStaffingPlan4.setHprdTotalNursFri(root.getHPRD_nursing_fri4());
				LTCStaffingPlan4.setHprdTotalNursSat(root.getHPRD_nursing_sat4());
				LTCStaffingPlan4.setHprdTotalNursSun(root.getHPRD_nursing_sun4());
				LTCStaffingPlan4.setHprdTotalNursWkTotal(root.getHPRD_nursing_total4());
				LTCStaffingPlan4.setHprdTotalAlliedMon(root.getHPRD_allied_mon4());
				LTCStaffingPlan4.setHprdTotalAlliedTues(root.getHPRD_allied_tue4());
				LTCStaffingPlan4.setHprdTotalAlliedWed(root.getHPRD_allied_wed4());
				LTCStaffingPlan4.setHprdTotalAlliedThurs(root.getHPRD_allied_thu4());
				LTCStaffingPlan4.setHprdTotalAlliedFri(root.getHPRD_allied_fri4());
				LTCStaffingPlan4.setHprdTotalAlliedSat(root.getHPRD_allied_sat4());
				LTCStaffingPlan4.setHprdTotalAlliedSun(root.getHPRD_allied_sun4());
				LTCStaffingPlan4.setHprdTotalAlliedWkTotal(root.getHPRD_allied_total4());
				//LTCstaffingPlan4.setPerfOtherSpecify("");
				//LTCstaffingPlan4.setStaffPlanForOther(root.getAdditionalNotes21());
				
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
				LTCStaffingPlan5.setPerf_4_1(root.getMinimumRN5());
				LTCStaffingPlan5.setTotalHrsNursMon(root.getNursing_mon_total5());
				LTCStaffingPlan5.setTotalHrsNursTues(root.getNursing_tue_total5());
				LTCStaffingPlan5.setTotalHrsNursWed(root.getNursing_wed_total5());
				LTCStaffingPlan5.setTotalHrsNursThurs(root.getNursing_thu_total5());
				LTCStaffingPlan5.setTotalHrsNursFri(root.getNursing_fri_total5());
				LTCStaffingPlan5.setTotalHrsNursSat(root.getNursing_sat_total5());
				LTCStaffingPlan5.setTotalHrsNursSun(root.getNursing_sun_total5());
				LTCStaffingPlan5.setTotalHrsNursWkTotal(root.getNursing_week_total5());
				LTCStaffingPlan5.setTotalHrsNursAnnual(root.getNursing_annual_total5());
				LTCStaffingPlan5.setHprdTotalNursMon(root.getHPRD_nursing_mon5());
				LTCStaffingPlan5.setHprdTotalNursTues(root.getHPRD_nursing_tue5());
				LTCStaffingPlan5.setHprdTotalNursWed(root.getHPRD_nursing_wed5());
				LTCStaffingPlan5.setHprdTotalNursThurs(root.getHPRD_nursing_thu5());
				LTCStaffingPlan5.setHprdTotalNursFri(root.getHPRD_nursing_fri5());
				LTCStaffingPlan5.setHprdTotalNursSat(root.getHPRD_nursing_sat5());
				LTCStaffingPlan5.setHprdTotalNursSun(root.getHPRD_nursing_sun5());
				LTCStaffingPlan5.setHprdTotalNursWkTotal(root.getHPRD_nursing_total5());
				LTCStaffingPlan5.setHprdTotalAlliedMon(root.getHPRD_allied_mon5());
				LTCStaffingPlan5.setHprdTotalAlliedTues(root.getHPRD_allied_tue5());
				LTCStaffingPlan5.setHprdTotalAlliedWed(root.getHPRD_allied_wed5());
				LTCStaffingPlan5.setHprdTotalAlliedThurs(root.getHPRD_allied_thu5());
				LTCStaffingPlan5.setHprdTotalAlliedFri(root.getHPRD_allied_fri5());
				LTCStaffingPlan5.setHprdTotalAlliedSat(root.getHPRD_allied_sat5());
				LTCStaffingPlan5.setHprdTotalAlliedSun(root.getHPRD_allied_sun5());
				LTCStaffingPlan5.setHprdTotalAlliedWkTotal(root.getHPRD_allied_total5());
				//LTCstaffingPlan5.setPerfOtherSpecify("");
				//LTCstaffingPlan5.setStaffPlanForOther(root.getAdditionalNotes21());
	
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
			lTCstaffingPlanMainEntity.setLTCStaffPlanPosType(LTCStaffPlanPosType);
			lTCstaffingPlanMainEntity.setLTCStaffingAddPos(LTCStaffingAddPos);
			lTCstaffingPlanMainEntity.setLTCStaffingHrs(LTCStaffingHrs);

			staffingPlanParsed.add(lTCstaffingPlanMainEntity);
		}
		return staffingPlanParsed;
	}
		
}
