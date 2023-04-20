package ca.bc.gov.chefs.etl.forms.ltc.facility.processor;

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

public class FacilityInfoFormApiResponseProcessor implements Processor {

	@SuppressWarnings("unchecked")
	@Override
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		System.out.println(payload);
		ObjectMapper mapper = new ObjectMapper();

		List<Root> facilityInformationModels = mapper.readValue(payload,
				new TypeReference<List<Root>>() {
				});
		List<FacilityInformation> parsedFacilityInfo = parseFacilityInfo(facilityInformationModels);
		List<IModel> iModels = (List<IModel>) (List<?>) parsedFacilityInfo;
		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
			
		List<String> filesGenerated = FileUtil.writeToCSVFile(map,Constants.LTC_FACILITY_DIR);
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setFiles(filesGenerated);
		exchange.getIn().setBody(mapper.writeValueAsString(successResponse));
	}
	
	private List<FacilityInformation> parseFacilityInfo(List<Root> facilities) {
		/* Mandatory fields */
		List<FacilityInformation> facilityInfoParsed = new ArrayList<>();
		for(Root facility : facilities) {
			FacilityInformation facilityInfo = new FacilityInformation();
			facilityInfo.setAccreditationBody(facility.getAccreditationBody());
			facilityInfo.setAccreditationDate(facility.getAccreditationDate1());
			facilityInfo.setAccreditationExpiryDate(facility.getAccreditationExpiryDate1());
			facilityInfo.setCCIMSID(facility.getSimpletextfield1());
			facilityInfo.setConfirmationID(facility.getForm().getConfirmationId());
			facilityInfo.setFacilityAddress(facility.getBcaddress().getProperties().getFullAddress());
			facilityInfo.setFacilityCity(facility.getCity1());
			facilityInfo.setFacilityName(facility.getFacilityName2());
			facilityInfo.setFacilityPostalCode(facility.getTextField());
			facilityInfo.setFacilityTelephone(facility.getPhoneNumber());
			facilityInfo.setFacilityWebsite(facility.getFacilityWebsite());
			facilityInfo.setHealthAuthority(facility.getHealthAuthority1());
			facilityInfo.setIsDeleted("false"); // TODO FIXME 
			facilityInfo.setLegislationtype(facility.getSelectList1());
			facilityInfo.setOwnerAddress(facility.getBcaddress1().getProperties().getFullAddress());
			facilityInfo.setOwnerCity(facility.getCity3());
			facilityInfo.setOwnercontactemail(facility.getContactEmail());
			facilityInfo.setOwnercontactName(facility.getContactName());
			facilityInfo.setOwnercontactposition(facility.getContactPosition());
			facilityInfo.setOwnerName(facility.getOwnerName());
			facilityInfo.setOwnercontactphone(facility.getPhoneNumber3());
			facilityInfo.setOwnerpostalcode(facility.getPostalCode1());
			facilityInfo.setOwnershiptype(facility.getOwnershipType1());
			facilityInfo.setProgramtype(facility.getProgramType1());
			facilityInfo.setSubmissionDate(facility.getForm().getCreatedAt());
			facilityInfo.setSubmittedby(facility.getForm().getEmail());
			

			if(!facility.isTheOwnerTheSameAsTheOperator1()) {
			facilityInfo.setOperatorAddress(facility.getOperatorAddress().getProperties().getFullAddress());
			facilityInfo.setOperatorCity(facility.getCity5());
			facilityInfo.setOperatorcontactemail(facility.getContactEmail2());
			facilityInfo.setOperatorcontactName(facility.getContactName3());
			facilityInfo.setOperatorcontactphone(facility.getContactPhoneNumber2());
			facilityInfo.setOperatorcontactposition(facility.getContactPosition2());
			facilityInfo.setOperatorName(facility.getOpName());
			facilityInfo.setOperatorpostalcode(facility.getPostalCode3());
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
			preparer1.setPreparerContactEmail(facility.getSimpleemail2());
			preparer1.setPreparerContactName(facility.getName2());
			preparer1.setPreparerContactPhone(facility.getPhoneNumber4());
			preparer1.setPreparerContactPosition(facility.getPosition3());
			preparer1.setPreparerNum("1");

			if(preparer1.getPreparerContactEmail().isBlank() || preparer1.getPreparerContactName().isBlank() || preparer1.getPreparerContactPhone().isBlank() || preparer1.getPreparerContactPosition().isBlank() || preparer1.getPreparerContactName().isBlank()) {
				
			}else {
				preparers.add(preparer1);
			}

			Preparer preparer2 = new Preparer();
			preparer2.setConfirmationID(facility.getForm().getConfirmationId());
			preparer2.setPreparerContactEmail(facility.getSimpleemail4());
			preparer2.setPreparerContactName(facility.getName4());
			preparer2.setPreparerContactPhone(facility.getPhoneNumber5());
			preparer2.setPreparerContactPosition(facility.getPosition6());
			preparer2.setPreparerNum("2");

			if(preparer2.getPreparerContactEmail().isBlank() || preparer2.getPreparerContactName().isBlank() || preparer2.getPreparerContactPhone().isBlank() || preparer2.getPreparerContactPosition().isBlank() || preparer2.getPreparerContactName().isBlank()) {
				
			}else {
				preparers.add(preparer2);
			}


			Preparer preparer3 = new Preparer();
			preparer3.setConfirmationID(facility.getForm().getConfirmationId());
			preparer3.setPreparerContactEmail(facility.getSimpleemail5());
			preparer3.setPreparerContactName(facility.getName5());
			preparer3.setPreparerContactPhone(facility.getPhoneNumber6());
			preparer3.setPreparerContactPosition(facility.getPosition7());
			preparer3.setPreparerNum("3");

			if(preparer3.getPreparerContactEmail().isBlank() || preparer3.getPreparerContactName().isBlank() || preparer3.getPreparerContactPhone().isBlank() || preparer3.getPreparerContactPosition().isBlank() || preparer3.getPreparerContactName().isBlank()) {
				
			}else {
				preparers.add(preparer3);
			}


			Preparer preparer4 = new Preparer();
			preparer4.setConfirmationID(facility.getForm().getConfirmationId());
			preparer4.setPreparerContactEmail(facility.getSimpleemail8());
			preparer4.setPreparerContactName(facility.getName8());
			preparer4.setPreparerContactPhone(facility.getPhoneNumber9());
			preparer4.setPreparerContactPosition(facility.getPosition10());
			preparer4.setPreparerNum("4");

			if(preparer4.getPreparerContactEmail().isBlank() || preparer4.getPreparerContactName().isBlank() || preparer4.getPreparerContactPhone().isBlank() || preparer4.getPreparerContactPosition().isBlank() || preparer4.getPreparerContactName().isBlank()) {
				
			}else {
				preparers.add(preparer4);
			}


			Preparer preparer5 = new Preparer();
			preparer5.setConfirmationID(facility.getForm().getConfirmationId());
			preparer5.setPreparerContactEmail(facility.getSimpleemail9());
			preparer5.setPreparerContactName(facility.getName9());
			preparer5.setPreparerContactPhone(facility.getPhoneNumber10());
			preparer5.setPreparerContactPosition(facility.getPosition11());
			preparer5.setPreparerNum("5");

			if(preparer5.getPreparerContactEmail().isBlank() || preparer5.getPreparerContactName().isBlank() || preparer5.getPreparerContactPhone().isBlank() || preparer5.getPreparerContactPosition().isBlank() || preparer5.getPreparerContactName().isBlank()) {
				
			}else {
				preparers.add(preparer5);
			}

			List<Approver> approvers = new ArrayList<Approver>();
			Approver approver1 = new Approver();
			approver1.setApproverContactEmail(facility.getEmail2());
			approver1.setApproverContactName(facility.getName3());
			approver1.setApproverContactPhone(facility.getSimplephonenumber3());
			approver1.setApproverContactPosition(facility.getPosition4());
			approver1.setApproverNum("1");
			approver1.setConfirmationID(facility.getForm().getConfirmationId());
			
			if(approver1.getApproverContactEmail().isBlank() || approver1.getApproverContactName().isBlank() || approver1.getApproverContactPhone().isBlank() || approver1.getApproverContactPosition().isBlank() || approver1.getApproverNum().isBlank()) {
				
			}else {
				approvers.add(approver1);
			}
			
			Approver approver2 = new Approver();
			approver2.setApproverContactEmail(facility.getEmail2());
			approver2.setApproverContactName(facility.getName6());
			approver2.setApproverContactPhone(facility.getPhoneNumber7());
			approver2.setApproverContactPosition(facility.getPosition8());
			approver2.setApproverNum("2");
			approver2.setConfirmationID(facility.getForm().getConfirmationId());
			
			if(approver2.getApproverContactEmail().isBlank() || approver2.getApproverContactName().isBlank() || approver2.getApproverContactPhone().isBlank() || approver2.getApproverContactPosition().isBlank() || approver2.getApproverNum().isBlank()) {
				
			}else {
				approvers.add(approver2);
			}


			Approver approver3 = new Approver();
			approver3.setApproverContactEmail(facility.getSimpleemail6());
			approver3.setApproverContactName(facility.getName3());
			approver3.setApproverContactPhone(facility.getSimplephonenumber3());
			approver3.setApproverContactPosition(facility.getPosition4());
			approver3.setApproverNum("3");
			approver3.setConfirmationID(facility.getForm().getConfirmationId());

			if(approver3.getApproverContactEmail().isBlank() || approver3.getApproverContactName().isBlank() || approver3.getApproverContactPhone().isBlank() || approver3.getApproverContactPosition().isBlank() || approver3.getApproverNum().isBlank()) {
				
			}else {
				approvers.add(approver3);
			}


			Approver approver4 = new Approver();
			approver4.setApproverContactEmail(facility.getSimpleemail10());
			approver4.setApproverContactName(facility.getName10());
			approver4.setApproverContactPhone(facility.getPhoneNumber11());
			approver4.setApproverContactPosition(facility.getPosition12());
			approver4.setApproverNum("4");
			approver4.setConfirmationID(facility.getForm().getConfirmationId());

			if(approver4.getApproverContactEmail().isBlank() || approver4.getApproverContactName().isBlank() || approver4.getApproverContactPhone().isBlank() || approver4.getApproverContactPosition().isBlank() || approver4.getApproverNum().isBlank()) {
				
			}else {
				approvers.add(approver4);
			}


			Approver approver5 = new Approver();
			approver5.setApproverContactEmail(facility.getSimpleemail7());
			approver5.setApproverContactName(facility.getName7());
			approver5.setApproverContactPhone(facility.getPhoneNumber8());
			approver5.setApproverContactPosition(facility.getPosition9());
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
