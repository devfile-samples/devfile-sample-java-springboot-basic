package ca.bc.gov.chefs.etl.forms.aims.model;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class MainEntity implements IModel {

	@JsonIgnore
	protected String confirmationId;
	@JsonIgnore
	protected String submissionDate;
	@JsonIgnore
	protected String submittedBy;

	@JsonProperty("submissionType")
	protected String submissionType;
	@JsonProperty("agencyCode")
	protected String agencyCode;
	@JsonProperty("programType1")
	protected String programType;
	@JsonProperty("officeCode1")
	protected String officeCode;
	@JsonProperty("referralSource1")
	protected String referralSource;
	@JsonProperty("date") // not confirmed yet
	protected String officeDate;
	@JsonProperty("regionalHa")
	protected String regionalHA;
	@JsonProperty("contractingHa")
	protected String contractingHA;
	@JsonProperty("personalHealthNumber")
	protected String healthNum;
	@JsonProperty("lastName")
	protected String lastName;
	@JsonProperty("givenNameFullName")
	protected String firstName;
	@JsonProperty("middleNameS")
	protected String middleName;
	@JsonProperty("birthdate")
	protected String birthDate;
	@JsonProperty("postalCode")
	protected String postalCode;
	@JsonProperty("primaryLanguage1")
	protected String primaryLanguage;
	@JsonProperty("educationLevel1")
	protected String educationLevel;
	@JsonProperty("maritalStatus1")
	protected String maritalStatus;
	@JsonProperty("employmentStatus1")
	protected String employmentStatus;
	@JsonProperty("numberOfDependentChildren")
	protected String numberDependentChildren;
	@JsonProperty("yoaClient1")
	protected String methadoneMaintainance;
	@JsonProperty("yoaClient2")
	protected String currentInjectionDrugUse;
	@JsonProperty("radioGroup1")
	protected String substance;
	@JsonProperty("otherPleaseSpecify")
	protected String otherClientInfo;
	@JsonProperty("relation4")
	protected String substanceRelation;
	@JsonProperty("primaryDrugOfChoice1")
	protected String primaryDrugOfChoice;
	@JsonProperty("radioGroup")
	protected String admScreenedRef;
	@JsonProperty("date1")
	protected String activityDate;
	@JsonProperty("serviceProviderCode2")
	protected String activityServiceProviderCode;
	@JsonProperty("radio1")
	protected String dischargeType;
	@JsonProperty("date2")
	protected String dischargeDate;
	@JsonProperty("serviceProviderCode")
	protected String dischargeServiceProviderCode;
	@JsonProperty("radioProgramCompletion")
	protected String dischargeProgramCompletion;
	
	@JsonIgnore
	protected List<AimsMisuse> aimsMisuses;
	
	@JsonUnwrapped
	protected AimsReferral aimsReferral;
		

	@JsonProperty("form")
	protected void unPackForm(Map<String,String> form) {
		this.confirmationId = form.get("confirmationId");
		this.submissionDate = form.get("createdAt");
		this.submittedBy = form.get("email");
	}
	
	@JsonProperty("selectBoxes1")
	protected void unPackSelectBoxes(Map<String,String> selectBoxes1) {
		
		List<AimsMisuse> aimsMisuses = new ArrayList<AimsMisuse>();
		for (Map.Entry<String, String> entry : selectBoxes1.entrySet()) {
			  if (entry.getValue().equals("true")) {
				 AimsMisuse aimsMisuse = new AimsMisuse();
				 aimsMisuse.setConfirmationId(this.confirmationId);
				 aimsMisuse.setSubstanceMisuse(entry.getKey());
				 aimsMisuses.add(aimsMisuse);
			  }
			}
		this.setAimsMisuses(aimsMisuses);
	}
	
	
	@Override
	public String getFileName() {
		return "AIMS_FORM";
	}
	@Override
	public String getFormType() {
		return Constants.AIMS_FORM;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.confirmationId);
		elements.add(this.submissionDate);
		elements.add(this.submittedBy);
		elements.add(this.submissionType);
		elements.add(this.agencyCode);
		elements.add(this.programType);
		elements.add(this.officeCode);
		elements.add(this.referralSource);
		elements.add(this.officeDate);
		elements.add(this.regionalHA);
		elements.add(this.contractingHA);
		elements.add(this.healthNum);
		elements.add(this.lastName);
		elements.add(this.firstName);
		elements.add(this.middleName);
		elements.add(this.birthDate);
		elements.add(this.postalCode);
		elements.add(this.primaryLanguage);
		elements.add(this.educationLevel);
		elements.add(this.maritalStatus);
		elements.add(this.employmentStatus);
		elements.add(this.numberDependentChildren);
		elements.add(this.methadoneMaintainance);
		elements.add(this.currentInjectionDrugUse);
		elements.add(this.substance);
		elements.add(this.otherClientInfo);
		elements.add(this.substanceRelation);
		elements.add(this.primaryDrugOfChoice);
		elements.add(this.admScreenedRef);
		elements.add(this.activityDate);
		elements.add(this.activityServiceProviderCode);
		elements.add(this.dischargeType);
		elements.add(this.dischargeDate);
		elements.add(this.dischargeServiceProviderCode);
		elements.add(this.dischargeProgramCompletion);
		
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		this.aimsReferral.setConfirmationId(this.confirmationId);
		List<IModel> objects = new ArrayList<>();
		if(this.getAimsMisuses()!=null) {
		objects.addAll(this.getAimsMisuses());
		}
		if(this.getAimsReferral()!=null) {
		objects.add(this.getAimsReferral());
		}
		return objects;
	}
	
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
	public String getSubmissionType() {
		return submissionType;
	}
	public void setSubmissionType(String submissionType) {
		this.submissionType = submissionType;
	}
	public String getAgencyCode() {
		return agencyCode;
	}
	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}
	public String getProgramType() {
		return programType;
	}
	public void setProgramType(String programType) {
		this.programType = programType;
	}
	public String getOfficeCode() {
		return officeCode;
	}
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	public String getReferralSource() {
		return referralSource;
	}
	public void setReferralSource(String referralSource) {
		this.referralSource = referralSource;
	}
	public String getOfficeDate() {
		return officeDate;
	}
	public void setOfficeDate(String officeDate) {
		this.officeDate = officeDate;
	}
	public String getRegionalHA() {
		return regionalHA;
	}
	public void setRegionalHA(String regionalHA) {
		this.regionalHA = regionalHA;
	}
	public String getContractingHA() {
		return contractingHA;
	}
	public void setContractingHA(String contractingHA) {
		this.contractingHA = contractingHA;
	}
	public String getHealthNum() {
		return healthNum;
	}
	public void setHealthNum(String healthNum) {
		this.healthNum = healthNum;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPrimaryLanguage() {
		return primaryLanguage;
	}
	public void setPrimaryLanguage(String primaryLanguage) {
		this.primaryLanguage = primaryLanguage;
	}
	public String getEducationLevel() {
		return educationLevel;
	}
	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getEmploymentStatus() {
		return employmentStatus;
	}
	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
	public String getNumberDependentChildren() {
		return numberDependentChildren;
	}
	public void setNumberDependentChildren(String numberDependentChildren) {
		this.numberDependentChildren = numberDependentChildren;
	}
	public String getMethadoneMaintainance() {
		return methadoneMaintainance;
	}
	public void setMethadoneMaintainance(String methadoneMaintainance) {
		this.methadoneMaintainance = methadoneMaintainance;
	}
	public String getCurrentInjectionDrugUse() {
		return currentInjectionDrugUse;
	}
	public void setCurrentInjectionDrugUse(String currentInjectionDrugUse) {
		this.currentInjectionDrugUse = currentInjectionDrugUse;
	}
	public String getSubstance() {
		return substance;
	}
	public void setSubstance(String substance) {
		this.substance = substance;
	}
	public String getOtherClientInfo() {
		return otherClientInfo;
	}
	public void setOtherClientInfo(String otherClientInfo) {
		this.otherClientInfo = otherClientInfo;
	}
	public String getSubstanceRelation() {
		return substanceRelation;
	}
	public void setSubstanceRelation(String substanceRelation) {
		this.substanceRelation = substanceRelation;
	}
	public String getPrimaryDrugOfChoice() {
		return primaryDrugOfChoice;
	}
	public void setPrimaryDrugOfChoice(String primaryDrugOfChoice) {
		this.primaryDrugOfChoice = primaryDrugOfChoice;
	}
	public String getAdmScreenedRef() {
		return admScreenedRef;
	}
	public void setAdmScreenedRef(String admScreenedRef) {
		this.admScreenedRef = admScreenedRef;
	}
	public String getActivityDate() {
		return activityDate;
	}
	public void setActivityDate(String activityDate) {
		this.activityDate = activityDate;
	}
	public String getActivityServiceProviderCode() {
		return activityServiceProviderCode;
	}
	public void setActivityServiceProviderCode(String activityServiceProviderCode) {
		this.activityServiceProviderCode = activityServiceProviderCode;
	}
	public String getDischargeType() {
		return dischargeType;
	}
	public void setDischargeType(String dischargeType) {
		this.dischargeType = dischargeType;
	}
	public String getDischargeDate() {
		return dischargeDate;
	}
	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	public String getDischargeServiceProviderCode() {
		return dischargeServiceProviderCode;
	}
	public void setDischargeServiceProviderCode(String dischargeServiceProviderCode) {
		this.dischargeServiceProviderCode = dischargeServiceProviderCode;
	}
	public String getDischargeProgramCompletion() {
		return dischargeProgramCompletion;
	}
	public void setDischargeProgramCompletion(String dischargeProgramCompletion) {
		this.dischargeProgramCompletion = dischargeProgramCompletion;
	}
	public List<AimsMisuse> getAimsMisuses() {
		return aimsMisuses;
	}
	public void setAimsMisuses(List<AimsMisuse> aimsMisuses) {
		this.aimsMisuses = aimsMisuses;
	}
	public AimsReferral getAimsReferral() {
		return aimsReferral;
	}
	public void setAimsReferral(AimsReferral aimsReferral) {
		this.aimsReferral = aimsReferral;
	}

	@Override
	public String toString() {
		return "MainEntity [confirmationId=" + confirmationId + ", submissionDate=" + submissionDate + ", submittedBy="
				+ submittedBy + ", submissionType=" + submissionType + ", agencyCode=" + agencyCode + ", programType="
				+ programType + ", officeCode=" + officeCode + ", referralSource=" + referralSource + ", officeDate="
				+ officeDate + ", regionalHA=" + regionalHA + ", contractingHA=" + contractingHA + ", healthNum="
				+ healthNum + ", lastName=" + lastName + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", birthDate=" + birthDate + ", postalCode=" + postalCode + ", primaryLanguage=" + primaryLanguage
				+ ", educationLevel=" + educationLevel + ", maritalStatus=" + maritalStatus + ", employmentStatus="
				+ employmentStatus + ", numberDependentChildren=" + numberDependentChildren + ", methadoneMaintainance="
				+ methadoneMaintainance + ", currentInjectionDrugUse=" + currentInjectionDrugUse + ", substance="
				+ substance + ", otherClientInfo=" + otherClientInfo + ", substanceRelation=" + substanceRelation
				+ ", primaryDrugOfChoice=" + primaryDrugOfChoice + ", admScreenedRef=" + admScreenedRef
				+ ", activityDate=" + activityDate + ", activityServiceProviderCode=" + activityServiceProviderCode
				+ ", dischargeType=" + dischargeType + ", dischargeDate=" + dischargeDate
				+ ", dischargeServiceProviderCode=" + dischargeServiceProviderCode + ", dischargeProgramCompletion="
				+ dischargeProgramCompletion + ", aimsMisuses=" + aimsMisuses + ", aimsReferral=" + aimsReferral + "]";
	}
	
	
}
