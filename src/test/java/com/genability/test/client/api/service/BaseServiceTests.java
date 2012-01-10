package com.genability.test.client.api.service;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class BaseServiceTests {

	protected Logger log = Logger.getLogger(this.getClass());
	
	protected final static String appId = "49c67ab6";
	
	protected final static String appKey = "d31770cad79150b3fd29b18b600dceec";
	

	public BaseServiceTests() {
		BasicConfigurator.configure();
	}
	

	
}
