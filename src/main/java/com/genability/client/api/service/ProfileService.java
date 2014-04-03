package com.genability.client.api.service;

import java.text.MessageFormat;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.GetProfileRequest;
import com.genability.client.api.request.GetProfilesRequest;
import com.genability.client.api.request.ReadingDataRequest;
import com.genability.client.types.Profile;
import com.genability.client.types.Response;


public class ProfileService extends BaseService {
	
    private static final TypeReference<Response<Profile>> PROFILE_RESPONSE_TYPEREF = new TypeReference<Response<Profile>>() {};

	/**
	 * Calls the REST service to get a Profile based on the arguments passed in.
	 * 
	 * @return
	 */
	public Response<Profile> getProfile(GetProfileRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getProfile called");
		
		String uri = "v1/usage/profiles";
		if (request.getProfileId() != null && request.getProfileId().length() !=0) {
			uri += "/" + request.getProfileId();
		}
		
		Response<Profile> response = this.callGet(
				uri,
				request.getQueryParams(),
				PROFILE_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getProfile completed");
		
		return response;
		
	}

	/**
	 * Calls the REST service to get Profiles based on the arguments passed in.
	 * 
	 * @return
	 */
	public Response<Profile> getProfiles(GetProfilesRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getProfiles called");
		
		String uri = "v1/usage/profiles";
		
		Response<Profile> response = this.callGet(
				uri,
				request.getQueryParams(),
				PROFILE_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getProfiles completed");
		
		return response;
		
	}
	
	public Response<Profile> addProfile(Profile profile) {
		
		if(log.isDebugEnabled()) log.debug("addProfile called");
	
		Response<Profile> response = this.callPost(
"v1/usage/profiles",
				profile,
				PROFILE_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("addProfile completed");
		
		return response;
		
	}
	

	public Response<Profile> updateProfile(Profile profile) {

		if (log.isDebugEnabled())
			log.debug("updateProfile called");

		String uri = "v1/profiles/{0}";

		if (profile.getProfileId() != null
				&& profile.getProfileId().length() != 0) {
			uri = MessageFormat.format(uri, profile.getProfileId());
		}

		Response<Profile> response = this.callPut(uri, profile,
				PROFILE_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("updateProfile completed");

		return response;

	}

	public Response<Profile> updateReadings(ReadingDataRequest request) {

		if (log.isDebugEnabled())
			log.debug("updateReadings called");

		String uri = "v1/profiles/{0}";

		if (request.getProfileId() != null) {
			uri = MessageFormat.format(uri, request.getProfileId());
		}

		Response<Profile> response = this.callPut(uri, request,
				PROFILE_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("updateReadings completed");

		return response;

	}

	public Response<Profile> addReadings(ReadingDataRequest request) {

		if (log.isDebugEnabled())
			log.debug("updateReadings called");

		String uri = "v1/profiles/{0}";

		if (request.getProfileId() != null) {
			uri = MessageFormat.format(uri, request.getProfileId());
		}

		Response<Profile> response = this.callPost(uri, request,
				PROFILE_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("updateReadings completed");

		return response;

	}

}
