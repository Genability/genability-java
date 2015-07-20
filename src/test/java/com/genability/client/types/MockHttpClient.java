package com.genability.client.types;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;

import static org.junit.Assert.*;

/*
 * This test double intercepts the HttpRequests sent by a service
 * and checks to make sure that the specified URI matches the
 * expected URI
 */
public class MockHttpClient implements HttpClient {

	private String expectedUriBase;
	private String receivedUri;
	private List<NameValuePair> expectedParameters;
	
	public MockHttpClient(final String expectedUri) {
		this.expectedUriBase = expectedUri;
		expectedParameters = new ArrayList<NameValuePair>();
		addExpectedParameter("fields", "ext");
	}
	
	@Override
	public <T> T execute(HttpUriRequest request,
			ResponseHandler<? extends T> responseHandler) throws IOException,
			ClientProtocolException {
		
		this.receivedUri = request.getURI().toString();
		return null;
	}

	/*
	 * Validates that the expected URI was received
	 */
	public void validate() {
		String[] splitUri = receivedUri.split("\\?");
		String receivedPath = splitUri[0];
		assertEquals("Expected URI didn't match received URI", expectedUriBase, receivedPath);
		
		if (splitUri.length > 1) {
			String rawParams = splitUri[1];
			String[] params = rawParams.split("&");
			
			List<NameValuePair> paramList = new ArrayList<NameValuePair>();
			for (String p : params) {
				String[] pair = p.split("=");
				paramList.add(new BasicNameValuePair(pair[0], pair[1]));
			}
			
			assertEquals("Parameter lists didn't have the same length", expectedParameters.size(), paramList.size());
			
			Comparator<NameValuePair> nvpComparator = getNameValuePairComparator();
			Collections.sort(paramList, (nvpComparator));
			Collections.sort(expectedParameters, (nvpComparator));
			
			int i = 0;
			for (NameValuePair expected : expectedParameters) {
				NameValuePair received = paramList.get(i);
				assertEquals("Parameters were not equal", expected, received);
				
				i++;
			}
		}
	}
	
	/*
	 * Sort the pairs alphabetically by name
	 */
	private Comparator<NameValuePair> getNameValuePairComparator() {
		Comparator<NameValuePair> c = new Comparator<NameValuePair>() {
			public int compare(NameValuePair left, NameValuePair right) {
				return left.getName().compareTo(right.getName());
			}
		};
		
		return c;
	}
	
	public String getExpectedUri() {
		return expectedUriBase;
	}
	
	public String getReceivedUri() {
		return receivedUri;
	}
	
	public void addExpectedParameter(String param, String value) {
		expectedParameters.add(new BasicNameValuePair(param, value));
	}
	
	@Override
	@Deprecated
	public HttpParams getParams() {
		// intentionally left empty, as it is not used in this library
		return null;
	}

	@Override
	@Deprecated
	public ClientConnectionManager getConnectionManager() {
		// intentionally left empty, as it is not used in this library
		return null;
	}

	@Override
	public HttpResponse execute(HttpUriRequest request) throws IOException,
			ClientProtocolException {
		// intentionally left empty, as it is not used in this library
		return null;
	}

	@Override
	public HttpResponse execute(HttpUriRequest request, HttpContext context)
			throws IOException, ClientProtocolException {
		// intentionally left empty, as it is not used in this library
		return null;
	}

	@Override
	public HttpResponse execute(HttpHost target, HttpRequest request)
			throws IOException, ClientProtocolException {
		// intentionally left empty, as it is not used in this library
		return null;
	}

	@Override
	public HttpResponse execute(HttpHost target, HttpRequest request,
			HttpContext context) throws IOException, ClientProtocolException {
		// intentionally left empty, as it is not used in this library
		return null;
	}
	
	@Override
	public <T> T execute(HttpUriRequest request,
			ResponseHandler<? extends T> responseHandler, HttpContext context)
			throws IOException, ClientProtocolException {
		// intentionally left empty, as it is not used in this library
		return null;
	}

	@Override
	public <T> T execute(HttpHost target, HttpRequest request,
			ResponseHandler<? extends T> responseHandler) throws IOException,
			ClientProtocolException {
		// intentionally left empty, as it is not used in this library
		return null;
	}

	@Override
	public <T> T execute(HttpHost target, HttpRequest request,
			ResponseHandler<? extends T> responseHandler, HttpContext context)
			throws IOException, ClientProtocolException {
		// intentionally left empty, as it is not used in this library
		return null;
	}

}
