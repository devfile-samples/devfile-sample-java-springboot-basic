package ca.bc.gov.chefs.etl.forms.testform;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ca.bc.gov.chefs.etl.parser.IModel;

public class PersonDetails implements IModel {

	@JsonProperty("firstName")
	private String firstname;
	@JsonProperty("lastName")
	private String lastname;
	@JsonProperty("birthPlace")
	private String birthPlace;
	@JsonProperty("education")
	private String education;
	@JsonProperty("confirmationId")
	private String confirmationId;

	public String getConfirmationId() {
		return confirmationId;
	}

	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}

	public String getFirstname() {
		return firstname;
	}

	@Override
	public String toString() {
		return "PersonDetails [firstname=" + firstname + ", lastname=" + lastname + ", birthPlace=" + birthPlace
				+ ", education=" + education + "]";
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	public String getFileName() {
		return "person-details.csv";
	}

	@Override
	public String getFormType() {
		return "TestModel#PersonDetails";
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.firstname);
		elements.add(this.lastname);
		elements.add(this.birthPlace);
		elements.add(this.education);
		elements.add(this.confirmationId);
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

}
