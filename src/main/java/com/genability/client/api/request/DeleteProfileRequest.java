package com.genability.client.api.request;

import java.io.Serializable;

public class DeleteProfileRequest extends AbstractRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String profileId;

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
}
