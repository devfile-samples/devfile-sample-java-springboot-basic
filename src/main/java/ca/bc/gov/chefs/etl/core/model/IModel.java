package ca.bc.gov.chefs.etl.core.model;

import java.util.List;

public interface IModel {
	String getFileName();
	String getFormType();
	List<String> getCsvElements();
	List<IModel> getObjects();
}
