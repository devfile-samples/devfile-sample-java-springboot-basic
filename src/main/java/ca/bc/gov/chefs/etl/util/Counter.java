package ca.bc.gov.chefs.etl.util;

import java.util.HashMap;
import java.util.Map;

import ca.bc.gov.chefs.etl.constant.Constants;

public class Counter {

	static Map<String,Integer> counter = new HashMap<String,Integer>();
	
	static {
		counter.put(Constants.AIMS_REFERRAL, 0);
	}
	
	public static int getNext(String formName) {
		if(counter.containsKey(formName)) {
		counter.put(formName, counter.get(formName)+1);
		}
		return counter.getOrDefault(formName,0);
	}
	
	public static void resetCounter(String formName) {
		counter.put(formName,0);
	}
}
