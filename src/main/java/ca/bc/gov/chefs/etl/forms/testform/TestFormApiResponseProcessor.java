package ca.bc.gov.chefs.etl.forms.testform;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.parser.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;



public class TestFormApiResponseProcessor implements Processor {

	/*
	 * receives a JSON Array of objects, models them and makes them ready
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void process(Exchange exchange) throws Exception {

		String payload = exchange.getIn().getBody(String.class);
		System.out.println(payload);
		ObjectMapper mapper = new ObjectMapper();
		
		List<TestModel> testModels = mapper.readValue(payload, new TypeReference<List<TestModel>>() {
		});
		List<IModel> testIModel =  (List<IModel>)(List<?>) testModels;
		CSVUtil.provider(testIModel);
	}

}
