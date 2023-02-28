package ca.bc.gov.chefs.etl.core.routes;

import org.apache.camel.Exchange;

public class HelloRoute extends BaseRoute{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("jetty:http://{{hostname}}:{{port}}/hello").routeId("hello")
		.log("CHEFS-ETL received a request for health check")
		.setHeader(Exchange.HTTP_RESPONSE_CODE,constant(200))
		.setBody(constant("HTTP 200 OK"))
		.end();

	}

}
