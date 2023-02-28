package ca.bc.gov.chefs.etl.forms.ltc.facility.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.parser.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

@SuppressWarnings("unchecked")
@JsonIgnoreProperties(ignoreUnknown = true)
public class FacilityInfo implements IModel {

	@JsonIgnore
	private String confirmationId;
	@JsonIgnore
	private String submissionDate;
	@JsonIgnore
	private String submittedBy;
	@JsonProperty("facilityName2")
	private String facilityName;
	@JsonIgnore
	private String facilityAddress;
	@JsonProperty("city1")
	private String facilityCity;
	@JsonProperty("textField")
	private String facilityPostalCode;
	@JsonProperty("phoneNumber")
	private String facilityTelephone;
	@JsonProperty("facilityWebsite")
	private String facilityWebsite;
	@JsonProperty("simpletextfield1")
	private String ccmsId;
	@JsonProperty("programType1")
	private String programType;
	@JsonProperty("ownershipType1")
	private String ownershipType;
	@JsonProperty("selectList1")
	private String legislationtType;
	@JsonProperty("accreditationBody")
	private String accreditationBody;
	@JsonProperty("accreditationDate1")
	private String accreditationDate;
	@JsonProperty("accreditationExpiryDate1")
	private String accreditationExpiryDate;
	@JsonProperty("healthAuthority1")
	private String healthAuthority;
	@JsonProperty("ownerName")
	private String ownerName;
	@JsonIgnore
	private String ownerAddress;
	@JsonProperty("city3")
	private String ownerCity;
	@JsonProperty("postalCode1")
	private String ownerPostalCode;
	@JsonProperty("contactName")
	private String ownerContactName;
	@JsonProperty("phoneNumber3")
	private String ownerContactPhone;
	@JsonProperty("contactPosition")
	private String ownerContactPosition;
	@JsonProperty("contactEmail")
	private String ownerContactEmail;
	@JsonProperty("opName")
	private String operatorName;
	@JsonIgnore
	private String operatorAddress;
	@JsonProperty("city5")
	private String operatorCity;
	@JsonProperty("postalCode3")
	private String operatorPostalCode;
	@JsonProperty("contactName3")
	private String operatorContactName;
	@JsonProperty("contactPhoneNumber2")
	private String operatorContactPhone;
	@JsonProperty("contactPosition2")
	private String operatorContactPosition;
	@JsonProperty("contactEmail2")
	private String operatorContactEmail;
	@JsonProperty("name2")
	private String preparerContactName;
	@JsonProperty("phoneNumber4")
	private String preparerContactPhone;
	@JsonProperty("position3")
	private String preparerContactPosition;
	@JsonProperty("simpleemail2")
	private String preparerContactEmail;
	@JsonProperty("name3")
	private String approverContactName;
	@JsonProperty("simplephonenumber3")
	private String ApproverContactPhone;
	@JsonProperty("position4")
	private String approverContactPosition;
	@JsonProperty("email2")
	private String approverContactEmail;
	
	@JsonProperty("isTheOwnerTheSameAsTheOperator1")
	private boolean ownerSameAsOperator;

	@JsonProperty("form")
	private void unPackForm(Map<String, String> form) {
		this.confirmationId = form.get("confirmationId");
		this.submissionDate =  CSVUtil.getFormattedDate(form.get("createdAt"));
		this.submittedBy = form.get("email");
	}

	@JsonProperty("bcaddress")
	private void unPackBcAddress(Map<String, Object> bcaddress) {
		if(bcaddress.containsKey("properties")) {
		Map<String, String> properties = (Map<String, String>) bcaddress.get("properties");
		this.facilityAddress = properties.get("fullAddress");
		}
	}

	@JsonProperty("bcaddress1")
	private void unPackBcAddress1(Map<String, Object> bcaddress1) {
		if(bcaddress1.containsKey("properties")) {
		Map<String, String> properties = (Map<String, String>) bcaddress1.get("properties");
		this.ownerAddress = properties.get("fullAddress");
		}
	}

	@JsonProperty("operatorAddress")
	private void unPackOperatorAddress(Map<String, Object> operatorAddress) {
		if(operatorAddress.containsKey("properties")) {
		Map<String, String> properties = (Map<String, String>) operatorAddress.get("properties");
		this.operatorAddress = properties.get("fullAddress");
		}
	}

	
	


