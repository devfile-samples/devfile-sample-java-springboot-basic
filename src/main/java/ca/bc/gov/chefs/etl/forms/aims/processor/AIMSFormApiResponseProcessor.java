package ca.bc.gov.chefs.etl.forms.aims.processor;

import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.FileProperties;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.forms.aims.model.MainEntity;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.Counter;
import ca.bc.gov.chefs.etl.util.FileUtil;


public class AIMSFormApiResponseProcessor implements Processor {

	@SuppressWarnings("unchecked")
	@Override
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		System.out.println(payload);
		ObjectMapper mapper = new ObjectMapper();
		Counter.resetCounter(Constants.AIMS_REFERRAL);
		List<MainEntity> aimsModels = mapper.readValue(payload, new TypeReference<List<MainEntity>>() {
		});
		
		List<IModel> iModels =  (List<IModel>)(List<?>) aimsModels;
		
		Map<String,List<List<String>>> map = CSVUtil.provider(iModels);
		boolean isHeaderAdded = (boolean) exchange.getProperties().get(Constants.IS_HEADER_ADDED);
		FileUtil.writeToCSVFile(map,Constants.AIMS_DIR, isHeaderAdded);
	}

}
