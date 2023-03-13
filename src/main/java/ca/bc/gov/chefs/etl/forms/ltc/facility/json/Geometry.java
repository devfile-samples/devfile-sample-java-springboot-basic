package ca.bc.gov.chefs.etl.forms.ltc.facility.json;


import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Geometry{
    public Crs crs;
    public String type;
    public ArrayList<Double> coordinates;
    
	public Crs getCrs() {
		return crs;
	}
	public void setCrs(Crs crs) {
		this.crs = crs;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ArrayList<Double> getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(ArrayList<Double> coordinates) {
		this.coordinates = coordinates;
	}
    
    
}