	/* Overriden methods from IModel for CSV Parsing. */
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_FACILITY;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add("false");
		elements.add(this.getSubmissionDate());
		elements.add(this.getSubmittedBy());
		elements.add(this.getFacilityName());
		elements.add(this.getFacilityAddress());
		elements.add(this.getFacilityCity());
		elements.add(this.getFacilityPostalCode());
		elements.add(this.getFacilityTelephone());
		elements.add(this.getFacilityWebsite());
		elements.add(this.getCcmsId());
		elements.add(this.getProgramType());
		elements.add(this.getOwnershipType());
		elements.add(this.getLegislationtType());
		elements.add(this.getAccreditationBody());
		elements.add(this.getAccreditationDate());
		elements.add(this.getAccreditationExpiryDate());
		elements.add(this.getHealthAuthority());
		elements.add(this.getOwnerName());
		elements.add(this.getOwnerAddress());
		elements.add(this.getOwnerCity());
		elements.add(this.getOwnerPostalCode());
		elements.add(this.getOwnerContactName());
		elements.add(this.getOwnerContactPhone());
		elements.add(this.getOwnerContactPosition());
		elements.add(this.getOwnerContactEmail());
		elements.add(this.getOperatorName());
		elements.add(this.getOperatorAddress());
		elements.add(this.getOperatorCity());
		elements.add(this.getOperatorPostalCode());
		elements.add(this.getOperatorContactName());
		elements.add(this.getOperatorContactPhone());
		elements.add(this.getOperatorContactPosition());
		elements.add(this.getOperatorContactEmail());
		elements.add(this.getPreparerContactName());
		elements.add(this.getPreparerContactPhone());
		elements.add(this.getPreparerContactPosition());
		elements.add(this.getPreparerContactEmail());
		elements.add(this.getApproverContactName());
		elements.add(this.getApproverContactPhone());
		elements.add(this.getApproverContactPosition());
		elements.add(this.getApproverContactEmail());
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

