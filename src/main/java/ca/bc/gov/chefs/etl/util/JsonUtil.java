package ca.bc.gov.chefs.etl.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	  private static final ObjectMapper mapper = new ObjectMapper();

	    public static <T> T parseJsonString(String json, Class<T> clazz) throws Exception {
	        return mapper.readValue(json, clazz);
	    }
}
