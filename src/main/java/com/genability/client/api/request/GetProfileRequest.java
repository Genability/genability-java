package com.genability.client.api.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

public class GetProfileRequest extends AbstractRequest implements Serializable{

	/**
	 * private member variable for serial version
	 */
	private static final long serialVersionUID = 1L;
	
		
	/**
	 * Use this constant for the groupBy value when you want to group readings
	 * annually.
	 */
	public static final String GROUP_BY_YEAR = "YEAR";

	/**
	 * Use this constant for the groupBy value when you want to group readings
	 * monthly.
	 */
	public static final String GROUP_BY_MONTH = "MONTH";

	/**
	 * Use this constant for the groupBy value when you want to group readings
	 * daily.
	 */
	public static final String GROUP_BY_DAY = "DAY";

	/**
	 * Use this constant for the groupBy value when you want to group readings
	 * hourly.
	 */
	public static final String GROUP_BY_HOUR = "HOUR";
	
	/**
	 * Use this constant for the groupBy value when you want to group readings
	 * into quarter-hour increments.
	 */
	public static final String GROUP_BY_QTRHOUR = "QTRHOUR";
	
	
	public static final String CLIP_OUTER = "OUTER";
	
	
	public static final String CLIP_INNER = "INNER";
	
	
	public static final String CLIP_NONE = "NONE";
	
	
	public static long QuaterHourMillis = 900000;
	
	public static long HourMillis = 3600000;
	
	private String usageProfileId;

	/**
	 * private member variable for FromDate
	 */
	private DateTime fromDateTime_;

	/**
	 * private member variable for ToDate
	 */
	private DateTime toDateTime_;

	/**
	 * private member variable for PopulateReadingdata
	 */
	private Boolean populateUsageData_;

	/**
	 * private member variable for deriveDemand
	 */
	private Boolean deriveDemand_;

	/**
	 * Private member holding optional group-by argument.
	 */
	private String groupBy;

	/**
	 * Private member holding optional clip-by argument.
	 */
	private String clipBy;


	public String getUsageProfileId() {
		return usageProfileId;
	}

	public void setUsageProfileId(String usageProfileId) {
		this.usageProfileId = usageProfileId;
	}

	/**
	 * @param date
	 *            the fromDate to set
	 */
	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime_ = fromDateTime;
	}

	/**
	 * @return the fromDate
	 */
	public DateTime getFromDateTime() {
		return fromDateTime_;
	}

	/**
	 * @param toDate
	 *            the toDate to set
	 */
	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime_ = toDateTime;
	}

	/**
	 * @return the toDate
	 */
	public DateTime getToDateTime() {
		return toDateTime_;
	}

	/**
	 * @return the populateReadingData
	 */
	public Boolean getPopulateUsageData() {
		return populateUsageData_;
	}

	/**
	 * @param populateReadingData
	 *            the populateReadingData to set
	 */
	public void setPopulateUsageData(Boolean populateUsageData) {
		populateUsageData_ = populateUsageData;
	}
	
	/**
	 * @return the populateReadingData
	 */
	public Boolean getDeriveDemand() {
		return deriveDemand_;
	}

	/**
	 * @param populateReadingData
	 *            the populateReadingData to set
	 */
	public void setDeriveDemand(Boolean deriveDemand) {
		deriveDemand_ = deriveDemand;
	}

	public String getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}

	public String getClipBy() {
		return clipBy;
	}

	public void setClipBy(String clipBy) {
		this.clipBy = clipBy;
	}

	public String getGroupReadingsBy() {
		return groupBy;
	}

	public void setGroupReadingsBy(String groupReadingsBy) {
		this.groupBy = groupReadingsBy;
	}

	@Override
	public List<NameValuePair> getQueryParams() {
		
		List<NameValuePair> qparams = new ArrayList<NameValuePair>();
		
		addParam(qparams,"fromDateTime", fromDateTime_);
		addParam(qparams,"toDateTime",toDateTime_);
		addParam(qparams,"populateUsageData",populateUsageData_);
		addParam(qparams,"groupBy",groupBy);
		addParam(qparams,"clipBy",clipBy);
		return qparams;
		
	}	
} // end of class GetProfileRestRequest
