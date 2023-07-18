package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class LtcBedYtdOccupancyRate implements IModel {

	private String confirmationID;
	private String occRateQuarter;
	private String occRateBedTypes;
	private String planMaxOccDays;
	private String ytdMaxOccDays;
	private String ytdOccDays;
	private String percentOcc;
	private String occRateNotes;
	
	
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
	public String getOccRateBedTypes() {
		return occRateBedTypes;
	}
	public void setOccRateBedTypes(String occRateBedTypes) {
		this.occRateBedTypes = StringUtils.defaultIfEmpty(occRateBedTypes, Constants.DEFAULT_STRING_VALUE);
	}
	public String getPlanMaxOccDays() {
		return planMaxOccDays;
	}
	public void setPlanMaxOccDays(String planMaxOccDays) {
		this.planMaxOccDays = planMaxOccDays;
	}
	public String getYtdMaxOccDays() {
		return ytdMaxOccDays;
	}
	public void setYtdMaxOccDays(String ytdMaxOccDays) {
		this.ytdMaxOccDays = ytdMaxOccDays;
	}
	public String getYtdOccDays() {
		return ytdOccDays;
	}
	public void setYtdOccDays(String ytdOccDays) {
		this.ytdOccDays = ytdOccDays;
	}
	public String getPercentOcc() {
		return percentOcc;
	}
	public void setPercentOcc(String percentOcc) {
		this.percentOcc = percentOcc;
	}
	public String getOccRateNotes() {
		return occRateNotes != null ? CSVUtil.replaceLineBreaks(occRateNotes) : occRateNotes;
	}
	public void setOccRateNotes(String occRateNotes) {
		this.occRateNotes = occRateNotes;
	}
	
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_BED_YTD_OCCUPANCY_RATE;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationID());
		elements.add(this.getOccRateQuarter());
		elements.add(this.getOccRateBedTypes());
		elements.add(this.getPlanMaxOccDays());
		elements.add(this.getYtdMaxOccDays());
		elements.add(this.getYtdOccDays());
		elements.add(this.getPercentOcc());
		elements.add(this.getOccRateNotes());
		return elements;
	}
	
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

	
}
