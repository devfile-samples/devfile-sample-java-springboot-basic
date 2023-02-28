package ca.bc.gov.chefs.etl.forms.ltc.facility.processor;

import java.util.List;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.forms.ltc.facility.model.FacilityInfo;
import ca.bc.gov.chefs.etl.parser.IModel;
import ca.bc.gov.chefs.etl.util.CSVUtil;
import ca.bc.gov.chefs.etl.util.FileUtil;

public class FacilityInfoFormApiResponseProcessor implements Processor {

	@SuppressWarnings("unchecked")
	@Override
	public void process(Exchange exchange) throws Exception {
		String payload = exchange.getIn().getBody(String.class);
		System.out.println(payload);
		ObjectMapper mapper = new ObjectMapper();

		List<FacilityInfo> facilityInformationModels = mapper.readValue(payload,
				new TypeReference<List<FacilityInfo>>() {
				});

		List<IModel> iModels = (List<IModel>) (List<?>) facilityInformationModels;

		Map<String, List<List<String>>> map = CSVUtil.provider(iModels);
		FileUtil.writeToCSVFile(map);
	}
}