	/* getter and setters */
	public String getConfirmationId() {
		return confirmationId;
	}

	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}

	public String getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getFacilityAddress() {
		return facilityAddress;
	}

	public void setFacilityAddress(String facilityAddress) {
		this.facilityAddress = facilityAddress;
	}

	public String getFacilityCity() {
		return facilityCity;
	}

	public void setFacilityCity(String facilityCity) {
		this.facilityCity = facilityCity;
	}

	public String getFacilityPostalCode() {
		return facilityPostalCode;
	}

	public void setFacilityPostalCode(String facilityPostalCode) {
		this.facilityPostalCode = facilityPostalCode;
	}

	public String getFacilityTelephone() {
		return facilityTelephone;
	}

	public void setFacilityTelephone(String facilityTelephone) {
		this.facilityTelephone = facilityTelephone;
	}

	public String getFacilityWebsite() {
		return facilityWebsite;
	}

	public void setFacilityWebsite(String facilityWebsite) {
		this.facilityWebsite = facilityWebsite;
	}

	public String getCcmsId() {
		return ccmsId;
	}

	public void setCcmsId(String ccmsId) {
		this.ccmsId = ccmsId;
	}

	public String getProgramType() {
		return programType;
	}

	public void setProgramType(String programType) {
		this.programType = programType;
	}

	public String getOwnershipType() {
		return ownershipType;
	}

	public void setOwnershipType(String ownershipType) {
		this.ownershipType = ownershipType;
	}

	public String getLegislationtType() {
		return legislationtType;
	}

	public String getAccreditationBody() {
		return accreditationBody;
	}

	public void setAccreditationBody(String accreditationBody) {
		this.accreditationBody = accreditationBody;
	}

	public void setLegislationtType(String legislationtType) {
		this.legislationtType = legislationtType;
	}

	public String getAccreditationDate() {
		return  CSVUtil.getFormattedDate(accreditationDate);
	}

	public void setAccreditationDate(String accreditationDate) {
		this.accreditationDate = accreditationDate;
	}

	public String getAccreditationExpiryDate() {
		return  CSVUtil.getFormattedDate(accreditationExpiryDate);
	}

	public void setAccreditationExpiryDate(String accreditationExpiryDate) {
		this.accreditationExpiryDate = accreditationExpiryDate;
	}

	public String getHealthAuthority() {
		return healthAuthority;
	}

	public void setHealthAuthority(String healthAuthority) {
		this.healthAuthority = healthAuthority;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	public String getOwnerCity() {
		return ownerCity;
	}

	public void setOwnerCity(String ownerCity) {
		this.ownerCity = ownerCity;
	}

	public String getOwnerPostalCode() {
		return ownerPostalCode;
	}

	public void setOwnerPostalCode(String ownerPostalCode) {
		this.ownerPostalCode = ownerPostalCode;
	}

	public String getOwnerContactName() {
		return ownerContactName;
	}

	public void setOwnerContactName(String ownerContactName) {
		this.ownerContactName = ownerContactName;
	}

	public String getOwnerContactPhone() {
		return ownerContactPhone;
	}

	public void setOwnerContactPhone(String ownerContactPhone) {
		this.ownerContactPhone = ownerContactPhone;
	}

	public String getOwnerContactPosition() {
		return ownerContactPosition;
	}

	public void setOwnerContactPosition(String ownerContactPosition) {
		this.ownerContactPosition = ownerContactPosition;
	}

	
	public String getOwnerContactEmail() {
		return ownerContactEmail;
	}

	public void setOwnerContactEmail(String ownerContactEmail) {
		this.ownerContactEmail = ownerContactEmail;
	}

	public String getOperatorName() {
		if(ownerSameAsOperator) {
			return this.getOwnerName();
		}
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOperatorAddress() {
		if(ownerSameAsOperator) {
			return this.getOwnerAddress();
		}
		return operatorAddress;
	}

	public void setOperatorAddress(String operatorAddress) {
		this.operatorAddress = operatorAddress;
	}

	public String getOperatorCity() {
		if(ownerSameAsOperator) {
			return this.getOwnerCity();
		}
		return operatorCity;
	}

	public void setOperatorCity(String operatorCity) {
		this.operatorCity = operatorCity;
	}

	public String getOperatorPostalCode() {
		if(ownerSameAsOperator) {
			return this.getOwnerPostalCode();
		}
		return operatorPostalCode;
	}

	public void setOperatorPostalCode(String operatorPostalCode) {
		this.operatorPostalCode = operatorPostalCode;
	}

	public String getOperatorContactName() {
		if(ownerSameAsOperator) {
			return this.getOwnerContactName();
		}
		return operatorContactName;
	}

	public void setOperatorContactName(String operatorContactName) {
		this.operatorContactName = operatorContactName;
	}

	public String getOperatorContactPhone() {
		if(ownerSameAsOperator) {
			return this.getOwnerContactPhone();
		}
		return operatorContactPhone;
	}

	public void setOperatorContactPhone(String operatorContactPhone) {
		this.operatorContactPhone = operatorContactPhone;
	}

	public String getOperatorContactPosition() {
		if(ownerSameAsOperator) {
			return this.getOwnerContactPosition();
		}
		return operatorContactPosition;
	}

	public void setOperatorContactPosition(String operatorContactPosition) {
		this.operatorContactPosition = operatorContactPosition;
	}

	public String getOperatorContactEmail() {
		if(ownerSameAsOperator) {
			return this.getOwnerContactEmail();
		}
		return operatorContactEmail;
	}

	public void setOperatorContactEmail(String operatorContactEmail) {
		this.operatorContactEmail = operatorContactEmail;
	}

	public String getPreparerContactName() {
		return preparerContactName;
	}

	public void setPreparerContactName(String preparerContactName) {
		this.preparerContactName = preparerContactName;
	}

	public String getPreparerContactPhone() {
		return preparerContactPhone;
	}

	public void setPreparerContactPhone(String preparerContactPhone) {
		this.preparerContactPhone = preparerContactPhone;
	}

	public String getPreparerContactPosition() {
		return preparerContactPosition;
	}

	public void setPreparerContactPosition(String preparerContactPosition) {
		this.preparerContactPosition = preparerContactPosition;
	}

	public String getPreparerContactEmail() {
		return preparerContactEmail;
	}

	public void setPreparerContactEmail(String preparerContactEmail) {
		this.preparerContactEmail = preparerContactEmail;
	}

	public String getApproverContactName() {
		return approverContactName;
	}

	public void setApproverContactName(String approverContactName) {
		this.approverContactName = approverContactName;
	}

	public String getApproverContactPhone() {
		return ApproverContactPhone;
	}

	public void setApproverContactPhone(String approverContactPhone) {
		ApproverContactPhone = approverContactPhone;
	}

	public String getApproverContactEmail() {
		return approverContactEmail;
	}

	public String getApproverContactPosition() {
		return approverContactPosition;
	}

	public void setApproverContactPosition(String approverContactPosition) {
		this.approverContactPosition = approverContactPosition;
	}

	public void setApproverContactEmail(String approverContactEmail) {
		this.approverContactEmail = approverContactEmail;
	}

}
