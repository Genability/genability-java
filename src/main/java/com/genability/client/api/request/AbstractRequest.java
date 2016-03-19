package com.genability.client.api.request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.genability.client.types.Fields;
import com.genability.client.util.EnumUtil;

public abstract class AbstractRequest {
	
	public static final String ISO_8601_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZZ";
	public static final DateTimeFormatter ISO_8601_DATE_TIME_FORMATTER = DateTimeFormat.forPattern(ISO_8601_DATE_TIME_FORMAT);
	
	public static final String ISO_8601_SHORT_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm";
	public static final DateTimeFormatter ISO_8601_SHORT_DATE_TIME_FORMATTER = DateTimeFormat.forPattern(ISO_8601_SHORT_DATE_TIME_FORMAT);

	public static final String ISO_8601_SHORT_DATE_FORMAT = "yyyy-MM-dd";
	public static final DateTimeFormatter ISO_8601_SHORT_DATE_FORMATTER = DateTimeFormat.forPattern(ISO_8601_SHORT_DATE_FORMAT);
	
	// To avoid confusion with fields null/versus not returning - we will
	// default to extended fields.
	protected Fields fields = Fields.EXT;

	public Fields getFields() {
      return fields;
    }
	
	public void setFields(Fields fields) {
      this.fields = fields;
    }

	@JsonIgnore
	public List<NameValuePair> getQueryParams() {
	  List<NameValuePair> qparams = new ArrayList<NameValuePair>();
	  if (fields != null) {
	    addParam(qparams, "fields", fields.getValue());
	  }
	  
	  return qparams;
	}

	protected void addParam(List<NameValuePair> qparams, String paramName, Long paramValue) {
		if(paramValue != null) {
			qparams.add(new BasicNameValuePair(paramName, paramValue.toString()));
		}
	}

	protected void addParam(List<NameValuePair> qparams, String paramName, Integer paramValue) {
		if(paramValue != null) {
			qparams.add(new BasicNameValuePair(paramName, paramValue.toString()));
		}
	}

	protected void addParam(List<NameValuePair> qparams, String paramName, String paramValue) {
		if(paramValue != null) {
			qparams.add(new BasicNameValuePair(paramName, paramValue));
		}
	}

	protected void addParam(List<NameValuePair> qparams, String paramName, BigDecimal paramValue) {
		if(paramValue != null) {
			qparams.add(new BasicNameValuePair(paramName, paramValue.toPlainString()));
		}
	}

	protected void addParam(List<NameValuePair> qparams, String paramName, Double paramValue) {
		if(paramValue != null) {
			qparams.add(new BasicNameValuePair(paramName, paramValue.toString()));
		}
	}
	
	protected void addParam(List<NameValuePair> qparams, String paramName, String[] paramValues) {
		if(paramValues != null) {
			for(String paramValue : paramValues)
			    qparams.add(new BasicNameValuePair(paramName, paramValue));
		}
	}

	protected <E extends Enum<E>> void addParam(List<NameValuePair> qparams, String paramName, E[] paramValues) {
		if(paramValues != null) {
			qparams.add(new BasicNameValuePair(paramName, EnumUtil.enumListString(paramValues)));
		}
	}

	protected <E extends Enum<E>> void addParam(List<NameValuePair> qparams, String paramName, E paramValue) {
		if(paramValue != null) {
			qparams.add(new BasicNameValuePair(paramName,  paramValue.name()));
		}
	}

	protected void addParam(List<NameValuePair> qparams, String paramName, DateTime paramValue) {
		if(paramValue != null) {
			//TODO - update this with correct formatting
			qparams.add(new BasicNameValuePair(paramName, paramValue.toString()));
		}
	}
	
	protected void addParam(List<NameValuePair> qparams, String paramName, LocalDate paramValue) {
		if(paramValue != null) {
			//TODO - update this with correct formatting
			qparams.add(new BasicNameValuePair(paramName, paramValue.toString()));
		}
	}

	protected void addParam(List<NameValuePair> qparams, String paramName, DateTime paramValue, String format) {
		if(paramValue != null) {
			qparams.add(new BasicNameValuePair(paramName, paramValue
					.toString(DateTimeFormat.forPattern(format))));
		}
	}

	protected void addParam(List<NameValuePair> qparams, String paramName, DateTime paramValue, DateTimeFormatter formatter) {
		if(paramValue != null) {
			qparams.add(new BasicNameValuePair(paramName, paramValue.toString(formatter)));
		}
	}
	
	protected void addParam(List<NameValuePair> qparams, String paramName, Boolean paramValue) {
		if(paramValue != null) {
			qparams.add(new BasicNameValuePair(paramName, 
					(Boolean.FALSE.equals(paramValue) ? "false" : "true")));
		}
	}
}
