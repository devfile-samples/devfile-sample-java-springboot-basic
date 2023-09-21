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
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdDepSubTotals;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdDirectCareCost;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdDirectCareCostSubtotals;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdDirectCareHrs;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdDirectCareHrsSubTotals;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdDirectCareVacancy;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdExp;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdExpSubTotals;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdRev;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdRevSubTotals;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdSubmission;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.model.LtcYtdSumTotals;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;
import ca.bc.gov.chefs.etl.util.JsonUtil;

public class LtcQuarterlyYtdApiResponseProcessor implements Processor {

	
	@Override
	@SuppressWarnings("unchecked")
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		payload = JsonUtil.preProcess(payload);
		payload = JsonUtil.roundDigitsNumber(payload);
		payload = JsonUtil.ltcYTDBackwardCompatibility(payload);
		ObjectMapper mapper = new ObjectMapper();
		List<Root> ltcYtdForms = mapper.readValue(payload, new TypeReference<List<Root>>() {
		});
		List<LtcYtdSubmission> parsedLtycYtdSubmissions = parseYtdQuarterlyRequest(ltcYtdForms);
		List<IModel> iModels =  (List<IModel>)(List<?>) parsedLtycYtdSubmissions;
		Map<String,List<List<String>>> map = CSVUtil.provider(iModels);
		boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		List<String> filesGenerated = FileUtil.writeToCSVFile(map,Constants.LTC_QUARTERLY_DIR, isHeaderAdded);
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
			List<LtcYtdDepSubTotals> ltcYtdDepSubTotals = new ArrayList<>();
			List<LtcYtdSumTotals> ltcYtdSumTotals = new ArrayList<>();
			List<LtcBedYtdOccupancyRate> ltcBedYtdOccupancyRates = new ArrayList<>();
			List<LtcBedYtdMaxOccupancy> ltcBedYtdMaxOccupancies = new ArrayList<>();
			List<LtcBedYtdMaxOccupancyTotals> ltcBedYtdMaxOccTtls = new ArrayList<>();
			List<LtcBedYtdOccupiedDays> ltcBedYtdOccupiedDays = new ArrayList<>();
			List<LtcBedYtdOccupiedDaysTotals> ltcBedYtdOccDaysTtls = new ArrayList<>();
			List<LtcBedYtdOccupancyRateTotals> ltcBedYtdOccRateTtls = new ArrayList<>();
			List<LtcYtdDirectCareVacancy> LtcYtdDirectCareVacancy = new ArrayList<>();
		

			/* Form Meta */
			ltcYtdSubmission.setConfirmationId(root.getForm().getConfirmationId());
			ltcYtdSubmission.setIsDeleted(String.valueOf(root.getForm().isDeleted()));
			ltcYtdSubmission.setSubmissionDate(root.getForm().getCreatedAt());
			ltcYtdSubmission.setSubmittedBy(root.getForm().getFullName());
			ltcYtdSubmission.setCCIMSID(root.getCcimsid());
			ltcYtdSubmission.setSubmissionType(root.getSubmission());
			ltcYtdSubmission.setPeriod(root.getQuarter());
			ltcYtdSubmission.setSubmissionFy(root.getFiscalYear());
			ltcYtdSubmission.setNbTotalBeds(root.getNumberOfTotalBeds());
			ltcYtdSubmission.setNbFundedBeds(root.getNumberOfTotalFundedBeds());
			ltcYtdSubmission.setOccRateThreshold(root.getThreshold());
			ltcYtdSubmission.setTotalSalariesWages(root.getbTotal_YTDSalaryWage());
			ltcYtdSubmission.setTotalBenefits(root.getBenefit_value_total());
			ltcYtdSubmission.setBenefitsPercent(root.getbTotal_value_sum());
			ltcYtdSubmission.setTotalVacancies(root.getNursingNVP_sum11());
			
			/* START : Direct Care Hours */
			/* Productive and NP Nursing */ // why no subtotal and total?
			LtcYtdDirectCareHrs nursingRNProdH = new LtcYtdDirectCareHrs();
			nursingRNProdH.setDirCareProdHrsRegYtd(root.getNursingProdH_item11());
			nursingRNProdH.setDirCareProdHrsOtYtd(root.getNursingProdH_item21());
			nursingRNProdH.setDirCareProdHrsOrientationYtd(root.getNursingProdH_item31());
			nursingRNProdH.setDirCareProdHrsContractedYtd(root.getNursingProdHCS1());
			nursingRNProdH.setDirCareNonProdHrsVacYtd(root.getNursingNProdH_item11());
			nursingRNProdH.setDirCareNonProdHrsSickYtd(root.getNursingNProdH_item21());
			nursingRNProdH.setDirCareNonProdHrsOtherYtd(root.getNursingNProdH_item31());
			nursingRNProdH.setConfirmationId(root.getForm().getConfirmationId());
			nursingRNProdH.setDirCareType(root.getNursing_label());
			nursingRNProdH.setDirCareName(root.getNursing_label1());
			nursingRNProdH.setDirCareProdHrsSubtotalYtd(root.getNursingProdH_calc1());
			nursingRNProdH.setDirCareProdHrsTotalYtd(root.getNursingProdH_sub1());
			nursingRNProdH.setDirCareTotalHrsPaidYtd(root.getNursingNProdH_THP1());
			nursingRNProdH.setDirCareNonProdHrsTotalYtd(root.getNursingNProdH_calc1());
			nursingRNProdH.setDirCareProdHrsAgencyStuffUtilYtd(root.getNursingProdHASU1());

			LtcYtdDirectCareHrs nursingLPNProdH = new LtcYtdDirectCareHrs();
			nursingLPNProdH.setDirCareProdHrsRegYtd(root.getNursingProdH_item12());
			nursingLPNProdH.setDirCareProdHrsOtYtd(root.getNursingProdH_item22());
			nursingLPNProdH.setDirCareProdHrsOrientationYtd(root.getNursingProdH_item32());
			nursingLPNProdH.setDirCareProdHrsContractedYtd(root.getNursingProdHCS2());
			nursingLPNProdH.setDirCareNonProdHrsVacYtd(root.getNursingNProdH_item12());
			nursingLPNProdH.setDirCareNonProdHrsSickYtd(root.getNursingNProdH_item22());
			nursingLPNProdH.setDirCareNonProdHrsOtherYtd(root.getNursingNProdH_item32());
			nursingLPNProdH.setConfirmationId(root.getForm().getConfirmationId());
			nursingLPNProdH.setDirCareType(root.getNursing_label());
			nursingLPNProdH.setDirCareName(root.getNursing_label2());
			nursingLPNProdH.setDirCareProdHrsSubtotalYtd(root.getNursingProdH_calc2());
			nursingLPNProdH.setDirCareProdHrsTotalYtd(root.getNursingProdH_sub2());
			nursingLPNProdH.setDirCareTotalHrsPaidYtd(root.getNursingNProdH_THP2());
			nursingLPNProdH.setDirCareNonProdHrsTotalYtd(root.getNursingNProdH_calc2());
			nursingLPNProdH.setDirCareProdHrsAgencyStuffUtilYtd(root.getNursingProdHASU2());


			
			LtcYtdDirectCareHrs nursingHCAProdH = new LtcYtdDirectCareHrs();
			nursingHCAProdH.setDirCareProdHrsRegYtd(root.getNursingProdH_item13());
			nursingHCAProdH.setDirCareProdHrsOtYtd(root.getNursingProdH_item23());
			nursingHCAProdH.setDirCareProdHrsOrientationYtd(root.getNursingProdH_item33());
			nursingHCAProdH.setDirCareProdHrsContractedYtd(root.getNursingProdHCS3());
			nursingHCAProdH.setDirCareNonProdHrsVacYtd(root.getNursingNProdH_item13());
			nursingHCAProdH.setDirCareNonProdHrsSickYtd(root.getNursingNProdH_item23());
			nursingHCAProdH.setDirCareNonProdHrsOtherYtd(root.getNursingNProdH_item33());
			nursingHCAProdH.setConfirmationId(root.getForm().getConfirmationId());
			nursingHCAProdH.setDirCareType(root.getNursing_label());
			nursingHCAProdH.setDirCareName(root.getNursing_label3());
			nursingHCAProdH.setDirCareProdHrsSubtotalYtd(root.getNursingProdH_calc3());
			nursingHCAProdH.setDirCareProdHrsTotalYtd(root.getNursingProdH_sub3());
			nursingHCAProdH.setDirCareTotalHrsPaidYtd(root.getNursingNProdH_THP3());
			nursingHCAProdH.setDirCareNonProdHrsTotalYtd(root.getNursingNProdH_calc3());
			nursingHCAProdH.setDirCareProdHrsAgencyStuffUtilYtd(root.getNursingProdHASU3());

			LtcYtdDirectCareHrs nursingOthProdH = new LtcYtdDirectCareHrs();
			nursingOthProdH.setDirCareProdHrsRegYtd(root.getNursingProdH_item14());
			nursingOthProdH.setDirCareProdHrsOtYtd(root.getNursingProdH_item24());
			nursingOthProdH.setDirCareProdHrsOrientationYtd(root.getNursingProdH_item34());
			nursingOthProdH.setDirCareProdHrsContractedYtd(root.getNursingProdHCS4());
			nursingOthProdH.setDirCareNonProdHrsVacYtd(root.getNursingNProdH_item14());
			nursingOthProdH.setDirCareNonProdHrsSickYtd(root.getNursingNProdH_item24());
			nursingOthProdH.setDirCareNonProdHrsOtherYtd(root.getNursingNProdH_item34());
			nursingOthProdH.setConfirmationId(root.getForm().getConfirmationId());
			nursingOthProdH.setDirCareType(root.getNursing_label());
			nursingOthProdH.setDirCareName(Constants.DC_HRS_OTHER);
			nursingOthProdH.setDirCareProdHrsSubtotalYtd(root.getNursingProdH_calc4());
			nursingOthProdH.setDirCareProdHrsTotalYtd(root.getNursingProdH_sub4());
			nursingOthProdH.setDirCareTotalHrsPaidYtd(root.getNursingNProdH_THP4());
			nursingOthProdH.setDirCareNonProdHrsTotalYtd(root.getNursingNProdH_calc4());
			nursingOthProdH.setDirCareOtherValue(root.getNursing_label4());
			nursingOthProdH.setDirCareProdHrsAgencyStuffUtilYtd(root.getNursingProdHASU4());

			// to check what is with the subtotal fields

