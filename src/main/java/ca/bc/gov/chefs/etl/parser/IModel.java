package ca.bc.gov.chefs.etl.parser;

import java.util.List;

public interface IModel {
	String getFileName();
	String getFormType();
	List<String> getCsvElements();
	List<IModel> getObjects();
}
