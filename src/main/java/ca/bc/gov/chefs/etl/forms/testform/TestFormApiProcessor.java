package ca.bc.gov.chefs.etl.forms.testform;

import org.apache.camel.Exchange;

import org.apache.camel.Processor;
import net.minidev.json.JSONObject;

public class TestFormApiProcessor implements Processor {

	//private static final Logger logger = LoggerFactory.getLogger(TestFormRoute.class);
	
	@Override
	public void process(Exchange exchange) throws Exception {

		JSONObject body = (JSONObject) exchange.getIn().getBody();
		String usernamePassword = body.getAsString("username") + ":" + body.getAsString("password");
		System.out.println(usernamePassword);
		exchange.getIn().setHeader("CamelHttpMethod", "GET");
		exchange.getIn().setHeader("Content-Type", "application/json");
		exchange.getIn().setHeader("accept", "application/json");
		exchange.getIn().setHeader("Authorization", "Basic MDc2MjNkMzMtOWY0OS00MjVhLWI3ZDItZDg0OWIzZTBhZjVjOjYzNTcxNzVlLTE4NzctNDU4Ny05MDVkLWE2MjJkNjMzZGQ0Mg==");		

	}

}
