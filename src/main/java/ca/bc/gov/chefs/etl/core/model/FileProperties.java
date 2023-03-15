package ca.bc.gov.chefs.etl.core.model;


public class FileProperties {

	private String unEncDirForThisExchange;
	private String encDirForThisExchange;
	private String extension = ".txt";

	public String getUnEncDirForThisExchange() {
		return unEncDirForThisExchange;
	}

	public void setUnEncDirForThisExchange(String unEncDirForThisExchange) {
		this.unEncDirForThisExchange = unEncDirForThisExchange;
	}

	public String getEncDirForThisExchange() {
		return encDirForThisExchange;
	}

	public void setEncDirForThisExchange(String encDirForThisExchange) {
		this.encDirForThisExchange = encDirForThisExchange;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	
	

}
