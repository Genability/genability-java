package com.genability.client.types;

import java.io.Serializable;
import java.util.List;


/**
 * Standard response payload that comes back from REST endpoints.
 *
 * @param <T>
 */
public class Response<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String STATUS_SUCCESS = "success";

	public static final String STATUS_ERROR = "error";

	public static final String HTTP_HEADER_X_ERROR_DETAIL = "X-Error-Detail";

	private String status;

	private Integer count;

	private String type;

	private Integer requestId;

	private List<T> results;


	/**
	 * 
	 */
	public Response() {
	}


	/**
	 * @param sets
	 *            the status of the response
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the status of the response
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param sets
	 *            the count of items in the results
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the count of items in the results
	 */
	public Integer getCount() {
		return count;
	}


	/**
	 * @return the type of items in the results
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param sets
	 *            the type of items in the results
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the count of items in the results
	 */
	public Integer getRequestId() {
		return requestId;
	}

	/**
	 * @param sets
	 *            the count of items in the results
	 */
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

}
