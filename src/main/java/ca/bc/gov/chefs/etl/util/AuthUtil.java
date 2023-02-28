package ca.bc.gov.chefs.etl.util;

import java.util.Base64;
import java.util.Base64.Encoder;

public class AuthUtil {

	static Encoder encoder = Base64.getEncoder();
	
	public static String getBasicAuth(String username,String password) {
		return "Basic "+ encoder.encodeToString((username+":"+password).getBytes());
	}
}
