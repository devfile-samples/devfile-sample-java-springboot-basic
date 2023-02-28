package ca.bc.gov.chefs.etl.forms.testform;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import ca.bc.gov.chefs.etl.parser.IModel;

public class TestModel implements IModel {

	@JsonProperty("confirmationId")
	private String confirmationId;

	@JsonProperty("formName")
	private String formName;

	@JsonProperty("version")
	private String version;

	@JsonProperty("status")
	private String status;

	@JsonProperty("createdAt")
	private String createdAt;

	@JsonProperty("fullName")
	private String fullName;

	@JsonProperty("username")
	private String username;

	@JsonProperty("email")
	private String email;

	@JsonProperty("assignee")
	private String assignee;

	@JsonProperty("assigneeEmail")
	private String assigneeEmail;

	@JsonUnwrapped
	private LoginCredentials loginCredentials;
	@JsonUnwrapped
	private PersonDetails personDetails;

	public LoginCredentials getLoginCredentials() {
		return loginCredentials;
	}

	public void setLoginCredentials(LoginCredentials loginCredentials) {
		this.loginCredentials = loginCredentials;
	}

	public PersonDetails getPersonDetails() {
		return personDetails;
	}

	public void setPersonDetails(PersonDetails personDetails) {
		this.personDetails = personDetails;
	}

	@Override
	public String toString() {
		return "TestModel [loginCredentials=" + loginCredentials + ", personDetails=" + personDetails + "]";
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.confirmationId);
		elements.add(this.formName);
		elements.add(this.version);
		elements.add(this.createdAt);
		elements.add(this.fullName);
		elements.add(this.username);
		elements.add(this.email);
		elements.add(this.status);
		elements.add(this.assignee);
		elements.add(this.assigneeEmail);
		return elements;
	}

	@Override
	public String getFileName() {
		return "testModel";
	}

	@Override
	public String getFormType() {
		return "TestModel#Main";
	}

	@Override
	public List<IModel> getObjects() {
		List<IModel> ls = new ArrayList<>();
		ls.add(loginCredentials);
		ls.add(personDetails);
		return ls;
	}
}
