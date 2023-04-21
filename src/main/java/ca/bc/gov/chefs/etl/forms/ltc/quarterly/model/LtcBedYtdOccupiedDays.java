package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcBedYtdOccupiedDays implements IModel{

	private String confirmationId;
	private String occQuarter;
	private String occMonth;
	private String occDaysYTDInScopePublic;
	private String occDaysYTOutScopePublic;
	private String occDaysYtdTotalDays;
	private String occDaysYTDPrivate;
	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}
	public String getOccQuarter() {
		return occQuarter;
	}
	public void setOccQuarter(String occQuarter) {
		this.occQuarter = occQuarter;
	}
	public String getOccMonth() {
		return occMonth;
	}
	public void setOccMonth(String occMonth) {
		this.occMonth = occMonth;
	}
	public String getOccDaysYTDInScopePublic() {
		return occDaysYTDInScopePublic;
	}
	public void setOccDaysYTDInScopePublic(String occDaysYTDInScopePublic) {
		this.occDaysYTDInScopePublic = occDaysYTDInScopePublic;
	}
	public String getOccDaysYTOutScopePublic() {
		return occDaysYTOutScopePublic;
	}
	public void setOccDaysYTOutScopePublic(String occDaysYTOutScopePublic) {
		this.occDaysYTOutScopePublic = occDaysYTOutScopePublic;
	}
	public String getOccDaysYTDPrivate() {
		return occDaysYTDPrivate;
	}
	public void setOccDaysYTDPrivate(String occDaysYTDPrivate) {
		this.occDaysYTDPrivate = occDaysYTDPrivate;
	}
	
	public String getOccDaysYtdTotalDays() {
		return occDaysYtdTotalDays;
	}
	public void setOccDaysYtdTotalDays(String occDaysYtdTotalDays) {
		this.occDaysYtdTotalDays = occDaysYtdTotalDays;
	}
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_BED_YTD_OCCUPIED_DAYS;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.getConfirmationId());
		elements.add(this.getOccQuarter());
		elements.add(this.getOccMonth());
		elements.add(this.getOccDaysYTDInScopePublic());
		elements.add(this.getOccDaysYTOutScopePublic());
		elements.add(this.getOccDaysYTDPrivate());
		elements.add(this.getOccDaysYtdTotalDays());
		return elements; 
	}
	@Override
	public List<IModel> getObjects() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	
}
