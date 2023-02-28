package ca.bc.gov.chefs.etl.core.routes;

import java.util.Properties;

import org.apache.camel.builder.RouteBuilder;

import ca.bc.gov.chefs.etl.util.PropertiesUtil;

public abstract class BaseRoute extends RouteBuilder {
	static Properties properties = PropertiesUtil.loadProperties();
	
}
