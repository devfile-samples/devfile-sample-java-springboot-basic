package ca.bc.gov.chefs.etl.forms.ltc.quaterly.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.parser.IModel;

public class LtcYtdDirectCareHrsSubTotals implements IModel{

	private String confirmationID;
	private String dirCareType;
	private String subTotalDirCareProdHrsRegularYTD;
	private String subTotalDirCareProdHrsOTYTD;
	private String subTotalDirCareProdHrsSubtotalYTD;
	private String subTotalDirCareProdHrsContServYTD;
	private String subTotalDirCareProdHrsTotalYTD;
	private String subTotalDirCareNonProdHrsVacYTD;
	private String subTotalDirCareNonProdHrsSickYTD;
	private String subTotalDirCareNonProdHrsOtherServYTD;
	private String subTotalDirCareNonProdHrsTotalYTD;
	private String subTotalDirCareTotalHrsPaidYTD;

	
	public String getConfirmationID() {
		return confirmationID;
	}

	public void setConfirmationID(String confirmationID) {
		this.confirmationID = confirmationID;
	}

	public String getDirCareType() {
		return dirCareType;
	}

	public void setDirCareType(String dirCareType) {
		this.dirCareType = dirCareType;
	}

	public String getSubTotalDirCareProdHrsRegularYTD() {
		return subTotalDirCareProdHrsRegularYTD;
	}

	public void setSubTotalDirCareProdHrsRegularYTD(String subTotalDirCareProdHrsRegularYTD) {
		this.subTotalDirCareProdHrsRegularYTD = subTotalDirCareProdHrsRegularYTD;
	}

	public String getSubTotalDirCareProdHrsOTYTD() {
		return subTotalDirCareProdHrsOTYTD;
	}

	public void setSubTotalDirCareProdHrsOTYTD(String subTotalDirCareProdHrsOTYTD) {
		this.subTotalDirCareProdHrsOTYTD = subTotalDirCareProdHrsOTYTD;
	}

	public String getSubTotalDirCareProdHrsSubtotalYTD() {
		return subTotalDirCareProdHrsSubtotalYTD;
	}

	public void setSubTotalDirCareProdHrsSubtotalYTD(String subTotalDirCareProdHrsSubtotalYTD) {
		this.subTotalDirCareProdHrsSubtotalYTD = subTotalDirCareProdHrsSubtotalYTD;
	}

	public String getSubTotalDirCareProdHrsContServYTD() {
		return subTotalDirCareProdHrsContServYTD;
	}

	public void setSubTotalDirCareProdHrsContServYTD(String subTotalDirCareProdHrsContServYTD) {
		this.subTotalDirCareProdHrsContServYTD = subTotalDirCareProdHrsContServYTD;
	}

	public String getSubTotalDirCareProdHrsTotalYTD() {
		return subTotalDirCareProdHrsTotalYTD;
	}

	public void setSubTotalDirCareProdHrsTotalYTD(String subTotalDirCareProdHrsTotalYTD) {
		this.subTotalDirCareProdHrsTotalYTD = subTotalDirCareProdHrsTotalYTD;
	}

	public String getSubTotalDirCareNonProdHrsVacYTD() {
		return subTotalDirCareNonProdHrsVacYTD;
	}

	public void setSubTotalDirCareNonProdHrsVacYTD(String subTotalDirCareNonProdHrsVacYTD) {
		this.subTotalDirCareNonProdHrsVacYTD = subTotalDirCareNonProdHrsVacYTD;
	}

	public String getSubTotalDirCareNonProdHrsSickYTD() {
		return subTotalDirCareNonProdHrsSickYTD;
	}

	public void setSubTotalDirCareNonProdHrsSickYTD(String subTotalDirCareNonProdHrsSickYTD) {
		this.subTotalDirCareNonProdHrsSickYTD = subTotalDirCareNonProdHrsSickYTD;
	}

	public String getSubTotalDirCareNonProdHrsOtherServYTD() {
		return subTotalDirCareNonProdHrsOtherServYTD;
	}

	public void setSubTotalDirCareNonProdHrsOtherServYTD(String subTotalDirCareNonProdHrsOtherServYTD) {
		this.subTotalDirCareNonProdHrsOtherServYTD = subTotalDirCareNonProdHrsOtherServYTD;
	}

	public String getSubTotalDirCareNonProdHrsTotalYTD() {
		return subTotalDirCareNonProdHrsTotalYTD;
	}

	public void setSubTotalDirCareNonProdHrsTotalYTD(String subTotalDirCareNonProdHrsTotalYTD) {
		this.subTotalDirCareNonProdHrsTotalYTD = subTotalDirCareNonProdHrsTotalYTD;
	}

	public String getSubTotalDirCareTotalHrsPaidYTD() {
		return subTotalDirCareTotalHrsPaidYTD;
	}

	public void setSubTotalDirCareTotalHrsPaidYTD(String subTotalDirCareTotalHrsPaidYTD) {
		this.subTotalDirCareTotalHrsPaidYTD = subTotalDirCareTotalHrsPaidYTD;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_YTD_DIRECT_CARE_HRS_SUB_TOTALS;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationID());
		elements.add(this.getDirCareType());
		elements.add(this.getSubTotalDirCareProdHrsRegularYTD());
		elements.add(this.getSubTotalDirCareProdHrsOTYTD());
		elements.add(this.getSubTotalDirCareProdHrsSubtotalYTD());
		elements.add(this.getSubTotalDirCareProdHrsContServYTD());
		elements.add(this.getSubTotalDirCareProdHrsTotalYTD());
		elements.add(this.getSubTotalDirCareNonProdHrsVacYTD());
		elements.add(this.getSubTotalDirCareNonProdHrsSickYTD());
		elements.add(this.getSubTotalDirCareNonProdHrsTotalYTD());
		elements.add(this.getSubTotalDirCareTotalHrsPaidYTD());
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

	
}
