package ca.bc.gov.chefs.etl.forms.ltc.budget.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.chefs.etl.core.routes.BaseRoute;
import ca.bc.gov.chefs.etl.forms.aims.route.AIMSFormRoute;
import ca.bc.gov.chefs.etl.forms.ltc.budget.processor.LtcAnnualBudgetApiProcessor;
import ca.bc.gov.chefs.etl.forms.ltc.budget.processor.LtcAnnualBudgetApiResponseProcessor;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.processor.LtcQuarterlyYtdApiProcessor;
import ca.bc.gov.chefs.etl.forms.ltc.quarterly.processor.LtcQuarterlyYtdApiResponseProcessor;

public class LtcAnnualBudgetRoute extends BaseRoute {

	private static final Logger logger = LoggerFactory.getLogger(AIMSFormRoute.class);
	@Override
	public void configure() throws Exception {
		super.configure();
		logger.info("Loaded LTC Annual Budget Form Route");

		/**
		 * receive JSON payload, parse and set to make an API call
		 * 
		 * 
		 */
		// trigger
		from("jetty:http://{{hostname}}:{{port}}/ltc-annual-budget").routeId("ltc-annual-budget-form")
				.log("CHEFS-ETL received a request for LTCQ Form extraction")
				.to("direct:ltc-annual-budget").end();

		from("direct:ltc-annual-budget")
				// to the http uri
				.process(new LtcAnnualBudgetApiProcessor())
				.toD("${header.RequestUri}")
				.log("This is the status code from the response: ${header.CamelHttpResponseCode}")
				.log("Trying to convert the received body OK").convertBodyTo(String.class)
				.process(new LtcAnnualBudgetApiResponseProcessor()).end();
	}

}
