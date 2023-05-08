package ca.bc.gov.chefs.etl.forms.ltc.facility.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ca.bc.gov.chefs.etl.core.model.IModel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {

	public Form form;
	public String admin;
	public String ccimsid;
	public String lateEntry;
	public String ownerCity;
	public String ownerName;
	public String phoneNumber;
	public String facilityCity;
	public String facilityName;
	public String facilityType;
	public String operatorCity;
	public String operatorName;
	public String approverName1;
	public String approverName2;
	public String approverName3;
	public String approverName4;
	public String approverName5;
	public String approverEmail1;
	public String approverEmail2;
	public String approverEmail3;
	public String approverEmail4;
	public String approverEmail5;
	public String submitterName1;
	public String submitterName2;
	public String submitterName3;
	public String submitterName4;
	public String submitterName5;
	public String facilityAddress;
	public String facilityWebsite;
	public String healthAuthority;
	public String ownerPostalCode;
	public String submitterEmail1;
	public String submitterEmail2;
	public String submitterEmail3;
	public String submitterEmail4;
	public String submitterEmail5;
	public String ownerContactName;
	public String approverPosition1;
	public String approverPosition2;
	public String approverPosition3;
	public String approverPosition4;
	public String approverPosition5;
	public String ownerContactEmail;
	public String facilityPostalCode;
	public String operatorPostalCode;
	public String submitterPosition1;
	public String submitterPosition2;
	public String submitterPosition3;
	public String submitterPosition4;
	public String submitterPosition5;
	public String operatorContactName;
	public String operatorPhoneNumber;
	public String approverPhoneNumber1;
	public String approverPhoneNumber2;
	public String approverPhoneNumber3;
	public String approverPhoneNumber4;
	public String approverPhoneNumber5;
	public String operatorContactEmail;
	public String ownerContactPosition;
	public String facilityOwnershipType;
	public String submitterPhoneNumber1;
	public String submitterPhoneNumber2;
	public String submitterPhoneNumber3;
	public String submitterPhoneNumber4;
	public String submitterPhoneNumber5;
	public String facilityLegislationType;
	public String operatorContactPosition;
	public String ownerContactPhoneNumber;
	public String facilityAccreditationBody;
	public String facilityAccreditationDate;
	public String localHealthAuthorityLhaName;
	public String facilityAccreditationExpiryDate;
	public boolean isTheOwnerTheSameAsTheOperator1;
	public Bcaddress ownerAddress;
	public Bcaddress operatorAddress;

	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getCcimsid() {
		return ccimsid;
	}
	public void setCcimsid(String ccimsid) {
		this.ccimsid = ccimsid;
	}
	public String getLateEntry() {
		return lateEntry;
	}
	public void setLateEntry(String lateEntry) {
		this.lateEntry = lateEntry;
	}
	public String getOwnerCity() {
		return ownerCity;
	}
	public void setOwnerCity(String ownerCity) {
		this.ownerCity = ownerCity;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFacilityCity() {
		return facilityCity;
	}
	public void setFacilityCity(String facilityCity) {
		this.facilityCity = facilityCity;
	}
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	public String getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}
	public String getOperatorCity() {
		return operatorCity;
	}
	public void setOperatorCity(String operatorCity) {
		this.operatorCity = operatorCity;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getApproverName1() {
		return approverName1;
	}
	public void setApproverName1(String approverName1) {
		this.approverName1 = approverName1;
	}
	public String getApproverName2() {
		return approverName2;
	}
	public void setApproverName2(String approverName2) {
		this.approverName2 = approverName2;
	}
	public String getApproverName3() {
		return approverName3;
	}
	public void setApproverName3(String approverName3) {
		this.approverName3 = approverName3;
	}
	public String getApproverName4() {
		return approverName4;
	}
	public void setApproverName4(String approverName4) {
		this.approverName4 = approverName4;
	}
	public String getApproverName5() {
		return approverName5;
	}
	public void setApproverName5(String approverName5) {
		this.approverName5 = approverName5;
	}
	public String getApproverEmail1() {
		return approverEmail1;
	}
	public void setApproverEmail1(String approverEmail1) {
		this.approverEmail1 = approverEmail1;
	}
	public String getApproverEmail2() {
		return approverEmail2;
	}
	public void setApproverEmail2(String approverEmail2) {
		this.approverEmail2 = approverEmail2;
	}
	public String getApproverEmail3() {
		return approverEmail3;
	}
	public void setApproverEmail3(String approverEmail3) {
		this.approverEmail3 = approverEmail3;
	}
	public String getApproverEmail4() {
		return approverEmail4;
	}
	public void setApproverEmail4(String approverEmail4) {
		this.approverEmail4 = approverEmail4;
	}
	public String getApproverEmail5() {
		return approverEmail5;
	}
	public void setApproverEmail5(String approverEmail5) {
		this.approverEmail5 = approverEmail5;
	}
	public String getSubmitterName1() {
		return submitterName1;
	}
	public void setSubmitterName1(String submitterName1) {
		this.submitterName1 = submitterName1;
	}
	public String getSubmitterName2() {
		return submitterName2;
	}
	public void setSubmitterName2(String submitterName2) {
		this.submitterName2 = submitterName2;
	}
	public String getSubmitterName3() {
		return submitterName3;
	}
	public void setSubmitterName3(String submitterName3) {
		this.submitterName3 = submitterName3;
	}
	public String getSubmitterName4() {
		return submitterName4;
	}
	public void setSubmitterName4(String submitterName4) {
		this.submitterName4 = submitterName4;
	}
	public String getSubmitterName5() {
		return submitterName5;
	}
	public void setSubmitterName5(String submitterName5) {
		this.submitterName5 = submitterName5;
	}
	public String getFacilityAddress() {
		return facilityAddress;
	}
	public void setFacilityAddress(String facilityAddress) {
		this.facilityAddress = facilityAddress;
	}
	public String getFacilityWebsite() {
		return facilityWebsite;
	}
	public void setFacilityWebsite(String facilityWebsite) {
		this.facilityWebsite = facilityWebsite;
	}
	public String getHealthAuthority() {
		return healthAuthority;
	}
	public void setHealthAuthority(String healthAuthority) {
		this.healthAuthority = healthAuthority;
	}
	public String getOwnerPostalCode() {
		return ownerPostalCode;
	}
	public void setOwnerPostalCode(String ownerPostalCode) {
		this.ownerPostalCode = ownerPostalCode;
	}
	public String getSubmitterEmail1() {
		return submitterEmail1;
	}
	public void setSubmitterEmail1(String submitterEmail1) {
		this.submitterEmail1 = submitterEmail1;
	}
	public String getSubmitterEmail2() {
		return submitterEmail2;
	}
	public void setSubmitterEmail2(String submitterEmail2) {
		this.submitterEmail2 = submitterEmail2;
	}
	public String getSubmitterEmail3() {
		return submitterEmail3;
	}
	public void setSubmitterEmail3(String submitterEmail3) {
		this.submitterEmail3 = submitterEmail3;
	}
	public String getSubmitterEmail4() {
		return submitterEmail4;
	}
	public void setSubmitterEmail4(String submitterEmail4) {
		this.submitterEmail4 = submitterEmail4;
	}
	public String getSubmitterEmail5() {
		return submitterEmail5;
	}
	public void setSubmitterEmail5(String submitterEmail5) {
		this.submitterEmail5 = submitterEmail5;
	}
	public String getOwnerContactName() {
		return ownerContactName;
	}
	public void setOwnerContactName(String ownerContactName) {
		this.ownerContactName = ownerContactName;
	}
	public String getApproverPosition1() {
		return approverPosition1;
	}
	public void setApproverPosition1(String approverPosition1) {
		this.approverPosition1 = approverPosition1;
	}
	public String getApproverPosition2() {
		return approverPosition2;
	}
	public void setApproverPosition2(String approverPosition2) {
		this.approverPosition2 = approverPosition2;
	}
	public String getApproverPosition3() {
		return approverPosition3;
	}
	public void setApproverPosition3(String approverPosition3) {
		this.approverPosition3 = approverPosition3;
	}
	public String getApproverPosition4() {
		return approverPosition4;
	}
	public void setApproverPosition4(String approverPosition4) {
		this.approverPosition4 = approverPosition4;
	}
	public String getApproverPosition5() {
		return approverPosition5;
	}
	public void setApproverPosition5(String approverPosition5) {
		this.approverPosition5 = approverPosition5;
	}
	public String getOwnerContactEmail() {
		return ownerContactEmail;
	}
	public void setOwnerContactEmail(String ownerContactEmail) {
		this.ownerContactEmail = ownerContactEmail;
	}
	public String getFacilityPostalCode() {
		return facilityPostalCode;
	}
	public void setFacilityPostalCode(String facilityPostalCode) {
		this.facilityPostalCode = facilityPostalCode;
	}
	public String getOperatorPostalCode() {
		return operatorPostalCode;
	}
	public void setOperatorPostalCode(String operatorPostalCode) {
		this.operatorPostalCode = operatorPostalCode;
	}
	public String getSubmitterPosition1() {
		return submitterPosition1;
	}
	public void setSubmitterPosition1(String submitterPosition1) {
		this.submitterPosition1 = submitterPosition1;
	}
	public String getSubmitterPosition2() {
		return submitterPosition2;
	}
	public void setSubmitterPosition2(String submitterPosition2) {
		this.submitterPosition2 = submitterPosition2;
	}
	public String getSubmitterPosition3() {
		return submitterPosition3;
	}
	public void setSubmitterPosition3(String submitterPosition3) {
		this.submitterPosition3 = submitterPosition3;
	}
	public String getSubmitterPosition4() {
		return submitterPosition4;
	}
	public void setSubmitterPosition4(String submitterPosition4) {
		this.submitterPosition4 = submitterPosition4;
	}
	public String getSubmitterPosition5() {
		return submitterPosition5;
	}
	public void setSubmitterPosition5(String submitterPosition5) {
		this.submitterPosition5 = submitterPosition5;
	}
	public String getOperatorContactName() {
		return operatorContactName;
	}
	public void setOperatorContactName(String operatorContactName) {
		this.operatorContactName = operatorContactName;
	}
	public String getOperatorPhoneNumber() {
		return operatorPhoneNumber;
	}
	public void setOperatorPhoneNumber(String operatorPhoneNumber) {
		this.operatorPhoneNumber = operatorPhoneNumber;
	}
	public String getApproverPhoneNumber1() {
		return approverPhoneNumber1;
	}
	public void setApproverPhoneNumber1(String approverPhoneNumber1) {
		this.approverPhoneNumber1 = approverPhoneNumber1;
	}
	public String getApproverPhoneNumber2() {
		return approverPhoneNumber2;
	}
	public void setApproverPhoneNumber2(String approverPhoneNumber2) {
		this.approverPhoneNumber2 = approverPhoneNumber2;
	}
	public String getApproverPhoneNumber3() {
		return approverPhoneNumber3;
	}
	public void setApproverPhoneNumber3(String approverPhoneNumber3) {
		this.approverPhoneNumber3 = approverPhoneNumber3;
	}
	public String getApproverPhoneNumber4() {
		return approverPhoneNumber4;
	}
	public void setApproverPhoneNumber4(String approverPhoneNumber4) {
		this.approverPhoneNumber4 = approverPhoneNumber4;
	}
	public String getApproverPhoneNumber5() {
		return approverPhoneNumber5;
	}
	public void setApproverPhoneNumber5(String approverPhoneNumber5) {
		this.approverPhoneNumber5 = approverPhoneNumber5;
	}
	public String getOperatorContactEmail() {
		return operatorContactEmail;
	}
	public void setOperatorContactEmail(String operatorContactEmail) {
		this.operatorContactEmail = operatorContactEmail;
	}
	public String getOwnerContactPosition() {
		return ownerContactPosition;
	}
	public void setOwnerContactPosition(String ownerContactPosition) {
		this.ownerContactPosition = ownerContactPosition;
	}
	public String getFacilityOwnershipType() {
		return facilityOwnershipType;
	}
	public void setFacilityOwnershipType(String facilityOwnershipType) {
		this.facilityOwnershipType = facilityOwnershipType;
	}
	public String getSubmitterPhoneNumber1() {
		return submitterPhoneNumber1;
	}
	public void setSubmitterPhoneNumber1(String submitterPhoneNumber1) {
		this.submitterPhoneNumber1 = submitterPhoneNumber1;
	}
	public String getSubmitterPhoneNumber2() {
		return submitterPhoneNumber2;
	}
	public void setSubmitterPhoneNumber2(String submitterPhoneNumber2) {
		this.submitterPhoneNumber2 = submitterPhoneNumber2;
	}
	public String getSubmitterPhoneNumber3() {
		return submitterPhoneNumber3;
	}
	public void setSubmitterPhoneNumber3(String submitterPhoneNumber3) {
		this.submitterPhoneNumber3 = submitterPhoneNumber3;
	}
	public String getSubmitterPhoneNumber4() {
		return submitterPhoneNumber4;
	}
	public void setSubmitterPhoneNumber4(String submitterPhoneNumber4) {
		this.submitterPhoneNumber4 = submitterPhoneNumber4;
	}
	public String getSubmitterPhoneNumber5() {
		return submitterPhoneNumber5;
	}
	public void setSubmitterPhoneNumber5(String submitterPhoneNumber5) {
		this.submitterPhoneNumber5 = submitterPhoneNumber5;
	}
	public String getFacilityLegislationType() {
		return facilityLegislationType;
	}
	public void setFacilityLegislationType(String facilityLegislationType) {
		this.facilityLegislationType = facilityLegislationType;
	}
	public String getOperatorContactPosition() {
		return operatorContactPosition;
	}
	public void setOperatorContactPosition(String operatorContactPosition) {
		this.operatorContactPosition = operatorContactPosition;
	}
	public String getOwnerContactPhoneNumber() {
		return ownerContactPhoneNumber;
	}
	public void setOwnerContactPhoneNumber(String ownerContactPhoneNumber) {
		this.ownerContactPhoneNumber = ownerContactPhoneNumber;
	}
	public String getFacilityAccreditationBody() {
		return facilityAccreditationBody;
	}
	public void setFacilityAccreditationBody(String facilityAccreditationBody) {
		this.facilityAccreditationBody = facilityAccreditationBody;
	}
	public String getFacilityAccreditationDate() {
		return facilityAccreditationDate;
	}
	public void setFacilityAccreditationDate(String facilityAccreditationDate) {
		this.facilityAccreditationDate = facilityAccreditationDate;
	}
	public String getLocalHealthAuthorityLhaName() {
		return localHealthAuthorityLhaName;
	}
	public void setLocalHealthAuthorityLhaName(String localHealthAuthorityLhaName) {
		this.localHealthAuthorityLhaName = localHealthAuthorityLhaName;
	}
	public String getFacilityAccreditationExpiryDate() {
		return facilityAccreditationExpiryDate;
	}
	public void setFacilityAccreditationExpiryDate(String facilityAccreditationExpiryDate) {
		this.facilityAccreditationExpiryDate = facilityAccreditationExpiryDate;
	}
	public boolean isTheOwnerTheSameAsTheOperator1() {
		return isTheOwnerTheSameAsTheOperator1;
	}
	public void setTheOwnerTheSameAsTheOperator1(boolean isTheOwnerTheSameAsTheOperator1) {
		this.isTheOwnerTheSameAsTheOperator1 = isTheOwnerTheSameAsTheOperator1;
	}
	public Bcaddress getOwnerAddress() {
		return ownerAddress;
	}
	public void setOwnerAddress(Bcaddress ownerAddress) {
		this.ownerAddress = ownerAddress;
	}
	public Bcaddress getOperatorAddress() {
		return operatorAddress;
	}
	public void setOperatorAddress(Bcaddress operatorAddress) {
		this.operatorAddress = operatorAddress;
	}

}
