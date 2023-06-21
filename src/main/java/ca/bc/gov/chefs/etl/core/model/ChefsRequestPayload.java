package ca.bc.gov.chefs.etl.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChefsRequestPayload {

	private String version;
	private String startDate;
	private String endDate;
	private String healthAuthority;
	private boolean isHeaderAdded = true;

	public boolean isHeaderAdded() {
		return isHeaderAdded;
	}

	@JsonProperty("isHeaderAdded")
	public void setHeaderAdded(boolean isHeaderAdded) {
		this.isHeaderAdded = Boolean.valueOf(isHeaderAdded);
	}
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getHealthAuthority() {
		return healthAuthority;
	}
	public void setHealthAuthority(String healthAuthority) {
		this.healthAuthority = healthAuthority;
	}
	
}
