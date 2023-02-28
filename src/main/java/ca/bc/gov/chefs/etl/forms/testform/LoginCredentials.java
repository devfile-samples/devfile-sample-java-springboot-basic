package ca.bc.gov.chefs.etl.forms.testform;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ca.bc.gov.chefs.etl.parser.IModel;

public class LoginCredentials implements IModel {

	@Override
	public String toString() {
		return "LoginCredentials [username=" + username + ", password=" + password + "]";
	}

	@JsonProperty("username1")
	private String username;
	
	@JsonProperty("password")
	private String password;

	public String getConfirmationId() {
		return confirmationId;
	}

	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}

	@JsonProperty("confirmationId")
	private String confirmationId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getFileName() {
		return "sample-today.csv";
	}

	@Override
	public  String getFormType() {
		return "TestModel#LoginCredentials";
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.username);
		elements.add(this.password);
		elements.add(this.confirmationId);
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

}
