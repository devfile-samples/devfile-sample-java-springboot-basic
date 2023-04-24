package ca.bc.gov.chefs.etl.forms.ltc.quarterly.processor;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.FileProperties;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.core.model.SuccessResponse;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.json.BedGrid0;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.json.BedGrid1;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.json.BedGrid2;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.json.BedGrid3;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.json.BedGrid4;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.json.Root;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcBedYtdMaxOccupancy;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcBedYtdMaxOccupancyTotals;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcBedYtdOccupancyRate;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcBedYtdOccupancyRateTotals;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcBedYtdOccupiedDays;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcBedYtdOccupiedDaysTotals;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdCompAddPos;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdCompBenefits;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdCompHrs;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdCompHrsSubtotals;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdCompHrsTotals;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdCompSal;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdCompSalSubtotals;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdCompSalTotals;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdDep;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdDirectCareCost;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdDirectCareCostSubtotals;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdDirectCareHrs;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdDirectCareHrsSubTotals;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdExp;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdExpSubTotals;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdRev;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdRevSubTotals;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdSubmission;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdSumTotals;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;

public class LtcQuarterlyYtdApiResponseProcessor implements Processor {

	
	@Override
	@SuppressWarnings("unchecked")
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		System.out.println(payload);
		ObjectMapper mapper = new ObjectMapper();
		List<Root> ltcYtdForms = mapper.readValue(payload, new TypeReference<List<Root>>() {
		});
		List<LtcYtdSubmission> parsedLtycYtdSubmissions = parseYtdQuarterlyRequest(ltcYtdForms);
		List<IModel> iModels =  (List<IModel>)(List<?>) parsedLtycYtdSubmissions;
		Map<String,List<List<String>>> map = CSVUtil.provider(iModels);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map,Constants.LTC_QUARTERLY_DIR);
		//TODO uncomment or remove dead code
		// SuccessResponse successResponse = new SuccessResponse();
		// successResponse.setFiles(filesGenerated);
		// exchange.getIn().setBody(mapper.writeValueAsString(successResponse));

		
	}

	private List<LtcYtdSubmission> parseYtdQuarterlyRequest(List<Root> ltcQuarterlyYTDSubmissions) {
		List<LtcYtdSubmission> ltcYtdSubmissions = new ArrayList<>();
		for (Root root : ltcQuarterlyYTDSubmissions) {
			LtcYtdSubmission ltcYtdSubmission = new LtcYtdSubmission();
			List<LtcYtdDirectCareHrs> ltcYtdDcHrs = new ArrayList<>();
			List<LtcYtdDirectCareHrsSubTotals> ltcYtdDcHrsSubttls = new ArrayList<>();
			List<LtcYtdDirectCareCost> ltcYtdDcCost = new ArrayList<>();
			List<LtcYtdDirectCareCostSubtotals> ltcYtdDcCostSubttls = new ArrayList<>();
			List<LtcYtdCompSal> ltcYtdCompSal = new ArrayList<>();
			List<LtcYtdCompSalSubtotals> ltcYtdCompSalSubttls = new ArrayList<>();
			List<LtcYtdCompSalTotals> ltcYtdCompsalTtls = new ArrayList<>();
			List<LtcYtdCompHrs> ltcYtdCompHrs = new ArrayList<>();
			List<LtcYtdCompHrsSubtotals> ltcYtdCompHrsSubttls = new ArrayList<>();
			List<LtcYtdCompHrsTotals> ltcYtdCompHrsTtls = new ArrayList<>();
			List<LtcYtdCompAddPos> ltcYtdCompAddPos = new ArrayList<>();
			List<LtcYtdCompBenefits> ltcYtdCompBenefits = new ArrayList<>();
			List<LtcYtdRev> ltcYtdRev = new ArrayList<>();
			List<LtcYtdRevSubTotals> ltcYtdRevSubTtls = new ArrayList<LtcYtdRevSubTotals>();
			List<LtcYtdExpSubTotals> ltcYtdExpSubttls = new ArrayList<LtcYtdExpSubTotals>();
			List<LtcYtdExp> ltcYtdExp = new ArrayList<>();
			List<LtcYtdDep> ltcYtdDep = new ArrayList<>();
			List<LtcYtdSumTotals> ltcYtdSumTotals = new ArrayList<>();
			List<LtcBedYtdOccupancyRate> ltcBedYtdOccupancyRates = new ArrayList<>();
			List<LtcBedYtdMaxOccupancy> ltcBedYtdMaxOccupancies = new ArrayList<>();
			List<LtcBedYtdMaxOccupancyTotals> ltcBedYtdMaxOccTtls = new ArrayList<>();
			List<LtcBedYtdOccupiedDays> ltcBedYtdOccupiedDays = new ArrayList<>();
			List<LtcBedYtdOccupiedDaysTotals> ltcBedYtdOccDaysTtls = new ArrayList<>();
			List<LtcBedYtdOccupancyRateTotals> ltcBedYtdOccRateTtls = new ArrayList<>();
		

			/* Form Meta */
			ltcYtdSubmission.setConfirmationId(root.getForm().getConfirmationId());
			ltcYtdSubmission.setIsDeleted("");
			ltcYtdSubmission.setSubmissionDate(root.getForm().getCreatedAt());
			ltcYtdSubmission.setSubmittedBy(root.getForm().getFullName());
			ltcYtdSubmission.setCCIMSID(root.getCcimsid());
			ltcYtdSubmission.setSubmissionType(root.getSubmission());
			ltcYtdSubmission.setPeriod(root.getQuarter());
			ltcYtdSubmission.setSubmissionFy(root.getFiscalYear());
			ltcYtdSubmission.setNbTotalBeds(root.getNumberOfTotalBeds());
			ltcYtdSubmission.setNbFundedBeds(root.getNumberOfTotalFundedBeds());
			ltcYtdSubmission.setOccRateThreshold(root.getThreshold());
			
			/* START : Direct Care Hours */
			/* Productive and NP Nursing */ // why no subtotal and total?
			LtcYtdDirectCareHrs nursingRNProdH = new LtcYtdDirectCareHrs();
			nursingRNProdH.setDirCareProdHrsRegYtd(root.getNursingProdH_item11());
			nursingRNProdH.setDirCareProdHrsOtYtd(root.getNursingProdH_item21());
			nursingRNProdH.setDirCareProdHrsContractedYtd(root.getNursingProdHCS1());
			nursingRNProdH.setDirCareNonProdHrsVacYtd(root.getNursingNProdH_item11());
			nursingRNProdH.setDirCareNonProdHrsSickYtd(root.getNursingNProdH_item21());
			nursingRNProdH.setDirCareNonProdHrsOtherYtd(root.getNursingNProdH_item31());
			nursingRNProdH.setConfirmationId(root.getForm().getConfirmationId());
			nursingRNProdH.setDirCareType(root.getNursing_label());
			nursingRNProdH.setDirCareName(root.getNursing_label1());
			nursingRNProdH.setDirCareProdHrsSubtotalYtd(root.getNursingProdH_calc1());
			nursingRNProdH.setDirCareProdHrsTotalYtd(root.getNursingProdH_sub1());
			nursingRNProdH.setDirCareTotalHrsPaidYtd(root.getNursingProdH_THP1());
			nursingRNProdH.setDirCareNonProdHrsTotalYtd(root.getNursingNProdH_calc1());

			LtcYtdDirectCareHrs nursingLPNProdH = new LtcYtdDirectCareHrs();
			nursingLPNProdH.setDirCareProdHrsRegYtd(root.getNursingProdH_item12());
			nursingLPNProdH.setDirCareProdHrsOtYtd(root.getNursingProdH_item22());
			nursingLPNProdH.setDirCareProdHrsContractedYtd(root.getNursingProdHCS2());
			nursingLPNProdH.setDirCareNonProdHrsVacYtd(root.getNursingNProdH_item12());
			nursingLPNProdH.setDirCareNonProdHrsSickYtd(root.getNursingNProdH_item22());
			nursingLPNProdH.setDirCareNonProdHrsOtherYtd(root.getNursingNProdH_item32());
			nursingLPNProdH.setConfirmationId(root.getForm().getConfirmationId());
			nursingLPNProdH.setDirCareType(root.getNursing_label());
			nursingLPNProdH.setDirCareName(root.getNursing_label2());
			nursingLPNProdH.setDirCareProdHrsSubtotalYtd(root.getNursingProdH_calc2());
			nursingLPNProdH.setDirCareProdHrsTotalYtd(root.getNursingProdH_sub2());
			nursingLPNProdH.setDirCareTotalHrsPaidYtd(root.getNursingProdH_THP2());
			nursingLPNProdH.setDirCareNonProdHrsTotalYtd(root.getNursingNProdH_calc2());

			
			LtcYtdDirectCareHrs nursingHCAProdH = new LtcYtdDirectCareHrs();
			nursingHCAProdH.setDirCareProdHrsRegYtd(root.getNursingProdH_item13());
			nursingHCAProdH.setDirCareProdHrsOtYtd(root.getNursingProdH_item23());
			nursingHCAProdH.setDirCareProdHrsContractedYtd(root.getNursingProdHCS3());
			nursingHCAProdH.setDirCareNonProdHrsVacYtd(root.getNursingNProdH_item13());
			nursingHCAProdH.setDirCareNonProdHrsSickYtd(root.getNursingNProdH_item23());
			nursingHCAProdH.setDirCareNonProdHrsOtherYtd(root.getNursingNProdH_item33());
			nursingHCAProdH.setConfirmationId(root.getForm().getConfirmationId());
			nursingHCAProdH.setDirCareType(root.getNursing_label());
			nursingHCAProdH.setDirCareName(root.getNursing_label3());
			nursingHCAProdH.setDirCareProdHrsSubtotalYtd(root.getNursingProdH_calc3());
			nursingHCAProdH.setDirCareProdHrsTotalYtd(root.getNursingProdH_sub3());
			nursingHCAProdH.setDirCareTotalHrsPaidYtd(root.getNursingProdH_THP3());
			nursingHCAProdH.setDirCareNonProdHrsTotalYtd(root.getNursingNProdH_calc3());

			LtcYtdDirectCareHrs nursingOthProdH = new LtcYtdDirectCareHrs();
			nursingOthProdH.setDirCareProdHrsRegYtd(root.getNursingProdH_item14());
			nursingOthProdH.setDirCareProdHrsOtYtd(root.getNursingProdH_item24());
			nursingOthProdH.setDirCareProdHrsContractedYtd(root.getNursingProdHCS4());
			nursingOthProdH.setDirCareNonProdHrsVacYtd(root.getNursingNProdH_item14());
			nursingOthProdH.setDirCareNonProdHrsSickYtd(root.getNursingNProdH_item24());
			nursingOthProdH.setDirCareNonProdHrsOtherYtd(root.getNursingNProdH_item34());
			nursingOthProdH.setConfirmationId(root.getForm().getConfirmationId());
			nursingOthProdH.setDirCareType(root.getNursing_label());
			nursingOthProdH.setDirCareName(Constants.DC_HRS_OTHER);
			nursingOthProdH.setDirCareProdHrsSubtotalYtd(root.getNursingProdH_calc4());
			nursingOthProdH.setDirCareProdHrsTotalYtd(root.getNursingProdH_sub4());
			nursingOthProdH.setDirCareTotalHrsPaidYtd(root.getNursingProdH_THP4());
			nursingOthProdH.setDirCareNonProdHrsTotalYtd(root.getNursingNProdH_calc4());
			nursingOthProdH.setDirCareOtherValue(root.getNursing_label4());

			// to check what is with the subtotal fields

			/* Productive and NP Allied Prof */
			LtcYtdDirectCareHrs alliedOTProfH = new LtcYtdDirectCareHrs();
			alliedOTProfH.setDirCareProdHrsRegYtd(root.getAlliedProfProdH_item11());
			alliedOTProfH.setDirCareProdHrsOtYtd(root.getAlliedProfProdH_item21());
			alliedOTProfH.setDirCareProdHrsContractedYtd(root.getAlliedProfProdHCS1());
			alliedOTProfH.setDirCareNonProdHrsVacYtd(root.getAlliedProfNProdH_item11());
			alliedOTProfH.setDirCareNonProdHrsSickYtd(root.getAlliedProfNProdH_item21());
			alliedOTProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedProfNProdH_item31());
			alliedOTProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedOTProfH.setDirCareType(root.getAlliedProf_label());
			alliedOTProfH.setDirCareName(root.getAlliedProf_label1());
			alliedOTProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedProfProdH_calc1());
			alliedOTProfH.setDirCareProdHrsTotalYtd(root.getAlliedProfProdH_sub1());
			alliedOTProfH.setDirCareTotalHrsPaidYtd(root.getAlliedProfProdH_THP1());
			alliedOTProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedProfNProdH_calc1());


			LtcYtdDirectCareHrs alliedPTProfH = new LtcYtdDirectCareHrs();
			alliedPTProfH.setDirCareProdHrsRegYtd(root.getAlliedProfProdH_item12());
			alliedPTProfH.setDirCareProdHrsOtYtd(root.getAlliedProfProdH_item22());
			alliedPTProfH.setDirCareProdHrsContractedYtd(root.getAlliedProfProdHCS2());
			alliedPTProfH.setDirCareNonProdHrsVacYtd(root.getAlliedProfNProdH_item12());
			alliedPTProfH.setDirCareNonProdHrsSickYtd(root.getAlliedProfNProdH_item22());
			alliedPTProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedProfNProdH_item32());
			alliedPTProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedPTProfH.setDirCareType(root.getAlliedProf_label());
			alliedPTProfH.setDirCareName(root.getAlliedProf_label2());
			alliedPTProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedProfProdH_calc2());
			alliedPTProfH.setDirCareProdHrsTotalYtd(root.getAlliedProfProdH_sub2());
			alliedPTProfH.setDirCareTotalHrsPaidYtd(root.getAlliedProfProdH_THP2());
			alliedPTProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedProfNProdH_calc2());

			LtcYtdDirectCareHrs alliedDTProfH = new LtcYtdDirectCareHrs();
			alliedDTProfH.setDirCareProdHrsRegYtd(root.getAlliedProfProdH_item13());
			alliedDTProfH.setDirCareProdHrsOtYtd(root.getAlliedProfProdH_item23());
			alliedDTProfH.setDirCareProdHrsContractedYtd(root.getAlliedProfProdHCS3());
			alliedDTProfH.setDirCareNonProdHrsVacYtd(root.getAlliedProfNProdH_item13());
			alliedDTProfH.setDirCareNonProdHrsSickYtd(root.getAlliedProfNProdH_item23());
			alliedDTProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedProfNProdH_item33());
			alliedDTProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedDTProfH.setDirCareType(root.getAlliedProf_label());
			alliedDTProfH.setDirCareName(root.getAlliedProf_label3());
			alliedDTProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedProfProdH_calc3());
			alliedDTProfH.setDirCareProdHrsTotalYtd(root.getAlliedProfProdH_sub3());
			alliedDTProfH.setDirCareTotalHrsPaidYtd(root.getAlliedProfProdH_THP3());
			alliedDTProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedProfNProdH_calc3());


			LtcYtdDirectCareHrs alliedSWProfH = new LtcYtdDirectCareHrs();
			alliedSWProfH.setDirCareProdHrsRegYtd(root.getAlliedProfProdH_item14());
			alliedSWProfH.setDirCareProdHrsOtYtd(root.getAlliedProfProdH_item24());
			alliedSWProfH.setDirCareProdHrsContractedYtd(root.getAlliedProfProdHCS4());
			alliedSWProfH.setDirCareNonProdHrsVacYtd(root.getAlliedProfNProdH_item14());
			alliedSWProfH.setDirCareNonProdHrsSickYtd(root.getAlliedProfNProdH_item24());
			alliedSWProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedProfNProdH_item34());
			alliedSWProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedSWProfH.setDirCareType(root.getAlliedProf_label());
			alliedSWProfH.setDirCareName(root.getAlliedProf_label4());
			alliedSWProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedProfProdH_calc4());
			alliedSWProfH.setDirCareProdHrsTotalYtd(root.getAlliedProfProdH_sub4());
			alliedSWProfH.setDirCareTotalHrsPaidYtd(root.getAlliedProfProdH_THP4());
			alliedSWProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedProfNProdH_calc4());

			LtcYtdDirectCareHrs alliedSLPProfH = new LtcYtdDirectCareHrs();
			alliedSLPProfH.setDirCareProdHrsRegYtd(root.getAlliedProfProdH_item15());
			alliedSLPProfH.setDirCareProdHrsOtYtd(root.getAlliedProfProdH_item25());
			alliedSLPProfH.setDirCareProdHrsContractedYtd(root.getAlliedProfProdHCS5());
			alliedSLPProfH.setDirCareNonProdHrsVacYtd(root.getAlliedProfNProdH_item15());
			alliedSLPProfH.setDirCareNonProdHrsSickYtd(root.getAlliedProfNProdH_item25());
			alliedSLPProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedProfNProdH_item35());
			alliedSLPProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedSLPProfH.setDirCareType(root.getAlliedProf_label());
			alliedSLPProfH.setDirCareName(root.getAlliedProf_label5());
			alliedSLPProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedProfProdH_calc5());
			alliedSLPProfH.setDirCareProdHrsTotalYtd(root.getAlliedProfProdH_sub5());
			alliedSLPProfH.setDirCareTotalHrsPaidYtd(root.getAlliedProfProdH_THP5());
			alliedSLPProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedProfNProdH_calc5());

			LtcYtdDirectCareHrs alliedRTProfH = new LtcYtdDirectCareHrs();
			alliedRTProfH.setDirCareProdHrsRegYtd(root.getAlliedProfProdH_item16());
			alliedRTProfH.setDirCareProdHrsOtYtd(root.getAlliedProfProdH_item26());
			alliedRTProfH.setDirCareProdHrsContractedYtd(root.getAlliedProfProdHCS6());
			alliedRTProfH.setDirCareNonProdHrsVacYtd(root.getAlliedProfNProdH_item16());
			alliedRTProfH.setDirCareNonProdHrsSickYtd(root.getAlliedProfNProdH_item26());
			alliedRTProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedProfNProdH_item36());
			alliedRTProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedRTProfH.setDirCareType(root.getAlliedProf_label());
			alliedRTProfH.setDirCareName(root.getAlliedProf_label6());
			alliedRTProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedProfProdH_calc6());
			alliedRTProfH.setDirCareProdHrsTotalYtd(root.getAlliedProfProdH_sub6());
			alliedRTProfH.setDirCareTotalHrsPaidYtd(root.getAlliedProfProdH_THP6());
			alliedRTProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedProfNProdH_calc6());
			
			LtcYtdDirectCareHrs alliedOTHProfH = new LtcYtdDirectCareHrs();
			alliedOTHProfH.setDirCareProdHrsRegYtd(root.getAlliedProfProdH_item17());
			alliedOTHProfH.setDirCareProdHrsOtYtd(root.getAlliedProfProdH_item27());
			alliedOTHProfH.setDirCareProdHrsContractedYtd(root.getAlliedProfProdHCS7());
			alliedOTHProfH.setDirCareNonProdHrsVacYtd(root.getAlliedProfNProdH_item17());
			alliedOTHProfH.setDirCareNonProdHrsSickYtd(root.getAlliedProfNProdH_item27());
			alliedOTHProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedProfNProdH_item37());
			alliedOTHProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedOTHProfH.setDirCareType(root.getAlliedProf_label());
			alliedOTHProfH.setDirCareName(Constants.DC_HRS_OTHER);
			alliedOTHProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedProfProdH_calc7());
			alliedOTHProfH.setDirCareProdHrsTotalYtd(root.getAlliedProfProdH_sub7());
			alliedOTHProfH.setDirCareTotalHrsPaidYtd(root.getAlliedProfProdH_THP7());
			alliedOTHProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedProfNProdH_calc7());
			alliedOTHProfH.setDirCareOtherValue(root.getAlliedProf_label7());

			/* Allied Non Professional */
			LtcYtdDirectCareHrs alliedNPRTProfH = new LtcYtdDirectCareHrs();
			alliedNPRTProfH.setDirCareProdHrsRegYtd(root.getAlliedNPProdH_item11());
			alliedNPRTProfH.setDirCareProdHrsOtYtd(root.getAlliedNPProdH_item21());
			alliedNPRTProfH.setDirCareProdHrsContractedYtd(root.getAlliedNPProdHCS1());
			alliedNPRTProfH.setDirCareNonProdHrsVacYtd(root.getAlliedNPNProdH_item11());
			alliedNPRTProfH.setDirCareNonProdHrsSickYtd(root.getAlliedNPNProdH_item21());
			alliedNPRTProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedNPNProdH_item31());
			alliedNPRTProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRTProfH.setDirCareType(root.getAlliedNP_label());
			alliedNPRTProfH.setDirCareName(root.getAlliedNP_label1());
			alliedNPRTProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedNPProdH_calc1());
			alliedNPRTProfH.setDirCareProdHrsTotalYtd(root.getAlliedNPProdH_sub1());
			alliedNPRTProfH.setDirCareTotalHrsPaidYtd(root.getAlliedNPProdH_THP1());
			alliedNPRTProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedNPNProdH_calc1());


			LtcYtdDirectCareHrs alliedNPRAProfH = new LtcYtdDirectCareHrs();
			alliedNPRAProfH.setDirCareProdHrsRegYtd(root.getAlliedNPProdH_item12());
			alliedNPRAProfH.setDirCareProdHrsOtYtd(root.getAlliedNPProdH_item22());
			alliedNPRAProfH.setDirCareProdHrsContractedYtd(root.getAlliedNPProdHCS2());
			alliedNPRAProfH.setDirCareNonProdHrsVacYtd(root.getAlliedNPNProdH_item12());
			alliedNPRAProfH.setDirCareNonProdHrsSickYtd(root.getAlliedNPNProdH_item22());
			alliedNPRAProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedNPNProdH_item32());
			alliedNPRAProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRAProfH.setDirCareType(root.getAlliedNP_label());
			alliedNPRAProfH.setDirCareName(root.getAlliedNP_label2());
			alliedNPRAProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedNPProdH_calc2());
			alliedNPRAProfH.setDirCareProdHrsTotalYtd(root.getAlliedNPProdH_sub2());
			alliedNPRAProfH.setDirCareTotalHrsPaidYtd(root.getAlliedNPProdH_THP2());
			alliedNPRAProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedNPNProdH_calc2());


			LtcYtdDirectCareHrs alliedNPAWProfH = new LtcYtdDirectCareHrs();
			alliedNPAWProfH.setDirCareProdHrsRegYtd(root.getAlliedNPProdH_item13());
			alliedNPAWProfH.setDirCareProdHrsOtYtd(root.getAlliedNPProdH_item23());
			alliedNPAWProfH.setDirCareProdHrsContractedYtd(root.getAlliedNPProdHCS3());
			alliedNPAWProfH.setDirCareNonProdHrsVacYtd(root.getAlliedNPNProdH_item13());
			alliedNPAWProfH.setDirCareNonProdHrsSickYtd(root.getAlliedNPNProdH_item23());
			alliedNPAWProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedNPNProdH_item33());
			alliedNPAWProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPAWProfH.setDirCareType(root.getAlliedNP_label());
			alliedNPAWProfH.setDirCareName(root.getAlliedNP_label3());
			alliedNPAWProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedNPProdH_calc3());
			alliedNPAWProfH.setDirCareProdHrsTotalYtd(root.getAlliedNPProdH_sub3());
			alliedNPAWProfH.setDirCareTotalHrsPaidYtd(root.getAlliedNPProdH_THP3());
			alliedNPAWProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedNPNProdH_calc3());


			LtcYtdDirectCareHrs alliedNPMTProfH = new LtcYtdDirectCareHrs();
			alliedNPMTProfH.setDirCareProdHrsRegYtd(root.getAlliedNPProdH_item14());
			alliedNPMTProfH.setDirCareProdHrsOtYtd(root.getAlliedNPProdH_item24());
			alliedNPMTProfH.setDirCareProdHrsContractedYtd(root.getAlliedNPProdHCS4());
			alliedNPMTProfH.setDirCareNonProdHrsVacYtd(root.getAlliedNPNProdH_item14());
			alliedNPMTProfH.setDirCareNonProdHrsSickYtd(root.getAlliedNPNProdH_item24());
			alliedNPMTProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedNPNProdH_item34());
			alliedNPMTProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPMTProfH.setDirCareType(root.getAlliedNP_label());
			alliedNPMTProfH.setDirCareName(root.getAlliedNP_label4());
			alliedNPMTProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedNPProdH_calc4());
			alliedNPMTProfH.setDirCareProdHrsTotalYtd(root.getAlliedNPProdH_sub4());
			alliedNPMTProfH.setDirCareTotalHrsPaidYtd(root.getAlliedNPProdH_THP4());
			alliedNPMTProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedNPNProdH_calc4());


			LtcYtdDirectCareHrs alliedNPATProfH = new LtcYtdDirectCareHrs();
			alliedNPATProfH.setDirCareProdHrsRegYtd(root.getAlliedNPProdH_item15());
			alliedNPATProfH.setDirCareProdHrsOtYtd(root.getAlliedNPProdH_item25());
			alliedNPATProfH.setDirCareProdHrsContractedYtd(root.getAlliedNPProdHCS5());
			alliedNPATProfH.setDirCareNonProdHrsVacYtd(root.getAlliedNPNProdH_item15());
			alliedNPATProfH.setDirCareNonProdHrsSickYtd(root.getAlliedNPNProdH_item25());
			alliedNPATProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedNPNProdH_item35());
			alliedNPATProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPATProfH.setDirCareType(root.getAlliedNP_label());
			alliedNPATProfH.setDirCareName(root.getAlliedNP_label5());
			alliedNPATProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedNPProdH_calc5());
			alliedNPATProfH.setDirCareProdHrsTotalYtd(root.getAlliedNPProdH_sub5());
			alliedNPATProfH.setDirCareTotalHrsPaidYtd(root.getAlliedNPProdH_THP5());
			alliedNPATProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedNPNProdH_calc5());

			LtcYtdDirectCareHrs alliedNPOTHProfH = new LtcYtdDirectCareHrs();
			alliedNPOTHProfH.setDirCareProdHrsRegYtd(root.getAlliedNPProdH_item16());
			alliedNPOTHProfH.setDirCareProdHrsOtYtd(root.getAlliedNPProdH_item26());
			alliedNPOTHProfH.setDirCareProdHrsContractedYtd(root.getAlliedNPProdHCS6());
			alliedNPOTHProfH.setDirCareNonProdHrsVacYtd(root.getAlliedNPNProdH_item16());
			alliedNPOTHProfH.setDirCareNonProdHrsSickYtd(root.getAlliedNPNProdH_item26());
			alliedNPOTHProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedNPNProdH_item36());
			alliedNPOTHProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPOTHProfH.setDirCareType(root.getAlliedNP_label());
			alliedNPOTHProfH.setDirCareName(Constants.DC_HRS_OTHER);
			alliedNPOTHProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedNPProdH_calc6());
			alliedNPOTHProfH.setDirCareProdHrsTotalYtd(root.getAlliedNPProdH_sub6());
			alliedNPOTHProfH.setDirCareTotalHrsPaidYtd(root.getAlliedNPProdH_THP6());
			alliedNPOTHProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedNPNProdH_calc6());
			alliedNPOTHProfH.setDirCareOtherValue(root.getAlliedNP_label6());

			Collections.addAll(ltcYtdDcHrs, nursingRNProdH, nursingLPNProdH, nursingHCAProdH, alliedOTProfH,
					alliedPTProfH, alliedDTProfH, alliedSWProfH, alliedSLPProfH, alliedRTProfH, alliedNPRTProfH,
					alliedNPRAProfH, alliedNPAWProfH, alliedNPMTProfH, alliedNPATProfH,nursingOthProdH,
					alliedOTHProfH, alliedNPOTHProfH);

			/* END : Direct Care Hours */

			/* Direct Care Hours Subtotals */
			LtcYtdDirectCareHrsSubTotals nursingDirCareHrsSubTotal = new LtcYtdDirectCareHrsSubTotals();
			nursingDirCareHrsSubTotal.setDirCareType(root.getNursing_label());
			nursingDirCareHrsSubTotal.setSubTotalDirCareProdHrsRegularYTD(root.getNursingProdH_sum11());
			nursingDirCareHrsSubTotal.setSubTotalDirCareProdHrsOTYTD(root.getNursingProdH_sum21());
			nursingDirCareHrsSubTotal.setSubTotalDirCareProdHrsSubtotalYTD(root.getNursingProdH_calcsum1());
			nursingDirCareHrsSubTotal.setSubTotalDirCareProdHrsContServYTD(root.getNursingProdHCS_subsum1());
			nursingDirCareHrsSubTotal.setSubTotalDirCareProdHrsTotalYTD(root.getNursingProdH_subsum1());
			nursingDirCareHrsSubTotal.setSubTotalDirCareTotalHrsPaidYTD(root.getNursingProdH_THPsum1());
			nursingDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsVacYTD(root.getNursingNProdH_sum11());
			nursingDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsSickYTD(root.getNursingNProdH_sum21());
			nursingDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsOtherServYTD(root.getNursingNProdH_sum31());
			nursingDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsTotalYTD(root.getNursingNProdH_calcsum1());
			nursingDirCareHrsSubTotal.setConfirmationID(root.getForm().getConfirmationId());
			

			LtcYtdDirectCareHrsSubTotals alliedDirCareHrsSubTotal = new LtcYtdDirectCareHrsSubTotals();
			alliedDirCareHrsSubTotal.setDirCareType(root.getAlliedProf_label());
			
			alliedDirCareHrsSubTotal.setSubTotalDirCareProdHrsRegularYTD(root.getAlliedProfProdH_sum11());
			alliedDirCareHrsSubTotal.setSubTotalDirCareProdHrsOTYTD(root.getAlliedProfProdH_sum21());
			alliedDirCareHrsSubTotal.setSubTotalDirCareProdHrsSubtotalYTD(root.getAlliedProfProdH_calcsum1());
			alliedDirCareHrsSubTotal.setSubTotalDirCareProdHrsContServYTD(root.getAlliedProfProdHCS_subsum1());
			alliedDirCareHrsSubTotal.setSubTotalDirCareProdHrsTotalYTD(root.getAlliedProfProdH_subsum1());
			alliedDirCareHrsSubTotal.setSubTotalDirCareTotalHrsPaidYTD(root.getAlliedProfProdH_THPsum1());
			alliedDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsVacYTD(root.getAlliedProfNProdH_sum11());
			alliedDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsSickYTD(root.getAlliedNProdH_sum21());
			alliedDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsOtherServYTD(root.getAlliedProfNProdH_sum31());
			alliedDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsTotalYTD(root.getAlliedProfNProdH_calcsum1());
			alliedDirCareHrsSubTotal.setConfirmationID(root.getForm().getConfirmationId());

			LtcYtdDirectCareHrsSubTotals alliedNPDirCareHrsSubTotal = new LtcYtdDirectCareHrsSubTotals();
			alliedNPDirCareHrsSubTotal.setDirCareType(root.getAlliedNP_label());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareProdHrsRegularYTD(root.getAlliedNPProdH_sum11());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareProdHrsOTYTD(root.getAlliedNPProdH_sum21());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareProdHrsSubtotalYTD(root.getAlliedNPProdH_calcsum1());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareProdHrsContServYTD(root.getAlliedNPProdHCS_subsum1());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareProdHrsTotalYTD(root.getAlliedNPProdH_subsum1());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareTotalHrsPaidYTD(root.getAlliedNPProdH_THPsum1());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsVacYTD(root.getAlliedNPNProdH_sum11());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsSickYTD(root.getAlliedNPNProdH_sum21());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsOtherServYTD(root.getAlliedNPNProdH_sum31());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsTotalYTD(root.getAlliedNPNProdH_calcsum1());
			alliedNPDirCareHrsSubTotal.setConfirmationID(root.getForm().getConfirmationId());

			Collections.addAll(ltcYtdDcHrsSubttls, nursingDirCareHrsSubTotal,alliedDirCareHrsSubTotal,alliedNPDirCareHrsSubTotal);
			/* END */


			/* START : Direct Care Cost */
			LtcYtdDirectCareCost nursingRNProdC = new LtcYtdDirectCareCost();
			nursingRNProdC.setDirCareCostProdHrsRegYtd(root.getNursingProdC_item11());
			nursingRNProdC.setDirCareCostProdHrsOtYtd(root.getNursingProdC_item21());
			nursingRNProdC.setDirCareCostProdHrsContractedYtd(root.getNursingProdCCS1());
			nursingRNProdC.setDirCareCostNonProdHrsVacYtd(root.getNursingNProdC_item11());
			nursingRNProdC.setDirCareCostNonProdHrsSickYtd(root.getNursingNProdC_item21());
			nursingRNProdC.setDirCareCostNonProdHrsOtherYtd(root.getNursingNProdC_item31());
			nursingRNProdC.setConfirmationId(root.getForm().getConfirmationId());
			nursingRNProdC.setDirCareCostType(root.getNursing_label());
			nursingRNProdC.setDirCareCostName(root.getNursing_label1());
			nursingRNProdC.setDirCareCostProdHrsSubtotalYtd(root.getNursingProdC_calc1());
			nursingRNProdC.setDirCareCostProdHrsTotalYtd(root.getNursingProdC_sub1());
			nursingRNProdC.setDirCareCostTotalHrsPaidYtd(root.getNursingProdC_THP1());
			nursingRNProdC.setDirCareCostNonProdHrsTotalYtd(root.getNursingNProdC_calc1());
			nursingRNProdC.setDirCareCostHourlyRateStaffYtd(root.getNursingStaffRate1());
			nursingRNProdC.setDirCareCostHourlyRateContractedYtd(root.getNursingContractRate1());
			/* END : Direct Care Cost */

			LtcYtdDirectCareCost nursingLPNProdC = new LtcYtdDirectCareCost();
			nursingLPNProdC.setDirCareCostProdHrsRegYtd(root.getNursingProdC_item12());
			nursingLPNProdC.setDirCareCostProdHrsOtYtd(root.getNursingProdC_item22());
			nursingLPNProdC.setDirCareCostProdHrsContractedYtd(root.getNursingProdCCS2());
			nursingLPNProdC.setDirCareCostNonProdHrsVacYtd(root.getNursingNProdC_item12());
			nursingLPNProdC.setDirCareCostNonProdHrsSickYtd(root.getNursingNProdC_item22());
			nursingLPNProdC.setDirCareCostNonProdHrsOtherYtd(root.getNursingNProdC_item32());
			nursingLPNProdC.setConfirmationId(root.getForm().getConfirmationId());
			nursingLPNProdC.setDirCareCostType(root.getNursing_label());
			nursingLPNProdC.setDirCareCostName(root.getNursing_label2());
			nursingLPNProdC.setDirCareCostProdHrsSubtotalYtd(root.getNursingProdC_calc2());
			nursingLPNProdC.setDirCareCostProdHrsTotalYtd(root.getNursingProdC_sub2());
			nursingLPNProdC.setDirCareCostTotalHrsPaidYtd(root.getNursingProdC_THP2());
			nursingLPNProdC.setDirCareCostNonProdHrsTotalYtd(root.getNursingNProdC_calc2());
			nursingLPNProdC.setDirCareCostHourlyRateStaffYtd(root.getNursingStaffRate2());
			nursingLPNProdC.setDirCareCostHourlyRateContractedYtd(root.getNursingContractRate2());



			LtcYtdDirectCareCost nursingHCAProdC = new LtcYtdDirectCareCost();
			nursingHCAProdC.setDirCareCostProdHrsRegYtd(root.getNursingProdC_item13());
			nursingHCAProdC.setDirCareCostProdHrsOtYtd(root.getNursingProdC_item23());
			nursingHCAProdC.setDirCareCostProdHrsContractedYtd(root.getNursingProdCCS3());
			nursingHCAProdC.setDirCareCostNonProdHrsVacYtd(root.getNursingNProdC_item13());
			nursingHCAProdC.setDirCareCostNonProdHrsSickYtd(root.getNursingNProdC_item23());
			nursingHCAProdC.setDirCareCostNonProdHrsOtherYtd(root.getNursingNProdC_item33());
			nursingHCAProdC.setConfirmationId(root.getForm().getConfirmationId());
			nursingHCAProdC.setDirCareCostType(root.getNursing_label());
			nursingHCAProdC.setDirCareCostName(root.getNursing_label3());
			nursingHCAProdC.setDirCareCostProdHrsSubtotalYtd(root.getNursingProdC_calc3());
			nursingHCAProdC.setDirCareCostProdHrsTotalYtd(root.getNursingProdC_sub3());
			nursingHCAProdC.setDirCareCostTotalHrsPaidYtd(root.getNursingProdC_THP3());
			nursingHCAProdC.setDirCareCostNonProdHrsTotalYtd(root.getNursingNProdC_calc3());
			nursingHCAProdC.setDirCareCostHourlyRateStaffYtd(root.getNursingStaffRate3());
			nursingHCAProdC.setDirCareCostHourlyRateContractedYtd(root.getNursingContractRate3());


			LtcYtdDirectCareCost nursingOthProdC = new LtcYtdDirectCareCost();
			nursingOthProdC.setDirCareCostProdHrsRegYtd(root.getNursingProdC_item14());
			nursingOthProdC.setDirCareCostProdHrsOtYtd(root.getNursingProdC_item24());
			nursingOthProdC.setDirCareCostProdHrsContractedYtd(root.getNursingProdCCS4());
			nursingOthProdC.setDirCareCostNonProdHrsVacYtd(root.getNursingNProdC_item14());
			nursingOthProdC.setDirCareCostNonProdHrsSickYtd(root.getNursingNProdC_item24());
			nursingOthProdC.setDirCareCostNonProdHrsOtherYtd(root.getNursingNProdC_item34());
			nursingOthProdC.setConfirmationId(root.getForm().getConfirmationId());
			nursingOthProdC.setDirCareCostType(root.getNursing_label());
			nursingOthProdC.setDirCareCostName(Constants.DC_HRS_OTHER);
			nursingOthProdC.setDirCareCostProdHrsSubtotalYtd(root.getNursingProdC_calc4());
			nursingOthProdC.setDirCareCostProdHrsTotalYtd(root.getNursingProdC_sub4());
			nursingOthProdC.setDirCareCostTotalHrsPaidYtd(root.getNursingProdC_THP4());
			nursingOthProdC.setDirCareCostNonProdHrsTotalYtd(root.getNursingNProdC_calc4());
			nursingOthProdC.setDirCareCostHourlyRateStaffYtd(root.getNursingStaffRate4());
			nursingOthProdC.setDirCareCostHourlyRateContractedYtd(root.getNursingContractRate4());
			nursingOthProdC.setDirCareOtherValue(root.getNursing_label4());




			// Allied Prof
			LtcYtdDirectCareCost alliedOTProfC = new LtcYtdDirectCareCost();
			alliedOTProfC.setDirCareCostProdHrsRegYtd(root.getAlliedProfProdC_item11());
			alliedOTProfC.setDirCareCostProdHrsOtYtd(root.getAlliedProfProdC_item21());
			alliedOTProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedProfProdCCS1());
			alliedOTProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedProfNProdC_item11());
			alliedOTProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedProfNProdC_item21());
			alliedOTProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedProfNProdC_item31());
			alliedOTProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedOTProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedOTProfC.setDirCareCostName(root.getAlliedProf_label1());
			alliedOTProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedProfProdC_calc1());
			alliedOTProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedProfProdC_sub1());
			alliedOTProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedProfProdC_THP1());
			alliedOTProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedProfNProdC_calc1());
			alliedOTProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedProfStaffRate1());
			alliedOTProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedProfContractRate1());


			LtcYtdDirectCareCost alliedPTProfC = new LtcYtdDirectCareCost();
			alliedPTProfC.setDirCareCostProdHrsRegYtd(root.getAlliedProfProdC_item12());
			alliedPTProfC.setDirCareCostProdHrsOtYtd(root.getAlliedProfProdC_item22());
			alliedPTProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedProfProdCCS2());
			alliedPTProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedProfNProdC_item12());
			alliedPTProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedProfNProdC_item22());
			alliedPTProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedProfNProdC_item32());
			alliedPTProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedPTProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedPTProfC.setDirCareCostName(root.getAlliedProf_label2());
			alliedPTProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedProfProdC_calc2());
			alliedPTProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedProfProdC_sub2());
			alliedPTProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedProfProdC_THP2());
			alliedPTProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedProfNProdC_calc2());
			alliedPTProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedProfStaffRate2());
			alliedPTProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedProfContractRate2());



			LtcYtdDirectCareCost alliedDTProfC = new LtcYtdDirectCareCost();
			alliedDTProfC.setDirCareCostProdHrsRegYtd(root.getAlliedProfProdC_item13());
			alliedDTProfC.setDirCareCostProdHrsOtYtd(root.getAlliedProfProdC_item23());
			alliedDTProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedProfProdCCS3());
			alliedDTProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedProfNProdC_item13());
			alliedDTProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedProfNProdC_item23());
			alliedDTProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedProfNProdC_item33());
			alliedDTProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedDTProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedDTProfC.setDirCareCostName(root.getAlliedProf_label3());
			alliedDTProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedProfProdC_calc3());
			alliedDTProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedProfProdC_sub3());
			alliedDTProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedProfProdC_THP3());
			alliedDTProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedProfNProdC_calc3());
			alliedDTProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedProfStaffRate3());
			alliedDTProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedProfContractRate3());



			LtcYtdDirectCareCost alliedSWProfC = new LtcYtdDirectCareCost();
			alliedSWProfC.setDirCareCostProdHrsRegYtd(root.getAlliedProfProdC_item14());
			alliedSWProfC.setDirCareCostProdHrsOtYtd(root.getAlliedProfProdC_item24());
			alliedSWProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedProfProdCCS4());
			alliedSWProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedProfNProdC_item14());
			alliedSWProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedProfNProdC_item24());
			alliedSWProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedProfNProdC_item34());
			alliedSWProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedSWProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedSWProfC.setDirCareCostName(root.getAlliedProf_label4());
			alliedSWProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedProfProdC_calc4());
			alliedSWProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedProfProdC_sub4());
			alliedSWProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedProfProdC_THP4());
			alliedSWProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedProfNProdC_calc4());
			alliedSWProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedProfStaffRate4());
			alliedSWProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedProfContractRate4());

			LtcYtdDirectCareCost alliedSLPProfC = new LtcYtdDirectCareCost();
			alliedSLPProfC.setDirCareCostProdHrsRegYtd(root.getAlliedProfProdC_item15());
			alliedSLPProfC.setDirCareCostProdHrsOtYtd(root.getAlliedProfProdC_item25());
			alliedSLPProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedProfProdCCS5());
			alliedSLPProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedProfNProdC_item15());
			alliedSLPProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedProfNProdC_item25());
			alliedSLPProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedProfNProdC_item35());
			alliedSLPProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedSLPProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedSLPProfC.setDirCareCostName(root.getAlliedProf_label5());
			alliedSLPProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedProfProdC_calc5());
			alliedSLPProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedProfProdC_sub5());
			alliedSLPProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedProfProdC_THP5());
			alliedSLPProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedProfNProdC_calc5());
			alliedSLPProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedProfStaffRate5());
			alliedSLPProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedProfContractRate5());

			LtcYtdDirectCareCost alliedRTProfC = new LtcYtdDirectCareCost();
			alliedRTProfC.setDirCareCostProdHrsRegYtd(root.getAlliedProfProdC_item16());
			alliedRTProfC.setDirCareCostProdHrsOtYtd(root.getAlliedProfProdC_item26());
			alliedRTProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedProfProdCCS6());
			alliedRTProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedProfNProdC_item16());
			alliedRTProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedProfNProdC_item26());
			alliedRTProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedProfNProdC_item36());
			alliedRTProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedRTProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedRTProfC.setDirCareCostName(root.getAlliedProf_label6());
			alliedRTProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedProfProdC_calc6());
			alliedRTProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedProfProdC_sub6());
			alliedRTProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedProfProdC_THP6());
			alliedRTProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedProfNProdC_calc6());
			alliedRTProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedProfStaffRate6());
			alliedRTProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedProfContractRate6());

			LtcYtdDirectCareCost alliedOTHProfC = new LtcYtdDirectCareCost();
			alliedOTHProfC.setDirCareCostProdHrsRegYtd(root.getAlliedProfProdC_item17());
			alliedOTHProfC.setDirCareCostProdHrsOtYtd(root.getAlliedProfProdC_item27());
			alliedOTHProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedProfProdCCS7());
			alliedOTHProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedProfNProdC_item17());
			alliedOTHProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedProfNProdC_item27());
			alliedOTHProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedProfNProdC_item37());
			alliedOTHProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedOTHProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedOTHProfC.setDirCareCostName(Constants.DC_HRS_OTHER);
			alliedOTHProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedProfProdC_calc7());
			alliedOTHProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedProfProdC_sub7());
			alliedOTHProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedProfProdC_THP7());
			alliedOTHProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedProfNProdC_calc7());
			alliedOTHProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedProfStaffRate7());
			alliedOTHProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedProfContractRate7());
			alliedOTHProfC.setDirCareOtherValue(root.getAlliedProf_label7());


			// Allied Non Professional
			LtcYtdDirectCareCost alliedNPRTProfC = new LtcYtdDirectCareCost();
			alliedNPRTProfC.setDirCareCostProdHrsRegYtd(root.getAlliedNPProdC_item11());
			alliedNPRTProfC.setDirCareCostProdHrsOtYtd(root.getAlliedNPProdC_item21());
			alliedNPRTProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedNPProdCCS1());
			alliedNPRTProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedNPNProdC_item11());
			alliedNPRTProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedNPProdC_item21());
			alliedNPRTProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedNPNProdC_item31());
			alliedNPRTProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRTProfC.setDirCareCostType(root.getAlliedNP_label());
			alliedNPRTProfC.setDirCareCostName(root.getAlliedNP_label1());
			alliedNPRTProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedNPProdC_calc1());
			alliedNPRTProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedNPProdC_sub1());
			alliedNPRTProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedNPProdC_THP1());
			alliedNPRTProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedNPNProdC_calc1());
			alliedNPRTProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedNPStaffRate1());
			alliedNPRTProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedNPContractRate1());


			LtcYtdDirectCareCost alliedNPRAProfC = new LtcYtdDirectCareCost();
			alliedNPRAProfC.setDirCareCostProdHrsRegYtd(root.getAlliedNPProdC_item12());
			alliedNPRAProfC.setDirCareCostProdHrsOtYtd(root.getAlliedNPProdC_item22());
			alliedNPRAProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedNPProdCCS2());
			alliedNPRAProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedNPNProdC_item12());
			alliedNPRAProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedNPProdC_item22());
			alliedNPRAProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedNPNProdC_item32());
			alliedNPRAProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRAProfC.setDirCareCostType(root.getAlliedNP_label());
			alliedNPRAProfC.setDirCareCostName(root.getAlliedNP_label2());
			alliedNPRAProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedNPProdC_calc2());
			alliedNPRAProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedNPProdC_sub2());
			alliedNPRAProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedNPProdC_THP2());
			alliedNPRAProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedNPNProdC_calc2());
			alliedNPRAProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedNPStaffRate2());
			alliedNPRAProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedNPContractRate2());



			LtcYtdDirectCareCost alliedNPAWProfC = new LtcYtdDirectCareCost();
			alliedNPAWProfC.setDirCareCostProdHrsRegYtd(root.getAlliedNPProdC_item13());
			alliedNPAWProfC.setDirCareCostProdHrsOtYtd(root.getAlliedNPProdC_item23());
			alliedNPAWProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedNPProdCCS3());
			alliedNPAWProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedNPNProdC_item13());
			alliedNPAWProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedNPProdC_item23());
			alliedNPAWProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedNPNProdC_item33());
			alliedNPAWProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPAWProfC.setDirCareCostType(root.getAlliedNP_label());
			alliedNPAWProfC.setDirCareCostName(root.getAlliedNP_label3());
			alliedNPAWProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedNPProdC_calc3());
			alliedNPAWProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedNPProdC_sub3());
			alliedNPAWProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedNPProdC_THP3());
			alliedNPAWProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedNPNProdC_calc3());
			alliedNPAWProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedNPStaffRate3());
			alliedNPAWProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedNPContractRate3());



			LtcYtdDirectCareCost alliedNPMTProfC = new LtcYtdDirectCareCost();
			alliedNPMTProfC.setDirCareCostProdHrsRegYtd(root.getAlliedNPProdC_item14());
			alliedNPMTProfC.setDirCareCostProdHrsOtYtd(root.getAlliedNPProdC_item24());
			alliedNPMTProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedNPProdCCS4());
			alliedNPMTProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedNPNProdC_item14());
			alliedNPMTProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedNPProdC_item24());
			alliedNPMTProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedNPNProdC_item34());
			alliedNPMTProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPMTProfC.setDirCareCostType(root.getAlliedNP_label());
			alliedNPMTProfC.setDirCareCostName(root.getAlliedNP_label4());
			alliedNPMTProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedNPProdC_calc4());
			alliedNPMTProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedNPProdC_sub4());
			alliedNPMTProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedNPProdC_THP4());
			alliedNPMTProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedNPNProdC_calc4());
			alliedNPMTProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedNPStaffRate4());
			alliedNPMTProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedNPContractRate4());



			LtcYtdDirectCareCost alliedNPATProfC = new LtcYtdDirectCareCost();
			alliedNPATProfC.setDirCareCostProdHrsRegYtd(root.getAlliedNPProdC_item15());
			alliedNPATProfC.setDirCareCostProdHrsOtYtd(root.getAlliedNPProdC_item25());
			alliedNPATProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedNPProdCCS5());
			alliedNPATProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedNPNProdC_item15());
			alliedNPATProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedNPProdC_item25());
			alliedNPATProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedNPNProdC_item35());
			alliedNPATProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPATProfC.setDirCareCostType(root.getAlliedNP_label());
			alliedNPATProfC.setDirCareCostName(root.getAlliedNP_label5());
			alliedNPATProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedNPProdC_calc5());
			alliedNPATProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedNPProdC_sub5());
			alliedNPATProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedNPProdC_THP5());
			alliedNPATProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedNPNProdC_calc5());
			alliedNPATProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedNPStaffRate5());
			alliedNPATProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedNPContractRate5());


			
			LtcYtdDirectCareCost alliedNPOTHProfC = new LtcYtdDirectCareCost();
			alliedNPOTHProfC.setDirCareCostProdHrsRegYtd(root.getAlliedNPProdC_item16());
			alliedNPOTHProfC.setDirCareCostProdHrsOtYtd(root.getAlliedNPProdC_item26());
			alliedNPOTHProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedNPProdCCS6());
			alliedNPOTHProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedNPNProdC_item16());
			alliedNPOTHProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedNPProdC_item26());
			alliedNPOTHProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedNPNProdC_item36());
			alliedNPOTHProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPOTHProfC.setDirCareCostType(root.getAlliedNP_label());
			alliedNPOTHProfC.setDirCareCostName(Constants.DC_HRS_OTHER);
			alliedNPOTHProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedNPProdC_calc6());
			alliedNPOTHProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedNPProdC_sub6());
			alliedNPOTHProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedNPProdC_THP6());
			alliedNPOTHProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedNPNProdC_calc6());
			alliedNPOTHProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedNPStaffRate6());
			alliedNPOTHProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedNPContractRate6());
			alliedNPOTHProfC.setDirCareOtherValue(root.getAlliedNP_label6());

			Collections.addAll(ltcYtdDcCost, nursingRNProdC, nursingLPNProdC, nursingHCAProdC,nursingOthProdC, alliedOTProfC,
					alliedPTProfC, alliedDTProfC, alliedSWProfC, alliedSLPProfC, alliedRTProfC, alliedNPRTProfC, alliedNPRAProfC, alliedNPAWProfC,
					alliedNPMTProfC, alliedNPATProfC,alliedOTHProfC,
					alliedNPOTHProfC);

			/* Direct Care Cost Subtotals */
			LtcYtdDirectCareCostSubtotals nursingCareCostSubtotals = new LtcYtdDirectCareCostSubtotals();
			nursingCareCostSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			nursingCareCostSubtotals.setDirCareType(root.getNursing_label());
			nursingCareCostSubtotals.setSubTotalDirCareCostProdHrsRegularYTD(root.getNursingProdC_sum11());
			nursingCareCostSubtotals.setSubTotalDirCareCostProdHrsOTYTD(root.getNursingProdC_sum21());
			nursingCareCostSubtotals.setSubTotalDirCareCostProdHrsSubtotalYTD(root.getNursingProdC_calc1());
			nursingCareCostSubtotals.setSubTotalDirCareCostProdHrsContServYTD(root.getNursingProdCCS_subsum1());
			nursingCareCostSubtotals.setSubTotalDirCareCostProdHrsTotalYTD(root.getNursingProdC_subsum1());
			nursingCareCostSubtotals.setSubTotalDirCareCostTotalHrsPaidYTD(root.getNursingProdC_sum11());
			nursingCareCostSubtotals.setSubTotalDirCareCostNonProdHrsVacYTD(root.getNursingNProdC_sum11());
			nursingCareCostSubtotals.setSubTotalDirCareCostNonProdHrsSickYTD(root.getNursingNProdC_sum21());
			nursingCareCostSubtotals.setSubTotalDirCareCostNonProdHrsOtherServYTD(root.getNursingNProdC_sum31());
			nursingCareCostSubtotals.setSubTotalDirCareCostNonProdHrsTotalYTD(root.getNursingNProdC_calcsum1());
			nursingCareCostSubtotals.setSubTotalDirCareCostHourlyRateStaffYTD(root.getNursingStaffRate1());
			nursingCareCostSubtotals.setSubTotalDirCareCostHourlyRateContractedYTD(root.getNursingContractRate1());

			LtcYtdDirectCareCostSubtotals alliedCareCostSubtotals = new LtcYtdDirectCareCostSubtotals();
			alliedCareCostSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			alliedCareCostSubtotals.setDirCareType(root.getAlliedProf_label());
			alliedCareCostSubtotals.setSubTotalDirCareCostProdHrsRegularYTD(root.getAlliedProfProdC_sum11());
			alliedCareCostSubtotals.setSubTotalDirCareCostProdHrsOTYTD(root.getAlliedProfProdC_sum21());
			alliedCareCostSubtotals.setSubTotalDirCareCostProdHrsSubtotalYTD(root.getAlliedProfProdC_calc1());
			alliedCareCostSubtotals.setSubTotalDirCareCostProdHrsContServYTD(root.getAlliedProfProdCCS_subsum1());
			alliedCareCostSubtotals.setSubTotalDirCareCostProdHrsTotalYTD(root.getAlliedProfProdC_subsum1());
			alliedCareCostSubtotals.setSubTotalDirCareCostTotalHrsPaidYTD(root.getAlliedProfProdC_sum11());
			alliedCareCostSubtotals.setSubTotalDirCareCostNonProdHrsVacYTD(root.getAlliedProfNProdC_sum11());
			alliedCareCostSubtotals.setSubTotalDirCareCostNonProdHrsSickYTD(root.getAlliedNProdC_sum21());
			alliedCareCostSubtotals.setSubTotalDirCareCostNonProdHrsOtherServYTD(root.getAlliedProfNProdC_sum31());
			alliedCareCostSubtotals.setSubTotalDirCareCostNonProdHrsTotalYTD(root.getAlliedProfNProdC_calcsum1());
			alliedCareCostSubtotals.setSubTotalDirCareCostHourlyRateStaffYTD(root.getAlliedProfStaffRate_total());
			alliedCareCostSubtotals.setSubTotalDirCareCostHourlyRateContractedYTD(root.getAlliedProfContractRate_total());
			
			LtcYtdDirectCareCostSubtotals alliedNProfCareCostSubtotals = new LtcYtdDirectCareCostSubtotals();
			alliedNProfCareCostSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			alliedNProfCareCostSubtotals.setDirCareType(root.getAlliedNP_label());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostProdHrsRegularYTD(root.getAlliedNPProdC_sum11());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostProdHrsOTYTD(root.getAlliedNPProdC_sum21());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostProdHrsSubtotalYTD(root.getAlliedNPProdC_calc1());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostProdHrsContServYTD(root.getAlliedNPProdCCS_subsum1());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostProdHrsTotalYTD(root.getAlliedNPProdC_subsum1());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostTotalHrsPaidYTD(root.getAlliedNPProdC_sum11());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostNonProdHrsVacYTD(root.getAlliedNPNProdC_sum11());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostNonProdHrsSickYTD(root.getAlliedNPNProdC_sum21());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostNonProdHrsOtherServYTD(root.getAlliedNPNProdC_sum31());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostNonProdHrsTotalYTD(root.getAlliedNPNProdC_calcsum1());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostHourlyRateStaffYTD(root.getAlliedNPStaffRate_total());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostHourlyRateContractedYTD(root.getAlliedNPContractRate_total());
			
			Collections.addAll(ltcYtdDcCostSubttls,nursingCareCostSubtotals,alliedCareCostSubtotals,alliedNProfCareCostSubtotals);

			/*
			 * START Compensation & Benefits Budget => Direct Care => Salaries, Wages and
			 * Contracted Services.
			 */
			LtcYtdCompSal supportFoodServices = new LtcYtdCompSal();
			supportFoodServices.setCompSalStaffYtd(root.getCompB_item11());
			supportFoodServices.setCompSalContractServicesYtd(root.getCompB_item21());
			supportFoodServices.setCompSalOfficeAllocYtd(root.getCompB_item31());
			supportFoodServices.setCompSalName(root.getSupport_label1());
			supportFoodServices.setCompSalType(root.getSupport_label());
			supportFoodServices.setConfirmationId(root.getForm().getConfirmationId());
			supportFoodServices.setCompSalTotalCostYtd(root.getCompB_calc1());
			
			LtcYtdCompSal supportLaundryServices = new LtcYtdCompSal();
			supportLaundryServices.setCompSalStaffYtd(root.getCompB_item12());
			supportLaundryServices.setCompSalContractServicesYtd(root.getCompB_item22());
			supportLaundryServices.setCompSalOfficeAllocYtd(root.getCompB_item32());
			supportLaundryServices.setCompSalName(root.getSupport_label2());
			supportLaundryServices.setCompSalType(root.getSupport_label());
			supportLaundryServices.setConfirmationId(root.getForm().getConfirmationId());
			supportLaundryServices.setCompSalTotalCostYtd(root.getCompB_calc2());

			LtcYtdCompSal supportHousekeeping = new LtcYtdCompSal();
			supportHousekeeping.setCompSalStaffYtd(root.getCompB_item13());
			supportHousekeeping.setCompSalContractServicesYtd(root.getCompB_item23());
			supportHousekeeping.setCompSalOfficeAllocYtd(root.getCompB_item33());
			supportHousekeeping.setCompSalName(root.getSupport_label3());
			supportHousekeeping.setCompSalType(root.getSupport_label());
			supportHousekeeping.setConfirmationId(root.getForm().getConfirmationId());
			supportHousekeeping.setCompSalTotalCostYtd(root.getCompB_calc3());

			LtcYtdCompSal supportPlantMntnce = new LtcYtdCompSal();
			supportPlantMntnce.setCompSalStaffYtd(root.getCompB_item14());
			supportPlantMntnce.setCompSalContractServicesYtd(root.getCompB_item24());
			supportPlantMntnce.setCompSalOfficeAllocYtd(root.getCompB_item34());
			supportPlantMntnce.setCompSalName(root.getSupport_label4());
			supportPlantMntnce.setCompSalType(root.getSupport_label());
			supportPlantMntnce.setConfirmationId(root.getForm().getConfirmationId());
			supportPlantMntnce.setCompSalTotalCostYtd(root.getCompB_calc4());
			// Administration

			LtcYtdCompSal adminAdministrator = new LtcYtdCompSal();
			adminAdministrator.setCompSalStaffYtd(root.getCompB_item15());
			adminAdministrator.setCompSalContractServicesYtd(root.getCompB_item25());
			adminAdministrator.setCompSalOfficeAllocYtd(root.getCompB_item35());
			adminAdministrator.setCompSalName("Administrator");
			adminAdministrator.setCompSalType("Support/Administration");
			adminAdministrator.setConfirmationId(root.getForm().getConfirmationId());
			adminAdministrator.setCompSalTotalCostYtd(root.getCompB_calc5());

			LtcYtdCompSal adminDirOfCare = new LtcYtdCompSal();
			adminDirOfCare.setCompSalStaffYtd(root.getCompB_item16());
			adminDirOfCare.setCompSalContractServicesYtd(root.getCompB_item26());
			adminDirOfCare.setCompSalOfficeAllocYtd(root.getCompB_item36());
			adminDirOfCare.setCompSalName("Director of Care");
			adminDirOfCare.setCompSalType("Support/Administration");
			adminDirOfCare.setConfirmationId(root.getForm().getConfirmationId());
			adminDirOfCare.setCompSalTotalCostYtd(root.getCompB_calc6());

			LtcYtdCompSal adminDeptManagers = new LtcYtdCompSal();
			adminDeptManagers.setCompSalStaffYtd(root.getCompB_item17());
			adminDeptManagers.setCompSalContractServicesYtd(root.getCompB_item27());
			adminDeptManagers.setCompSalOfficeAllocYtd(root.getCompB_item37());
			adminDeptManagers.setCompSalName("Dept Managers");
			adminDeptManagers.setCompSalType("Support/Administration");
			adminDeptManagers.setConfirmationId(root.getForm().getConfirmationId());
			adminDeptManagers.setCompSalTotalCostYtd(root.getCompB_calc7());

			LtcYtdCompSal adminSupport = new LtcYtdCompSal();
			adminSupport.setCompSalStaffYtd(root.getCompB_item18());
			adminSupport.setCompSalContractServicesYtd(root.getCompB_item28());
			adminSupport.setCompSalOfficeAllocYtd(root.getCompB_item38());
			adminSupport.setCompSalName("Administrative Support");
			adminSupport.setCompSalType("Support/Administration");
			adminSupport.setConfirmationId(root.getForm().getConfirmationId());
			adminSupport.setCompSalTotalCostYtd(root.getCompB_calc8());

			LtcYtdCompSal adminPastoCareWrkr = new LtcYtdCompSal();
			adminPastoCareWrkr.setCompSalStaffYtd(root.getCompB_item19());
			adminPastoCareWrkr.setCompSalContractServicesYtd(root.getCompB_item29());
			adminPastoCareWrkr.setCompSalOfficeAllocYtd(root.getCompB_item39());
			adminPastoCareWrkr.setCompSalName("Pastoral Care Worker");
			adminPastoCareWrkr.setCompSalType("Support/Administration");
			adminPastoCareWrkr.setConfirmationId(root.getForm().getConfirmationId());
			adminPastoCareWrkr.setCompSalTotalCostYtd(root.getCompB_calc9());

			LtcYtdCompSal adminClrks = new LtcYtdCompSal();
			adminClrks.setCompSalStaffYtd(root.getCompB_item110());
			adminClrks.setCompSalContractServicesYtd(root.getCompB_item210());
			adminClrks.setCompSalOfficeAllocYtd(root.getCompB_item310());
			adminClrks.setCompSalName("Clerical Clerks");
			adminClrks.setCompSalType("Support/Administration");
			adminClrks.setConfirmationId(root.getForm().getConfirmationId());
			adminClrks.setCompSalTotalCostYtd(root.getCompB_calc10());

			LtcYtdCompSal adminClncCrdinator = new LtcYtdCompSal();
			adminClncCrdinator.setCompSalStaffYtd(root.getCompB_item111());
			adminClncCrdinator.setCompSalContractServicesYtd(root.getCompB_item211());
			adminClncCrdinator.setCompSalOfficeAllocYtd(root.getCompB_item311());
			adminClncCrdinator.setCompSalName("Clinical Coordinator");
			adminClncCrdinator.setCompSalType("Support/Administration");
			adminClncCrdinator.setConfirmationId(root.getForm().getConfirmationId());
			adminClncCrdinator.setCompSalTotalCostYtd(root.getCompB_calc11());

			LtcYtdCompSal adminOther = new LtcYtdCompSal();
			adminOther.setCompSalStaffYtd(root.getCompB_item112());
			adminOther.setCompSalContractServicesYtd(root.getCompB_item212());
			adminOther.setCompSalOfficeAllocYtd(root.getCompB_item312());
			adminOther.setCompSalName("Other");
			adminOther.setCompSalType("Support/Administration");
			adminOther.setConfirmationId(root.getForm().getConfirmationId());
			adminOther.setCompSalTotalCostYtd(root.getCompB_calc12());

			/* Direct Care Nursing */
			LtcYtdCompSal nursingRNSal = new LtcYtdCompSal();
			nursingRNSal.setCompSalStaffYtd(root.getCompB_item113());
			nursingRNSal.setCompSalContractServicesYtd(root.getCompB_item213());
			nursingRNSal.setCompSalOfficeAllocYtd(root.getCompB_item313());
			nursingRNSal.setCompSalName("RN");
			nursingRNSal.setCompSalType("Nursing");
			nursingRNSal.setConfirmationId(root.getForm().getConfirmationId());
			nursingRNSal.setCompSalTotalCostYtd(root.getCompB_calc13());
			

			LtcYtdCompSal nursingLPNSal = new LtcYtdCompSal();
			nursingLPNSal.setCompSalStaffYtd(root.getCompB_item114());
			nursingLPNSal.setCompSalContractServicesYtd(root.getCompB_item214());
			nursingLPNSal.setCompSalOfficeAllocYtd(root.getCompB_item314());
			nursingLPNSal.setCompSalName("LPN");
			nursingLPNSal.setCompSalType("Nursing");
			nursingLPNSal.setConfirmationId(root.getForm().getConfirmationId());
			nursingLPNSal.setCompSalTotalCostYtd(root.getCompB_calc14());

			LtcYtdCompSal nursingHCASal = new LtcYtdCompSal();
			nursingHCASal.setCompSalStaffYtd(root.getCompB_item115());
			nursingHCASal.setCompSalContractServicesYtd(root.getCompB_item215());
			nursingHCASal.setCompSalOfficeAllocYtd(root.getCompB_item315());
			nursingHCASal.setCompSalName("Care Aides (HCA)");
			nursingHCASal.setCompSalType("Nursing");
			nursingHCASal.setConfirmationId(root.getForm().getConfirmationId());
			nursingHCASal.setCompSalTotalCostYtd(root.getCompB_calc15());
			

			LtcYtdCompSal nursingOthSal = new LtcYtdCompSal();
			nursingOthSal.setCompSalStaffYtd(root.getCompB_item116());
			nursingOthSal.setCompSalContractServicesYtd(root.getCompB_item216());
			nursingOthSal.setCompSalOfficeAllocYtd(root.getCompB_item316());
			nursingOthSal.setCompSalName("Other (specify)");
			nursingOthSal.setCompSalType("Nursing");
			nursingOthSal.setConfirmationId(root.getForm().getConfirmationId());
			nursingOthSal.setCompSalTotalCostYtd(root.getCompB_calc16());

			/* Allied Professional */
			LtcYtdCompSal alliedProfOTSal = new LtcYtdCompSal();
			alliedProfOTSal.setCompSalStaffYtd(root.getCompB_item117());
			alliedProfOTSal.setCompSalContractServicesYtd(root.getCompB_item217());
			alliedProfOTSal.setCompSalOfficeAllocYtd(root.getCompB_item317());
			alliedProfOTSal.setCompSalName("Occupational Therapist");
			alliedProfOTSal.setCompSalType("Allied professional");
			alliedProfOTSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfOTSal.setCompSalTotalCostYtd(root.getCompB_calc17());

			LtcYtdCompSal alliedProfPTSal = new LtcYtdCompSal();
			alliedProfPTSal.setCompSalStaffYtd(root.getCompB_item118());
			alliedProfPTSal.setCompSalContractServicesYtd(root.getCompB_item218());
			alliedProfPTSal.setCompSalOfficeAllocYtd(root.getCompB_item318());
			alliedProfPTSal.setCompSalName("Physiotherapist");
			alliedProfPTSal.setCompSalType("Allied professional");
			alliedProfPTSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfPTSal.setCompSalTotalCostYtd(root.getCompB_calc18());

			LtcYtdCompSal alliedProfDTSal = new LtcYtdCompSal();
			alliedProfDTSal.setCompSalStaffYtd(root.getCompB_item119());
			alliedProfDTSal.setCompSalContractServicesYtd(root.getCompB_item219());
			alliedProfDTSal.setCompSalOfficeAllocYtd(root.getCompB_item319());
			alliedProfDTSal.setCompSalName("Dietitian");
			alliedProfDTSal.setCompSalType("Allied professional");
			alliedProfDTSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfDTSal.setCompSalTotalCostYtd(root.getCompB_calc19());

			LtcYtdCompSal alliedProfSWSal = new LtcYtdCompSal();
			alliedProfSWSal.setCompSalStaffYtd(root.getCompB_item120());
			alliedProfSWSal.setCompSalContractServicesYtd(root.getCompB_item220());
			alliedProfSWSal.setCompSalOfficeAllocYtd(root.getCompB_item320());
			alliedProfSWSal.setCompSalName("Dietitian");
			alliedProfSWSal.setCompSalType("Allied professional");
			alliedProfSWSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfSWSal.setCompSalTotalCostYtd(root.getCompB_calc20());

			LtcYtdCompSal alliedProfOTHSal = new LtcYtdCompSal();
			alliedProfOTHSal.setCompSalStaffYtd(root.getCompB_item121());
			alliedProfOTHSal.setCompSalContractServicesYtd(root.getCompB_item221());
			alliedProfOTHSal.setCompSalOfficeAllocYtd(root.getCompB_item321());
			alliedProfOTHSal.setCompSalName("Other (specify)");
			alliedProfOTHSal.setCompSalType("Allied professional");
			alliedProfOTHSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfOTHSal.setCompSalTotalCostYtd(root.getCompB_calc21());

			/* Allied Non Professional */
			LtcYtdCompSal alliedNPRTSal = new LtcYtdCompSal();
			alliedNPRTSal.setCompSalStaffYtd(root.getCompB_item122());
			alliedNPRTSal.setCompSalContractServicesYtd(root.getCompB_item222());
			alliedNPRTSal.setCompSalOfficeAllocYtd(root.getCompB_item322());
			alliedNPRTSal.setCompSalName("Recreation Therapist");
			alliedNPRTSal.setCompSalType("Allied Non-professional");
			alliedNPRTSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRTSal.setCompSalTotalCostYtd(root.getCompB_calc22());

			LtcYtdCompSal alliedNPRASal = new LtcYtdCompSal();
			alliedNPRASal.setCompSalStaffYtd(root.getCompB_item123());
			alliedNPRASal.setCompSalContractServicesYtd(root.getCompB_item223());
			alliedNPRASal.setCompSalOfficeAllocYtd(root.getCompB_item323());
			alliedNPRASal.setCompSalName("Rehab Assistant");
			alliedNPRASal.setCompSalType("Allied Non-professional");
			alliedNPRASal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRASal.setCompSalTotalCostYtd(root.getCompB_calc23());

			LtcYtdCompSal alliedNPAWSal = new LtcYtdCompSal();
			alliedNPAWSal.setCompSalStaffYtd(root.getCompB_item124());
			alliedNPAWSal.setCompSalContractServicesYtd(root.getCompB_item224());
			alliedNPAWSal.setCompSalOfficeAllocYtd(root.getCompB_item324());
			alliedNPAWSal.setCompSalName("Activity Worker");
			alliedNPAWSal.setCompSalType("Allied Non-professional");
			alliedNPAWSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPAWSal.setCompSalTotalCostYtd(root.getCompB_calc24());

			LtcYtdCompSal alliedNPMTSal = new LtcYtdCompSal();
			alliedNPMTSal.setCompSalStaffYtd(root.getCompB_item125());
			alliedNPMTSal.setCompSalContractServicesYtd(root.getCompB_item225());
			alliedNPMTSal.setCompSalOfficeAllocYtd(root.getCompB_item325());
			alliedNPMTSal.setCompSalName("Music Therapist");
			alliedNPMTSal.setCompSalType("Allied Non-professional");
			alliedNPMTSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPMTSal.setCompSalTotalCostYtd(root.getCompB_calc25());

			LtcYtdCompSal alliedNPATSal = new LtcYtdCompSal();
			alliedNPATSal.setCompSalStaffYtd(root.getCompB_item126());
			alliedNPATSal.setCompSalContractServicesYtd(root.getCompB_item226());
			alliedNPATSal.setCompSalOfficeAllocYtd(root.getCompB_item326());
			alliedNPATSal.setCompSalName("Art Therapist");
			alliedNPATSal.setCompSalType("Allied Non-professional");
			alliedNPATSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPATSal.setCompSalTotalCostYtd(root.getCompB_calc26());

			LtcYtdCompSal alliedNPOTHSal = new LtcYtdCompSal();
			alliedNPOTHSal.setCompSalStaffYtd(root.getCompB_item127());
			alliedNPOTHSal.setCompSalContractServicesYtd(root.getCompB_item227());
			alliedNPOTHSal.setCompSalOfficeAllocYtd(root.getCompB_item327());
			alliedNPOTHSal.setCompSalName("Other (specify)");
			alliedNPOTHSal.setCompSalType("Allied Non-professional");
			alliedNPOTHSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPOTHSal.setCompSalTotalCostYtd(root.getCompB_calc27());

			Collections.addAll(ltcYtdCompSal, supportFoodServices, supportLaundryServices, supportHousekeeping,
					supportPlantMntnce, adminAdministrator, adminDirOfCare, adminDeptManagers, adminSupport,
					adminPastoCareWrkr, adminClrks, adminClncCrdinator, adminOther, nursingRNSal, nursingLPNSal,
					nursingHCASal, nursingOthSal, alliedProfOTSal, alliedProfPTSal, alliedProfDTSal, alliedProfSWSal,
					alliedProfOTHSal, alliedNPRTSal, alliedNPRASal, alliedNPAWSal, alliedNPMTSal, alliedNPATSal,
					alliedNPOTHSal);
					

			LtcYtdCompSalSubtotals supportSalSubtotal = new LtcYtdCompSalSubtotals();
			supportSalSubtotal.setCompSalType("Support");
			supportSalSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			supportSalSubtotal.setSubTotalCompSalStaffYTD(root.getCompB_sum11());
			supportSalSubtotal.setSubTotalCompSalContractServicesYTD(root.getCompB_sum21());
			supportSalSubtotal.setSubTotalCompSalOfficeAllocYTD(root.getCompB_sum31());
			supportSalSubtotal.setSubTotalCompSalTotalCostYTD(root.getCompB_calcsum1());

			LtcYtdCompSalSubtotals administrationSalSubtotal = new LtcYtdCompSalSubtotals();
			administrationSalSubtotal.setCompSalType("Administration");
			administrationSalSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			administrationSalSubtotal.setSubTotalCompSalStaffYTD(root.getCompB_sum12());
			administrationSalSubtotal.setSubTotalCompSalContractServicesYTD(root.getCompB_sum22());
			administrationSalSubtotal.setSubTotalCompSalOfficeAllocYTD(root.getCompB_sum32());
			administrationSalSubtotal.setSubTotalCompSalTotalCostYTD(root.getCompB_calcsum2());

			LtcYtdCompSalSubtotals nursingSalSubtotal = new LtcYtdCompSalSubtotals();
			nursingSalSubtotal.setCompSalType("Nursing");
			nursingSalSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			nursingSalSubtotal.setSubTotalCompSalStaffYTD(root.getCompB_sum13());
			nursingSalSubtotal.setSubTotalCompSalContractServicesYTD(root.getCompB_sum23());
			nursingSalSubtotal.setSubTotalCompSalOfficeAllocYTD(root.getCompB_sum33());
			nursingSalSubtotal.setSubTotalCompSalTotalCostYTD(root.getCompB_calcsum3());

			LtcYtdCompSalSubtotals alliedSalSubtotal = new LtcYtdCompSalSubtotals();
			alliedSalSubtotal.setCompSalType("Allied Professional");
			alliedSalSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			alliedSalSubtotal.setSubTotalCompSalStaffYTD(root.getCompB_sum14());
			alliedSalSubtotal.setSubTotalCompSalContractServicesYTD(root.getCompB_sum24());
			alliedSalSubtotal.setSubTotalCompSalOfficeAllocYTD(root.getCompB_sum34());
			alliedSalSubtotal.setSubTotalCompSalTotalCostYTD(root.getCompB_calcsum4());

			LtcYtdCompSalSubtotals alliedNPSalSubtotal = new LtcYtdCompSalSubtotals();
			alliedNPSalSubtotal.setCompSalType("Allied Non-professional");
			alliedNPSalSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPSalSubtotal.setSubTotalCompSalStaffYTD(root.getCompB_sum15());
			alliedNPSalSubtotal.setSubTotalCompSalContractServicesYTD(root.getCompB_sum25());
			alliedNPSalSubtotal.setSubTotalCompSalOfficeAllocYTD(root.getCompB_sum35());
			alliedNPSalSubtotal.setSubTotalCompSalTotalCostYTD(root.getCompB_calcsum5());

			Collections.addAll(ltcYtdCompSalSubttls,administrationSalSubtotal,nursingSalSubtotal,supportSalSubtotal,alliedSalSubtotal,alliedNPSalSubtotal);

			LtcYtdCompSalTotals totalPerPayrollSal = new LtcYtdCompSalTotals();
			totalPerPayrollSal.setCompSalType("Total Per Payroll");
			totalPerPayrollSal.setConfirmationId(root.getForm().getConfirmationId());
			totalPerPayrollSal.setTotalCompSalStaffYTD(root.getCompB_total1());
			totalPerPayrollSal.setTotalCompSalContractServicesYTD(root.getCompB_total2());
			totalPerPayrollSal.setTotalCompSalOfficeAllocYTD(root.getCompB_total3());
			totalPerPayrollSal.setTotalCompSalTotalCostYTD(root.getCompB_total());

			LtcYtdCompSalTotals recoveredPerPayrollSal = new LtcYtdCompSalTotals();
			recoveredPerPayrollSal.setCompSalType("Recovered Salaries and Wages");
			recoveredPerPayrollSal.setConfirmationId(root.getForm().getConfirmationId());
			recoveredPerPayrollSal.setTotalCompSalStaffYTD(root.getCompB_recovered1());
			recoveredPerPayrollSal.setTotalCompSalContractServicesYTD(root.getCompB_recovered2());
			recoveredPerPayrollSal.setTotalCompSalOfficeAllocYTD(root.getCompB_recovered3());
			recoveredPerPayrollSal.setTotalCompSalTotalCostYTD(root.getCompB_recovered());

			LtcYtdCompSalTotals accruedPerPayrollSal = new LtcYtdCompSalTotals();
			accruedPerPayrollSal.setCompSalType("Accrued Salaries and Wages");
			accruedPerPayrollSal.setConfirmationId(root.getForm().getConfirmationId());
			accruedPerPayrollSal.setTotalCompSalStaffYTD(root.getCompB_accrued1());
			accruedPerPayrollSal.setTotalCompSalContractServicesYTD(root.getCompB_accrued2());
			accruedPerPayrollSal.setTotalCompSalOfficeAllocYTD(root.getCompB_accrued3());
			accruedPerPayrollSal.setTotalCompSalTotalCostYTD(root.getCompB_accrued());

			LtcYtdCompSalTotals otherPerPayrollSal = new LtcYtdCompSalTotals();
			otherPerPayrollSal.setCompSalType("Other labour costs - Specify");
			otherPerPayrollSal.setConfirmationId(root.getForm().getConfirmationId());
			otherPerPayrollSal.setTotalCompSalStaffYTD(root.getCompB_laborOther1());
			otherPerPayrollSal.setTotalCompSalContractServicesYTD(root.getCompB_laborOther2());
			otherPerPayrollSal.setTotalCompSalOfficeAllocYTD(root.getCompB_laborOther3());
			otherPerPayrollSal.setTotalCompSalTotalCostYTD(root.getCompB_laborOther());

			Collections.addAll(ltcYtdCompsalTtls,totalPerPayrollSal,recoveredPerPayrollSal,accruedPerPayrollSal,otherPerPayrollSal);

			/* Hours for Staff and Contracted Services */
			LtcYtdCompHrs supportFoodServicesHrs = new LtcYtdCompHrs();
			//supportFoodServicesHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP1());
			supportFoodServicesHrs.setCompHrsStaffYtd(root.getCompH_item11());
			supportFoodServicesHrs.setCompHrsContractServicesYtd(root.getCompH_item21());
			supportFoodServicesHrs.setCompHrsOfficeAllocYtd(root.getCompH_item31());
			supportFoodServicesHrs.setCompHrsName("Food Services");
			supportFoodServicesHrs.setCompHrsType("Support/Administration");
			supportFoodServicesHrs.setConfirmationId(root.getForm().getConfirmationId());
			supportFoodServicesHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc1());

			LtcYtdCompHrs supportLaundryServicesHrs = new LtcYtdCompHrs();
			//supportLaundryServicesHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP2());
			supportLaundryServicesHrs.setCompHrsStaffYtd(root.getCompH_item12());
			supportLaundryServicesHrs.setCompHrsContractServicesYtd(root.getCompH_item22());
			supportLaundryServicesHrs.setCompHrsOfficeAllocYtd(root.getCompH_item32());
			supportLaundryServicesHrs.setCompHrsName("Laundry Services");
			supportLaundryServicesHrs.setCompHrsType("Support/Administration");
			supportLaundryServicesHrs.setConfirmationId(root.getForm().getConfirmationId());
			supportLaundryServicesHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc2());

			LtcYtdCompHrs supportHousekeepingHrs = new LtcYtdCompHrs();
			//supportHousekeepingHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP3());
			supportHousekeepingHrs.setCompHrsStaffYtd(root.getCompH_item13());
			supportHousekeepingHrs.setCompHrsContractServicesYtd(root.getCompH_item23());
			supportHousekeepingHrs.setCompHrsOfficeAllocYtd(root.getCompH_item33());
			supportHousekeepingHrs.setCompHrsName("Housekeeping Services");
			supportHousekeepingHrs.setCompHrsType("Support/Administration");
			supportHousekeepingHrs.setConfirmationId(root.getForm().getConfirmationId());
			supportHousekeepingHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc3());

			LtcYtdCompHrs supportPlantMntnceHrs = new LtcYtdCompHrs();
		//	supportPlantMntnceHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP4());
			supportPlantMntnceHrs.setCompHrsStaffYtd(root.getCompH_item14());
			supportPlantMntnceHrs.setCompHrsContractServicesYtd(root.getCompH_item24());
			supportPlantMntnceHrs.setCompHrsOfficeAllocYtd(root.getCompH_item34());
			supportPlantMntnceHrs.setCompHrsName("Plant Maintenance & Op. Staffing");
			supportPlantMntnceHrs.setCompHrsType("Support/Administration");
			supportPlantMntnceHrs.setConfirmationId(root.getForm().getConfirmationId());
			supportPlantMntnceHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc4());

			// sum remaining
			LtcYtdCompHrs adminAdministratorHrs = new LtcYtdCompHrs();
		//	adminAdministratorHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP5());
			adminAdministratorHrs.setCompHrsStaffYtd(root.getCompH_item15());
			adminAdministratorHrs.setCompHrsContractServicesYtd(root.getCompH_item25());
			adminAdministratorHrs.setCompHrsOfficeAllocYtd(root.getCompH_item35());
			adminAdministratorHrs.setCompHrsName("Administrator");
			adminAdministratorHrs.setCompHrsType("Support/Administration");
			adminAdministratorHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminAdministratorHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc5());


			LtcYtdCompHrs adminDirOfCareHrs = new LtcYtdCompHrs();
			//adminDirOfCareHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP6());
			adminDirOfCareHrs.setCompHrsStaffYtd(root.getCompH_item16());
			adminDirOfCareHrs.setCompHrsContractServicesYtd(root.getCompH_item26());
			adminDirOfCareHrs.setCompHrsOfficeAllocYtd(root.getCompH_item36());
			adminDirOfCareHrs.setCompHrsName("Administrator");
			adminDirOfCareHrs.setCompHrsType("Support/Administration");
			adminDirOfCareHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminDirOfCareHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc6());

			LtcYtdCompHrs adminDeptManagersHrs = new LtcYtdCompHrs();
		//	adminDeptManagersHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP7());
			adminDeptManagersHrs.setCompHrsStaffYtd(root.getCompH_item17());
			adminDeptManagersHrs.setCompHrsContractServicesYtd(root.getCompH_item27());
			adminDeptManagersHrs.setCompHrsOfficeAllocYtd(root.getCompH_item37());
			adminDeptManagersHrs.setCompHrsName("Dept Managers");
			adminDeptManagersHrs.setCompHrsType("Support/Administration");
			adminDeptManagersHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminDeptManagersHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc7());

			LtcYtdCompHrs adminSupportHrs = new LtcYtdCompHrs();
			//adminSupportHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP8());
			adminSupportHrs.setCompHrsStaffYtd(root.getCompH_item18());
			adminSupportHrs.setCompHrsContractServicesYtd(root.getCompH_item28());
			adminSupportHrs.setCompHrsOfficeAllocYtd(root.getCompH_item38());
			adminSupportHrs.setCompHrsName("Administrative Support");
			adminSupportHrs.setCompHrsType("Support/Administration");
			adminSupportHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminSupportHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc8());

			LtcYtdCompHrs adminPastoCareWrkrHrs = new LtcYtdCompHrs();
		//	adminPastoCareWrkrHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP9());
			adminPastoCareWrkrHrs.setCompHrsStaffYtd(root.getCompH_item19());
			adminPastoCareWrkrHrs.setCompHrsContractServicesYtd(root.getCompH_item29());
			adminPastoCareWrkrHrs.setCompHrsOfficeAllocYtd(root.getCompH_item39());
			adminPastoCareWrkrHrs.setCompHrsName("Pastoral Care Worker");
			adminPastoCareWrkrHrs.setCompHrsType("Support/Administration");
			adminPastoCareWrkrHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminPastoCareWrkrHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc9());

			LtcYtdCompHrs adminClrksHrs = new LtcYtdCompHrs();
			//adminClrksHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP10());
			adminClrksHrs.setCompHrsStaffYtd(root.getCompH_item110());
			adminClrksHrs.setCompHrsContractServicesYtd(root.getCompH_item210());
			adminClrksHrs.setCompHrsOfficeAllocYtd(root.getCompH_item310());
			adminClrksHrs.setCompHrsName("Clerical Clerks");
			adminClrksHrs.setCompHrsType("Support/Administration");
			adminClrksHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminClrksHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc10());

			LtcYtdCompHrs adminClncCrdinatorHrs = new LtcYtdCompHrs();
		//	adminClncCrdinatorHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP11());
			adminClncCrdinatorHrs.setCompHrsStaffYtd(root.getCompH_item111());
			adminClncCrdinatorHrs.setCompHrsContractServicesYtd(root.getCompH_item211());
			adminClncCrdinatorHrs.setCompHrsOfficeAllocYtd(root.getCompH_item311());
			adminClncCrdinatorHrs.setCompHrsName("Clinical Coordiantor");
			adminClncCrdinatorHrs.setCompHrsType("Support/Administration");
			adminClncCrdinatorHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminClncCrdinatorHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc11());

			LtcYtdCompHrs adminOtherHrs = new LtcYtdCompHrs();
		//	adminOtherHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP12());
			adminOtherHrs.setCompHrsStaffYtd(root.getCompH_item112());
			adminOtherHrs.setCompHrsContractServicesYtd(root.getCompH_item212());
			adminOtherHrs.setCompHrsOfficeAllocYtd(root.getCompH_item312());
			adminOtherHrs.setCompHrsName("Other (specify)");
			adminOtherHrs.setCompHrsType("Support/Administration");
			adminOtherHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminOtherHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc12());

			/* Nursing, Allied, Non Allied Hours */
			LtcYtdCompHrs nursingRNHrs = new LtcYtdCompHrs();
			//nursingRNHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP13());
			nursingRNHrs.setCompHrsStaffYtd(root.getCompH_item113());
			nursingRNHrs.setCompHrsContractServicesYtd(root.getCompH_item213());
			nursingRNHrs.setCompHrsOfficeAllocYtd(root.getCompH_item313());
			nursingRNHrs.setCompHrsName("RN");
			nursingRNHrs.setCompHrsType("Nursing");
			nursingRNHrs.setConfirmationId(root.getForm().getConfirmationId());
			nursingRNHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc13());

			LtcYtdCompHrs nursingLPNHrs = new LtcYtdCompHrs();
			//nursingLPNHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP14());
			nursingLPNHrs.setCompHrsStaffYtd(root.getCompH_item114());
			nursingLPNHrs.setCompHrsContractServicesYtd(root.getCompH_item214());
			nursingLPNHrs.setCompHrsOfficeAllocYtd(root.getCompH_item314());
			nursingLPNHrs.setCompHrsName("LPN");
			nursingLPNHrs.setCompHrsType("Nursing");
			nursingLPNHrs.setConfirmationId(root.getForm().getConfirmationId());
			nursingLPNHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc14());

			LtcYtdCompHrs nursingHCAHrs = new LtcYtdCompHrs();
			//nursingHCAHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP15());
			nursingHCAHrs.setCompHrsStaffYtd(root.getCompH_item115());
			nursingHCAHrs.setCompHrsContractServicesYtd(root.getCompH_item215());
			nursingHCAHrs.setCompHrsOfficeAllocYtd(root.getCompH_item315());
			nursingHCAHrs.setCompHrsName("HCA");
			nursingHCAHrs.setCompHrsType("Nursing");
			nursingHCAHrs.setConfirmationId(root.getForm().getConfirmationId());
			nursingHCAHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc15());

			LtcYtdCompHrs nursingOthHrs = new LtcYtdCompHrs();
			//nursingOthHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP16());
			nursingOthHrs.setCompHrsStaffYtd(root.getCompH_item116());
			nursingOthHrs.setCompHrsContractServicesYtd(root.getCompH_item216());
			nursingOthHrs.setCompHrsOfficeAllocYtd(root.getCompH_item316());
			nursingOthHrs.setCompHrsName("Other (specify)");
			nursingOthHrs.setCompHrsType("Nursing");
			nursingOthHrs.setConfirmationId(root.getForm().getConfirmationId());
			nursingOthHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc16());

			LtcYtdCompHrs alliedProfOTHrs = new LtcYtdCompHrs();
			//alliedProfOTHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP17());
			alliedProfOTHrs.setCompHrsStaffYtd(root.getCompH_item117());
			alliedProfOTHrs.setCompHrsContractServicesYtd(root.getCompH_item217());
			alliedProfOTHrs.setCompHrsOfficeAllocYtd(root.getCompH_item317());
			alliedProfOTHrs.setCompHrsName("Occupational Therapist");
			alliedProfOTHrs.setCompHrsType("Allied Professional");
			alliedProfOTHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfOTHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc17());

			LtcYtdCompHrs alliedProfPTHrs = new LtcYtdCompHrs();
			//alliedProfPTHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP18());
			alliedProfPTHrs.setCompHrsStaffYtd(root.getCompH_item118());
			alliedProfPTHrs.setCompHrsContractServicesYtd(root.getCompH_item218());
			alliedProfPTHrs.setCompHrsOfficeAllocYtd(root.getCompH_item318());
			alliedProfPTHrs.setCompHrsName("Physiotherapist");
			alliedProfPTHrs.setCompHrsType("Allied Professional");
			alliedProfPTHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfPTHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc18());

			LtcYtdCompHrs alliedProfDTHrs = new LtcYtdCompHrs();
			//alliedProfDTHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP19());
			alliedProfDTHrs.setCompHrsStaffYtd(root.getCompH_item119());
			alliedProfDTHrs.setCompHrsContractServicesYtd(root.getCompH_item219());
			alliedProfDTHrs.setCompHrsOfficeAllocYtd(root.getCompH_item319());
			alliedProfDTHrs.setCompHrsName("Dietitian");
			alliedProfDTHrs.setCompHrsType("Allied Professional");
			alliedProfDTHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfDTHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc19());

			LtcYtdCompHrs alliedProfSWHrs = new LtcYtdCompHrs();
			//alliedProfSWHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP20());
			alliedProfSWHrs.setCompHrsStaffYtd(root.getCompH_item120());
			alliedProfSWHrs.setCompHrsContractServicesYtd(root.getCompH_item220());
			alliedProfSWHrs.setCompHrsOfficeAllocYtd(root.getCompH_item320());
			alliedProfSWHrs.setCompHrsName("Social Worker");
			alliedProfSWHrs.setCompHrsType("Allied Professional");
			alliedProfSWHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfSWHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc20());

			LtcYtdCompHrs alliedProfOTHHrs = new LtcYtdCompHrs();
			//alliedProfOTHHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP21());
			alliedProfOTHHrs.setCompHrsStaffYtd(root.getCompH_item121());
			alliedProfOTHHrs.setCompHrsContractServicesYtd(root.getCompH_item221());
			alliedProfOTHHrs.setCompHrsOfficeAllocYtd(root.getCompH_item321());
			alliedProfOTHHrs.setCompHrsName("Other (specify)");
			alliedProfOTHHrs.setCompHrsType("Allied Professional");
			alliedProfOTHHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfOTHHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc21());

			LtcYtdCompHrs alliedNPRTHrs = new LtcYtdCompHrs();
			//alliedNPRTHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP22());
			alliedNPRTHrs.setCompHrsStaffYtd(root.getCompH_item122());
			alliedNPRTHrs.setCompHrsContractServicesYtd(root.getCompH_item222());
			alliedNPRTHrs.setCompHrsOfficeAllocYtd(root.getCompH_item322());
			alliedNPRTHrs.setCompHrsName("Recreation Therapist");
			alliedNPRTHrs.setCompHrsType("Allied Non-professional");
			alliedNPRTHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRTHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc22());

			LtcYtdCompHrs alliedNPRAHrs = new LtcYtdCompHrs();
			//alliedNPRAHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP23());
			alliedNPRAHrs.setCompHrsStaffYtd(root.getCompH_item123());
			alliedNPRAHrs.setCompHrsContractServicesYtd(root.getCompH_item223());
			alliedNPRAHrs.setCompHrsOfficeAllocYtd(root.getCompH_item323());
			alliedNPRAHrs.setCompHrsName("Rehab Assistant");
			alliedNPRAHrs.setCompHrsType("Allied Non-professional");
			alliedNPRAHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRAHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc23());

			LtcYtdCompHrs alliedNPAWHrs = new LtcYtdCompHrs();
			//alliedNPAWHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP24());
			alliedNPAWHrs.setCompHrsStaffYtd(root.getCompH_item124());
			alliedNPAWHrs.setCompHrsContractServicesYtd(root.getCompH_item224());
			alliedNPAWHrs.setCompHrsOfficeAllocYtd(root.getCompH_item324());
			alliedNPAWHrs.setCompHrsName("Activity Worker");
			alliedNPAWHrs.setCompHrsType("Allied Non-professional");
			alliedNPAWHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPAWHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc24());

			LtcYtdCompHrs alliedNPMTHrs = new LtcYtdCompHrs();
			//alliedNPMTHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP25());
			alliedNPMTHrs.setCompHrsStaffYtd(root.getCompH_item125());
			alliedNPMTHrs.setCompHrsContractServicesYtd(root.getCompH_item225());
			alliedNPMTHrs.setCompHrsOfficeAllocYtd(root.getCompH_item325());
			alliedNPMTHrs.setCompHrsName("Music Therapist");
			alliedNPMTHrs.setCompHrsType("Allied Non-professional");
			alliedNPMTHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPMTHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc25());

			LtcYtdCompHrs alliedNPATHrs = new LtcYtdCompHrs();
			//alliedNPATHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP26());
			alliedNPATHrs.setCompHrsStaffYtd(root.getCompH_item126());
			alliedNPATHrs.setCompHrsContractServicesYtd(root.getCompH_item226());
			alliedNPATHrs.setCompHrsOfficeAllocYtd(root.getCompH_item326());
			alliedNPATHrs.setCompHrsName("Art Therapist");
			alliedNPATHrs.setCompHrsType("Allied Non-professional");
			alliedNPATHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPATHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc26());

			LtcYtdCompHrs alliedNPOTHHrs = new LtcYtdCompHrs();
			//alliedNPOTHHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP27());
			alliedNPOTHHrs.setCompHrsStaffYtd(root.getCompH_item127());
			alliedNPOTHHrs.setCompHrsContractServicesYtd(root.getCompH_item227());
			alliedNPOTHHrs.setCompHrsOfficeAllocYtd(root.getCompH_item327());
			alliedNPOTHHrs.setCompHrsName("Other (specify)");
			alliedNPOTHHrs.setCompHrsType("Allied Non-professional");
			alliedNPOTHHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPOTHHrs.setCompTotalWorkedHrsYtd(root.getCompH_calc27());

			Collections.addAll(ltcYtdCompHrs, supportFoodServicesHrs, supportLaundryServicesHrs, supportHousekeepingHrs,
					supportPlantMntnceHrs, adminAdministratorHrs, adminDirOfCareHrs, adminDeptManagersHrs,
					adminSupportHrs, adminPastoCareWrkrHrs, adminClrksHrs, adminClncCrdinatorHrs, adminOtherHrs,
					nursingRNHrs, nursingLPNHrs, nursingHCAHrs, nursingOthHrs, alliedProfOTHrs, alliedProfPTHrs,
					alliedProfDTHrs, alliedProfSWHrs, alliedProfOTHHrs, alliedNPRTHrs, alliedNPRAHrs, alliedNPAWHrs,
					alliedNPMTHrs, alliedNPATHrs, alliedNPOTHHrs);

			/* Subtotals */
			LtcYtdCompHrsSubtotals supportHrsSubtotals = new LtcYtdCompHrsSubtotals();
			supportHrsSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			supportHrsSubtotals.setCompHrsType("Support");
			supportHrsSubtotals.setSubTotalCompHrsStaffYTD(root.getCompH_sum11());
			supportHrsSubtotals.setSubTotalCompHrsContractServicesYTD(root.getCompH_sum21());
			supportHrsSubtotals.setSubTotalCompHrsOfficeAllocYTD(root.getCompH_sum31());
			supportHrsSubtotals.setSubTotalCompTotalWorkedHrsYTD(root.getCompH_calcsum1());
			
			LtcYtdCompHrsSubtotals adminHrsSubtotals = new LtcYtdCompHrsSubtotals();
			adminHrsSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			adminHrsSubtotals.setCompHrsType("Administration");
			adminHrsSubtotals.setSubTotalCompHrsStaffYTD(root.getCompH_sum12());
			adminHrsSubtotals.setSubTotalCompHrsContractServicesYTD(root.getCompH_sum22());
			adminHrsSubtotals.setSubTotalCompHrsOfficeAllocYTD(root.getCompH_sum32());
			adminHrsSubtotals.setSubTotalCompTotalWorkedHrsYTD(root.getCompH_calcsum2());

			LtcYtdCompHrsSubtotals nursingHrsSubtotals = new LtcYtdCompHrsSubtotals();
			nursingHrsSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			nursingHrsSubtotals.setCompHrsType("Nursing");
			nursingHrsSubtotals.setSubTotalCompHrsStaffYTD(root.getCompH_sum13());
			nursingHrsSubtotals.setSubTotalCompHrsContractServicesYTD(root.getCompH_sum23());
			nursingHrsSubtotals.setSubTotalCompHrsOfficeAllocYTD(root.getCompH_sum33());
			nursingHrsSubtotals.setSubTotalCompTotalWorkedHrsYTD(root.getCompH_calcsum3());

			LtcYtdCompHrsSubtotals alliedHrsSubtotals = new LtcYtdCompHrsSubtotals();
			alliedHrsSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			alliedHrsSubtotals.setCompHrsType("Allied Professional");
			alliedHrsSubtotals.setSubTotalCompHrsStaffYTD(root.getCompH_sum14());
			alliedHrsSubtotals.setSubTotalCompHrsContractServicesYTD(root.getCompH_sum24());
			alliedHrsSubtotals.setSubTotalCompHrsOfficeAllocYTD(root.getCompH_sum34());
			alliedHrsSubtotals.setSubTotalCompTotalWorkedHrsYTD(root.getCompH_calcsum4());

			LtcYtdCompHrsSubtotals alliedNPHrsSubtotals = new LtcYtdCompHrsSubtotals();
			alliedNPHrsSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			alliedNPHrsSubtotals.setCompHrsType("Allied Non-professional");
			alliedNPHrsSubtotals.setSubTotalCompHrsStaffYTD(root.getCompH_sum15());
			alliedNPHrsSubtotals.setSubTotalCompHrsContractServicesYTD(root.getCompH_sum25());
			alliedNPHrsSubtotals.setSubTotalCompHrsOfficeAllocYTD(root.getCompH_sum35());
			alliedNPHrsSubtotals.setSubTotalCompTotalWorkedHrsYTD(root.getCompH_calcsum5());

			Collections.addAll(ltcYtdCompHrsSubttls, supportHrsSubtotals,adminHrsSubtotals,nursingHrsSubtotals,alliedHrsSubtotals,alliedNPHrsSubtotals);

			/* Totals */
			LtcYtdCompHrsTotals totalPerPayrollHrsTotals = new LtcYtdCompHrsTotals();
			totalPerPayrollHrsTotals.setCompHrsTotalType("Total Per Payroll");
			totalPerPayrollHrsTotals.setTotalCompHrsStaffYTD(root.getCompH_total1());
			totalPerPayrollHrsTotals.setTotalCompHrsContractServicesYTD(root.getCompH_total2());
			totalPerPayrollHrsTotals.setTotalCompHrsOfficeAllocYTD(root.getCompH_total3());
			totalPerPayrollHrsTotals.setTotalCompTotalWorkedHrsYTD(root.getCompH_total());
			totalPerPayrollHrsTotals.setConfirmationID(root.getForm().getConfirmationId());

			LtcYtdCompHrsTotals accuredHrsTotals = new LtcYtdCompHrsTotals();
			accuredHrsTotals.setCompHrsTotalType("Accured Hours");
			accuredHrsTotals.setTotalCompHrsStaffYTD(root.getCompH_accrued2());
			accuredHrsTotals.setTotalCompHrsContractServicesYTD(root.getCompH_accrued3());
			accuredHrsTotals.setTotalCompHrsOfficeAllocYTD(root.getCompH_accrued3());
			accuredHrsTotals.setTotalCompTotalWorkedHrsYTD(root.getCompH_accrued());
			accuredHrsTotals.setConfirmationID(root.getForm().getConfirmationId());

			Collections.addAll(ltcYtdCompHrsTtls,totalPerPayrollHrsTotals,accuredHrsTotals);

			/* Add Pos Hrs */
			LtcYtdCompAddPos nursingRNAddPos = new LtcYtdCompAddPos();
			nursingRNAddPos.setConfirmationId(root.getForm().getConfirmationId());
			nursingRNAddPos.setAddPosType(root.getNursing_label_CSP());
			nursingRNAddPos.setAddPosName(root.getNursing_label_CSP1());
			nursingRNAddPos.setAddPosLegalNameContractServiceYtd(root.getNursingProvider1());
			nursingRNAddPos.setAddPosPercentServiceContractOutYtd(root.getNursingPercentage1());
			nursingRNAddPos.determineAddPosContractedOutYtd();
			
			LtcYtdCompAddPos nursingLPNAddPos = new LtcYtdCompAddPos();
			nursingLPNAddPos.setConfirmationId(root.getForm().getConfirmationId());
			nursingLPNAddPos.setAddPosType(root.getNursing_label_CSP());
			nursingLPNAddPos.setAddPosName(root.getNursing_label_CSP2());
			nursingLPNAddPos.setAddPosLegalNameContractServiceYtd(root.getNursingProvider2());
			nursingLPNAddPos.setAddPosPercentServiceContractOutYtd(root.getNursingPercentage2());
			nursingLPNAddPos.determineAddPosContractedOutYtd();

			LtcYtdCompAddPos nursingHCAAddPos = new LtcYtdCompAddPos();
			nursingHCAAddPos.setConfirmationId(root.getForm().getConfirmationId());
			nursingHCAAddPos.setAddPosType(root.getNursing_label_CSP());
			nursingHCAAddPos.setAddPosName(root.getNursing_label_CSP3());
			nursingHCAAddPos.setAddPosLegalNameContractServiceYtd(root.getNursingProvider3());
			nursingHCAAddPos.setAddPosPercentServiceContractOutYtd(root.getNursingPercentage3());
			nursingHCAAddPos.determineAddPosContractedOutYtd();

			LtcYtdCompAddPos nursingOTHAddPos = new LtcYtdCompAddPos();
			nursingOTHAddPos.setConfirmationId(root.getForm().getConfirmationId());
			nursingOTHAddPos.setAddPosType(root.getNursing_label_CSP());
			nursingOTHAddPos.setAddPosName(Constants.POS_TYPE_OTHER);
			nursingOTHAddPos.setAddPosLegalNameContractServiceYtd(root.getNursingProvider4());
			nursingOTHAddPos.setAddPosPercentServiceContractOutYtd(root.getNursingPercentage4());
			nursingOTHAddPos.setAddPosAnotherName(root.getNursing_label_CSP4());
			nursingOTHAddPos.determineAddPosContractedOutYtd();

			LtcYtdCompAddPos alliedProfOTAddPos = new LtcYtdCompAddPos();
			alliedProfOTAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfOTAddPos.setAddPosType(root.getAlliedProf_label_CSP());
			alliedProfOTAddPos.setAddPosName(root.getAlliedProf_label_CSP1());
			alliedProfOTAddPos.setAddPosLegalNameContractServiceYtd(root.getAlliedProfProvider1());
			alliedProfOTAddPos.setAddPosPercentServiceContractOutYtd(root.getAlliedProfPercentage1());
			alliedProfOTAddPos.determineAddPosContractedOutYtd();

			LtcYtdCompAddPos alliedProfPTAddPos = new LtcYtdCompAddPos();
			alliedProfPTAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfPTAddPos.setAddPosType(root.getAlliedProf_label_CSP());
			alliedProfPTAddPos.setAddPosName(root.getAlliedProf_label_CSP2());
			alliedProfPTAddPos.setAddPosLegalNameContractServiceYtd(root.getAlliedProfProvider2());
			alliedProfPTAddPos.setAddPosPercentServiceContractOutYtd(root.getAlliedProfPercentage2());
			alliedProfPTAddPos.determineAddPosContractedOutYtd();

			LtcYtdCompAddPos alliedProfDTAddPos = new LtcYtdCompAddPos();
			alliedProfDTAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfDTAddPos.setAddPosType(root.getAlliedProf_label_CSP());
			alliedProfDTAddPos.setAddPosName(root.getAlliedProf_label_CSP3());
			alliedProfDTAddPos.setAddPosLegalNameContractServiceYtd(root.getAlliedProfProvider3());
			alliedProfDTAddPos.setAddPosPercentServiceContractOutYtd(root.getAlliedProfPercentage3());
			alliedProfDTAddPos.determineAddPosContractedOutYtd();

			LtcYtdCompAddPos alliedProfSWAddPos = new LtcYtdCompAddPos();
			alliedProfSWAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfSWAddPos.setAddPosType(root.getAlliedProf_label_CSP());
			alliedProfSWAddPos.setAddPosName(root.getAlliedProf_label_CSP4());
			alliedProfSWAddPos.setAddPosLegalNameContractServiceYtd(root.getAlliedProfProvider4());
			alliedProfSWAddPos.setAddPosPercentServiceContractOutYtd(root.getAlliedProfPercentage4());
			alliedProfSWAddPos.determineAddPosContractedOutYtd();

			LtcYtdCompAddPos alliedProfSLPAddPos = new LtcYtdCompAddPos();
			alliedProfSLPAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfSLPAddPos.setAddPosType(root.getAlliedProf_label_CSP());
			alliedProfSLPAddPos.setAddPosName(root.getAlliedProf_label_CSP5());
			alliedProfSLPAddPos.setAddPosLegalNameContractServiceYtd(root.getAlliedProfProvider4());
			alliedProfSLPAddPos.setAddPosPercentServiceContractOutYtd(root.getAlliedProfPercentage4());
			alliedProfSLPAddPos.determineAddPosContractedOutYtd();

			LtcYtdCompAddPos alliedProfRTAddPos = new LtcYtdCompAddPos();
			alliedProfRTAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfRTAddPos.setAddPosType(root.getAlliedProf_label_CSP());
			alliedProfRTAddPos.setAddPosName(root.getAlliedProf_label_CSP6());
			alliedProfRTAddPos.setAddPosLegalNameContractServiceYtd(root.getAlliedProfProvider4());
			alliedProfRTAddPos.setAddPosPercentServiceContractOutYtd(root.getAlliedProfPercentage4());
			alliedProfRTAddPos.determineAddPosContractedOutYtd();

			LtcYtdCompAddPos alliedProfOTHAddPos = new LtcYtdCompAddPos();
			alliedProfOTHAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfOTHAddPos.setAddPosType(root.getAlliedProf_label_CSP());
			alliedProfOTHAddPos.setAddPosName(Constants.POS_TYPE_OTHER);
			alliedProfOTHAddPos.setAddPosLegalNameContractServiceYtd(root.getAlliedProfProvider5());
			alliedProfOTHAddPos.setAddPosPercentServiceContractOutYtd(root.getAlliedProfPercentage5());
			alliedProfOTHAddPos.setAddPosAnotherName(root.getAlliedProf_label_CSP7());
			alliedProfOTHAddPos.determineAddPosContractedOutYtd();

			LtcYtdCompAddPos alliedNPRTAddPos = new LtcYtdCompAddPos();
			alliedNPRTAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRTAddPos.setAddPosType(root.getAlliedNP_label_CSP());
			alliedNPRTAddPos.setAddPosName(root.getAlliedNP_label_CSP1());
			alliedNPRTAddPos.setAddPosLegalNameContractServiceYtd(root.getAlliedNPProvider1());
			alliedNPRTAddPos.setAddPosPercentServiceContractOutYtd(root.getAlliedNPPercentage1());
			alliedNPRTAddPos.determineAddPosContractedOutYtd();

			LtcYtdCompAddPos alliedNPRAAddPos = new LtcYtdCompAddPos();
			alliedNPRAAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRAAddPos.setAddPosType(root.getAlliedNP_label_CSP());
			alliedNPRAAddPos.setAddPosName(root.getAlliedNP_label_CSP2());
			alliedNPRAAddPos.setAddPosLegalNameContractServiceYtd(root.getAlliedNPProvider2());
			alliedNPRAAddPos.setAddPosPercentServiceContractOutYtd(root.getAlliedNPPercentage2());
			alliedNPRAAddPos.determineAddPosContractedOutYtd();

			LtcYtdCompAddPos alliedNPAWAddPos = new LtcYtdCompAddPos();
			alliedNPAWAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPAWAddPos.setAddPosType(root.getAlliedNP_label_CSP());
			alliedNPAWAddPos.setAddPosName(root.getAlliedNP_label_CSP3());
			alliedNPAWAddPos.setAddPosLegalNameContractServiceYtd(root.getAlliedNPProvider3());
			alliedNPAWAddPos.setAddPosPercentServiceContractOutYtd(root.getAlliedNPPercentage3());
			alliedNPAWAddPos.determineAddPosContractedOutYtd();

			LtcYtdCompAddPos alliedNPMTAddPos = new LtcYtdCompAddPos();
			alliedNPMTAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPMTAddPos.setAddPosType(root.getAlliedNP_label_CSP());
			alliedNPMTAddPos.setAddPosName(root.getAlliedNP_label_CSP4());
			alliedNPMTAddPos.setAddPosLegalNameContractServiceYtd(root.getAlliedNPProvider4());
			alliedNPMTAddPos.setAddPosPercentServiceContractOutYtd(root.getAlliedNPPercentage4());
			alliedNPMTAddPos.determineAddPosContractedOutYtd();

			LtcYtdCompAddPos alliedNPATAddPos = new LtcYtdCompAddPos();
			alliedNPATAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPATAddPos.setAddPosType(root.getAlliedNP_label_CSP());
			alliedNPATAddPos.setAddPosName(root.getAlliedNP_label_CSP5());
			alliedNPATAddPos.setAddPosLegalNameContractServiceYtd(root.getAlliedNPProvider5());
			alliedNPATAddPos.setAddPosPercentServiceContractOutYtd(root.getAlliedNPPercentage5());
			alliedNPATAddPos.determineAddPosContractedOutYtd();

			LtcYtdCompAddPos alliedNPOTHAddPos = new LtcYtdCompAddPos();
			alliedNPOTHAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPOTHAddPos.setAddPosType(root.getAlliedNP_label_CSP());
			alliedNPOTHAddPos.setAddPosName(Constants.POS_TYPE_OTHER);
			alliedNPOTHAddPos.setAddPosLegalNameContractServiceYtd(root.getAlliedNPProvider6());
			alliedNPOTHAddPos.setAddPosPercentServiceContractOutYtd(root.getAlliedNPPercentage6());
			alliedNPOTHAddPos.setAddPosAnotherName(root.getAlliedNP_label_CSP6());
			alliedNPOTHAddPos.determineAddPosContractedOutYtd();

			Collections.addAll(ltcYtdCompAddPos, nursingRNAddPos, nursingLPNAddPos, nursingHCAAddPos, nursingOTHAddPos,
					alliedProfOTAddPos, alliedProfPTAddPos, alliedProfDTAddPos, alliedProfSWAddPos, alliedProfRTAddPos, 
					alliedProfSLPAddPos, alliedProfOTHAddPos, alliedNPRTAddPos, alliedNPRAAddPos, alliedNPAWAddPos,
					alliedNPMTAddPos, alliedNPATAddPos, alliedNPOTHAddPos);
					
			/* Benefits Where is %Allocation stored */
			LtcYtdCompBenefits empInsBenefit = new LtcYtdCompBenefits();
			empInsBenefit.setBenefitsAmountYtd(root.getBenefit_value1());
			empInsBenefit.setBenefitsType("Employment Insurance");
			empInsBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdCompBenefits canPenPlnBenefit = new LtcYtdCompBenefits();
			canPenPlnBenefit.setBenefitsAmountYtd(root.getBenefit_value2());
			canPenPlnBenefit.setBenefitsType("Canada Pension Plan");
			canPenPlnBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdCompBenefits wrkrCompBoardBenefit = new LtcYtdCompBenefits();
			wrkrCompBoardBenefit.setBenefitsAmountYtd(root.getBenefit_value3());
			wrkrCompBoardBenefit.setBenefitsType("Workers Compensation Board");
			wrkrCompBoardBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdCompBenefits empHlthTaxBenefit = new LtcYtdCompBenefits();
			empHlthTaxBenefit.setBenefitsAmountYtd(root.getBenefit_value4());
			empHlthTaxBenefit.setBenefitsType("Employer Health Tax");
			empHlthTaxBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdCompBenefits penPlanBenefit = new LtcYtdCompBenefits();
			penPlanBenefit.setBenefitsAmountYtd(root.getBenefit_value5());
			penPlanBenefit.setBenefitsType("Pension Plan");
			penPlanBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdCompBenefits exHlthDntlBenefit = new LtcYtdCompBenefits();
			exHlthDntlBenefit.setBenefitsAmountYtd(root.getBenefit_value6());
			exHlthDntlBenefit.setBenefitsType("Extended Health & Dental");
			exHlthDntlBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdCompBenefits grpLifeBenefit = new LtcYtdCompBenefits();
			grpLifeBenefit.setBenefitsAmountYtd(root.getBenefit_value7());
			grpLifeBenefit.setBenefitsType("Group Life,  AD&D, LTD");
			grpLifeBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdCompBenefits otherBenefit = new LtcYtdCompBenefits();
			otherBenefit.setBenefitsAmountYtd(root.getBenefit_value8());
			otherBenefit.setBenefitsType("Other Benefits specify");
			otherBenefit.setConfirmationId(root.getForm().getConfirmationId());

			Collections.addAll(ltcYtdCompBenefits, empInsBenefit, canPenPlnBenefit, wrkrCompBoardBenefit,
					empHlthTaxBenefit, penPlanBenefit, exHlthDntlBenefit, grpLifeBenefit, otherBenefit);
			/* Are we setting the subtotal and total things? */

			/* Summary of Rev & Exp Budget */
			LtcYtdRev revFrmHA1Adj = new LtcYtdRev();
			revFrmHA1Adj.setRevYTD(root.getOpRev_YTD1());
			revFrmHA1Adj.setRevNotes(root.getOpRev_note1());
			revFrmHA1Adj.setRevName("HA Operating Funding");	
			revFrmHA1Adj.setRevType("Revenue from HA (1)");
			revFrmHA1Adj.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev revFrmHA1DirCare = new LtcYtdRev();
			revFrmHA1DirCare.setRevYTD(root.getOpRev_YTD2());
			revFrmHA1DirCare.setRevNotes(root.getOpRev_note2());
			revFrmHA1DirCare.setRevName("Direct care hours");
			revFrmHA1DirCare.setRevType("Revenue from HA (1)");
			revFrmHA1DirCare.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev revFrmHA1Others = new LtcYtdRev();
			revFrmHA1Others.setRevYTD(root.getOpRev_YTD3());
			revFrmHA1Others.setRevNotes(root.getOpRev_note3());
			revFrmHA1Others.setRevName("Others");
			revFrmHA1Others.setRevType("Revenue from HA (1)");
			revFrmHA1Others.setConfirmationId(root.getForm().getConfirmationId());

			// skipping subtotal for now

			LtcYtdRev revFrmHA2OpFundMinEq = new LtcYtdRev();
			revFrmHA2OpFundMinEq.setRevYTD(root.getOpRev_YTD4());
			revFrmHA2OpFundMinEq.setRevNotes(root.getOpRev_note4());
			revFrmHA2OpFundMinEq.setRevName("HA Operating Funding - Minor Equipment");
			revFrmHA2OpFundMinEq.setRevType("Revenue from HA (2)");
			revFrmHA2OpFundMinEq.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev revFrmHA2OpFundOth = new LtcYtdRev();
			revFrmHA2OpFundOth.setRevYTD(root.getOpRev_YTD5());
			revFrmHA2OpFundOth.setRevNotes(root.getOpRev_note5());
			revFrmHA2OpFundOth.setRevName("HA Operating Funding - Other");
			revFrmHA2OpFundOth.setRevType("Revenue from HA (2)");
			revFrmHA2OpFundOth.setConfirmationId(root.getForm().getConfirmationId());

			// skipping subtotal

			LtcYtdRev revFrmHA3 = new LtcYtdRev();
			revFrmHA3.setRevYTD(root.getOpRev_YTD6());
			revFrmHA3.setRevNotes(root.getOpRev_note6());
			revFrmHA3.setRevName("HA Capital Contribution Funding");
			revFrmHA3.setRevType("Revenue from HA (3)");
			revFrmHA3.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev revFrmHA4OccThld = new LtcYtdRev();
			revFrmHA4OccThld.setRevYTD(root.getOpRev_YTD7());
			revFrmHA4OccThld.setRevNotes(root.getOpRev_note7());
			revFrmHA4OccThld.setRevName("Occupancy threshold");
			revFrmHA4OccThld.setRevType("Revenue from HA (4)");
			revFrmHA4OccThld.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev revFrmHA4CliConReconc = new LtcYtdRev();
			revFrmHA4CliConReconc.setRevYTD(root.getOpRev_YTD8());
			revFrmHA4CliConReconc.setRevNotes(root.getOpRev_note8());
			revFrmHA4CliConReconc.setRevName("Client Contribution Reconciliation");
			revFrmHA4CliConReconc.setRevType("Revenue from HA (4)");
			revFrmHA4CliConReconc.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev revFrmHA4DirCare = new LtcYtdRev();
			revFrmHA4DirCare.setRevYTD(root.getOpRev_YTD9());
			revFrmHA4DirCare.setRevNotes(root.getOpRev_note9());
			revFrmHA4DirCare.setRevName("Direct Care Hours");
			revFrmHA4DirCare.setRevType("Revenue from HA (4)");
			revFrmHA4DirCare.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev revFrmHA4Oth = new LtcYtdRev();
			revFrmHA4Oth.setRevYTD(root.getOpRev_YTD10());
			revFrmHA4Oth.setRevNotes(root.getOpRev_note10());
			revFrmHA4Oth.setRevName("Other");
			revFrmHA4Oth.setRevType("Revenue from HA (4)");
			revFrmHA4Oth.setConfirmationId(root.getForm().getConfirmationId());

			/* Non operating revenu */
			LtcYtdRev nonOperatingRevOth = new LtcYtdRev();
			nonOperatingRevOth.setRevYTD(root.getNopRev_YTD1());
			nonOperatingRevOth.setRevNotes(root.getNopRev_note1());
			nonOperatingRevOth.setRevName("Other");
			nonOperatingRevOth.setRevType("Non-operating Revenue");
			nonOperatingRevOth.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev nonOperatingRevOthThirdParty = new LtcYtdRev();
			nonOperatingRevOthThirdParty.setRevYTD(root.getNopRev_YTD2());
			nonOperatingRevOthThirdParty.setRevNotes(root.getNopRev_note2());
			nonOperatingRevOthThirdParty.setRevName("Other - 3rd party funding ");
			nonOperatingRevOthThirdParty.setRevType("Non-operating Revenue");
			nonOperatingRevOthThirdParty.setConfirmationId(root.getForm().getConfirmationId());
			/* END */

			// skipping subtotal for now

			LtcYtdRev clntRvnHAClient = new LtcYtdRev();
			clntRvnHAClient.setRevYTD(root.getOpRev_YTD11());
			clntRvnHAClient.setRevNotes(root.getOpRev_note11());
			clntRvnHAClient.setRevName("HA Client User Fees Paid by the Client");
			clntRvnHAClient.setRevType("Client Revenue");
			clntRvnHAClient.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev clntRvnFeePaidParties = new LtcYtdRev();
			clntRvnFeePaidParties.setRevYTD(root.getOpRev_YTD12());
			clntRvnFeePaidParties.setRevNotes(root.getOpRev_note12());
			clntRvnFeePaidParties.setRevName("Client user fee paid by their parties");
			clntRvnFeePaidParties.setRevType("Client Revenue");
			clntRvnFeePaidParties.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev clntRvnFeePaidNonEligible = new LtcYtdRev();
			clntRvnFeePaidNonEligible.setRevYTD(root.getOpRev_YTD13());
			clntRvnFeePaidNonEligible.setRevNotes(root.getOpRev_note13());
			clntRvnFeePaidNonEligible.setRevName("Client user fee paid ~ for non-eligible residents");
			clntRvnFeePaidNonEligible.setRevType("Client Revenue");
			clntRvnFeePaidNonEligible.setConfirmationId(root.getForm().getConfirmationId());

			// skipping subtotal for now
			LtcYtdRev othRevInvstOpFund = new LtcYtdRev();
			othRevInvstOpFund.setRevYTD(root.getOpRev_YTD14());
			othRevInvstOpFund.setRevNotes(root.getOpRev_note14());
			othRevInvstOpFund.setRevName("Investments Revenue on operating funds");
			othRevInvstOpFund.setRevType("Other Revenue");
			othRevInvstOpFund.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev othRevInvstCmBcFund = new LtcYtdRev();
			othRevInvstCmBcFund.setRevYTD(root.getOpRev_YTD15());
			othRevInvstCmBcFund.setRevNotes(root.getOpRev_note15());
			othRevInvstCmBcFund.setRevName("CMHC/BCHMC funding");
			othRevInvstCmBcFund.setRevType("Other Revenue");
			othRevInvstCmBcFund.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev othRevFoodServ = new LtcYtdRev();
			othRevFoodServ.setRevYTD(root.getOpRev_YTD16());
			othRevFoodServ.setRevNotes(root.getOpRev_note16());
			othRevFoodServ.setRevName("food services");
			othRevFoodServ.setRevType("Other Revenue");
			othRevFoodServ.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev othRevLdryServ = new LtcYtdRev();
			othRevLdryServ.setRevYTD(root.getOpRev_YTD17());
			othRevLdryServ.setRevNotes(root.getOpRev_note17());
			othRevLdryServ.setRevName("laundry services");
			othRevLdryServ.setRevType("Other Revenue");
			othRevLdryServ.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev othRevCabl = new LtcYtdRev();
			othRevCabl.setRevYTD(root.getOpRev_YTD18());
			othRevCabl.setRevNotes(root.getOpRev_note18());
			othRevCabl.setRevName("cablevision");
			othRevCabl.setRevType("Other Revenue");
			othRevCabl.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev othRevOthRec = new LtcYtdRev();
			othRevOthRec.setRevYTD(root.getOpRev_YTD19());
			othRevOthRec.setRevNotes(root.getOpRev_note19());
			othRevOthRec.setRevName("other recoveries");
			othRevOthRec.setRevType("Other Revenue");
			othRevOthRec.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev othRevOthSpcfy = new LtcYtdRev();
			othRevOthSpcfy.setRevYTD(root.getOpRev_YTD20());
			othRevOthSpcfy.setRevNotes(root.getOpRev_note20());
			othRevOthSpcfy.setRevName("Others ~ specify");
			othRevOthSpcfy.setRevType("Other Revenue");
			othRevOthSpcfy.setConfirmationId(root.getForm().getConfirmationId());
			Collections.addAll(ltcYtdRev, revFrmHA1Adj, revFrmHA1DirCare, revFrmHA1Others, revFrmHA2OpFundMinEq,
					revFrmHA2OpFundOth, revFrmHA3, revFrmHA4OccThld, revFrmHA4CliConReconc, revFrmHA4DirCare,
					revFrmHA4Oth, clntRvnHAClient, clntRvnFeePaidParties, clntRvnFeePaidNonEligible, othRevInvstOpFund,
					othRevInvstCmBcFund, othRevFoodServ, othRevLdryServ, othRevCabl, othRevOthRec, othRevOthSpcfy, 
					nonOperatingRevOth, nonOperatingRevOthThirdParty);

			/* Subtotals */
			LtcYtdRevSubTotals revFromHA1Subttl = new LtcYtdRevSubTotals();
			revFromHA1Subttl.setConfirmationId(root.getForm().getConfirmationId());
			revFromHA1Subttl.setRevType("Revenue from HA(1)");
			revFromHA1Subttl.setSubTotalRevYtd(root.getOpRev_sum11());

			LtcYtdRevSubTotals revFromHA2Subttl = new LtcYtdRevSubTotals();
			revFromHA2Subttl.setConfirmationId(root.getForm().getConfirmationId());
			revFromHA2Subttl.setRevType("Revenue from HA(2)");
			revFromHA2Subttl.setSubTotalRevYtd(root.getOpRev_sum12());

			LtcYtdRevSubTotals revFromHA4Subttl = new LtcYtdRevSubTotals();
			revFromHA4Subttl.setConfirmationId(root.getForm().getConfirmationId());
			revFromHA4Subttl.setRevType("Revenue from HA(4)");
			revFromHA4Subttl.setSubTotalRevYtd(root.getOpRev_sum13());

			LtcYtdRevSubTotals clntRevSubttl = new LtcYtdRevSubTotals();
			clntRevSubttl.setConfirmationId(root.getForm().getConfirmationId());
			clntRevSubttl.setRevType("Client Revenue");
			clntRevSubttl.setSubTotalRevYtd(root.getOpRev_sum14());

			LtcYtdRevSubTotals othRevSubttl = new LtcYtdRevSubTotals();
			othRevSubttl.setConfirmationId(root.getForm().getConfirmationId());
			othRevSubttl.setRevType("Other Revenue");
			othRevSubttl.setSubTotalRevYtd(root.getOpRev_sum15());

			LtcYtdRevSubTotals opRevSubttl = new LtcYtdRevSubTotals();
			opRevSubttl.setConfirmationId(root.getForm().getConfirmationId());
			opRevSubttl.setRevType("Operating Revenue");
			opRevSubttl.setSubTotalRevYtd(root.getOpRev_YTD_total());

			LtcYtdRevSubTotals nonOpRevSubttl = new LtcYtdRevSubTotals();
			nonOpRevSubttl.setConfirmationId(root.getForm().getConfirmationId());
			nonOpRevSubttl.setRevType("Non-operating revenue");
			nonOpRevSubttl.setSubTotalRevYtd(root.getNopRev_sum11());

			Collections.addAll(ltcYtdRevSubTtls, revFromHA1Subttl,revFromHA2Subttl,revFromHA4Subttl,clntRevSubttl,othRevSubttl,opRevSubttl, nonOpRevSubttl);

			LtcYtdExp dirCareCostExp = new LtcYtdExp();
			dirCareCostExp.setExpYtd(root.getOpEx_YTD1());
			dirCareCostExp.setExpNotes(root.getOpEx_note1());
			dirCareCostExp.setExpName("Direct Care");
			dirCareCostExp.setExpType("Staffing Cost (1A)");
			dirCareCostExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp foodCostExp = new LtcYtdExp();
			foodCostExp.setExpYtd(root.getOpEx_YTD2());
			foodCostExp.setExpNotes(root.getOpEx_note2());
			foodCostExp.setExpName("Food Services");
			foodCostExp.setExpType("Staffing Cost (1A)");
			foodCostExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp ldryServExp = new LtcYtdExp();
			ldryServExp.setExpYtd(root.getOpEx_YTD3());
			ldryServExp.setExpNotes(root.getOpEx_note3());
			ldryServExp.setExpName("Laundry Services");
			ldryServExp.setExpType("Staffing Cost (1A)");
			ldryServExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp housekeepingCostExp = new LtcYtdExp();
			housekeepingCostExp.setExpYtd(root.getOpEx_YTD4());
			housekeepingCostExp.setExpNotes(root.getOpEx_note4());
			housekeepingCostExp.setExpName("Housekeeping Services");
			housekeepingCostExp.setExpType("Staffing Cost (1A)");
			housekeepingCostExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp adminServCostExp = new LtcYtdExp();
			adminServCostExp.setExpYtd(root.getOpEx_YTD5());
			adminServCostExp.setExpNotes(root.getOpEx_note5());
			adminServCostExp.setExpName("Administration Services");
			adminServCostExp.setExpType("Staffing Cost (1A)");
			adminServCostExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp plantMainOpStaffExp = new LtcYtdExp();
			plantMainOpStaffExp.setExpYtd(root.getOpEx_YTD6());
			plantMainOpStaffExp.setExpNotes(root.getOpEx_note6());
			plantMainOpStaffExp.setExpName("Plant Maintenance & Op. Staffing");
			plantMainOpStaffExp.setExpType("Staffing Cost (1A)");
			plantMainOpStaffExp.setConfirmationId(root.getForm().getConfirmationId());

			// subtotal before salary and wages - omitted
			LtcYtdExp salWagRecvExp = new LtcYtdExp();
			salWagRecvExp.setExpYtd(root.getOpEx_YTD7());
			salWagRecvExp.setExpNotes(root.getOpEx_note7());
			salWagRecvExp.setExpName("Salary & wages recovered");
			salWagRecvExp.setExpType("Staffing Cost (1A)");
			salWagRecvExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp salWagAccExp = new LtcYtdExp();
			salWagAccExp.setExpYtd(root.getOpEx_YTD8());
			salWagAccExp.setExpNotes(root.getOpEx_note8());
			salWagAccExp.setExpName("Salaries and wages accrual");
			salWagAccExp.setExpType("Staffing Cost (1A)");
			salWagAccExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp othLabCostExp = new LtcYtdExp();
			othLabCostExp.setExpYtd(root.getOpEx_YTD9());
			othLabCostExp.setExpNotes(root.getOpEx_note9());
			othLabCostExp.setExpName("Salary & wages recovered");
			othLabCostExp.setExpType("Staffing Cost (1A)");
			othLabCostExp.setConfirmationId(root.getForm().getConfirmationId());

			// subtotal

			LtcYtdExp bnftCostExp = new LtcYtdExp();
			bnftCostExp.setExpYtd(root.getOpEx_YTD10());
			bnftCostExp.setExpNotes(root.getOpEx_YTD10());
			bnftCostExp.setExpName("Benefits");
			bnftCostExp.setExpType("Staffing Cost (1B)");
			bnftCostExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp sickSevrnceAccExp = new LtcYtdExp();
			sickSevrnceAccExp.setExpYtd(root.getOpEx_YTD11());
			sickSevrnceAccExp.setExpNotes(root.getOpEx_YTD11());
			sickSevrnceAccExp.setExpName("Sick, severance and other accrual");
			sickSevrnceAccExp.setExpType("Staffing Cost (1B)");
			sickSevrnceAccExp.setConfirmationId(root.getForm().getConfirmationId());

			// subtotal
			LtcYtdExp buildingRentExp = new LtcYtdExp();
			buildingRentExp.setExpYtd(root.getOpEx_YTD12());
			buildingRentExp.setExpNotes(root.getOpEx_YTD12());
			buildingRentExp.setExpName("Building rent/lease cost");
			buildingRentExp.setExpType("Property Cost");
			buildingRentExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp intrstMortgageLngTrmExp = new LtcYtdExp();
			intrstMortgageLngTrmExp.setExpYtd(root.getOpEx_YTD13());
			intrstMortgageLngTrmExp.setExpNotes(root.getOpEx_YTD13());
			intrstMortgageLngTrmExp.setExpName("Interest on mortgage or long-term debt");
			intrstMortgageLngTrmExp.setExpType("Property Cost");
			intrstMortgageLngTrmExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp propertyTaxesExp = new LtcYtdExp();
			propertyTaxesExp.setExpYtd(root.getOpEx_YTD14());
			propertyTaxesExp.setExpNotes(root.getOpEx_YTD14());
			propertyTaxesExp.setExpName("Property taxes");
			propertyTaxesExp.setExpType("Property Cost");
			propertyTaxesExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp mntnceExp = new LtcYtdExp();
			mntnceExp.setExpYtd(root.getOpEx_YTD15());
			mntnceExp.setExpNotes(root.getOpEx_YTD15());
			mntnceExp.setExpName("Maintenance & Repairs - building, ground & equip.");
			mntnceExp.setExpType("Property Cost");
			mntnceExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp suppliesExp = new LtcYtdExp();
			suppliesExp.setExpYtd(root.getOpEx_YTD16());
			suppliesExp.setExpNotes(root.getOpEx_YTD16());
			suppliesExp.setExpName("Supplies ~ for building, ground & equipment");
			suppliesExp.setExpType("Property Cost");
			suppliesExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp utilitiesExp = new LtcYtdExp();
			utilitiesExp.setExpYtd(root.getOpEx_YTD17());
			utilitiesExp.setExpNotes(root.getOpEx_YTD17());
			utilitiesExp.setExpName("Utilities");
			utilitiesExp.setExpType("Property Cost");
			utilitiesExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp wasteMgmntExp = new LtcYtdExp();
			wasteMgmntExp.setExpYtd(root.getOpEx_YTD18());
			wasteMgmntExp.setExpNotes(root.getOpEx_YTD18());
			wasteMgmntExp.setExpName("Waste management");
			wasteMgmntExp.setExpType("Property Cost");
			wasteMgmntExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp resTranServExp = new LtcYtdExp();
			resTranServExp.setExpYtd(root.getOpEx_YTD19());
			resTranServExp.setExpNotes(root.getOpEx_YTD19());
			resTranServExp.setExpName("Resident Transportation Services");
			resTranServExp.setExpType("Property Cost");
			resTranServExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp othExp = new LtcYtdExp();
			othExp.setExpYtd(root.getOpEx_YTD20());
			othExp.setExpNotes(root.getOpEx_YTD20());
			othExp.setExpName("Others - Operating");
			othExp.setExpType("Property Cost");
			othExp.setConfirmationId(root.getForm().getConfirmationId());

			// skipping subtotal for now

			LtcYtdExp medSupExp = new LtcYtdExp();
			medSupExp.setExpYtd(root.getOpEx_YTD21());
			medSupExp.setExpNotes(root.getOpEx_YTD21());
			medSupExp.setExpName("Medical Supplies");
			medSupExp.setExpType("Supplies");
			medSupExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp drgsPharmaExp = new LtcYtdExp();
			drgsPharmaExp.setExpYtd(root.getOpEx_YTD22());
			drgsPharmaExp.setExpNotes(root.getOpEx_YTD22());
			drgsPharmaExp.setExpName("Drugs & Pharmaceutical");
			drgsPharmaExp.setExpType("Supplies");
			drgsPharmaExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp rawFoodCostExp = new LtcYtdExp();
			rawFoodCostExp.setExpYtd(root.getOpEx_YTD23());
			rawFoodCostExp.setExpNotes(root.getOpEx_YTD23());
			rawFoodCostExp.setExpName("Raw Food Cost (inc. dietary supplement costs)");
			rawFoodCostExp.setExpType("Supplies");
			rawFoodCostExp.setConfirmationId(root.getForm().getConfirmationId());

			

			LtcYtdExp dietSupExp = new LtcYtdExp();
			dietSupExp.setExpYtd(root.getOpEx_YTD24());
			dietSupExp.setExpNotes(root.getOpEx_YTD24());
			dietSupExp.setExpName("Dietary supplies");
			dietSupExp.setExpType("Supplies");
			dietSupExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp ldrySupExp = new LtcYtdExp();
			ldrySupExp.setExpYtd(root.getOpEx_YTD25());
			ldrySupExp.setExpNotes(root.getOpEx_YTD25());
			ldrySupExp.setExpName("Laundry supplies");
			ldrySupExp.setExpType("Supplies");
			ldrySupExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp houseSupExp = new LtcYtdExp();
			houseSupExp.setExpYtd(root.getOpEx_YTD26());
			houseSupExp.setExpNotes(root.getOpEx_YTD26());
			houseSupExp.setExpName("Housekeeping supplies");
			houseSupExp.setExpType("Supplies");
			houseSupExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp othSupExp = new LtcYtdExp();
			othSupExp.setExpYtd(root.getOpEx_YTD27());
			othSupExp.setExpNotes(root.getOpEx_YTD27());
			othSupExp.setExpName("Others - Specify");
			othSupExp.setExpType("Supplies");
			othSupExp.setConfirmationId(root.getForm().getConfirmationId());

			Collections.addAll(ltcYtdExp, dirCareCostExp, foodCostExp, ldryServExp, housekeepingCostExp,
					adminServCostExp, plantMainOpStaffExp, salWagRecvExp, salWagAccExp, othLabCostExp, bnftCostExp,
					sickSevrnceAccExp, buildingRentExp, intrstMortgageLngTrmExp, propertyTaxesExp, mntnceExp,
					suppliesExp, utilitiesExp, wasteMgmntExp, resTranServExp, othExp, medSupExp, rawFoodCostExp,
					drgsPharmaExp, dietSupExp, ldrySupExp, houseSupExp, othSupExp);

			//
			/* Subtotals */
			LtcYtdExpSubTotals staffCost1ASubtotal = new LtcYtdExpSubTotals();
			staffCost1ASubtotal.setConfirmationId(root.getForm().getConfirmationId());
			staffCost1ASubtotal.setExpType("Staffing Type (1A)");
			staffCost1ASubtotal.setSubTotalRevYtd(root.getOpEx_sum11());

			LtcYtdExpSubTotals staffCost1BSubtotal = new LtcYtdExpSubTotals();
			staffCost1BSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			staffCost1BSubtotal.setExpType("Staffing Type (1B)");
			staffCost1BSubtotal.setSubTotalRevYtd(root.getOpEx_sum12());

			LtcYtdExpSubTotals propertyCostSubtotal = new LtcYtdExpSubTotals();
			propertyCostSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			propertyCostSubtotal.setExpType("Property Cost (2)");
			propertyCostSubtotal.setSubTotalRevYtd(root.getOpEx_sum13());

			LtcYtdExpSubTotals suppliesSubtotal = new LtcYtdExpSubTotals();
			suppliesSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			suppliesSubtotal.setExpType("Supplies");
			suppliesSubtotal.setSubTotalRevYtd(root.getOpEx_sum14());

			LtcYtdExpSubTotals adminCostSubtotal = new LtcYtdExpSubTotals();
			adminCostSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			adminCostSubtotal.setExpType("Administration Cost - non-wages (4)");
			adminCostSubtotal.setSubTotalRevYtd(root.getOpEx_sum15());

			LtcYtdExpSubTotals operatingCostSubtotal = new LtcYtdExpSubTotals();
			operatingCostSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			operatingCostSubtotal.setExpType("Operating Expenses");
			operatingCostSubtotal.setSubTotalRevYtd(root.getOpEx_sum16());

			LtcYtdExpSubTotals nonOperationalExpSubtotal = new LtcYtdExpSubTotals();
			nonOperationalExpSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			nonOperationalExpSubtotal.setExpType("Non-operating expenses");
			nonOperationalExpSubtotal.setSubTotalRevYtd(root.getNopEx_sum11());

			Collections.addAll(ltcYtdExpSubttls,staffCost1ASubtotal,staffCost1BSubtotal,propertyCostSubtotal,suppliesSubtotal,adminCostSubtotal,operatingCostSubtotal,
			 nonOperationalExpSubtotal);

			/* END */

			/*LtcYtdDep */
			LtcYtdDep buildingDep = new LtcYtdDep();
			buildingDep.setConfirmationId(root.getForm().getConfirmationId());
			buildingDep.setDepName("Building");
			buildingDep.setDepYtd(root.getOpEx_item138());
			buildingDep.setDepNotes(root.getOpEx_note38());

			LtcYtdDep furnitureEquipmentDep = new LtcYtdDep();
			furnitureEquipmentDep.setConfirmationId(root.getForm().getConfirmationId());
			furnitureEquipmentDep.setDepName("Furniture & equipment");
			furnitureEquipmentDep.setDepYtd(root.getOpEx_item139());
			furnitureEquipmentDep.setDepNotes(root.getOpEx_note39());

			Collections.addAll(ltcYtdDep, buildingDep, furnitureEquipmentDep);
			/* END */

			/* LtcYtdSumTotals */
			LtcYtdSumTotals YtdTotal = new LtcYtdSumTotals();
			YtdTotal.setConfirmationId(root.getForm().getConfirmationId());
			YtdTotal.setTotName(root.getOpSu_data_total_label());
			YtdTotal.setSumYTD(root.getOpSu_data_total());
			YtdTotal.setTotNotes(root.getOpSu_data_total_note());

			ltcYtdSumTotals.add(YtdTotal);

			/* END */
			
			LtcYtdExp offExpAdCost = new LtcYtdExp();
			offExpAdCost.setExpYtd(root.getOpEx_YTD28());
			offExpAdCost.setExpNotes(root.getOpEx_YTD28());
			offExpAdCost.setExpName("Office Expense");
			offExpAdCost.setExpType("Administration Cost - non-wages");
			offExpAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp mgmntAdCost = new LtcYtdExp();
			mgmntAdCost.setExpYtd(root.getOpEx_YTD29());
			mgmntAdCost.setExpNotes(root.getOpEx_YTD29());
			mgmntAdCost.setExpName("Management Fees");
			mgmntAdCost.setExpType("Administration Cost - non-wages");
			mgmntAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp hoAllocpAdCost = new LtcYtdExp();
			hoAllocpAdCost.setExpYtd(root.getOpEx_YTD30());
			hoAllocpAdCost.setExpNotes(root.getOpEx_YTD30());
			hoAllocpAdCost.setExpName("Head Office Allocation (non-compensation)");
			hoAllocpAdCost.setExpType("Administration Cost - non-wages");
			hoAllocpAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp accAdCost = new LtcYtdExp();
			accAdCost.setExpYtd(root.getOpEx_YTD31());
			accAdCost.setExpNotes(root.getOpEx_YTD31());
			accAdCost.setExpName("Accreditation Costs");
			accAdCost.setExpType("Administration Cost - non-wages");
			accAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp apaAdCost = new LtcYtdExp();
			apaAdCost.setExpYtd(root.getOpEx_YTD32());
			apaAdCost.setExpNotes(root.getOpEx_YTD32());
			apaAdCost.setExpName("Association dues, professional fees, audit fees");
			apaAdCost.setExpType("Administration Cost - non-wages");
			apaAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp insuranceAdCost = new LtcYtdExp();
			insuranceAdCost.setExpYtd(root.getOpEx_YTD33());
			insuranceAdCost.setExpNotes(root.getOpEx_YTD33());
			insuranceAdCost.setExpName("Insurances (for property & liability)");
			insuranceAdCost.setExpType("Administration Cost - non-wages");
			insuranceAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp othSupAdCost = new LtcYtdExp();
			othSupAdCost.setExpYtd(root.getOpEx_YTD34());
			othSupAdCost.setExpNotes(root.getOpEx_YTD34());
			othSupAdCost.setExpName("Other - Administration and supplies");
			othSupAdCost.setExpType("Administration Cost - non-wages");
			othSupAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp othAdCost = new LtcYtdExp();
			othAdCost.setExpYtd(root.getOpEx_YTD35());
			othAdCost.setExpNotes(root.getOpEx_YTD35());
			othAdCost.setExpName("Other - Specify");
			othAdCost.setExpType("Administration Cost - non-wages");
			othAdCost.setConfirmationId(root.getForm().getConfirmationId());

			
			/* Non operating expense */
			LtcYtdExp dirCareNonOpExpMortgage = new LtcYtdExp();
			dirCareNonOpExpMortgage.setExpYtd(root.getNopEx_YTD1());
			dirCareNonOpExpMortgage.setExpNotes(root.getNopEx_note1());
			dirCareNonOpExpMortgage.setExpName("Mortgage Principle Repayment");
			dirCareNonOpExpMortgage.setExpType("Non-operating Expense");
			dirCareNonOpExpMortgage.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp dirCareNonOpExpOther = new LtcYtdExp();
			dirCareNonOpExpOther.setExpYtd(root.getNopEx_YTD2());
			dirCareNonOpExpOther.setExpNotes(root.getNopEx_note2());
			dirCareNonOpExpOther.setExpName("Other");
			dirCareNonOpExpOther.setExpType("Non-operating Expense");
			dirCareNonOpExpOther.setConfirmationId(root.getForm().getConfirmationId());
			/* END */

			
			Collections.addAll(ltcYtdExp, dirCareCostExp, foodCostExp, ldryServExp, housekeepingCostExp,
					adminServCostExp, plantMainOpStaffExp, salWagRecvExp, salWagAccExp, othLabCostExp, bnftCostExp,
					sickSevrnceAccExp, buildingRentExp, intrstMortgageLngTrmExp, propertyTaxesExp, mntnceExp,
					suppliesExp, utilitiesExp, wasteMgmntExp, resTranServExp, othExp, medSupExp, rawFoodCostExp,
					drgsPharmaExp, dietSupExp, ldrySupExp, houseSupExp, othSupExp, offExpAdCost, mgmntAdCost,
					hoAllocpAdCost, accAdCost, apaAdCost, insuranceAdCost, othSupAdCost, othAdCost, dirCareNonOpExpMortgage,
					dirCareNonOpExpOther);

			// subtotal
			// total operating expenses

			/* Bed Inventory */

			/* mandatory bed grid */
			for (BedGrid0 maxOcp : root.getBedGrid0()) {
				LtcBedYtdMaxOccupancy numOfBeds = new LtcBedYtdMaxOccupancy();
				numOfBeds.setBedFundingType(maxOcp.getBedType());
				numOfBeds.setQuarterInventory(maxOcp.getQuarter());
				numOfBeds.setConfirmationId(root.getForm().getConfirmationId());
				numOfBeds.setStartDate(maxOcp.getStartDate0());
				numOfBeds.setEndDate(maxOcp.getEndDate0());
				numOfBeds.setNumberOfBeds(maxOcp.getNumberOfBeds());
				numOfBeds.setMaximumBedDays(maxOcp.getMaximumBedDays());
				// notes missing
				if (maxOcp.getBedType()!=null && maxOcp.getBedType().equals(Constants.IN_SCOPE)) {
					 numOfBeds.setBedSubype(maxOcp.getSubTypeIn());
				} else if (maxOcp.getBedType()!=null && maxOcp.getBedType().equals(Constants.OUT_OF_SCOPE)) {
					numOfBeds.setBedSubype(maxOcp.getSubTypeOut());
				} else {
					numOfBeds.setBedSubype(maxOcp.getSubTypePrivate());
				}

				ltcBedYtdMaxOccupancies.add(numOfBeds);

			}

			/* Planned Maximum Bed Occupancy */
			LtcBedYtdMaxOccupancyTotals plannedInScopeOccupancy = new LtcBedYtdMaxOccupancyTotals();
			plannedInScopeOccupancy.setConfirmationID(root.getForm().getConfirmationId());
			plannedInScopeOccupancy.setOccupancyType("Planned Maximum Bed Occupancy");
			plannedInScopeOccupancy.setBedFundingType("In-Scope Max. Beds Days");
			plannedInScopeOccupancy.setTotalBedQuarter1(root.getPlannedInScope1());
			plannedInScopeOccupancy.setTotalBedQuarter2(root.getPlannedInScope2());
			plannedInScopeOccupancy.setTotalBedQuarter3(root.getPlannedInScope3());
			plannedInScopeOccupancy.setTotalBedQuarter4(root.getPlannedInScope4());
			plannedInScopeOccupancy.setTotalBedDays(root.getPlannedInScope());

			LtcBedYtdMaxOccupancyTotals plannedOutOfScopeOccupancy = new LtcBedYtdMaxOccupancyTotals();
			plannedOutOfScopeOccupancy.setConfirmationID(root.getForm().getConfirmationId());
			plannedOutOfScopeOccupancy.setOccupancyType("Planned Maximum Bed Occupancy");
			plannedOutOfScopeOccupancy.setBedFundingType("Out of Scope Max Beds Days");
			plannedOutOfScopeOccupancy.setTotalBedQuarter1(root.getPlannedOutScope1());
			plannedOutOfScopeOccupancy.setTotalBedQuarter2(root.getPlannedOutScope2());
			plannedOutOfScopeOccupancy.setTotalBedQuarter3(root.getPlannedOutScope3());
			plannedOutOfScopeOccupancy.setTotalBedQuarter4(root.getPlannedOutScope4());
			plannedOutOfScopeOccupancy.setTotalBedDays(root.getPlannedOutScope());

			LtcBedYtdMaxOccupancyTotals plannedPrivateOccupancy = new LtcBedYtdMaxOccupancyTotals();
			plannedPrivateOccupancy.setConfirmationID(root.getForm().getConfirmationId());
			plannedPrivateOccupancy.setOccupancyType("Planned Maximum Bed Occupancy");
			plannedPrivateOccupancy.setBedFundingType("Private Max Beds Days");
			plannedPrivateOccupancy.setTotalBedQuarter1(root.getPlannedPrivate1());
			plannedPrivateOccupancy.setTotalBedQuarter2(root.getPlannedPrivate2());
			plannedPrivateOccupancy.setTotalBedQuarter3(root.getPlannedPrivate3());
			plannedPrivateOccupancy.setTotalBedQuarter4(root.getPlannedPrivate4());
			plannedPrivateOccupancy.setTotalBedDays(root.getPlannedPrivate());

			LtcBedYtdMaxOccupancyTotals plannedTotalMaxBedOccupancy = new LtcBedYtdMaxOccupancyTotals();
			plannedTotalMaxBedOccupancy.setConfirmationID(root.getForm().getConfirmationId());
			plannedTotalMaxBedOccupancy.setOccupancyType("Planned Maximum Bed Occupancy");
			plannedTotalMaxBedOccupancy.setBedFundingType("Total Max Bed Days");
			plannedTotalMaxBedOccupancy.setTotalBedQuarter1(root.getPlannedTotal1());
			plannedTotalMaxBedOccupancy.setTotalBedQuarter2(root.getPlannedTotal2());
			plannedTotalMaxBedOccupancy.setTotalBedQuarter3(root.getPlannedTotal3());
			plannedTotalMaxBedOccupancy.setTotalBedQuarter4(root.getPlannedTotal4());
			plannedTotalMaxBedOccupancy.setTotalBedDays(root.getPlannedTotal());

			LtcBedYtdMaxOccupancyTotals ytdInScopeMaxBedOccupancy = new LtcBedYtdMaxOccupancyTotals();
			ytdInScopeMaxBedOccupancy.setConfirmationID(root.getForm().getConfirmationId());
			ytdInScopeMaxBedOccupancy.setOccupancyType("YTD Maximum Bed Occupancy");
			ytdInScopeMaxBedOccupancy.setBedFundingType("In-Scope Max. Beds Days");
			ytdInScopeMaxBedOccupancy.setTotalBedQuarter1(root.getyTDMaxInScopeQ1());
			ytdInScopeMaxBedOccupancy.setTotalBedQuarter2(root.getyTDMaxInScopeQ2());
			ytdInScopeMaxBedOccupancy.setTotalBedQuarter3(root.getyTDMaxInScopeQ3());
			ytdInScopeMaxBedOccupancy.setTotalBedQuarter4(root.getyTDMaxInScopeQ4());
			ytdInScopeMaxBedOccupancy.setTotalBedDays(root.getInScopeBedTotalYTD());

			LtcBedYtdMaxOccupancyTotals ytdOutOfScopeMaxBedOccupancy = new LtcBedYtdMaxOccupancyTotals();
			ytdOutOfScopeMaxBedOccupancy.setConfirmationID(root.getForm().getConfirmationId());
			ytdOutOfScopeMaxBedOccupancy.setOccupancyType("YTD Maximum Bed Occupancy");
			ytdOutOfScopeMaxBedOccupancy.setBedFundingType("Out of Scope Max Beds Days");
			ytdOutOfScopeMaxBedOccupancy.setTotalBedQuarter1(root.getyTDMaxOutScopeQ1());
			ytdOutOfScopeMaxBedOccupancy.setTotalBedQuarter2(root.getyTDMaxOutScopeQ2());
			ytdOutOfScopeMaxBedOccupancy.setTotalBedQuarter3(root.getyTDMaxOutScopeQ3());
			ytdOutOfScopeMaxBedOccupancy.setTotalBedQuarter4(root.getyTDMaxOutScopeQ4());
			ytdOutOfScopeMaxBedOccupancy.setTotalBedDays(root.getOutScopeBedTotalYTD());

			LtcBedYtdMaxOccupancyTotals ytdPrivateMaxBedOccupancy = new LtcBedYtdMaxOccupancyTotals();
			ytdPrivateMaxBedOccupancy.setConfirmationID(root.getForm().getConfirmationId());
			ytdPrivateMaxBedOccupancy.setOccupancyType("YTD Maximum Bed Occupancy");
			ytdPrivateMaxBedOccupancy.setBedFundingType("In-Scope Max. Beds Days");
			ytdPrivateMaxBedOccupancy.setTotalBedQuarter1(root.getyTDMaxPrivateQ1());
			ytdPrivateMaxBedOccupancy.setTotalBedQuarter2(root.getyTDMaxPrivateQ2());
			ytdPrivateMaxBedOccupancy.setTotalBedQuarter3(root.getyTDMaxPrivateQ3());
			ytdPrivateMaxBedOccupancy.setTotalBedQuarter4(root.getyTDMaxPrivateQ4());
			ytdPrivateMaxBedOccupancy.setTotalBedDays(root.getPrivateBedTotalYTD());

			LtcBedYtdMaxOccupancyTotals ytdTotalMaxBedOccupancy = new LtcBedYtdMaxOccupancyTotals();
			ytdTotalMaxBedOccupancy.setConfirmationID(root.getForm().getConfirmationId());
			ytdTotalMaxBedOccupancy.setOccupancyType("YTD Maximum Bed Occupancy");
			ytdTotalMaxBedOccupancy.setBedFundingType("In-Scope Max. Beds Days");
			ytdTotalMaxBedOccupancy.setTotalBedQuarter1(root.getyTDMaxTotalQ1());
			ytdTotalMaxBedOccupancy.setTotalBedQuarter2(root.getyTDMaxTotalQ2());
			ytdTotalMaxBedOccupancy.setTotalBedQuarter3(root.getyTDMaxTotalQ3());
			ytdTotalMaxBedOccupancy.setTotalBedQuarter4(root.getyTDMaxTotalQ4());
			ytdTotalMaxBedOccupancy.setTotalBedDays(root.getTotalBedYTD());

			Collections.addAll(ltcBedYtdMaxOccTtls,plannedInScopeOccupancy,plannedOutOfScopeOccupancy,plannedPrivateOccupancy,plannedTotalMaxBedOccupancy,ytdTotalMaxBedOccupancy,ytdInScopeMaxBedOccupancy,ytdOutOfScopeMaxBedOccupancy,ytdPrivateMaxBedOccupancy);
			


			switch (root.getQuarter()) {
			case "q1":
				// bed grid
				for (BedGrid1 maxOcp : root.getBedGrid1()) {
					LtcBedYtdMaxOccupancy numOfBeds = new LtcBedYtdMaxOccupancy();
					numOfBeds.setBedFundingType(maxOcp.getBedType());
					numOfBeds.setConfirmationId(root.getForm().getConfirmationId());
					numOfBeds.setStartDate(maxOcp.getStartDate1());
					numOfBeds.setEndDate(maxOcp.getEndDate1());
					numOfBeds.setNumberOfBeds(maxOcp.getNumberOfBeds());
					numOfBeds.setMaximumBedDays(maxOcp.getMaximumBedDays());
					numOfBeds.setQuarterInventory(root.getQuarter());
					// notes missing
					if (maxOcp.getBedType1()!=null && maxOcp.getBedType1().equals(Constants.IN_SCOPE)) {
						numOfBeds.setBedSubype(maxOcp.getSubTypeIn());
					} else if (maxOcp.getBedType1()!=null && maxOcp.getBedType1().equals(Constants.OUT_OF_SCOPE)) {
						numOfBeds.setBedSubype(maxOcp.getSubTypeOut());
					} else {
						numOfBeds.setBedSubype(maxOcp.getSubTypePrivate() == null ? "" : maxOcp.getSubTypePrivate());
					}
					ltcBedYtdMaxOccupancies.add(numOfBeds);
				}

				// Q1 - April, May, June
				LtcBedYtdOccupiedDays aprilYtdOccDays = new LtcBedYtdOccupiedDays();
				aprilYtdOccDays.setConfirmationId(root.getForm().getConfirmationId());
				aprilYtdOccDays.setOccDaysYTDInScopePublic(root.getInScopeMonth4());
				aprilYtdOccDays.setOccDaysYTOutScopePublic(root.getOutScopeMonth4());
				aprilYtdOccDays.setOccDaysYTDPrivate(root.getPrivateMonth4());
				aprilYtdOccDays.setOccDaysYtdTotalDays(root.getTotalMonth4());
				aprilYtdOccDays.setOccMonth("April");
				aprilYtdOccDays.setOccQuarter("Q1");

				LtcBedYtdOccupiedDays mayYtdOccDays = new LtcBedYtdOccupiedDays();
				mayYtdOccDays.setConfirmationId(root.getForm().getConfirmationId());
				mayYtdOccDays.setOccDaysYTDInScopePublic(root.getInScopeMonth5());
				mayYtdOccDays.setOccDaysYTOutScopePublic(root.getOutScopeMonth5());
				mayYtdOccDays.setOccDaysYTDPrivate(root.getPrivateMonth5());
				mayYtdOccDays.setOccMonth("May");
				mayYtdOccDays.setOccQuarter("Q1");
				mayYtdOccDays.setOccDaysYtdTotalDays(root.getTotalMonth5());

				LtcBedYtdOccupiedDays juneYtdOccDays = new LtcBedYtdOccupiedDays();
				juneYtdOccDays.setConfirmationId(root.getForm().getConfirmationId());
				juneYtdOccDays.setOccDaysYTDInScopePublic(root.getInScopeMonth6());
				juneYtdOccDays.setOccDaysYTOutScopePublic(root.getOutScopeMonth6());
				juneYtdOccDays.setOccDaysYTDPrivate(root.getPrivateMonth6());
				juneYtdOccDays.setOccMonth("June");
				juneYtdOccDays.setOccQuarter("Q1");
				juneYtdOccDays.setOccDaysYtdTotalDays(root.getTotalMonth6());
				
				Collections.addAll(ltcBedYtdOccupiedDays, aprilYtdOccDays,mayYtdOccDays,juneYtdOccDays);

				LtcBedYtdOccupiedDaysTotals q1OccDaysSubttls = new LtcBedYtdOccupiedDaysTotals();
				q1OccDaysSubttls.setConfirmationID(root.getForm().getConfirmationId());
				q1OccDaysSubttls.setOccQuarter("Q1");
				q1OccDaysSubttls.setOccDaysYTDInScopePublic(root.getInScopeTotalQ1());
				q1OccDaysSubttls.setOccDaysYTDOutScopePublic(root.getOutScopeTotalQ1());
				q1OccDaysSubttls.setOccDaysYTDPrivate(root.getPrivateTotalQ1());
				q1OccDaysSubttls.setOccDaysYTDTotalDays(root.getTotalQ1());
				Collections.addAll(ltcBedYtdOccDaysTtls,q1OccDaysSubttls);

// Q1
				LtcBedYtdOccupancyRate occInRateQ1 = new LtcBedYtdOccupancyRate();
				occInRateQ1.setConfirmationID(root.getForm().getConfirmationId());
				occInRateQ1.setOccRateBedTypes("In-Scope 3.36 HPRD Publicly Funded Beds");
				occInRateQ1.setPlanMaxOccDays(root.getyTDPlannedInScopeQ1());
				occInRateQ1.setYtdMaxOccDays(root.getyTDMaxInScopeQ1());
				occInRateQ1.setYtdOccDays(root.getyTDOccupiedInScopeQ1());
				occInRateQ1.setPercentOcc(root.getOccupiedPercentageInScopeQ1());
				occInRateQ1.setOccRateNotes(root.getNoteInScopeQ1());
				occInRateQ1.setOccRateQuarter("Q1");

				LtcBedYtdOccupancyRate occOutRateQ1 = new LtcBedYtdOccupancyRate();
				occOutRateQ1.setConfirmationID(root.getForm().getConfirmationId());
				occOutRateQ1.setOccRateBedTypes("Out of Scope Publicly Funded Beds");
				occOutRateQ1.setPlanMaxOccDays(root.getyTDPlannedInScopeQ1());
				occOutRateQ1.setYtdMaxOccDays(root.getyTDMaxInScopeQ1());
				occOutRateQ1.setYtdOccDays(root.getyTDOccupiedInScopeQ1());
				occOutRateQ1.setPercentOcc(root.getOccupiedPercentageOutScopeQ1());
				occOutRateQ1.setOccRateQuarter("Q1");
				//occInRateQ1.setOccRateNotes(root.getOpEx_note13());

				LtcBedYtdOccupancyRate occRateQ1 = new LtcBedYtdOccupancyRate();
				occRateQ1.setConfirmationID(root.getForm().getConfirmationId());
				occRateQ1.setOccRateBedTypes("Private Beds");
				occRateQ1.setPlanMaxOccDays(root.getyTDPlannedInScopeQ1());
				occRateQ1.setYtdMaxOccDays(root.getyTDMaxInScopeQ1());
				occRateQ1.setYtdOccDays(root.getyTDOccupiedInScopeQ1());
				occRateQ1.setPercentOcc(root.getOccupiedPercentagePrivateQ1());
				occRateQ1.setOccRateQuarter("Q1");
			//	occInRateQ1.setOccRateNotes(root.getNoteInScopeQ1());

				LtcBedYtdOccupancyRateTotals q1RateTotals = new LtcBedYtdOccupancyRateTotals();
				q1RateTotals.setConfirmationID(root.getForm().getConfirmationId());
				q1RateTotals.setOccRateQuarter("Q1");
				q1RateTotals.setTotalPlanMaxOccDays(root.getyTDPlannedTotalQ1());
				q1RateTotals.setTotalYTDMaxOccDays(root.getyTDMaxTotalQ1());
				q1RateTotals.setTotalYTDOccDays(root.getyTDOccupiedTotalQ1());
				q1RateTotals.setTotalPercentOcc(root.getOccupiedPercentageTotalQ1());

				Collections.addAll(ltcBedYtdOccRateTtls,q1RateTotals);
				Collections.addAll(ltcBedYtdOccupancyRates, occInRateQ1,occOutRateQ1,occRateQ1);

				break;
			case "q2":
				for (BedGrid2 maxOcp : root.getBedGrid2()) {
					LtcBedYtdMaxOccupancy numOfBeds = new LtcBedYtdMaxOccupancy();
					numOfBeds.setBedFundingType(maxOcp.getBedType());
					numOfBeds.setConfirmationId(root.getForm().getConfirmationId());
					numOfBeds.setStartDate(maxOcp.getStartDate2());
					numOfBeds.setEndDate(maxOcp.getEndDate2());
					numOfBeds.setNumberOfBeds(maxOcp.getNumberOfBeds());
					numOfBeds.setMaximumBedDays(maxOcp.getMaximumBedDays());
					numOfBeds.setQuarterInventory("Q2");
					// notes missing
					if (maxOcp.getBedType2()!=null && maxOcp.getBedType2().equals(Constants.IN_SCOPE)) {
						numOfBeds.setBedSubype(maxOcp.getSubTypeIn());
					} else if (maxOcp.getBedType2()!=null && maxOcp.getBedType2().equals(Constants.OUT_OF_SCOPE)) {
						numOfBeds.setBedSubype(maxOcp.getSubTypeOut());
					} else {
						numOfBeds.setBedSubype(maxOcp.getSubTypePrivate());
					}
					ltcBedYtdMaxOccupancies.add(numOfBeds);
				}
				// Q2 July, August, September
				LtcBedYtdOccupiedDays julyYtdOccDays = new LtcBedYtdOccupiedDays();
				julyYtdOccDays.setConfirmationId(root.getForm().getConfirmationId());
				julyYtdOccDays.setOccDaysYTDInScopePublic(root.getInScopeMonth7());
				julyYtdOccDays.setOccDaysYTOutScopePublic(root.getOutScopeMonth7());
				julyYtdOccDays.setOccDaysYTDPrivate(root.getPrivateMonth7());
				julyYtdOccDays.setOccMonth("July");
				julyYtdOccDays.setOccQuarter("Q2");
				julyYtdOccDays.setOccDaysYtdTotalDays(root.getTotalMonth7());

				LtcBedYtdOccupiedDays augYtdOccDays = new LtcBedYtdOccupiedDays();
				augYtdOccDays.setConfirmationId(root.getForm().getConfirmationId());
				augYtdOccDays.setOccDaysYTDInScopePublic(root.getInScopeMonth8());
				augYtdOccDays.setOccDaysYTOutScopePublic(root.getOutScopeMonth8());
				augYtdOccDays.setOccDaysYTDPrivate(root.getPrivateMonth8());
				augYtdOccDays.setOccMonth("May");
				augYtdOccDays.setOccQuarter("Q2");
				augYtdOccDays.setOccDaysYtdTotalDays(root.getTotalMonth8());

				LtcBedYtdOccupiedDays sepYtdOccDays = new LtcBedYtdOccupiedDays();
				sepYtdOccDays.setConfirmationId(root.getForm().getConfirmationId());
				sepYtdOccDays.setOccDaysYTDInScopePublic(root.getInScopeMonth9());
				sepYtdOccDays.setOccDaysYTOutScopePublic(root.getOutScopeMonth9());
				sepYtdOccDays.setOccDaysYTDPrivate(root.getPrivateMonth9());
				sepYtdOccDays.setOccMonth("September");
				sepYtdOccDays.setOccQuarter("Q2");
				sepYtdOccDays.setOccDaysYtdTotalDays(root.getTotalMonth9());
				
				Collections.addAll(ltcBedYtdOccupiedDays, julyYtdOccDays,augYtdOccDays,sepYtdOccDays);

				LtcBedYtdOccupiedDaysTotals q2OccDaysSubttls = new LtcBedYtdOccupiedDaysTotals();
				q2OccDaysSubttls.setConfirmationID(root.getForm().getConfirmationId());
				q2OccDaysSubttls.setOccQuarter("Q2");
				q2OccDaysSubttls.setOccDaysYTDInScopePublic(root.getInScopeTotalQ2());
				q2OccDaysSubttls.setOccDaysYTDOutScopePublic(root.getOutScopeTotalQ2());
				q2OccDaysSubttls.setOccDaysYTDPrivate(root.getPrivateTotalQ2());
				q2OccDaysSubttls.setOccDaysYTDTotalDays(root.getTotalQ2());
				Collections.addAll(ltcBedYtdOccDaysTtls,q2OccDaysSubttls);


				// Q2
				LtcBedYtdOccupancyRate occInRateQ2 = new LtcBedYtdOccupancyRate();
				occInRateQ2.setConfirmationID(root.getForm().getConfirmationId());
				occInRateQ2.setOccRateBedTypes("In-Scope 3.36 HPRD Publicly Funded Beds");
				occInRateQ2.setPlanMaxOccDays(root.getyTDPlannedInScopeQ2());
				occInRateQ2.setYtdMaxOccDays(root.getyTDMaxInScopeQ2());
				occInRateQ2.setYtdOccDays(root.getyTDOccupiedInScopeQ2());
				occInRateQ2.setPercentOcc(root.getOccupiedPercentageInScopeQ2());
				occInRateQ2.setOccRateNotes(root.getNoteInScopeQ2());
				occInRateQ2.setOccRateQuarter("Q2");

				LtcBedYtdOccupancyRate occOutRateQ2 = new LtcBedYtdOccupancyRate();
				occOutRateQ2.setConfirmationID(root.getForm().getConfirmationId());
				occOutRateQ2.setOccRateBedTypes("Out of Scope Publicly Funded Beds");
				occOutRateQ2.setPlanMaxOccDays(root.getyTDPlannedInScopeQ2());
				occOutRateQ2.setYtdMaxOccDays(root.getyTDMaxInScopeQ2());
				occOutRateQ2.setYtdOccDays(root.getyTDOccupiedInScopeQ2());
				occOutRateQ2.setPercentOcc(root.getOccupiedPercentageOutScopeQ2());
				occOutRateQ2.setOccRateQuarter("Q2");

				LtcBedYtdOccupancyRate occRateQ2 = new LtcBedYtdOccupancyRate();
				occRateQ2.setConfirmationID(root.getForm().getConfirmationId());
				occRateQ2.setOccRateBedTypes("Private Beds");
				occRateQ2.setPlanMaxOccDays(root.getyTDPlannedInScopeQ2());
				occRateQ2.setYtdMaxOccDays(root.getyTDMaxInScopeQ2());
				occRateQ2.setYtdOccDays(root.getyTDOccupiedInScopeQ2());
				occRateQ2.setPercentOcc(root.getOccupiedPercentagePrivateQ2());
				occRateQ2.setOccRateQuarter("Q2");
				
				LtcBedYtdOccupancyRateTotals q2RateTotals = new LtcBedYtdOccupancyRateTotals();
				q2RateTotals.setConfirmationID(root.getForm().getConfirmationId());
				q2RateTotals.setOccRateQuarter("Q2");
				q2RateTotals.setTotalPlanMaxOccDays(root.getyTDPlannedTotalQ2());
				q2RateTotals.setTotalYTDMaxOccDays(root.getyTDMaxTotalQ2());
				q2RateTotals.setTotalYTDOccDays(root.getyTDOccupiedTotalQ2());
				q2RateTotals.setTotalPercentOcc(root.getOccupiedPercentageTotalQ2());
				

				Collections.addAll(ltcBedYtdOccRateTtls,q2RateTotals);
				Collections.addAll(ltcBedYtdOccupancyRates, occInRateQ2,occOutRateQ2,occRateQ2);

				break;
			case "q3":
				for (BedGrid3 maxOcp : root.getBedGrid3()) {
					LtcBedYtdMaxOccupancy numOfBeds = new LtcBedYtdMaxOccupancy();
					numOfBeds.setBedFundingType(maxOcp.getBedType());
					numOfBeds.setConfirmationId(root.getForm().getConfirmationId());
					numOfBeds.setStartDate(maxOcp.getStartDate3());
					numOfBeds.setEndDate(maxOcp.getEndDate3());
					numOfBeds.setNumberOfBeds(maxOcp.getNumberOfBeds());
					numOfBeds.setMaximumBedDays(maxOcp.getMaximumBedDays());
					numOfBeds.setQuarterInventory(root.getQuarter());
					// notes missing
					if (maxOcp.getBedType3()!=null && maxOcp.getBedType3().equals(Constants.IN_SCOPE)) {
						numOfBeds.setBedSubype(maxOcp.getSubTypeIn());
					} else if (maxOcp.getBedType3()!=null && maxOcp.getBedType3().equals(Constants.OUT_OF_SCOPE)) {
						numOfBeds.setBedSubype(maxOcp.getSubTypeOut());
					} else {
						numOfBeds.setBedSubype(maxOcp.getSubTypePrivate());
					}
					ltcBedYtdMaxOccupancies.add(numOfBeds);
				}

				LtcBedYtdOccupiedDaysTotals q3OccDaysSubttls = new LtcBedYtdOccupiedDaysTotals();
				q3OccDaysSubttls.setConfirmationID(root.getForm().getConfirmationId());
				q3OccDaysSubttls.setOccQuarter("Q3");
				q3OccDaysSubttls.setOccDaysYTDInScopePublic(root.getInScopeTotalQ3());
				q3OccDaysSubttls.setOccDaysYTDOutScopePublic(root.getOutScopeTotalQ3());
				q3OccDaysSubttls.setOccDaysYTDPrivate(root.getPrivateTotalQ3());
				q3OccDaysSubttls.setOccDaysYTDTotalDays(root.getTotalQ3());
				Collections.addAll(ltcBedYtdOccDaysTtls,q3OccDaysSubttls);

				// Q3 October, November, December
				LtcBedYtdOccupiedDays octYtdOccDays = new LtcBedYtdOccupiedDays();
				octYtdOccDays.setConfirmationId(root.getForm().getConfirmationId());
				octYtdOccDays.setOccDaysYTDInScopePublic(root.getInScopeMonth10());
				octYtdOccDays.setOccDaysYTOutScopePublic(root.getOutScopeMonth10());
				octYtdOccDays.setOccDaysYTDPrivate(root.getPrivateMonth10());
				octYtdOccDays.setOccMonth("October");
				octYtdOccDays.setOccQuarter("Q3");

				LtcBedYtdOccupiedDays novYtdOccDays = new LtcBedYtdOccupiedDays();
				novYtdOccDays.setConfirmationId(root.getForm().getConfirmationId());
				novYtdOccDays.setOccDaysYTDInScopePublic(root.getInScopeMonth11());
				novYtdOccDays.setOccDaysYTOutScopePublic(root.getOutScopeMonth11());
				novYtdOccDays.setOccDaysYTDPrivate(root.getPrivateMonth11());
				novYtdOccDays.setOccMonth("November");
				novYtdOccDays.setOccQuarter("Q3");

				LtcBedYtdOccupiedDays decYtdOccDays = new LtcBedYtdOccupiedDays();
				decYtdOccDays.setConfirmationId(root.getForm().getConfirmationId());
				decYtdOccDays.setOccDaysYTDInScopePublic(root.getInScopeMonth12());
				decYtdOccDays.setOccDaysYTOutScopePublic(root.getOutScopeMonth12());
				decYtdOccDays.setOccDaysYTDPrivate(root.getPrivateMonth12());
				decYtdOccDays.setOccMonth("December");
				decYtdOccDays.setOccQuarter("Q3");
				Collections.addAll(ltcBedYtdOccupiedDays, octYtdOccDays,novYtdOccDays,decYtdOccDays);
				
				// Q3
				LtcBedYtdOccupancyRate occInRateQ3 = new LtcBedYtdOccupancyRate();
				occInRateQ3.setConfirmationID(root.getForm().getConfirmationId());
				occInRateQ3.setOccRateBedTypes("In-Scope 3.36 HPRD Publicly Funded Beds");
				occInRateQ3.setPlanMaxOccDays(root.getyTDPlannedInScopeQ3());
				occInRateQ3.setYtdMaxOccDays(root.getyTDMaxInScopeQ3());
				occInRateQ3.setYtdOccDays(root.getyTDOccupiedInScopeQ3());
				occInRateQ3.setOccRateNotes(root.getNoteInScopeQ3());
				occInRateQ3.setPercentOcc(root.getOccupiedPercentageInScopeQ3());

				LtcBedYtdOccupancyRate occOutRateQ3 = new LtcBedYtdOccupancyRate();
				occOutRateQ3.setConfirmationID(root.getForm().getConfirmationId());
				occOutRateQ3.setOccRateBedTypes("Out of Scope Publicly Funded Beds");
				occOutRateQ3.setPlanMaxOccDays(root.getyTDPlannedInScopeQ3());
				occOutRateQ3.setYtdMaxOccDays(root.getyTDMaxInScopeQ3());
				occOutRateQ3.setYtdOccDays(root.getyTDOccupiedInScopeQ3());
				occOutRateQ3.setPercentOcc(root.getOccupiedPercentageOutScopeQ3());

				LtcBedYtdOccupancyRate occRateQ3 = new LtcBedYtdOccupancyRate();
				occRateQ3.setConfirmationID(root.getForm().getConfirmationId());
				occRateQ3.setOccRateBedTypes("Private Beds");
				occRateQ3.setPlanMaxOccDays(root.getyTDPlannedInScopeQ3());
				occRateQ3.setYtdMaxOccDays(root.getyTDMaxInScopeQ3());
				occRateQ3.setYtdOccDays(root.getyTDOccupiedInScopeQ3());
				occRateQ3.setPercentOcc(root.getOccupiedPercentagePrivateQ3());
				
				LtcBedYtdOccupancyRateTotals q3RateTotals = new LtcBedYtdOccupancyRateTotals();
				q3RateTotals.setConfirmationID(root.getForm().getConfirmationId());
				q3RateTotals.setOccRateQuarter("Q3");
				q3RateTotals.setTotalPlanMaxOccDays(root.getyTDPlannedTotalQ3());
				q3RateTotals.setTotalYTDMaxOccDays(root.getyTDMaxTotalQ3());
				q3RateTotals.setTotalYTDOccDays(root.getyTDOccupiedTotalQ3());
				q3RateTotals.setTotalPercentOcc(root.getOccupiedPercentageTotalQ3());

				Collections.addAll(ltcBedYtdOccRateTtls,q3RateTotals);
				Collections.addAll(ltcBedYtdOccupancyRates, occInRateQ3,occOutRateQ3,occRateQ3);
				break;
			case "q4":
				for (BedGrid4 maxOcp : root.getBedGrid4()) {
					LtcBedYtdMaxOccupancy numOfBeds = new LtcBedYtdMaxOccupancy();
					numOfBeds.setBedFundingType(maxOcp.getBedType());
					numOfBeds.setConfirmationId(root.getForm().getConfirmationId());
					numOfBeds.setStartDate(maxOcp.getStartDate4());
					numOfBeds.setEndDate(maxOcp.getEndDate4());
					numOfBeds.setNumberOfBeds(maxOcp.getNumberOfBeds());
					numOfBeds.setMaximumBedDays(maxOcp.getMaximumBedDays());
					numOfBeds.setQuarterInventory(root.getQuarter());
					// notes missing
					if (maxOcp.getBedType4()!=null && maxOcp.getBedType4().equals(Constants.IN_SCOPE)) {
						numOfBeds.setBedSubype(maxOcp.getSubTypeIn());
					} else if (maxOcp.getBedType4()!=null && maxOcp.getBedType4().equals(Constants.OUT_OF_SCOPE)) {
						numOfBeds.setBedSubype(maxOcp.getSubTypeOut());
					} else {
						numOfBeds.setBedSubype(maxOcp.getSubTypePrivate());
					}
					ltcBedYtdMaxOccupancies.add(numOfBeds);
				}
				LtcBedYtdOccupiedDaysTotals q4OccDaysSubttls = new LtcBedYtdOccupiedDaysTotals();
				q4OccDaysSubttls.setConfirmationID(root.getForm().getConfirmationId());
				q4OccDaysSubttls.setOccQuarter("Q4");
				q4OccDaysSubttls.setOccDaysYTDInScopePublic(root.getInScopeTotalQ4());
				q4OccDaysSubttls.setOccDaysYTDOutScopePublic(root.getOutScopeTotalQ4());
				q4OccDaysSubttls.setOccDaysYTDPrivate(root.getPrivateTotalQ4());
				q4OccDaysSubttls.setOccDaysYTDTotalDays(root.getTotalQ4());
				Collections.addAll(ltcBedYtdOccDaysTtls,q4OccDaysSubttls);

				// Q4 Jan Feb March
				LtcBedYtdOccupiedDays janYtdOccDays = new LtcBedYtdOccupiedDays();
				janYtdOccDays.setConfirmationId(root.getForm().getConfirmationId());
				janYtdOccDays.setOccDaysYTDInScopePublic(root.getInScopeMonth1());
				janYtdOccDays.setOccDaysYTOutScopePublic(root.getOutScopeMonth1());
				janYtdOccDays.setOccDaysYTDPrivate(root.getPrivateMonth12());
				janYtdOccDays.setOccMonth("January");
				janYtdOccDays.setOccQuarter("Q4");
				janYtdOccDays.setOccDaysYtdTotalDays(root.getTotalMonth1());
				

				LtcBedYtdOccupiedDays febYtdOccDays = new LtcBedYtdOccupiedDays();
				febYtdOccDays.setConfirmationId(root.getForm().getConfirmationId());
				febYtdOccDays.setOccDaysYTDInScopePublic(root.getInScopeMonth2());
				febYtdOccDays.setOccDaysYTOutScopePublic(root.getOutScopeMonth2());
				febYtdOccDays.setOccDaysYTDPrivate(root.getPrivateMonth12());
				febYtdOccDays.setOccMonth("February");
				febYtdOccDays.setOccQuarter("Q4");
				febYtdOccDays.setOccDaysYtdTotalDays(root.getTotalMonth2());

				LtcBedYtdOccupiedDays marYtdOccDays = new LtcBedYtdOccupiedDays();
				marYtdOccDays.setConfirmationId(root.getForm().getConfirmationId());
				marYtdOccDays.setOccDaysYTDInScopePublic(root.getInScopeMonth3());
				marYtdOccDays.setOccDaysYTOutScopePublic(root.getOutScopeMonth3());
				marYtdOccDays.setOccDaysYTDPrivate(root.getPrivateMonth12());
				marYtdOccDays.setOccMonth("March");
				marYtdOccDays.setOccQuarter("Q4");
				marYtdOccDays.setOccDaysYtdTotalDays(root.getTotalMonth3());
				
				Collections.addAll(ltcBedYtdOccupiedDays, janYtdOccDays,febYtdOccDays,marYtdOccDays);

				// Q4
				LtcBedYtdOccupancyRate occInRateQ4 = new LtcBedYtdOccupancyRate();
				occInRateQ4.setConfirmationID(root.getForm().getConfirmationId());
				occInRateQ4.setOccRateBedTypes("In-Scope 3.36 HPRD Publicly Funded Beds");
				occInRateQ4.setPlanMaxOccDays(root.getyTDPlannedInScopeQ4());
				occInRateQ4.setYtdMaxOccDays(root.getyTDMaxInScopeQ4());
				occInRateQ4.setYtdOccDays(root.getyTDOccupiedInScopeQ4());
				occInRateQ4.setOccRateNotes(root.getNoteInScopeQ4());
				occInRateQ4.setPercentOcc(root.getOccupiedPercentageInScopeQ4());

				LtcBedYtdOccupancyRate occOutRateQ4 = new LtcBedYtdOccupancyRate();
				occOutRateQ4.setConfirmationID(root.getForm().getConfirmationId());
				occOutRateQ4.setOccRateBedTypes("Out of Scope Publicly Funded Beds");
				occOutRateQ4.setPlanMaxOccDays(root.getyTDPlannedInScopeQ4());
				occOutRateQ4.setYtdMaxOccDays(root.getyTDMaxInScopeQ4());
				occOutRateQ4.setYtdOccDays(root.getyTDOccupiedInScopeQ4());
				occOutRateQ4.setPercentOcc(root.getOccupiedPercentageOutScopeQ4());

				LtcBedYtdOccupancyRate occRateQ4 = new LtcBedYtdOccupancyRate();
				occRateQ4.setConfirmationID(root.getForm().getConfirmationId());
				occRateQ4.setOccRateBedTypes("Private Beds");
				occRateQ4.setPlanMaxOccDays(root.getyTDPlannedInScopeQ4());
				occRateQ4.setYtdMaxOccDays(root.getyTDMaxInScopeQ4());
				occRateQ4.setYtdOccDays(root.getyTDOccupiedInScopeQ4());
				occRateQ4.setPercentOcc(root.getOccupiedPercentagePrivateQ4());
				
				LtcBedYtdOccupancyRateTotals q4RateTotals = new LtcBedYtdOccupancyRateTotals();
				q4RateTotals.setConfirmationID(root.getForm().getConfirmationId());
				q4RateTotals.setOccRateQuarter("Q4");
				q4RateTotals.setTotalPlanMaxOccDays(root.getyTDPlannedTotalQ4());
				q4RateTotals.setTotalYTDMaxOccDays(root.getyTDMaxTotalQ4());
				q4RateTotals.setTotalYTDOccDays(root.getyTDOccupiedTotalQ4());
				q4RateTotals.setTotalPercentOcc(root.getOccupiedPercentageTotalQ4());

				Collections.addAll(ltcBedYtdOccRateTtls,q4RateTotals);
				Collections.addAll(ltcBedYtdOccupancyRates, occInRateQ4,occOutRateQ4,occRateQ4);

				break;
			default:
				break;
			}
			
			ltcYtdSubmission.setLtcBedYtdMaxOccupancy(ltcBedYtdMaxOccupancies);
			ltcYtdSubmission.setLtcBedYtdOccupancyRate(ltcBedYtdOccupancyRates);
			ltcYtdSubmission.setLtcBedYtdOccupiedDays(ltcBedYtdOccupiedDays);
			ltcYtdSubmission.setLtcYtdCompAddPos(ltcYtdCompAddPos);
			ltcYtdSubmission.setLtcYtdCompBenefits(ltcYtdCompBenefits);
			ltcYtdSubmission.setLtcYtdCompHrs(ltcYtdCompHrs);
			ltcYtdSubmission.setLtcYtdCompSal(ltcYtdCompSal);
			ltcYtdSubmission.setLtcYtdDirectCareCost(ltcYtdDcCost);
			ltcYtdSubmission.setLtcYtdDirectCareHrs(ltcYtdDcHrs);
			ltcYtdSubmission.setLtcYtdExp(ltcYtdExp);
			ltcYtdSubmission.setLtcYtdDep(ltcYtdDep);
			ltcYtdSubmission.setLtcYtdSumTotals(ltcYtdSumTotals);
			ltcYtdSubmission.setLtcYtdRev(ltcYtdRev);
			ltcYtdSubmission.setLtcYtdExpSubttls(ltcYtdExpSubttls);
			ltcYtdSubmission.setLtcYtdRevSubttls(ltcYtdRevSubTtls);
			ltcYtdSubmission.setLtcYtdCompSalSubttls(ltcYtdCompSalSubttls);
			ltcYtdSubmission.setLtcYtdCompSalTtls(ltcYtdCompsalTtls);
			ltcYtdSubmission.setLtcYtdCompHrsSubttls(ltcYtdCompHrsSubttls);
			ltcYtdSubmission.setLtcYtdCompHrsTtls(ltcYtdCompHrsTtls);
			ltcYtdSubmission.setLtcYtdDirectCareHrsSubttls(ltcYtdDcHrsSubttls);
			ltcYtdSubmission.setLtcYtdDirectCareCostSubttls(ltcYtdDcCostSubttls);
			ltcYtdSubmission.setLtcBedYtdMaxOccTtls(ltcBedYtdMaxOccTtls);
			ltcYtdSubmission.setLtcBedYtdOccDaysTtls(ltcBedYtdOccDaysTtls);
			ltcYtdSubmission.setLtcBedYtdOccRateTtls(ltcBedYtdOccRateTtls);
			
			
			ltcYtdSubmissions.add(ltcYtdSubmission);

		}

		return ltcYtdSubmissions;
	}
}
