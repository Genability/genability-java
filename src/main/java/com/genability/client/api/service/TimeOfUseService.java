package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.GetTimeOfUseGroupsRequest;
import com.genability.client.api.request.GetTimeOfUseIntervalsRequest;
import com.genability.client.types.Response;
import com.genability.client.types.TimeOfUseGroup;
import com.genability.client.types.TimeOfUseInterval;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class TimeOfUseService extends BaseService {
	private static final TypeReference<Response<TimeOfUseGroup>> TOU_GROUP_RESPONSE_TYPEREF = new TypeReference<Response<TimeOfUseGroup>>() {};
	private static final TypeReference<Response<TimeOfUseInterval>> TOU_INTERVAL_RESPONSE_TYPEREF = new TypeReference<Response<TimeOfUseInterval>>() {};
	private static final String PUBLIC_URL_BASE = "public/timeofuses";
	private static final String PRIVATE_URL_BASE = "timeofuses";
	
	public Response<TimeOfUseGroup> getTimeOfUseGroup(long lseId, long touGroupId) {
		if (log.isDebugEnabled()) {
			log.debug("getTimeOfUseGroup called");
		}

		List<NameValuePair> queryParams = new ArrayList<NameValuePair>();
		queryParams.add(new BasicNameValuePair("fields", "ext"));

		String url = String.format("%s/%d/%d", PUBLIC_URL_BASE, lseId, touGroupId); 
		Response<TimeOfUseGroup> response = this.callGet(url, queryParams, TOU_GROUP_RESPONSE_TYPEREF);
		
		if (log.isDebugEnabled()) {
			log.debug("Done with getTimeOfUseGroup");
		}
		
		return response;
	}

	/*
	 * Get a list of TimeOfUseGroups matching the request parameters. If request is null,
	 * all TimeOfUseGroups will be returned.
	 */
	public Response<TimeOfUseGroup> getTimeOfUseGroups(GetTimeOfUseGroupsRequest request) {
		if (log.isDebugEnabled()) {
			log.debug("getTimeOfUseGroups called");
		}
		
		Response<TimeOfUseGroup> response = this.callGet(PUBLIC_URL_BASE,
				request.getQueryParams(),
				TOU_GROUP_RESPONSE_TYPEREF);
		
		if (log.isDebugEnabled()) {
			log.debug("Done with getTimeOfUseGroups");
		}
		
		return response;
	}
	
	/*
	 * Get a list of intervals for the specified timeOfUseGroup. If request is null, one week of intervals
	 * is returned
	 */
	public Response<TimeOfUseInterval> getTimeOfUseIntervals(long lseId, long touGroupId, GetTimeOfUseIntervalsRequest request) {
		if (log.isDebugEnabled()) {
			log.debug("getTimeOfUseIntervals called");
		}
		
		String url = String.format("%s/%d/%d/intervals", PUBLIC_URL_BASE, lseId, touGroupId);
		Response<TimeOfUseInterval> response = this.callGet(url,
				request.getQueryParams(),
				TOU_INTERVAL_RESPONSE_TYPEREF);
		
		if (log.isDebugEnabled()) {
			log.debug("Done with getTimeOfUseIntervals");
		}
		
		return response;
	}
	
	/**
	 * Creates a private TimeOfUseGroup out of the passed-in TOU group.
	 * 
	 * @param touGroup The touGroup.
	 * @return The added TOU group that is sent back by the API.
	 */
	public Response<TimeOfUseGroup> addPrivateTimeOfUseGroup(TimeOfUseGroup touGroup) {
		if (log.isDebugEnabled()) {
			log.debug("addPrivateTouGroup called");
		}
		
		Response<TimeOfUseGroup> response = this.callPost(PRIVATE_URL_BASE,
				touGroup,
				TOU_GROUP_RESPONSE_TYPEREF);
		
		if (log.isDebugEnabled()) {
			log.debug("Done with addPrivateTouGroup");
		}
		
		return response;
	}
	
	/**
	 * Updates the passed-in private TimeOfUseGroup. You can only update a TOU group
	 * that belongs to your organization.
	 * 
	 * @param touGroup The touGroup.
	 * @return The added TOU group that is sent back by the API.
	 */
	public Response<TimeOfUseGroup> updatePrivateTimeOfUseGroup(TimeOfUseGroup touGroup) {
		if (log.isDebugEnabled()) {
			log.debug("updatePrivateTouGroup called");
		}
		
		Response<TimeOfUseGroup> response = this.callPut(PRIVATE_URL_BASE,
				touGroup,
				TOU_GROUP_RESPONSE_TYPEREF);
		
		if (log.isDebugEnabled()) {
			log.debug("Done with updatePrivateTouGroup");
		}
		
		return response;
	}
	
	/**
	 * Deletes a private TOU group. You can only delete a TOU group that belongs to your
	 * organization.
	 * 
	 * @param lseId The lseId.
	 * @param touGroupId The touGroupId.
	 * @return The deleted TOU group, which is sent back by the API.
	 */
	public Response<TimeOfUseGroup> deletePrivateTimeOfUseGroup(long lseId, long touGroupId) {
		if (log.isDebugEnabled()) {
			log.debug("deletePrivateTouGroup called");
		}
		
		String url = String.format("%s/%d/%d", PRIVATE_URL_BASE, lseId, touGroupId);
		Response<TimeOfUseGroup> response = this.callDelete(url,
				null,
				TOU_GROUP_RESPONSE_TYPEREF);
		
		if (log.isDebugEnabled()) {
			log.debug("Done with deletePrivateTouGroup");
		}
		
		return response;
	}
}
