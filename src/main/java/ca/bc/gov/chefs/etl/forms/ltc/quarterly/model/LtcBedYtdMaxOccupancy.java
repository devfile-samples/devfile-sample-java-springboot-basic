package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class LtcBedYtdMaxOccupancy implements IModel {

	private String confirmationId;
	private String bedIndex;
	private String quarterInventory;
	private String bedFundingType;
	private String bedSubype;
	private String startDate;
	private String endDate;
	private String numberOfBeds;
	private String maximumBedDays;
	private String notes;
	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
	}
	public String getBedIndex() {
		return bedIndex;
	}
	public void setBedIndex(String bedIndex) {
		this.bedIndex = bedIndex;
	}
	public String getQuarterInventory() {
		return quarterInventory;
	}
	public void setQuarterInventory(String quarterInventory) {
		this.quarterInventory = StringUtils.defaultIfEmpty(quarterInventory, Constants.DEFAULT_STRING_VALUE);
	}
	public String getBedFundingType() {
		return bedFundingType;
	}
	public void setBedFundingType(String bedFundingType) {
		this.bedFundingType = StringUtils.defaultIfEmpty(bedFundingType, Constants.DEFAULT_STRING_VALUE);
	}
	public String getBedSubype() {
		return bedSubype;
	}
	public void setBedSubype(String bedSubype) {
		this.bedSubype = StringUtils.defaultIfEmpty(bedSubype, Constants.DEFAULT_STRING_VALUE);
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = CSVUtil.getFormattedDate(startDate);
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = CSVUtil.getFormattedDate(endDate);
	}
	public String getNumberOfBeds() {
		return numberOfBeds;
	}
	public void setNumberOfBeds(String numberOfBeds) {
		this.numberOfBeds = StringUtils.defaultIfEmpty(numberOfBeds, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getMaximumBedDays() {
		return maximumBedDays;
	}
	public void setMaximumBedDays(String maximumBedDays) {
		this.maximumBedDays = StringUtils.defaultIfEmpty(maximumBedDays, Constants.DEFAULT_DECIMAL_VALUE);
	}
	
	public String getNotes() {
		return notes != null ? CSVUtil.replaceLineBreaks(notes) : notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_BED_YTD_MAX_OCCUPANCY;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.getConfirmationId());
		elements.add(this.getBedIndex());
		elements.add(this.getQuarterInventory());
		elements.add(this.getBedFundingType());
		elements.add(this.getBedSubype());
		elements.add(this.getStartDate());
		elements.add(this.getEndDate());
		elements.add(this.getNumberOfBeds());
		elements.add(this.getMaximumBedDays());
		elements.add(this.getNotes());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}
	
	
	
}
