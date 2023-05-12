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
import ca.bc.gov.chefs.etl.forms.ltc.facility.json.Root;
import ca.bc.gov.chefs.etl.forms.ltc.facility.model.Approver;
import ca.bc.gov.chefs.etl.forms.ltc.facility.model.FacilityInformation;
import ca.bc.gov.chefs.etl.forms.ltc.facility.model.Preparer;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;

public class LTCStaffingPlanApiResponseProcessor implements Processor {

	@SuppressWarnings("unchecked")
	@Override
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		System.out.println(payload);
		ObjectMapper mapper = new ObjectMapper();

		// List<Root> facilityInformationModels = mapper.readValue(payload,
		// 		new TypeReference<List<Root>>() {
		// 		});
		// List<FacilityInformation> parsedFacilityInfo = parseFacilityInfo(facilityInformationModels);
		// List<IModel> iModels = (List<IModel>) (List<?>) parsedFacilityInfo;
		// Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
			
		// List<String> filesGenerated = FileUtil.writeToCSVFile(map,Constants.LTC_FACILITY_DIR);
		// TODO remove successReponse or uncomment
		// SuccessResponse successResponse = new SuccessResponse();
		// successResponse.setFiles(filesGenerated);
		// exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
	}
	
	private List<FacilityInformation> parseFacilityInfo(List<Root> facilities) {
		/* Mandatory fields */
		List<FacilityInformation> facilityInfoParsed = new ArrayList<>();
		for(Root facility : facilities) {
			FacilityInformation facilityInfo = new FacilityInformation();
			facilityInfo.setAccreditationBody(facility.getFacilityAccreditationBody());
			facilityInfo.setAccreditationDate(facility.getFacilityAccreditationDate());
			facilityInfo.setAccreditationExpiryDate(facility.getFacilityAccreditationExpiryDate());
			facilityInfo.setCCIMSID(facility.getCcimsid());
			facilityInfo.setConfirmationID(facility.getForm().getConfirmationId());
			facilityInfo.setFacilityAddress(facility.getFacilityAddress());
			facilityInfo.setFacilityCity(facility.getFacilityCity());
			facilityInfo.setFacilityName(facility.getFacilityName());
			facilityInfo.setFacilityPostalCode(facility.getFacilityPostalCode());
			facilityInfo.setFacilityTelephone(facility.getPhoneNumber());
			facilityInfo.setFacilityWebsite(facility.getFacilityWebsite());
			facilityInfo.setHealthAuthority(facility.getHealthAuthority());
			facilityInfo.setIsDeleted("false"); // TODO FIXME 
			facilityInfo.setLegislationtype(facility.getFacilityLegislationType());
			facilityInfo.setOwnerAddress(facility.getOwnerAddress().getProperties().getFullAddress());
			facilityInfo.setOwnerCity(facility.getOwnerCity());
			facilityInfo.setOwnercontactemail(facility.getOwnerContactEmail());
			facilityInfo.setOwnercontactName(facility.getOwnerContactName());
			facilityInfo.setOwnercontactposition(facility.getOwnerContactPosition());
			facilityInfo.setOwnerName(facility.getOwnerName());
			facilityInfo.setOwnercontactphone(facility.getOwnerContactPhoneNumber());
			facilityInfo.setOwnerpostalcode(facility.getOwnerPostalCode());
			facilityInfo.setOwnershiptype(facility.getFacilityOwnershipType());
			facilityInfo.setProgramtype(facility.getFacilityType());
			facilityInfo.setSubmissionDate(facility.getForm().getCreatedAt());
			facilityInfo.setSubmittedby(facility.getForm().getEmail());
			

			if(!facility.isTheOwnerTheSameAsTheOperator1()) {
			facilityInfo.setOperatorAddress(facility.getOperatorAddress().getProperties().getFullAddress());
			facilityInfo.setOperatorCity(facility.getOperatorCity());
			facilityInfo.setOperatorcontactemail(facility.getOperatorContactEmail());
			facilityInfo.setOperatorcontactName(facility.getOperatorContactName());
			facilityInfo.setOperatorcontactphone(facility.getOperatorPhoneNumber());
			facilityInfo.setOperatorcontactposition(facility.getOperatorContactPosition());
			facilityInfo.setOperatorName(facility.getOperatorName());
			facilityInfo.setOperatorpostalcode(facility.getOperatorPostalCode());
			}else {
				facilityInfo.setOperatorAddress(facilityInfo.getOwnerAddress());
				facilityInfo.setOperatorCity(facilityInfo.getOwnerCity());
				facilityInfo.setOperatorcontactemail(facilityInfo.getOwnercontactemail());
				facilityInfo.setOperatorcontactName(facilityInfo.getOwnercontactName());
				facilityInfo.setOperatorcontactphone(facilityInfo.getOwnercontactphone());
				facilityInfo.setOperatorcontactposition(facilityInfo.getOwnercontactposition());
				facilityInfo.setOperatorName(facilityInfo.getOwnerName());
				facilityInfo.setOperatorpostalcode(facilityInfo.getOwnerpostalcode());	
			}


			/* Creating Preparer Pojos */
			List<Preparer> preparers = new ArrayList<Preparer>();
			Preparer preparer1 = new Preparer();
			preparer1.setConfirmationID(facility.getForm().getConfirmationId());
			preparer1.setPreparerContactEmail(facility.getSubmitterEmail1());
			preparer1.setPreparerContactName(facility.getSubmitterName1());
			preparer1.setPreparerContactPhone(facility.getSubmitterPhoneNumber1());
			preparer1.setPreparerContactPosition(facility.getSubmitterPosition1());
			preparer1.setPreparerNum("1");

			if(preparer1.getPreparerContactEmail().isBlank() || preparer1.getPreparerContactName().isBlank() || preparer1.getPreparerContactPhone().isBlank() || preparer1.getPreparerContactPosition().isBlank() || preparer1.getPreparerContactName().isBlank()) {
				
			}else {
				preparers.add(preparer1);
			}

			Preparer preparer2 = new Preparer();
			preparer2.setConfirmationID(facility.getForm().getConfirmationId());
			preparer2.setPreparerContactEmail(facility.getSubmitterEmail2());
			preparer2.setPreparerContactName(facility.getSubmitterName2());
			preparer2.setPreparerContactPhone(facility.getSubmitterPhoneNumber2());
			preparer2.setPreparerContactPosition(facility.getSubmitterPosition2());
			preparer2.setPreparerNum("2");

			if(preparer2.getPreparerContactEmail().isBlank() || preparer2.getPreparerContactName().isBlank() || preparer2.getPreparerContactPhone().isBlank() || preparer2.getPreparerContactPosition().isBlank() || preparer2.getPreparerContactName().isBlank()) {
				
			}else {
				preparers.add(preparer2);
			}


			Preparer preparer3 = new Preparer();
			preparer3.setConfirmationID(facility.getForm().getConfirmationId());
			preparer3.setPreparerContactEmail(facility.getSubmitterEmail3());
			preparer3.setPreparerContactName(facility.getSubmitterName3());
			preparer3.setPreparerContactPhone(facility.getSubmitterPhoneNumber3());
			preparer3.setPreparerContactPosition(facility.getSubmitterPosition3());
			preparer3.setPreparerNum("3");

			if(preparer3.getPreparerContactEmail().isBlank() || preparer3.getPreparerContactName().isBlank() || preparer3.getPreparerContactPhone().isBlank() || preparer3.getPreparerContactPosition().isBlank() || preparer3.getPreparerContactName().isBlank()) {
				
			}else {
				preparers.add(preparer3);
			}


			Preparer preparer4 = new Preparer();
			preparer4.setConfirmationID(facility.getForm().getConfirmationId());
			preparer4.setPreparerContactEmail(facility.getSubmitterEmail4());
			preparer4.setPreparerContactName(facility.getSubmitterName4());
			preparer4.setPreparerContactPhone(facility.getSubmitterPhoneNumber4());
			preparer4.setPreparerContactPosition(facility.getSubmitterPosition4());
			preparer4.setPreparerNum("4");

			if(preparer4.getPreparerContactEmail().isBlank() || preparer4.getPreparerContactName().isBlank() || preparer4.getPreparerContactPhone().isBlank() || preparer4.getPreparerContactPosition().isBlank() || preparer4.getPreparerContactName().isBlank()) {
				
			}else {
				preparers.add(preparer4);
			}


			Preparer preparer5 = new Preparer();
			preparer5.setConfirmationID(facility.getForm().getConfirmationId());
			preparer5.setPreparerContactEmail(facility.getSubmitterEmail5());
			preparer5.setPreparerContactName(facility.getSubmitterName5());
			preparer5.setPreparerContactPhone(facility.getSubmitterPhoneNumber5());
			preparer5.setPreparerContactPosition(facility.getSubmitterPosition5());
			preparer5.setPreparerNum("5");

			if(preparer5.getPreparerContactEmail().isBlank() || preparer5.getPreparerContactName().isBlank() || preparer5.getPreparerContactPhone().isBlank() || preparer5.getPreparerContactPosition().isBlank() || preparer5.getPreparerContactName().isBlank()) {
				
			}else {
				preparers.add(preparer5);
			}

			List<Approver> approvers = new ArrayList<Approver>();
			Approver approver1 = new Approver();
			approver1.setApproverContactEmail(facility.getApproverEmail1());
			approver1.setApproverContactName(facility.getApproverName1());
			approver1.setApproverContactPhone(facility.getApproverPhoneNumber1());
			approver1.setApproverContactPosition(facility.getApproverPosition1());
			approver1.setApproverNum("1");
			approver1.setConfirmationID(facility.getForm().getConfirmationId());
			
			if(approver1.getApproverContactEmail().isBlank() || approver1.getApproverContactName().isBlank() || approver1.getApproverContactPhone().isBlank() || approver1.getApproverContactPosition().isBlank() || approver1.getApproverNum().isBlank()) {
				
			}else {
				approvers.add(approver1);
			}
			
			Approver approver2 = new Approver();
			approver2.setApproverContactEmail(facility.getApproverEmail2());
			approver2.setApproverContactName(facility.getApproverName2());
			approver2.setApproverContactPhone(facility.getApproverPhoneNumber2());
			approver2.setApproverContactPosition(facility.getApproverPosition2());
			approver2.setApproverNum("2");
			approver2.setConfirmationID(facility.getForm().getConfirmationId());
			
			if(approver2.getApproverContactEmail().isBlank() || approver2.getApproverContactName().isBlank() || approver2.getApproverContactPhone().isBlank() || approver2.getApproverContactPosition().isBlank() || approver2.getApproverNum().isBlank()) {
				
			}else {
				approvers.add(approver2);
			}


			Approver approver3 = new Approver();
			approver3.setApproverContactEmail(facility.getApproverEmail3());
			approver3.setApproverContactName(facility.getApproverName3());
			approver3.setApproverContactPhone(facility.getApproverPhoneNumber3());
			approver3.setApproverContactPosition(facility.getApproverPosition3());
			approver3.setApproverNum("3");
			approver3.setConfirmationID(facility.getForm().getConfirmationId());

			if(approver3.getApproverContactEmail().isBlank() || approver3.getApproverContactName().isBlank() || approver3.getApproverContactPhone().isBlank() || approver3.getApproverContactPosition().isBlank() || approver3.getApproverNum().isBlank()) {
				
			}else {
				approvers.add(approver3);
			}


			Approver approver4 = new Approver();
			approver4.setApproverContactEmail(facility.getApproverEmail4());
			approver4.setApproverContactName(facility.getApproverName4());
			approver4.setApproverContactPhone(facility.getApproverPhoneNumber4());
			approver4.setApproverContactPosition(facility.getApproverPosition4());
			approver4.setApproverNum("4");
			approver4.setConfirmationID(facility.getForm().getConfirmationId());

			if(approver4.getApproverContactEmail().isBlank() || approver4.getApproverContactName().isBlank() || approver4.getApproverContactPhone().isBlank() || approver4.getApproverContactPosition().isBlank() || approver4.getApproverNum().isBlank()) {
				
			}else {
				approvers.add(approver4);
			}


			Approver approver5 = new Approver();
			approver5.setApproverContactEmail(facility.getApproverEmail5());
			approver5.setApproverContactName(facility.getApproverName5());
			approver5.setApproverContactPhone(facility.getApproverPhoneNumber5());
			approver5.setApproverContactPosition(facility.getApproverPosition5());
			approver5.setApproverNum("5");
			approver5.setConfirmationID(facility.getForm().getConfirmationId());

			if(approver5.getApproverContactEmail().isBlank() || approver5.getApproverContactName().isBlank() || approver5.getApproverContactPhone().isBlank() || approver5.getApproverContactPosition().isBlank() || approver5.getApproverNum().isBlank()) {
				
			}else {
				approvers.add(approver5);
			}

			facilityInfo.setPreparers(preparers);
			facilityInfo.setApprovers(approvers);
			facilityInfoParsed.add(facilityInfo);
		}
		return facilityInfoParsed;
	}
		
}
