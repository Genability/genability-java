package com.genability.client.types;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


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


	public PagedList() {
		super();
		this.paginationInfo_ = new PaginationInfo();
	}

	public PagedList(List<T> list) {
		super();
		this.paginationInfo_ = new PaginationInfo();
		this.list_ = list;
		if (list != null)
			this.paginationInfo_.setTotalCount(this.list_.size());
	}

	public PagedList(PaginationInfo paginationInfo) {
		super();
		if (paginationInfo == null) {
			this.paginationInfo_ = new PaginationInfo();
		} else {
			this.paginationInfo_ = paginationInfo;
		}
	}

	public PagedList(List<T> list, PaginationInfo paginationInfo) {
		this.list_ = list;
		if (paginationInfo == null) {
			this.paginationInfo_ = new PaginationInfo();
			if (list != null)
				this.paginationInfo_.setTotalCount(this.list_.size());
		} else {
			this.paginationInfo_ = paginationInfo;
		}
	}

	public PaginationInfo getPaginationInfo() {
		return paginationInfo_;
	}

	public void setPaginationInfo(PaginationInfo paginationInfo) {
		this.paginationInfo_ = paginationInfo;
	}

	public int getTotalCount() {
		return paginationInfo_.getTotalCount();
	}

	public void setTotalCount(int totalCount) {
		if (paginationInfo_ == null) {
			paginationInfo_ = new PaginationInfo(totalCount);
		} else {
			paginationInfo_.setTotalCount(totalCount);
		}

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