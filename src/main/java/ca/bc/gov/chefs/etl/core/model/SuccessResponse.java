package ca.bc.gov.chefs.etl.core.model;

import java.util.List;

import org.apache.http.HttpStatus;

public class SuccessResponse {
	
	private String type = "success";
	private Integer statusCode = HttpStatus.SC_OK;
	private List<String> files;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		if(files.isEmpty()) {
			return "Empty response from CHEFS, Hence not generating any files";
		}
		return "Files Generated";
	}
	public void setMessage(String message) {
	}
	public List<String> getFiles() {
		return files;
	}
	public void setFiles(List<String> files) {
		this.files = files;
	}
	
	
}
