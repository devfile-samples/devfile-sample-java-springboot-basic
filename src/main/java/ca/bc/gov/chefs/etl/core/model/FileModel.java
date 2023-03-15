package ca.bc.gov.chefs.etl.core.model;

public class FileModel {

	public String from;
	public String to;
	public String pgpPublicKeyPath;
	
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getPgpPublicKeyPath() {
		return pgpPublicKeyPath;
	}
	public void setPgpPublicKeyPath(String pgpPublicKeyPath) {
		this.pgpPublicKeyPath = pgpPublicKeyPath;
	}
	
	
}
