package com.genability.client.api.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentProducer;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.genability.client.api.request.BulkUploadRequest;
import com.genability.client.types.Response;

public class BaseService {
	
	
	/**
	 * Protected member of logger
	 */
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

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
	private ObjectMapper mapper;
	
	/**
	 * Private member holding the Apache HttpClient
	 */
	private CloseableHttpClient httpClient;


	public BaseService() {
	    mapper = new ObjectMapper();
	    mapper.registerModule(new JodaModule());
	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    mapper.setSerializationInclusion(Include.NON_NULL);

	    httpClient = HttpClientBuilder.create().build();
    }


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
	 * Mutator for IoC and configuration. Typically you don't need to worry about this
	 * as the default sets up a mapper for you.
	 *
	 * @param mapper the mapper to set
	 */
	public void setHttpClient(CloseableHttpClient httpClient) {
		this.httpClient = httpClient;
	}


	/**
	 * Helper method that makes a HTTP GET to the Genability APIs.
	 * 
	 * @param endpointPath
	 * @param resultTypeReference
	 * @return
	 */
	protected <T extends Response<R>, R> T callGet(String endpointPath, List<NameValuePair> queryParams, TypeReference<T> resultTypeReference) {

		T restResponse = null;

		try {

			String qs = null;
			
			String url = restApiServer + endpointPath; // + "?" + this.getQueryStringCredentials();  // if you prefer to pass creds on query string
			if(queryParams != null) qs = URLEncodedUtils.format(queryParams, "UTF-8");
			if(qs != null) url += "?" + qs;
			
			if(log.isDebugEnabled()) log.debug(qs);
			
			HttpGet getRequest = new HttpGet(url);

			getRequest.addHeader("accept", "application/json");

			String basic_auth = new String(Base64.encodeBase64((appId + ":" + appKey).getBytes()));
			getRequest.addHeader("Authorization", "Basic " + basic_auth);

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			//
			// Convert the JSON pay-load to the standard Response object.
			//
			restResponse = mapper.readValue(response.getEntity().getContent(), resultTypeReference);

		} catch (ClientProtocolException e) {

			log.error("ClientProtocolException",e);

		} catch (IOException e) {

			log.error("IOException",e);
		}

		return restResponse;
		
	} // end of callGet
	
	
	/**
	 * Helper method that makes a HTTP POST to the Genability APIs.
	 * 
	 * @param endpointPath
	 * @param resultTypeReference
	 * @return
	 */
	protected <T extends Response<R>, R> T callPost(String endpointPath, final Object requestPayload, TypeReference<T> resultTypeReference) {
		
		T restResponse = null;

		try {

			String url = restApiServer + endpointPath;  // + "?" + this.getQueryStringCredentials();  // if you prefer to pass creds on query string
			if(log.isDebugEnabled()) log.debug(url);
			
			HttpPost postRequest = new HttpPost(url);
			postRequest.addHeader("accept", "application/json");
			String basic_auth = new String(Base64.encodeBase64((appId + ":" + appKey).getBytes()));
			postRequest.addHeader("Authorization", "Basic " + basic_auth);
			
			//
			// Convert the object to a JSON request body.
			//
			postRequest.addHeader("Content-Type", "application/json");
			ContentProducer cp = new ContentProducer() {
				
				@Override
			    public void writeTo(OutputStream outstream) throws IOException {
					
					mapper.writeValue(outstream, requestPayload);
					
			    }
			};
			HttpEntity entity = new EntityTemplate(cp);
			postRequest.setEntity(entity);

			HttpResponse response = httpClient.execute(postRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			//
			// Convert the JSON pay-load to the standard Response object.
			//
			restResponse = mapper.readValue(response.getEntity().getContent(), resultTypeReference);

		} catch (ClientProtocolException e) {

			log.error("ClientProtocolException",e);

		} catch (IOException e) {

			log.error("IOException",e);
		}

		return restResponse;
		
	} // end of callPost

	/**
	 * Helper method that makes a HTTP POST to the Genability APIs.
	 * 
	 * @param endpointPath
	 * @param resultTypeReference
	 * @return
	 */
	protected <T extends Response<R>, R> T callPut(String endpointPath,
			final Object requestPayload, TypeReference<T> resultTypeReference) {

		T restResponse = null;

		try {

			String url = restApiServer + endpointPath; // + "?" +
														// this.getQueryStringCredentials();
														// // if you prefer to
														// pass creds on query
														// string
			if (log.isDebugEnabled())
				log.debug(url);

			HttpPut putRequest = new HttpPut(url);
			putRequest.addHeader("accept", "application/json");
			String basic_auth = new String(
					Base64.encodeBase64((appId + ":" + appKey).getBytes()));
			putRequest.addHeader("Authorization", "Basic " + basic_auth);

			//
			// Convert the object to a JSON request body.
			//
			putRequest.addHeader("Content-Type", "application/json");
			ContentProducer cp = new ContentProducer() {

				@Override
				public void writeTo(OutputStream outstream) throws IOException {

					mapper.writeValue(outstream, requestPayload);

				}
			};
			HttpEntity entity = new EntityTemplate(cp);
			putRequest.setEntity(entity);

			HttpResponse response = httpClient.execute(putRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			//
			// Convert the JSON pay-load to the standard Response object.
			//
			restResponse = mapper.readValue(response.getEntity().getContent(),
					resultTypeReference);

		} catch (ClientProtocolException e) {

			log.error("ClientProtocolException", e);

		} catch (IOException e) {

			log.error("IOException", e);
		}

		return restResponse;

	} // end of callPut
	
	/*
	 * This method is used to upload large datasets, typically CSV or XML files.
	 * The request object passed in contains the File to upload.
	 */
	public <T extends Response<R>, R> T callFileUpload(String endpointPath, BulkUploadRequest request, TypeReference<T> resultTypeReference) {
		
		T restResponse = null;

		String url = restApiServer + endpointPath;  // + "?" + this.getQueryStringCredentials();  // if you prefer to pass creds on query string

		if(log.isDebugEnabled()) log.debug(url);

		// Set up post request and set header auth
		HttpPost postRequest = new HttpPost(url);
		String basic_auth = new String(Base64.encodeBase64((appId + ":" + appKey).getBytes()));
		postRequest.addHeader("Authorization", "Basic " + basic_auth);
		
		// Large files may take a while, so we are setting this to a 5 minute
		// timeout
		Builder requestConfigBuilder = RequestConfig.custom();
		requestConfigBuilder.setSocketTimeout(300000);
		postRequest.setConfig(requestConfigBuilder.build());

		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

		// Set file data
		FileBody fileBody = new FileBody(request.getFileData());
		builder.addPart("fileData", fileBody);
		builder.addTextBody("fileFormat", request.getFileFormat(),
				ContentType.TEXT_XML);
		postRequest.setEntity(builder.build());


	    try {
		    HttpResponse response = httpClient.execute(postRequest);
			restResponse = mapper.readValue(response.getEntity().getContent(),
					resultTypeReference);

		} catch (ClientProtocolException e) {
			
			log.error("ClientProtocolException",e);
	
		} catch (IOException e) {
	
			log.error("IOException",e);
		}
		return restResponse;
		
	}
	
	/**
	 * Helper method that makes a HTTP DELETE to the Genability APIs.
	 * 
	 * @param endpointPath
	 * @param resultTypeReference
	 * @return
	 */
	protected <T extends Response<R>, R> T callDelete(String endpointPath, List<NameValuePair> queryParams, TypeReference<T> resultTypeReference) {

		T restResponse = null;

		try {

			String qs = null;
			
			String url = restApiServer + endpointPath; // + "?" + this.getQueryStringCredentials();  // if you prefer to pass creds on query string
			if(queryParams != null) qs = URLEncodedUtils.format(queryParams, "UTF-8");
			if(qs != null) url += "?" + qs;
			
			if(log.isDebugEnabled()) log.debug(qs);
			
			HttpDelete deleteRequest = new HttpDelete(url);
			
			deleteRequest.addHeader("accept", "application/json");

			String basic_auth = new String(Base64.encodeBase64((appId + ":" + appKey).getBytes()));
			deleteRequest.addHeader("Authorization", "Basic " + basic_auth);

			HttpResponse response = httpClient.execute(deleteRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			//
			// Convert the JSON pay-load to the standard Response object.
			//
			restResponse = mapper.readValue(response.getEntity().getContent(), resultTypeReference);

		} catch (ClientProtocolException e) {

			log.error("ClientProtocolException",e);

		} catch (IOException e) {

			log.error("IOException",e);
		}

		return restResponse;
		
	} // end of callGet	

}
