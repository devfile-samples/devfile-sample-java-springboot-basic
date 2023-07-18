package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;

public class LtcYtdDepSubTotals implements IModel {

	private String confirmationId;
	private String subTotalDepYtd;
	private String subTotalDepNotes;
	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = StringUtils.defaultIfEmpty(confirmationId, Constants.DEFAULT_STRING_VALUE);
	}
	public String getSubTotalDepYtd() {
		return subTotalDepYtd;
	}
	public void setSubTotalDepYtd(String subTotalDepYtd) {
		this.subTotalDepYtd = StringUtils.defaultIfEmpty(subTotalDepYtd, Constants.DEFAULT_DECIMAL_VALUE);
	}
	public String getSubTotalDepNotes() {
		return subTotalDepNotes != null ? CSVUtil.replaceLineBreaks(subTotalDepNotes) : subTotalDepNotes;
	}
	public void setSubTotalDepNotes(String subTotalDepNotes) {
		this.subTotalDepNotes = subTotalDepNotes;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_YTD_DEP_SUBTOTALS;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getSubTotalDepYtd());
		elements.add(this.getSubTotalDepNotes());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
}
