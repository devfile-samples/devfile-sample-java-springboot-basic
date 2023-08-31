package ca.bc.gov.chefs.etl.core.routes;

import java.util.HashMap;

import java.util.Map;
import java.util.Properties;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.core.model.ErrorResponse;
import ca.bc.gov.chefs.etl.util.PropertiesUtil;

public abstract class BaseRoute extends RouteBuilder {
	static Properties properties = PropertiesUtil.loadProperties();
	private static final Logger logger = LoggerFactory.getLogger(BaseRoute.class);
	
	@Override
	public void configure() throws Exception {
		onException(Exception.class)
		.handled(true)
		.process(new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {
				logger.error("Error in the process");
				ObjectMapper mapper = new ObjectMapper();
				Exception exception = (Exception) exchange.getProperty(Exchange.EXCEPTION_CAUGHT);
				ErrorResponse errorResponse = new ErrorResponse();
				errorResponse.setMessage(exception.getLocalizedMessage());
				errorResponse.setStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
				errorResponse.setType("Error");
				
				exchange.getIn().setBody(mapper.writeValueAsString(errorResponse));
			}
			
		})
		.setHeader("Content-Type",constant("application/json"))
		.end();
	}
}
