package com.genability.client.types;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PagedList<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	protected PaginationInfo paginationInfo_;

	protected List<T> list_;

	protected boolean isPaginated_;

	public PagedList() {
		super();
		this.paginationInfo_ = new PaginationInfo();
		this.isPaginated_ = false;
	}

	public PagedList(List<T> list) {
		super();
		this.paginationInfo_ = new PaginationInfo();
		this.isPaginated_ = false;
		this.list_ = list;
		if (list != null)
			this.paginationInfo_.setTotalCount(this.list_.size());
	}

	public PagedList(PaginationInfo paginationInfo) {
		super();
		if (paginationInfo == null) {
			this.paginationInfo_ = new PaginationInfo();
			this.isPaginated_ = false;
		} else {
			this.paginationInfo_ = paginationInfo;
			this.isPaginated_ = true;
		}
	}

	public PagedList(List<T> list, PaginationInfo paginationInfo) {
		this.list_ = list;
		if (paginationInfo == null) {
			this.paginationInfo_ = new PaginationInfo();
			this.isPaginated_ = false;
			if (list != null)
				this.paginationInfo_.setTotalCount(this.list_.size());
		} else {
			this.paginationInfo_ = paginationInfo;
			this.isPaginated_ = true;
		}
	}

	public PaginationInfo getPaginationInfo() {
		return paginationInfo_;
	}

	public void setPaginationInfo(PaginationInfo paginationInfo) {
		this.paginationInfo_ = paginationInfo;
		this.isPaginated_ = (paginationInfo == null ? false : true);
	}

	public int getTotalCount() {
		return paginationInfo_.getTotalCount();
	}

	public int getPageCount() {
		return paginationInfo_.getPageCount();
	}

	public void setPageCount(int pageCount) {
		this.paginationInfo_.setPageCount(pageCount);
	}

	public int getPageStart() {
		return paginationInfo_.getPageStart();
	}

	public void setPageStart(int pageStart) {
		this.paginationInfo_.setPageStart(pageStart);
	}

	public List<T> getList() {
		return list_;
	}

	public void setList(List<T> list) {
		this.list_ = list;
	}

	public void addAll(PagedList<T> list) {
		this.list_.addAll(list.getList());
	}
} // end of class PagedList