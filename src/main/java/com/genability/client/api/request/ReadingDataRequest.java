package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;

import com.genability.client.types.ReadingData;

public class ReadingDataRequest extends AbstractRequest implements Serializable{

	/**
	 * private member variable for serial version
	 */
	private static final long serialVersionUID = 1L;
	

	private String profileId;
	private List<ReadingData> readings;

	/**
	 * @return the usageProfileId_
	 */
	public String getProfileId() {
		return profileId;
	}

	/**
	 * @param usageProfileId_
	 *            the usageProfileId_ to set
	 */
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	
	public List<ReadingData> getReadings() {
		return readings;
	}

	public void setReadings(List<ReadingData> readings) {
		this.readings = readings;
	}

	@Override
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = super.getQueryParams();
		
		addParam(qparams, "profileId", profileId);
		return qparams;
		
	}
	
} // end of class GetProfileRestRequest
