package com.genability.client.api.service;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.genability.client.types.Response;

public class BaseService {
	
	
	/**
	 * Protected member of logger
	 */
	protected final Log log = LogFactory.getLog(this.getClass());

	/**
	 * Protected member of URL of the server to call
	 */
	protected String restApiServer = "http://api.genability.com/rest/";
	
	/**
	 * Protected member holding the App ID for authentication.
	 */
	protected String appId = null;

	/**
	 * Protected member holding the App Key for authentication.
	 */
	protected String appKey = null;
	
	/**
	 * Private member holding the Jackson Object Mapper (for JSON conversions).
	 */
	private ObjectMapper mapper = new ObjectMapper();
	


	/**
	 * Mutator for IoC and configuration. If not called, this property defaults to 
	 * the Genability Production servers URL.
	 * @param restApiServer the restApiServer to set
	 */
	public void setRestApiServer(String restApiServer) {
		this.restApiServer = restApiServer;
	}


	/**
	 * Mutator for IoC and configuration. You need to call this as their
	 * isn't a default.
	 * 
	 * @param appId the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}


	/**
	 * Mutator for IoC and configuration. You need to call this as their
	 * isn't a default.
	 * 
	 * @param appKey the appKey to set
	 */
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}


	/**
	 * Mutator for IoC and configuration. Typically you don't need to worry about this
	 * as the default sets up a mapper for you.
	 * 
	 * @param mapper the mapper to set
	 */
	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}


	/**
	 * Helper method that makes a HTTP GET to the Genability APIs.
	 * 
	 * @param endpointPath
	 * @param resultTypeReference
	 * @return
	 */
	protected Response<?> callGet(String endpointPath, List<NameValuePair> queryParams, TypeReference<?> resultTypeReference) {

		Response<?> restResponse = null;

		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			
			String url = restApiServer + endpointPath + "?" + this.getQueryStringCredentials();
			String qs = URLEncodedUtils.format(queryParams, "UTF-8");
			if(qs != null) url += "&" + qs;
			
			if(log.isDebugEnabled()) log.debug(qs);
			
			HttpGet getRequest = new HttpGet(url);
			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			//
			// Convert the JSON pay-load to the standard Response object.
			//
			restResponse = mapper.readValue(response.getEntity().getContent(), resultTypeReference);
			
			httpClient.getConnectionManager().shutdown();

		} catch (ClientProtocolException e) {

			log.error("ClientProtocolException",e);

		} catch (IOException e) {

			log.error("IOException",e);
		}

		return restResponse;
		
	} // end of callGet
	
	
	/**
	 * Helps build the credentials for the request.
	 */
	private String getQueryStringCredentials() {
		
		return "appId=" + appId + "&appKey=" + appKey;

	}

}
