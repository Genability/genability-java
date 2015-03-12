package com.genability.client.api.service;

import java.text.MessageFormat;

import com.fasterxml.jackson.core.type.TypeReference;

import com.genability.client.api.request.DeleteProfileRequest;
import com.genability.client.api.request.GetProfileRequest;
import com.genability.client.api.request.GetProfilesRequest;
import com.genability.client.api.request.ReadingDataRequest;
import com.genability.client.types.Profile;
import com.genability.client.types.ReadingData;
import com.genability.client.types.Response;


public class ProfileService extends BaseService {
	
    private static final TypeReference<Response<Profile>> PROFILE_RESPONSE_TYPEREF = new TypeReference<Response<Profile>>() {};
	private static final TypeReference<Response<ReadingData>> READING_DATA_RESPONSE_TYPEREF = new TypeReference<Response<ReadingData>>() {
	};

	/**
	 * Calls the REST service to get a Profile based on the arguments passed in.
	 * 
	 * @return
	 */
	public Response<Profile> getProfile(GetProfileRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getProfile called");

		// Set uri based on if providerProfileId was used
		String uri = "v1/profiles";
		if (request.getProviderProfileId() != null
				&& request.getProviderProfileId().length() != 0) {

			uri += "/pid/" + request.getProviderProfileId();

		} else if (request.getProfileId() != null
				&& request.getProfileId().length() != 0) {

			uri += "/" + request.getProfileId();
		}

		Response<Profile> response = this.callGet(uri,
				request.getQueryParams(), PROFILE_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("getProfile completed");

		return response;

	}

	/**
	 * Calls the REST service to get Profiles based on the arguments passed in.
	 * 
	 * @return
	 */
	public Response<Profile> getProfiles(GetProfilesRequest request) {
		
		if(log.isDebugEnabled()) log.debug("getProfiles called");
		
		String uri = "v1/profiles";
		
		Response<Profile> response = this.callGet(
				uri,
				request.getQueryParams(),
				PROFILE_RESPONSE_TYPEREF);
		
		if(log.isDebugEnabled()) log.debug("getProfiles completed");
		
		return response;
		
	}
	
	public Response<Profile> addProfile(Profile profile) {

		if (log.isDebugEnabled())
			log.debug("addProfile called");

		Response<Profile> response = this.callPost("v1/usage/profiles",
				profile, PROFILE_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("addProfile completed");

		return response;

	}

	public Response<Profile> updateProfile(Profile profile) {

		if (log.isDebugEnabled())
			log.debug("updateProfile called");

		String uri = "v1/profiles";

		Response<Profile> response = this.callPut(uri, profile,
				PROFILE_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("updateProfile completed");

		return response;

	}

	/**
	 * Calls the REST service to delete a Profile based on the arguments passed in.
	 *
	 * @return
	 */
	public Response<Profile> deleteProfile(DeleteProfileRequest request) {
		if(log.isDebugEnabled()) log.debug("deleteProfile called");

		String profileId = request.getProfileId();

		if (profileId == null || profileId.isEmpty()) {
			throw new GenabilityException("profileId must be set");
		}

		String uri = "v1/profiles/" + profileId;

		Response<Profile> response = this.callDelete(uri, request.getQueryParams(), PROFILE_RESPONSE_TYPEREF);

		if (log.isDebugEnabled()) log.debug("deleteProfile completed");

		return response;
	}

	public Response<ReadingData> updateReadings(ReadingDataRequest request) {

		if (log.isDebugEnabled())
			log.debug("updateReadings called");

		String uri = "v1/profiles/{0}/readings";

		if (request.getUsageProfileId() != null) {
			uri = MessageFormat.format(uri, request.getUsageProfileId());
		}

		Response<ReadingData> response = this.callPut(uri, request,
				READING_DATA_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("updateReadings completed");

		return response;

	}

	public Response<ReadingData> addReadings(ReadingDataRequest request) {

		if (log.isDebugEnabled())
			log.debug("addReadings called");

		String uri = "v1/profiles/{0}/readings";

		if (request.getUsageProfileId() != null) {
			uri = MessageFormat.format(uri, request.getUsageProfileId());
		}

		Response<ReadingData> response = this.callPost(uri, request,
				READING_DATA_RESPONSE_TYPEREF);

		if (log.isDebugEnabled())
			log.debug("addReadings completed");

		return response;

	}

}
