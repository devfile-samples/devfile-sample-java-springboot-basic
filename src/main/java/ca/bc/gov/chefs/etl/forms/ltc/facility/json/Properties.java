package ca.bc.gov.chefs.etl.forms.ltc.facility.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ca.bc.gov.chefs.etl.core.model.IModel;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Properties implements IModel{
    public int code;
    public int score;
    public ArrayList<Fault> faults;
    public String siteID;
    public String blockID;
    public String siteStatus;
    public String accessNotes;
    public String fullAddress;
    public String localityType;
    public String electoralArea;
    public String matchPrecision;
    public int precisionPoints;
    public String locationDescriptor;
    public String locationPositionalAccuracy;
   
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public ArrayList<Fault> getFaults() {
		return faults;
	}
	public void setFaults(ArrayList<Fault> faults) {
		this.faults = faults;
	}
	public String getSiteID() {
		return siteID;
	}
	public void setSiteID(String siteID) {
		this.siteID = siteID;
	}
	public String getBlockID() {
		return blockID;
	}
	public void setBlockID(String blockID) {
		this.blockID = blockID;
	}
	public String getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	public String getAccessNotes() {
		return accessNotes;
	}
	public void setAccessNotes(String accessNotes) {
		this.accessNotes = accessNotes;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	public String getLocalityType() {
		return localityType;
	}
	public void setLocalityType(String localityType) {
		this.localityType = localityType;
	}
	public String getElectoralArea() {
		return electoralArea;
	}
	public void setElectoralArea(String electoralArea) {
		this.electoralArea = electoralArea;
	}
	public String getMatchPrecision() {
		return matchPrecision;
	}
	public void setMatchPrecision(String matchPrecision) {
		this.matchPrecision = matchPrecision;
	}
	public int getPrecisionPoints() {
		return precisionPoints;
	}
	public void setPrecisionPoints(int precisionPoints) {
		this.precisionPoints = precisionPoints;
	}
	public String getLocationDescriptor() {
		return locationDescriptor;
	}
	public void setLocationDescriptor(String locationDescriptor) {
		this.locationDescriptor = locationDescriptor;
	}
	public String getLocationPositionalAccuracy() {
		return locationPositionalAccuracy;
	}
	public void setLocationPositionalAccuracy(String locationPositionalAccuracy) {
		this.locationPositionalAccuracy = locationPositionalAccuracy;
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