			/* Productive and NP Allied Prof */
			LtcYtdDirectCareHrs alliedOTProfH = new LtcYtdDirectCareHrs();
			alliedOTProfH.setDirCareProdHrsRegYtd(root.getAlliedProfProdH_item11());
			alliedOTProfH.setDirCareProdHrsOtYtd(root.getAlliedProfProdH_item21());
			alliedOTProfH.setDirCareProdHrsOrientationYtd(root.getAlliedProfProdH_item31());
			alliedOTProfH.setDirCareProdHrsContractedYtd(root.getAlliedProfProdHCS1());
			alliedOTProfH.setDirCareNonProdHrsVacYtd(root.getAlliedProfNProdH_item11());
			alliedOTProfH.setDirCareNonProdHrsSickYtd(root.getAlliedProfNProdH_item21());
			alliedOTProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedProfNProdH_item31());
			alliedOTProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedOTProfH.setDirCareType(root.getAlliedProf_label());
			alliedOTProfH.setDirCareName(root.getAlliedProf_label1());
			alliedOTProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedProfProdH_calc1());
			alliedOTProfH.setDirCareProdHrsTotalYtd(root.getAlliedProfProdH_sub1());
			alliedOTProfH.setDirCareTotalHrsPaidYtd(root.getAlliedProfNProdH_THP1());
			alliedOTProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedProfNProdH_calc1());


			LtcYtdDirectCareHrs alliedPTProfH = new LtcYtdDirectCareHrs();
			alliedPTProfH.setDirCareProdHrsRegYtd(root.getAlliedProfProdH_item12());
			alliedPTProfH.setDirCareProdHrsOtYtd(root.getAlliedProfProdH_item22());
			alliedPTProfH.setDirCareProdHrsOrientationYtd(root.getAlliedProfProdH_item32());
			alliedPTProfH.setDirCareProdHrsContractedYtd(root.getAlliedProfProdHCS2());
			alliedPTProfH.setDirCareNonProdHrsVacYtd(root.getAlliedProfNProdH_item12());
			alliedPTProfH.setDirCareNonProdHrsSickYtd(root.getAlliedProfNProdH_item22());
			alliedPTProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedProfNProdH_item32());
			alliedPTProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedPTProfH.setDirCareType(root.getAlliedProf_label());
			alliedPTProfH.setDirCareName(root.getAlliedProf_label2());
			alliedPTProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedProfProdH_calc2());
			alliedPTProfH.setDirCareProdHrsTotalYtd(root.getAlliedProfProdH_sub2());
			alliedPTProfH.setDirCareTotalHrsPaidYtd(root.getAlliedProfNProdH_THP2());
			alliedPTProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedProfNProdH_calc2());

			LtcYtdDirectCareHrs alliedDTProfH = new LtcYtdDirectCareHrs();
			alliedDTProfH.setDirCareProdHrsRegYtd(root.getAlliedProfProdH_item13());
			alliedDTProfH.setDirCareProdHrsOtYtd(root.getAlliedProfProdH_item23());
			alliedDTProfH.setDirCareProdHrsOrientationYtd(root.getAlliedProfProdH_item33());
			alliedDTProfH.setDirCareProdHrsContractedYtd(root.getAlliedProfProdHCS3());
			alliedDTProfH.setDirCareNonProdHrsVacYtd(root.getAlliedProfNProdH_item13());
			alliedDTProfH.setDirCareNonProdHrsSickYtd(root.getAlliedProfNProdH_item23());
			alliedDTProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedProfNProdH_item33());
			alliedDTProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedDTProfH.setDirCareType(root.getAlliedProf_label());
			alliedDTProfH.setDirCareName(root.getAlliedProf_label3());
			alliedDTProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedProfProdH_calc3());
			alliedDTProfH.setDirCareProdHrsTotalYtd(root.getAlliedProfProdH_sub3());
			alliedDTProfH.setDirCareTotalHrsPaidYtd(root.getAlliedProfNProdH_THP3());
			alliedDTProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedProfNProdH_calc3());


			LtcYtdDirectCareHrs alliedSWProfH = new LtcYtdDirectCareHrs();
			alliedSWProfH.setDirCareProdHrsRegYtd(root.getAlliedProfProdH_item14());
			alliedSWProfH.setDirCareProdHrsOtYtd(root.getAlliedProfProdH_item24());
			alliedSWProfH.setDirCareProdHrsOrientationYtd(root.getAlliedProfProdH_item34());
			alliedSWProfH.setDirCareProdHrsContractedYtd(root.getAlliedProfProdHCS4());
			alliedSWProfH.setDirCareNonProdHrsVacYtd(root.getAlliedProfNProdH_item14());
			alliedSWProfH.setDirCareNonProdHrsSickYtd(root.getAlliedProfNProdH_item24());
			alliedSWProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedProfNProdH_item34());
			alliedSWProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedSWProfH.setDirCareType(root.getAlliedProf_label());
			alliedSWProfH.setDirCareName(root.getAlliedProf_label4());
			alliedSWProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedProfProdH_calc4());
			alliedSWProfH.setDirCareProdHrsTotalYtd(root.getAlliedProfProdH_sub4());
			alliedSWProfH.setDirCareTotalHrsPaidYtd(root.getAlliedProfNProdH_THP4());
			alliedSWProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedProfNProdH_calc4());

			LtcYtdDirectCareHrs alliedSLPProfH = new LtcYtdDirectCareHrs();
			alliedSLPProfH.setDirCareProdHrsRegYtd(root.getAlliedProfProdH_item15());
			alliedSLPProfH.setDirCareProdHrsOtYtd(root.getAlliedProfProdH_item25());
			alliedSLPProfH.setDirCareProdHrsOrientationYtd(root.getAlliedProfProdH_item35());
			alliedSLPProfH.setDirCareProdHrsContractedYtd(root.getAlliedProfProdHCS5());
			alliedSLPProfH.setDirCareNonProdHrsVacYtd(root.getAlliedProfNProdH_item15());
			alliedSLPProfH.setDirCareNonProdHrsSickYtd(root.getAlliedProfNProdH_item25());
			alliedSLPProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedProfNProdH_item35());
			alliedSLPProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedSLPProfH.setDirCareType(root.getAlliedProf_label());
			alliedSLPProfH.setDirCareName(root.getAlliedProf_label5());
			alliedSLPProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedProfProdH_calc5());
			alliedSLPProfH.setDirCareProdHrsTotalYtd(root.getAlliedProfProdH_sub5());
			alliedSLPProfH.setDirCareTotalHrsPaidYtd(root.getAlliedProfNProdH_THP5());
			alliedSLPProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedProfNProdH_calc5());

			LtcYtdDirectCareHrs alliedRTProfH = new LtcYtdDirectCareHrs();
			alliedRTProfH.setDirCareProdHrsRegYtd(root.getAlliedProfProdH_item16());
			alliedRTProfH.setDirCareProdHrsOtYtd(root.getAlliedProfProdH_item26());
			alliedRTProfH.setDirCareProdHrsOrientationYtd(root.getAlliedProfProdH_item36());
			alliedRTProfH.setDirCareProdHrsContractedYtd(root.getAlliedProfProdHCS6());
			alliedRTProfH.setDirCareNonProdHrsVacYtd(root.getAlliedProfNProdH_item16());
			alliedRTProfH.setDirCareNonProdHrsSickYtd(root.getAlliedProfNProdH_item26());
			alliedRTProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedProfNProdH_item36());
			alliedRTProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedRTProfH.setDirCareType(root.getAlliedProf_label());
			alliedRTProfH.setDirCareName(root.getAlliedProf_label6());
			alliedRTProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedProfProdH_calc6());
			alliedRTProfH.setDirCareProdHrsTotalYtd(root.getAlliedProfProdH_sub6());
			alliedRTProfH.setDirCareTotalHrsPaidYtd(root.getAlliedProfNProdH_THP6());
			alliedRTProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedProfNProdH_calc6());
			
			LtcYtdDirectCareHrs alliedOTHProfH = new LtcYtdDirectCareHrs();
			alliedOTHProfH.setDirCareProdHrsRegYtd(root.getAlliedProfProdH_item17());
			alliedOTHProfH.setDirCareProdHrsOtYtd(root.getAlliedProfProdH_item27());
			alliedOTHProfH.setDirCareProdHrsOrientationYtd(root.getAlliedProfProdH_item37());
			alliedOTHProfH.setDirCareProdHrsContractedYtd(root.getAlliedProfProdHCS7());
			alliedOTHProfH.setDirCareNonProdHrsVacYtd(root.getAlliedProfNProdH_item17());
			alliedOTHProfH.setDirCareNonProdHrsSickYtd(root.getAlliedProfNProdH_item27());
			alliedOTHProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedProfNProdH_item37());
			alliedOTHProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedOTHProfH.setDirCareType(root.getAlliedProf_label());
			alliedOTHProfH.setDirCareName(Constants.DC_HRS_OTHER);
			alliedOTHProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedProfProdH_calc7());
			alliedOTHProfH.setDirCareProdHrsTotalYtd(root.getAlliedProfProdH_sub7());
			alliedOTHProfH.setDirCareTotalHrsPaidYtd(root.getAlliedProfNProdH_THP7());
			alliedOTHProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedProfNProdH_calc7());
			alliedOTHProfH.setDirCareOtherValue(root.getAlliedProf_label7());

			/* Allied Non Professional */
			LtcYtdDirectCareHrs alliedNPRTProfH = new LtcYtdDirectCareHrs();
			alliedNPRTProfH.setDirCareProdHrsRegYtd(root.getAlliedNPProdH_item11());
			alliedNPRTProfH.setDirCareProdHrsOtYtd(root.getAlliedNPProdH_item21());
			alliedNPRTProfH.setDirCareProdHrsOrientationYtd(root.getAlliedNPProdH_item31());
			alliedNPRTProfH.setDirCareProdHrsContractedYtd(root.getAlliedNPProdHCS1());
			alliedNPRTProfH.setDirCareNonProdHrsVacYtd(root.getAlliedNPNProdH_item11());
			alliedNPRTProfH.setDirCareNonProdHrsSickYtd(root.getAlliedNPNProdH_item21());
			alliedNPRTProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedNPNProdH_item31());
			alliedNPRTProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRTProfH.setDirCareType(root.getAlliedNP_label());
			alliedNPRTProfH.setDirCareName(root.getAlliedNP_label1());
			alliedNPRTProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedNPProdH_calc1());
			alliedNPRTProfH.setDirCareProdHrsTotalYtd(root.getAlliedNPProdH_sub1());
			alliedNPRTProfH.setDirCareTotalHrsPaidYtd(root.getAlliedNPNProdH_THP1());
			alliedNPRTProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedNPNProdH_calc1());


			LtcYtdDirectCareHrs alliedNPRAProfH = new LtcYtdDirectCareHrs();
			alliedNPRAProfH.setDirCareProdHrsRegYtd(root.getAlliedNPProdH_item12());
			alliedNPRAProfH.setDirCareProdHrsOtYtd(root.getAlliedNPProdH_item22());
			alliedNPRAProfH.setDirCareProdHrsOrientationYtd(root.getAlliedNPProdH_item32());
			alliedNPRAProfH.setDirCareProdHrsContractedYtd(root.getAlliedNPProdHCS2());
			alliedNPRAProfH.setDirCareNonProdHrsVacYtd(root.getAlliedNPNProdH_item12());
			alliedNPRAProfH.setDirCareNonProdHrsSickYtd(root.getAlliedNPNProdH_item22());
			alliedNPRAProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedNPNProdH_item32());
			alliedNPRAProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRAProfH.setDirCareType(root.getAlliedNP_label());
			alliedNPRAProfH.setDirCareName(root.getAlliedNP_label2());
			alliedNPRAProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedNPProdH_calc2());
			alliedNPRAProfH.setDirCareProdHrsTotalYtd(root.getAlliedNPProdH_sub2());
			alliedNPRAProfH.setDirCareTotalHrsPaidYtd(root.getAlliedNPNProdH_THP2());
			alliedNPRAProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedNPNProdH_calc2());


			LtcYtdDirectCareHrs alliedNPAWProfH = new LtcYtdDirectCareHrs();
			alliedNPAWProfH.setDirCareProdHrsRegYtd(root.getAlliedNPProdH_item13());
			alliedNPAWProfH.setDirCareProdHrsOtYtd(root.getAlliedNPProdH_item23());
			alliedNPAWProfH.setDirCareProdHrsOrientationYtd(root.getAlliedNPProdH_item33());
			alliedNPAWProfH.setDirCareProdHrsContractedYtd(root.getAlliedNPProdHCS3());
			alliedNPAWProfH.setDirCareNonProdHrsVacYtd(root.getAlliedNPNProdH_item13());
			alliedNPAWProfH.setDirCareNonProdHrsSickYtd(root.getAlliedNPNProdH_item23());
			alliedNPAWProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedNPNProdH_item33());
			alliedNPAWProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPAWProfH.setDirCareType(root.getAlliedNP_label());
			alliedNPAWProfH.setDirCareName(root.getAlliedNP_label3());
			alliedNPAWProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedNPProdH_calc3());
			alliedNPAWProfH.setDirCareProdHrsTotalYtd(root.getAlliedNPProdH_sub3());
			alliedNPAWProfH.setDirCareTotalHrsPaidYtd(root.getAlliedNPNProdH_THP3());
			alliedNPAWProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedNPNProdH_calc3());


			LtcYtdDirectCareHrs alliedNPMTProfH = new LtcYtdDirectCareHrs();
			alliedNPMTProfH.setDirCareProdHrsRegYtd(root.getAlliedNPProdH_item14());
			alliedNPMTProfH.setDirCareProdHrsOtYtd(root.getAlliedNPProdH_item24());
			alliedNPMTProfH.setDirCareProdHrsOrientationYtd(root.getAlliedNPProdH_item34());
			alliedNPMTProfH.setDirCareProdHrsContractedYtd(root.getAlliedNPProdHCS4());
			alliedNPMTProfH.setDirCareNonProdHrsVacYtd(root.getAlliedNPNProdH_item14());
			alliedNPMTProfH.setDirCareNonProdHrsSickYtd(root.getAlliedNPNProdH_item24());
			alliedNPMTProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedNPNProdH_item34());
			alliedNPMTProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPMTProfH.setDirCareType(root.getAlliedNP_label());
			alliedNPMTProfH.setDirCareName(root.getAlliedNP_label4());
			alliedNPMTProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedNPProdH_calc4());
			alliedNPMTProfH.setDirCareProdHrsTotalYtd(root.getAlliedNPProdH_sub4());
			alliedNPMTProfH.setDirCareTotalHrsPaidYtd(root.getAlliedNPNProdH_THP4());
			alliedNPMTProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedNPNProdH_calc4());


			LtcYtdDirectCareHrs alliedNPATProfH = new LtcYtdDirectCareHrs();
			alliedNPATProfH.setDirCareProdHrsRegYtd(root.getAlliedNPProdH_item15());
			alliedNPATProfH.setDirCareProdHrsOtYtd(root.getAlliedNPProdH_item25());
			alliedNPATProfH.setDirCareProdHrsOrientationYtd(root.getAlliedNPProdH_item35());
			alliedNPATProfH.setDirCareProdHrsContractedYtd(root.getAlliedNPProdHCS5());
			alliedNPATProfH.setDirCareNonProdHrsVacYtd(root.getAlliedNPNProdH_item15());
			alliedNPATProfH.setDirCareNonProdHrsSickYtd(root.getAlliedNPNProdH_item25());
			alliedNPATProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedNPNProdH_item35());
			alliedNPATProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPATProfH.setDirCareType(root.getAlliedNP_label());
			alliedNPATProfH.setDirCareName(root.getAlliedNP_label5());
			alliedNPATProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedNPProdH_calc5());
			alliedNPATProfH.setDirCareProdHrsTotalYtd(root.getAlliedNPProdH_sub5());
			alliedNPATProfH.setDirCareTotalHrsPaidYtd(root.getAlliedNPNProdH_THP5());
			alliedNPATProfH.setDirCareNonProdHrsTotalYtd(root.getAlliedNPNProdH_calc5());

			LtcYtdDirectCareHrs alliedNPOTHProfH = new LtcYtdDirectCareHrs();
			alliedNPOTHProfH.setDirCareProdHrsRegYtd(root.getAlliedNPProdH_item16());
			alliedNPOTHProfH.setDirCareProdHrsOtYtd(root.getAlliedNPProdH_item26());
			alliedNPOTHProfH.setDirCareProdHrsOrientationYtd(root.getAlliedNPProdH_item36());
			alliedNPOTHProfH.setDirCareProdHrsContractedYtd(root.getAlliedNPProdHCS6());
			alliedNPOTHProfH.setDirCareNonProdHrsVacYtd(root.getAlliedNPNProdH_item16());
			alliedNPOTHProfH.setDirCareNonProdHrsSickYtd(root.getAlliedNPNProdH_item26());
			alliedNPOTHProfH.setDirCareNonProdHrsOtherYtd(root.getAlliedNPNProdH_item36());
			alliedNPOTHProfH.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPOTHProfH.setDirCareType(root.getAlliedNP_label());
			alliedNPOTHProfH.setDirCareName(Constants.DC_HRS_OTHER);
			alliedNPOTHProfH.setDirCareProdHrsSubtotalYtd(root.getAlliedNPProdH_calc6());
			alliedNPOTHProfH.setDirCareProdHrsTotalYtd(root.getAlliedNPProdH_sub6());
			alliedNPOTHProfH.setDirCareTotalHrsPaidYtd(root.getAlliedNPNProdH_THP6());
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
			nursingDirCareHrsSubTotal.setSubTotalDirCareProdHrsOrientationYTD(root.getNursingProdH_sum31());
			nursingDirCareHrsSubTotal.setSubTotalDirCareProdHrsSubtotalYTD(root.getNursingProdH_calcsum1());
			nursingDirCareHrsSubTotal.setSubTotalDirCareProdHrsContServYTD(root.getNursingProdHCS_subsum1());
			nursingDirCareHrsSubTotal.setSubTotalDirCareProdHrsTotalYTD(root.getNursingProdH_subsum1());
			nursingDirCareHrsSubTotal.setSubTotalDirCareTotalHrsPaidYTD(root.getNursingNProdH_THPsum1());
			nursingDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsVacYTD(root.getNursingNProdH_sum11());
			nursingDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsSickYTD(root.getNursingNProdH_sum21());
			nursingDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsOtherServYTD(root.getNursingNProdH_sum31());
			nursingDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsTotalYTD(root.getNursingNProdH_calcsum1());
			nursingDirCareHrsSubTotal.setConfirmationID(root.getForm().getConfirmationId());
			nursingDirCareHrsSubTotal.setSubTotalDirCareProdHrsAgencyStaffUtil(root.getNursingProdHASU_subsum());
			

			LtcYtdDirectCareHrsSubTotals alliedDirCareHrsSubTotal = new LtcYtdDirectCareHrsSubTotals();
			alliedDirCareHrsSubTotal.setDirCareType(root.getAlliedProf_label());
			alliedDirCareHrsSubTotal.setSubTotalDirCareProdHrsRegularYTD(root.getAlliedProfProdH_sum11());
			alliedDirCareHrsSubTotal.setSubTotalDirCareProdHrsOTYTD(root.getAlliedProfProdH_sum21());
			alliedDirCareHrsSubTotal.setSubTotalDirCareProdHrsOrientationYTD(root.getAlliedProfProdH_sum31());
			alliedDirCareHrsSubTotal.setSubTotalDirCareProdHrsSubtotalYTD(root.getAlliedProfProdH_calcsum1());
			alliedDirCareHrsSubTotal.setSubTotalDirCareProdHrsContServYTD(root.getAlliedProfProdHCS_subsum1());
			alliedDirCareHrsSubTotal.setSubTotalDirCareProdHrsTotalYTD(root.getAlliedProfProdH_subsum1());
			alliedDirCareHrsSubTotal.setSubTotalDirCareTotalHrsPaidYTD(root.getAlliedProfNProdH_THPsum1());
			alliedDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsVacYTD(root.getAlliedProfNProdH_sum11());
			alliedDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsSickYTD(root.getAlliedNProdH_sum21());
			alliedDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsOtherServYTD(root.getAlliedProfNProdH_sum31());
			alliedDirCareHrsSubTotal.setSubTotalDirCareNonProdHrsTotalYTD(root.getAlliedProfNProdH_calcsum1());
			alliedDirCareHrsSubTotal.setConfirmationID(root.getForm().getConfirmationId());

			LtcYtdDirectCareHrsSubTotals alliedNPDirCareHrsSubTotal = new LtcYtdDirectCareHrsSubTotals();
			alliedNPDirCareHrsSubTotal.setDirCareType(root.getAlliedNP_label());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareProdHrsRegularYTD(root.getAlliedNPProdH_sum11());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareProdHrsOTYTD(root.getAlliedNPProdH_sum21());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareProdHrsOrientationYTD(root.getAlliedNPProdH_sum31());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareProdHrsSubtotalYTD(root.getAlliedNPProdH_calcsum1());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareProdHrsContServYTD(root.getAlliedNPProdHCS_subsum1());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareProdHrsTotalYTD(root.getAlliedNPProdH_subsum1());
			alliedNPDirCareHrsSubTotal.setSubTotalDirCareTotalHrsPaidYTD(root.getAlliedNPNProdH_THPsum1());
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
			nursingRNProdC.setDirCareCostProdHrsOrientationYtd(root.getNursingProdC_item31());
			nursingRNProdC.setDirCareCostProdHrsContractedYtd(root.getNursingProdCCS1());
			nursingRNProdC.setDirCareCostNonProdHrsVacYtd(root.getNursingNProdC_item11());
			nursingRNProdC.setDirCareCostNonProdHrsSickYtd(root.getNursingNProdC_item21());
			nursingRNProdC.setDirCareCostNonProdHrsOtherYtd(root.getNursingNProdC_item31());
			nursingRNProdC.setConfirmationId(root.getForm().getConfirmationId());
			nursingRNProdC.setDirCareCostType(root.getNursing_label());
			nursingRNProdC.setDirCareCostName(root.getNursing_label1());
			nursingRNProdC.setDirCareCostProdHrsSubtotalYtd(root.getNursingProdC_calc1());
			nursingRNProdC.setDirCareCostProdHrsTotalYtd(root.getNursingProdC_sub1());
			nursingRNProdC.setDirCareCostTotalHrsPaidYtd(root.getNursingCost1());
			nursingRNProdC.setDirCareCostNonProdHrsTotalYtd(root.getNursingNProdC_calc1());
			nursingRNProdC.setDirCareCostHourlyRateStaffYtd(root.getNursingStaffRate1());
			nursingRNProdC.setDirCareCostHourlyRateContractedYtd(root.getNursingContractRate1());
			nursingRNProdC.setDirCareCostProdHrsAgencyStaffUtil(root.getNursingProdCASU1());
			/* END : Direct Care Cost */

			LtcYtdDirectCareCost nursingLPNProdC = new LtcYtdDirectCareCost();
			nursingLPNProdC.setDirCareCostProdHrsRegYtd(root.getNursingProdC_item12());
			nursingLPNProdC.setDirCareCostProdHrsOtYtd(root.getNursingProdC_item22());
			nursingLPNProdC.setDirCareCostProdHrsOrientationYtd(root.getNursingProdC_item32());
			nursingLPNProdC.setDirCareCostProdHrsContractedYtd(root.getNursingProdCCS2());
			nursingLPNProdC.setDirCareCostNonProdHrsVacYtd(root.getNursingNProdC_item12());
			nursingLPNProdC.setDirCareCostNonProdHrsSickYtd(root.getNursingNProdC_item22());
			nursingLPNProdC.setDirCareCostNonProdHrsOtherYtd(root.getNursingNProdC_item32());
			nursingLPNProdC.setConfirmationId(root.getForm().getConfirmationId());
			nursingLPNProdC.setDirCareCostType(root.getNursing_label());
			nursingLPNProdC.setDirCareCostName(root.getNursing_label2());
			nursingLPNProdC.setDirCareCostProdHrsSubtotalYtd(root.getNursingProdC_calc2());
			nursingLPNProdC.setDirCareCostProdHrsTotalYtd(root.getNursingProdC_sub2());
			nursingLPNProdC.setDirCareCostTotalHrsPaidYtd(root.getNursingCost2());
			nursingLPNProdC.setDirCareCostNonProdHrsTotalYtd(root.getNursingNProdC_calc2());
			nursingLPNProdC.setDirCareCostHourlyRateStaffYtd(root.getNursingStaffRate2());
			nursingLPNProdC.setDirCareCostHourlyRateContractedYtd(root.getNursingContractRate2());
			nursingLPNProdC.setDirCareCostProdHrsAgencyStaffUtil(root.getNursingProdCASU2());



			LtcYtdDirectCareCost nursingHCAProdC = new LtcYtdDirectCareCost();
			nursingHCAProdC.setDirCareCostProdHrsRegYtd(root.getNursingProdC_item13());
			nursingHCAProdC.setDirCareCostProdHrsOtYtd(root.getNursingProdC_item23());
			nursingHCAProdC.setDirCareCostProdHrsOrientationYtd(root.getNursingProdC_item33());
			nursingHCAProdC.setDirCareCostProdHrsContractedYtd(root.getNursingProdCCS3());
			nursingHCAProdC.setDirCareCostNonProdHrsVacYtd(root.getNursingNProdC_item13());
			nursingHCAProdC.setDirCareCostNonProdHrsSickYtd(root.getNursingNProdC_item23());
			nursingHCAProdC.setDirCareCostNonProdHrsOtherYtd(root.getNursingNProdC_item33());
			nursingHCAProdC.setConfirmationId(root.getForm().getConfirmationId());
			nursingHCAProdC.setDirCareCostType(root.getNursing_label());
			nursingHCAProdC.setDirCareCostName(root.getNursing_label3());
			nursingHCAProdC.setDirCareCostProdHrsSubtotalYtd(root.getNursingProdC_calc3());
			nursingHCAProdC.setDirCareCostProdHrsTotalYtd(root.getNursingProdC_sub3());
			nursingHCAProdC.setDirCareCostTotalHrsPaidYtd(root.getNursingCost3());
			nursingHCAProdC.setDirCareCostNonProdHrsTotalYtd(root.getNursingNProdC_calc3());
			nursingHCAProdC.setDirCareCostHourlyRateStaffYtd(root.getNursingStaffRate3());
			nursingHCAProdC.setDirCareCostHourlyRateContractedYtd(root.getNursingContractRate3());
			nursingHCAProdC.setDirCareCostProdHrsAgencyStaffUtil(root.getNursingProdCASU3());


			LtcYtdDirectCareCost nursingOthProdC = new LtcYtdDirectCareCost();
			nursingOthProdC.setDirCareCostProdHrsRegYtd(root.getNursingProdC_item14());
			nursingOthProdC.setDirCareCostProdHrsOtYtd(root.getNursingProdC_item24());
			nursingOthProdC.setDirCareCostProdHrsOrientationYtd(root.getNursingProdC_item34());
			nursingOthProdC.setDirCareCostProdHrsContractedYtd(root.getNursingProdCCS4());
			nursingOthProdC.setDirCareCostNonProdHrsVacYtd(root.getNursingNProdC_item14());
			nursingOthProdC.setDirCareCostNonProdHrsSickYtd(root.getNursingNProdC_item24());
			nursingOthProdC.setDirCareCostNonProdHrsOtherYtd(root.getNursingNProdC_item34());
			nursingOthProdC.setConfirmationId(root.getForm().getConfirmationId());
			nursingOthProdC.setDirCareCostType(root.getNursing_label());
			nursingOthProdC.setDirCareCostName(Constants.DC_HRS_OTHER);
			nursingOthProdC.setDirCareCostProdHrsSubtotalYtd(root.getNursingProdC_calc4());
			nursingOthProdC.setDirCareCostProdHrsTotalYtd(root.getNursingProdC_sub4());
			nursingOthProdC.setDirCareCostTotalHrsPaidYtd(root.getNursingCost4());
			nursingOthProdC.setDirCareCostNonProdHrsTotalYtd(root.getNursingNProdC_calc4());
			nursingOthProdC.setDirCareCostHourlyRateStaffYtd(root.getNursingStaffRate4());
			nursingOthProdC.setDirCareCostHourlyRateContractedYtd(root.getNursingContractRate4());
			nursingOthProdC.setDirCareOtherValue(root.getNursing_label4());
			nursingOthProdC.setDirCareCostProdHrsAgencyStaffUtil(root.getNursingProdCASU4());




			// Allied Prof
			LtcYtdDirectCareCost alliedOTProfC = new LtcYtdDirectCareCost();
			alliedOTProfC.setDirCareCostProdHrsRegYtd(root.getAlliedProfProdC_item11());
			alliedOTProfC.setDirCareCostProdHrsOtYtd(root.getAlliedProfProdC_item21());
			alliedOTProfC.setDirCareCostProdHrsOrientationYtd(root.getAlliedProfProdC_item31());
			alliedOTProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedProfProdCCS1());
			alliedOTProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedProfNProdC_item11());
			alliedOTProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedProfNProdC_item21());
			alliedOTProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedProfNProdC_item31());
			alliedOTProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedOTProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedOTProfC.setDirCareCostName(root.getAlliedProf_label1());
			alliedOTProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedProfProdC_calc1());
			alliedOTProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedProfProdC_sub1());
			alliedOTProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedProfCost1());
			alliedOTProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedProfNProdC_calc1());
			alliedOTProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedProfStaffRate1());
			alliedOTProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedProfContractRate1());


			LtcYtdDirectCareCost alliedPTProfC = new LtcYtdDirectCareCost();
			alliedPTProfC.setDirCareCostProdHrsRegYtd(root.getAlliedProfProdC_item12());
			alliedPTProfC.setDirCareCostProdHrsOtYtd(root.getAlliedProfProdC_item22());
			alliedPTProfC.setDirCareCostProdHrsOrientationYtd(root.getAlliedProfProdC_item32());
			alliedPTProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedProfProdCCS2());
			alliedPTProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedProfNProdC_item12());
			alliedPTProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedProfNProdC_item22());
			alliedPTProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedProfNProdC_item32());
			alliedPTProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedPTProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedPTProfC.setDirCareCostName(root.getAlliedProf_label2());
			alliedPTProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedProfProdC_calc2());
			alliedPTProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedProfProdC_sub2());
			alliedPTProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedProfCost2());
			alliedPTProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedProfNProdC_calc2());
			alliedPTProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedProfStaffRate2());
			alliedPTProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedProfContractRate2());



			LtcYtdDirectCareCost alliedDTProfC = new LtcYtdDirectCareCost();
			alliedDTProfC.setDirCareCostProdHrsRegYtd(root.getAlliedProfProdC_item13());
			alliedDTProfC.setDirCareCostProdHrsOtYtd(root.getAlliedProfProdC_item23());
			alliedDTProfC.setDirCareCostProdHrsOrientationYtd(root.getAlliedProfProdC_item33());
			alliedDTProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedProfProdCCS3());
			alliedDTProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedProfNProdC_item13());
			alliedDTProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedProfNProdC_item23());
			alliedDTProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedProfNProdC_item33());
			alliedDTProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedDTProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedDTProfC.setDirCareCostName(root.getAlliedProf_label3());
			alliedDTProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedProfProdC_calc3());
			alliedDTProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedProfProdC_sub3());
			alliedDTProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedProfCost3());
			alliedDTProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedProfNProdC_calc3());
			alliedDTProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedProfStaffRate3());
			alliedDTProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedProfContractRate3());



			LtcYtdDirectCareCost alliedSWProfC = new LtcYtdDirectCareCost();
			alliedSWProfC.setDirCareCostProdHrsRegYtd(root.getAlliedProfProdC_item14());
			alliedSWProfC.setDirCareCostProdHrsOtYtd(root.getAlliedProfProdC_item24());
			alliedSWProfC.setDirCareCostProdHrsOrientationYtd(root.getAlliedProfProdC_item34());
			alliedSWProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedProfProdCCS4());
			alliedSWProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedProfNProdC_item14());
			alliedSWProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedProfNProdC_item24());
			alliedSWProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedProfNProdC_item34());
			alliedSWProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedSWProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedSWProfC.setDirCareCostName(root.getAlliedProf_label4());
			alliedSWProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedProfProdC_calc4());
			alliedSWProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedProfProdC_sub4());
			alliedSWProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedProfCost4());
			alliedSWProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedProfNProdC_calc4());
			alliedSWProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedProfStaffRate4());
			alliedSWProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedProfContractRate4());

			LtcYtdDirectCareCost alliedSLPProfC = new LtcYtdDirectCareCost();
			alliedSLPProfC.setDirCareCostProdHrsRegYtd(root.getAlliedProfProdC_item15());
			alliedSLPProfC.setDirCareCostProdHrsOtYtd(root.getAlliedProfProdC_item25());
			alliedSLPProfC.setDirCareCostProdHrsOrientationYtd(root.getAlliedProfProdC_item35());
			alliedSLPProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedProfProdCCS5());
			alliedSLPProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedProfNProdC_item15());
			alliedSLPProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedProfNProdC_item25());
			alliedSLPProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedProfNProdC_item35());
			alliedSLPProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedSLPProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedSLPProfC.setDirCareCostName(root.getAlliedProf_label5());
			alliedSLPProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedProfProdC_calc5());
			alliedSLPProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedProfProdC_sub5());
			alliedSLPProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedProfCost5());
			alliedSLPProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedProfNProdC_calc5());
			alliedSLPProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedProfStaffRate5());
			alliedSLPProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedProfContractRate5());

			LtcYtdDirectCareCost alliedRTProfC = new LtcYtdDirectCareCost();
			alliedRTProfC.setDirCareCostProdHrsRegYtd(root.getAlliedProfProdC_item16());
			alliedRTProfC.setDirCareCostProdHrsOtYtd(root.getAlliedProfProdC_item26());
			alliedRTProfC.setDirCareCostProdHrsOrientationYtd(root.getAlliedProfProdC_item36());
			alliedRTProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedProfProdCCS6());
			alliedRTProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedProfNProdC_item16());
			alliedRTProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedProfNProdC_item26());
			alliedRTProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedProfNProdC_item36());
			alliedRTProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedRTProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedRTProfC.setDirCareCostName(root.getAlliedProf_label6());
			alliedRTProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedProfProdC_calc6());
			alliedRTProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedProfProdC_sub6());
			alliedRTProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedProfCost6());
			alliedRTProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedProfNProdC_calc6());
			alliedRTProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedProfStaffRate6());
			alliedRTProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedProfContractRate6());

			LtcYtdDirectCareCost alliedOTHProfC = new LtcYtdDirectCareCost();
			alliedOTHProfC.setDirCareCostProdHrsRegYtd(root.getAlliedProfProdC_item17());
			alliedOTHProfC.setDirCareCostProdHrsOtYtd(root.getAlliedProfProdC_item27());
			alliedOTHProfC.setDirCareCostProdHrsOrientationYtd(root.getAlliedProfProdC_item37());
			alliedOTHProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedProfProdCCS7());
			alliedOTHProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedProfNProdC_item17());
			alliedOTHProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedProfNProdC_item27());
			alliedOTHProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedProfNProdC_item37());
			alliedOTHProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedOTHProfC.setDirCareCostType(root.getAlliedProf_label());
			alliedOTHProfC.setDirCareCostName(Constants.DC_HRS_OTHER);
			alliedOTHProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedProfProdC_calc7());
			alliedOTHProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedProfProdC_sub7());
			alliedOTHProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedProfCost7());
			alliedOTHProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedProfNProdC_calc7());
			alliedOTHProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedProfStaffRate7());
			alliedOTHProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedProfContractRate7());
			alliedOTHProfC.setDirCareOtherValue(root.getAlliedProf_label7());


			// Allied Non Professional
			LtcYtdDirectCareCost alliedNPRTProfC = new LtcYtdDirectCareCost();
			alliedNPRTProfC.setDirCareCostProdHrsRegYtd(root.getAlliedNPProdC_item11());
			alliedNPRTProfC.setDirCareCostProdHrsOtYtd(root.getAlliedNPProdC_item21());
			alliedNPRTProfC.setDirCareCostProdHrsOrientationYtd(root.getAlliedNPProdC_item31());
			alliedNPRTProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedNPProdCCS1());
			alliedNPRTProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedNPNProdC_item11());
			alliedNPRTProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedNPProdC_item21());
			alliedNPRTProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedNPNProdC_item31());
			alliedNPRTProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRTProfC.setDirCareCostType(root.getAlliedNP_label());
			alliedNPRTProfC.setDirCareCostName(root.getAlliedNP_label1());
			alliedNPRTProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedNPProdC_calc1());
			alliedNPRTProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedNPProdC_sub1());
			alliedNPRTProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedNPCost1());
			alliedNPRTProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedNPNProdC_calc1());
			alliedNPRTProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedNPStaffRate1());
			alliedNPRTProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedNPContractRate1());


			LtcYtdDirectCareCost alliedNPRAProfC = new LtcYtdDirectCareCost();
			alliedNPRAProfC.setDirCareCostProdHrsRegYtd(root.getAlliedNPProdC_item12());
			alliedNPRAProfC.setDirCareCostProdHrsOtYtd(root.getAlliedNPProdC_item22());
			alliedNPRAProfC.setDirCareCostProdHrsOrientationYtd(root.getAlliedNPProdC_item32());
			alliedNPRAProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedNPProdCCS2());
			alliedNPRAProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedNPNProdC_item12());
			alliedNPRAProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedNPProdC_item22());
			alliedNPRAProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedNPNProdC_item32());
			alliedNPRAProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRAProfC.setDirCareCostType(root.getAlliedNP_label());
			alliedNPRAProfC.setDirCareCostName(root.getAlliedNP_label2());
			alliedNPRAProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedNPProdC_calc2());
			alliedNPRAProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedNPProdC_sub2());
			alliedNPRAProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedNPCost2());
			alliedNPRAProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedNPNProdC_calc2());
			alliedNPRAProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedNPStaffRate2());
			alliedNPRAProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedNPContractRate2());



			LtcYtdDirectCareCost alliedNPAWProfC = new LtcYtdDirectCareCost();
			alliedNPAWProfC.setDirCareCostProdHrsRegYtd(root.getAlliedNPProdC_item13());
			alliedNPAWProfC.setDirCareCostProdHrsOtYtd(root.getAlliedNPProdC_item23());
			alliedNPAWProfC.setDirCareCostProdHrsOrientationYtd(root.getAlliedNPProdC_item33());
			alliedNPAWProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedNPProdCCS3());
			alliedNPAWProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedNPNProdC_item13());
			alliedNPAWProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedNPProdC_item23());
			alliedNPAWProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedNPNProdC_item33());
			alliedNPAWProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPAWProfC.setDirCareCostType(root.getAlliedNP_label());
			alliedNPAWProfC.setDirCareCostName(root.getAlliedNP_label3());
			alliedNPAWProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedNPProdC_calc3());
			alliedNPAWProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedNPProdC_sub3());
			alliedNPAWProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedNPCost3());
			alliedNPAWProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedNPNProdC_calc3());
			alliedNPAWProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedNPStaffRate3());
			alliedNPAWProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedNPContractRate3());



			LtcYtdDirectCareCost alliedNPMTProfC = new LtcYtdDirectCareCost();
			alliedNPMTProfC.setDirCareCostProdHrsRegYtd(root.getAlliedNPProdC_item14());
			alliedNPMTProfC.setDirCareCostProdHrsOtYtd(root.getAlliedNPProdC_item24());
			alliedNPMTProfC.setDirCareCostProdHrsOrientationYtd(root.getAlliedNPProdC_item34());
			alliedNPMTProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedNPProdCCS4());
			alliedNPMTProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedNPNProdC_item14());
			alliedNPMTProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedNPProdC_item24());
			alliedNPMTProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedNPNProdC_item34());
			alliedNPMTProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPMTProfC.setDirCareCostType(root.getAlliedNP_label());
			alliedNPMTProfC.setDirCareCostName(root.getAlliedNP_label4());
			alliedNPMTProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedNPProdC_calc4());
			alliedNPMTProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedNPProdC_sub4());
			alliedNPMTProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedNPCost4());
			alliedNPMTProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedNPNProdC_calc4());
			alliedNPMTProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedNPStaffRate4());
			alliedNPMTProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedNPContractRate4());



			LtcYtdDirectCareCost alliedNPATProfC = new LtcYtdDirectCareCost();
			alliedNPATProfC.setDirCareCostProdHrsRegYtd(root.getAlliedNPProdC_item15());
			alliedNPATProfC.setDirCareCostProdHrsOtYtd(root.getAlliedNPProdC_item25());
			alliedNPATProfC.setDirCareCostProdHrsOrientationYtd(root.getAlliedNPProdC_item35());
			alliedNPATProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedNPProdCCS5());
			alliedNPATProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedNPNProdC_item15());
			alliedNPATProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedNPProdC_item25());
			alliedNPATProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedNPNProdC_item35());
			alliedNPATProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPATProfC.setDirCareCostType(root.getAlliedNP_label());
			alliedNPATProfC.setDirCareCostName(root.getAlliedNP_label5());
			alliedNPATProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedNPProdC_calc5());
			alliedNPATProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedNPProdC_sub5());
			alliedNPATProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedNPCost5());
			alliedNPATProfC.setDirCareCostNonProdHrsTotalYtd(root.getAlliedNPNProdC_calc5());
			alliedNPATProfC.setDirCareCostHourlyRateStaffYtd(root.getAlliedNPStaffRate5());
			alliedNPATProfC.setDirCareCostHourlyRateContractedYtd(root.getAlliedNPContractRate5());


			
			LtcYtdDirectCareCost alliedNPOTHProfC = new LtcYtdDirectCareCost();
			alliedNPOTHProfC.setDirCareCostProdHrsRegYtd(root.getAlliedNPProdC_item16());
			alliedNPOTHProfC.setDirCareCostProdHrsOtYtd(root.getAlliedNPProdC_item26());
			alliedNPOTHProfC.setDirCareCostProdHrsOrientationYtd(root.getAlliedNPProdC_item36());
			alliedNPOTHProfC.setDirCareCostProdHrsContractedYtd(root.getAlliedNPProdCCS6());
			alliedNPOTHProfC.setDirCareCostNonProdHrsVacYtd(root.getAlliedNPNProdC_item16());
			alliedNPOTHProfC.setDirCareCostNonProdHrsSickYtd(root.getAlliedNPProdC_item26());
			alliedNPOTHProfC.setDirCareCostNonProdHrsOtherYtd(root.getAlliedNPNProdC_item36());
			alliedNPOTHProfC.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPOTHProfC.setDirCareCostType(root.getAlliedNP_label());
			alliedNPOTHProfC.setDirCareCostName(Constants.DC_HRS_OTHER);
			alliedNPOTHProfC.setDirCareCostProdHrsSubtotalYtd(root.getAlliedNPProdC_calc6());
			alliedNPOTHProfC.setDirCareCostProdHrsTotalYtd(root.getAlliedNPProdC_sub6());
			alliedNPOTHProfC.setDirCareCostTotalHrsPaidYtd(root.getAlliedNPCost6());
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
			nursingCareCostSubtotals.setSubTotalDirCareCostProdHrsOrientationYTD(root.getNursingProdC_sum31());
			nursingCareCostSubtotals.setSubTotalDirCareCostProdHrsSubtotalYTD(root.getNursingProdC_calcsum1());
			nursingCareCostSubtotals.setSubTotalDirCareCostProdHrsContServYTD(root.getNursingProdCCS_subsum1());
			nursingCareCostSubtotals.setSubTotalDirCareCostProdHrsTotalYTD(root.getNursingProdC_subsum1());
			nursingCareCostSubtotals.setSubTotalDirCareCostTotalHrsPaidYTD(root.getNursingCost_total());
			nursingCareCostSubtotals.setSubTotalDirCareCostNonProdHrsVacYTD(root.getNursingNProdC_sum11());
			nursingCareCostSubtotals.setSubTotalDirCareCostNonProdHrsSickYTD(root.getNursingNProdC_sum21());
			nursingCareCostSubtotals.setSubTotalDirCareCostNonProdHrsOtherServYTD(root.getNursingNProdC_sum31());
			nursingCareCostSubtotals.setSubTotalDirCareCostNonProdHrsTotalYTD(root.getNursingNProdC_calcsum1());
			nursingCareCostSubtotals.setSubTotalDirCareCostHourlyRateStaffYTD(root.getNursingStaffRate_total());
			nursingCareCostSubtotals.setSubTotalDirCareCostHourlyRateContractedYTD(root.getNursingContractRate_total());
			nursingCareCostSubtotals.setSubTotalDirCareCostProdHrsAgencyStaffUtil(root.getNursingProdCASU_subsum());

			LtcYtdDirectCareCostSubtotals alliedCareCostSubtotals = new LtcYtdDirectCareCostSubtotals();
			alliedCareCostSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			alliedCareCostSubtotals.setDirCareType(root.getAlliedProf_label());
			alliedCareCostSubtotals.setSubTotalDirCareCostProdHrsRegularYTD(root.getAlliedProfProdC_sum11());
			alliedCareCostSubtotals.setSubTotalDirCareCostProdHrsOTYTD(root.getAlliedProfProdC_sum21());
			alliedCareCostSubtotals.setSubTotalDirCareCostProdHrsOrientationYTD(root.getAlliedProfProdC_sum31());
			alliedCareCostSubtotals.setSubTotalDirCareCostProdHrsSubtotalYTD(root.getAlliedProfProdC_calcsum1());
			alliedCareCostSubtotals.setSubTotalDirCareCostProdHrsContServYTD(root.getAlliedProfProdCCS_subsum1());
			alliedCareCostSubtotals.setSubTotalDirCareCostProdHrsTotalYTD(root.getAlliedProfProdC_subsum1());
			alliedCareCostSubtotals.setSubTotalDirCareCostTotalHrsPaidYTD(root.getAlliedProfCost_total());
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
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostProdHrsOrientationYTD(root.getAlliedNPProdC_sum31());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostProdHrsSubtotalYTD(root.getAlliedNPProdC_calcsum1());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostProdHrsContServYTD(root.getAlliedNPProdCCS_subsum1());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostProdHrsTotalYTD(root.getAlliedNPProdC_subsum1());
			alliedNProfCareCostSubtotals.setSubTotalDirCareCostTotalHrsPaidYTD(root.getAlliedNPCost_total());
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
			supportFoodServices.setCompSalStaffYtd(root.getSupportC_item11());
			supportFoodServices.setCompSalContractServicesYtd(root.getSupportC_item21());
			supportFoodServices.setCompSalName(root.getSupport_label1());
			supportFoodServices.setCompSalType(root.getSupport_label());
			supportFoodServices.setConfirmationId(root.getForm().getConfirmationId());
			supportFoodServices.setCompSalTotalCostYtd(root.getSupportC_calc1());
			
			LtcYtdCompSal supportLaundryServices = new LtcYtdCompSal();
			supportLaundryServices.setCompSalStaffYtd(root.getSupportC_item12());
			supportLaundryServices.setCompSalContractServicesYtd(root.getSupportC_item22());
			supportLaundryServices.setCompSalName(root.getSupport_label2());
			supportLaundryServices.setCompSalType(root.getSupport_label());
			supportLaundryServices.setConfirmationId(root.getForm().getConfirmationId());
			supportLaundryServices.setCompSalTotalCostYtd(root.getSupportC_calc2());

			LtcYtdCompSal supportHousekeeping = new LtcYtdCompSal();
			supportHousekeeping.setCompSalStaffYtd(root.getSupportC_item13());
			supportHousekeeping.setCompSalContractServicesYtd(root.getSupportC_item23());
			supportHousekeeping.setCompSalName(root.getSupport_label3());
			supportHousekeeping.setCompSalType(root.getSupport_label());
			supportHousekeeping.setConfirmationId(root.getForm().getConfirmationId());
			supportHousekeeping.setCompSalTotalCostYtd(root.getSupportC_calc3());

			LtcYtdCompSal supportPlantMntnce = new LtcYtdCompSal();
			supportPlantMntnce.setCompSalStaffYtd(root.getSupportC_item14());
			supportPlantMntnce.setCompSalContractServicesYtd(root.getSupportC_item24());
			supportPlantMntnce.setCompSalName(root.getSupport_label4());
			supportPlantMntnce.setCompSalType(root.getSupport_label());
			supportPlantMntnce.setConfirmationId(root.getForm().getConfirmationId());
			supportPlantMntnce.setCompSalTotalCostYtd(root.getSupportC_calc4());

			if(root.getSupport_label5() != null) {
				LtcYtdCompSal supportPharmacyServices = new LtcYtdCompSal();
				supportPharmacyServices.setConfirmationId(root.getForm().getConfirmationId());
				supportPharmacyServices.setCompSalType(root.getSupport_label());
				supportPharmacyServices.setCompSalName(root.getSupport_label5());
				supportPharmacyServices.setCompSalStaffYtd(root.getSupportC_item15());
				supportPharmacyServices.setCompSalContractServicesYtd(root.getSupportC_item25());
				supportPharmacyServices.setCompSalTotalCostYtd(root.getSupportC_calc5());

				Collections.addAll(ltcYtdCompSal, supportPharmacyServices);			
			}

			// Administration

			LtcYtdCompSal adminAdministrator = new LtcYtdCompSal();
			adminAdministrator.setCompSalStaffYtd(root.getAdminC_item11());
			adminAdministrator.setCompSalContractServicesYtd(root.getAdminC_item21());
			adminAdministrator.setCompSalName(root.getAdmin_label1());
			adminAdministrator.setCompSalType(root.getAdmin_label());
			adminAdministrator.setConfirmationId(root.getForm().getConfirmationId());
			adminAdministrator.setCompSalTotalCostYtd(root.getAdminC_calc1());

			LtcYtdCompSal adminDirOfCare = new LtcYtdCompSal();
			adminDirOfCare.setCompSalStaffYtd(root.getAdminC_item12());
			adminDirOfCare.setCompSalContractServicesYtd(root.getAdminC_item22());
			adminDirOfCare.setCompSalName(root.getAdmin_label2());
			adminDirOfCare.setCompSalType(root.getAdmin_label());
			adminDirOfCare.setConfirmationId(root.getForm().getConfirmationId());
			adminDirOfCare.setCompSalTotalCostYtd(root.getAdminC_calc2());

			LtcYtdCompSal adminDeptManagers = new LtcYtdCompSal();
			adminDeptManagers.setCompSalStaffYtd(root.getAdminC_item13());
			adminDeptManagers.setCompSalContractServicesYtd(root.getAdminC_item23());
			adminDeptManagers.setCompSalName(root.getAdmin_label3());
			adminDeptManagers.setCompSalType(root.getAdmin_label());
			adminDeptManagers.setConfirmationId(root.getForm().getConfirmationId());
			adminDeptManagers.setCompSalTotalCostYtd(root.getAdminC_calc3());

			LtcYtdCompSal adminSupport = new LtcYtdCompSal();
			adminSupport.setCompSalStaffYtd(root.getAdminC_item14());
			adminSupport.setCompSalContractServicesYtd(root.getAdminC_item24());
			adminSupport.setCompSalName(root.getAdmin_label4());
			adminSupport.setCompSalType(root.getAdmin_label());
			adminSupport.setConfirmationId(root.getForm().getConfirmationId());
			adminSupport.setCompSalTotalCostYtd(root.getAdminC_calc4());

			LtcYtdCompSal adminPastoCareWrkr = new LtcYtdCompSal();
			adminPastoCareWrkr.setCompSalStaffYtd(root.getAdminC_item15());
			adminPastoCareWrkr.setCompSalContractServicesYtd(root.getAdminC_item25());
			adminPastoCareWrkr.setCompSalName(root.getAdmin_label5());
			adminPastoCareWrkr.setCompSalType(root.getAdmin_label());
			adminPastoCareWrkr.setConfirmationId(root.getForm().getConfirmationId());
			adminPastoCareWrkr.setCompSalTotalCostYtd(root.getAdminC_calc5());

			LtcYtdCompSal adminClrks = new LtcYtdCompSal();
			adminClrks.setCompSalStaffYtd(root.getAdminC_item16());
			adminClrks.setCompSalContractServicesYtd(root.getAdminC_item26());
			adminClrks.setCompSalName(root.getAdmin_label6());
			adminClrks.setCompSalType(root.getAdmin_label());
			adminClrks.setConfirmationId(root.getForm().getConfirmationId());
			adminClrks.setCompSalTotalCostYtd(root.getAdminC_calc6());

			LtcYtdCompSal adminClncCrdinator = new LtcYtdCompSal();
			adminClncCrdinator.setCompSalStaffYtd(root.getAdminC_item17());
			adminClncCrdinator.setCompSalContractServicesYtd(root.getAdminC_item27());
			adminClncCrdinator.setCompSalName(root.getAdmin_label7());
			adminClncCrdinator.setCompSalType(root.getAdmin_label());
			adminClncCrdinator.setConfirmationId(root.getForm().getConfirmationId());
			adminClncCrdinator.setCompSalTotalCostYtd(root.getAdminC_calc7());

			LtcYtdCompSal adminScreenGreeters = new LtcYtdCompSal();
			adminScreenGreeters.setCompSalStaffYtd(root.getAdminC_item18());
			adminScreenGreeters.setCompSalContractServicesYtd(root.getAdminC_item28());
			adminScreenGreeters.setCompSalName(root.getAdmin_label8());
			adminScreenGreeters.setCompSalType(root.getAdmin_label());
			adminScreenGreeters.setConfirmationId(root.getForm().getConfirmationId());
			adminScreenGreeters.setCompSalTotalCostYtd(root.getAdminC_calc8());

			LtcYtdCompSal adminHCSP = new LtcYtdCompSal();
			adminHCSP.setCompSalStaffYtd(root.getAdminC_item19());
			adminHCSP.setCompSalContractServicesYtd(root.getAdminC_item29());
			adminHCSP.setCompSalName(root.getAdmin_label9());
			adminHCSP.setCompSalType(root.getAdmin_label());
			adminHCSP.setConfirmationId(root.getForm().getConfirmationId());
			adminHCSP.setCompSalTotalCostYtd(root.getAdminC_calc9());

			LtcYtdCompSal adminOther = new LtcYtdCompSal();
			adminOther.setCompSalStaffYtd(root.getAdminC_item110());
			adminOther.setCompSalContractServicesYtd(root.getAdminC_item210());
			adminOther.setCompSalName(Constants.DEFAULT_OTHER_VALUE);
			adminOther.setCompSalType(root.getAdmin_label());
			adminOther.setConfirmationId(root.getForm().getConfirmationId());
			adminOther.setCompSalTotalCostYtd(root.getAdminC_calc10());
			adminOther.setCompSalOtherName(root.getAdmin_label10());

			/* Direct Care Nursing */
			LtcYtdCompSal nursingRNSal = new LtcYtdCompSal();
			nursingRNSal.setCompSalStaffYtd(root.getCompBNursing_item11());
			nursingRNSal.setCompSalContractServicesYtd(root.getCompBNursing_item21());
			nursingRNSal.setCompSalName(root.getNursing_label_comp1());
			nursingRNSal.setCompSalType(root.getNursing_label_comp());
			nursingRNSal.setConfirmationId(root.getForm().getConfirmationId());
			nursingRNSal.setCompSalTotalCostYtd(root.getCompBNursing_calc1());
			

			LtcYtdCompSal nursingLPNSal = new LtcYtdCompSal();
			nursingLPNSal.setCompSalStaffYtd(root.getCompBNursing_item12());
			nursingLPNSal.setCompSalContractServicesYtd(root.getCompBNursing_item22());
			nursingLPNSal.setCompSalName(root.getNursing_label_comp2());
			nursingLPNSal.setCompSalType(root.getNursing_label_comp());
			nursingLPNSal.setConfirmationId(root.getForm().getConfirmationId());
			nursingLPNSal.setCompSalTotalCostYtd(root.getCompBNursing_calc2());

			LtcYtdCompSal nursingHCASal = new LtcYtdCompSal();
			nursingHCASal.setCompSalStaffYtd(root.getCompBNursing_item13());
			nursingHCASal.setCompSalContractServicesYtd(root.getCompBNursing_item23());
			nursingHCASal.setCompSalName(root.getNursing_label_comp3());
			nursingHCASal.setCompSalType(root.getNursing_label_comp());
			nursingHCASal.setConfirmationId(root.getForm().getConfirmationId());
			nursingHCASal.setCompSalTotalCostYtd(root.getCompBNursing_calc3());
			

			LtcYtdCompSal nursingOthSal = new LtcYtdCompSal();
			nursingOthSal.setCompSalStaffYtd(root.getCompBNursing_item14());
			nursingOthSal.setCompSalContractServicesYtd(root.getCompBNursing_item24());
			nursingOthSal.setCompSalName(Constants.DEFAULT_OTHER_VALUE);
			nursingOthSal.setCompSalType(root.getNursing_label_comp());
			nursingOthSal.setConfirmationId(root.getForm().getConfirmationId());
			nursingOthSal.setCompSalTotalCostYtd(root.getCompBNursing_calc4());
			nursingOthSal.setCompSalOtherName(root.getNursing_label_comp4());

			/* Allied Professional */
			LtcYtdCompSal alliedProfOTSal = new LtcYtdCompSal();
			alliedProfOTSal.setCompSalStaffYtd(root.getCompBAlliedProf_item11());
			alliedProfOTSal.setCompSalContractServicesYtd(root.getCompBAlliedProf_item21());
			alliedProfOTSal.setCompSalName(root.getAlliedProf_label_comp1());
			alliedProfOTSal.setCompSalType(root.getAlliedProf_label_comp());
			alliedProfOTSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfOTSal.setCompSalTotalCostYtd(root.getCompBAlliedProf_calc1());

			LtcYtdCompSal alliedProfPTSal = new LtcYtdCompSal();
			alliedProfPTSal.setCompSalStaffYtd(root.getCompBAlliedProf_item12());
			alliedProfPTSal.setCompSalContractServicesYtd(root.getCompBAlliedProf_item22());
			alliedProfPTSal.setCompSalName(root.getAlliedProf_label_comp2());
			alliedProfPTSal.setCompSalType(root.getAlliedProf_label_comp());
			alliedProfPTSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfPTSal.setCompSalTotalCostYtd(root.getCompBAlliedProf_calc2());

			LtcYtdCompSal alliedProfDTSal = new LtcYtdCompSal();
			alliedProfDTSal.setCompSalStaffYtd(root.getCompBAlliedProf_item13());
			alliedProfDTSal.setCompSalContractServicesYtd(root.getCompBAlliedProf_item23());
			alliedProfDTSal.setCompSalName(root.getAlliedProf_label_comp3());
			alliedProfDTSal.setCompSalType(root.getAlliedProf_label_comp());
			alliedProfDTSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfDTSal.setCompSalTotalCostYtd(root.getCompBAlliedProf_calc3());

			LtcYtdCompSal alliedProfSWSal = new LtcYtdCompSal();
			alliedProfSWSal.setCompSalStaffYtd(root.getCompBAlliedProf_item14());
			alliedProfSWSal.setCompSalContractServicesYtd(root.getCompBAlliedProf_item24());
			alliedProfSWSal.setCompSalName(root.getAlliedProf_label_comp4());
			alliedProfSWSal.setCompSalType(root.getAlliedProf_label_comp());
			alliedProfSWSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfSWSal.setCompSalTotalCostYtd(root.getCompBAlliedProf_calc4());

			LtcYtdCompSal alliedProfSLPSal = new LtcYtdCompSal();
			alliedProfSLPSal.setCompSalStaffYtd(root.getCompBAlliedProf_item15());
			alliedProfSLPSal.setCompSalContractServicesYtd(root.getCompBAlliedProf_item25());
			alliedProfSLPSal.setCompSalName(root.getAlliedProf_label_comp5());
			alliedProfSLPSal.setCompSalType(root.getAlliedProf_label_comp());
			alliedProfSLPSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfSLPSal.setCompSalTotalCostYtd(root.getCompBAlliedProf_calc5());

			LtcYtdCompSal alliedProfRPPSal = new LtcYtdCompSal();
			alliedProfRPPSal.setCompSalStaffYtd(root.getCompBAlliedProf_item16());
			alliedProfRPPSal.setCompSalContractServicesYtd(root.getCompBAlliedProf_item26());
			alliedProfRPPSal.setCompSalName(root.getAlliedProf_label_comp6());
			alliedProfRPPSal.setCompSalType(root.getAlliedProf_label_comp());
			alliedProfRPPSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfRPPSal.setCompSalTotalCostYtd(root.getCompBAlliedProf_calc6());

			LtcYtdCompSal alliedProfOTHSal = new LtcYtdCompSal();
			alliedProfOTHSal.setCompSalStaffYtd(root.getCompBAlliedProf_item17());
			alliedProfOTHSal.setCompSalContractServicesYtd(root.getCompBAlliedProf_item27());
			alliedProfOTHSal.setCompSalName(Constants.DEFAULT_OTHER_VALUE);
			alliedProfOTHSal.setCompSalType(root.getAlliedProf_label_comp());
			alliedProfOTHSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfOTHSal.setCompSalTotalCostYtd(root.getCompBAlliedProf_calc7());
			alliedProfOTHSal.setCompSalOtherName(root.getAlliedProf_label_comp7());

			/* Allied Non Professional */
			LtcYtdCompSal alliedNPRTSal = new LtcYtdCompSal();
			alliedNPRTSal.setCompSalStaffYtd(root.getCompBAlliedNP_item11());
			alliedNPRTSal.setCompSalContractServicesYtd(root.getCompBAlliedNP_item21());
			alliedNPRTSal.setCompSalName(root.getAlliedNP_label_comp1());
			alliedNPRTSal.setCompSalType(root.getAlliedNP_label_comp());
			alliedNPRTSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRTSal.setCompSalTotalCostYtd(root.getCompBAlliedNP_calc1());

			LtcYtdCompSal alliedNPRASal = new LtcYtdCompSal();
			alliedNPRASal.setCompSalStaffYtd(root.getCompBAlliedNP_item12());
			alliedNPRASal.setCompSalContractServicesYtd(root.getCompBAlliedNP_item22());
			alliedNPRASal.setCompSalName(root.getAlliedNP_label_comp2());
			alliedNPRASal.setCompSalType(root.getAlliedNP_label_comp());
			alliedNPRASal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRASal.setCompSalTotalCostYtd(root.getCompBAlliedNP_calc2());

			LtcYtdCompSal alliedNPAWSal = new LtcYtdCompSal();
			alliedNPAWSal.setCompSalStaffYtd(root.getCompBAlliedNP_item13());
			alliedNPAWSal.setCompSalContractServicesYtd(root.getCompBAlliedNP_item23());
			alliedNPAWSal.setCompSalName(root.getAlliedNP_label_comp3());
			alliedNPAWSal.setCompSalType(root.getAlliedNP_label_comp());
			alliedNPAWSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPAWSal.setCompSalTotalCostYtd(root.getCompBAlliedNP_calc3());

			LtcYtdCompSal alliedNPMTSal = new LtcYtdCompSal();
			alliedNPMTSal.setCompSalStaffYtd(root.getCompBAlliedNP_item14());
			alliedNPMTSal.setCompSalContractServicesYtd(root.getCompBAlliedNP_item24());
			alliedNPMTSal.setCompSalName(root.getAlliedNP_label_comp4());
			alliedNPMTSal.setCompSalType(root.getAlliedNP_label_comp());
			alliedNPMTSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPMTSal.setCompSalTotalCostYtd(root.getCompBAlliedNP_calc4());

			LtcYtdCompSal alliedNPATSal = new LtcYtdCompSal();
			alliedNPATSal.setCompSalStaffYtd(root.getCompBAlliedNP_item15());
			alliedNPATSal.setCompSalContractServicesYtd(root.getCompBAlliedNP_item25());
			alliedNPATSal.setCompSalName(root.getAlliedNP_label_comp5());
			alliedNPATSal.setCompSalType(root.getAlliedNP_label_comp());
			alliedNPATSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPATSal.setCompSalTotalCostYtd(root.getCompBAlliedNP_calc5());

			LtcYtdCompSal alliedNPOTHSal = new LtcYtdCompSal();
			alliedNPOTHSal.setCompSalStaffYtd(root.getCompBAlliedNP_item16());
			alliedNPOTHSal.setCompSalContractServicesYtd(root.getCompBAlliedNP_item26());
			alliedNPOTHSal.setCompSalName(Constants.DEFAULT_OTHER_VALUE);
			alliedNPOTHSal.setCompSalType(root.getAlliedNP_label_comp());
			alliedNPOTHSal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPOTHSal.setCompSalTotalCostYtd(root.getCompBAlliedNP_calc6());
			alliedNPOTHSal.setCompSalOtherName(root.getAlliedNP_label_comp6());

			Collections.addAll(ltcYtdCompSal, supportFoodServices, supportLaundryServices, supportHousekeeping,
					supportPlantMntnce, adminAdministrator, adminDirOfCare, adminDeptManagers, adminSupport,
					adminPastoCareWrkr, adminClrks, adminClncCrdinator, adminScreenGreeters, adminHCSP, adminOther, nursingRNSal,
					nursingLPNSal, nursingHCASal, nursingOthSal, alliedProfOTSal, alliedProfPTSal, alliedProfDTSal, alliedProfSWSal,
					alliedProfSLPSal, alliedProfRPPSal, alliedProfOTHSal, alliedNPRTSal, alliedNPRASal,
					alliedNPAWSal, alliedNPMTSal, alliedNPATSal, alliedNPOTHSal);
					

			LtcYtdCompSalSubtotals supportSalSubtotal = new LtcYtdCompSalSubtotals();
			supportSalSubtotal.setCompSalType(root.getSupport_label());
			supportSalSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			supportSalSubtotal.setSubTotalCompSalStaffYTD(root.getSupportC_sum1());
			supportSalSubtotal.setSubTotalCompSalContractServicesYTD(root.getSupportC_sum2());
			supportSalSubtotal.setSubTotalCompSalTotalCostYTD(root.getSupportC_calcsum());

			LtcYtdCompSalSubtotals administrationSalSubtotal = new LtcYtdCompSalSubtotals();
			administrationSalSubtotal.setCompSalType(root.getAdmin_label());
			administrationSalSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			administrationSalSubtotal.setSubTotalCompSalStaffYTD(root.getAdminC_sum1());
			administrationSalSubtotal.setSubTotalCompSalContractServicesYTD(root.getAdminC_sum2());
			administrationSalSubtotal.setSubTotalCompSalTotalCostYTD(root.getAdminC_calcsum());

			LtcYtdCompSalSubtotals nursingSalSubtotal = new LtcYtdCompSalSubtotals();
			nursingSalSubtotal.setCompSalType(root.getNursing_label_comp());
			nursingSalSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			nursingSalSubtotal.setSubTotalCompSalStaffYTD(root.getCompBNursing_sum1());
			nursingSalSubtotal.setSubTotalCompSalContractServicesYTD(root.getCompBNursing_sum2());
			nursingSalSubtotal.setSubTotalCompSalTotalCostYTD(root.getCompBNursing_calcsum());

			LtcYtdCompSalSubtotals alliedSalSubtotal = new LtcYtdCompSalSubtotals();
			alliedSalSubtotal.setCompSalType(root.getAlliedProf_label_comp());
			alliedSalSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			alliedSalSubtotal.setSubTotalCompSalStaffYTD(root.getCompBAlliedProf_sum1());
			alliedSalSubtotal.setSubTotalCompSalContractServicesYTD(root.getCompBAlliedProf_sum2());
			alliedSalSubtotal.setSubTotalCompSalTotalCostYTD(root.getCompBAlliedProf_calcsum());

			LtcYtdCompSalSubtotals alliedNPSalSubtotal = new LtcYtdCompSalSubtotals();
			alliedNPSalSubtotal.setCompSalType(root.getAlliedNP_label_comp());
			alliedNPSalSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPSalSubtotal.setSubTotalCompSalStaffYTD(root.getCompBAlliedNP_sum1());
			alliedNPSalSubtotal.setSubTotalCompSalContractServicesYTD(root.getCompBAlliedNP_sum2());
			alliedNPSalSubtotal.setSubTotalCompSalTotalCostYTD(root.getCompBAlliedNP_calcsum());

			Collections.addAll(ltcYtdCompSalSubttls,administrationSalSubtotal,nursingSalSubtotal,supportSalSubtotal,alliedSalSubtotal,alliedNPSalSubtotal);

			LtcYtdCompSalTotals totalPerPayrollSal = new LtcYtdCompSalTotals();
			totalPerPayrollSal.setCompSalType(root.getCompB_total_label());
			totalPerPayrollSal.setConfirmationId(root.getForm().getConfirmationId());
			totalPerPayrollSal.setTotalCompSalStaffYTD(root.getCompB_total1());
			totalPerPayrollSal.setTotalCompSalContractServicesYTD(root.getCompB_total2());
			totalPerPayrollSal.setTotalCompSalTotalCostYTD(root.getCompB_total());

			LtcYtdCompSalTotals recoveredPerPayrollSal = new LtcYtdCompSalTotals();
			recoveredPerPayrollSal.setCompSalType(root.getCompB_recovered_label());
			recoveredPerPayrollSal.setConfirmationId(root.getForm().getConfirmationId());
			recoveredPerPayrollSal.setTotalCompSalStaffYTD(root.getCompB_recovered1());
			recoveredPerPayrollSal.setTotalCompSalContractServicesYTD(root.getCompB_recovered2());
			recoveredPerPayrollSal.setTotalCompSalTotalCostYTD(root.getCompB_recovered());

			LtcYtdCompSalTotals accruedPerPayrollSal = new LtcYtdCompSalTotals();
			accruedPerPayrollSal.setCompSalType(root.getCompB_accrued_label());
			accruedPerPayrollSal.setConfirmationId(root.getForm().getConfirmationId());
			accruedPerPayrollSal.setTotalCompSalStaffYTD(root.getCompB_accrued1());
			accruedPerPayrollSal.setTotalCompSalContractServicesYTD(root.getCompB_accrued2());
			accruedPerPayrollSal.setTotalCompSalTotalCostYTD(root.getCompB_accrued());

			LtcYtdCompSalTotals otherPerPayrollSal = new LtcYtdCompSalTotals();
			otherPerPayrollSal.setCompSalType(root.getCompB_laborOther_label());
			otherPerPayrollSal.setConfirmationId(root.getForm().getConfirmationId());
			otherPerPayrollSal.setTotalCompSalStaffYTD(root.getCompB_laborOther1());
			otherPerPayrollSal.setTotalCompSalContractServicesYTD(root.getCompB_laborOther2());
			otherPerPayrollSal.setTotalCompSalTotalCostYTD(root.getCompB_laborOther());

			Collections.addAll(ltcYtdCompsalTtls,totalPerPayrollSal,recoveredPerPayrollSal,accruedPerPayrollSal,otherPerPayrollSal);

			/* Hours for Staff and Contracted Services */
			LtcYtdCompHrs supportFoodServicesHrs = new LtcYtdCompHrs();
			//supportFoodServicesHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP1());
			supportFoodServicesHrs.setCompHrsStaffYtd(root.getSupportH_item11());
			supportFoodServicesHrs.setCompHrsContractServicesYtd(root.getSupportH_item21());
			supportFoodServicesHrs.setCompHrsName(root.getSupport_label1());
			supportFoodServicesHrs.setCompHrsType(root.getSupport_label());
			supportFoodServicesHrs.setConfirmationId(root.getForm().getConfirmationId());
			supportFoodServicesHrs.setCompTotalWorkedHrsYtd(root.getSupportH_calc1());

			LtcYtdCompHrs supportLaundryServicesHrs = new LtcYtdCompHrs();
			//supportLaundryServicesHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP2());
			supportLaundryServicesHrs.setCompHrsStaffYtd(root.getSupportH_item12());
			supportLaundryServicesHrs.setCompHrsContractServicesYtd(root.getSupportH_item22());
			supportLaundryServicesHrs.setCompHrsName(root.getSupport_label2());
			supportLaundryServicesHrs.setCompHrsType(root.getSupport_label());
			supportLaundryServicesHrs.setConfirmationId(root.getForm().getConfirmationId());
			supportLaundryServicesHrs.setCompTotalWorkedHrsYtd(root.getSupportH_calc2());

			LtcYtdCompHrs supportHousekeepingHrs = new LtcYtdCompHrs();
			//supportHousekeepingHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP3());
			supportHousekeepingHrs.setCompHrsStaffYtd(root.getSupportH_item13());
			supportHousekeepingHrs.setCompHrsContractServicesYtd(root.getSupportH_item23());
			supportHousekeepingHrs.setCompHrsName(root.getSupport_label3());
			supportHousekeepingHrs.setCompHrsType(root.getSupport_label());
			supportHousekeepingHrs.setConfirmationId(root.getForm().getConfirmationId());
			supportHousekeepingHrs.setCompTotalWorkedHrsYtd(root.getSupportH_calc3());

			LtcYtdCompHrs supportPlantMntnceHrs = new LtcYtdCompHrs();
			supportPlantMntnceHrs.setCompHrsStaffYtd(root.getSupportH_item14());
			supportPlantMntnceHrs.setCompHrsContractServicesYtd(root.getSupportH_item24());
			supportPlantMntnceHrs.setCompHrsName(root.getSupport_label4());
			supportPlantMntnceHrs.setCompHrsType(root.getSupport_label());
			supportPlantMntnceHrs.setConfirmationId(root.getForm().getConfirmationId());
			supportPlantMntnceHrs.setCompTotalWorkedHrsYtd(root.getSupportH_calc4());


			if(root.getSupport_label5() != null){
				LtcYtdCompHrs supportPharmacyServicesHrs = new LtcYtdCompHrs();
				supportPharmacyServicesHrs.setConfirmationId(root.getForm().getConfirmationId());
				supportPharmacyServicesHrs.setCompHrsType(root.getSupport_label());
				supportPharmacyServicesHrs.setCompHrsName(root.getSupport_label5());
				supportPharmacyServicesHrs.setCompHrsStaffYtd(root.getSupportH_item15());
				supportPharmacyServicesHrs.setCompHrsContractServicesYtd(root.getSupportH_item25());
				supportPharmacyServicesHrs.setCompTotalWorkedHrsYtd(root.getSupportH_calc5());

				Collections.addAll(ltcYtdCompHrs, supportPharmacyServicesHrs);

			}

			// sum remaining
			LtcYtdCompHrs adminAdministratorHrs = new LtcYtdCompHrs();
			adminAdministratorHrs.setCompHrsStaffYtd(root.getAdminH_item11());
			adminAdministratorHrs.setCompHrsContractServicesYtd(root.getAdminH_item21());
			adminAdministratorHrs.setCompHrsName(root.getAdmin_label1());
			adminAdministratorHrs.setCompHrsType(root.getAdmin_label());
			adminAdministratorHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminAdministratorHrs.setCompTotalWorkedHrsYtd(root.getAdminH_calc1());


			LtcYtdCompHrs adminDirOfCareHrs = new LtcYtdCompHrs();
			adminDirOfCareHrs.setCompHrsStaffYtd(root.getAdminH_item12());
			adminDirOfCareHrs.setCompHrsContractServicesYtd(root.getAdminH_item22());
			adminDirOfCareHrs.setCompHrsName(root.getAdmin_label2());
			adminDirOfCareHrs.setCompHrsType(root.getAdmin_label());
			adminDirOfCareHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminDirOfCareHrs.setCompTotalWorkedHrsYtd(root.getAdminH_calc2());

			LtcYtdCompHrs adminDeptManagersHrs = new LtcYtdCompHrs();
			adminDeptManagersHrs.setCompHrsStaffYtd(root.getAdminH_item13());
			adminDeptManagersHrs.setCompHrsContractServicesYtd(root.getAdminH_item23());
			adminDeptManagersHrs.setCompHrsName(root.getAdmin_label3());
			adminDeptManagersHrs.setCompHrsType(root.getAdmin_label());
			adminDeptManagersHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminDeptManagersHrs.setCompTotalWorkedHrsYtd(root.getAdminH_calc3());

			LtcYtdCompHrs adminSupportHrs = new LtcYtdCompHrs();
			adminSupportHrs.setCompHrsStaffYtd(root.getAdminH_item14());
			adminSupportHrs.setCompHrsContractServicesYtd(root.getAdminH_item24());
			adminSupportHrs.setCompHrsName(root.getAdmin_label4());
			adminSupportHrs.setCompHrsType(root.getAdmin_label());
			adminSupportHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminSupportHrs.setCompTotalWorkedHrsYtd(root.getAdminH_calc4());

			LtcYtdCompHrs adminPastoCareWrkrHrs = new LtcYtdCompHrs();
			adminPastoCareWrkrHrs.setCompHrsStaffYtd(root.getAdminH_item15());
			adminPastoCareWrkrHrs.setCompHrsContractServicesYtd(root.getAdminH_item25());
			adminPastoCareWrkrHrs.setCompHrsName(root.getAdmin_label5());
			adminPastoCareWrkrHrs.setCompHrsType(root.getAdmin_label());
			adminPastoCareWrkrHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminPastoCareWrkrHrs.setCompTotalWorkedHrsYtd(root.getAdminH_calc5());

			LtcYtdCompHrs adminClrksHrs = new LtcYtdCompHrs();
			adminClrksHrs.setCompHrsStaffYtd(root.getAdminH_item16());
			adminClrksHrs.setCompHrsContractServicesYtd(root.getAdminH_item26());
			adminClrksHrs.setCompHrsName(root.getAdmin_label6());
			adminClrksHrs.setCompHrsType(root.getAdmin_label());
			adminClrksHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminClrksHrs.setCompTotalWorkedHrsYtd(root.getAdminH_calc6());

			LtcYtdCompHrs adminClncCrdinatorHrs = new LtcYtdCompHrs();
			adminClncCrdinatorHrs.setCompHrsStaffYtd(root.getAdminH_item17());
			adminClncCrdinatorHrs.setCompHrsContractServicesYtd(root.getAdminH_item27());
			adminClncCrdinatorHrs.setCompHrsName(root.getAdmin_label7());
			adminClncCrdinatorHrs.setCompHrsType(root.getAdmin_label());
			adminClncCrdinatorHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminClncCrdinatorHrs.setCompTotalWorkedHrsYtd(root.getAdminH_calc7());

			LtcYtdCompHrs adminScreenersGreeters = new LtcYtdCompHrs();
			adminScreenersGreeters.setCompHrsStaffYtd(root.getAdminH_item18());
			adminScreenersGreeters.setCompHrsContractServicesYtd(root.getAdminH_item28());
			adminScreenersGreeters.setCompHrsName(root.getAdmin_label8());
			adminScreenersGreeters.setCompHrsType(root.getAdmin_label());
			adminScreenersGreeters.setConfirmationId(root.getForm().getConfirmationId());
			adminScreenersGreeters.setCompTotalWorkedHrsYtd(root.getAdminH_calc8());

			LtcYtdCompHrs adminHCSW = new LtcYtdCompHrs();
			adminHCSW.setCompHrsStaffYtd(root.getAdminH_item19());
			adminHCSW.setCompHrsContractServicesYtd(root.getAdminH_item29());
			adminHCSW.setCompHrsName(root.getAdmin_label9());
			adminHCSW.setCompHrsType(root.getAdmin_label());
			adminHCSW.setConfirmationId(root.getForm().getConfirmationId());
			adminHCSW.setCompTotalWorkedHrsYtd(root.getAdminH_calc9());

			LtcYtdCompHrs adminOtherHrs = new LtcYtdCompHrs();
			adminOtherHrs.setCompHrsStaffYtd(root.getAdminH_item110());
			adminOtherHrs.setCompHrsContractServicesYtd(root.getAdminH_item210());
			adminOtherHrs.setCompHrsName(Constants.DEFAULT_OTHER_VALUE);
			adminOtherHrs.setCompHrsType(root.getAdmin_label());
			adminOtherHrs.setConfirmationId(root.getForm().getConfirmationId());
			adminOtherHrs.setCompTotalWorkedHrsYtd(root.getAdminH_calc10());
			adminOtherHrs.setCompHrsOtherName(root.getAdmin_label10());

			/* Nursing, Allied, Non Allied Hours */
			LtcYtdCompHrs nursingRNHrs = new LtcYtdCompHrs();
			//nursingRNHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP13());
			nursingRNHrs.setCompHrsStaffYtd(root.getCompHNursing_item11());
			nursingRNHrs.setCompHrsContractServicesYtd(root.getCompHNursing_item21());
			nursingRNHrs.setCompHrsName(root.getNursing_label_comp1());
			nursingRNHrs.setCompHrsType(root.getNursing_label_comp());
			nursingRNHrs.setConfirmationId(root.getForm().getConfirmationId());
			nursingRNHrs.setCompTotalWorkedHrsYtd(root.getCompHNursing_calc1());

			LtcYtdCompHrs nursingLPNHrs = new LtcYtdCompHrs();
			//nursingLPNHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP14());
			nursingLPNHrs.setCompHrsStaffYtd(root.getCompHNursing_item12());
			nursingLPNHrs.setCompHrsContractServicesYtd(root.getCompHNursing_item22());
			nursingLPNHrs.setCompHrsName(root.getNursing_label_comp2());
			nursingLPNHrs.setCompHrsType(root.getNursing_label_comp());
			nursingLPNHrs.setConfirmationId(root.getForm().getConfirmationId());
			nursingLPNHrs.setCompTotalWorkedHrsYtd(root.getCompHNursing_calc2());

			LtcYtdCompHrs nursingHCAHrs = new LtcYtdCompHrs();
			//nursingHCAHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP15());
			nursingHCAHrs.setCompHrsStaffYtd(root.getCompHNursing_item13());
			nursingHCAHrs.setCompHrsContractServicesYtd(root.getCompHNursing_item23());
			nursingHCAHrs.setCompHrsName(root.getNursing_label_comp3());
			nursingHCAHrs.setCompHrsType(root.getNursing_label_comp());
			nursingHCAHrs.setConfirmationId(root.getForm().getConfirmationId());
			nursingHCAHrs.setCompTotalWorkedHrsYtd(root.getCompHNursing_calc3());

			LtcYtdCompHrs nursingOthHrs = new LtcYtdCompHrs();
			//nursingOthHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP16());
			nursingOthHrs.setCompHrsStaffYtd(root.getCompHNursing_item14());
			nursingOthHrs.setCompHrsContractServicesYtd(root.getCompHNursing_item24());
			nursingOthHrs.setCompHrsName(Constants.DEFAULT_OTHER_VALUE);
			nursingOthHrs.setCompHrsType(root.getNursing_label_comp());
			nursingOthHrs.setConfirmationId(root.getForm().getConfirmationId());
			nursingOthHrs.setCompTotalWorkedHrsYtd(root.getCompHNursing_calc4());
			nursingOthHrs.setCompHrsOtherName(root.getNursing_label_comp4());

			LtcYtdCompHrs alliedProfOTHrs = new LtcYtdCompHrs();
			//alliedProfOTHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP17());
			alliedProfOTHrs.setCompHrsStaffYtd(root.getCompHAlliedProf_item11());
			alliedProfOTHrs.setCompHrsContractServicesYtd(root.getCompHAlliedProf_item21());
			alliedProfOTHrs.setCompHrsName(root.getAlliedProf_label_comp1());
			alliedProfOTHrs.setCompHrsType(root.getAlliedProf_label_comp());
			alliedProfOTHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfOTHrs.setCompTotalWorkedHrsYtd(root.getCompHAlliedProf_calc1());

			LtcYtdCompHrs alliedProfPTHrs = new LtcYtdCompHrs();
			//alliedProfPTHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP18());
			alliedProfPTHrs.setCompHrsStaffYtd(root.getCompHAlliedProf_item12());
			alliedProfPTHrs.setCompHrsContractServicesYtd(root.getCompHAlliedProf_item22());
			alliedProfPTHrs.setCompHrsName(root.getAlliedProf_label_comp2());
			alliedProfPTHrs.setCompHrsType(root.getAlliedProf_label_comp());
			alliedProfPTHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfPTHrs.setCompTotalWorkedHrsYtd(root.getCompHAlliedProf_calc2());

			LtcYtdCompHrs alliedProfDTHrs = new LtcYtdCompHrs();
			//alliedProfDTHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP19());
			alliedProfDTHrs.setCompHrsStaffYtd(root.getCompHAlliedProf_item13());
			alliedProfDTHrs.setCompHrsContractServicesYtd(root.getCompHAlliedProf_item23());
			alliedProfDTHrs.setCompHrsName(root.getAlliedProf_label_comp3());
			alliedProfDTHrs.setCompHrsType(root.getAlliedProf_label_comp());
			alliedProfDTHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfDTHrs.setCompTotalWorkedHrsYtd(root.getCompHAlliedProf_calc3());

			LtcYtdCompHrs alliedProfSWHrs = new LtcYtdCompHrs();
			//alliedProfSWHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP20());
			alliedProfSWHrs.setCompHrsStaffYtd(root.getCompHAlliedProf_item14());
			alliedProfSWHrs.setCompHrsContractServicesYtd(root.getCompHAlliedProf_item24());
			alliedProfSWHrs.setCompHrsName(root.getAlliedProf_label_comp4());
			alliedProfSWHrs.setCompHrsType(root.getAlliedProf_label_comp());
			alliedProfSWHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfSWHrs.setCompTotalWorkedHrsYtd(root.getCompHAlliedProf_calc4());

			LtcYtdCompHrs alliedProfSLPHrs = new LtcYtdCompHrs();
			//alliedProfSWHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP20());
			alliedProfSLPHrs.setCompHrsStaffYtd(root.getCompHAlliedProf_item15());
			alliedProfSLPHrs.setCompHrsContractServicesYtd(root.getCompHAlliedProf_item25());
			alliedProfSLPHrs.setCompHrsName(root.getAlliedProf_label_comp5());
			alliedProfSLPHrs.setCompHrsType(root.getAlliedProf_label_comp());
			alliedProfSLPHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfSLPHrs.setCompTotalWorkedHrsYtd(root.getCompHAlliedProf_calc5());

			LtcYtdCompHrs alliedProfRTHrs = new LtcYtdCompHrs();
			//alliedProfSWHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP20());
			alliedProfRTHrs.setCompHrsStaffYtd(root.getCompHAlliedProf_item16());
			alliedProfRTHrs.setCompHrsContractServicesYtd(root.getCompHAlliedProf_item26());
			alliedProfRTHrs.setCompHrsName(root.getAlliedProf_label_comp6());
			alliedProfRTHrs.setCompHrsType(root.getAlliedProf_label_comp());
			alliedProfRTHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfRTHrs.setCompTotalWorkedHrsYtd(root.getCompHAlliedProf_calc6());

			LtcYtdCompHrs alliedProfOTHHrs = new LtcYtdCompHrs();
			//alliedProfOTHHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP21());
			alliedProfOTHHrs.setCompHrsStaffYtd(root.getCompHAlliedProf_item17());
			alliedProfOTHHrs.setCompHrsContractServicesYtd(root.getCompHAlliedProf_item27());
			alliedProfOTHHrs.setCompHrsName(Constants.DEFAULT_OTHER_VALUE);
			alliedProfOTHHrs.setCompHrsType(root.getAlliedProf_label_comp());
			alliedProfOTHHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfOTHHrs.setCompTotalWorkedHrsYtd(root.getCompHAlliedProf_calc7());
			alliedProfOTHHrs.setCompHrsOtherName(root.getAlliedProf_label_comp7());

			LtcYtdCompHrs alliedNPRTHrs = new LtcYtdCompHrs();
			//alliedNPRTHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP22());
			alliedNPRTHrs.setCompHrsStaffYtd(root.getCompHAlliedNP_item11());
			alliedNPRTHrs.setCompHrsContractServicesYtd(root.getCompHAlliedNP_item21());
			alliedNPRTHrs.setCompHrsName(root.getAlliedNP_label_comp1());
			alliedNPRTHrs.setCompHrsType(root.getAlliedNP_label_comp());
			alliedNPRTHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRTHrs.setCompTotalWorkedHrsYtd(root.getCompHAlliedNP_calc1());

			LtcYtdCompHrs alliedNPRAHrs = new LtcYtdCompHrs();
			//alliedNPRAHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP23());
			alliedNPRAHrs.setCompHrsStaffYtd(root.getCompHAlliedNP_item12());
			alliedNPRAHrs.setCompHrsContractServicesYtd(root.getCompHAlliedNP_item22());
			alliedNPRAHrs.setCompHrsName(root.getAlliedNP_label_comp2());
			alliedNPRAHrs.setCompHrsType(root.getAlliedNP_label_comp());
			alliedNPRAHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPRAHrs.setCompTotalWorkedHrsYtd(root.getCompHAlliedNP_calc2());

			LtcYtdCompHrs alliedNPAWHrs = new LtcYtdCompHrs();
			//alliedNPAWHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP24());
			alliedNPAWHrs.setCompHrsStaffYtd(root.getCompHAlliedNP_item13());
			alliedNPAWHrs.setCompHrsContractServicesYtd(root.getCompHAlliedNP_item23());
			alliedNPAWHrs.setCompHrsName(root.getAlliedNP_label_comp3());
			alliedNPAWHrs.setCompHrsType(root.getAlliedNP_label_comp());
			alliedNPAWHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPAWHrs.setCompTotalWorkedHrsYtd(root.getCompHAlliedNP_calc3());

			LtcYtdCompHrs alliedNPMTHrs = new LtcYtdCompHrs();
			//alliedNPMTHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP25());
			alliedNPMTHrs.setCompHrsStaffYtd(root.getCompHAlliedNP_item14());
			alliedNPMTHrs.setCompHrsContractServicesYtd(root.getCompHAlliedNP_item24());
			alliedNPMTHrs.setCompHrsName(root.getAlliedNP_label_comp4());
			alliedNPMTHrs.setCompHrsType(root.getAlliedNP_label_comp());
			alliedNPMTHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPMTHrs.setCompTotalWorkedHrsYtd(root.getCompHAlliedNP_calc4());

			LtcYtdCompHrs alliedNPATHrs = new LtcYtdCompHrs();
			//alliedNPATHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP26());
			alliedNPATHrs.setCompHrsStaffYtd(root.getCompHAlliedNP_item15());
			alliedNPATHrs.setCompHrsContractServicesYtd(root.getCompHAlliedNP_item25());
			alliedNPATHrs.setCompHrsName(root.getAlliedNP_label_comp5());
			alliedNPATHrs.setCompHrsType(root.getAlliedNP_label_comp());
			alliedNPATHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPATHrs.setCompTotalWorkedHrsYtd(root.getCompHAlliedNP_calc5());

			LtcYtdCompHrs alliedNPOTHHrs = new LtcYtdCompHrs();
			//alliedNPOTHHrs.setCompHrsPerPayrollYtd(root.getCompH_PHP27());
			alliedNPOTHHrs.setCompHrsStaffYtd(root.getCompHAlliedNP_item16());
			alliedNPOTHHrs.setCompHrsContractServicesYtd(root.getCompHAlliedNP_item26());
			alliedNPOTHHrs.setCompHrsName(Constants.DEFAULT_OTHER_VALUE);
			alliedNPOTHHrs.setCompHrsType(root.getAlliedNP_label_comp());
			alliedNPOTHHrs.setConfirmationId(root.getForm().getConfirmationId());
			alliedNPOTHHrs.setCompTotalWorkedHrsYtd(root.getCompHAlliedNP_calc6());
			alliedNPOTHHrs.setCompHrsOtherName(root.getAlliedNP_label_comp6());

			Collections.addAll(ltcYtdCompHrs, supportFoodServicesHrs, supportLaundryServicesHrs, supportHousekeepingHrs,
					supportPlantMntnceHrs, adminAdministratorHrs, adminDirOfCareHrs, adminDeptManagersHrs,
					adminSupportHrs, adminPastoCareWrkrHrs, adminClrksHrs, adminClncCrdinatorHrs, adminScreenersGreeters, adminHCSW, 
					adminOtherHrs, nursingRNHrs, nursingLPNHrs, nursingHCAHrs, nursingOthHrs, alliedProfOTHrs, alliedProfPTHrs,
					alliedProfDTHrs, alliedProfSWHrs, alliedProfSLPHrs, alliedProfRTHrs, alliedProfOTHHrs, alliedNPRTHrs, alliedNPRAHrs, alliedNPAWHrs,
					alliedNPMTHrs, alliedNPATHrs, alliedNPOTHHrs);

			/* Subtotals */
			LtcYtdCompHrsSubtotals supportHrsSubtotals = new LtcYtdCompHrsSubtotals();
			supportHrsSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			supportHrsSubtotals.setCompHrsType(root.getSupport_label());
			supportHrsSubtotals.setSubTotalCompHrsStaffYTD(root.getSupportH_sum1());
			supportHrsSubtotals.setSubTotalCompHrsContractServicesYTD(root.getSupportH_sum2());
			supportHrsSubtotals.setSubTotalCompTotalWorkedHrsYTD(root.getSupportH_calcsum());
			
			LtcYtdCompHrsSubtotals adminHrsSubtotals = new LtcYtdCompHrsSubtotals();
			adminHrsSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			adminHrsSubtotals.setCompHrsType(root.getAdmin_label());
			adminHrsSubtotals.setSubTotalCompHrsStaffYTD(root.getAdminH_sum1());
			adminHrsSubtotals.setSubTotalCompHrsContractServicesYTD(root.getAdminH_sum2());
			adminHrsSubtotals.setSubTotalCompTotalWorkedHrsYTD(root.getAdminH_calcsum());

			LtcYtdCompHrsSubtotals nursingHrsSubtotals = new LtcYtdCompHrsSubtotals();
			nursingHrsSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			nursingHrsSubtotals.setCompHrsType(root.getNursing_label_comp());
			nursingHrsSubtotals.setSubTotalCompHrsStaffYTD(root.getCompHNursing_sum1());
			nursingHrsSubtotals.setSubTotalCompHrsContractServicesYTD(root.getCompHNursing_sum2());
			nursingHrsSubtotals.setSubTotalCompTotalWorkedHrsYTD(root.getCompHNursing_calcsum());

			LtcYtdCompHrsSubtotals alliedHrsSubtotals = new LtcYtdCompHrsSubtotals();
			alliedHrsSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			alliedHrsSubtotals.setCompHrsType(root.getAlliedProf_label_comp());
			alliedHrsSubtotals.setSubTotalCompHrsStaffYTD(root.getCompHAlliedProf_sum1());
			alliedHrsSubtotals.setSubTotalCompHrsContractServicesYTD(root.getCompHAlliedProf_sum2());
			alliedHrsSubtotals.setSubTotalCompTotalWorkedHrsYTD(root.getCompHAlliedProf_calcsum());

			LtcYtdCompHrsSubtotals alliedNPHrsSubtotals = new LtcYtdCompHrsSubtotals();
			alliedNPHrsSubtotals.setConfirmationID(root.getForm().getConfirmationId());
			alliedNPHrsSubtotals.setCompHrsType(root.getAlliedNP_label_comp());
			alliedNPHrsSubtotals.setSubTotalCompHrsStaffYTD(root.getCompHAlliedNP_sum1());
			alliedNPHrsSubtotals.setSubTotalCompHrsContractServicesYTD(root.getCompHAlliedNP_sum2());
			alliedNPHrsSubtotals.setSubTotalCompTotalWorkedHrsYTD(root.getCompHAlliedNP_calcsum());

			Collections.addAll(ltcYtdCompHrsSubttls, supportHrsSubtotals,adminHrsSubtotals,nursingHrsSubtotals,alliedHrsSubtotals,alliedNPHrsSubtotals);

			/* Totals */
			LtcYtdCompHrsTotals totalPerPayrollHrsTotals = new LtcYtdCompHrsTotals();
			totalPerPayrollHrsTotals.setCompHrsTotalType(root.getCompH_total_label());
			totalPerPayrollHrsTotals.setTotalCompHrsStaffYTD(root.getCompH_total1());
			totalPerPayrollHrsTotals.setTotalCompHrsContractServicesYTD(root.getCompH_total2());
			totalPerPayrollHrsTotals.setTotalCompTotalWorkedHrsYTD(root.getCompH_total());
			totalPerPayrollHrsTotals.setConfirmationID(root.getForm().getConfirmationId());

			LtcYtdCompHrsTotals accuredHrsTotals = new LtcYtdCompHrsTotals();
			accuredHrsTotals.setCompHrsTotalType(root.getCompH_accrued_label());
			accuredHrsTotals.setTotalCompHrsStaffYTD(root.getCompH_accrued1());
			accuredHrsTotals.setTotalCompHrsContractServicesYTD(root.getCompH_accrued2());
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
			alliedProfSLPAddPos.setAddPosLegalNameContractServiceYtd(root.getAlliedProfProvider5());
			alliedProfSLPAddPos.setAddPosPercentServiceContractOutYtd(root.getAlliedProfPercentage5());
			alliedProfSLPAddPos.determineAddPosContractedOutYtd();

			LtcYtdCompAddPos alliedProfRTAddPos = new LtcYtdCompAddPos();
			alliedProfRTAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfRTAddPos.setAddPosType(root.getAlliedProf_label_CSP());
			alliedProfRTAddPos.setAddPosName(root.getAlliedProf_label_CSP6());
			alliedProfRTAddPos.setAddPosLegalNameContractServiceYtd(root.getAlliedProfProvider6());
			alliedProfRTAddPos.setAddPosPercentServiceContractOutYtd(root.getAlliedProfPercentage6());
			alliedProfRTAddPos.determineAddPosContractedOutYtd();

			LtcYtdCompAddPos alliedProfOTHAddPos = new LtcYtdCompAddPos();
			alliedProfOTHAddPos.setConfirmationId(root.getForm().getConfirmationId());
			alliedProfOTHAddPos.setAddPosType(root.getAlliedProf_label_CSP());
			alliedProfOTHAddPos.setAddPosName(Constants.POS_TYPE_OTHER);
			alliedProfOTHAddPos.setAddPosLegalNameContractServiceYtd(root.getAlliedProfProvider7());
			alliedProfOTHAddPos.setAddPosPercentServiceContractOutYtd(root.getAlliedProfPercentage7());
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
			empInsBenefit.setBenefitsType(root.getBenefit_value_label1());
			empInsBenefit.setBenefitsPercentageAlloc(root.getBenefit_percentage1());
			empInsBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdCompBenefits canPenPlnBenefit = new LtcYtdCompBenefits();
			canPenPlnBenefit.setBenefitsAmountYtd(root.getBenefit_value2());
			canPenPlnBenefit.setBenefitsType(root.getBenefit_value_label2());
			canPenPlnBenefit.setBenefitsPercentageAlloc(root.getBenefit_percentage2());
			canPenPlnBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdCompBenefits wrkrCompBoardBenefit = new LtcYtdCompBenefits();
			wrkrCompBoardBenefit.setBenefitsAmountYtd(root.getBenefit_value3());
			wrkrCompBoardBenefit.setBenefitsType(root.getBenefit_value_label3());
			wrkrCompBoardBenefit.setBenefitsPercentageAlloc(root.getBenefit_percentage3());
			wrkrCompBoardBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdCompBenefits empHlthTaxBenefit = new LtcYtdCompBenefits();
			empHlthTaxBenefit.setBenefitsAmountYtd(root.getBenefit_value4());
			empHlthTaxBenefit.setBenefitsType(root.getBenefit_value_label4());
			empHlthTaxBenefit.setBenefitsPercentageAlloc(root.getBenefit_percentage4());
			empHlthTaxBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdCompBenefits penPlanBenefit = new LtcYtdCompBenefits();
			penPlanBenefit.setBenefitsAmountYtd(root.getBenefit_value5());
			penPlanBenefit.setBenefitsType(root.getBenefit_value_label5());
			penPlanBenefit.setBenefitsPercentageAlloc(root.getBenefit_percentage5());
			penPlanBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdCompBenefits exHlthDntlBenefit = new LtcYtdCompBenefits();
			exHlthDntlBenefit.setBenefitsAmountYtd(root.getBenefit_value6());
			exHlthDntlBenefit.setBenefitsType(root.getBenefit_value_label6());
			exHlthDntlBenefit.setBenefitsPercentageAlloc(root.getBenefit_percentage6());
			exHlthDntlBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdCompBenefits grpLifeBenefit = new LtcYtdCompBenefits();
			grpLifeBenefit.setBenefitsAmountYtd(root.getBenefit_value7());
			grpLifeBenefit.setBenefitsType(root.getBenefit_value_label7());
			grpLifeBenefit.setBenefitsPercentageAlloc(root.getBenefit_percentage7());
			grpLifeBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdCompBenefits otherBenefit = new LtcYtdCompBenefits();
			otherBenefit.setBenefitsAmountYtd(root.getBenefit_value8());
			otherBenefit.setBenefitsType(root.getBenefit_value_label8());
			otherBenefit.setBenefitsPercentageAlloc(root.getBenefit_percentage8());
			otherBenefit.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdCompBenefits lessBenefitsRecovery = new LtcYtdCompBenefits();
			lessBenefitsRecovery.setBenefitsAmountYtd(root.getBenefit_value_rec());
			lessBenefitsRecovery.setBenefitsType(root.getBenefit_value_rec_label());
			lessBenefitsRecovery.setBenefitsPercentageAlloc(root.getBenefit_percentage_rec());
			lessBenefitsRecovery.setConfirmationId(root.getForm().getConfirmationId());

			Collections.addAll(ltcYtdCompBenefits, empInsBenefit, canPenPlnBenefit, wrkrCompBoardBenefit,
					empHlthTaxBenefit, penPlanBenefit, exHlthDntlBenefit, grpLifeBenefit, otherBenefit, 
					lessBenefitsRecovery);
			/* Are we setting the subtotal and total things? */

			/* Summary of Rev & Exp Budget */
			LtcYtdRev revFrmHA1Adj = new LtcYtdRev();
			revFrmHA1Adj.setRevYTD(root.getOpRev_YTD1());
			revFrmHA1Adj.setRevNotes(root.getOpRev_note1());
			revFrmHA1Adj.setRevName(root.getOpRev_YTD_label_1());	
			revFrmHA1Adj.setRevType(root.getOpRev_1_label());
			revFrmHA1Adj.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev revFrmHA1DirCare = new LtcYtdRev();
			revFrmHA1DirCare.setRevYTD(root.getOpRev_YTD2());
			revFrmHA1DirCare.setRevNotes(root.getOpRev_note2());
			revFrmHA1DirCare.setRevName(root.getOpRev_YTD_label_2());
			revFrmHA1DirCare.setRevType(root.getOpRev_1_label());
			revFrmHA1DirCare.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev revFrmHA1Others = new LtcYtdRev();
			revFrmHA1Others.setRevYTD(root.getOpRev_YTD3());
			revFrmHA1Others.setRevNotes(root.getOpRev_note3());
			revFrmHA1Others.setRevName(root.getOpRev_YTD_label_3());
			revFrmHA1Others.setRevType(root.getOpRev_1_label());
			revFrmHA1Others.setConfirmationId(root.getForm().getConfirmationId());

			// skipping subtotal for now

			LtcYtdRev revFrmHA2OpFundMinEq = new LtcYtdRev();
			revFrmHA2OpFundMinEq.setRevYTD(root.getOpRev_YTD4());
			revFrmHA2OpFundMinEq.setRevNotes(root.getOpRev_note4());
			revFrmHA2OpFundMinEq.setRevName(root.getOpRev_YTD_label_4());
			revFrmHA2OpFundMinEq.setRevType(root.getOpRev_2_label());
			revFrmHA2OpFundMinEq.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev revFrmHA2OpFundOth = new LtcYtdRev();
			revFrmHA2OpFundOth.setRevYTD(root.getOpRev_YTD5());
			revFrmHA2OpFundOth.setRevNotes(root.getOpRev_note5());
			revFrmHA2OpFundOth.setRevName(root.getOpRev_YTD_label_5());
			revFrmHA2OpFundOth.setRevType(root.getOpRev_2_label());
			revFrmHA2OpFundOth.setConfirmationId(root.getForm().getConfirmationId());

			// skipping subtotal

			LtcYtdRev revFrmHA3 = new LtcYtdRev();
			revFrmHA3.setRevYTD(root.getOpRev_YTD6());
			revFrmHA3.setRevNotes(root.getOpRev_note6());
			revFrmHA3.setRevName(root.getOpRev_YTD_label_6());
			revFrmHA3.setRevType(root.getOpRev_3_label());
			revFrmHA3.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev revFrmHA4OccThld = new LtcYtdRev();
			revFrmHA4OccThld.setRevYTD(root.getOpRev_YTD7());
			revFrmHA4OccThld.setRevNotes(root.getOpRev_note7());
			revFrmHA4OccThld.setRevName(root.getOpRev_YTD_label_7());
			revFrmHA4OccThld.setRevType(root.getOpRev_4_label());
			revFrmHA4OccThld.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev revFrmHA4CliConReconc = new LtcYtdRev();
			revFrmHA4CliConReconc.setRevYTD(root.getOpRev_YTD8());
			revFrmHA4CliConReconc.setRevNotes(root.getOpRev_note8());
			revFrmHA4CliConReconc.setRevName(root.getOpRev_YTD_label_8());
			revFrmHA4CliConReconc.setRevType(root.getOpRev_4_label());
			revFrmHA4CliConReconc.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev revFrmHA4DirCare = new LtcYtdRev();
			revFrmHA4DirCare.setRevYTD(root.getOpRev_YTD9());
			revFrmHA4DirCare.setRevNotes(root.getOpRev_note9());
			revFrmHA4DirCare.setRevName(root.getOpRev_YTD_label_9());
			revFrmHA4DirCare.setRevType(root.getOpRev_4_label());
			revFrmHA4DirCare.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev revFrmHA4Oth = new LtcYtdRev();
			revFrmHA4Oth.setRevYTD(root.getOpRev_YTD10());
			revFrmHA4Oth.setRevNotes(root.getOpRev_note10());
			revFrmHA4Oth.setRevName(root.getOpRev_YTD_label_10());
			revFrmHA4Oth.setRevType(root.getOpRev_4_label());
			revFrmHA4Oth.setConfirmationId(root.getForm().getConfirmationId());

			/* Non operating revenu */
			LtcYtdRev nonOperatingRevOth = new LtcYtdRev();
			nonOperatingRevOth.setRevYTD(root.getNopRev_YTD1());
			nonOperatingRevOth.setRevNotes(root.getNopRev_note1());
			nonOperatingRevOth.setRevName(root.getNopRev_YTD_label1());
			nonOperatingRevOth.setRevType(root.getNopRev_label());
			nonOperatingRevOth.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev nonOperatingRevOthThirdParty = new LtcYtdRev();
			nonOperatingRevOthThirdParty.setRevYTD(root.getNopRev_YTD2());
			nonOperatingRevOthThirdParty.setRevNotes(root.getNopRev_note2());
			nonOperatingRevOthThirdParty.setRevName(root.getNopRev_YTD_label2());
			nonOperatingRevOthThirdParty.setRevType(root.getNopRev_label());
			nonOperatingRevOthThirdParty.setConfirmationId(root.getForm().getConfirmationId());
			/* END */

			// skipping subtotal for now

			LtcYtdRev clntRvnHAClient = new LtcYtdRev();
			clntRvnHAClient.setRevYTD(root.getOpRev_YTD11());
			clntRvnHAClient.setRevNotes(root.getOpRev_note11());
			clntRvnHAClient.setRevName(root.getOpRev_YTD_label_11());
			clntRvnHAClient.setRevType(root.getOpRev_client_label());
			clntRvnHAClient.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev clntRvnFeePaidParties = new LtcYtdRev();
			clntRvnFeePaidParties.setRevYTD(root.getOpRev_YTD12());
			clntRvnFeePaidParties.setRevNotes(root.getOpRev_note12());
			clntRvnFeePaidParties.setRevName(root.getOpRev_YTD_label_12());
			clntRvnFeePaidParties.setRevType(root.getOpRev_client_label());
			clntRvnFeePaidParties.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev clntRvnFeePaidNonEligible = new LtcYtdRev();
			clntRvnFeePaidNonEligible.setRevYTD(root.getOpRev_YTD13());
			clntRvnFeePaidNonEligible.setRevNotes(root.getOpRev_note13());
			clntRvnFeePaidNonEligible.setRevName(root.getOpRev_YTD_label_13());
			clntRvnFeePaidNonEligible.setRevType(root.getOpRev_client_label());
			clntRvnFeePaidNonEligible.setConfirmationId(root.getForm().getConfirmationId());

			// skipping subtotal for now
			LtcYtdRev othRevInvstOpFund = new LtcYtdRev();
			othRevInvstOpFund.setRevYTD(root.getOpRev_YTD14());
			othRevInvstOpFund.setRevNotes(root.getOpRev_note14());
			othRevInvstOpFund.setRevName(root.getOpRev_YTD_label_14());
			othRevInvstOpFund.setRevType(root.getOpRev_otherRev_label());
			othRevInvstOpFund.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev othRevInvstCmBcFund = new LtcYtdRev();
			othRevInvstCmBcFund.setRevYTD(root.getOpRev_YTD15());
			othRevInvstCmBcFund.setRevNotes(root.getOpRev_note15());
			othRevInvstCmBcFund.setRevName(root.getOpRev_YTD_label_15());
			othRevInvstCmBcFund.setRevType(root.getOpRev_otherRev_label());
			othRevInvstCmBcFund.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev othRevFoodServ = new LtcYtdRev();
			othRevFoodServ.setRevYTD(root.getOpRev_YTD16());
			othRevFoodServ.setRevNotes(root.getOpRev_note16());
			othRevFoodServ.setRevName(root.getOpRev_YTD_label_16());
			othRevFoodServ.setRevType(root.getOpRev_otherRev_label());
			othRevFoodServ.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev othRevLdryServ = new LtcYtdRev();
			othRevLdryServ.setRevYTD(root.getOpRev_YTD17());
			othRevLdryServ.setRevNotes(root.getOpRev_note17());
			othRevLdryServ.setRevName(root.getOpRev_YTD_label_17());
			othRevLdryServ.setRevType(root.getOpRev_otherRev_label());
			othRevLdryServ.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev othRevCabl = new LtcYtdRev();
			othRevCabl.setRevYTD(root.getOpRev_YTD18());
			othRevCabl.setRevNotes(root.getOpRev_note18());
			othRevCabl.setRevName(root.getOpRev_YTD_label_18());
			othRevCabl.setRevType(root.getOpRev_otherRev_label());
			othRevCabl.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev othRevOthRec = new LtcYtdRev();
			othRevOthRec.setRevYTD(root.getOpRev_YTD19());
			othRevOthRec.setRevNotes(root.getOpRev_note19());
			othRevOthRec.setRevName(root.getOpRev_YTD_label_19());
			othRevOthRec.setRevType(root.getOpRev_otherRev_label());
			othRevOthRec.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdRev othRevOthSpcfy = new LtcYtdRev();
			othRevOthSpcfy.setRevYTD(root.getOpRev_YTD20());
			othRevOthSpcfy.setRevNotes(root.getOpRev_note20());
			othRevOthSpcfy.setRevName(root.getOpRev_YTD_label_20());
			othRevOthSpcfy.setRevType(root.getOpRev_otherRev_label());
			othRevOthSpcfy.setConfirmationId(root.getForm().getConfirmationId());
			Collections.addAll(ltcYtdRev, revFrmHA1Adj, revFrmHA1DirCare, revFrmHA1Others, revFrmHA2OpFundMinEq,
					revFrmHA2OpFundOth, revFrmHA3, revFrmHA4OccThld, revFrmHA4CliConReconc, revFrmHA4DirCare,
					revFrmHA4Oth, clntRvnHAClient, clntRvnFeePaidParties, clntRvnFeePaidNonEligible, othRevInvstOpFund,
					othRevInvstCmBcFund, othRevFoodServ, othRevLdryServ, othRevCabl, othRevOthRec, othRevOthSpcfy, 
					nonOperatingRevOth, nonOperatingRevOthThirdParty);

			/* Subtotals */
			LtcYtdRevSubTotals revFromHA1Subttl = new LtcYtdRevSubTotals();
			revFromHA1Subttl.setConfirmationId(root.getForm().getConfirmationId());
			revFromHA1Subttl.setRevType(root.getOpRev_1_label());
			revFromHA1Subttl.setSubTotalRevYtd(root.getOpRev_sum11());
			revFromHA1Subttl.setSubTotalRevNotes(root.getOpRev_sum_note1());

			LtcYtdRevSubTotals revFromHA2Subttl = new LtcYtdRevSubTotals();
			revFromHA2Subttl.setConfirmationId(root.getForm().getConfirmationId());
			revFromHA2Subttl.setRevType(root.getOpRev_2_label());
			revFromHA2Subttl.setSubTotalRevYtd(root.getOpRev_sum12());
			revFromHA2Subttl.setSubTotalRevNotes(root.getOpRev_sum_note2());

			LtcYtdRevSubTotals revFromHA4Subttl = new LtcYtdRevSubTotals();
			revFromHA4Subttl.setConfirmationId(root.getForm().getConfirmationId());
			revFromHA4Subttl.setRevType(root.getOpRev_4_label());
			revFromHA4Subttl.setSubTotalRevYtd(root.getOpRev_sum13());
			revFromHA4Subttl.setSubTotalRevNotes(root.getOpRev_sum_note3());

			LtcYtdRevSubTotals clntRevSubttl = new LtcYtdRevSubTotals();
			clntRevSubttl.setConfirmationId(root.getForm().getConfirmationId());
			clntRevSubttl.setRevType(root.getOpRev_client_label());
			clntRevSubttl.setSubTotalRevYtd(root.getOpRev_sum14());
			clntRevSubttl.setSubTotalRevNotes(root.getOpRev_sum_note4());

			LtcYtdRevSubTotals othRevSubttl = new LtcYtdRevSubTotals();
			othRevSubttl.setConfirmationId(root.getForm().getConfirmationId());
			othRevSubttl.setRevType(root.getOpRev_otherRev_label());
			othRevSubttl.setSubTotalRevYtd(root.getOpRev_sum15());
			othRevSubttl.setSubTotalRevNotes(root.getOpRev_sum_note5());

			LtcYtdRevSubTotals opRevSubttl = new LtcYtdRevSubTotals();
			opRevSubttl.setConfirmationId(root.getForm().getConfirmationId());
			opRevSubttl.setRevType(root.getOpRev_YTD_total_label());
			opRevSubttl.setSubTotalRevYtd(root.getOpRev_YTD_total());
			opRevSubttl.setSubTotalRevNotes(root.getOpRev_total_note());

			LtcYtdRevSubTotals nonOpRevSubttl = new LtcYtdRevSubTotals();
			nonOpRevSubttl.setConfirmationId(root.getForm().getConfirmationId());
			nonOpRevSubttl.setRevType(root.getNopRev_label());
			nonOpRevSubttl.setSubTotalRevYtd(root.getNopRev_sum11());
			nonOpRevSubttl.setSubTotalRevNotes(root.getNopRev_sub_note());

			Collections.addAll(ltcYtdRevSubTtls, revFromHA1Subttl,revFromHA2Subttl,revFromHA4Subttl,clntRevSubttl,othRevSubttl,opRevSubttl, nonOpRevSubttl);

			LtcYtdExp dirCareCostExp = new LtcYtdExp();
			dirCareCostExp.setExpYtd(root.getOpEx_YTD1());
			dirCareCostExp.setExpNotes(root.getOpEx_note1());
			dirCareCostExp.setExpName(root.getOpEx_YTD_label1());
			dirCareCostExp.setExpType(root.getOpEx_1A_label());
			dirCareCostExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp foodCostExp = new LtcYtdExp();
			foodCostExp.setExpYtd(root.getOpEx_YTD2());
			foodCostExp.setExpNotes(root.getOpEx_note2());
			foodCostExp.setExpName(root.getOpEx_YTD_label2());
			foodCostExp.setExpType(root.getOpEx_1A_label());
			foodCostExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp ldryServExp = new LtcYtdExp();
			ldryServExp.setExpYtd(root.getOpEx_YTD3());
			ldryServExp.setExpNotes(root.getOpEx_note3());
			ldryServExp.setExpName(root.getOpEx_YTD_label3());
			ldryServExp.setExpType(root.getOpEx_1A_label());
			ldryServExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp housekeepingCostExp = new LtcYtdExp();
			housekeepingCostExp.setExpYtd(root.getOpEx_YTD4());
			housekeepingCostExp.setExpNotes(root.getOpEx_note4());
			housekeepingCostExp.setExpName(root.getOpEx_YTD_label4());
			housekeepingCostExp.setExpType(root.getOpEx_1A_label());
			housekeepingCostExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp adminServCostExp = new LtcYtdExp();
			adminServCostExp.setExpYtd(root.getOpEx_YTD5());
			adminServCostExp.setExpNotes(root.getOpEx_note5());
			adminServCostExp.setExpName(root.getOpEx_YTD_label5());
			adminServCostExp.setExpType(root.getOpEx_1A_label());
			adminServCostExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp plantMainOpStaffExp = new LtcYtdExp();
			plantMainOpStaffExp.setExpYtd(root.getOpEx_YTD6());
			plantMainOpStaffExp.setExpNotes(root.getOpEx_note6());
			plantMainOpStaffExp.setExpName(root.getOpEx_YTD_label6());
			plantMainOpStaffExp.setExpType(root.getOpEx_1A_label());
			plantMainOpStaffExp.setConfirmationId(root.getForm().getConfirmationId());

			// subtotal before salary and wages - omitted
			LtcYtdExp salWagRecvExp = new LtcYtdExp();
			salWagRecvExp.setExpYtd(root.getOpEx_YTD7());
			salWagRecvExp.setExpNotes(root.getOpEx_note7());
			salWagRecvExp.setExpName(root.getOpEx_YTD_label7());
			salWagRecvExp.setExpType(root.getOpEx_1A_label());
			salWagRecvExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp salWagAccExp = new LtcYtdExp();
			salWagAccExp.setExpYtd(root.getOpEx_YTD8());
			salWagAccExp.setExpNotes(root.getOpEx_note8());
			salWagAccExp.setExpName(root.getOpEx_YTD_label8());
			salWagAccExp.setExpType(root.getOpEx_1A_label());
			salWagAccExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp othLabCostExp = new LtcYtdExp();
			othLabCostExp.setExpYtd(root.getOpEx_YTD9());
			othLabCostExp.setExpNotes(root.getOpEx_note9());
			othLabCostExp.setExpName(root.getOpEx_YTD_label9());
			othLabCostExp.setExpType(root.getOpEx_1A_label());
			othLabCostExp.setConfirmationId(root.getForm().getConfirmationId());

			// subtotal

			LtcYtdExp bnftCostExp = new LtcYtdExp();
			bnftCostExp.setExpYtd(root.getOpEx_YTD10());
			bnftCostExp.setExpNotes(root.getOpEx_note10());
			bnftCostExp.setExpName(root.getOpEx_YTD_label10());
			bnftCostExp.setExpType(root.getOpEx_1B_label());
			bnftCostExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp sickSevrnceAccExp = new LtcYtdExp();
			sickSevrnceAccExp.setExpYtd(root.getOpEx_YTD11());
			sickSevrnceAccExp.setExpNotes(root.getOpEx_note11());
			sickSevrnceAccExp.setExpName(root.getOpEx_YTD_label11());
			sickSevrnceAccExp.setExpType(root.getOpEx_1B_label());
			sickSevrnceAccExp.setConfirmationId(root.getForm().getConfirmationId());

			// subtotal
			LtcYtdExp buildingRentExp = new LtcYtdExp();
			buildingRentExp.setExpYtd(root.getOpEx_YTD12());
			buildingRentExp.setExpNotes(root.getOpEx_note12());
			buildingRentExp.setExpName(root.getOpEx_YTD_label12());
			buildingRentExp.setExpType(root.getOpEx_2_label());
			buildingRentExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp intrstMortgageLngTrmExp = new LtcYtdExp();
			intrstMortgageLngTrmExp.setExpYtd(root.getOpEx_YTD13());
			intrstMortgageLngTrmExp.setExpNotes(root.getOpEx_note13());
			intrstMortgageLngTrmExp.setExpName(root.getOpEx_YTD_label13());
			intrstMortgageLngTrmExp.setExpType(root.getOpEx_2_label());
			intrstMortgageLngTrmExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp propertyTaxesExp = new LtcYtdExp();
			propertyTaxesExp.setExpYtd(root.getOpEx_YTD14());
			propertyTaxesExp.setExpNotes(root.getOpEx_note14());
			propertyTaxesExp.setExpName(root.getOpEx_YTD_label14());
			propertyTaxesExp.setExpType(root.getOpEx_2_label());
			propertyTaxesExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp mntnceExp = new LtcYtdExp();
			mntnceExp.setExpYtd(root.getOpEx_YTD15());
			mntnceExp.setExpNotes(root.getOpEx_note15());
			mntnceExp.setExpName(root.getOpEx_YTD_label15());
			mntnceExp.setExpType(root.getOpEx_2_label());
			mntnceExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp suppliesExp = new LtcYtdExp();
			suppliesExp.setExpYtd(root.getOpEx_YTD16());
			suppliesExp.setExpNotes(root.getOpEx_note16());
			suppliesExp.setExpName(root.getOpEx_YTD_label16());
			suppliesExp.setExpType(root.getOpEx_2_label());
			suppliesExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp utilitiesExp = new LtcYtdExp();
			utilitiesExp.setExpYtd(root.getOpEx_YTD17());
			utilitiesExp.setExpNotes(root.getOpEx_note17());
			utilitiesExp.setExpName(root.getOpEx_YTD_label17());
			utilitiesExp.setExpType(root.getOpEx_2_label());
			utilitiesExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp wasteMgmntExp = new LtcYtdExp();
			wasteMgmntExp.setExpYtd(root.getOpEx_YTD18());
			wasteMgmntExp.setExpNotes(root.getOpEx_note18());
			wasteMgmntExp.setExpName(root.getOpEx_YTD_label18());
			wasteMgmntExp.setExpType(root.getOpEx_2_label());
			wasteMgmntExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp resTranServExp = new LtcYtdExp();
			resTranServExp.setExpYtd(root.getOpEx_YTD19());
			resTranServExp.setExpNotes(root.getOpEx_note19());
			resTranServExp.setExpName(root.getOpEx_YTD_label19());
			resTranServExp.setExpType(root.getOpEx_2_label());
			resTranServExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp othExp = new LtcYtdExp();
			othExp.setExpYtd(root.getOpEx_YTD20());
			othExp.setExpNotes(root.getOpEx_note20());
			othExp.setExpName(root.getOpEx_YTD_label20());
			othExp.setExpType(root.getOpEx_2_label());
			othExp.setConfirmationId(root.getForm().getConfirmationId());

			// skipping subtotal for now

			LtcYtdExp medSupExp = new LtcYtdExp();
			medSupExp.setExpYtd(root.getOpEx_YTD21());
			medSupExp.setExpNotes(root.getOpEx_note21());
			medSupExp.setExpName(root.getOpEx_YTD_label21());
			medSupExp.setExpType(root.getOpEx_3_label());
			medSupExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp drgsPharmaExp = new LtcYtdExp();
			drgsPharmaExp.setExpYtd(root.getOpEx_YTD22());
			drgsPharmaExp.setExpNotes(root.getOpEx_note22());
			drgsPharmaExp.setExpName(root.getOpEx_YTD_label22());
			drgsPharmaExp.setExpType(root.getOpEx_3_label());
			drgsPharmaExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp rawFoodCostExp = new LtcYtdExp();
			rawFoodCostExp.setExpYtd(root.getOpEx_YTD23());
			rawFoodCostExp.setExpNotes(root.getOpEx_note23());
			rawFoodCostExp.setExpName(root.getOpEx_YTD_label23());
			rawFoodCostExp.setExpType(root.getOpEx_3_label());
			rawFoodCostExp.setConfirmationId(root.getForm().getConfirmationId());

			

			LtcYtdExp dietSupExp = new LtcYtdExp();
			dietSupExp.setExpYtd(root.getOpEx_YTD24());
			dietSupExp.setExpNotes(root.getOpEx_note24());
			dietSupExp.setExpName(root.getOpEx_YTD_label24());
			dietSupExp.setExpType(root.getOpEx_3_label());
			dietSupExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp ldrySupExp = new LtcYtdExp();
			ldrySupExp.setExpYtd(root.getOpEx_YTD25());
			ldrySupExp.setExpNotes(root.getOpEx_note25());
			ldrySupExp.setExpName(root.getOpEx_YTD_label25());
			ldrySupExp.setExpType(root.getOpEx_3_label());
			ldrySupExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp houseSupExp = new LtcYtdExp();
			houseSupExp.setExpYtd(root.getOpEx_YTD26());
			houseSupExp.setExpNotes(root.getOpEx_note26());
			houseSupExp.setExpName(root.getOpEx_YTD_label26());
			houseSupExp.setExpType(root.getOpEx_3_label());
			houseSupExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp incontinenceSupExp = new LtcYtdExp();
			incontinenceSupExp.setExpYtd(root.getOpEx_YTD27());
			incontinenceSupExp.setExpNotes(root.getOpEx_note27());
			incontinenceSupExp.setExpName(root.getOpEx_YTD_label27());
			incontinenceSupExp.setExpType(root.getOpEx_3_label());
			incontinenceSupExp.setConfirmationId(root.getForm().getConfirmationId());

			//
			/* Subtotals */
			LtcYtdExpSubTotals staffCost1ASubtotal = new LtcYtdExpSubTotals();
			staffCost1ASubtotal.setConfirmationId(root.getForm().getConfirmationId());
			staffCost1ASubtotal.setExpType(root.getOpEx_1A_label());
			staffCost1ASubtotal.setSubTotalExpYtd(root.getOpEx_sum11());
			staffCost1ASubtotal.setSubTotalExpNotes(root.getOpEx_sum_note1());

			LtcYtdExpSubTotals staffCost1BSubtotal = new LtcYtdExpSubTotals();
			staffCost1BSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			staffCost1BSubtotal.setExpType(root.getOpEx_1B_label());
			staffCost1BSubtotal.setSubTotalExpYtd(root.getOpEx_sum12());
			staffCost1BSubtotal.setSubTotalExpNotes(root.getOpEx_sum_note2());

			LtcYtdExpSubTotals propertyCostSubtotal = new LtcYtdExpSubTotals();
			propertyCostSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			propertyCostSubtotal.setExpType(root.getOpEx_2_label());
			propertyCostSubtotal.setSubTotalExpYtd(root.getOpEx_sum13());
			propertyCostSubtotal.setSubTotalExpNotes(root.getOpEx_sum_note3());

			LtcYtdExpSubTotals suppliesSubtotal = new LtcYtdExpSubTotals();
			suppliesSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			suppliesSubtotal.setExpType(root.getOpEx_3_label());
			suppliesSubtotal.setSubTotalExpYtd(root.getOpEx_sum14());
			suppliesSubtotal.setSubTotalExpNotes(root.getOpEx_sum_note4());

			LtcYtdExpSubTotals adminCostSubtotal = new LtcYtdExpSubTotals();
			adminCostSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			adminCostSubtotal.setExpType(root.getOpEx_4_label());
			adminCostSubtotal.setSubTotalExpYtd(root.getOpEx_sum15());
			adminCostSubtotal.setSubTotalExpNotes(root.getOpEx_sum_note5());

			LtcYtdExpSubTotals operatingCostSubtotal = new LtcYtdExpSubTotals();
			operatingCostSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			operatingCostSubtotal.setExpType(root.getOpEx_data_total_label());
			operatingCostSubtotal.setSubTotalExpYtd(root.getOpEx_data_total());
			operatingCostSubtotal.setSubTotalExpNotes(root.getOpEx_total_note());

			LtcYtdExpSubTotals nonOperationalExpSubtotal = new LtcYtdExpSubTotals();
			nonOperationalExpSubtotal.setConfirmationId(root.getForm().getConfirmationId());
			nonOperationalExpSubtotal.setExpType(root.getNopEx_label());
			nonOperationalExpSubtotal.setSubTotalExpYtd(root.getNopEx_sum11());
			nonOperationalExpSubtotal.setSubTotalExpNotes(root.getNopEx_sub_note());

			LtcYtdExpSubTotals beforeSalaryWagesRecAcc = new LtcYtdExpSubTotals();
			beforeSalaryWagesRecAcc.setConfirmationId(root.getForm().getConfirmationId());
			beforeSalaryWagesRecAcc.setExpType("Before salary/wages rec./accruals");
			beforeSalaryWagesRecAcc.setSubTotalExpYtd(root.getOpEx_sub1());
			beforeSalaryWagesRecAcc.setSubTotalExpNotes(root.getOpEx_sub_note());

			// /getOpEx_sub1()

			Collections.addAll(ltcYtdExpSubttls,staffCost1ASubtotal,staffCost1BSubtotal,propertyCostSubtotal,suppliesSubtotal,adminCostSubtotal,operatingCostSubtotal, nonOperationalExpSubtotal,
			 beforeSalaryWagesRecAcc);

			/* END */

			/*LtcYtdDep */
			LtcYtdDep buildingDep = new LtcYtdDep();
			buildingDep.setConfirmationId(root.getForm().getConfirmationId());
			buildingDep.setDepName(root.getOpEx_YTD_label38());
			buildingDep.setDepYtd(root.getOpEx_item138());
			buildingDep.setDepNotes(root.getOpEx_note38());

			LtcYtdDep furnitureEquipmentDep = new LtcYtdDep();
			furnitureEquipmentDep.setConfirmationId(root.getForm().getConfirmationId());
			furnitureEquipmentDep.setDepName(root.getOpEx_YTD_label39());
			furnitureEquipmentDep.setDepYtd(root.getOpEx_item139());
			furnitureEquipmentDep.setDepNotes(root.getOpEx_note39());

			Collections.addAll(ltcYtdDep, buildingDep, furnitureEquipmentDep);
			/* END */

			/* LTC YTD SUBTOTALS */

			LtcYtdDepSubTotals subTotalYtdDep = new LtcYtdDepSubTotals();
			subTotalYtdDep.setConfirmationId(root.getForm().getConfirmationId());
			subTotalYtdDep.setSubTotalDepYtd(root.getOpEx_sum16());
			subTotalYtdDep.setSubTotalDepNotes(root.getOpEx_note_sum6());

			Collections.addAll(ltcYtdDepSubTotals, subTotalYtdDep);
			/* END */

			/* LtcYtdSumTotals */
			LtcYtdSumTotals totalNonOperatingSurplus = new LtcYtdSumTotals();
			totalNonOperatingSurplus.setConfirmationId(root.getForm().getConfirmationId());
			totalNonOperatingSurplus.setTotName(root.getNopSu_data_label());
			totalNonOperatingSurplus.setSumYTD(root.getNopSu_data1());
			totalNonOperatingSurplus.setTotNotes(root.getNopSu_note());

			LtcYtdSumTotals operatingSurplusBeforeDepreciation = new LtcYtdSumTotals();
			operatingSurplusBeforeDepreciation.setConfirmationId(root.getForm().getConfirmationId());
			operatingSurplusBeforeDepreciation.setTotName(root.getOpSuB_item11_label());
			operatingSurplusBeforeDepreciation.setSumYTD(root.getOpSuB_item11());
			operatingSurplusBeforeDepreciation.setTotNotes(root.getOpSuB_note());

			LtcYtdSumTotals totalOperatingSurplus = new LtcYtdSumTotals();
			totalOperatingSurplus.setConfirmationId(root.getForm().getConfirmationId());
			totalOperatingSurplus.setTotName(root.getOpSu_data_total_label());
			totalOperatingSurplus.setSumYTD(root.getOpSu_data_total());
			totalOperatingSurplus.setTotNotes(root.getOpSu_data_total_note());

			Collections.addAll(ltcYtdSumTotals, operatingSurplusBeforeDepreciation, totalNonOperatingSurplus,
			 totalOperatingSurplus);

			/* END */
			
			LtcYtdExp OthSupExp = new LtcYtdExp();
			OthSupExp.setExpYtd(root.getOpEx_YTD28());
			OthSupExp.setExpNotes(root.getOpEx_note28());
			OthSupExp.setExpName(root.getOpEx_YTD_label28());
			OthSupExp.setExpType(root.getOpEx_3_label());
			OthSupExp.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp officeExpAdCost = new LtcYtdExp();
			officeExpAdCost.setExpYtd(root.getOpEx_YTD29());
			officeExpAdCost.setExpNotes(root.getOpEx_note29());
			officeExpAdCost.setExpName(root.getOpEx_YTD_label29());
			officeExpAdCost.setExpType(root.getOpEx_4_label());
			officeExpAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp mgmntAdCost = new LtcYtdExp();
			mgmntAdCost.setExpYtd(root.getOpEx_YTD30());
			mgmntAdCost.setExpNotes(root.getOpEx_note30());
			mgmntAdCost.setExpName(root.getOpEx_YTD_label30());
			mgmntAdCost.setExpType(root.getOpEx_4_label());
			mgmntAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp hoAllocpAdCost = new LtcYtdExp();
			hoAllocpAdCost.setExpYtd(root.getOpEx_YTD31());
			hoAllocpAdCost.setExpNotes(root.getOpEx_note31());
			hoAllocpAdCost.setExpName(root.getOpEx_YTD_label31());
			hoAllocpAdCost.setExpType(root.getOpEx_4_label());
			hoAllocpAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp accAdCost = new LtcYtdExp();
			accAdCost.setExpYtd(root.getOpEx_YTD32());
			accAdCost.setExpNotes(root.getOpEx_note32());
			accAdCost.setExpName(root.getOpEx_YTD_label32());
			accAdCost.setExpType(root.getOpEx_4_label());
			accAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp apaAdCost = new LtcYtdExp();
			apaAdCost.setExpYtd(root.getOpEx_YTD33());
			apaAdCost.setExpNotes(root.getOpEx_note33());
			apaAdCost.setExpName(root.getOpEx_YTD_label33());
			apaAdCost.setExpType(root.getOpEx_4_label());
			apaAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp insuranceAdCost = new LtcYtdExp();
			insuranceAdCost.setExpYtd(root.getOpEx_YTD34());
			insuranceAdCost.setExpNotes(root.getOpEx_note34());
			insuranceAdCost.setExpName(root.getOpEx_YTD_label34());
			insuranceAdCost.setExpType(root.getOpEx_4_label());
			insuranceAdCost.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp adminSupAdCost = new LtcYtdExp();
			adminSupAdCost.setExpYtd(root.getOpEx_YTD35());
			adminSupAdCost.setExpNotes(root.getOpEx_note35());
			adminSupAdCost.setExpName(root.getOpEx_YTD_label35());
			adminSupAdCost.setExpType(root.getOpEx_4_label());
			adminSupAdCost.setConfirmationId(root.getForm().getConfirmationId());

			// Bad Dept does not exist on older submissions, creating it only if it is present in the payload
			if(root.getOpEx_YTD_label37() != null){
				LtcYtdExp badDeptAdCost = new LtcYtdExp();
				badDeptAdCost.setExpYtd(root.getOpEx_YTD37());
				badDeptAdCost.setExpNotes(root.getOpEx_note37());
				badDeptAdCost.setExpName(root.getOpEx_YTD_label37());
				badDeptAdCost.setExpType(root.getOpEx_4_label());
				badDeptAdCost.setConfirmationId(root.getForm().getConfirmationId());

				Collections.addAll(ltcYtdExp, badDeptAdCost);
			}


			LtcYtdExp othAdCost = new LtcYtdExp();
			othAdCost.setExpYtd(root.getOpEx_YTD36());
			othAdCost.setExpNotes(root.getOpEx_note36());
			othAdCost.setExpName(root.getOpEx_YTD_label36());
			othAdCost.setExpType(root.getOpEx_4_label());
			othAdCost.setConfirmationId(root.getForm().getConfirmationId());

			
			/* Non operating expense */
			LtcYtdExp dirCareNonOpExpMortgage = new LtcYtdExp();
			dirCareNonOpExpMortgage.setExpYtd(root.getNopEx_YTD1());
			dirCareNonOpExpMortgage.setExpNotes(root.getNopEx_note1());
			dirCareNonOpExpMortgage.setExpName(root.getNopEx_YTD_label1());
			dirCareNonOpExpMortgage.setExpType(root.getNopEx_label());
			dirCareNonOpExpMortgage.setConfirmationId(root.getForm().getConfirmationId());

			LtcYtdExp dirCareNonOpExpOther = new LtcYtdExp();
			dirCareNonOpExpOther.setExpYtd(root.getNopEx_YTD2());
			dirCareNonOpExpOther.setExpNotes(root.getNopEx_note2());
			dirCareNonOpExpOther.setExpName(root.getNopEx_YTD_label2());
			dirCareNonOpExpOther.setExpType(root.getNopEx_label());
			dirCareNonOpExpOther.setConfirmationId(root.getForm().getConfirmationId());
			/* END */

			
			Collections.addAll(ltcYtdExp, dirCareCostExp, foodCostExp, ldryServExp, housekeepingCostExp,
					adminServCostExp, plantMainOpStaffExp, salWagRecvExp, salWagAccExp, othLabCostExp, bnftCostExp,
					sickSevrnceAccExp, buildingRentExp, intrstMortgageLngTrmExp, propertyTaxesExp, mntnceExp,
					suppliesExp, utilitiesExp, wasteMgmntExp, resTranServExp, othExp, medSupExp, rawFoodCostExp,
					drgsPharmaExp, dietSupExp, ldrySupExp, houseSupExp, incontinenceSupExp, OthSupExp, officeExpAdCost,
					mgmntAdCost, hoAllocpAdCost, accAdCost, apaAdCost, insuranceAdCost, adminSupAdCost,
					othAdCost, dirCareNonOpExpMortgage, dirCareNonOpExpOther);

			// subtotal
			// total operating expenses

			//DIRECT CARE VACANCY : 
			//LtcYtdDirectCareVacancy

			LtcYtdDirectCareVacancy directCareVacancyNurseRN = new LtcYtdDirectCareVacancy();
			directCareVacancyNurseRN.setConfirmationId(root.getForm().getConfirmationId());
			directCareVacancyNurseRN.setDirectCareVacancyType(root.getNursing_label());
			directCareVacancyNurseRN.setDirectCareVacancyName(root.getNursing_label1());
			directCareVacancyNurseRN.setDirectCareVacPositions(root.getNursingNVP_item11());

			LtcYtdDirectCareVacancy directCareVacancyNurseLPN = new LtcYtdDirectCareVacancy();
			directCareVacancyNurseLPN.setConfirmationId(root.getForm().getConfirmationId());
			directCareVacancyNurseLPN.setDirectCareVacancyType(root.getNursing_label());
			directCareVacancyNurseLPN.setDirectCareVacancyName(root.getNursing_label2());
			directCareVacancyNurseLPN.setDirectCareVacPositions(root.getNursingNVP_item12());

			LtcYtdDirectCareVacancy directCareVacancyNurseHCA = new LtcYtdDirectCareVacancy();
			directCareVacancyNurseHCA.setConfirmationId(root.getForm().getConfirmationId());
			directCareVacancyNurseHCA.setDirectCareVacancyType(root.getNursing_label());
			directCareVacancyNurseHCA.setDirectCareVacancyName(root.getNursing_label3());
			directCareVacancyNurseHCA.setDirectCareVacPositions(root.getNursingNVP_item13());

			LtcYtdDirectCareVacancy directCareVacancyNurseOther = new LtcYtdDirectCareVacancy();
			directCareVacancyNurseOther.setConfirmationId(root.getForm().getConfirmationId());
			directCareVacancyNurseOther.setDirectCareVacancyType(root.getNursing_label());
			directCareVacancyNurseOther.setDirectCareVacancyName(Constants.DEFAULT_OTHER_VALUE);
			directCareVacancyNurseOther.setDirectCareVacPositions(root.getNursingNVP_item14());
			directCareVacancyNurseOther.setDirectCareVacOtherName(root.getNursing_label4());

			Collections.addAll(LtcYtdDirectCareVacancy, directCareVacancyNurseRN, directCareVacancyNurseLPN,
			 directCareVacancyNurseHCA, directCareVacancyNurseOther);

			
			/* Bed Inventory */

			/* mandatory bed grid */
			int bedGrid0Index = 0;
			for (BedGrid0 maxOcp : root.getBedGrid0()) {
				LtcBedYtdMaxOccupancy numOfBeds = new LtcBedYtdMaxOccupancy();
				numOfBeds.setBedIndex(Integer.toString(++bedGrid0Index));
				numOfBeds.setBedFundingType(maxOcp.getBedType());
				numOfBeds.setQuarterInventory("Inventory");
				numOfBeds.setConfirmationId(root.getForm().getConfirmationId());
				numOfBeds.setStartDate(maxOcp.getStartDate0());
				numOfBeds.setEndDate(maxOcp.getEndDate0());
				numOfBeds.setNumberOfBeds(maxOcp.getNumberOfBeds());
				numOfBeds.setMaximumBedDays(maxOcp.getMaximumBedDays());
				numOfBeds.setNotes(maxOcp.getInventoryNotes());
				numOfBeds.setBedSubype(maxOcp.getSubTypeLabel());

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
			ytdInScopeMaxBedOccupancy.setTotalBedQuarter1(root.getInScopeBedTotal1());
			ytdInScopeMaxBedOccupancy.setTotalBedQuarter2(root.getInScopeBedTotal2());
			ytdInScopeMaxBedOccupancy.setTotalBedQuarter3(root.getInScopeBedTotal3());
			ytdInScopeMaxBedOccupancy.setTotalBedQuarter4(root.getInScopeBedTotal4());
			ytdInScopeMaxBedOccupancy.setTotalBedDays(root.getInScopeBedTotalYTD());

			LtcBedYtdMaxOccupancyTotals ytdOutOfScopeMaxBedOccupancy = new LtcBedYtdMaxOccupancyTotals();
			ytdOutOfScopeMaxBedOccupancy.setConfirmationID(root.getForm().getConfirmationId());
			ytdOutOfScopeMaxBedOccupancy.setOccupancyType("YTD Maximum Bed Occupancy");
			ytdOutOfScopeMaxBedOccupancy.setBedFundingType("Out of Scope Max Beds Days");
			ytdOutOfScopeMaxBedOccupancy.setTotalBedQuarter1(root.getOutScopeBedTotal1());
			ytdOutOfScopeMaxBedOccupancy.setTotalBedQuarter2(root.getOutScopeBedTotal2());
			ytdOutOfScopeMaxBedOccupancy.setTotalBedQuarter3(root.getOutScopeBedTotal3());
			ytdOutOfScopeMaxBedOccupancy.setTotalBedQuarter4(root.getOutScopeBedTotal4());
			ytdOutOfScopeMaxBedOccupancy.setTotalBedDays(root.getOutScopeBedTotalYTD());

			LtcBedYtdMaxOccupancyTotals ytdPrivateMaxBedOccupancy = new LtcBedYtdMaxOccupancyTotals();
			ytdPrivateMaxBedOccupancy.setConfirmationID(root.getForm().getConfirmationId());
			ytdPrivateMaxBedOccupancy.setOccupancyType("YTD Maximum Bed Occupancy");
			ytdPrivateMaxBedOccupancy.setBedFundingType("Private Max Beds Days");
			ytdPrivateMaxBedOccupancy.setTotalBedQuarter1(root.getPrivateBedTotal1());
			ytdPrivateMaxBedOccupancy.setTotalBedQuarter2(root.getPrivateBedTotal2());
			ytdPrivateMaxBedOccupancy.setTotalBedQuarter3(root.getPrivateBedTotal3());
			ytdPrivateMaxBedOccupancy.setTotalBedQuarter4(root.getPrivateBedTotal4());
			ytdPrivateMaxBedOccupancy.setTotalBedDays(root.getPrivateBedTotalYTD());

			LtcBedYtdMaxOccupancyTotals ytdTotalMaxBedOccupancy = new LtcBedYtdMaxOccupancyTotals();
			ytdTotalMaxBedOccupancy.setConfirmationID(root.getForm().getConfirmationId());
			ytdTotalMaxBedOccupancy.setOccupancyType("YTD Maximum Bed Occupancy");
			ytdTotalMaxBedOccupancy.setBedFundingType("Total Max Bed Days");
			ytdTotalMaxBedOccupancy.setTotalBedQuarter1(root.getTotalBed1());
			ytdTotalMaxBedOccupancy.setTotalBedQuarter2(root.getTotalBed2());
			ytdTotalMaxBedOccupancy.setTotalBedQuarter3(root.getTotalBed3());
			ytdTotalMaxBedOccupancy.setTotalBedQuarter4(root.getTotalBed4());
			ytdTotalMaxBedOccupancy.setTotalBedDays(root.getTotalBedYTD());

			Collections.addAll(ltcBedYtdMaxOccTtls,plannedInScopeOccupancy,plannedOutOfScopeOccupancy,plannedPrivateOccupancy,plannedTotalMaxBedOccupancy,ytdTotalMaxBedOccupancy,ytdInScopeMaxBedOccupancy,ytdOutOfScopeMaxBedOccupancy,ytdPrivateMaxBedOccupancy);
			


			switch (root.getQuarter()) {
			case "q1":
				// bed grid
				int bedGrid1Index = 0;
				for (BedGrid1 maxOcp : root.getBedGrid1()) {
					LtcBedYtdMaxOccupancy numOfBeds = new LtcBedYtdMaxOccupancy();
					numOfBeds.setBedIndex(Integer.toString(++bedGrid1Index));
					numOfBeds.setBedFundingType(maxOcp.getBedType1());
					numOfBeds.setConfirmationId(root.getForm().getConfirmationId());
					numOfBeds.setStartDate(maxOcp.getStartDate1());
					numOfBeds.setEndDate(maxOcp.getEndDate1());
					numOfBeds.setNumberOfBeds(maxOcp.getNumberOfBeds1());
					numOfBeds.setMaximumBedDays(maxOcp.getMaximumBedDays1());
					numOfBeds.setQuarterInventory("Q1");
					numOfBeds.setNotes(maxOcp.getQuarterNote1());
					numOfBeds.setBedSubype(maxOcp.getSubTypeLabel());
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
				occOutRateQ1.setPlanMaxOccDays(root.getyTDPlannedOutScopeQ1());
				occOutRateQ1.setYtdMaxOccDays(root.getyTDMaxOutScopeQ1());
				occOutRateQ1.setYtdOccDays(root.getyTDOccupiedOutScopeQ1());
				occOutRateQ1.setPercentOcc(root.getOccupiedPercentageOutScopeQ1());
				occOutRateQ1.setOccRateQuarter("Q1");
				//occOutRateQ1.setOccRateNotes(root.getNoteInScopeQ1());

				LtcBedYtdOccupancyRate occRateQ1 = new LtcBedYtdOccupancyRate();
				occRateQ1.setConfirmationID(root.getForm().getConfirmationId());
				occRateQ1.setOccRateBedTypes("Private Beds");
				occRateQ1.setPlanMaxOccDays(root.getyTDPlannedPrivateQ1());
				occRateQ1.setYtdMaxOccDays(root.getyTDMaxPrivateQ1());
				occRateQ1.setYtdOccDays(root.getyTDOccupiedPrivateQ1());
				occRateQ1.setPercentOcc(root.getOccupiedPercentagePrivateQ1());
				occRateQ1.setOccRateQuarter("Q1");
				//occRateQ1.setOccRateNotes(root.getNoteInScopeQ1());

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
				int bedGrid2Index = 0;
				for (BedGrid2 maxOcp : root.getBedGrid2()) {
					LtcBedYtdMaxOccupancy numOfBeds = new LtcBedYtdMaxOccupancy();
					numOfBeds.setBedIndex(Integer.toString(++bedGrid2Index));
					numOfBeds.setBedFundingType(maxOcp.getBedType2());
					numOfBeds.setConfirmationId(root.getForm().getConfirmationId());
					numOfBeds.setStartDate(maxOcp.getStartDate2());
					numOfBeds.setEndDate(maxOcp.getEndDate2());
					numOfBeds.setNumberOfBeds(maxOcp.getNumberOfBeds2());
					numOfBeds.setMaximumBedDays(maxOcp.getMaximumBedDays2());
					numOfBeds.setQuarterInventory("Q2");
					numOfBeds.setNotes(maxOcp.getNotes2());
					numOfBeds.setBedSubype(maxOcp.getSubTypeLabel());
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
				augYtdOccDays.setOccMonth("August");
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
				occOutRateQ2.setPlanMaxOccDays(root.getyTDPlannedOutScopeQ2());
				occOutRateQ2.setYtdMaxOccDays(root.getyTDMaxOutScopeQ2());
				occOutRateQ2.setYtdOccDays(root.getyTDOccupiedOutScopeQ2());
				occOutRateQ2.setPercentOcc(root.getOccupiedPercentageOutScopeQ2());
				occOutRateQ2.setOccRateQuarter("Q2");
				//occOutRateQ2.setOccRateNotes(root.getNoteInScopeQ2());

				LtcBedYtdOccupancyRate occRateQ2 = new LtcBedYtdOccupancyRate();
				occRateQ2.setConfirmationID(root.getForm().getConfirmationId());
				occRateQ2.setOccRateBedTypes("Private Beds");
				occRateQ2.setPlanMaxOccDays(root.getyTDPlannedPrivateQ2());
				occRateQ2.setYtdMaxOccDays(root.getyTDMaxPrivateQ2());
				occRateQ2.setYtdOccDays(root.getyTDOccupiedPrivateQ2());
				occRateQ2.setPercentOcc(root.getOccupiedPercentagePrivateQ2());
				occRateQ2.setOccRateQuarter("Q2");
				//occRateQ2.setOccRateNotes(root.getNoteInScopeQ2());
				
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
				int bedGrid3Index = 0;
				for (BedGrid3 maxOcp : root.getBedGrid3()) {
					LtcBedYtdMaxOccupancy numOfBeds = new LtcBedYtdMaxOccupancy();
					numOfBeds.setBedIndex(Integer.toString(++bedGrid3Index));
					numOfBeds.setBedFundingType(maxOcp.getBedType3());
					numOfBeds.setConfirmationId(root.getForm().getConfirmationId());
					numOfBeds.setStartDate(maxOcp.getStartDate3());
					numOfBeds.setEndDate(maxOcp.getEndDate3());
					numOfBeds.setNumberOfBeds(maxOcp.getNumberOfBeds3());
					numOfBeds.setMaximumBedDays(maxOcp.getMaximumBedDays3());
					numOfBeds.setQuarterInventory("Q3");
					numOfBeds.setNotes(maxOcp.getNotes3());
					numOfBeds.setBedSubype(maxOcp.getSubTypeLabel());
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
				occInRateQ3.setOccRateQuarter("Q3");

				LtcBedYtdOccupancyRate occOutRateQ3 = new LtcBedYtdOccupancyRate();
				occOutRateQ3.setConfirmationID(root.getForm().getConfirmationId());
				occOutRateQ3.setOccRateBedTypes("Out of Scope Publicly Funded Beds");
				occOutRateQ3.setPlanMaxOccDays(root.getyTDPlannedOutScopeQ3());
				occOutRateQ3.setYtdMaxOccDays(root.getyTDMaxOutScopeQ3());
				occOutRateQ3.setYtdOccDays(root.getyTDOccupiedOutScopeQ3());
				occOutRateQ3.setPercentOcc(root.getOccupiedPercentageOutScopeQ3());
				occOutRateQ3.setOccRateQuarter("Q3");
				//occOutRateQ3.setOccRateNotes(root.getNoteInScopeQ3());

				LtcBedYtdOccupancyRate occRateQ3 = new LtcBedYtdOccupancyRate();
				occRateQ3.setConfirmationID(root.getForm().getConfirmationId());
				occRateQ3.setOccRateBedTypes("Private Beds");
				occRateQ3.setPlanMaxOccDays(root.getyTDPlannedPrivateQ3());
				occRateQ3.setYtdMaxOccDays(root.getyTDMaxPrivateQ3());
				occRateQ3.setYtdOccDays(root.getyTDOccupiedPrivateQ3());
				occRateQ3.setPercentOcc(root.getOccupiedPercentagePrivateQ3());
				occRateQ3.setOccRateQuarter("Q3");
				//occRateQ3.setOccRateNotes(root.getNoteInScopeQ3());
				
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
				int bedGrid4Index = 0;
				for (BedGrid4 maxOcp : root.getBedGrid4()) {
					LtcBedYtdMaxOccupancy numOfBeds = new LtcBedYtdMaxOccupancy();
					numOfBeds.setBedIndex(Integer.toString(++bedGrid4Index));
					numOfBeds.setBedFundingType(maxOcp.getBedType4());
					numOfBeds.setConfirmationId(root.getForm().getConfirmationId());
					numOfBeds.setStartDate(maxOcp.getStartDate4());
					numOfBeds.setEndDate(maxOcp.getEndDate4());
					numOfBeds.setNumberOfBeds(maxOcp.getNumberOfBeds4());
					numOfBeds.setMaximumBedDays(maxOcp.getMaximumBedDays4());
					numOfBeds.setQuarterInventory("Q4");
					numOfBeds.setNotes(maxOcp.getNotes4());
					numOfBeds.setBedSubype(maxOcp.getSubTypeLabel());
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
				occInRateQ4.setOccRateQuarter("Q4");

				LtcBedYtdOccupancyRate occOutRateQ4 = new LtcBedYtdOccupancyRate();
				occOutRateQ4.setConfirmationID(root.getForm().getConfirmationId());
				occOutRateQ4.setOccRateBedTypes("Out of Scope Publicly Funded Beds");
				occOutRateQ4.setPlanMaxOccDays(root.getyTDPlannedOutScopeQ4());
				occOutRateQ4.setYtdMaxOccDays(root.getyTDMaxOutScopeQ4());
				occOutRateQ4.setYtdOccDays(root.getyTDOccupiedOutScopeQ4());
				occOutRateQ4.setPercentOcc(root.getOccupiedPercentageOutScopeQ4());
				occOutRateQ4.setOccRateQuarter("Q4");
				// occOutRateQ4.setOccRateNotes(root.getNoteInScopeQ4());

				LtcBedYtdOccupancyRate occRateQ4 = new LtcBedYtdOccupancyRate();
				occRateQ4.setConfirmationID(root.getForm().getConfirmationId());
				occRateQ4.setOccRateBedTypes("Private Beds");
				occRateQ4.setPlanMaxOccDays(root.getyTDPlannedPrivateQ4());
				occRateQ4.setYtdMaxOccDays(root.getyTDMaxPrivateQ4());
				occRateQ4.setYtdOccDays(root.getyTDOccupiedPrivateQ4());
				occRateQ4.setPercentOcc(root.getOccupiedPercentagePrivateQ4());
				occRateQ4.setOccRateQuarter("Q4");
				// occRateQ4.setOccRateNotes(root.getNoteInScopeQ4());
				
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
			ltcYtdSubmission.setLtcYtdDepSubTotals(ltcYtdDepSubTotals);
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
			ltcYtdSubmission.setLtcYtdDirectCareVacancy(LtcYtdDirectCareVacancy);
			
			
			ltcYtdSubmissions.add(ltcYtdSubmission);

		}

		return ltcYtdSubmissions;
	}
}
