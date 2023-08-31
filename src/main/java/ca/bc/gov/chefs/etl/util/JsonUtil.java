package ca.bc.gov.chefs.etl.util;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.chefs.etl.constant.Constants;

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

    public String ltcYTDBackwardCompatibility(String payload){
        for (Map.Entry<String, String> entry : Constants.LTC_YTD_OLD_KEYS_COMPATIBILITY.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            payload = payload.replace(key, value);
        }
        return payload;
    }

	public static String roundDigitsNumber(String payload){

        // Regular expression pattern to match numbers with 11 decimal places
        String pattern = "\\b\\d+\\.\\d{3,}\\b";
        
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(payload);

        // Iterate over matches and replace with numbers with 2 decimal places
        StringBuffer output = new StringBuffer();
        while (matcher.find()) {
            String matchedNumber = matcher.group();
            double roundedNumber = Math.round(Double.parseDouble(matchedNumber) * 100.0) / 100.0;
            String roundedString = String.format("%.2f", roundedNumber);
            matcher.appendReplacement(output, roundedString);
        }
        matcher.appendTail(output);

		return output.toString();
	}
}
