package com.genability.client.api.request;

import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.joda.time.DateTime;

public abstract class AbstractRequest {
	
	protected abstract List<NameValuePair> getQueryParams();
	
	
	protected void addParam(List<NameValuePair> qparams, String paramName, Long paramValue) {
		
		if(paramValue != null) 
			qparams.add(new BasicNameValuePair(paramName, paramValue.toString()));

	} // end of addParam for Long


	protected void addParam(List<NameValuePair> qparams, String paramName, String paramValue) {
		
		if(paramValue != null) {
			
			qparams.add(new BasicNameValuePair(paramName, paramValue));
			
		}

	} // end of addParam for String
	
	protected void addParam(List<NameValuePair> qparams, String paramName, String[] paramValues) {
		
		if(paramValues != null) {
			
			for(String paramValue : paramValues)
			    qparams.add(new BasicNameValuePair(paramName, paramValue));
			
		}

	} // end of addParam for String[]


	protected void addParam(List<NameValuePair> qparams, String paramName, DateTime paramValue) {
		
		if(paramValue != null) {
			
			//TODO - update this with correct formatting
			qparams.add(new BasicNameValuePair(paramName, paramValue.toString()));
			
		}

	} // end of addParam for DateTime
	
	protected void addParam(List<NameValuePair> qparams, String paramName, Boolean paramValue) {
		
		if(paramValue != null) {
			
			qparams.add(new BasicNameValuePair(paramName, 
					(Boolean.FALSE.equals(paramValue) ? "false" : "true")));
			
		}

	} // end of addParam for Boolean
	
}
