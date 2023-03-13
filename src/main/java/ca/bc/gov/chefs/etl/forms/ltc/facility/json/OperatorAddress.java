package ca.bc.gov.chefs.etl.forms.ltc.facility.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ca.bc.gov.chefs.etl.parser.IModel;

@JsonIgnoreProperties(ignoreUnknown=true)
public class OperatorAddress implements IModel{
	
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

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getCsvElements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IModel> getObjects() {
		// TODO Auto-generated method stub
		return null;
	}
}
