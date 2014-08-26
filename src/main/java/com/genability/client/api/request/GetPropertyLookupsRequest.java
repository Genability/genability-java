package com.genability.client.api.request;

import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

public class GetPropertyLookupsRequest extends AbstractRequest {


	private String propertyKey;

	private String subPropertyKey;

	private DateTime fromDateTime;
	
	private DateTime toDateTime;


	public String getPropertyKey() {
		return propertyKey;
	}

	public void setPropertyKey(String propertyKey) {
		this.propertyKey = propertyKey;
	}

	public String getSubPropertyKey() {
		return subPropertyKey;
	}

	public void setSubPropertyKey(String subPropertyKey) {
		this.subPropertyKey = subPropertyKey;
	}

	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public DateTime getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime = toDateTime;
	}
	
	
	@Override
	public List<NameValuePair> getQueryParams() {

		List<NameValuePair> qparams = super.getQueryParams();
		addParam(qparams,"propertyKey", propertyKey);
		addParam(qparams,"subPropertyKey", subPropertyKey);
		addParam(qparams,"fromDateTime", fromDateTime);
		addParam(qparams,"toDateTime", toDateTime);
		return qparams;
		
	}

}
