package ca.bc.gov.chefs.etl.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import ca.bc.gov.chefs.etl.constant.Constants;

public class PropertiesUtil {

	public static Properties loadProperties()  {
        Properties configuration = new Properties();
        InputStream inputStream = PropertiesUtil.class
          .getClassLoader()
          .getResourceAsStream("application.properties");
        try {
			configuration.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return configuration;
    }
	
	public static String getValue(String key) {
		Properties properties = loadProperties();
		return properties.getProperty(key);
	}

	public static String buildFormProperty(String property, String healthAuthority, boolean isUsername){
		if(healthAuthority == null || healthAuthority.isEmpty()){
			return isUsername ? property.concat("username") : property.concat("password");
		}
		String result = property.concat(Constants.HA_DICTIONNARY.get(healthAuthority));
		return isUsername ? result.concat(".username") : result.concat(".password");
	}
	
}
