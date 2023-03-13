package ca.bc.gov.chefs.etl.forms.ltc.facility.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Bcaddress{
    public String type;
    public Geometry geometry;
    public Properties properties;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Geometry getGeometry() {
		return geometry;
	}
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
    
    
}

