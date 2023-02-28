package ca.bc.gov.chefs.etl.forms.ltc.quaterly.model;

import java.util.ArrayList;

import java.util.List;
import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.parser.IModel;

public class LtcYtdSubmission implements IModel {

	/*
	 * Main Entity
	 */

	private String confirmationId;
	private String submissionDate;
	private String submittedBy;
	private String facilitySubId;
	private String period;
	private String submissionFy;
	private String nbTotalBeds;
	private String nbFundedBeds;
	private String occRateThreshold;
	private String isDeleted;

	private List<LtcBedYtdMaxOccupancy> ltcBedYtdMaxOccupancy;
	private List<LtcBedYtdOccupancyRate> ltcBedYtdOccupancyRate;
	private List<LtcBedYtdOccupiedDays> ltcBedYtdOccupiedDays;
	private List<LtcYtdCompAddPos> ltcYtdCompAddPos;
	private List<LtcYtdCompBenefits> ltcYtdCompBenefits;
	private List<LtcYtdCompHrs> ltcYtdCompHrs;
	private List<LtcYtdCompSal> ltcYtdCompSal;
	private List<LtcYtdDirectCareCost> ltcYtdDirectCareCost;
	private List<LtcYtdDirectCareHrs> ltcYtdDirectCareHrs;
	private List<LtcYtdExp> ltcYtdExp;
	private List<LtcYtdRev> ltcYtdRev;

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_YTD_SUBMISSION;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getIsDeleted());
		elements.add(this.getSubmissionDate());
		elements.add(this.getSubmittedBy());
		elements.add(this.getFacilitySubId());
		elements.add(this.getPeriod());
		elements.add(this.getSubmissionFy());
		elements.add(this.getNbTotalBeds());
		elements.add(this.getNbFundedBeds());
		elements.add(this.getOccRateThreshold());
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		List<IModel> ltcQtdInstances = new ArrayList<>();
		ltcQtdInstances.addAll(this.getLtcBedYtdMaxOccupancy());
		ltcQtdInstances.addAll(this.getLtcBedYtdOccupancyRate());
		ltcQtdInstances.addAll(this.getLtcBedYtdOccupiedDays());
		ltcQtdInstances.addAll(this.getLtcYtdCompAddPos());
		ltcQtdInstances.addAll(this.getLtcYtdCompBenefits());
		ltcQtdInstances.addAll(this.getLtcYtdCompHrs());
		ltcQtdInstances.addAll(this.getLtcYtdCompSal());
		ltcQtdInstances.addAll(this.getLtcYtdDirectCareCost());
		ltcQtdInstances.addAll(this.getLtcYtdDirectCareHrs());
		ltcQtdInstances.addAll(this.getLtcYtdExp());
		ltcQtdInstances.addAll(this.getLtcYtdRev());

		return ltcQtdInstances;
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

	public String getFacilitySubId() {
		return facilitySubId;
	}

	public void setFacilitySubId(String facilitySubId) {
		this.facilitySubId = facilitySubId;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getSubmissionFy() {
		return submissionFy;
	}

	public void setSubmissionFy(String submissionFy) {
		this.submissionFy = submissionFy;
	}

	public String getNbTotalBeds() {
		return nbTotalBeds;
	}

	public void setNbTotalBeds(String nbTotalBeds) {
		this.nbTotalBeds = nbTotalBeds;
	}

	public String getNbFundedBeds() {
		return nbFundedBeds;
	}

	public void setNbFundedBeds(String nbFundedBeds) {
		this.nbFundedBeds = nbFundedBeds;
	}

	public String getOccRateThreshold() {
		return occRateThreshold;
	}

	public void setOccRateThreshold(String occRateThreshold) {
		this.occRateThreshold = occRateThreshold;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public List<LtcBedYtdMaxOccupancy> getLtcBedYtdMaxOccupancy() {
		return ltcBedYtdMaxOccupancy;
	}

	public void setLtcBedYtdMaxOccupancy(List<LtcBedYtdMaxOccupancy> ltcBedYtdMaxOccupancy) {
		this.ltcBedYtdMaxOccupancy = ltcBedYtdMaxOccupancy;
	}

	public List<LtcBedYtdOccupancyRate> getLtcBedYtdOccupancyRate() {
		return ltcBedYtdOccupancyRate;
	}

	public void setLtcBedYtdOccupancyRate(List<LtcBedYtdOccupancyRate> ltcBedYtdOccupancyRate) {
		this.ltcBedYtdOccupancyRate = ltcBedYtdOccupancyRate;
	}

	public List<LtcBedYtdOccupiedDays> getLtcBedYtdOccupiedDays() {
		return ltcBedYtdOccupiedDays;
	}

	public void setLtcBedYtdOccupiedDays(List<LtcBedYtdOccupiedDays> ltcBedYtdOccupiedDays) {
		this.ltcBedYtdOccupiedDays = ltcBedYtdOccupiedDays;
	}

	public List<LtcYtdCompAddPos> getLtcYtdCompAddPos() {
		return ltcYtdCompAddPos;
	}

	public void setLtcYtdCompAddPos(List<LtcYtdCompAddPos> ltcYtdCompAddPos) {
		this.ltcYtdCompAddPos = ltcYtdCompAddPos;
	}

	public List<LtcYtdCompBenefits> getLtcYtdCompBenefits() {
		return ltcYtdCompBenefits;
	}

	public void setLtcYtdCompBenefits(List<LtcYtdCompBenefits> ltcYtdCompBenefits) {
		this.ltcYtdCompBenefits = ltcYtdCompBenefits;
	}

	public List<LtcYtdCompHrs> getLtcYtdCompHrs() {
		return ltcYtdCompHrs;
	}

	public void setLtcYtdCompHrs(List<LtcYtdCompHrs> ltcYtdCompHrs) {
		this.ltcYtdCompHrs = ltcYtdCompHrs;
	}

	public List<LtcYtdCompSal> getLtcYtdCompSal() {
		return ltcYtdCompSal;
	}

	public void setLtcYtdCompSal(List<LtcYtdCompSal> ltcYtdCompSal) {
		this.ltcYtdCompSal = ltcYtdCompSal;
	}

	public List<LtcYtdDirectCareCost> getLtcYtdDirectCareCost() {
		return ltcYtdDirectCareCost;
	}

	public void setLtcYtdDirectCareCost(List<LtcYtdDirectCareCost> ltcYtdDirectCareCost) {
		this.ltcYtdDirectCareCost = ltcYtdDirectCareCost;
	}

	public List<LtcYtdDirectCareHrs> getLtcYtdDirectCareHrs() {
		return ltcYtdDirectCareHrs;
	}

	public void setLtcYtdDirectCareHrs(List<LtcYtdDirectCareHrs> ltcYtdDirectCareHrs) {
		this.ltcYtdDirectCareHrs = ltcYtdDirectCareHrs;
	}

	public List<LtcYtdExp> getLtcYtdExp() {
		return ltcYtdExp;
	}

	public void setLtcYtdExp(List<LtcYtdExp> ltcYtdExp) {
		this.ltcYtdExp = ltcYtdExp;
	}

	public List<LtcYtdRev> getLtcYtdRev() {
		return ltcYtdRev;
	}

	public void setLtcYtdRev(List<LtcYtdRev> ltcYtdRev) {
		this.ltcYtdRev = ltcYtdRev;
	}

}
