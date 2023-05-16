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
import ca.bc.gov.chefs.etl.forms.ltc.staffing.model.LTCStaffingPlan;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;

public class LTCStaffingPlanApiResponseProcessor implements Processor {

	@SuppressWarnings("unchecked")
	@Override
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		System.out.println(payload);
		ObjectMapper mapper = new ObjectMapper();

		List<Root> staffingPlanModels = mapper.readValue(payload,
				new TypeReference<List<Root>>() {
				});
		List<LTCStaffingPlan> parsedStaffingPlan = parseStaffingPlan(staffingPlanModels);
		List<IModel> iModels = (List<IModel>) (List<?>) parsedStaffingPlan;
		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
			
		List<String> filesGenerated = FileUtil.writeToCSVFile(map,Constants.LTC_STAFFING_PLAN_DIR);
		// TODO remove successReponse or uncomment
		// SuccessResponse successResponse = new SuccessResponse();
		// successResponse.setFiles(filesGenerated);
		// exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
	}
	
	private List<LTCStaffingPlan> parseStaffingPlan(List<Root> staffingPlans) {
		/* Mandatory fields */
		List<LTCStaffingPlan> staffingPlanParsed = new ArrayList<>();
		for(Root staffingPlan : staffingPlans) {
			LTCStaffingPlan LTCstaffingPlan = new LTCStaffingPlan();

			/* Creating Preparer Pojos */
		// 	List<Preparer> preparers = new ArrayList<Preparer>();

		// 	List<Approver> approvers = new ArrayList<Approver>();
		// 	Approver approver1 = new Approver();
		// 	approvers.add(approver1);
		// 	facilityInfo.setPreparers(preparers);
		// 	facilityInfo.setApprovers(approvers);
		// 	facilityInfoParsed.add(facilityInfo);
			staffingPlanParsed.add(LTCstaffingPlan);
		}
		return staffingPlanParsed;
	}
		
}
