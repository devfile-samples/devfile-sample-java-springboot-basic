package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcBedYtdOccupancyRateTotals implements IModel {

	private String confirmationID;
	private String occRateQuarter;
	private String totalPlanMaxOccDays;
	private String totalYTDMaxOccDays;
	private String totalYTDOccDays;
	private String totalPercentOcc;
	
	public String getConfirmationID() {
		return confirmationID;
	}

	public void setConfirmationID(String confirmationID) {
		this.confirmationID = StringUtils.defaultIfEmpty(confirmationID, Constants.DEFAULT_STRING_VALUE);
	}

	public String getOccRateQuarter() {
		return occRateQuarter;
	}

	public void setOccRateQuarter(String occRateQuarter) {
		this.occRateQuarter = StringUtils.defaultIfEmpty(occRateQuarter, Constants.DEFAULT_STRING_VALUE);
	}

	public String getTotalPlanMaxOccDays() {
		return totalPlanMaxOccDays;
	}

	public void setTotalPlanMaxOccDays(String totalPlanMaxOccDays) {
		this.totalPlanMaxOccDays = totalPlanMaxOccDays;
	}

	public String getTotalYTDMaxOccDays() {
		return totalYTDMaxOccDays;
	}

	public void setTotalYTDMaxOccDays(String totalYTDMaxOccDays) {
		this.totalYTDMaxOccDays = totalYTDMaxOccDays;
	}

	public String getTotalYTDOccDays() {
		return totalYTDOccDays;
	}

	public void setTotalYTDOccDays(String totalYTDOccDays) {
		this.totalYTDOccDays = totalYTDOccDays;
	}

	public String getTotalPercentOcc() {
		return totalPercentOcc;
	}

	public void setTotalPercentOcc(String totalPercentOcc) {
		this.totalPercentOcc = totalPercentOcc;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_BED_YTD_OCCUPANCY_RATE_TOT;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationID());
		elements.add(this.getOccRateQuarter());
		elements.add(this.getTotalPlanMaxOccDays());
		elements.add(this.getTotalYTDMaxOccDays());
		elements.add(this.getTotalYTDOccDays());
		elements.add(this.getTotalPercentOcc());
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

}
