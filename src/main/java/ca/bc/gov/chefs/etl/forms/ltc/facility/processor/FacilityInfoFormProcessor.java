package ca.bc.gov.chefs.etl.forms.ltc.facility.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FacilityInfoFormProcessor implements Processor {
	private static final Logger logger = LoggerFactory.getLogger(FacilityInfoFormProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		logger.info("Hello! Processing Now: current timestamp is: {}", System.currentTimeMillis());
		logger.info("Body Received: {}", exchange.getIn().getBody());

	}
}
