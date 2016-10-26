package com.genability.client.types;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Standard response payload that comes back from REST endpoints.
 *
 * @param <T> The type parameter.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String STATUS_SUCCESS = "success";
	public static final String STATUS_ERROR = "error";
	public static final String HTTP_HEADER_X_ERROR_DETAIL = "X-Error-Detail";

	private String status;
	private String type;
	private List<T> results;
	
	private Integer pageStart;
	private Integer pageCount;
	private Integer count;

	private String requestId;

	public Response() {
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCount() {
		return count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public Integer getPageCount() {
		return pageCount;
	}
	
	public void setPageCount(final Integer pageLength) {
		this.pageCount = pageLength;
	}
	
	public Integer getPageStart() {
		return pageStart;
	}
	
	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
}
