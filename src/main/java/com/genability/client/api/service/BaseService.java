package com.genability.client.api.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.genability.client.util.JodaDateJsonSerializer;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.GzipCompressingEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.genability.client.api.request.BulkUploadRequest;
import com.genability.client.types.Response;

public class BaseService {
	
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	protected String restApiServer = "https://api.genability.com/rest/";

	protected String appId = null;
	protected String appKey = null;
	
	private ObjectMapper mapper;

	private HttpClient httpClient = HttpClientBuilder.create().build();
	private boolean requestCompression = false;
	
	public BaseService() {
	    mapper = new ObjectMapper();
	    mapper.registerModule(new JodaModule());
	    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
	    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	    mapper.setSerializationInclusion(Include.NON_NULL);
		SimpleModule module = new SimpleModule();
		module.addSerializer(DateTime.class, new JodaDateJsonSerializer());
		mapper.registerModule(module);
    }

	/**
	 * Mutator for IoC and configuration. If not called, this property defaults to 
	 * the Genability Production servers URL.
	 * @param restApiServer the restApiServer to set
	 */
	public void setRestApiServer(String restApiServer) {
		this.restApiServer = restApiServer;
	}
	
	public String getRestApiServer() {
		return restApiServer;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

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

	public ObjectMapper getMapper() {
		return mapper;
	}
	
	public void setHttpClient(HttpClient httpClient) {
		this.httpClient = httpClient;
	}

	public boolean getRequestCompression() {
		return requestCompression;
	}
	
	public void setRequestCompression(boolean requestCompression) {
		this.requestCompression = requestCompression;
	}
	
	/**
	 * Helper method that makes a HTTP GET to the Genability APIs.
	 * @param <T> The type parameter.
	 * @param <R> The type parameter.
	 * @param endpointPath The endpointPath.
	 * @param queryParams The queryParams.
	 * @param resultTypeReference The resultTypeReference.
	 * @return The return value.
	 */
	protected <T extends Response<R>, R> T callGet(String endpointPath, List<NameValuePair> queryParams, TypeReference<T> resultTypeReference) {
		String qs = null;

		String url = restApiServer + endpointPath; // + "?" + this.getQueryStringCredentials();  // if you prefer to pass creds on query string
		if(queryParams != null) qs = URLEncodedUtils.format(queryParams, "UTF-8");
		if(qs != null) url += "?" + qs;

		if(log.isDebugEnabled()) log.debug(qs);

		HttpGet getRequest = new HttpGet(url);
		if(log.isDebugEnabled()) log.debug(url);

		return execute(getRequest, resultTypeReference);
	}
	
	
	/**
	 * Helper method that makes a HTTP POST to the Genability APIs.
	 * @param <T> The type parameter.
	 * @param <R> The type parameter.
	 * @param endpointPath The endpointPath.
	 * @param requestPayload The requestPayload.
	 * @param resultTypeReference The resultTypeReference.
	 * @return The return value.
	 */
	protected <T extends Response<R>, R> T callPost(String endpointPath, final Object requestPayload, TypeReference<T> resultTypeReference) {
		String url = restApiServer + endpointPath;  // + "?" + this.getQueryStringCredentials();  // if you prefer to pass creds on query string
		if(log.isDebugEnabled()) log.debug(url);

		HttpPost postRequest = new HttpPost(url);
		postRequest.setEntity(getEntity(requestPayload));

		return execute(postRequest, resultTypeReference);
	}

	/**
	 * Helper method that makes a HTTP POST to the Genability APIs.
	 * @param <T> The type parameter.
	 * @param <R> The type parameter.
	 * @param endpointPath The endpointPath.
	 * @param requestPayload The requestPayload.
	 * @param resultTypeReference The resultTypeReference.
	 * @return The return value.
	 */
	protected <T extends Response<R>, R> T callPut(String endpointPath, final Object requestPayload, TypeReference<T> resultTypeReference) {
		String url = restApiServer + endpointPath; // + "?" +
														// this.getQueryStringCredentials();
														// // if you prefer to
														// pass creds on query
														// string
		if (log.isDebugEnabled())
			log.debug(url);

		HttpPut putRequest = new HttpPut(url);
		putRequest.setEntity(getEntity(requestPayload));

		return execute(putRequest, resultTypeReference);
	}
	
	/**
	 * This method is used to upload large datasets, typically CSV or XML files.
	 * The request object passed in contains the File to upload.
	 * @param <T> The type parameter.
	 * @param <R> The type parameter.
	 * @param endpointPath The endpointPath.
	 * @param request The request.
	 * @param resultTypeReference The resultTypeReference.
	 * @return The return value.
	 */
	public <T extends Response<R>, R> T callFileUpload(String endpointPath, BulkUploadRequest request, TypeReference<T> resultTypeReference) {
		String url = restApiServer + endpointPath;  // + "?" + this.getQueryStringCredentials();  // if you prefer to pass creds on query string

		if(log.isDebugEnabled()) log.debug(url);

		// Set up post request and set header auth
		HttpPost postRequest = new HttpPost(url);
		
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
		postRequest.setEntity(getEntity(builder.build()));

		return execute(postRequest, resultTypeReference);
	}
	
	/**
	 * Helper method that makes a HTTP DELETE to the Genability APIs.
	 * @param <T> The type parameter.
	 * @param <R> The type parameter.
	 * @param endpointPath The endpointPath.
	 * @param queryParams The queryParams.
	 * @param resultTypeReference The resultTypeReference.
	 * @return The return value.
	 */
	protected <T extends Response<R>, R> T callDelete(String endpointPath, List<NameValuePair> queryParams, TypeReference<T> resultTypeReference) {
		String qs = null;

		String url = restApiServer + endpointPath; // + "?" + this.getQueryStringCredentials();  // if you prefer to pass creds on query string
		if(queryParams != null) qs = URLEncodedUtils.format(queryParams, "UTF-8");
		if(qs != null) url += "?" + qs;

		if(log.isDebugEnabled()) log.debug(qs);

		HttpDelete deleteRequest = new HttpDelete(url);

		return execute(deleteRequest, resultTypeReference);
	} // end of callGet

	protected <T extends Response<R>, R> T execute(final HttpRequestBase request, final TypeReference<T> resultTypeReference) {
		try {
			request.addHeader("accept", "application/json");

			String basic_auth = new String(Base64.encodeBase64((appId + ":" + appKey).getBytes()));
			request.addHeader("Authorization", "Basic " + basic_auth);
			request.addHeader("Accept-Encoding", "gzip");
			request.addHeader("Connection", "close"); //close connections after we receive a response

			return httpClient.execute(request, new ResponseHandler<T>() {
				@Override
				public T handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
					if (httpResponse.getStatusLine().getStatusCode() != 200) {
						String responseBody = null;
						try {
							responseBody = EntityUtils.toString(httpResponse.getEntity());
						}
						catch (IOException ex) {}

						throw new GenabilityException("Failed " + request.getMethod() + " " + request.getURI() +
								": HTTP error code : " + httpResponse.getStatusLine().getStatusCode(), responseBody);
					}

					//
					// Convert the JSON pay-load to the standard Response object.
					//
					return mapper.readValue(httpResponse.getEntity().getContent(), resultTypeReference);
				}
			});

		}
		catch (ClientProtocolException e) {
			log.error("ClientProtocolException", e);
			throw new GenabilityException(e);
		}
		catch (IOException e) {
			log.error("IOException", e);
			throw new GenabilityException(e);
		}
	}

	private HttpEntity getEntity(Object obj) {
		return getEntity(new JacksonHttpEntity(obj));
	}
	
	private HttpEntity getEntity(HttpEntity ent) {
		if (requestCompression) {
			return new GzipCompressingEntity(ent);
		} else {
			return ent;
		}
	}
	
	private class JacksonHttpEntity extends AbstractHttpEntity {

		private final Object object;

		public JacksonHttpEntity(final Object object) {
			this.object = object;

			setContentType(ContentType.APPLICATION_JSON.getMimeType());
		}

		@Override
		public long getContentLength() {
			return -1;
		}

		@Override
		public boolean isRepeatable() {
			return true;
		}

		@Override
		public boolean isStreaming() {
			return false;
		}

		@Override
		public InputStream getContent() throws IOException {
			return new ByteArrayInputStream(mapper.writeValueAsBytes(object));
		}

		@Override
		public void writeTo(final OutputStream outstream) throws IOException {
			if (outstream == null) {
				throw new IllegalArgumentException("Output stream may not be null");
			}
			mapper.writeValue(outstream, object);
		}
	}
}
