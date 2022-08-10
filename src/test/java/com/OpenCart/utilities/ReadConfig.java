package com.OpenCart.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.AccessException;
import java.util.Properties;

public class ReadConfig {

	Properties properties;

	public ReadConfig(){
		try {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/Configuration/config.properties");
		properties = new Properties();
		properties.load(fis);
		}
		catch(Exception e) {
			
		}
	}

	public String baseURL() {
		String url = properties.getProperty("baseURL");
		return url;
	}

	public String browser() {
		String browserName = properties.getProperty("browser");
		return browserName;
	}

}
