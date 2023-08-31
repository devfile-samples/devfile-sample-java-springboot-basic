package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class LtcYtdSubmission implements IModel {

	/*
	 * Main Entity
	 */

	private String confirmationId;
	private String isDeleted;
	private String submissionDate;
	private String submittedBy;
	private String CCIMSID;
	private String submissionType;
	private String period;
	private String submissionFy;
	private String nbTotalBeds;
	private String nbFundedBeds;
	private String occRateThreshold;
	private String totalSalariesWages;
	private String totalBenefits;
	private String benefitsPercent;
	private String totalVacancies;

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
	private List<LtcYtdDep> ltcYtdDep;
	private List<LtcYtdDepSubTotals> ltcYtdDepSubTotals;
	private List<LtcYtdRev> ltcYtdRev;
	private List<LtcYtdExpSubTotals> ltcYtdExpSubttls;
	private List<LtcYtdRevSubTotals> ltcYtdRevSubttls;
	private List<LtcYtdSumTotals> ltcYtdSumTotals;
	private List<LtcYtdCompSalSubtotals> ltcYtdCompSalSubttls;
	private List<LtcYtdCompSalTotals> ltcYtdCompSalTtls;
	private List<LtcYtdCompHrsSubtotals> ltcYtdCompHrsSubttls;
	private List<LtcYtdCompHrsTotals> ltcYtdCompHrsTtls;
	private List<LtcYtdDirectCareHrsSubTotals> ltcYtdDirectCareHrsSubttls;
	private List<LtcYtdDirectCareCostSubtotals> ltcYtdDirectCareCostSubttls;
	private List<LtcBedYtdMaxOccupancyTotals> ltcBedYtdMaxOccTtls;
	private List<LtcBedYtdOccupiedDaysTotals> ltcBedYtdOccDaysTtls;
	private List<LtcBedYtdOccupancyRateTotals> ltcBedYtdOccRateTtls;
	private List<LtcYtdDirectCareVacancy> LtcYtdDirectCareVacancy;
	

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
		elements.add(this.getCCIMSID());
		elements.add(this.getSubmissionType());
		elements.add(this.getPeriod());
		elements.add(this.getSubmissionFy());
		elements.add(this.getNbTotalBeds());
		elements.add(this.getNbFundedBeds());
		elements.add(this.getOccRateThreshold());
		elements.add(this.getTotalBenefits());
		elements.add(this.getTotalSalariesWages());
		elements.add(this.getBenefitsPercent());
		elements.add(this.getTotalVacancies());
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
		ltcQtdInstances.addAll(this.getLtcYtdDep());
		ltcQtdInstances.addAll(this.getLtcYtdDepSubTotals());
		ltcQtdInstances.addAll(this.getLtcYtdSumTotals());
		ltcQtdInstances.addAll(this.getLtcYtdExpSubttls());
		ltcQtdInstances.addAll(this.getLtcYtdRevSubttls());
		ltcQtdInstances.addAll(this.getLtcYtdCompSalSubttls());
		ltcQtdInstances.addAll(this.getLtcYtdCompSalTtls());
		ltcQtdInstances.addAll(this.getLtcYtdCompHrsSubttls());
		ltcQtdInstances.addAll(this.getLtcYtdCompHrsTtls());
		ltcQtdInstances.addAll(this.getLtcYtdDirectCareHrsSubttls());
		ltcQtdInstances.addAll(this.getLtcYtdDirectCareCostSubttls());
		ltcQtdInstances.addAll(this.getLtcBedYtdMaxOccTtls());
		ltcQtdInstances.addAll(this.getLtcBedYtdOccDaysTtls());
		ltcQtdInstances.addAll(this.getLtcBedYtdOccRateTtls());
		ltcQtdInstances.addAll(this.getLtcYtdDirectCareVacancy());

		return ltcQtdInstances;
	}

	public String getConfirmationId() {
		return confirmationId;
	}

	public void setConfirmationId(String confirmationId) {
		this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
	}

	public String getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = CSVUtil.getFormattedDate(submissionDate);
	}

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = StringUtils.defaultIfEmpty(submittedBy, Constants.DEFAULT_STRING_VALUE);
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = StringUtils.defaultIfEmpty(period, Constants.DEFAULT_STRING_VALUE);
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
		this.isDeleted = StringUtils.defaultIfEmpty(isDeleted, Constants.DEFAULT_STRING_VALUE);
	}

	public String getCCIMSID() {
		return CCIMSID;
	}

	public void setCCIMSID(String cCIMSID) {
		CCIMSID = StringUtils.defaultIfEmpty(cCIMSID, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getSubmissionType() {
		return submissionType;
	}

	public void setSubmissionType(String submissionType) {
		this.submissionType = StringUtils.defaultIfEmpty(submissionType, Constants.DEFAULT_STRING_VALUE);
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

	public List<LtcYtdExpSubTotals> getLtcYtdExpSubttls() {
		return ltcYtdExpSubttls;
	}

	public void setLtcYtdExpSubttls(List<LtcYtdExpSubTotals> ltcYtdExpSubttls) {
		this.ltcYtdExpSubttls = ltcYtdExpSubttls;
	}

	public List<LtcYtdRevSubTotals> getLtcYtdRevSubttls() {
		return ltcYtdRevSubttls;
	}

	public void setLtcYtdRevSubttls(List<LtcYtdRevSubTotals> ltcYtdRevSubttls) {
		this.ltcYtdRevSubttls = ltcYtdRevSubttls;
	}

	public List<LtcYtdCompSalSubtotals> getLtcYtdCompSalSubttls() {
		return ltcYtdCompSalSubttls;
	}

	public void setLtcYtdCompSalSubttls(List<LtcYtdCompSalSubtotals> ltcYtdCompSalSubttls) {
		this.ltcYtdCompSalSubttls = ltcYtdCompSalSubttls;
	}

	public List<LtcYtdCompSalTotals> getLtcYtdCompSalTtls() {
		return ltcYtdCompSalTtls;
	}

	public void setLtcYtdCompSalTtls(List<LtcYtdCompSalTotals> ltcYtdCompSalTtls) {
		this.ltcYtdCompSalTtls = ltcYtdCompSalTtls;
	}

	public List<LtcYtdCompHrsSubtotals> getLtcYtdCompHrsSubttls() {
		return ltcYtdCompHrsSubttls;
	}

	public void setLtcYtdCompHrsSubttls(List<LtcYtdCompHrsSubtotals> ltcYtdCompHrsSubttls) {
		this.ltcYtdCompHrsSubttls = ltcYtdCompHrsSubttls;
	}

	public List<LtcYtdCompHrsTotals> getLtcYtdCompHrsTtls() {
		return ltcYtdCompHrsTtls;
	}

	public void setLtcYtdCompHrsTtls(List<LtcYtdCompHrsTotals> ltcYtdCompHrsTtls) {
		this.ltcYtdCompHrsTtls = ltcYtdCompHrsTtls;
	}

	public List<LtcYtdDirectCareHrsSubTotals> getLtcYtdDirectCareHrsSubttls() {
		return ltcYtdDirectCareHrsSubttls;
	}

	public void setLtcYtdDirectCareHrsSubttls(List<LtcYtdDirectCareHrsSubTotals> ltcYtdDirectCareHrsSubttls) {
		this.ltcYtdDirectCareHrsSubttls = ltcYtdDirectCareHrsSubttls;
	}

	public List<LtcYtdDirectCareCostSubtotals> getLtcYtdDirectCareCostSubttls() {
		return ltcYtdDirectCareCostSubttls;
	}

	public void setLtcYtdDirectCareCostSubttls(List<LtcYtdDirectCareCostSubtotals> ltcYtdDirectCareCostSubttls) {
		this.ltcYtdDirectCareCostSubttls = ltcYtdDirectCareCostSubttls;
	}

	public List<LtcBedYtdMaxOccupancyTotals> getLtcBedYtdMaxOccTtls() {
		return ltcBedYtdMaxOccTtls;
	}

	public void setLtcBedYtdMaxOccTtls(List<LtcBedYtdMaxOccupancyTotals> ltcBedYtdMaxOccTtls) {
		this.ltcBedYtdMaxOccTtls = ltcBedYtdMaxOccTtls;
	}

	public List<LtcBedYtdOccupiedDaysTotals> getLtcBedYtdOccDaysTtls() {
		return ltcBedYtdOccDaysTtls;
	}

	public void setLtcBedYtdOccDaysTtls(List<LtcBedYtdOccupiedDaysTotals> ltcBedYtdOccDaysTtls) {
		this.ltcBedYtdOccDaysTtls = ltcBedYtdOccDaysTtls;
	}

	public List<LtcBedYtdOccupancyRateTotals> getLtcBedYtdOccRateTtls() {
		return ltcBedYtdOccRateTtls;
	}

	public void setLtcBedYtdOccRateTtls(List<LtcBedYtdOccupancyRateTotals> ltcBedYtdOccRateTtls) {
		this.ltcBedYtdOccRateTtls = ltcBedYtdOccRateTtls;
	}

	public List<LtcYtdDirectCareVacancy> getLtcYtdDirectCareVacancy() {
		return LtcYtdDirectCareVacancy;
	}

	public void setLtcYtdDirectCareVacancy(List<LtcYtdDirectCareVacancy> ltcYtdDirectCareVacancy) {
		this.LtcYtdDirectCareVacancy = ltcYtdDirectCareVacancy;
	}

	public String getSubmissionFy() {
		return submissionFy;
	}

	public void setSubmissionFy(String submissionFy) {
		this.submissionFy = StringUtils.defaultIfEmpty(submissionFy, Constants.DEFAULT_STRING_VALUE);
	}
	public List<LtcYtdDep> getLtcYtdDep() {
		return ltcYtdDep;
	}

	public void setLtcYtdDep(List<LtcYtdDep> ltcYtdDep) {
		this.ltcYtdDep = ltcYtdDep;
	}
	public List<LtcYtdDepSubTotals> getLtcYtdDepSubTotals() {
		return ltcYtdDepSubTotals;
	}

	public void setLtcYtdDepSubTotals(List<LtcYtdDepSubTotals> ltcYtdDepSubTotals) {
		this.ltcYtdDepSubTotals = ltcYtdDepSubTotals;
	}
	public List<LtcYtdSumTotals> getLtcYtdSumTotals() {
		return ltcYtdSumTotals;
	}

	public void setLtcYtdSumTotals(List<LtcYtdSumTotals> ltcYtdSumTotals) {
		this.ltcYtdSumTotals = ltcYtdSumTotals;
	}
	
	public String getTotalBenefits() {
		return totalBenefits;
	}

	public void setTotalBenefits(String totalBenefits) {
		this.totalBenefits = totalBenefits;
	}
	
	public String getBenefitsPercent() {
		return benefitsPercent;
	}

	public void setBenefitsPercent(String benefitsPercent) {
		this.benefitsPercent = benefitsPercent;
	}

	public String getTotalVacancies() {
		return totalVacancies;
	}

	public void setTotalVacancies(String totalVacancies) {
		this.totalVacancies = totalVacancies;
	}

	public String getTotalSalariesWages() {
		return totalSalariesWages;
	}

	public void setTotalSalariesWages(String totalSalariesWages) {
		this.totalSalariesWages = totalSalariesWages;
	}
	
}
