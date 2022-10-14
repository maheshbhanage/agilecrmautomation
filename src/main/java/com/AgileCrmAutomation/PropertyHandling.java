package com.AgileCrmAutomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandling {

	private Properties properties;
	
	public PropertyHandling() {
	//conf file path
		String configfilepath=System.getProperty("user.dir")+"//config.properties";
		try {
			FileInputStream input=new FileInputStream(configfilepath);
			properties=new Properties();
			properties.load(input);
					}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public String getvalue(String key) {
		return properties.getProperty(key);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
