package ca.bc.gov.chefs.etl.forms.ltc.facility.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class FacilityInformation implements IModel {
	
	private String ConfirmationID;
	private String IsDeleted;
	private String SubmissionDate;
	private String Submittedby;
	private String FacilityName;
	private String FacilityAddress;
	private String FacilityCity;
	private String FacilityPostalCode;
	private String FacilityTelephone;
	private String FacilityWebsite;
	private String CCIMSID;
	private String Programtype;
	private String Ownershiptype;
	private String Legislationtype;
	private String AccreditationBody;
	private String AccreditationDate;
	private String AccreditationExpiryDate;
	private String HealthAuthority;
	private String OwnerName;
	private String OwnerAddress;
	private String OwnerCity;
	private String Ownerpostalcode;
	private String OwnercontactName;
	private String Ownercontactphone;
	private String Ownercontactposition;
	private String Ownercontactemail;
	private String OperatorName;
	private String OperatorAddress;
	private String OperatorCity;
	private String Operatorpostalcode;
	private String OperatorcontactName;
	private String Operatorcontactphone;
	private String Operatorcontactposition;
	private String Operatorcontactemail;
	
	private List<Approver> approvers;
	private List<Preparer> preparer;
	
	public String getConfirmationID() {
		return ConfirmationID;
	}
	public void setConfirmationID(String confirmationID) {
		ConfirmationID = confirmationID;
	}
	public String getIsDeleted() {
		return IsDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		IsDeleted = isDeleted;
	}
	public String getSubmissionDate() {
		return CSVUtil.getFormattedDate(SubmissionDate);
	}
	public void setSubmissionDate(String submissionDate) {
		SubmissionDate = submissionDate;
	}
	public String getSubmittedby() {
		return Submittedby;
	}
	public void setSubmittedby(String submittedby) {
		Submittedby = submittedby;
	}
	public String getFacilityName() {
		return FacilityName;
	}
	public void setFacilityName(String facilityName) {
		FacilityName = facilityName;
	}
	public String getFacilityAddress() {
		return FacilityAddress;
	}
	public void setFacilityAddress(String facilityAddress) {
		FacilityAddress = facilityAddress;
	}
	public String getFacilityCity() {
		return FacilityCity;
	}
	public void setFacilityCity(String facilityCity) {
		FacilityCity = facilityCity;
	}
	public String getFacilityPostalCode() {
		return FacilityPostalCode;
	}
	public void setFacilityPostalCode(String facilityPostalCode) {
		FacilityPostalCode = facilityPostalCode;
	}
	public String getFacilityTelephone() {
		return FacilityTelephone;
	}
	public void setFacilityTelephone(String facilityTelephone) {
		FacilityTelephone = facilityTelephone;
	}
	public String getFacilityWebsite() {
		return FacilityWebsite;
	}
	public void setFacilityWebsite(String facilityWebsite) {
		FacilityWebsite = facilityWebsite;
	}
	public String getCCIMSID() {
		return CCIMSID;
	}
	public void setCCIMSID(String cCIMSID) {
		CCIMSID = cCIMSID;
	}
	public String getProgramtype() {
		return Programtype;
	}
	public void setProgramtype(String programtype) {
		Programtype = programtype;
	}
	public String getOwnershiptype() {
		return Ownershiptype;
	}
	public void setOwnershiptype(String ownershiptype) {
		Ownershiptype = ownershiptype;
	}
	public String getLegislationtype() {
		return Legislationtype;
	}
	public void setLegislationtype(String legislationtype) {
		Legislationtype = legislationtype;
	}
	public String getAccreditationBody() {
		return AccreditationBody;
	}
	public void setAccreditationBody(String accreditationBody) {
		AccreditationBody = accreditationBody;
	}
	public String getAccreditationDate() {
		return CSVUtil.getFormattedDate(AccreditationDate);
	}
	public void setAccreditationDate(String accreditationDate) {
		AccreditationDate = accreditationDate;
	}
	public String getAccreditationExpiryDate() {
		return CSVUtil.getFormattedDate(AccreditationExpiryDate);
	}
	public void setAccreditationExpiryDate(String accreditationExpiryDate) {
		AccreditationExpiryDate = accreditationExpiryDate;
	}
	public String getHealthAuthority() {
		return HealthAuthority;
	}
	public void setHealthAuthority(String healthAuthority) {
		HealthAuthority = healthAuthority;
	}
	public String getOwnerName() {
		return OwnerName;
	}
	public void setOwnerName(String ownerName) {
		OwnerName = ownerName;
	}
	public String getOwnerAddress() {
		return OwnerAddress;
	}
	public void setOwnerAddress(String ownerAddress) {
		OwnerAddress = ownerAddress;
	}
	public String getOwnerCity() {
		return OwnerCity;
	}
	public void setOwnerCity(String ownerCity) {
		OwnerCity = ownerCity;
	}
	public String getOwnerpostalcode() {
		return Ownerpostalcode;
	}
	public void setOwnerpostalcode(String ownerpostalcode) {
		Ownerpostalcode = ownerpostalcode;
	}
	public String getOwnercontactName() {
		return OwnercontactName;
	}
	public void setOwnercontactName(String ownercontactName) {
		OwnercontactName = ownercontactName;
	}
	public String getOwnercontactphone() {
		return Ownercontactphone;
	}
	public void setOwnercontactphone(String ownercontactphone) {
		Ownercontactphone = ownercontactphone;
	}
	public String getOwnercontactposition() {
		return Ownercontactposition;
	}
	public void setOwnercontactposition(String ownercontactposition) {
		Ownercontactposition = ownercontactposition;
	}
	public String getOwnercontactemail() {
		return Ownercontactemail;
	}
	public void setOwnercontactemail(String ownercontactemail) {
		Ownercontactemail = ownercontactemail;
	}
	public String getOperatorName() {
		return OperatorName;
	}
	public void setOperatorName(String operatorName) {
		OperatorName = operatorName;
	}
	public String getOperatorAddress() {
		return OperatorAddress;
	}
	public void setOperatorAddress(String operatorAddress) {
		OperatorAddress = operatorAddress;
	}
	public String getOperatorCity() {
		return OperatorCity;
	}
	public void setOperatorCity(String operatorCity) {
		OperatorCity = operatorCity;
	}
	public String getOperatorpostalcode() {
		return Operatorpostalcode;
	}
	public void setOperatorpostalcode(String operatorpostalcode) {
		Operatorpostalcode = operatorpostalcode;
	}
	public String getOperatorcontactName() {
		return OperatorcontactName;
	}
	public void setOperatorcontactName(String operatorcontactName) {
		OperatorcontactName = operatorcontactName;
	}
	public String getOperatorcontactphone() {
		return Operatorcontactphone;
	}
	public void setOperatorcontactphone(String operatorcontactphone) {
		Operatorcontactphone = operatorcontactphone;
	}
	public String getOperatorcontactposition() {
		return Operatorcontactposition;
	}
	public void setOperatorcontactposition(String operatorcontactposition) {
		Operatorcontactposition = operatorcontactposition;
	}
	public String getOperatorcontactemail() {
		return Operatorcontactemail;
	}
	public void setOperatorcontactemail(String operatorcontactemail) {
		Operatorcontactemail = operatorcontactemail;
	}
	
	public List<Approver> getApprovers() {
		return approvers;
	}
	public void setApprovers(List<Approver> approvers) {
		this.approvers = approvers;
	}
	public List<Preparer> getPreparers() {
		return preparer;
	}
	public void setPreparers(List<Preparer> preparer) {
		this.preparer = preparer;
	}
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
		elements.add(this.getConfirmationID());
		elements.add("false"); // FIXME
		elements.add(this.getSubmissionDate());
		elements.add(this.getSubmittedby());
		elements.add(this.getFacilityName());
		elements.add(this.getFacilityAddress());
		elements.add(this.getFacilityCity());
		elements.add(this.getFacilityPostalCode());
		elements.add(this.getFacilityTelephone());
		elements.add(this.getFacilityWebsite());
		elements.add(this.getCCIMSID());
		elements.add(this.getProgramtype());
		elements.add(this.getOwnershiptype());
		elements.add(this.getLegislationtype());
		elements.add(this.getAccreditationBody());
		elements.add(this.getAccreditationDate());
		elements.add(this.getAccreditationExpiryDate());
		elements.add(this.getHealthAuthority());
		elements.add(this.getOwnerName());
		elements.add(this.getOwnerAddress());
		elements.add(this.getOwnerCity());
		elements.add(this.getOwnerpostalcode());
		elements.add(this.getOwnercontactName());
		elements.add(this.getOwnercontactphone());
		elements.add(this.getOwnercontactposition());
		elements.add(this.getOwnercontactemail());
		elements.add(this.getOperatorName());
		elements.add(this.getOperatorAddress());
		elements.add(this.getOperatorCity());
		elements.add(this.getOperatorpostalcode());
		elements.add(this.getOperatorcontactName());
		elements.add(this.getOperatorcontactphone());
		elements.add(this.getOperatorcontactposition());
		elements.add(this.getOperatorcontactemail());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		List<IModel> objects = new ArrayList<>();
		objects.addAll(this.getPreparers());
		objects.addAll(this.getApprovers());
		return objects;
	}

	
}
