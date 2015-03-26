package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.genability.client.types.ReadingData;

public class ReadingDataRequest extends AbstractRequest implements Serializable{
	private static final long serialVersionUID = 1L;

	private String usageProfileId;
	private List<ReadingData> readings;

	public String getUsageProfileId() {
		return usageProfileId;
	}

	public void setUsageProfileId(String profileId) {
		this.usageProfileId = profileId;
	}
	
	public List<ReadingData> getReadings() {
		return readings;
	}

	public void setReadings(List<ReadingData> readings) {
		this.readings = readings;
	}

	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {
		List<NameValuePair> qparams = super.getQueryParams();
		
		addParam(qparams, "usageProfileId", usageProfileId);

		return qparams;
	}
}
