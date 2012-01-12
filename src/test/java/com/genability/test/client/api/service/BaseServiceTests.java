package com.genability.test.client.api.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class BaseServiceTests {

	protected Logger log = Logger.getLogger(this.getClass());
	
	protected static String appId = null;
	
	protected static String appKey = null;
	

	static {
		//
		// Very simple configuration of logging to console.
		//
		BasicConfigurator.configure();
		Logger logger = Logger.getLogger(BaseServiceTests.class);
		
		//
		// Very simple configuration of API keys etc.
		//
		Properties prop = new Properties();
		 
    	try {
    		
    		//
    		//load the properties file from in the classpath
    		//
    		InputStream inputStream = BaseServiceTests.class.getClassLoader().getResourceAsStream("genability.properties");
    		prop.load(inputStream);
 
    		//
            // get the properties and print them out
    		//
    		appId = prop.getProperty("appId");
    		appKey = prop.getProperty("appKey");
    		logger.info("appId:" + appId);
    		logger.info("appKey:" + appKey);
 
    	} catch (IOException ex) {
    		logger.error("Unable to process genability.properties", ex);
        }
	}
	

	
}
