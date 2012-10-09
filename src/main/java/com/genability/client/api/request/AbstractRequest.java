package com.genability.client.api.request;

import java.math.BigDecimal;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public abstract class AbstractRequest {
	
	protected abstract List<NameValuePair> getQueryParams();
	
	public static final String ISO_8601_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZZ";
	
	public static final String ISO_8601_SHORT_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm";

	public static final String ISO_8601_SHORT_DATE_FORMAT = "yyyy-MM-dd";
	
	protected void addParam(List<NameValuePair> qparams, String paramName, Long paramValue) {
		
		if(paramValue != null) 
			qparams.add(new BasicNameValuePair(paramName, paramValue.toString()));

	} // end of addParam for Long

	protected void addParam(List<NameValuePair> qparams, String paramName, Integer paramValue) {
		
		if(paramValue != null) 
			qparams.add(new BasicNameValuePair(paramName, paramValue.toString()));

	} // end of addParam for Integer

	protected void addParam(List<NameValuePair> qparams, String paramName, String paramValue) {
		
		if(paramValue != null) {
			
			qparams.add(new BasicNameValuePair(paramName, paramValue));
			
		}

	} // end of addParam for String

	protected void addParam(List<NameValuePair> qparams, String paramName, BigDecimal paramValue) {
		
		if(paramValue != null) {
			
			qparams.add(new BasicNameValuePair(paramName, paramValue.toPlainString()));
			
		}

	} // end of addParam for BigDecimal
	
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

	protected void addParam(List<NameValuePair> qparams, String paramName, DateTime paramValue, String format) {
		
		if(paramValue != null) {

			qparams.add(new BasicNameValuePair(paramName, paramValue
					.toString(DateTimeFormat.forPattern(ISO_8601_SHORT_DATE_FORMAT))));
			
		}

	} // end of addParam for DateTime
	
	protected void addParam(List<NameValuePair> qparams, String paramName, Boolean paramValue) {
		
		if(paramValue != null) {
			
			qparams.add(new BasicNameValuePair(paramName, 
					(Boolean.FALSE.equals(paramValue) ? "false" : "true")));
			
		}

	} // end of addParam for Boolean
	
}
