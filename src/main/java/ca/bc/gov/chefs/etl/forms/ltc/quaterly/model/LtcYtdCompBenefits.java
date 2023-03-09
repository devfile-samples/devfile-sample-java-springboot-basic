package ca.bc.gov.chefs.etl.forms.ltc.quaterly.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.parser.IModel;

public class LtcYtdCompBenefits implements IModel {

	private String confirmationId;
	private String benefitsType;
	private String benefitsAmountYtd;
	private String benefitsPercentageAlloc;
	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}
	public String getBenefitsType() {
		return benefitsType;
	}
	public void setBenefitsType(String benefitsType) {
		this.benefitsType = benefitsType;
	}
	public String getBenefitsAmountYtd() {
		return benefitsAmountYtd.isBlank() ? "0" : benefitsAmountYtd;
	}
	public void setBenefitsAmountYtd(String benefitsAmountYtd) {
		this.benefitsAmountYtd = benefitsAmountYtd;
	}
	
	
	
	public String getBenefitsPercentageAlloc() {
		return benefitsPercentageAlloc.isBlank() ? "0" : benefitsPercentageAlloc;
	}
	public void setBenefitsPercentageAlloc(String benefitsPercentageAlloc) {
		this.benefitsPercentageAlloc = benefitsPercentageAlloc;
	}
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_YTD_COMP_BENEFITS;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.getConfirmationId());
		elements.add(this.getBenefitsType());
		elements.add(this.getBenefitsAmountYtd());
		elements.add(this.getBenefitsPercentageAlloc());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
	
}
