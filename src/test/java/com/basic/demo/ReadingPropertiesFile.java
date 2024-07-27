package com.basic.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFile {

	public static void main(String[] args) throws IOException {

		// creating object of properties file
		Properties propertyobj = new Properties();
	
		// location of properties file
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testData\\config.properties");

		// loading the properties file
		
		propertyobj.load(file);
		
		// Reading data from property file
		
		String url = propertyobj.getProperty("appurl");
		String email = propertyobj.getProperty("email");
		String pass = propertyobj.getProperty("password");
		String ordid = propertyobj.getProperty("orderid");
		String cusid = propertyobj.getProperty("customerid");
		
		
		System.out.println(url+" "+email+" "+pass+" "+ordid+" "+cusid);
		
		// Reading all the keys 
		
		Set<String> keys = propertyobj.stringPropertyNames();
		System.out.println(keys);
		
		Set<Object> key = propertyobj.keySet();
		System.out.println(key);
		
		// Readding all the values
		
		Collection<Object> values = propertyobj.values();
		System.out.println(values);
		
		file.close();
	}

}
