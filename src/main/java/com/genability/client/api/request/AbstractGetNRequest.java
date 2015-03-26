package com.genability.client.api.request;

import java.util.List;

import org.apache.http.NameValuePair;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.genability.client.types.SortOrder;

public abstract class AbstractGetNRequest extends AbstractRequest {
	
	
	private Integer pageStart;

	private Integer pageCount;

	protected String search;
	
	protected String searchOn;

	protected Boolean startsWith;

	protected Boolean endsWith;
	
	protected Boolean isRegex;
	
    protected String sortOn;
    
    protected SortOrder sortOrder;


	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
	}

	public Integer getPageStart() {
		return pageStart;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSearchOn() {
		return searchOn;
	}

	public void setSearchOn(String searchOn) {
		this.searchOn = searchOn;
	}
	
	public Boolean getStartsWith() {
		return startsWith;
	}

	public void setStartsWith(Boolean startsWithWildCard) {
		this.startsWith = startsWithWildCard;
	}

	public Boolean getEndsWith() {
		return endsWith;
	}

	public void setEndsWith(Boolean endsWith) {
		this.endsWith = endsWith;
	}

	public Boolean getIsRegex() {
		return isRegex;
	}

	public void setIsRegex(Boolean isRegex) {
		this.isRegex = isRegex;
	}
	
	public Integer getPageCount() {
		return pageCount;
	}

	public String getSortOn() {
		return sortOn;
	}

	public void setSortOn(String sortOn) {
		this.sortOn = sortOn;
	}

	public SortOrder getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(SortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = super.getQueryParams();
		addParam(qparams, "pageStart", pageStart);
		addParam(qparams, "pageCount", pageCount);
		addParam(qparams, "search", search);
		addParam(qparams, "searchOn", searchOn);
		addParam(qparams, "startsWith", startsWith);
		addParam(qparams, "endsWith", endsWith);
		addParam(qparams, "isRegex", isRegex);
		addParam(qparams, "sortOn", sortOn);
		addParam(qparams, "sortOrder", sortOrder == null ? null : sortOrder.getValue());

		return qparams;
		
	}

}
