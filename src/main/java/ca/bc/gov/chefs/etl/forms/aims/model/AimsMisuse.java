package ca.bc.gov.chefs.etl.forms.aims.model;

import java.util.ArrayList;
import java.util.List;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.Counter;

public class AimsMisuse implements IModel {

	private String confirmationId;
	private String substanceMisuse;
	
	public String getConfirmationId() {
		return confirmationId.concat(String.valueOf(Counter.getNext(getFormType())));
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}
	public String getSubstanceMisuse() {
		return substanceMisuse;
	}
	public void setSubstanceMisuse(String substanceMisuse) {
		this.substanceMisuse = substanceMisuse;
	}
	
	@Override
	public String getFileName() {
		return "AIMS_MISUSE";
	}
	@Override
	public String getFormType() {
		return Constants.AIMS_MISUSE;
	}
	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<String>();
		elements.add(this.confirmationId);
		elements.add(this.substanceMisuse);
		return elements;
	}
	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}
	@Override
	public String toString() {
		return "AimsMisuse [confirmationId=" + confirmationId + ", substanceMisuse=" + substanceMisuse + "]";
	}
	
	
	
	
}
