package ca.bc.gov.chefs.etl.forms.ltc.budget.model;

import java.util.ArrayList;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class LtcBudgetSubmission implements IModel {

	/*
	 * Main Entity
	 */

	private String confirmationId;
	private String isDeleted;
	private String submissionDate;
	private String submittedBy;
	private String CCIMSID;
	private String submissionType;
	private String submissionFy;
	private String nbTotalBeds;
	private String nbFundedBeds;
	private String totalSalariesWages;
	private String totalBenefits;
	private String benefitsPercent;

	private List<LtcBudgetCompAddPos> ltcBudgetCompAddPos;
	private List<LtcBudgetCompBenefits> ltcBudgetCompBenefits;
	private List<LtcBudgetCompHrs> ltcBudgetCompHrs;
	private List<LtcBudgetCompSal> ltcBudgetCompSal;
	private List<LtcBudgetDirectCareCost> ltcBudgetDirectCareCost;
	private List<LtcBudgetDirectCareHrs> ltcBudgetDirectCareHrs;
	private List<LtcBudgetExp> ltcBudgetExp;
	private List<LtcBudgetDep> ltcBudgetDep;
	private List<LtcBudgetDepSubTotals> ltcBudgetDepSubTotals;
	private List<LtcBudgetRev> ltcBudgetRev;
	private List<LtcBudgetExpTotals> ltcBudgetExpSubttls;
	private List<LtcBudgetRevTotals> ltcBudgetRevSubttls;
	private List<LtcBudgetSumTotals> ltcBudgetSumTotals;
	private List<LtcBudgetCompSalSubtotals> ltcBudgetCompSalSubttls;
	private List<LtcBudgetCompSalTotals> ltcBudgetCompSalTtls;
	private List<LtcBudgetCompHrsSubtotals> ltcBudgetCompHrsSubttls;
	private List<LtcBudgetCompHrsTotals> ltcBudgetCompHrsTtls;
	private List<LtcBudgetDirectCareHrsSubTotals> ltcBudgetDirectCareHrsSubttls;
	private List<LtcBudgetDirectCareCostSubtotals> ltcBudgetDirectCareCostSubttls;
	

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_BUDGET_SUBMISSION;
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
		elements.add(this.getSubmissionFy());
		elements.add(this.getNbTotalBeds());
		elements.add(this.getNbFundedBeds());
		elements.add(this.getTotalBenefits());
		elements.add(this.getTotalSalariesWages());
		elements.add(this.getBenefitsPercent());
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		List<IModel> ltcQtdInstances = new ArrayList<>();
		ltcQtdInstances.addAll(this.getLtcBudgetCompAddPos());
		ltcQtdInstances.addAll(this.getLtcBudgetCompBenefits());
		ltcQtdInstances.addAll(this.getLtcBudgetCompHrs());
		ltcQtdInstances.addAll(this.getLtcBudgetCompSal());
		ltcQtdInstances.addAll(this.getLtcBudgetDirectCareCost());
		ltcQtdInstances.addAll(this.getLtcBudgetDirectCareHrs());
		ltcQtdInstances.addAll(this.getLtcBudgetExp());
		ltcQtdInstances.addAll(this.getLtcBudgetRev());
		ltcQtdInstances.addAll(this.getLtcBudgetDep());
		ltcQtdInstances.addAll(this.getLtcBudgetDepSubTotals());
		ltcQtdInstances.addAll(this.getLtcBudgetSumTotals());
		ltcQtdInstances.addAll(this.getLtcBudgetExpSubttls());
		ltcQtdInstances.addAll(this.getLtcBudgetRevSubttls());
		ltcQtdInstances.addAll(this.getLtcBudgetCompSalSubttls());
		ltcQtdInstances.addAll(this.getLtcBudgetCompSalTtls());
		ltcQtdInstances.addAll(this.getLtcBudgetCompHrsSubttls());
		ltcQtdInstances.addAll(this.getLtcBudgetCompHrsTtls());
		ltcQtdInstances.addAll(this.getLtcBudgetDirectCareHrsSubttls());
		ltcQtdInstances.addAll(this.getLtcBudgetDirectCareCostSubttls());

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

	public List<LtcBudgetCompAddPos> getLtcBudgetCompAddPos() {
		return ltcBudgetCompAddPos;
	}

	public void setLtcBudgetCompAddPos(List<LtcBudgetCompAddPos> ltcBudgetCompAddPos) {
		this.ltcBudgetCompAddPos = ltcBudgetCompAddPos;
	}

	public List<LtcBudgetCompBenefits> getLtcBudgetCompBenefits() {
		return ltcBudgetCompBenefits;
	}

	public void setLtcBudgetCompBenefits(List<LtcBudgetCompBenefits> ltcBudgetCompBenefits) {
		this.ltcBudgetCompBenefits = ltcBudgetCompBenefits;
	}

	public List<LtcBudgetCompHrs> getLtcBudgetCompHrs() {
		return ltcBudgetCompHrs;
	}

	public void setLtcBudgetCompHrs(List<LtcBudgetCompHrs> ltcBudgetCompHrs) {
		this.ltcBudgetCompHrs = ltcBudgetCompHrs;
	}

	public List<LtcBudgetCompSal> getLtcBudgetCompSal() {
		return ltcBudgetCompSal;
	}

	public void setLtcBudgetCompSal(List<LtcBudgetCompSal> ltcBudgetCompSal) {
		this.ltcBudgetCompSal = ltcBudgetCompSal;
	}

	public List<LtcBudgetDirectCareCost> getLtcBudgetDirectCareCost() {
		return ltcBudgetDirectCareCost;
	}

	public void setLtcBudgetDirectCareCost(List<LtcBudgetDirectCareCost> ltcBudgetDirectCareCost) {
		this.ltcBudgetDirectCareCost = ltcBudgetDirectCareCost;
	}

	public List<LtcBudgetDirectCareHrs> getLtcBudgetDirectCareHrs() {
		return ltcBudgetDirectCareHrs;
	}

	public void setLtcBudgetDirectCareHrs(List<LtcBudgetDirectCareHrs> ltcBudgetDirectCareHrs) {
		this.ltcBudgetDirectCareHrs = ltcBudgetDirectCareHrs;
	}

	public List<LtcBudgetExp> getLtcBudgetExp() {
		return ltcBudgetExp;
	}

	public void setLtcBudgetExp(List<LtcBudgetExp> ltcBudgetExp) {
		this.ltcBudgetExp = ltcBudgetExp;
	}

	public List<LtcBudgetRev> getLtcBudgetRev() {
		return ltcBudgetRev;
	}

	public void setLtcBudgetRev(List<LtcBudgetRev> ltcBudgetRev) {
		this.ltcBudgetRev = ltcBudgetRev;
	}

	public List<LtcBudgetExpTotals> getLtcBudgetExpSubttls() {
		return ltcBudgetExpSubttls;
	}

	public void setLtcBudgetExpSubttls(List<LtcBudgetExpTotals> ltcBudgetExpSubttls) {
		this.ltcBudgetExpSubttls = ltcBudgetExpSubttls;
	}

	public List<LtcBudgetRevTotals> getLtcBudgetRevSubttls() {
		return ltcBudgetRevSubttls;
	}

	public void setLtcBudgetRevSubttls(List<LtcBudgetRevTotals> ltcBudgetRevSubttls) {
		this.ltcBudgetRevSubttls = ltcBudgetRevSubttls;
	}

	public List<LtcBudgetCompSalSubtotals> getLtcBudgetCompSalSubttls() {
		return ltcBudgetCompSalSubttls;
	}

	public void setLtcBudgetCompSalSubttls(List<LtcBudgetCompSalSubtotals> ltcBudgetCompSalSubttls) {
		this.ltcBudgetCompSalSubttls = ltcBudgetCompSalSubttls;
	}

	public List<LtcBudgetCompSalTotals> getLtcBudgetCompSalTtls() {
		return ltcBudgetCompSalTtls;
	}

	public void setLtcBudgetCompSalTtls(List<LtcBudgetCompSalTotals> ltcBudgetCompSalTtls) {
		this.ltcBudgetCompSalTtls = ltcBudgetCompSalTtls;
	}

	public List<LtcBudgetCompHrsSubtotals> getLtcBudgetCompHrsSubttls() {
		return ltcBudgetCompHrsSubttls;
	}

	public void setLtcBudgetCompHrsSubttls(List<LtcBudgetCompHrsSubtotals> ltcBudgetCompHrsSubttls) {
		this.ltcBudgetCompHrsSubttls = ltcBudgetCompHrsSubttls;
	}

	public List<LtcBudgetCompHrsTotals> getLtcBudgetCompHrsTtls() {
		return ltcBudgetCompHrsTtls;
	}

	public void setLtcBudgetCompHrsTtls(List<LtcBudgetCompHrsTotals> ltcBudgetCompHrsTtls) {
		this.ltcBudgetCompHrsTtls = ltcBudgetCompHrsTtls;
	}

	public List<LtcBudgetDirectCareHrsSubTotals> getLtcBudgetDirectCareHrsSubttls() {
		return ltcBudgetDirectCareHrsSubttls;
	}

	public void setLtcBudgetDirectCareHrsSubttls(List<LtcBudgetDirectCareHrsSubTotals> ltcBudgetDirectCareHrsSubttls) {
		this.ltcBudgetDirectCareHrsSubttls = ltcBudgetDirectCareHrsSubttls;
	}

	public List<LtcBudgetDirectCareCostSubtotals> getLtcBudgetDirectCareCostSubttls() {
		return ltcBudgetDirectCareCostSubttls;
	}

	public void setLtcBudgetDirectCareCostSubttls(List<LtcBudgetDirectCareCostSubtotals> ltcBudgetDirectCareCostSubttls) {
		this.ltcBudgetDirectCareCostSubttls = ltcBudgetDirectCareCostSubttls;
	}

	public String getSubmissionFy() {
		return submissionFy;
	}

	public void setSubmissionFy(String submissionFy) {
		this.submissionFy = StringUtils.defaultIfEmpty(submissionFy, Constants.DEFAULT_STRING_VALUE);
	}
	public List<LtcBudgetDep> getLtcBudgetDep() {
		return ltcBudgetDep;
	}

	public void setLtcBudgetDep(List<LtcBudgetDep> ltcBudgetDep) {
		this.ltcBudgetDep = ltcBudgetDep;
	}
	public List<LtcBudgetDepSubTotals> getLtcBudgetDepSubTotals() {
		return ltcBudgetDepSubTotals;
	}

	public void setLtcBudgetDepSubTotals(List<LtcBudgetDepSubTotals> ltcBudgetDepSubTotals) {
		this.ltcBudgetDepSubTotals = ltcBudgetDepSubTotals;
	}
	public List<LtcBudgetSumTotals> getLtcBudgetSumTotals() {
		return ltcBudgetSumTotals;
	}

	public void setLtcBudgetSumTotals(List<LtcBudgetSumTotals> ltcBudgetSumTotals) {
		this.ltcBudgetSumTotals = ltcBudgetSumTotals;
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
	public String getTotalSalariesWages() {
		return totalSalariesWages;
	}

	public void setTotalSalariesWages(String totalSalariesWages) {
		this.totalSalariesWages = totalSalariesWages;
	}
	
}
