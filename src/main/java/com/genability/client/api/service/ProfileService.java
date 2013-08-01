package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.GetProfileRequest;
import com.genability.client.api.request.GetProfilesRequest;
import com.genability.client.types.Response;
import com.genability.client.types.Profile;


public class ProfileService extends BaseService {
	
	
	/**
	 * Calls the REST service to get a Profile based on the arguments passed in.
	 * 
	 * @return
	 */
	public Response<Profile> getProfile(GetProfileRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getProfile called");
		
		String uri = "beta/usage/profiles";
		if (request.getUsageProfileId() != null && request.getUsageProfileId().length() !=0) {
			uri += "/" + request.getUsageProfileId();
		}
		
		Response<Profile> response = this.callGet(
				uri,
				request.getQueryParams(),
				new TypeReference<Response<Profile>>() { });
		
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
		
		String uri = "beta/usage/profiles";
		
		Response<Profile> response = this.callGet(
				uri,
				request.getQueryParams(),
				new TypeReference<Response<Profile>>() { });
		
		if(log.isDebugEnabled()) log.debug("getProfiles completed");
		
		return response;
		
	}
	
	public Response<Profile> addProfile(Profile profile) {
		
		if(log.isDebugEnabled()) log.debug("addProfile called");
	
		Response<Profile> response = this.callPost(
				"beta/usage/profiles", 
				profile,
				new TypeReference<Response<Profile>>() { });
		
		if(log.isDebugEnabled()) log.debug("addProfile completed");
		
		return response;
		
	}
	
}
