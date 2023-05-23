package ca.bc.gov.chefs.etl.forms.ltc.quarterly.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;

public class LtcYtdDirectCareVacancy implements IModel {

	private String confirmationId;
	private String directCareVacancyType;
	private String directCareVacancyName;
	private String directCareVacPositions;

	
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}
	public String getDirectCareVacancyType() {
		return directCareVacancyType;
	}
	public void setDirectCareVacancyType(String directCareVacancyType) {
		this.directCareVacancyType = directCareVacancyType;
	}
	public String getDirectCareVacancyName() {
		return directCareVacancyName;
	}
	public void setDirectCareVacancyName(String directCareVacancyName) {
		this.directCareVacancyName = directCareVacancyName;
	}
	public String getDirectCareVacPositions() {
		return directCareVacPositions;
	}
	public void setDirectCareVacPositions(String directCareVacPositions) {
		this.directCareVacPositions = directCareVacPositions;
	}
	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFormType() {
		return Constants.LTC_YTD_DIRECT_CARE_VACANCY;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.getConfirmationId());
		elements.add(this.getDirectCareVacancyType());
		elements.add(this.getDirectCareVacancyName());
		elements.add(this.getDirectCareVacPositions());
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	
	
}
