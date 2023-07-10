package ca.bc.gov.chefs.etl.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private static final ObjectMapper mapper = new ObjectMapper();

	public static <T> T parseJsonString(String json, Class<T> clazz) throws Exception {
        return mapper.readValue(json, clazz);
    }
	
	public static String preProcess(String payload){
		// The following code aims to replace occurences of "subTypeX":"" with "subTypeX":{}, as "subTypeX" is expected to be
		// an object (can be empty) and not a String. 
		String result = payload.replaceAll("\"(subType\\d*)\":\"\"", "\"$1\":{}");
		return result;
	}
}
