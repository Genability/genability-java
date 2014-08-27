package com.genability.client.api.request;

import java.io.Serializable;

public class DeleteProfileRequest extends AbstractRequest implements Serializable{

	/**
	 * private member variable for serial version
	 */
	private static final long serialVersionUID = 1L;


	private String profileId;

	/**
	 * private member variable for providerProfileId
	 */
	private String providerProfileId;


	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getProviderProfileId() {
		return providerProfileId;
	}

	public void setProviderProfileId(String providerProfileId) {
		this.providerProfileId = providerProfileId;
	}

}
