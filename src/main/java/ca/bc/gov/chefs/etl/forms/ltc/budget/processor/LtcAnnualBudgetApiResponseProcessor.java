package ca.bc.gov.chefs.etl.forms.ltc.budget.processor;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.forms.ltc.budget.json.Root;
import ca.bc.gov.chefs.etl.forms.ltc.budget.model.LtcBudgetCompAddPos;
import ca.bc.gov.chefs.etl.forms.ltc.budget.model.LtcBudgetCompBenefits;
import ca.bc.gov.chefs.etl.forms.ltc.budget.model.LtcBudgetCompHrs;
import ca.bc.gov.chefs.etl.forms.ltc.budget.model.LtcBudgetCompHrsSubtotals;
import ca.bc.gov.chefs.etl.forms.ltc.budget.model.LtcBudgetCompHrsTotals;
import ca.bc.gov.chefs.etl.forms.ltc.budget.model.LtcBudgetCompSal;
import ca.bc.gov.chefs.etl.forms.ltc.budget.model.LtcBudgetCompSalSubtotals;
import ca.bc.gov.chefs.etl.forms.ltc.budget.model.LtcBudgetCompSalTotals;
import ca.bc.gov.chefs.etl.forms.ltc.budget.model.LtcBudgetDep;
import ca.bc.gov.chefs.etl.forms.ltc.budget.model.LtcBudgetDepSubTotals;
import ca.bc.gov.chefs.etl.forms.ltc.budget.model.LtcBudgetDirectCareCost;
import ca.bc.gov.chefs.etl.forms.ltc.budget.model.LtcBudgetDirectCareCostSubtotals;
import ca.bc.gov.chefs.etl.forms.ltc.budget.model.LtcBudgetDirectCareHrs;
import ca.bc.gov.chefs.etl.forms.ltc.budget.model.LtcBudgetDirectCareHrsSubTotals;
import ca.bc.gov.chefs.etl.forms.ltc.budget.model.LtcBudgetExp;
import ca.bc.gov.chefs.etl.forms.ltc.budget.model.LtcBudgetExpTotals;
import ca.bc.gov.chefs.etl.forms.ltc.budget.model.LtcBudgetRev;
import ca.bc.gov.chefs.etl.forms.ltc.budget.model.LtcBudgetRevTotals;
import ca.bc.gov.chefs.etl.forms.ltc.budget.model.LtcBudgetSubmission;
import ca.bc.gov.chefs.etl.forms.ltc.budget.model.LtcBudgetSumTotals;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class LtcAnnualBudgetApiResponseProcessor implements Processor {

	
	@Override
	@SuppressWarnings("unchecked")
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		payload = JsonUtil.preProcess(payload);
		payload = JsonUtil.roundDigitsNumber(payload);
		ObjectMapper mapper = new ObjectMapper();
		List<Root> ltcBudgetForms = mapper.readValue(payload, new TypeReference<List<Root>>() {
		});
		List<LtcBudgetSubmission> parsedLtycBudgetSubmissions = parseBudgetQuarterlyRequest(ltcBudgetForms);
		List<IModel> iModels =  (List<IModel>)(List<?>) parsedLtycBudgetSubmissions;
		Map<String,List<List<String>>> map = CSVUtil.provider(iModels);
		boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map,Constants.LTC_QUARTERLY_DIR, isHeaderAdded);
		//TODO uncomment or remove dead code
		// SuccessResponse successResponse = new SuccessResponse();
		// successResponse.setFiles(filesGenerated);
		// exchange.getIn().setBody(mapper.writeValueAsString(successResponse));

		
	}

	private List<LtcBudgetSubmission> parseBudgetQuarterlyRequest(List<Root> ltcQuarterlyBudgetSubmissions) {
		List<LtcBudgetSubmission> ltcBudgetSubmissions = new ArrayList<>();
		for (Root root : ltcQuarterlyBudgetSubmissions) {
			LtcBudgetSubmission ltcBudgetSubmission = new LtcBudgetSubmission();
			List<LtcBudgetDirectCareHrs> ltcBudgetDcHrs = new ArrayList<>();
			List<LtcBudgetDirectCareHrsSubTotals> ltcBudgetDcHrsSubttls = new ArrayList<>();
			List<LtcBudgetDirectCareCost> ltcBudgetDcCost = new ArrayList<>();
			List<LtcBudgetDirectCareCostSubtotals> ltcBudgetDcCostSubttls = new ArrayList<>();
			List<LtcBudgetCompSal> ltcBudgetCompSal = new ArrayList<>();
			List<LtcBudgetCompSalSubtotals> ltcBudgetCompSalSubttls = new ArrayList<>();
			List<LtcBudgetCompSalTotals> ltcBudgetCompsalTtls = new ArrayList<>();
			List<LtcBudgetCompHrs> ltcBudgetCompHrs = new ArrayList<>();
			List<LtcBudgetCompHrsSubtotals> ltcBudgetCompHrsSubttls = new ArrayList<>();
			List<LtcBudgetCompHrsTotals> ltcBudgetCompHrsTtls = new ArrayList<>();
			List<LtcBudgetCompAddPos> ltcBudgetCompAddPos = new ArrayList<>();
			List<LtcBudgetCompBenefits> ltcBudgetCompBenefits = new ArrayList<>();
			List<LtcBudgetRev> ltcBudgetRev = new ArrayList<>();
			List<LtcBudgetRevTotals> ltcBudgetRevSubTtls = new ArrayList<LtcBudgetRevTotals>();
			List<LtcBudgetExpTotals> ltcBudgetExpSubttls = new ArrayList<LtcBudgetExpTotals>();
			List<LtcBudgetExp> ltcBudgetExp = new ArrayList<>();
			List<LtcBudgetDep> ltcBudgetDep = new ArrayList<>();
			List<LtcBudgetDepSubTotals> ltcBudgetDepSubTotals = new ArrayList<>();
			List<LtcBudgetSumTotals> ltcBudgetSumTotals = new ArrayList<>();

			/* Form Meta */
			ltcBudgetSubmission.setConfirmationId(root.getForm().getConfirmationId());
			ltcBudgetSubmission.setIsDeleted(String.valueOf(root.getForm().isDeleted()));
			ltcBudgetSubmission.setSubmissionDate(root.getForm().getCreatedAt());
			ltcBudgetSubmission.setSubmittedBy(root.getForm().getFullName());
			ltcBudgetSubmission.setCCIMSID(root.getCcimsid());
			ltcBudgetSubmission.setSubmissionType(root.getSubmission());
			ltcBudgetSubmission.setPeriod(root.getQuarter());
			ltcBudgetSubmission.setSubmissionFy(root.getFiscalYear());
			ltcBudgetSubmission.setNbTotalBeds(root.getNumberOfTotalBeds());
			ltcBudgetSubmission.setNbFundedBeds(root.getNumberOfTotalFundedBeds());
			ltcBudgetSubmission.setOccRateThreshold(root.getThreshold());
			ltcBudgetSubmission.setTotalSalariesWages(root.getbTotal_YTDSalaryWage());
			ltcBudgetSubmission.setTotalBenefits(root.getBenefit_value_total());
			ltcBudgetSubmission.setBenefitsPercent(root.getbTotal_value_sum());
			ltcBudgetSubmission.setTotalVacancies(root.getNursingNVP_sum11());
			
			/* START : Direct Care Hours */
			/* Productive and NP Nursing */ // why no subtotal and total?
			LtcBudgetDirectCareHrs nursingRNProdH = new LtcBudgetDirectCareHrs();
			nursingRNProdH.setDirCareProdHrsRegBudget(root.getNursingProdH_item11());
			nursingRNProdH.setDirCareProdHrsOtBudget(root.getNursingProdH_item21());
			nursingRNProdH.setDirCareProdHrsOrientationBudget(root.getNursingProdH_item31());
			nursingRNProdH.setDirCareProdHrsContractedBudget(root.getNursingProdHCS1());
			nursingRNProdH.setDirCareNonProdHrsVacBudget(root.getNursingNProdH_item11());
			nursingRNProdH.setDirCareNonProdHrsSickBudget(root.getNursingNProdH_item21());
			nursingRNProdH.setDirCareNonProdHrsOtherBudget(root.getNursingNProdH_item31());
			nursingRNProdH.setConfirmationId(root.getForm().getConfirmationId());
			nursingRNProdH.setDirCareType(root.getNursing_label());
			nursingRNProdH.setDirCareName(root.getNursing_label1());
			nursingRNProdH.setDirCareProdHrsSubtotalBudget(root.getNursingProdH_calc1());
			nursingRNProdH.setDirCareProdHrsTotalBudget(root.getNursingProdH_sub1());
			nursingRNProdH.setDirCareTotalHrsPaidBudget(root.getNursingNProdH_THP1());
			nursingRNProdH.setDirCareNonProdHrsTotalBudget(root.getNursingNProdH_calc1());
			nursingRNProdH.setDirCareProdHrsAgencyStuffUtilBudget(root.getNursingProdHASU1());

			LtcBudgetDirectCareHrs nursingLPNProdH = new LtcBudgetDirectCareHrs();
			nursingLPNProdH.setDirCareProdHrsRegBudget(root.getNursingProdH_item12());
			nursingLPNProdH.setDirCareProdHrsOtBudget(root.getNursingProdH_item22());
			nursingLPNProdH.setDirCareProdHrsOrientationBudget(root.getNursingProdH_item32());
			nursingLPNProdH.setDirCareProdHrsContractedBudget(root.getNursingProdHCS2());
			nursingLPNProdH.setDirCareNonProdHrsVacBudget(root.getNursingNProdH_item12());
			nursingLPNProdH.setDirCareNonProdHrsSickBudget(root.getNursingNProdH_item22());
			nursingLPNProdH.setDirCareNonProdHrsOtherBudget(root.getNursingNProdH_item32());
			nursingLPNProdH.setConfirmationId(root.getForm().getConfirmationId());
			nursingLPNProdH.setDirCareType(root.getNursing_label());
			nursingLPNProdH.setDirCareName(root.getNursing_label2());
			nursingLPNProdH.setDirCareProdHrsSubtotalBudget(root.getNursingProdH_calc2());
			nursingLPNProdH.setDirCareProdHrsTotalBudget(root.getNursingProdH_sub2());
			nursingLPNProdH.setDirCareTotalHrsPaidBudget(root.getNursingNProdH_THP2());
			nursingLPNProdH.setDirCareNonProdHrsTotalBudget(root.getNursingNProdH_calc2());
			nursingLPNProdH.setDirCareProdHrsAgencyStuffUtilBudget(root.getNursingProdHASU2());


			
			LtcBudgetDirectCareHrs nursingHCAProdH = new LtcBudgetDirectCareHrs();
			nursingHCAProdH.setDirCareProdHrsRegBudget(root.getNursingProdH_item13());
			nursingHCAProdH.setDirCareProdHrsOtBudget(root.getNursingProdH_item23());
			nursingHCAProdH.setDirCareProdHrsOrientationBudget(root.getNursingProdH_item33());
			nursingHCAProdH.setDirCareProdHrsContractedBudget(root.getNursingProdHCS3());
			nursingHCAProdH.setDirCareNonProdHrsVacBudget(root.getNursingNProdH_item13());
			nursingHCAProdH.setDirCareNonProdHrsSickBudget(root.getNursingNProdH_item23());
			nursingHCAProdH.setDirCareNonProdHrsOtherBudget(root.getNursingNProdH_item33());
			nursingHCAProdH.setConfirmationId(root.getForm().getConfirmationId());
			nursingHCAProdH.setDirCareType(root.getNursing_label());
			nursingHCAProdH.setDirCareName(root.getNursing_label3());
			nursingHCAProdH.setDirCareProdHrsSubtotalBudget(root.getNursingProdH_calc3());
			nursingHCAProdH.setDirCareProdHrsTotalBudget(root.getNursingProdH_sub3());
			nursingHCAProdH.setDirCareTotalHrsPaidBudget(root.getNursingNProdH_THP3());
			nursingHCAProdH.setDirCareNonProdHrsTotalBudget(root.getNursingNProdH_calc3());
			nursingHCAProdH.setDirCareProdHrsAgencyStuffUtilBudget(root.getNursingProdHASU3());

			LtcBudgetDirectCareHrs nursingOthProdH = new LtcBudgetDirectCareHrs();
			nursingOthProdH.setDirCareProdHrsRegBudget(root.getNursingProdH_item14());
			nursingOthProdH.setDirCareProdHrsOtBudget(root.getNursingProdH_item24());
			nursingOthProdH.setDirCareProdHrsOrientationBudget(root.getNursingProdH_item34());
			nursingOthProdH.setDirCareProdHrsContractedBudget(root.getNursingProdHCS4());
			nursingOthProdH.setDirCareNonProdHrsVacBudget(root.getNursingNProdH_item14());
			nursingOthProdH.setDirCareNonProdHrsSickBudget(root.getNursingNProdH_item24());
			nursingOthProdH.setDirCareNonProdHrsOtherBudget(root.getNursingNProdH_item34());
			nursingOthProdH.setConfirmationId(root.getForm().getConfirmationId());
			nursingOthProdH.setDirCareType(root.getNursing_label());
			nursingOthProdH.setDirCareName(Constants.DC_HRS_OTHER);
			nursingOthProdH.setDirCareProdHrsSubtotalBudget(root.getNursingProdH_calc4());
			nursingOthProdH.setDirCareProdHrsTotalBudget(root.getNursingProdH_sub4());
			nursingOthProdH.setDirCareTotalHrsPaidBudget(root.getNursingNProdH_THP4());
			nursingOthProdH.setDirCareNonProdHrsTotalBudget(root.getNursingNProdH_calc4());
			nursingOthProdH.setDirCareOtherValue(root.getNursing_label4());
			nursingOthProdH.setDirCareProdHrsAgencyStuffUtilBudget(root.getNursingProdHASU4());

			// to check what is with the subtotal fields

			/* Productive and NP Allied Prof */
			LtcBudgetDirectCareHrs alliedOTProfH = new LtcBudgetDirectCareHrs();
			alliedOTProfH.setDirCareProdHrsRegBudget(root.getAlliedProfProdH_item11());
			alliedOTProfH.setDirCareProdHrsOtBudget(root.getAlliedProfProdH_item21());
			alliedOTProfH.setDirCareProdHrsOrientationBudget(root.getAlliedProfProdH_item31());
			alliedOTProfH.setDirCareProdHrsContractedBudget(root.getAlliedProfProdHCS1());
			alliedOTProfH.setDirCareNonProdHrsVacBudget(root.getAlliedProfNProdH_item11());
			alliedOTProfH.setDirCareNonProdHrsSickBudget(root.getAlliedProfNProdH_item21());
			alliedOTProfH.setDirCareNonProdHrsOtherBudget(root.getAlliedProfNProdH_item31());
			alliedOTProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedOTProfH.setDirCareType(root.getAlliedProf_label());
			alliedOTProfH.setDirCareName(root.getAlliedProf_label1());
			alliedOTProfH.setDirCareProdHrsSubtotalBudget(root.getAlliedProfProdH_calc1());
			alliedOTProfH.setDirCareProdHrsTotalBudget(root.getAlliedProfProdH_sub1());
			alliedOTProfH.setDirCareTotalHrsPaidBudget(root.getAlliedProfNProdH_THP1());
			alliedOTProfH.setDirCareNonProdHrsTotalBudget(root.getAlliedProfNProdH_calc1());


			LtcBudgetDirectCareHrs alliedPTProfH = new LtcBudgetDirectCareHrs();
			alliedPTProfH.setDirCareProdHrsRegBudget(root.getAlliedProfProdH_item12());
			alliedPTProfH.setDirCareProdHrsOtBudget(root.getAlliedProfProdH_item22());
			alliedPTProfH.setDirCareProdHrsOrientationBudget(root.getAlliedProfProdH_item32());
			alliedPTProfH.setDirCareProdHrsContractedBudget(root.getAlliedProfProdHCS2());
			alliedPTProfH.setDirCareNonProdHrsVacBudget(root.getAlliedProfNProdH_item12());
			alliedPTProfH.setDirCareNonProdHrsSickBudget(root.getAlliedProfNProdH_item22());
			alliedPTProfH.setDirCareNonProdHrsOtherBudget(root.getAlliedProfNProdH_item32());
			alliedPTProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedPTProfH.setDirCareType(root.getAlliedProf_label());
			alliedPTProfH.setDirCareName(root.getAlliedProf_label2());
			alliedPTProfH.setDirCareProdHrsSubtotalBudget(root.getAlliedProfProdH_calc2());
			alliedPTProfH.setDirCareProdHrsTotalBudget(root.getAlliedProfProdH_sub2());
			alliedPTProfH.setDirCareTotalHrsPaidBudget(root.getAlliedProfNProdH_THP2());
			alliedPTProfH.setDirCareNonProdHrsTotalBudget(root.getAlliedProfNProdH_calc2());

			LtcBudgetDirectCareHrs alliedDTProfH = new LtcBudgetDirectCareHrs();
			alliedDTProfH.setDirCareProdHrsRegBudget(root.getAlliedProfProdH_item13());
			alliedDTProfH.setDirCareProdHrsOtBudget(root.getAlliedProfProdH_item23());
			alliedDTProfH.setDirCareProdHrsOrientationBudget(root.getAlliedProfProdH_item33());
			alliedDTProfH.setDirCareProdHrsContractedBudget(root.getAlliedProfProdHCS3());
			alliedDTProfH.setDirCareNonProdHrsVacBudget(root.getAlliedProfNProdH_item13());
			alliedDTProfH.setDirCareNonProdHrsSickBudget(root.getAlliedProfNProdH_item23());
			alliedDTProfH.setDirCareNonProdHrsOtherBudget(root.getAlliedProfNProdH_item33());
			alliedDTProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedDTProfH.setDirCareType(root.getAlliedProf_label());
			alliedDTProfH.setDirCareName(root.getAlliedProf_label3());
			alliedDTProfH.setDirCareProdHrsSubtotalBudget(root.getAlliedProfProdH_calc3());
			alliedDTProfH.setDirCareProdHrsTotalBudget(root.getAlliedProfProdH_sub3());
			alliedDTProfH.setDirCareTotalHrsPaidBudget(root.getAlliedProfNProdH_THP3());
			alliedDTProfH.setDirCareNonProdHrsTotalBudget(root.getAlliedProfNProdH_calc3());


			LtcBudgetDirectCareHrs alliedSWProfH = new LtcBudgetDirectCareHrs();
			alliedSWProfH.setDirCareProdHrsRegBudget(root.getAlliedProfProdH_item14());
			alliedSWProfH.setDirCareProdHrsOtBudget(root.getAlliedProfProdH_item24());
			alliedSWProfH.setDirCareProdHrsOrientationBudget(root.getAlliedProfProdH_item34());
			alliedSWProfH.setDirCareProdHrsContractedBudget(root.getAlliedProfProdHCS4());
			alliedSWProfH.setDirCareNonProdHrsVacBudget(root.getAlliedProfNProdH_item14());
			alliedSWProfH.setDirCareNonProdHrsSickBudget(root.getAlliedProfNProdH_item24());
			alliedSWProfH.setDirCareNonProdHrsOtherBudget(root.getAlliedProfNProdH_item34());
			alliedSWProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedSWProfH.setDirCareType(root.getAlliedProf_label());
			alliedSWProfH.setDirCareName(root.getAlliedProf_label4());
			alliedSWProfH.setDirCareProdHrsSubtotalBudget(root.getAlliedProfProdH_calc4());
			alliedSWProfH.setDirCareProdHrsTotalBudget(root.getAlliedProfProdH_sub4());
			alliedSWProfH.setDirCareTotalHrsPaidBudget(root.getAlliedProfNProdH_THP4());
			alliedSWProfH.setDirCareNonProdHrsTotalBudget(root.getAlliedProfNProdH_calc4());

			LtcBudgetDirectCareHrs alliedSLPProfH = new LtcBudgetDirectCareHrs();
			alliedSLPProfH.setDirCareProdHrsRegBudget(root.getAlliedProfProdH_item15());
			alliedSLPProfH.setDirCareProdHrsOtBudget(root.getAlliedProfProdH_item25());
			alliedSLPProfH.setDirCareProdHrsOrientationBudget(root.getAlliedProfProdH_item35());
			alliedSLPProfH.setDirCareProdHrsContractedBudget(root.getAlliedProfProdHCS5());
			alliedSLPProfH.setDirCareNonProdHrsVacBudget(root.getAlliedProfNProdH_item15());
			alliedSLPProfH.setDirCareNonProdHrsSickBudget(root.getAlliedProfNProdH_item25());
			alliedSLPProfH.setDirCareNonProdHrsOtherBudget(root.getAlliedProfNProdH_item35());
			alliedSLPProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedSLPProfH.setDirCareType(root.getAlliedProf_label());
			alliedSLPProfH.setDirCareName(root.getAlliedProf_label5());
			alliedSLPProfH.setDirCareProdHrsSubtotalBudget(root.getAlliedProfProdH_calc5());
			alliedSLPProfH.setDirCareProdHrsTotalBudget(root.getAlliedProfProdH_sub5());
			alliedSLPProfH.setDirCareTotalHrsPaidBudget(root.getAlliedProfNProdH_THP5());
			alliedSLPProfH.setDirCareNonProdHrsTotalBudget(root.getAlliedProfNProdH_calc5());

			LtcBudgetDirectCareHrs alliedRTProfH = new LtcBudgetDirectCareHrs();
			alliedRTProfH.setDirCareProdHrsRegBudget(root.getAlliedProfProdH_item16());
			alliedRTProfH.setDirCareProdHrsOtBudget(root.getAlliedProfProdH_item26());
			alliedRTProfH.setDirCareProdHrsOrientationBudget(root.getAlliedProfProdH_item36());
			alliedRTProfH.setDirCareProdHrsContractedBudget(root.getAlliedProfProdHCS6());
			alliedRTProfH.setDirCareNonProdHrsVacBudget(root.getAlliedProfNProdH_item16());
			alliedRTProfH.setDirCareNonProdHrsSickBudget(root.getAlliedProfNProdH_item26());
			alliedRTProfH.setDirCareNonProdHrsOtherBudget(root.getAlliedProfNProdH_item36());
			alliedRTProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedRTProfH.setDirCareType(root.getAlliedProf_label());
			alliedRTProfH.setDirCareName(root.getAlliedProf_label6());
			alliedRTProfH.setDirCareProdHrsSubtotalBudget(root.getAlliedProfProdH_calc6());
			alliedRTProfH.setDirCareProdHrsTotalBudget(root.getAlliedProfProdH_sub6());
			alliedRTProfH.setDirCareTotalHrsPaidBudget(root.getAlliedProfNProdH_THP6());
			alliedRTProfH.setDirCareNonProdHrsTotalBudget(root.getAlliedProfNProdH_calc6());
			
			LtcBudgetDirectCareHrs alliedOTHProfH = new LtcBudgetDirectCareHrs();
			alliedOTHProfH.setDirCareProdHrsRegBudget(root.getAlliedProfProdH_item17());
			alliedOTHProfH.setDirCareProdHrsOtBudget(root.getAlliedProfProdH_item27());
			alliedOTHProfH.setDirCareProdHrsOrientationBudget(root.getAlliedProfProdH_item37());
			alliedOTHProfH.setDirCareProdHrsContractedBudget(root.getAlliedProfProdHCS7());
			alliedOTHProfH.setDirCareNonProdHrsVacBudget(root.getAlliedProfNProdH_item17());
			alliedOTHProfH.setDirCareNonProdHrsSickBudget(root.getAlliedProfNProdH_item27());
			alliedOTHProfH.setDirCareNonProdHrsOtherBudget(root.getAlliedProfNProdH_item37());
			alliedOTHProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedOTHProfH.setDirCareType(root.getAlliedProf_label());
			alliedOTHProfH.setDirCareName(Constants.DC_HRS_OTHER);
			alliedOTHProfH.setDirCareProdHrsSubtotalBudget(root.getAlliedProfProdH_calc7());
			alliedOTHProfH.setDirCareProdHrsTotalBudget(root.getAlliedProfProdH_sub7());
			alliedOTHProfH.setDirCareTotalHrsPaidBudget(root.getAlliedProfNProdH_THP7());
			alliedOTHProfH.setDirCareNonProdHrsTotalBudget(root.getAlliedProfNProdH_calc7());
			alliedOTHProfH.setDirCareOtherValue(root.getAlliedProf_label7());

			/* Allied Non Professional */
			LtcBudgetDirectCareHrs alliedNPRTProfH = new LtcBudgetDirectCareHrs();
			alliedNPRTProfH.setDirCareProdHrsRegBudget(root.getAlliedNPProdH_item11());
			alliedNPRTProfH.setDirCareProdHrsOtBudget(root.getAlliedNPProdH_item21());
			alliedNPRTProfH.setDirCareProdHrsOrientationBudget(root.getAlliedNPProdH_item31());
			alliedNPRTProfH.setDirCareProdHrsContractedBudget(root.getAlliedNPProdHCS1());
			alliedNPRTProfH.setDirCareNonProdHrsVacBudget(root.getAlliedNPNProdH_item11());
			alliedNPRTProfH.setDirCareNonProdHrsSickBudget(root.getAlliedNPNProdH_item21());
			alliedNPRTProfH.setDirCareNonProdHrsOtherBudget(root.getAlliedNPNProdH_item31());
			alliedNPRTProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRTProfH.setDirCareType(root.getAlliedNP_label());
			alliedNPRTProfH.setDirCareName(root.getAlliedNP_label1());
			alliedNPRTProfH.setDirCareProdHrsSubtotalBudget(root.getAlliedNPProdH_calc1());
			alliedNPRTProfH.setDirCareProdHrsTotalBudget(root.getAlliedNPProdH_sub1());
			alliedNPRTProfH.setDirCareTotalHrsPaidBudget(root.getAlliedNPNProdH_THP1());
			alliedNPRTProfH.setDirCareNonProdHrsTotalBudget(root.getAlliedNPNProdH_calc1());


			LtcBudgetDirectCareHrs alliedNPRAProfH = new LtcBudgetDirectCareHrs();
			alliedNPRAProfH.setDirCareProdHrsRegBudget(root.getAlliedNPProdH_item12());
			alliedNPRAProfH.setDirCareProdHrsOtBudget(root.getAlliedNPProdH_item22());
			alliedNPRAProfH.setDirCareProdHrsOrientationBudget(root.getAlliedNPProdH_item32());
			alliedNPRAProfH.setDirCareProdHrsContractedBudget(root.getAlliedNPProdHCS2());
			alliedNPRAProfH.setDirCareNonProdHrsVacBudget(root.getAlliedNPNProdH_item12());
			alliedNPRAProfH.setDirCareNonProdHrsSickBudget(root.getAlliedNPNProdH_item22());
			alliedNPRAProfH.setDirCareNonProdHrsOtherBudget(root.getAlliedNPNProdH_item32());
			alliedNPRAProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRAProfH.setDirCareType(root.getAlliedNP_label());
			alliedNPRAProfH.setDirCareName(root.getAlliedNP_label2());
			alliedNPRAProfH.setDirCareProdHrsSubtotalBudget(root.getAlliedNPProdH_calc2());
			alliedNPRAProfH.setDirCareProdHrsTotalBudget(root.getAlliedNPProdH_sub2());
			alliedNPRAProfH.setDirCareTotalHrsPaidBudget(root.getAlliedNPNProdH_THP2());
			alliedNPRAProfH.setDirCareNonProdHrsTotalBudget(root.getAlliedNPNProdH_calc2());


			LtcBudgetDirectCareHrs alliedNPAWProfH = new LtcBudgetDirectCareHrs();
			alliedNPAWProfH.setDirCareProdHrsRegBudget(root.getAlliedNPProdH_item13());
			alliedNPAWProfH.setDirCareProdHrsOtBudget(root.getAlliedNPProdH_item23());
			alliedNPAWProfH.setDirCareProdHrsOrientationBudget(root.getAlliedNPProdH_item33());
			alliedNPAWProfH.setDirCareProdHrsContractedBudget(root.getAlliedNPProdHCS3());
			alliedNPAWProfH.setDirCareNonProdHrsVacBudget(root.getAlliedNPNProdH_item13());
			alliedNPAWProfH.setDirCareNonProdHrsSickBudget(root.getAlliedNPNProdH_item23());
			alliedNPAWProfH.setDirCareNonProdHrsOtherBudget(root.getAlliedNPNProdH_item33());
			alliedNPAWProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPAWProfH.setDirCareType(root.getAlliedNP_label());
			alliedNPAWProfH.setDirCareName(root.getAlliedNP_label3());
			alliedNPAWProfH.setDirCareProdHrsSubtotalBudget(root.getAlliedNPProdH_calc3());
			alliedNPAWProfH.setDirCareProdHrsTotalBudget(root.getAlliedNPProdH_sub3());
			alliedNPAWProfH.setDirCareTotalHrsPaidBudget(root.getAlliedNPNProdH_THP3());
			alliedNPAWProfH.setDirCareNonProdHrsTotalBudget(root.getAlliedNPNProdH_calc3());


			LtcBudgetDirectCareHrs alliedNPMTProfH = new LtcBudgetDirectCareHrs();
			alliedNPMTProfH.setDirCareProdHrsRegBudget(root.getAlliedNPProdH_item14());
			alliedNPMTProfH.setDirCareProdHrsOtBudget(root.getAlliedNPProdH_item24());
			alliedNPMTProfH.setDirCareProdHrsOrientationBudget(root.getAlliedNPProdH_item34());
			alliedNPMTProfH.setDirCareProdHrsContractedBudget(root.getAlliedNPProdHCS4());
			alliedNPMTProfH.setDirCareNonProdHrsVacBudget(root.getAlliedNPNProdH_item14());
			alliedNPMTProfH.setDirCareNonProdHrsSickBudget(root.getAlliedNPNProdH_item24());
			alliedNPMTProfH.setDirCareNonProdHrsOtherBudget(root.getAlliedNPNProdH_item34());
			alliedNPMTProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPMTProfH.setDirCareType(root.getAlliedNP_label());
			alliedNPMTProfH.setDirCareName(root.getAlliedNP_label4());
			alliedNPMTProfH.setDirCareProdHrsSubtotalBudget(root.getAlliedNPProdH_calc4());
			alliedNPMTProfH.setDirCareProdHrsTotalBudget(root.getAlliedNPProdH_sub4());
			alliedNPMTProfH.setDirCareTotalHrsPaidBudget(root.getAlliedNPNProdH_THP4());
			alliedNPMTProfH.setDirCareNonProdHrsTotalBudget(root.getAlliedNPNProdH_calc4());


			LtcBudgetDirectCareHrs alliedNPATProfH = new LtcBudgetDirectCareHrs();
			alliedNPATProfH.setDirCareProdHrsRegBudget(root.getAlliedNPProdH_item15());
			alliedNPATProfH.setDirCareProdHrsOtBudget(root.getAlliedNPProdH_item25());
			alliedNPATProfH.setDirCareProdHrsOrientationBudget(root.getAlliedNPProdH_item35());
			alliedNPATProfH.setDirCareProdHrsContractedBudget(root.getAlliedNPProdHCS5());
			alliedNPATProfH.setDirCareNonProdHrsVacBudget(root.getAlliedNPNProdH_item15());
			alliedNPATProfH.setDirCareNonProdHrsSickBudget(root.getAlliedNPNProdH_item25());
			alliedNPATProfH.setDirCareNonProdHrsOtherBudget(root.getAlliedNPNProdH_item35());
			alliedNPATProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPATProfH.setDirCareType(root.getAlliedNP_label());
			alliedNPATProfH.setDirCareName(root.getAlliedNP_label5());
			alliedNPATProfH.setDirCareProdHrsSubtotalBudget(root.getAlliedNPProdH_calc5());
			alliedNPATProfH.setDirCareProdHrsTotalBudget(root.getAlliedNPProdH_sub5());
			alliedNPATProfH.setDirCareTotalHrsPaidBudget(root.getAlliedNPNProdH_THP5());
			alliedNPATProfH.setDirCareNonProdHrsTotalBudget(root.getAlliedNPNProdH_calc5());

			LtcBudgetDirectCareHrs alliedNPOTHProfH = new LtcBudgetDirectCareHrs();
			alliedNPOTHProfH.setDirCareProdHrsRegBudget(root.getAlliedNPProdH_item16());
			alliedNPOTHProfH.setDirCareProdHrsOtBudget(root.getAlliedNPProdH_item26());
			alliedNPOTHProfH.setDirCareProdHrsOrientationBudget(root.getAlliedNPProdH_item36());
			alliedNPOTHProfH.setDirCareProdHrsContractedBudget(root.getAlliedNPProdHCS6());
			alliedNPOTHProfH.setDirCareNonProdHrsVacBudget(root.getAlliedNPNProdH_item16());
			alliedNPOTHProfH.setDirCareNonProdHrsSickBudget(root.getAlliedNPNProdH_item26());
			alliedNPOTHProfH.setDirCareNonProdHrsOtherBudget(root.getAlliedNPNProdH_item36());
			alliedNPOTHProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPOTHProfH.setDirCareType(root.getAlliedNP_label());
			alliedNPOTHProfH.setDirCareName(Constants.DC_HRS_OTHER);
			alliedNPOTHProfH.setDirCareProdHrsSubtotalBudget(root.getAlliedNPProdH_calc6());
			alliedNPOTHProfH.setDirCareProdHrsTotalBudget(root.getAlliedNPProdH_sub6());
			alliedNPOTHProfH.setDirCareTotalHrsPaidBudget(root.getAlliedNPNProdH_THP6());
			alliedNPOTHProfH.setDirCareNonProdHrsTotalBudget(root.getAlliedNPNProdH_calc6());
			alliedNPOTHProfH.setDirCareOtherValue(root.getAlliedNP_label6());

			Collections.addAll(ltcBudgetDcHrs, nursingRNProdH, nursingLPNProdH, nursingHCAProdH, alliedOTProfH,
					alliedPTProfH, alliedDTProfH, alliedSWProfH, alliedSLPProfH, alliedRTProfH, alliedNPRTProfH,
					alliedNPRAProfH, alliedNPAWProfH, alliedNPMTProfH, alliedNPATProfH,nursingOthProdH,
					alliedOTHProfH, alliedNPOTHProfH);

			/* END : Direct Care Hours */

			/* Direct Care Hours Subtotals */
			LtcBudgetDirectCareHrsSubTotals nursingDirCareHrsSubTotal = new LtcBudgetDirectCareHrsSubTotals();
			nursingDirCareHrsSubTotal.setDirCareType(root.getNursing_label());
			nursingDirCareHrsSubTotal.setSubTotalDirCareProdHrsRegularBudget(root.getNursingProdH_sum11());
			nursingDirCareHrsSubTotal.setSubTotalDirCareProdHrsOTBudget(root.getNursingProdH_sum21());
			nursingDirCareHrsSubTotal.setSubTotalDirCareProdHrsOrientationBudget(root.getNursingProdH_sum31());
			nursingDirCareHrsSubTotal.setSubTotalDirCareProdHrsSubtotalBudget(root.getNursingProdH_calcsum1());
			nursingDirCareHrsSubTotal.setSubTotalDirCareProdHrsContServBudget(root.getNursingProdHCS_subsum1());
			nursingDirCareHrsSubTotal.setSubTotalDirCareProdHrsTotalBudget(root.getNursingProdH_subsum1());
			nursingDirCareHrsSubTotal.setSubTotalDirCareTotalHrsPaidBudget(root.getNursingNProdH_THPsum1());
			nursingDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsVacBudget(root.getNursingNProdH_sum11());
			nursingDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsSickBudget(root.getNursingNProdH_sum21());
			nursingDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsOtherServBudget(root.getNursingNProdH_sum31());
			nursingDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsTotalBudget(root.getNursingNProdH_calcsum1());
			nursingDirCareHrsSubTotal.setConfirmationID(root.getForm().getConfirmationId());
			nursingDirCareHrsSubTotal.setSubTotalDirCareProdHrsAgencyStaffUtil(root.getNursingProdHASU_subsum());
			

			LtcBudgetDirectCareHrsSubTotals alliedDirCareHrsSubTotal = new LtcBudgetDirectCareHrsSubTotals();
			alliedDirCareHrsSubTotal.setDirCareType(root.getAlliedProf_label());
			alliedDirCareHrsSubTotal.setSubTotalDirCareProdHrsRegularBudget(root.getAlliedProfProdH_sum11());
			alliedDirCareHrsSubTotal.setSubTotalDirCareProdHrsOTBudget(root.getAlliedProfProdH_sum21());
			alliedDirCareHrsSubTotal.setSubTotalDirCareProdHrsOrientationBudget(root.getAlliedProfProdH_sum31());
			alliedDirCareHrsSubTotal.setSubTotalDirCareProdHrsSubtotalBudget(root.getAlliedProfProdH_calcsum1());
			alliedDirCareHrsSubTotal.setSubTotalDirCareProdHrsContServBudget(root.getAlliedProfProdHCS_subsum1());
			alliedDirCareHrsSubTotal.setSubTotalDirCareProdHrsTotalBudget(root.getAlliedProfProdH_subsum1());
			alliedDirCareHrsSubTotal.setSubTotalDirCareTotalHrsPaidBudget(root.getAlliedProfNProdH_THPsum1());
			alliedDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsVacBudget(root.getAlliedProfNProdH_sum11());
			alliedDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsSickBudget(root.getAlliedNProdH_sum21());
			alliedDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsOtherServBudget(root.getAlliedProfNProdH_sum31());
			alliedDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsTotalBudget(root.getAlliedProfNProdH_calcsum1());
			alliedDirCareHrsSubTotal.setConfirmationID(root.getForm().getConfirmationId());

			LtcBudgetDirectCareHrsSubTotals alliedNPDirCareHrsSubTotal = new LtcBudgetDirectCareHrsSubTotals();
			alliedNPDirCareHrsSubTotal.setDirCareType(root.getAlliedNP_label());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareProdHrsRegularBudget(root.getAlliedNPProdH_sum11());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareProdHrsOTBudget(root.getAlliedNPProdH_sum21());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareProdHrsOrientationBudget(root.getAlliedNPProdH_sum31());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareProdHrsSubtotalBudget(root.getAlliedNPProdH_calcsum1());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareProdHrsContServBudget(root.getAlliedNPProdHCS_subsum1());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareProdHrsTotalBudget(root.getAlliedNPProdH_subsum1());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareTotalHrsPaidBudget(root.getAlliedNPNProdH_THPsum1());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsVacBudget(root.getAlliedNPNProdH_sum11());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsSickBudget(root.getAlliedNPNProdH_sum21());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsOtherServBudget(root.getAlliedNPNProdH_sum31());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsTotalBudget(root.getAlliedNPNProdH_calcsum1());
			alliedNPDirCareHrsSubTotal.setConfirmationID(root.getForm().getConfirmationId());

			Collections.addAll(ltcBudgetDcHrsSubttls, nursingDirCareHrsSubTotal,alliedDirCareHrsSubTotal,alliedNPDirCareHrsSubTotal);
			/* END */


			/* START : Direct Care Cost */
			LtcBudgetDirectCareCost nursingRNProdC = new LtcBudgetDirectCareCost();
			nursingRNProdC.setDirCareCostProdHrsRegBudget(root.getNursingProdC_item11());
			nursingRNProdC.setDirCareCostProdHrsOtBudget(root.getNursingProdC_item21());
			nursingRNProdC.setDirCareCostProdHrsOrientationBudget(root.getNursingProdC_item31());
			nursingRNProdC.setDirCareCostProdHrsContractedBudget(root.getNursingProdCCS1());
			nursingRNProdC.setDirCareCostNonProdHrsVacBudget(root.getNursingNProdC_item11());
			nursingRNProdC.setDirCareCostNonProdHrsSickBudget(root.getNursingNProdC_item21());
			nursingRNProdC.setDirCareCostNonProdHrsOtherBudget(root.getNursingNProdC_item31());
			nursingRNProdC.setConfirmationId(root.getForm().getConfirmationId());
			nursingRNProdC.setDirCareCostType(root.getNursing_label());
			nursingRNProdC.setDirCareCostName(root.getNursing_label1());
			nursingRNProdC.setDirCareCostProdHrsSubtotalBudget(root.getNursingProdC_calc1());
			nursingRNProdC.setDirCareCostProdHrsTotalBudget(root.getNursingProdC_sub1());
			nursingRNProdC.setDirCareCostTotalHrsPaidBudget(root.getNursingCost1());
			nursingRNProdC.setDirCareCostNonProdHrsTotalBudget(root.getNursingNProdC_calc1());
			nursingRNProdC.setDirCareCostHourlyRateStaffBudget(root.getNursingStaffRate1());
			nursingRNProdC.setDirCareCostHourlyRateContractedBudget(root.getNursingContractRate1());
			nursingRNProdC.setDirCareCostProdHrsAgencyStaffUtil(root.getNursingProdCASU1());
			/* END : Direct Care Cost */

			LtcBudgetDirectCareCost nursingLPNProdC = new LtcBudgetDirectCareCost();
			nursingLPNProdC.setDirCareCostProdHrsRegBudget(root.getNursingProdC_item12());
			nursingLPNProdC.setDirCareCostProdHrsOtBudget(root.getNursingProdC_item22());
			nursingLPNProdC.setDirCareCostProdHrsOrientationBudget(root.getNursingProdC_item32());
			nursingLPNProdC.setDirCareCostProdHrsContractedBudget(root.getNursingProdCCS2());
			nursingLPNProdC.setDirCareCostNonProdHrsVacBudget(root.getNursingNProdC_item12());
			nursingLPNProdC.setDirCareCostNonProdHrsSickBudget(root.getNursingNProdC_item22());
			nursingLPNProdC.setDirCareCostNonProdHrsOtherBudget(root.getNursingNProdC_item32());
			nursingLPNProdC.setConfirmationId(root.getForm().getConfirmationId());
			nursingLPNProdC.setDirCareCostType(root.getNursing_label());
			nursingLPNProdC.setDirCareCostName(root.getNursing_label2());
			nursingLPNProdC.setDirCareCostProdHrsSubtotalBudget(root.getNursingProdC_calc2());
			nursingLPNProdC.setDirCareCostProdHrsTotalBudget(root.getNursingProdC_sub2());
			nursingLPNProdC.setDirCareCostTotalHrsPaidBudget(root.getNursingCost2());
			nursingLPNProdC.setDirCareCostNonProdHrsTotalBudget(root.getNursingNProdC_calc2());
			nursingLPNProdC.setDirCareCostHourlyRateStaffBudget(root.getNursingStaffRate2());
			nursingLPNProdC.setDirCareCostHourlyRateContractedBudget(root.getNursingContractRate2());
			nursingLPNProdC.setDirCareCostProdHrsAgencyStaffUtil(root.getNursingProdCASU2());



			LtcBudgetDirectCareCost nursingHCAProdC = new LtcBudgetDirectCareCost();
			nursingHCAProdC.setDirCareCostProdHrsRegBudget(root.getNursingProdC_item13());
			nursingHCAProdC.setDirCareCostProdHrsOtBudget(root.getNursingProdC_item23());
			nursingHCAProdC.setDirCareCostProdHrsOrientationBudget(root.getNursingProdC_item33());
			nursingHCAProdC.setDirCareCostProdHrsContractedBudget(root.getNursingProdCCS3());
			nursingHCAProdC.setDirCareCostNonProdHrsVacBudget(root.getNursingNProdC_item13());
			nursingHCAProdC.setDirCareCostNonProdHrsSickBudget(root.getNursingNProdC_item23());
			nursingHCAProdC.setDirCareCostNonProdHrsOtherBudget(root.getNursingNProdC_item33());
			nursingHCAProdC.setConfirmationId(root.getForm().getConfirmationId());
			nursingHCAProdC.setDirCareCostType(root.getNursing_label());
			nursingHCAProdC.setDirCareCostName(root.getNursing_label3());
			nursingHCAProdC.setDirCareCostProdHrsSubtotalBudget(root.getNursingProdC_calc3());
			nursingHCAProdC.setDirCareCostProdHrsTotalBudget(root.getNursingProdC_sub3());
			nursingHCAProdC.setDirCareCostTotalHrsPaidBudget(root.getNursingCost3());
			nursingHCAProdC.setDirCareCostNonProdHrsTotalBudget(root.getNursingNProdC_calc3());
			nursingHCAProdC.setDirCareCostHourlyRateStaffBudget(root.getNursingStaffRate3());
			nursingHCAProdC.setDirCareCostHourlyRateContractedBudget(root.getNursingContractRate3());
			nursingHCAProdC.setDirCareCostProdHrsAgencyStaffUtil(root.getNursingProdCASU3());


			LtcBudgetDirectCareCost nursingOthProdC = new LtcBudgetDirectCareCost();
			nursingOthProdC.setDirCareCostProdHrsRegBudget(root.getNursingProdC_item14());
			nursingOthProdC.setDirCareCostProdHrsOtBudget(root.getNursingProdC_item24());
			nursingOthProdC.setDirCareCostProdHrsOrientationBudget(root.getNursingProdC_item34());
			nursingOthProdC.setDirCareCostProdHrsContractedBudget(root.getNursingProdCCS4());
			nursingOthProdC.setDirCareCostNonProdHrsVacBudget(root.getNursingNProdC_item14());
			nursingOthProdC.setDirCareCostNonProdHrsSickBudget(root.getNursingNProdC_item24());
			nursingOthProdC.setDirCareCostNonProdHrsOtherBudget(root.getNursingNProdC_item34());
			nursingOthProdC.setConfirmationId(root.getForm().getConfirmationId());
			nursingOthProdC.setDirCareCostType(root.getNursing_label());
			nursingOthProdC.setDirCareCostName(Constants.DC_HRS_OTHER);
			nursingOthProdC.setDirCareCostProdHrsSubtotalBudget(root.getNursingProdC_calc4());
			nursingOthProdC.setDirCareCostProdHrsTotalBudget(root.getNursingProdC_sub4());
			nursingOthProdC.setDirCareCostTotalHrsPaidBudget(root.getNursingCost4());
			nursingOthProdC.setDirCareCostNonProdHrsTotalBudget(root.getNursingNProdC_calc4());
			nursingOthProdC.setDirCareCostHourlyRateStaffBudget(root.getNursingStaffRate4());
			nursingOthProdC.setDirCareCostHourlyRateContractedBudget(root.getNursingContractRate4());
			nursingOthProdC.setDirCareOtherValue(root.getNursing_label4());
			nursingOthProdC.setDirCareCostProdHrsAgencyStaffUtil(root.getNursingProdCASU4());




			// Allied Prof
			LtcBudgetDirectCareCost alliedOTProfC = new LtcBudgetDirectCareCost();
			alliedOTProfC.setDirCareCostProdHrsRegBudget(root.getAlliedProfProdC_item11());
			alliedOTProfC.setDirCareCostProdHrsOtBudget(root.getAlliedProfProdC_item21());
			alliedOTProfC.setDirCareCostProdHrsOrientationBudget(root.getAlliedProfProdC_item31());
			alliedOTProfC.setDirCareCostProdHrsContractedBudget(root.getAlliedProfProdCCS1());
			alliedOTProfC.setDirCareCostNonProdHrsVacBudget(root.getAlliedProfNProdC_item11());
			alliedOTProfC.setDirCareCostNonProdHrsSickBudget(root.getAlliedProfNProdC_item21());
			alliedOTProfC.setDirCareCostNonProdHrsOtherBudget(root.getAlliedProfNProdC_item31());
			alliedOTProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedOTProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedOTProfC.setDirCareCostName(root.getAlliedProf_label1());
			alliedOTProfC.setDirCareCostProdHrsSubtotalBudget(root.getAlliedProfProdC_calc1());
			alliedOTProfC.setDirCareCostProdHrsTotalBudget(root.getAlliedProfProdC_sub1());
			alliedOTProfC.setDirCareCostTotalHrsPaidBudget(root.getAlliedProfCost1());
			alliedOTProfC.setDirCareCostNonProdHrsTotalBudget(root.getAlliedProfNProdC_calc1());
			alliedOTProfC.setDirCareCostHourlyRateStaffBudget(root.getAlliedProfStaffRate1());
			alliedOTProfC.setDirCareCostHourlyRateContractedBudget(root.getAlliedProfContractRate1());


			LtcBudgetDirectCareCost alliedPTProfC = new LtcBudgetDirectCareCost();
			alliedPTProfC.setDirCareCostProdHrsRegBudget(root.getAlliedProfProdC_item12());
			alliedPTProfC.setDirCareCostProdHrsOtBudget(root.getAlliedProfProdC_item22());
			alliedPTProfC.setDirCareCostProdHrsOrientationBudget(root.getAlliedProfProdC_item32());
			alliedPTProfC.setDirCareCostProdHrsContractedBudget(root.getAlliedProfProdCCS2());
			alliedPTProfC.setDirCareCostNonProdHrsVacBudget(root.getAlliedProfNProdC_item12());
			alliedPTProfC.setDirCareCostNonProdHrsSickBudget(root.getAlliedProfNProdC_item22());
			alliedPTProfC.setDirCareCostNonProdHrsOtherBudget(root.getAlliedProfNProdC_item32());
			alliedPTProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedPTProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedPTProfC.setDirCareCostName(root.getAlliedProf_label2());
			alliedPTProfC.setDirCareCostProdHrsSubtotalBudget(root.getAlliedProfProdC_calc2());
			alliedPTProfC.setDirCareCostProdHrsTotalBudget(root.getAlliedProfProdC_sub2());
			alliedPTProfC.setDirCareCostTotalHrsPaidBudget(root.getAlliedProfCost2());
			alliedPTProfC.setDirCareCostNonProdHrsTotalBudget(root.getAlliedProfNProdC_calc2());
			alliedPTProfC.setDirCareCostHourlyRateStaffBudget(root.getAlliedProfStaffRate2());
			alliedPTProfC.setDirCareCostHourlyRateContractedBudget(root.getAlliedProfContractRate2());



			LtcBudgetDirectCareCost alliedDTProfC = new LtcBudgetDirectCareCost();
			alliedDTProfC.setDirCareCostProdHrsRegBudget(root.getAlliedProfProdC_item13());
			alliedDTProfC.setDirCareCostProdHrsOtBudget(root.getAlliedProfProdC_item23());
			alliedDTProfC.setDirCareCostProdHrsOrientationBudget(root.getAlliedProfProdC_item33());
			alliedDTProfC.setDirCareCostProdHrsContractedBudget(root.getAlliedProfProdCCS3());
			alliedDTProfC.setDirCareCostNonProdHrsVacBudget(root.getAlliedProfNProdC_item13());
			alliedDTProfC.setDirCareCostNonProdHrsSickBudget(root.getAlliedProfNProdC_item23());
			alliedDTProfC.setDirCareCostNonProdHrsOtherBudget(root.getAlliedProfNProdC_item33());
			alliedDTProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedDTProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedDTProfC.setDirCareCostName(root.getAlliedProf_label3());
			alliedDTProfC.setDirCareCostProdHrsSubtotalBudget(root.getAlliedProfProdC_calc3());
			alliedDTProfC.setDirCareCostProdHrsTotalBudget(root.getAlliedProfProdC_sub3());
			alliedDTProfC.setDirCareCostTotalHrsPaidBudget(root.getAlliedProfCost3());
			alliedDTProfC.setDirCareCostNonProdHrsTotalBudget(root.getAlliedProfNProdC_calc3());
			alliedDTProfC.setDirCareCostHourlyRateStaffBudget(root.getAlliedProfStaffRate3());
			alliedDTProfC.setDirCareCostHourlyRateContractedBudget(root.getAlliedProfContractRate3());



			LtcBudgetDirectCareCost alliedSWProfC = new LtcBudgetDirectCareCost();
			alliedSWProfC.setDirCareCostProdHrsRegBudget(root.getAlliedProfProdC_item14());
			alliedSWProfC.setDirCareCostProdHrsOtBudget(root.getAlliedProfProdC_item24());
			alliedSWProfC.setDirCareCostProdHrsOrientationBudget(root.getAlliedProfProdC_item34());
			alliedSWProfC.setDirCareCostProdHrsContractedBudget(root.getAlliedProfProdCCS4());
			alliedSWProfC.setDirCareCostNonProdHrsVacBudget(root.getAlliedProfNProdC_item14());
			alliedSWProfC.setDirCareCostNonProdHrsSickBudget(root.getAlliedProfNProdC_item24());
			alliedSWProfC.setDirCareCostNonProdHrsOtherBudget(root.getAlliedProfNProdC_item34());
			alliedSWProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedSWProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedSWProfC.setDirCareCostName(root.getAlliedProf_label4());
			alliedSWProfC.setDirCareCostProdHrsSubtotalBudget(root.getAlliedProfProdC_calc4());
			alliedSWProfC.setDirCareCostProdHrsTotalBudget(root.getAlliedProfProdC_sub4());
			alliedSWProfC.setDirCareCostTotalHrsPaidBudget(root.getAlliedProfCost4());
			alliedSWProfC.setDirCareCostNonProdHrsTotalBudget(root.getAlliedProfNProdC_calc4());
			alliedSWProfC.setDirCareCostHourlyRateStaffBudget(root.getAlliedProfStaffRate4());
			alliedSWProfC.setDirCareCostHourlyRateContractedBudget(root.getAlliedProfContractRate4());

			LtcBudgetDirectCareCost alliedSLPProfC = new LtcBudgetDirectCareCost();
			alliedSLPProfC.setDirCareCostProdHrsRegBudget(root.getAlliedProfProdC_item15());
			alliedSLPProfC.setDirCareCostProdHrsOtBudget(root.getAlliedProfProdC_item25());
			alliedSLPProfC.setDirCareCostProdHrsOrientationBudget(root.getAlliedProfProdC_item35());
			alliedSLPProfC.setDirCareCostProdHrsContractedBudget(root.getAlliedProfProdCCS5());
			alliedSLPProfC.setDirCareCostNonProdHrsVacBudget(root.getAlliedProfNProdC_item15());
			alliedSLPProfC.setDirCareCostNonProdHrsSickBudget(root.getAlliedProfNProdC_item25());
			alliedSLPProfC.setDirCareCostNonProdHrsOtherBudget(root.getAlliedProfNProdC_item35());
			alliedSLPProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedSLPProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedSLPProfC.setDirCareCostName(root.getAlliedProf_label5());
			alliedSLPProfC.setDirCareCostProdHrsSubtotalBudget(root.getAlliedProfProdC_calc5());
			alliedSLPProfC.setDirCareCostProdHrsTotalBudget(root.getAlliedProfProdC_sub5());
			alliedSLPProfC.setDirCareCostTotalHrsPaidBudget(root.getAlliedProfCost5());
			alliedSLPProfC.setDirCareCostNonProdHrsTotalBudget(root.getAlliedProfNProdC_calc5());
			alliedSLPProfC.setDirCareCostHourlyRateStaffBudget(root.getAlliedProfStaffRate5());
			alliedSLPProfC.setDirCareCostHourlyRateContractedBudget(root.getAlliedProfContractRate5());

			LtcBudgetDirectCareCost alliedRTProfC = new LtcBudgetDirectCareCost();
			alliedRTProfC.setDirCareCostProdHrsRegBudget(root.getAlliedProfProdC_item16());
			alliedRTProfC.setDirCareCostProdHrsOtBudget(root.getAlliedProfProdC_item26());
			alliedRTProfC.setDirCareCostProdHrsOrientationBudget(root.getAlliedProfProdC_item36());
			alliedRTProfC.setDirCareCostProdHrsContractedBudget(root.getAlliedProfProdCCS6());
			alliedRTProfC.setDirCareCostNonProdHrsVacBudget(root.getAlliedProfNProdC_item16());
			alliedRTProfC.setDirCareCostNonProdHrsSickBudget(root.getAlliedProfNProdC_item26());
			alliedRTProfC.setDirCareCostNonProdHrsOtherBudget(root.getAlliedProfNProdC_item36());
			alliedRTProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedRTProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedRTProfC.setDirCareCostName(root.getAlliedProf_label6());
			alliedRTProfC.setDirCareCostProdHrsSubtotalBudget(root.getAlliedProfProdC_calc6());
			alliedRTProfC.setDirCareCostProdHrsTotalBudget(root.getAlliedProfProdC_sub6());
			alliedRTProfC.setDirCareCostTotalHrsPaidBudget(root.getAlliedProfCost6());
			alliedRTProfC.setDirCareCostNonProdHrsTotalBudget(root.getAlliedProfNProdC_calc6());
			alliedRTProfC.setDirCareCostHourlyRateStaffBudget(root.getAlliedProfStaffRate6());
			alliedRTProfC.setDirCareCostHourlyRateContractedBudget(root.getAlliedProfContractRate6());

			LtcBudgetDirectCareCost alliedOTHProfC = new LtcBudgetDirectCareCost();
			alliedOTHProfC.setDirCareCostProdHrsRegBudget(root.getAlliedProfProdC_item17());
			alliedOTHProfC.setDirCareCostProdHrsOtBudget(root.getAlliedProfProdC_item27());
			alliedOTHProfC.setDirCareCostProdHrsOrientationBudget(root.getAlliedProfProdC_item37());
			alliedOTHProfC.setDirCareCostProdHrsContractedBudget(root.getAlliedProfProdCCS7());
			alliedOTHProfC.setDirCareCostNonProdHrsVacBudget(root.getAlliedProfNProdC_item17());
			alliedOTHProfC.setDirCareCostNonProdHrsSickBudget(root.getAlliedProfNProdC_item27());
			alliedOTHProfC.setDirCareCostNonProdHrsOtherBudget(root.getAlliedProfNProdC_item37());
			alliedOTHProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedOTHProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedOTHProfC.setDirCareCostName(Constants.DC_HRS_OTHER);
			alliedOTHProfC.setDirCareCostProdHrsSubtotalBudget(root.getAlliedProfProdC_calc7());
			alliedOTHProfC.setDirCareCostProdHrsTotalBudget(root.getAlliedProfProdC_sub7());
			alliedOTHProfC.setDirCareCostTotalHrsPaidBudget(root.getAlliedProfCost7());
			alliedOTHProfC.setDirCareCostNonProdHrsTotalBudget(root.getAlliedProfNProdC_calc7());
			alliedOTHProfC.setDirCareCostHourlyRateStaffBudget(root.getAlliedProfStaffRate7());
			alliedOTHProfC.setDirCareCostHourlyRateContractedBudget(root.getAlliedProfContractRate7());
			alliedOTHProfC.setDirCareOtherValue(root.getAlliedProf_label7());


			// Allied Non Professional
			LtcBudgetDirectCareCost alliedNPRTProfC = new LtcBudgetDirectCareCost();
			alliedNPRTProfC.setDirCareCostProdHrsRegBudget(root.getAlliedNPProdC_item11());
			alliedNPRTProfC.setDirCareCostProdHrsOtBudget(root.getAlliedNPProdC_item21());
			alliedNPRTProfC.setDirCareCostProdHrsOrientationBudget(root.getAlliedNPProdC_item31());
			alliedNPRTProfC.setDirCareCostProdHrsContractedBudget(root.getAlliedNPProdCCS1());
			alliedNPRTProfC.setDirCareCostNonProdHrsVacBudget(root.getAlliedNPNProdC_item11());
			alliedNPRTProfC.setDirCareCostNonProdHrsSickBudget(root.getAlliedNPProdC_item21());
			alliedNPRTProfC.setDirCareCostNonProdHrsOtherBudget(root.getAlliedNPNProdC_item31());
			alliedNPRTProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRTProfC.setDirCareCostType(root.getAlliedNP_label());
			alliedNPRTProfC.setDirCareCostName(root.getAlliedNP_label1());
			alliedNPRTProfC.setDirCareCostProdHrsSubtotalBudget(root.getAlliedNPProdC_calc1());
			alliedNPRTProfC.setDirCareCostProdHrsTotalBudget(root.getAlliedNPProdC_sub1());
			alliedNPRTProfC.setDirCareCostTotalHrsPaidBudget(root.getAlliedNPCost1());
			alliedNPRTProfC.setDirCareCostNonProdHrsTotalBudget(root.getAlliedNPNProdC_calc1());
			alliedNPRTProfC.setDirCareCostHourlyRateStaffBudget(root.getAlliedNPStaffRate1());
			alliedNPRTProfC.setDirCareCostHourlyRateContractedBudget(root.getAlliedNPContractRate1());


			LtcBudgetDirectCareCost alliedNPRAProfC = new LtcBudgetDirectCareCost();
			alliedNPRAProfC.setDirCareCostProdHrsRegBudget(root.getAlliedNPProdC_item12());
			alliedNPRAProfC.setDirCareCostProdHrsOtBudget(root.getAlliedNPProdC_item22());
			alliedNPRAProfC.setDirCareCostProdHrsOrientationBudget(root.getAlliedNPProdC_item32());
			alliedNPRAProfC.setDirCareCostProdHrsContractedBudget(root.getAlliedNPProdCCS2());
			alliedNPRAProfC.setDirCareCostNonProdHrsVacBudget(root.getAlliedNPNProdC_item12());
			alliedNPRAProfC.setDirCareCostNonProdHrsSickBudget(root.getAlliedNPProdC_item22());
			alliedNPRAProfC.setDirCareCostNonProdHrsOtherBudget(root.getAlliedNPNProdC_item32());
			alliedNPRAProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRAProfC.setDirCareCostType(root.getAlliedNP_label());
			alliedNPRAProfC.setDirCareCostName(root.getAlliedNP_label2());
			alliedNPRAProfC.setDirCareCostProdHrsSubtotalBudget(root.getAlliedNPProdC_calc2());
			alliedNPRAProfC.setDirCareCostProdHrsTotalBudget(root.getAlliedNPProdC_sub2());
			alliedNPRAProfC.setDirCareCostTotalHrsPaidBudget(root.getAlliedNPCost2());
			alliedNPRAProfC.setDirCareCostNonProdHrsTotalBudget(root.getAlliedNPNProdC_calc2());
			alliedNPRAProfC.setDirCareCostHourlyRateStaffBudget(root.getAlliedNPStaffRate2());
			alliedNPRAProfC.setDirCareCostHourlyRateContractedBudget(root.getAlliedNPContractRate2());



			LtcBudgetDirectCareCost alliedNPAWProfC = new LtcBudgetDirectCareCost();
			alliedNPAWProfC.setDirCareCostProdHrsRegBudget(root.getAlliedNPProdC_item13());
			alliedNPAWProfC.setDirCareCostProdHrsOtBudget(root.getAlliedNPProdC_item23());
			alliedNPAWProfC.setDirCareCostProdHrsOrientationBudget(root.getAlliedNPProdC_item33());
			alliedNPAWProfC.setDirCareCostProdHrsContractedBudget(root.getAlliedNPProdCCS3());
			alliedNPAWProfC.setDirCareCostNonProdHrsVacBudget(root.getAlliedNPNProdC_item13());
			alliedNPAWProfC.setDirCareCostNonProdHrsSickBudget(root.getAlliedNPProdC_item23());
			alliedNPAWProfC.setDirCareCostNonProdHrsOtherBudget(root.getAlliedNPNProdC_item33());
			alliedNPAWProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPAWProfC.setDirCareCostType(root.getAlliedNP_label());
			alliedNPAWProfC.setDirCareCostName(root.getAlliedNP_label3());
			alliedNPAWProfC.setDirCareCostProdHrsSubtotalBudget(root.getAlliedNPProdC_calc3());
			alliedNPAWProfC.setDirCareCostProdHrsTotalBudget(root.getAlliedNPProdC_sub3());
			alliedNPAWProfC.setDirCareCostTotalHrsPaidBudget(root.getAlliedNPCost3());
			alliedNPAWProfC.setDirCareCostNonProdHrsTotalBudget(root.getAlliedNPNProdC_calc3());
			alliedNPAWProfC.setDirCareCostHourlyRateStaffBudget(root.getAlliedNPStaffRate3());
			alliedNPAWProfC.setDirCareCostHourlyRateContractedBudget(root.getAlliedNPContractRate3());



			LtcBudgetDirectCareCost alliedNPMTProfC = new LtcBudgetDirectCareCost();
			alliedNPMTProfC.setDirCareCostProdHrsRegBudget(root.getAlliedNPProdC_item14());
			alliedNPMTProfC.setDirCareCostProdHrsOtBudget(root.getAlliedNPProdC_item24());
			alliedNPMTProfC.setDirCareCostProdHrsOrientationBudget(root.getAlliedNPProdC_item34());
			alliedNPMTProfC.setDirCareCostProdHrsContractedBudget(root.getAlliedNPProdCCS4());
			alliedNPMTProfC.setDirCareCostNonProdHrsVacBudget(root.getAlliedNPNProdC_item14());
			alliedNPMTProfC.setDirCareCostNonProdHrsSickBudget(root.getAlliedNPProdC_item24());
			alliedNPMTProfC.setDirCareCostNonProdHrsOtherBudget(root.getAlliedNPNProdC_item34());
			alliedNPMTProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPMTProfC.setDirCareCostType(root.getAlliedNP_label());
			alliedNPMTProfC.setDirCareCostName(root.getAlliedNP_label4());
			alliedNPMTProfC.setDirCareCostProdHrsSubtotalBudget(root.getAlliedNPProdC_calc4());
			alliedNPMTProfC.setDirCareCostProdHrsTotalBudget(root.getAlliedNPProdC_sub4());
			alliedNPMTProfC.setDirCareCostTotalHrsPaidBudget(root.getAlliedNPCost4());
			alliedNPMTProfC.setDirCareCostNonProdHrsTotalBudget(root.getAlliedNPNProdC_calc4());
			alliedNPMTProfC.setDirCareCostHourlyRateStaffBudget(root.getAlliedNPStaffRate4());
			alliedNPMTProfC.setDirCareCostHourlyRateContractedBudget(root.getAlliedNPContractRate4());



			LtcBudgetDirectCareCost alliedNPATProfC = new LtcBudgetDirectCareCost();
			alliedNPATProfC.setDirCareCostProdHrsRegBudget(root.getAlliedNPProdC_item15());
			alliedNPATProfC.setDirCareCostProdHrsOtBudget(root.getAlliedNPProdC_item25());
			alliedNPATProfC.setDirCareCostProdHrsOrientationBudget(root.getAlliedNPProdC_item35());
			alliedNPATProfC.setDirCareCostProdHrsContractedBudget(root.getAlliedNPProdCCS5());
			alliedNPATProfC.setDirCareCostNonProdHrsVacBudget(root.getAlliedNPNProdC_item15());
			alliedNPATProfC.setDirCareCostNonProdHrsSickBudget(root.getAlliedNPProdC_item25());
			alliedNPATProfC.setDirCareCostNonProdHrsOtherBudget(root.getAlliedNPNProdC_item35());
			alliedNPATProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPATProfC.setDirCareCostType(root.getAlliedNP_label());
			alliedNPATProfC.setDirCareCostName(root.getAlliedNP_label5());
			alliedNPATProfC.setDirCareCostProdHrsSubtotalBudget(root.getAlliedNPProdC_calc5());
			alliedNPATProfC.setDirCareCostProdHrsTotalBudget(root.getAlliedNPProdC_sub5());
			alliedNPATProfC.setDirCareCostTotalHrsPaidBudget(root.getAlliedNPCost5());
			alliedNPATProfC.setDirCareCostNonProdHrsTotalBudget(root.getAlliedNPNProdC_calc5());
			alliedNPATProfC.setDirCareCostHourlyRateStaffBudget(root.getAlliedNPStaffRate5());
			alliedNPATProfC.setDirCareCostHourlyRateContractedBudget(root.getAlliedNPContractRate5());


			
			LtcBudgetDirectCareCost alliedNPOTHProfC = new LtcBudgetDirectCareCost();
			alliedNPOTHProfC.setDirCareCostProdHrsRegBudget(root.getAlliedNPProdC_item16());
			alliedNPOTHProfC.setDirCareCostProdHrsOtBudget(root.getAlliedNPProdC_item26());
			alliedNPOTHProfC.setDirCareCostProdHrsOrientationBudget(root.getAlliedNPProdC_item36());
			alliedNPOTHProfC.setDirCareCostProdHrsContractedBudget(root.getAlliedNPProdCCS6());
			alliedNPOTHProfC.setDirCareCostNonProdHrsVacBudget(root.getAlliedNPNProdC_item16());
			alliedNPOTHProfC.setDirCareCostNonProdHrsSickBudget(root.getAlliedNPProdC_item26());
			alliedNPOTHProfC.setDirCareCostNonProdHrsOtherBudget(root.getAlliedNPNProdC_item36());
			alliedNPOTHProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPOTHProfC.setDirCareCostType(root.getAlliedNP_label());
			alliedNPOTHProfC.setDirCareCostName(Constants.DC_HRS_OTHER);
			alliedNPOTHProfC.setDirCareCostProdHrsSubtotalBudget(root.getAlliedNPProdC_calc6());
			alliedNPOTHProfC.setDirCareCostProdHrsTotalBudget(root.getAlliedNPProdC_sub6());
			alliedNPOTHProfC.setDirCareCostTotalHrsPaidBudget(root.getAlliedNPCost6());
			alliedNPOTHProfC.setDirCareCostNonProdHrsTotalBudget(root.getAlliedNPNProdC_calc6());
			alliedNPOTHProfC.setDirCareCostHourlyRateStaffBudget(root.getAlliedNPStaffRate6());
			alliedNPOTHProfC.setDirCareCostHourlyRateContractedBudget(root.getAlliedNPContractRate6());
			alliedNPOTHProfC.setDirCareOtherValue(root.getAlliedNP_label6());

			Collections.addAll(ltcBudgetDcCost, nursingRNProdC, nursingLPNProdC, nursingHCAProdC,nursingOthProdC, alliedOTProfC,
					alliedPTProfC, alliedDTProfC, alliedSWProfC, alliedSLPProfC, alliedRTProfC, alliedNPRTProfC, alliedNPRAProfC, alliedNPAWProfC,
					alliedNPMTProfC, alliedNPATProfC,alliedOTHProfC,
					alliedNPOTHProfC);

			/* Direct Care Cost Subtotals */
			LtcBudgetDirectCareCostSubtotals nursingCareCostSubtotals = new LtcBudgetDirectCareCostSubtotals();
			nursingCareCostSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			nursingCareCostSubtotals.setDirCareType(root.getNursing_label());
			nursingCareCostSubtotals.setSubTotalDirCareCostProdHrsRegularBudget(root.getNursingProdC_sum11());
			nursingCareCostSubtotals.setSubTotalDirCareCostProdHrsOTBudget(root.getNursingProdC_sum21());
			nursingCareCostSubtotals.setSubTotalDirCareCostProdHrsOrientationBudget(root.getNursingProdC_sum31());
			nursingCareCostSubtotals.setSubTotalDirCareCostProdHrsSubtotalBudget(root.getNursingProdC_calcsum1());
			nursingCareCostSubtotals.setSubTotalDirCareCostProdHrsContServBudget(root.getNursingProdCCS_subsum1());
			nursingCareCostSubtotals.setSubTotalDirCareCostProdHrsTotalBudget(root.getNursingProdC_subsum1());
			nursingCareCostSubtotals.setSubTotalDirCareCostTotalHrsPaidBudget(root.getNursingCost_total());
			nursingCareCostSubtotals.setSubTotalDirCareCostNonProdHrsVacBudget(root.getNursingNProdC_sum11());
			nursingCareCostSubtotals.setSubTotalDirCareCostNonProdHrsSickBudget(root.getNursingNProdC_sum21());
			nursingCareCostSubtotals.setSubTotalDirCareCostNonProdHrsOtherServBudget(root.getNursingNProdC_sum31());
			nursingCareCostSubtotals.setSubTotalDirCareCostNonProdHrsTotalBudget(root.getNursingNProdC_calcsum1());
			nursingCareCostSubtotals.setSubTotalDirCareCostHourlyRateStaffBudget(root.getNursingStaffRate_total());
			nursingCareCostSubtotals.setSubTotalDirCareCostHourlyRateContractedBudget(root.getNursingContractRate_total());
			nursingCareCostSubtotals.setSubTotalDirCareCostProdHrsAgencyStaffUtil(root.getNursingProdCASU_subsum());

			LtcBudgetDirectCareCostSubtotals alliedCareCostSubtotals = new LtcBudgetDirectCareCostSubtotals();
			alliedCareCostSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			alliedCareCostSubtotals.setDirCareType(root.getAlliedProf_label());
			alliedCareCostSubtotals.setSubTotalDirCareCostProdHrsRegularBudget(root.getAlliedProfProdC_sum11());
			alliedCareCostSubtotals.setSubTotalDirCareCostProdHrsOTBudget(root.getAlliedProfProdC_sum21());
			alliedCareCostSubtotals.setSubTotalDirCareCostProdHrsOrientationBudget(root.getAlliedProfProdC_sum31());
			alliedCareCostSubtotals.setSubTotalDirCareCostProdHrsSubtotalBudget(root.getAlliedProfProdC_calcsum1());
			alliedCareCostSubtotals.setSubTotalDirCareCostProdHrsContServBudget(root.getAlliedProfProdCCS_subsum1());
			alliedCareCostSubtotals.setSubTotalDirCareCostProdHrsTotalBudget(root.getAlliedProfProdC_subsum1());
			alliedCareCostSubtotals.setSubTotalDirCareCostTotalHrsPaidBudget(root.getAlliedProfCost_total());
			alliedCareCostSubtotals.setSubTotalDirCareCostNonProdHrsVacBudget(root.getAlliedProfNProdC_sum11());
			alliedCareCostSubtotals.setSubTotalDirCareCostNonProdHrsSickBudget(root.getAlliedNProdC_sum21());
			alliedCareCostSubtotals.setSubTotalDirCareCostNonProdHrsOtherServBudget(root.getAlliedProfNProdC_sum31());
			alliedCareCostSubtotals.setSubTotalDirCareCostNonProdHrsTotalBudget(root.getAlliedProfNProdC_calcsum1());
			alliedCareCostSubtotals.setSubTotalDirCareCostHourlyRateStaffBudget(root.getAlliedProfStaffRate_total());
			alliedCareCostSubtotals.setSubTotalDirCareCostHourlyRateContractedBudget(root.getAlliedProfContractRate_total());
			
			LtcBudgetDirectCareCostSubtotals alliedNProfCareCostSubtotals = new LtcBudgetDirectCareCostSubtotals();
			alliedNProfCareCostSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			alliedNProfCareCostSubtotals.setDirCareType(root.getAlliedNP_label());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostProdHrsRegularBudget(root.getAlliedNPProdC_sum11());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostProdHrsOTBudget(root.getAlliedNPProdC_sum21());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostProdHrsOrientationBudget(root.getAlliedNPProdC_sum31());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostProdHrsSubtotalBudget(root.getAlliedNPProdC_calcsum1());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostProdHrsContServBudget(root.getAlliedNPProdCCS_subsum1());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostProdHrsTotalBudget(root.getAlliedNPProdC_subsum1());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostTotalHrsPaidBudget(root.getAlliedNPCost_total());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostNonProdHrsVacBudget(root.getAlliedNPNProdC_sum11());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostNonProdHrsSickBudget(root.getAlliedNPNProdC_sum21());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostNonProdHrsOtherServBudget(root.getAlliedNPNProdC_sum31());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostNonProdHrsTotalBudget(root.getAlliedNPNProdC_calcsum1());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostHourlyRateStaffBudget(root.getAlliedNPStaffRate_total());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostHourlyRateContractedBudget(root.getAlliedNPContractRate_total());
			
			Collections.addAll(ltcBudgetDcCostSubttls,nursingCareCostSubtotals,alliedCareCostSubtotals,alliedNProfCareCostSubtotals);

			/*
			 * START Compensation & Benefits Budget => Direct Care => Salaries, Wages and
			 * Contracted Services.
			 */
			LtcBudgetCompSal supportFoodServices = new LtcBudgetCompSal();
			supportFoodServices.setCompSalStaffBudget(root.getSupportC_item11());
			supportFoodServices.setCompSalContractServicesBudget(root.getSupportC_item21());
			supportFoodServices.setCompSalName(root.getSupport_label1());
			supportFoodServices.setCompSalType(root.getSupport_label());
			supportFoodServices.setConfirmationId(root.getForm().getConfirmationId());
			supportFoodServices.setCompSalTotalCostBudget(root.getSupportC_calc1());
			
			LtcBudgetCompSal supportLaundryServices = new LtcBudgetCompSal();
			supportLaundryServices.setCompSalStaffBudget(root.getSupportC_item12());
			supportLaundryServices.setCompSalContractServicesBudget(root.getSupportC_item22());
			supportLaundryServices.setCompSalName(root.getSupport_label2());
			supportLaundryServices.setCompSalType(root.getSupport_label());
			supportLaundryServices.setConfirmationId(root.getForm().getConfirmationId());
			supportLaundryServices.setCompSalTotalCostBudget(root.getSupportC_calc2());

			LtcBudgetCompSal supportHousekeeping = new LtcBudgetCompSal();
			supportHousekeeping.setCompSalStaffBudget(root.getSupportC_item13());
			supportHousekeeping.setCompSalContractServicesBudget(root.getSupportC_item23());
			supportHousekeeping.setCompSalName(root.getSupport_label3());
			supportHousekeeping.setCompSalType(root.getSupport_label());
			supportHousekeeping.setConfirmationId(root.getForm().getConfirmationId());
			supportHousekeeping.setCompSalTotalCostBudget(root.getSupportC_calc3());

			LtcBudgetCompSal supportPlantMntnce = new LtcBudgetCompSal();
			supportPlantMntnce.setCompSalStaffBudget(root.getSupportC_item14());
			supportPlantMntnce.setCompSalContractServicesBudget(root.getSupportC_item24());
			supportPlantMntnce.setCompSalName(root.getSupport_label4());
			supportPlantMntnce.setCompSalType(root.getSupport_label());
			supportPlantMntnce.setConfirmationId(root.getForm().getConfirmationId());
			supportPlantMntnce.setCompSalTotalCostBudget(root.getSupportC_calc4());
			// Administration

			LtcBudgetCompSal adminAdministrator = new LtcBudgetCompSal();
			adminAdministrator.setCompSalStaffBudget(root.getAdminC_item11());
			adminAdministrator.setCompSalContractServicesBudget(root.getAdminC_item21());
			adminAdministrator.setCompSalName(root.getAdmin_label1());
			adminAdministrator.setCompSalType(root.getAdmin_label());
			adminAdministrator.setConfirmationId(root.getForm().getConfirmationId());
			adminAdministrator.setCompSalTotalCostBudget(root.getAdminC_calc1());

			LtcBudgetCompSal adminDirOfCare = new LtcBudgetCompSal();
			adminDirOfCare.setCompSalStaffBudget(root.getAdminC_item12());
			adminDirOfCare.setCompSalContractServicesBudget(root.getAdminC_item22());
			adminDirOfCare.setCompSalName(root.getAdmin_label2());
			adminDirOfCare.setCompSalType(root.getAdmin_label());
			adminDirOfCare.setConfirmationId(root.getForm().getConfirmationId());
			adminDirOfCare.setCompSalTotalCostBudget(root.getAdminC_calc2());

			LtcBudgetCompSal adminDeptManagers = new LtcBudgetCompSal();
			adminDeptManagers.setCompSalStaffBudget(root.getAdminC_item13());
			adminDeptManagers.setCompSalContractServicesBudget(root.getAdminC_item23());
			adminDeptManagers.setCompSalName(root.getAdmin_label3());
			adminDeptManagers.setCompSalType(root.getAdmin_label());
			adminDeptManagers.setConfirmationId(root.getForm().getConfirmationId());
			adminDeptManagers.setCompSalTotalCostBudget(root.getAdminC_calc3());

			LtcBudgetCompSal adminSupport = new LtcBudgetCompSal();
			adminSupport.setCompSalStaffBudget(root.getAdminC_item14());
			adminSupport.setCompSalContractServicesBudget(root.getAdminC_item24());
			adminSupport.setCompSalName(root.getAdmin_label4());
			adminSupport.setCompSalType(root.getAdmin_label());
			adminSupport.setConfirmationId(root.getForm().getConfirmationId());
			adminSupport.setCompSalTotalCostBudget(root.getAdminC_calc4());

			LtcBudgetCompSal adminPastoCareWrkr = new LtcBudgetCompSal();
			adminPastoCareWrkr.setCompSalStaffBudget(root.getAdminC_item15());
			adminPastoCareWrkr.setCompSalContractServicesBudget(root.getAdminC_item25());
			adminPastoCareWrkr.setCompSalName(root.getAdmin_label5());
			adminPastoCareWrkr.setCompSalType(root.getAdmin_label());
			adminPastoCareWrkr.setConfirmationId(root.getForm().getConfirmationId());
			adminPastoCareWrkr.setCompSalTotalCostBudget(root.getAdminC_calc5());

			LtcBudgetCompSal adminClrks = new LtcBudgetCompSal();
			adminClrks.setCompSalStaffBudget(root.getAdminC_item16());
			adminClrks.setCompSalContractServicesBudget(root.getAdminC_item26());
			adminClrks.setCompSalName(root.getAdmin_label6());
			adminClrks.setCompSalType(root.getAdmin_label());
			adminClrks.setConfirmationId(root.getForm().getConfirmationId());
			adminClrks.setCompSalTotalCostBudget(root.getAdminC_calc6());

			LtcBudgetCompSal adminClncCrdinator = new LtcBudgetCompSal();
			adminClncCrdinator.setCompSalStaffBudget(root.getAdminC_item17());
			adminClncCrdinator.setCompSalContractServicesBudget(root.getAdminC_item27());
			adminClncCrdinator.setCompSalName(root.getAdmin_label7());
			adminClncCrdinator.setCompSalType(root.getAdmin_label());
			adminClncCrdinator.setConfirmationId(root.getForm().getConfirmationId());
			adminClncCrdinator.setCompSalTotalCostBudget(root.getAdminC_calc7());

			LtcBudgetCompSal adminScreenGreeters = new LtcBudgetCompSal();
			adminScreenGreeters.setCompSalStaffBudget(root.getAdminC_item18());
			adminScreenGreeters.setCompSalContractServicesBudget(root.getAdminC_item28());
			adminScreenGreeters.setCompSalName(root.getAdmin_label8());
			adminScreenGreeters.setCompSalType(root.getAdmin_label());
			adminScreenGreeters.setConfirmationId(root.getForm().getConfirmationId());
			adminScreenGreeters.setCompSalTotalCostBudget(root.getAdminC_calc8());

			LtcBudgetCompSal adminHCSP = new LtcBudgetCompSal();
			adminHCSP.setCompSalStaffBudget(root.getAdminC_item19());
			adminHCSP.setCompSalContractServicesBudget(root.getAdminC_item29());
			adminHCSP.setCompSalName(root.getAdmin_label9());
			adminHCSP.setCompSalType(root.getAdmin_label());
			adminHCSP.setConfirmationId(root.getForm().getConfirmationId());
			adminHCSP.setCompSalTotalCostBudget(root.getAdminC_calc9());

			LtcBudgetCompSal adminOther = new LtcBudgetCompSal();
			adminOther.setCompSalStaffBudget(root.getAdminC_item110());
			adminOther.setCompSalContractServicesBudget(root.getAdminC_item210());
			adminOther.setCompSalName(Constants.DEFAULT_OTHER_VALUE);
			adminOther.setCompSalType(root.getAdmin_label());
			adminOther.setConfirmationId(root.getForm().getConfirmationId());
			adminOther.setCompSalTotalCostBudget(root.getAdminC_calc10());
			adminOther.setCompSalOtherName(root.getAdmin_label10());

			/* Direct Care Nursing */
			LtcBudgetCompSal nursingRNSal = new LtcBudgetCompSal();
			nursingRNSal.setCompSalStaffBudget(root.getCompBNursing_item11());
			nursingRNSal.setCompSalContractServicesBudget(root.getCompBNursing_item21());
			nursingRNSal.setCompSalName(root.getNursing_label_comp1());
			nursingRNSal.setCompSalType(root.getNursing_label_comp());
			nursingRNSal.setConfirmationId(root.getForm().getConfirmationId());
			nursingRNSal.setCompSalTotalCostBudget(root.getCompBNursing_calc1());
			

			LtcBudgetCompSal nursingLPNSal = new LtcBudgetCompSal();
			nursingLPNSal.setCompSalStaffBudget(root.getCompBNursing_item12());
			nursingLPNSal.setCompSalContractServicesBudget(root.getCompBNursing_item22());
			nursingLPNSal.setCompSalName(root.getNursing_label_comp2());
			nursingLPNSal.setCompSalType(root.getNursing_label_comp());
			nursingLPNSal.setConfirmationId(root.getForm().getConfirmationId());
			nursingLPNSal.setCompSalTotalCostBudget(root.getCompBNursing_calc2());

			LtcBudgetCompSal nursingHCASal = new LtcBudgetCompSal();
			nursingHCASal.setCompSalStaffBudget(root.getCompBNursing_item13());
			nursingHCASal.setCompSalContractServicesBudget(root.getCompBNursing_item23());
			nursingHCASal.setCompSalName(root.getNursing_label_comp3());
			nursingHCASal.setCompSalType(root.getNursing_label_comp());
			nursingHCASal.setConfirmationId(root.getForm().getConfirmationId());
			nursingHCASal.setCompSalTotalCostBudget(root.getCompBNursing_calc3());
			

			LtcBudgetCompSal nursingOthSal = new LtcBudgetCompSal();
			nursingOthSal.setCompSalStaffBudget(root.getCompBNursing_item14());
			nursingOthSal.setCompSalContractServicesBudget(root.getCompBNursing_item24());
			nursingOthSal.setCompSalName(Constants.DEFAULT_OTHER_VALUE);
			nursingOthSal.setCompSalType(root.getNursing_label_comp());
			nursingOthSal.setConfirmationId(root.getForm().getConfirmationId());
			nursingOthSal.setCompSalTotalCostBudget(root.getCompBNursing_calc4());
			nursingOthSal.setCompSalOtherName(root.getNursing_label_comp4());

			/* Allied Professional */
			LtcBudgetCompSal alliedProfOTSal = new LtcBudgetCompSal();
			alliedProfOTSal.setCompSalStaffBudget(root.getCompBAlliedProf_item11());
			alliedProfOTSal.setCompSalContractServicesBudget(root.getCompBAlliedProf_item21());
			alliedProfOTSal.setCompSalName(root.getAlliedProf_label_comp1());
			alliedProfOTSal.setCompSalType(root.getAlliedProf_label_comp());
			alliedProfOTSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfOTSal.setCompSalTotalCostBudget(root.getCompBAlliedProf_calc1());

			LtcBudgetCompSal alliedProfPTSal = new LtcBudgetCompSal();
			alliedProfPTSal.setCompSalStaffBudget(root.getCompBAlliedProf_item12());
			alliedProfPTSal.setCompSalContractServicesBudget(root.getCompBAlliedProf_item22());
			alliedProfPTSal.setCompSalName(root.getAlliedProf_label_comp2());
			alliedProfPTSal.setCompSalType(root.getAlliedProf_label_comp());
			alliedProfPTSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfPTSal.setCompSalTotalCostBudget(root.getCompBAlliedProf_calc2());

			LtcBudgetCompSal alliedProfDTSal = new LtcBudgetCompSal();
			alliedProfDTSal.setCompSalStaffBudget(root.getCompBAlliedProf_item13());
			alliedProfDTSal.setCompSalContractServicesBudget(root.getCompBAlliedProf_item23());
			alliedProfDTSal.setCompSalName(root.getAlliedProf_label_comp3());
			alliedProfDTSal.setCompSalType(root.getAlliedProf_label_comp());
			alliedProfDTSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfDTSal.setCompSalTotalCostBudget(root.getCompBAlliedProf_calc3());

			LtcBudgetCompSal alliedProfSWSal = new LtcBudgetCompSal();
			alliedProfSWSal.setCompSalStaffBudget(root.getCompBAlliedProf_item14());
			alliedProfSWSal.setCompSalContractServicesBudget(root.getCompBAlliedProf_item24());
			alliedProfSWSal.setCompSalName(root.getAlliedProf_label_comp4());
			alliedProfSWSal.setCompSalType(root.getAlliedProf_label_comp());
			alliedProfSWSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfSWSal.setCompSalTotalCostBudget(root.getCompBAlliedProf_calc4());

			LtcBudgetCompSal alliedProfSLPSal = new LtcBudgetCompSal();
			alliedProfSLPSal.setCompSalStaffBudget(root.getCompBAlliedProf_item15());
			alliedProfSLPSal.setCompSalContractServicesBudget(root.getCompBAlliedProf_item25());
			alliedProfSLPSal.setCompSalName(root.getAlliedProf_label_comp5());
			alliedProfSLPSal.setCompSalType(root.getAlliedProf_label_comp());
			alliedProfSLPSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfSLPSal.setCompSalTotalCostBudget(root.getCompBAlliedProf_calc5());

			LtcBudgetCompSal alliedProfRPPSal = new LtcBudgetCompSal();
			alliedProfRPPSal.setCompSalStaffBudget(root.getCompBAlliedProf_item16());
			alliedProfRPPSal.setCompSalContractServicesBudget(root.getCompBAlliedProf_item26());
			alliedProfRPPSal.setCompSalName(root.getAlliedProf_label_comp6());
			alliedProfRPPSal.setCompSalType(root.getAlliedProf_label_comp());
			alliedProfRPPSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfRPPSal.setCompSalTotalCostBudget(root.getCompBAlliedProf_calc6());

			LtcBudgetCompSal alliedProfOTHSal = new LtcBudgetCompSal();
			alliedProfOTHSal.setCompSalStaffBudget(root.getCompBAlliedProf_item17());
			alliedProfOTHSal.setCompSalContractServicesBudget(root.getCompBAlliedProf_item27());
			alliedProfOTHSal.setCompSalName(Constants.DEFAULT_OTHER_VALUE);
			alliedProfOTHSal.setCompSalType(root.getAlliedProf_label_comp());
			alliedProfOTHSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfOTHSal.setCompSalTotalCostBudget(root.getCompBAlliedProf_calc7());
			alliedProfOTHSal.setCompSalOtherName(root.getAlliedProf_label_comp7());

			/* Allied Non Professional */
			LtcBudgetCompSal alliedNPRTSal = new LtcBudgetCompSal();
			alliedNPRTSal.setCompSalStaffBudget(root.getCompBAlliedNP_item11());
			alliedNPRTSal.setCompSalContractServicesBudget(root.getCompBAlliedNP_item21());
			alliedNPRTSal.setCompSalName(root.getAlliedNP_label_comp1());
			alliedNPRTSal.setCompSalType(root.getAlliedNP_label_comp());
			alliedNPRTSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRTSal.setCompSalTotalCostBudget(root.getCompBAlliedNP_calc1());

			LtcBudgetCompSal alliedNPRASal = new LtcBudgetCompSal();
			alliedNPRASal.setCompSalStaffBudget(root.getCompBAlliedNP_item12());
			alliedNPRASal.setCompSalContractServicesBudget(root.getCompBAlliedNP_item22());
			alliedNPRASal.setCompSalName(root.getAlliedNP_label_comp2());
			alliedNPRASal.setCompSalType(root.getAlliedNP_label_comp());
			alliedNPRASal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRASal.setCompSalTotalCostBudget(root.getCompBAlliedNP_calc2());

			LtcBudgetCompSal alliedNPAWSal = new LtcBudgetCompSal();
			alliedNPAWSal.setCompSalStaffBudget(root.getCompBAlliedNP_item13());
			alliedNPAWSal.setCompSalContractServicesBudget(root.getCompBAlliedNP_item23());
			alliedNPAWSal.setCompSalName(root.getAlliedNP_label_comp3());
			alliedNPAWSal.setCompSalType(root.getAlliedNP_label_comp());
			alliedNPAWSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPAWSal.setCompSalTotalCostBudget(root.getCompBAlliedNP_calc3());

			LtcBudgetCompSal alliedNPMTSal = new LtcBudgetCompSal();
			alliedNPMTSal.setCompSalStaffBudget(root.getCompBAlliedNP_item14());
			alliedNPMTSal.setCompSalContractServicesBudget(root.getCompBAlliedNP_item24());
			alliedNPMTSal.setCompSalName(root.getAlliedNP_label_comp4());
			alliedNPMTSal.setCompSalType(root.getAlliedNP_label_comp());
			alliedNPMTSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPMTSal.setCompSalTotalCostBudget(root.getCompBAlliedNP_calc4());

			LtcBudgetCompSal alliedNPATSal = new LtcBudgetCompSal();
			alliedNPATSal.setCompSalStaffBudget(root.getCompBAlliedNP_item15());
			alliedNPATSal.setCompSalContractServicesBudget(root.getCompBAlliedNP_item25());
			alliedNPATSal.setCompSalName(root.getAlliedNP_label_comp5());
			alliedNPATSal.setCompSalType(root.getAlliedNP_label_comp());
			alliedNPATSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPATSal.setCompSalTotalCostBudget(root.getCompBAlliedNP_calc5());

			LtcBudgetCompSal alliedNPOTHSal = new LtcBudgetCompSal();
			alliedNPOTHSal.setCompSalStaffBudget(root.getCompBAlliedNP_item16());
			alliedNPOTHSal.setCompSalContractServicesBudget(root.getCompBAlliedNP_item26());
			alliedNPOTHSal.setCompSalName(Constants.DEFAULT_OTHER_VALUE);
			alliedNPOTHSal.setCompSalType(root.getAlliedNP_label_comp());
			alliedNPOTHSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPOTHSal.setCompSalTotalCostBudget(root.getCompBAlliedNP_calc6());
			alliedNPOTHSal.setCompSalOtherName(root.getAlliedNP_label_comp6());

			Collections.addAll(ltcBudgetCompSal, supportFoodServices, supportLaundryServices, supportHousekeeping,
					supportPlantMntnce, adminAdministrator, adminDirOfCare, adminDeptManagers, adminSupport,
					adminPastoCareWrkr, adminClrks, adminClncCrdinator, adminScreenGreeters, adminHCSP, adminOther, nursingRNSal,
					nursingLPNSal, nursingHCASal, nursingOthSal, alliedProfOTSal, alliedProfPTSal, alliedProfDTSal, alliedProfSWSal,
					alliedProfSLPSal, alliedProfRPPSal, alliedProfOTHSal, alliedNPRTSal, alliedNPRASal,
					alliedNPAWSal, alliedNPMTSal, alliedNPATSal, alliedNPOTHSal);
					

			LtcBudgetCompSalSubtotals supportSalSubtotal = new LtcBudgetCompSalSubtotals();
			supportSalSubtotal.setCompSalType(root.getSupport_label());
			supportSalSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			supportSalSubtotal.setSubTotalCompSalStaffBudget(root.getSupportC_sum1());
			supportSalSubtotal.setSubTotalCompSalContractServicesBudget(root.getSupportC_sum2());
			supportSalSubtotal.setSubTotalCompSalTotalCostBudget(root.getSupportC_calcsum());

			LtcBudgetCompSalSubtotals administrationSalSubtotal = new LtcBudgetCompSalSubtotals();
			administrationSalSubtotal.setCompSalType(root.getAdmin_label());
			administrationSalSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			administrationSalSubtotal.setSubTotalCompSalStaffBudget(root.getAdminC_sum1());
			administrationSalSubtotal.setSubTotalCompSalContractServicesBudget(root.getAdminC_sum2());
			administrationSalSubtotal.setSubTotalCompSalTotalCostBudget(root.getAdminC_calcsum());

			LtcBudgetCompSalSubtotals nursingSalSubtotal = new LtcBudgetCompSalSubtotals();
			nursingSalSubtotal.setCompSalType(root.getNursing_label_comp());
			nursingSalSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			nursingSalSubtotal.setSubTotalCompSalStaffBudget(root.getCompBNursing_sum1());
			nursingSalSubtotal.setSubTotalCompSalContractServicesBudget(root.getCompBNursing_sum2());
			nursingSalSubtotal.setSubTotalCompSalTotalCostBudget(root.getCompBNursing_calcsum());

			LtcBudgetCompSalSubtotals alliedSalSubtotal = new LtcBudgetCompSalSubtotals();
			alliedSalSubtotal.setCompSalType(root.getAlliedProf_label_comp());
			alliedSalSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			alliedSalSubtotal.setSubTotalCompSalStaffBudget(root.getCompBAlliedProf_sum1());
			alliedSalSubtotal.setSubTotalCompSalContractServicesBudget(root.getCompBAlliedProf_sum2());
			alliedSalSubtotal.setSubTotalCompSalTotalCostBudget(root.getCompBAlliedProf_calcsum());

			LtcBudgetCompSalSubtotals alliedNPSalSubtotal = new LtcBudgetCompSalSubtotals();
			alliedNPSalSubtotal.setCompSalType(root.getAlliedNP_label_comp());
			alliedNPSalSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPSalSubtotal.setSubTotalCompSalStaffBudget(root.getCompBAlliedNP_sum1());
			alliedNPSalSubtotal.setSubTotalCompSalContractServicesBudget(root.getCompBAlliedNP_sum2());
			alliedNPSalSubtotal.setSubTotalCompSalTotalCostBudget(root.getCompBAlliedNP_calcsum());

			Collections.addAll(ltcBudgetCompSalSubttls,administrationSalSubtotal,nursingSalSubtotal,supportSalSubtotal,alliedSalSubtotal,alliedNPSalSubtotal);

			LtcBudgetCompSalTotals totalPerPayrollSal = new LtcBudgetCompSalTotals();
			totalPerPayrollSal.setCompSalType(root.getCompB_total_label());
			totalPerPayrollSal.setConfirmationId(root.getForm().getConfirmationId());
			totalPerPayrollSal.setTotalCompSalStaffBudget(root.getCompB_total1());
			totalPerPayrollSal.setTotalCompSalContractServicesBudget(root.getCompB_total2());
			totalPerPayrollSal.setTotalCompSalTotalCostBudget(root.getCompB_total());

			LtcBudgetCompSalTotals recoveredPerPayrollSal = new LtcBudgetCompSalTotals();
			recoveredPerPayrollSal.setCompSalType(root.getCompB_recovered_label());
			recoveredPerPayrollSal.setConfirmationId(root.getForm().getConfirmationId());
			recoveredPerPayrollSal.setTotalCompSalStaffBudget(root.getCompB_recovered1());
			recoveredPerPayrollSal.setTotalCompSalContractServicesBudget(root.getCompB_recovered2());
			recoveredPerPayrollSal.setTotalCompSalTotalCostBudget(root.getCompB_recovered());

			LtcBudgetCompSalTotals accruedPerPayrollSal = new LtcBudgetCompSalTotals();
			accruedPerPayrollSal.setCompSalType(root.getCompB_accrued_label());
			accruedPerPayrollSal.setConfirmationId(root.getForm().getConfirmationId());
			accruedPerPayrollSal.setTotalCompSalStaffBudget(root.getCompB_accrued1());
			accruedPerPayrollSal.setTotalCompSalContractServicesBudget(root.getCompB_accrued2());
			accruedPerPayrollSal.setTotalCompSalTotalCostBudget(root.getCompB_accrued());

			LtcBudgetCompSalTotals otherPerPayrollSal = new LtcBudgetCompSalTotals();
			otherPerPayrollSal.setCompSalType(root.getCompB_laborOther_label());
			otherPerPayrollSal.setConfirmationId(root.getForm().getConfirmationId());
			otherPerPayrollSal.setTotalCompSalStaffBudget(root.getCompB_laborOther1());
			otherPerPayrollSal.setTotalCompSalContractServicesBudget(root.getCompB_laborOther2());
			otherPerPayrollSal.setTotalCompSalTotalCostBudget(root.getCompB_laborOther());

			Collections.addAll(ltcBudgetCompsalTtls,totalPerPayrollSal,recoveredPerPayrollSal,accruedPerPayrollSal,otherPerPayrollSal);

			/* Hours for Staff and Contracted Services */
			LtcBudgetCompHrs supportFoodServicesHrs = new LtcBudgetCompHrs();
			//supportFoodServicesHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP1());
			supportFoodServicesHrs.setCompHrsStaffBudget(root.getSupportH_item11());
			supportFoodServicesHrs.setCompHrsContractServicesBudget(root.getSupportH_item21());
			supportFoodServicesHrs.setCompHrsName(root.getSupport_label1());
			supportFoodServicesHrs.setCompHrsType(root.getSupport_label());
			supportFoodServicesHrs.setConfirmationId(root.getForm().getConfirmationId());
			supportFoodServicesHrs.setCompTotalWorkedHrsBudget(root.getSupportH_calc1());

			LtcBudgetCompHrs supportLaundryServicesHrs = new LtcBudgetCompHrs();
			//supportLaundryServicesHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP2());
			supportLaundryServicesHrs.setCompHrsStaffBudget(root.getSupportH_item12());
			supportLaundryServicesHrs.setCompHrsContractServicesBudget(root.getSupportH_item22());
			supportLaundryServicesHrs.setCompHrsName(root.getSupport_label2());
			supportLaundryServicesHrs.setCompHrsType(root.getSupport_label());
			supportLaundryServicesHrs.setConfirmationId(root.getForm().getConfirmationId());
			supportLaundryServicesHrs.setCompTotalWorkedHrsBudget(root.getSupportH_calc2());

			LtcBudgetCompHrs supportHousekeepingHrs = new LtcBudgetCompHrs();
			//supportHousekeepingHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP3());
			supportHousekeepingHrs.setCompHrsStaffBudget(root.getSupportH_item13());
			supportHousekeepingHrs.setCompHrsContractServicesBudget(root.getSupportH_item23());
			supportHousekeepingHrs.setCompHrsName(root.getSupport_label3());
			supportHousekeepingHrs.setCompHrsType(root.getSupport_label());
			supportHousekeepingHrs.setConfirmationId(root.getForm().getConfirmationId());
			supportHousekeepingHrs.setCompTotalWorkedHrsBudget(root.getSupportH_calc3());

			LtcBudgetCompHrs supportPlantMntnceHrs = new LtcBudgetCompHrs();
		//	supportPlantMntnceHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP4());
			supportPlantMntnceHrs.setCompHrsStaffBudget(root.getSupportH_item14());
			supportPlantMntnceHrs.setCompHrsContractServicesBudget(root.getSupportH_item24());
			supportPlantMntnceHrs.setCompHrsName(root.getSupport_label4());
			supportPlantMntnceHrs.setCompHrsType(root.getSupport_label());
			supportPlantMntnceHrs.setConfirmationId(root.getForm().getConfirmationId());
			supportPlantMntnceHrs.setCompTotalWorkedHrsBudget(root.getSupportH_calc4());

			// sum remaining
			LtcBudgetCompHrs adminAdministratorHrs = new LtcBudgetCompHrs();
		//	adminAdministratorHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP5());
			adminAdministratorHrs.setCompHrsStaffBudget(root.getAdminH_item11());
			adminAdministratorHrs.setCompHrsContractServicesBudget(root.getAdminH_item21());
			adminAdministratorHrs.setCompHrsName(root.getAdmin_label1());
			adminAdministratorHrs.setCompHrsType(root.getAdmin_label());
			adminAdministratorHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminAdministratorHrs.setCompTotalWorkedHrsBudget(root.getAdminH_calc1());


			LtcBudgetCompHrs adminDirOfCareHrs = new LtcBudgetCompHrs();
			//adminDirOfCareHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP6());
			adminDirOfCareHrs.setCompHrsStaffBudget(root.getAdminH_item12());
			adminDirOfCareHrs.setCompHrsContractServicesBudget(root.getAdminH_item22());
			adminDirOfCareHrs.setCompHrsName(root.getAdmin_label2());
			adminDirOfCareHrs.setCompHrsType(root.getAdmin_label());
			adminDirOfCareHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminDirOfCareHrs.setCompTotalWorkedHrsBudget(root.getAdminH_calc2());

			LtcBudgetCompHrs adminDeptManagersHrs = new LtcBudgetCompHrs();
		//	adminDeptManagersHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP7());
			adminDeptManagersHrs.setCompHrsStaffBudget(root.getAdminH_item13());
			adminDeptManagersHrs.setCompHrsContractServicesBudget(root.getAdminH_item23());
			adminDeptManagersHrs.setCompHrsName(root.getAdmin_label3());
			adminDeptManagersHrs.setCompHrsType(root.getAdmin_label());
			adminDeptManagersHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminDeptManagersHrs.setCompTotalWorkedHrsBudget(root.getAdminH_calc3());

			LtcBudgetCompHrs adminSupportHrs = new LtcBudgetCompHrs();
			//adminSupportHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP8());
			adminSupportHrs.setCompHrsStaffBudget(root.getAdminH_item14());
			adminSupportHrs.setCompHrsContractServicesBudget(root.getAdminH_item24());
			adminSupportHrs.setCompHrsName(root.getAdmin_label4());
			adminSupportHrs.setCompHrsType(root.getAdmin_label());
			adminSupportHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminSupportHrs.setCompTotalWorkedHrsBudget(root.getAdminH_calc4());

			LtcBudgetCompHrs adminPastoCareWrkrHrs = new LtcBudgetCompHrs();
		//	adminPastoCareWrkrHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP9());
			adminPastoCareWrkrHrs.setCompHrsStaffBudget(root.getAdminH_item15());
			adminPastoCareWrkrHrs.setCompHrsContractServicesBudget(root.getAdminH_item25());
			adminPastoCareWrkrHrs.setCompHrsName(root.getAdmin_label5());
			adminPastoCareWrkrHrs.setCompHrsType(root.getAdmin_label());
			adminPastoCareWrkrHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminPastoCareWrkrHrs.setCompTotalWorkedHrsBudget(root.getAdminH_calc5());

			LtcBudgetCompHrs adminClrksHrs = new LtcBudgetCompHrs();
			//adminClrksHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP10());
			adminClrksHrs.setCompHrsStaffBudget(root.getAdminH_item16());
			adminClrksHrs.setCompHrsContractServicesBudget(root.getAdminH_item26());
			adminClrksHrs.setCompHrsName(root.getAdmin_label6());
			adminClrksHrs.setCompHrsType(root.getAdmin_label());
			adminClrksHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminClrksHrs.setCompTotalWorkedHrsBudget(root.getAdminH_calc6());

			LtcBudgetCompHrs adminClncCrdinatorHrs = new LtcBudgetCompHrs();
		//	adminClncCrdinatorHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP11());
			adminClncCrdinatorHrs.setCompHrsStaffBudget(root.getAdminH_item17());
			adminClncCrdinatorHrs.setCompHrsContractServicesBudget(root.getAdminH_item27());
			adminClncCrdinatorHrs.setCompHrsName(root.getAdmin_label7());
			adminClncCrdinatorHrs.setCompHrsType(root.getAdmin_label());
			adminClncCrdinatorHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminClncCrdinatorHrs.setCompTotalWorkedHrsBudget(root.getAdminH_calc7());

			LtcBudgetCompHrs adminScreenersGreeters = new LtcBudgetCompHrs();
			adminScreenersGreeters.setCompHrsStaffBudget(root.getAdminH_item18());
			adminScreenersGreeters.setCompHrsContractServicesBudget(root.getAdminH_item28());
			adminScreenersGreeters.setCompHrsName(root.getAdmin_label8());
			adminScreenersGreeters.setCompHrsType(root.getAdmin_label());
			adminScreenersGreeters.setConfirmationId(root.getForm().getConfirmationId());
			adminScreenersGreeters.setCompTotalWorkedHrsBudget(root.getAdminH_calc8());

			LtcBudgetCompHrs adminHCSW = new LtcBudgetCompHrs();
			adminHCSW.setCompHrsStaffBudget(root.getAdminH_item19());
			adminHCSW.setCompHrsContractServicesBudget(root.getAdminH_item29());
			adminHCSW.setCompHrsName(root.getAdmin_label9());
			adminHCSW.setCompHrsType(root.getAdmin_label());
			adminHCSW.setConfirmationId(root.getForm().getConfirmationId());
			adminHCSW.setCompTotalWorkedHrsBudget(root.getAdminH_calc9());

			LtcBudgetCompHrs adminOtherHrs = new LtcBudgetCompHrs();
		//	adminOtherHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP12());
			adminOtherHrs.setCompHrsStaffBudget(root.getAdminH_item110());
			adminOtherHrs.setCompHrsContractServicesBudget(root.getAdminH_item210());
			adminOtherHrs.setCompHrsName(Constants.DEFAULT_OTHER_VALUE);
			adminOtherHrs.setCompHrsType(root.getAdmin_label());
			adminOtherHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminOtherHrs.setCompTotalWorkedHrsBudget(root.getAdminH_calc10());
			adminOtherHrs.setCompHrsOtherName(root.getAdmin_label10());

			/* Nursing, Allied, Non Allied Hours */
			LtcBudgetCompHrs nursingRNHrs = new LtcBudgetCompHrs();
			//nursingRNHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP13());
			nursingRNHrs.setCompHrsStaffBudget(root.getCompHNursing_item11());
			nursingRNHrs.setCompHrsContractServicesBudget(root.getCompHNursing_item21());
			nursingRNHrs.setCompHrsName(root.getNursing_label_comp1());
			nursingRNHrs.setCompHrsType(root.getNursing_label_comp());
			nursingRNHrs.setConfirmationId(root.getForm().getConfirmationId());
			nursingRNHrs.setCompTotalWorkedHrsBudget(root.getCompHNursing_calc1());

			LtcBudgetCompHrs nursingLPNHrs = new LtcBudgetCompHrs();
			//nursingLPNHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP14());
			nursingLPNHrs.setCompHrsStaffBudget(root.getCompHNursing_item12());
			nursingLPNHrs.setCompHrsContractServicesBudget(root.getCompHNursing_item22());
			nursingLPNHrs.setCompHrsName(root.getNursing_label_comp2());
			nursingLPNHrs.setCompHrsType(root.getNursing_label_comp());
			nursingLPNHrs.setConfirmationId(root.getForm().getConfirmationId());
			nursingLPNHrs.setCompTotalWorkedHrsBudget(root.getCompHNursing_calc2());

			LtcBudgetCompHrs nursingHCAHrs = new LtcBudgetCompHrs();
			//nursingHCAHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP15());
			nursingHCAHrs.setCompHrsStaffBudget(root.getCompHNursing_item13());
			nursingHCAHrs.setCompHrsContractServicesBudget(root.getCompHNursing_item23());
			nursingHCAHrs.setCompHrsName(root.getNursing_label_comp3());
			nursingHCAHrs.setCompHrsType(root.getNursing_label_comp());
			nursingHCAHrs.setConfirmationId(root.getForm().getConfirmationId());
			nursingHCAHrs.setCompTotalWorkedHrsBudget(root.getCompHNursing_calc3());

			LtcBudgetCompHrs nursingOthHrs = new LtcBudgetCompHrs();
			//nursingOthHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP16());
			nursingOthHrs.setCompHrsStaffBudget(root.getCompHNursing_item14());
			nursingOthHrs.setCompHrsContractServicesBudget(root.getCompHNursing_item24());
			nursingOthHrs.setCompHrsName(Constants.DEFAULT_OTHER_VALUE);
			nursingOthHrs.setCompHrsType(root.getNursing_label_comp());
			nursingOthHrs.setConfirmationId(root.getForm().getConfirmationId());
			nursingOthHrs.setCompTotalWorkedHrsBudget(root.getCompHNursing_calc4());
			nursingOthHrs.setCompHrsOtherName(root.getNursing_label_comp4());

			LtcBudgetCompHrs alliedProfOTHrs = new LtcBudgetCompHrs();
			//alliedProfOTHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP17());
			alliedProfOTHrs.setCompHrsStaffBudget(root.getCompHAlliedProf_item11());
			alliedProfOTHrs.setCompHrsContractServicesBudget(root.getCompHAlliedProf_item21());
			alliedProfOTHrs.setCompHrsName(root.getAlliedProf_label_comp1());
			alliedProfOTHrs.setCompHrsType(root.getAlliedProf_label_comp());
			alliedProfOTHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfOTHrs.setCompTotalWorkedHrsBudget(root.getCompHAlliedProf_calc1());

			LtcBudgetCompHrs alliedProfPTHrs = new LtcBudgetCompHrs();
			//alliedProfPTHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP18());
			alliedProfPTHrs.setCompHrsStaffBudget(root.getCompHAlliedProf_item12());
			alliedProfPTHrs.setCompHrsContractServicesBudget(root.getCompHAlliedProf_item22());
			alliedProfPTHrs.setCompHrsName(root.getAlliedProf_label_comp2());
			alliedProfPTHrs.setCompHrsType(root.getAlliedProf_label_comp());
			alliedProfPTHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfPTHrs.setCompTotalWorkedHrsBudget(root.getCompHAlliedProf_calc2());

			LtcBudgetCompHrs alliedProfDTHrs = new LtcBudgetCompHrs();
			//alliedProfDTHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP19());
			alliedProfDTHrs.setCompHrsStaffBudget(root.getCompHAlliedProf_item13());
			alliedProfDTHrs.setCompHrsContractServicesBudget(root.getCompHAlliedProf_item23());
			alliedProfDTHrs.setCompHrsName(root.getAlliedProf_label_comp3());
			alliedProfDTHrs.setCompHrsType(root.getAlliedProf_label_comp());
			alliedProfDTHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfDTHrs.setCompTotalWorkedHrsBudget(root.getCompHAlliedProf_calc3());

			LtcBudgetCompHrs alliedProfSWHrs = new LtcBudgetCompHrs();
			//alliedProfSWHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP20());
			alliedProfSWHrs.setCompHrsStaffBudget(root.getCompHAlliedProf_item14());
			alliedProfSWHrs.setCompHrsContractServicesBudget(root.getCompHAlliedProf_item24());
			alliedProfSWHrs.setCompHrsName(root.getAlliedProf_label_comp4());
			alliedProfSWHrs.setCompHrsType(root.getAlliedProf_label_comp());
			alliedProfSWHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfSWHrs.setCompTotalWorkedHrsBudget(root.getCompHAlliedProf_calc4());

			LtcBudgetCompHrs alliedProfSLPHrs = new LtcBudgetCompHrs();
			//alliedProfSWHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP20());
			alliedProfSLPHrs.setCompHrsStaffBudget(root.getCompHAlliedProf_item15());
			alliedProfSLPHrs.setCompHrsContractServicesBudget(root.getCompHAlliedProf_item25());
			alliedProfSLPHrs.setCompHrsName(root.getAlliedProf_label_comp5());
			alliedProfSLPHrs.setCompHrsType(root.getAlliedProf_label_comp());
			alliedProfSLPHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfSLPHrs.setCompTotalWorkedHrsBudget(root.getCompHAlliedProf_calc5());

			LtcBudgetCompHrs alliedProfRTHrs = new LtcBudgetCompHrs();
			//alliedProfSWHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP20());
			alliedProfRTHrs.setCompHrsStaffBudget(root.getCompHAlliedProf_item16());
			alliedProfRTHrs.setCompHrsContractServicesBudget(root.getCompHAlliedProf_item26());
			alliedProfRTHrs.setCompHrsName(root.getAlliedProf_label_comp6());
			alliedProfRTHrs.setCompHrsType(root.getAlliedProf_label_comp());
			alliedProfRTHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfRTHrs.setCompTotalWorkedHrsBudget(root.getCompHAlliedProf_calc6());

			LtcBudgetCompHrs alliedProfOTHHrs = new LtcBudgetCompHrs();
			//alliedProfOTHHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP21());
			alliedProfOTHHrs.setCompHrsStaffBudget(root.getCompHAlliedProf_item17());
			alliedProfOTHHrs.setCompHrsContractServicesBudget(root.getCompHAlliedProf_item27());
			alliedProfOTHHrs.setCompHrsName(Constants.DEFAULT_OTHER_VALUE);
			alliedProfOTHHrs.setCompHrsType(root.getAlliedProf_label_comp());
			alliedProfOTHHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfOTHHrs.setCompTotalWorkedHrsBudget(root.getCompHAlliedProf_calc7());
			alliedProfOTHHrs.setCompHrsOtherName(root.getAlliedProf_label_comp7());

			LtcBudgetCompHrs alliedNPRTHrs = new LtcBudgetCompHrs();
			//alliedNPRTHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP22());
			alliedNPRTHrs.setCompHrsStaffBudget(root.getCompHAlliedNP_item11());
			alliedNPRTHrs.setCompHrsContractServicesBudget(root.getCompHAlliedNP_item21());
			alliedNPRTHrs.setCompHrsName(root.getAlliedNP_label_comp1());
			alliedNPRTHrs.setCompHrsType(root.getAlliedNP_label_comp());
			alliedNPRTHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRTHrs.setCompTotalWorkedHrsBudget(root.getCompHAlliedNP_calc1());

			LtcBudgetCompHrs alliedNPRAHrs = new LtcBudgetCompHrs();
			//alliedNPRAHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP23());
			alliedNPRAHrs.setCompHrsStaffBudget(root.getCompHAlliedNP_item12());
			alliedNPRAHrs.setCompHrsContractServicesBudget(root.getCompHAlliedNP_item22());
			alliedNPRAHrs.setCompHrsName(root.getAlliedNP_label_comp2());
			alliedNPRAHrs.setCompHrsType(root.getAlliedNP_label_comp());
			alliedNPRAHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRAHrs.setCompTotalWorkedHrsBudget(root.getCompHAlliedNP_calc2());

			LtcBudgetCompHrs alliedNPAWHrs = new LtcBudgetCompHrs();
			//alliedNPAWHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP24());
			alliedNPAWHrs.setCompHrsStaffBudget(root.getCompHAlliedNP_item13());
			alliedNPAWHrs.setCompHrsContractServicesBudget(root.getCompHAlliedNP_item23());
			alliedNPAWHrs.setCompHrsName(root.getAlliedNP_label_comp3());
			alliedNPAWHrs.setCompHrsType(root.getAlliedNP_label_comp());
			alliedNPAWHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPAWHrs.setCompTotalWorkedHrsBudget(root.getCompHAlliedNP_calc3());

			LtcBudgetCompHrs alliedNPMTHrs = new LtcBudgetCompHrs();
			//alliedNPMTHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP25());
			alliedNPMTHrs.setCompHrsStaffBudget(root.getCompHAlliedNP_item14());
			alliedNPMTHrs.setCompHrsContractServicesBudget(root.getCompHAlliedNP_item24());
			alliedNPMTHrs.setCompHrsName(root.getAlliedNP_label_comp4());
			alliedNPMTHrs.setCompHrsType(root.getAlliedNP_label_comp());
			alliedNPMTHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPMTHrs.setCompTotalWorkedHrsBudget(root.getCompHAlliedNP_calc4());

			LtcBudgetCompHrs alliedNPATHrs = new LtcBudgetCompHrs();
			//alliedNPATHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP26());
			alliedNPATHrs.setCompHrsStaffBudget(root.getCompHAlliedNP_item15());
			alliedNPATHrs.setCompHrsContractServicesBudget(root.getCompHAlliedNP_item25());
			alliedNPATHrs.setCompHrsName(root.getAlliedNP_label_comp5());
			alliedNPATHrs.setCompHrsType(root.getAlliedNP_label_comp());
			alliedNPATHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPATHrs.setCompTotalWorkedHrsBudget(root.getCompHAlliedNP_calc5());

			LtcBudgetCompHrs alliedNPOTHHrs = new LtcBudgetCompHrs();
			//alliedNPOTHHrs.setCompHrsPerPayrollBudget(root.getCompH_PHP27());
			alliedNPOTHHrs.setCompHrsStaffBudget(root.getCompHAlliedNP_item16());
			alliedNPOTHHrs.setCompHrsContractServicesBudget(root.getCompHAlliedNP_item26());
			alliedNPOTHHrs.setCompHrsName(Constants.DEFAULT_OTHER_VALUE);
			alliedNPOTHHrs.setCompHrsType(root.getAlliedNP_label_comp());
			alliedNPOTHHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPOTHHrs.setCompTotalWorkedHrsBudget(root.getCompHAlliedNP_calc6());
			alliedNPOTHHrs.setCompHrsOtherName(root.getAlliedNP_label_comp6());

			Collections.addAll(ltcBudgetCompHrs, supportFoodServicesHrs, supportLaundryServicesHrs, supportHousekeepingHrs,
					supportPlantMntnceHrs, adminAdministratorHrs, adminDirOfCareHrs, adminDeptManagersHrs,
					adminSupportHrs, adminPastoCareWrkrHrs, adminClrksHrs, adminClncCrdinatorHrs, adminScreenersGreeters, adminHCSW, 
					adminOtherHrs, nursingRNHrs, nursingLPNHrs, nursingHCAHrs, nursingOthHrs, alliedProfOTHrs, alliedProfPTHrs,
					alliedProfDTHrs, alliedProfSWHrs, alliedProfSLPHrs, alliedProfRTHrs, alliedProfOTHHrs, alliedNPRTHrs, alliedNPRAHrs, alliedNPAWHrs,
					alliedNPMTHrs, alliedNPATHrs, alliedNPOTHHrs);

			/* Subtotals */
			LtcBudgetCompHrsSubtotals supportHrsSubtotals = new LtcBudgetCompHrsSubtotals();
			supportHrsSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			supportHrsSubtotals.setCompHrsType(root.getSupport_label());
			supportHrsSubtotals.setSubTotalCompHrsStaffBudget(root.getSupportH_sum1());
			supportHrsSubtotals.setSubTotalCompHrsContractServicesBudget(root.getSupportH_sum2());
			supportHrsSubtotals.setSubTotalCompTotalWorkedHrsBudget(root.getSupportH_calcsum());
			
			LtcBudgetCompHrsSubtotals adminHrsSubtotals = new LtcBudgetCompHrsSubtotals();
			adminHrsSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			adminHrsSubtotals.setCompHrsType(root.getAdmin_label());
			adminHrsSubtotals.setSubTotalCompHrsStaffBudget(root.getAdminH_sum1());
			adminHrsSubtotals.setSubTotalCompHrsContractServicesBudget(root.getAdminH_sum2());
			adminHrsSubtotals.setSubTotalCompTotalWorkedHrsBudget(root.getAdminH_calcsum());

			LtcBudgetCompHrsSubtotals nursingHrsSubtotals = new LtcBudgetCompHrsSubtotals();
			nursingHrsSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			nursingHrsSubtotals.setCompHrsType(root.getNursing_label_comp());
			nursingHrsSubtotals.setSubTotalCompHrsStaffBudget(root.getCompHNursing_sum1());
			nursingHrsSubtotals.setSubTotalCompHrsContractServicesBudget(root.getCompHNursing_sum2());
			nursingHrsSubtotals.setSubTotalCompTotalWorkedHrsBudget(root.getCompHNursing_calcsum());

			LtcBudgetCompHrsSubtotals alliedHrsSubtotals = new LtcBudgetCompHrsSubtotals();
			alliedHrsSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			alliedHrsSubtotals.setCompHrsType(root.getAlliedProf_label_comp());
			alliedHrsSubtotals.setSubTotalCompHrsStaffBudget(root.getCompHAlliedProf_sum1());
			alliedHrsSubtotals.setSubTotalCompHrsContractServicesBudget(root.getCompHAlliedProf_sum2());
			alliedHrsSubtotals.setSubTotalCompTotalWorkedHrsBudget(root.getCompHAlliedProf_calcsum());

			LtcBudgetCompHrsSubtotals alliedNPHrsSubtotals = new LtcBudgetCompHrsSubtotals();
			alliedNPHrsSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			alliedNPHrsSubtotals.setCompHrsType(root.getAlliedNP_label_comp());
			alliedNPHrsSubtotals.setSubTotalCompHrsStaffBudget(root.getCompHAlliedNP_sum1());
			alliedNPHrsSubtotals.setSubTotalCompHrsContractServicesBudget(root.getCompHAlliedNP_sum2());
			alliedNPHrsSubtotals.setSubTotalCompTotalWorkedHrsBudget(root.getCompHAlliedNP_calcsum());

			Collections.addAll(ltcBudgetCompHrsSubttls, supportHrsSubtotals,adminHrsSubtotals,nursingHrsSubtotals,alliedHrsSubtotals,alliedNPHrsSubtotals);

			/* Totals */
			LtcBudgetCompHrsTotals totalPerPayrollHrsTotals = new LtcBudgetCompHrsTotals();
			totalPerPayrollHrsTotals.setCompHrsTotalType(root.getCompH_total_label());
			totalPerPayrollHrsTotals.setTotalCompHrsStaffBudget(root.getCompH_total1());
			totalPerPayrollHrsTotals.setTotalCompHrsContractServicesBudget(root.getCompH_total2());
			totalPerPayrollHrsTotals.setTotalCompTotalWorkedHrsBudget(root.getCompH_total());
			totalPerPayrollHrsTotals.setConfirmationID(root.getForm().getConfirmationId());

			LtcBudgetCompHrsTotals accuredHrsTotals = new LtcBudgetCompHrsTotals();
			accuredHrsTotals.setCompHrsTotalType(root.getCompH_accrued_label());
			accuredHrsTotals.setTotalCompHrsStaffBudget(root.getCompH_accrued1());
			accuredHrsTotals.setTotalCompHrsContractServicesBudget(root.getCompH_accrued2());
			accuredHrsTotals.setTotalCompTotalWorkedHrsBudget(root.getCompH_accrued());
			accuredHrsTotals.setConfirmationID(root.getForm().getConfirmationId());

			Collections.addAll(ltcBudgetCompHrsTtls,totalPerPayrollHrsTotals,accuredHrsTotals);

			/* Add Pos Hrs */
			LtcBudgetCompAddPos nursingRNAddPos = new LtcBudgetCompAddPos();
			nursingRNAddPos.setConfirmationId(root.getForm().getConfirmationId());
			nursingRNAddPos.setAddPosType(root.getNursing_label_CSP());
			nursingRNAddPos.setAddPosName(root.getNursing_label_CSP1());
			nursingRNAddPos.setAddPosLegalNameContractServiceBudget(root.getNursingProvider1());
			nursingRNAddPos.setAddPosPercentServiceContractOutBudget(root.getNursingPercentage1());
			nursingRNAddPos.determineAddPosContractedOutBudget();
			
			LtcBudgetCompAddPos nursingLPNAddPos = new LtcBudgetCompAddPos();
			nursingLPNAddPos.setConfirmationId(root.getForm().getConfirmationId());
			nursingLPNAddPos.setAddPosType(root.getNursing_label_CSP());
			nursingLPNAddPos.setAddPosName(root.getNursing_label_CSP2());
			nursingLPNAddPos.setAddPosLegalNameContractServiceBudget(root.getNursingProvider2());
			nursingLPNAddPos.setAddPosPercentServiceContractOutBudget(root.getNursingPercentage2());
			nursingLPNAddPos.determineAddPosContractedOutBudget();

			LtcBudgetCompAddPos nursingHCAAddPos = new LtcBudgetCompAddPos();
			nursingHCAAddPos.setConfirmationId(root.getForm().getConfirmationId());
			nursingHCAAddPos.setAddPosType(root.getNursing_label_CSP());
			nursingHCAAddPos.setAddPosName(root.getNursing_label_CSP3());
			nursingHCAAddPos.setAddPosLegalNameContractServiceBudget(root.getNursingProvider3());
			nursingHCAAddPos.setAddPosPercentServiceContractOutBudget(root.getNursingPercentage3());
			nursingHCAAddPos.determineAddPosContractedOutBudget();

			LtcBudgetCompAddPos nursingOTHAddPos = new LtcBudgetCompAddPos();
			nursingOTHAddPos.setConfirmationId(root.getForm().getConfirmationId());
			nursingOTHAddPos.setAddPosType(root.getNursing_label_CSP());
			nursingOTHAddPos.setAddPosName(Constants.POS_TYPE_OTHER);
			nursingOTHAddPos.setAddPosLegalNameContractServiceBudget(root.getNursingProvider4());
			nursingOTHAddPos.setAddPosPercentServiceContractOutBudget(root.getNursingPercentage4());
			nursingOTHAddPos.setAddPosAnotherName(root.getNursing_label_CSP4());
			nursingOTHAddPos.determineAddPosContractedOutBudget();

			LtcBudgetCompAddPos alliedProfOTAddPos = new LtcBudgetCompAddPos();
			alliedProfOTAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfOTAddPos.setAddPosType(root.getAlliedProf_label_CSP());
			alliedProfOTAddPos.setAddPosName(root.getAlliedProf_label_CSP1());
			alliedProfOTAddPos.setAddPosLegalNameContractServiceBudget(root.getAlliedProfProvider1());
			alliedProfOTAddPos.setAddPosPercentServiceContractOutBudget(root.getAlliedProfPercentage1());
			alliedProfOTAddPos.determineAddPosContractedOutBudget();

			LtcBudgetCompAddPos alliedProfPTAddPos = new LtcBudgetCompAddPos();
			alliedProfPTAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfPTAddPos.setAddPosType(root.getAlliedProf_label_CSP());
			alliedProfPTAddPos.setAddPosName(root.getAlliedProf_label_CSP2());
			alliedProfPTAddPos.setAddPosLegalNameContractServiceBudget(root.getAlliedProfProvider2());
			alliedProfPTAddPos.setAddPosPercentServiceContractOutBudget(root.getAlliedProfPercentage2());
			alliedProfPTAddPos.determineAddPosContractedOutBudget();

			LtcBudgetCompAddPos alliedProfDTAddPos = new LtcBudgetCompAddPos();
			alliedProfDTAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfDTAddPos.setAddPosType(root.getAlliedProf_label_CSP());
			alliedProfDTAddPos.setAddPosName(root.getAlliedProf_label_CSP3());
			alliedProfDTAddPos.setAddPosLegalNameContractServiceBudget(root.getAlliedProfProvider3());
			alliedProfDTAddPos.setAddPosPercentServiceContractOutBudget(root.getAlliedProfPercentage3());
			alliedProfDTAddPos.determineAddPosContractedOutBudget();

			LtcBudgetCompAddPos alliedProfSWAddPos = new LtcBudgetCompAddPos();
			alliedProfSWAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfSWAddPos.setAddPosType(root.getAlliedProf_label_CSP());
			alliedProfSWAddPos.setAddPosName(root.getAlliedProf_label_CSP4());
			alliedProfSWAddPos.setAddPosLegalNameContractServiceBudget(root.getAlliedProfProvider4());
			alliedProfSWAddPos.setAddPosPercentServiceContractOutBudget(root.getAlliedProfPercentage4());
			alliedProfSWAddPos.determineAddPosContractedOutBudget();

			LtcBudgetCompAddPos alliedProfSLPAddPos = new LtcBudgetCompAddPos();
			alliedProfSLPAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfSLPAddPos.setAddPosType(root.getAlliedProf_label_CSP());
			alliedProfSLPAddPos.setAddPosName(root.getAlliedProf_label_CSP5());
			alliedProfSLPAddPos.setAddPosLegalNameContractServiceBudget(root.getAlliedProfProvider5());
			alliedProfSLPAddPos.setAddPosPercentServiceContractOutBudget(root.getAlliedProfPercentage5());
			alliedProfSLPAddPos.determineAddPosContractedOutBudget();

			LtcBudgetCompAddPos alliedProfRTAddPos = new LtcBudgetCompAddPos();
			alliedProfRTAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfRTAddPos.setAddPosType(root.getAlliedProf_label_CSP());
			alliedProfRTAddPos.setAddPosName(root.getAlliedProf_label_CSP6());
			alliedProfRTAddPos.setAddPosLegalNameContractServiceBudget(root.getAlliedProfProvider6());
			alliedProfRTAddPos.setAddPosPercentServiceContractOutBudget(root.getAlliedProfPercentage6());
			alliedProfRTAddPos.determineAddPosContractedOutBudget();

			LtcBudgetCompAddPos alliedProfOTHAddPos = new LtcBudgetCompAddPos();
			alliedProfOTHAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfOTHAddPos.setAddPosType(root.getAlliedProf_label_CSP());
			alliedProfOTHAddPos.setAddPosName(Constants.POS_TYPE_OTHER);
			alliedProfOTHAddPos.setAddPosLegalNameContractServiceBudget(root.getAlliedProfProvider7());
			alliedProfOTHAddPos.setAddPosPercentServiceContractOutBudget(root.getAlliedProfPercentage7());
			alliedProfOTHAddPos.setAddPosAnotherName(root.getAlliedProf_label_CSP7());
			alliedProfOTHAddPos.determineAddPosContractedOutBudget();

			LtcBudgetCompAddPos alliedNPRTAddPos = new LtcBudgetCompAddPos();
			alliedNPRTAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRTAddPos.setAddPosType(root.getAlliedNP_label_CSP());
			alliedNPRTAddPos.setAddPosName(root.getAlliedNP_label_CSP1());
			alliedNPRTAddPos.setAddPosLegalNameContractServiceBudget(root.getAlliedNPProvider1());
			alliedNPRTAddPos.setAddPosPercentServiceContractOutBudget(root.getAlliedNPPercentage1());
			alliedNPRTAddPos.determineAddPosContractedOutBudget();

			LtcBudgetCompAddPos alliedNPRAAddPos = new LtcBudgetCompAddPos();
			alliedNPRAAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRAAddPos.setAddPosType(root.getAlliedNP_label_CSP());
			alliedNPRAAddPos.setAddPosName(root.getAlliedNP_label_CSP2());
			alliedNPRAAddPos.setAddPosLegalNameContractServiceBudget(root.getAlliedNPProvider2());
			alliedNPRAAddPos.setAddPosPercentServiceContractOutBudget(root.getAlliedNPPercentage2());
			alliedNPRAAddPos.determineAddPosContractedOutBudget();

			LtcBudgetCompAddPos alliedNPAWAddPos = new LtcBudgetCompAddPos();
			alliedNPAWAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPAWAddPos.setAddPosType(root.getAlliedNP_label_CSP());
			alliedNPAWAddPos.setAddPosName(root.getAlliedNP_label_CSP3());
			alliedNPAWAddPos.setAddPosLegalNameContractServiceBudget(root.getAlliedNPProvider3());
			alliedNPAWAddPos.setAddPosPercentServiceContractOutBudget(root.getAlliedNPPercentage3());
			alliedNPAWAddPos.determineAddPosContractedOutBudget();

			LtcBudgetCompAddPos alliedNPMTAddPos = new LtcBudgetCompAddPos();
			alliedNPMTAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPMTAddPos.setAddPosType(root.getAlliedNP_label_CSP());
			alliedNPMTAddPos.setAddPosName(root.getAlliedNP_label_CSP4());
			alliedNPMTAddPos.setAddPosLegalNameContractServiceBudget(root.getAlliedNPProvider4());
			alliedNPMTAddPos.setAddPosPercentServiceContractOutBudget(root.getAlliedNPPercentage4());
			alliedNPMTAddPos.determineAddPosContractedOutBudget();

			LtcBudgetCompAddPos alliedNPATAddPos = new LtcBudgetCompAddPos();
			alliedNPATAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPATAddPos.setAddPosType(root.getAlliedNP_label_CSP());
			alliedNPATAddPos.setAddPosName(root.getAlliedNP_label_CSP5());
			alliedNPATAddPos.setAddPosLegalNameContractServiceBudget(root.getAlliedNPProvider5());
			alliedNPATAddPos.setAddPosPercentServiceContractOutBudget(root.getAlliedNPPercentage5());
			alliedNPATAddPos.determineAddPosContractedOutBudget();

			LtcBudgetCompAddPos alliedNPOTHAddPos = new LtcBudgetCompAddPos();
			alliedNPOTHAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPOTHAddPos.setAddPosType(root.getAlliedNP_label_CSP());
			alliedNPOTHAddPos.setAddPosName(Constants.POS_TYPE_OTHER);
			alliedNPOTHAddPos.setAddPosLegalNameContractServiceBudget(root.getAlliedNPProvider6());
			alliedNPOTHAddPos.setAddPosPercentServiceContractOutBudget(root.getAlliedNPPercentage6());
			alliedNPOTHAddPos.setAddPosAnotherName(root.getAlliedNP_label_CSP6());
			alliedNPOTHAddPos.determineAddPosContractedOutBudget();

			Collections.addAll(ltcBudgetCompAddPos, nursingRNAddPos, nursingLPNAddPos, nursingHCAAddPos, nursingOTHAddPos,
					alliedProfOTAddPos, alliedProfPTAddPos, alliedProfDTAddPos, alliedProfSWAddPos, alliedProfRTAddPos, 
					alliedProfSLPAddPos, alliedProfOTHAddPos, alliedNPRTAddPos, alliedNPRAAddPos, alliedNPAWAddPos,
					alliedNPMTAddPos, alliedNPATAddPos, alliedNPOTHAddPos);
					
			/* Benefits Where is %Allocation stored */
			LtcBudgetCompBenefits empInsBenefit = new LtcBudgetCompBenefits();
			empInsBenefit.setBenefitsAmountBudget(root.getBenefit_value1());
			empInsBenefit.setBenefitsType(root.getBenefit_value_label1());
			empInsBenefit.setBenefitsPercentageAlloc(root.getBenefit_percentage1());
			empInsBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetCompBenefits canPenPlnBenefit = new LtcBudgetCompBenefits();
			canPenPlnBenefit.setBenefitsAmountBudget(root.getBenefit_value2());
			canPenPlnBenefit.setBenefitsType(root.getBenefit_value_label2());
			canPenPlnBenefit.setBenefitsPercentageAlloc(root.getBenefit_percentage2());
			canPenPlnBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetCompBenefits wrkrCompBoardBenefit = new LtcBudgetCompBenefits();
			wrkrCompBoardBenefit.setBenefitsAmountBudget(root.getBenefit_value3());
			wrkrCompBoardBenefit.setBenefitsType(root.getBenefit_value_label3());
			wrkrCompBoardBenefit.setBenefitsPercentageAlloc(root.getBenefit_percentage3());
			wrkrCompBoardBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetCompBenefits empHlthTaxBenefit = new LtcBudgetCompBenefits();
			empHlthTaxBenefit.setBenefitsAmountBudget(root.getBenefit_value4());
			empHlthTaxBenefit.setBenefitsType(root.getBenefit_value_label4());
			empHlthTaxBenefit.setBenefitsPercentageAlloc(root.getBenefit_percentage4());
			empHlthTaxBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetCompBenefits penPlanBenefit = new LtcBudgetCompBenefits();
			penPlanBenefit.setBenefitsAmountBudget(root.getBenefit_value5());
			penPlanBenefit.setBenefitsType(root.getBenefit_value_label5());
			penPlanBenefit.setBenefitsPercentageAlloc(root.getBenefit_percentage5());
			penPlanBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetCompBenefits exHlthDntlBenefit = new LtcBudgetCompBenefits();
			exHlthDntlBenefit.setBenefitsAmountBudget(root.getBenefit_value6());
			exHlthDntlBenefit.setBenefitsType(root.getBenefit_value_label6());
			exHlthDntlBenefit.setBenefitsPercentageAlloc(root.getBenefit_percentage6());
			exHlthDntlBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetCompBenefits grpLifeBenefit = new LtcBudgetCompBenefits();
			grpLifeBenefit.setBenefitsAmountBudget(root.getBenefit_value7());
			grpLifeBenefit.setBenefitsType(root.getBenefit_value_label7());
			grpLifeBenefit.setBenefitsPercentageAlloc(root.getBenefit_percentage7());
			grpLifeBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetCompBenefits otherBenefit = new LtcBudgetCompBenefits();
			otherBenefit.setBenefitsAmountBudget(root.getBenefit_value8());
			otherBenefit.setBenefitsType(root.getBenefit_value_label8());
			otherBenefit.setBenefitsPercentageAlloc(root.getBenefit_percentage8());
			otherBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetCompBenefits lessBenefitsRecovery = new LtcBudgetCompBenefits();
			lessBenefitsRecovery.setBenefitsAmountBudget(root.getBenefit_value_rec());
			lessBenefitsRecovery.setBenefitsType(root.getBenefit_value_rec_label());
			lessBenefitsRecovery.setBenefitsPercentageAlloc(root.getBenefit_percentage_rec());
			lessBenefitsRecovery.setConfirmationId(root.getForm().getConfirmationId());

			Collections.addAll(ltcBudgetCompBenefits, empInsBenefit, canPenPlnBenefit, wrkrCompBoardBenefit,
					empHlthTaxBenefit, penPlanBenefit, exHlthDntlBenefit, grpLifeBenefit, otherBenefit, 
					lessBenefitsRecovery);
			/* Are we setting the subtotal and total things? */

			/* Summary of Rev & Exp Budget */
			LtcBudgetRev revFrmHA1Adj = new LtcBudgetRev();
			revFrmHA1Adj.setRevBudget(root.getOpRev_YTD1());
			revFrmHA1Adj.setRevNotes(root.getOpRev_note1());
			revFrmHA1Adj.setRevName(root.getOpRev_YTD_label_1());	
			revFrmHA1Adj.setRevType(root.getOpRev_1_label());
			revFrmHA1Adj.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetRev revFrmHA1DirCare = new LtcBudgetRev();
			revFrmHA1DirCare.setRevBudget(root.getOpRev_YTD2());
			revFrmHA1DirCare.setRevNotes(root.getOpRev_note2());
			revFrmHA1DirCare.setRevName(root.getOpRev_YTD_label_2());
			revFrmHA1DirCare.setRevType(root.getOpRev_1_label());
			revFrmHA1DirCare.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetRev revFrmHA1Others = new LtcBudgetRev();
			revFrmHA1Others.setRevBudget(root.getOpRev_YTD3());
			revFrmHA1Others.setRevNotes(root.getOpRev_note3());
			revFrmHA1Others.setRevName(root.getOpRev_YTD_label_3());
			revFrmHA1Others.setRevType(root.getOpRev_1_label());
			revFrmHA1Others.setConfirmationId(root.getForm().getConfirmationId());

			// skipping subtotal for now

			LtcBudgetRev revFrmHA2OpFundMinEq = new LtcBudgetRev();
			revFrmHA2OpFundMinEq.setRevBudget(root.getOpRev_YTD4());
			revFrmHA2OpFundMinEq.setRevNotes(root.getOpRev_note4());
			revFrmHA2OpFundMinEq.setRevName(root.getOpRev_YTD_label_4());
			revFrmHA2OpFundMinEq.setRevType(root.getOpRev_2_label());
			revFrmHA2OpFundMinEq.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetRev revFrmHA2OpFundOth = new LtcBudgetRev();
			revFrmHA2OpFundOth.setRevBudget(root.getOpRev_YTD5());
			revFrmHA2OpFundOth.setRevNotes(root.getOpRev_note5());
			revFrmHA2OpFundOth.setRevName(root.getOpRev_YTD_label_5());
			revFrmHA2OpFundOth.setRevType(root.getOpRev_2_label());
			revFrmHA2OpFundOth.setConfirmationId(root.getForm().getConfirmationId());

			// skipping subtotal

			LtcBudgetRev revFrmHA3 = new LtcBudgetRev();
			revFrmHA3.setRevBudget(root.getOpRev_YTD6());
			revFrmHA3.setRevNotes(root.getOpRev_note6());
			revFrmHA3.setRevName(root.getOpRev_YTD_label_6());
			revFrmHA3.setRevType(root.getOpRev_3_label());
			revFrmHA3.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetRev revFrmHA4OccThld = new LtcBudgetRev();
			revFrmHA4OccThld.setRevBudget(root.getOpRev_YTD7());
			revFrmHA4OccThld.setRevNotes(root.getOpRev_note7());
			revFrmHA4OccThld.setRevName(root.getOpRev_YTD_label_7());
			revFrmHA4OccThld.setRevType(root.getOpRev_4_label());
			revFrmHA4OccThld.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetRev revFrmHA4CliConReconc = new LtcBudgetRev();
			revFrmHA4CliConReconc.setRevBudget(root.getOpRev_YTD8());
			revFrmHA4CliConReconc.setRevNotes(root.getOpRev_note8());
			revFrmHA4CliConReconc.setRevName(root.getOpRev_YTD_label_8());
			revFrmHA4CliConReconc.setRevType(root.getOpRev_4_label());
			revFrmHA4CliConReconc.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetRev revFrmHA4DirCare = new LtcBudgetRev();
			revFrmHA4DirCare.setRevBudget(root.getOpRev_YTD9());
			revFrmHA4DirCare.setRevNotes(root.getOpRev_note9());
			revFrmHA4DirCare.setRevName(root.getOpRev_YTD_label_9());
			revFrmHA4DirCare.setRevType(root.getOpRev_4_label());
			revFrmHA4DirCare.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetRev revFrmHA4Oth = new LtcBudgetRev();
			revFrmHA4Oth.setRevBudget(root.getOpRev_YTD10());
			revFrmHA4Oth.setRevNotes(root.getOpRev_note10());
			revFrmHA4Oth.setRevName(root.getOpRev_YTD_label_10());
			revFrmHA4Oth.setRevType(root.getOpRev_4_label());
			revFrmHA4Oth.setConfirmationId(root.getForm().getConfirmationId());

			/* Non operating revenu */
			LtcBudgetRev nonOperatingRevOth = new LtcBudgetRev();
			nonOperatingRevOth.setRevBudget(root.getNopRev_YTD1());
			nonOperatingRevOth.setRevNotes(root.getNopRev_note1());
			nonOperatingRevOth.setRevName(root.getNopRev_YTD_label1());
			nonOperatingRevOth.setRevType(root.getNopRev_label());
			nonOperatingRevOth.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetRev nonOperatingRevOthThirdParty = new LtcBudgetRev();
			nonOperatingRevOthThirdParty.setRevBudget(root.getNopRev_YTD2());
			nonOperatingRevOthThirdParty.setRevNotes(root.getNopRev_note2());
			nonOperatingRevOthThirdParty.setRevName(root.getNopRev_YTD_label2());
			nonOperatingRevOthThirdParty.setRevType(root.getNopRev_label());
			nonOperatingRevOthThirdParty.setConfirmationId(root.getForm().getConfirmationId());
			/* END */

			// skipping subtotal for now

			LtcBudgetRev clntRvnHAClient = new LtcBudgetRev();
			clntRvnHAClient.setRevBudget(root.getOpRev_YTD11());
			clntRvnHAClient.setRevNotes(root.getOpRev_note11());
			clntRvnHAClient.setRevName(root.getOpRev_YTD_label_11());
			clntRvnHAClient.setRevType(root.getOpRev_client_label());
			clntRvnHAClient.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetRev clntRvnFeePaidParties = new LtcBudgetRev();
			clntRvnFeePaidParties.setRevBudget(root.getOpRev_YTD12());
			clntRvnFeePaidParties.setRevNotes(root.getOpRev_note12());
			clntRvnFeePaidParties.setRevName(root.getOpRev_YTD_label_12());
			clntRvnFeePaidParties.setRevType(root.getOpRev_client_label());
			clntRvnFeePaidParties.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetRev clntRvnFeePaidNonEligible = new LtcBudgetRev();
			clntRvnFeePaidNonEligible.setRevBudget(root.getOpRev_YTD13());
			clntRvnFeePaidNonEligible.setRevNotes(root.getOpRev_note13());
			clntRvnFeePaidNonEligible.setRevName(root.getOpRev_YTD_label_13());
			clntRvnFeePaidNonEligible.setRevType(root.getOpRev_client_label());
			clntRvnFeePaidNonEligible.setConfirmationId(root.getForm().getConfirmationId());

			// skipping subtotal for now
			LtcBudgetRev othRevInvstOpFund = new LtcBudgetRev();
			othRevInvstOpFund.setRevBudget(root.getOpRev_YTD14());
			othRevInvstOpFund.setRevNotes(root.getOpRev_note14());
			othRevInvstOpFund.setRevName(root.getOpRev_YTD_label_14());
			othRevInvstOpFund.setRevType(root.getOpRev_otherRev_label());
			othRevInvstOpFund.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetRev othRevInvstCmBcFund = new LtcBudgetRev();
			othRevInvstCmBcFund.setRevBudget(root.getOpRev_YTD15());
			othRevInvstCmBcFund.setRevNotes(root.getOpRev_note15());
			othRevInvstCmBcFund.setRevName(root.getOpRev_YTD_label_15());
			othRevInvstCmBcFund.setRevType(root.getOpRev_otherRev_label());
			othRevInvstCmBcFund.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetRev othRevFoodServ = new LtcBudgetRev();
			othRevFoodServ.setRevBudget(root.getOpRev_YTD16());
			othRevFoodServ.setRevNotes(root.getOpRev_note16());
			othRevFoodServ.setRevName(root.getOpRev_YTD_label_16());
			othRevFoodServ.setRevType(root.getOpRev_otherRev_label());
			othRevFoodServ.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetRev othRevLdryServ = new LtcBudgetRev();
			othRevLdryServ.setRevBudget(root.getOpRev_YTD17());
			othRevLdryServ.setRevNotes(root.getOpRev_note17());
			othRevLdryServ.setRevName(root.getOpRev_YTD_label_17());
			othRevLdryServ.setRevType(root.getOpRev_otherRev_label());
			othRevLdryServ.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetRev othRevCabl = new LtcBudgetRev();
			othRevCabl.setRevBudget(root.getOpRev_YTD18());
			othRevCabl.setRevNotes(root.getOpRev_note18());
			othRevCabl.setRevName(root.getOpRev_YTD_label_18());
			othRevCabl.setRevType(root.getOpRev_otherRev_label());
			othRevCabl.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetRev othRevOthRec = new LtcBudgetRev();
			othRevOthRec.setRevBudget(root.getOpRev_YTD19());
			othRevOthRec.setRevNotes(root.getOpRev_note19());
			othRevOthRec.setRevName(root.getOpRev_YTD_label_19());
			othRevOthRec.setRevType(root.getOpRev_otherRev_label());
			othRevOthRec.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetRev othRevOthSpcfy = new LtcBudgetRev();
			othRevOthSpcfy.setRevBudget(root.getOpRev_YTD20());
			othRevOthSpcfy.setRevNotes(root.getOpRev_note20());
			othRevOthSpcfy.setRevName(root.getOpRev_YTD_label_20());
			othRevOthSpcfy.setRevType(root.getOpRev_otherRev_label());
			othRevOthSpcfy.setConfirmationId(root.getForm().getConfirmationId());
			Collections.addAll(ltcBudgetRev, revFrmHA1Adj, revFrmHA1DirCare, revFrmHA1Others, revFrmHA2OpFundMinEq,
					revFrmHA2OpFundOth, revFrmHA3, revFrmHA4OccThld, revFrmHA4CliConReconc, revFrmHA4DirCare,
					revFrmHA4Oth, clntRvnHAClient, clntRvnFeePaidParties, clntRvnFeePaidNonEligible, othRevInvstOpFund,
					othRevInvstCmBcFund, othRevFoodServ, othRevLdryServ, othRevCabl, othRevOthRec, othRevOthSpcfy, 
					nonOperatingRevOth, nonOperatingRevOthThirdParty);

			/* Subtotals */
			LtcBudgetRevTotals revFromHA1Subttl = new LtcBudgetRevTotals();
			revFromHA1Subttl.setConfirmationId(root.getForm().getConfirmationId());
			revFromHA1Subttl.setRevType(root.getOpRev_1_label());
			revFromHA1Subttl.setSubTotalRevBudget(root.getOpRev_sum11());
			revFromHA1Subttl.setSubTotalRevNotes(root.getOpRev_sum_note1());

			LtcBudgetRevTotals revFromHA2Subttl = new LtcBudgetRevTotals();
			revFromHA2Subttl.setConfirmationId(root.getForm().getConfirmationId());
			revFromHA2Subttl.setRevType(root.getOpRev_2_label());
			revFromHA2Subttl.setSubTotalRevBudget(root.getOpRev_sum12());
			revFromHA2Subttl.setSubTotalRevNotes(root.getOpRev_sum_note2());

			LtcBudgetRevTotals revFromHA4Subttl = new LtcBudgetRevTotals();
			revFromHA4Subttl.setConfirmationId(root.getForm().getConfirmationId());
			revFromHA4Subttl.setRevType(root.getOpRev_4_label());
			revFromHA4Subttl.setSubTotalRevBudget(root.getOpRev_sum13());
			revFromHA4Subttl.setSubTotalRevNotes(root.getOpRev_sum_note3());

			LtcBudgetRevTotals clntRevSubttl = new LtcBudgetRevTotals();
			clntRevSubttl.setConfirmationId(root.getForm().getConfirmationId());
			clntRevSubttl.setRevType(root.getOpRev_client_label());
			clntRevSubttl.setSubTotalRevBudget(root.getOpRev_sum14());
			clntRevSubttl.setSubTotalRevNotes(root.getOpRev_sum_note4());

			LtcBudgetRevTotals othRevSubttl = new LtcBudgetRevTotals();
			othRevSubttl.setConfirmationId(root.getForm().getConfirmationId());
			othRevSubttl.setRevType(root.getOpRev_otherRev_label());
			othRevSubttl.setSubTotalRevBudget(root.getOpRev_sum15());
			othRevSubttl.setSubTotalRevNotes(root.getOpRev_sum_note5());

			LtcBudgetRevTotals opRevSubttl = new LtcBudgetRevTotals();
			opRevSubttl.setConfirmationId(root.getForm().getConfirmationId());
			opRevSubttl.setRevType(root.getOpRev_YTD_total_label());
			opRevSubttl.setSubTotalRevBudget(root.getOpRev_YTD_total());
			opRevSubttl.setSubTotalRevNotes(root.getOpRev_total_note());

			LtcBudgetRevTotals nonOpRevSubttl = new LtcBudgetRevTotals();
			nonOpRevSubttl.setConfirmationId(root.getForm().getConfirmationId());
			nonOpRevSubttl.setRevType(root.getNopRev_label());
			nonOpRevSubttl.setSubTotalRevBudget(root.getNopRev_sum11());
			nonOpRevSubttl.setSubTotalRevNotes(root.getNopRev_sub_note());

			Collections.addAll(ltcBudgetRevSubTtls, revFromHA1Subttl,revFromHA2Subttl,revFromHA4Subttl,clntRevSubttl,othRevSubttl,opRevSubttl, nonOpRevSubttl);

			LtcBudgetExp dirCareCostExp = new LtcBudgetExp();
			dirCareCostExp.setExpBudget(root.getOpEx_YTD1());
			dirCareCostExp.setExpNotes(root.getOpEx_note1());
			dirCareCostExp.setExpName(root.getOpEx_YTD_label1());
			dirCareCostExp.setExpType(root.getOpEx_1A_label());
			dirCareCostExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp foodCostExp = new LtcBudgetExp();
			foodCostExp.setExpBudget(root.getOpEx_YTD2());
			foodCostExp.setExpNotes(root.getOpEx_note2());
			foodCostExp.setExpName(root.getOpEx_YTD_label2());
			foodCostExp.setExpType(root.getOpEx_1A_label());
			foodCostExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp ldryServExp = new LtcBudgetExp();
			ldryServExp.setExpBudget(root.getOpEx_YTD3());
			ldryServExp.setExpNotes(root.getOpEx_note3());
			ldryServExp.setExpName(root.getOpEx_YTD_label3());
			ldryServExp.setExpType(root.getOpEx_1A_label());
			ldryServExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp housekeepingCostExp = new LtcBudgetExp();
			housekeepingCostExp.setExpBudget(root.getOpEx_YTD4());
			housekeepingCostExp.setExpNotes(root.getOpEx_note4());
			housekeepingCostExp.setExpName(root.getOpEx_YTD_label4());
			housekeepingCostExp.setExpType(root.getOpEx_1A_label());
			housekeepingCostExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp adminServCostExp = new LtcBudgetExp();
			adminServCostExp.setExpBudget(root.getOpEx_YTD5());
			adminServCostExp.setExpNotes(root.getOpEx_note5());
			adminServCostExp.setExpName(root.getOpEx_YTD_label5());
			adminServCostExp.setExpType(root.getOpEx_1A_label());
			adminServCostExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp plantMainOpStaffExp = new LtcBudgetExp();
			plantMainOpStaffExp.setExpBudget(root.getOpEx_YTD6());
			plantMainOpStaffExp.setExpNotes(root.getOpEx_note6());
			plantMainOpStaffExp.setExpName(root.getOpEx_YTD_label6());
			plantMainOpStaffExp.setExpType(root.getOpEx_1A_label());
			plantMainOpStaffExp.setConfirmationId(root.getForm().getConfirmationId());

			// subtotal before salary and wages - omitted
			LtcBudgetExp salWagRecvExp = new LtcBudgetExp();
			salWagRecvExp.setExpBudget(root.getOpEx_YTD7());
			salWagRecvExp.setExpNotes(root.getOpEx_note7());
			salWagRecvExp.setExpName(root.getOpEx_YTD_label7());
			salWagRecvExp.setExpType(root.getOpEx_1A_label());
			salWagRecvExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp salWagAccExp = new LtcBudgetExp();
			salWagAccExp.setExpBudget(root.getOpEx_YTD8());
			salWagAccExp.setExpNotes(root.getOpEx_note8());
			salWagAccExp.setExpName(root.getOpEx_YTD_label8());
			salWagAccExp.setExpType(root.getOpEx_1A_label());
			salWagAccExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp othLabCostExp = new LtcBudgetExp();
			othLabCostExp.setExpBudget(root.getOpEx_YTD9());
			othLabCostExp.setExpNotes(root.getOpEx_note9());
			othLabCostExp.setExpName(root.getOpEx_YTD_label9());
			othLabCostExp.setExpType(root.getOpEx_1A_label());
			othLabCostExp.setConfirmationId(root.getForm().getConfirmationId());

			// subtotal

			LtcBudgetExp bnftCostExp = new LtcBudgetExp();
			bnftCostExp.setExpBudget(root.getOpEx_YTD10());
			bnftCostExp.setExpNotes(root.getOpEx_note10());
			bnftCostExp.setExpName(root.getOpEx_YTD_label10());
			bnftCostExp.setExpType(root.getOpEx_1B_label());
			bnftCostExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp sickSevrnceAccExp = new LtcBudgetExp();
			sickSevrnceAccExp.setExpBudget(root.getOpEx_YTD11());
			sickSevrnceAccExp.setExpNotes(root.getOpEx_note11());
			sickSevrnceAccExp.setExpName(root.getOpEx_YTD_label11());
			sickSevrnceAccExp.setExpType(root.getOpEx_1B_label());
			sickSevrnceAccExp.setConfirmationId(root.getForm().getConfirmationId());

			// subtotal
			LtcBudgetExp buildingRentExp = new LtcBudgetExp();
			buildingRentExp.setExpBudget(root.getOpEx_YTD12());
			buildingRentExp.setExpNotes(root.getOpEx_note12());
			buildingRentExp.setExpName(root.getOpEx_YTD_label12());
			buildingRentExp.setExpType(root.getOpEx_2_label());
			buildingRentExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp intrstMortgageLngTrmExp = new LtcBudgetExp();
			intrstMortgageLngTrmExp.setExpBudget(root.getOpEx_YTD13());
			intrstMortgageLngTrmExp.setExpNotes(root.getOpEx_note13());
			intrstMortgageLngTrmExp.setExpName(root.getOpEx_YTD_label13());
			intrstMortgageLngTrmExp.setExpType(root.getOpEx_2_label());
			intrstMortgageLngTrmExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp propertyTaxesExp = new LtcBudgetExp();
			propertyTaxesExp.setExpBudget(root.getOpEx_YTD14());
			propertyTaxesExp.setExpNotes(root.getOpEx_note14());
			propertyTaxesExp.setExpName(root.getOpEx_YTD_label14());
			propertyTaxesExp.setExpType(root.getOpEx_2_label());
			propertyTaxesExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp mntnceExp = new LtcBudgetExp();
			mntnceExp.setExpBudget(root.getOpEx_YTD15());
			mntnceExp.setExpNotes(root.getOpEx_note15());
			mntnceExp.setExpName(root.getOpEx_YTD_label15());
			mntnceExp.setExpType(root.getOpEx_2_label());
			mntnceExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp suppliesExp = new LtcBudgetExp();
			suppliesExp.setExpBudget(root.getOpEx_YTD16());
			suppliesExp.setExpNotes(root.getOpEx_note16());
			suppliesExp.setExpName(root.getOpEx_YTD_label16());
			suppliesExp.setExpType(root.getOpEx_2_label());
			suppliesExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp utilitiesExp = new LtcBudgetExp();
			utilitiesExp.setExpBudget(root.getOpEx_YTD17());
			utilitiesExp.setExpNotes(root.getOpEx_note17());
			utilitiesExp.setExpName(root.getOpEx_YTD_label17());
			utilitiesExp.setExpType(root.getOpEx_2_label());
			utilitiesExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp wasteMgmntExp = new LtcBudgetExp();
			wasteMgmntExp.setExpBudget(root.getOpEx_YTD18());
			wasteMgmntExp.setExpNotes(root.getOpEx_note18());
			wasteMgmntExp.setExpName(root.getOpEx_YTD_label18());
			wasteMgmntExp.setExpType(root.getOpEx_2_label());
			wasteMgmntExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp resTranServExp = new LtcBudgetExp();
			resTranServExp.setExpBudget(root.getOpEx_YTD19());
			resTranServExp.setExpNotes(root.getOpEx_note19());
			resTranServExp.setExpName(root.getOpEx_YTD_label19());
			resTranServExp.setExpType(root.getOpEx_2_label());
			resTranServExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp othExp = new LtcBudgetExp();
			othExp.setExpBudget(root.getOpEx_YTD20());
			othExp.setExpNotes(root.getOpEx_note20());
			othExp.setExpName(root.getOpEx_YTD_label20());
			othExp.setExpType(root.getOpEx_2_label());
			othExp.setConfirmationId(root.getForm().getConfirmationId());

			// skipping subtotal for now

			LtcBudgetExp medSupExp = new LtcBudgetExp();
			medSupExp.setExpBudget(root.getOpEx_YTD21());
			medSupExp.setExpNotes(root.getOpEx_note21());
			medSupExp.setExpName(root.getOpEx_YTD_label21());
			medSupExp.setExpType(root.getOpEx_3_label());
			medSupExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp drgsPharmaExp = new LtcBudgetExp();
			drgsPharmaExp.setExpBudget(root.getOpEx_YTD22());
			drgsPharmaExp.setExpNotes(root.getOpEx_note22());
			drgsPharmaExp.setExpName(root.getOpEx_YTD_label22());
			drgsPharmaExp.setExpType(root.getOpEx_3_label());
			drgsPharmaExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp rawFoodCostExp = new LtcBudgetExp();
			rawFoodCostExp.setExpBudget(root.getOpEx_YTD23());
			rawFoodCostExp.setExpNotes(root.getOpEx_note23());
			rawFoodCostExp.setExpName(root.getOpEx_YTD_label23());
			rawFoodCostExp.setExpType(root.getOpEx_3_label());
			rawFoodCostExp.setConfirmationId(root.getForm().getConfirmationId());

			

			LtcBudgetExp dietSupExp = new LtcBudgetExp();
			dietSupExp.setExpBudget(root.getOpEx_YTD24());
			dietSupExp.setExpNotes(root.getOpEx_note24());
			dietSupExp.setExpName(root.getOpEx_YTD_label24());
			dietSupExp.setExpType(root.getOpEx_3_label());
			dietSupExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp ldrySupExp = new LtcBudgetExp();
			ldrySupExp.setExpBudget(root.getOpEx_YTD25());
			ldrySupExp.setExpNotes(root.getOpEx_note25());
			ldrySupExp.setExpName(root.getOpEx_YTD_label25());
			ldrySupExp.setExpType(root.getOpEx_3_label());
			ldrySupExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp houseSupExp = new LtcBudgetExp();
			houseSupExp.setExpBudget(root.getOpEx_YTD26());
			houseSupExp.setExpNotes(root.getOpEx_note26());
			houseSupExp.setExpName(root.getOpEx_YTD_label26());
			houseSupExp.setExpType(root.getOpEx_3_label());
			houseSupExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp incontinenceSupExp = new LtcBudgetExp();
			incontinenceSupExp.setExpBudget(root.getOpEx_YTD27());
			incontinenceSupExp.setExpNotes(root.getOpEx_note27());
			incontinenceSupExp.setExpName(root.getOpEx_YTD_label27());
			incontinenceSupExp.setExpType(root.getOpEx_3_label());
			incontinenceSupExp.setConfirmationId(root.getForm().getConfirmationId());

			//
			/* Subtotals */
			LtcBudgetExpTotals staffCost1ASubtotal = new LtcBudgetExpTotals();
			staffCost1ASubtotal.setConfirmationId(root.getForm().getConfirmationId());
			staffCost1ASubtotal.setExpType(root.getOpEx_1A_label());
			staffCost1ASubtotal.setSubTotalExpBudget(root.getOpEx_sum11());
			staffCost1ASubtotal.setSubTotalExpNotes(root.getOpEx_sum_note1());

			LtcBudgetExpTotals staffCost1BSubtotal = new LtcBudgetExpTotals();
			staffCost1BSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			staffCost1BSubtotal.setExpType(root.getOpEx_1B_label());
			staffCost1BSubtotal.setSubTotalExpBudget(root.getOpEx_sum12());
			staffCost1BSubtotal.setSubTotalExpNotes(root.getOpEx_sum_note2());

			LtcBudgetExpTotals propertyCostSubtotal = new LtcBudgetExpTotals();
			propertyCostSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			propertyCostSubtotal.setExpType(root.getOpEx_2_label());
			propertyCostSubtotal.setSubTotalExpBudget(root.getOpEx_sum13());
			propertyCostSubtotal.setSubTotalExpNotes(root.getOpEx_sum_note3());

			LtcBudgetExpTotals suppliesSubtotal = new LtcBudgetExpTotals();
			suppliesSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			suppliesSubtotal.setExpType(root.getOpEx_3_label());
			suppliesSubtotal.setSubTotalExpBudget(root.getOpEx_sum14());
			suppliesSubtotal.setSubTotalExpNotes(root.getOpEx_sum_note4());

			LtcBudgetExpTotals adminCostSubtotal = new LtcBudgetExpTotals();
			adminCostSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			adminCostSubtotal.setExpType(root.getOpEx_4_label());
			adminCostSubtotal.setSubTotalExpBudget(root.getOpEx_sum15());
			adminCostSubtotal.setSubTotalExpNotes(root.getOpEx_sum_note5());

			LtcBudgetExpTotals operatingCostSubtotal = new LtcBudgetExpTotals();
			operatingCostSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			operatingCostSubtotal.setExpType(root.getOpEx_data_total_label());
			operatingCostSubtotal.setSubTotalExpBudget(root.getOpEx_data_total());
			operatingCostSubtotal.setSubTotalExpNotes(root.getOpEx_total_note());

			LtcBudgetExpTotals nonOperationalExpSubtotal = new LtcBudgetExpTotals();
			nonOperationalExpSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			nonOperationalExpSubtotal.setExpType(root.getNopEx_label());
			nonOperationalExpSubtotal.setSubTotalExpBudget(root.getNopEx_sum11());
			nonOperationalExpSubtotal.setSubTotalExpNotes(root.getNopEx_sub_note());

			LtcBudgetExpTotals beforeSalaryWagesRecAcc = new LtcBudgetExpTotals();
			beforeSalaryWagesRecAcc.setConfirmationId(root.getForm().getConfirmationId());
			beforeSalaryWagesRecAcc.setExpType("Before salary/wages rec./accruals");
			beforeSalaryWagesRecAcc.setSubTotalExpBudget(root.getOpEx_sub1());
			beforeSalaryWagesRecAcc.setSubTotalExpNotes(root.getOpEx_sub_note());

			// /getOpEx_sub1()

			Collections.addAll(ltcBudgetExpSubttls,staffCost1ASubtotal,staffCost1BSubtotal,propertyCostSubtotal,suppliesSubtotal,adminCostSubtotal,operatingCostSubtotal, nonOperationalExpSubtotal,
			 beforeSalaryWagesRecAcc);

			/* END */

			/*LtcBudgetDep */
			LtcBudgetDep buildingDep = new LtcBudgetDep();
			buildingDep.setConfirmationId(root.getForm().getConfirmationId());
			buildingDep.setDepName(root.getOpEx_YTD_label38());
			buildingDep.setDepBudget(root.getOpEx_item138());
			buildingDep.setDepNotes(root.getOpEx_note38());

			LtcBudgetDep furnitureEquipmentDep = new LtcBudgetDep();
			furnitureEquipmentDep.setConfirmationId(root.getForm().getConfirmationId());
			furnitureEquipmentDep.setDepName(root.getOpEx_YTD_label39());
			furnitureEquipmentDep.setDepBudget(root.getOpEx_item139());
			furnitureEquipmentDep.setDepNotes(root.getOpEx_note39());

			Collections.addAll(ltcBudgetDep, buildingDep, furnitureEquipmentDep);
			/* END */

			/* LTC Budget SUBTOTALS */

			LtcBudgetDepSubTotals subTotalBudgetDep = new LtcBudgetDepSubTotals();
			subTotalBudgetDep.setConfirmationId(root.getForm().getConfirmationId());
			subTotalBudgetDep.setSubTotalDepBudget(root.getOpEx_sum16());
			subTotalBudgetDep.setSubTotalDepNotes(root.getOpEx_note_sum6());

			Collections.addAll(ltcBudgetDepSubTotals, subTotalBudgetDep);
			/* END */

			/* LtcBudgetSumTotals */
			LtcBudgetSumTotals totalNonOperatingSurplus = new LtcBudgetSumTotals();
			totalNonOperatingSurplus.setConfirmationId(root.getForm().getConfirmationId());
			totalNonOperatingSurplus.setTotName(root.getNopSu_data_label());
			totalNonOperatingSurplus.setSumBudget(root.getNopSu_data1());
			totalNonOperatingSurplus.setTotNotes(root.getNopSu_note());

			LtcBudgetSumTotals operatingSurplusBeforeDepreciation = new LtcBudgetSumTotals();
			operatingSurplusBeforeDepreciation.setConfirmationId(root.getForm().getConfirmationId());
			operatingSurplusBeforeDepreciation.setTotName(root.getOpSuB_item11_label());
			operatingSurplusBeforeDepreciation.setSumBudget(root.getOpSuB_item11());
			operatingSurplusBeforeDepreciation.setTotNotes(root.getOpSuB_note());

			LtcBudgetSumTotals totalOperatingSurplus = new LtcBudgetSumTotals();
			totalOperatingSurplus.setConfirmationId(root.getForm().getConfirmationId());
			totalOperatingSurplus.setTotName(root.getOpSu_data_total_label());
			totalOperatingSurplus.setSumBudget(root.getOpSu_data_total());
			totalOperatingSurplus.setTotNotes(root.getOpSu_data_total_note());

			Collections.addAll(ltcBudgetSumTotals, operatingSurplusBeforeDepreciation, totalNonOperatingSurplus,
			 totalOperatingSurplus);

			/* END */
			
			LtcBudgetExp OthSupExp = new LtcBudgetExp();
			OthSupExp.setExpBudget(root.getOpEx_YTD28());
			OthSupExp.setExpNotes(root.getOpEx_note28());
			OthSupExp.setExpName(root.getOpEx_YTD_label28());
			OthSupExp.setExpType(root.getOpEx_3_label());
			OthSupExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp officeExpAdCost = new LtcBudgetExp();
			officeExpAdCost.setExpBudget(root.getOpEx_YTD29());
			officeExpAdCost.setExpNotes(root.getOpEx_note29());
			officeExpAdCost.setExpName(root.getOpEx_YTD_label29());
			officeExpAdCost.setExpType(root.getOpEx_4_label());
			officeExpAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp mgmntAdCost = new LtcBudgetExp();
			mgmntAdCost.setExpBudget(root.getOpEx_YTD30());
			mgmntAdCost.setExpNotes(root.getOpEx_note30());
			mgmntAdCost.setExpName(root.getOpEx_YTD_label30());
			mgmntAdCost.setExpType(root.getOpEx_4_label());
			mgmntAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp hoAllocpAdCost = new LtcBudgetExp();
			hoAllocpAdCost.setExpBudget(root.getOpEx_YTD31());
			hoAllocpAdCost.setExpNotes(root.getOpEx_note31());
			hoAllocpAdCost.setExpName(root.getOpEx_YTD_label31());
			hoAllocpAdCost.setExpType(root.getOpEx_4_label());
			hoAllocpAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp accAdCost = new LtcBudgetExp();
			accAdCost.setExpBudget(root.getOpEx_YTD32());
			accAdCost.setExpNotes(root.getOpEx_note32());
			accAdCost.setExpName(root.getOpEx_YTD_label32());
			accAdCost.setExpType(root.getOpEx_4_label());
			accAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp apaAdCost = new LtcBudgetExp();
			apaAdCost.setExpBudget(root.getOpEx_YTD33());
			apaAdCost.setExpNotes(root.getOpEx_note33());
			apaAdCost.setExpName(root.getOpEx_YTD_label33());
			apaAdCost.setExpType(root.getOpEx_4_label());
			apaAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp insuranceAdCost = new LtcBudgetExp();
			insuranceAdCost.setExpBudget(root.getOpEx_YTD34());
			insuranceAdCost.setExpNotes(root.getOpEx_note34());
			insuranceAdCost.setExpName(root.getOpEx_YTD_label34());
			insuranceAdCost.setExpType(root.getOpEx_4_label());
			insuranceAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp adminSupAdCost = new LtcBudgetExp();
			adminSupAdCost.setExpBudget(root.getOpEx_YTD35());
			adminSupAdCost.setExpNotes(root.getOpEx_note35());
			adminSupAdCost.setExpName(root.getOpEx_YTD_label35());
			adminSupAdCost.setExpType(root.getOpEx_4_label());
			adminSupAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp badDeptAdCost = new LtcBudgetExp();
			badDeptAdCost.setExpBudget(root.getOpEx_YTD37());
			badDeptAdCost.setExpNotes(root.getOpEx_note37());
			badDeptAdCost.setExpName(root.getOpEx_YTD_label37());
			badDeptAdCost.setExpType(root.getOpEx_4_label());
			badDeptAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp othAdCost = new LtcBudgetExp();
			othAdCost.setExpBudget(root.getOpEx_YTD36());
			othAdCost.setExpNotes(root.getOpEx_note36());
			othAdCost.setExpName(root.getOpEx_YTD_label36());
			othAdCost.setExpType(root.getOpEx_4_label());
			othAdCost.setConfirmationId(root.getForm().getConfirmationId());

			
			/* Non operating expense */
			LtcBudgetExp dirCareNonOpExpMortgage = new LtcBudgetExp();
			dirCareNonOpExpMortgage.setExpBudget(root.getNopEx_YTD1());
			dirCareNonOpExpMortgage.setExpNotes(root.getNopEx_note1());
			dirCareNonOpExpMortgage.setExpName(root.getNopEx_YTD_label1());
			dirCareNonOpExpMortgage.setExpType(root.getNopEx_label());
			dirCareNonOpExpMortgage.setConfirmationId(root.getForm().getConfirmationId());

			LtcBudgetExp dirCareNonOpExpOther = new LtcBudgetExp();
			dirCareNonOpExpOther.setExpBudget(root.getNopEx_YTD2());
			dirCareNonOpExpOther.setExpNotes(root.getNopEx_note2());
			dirCareNonOpExpOther.setExpName(root.getNopEx_YTD_label2());
			dirCareNonOpExpOther.setExpType(root.getNopEx_label());
			dirCareNonOpExpOther.setConfirmationId(root.getForm().getConfirmationId());
			/* END */

			
			Collections.addAll(ltcBudgetExp, dirCareCostExp, foodCostExp, ldryServExp, housekeepingCostExp,
					adminServCostExp, plantMainOpStaffExp, salWagRecvExp, salWagAccExp, othLabCostExp, bnftCostExp,
					sickSevrnceAccExp, buildingRentExp, intrstMortgageLngTrmExp, propertyTaxesExp, mntnceExp,
					suppliesExp, utilitiesExp, wasteMgmntExp, resTranServExp, othExp, medSupExp, rawFoodCostExp,
					drgsPharmaExp, dietSupExp, ldrySupExp, houseSupExp, incontinenceSupExp, OthSupExp, officeExpAdCost,
					mgmntAdCost, hoAllocpAdCost, accAdCost, apaAdCost, insuranceAdCost, adminSupAdCost, badDeptAdCost,
					othAdCost, dirCareNonOpExpMortgage, dirCareNonOpExpOther);

			
			/* Bed Inventory */
			
			ltcBudgetSubmission.setLtcBudgetCompAddPos(ltcBudgetCompAddPos);
			ltcBudgetSubmission.setLtcBudgetCompBenefits(ltcBudgetCompBenefits);
			ltcBudgetSubmission.setLtcBudgetCompHrs(ltcBudgetCompHrs);
			ltcBudgetSubmission.setLtcBudgetCompSal(ltcBudgetCompSal);
			ltcBudgetSubmission.setLtcBudgetDirectCareCost(ltcBudgetDcCost);
			ltcBudgetSubmission.setLtcBudgetDirectCareHrs(ltcBudgetDcHrs);
			ltcBudgetSubmission.setLtcBudgetExp(ltcBudgetExp);
			ltcBudgetSubmission.setLtcBudgetDep(ltcBudgetDep);
			ltcBudgetSubmission.setLtcBudgetDepSubTotals(ltcBudgetDepSubTotals);
			ltcBudgetSubmission.setLtcBudgetSumTotals(ltcBudgetSumTotals);
			ltcBudgetSubmission.setLtcBudgetRev(ltcBudgetRev);
			ltcBudgetSubmission.setLtcBudgetExpSubttls(ltcBudgetExpSubttls);
			ltcBudgetSubmission.setLtcBudgetRevSubttls(ltcBudgetRevSubTtls);
			ltcBudgetSubmission.setLtcBudgetCompSalSubttls(ltcBudgetCompSalSubttls);
			ltcBudgetSubmission.setLtcBudgetCompSalTtls(ltcBudgetCompsalTtls);
			ltcBudgetSubmission.setLtcBudgetCompHrsSubttls(ltcBudgetCompHrsSubttls);
			ltcBudgetSubmission.setLtcBudgetCompHrsTtls(ltcBudgetCompHrsTtls);
			ltcBudgetSubmission.setLtcBudgetDirectCareHrsSubttls(ltcBudgetDcHrsSubttls);
			ltcBudgetSubmission.setLtcBudgetDirectCareCostSubttls(ltcBudgetDcCostSubttls);
			
			ltcBudgetSubmissions.add(ltcBudgetSubmission);

		}

		return ltcBudgetSubmissions;
	}
}
