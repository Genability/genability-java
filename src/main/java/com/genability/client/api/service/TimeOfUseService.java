package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.GetTimeOfUseGroupsRequest;
import com.genability.client.api.request.GetTimeOfUseIntervalsRequest;
import com.genability.client.types.Response;
import com.genability.client.types.TimeOfUseGroup;
import com.genability.client.types.TimeOfUseInterval;

public class TimeOfUseService extends BaseService {
	private static final TypeReference<Response<TimeOfUseGroup>> TOU_GROUP_RESPONSE_TYPEREF = new TypeReference<Response<TimeOfUseGroup>>() {};
	private static final TypeReference<Response<TimeOfUseInterval>> TOU_INTERVAL_RESPONSE_TYPEREF = new TypeReference<Response<TimeOfUseInterval>>() {};
	private static final String URL_BASE = "public/timeofuses";
	
	public Response<TimeOfUseGroup> getTimeOfUseGroup(long lseId, long touGroupId) {
		if (log.isDebugEnabled()) {
			log.debug("getTimeOfUseGroup called");
		}
		
		String url = String.format("%s/%d/%d", URL_BASE, lseId, touGroupId); 
		Response<TimeOfUseGroup> response = this.callGet(url, null, TOU_GROUP_RESPONSE_TYPEREF);
		
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
		
		Response<TimeOfUseGroup> response = this.callGet(URL_BASE,
				request.getQueryParams(),
				TOU_GROUP_RESPONSE_TYPEREF);
		
		if (log.isDebugEnabled()) {
			log.debug("Done with getTimeOfUseGroups");
		}
		
		return response;
	}
	
	/*
	 * Get a list of intervals for the specified timeOfUseGroup. If request is null, no query parameters are
	 * added to the HTTP request.
	 */
	public Response<TimeOfUseInterval> getTimeOfUseIntervals(long lseId, long touGroupId, GetTimeOfUseIntervalsRequest request) {
		if (log.isDebugEnabled()) {
			log.debug("getTimeOfUseIntervals called");
		}
		
		String url = String.format("%s/%d/%d/intervals", URL_BASE, lseId, touGroupId);
		Response<TimeOfUseInterval> response = this.callGet(url,
				request.getQueryParams(),
				TOU_INTERVAL_RESPONSE_TYPEREF);
		
		if (log.isDebugEnabled()) {
			log.debug("Done with getTimeOfUseIntervals");
		}
		
		return response;
	}
}
