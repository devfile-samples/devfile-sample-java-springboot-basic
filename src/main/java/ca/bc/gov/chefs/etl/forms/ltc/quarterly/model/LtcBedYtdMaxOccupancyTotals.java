package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcBedYtdMaxOccupancyTotals implements IModel {

	private String confirmationID;
	private String bedFundingType;
	private String occupancyType;
	private String totalBedQuarter1;
	private String totalBedQuarter2;
	private String totalBedQuarter3;
	private String totalBedQuarter4;
	private String totalBedDays;
	
	public String getConfirmationID() {
		return confirmationID;
	}

	public void setConfirmationID(String confirmationID) {
		this.confirmationID = StringUtils.defaultIfEmpty(confirmationID, Constants.DEFAULT_STRING_VALUE);
	}

	public String getBedFundingType() {
		return bedFundingType;
	}

	public void setBedFundingType(String bedFundingType) {
		this.bedFundingType = StringUtils.defaultIfEmpty(bedFundingType, Constants.DEFAULT_STRING_VALUE);
	}

	public String getTotalBedQuarter1() {
		return totalBedQuarter1;
	}

	public void setTotalBedQuarter1(String totalBedQuarter1) {
		this.totalBedQuarter1 = StringUtils.defaultIfEmpty(totalBedQuarter1, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getTotalBedQuarter2() {
		return totalBedQuarter2;
	}

	public void setTotalBedQuarter2(String totalBedQuarter2) {
		this.totalBedQuarter2 = StringUtils.defaultIfEmpty(totalBedQuarter2, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getTotalBedQuarter3() {
		return totalBedQuarter3;
	}

	public void setTotalBedQuarter3(String totalBedQuarter3) {
		this.totalBedQuarter3 = StringUtils.defaultIfEmpty(totalBedQuarter3, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getTotalBedQuarter4() {
		return totalBedQuarter4;
	}

	public void setTotalBedQuarter4(String totalBedQuarter4) {
		this.totalBedQuarter4 = StringUtils.defaultIfEmpty(totalBedQuarter4, Constants.DEFAULT_DECIMAL_VALUE);
	}

	public String getTotalBedDays() {
		return totalBedDays;
	}

	public void setTotalBedDays(String totalBedDays) {
		this.totalBedDays = totalBedDays;
	}

	public String getOccupancyType() {
		return occupancyType;
	}

	public void setOccupancyType(String occupancyType) {
		this.occupancyType = StringUtils.defaultIfEmpty(occupancyType, Constants.DEFAULT_STRING_VALUE);
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		return Constants.LTC_BED_YTD_MAX_OCCY_TOTALS;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationID());
		elements.add(this.getOccupancyType());
		elements.add(this.getBedFundingType());
		elements.add(this.getTotalBedQuarter1());
		elements.add(this.getTotalBedQuarter2());
		elements.add(this.getTotalBedQuarter3());
		elements.add(this.getTotalBedQuarter4());
		elements.add(this.getTotalBedDays());
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

}
