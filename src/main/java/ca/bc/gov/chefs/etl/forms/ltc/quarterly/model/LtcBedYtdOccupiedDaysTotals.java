package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcBedYtdOccupiedDaysTotals implements IModel {
	private String ConfirmationID;
	private String occQuarter;
	private String occDaysYTDInScopePublic;
	private String occDaysYTDOutScopePublic;
	private String occDaysYTDTotalDays;
	private String occDaysYTDPrivate;
	
	public String getConfirmationID() {
		return ConfirmationID;
	}
	public void setConfirmationID(String confirmationID) {
		ConfirmationID = StringUtils.defaultIfEmpty(confirmationID, Constants.DEFAULT_STRING_VALUE);
	}
	public String getOccQuarter() {
		return occQuarter;
	}
	public void setOccQuarter(String occQuarter) {
		this.occQuarter = StringUtils.defaultIfEmpty(occQuarter, Constants.DEFAULT_STRING_VALUE);
	}
	public String getOccDaysYTDInScopePublic() {
		return occDaysYTDInScopePublic;
	}
	public void setOccDaysYTDInScopePublic(String occDaysYTDInScopePublic) {
		this.occDaysYTDInScopePublic = occDaysYTDInScopePublic;
	}
	public String getOccDaysYTDOutScopePublic() {
		return occDaysYTDOutScopePublic;
	}
	public void setOccDaysYTDOutScopePublic(String occDaysYTDOutScopePublic) {
		this.occDaysYTDOutScopePublic = occDaysYTDOutScopePublic;
	}
	public String getOccDaysYTDTotalDays() {
		return occDaysYTDTotalDays;
	}
	public void setOccDaysYTDTotalDays(String occDaysYTDTotalDays) {
		this.occDaysYTDTotalDays = occDaysYTDTotalDays;
	}
	public String getOccDaysYTDPrivate() {
		return occDaysYTDPrivate;
	}
	public void setOccDaysYTDPrivate(String occDaysYTDPrivate) {
		this.occDaysYTDPrivate = occDaysYTDPrivate;
	}
	
	
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_BED_YTD_OCCUPIED_DAYS_TOT;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationID());
		elements.add(this.getOccQuarter());
		elements.add(this.getOccDaysYTDInScopePublic());
		elements.add(this.getOccDaysYTDOutScopePublic());
		elements.add(this.getOccDaysYTDPrivate());
		elements.add(this.getOccDaysYTDTotalDays());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	

	
}
