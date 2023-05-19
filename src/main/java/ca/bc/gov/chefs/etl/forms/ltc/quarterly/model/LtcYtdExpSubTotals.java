package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcYtdExpSubTotals implements IModel {

	private String confirmationId;
	private String expType;
	private String subTotalExpYtd;
	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
	}
	public String getExpType() {
		return expType;
	}
	public void setExpType(String expType) {
		this.expType = StringUtils.defaultIfEmpty(expType, Constants.DEFAULT_STRING_VALUE);
	}
	public String getSubTotalExpYtd() {
		return subTotalExpYtd;
	}
	public void setSubTotalExpYtd(String subTotalExpYtd) {
		this.subTotalExpYtd = subTotalExpYtd;
	}
	
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_YTD_EXP_SUB_TOTALS;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.getConfirmationId());
		elements.add(this.getExpType());
		elements.add(this.getSubTotalExpYtd());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
	
}
