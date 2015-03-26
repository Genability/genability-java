package com.genability.client.types;

public class PaginationInfo {

	private int totalCount;
	private int pageCount;
	private int pageStart;

	public int getEndIndex() {
		int min = pageStart + pageCount;
		if (min > totalCount) {
			min = totalCount;
		}
		return min;
	}

	/**
	 * Default zero argument constructor.
	 */
	public PaginationInfo() {
		super();
	}

	public String toString() {
		try {
			return "<" + getClass().getSimpleName()
					+ " pageStart:" + pageStart
					+ " pageCount:" + pageCount
					+ " totalCount:" + totalCount
					+ ">";
		} catch (Exception e) {
			return super.toString();
		}
	}

	/**
	 * Set the totalCount.
	 *
	 * @param totalCount
	 */
	public PaginationInfo(int totalCount) {
		super();
		this.totalCount = totalCount;
	}
	
	/**
	 * Set the pageCount and pageStart.
	 * 
	 * @param pageCount
	 * @param pageStart
	 */
	public PaginationInfo(int pageCount, int pageStart) {
		super();
		this.pageCount = pageCount;
		this.pageStart = pageStart;
	}

	/**
	 * Set the totalCount, pageCount and pageStart.
	 *
	 * @param totalCount
	 * @param pageCount
	 * @param pageStart
	 */
	public PaginationInfo(int totalCount, int pageCount, int pageStart) {
		super();
		this.totalCount = totalCount;
		this.pageCount = pageCount;
		this.pageStart = pageStart;
	}
	
	/**
	 * This returns the total count of all records that match the
	 * search (query) criteria. If the results were paginated, this
	 * will likely be greater that the count of actual results
	 * returned.
	 * @return total records matching the criteria
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * This sets the total count of all records that match the 
	 * search criteria.
	 * @param totalCount total record count
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * This returns the number of records that are in (or
	 * should be in) the "page" that is returned. For instance
	 * if the query should return the first 10 records of
	 * the total, this will be 10.
	 * 
	 * @return
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * Use this to set the number of records that should
	 * be returned in one "page" of the results. For instance,
	 * to return the 16th to the 30th record, this should be set
	 * to 15.
	 * @param pageCount records in the "page"
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * This is the value of where the "pages" records
	 * start.
	 * @return record count where page starts
	 */
	public int getPageStart() {
		return pageStart;
	}

	/**
	 * Set the value where you wish the requested page
	 * to start. For instance, if you want the 3rd
	 * page of a total record set, where the page size is
	 * 10, this value would be 20 (since 0 give records
	 * 1 to 10, 10 give 11 to 20, and 20 gives 21 to 30 which
	 * is the 3rd page).
	 * 
	 * @param pageStart start of requested page
	 */
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

}
