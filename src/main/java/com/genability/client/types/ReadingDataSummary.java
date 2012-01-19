package com.genability.client.types;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.joda.time.DateTime;


/**
 * 
 */
public class ReadingDataSummary implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	
	/**
	 * private member variable for ProfileId.
	 */
	private String profileId_;

	/**
	 * private member variable for QuantityUnit.
	 */
	private String quantityUnit_;

	/**
	 * private member variable for fromDateTime.
	 */
	private DateTime fromDateTime_;

	/**
	 * private member variable for toDateTime.
	 */
	private DateTime toDateTime_;

	/**
	 * private member variable for NumberOfReadings.
	 */
	private Integer numberOfReadings_;

	/**
	 * private member variable for MeanIntervalTime.
	 */
	private Long meanIntervalTime_;

	/**
	 * This is the default constructor.
	 */
	public ReadingDataSummary() {

	}

	/**
	 * Access method for ProfileId.
	 */
	@JsonIgnore
	public String getProfileId() {
		return profileId_;
	}

	/**
	 * Mutator for ProfileId.
	 */
	public void setProfileId(String profileId_) {
		this.profileId_ = profileId_;
	}

	/**
	 * Access method for QuantityUnit.
	 */
	public String getQuantityUnit() {
		return quantityUnit_;
	}

	/**
	 * Mutator for QuantityUnit.
	 */
	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit_ = quantityUnit;
	}

	/**
	 * @return the fromDateTime
	 */
	@JsonIgnore
	public DateTime getFromDateTime() {
		return fromDateTime_;
	}

	/**
	 * @param fromDateTime
	 *            the fromDateTime to set
	 */
	public void setFromDateTime(DateTime fromDateTime) {
		fromDateTime_ = fromDateTime;
	}

	/**
	 * @return the toDateTime
	 */
	@JsonIgnore
	public DateTime getToDateTime() {
		return toDateTime_;
	}

	/**
	 * @param toDateTime
	 *            the toDateTime to set
	 */
	public void setToDateTime(DateTime toDateTime) {
		toDateTime_ = toDateTime;
	}

	/**
	 * @return the numberOfReadings
	 */
	public Integer getNumberOfReadings() {
		return numberOfReadings_;
	}

	/**
	 * @param numberOfReadings
	 *            the numberOfReadings to set
	 */
	public void setNumberOfReadings(Integer numberOfReadings) {
		numberOfReadings_ = numberOfReadings;
	}

	/**
	 * @return the meanIntervalTime
	 */
	@JsonIgnore
	public Long getMeanIntervalTime() {
		return meanIntervalTime_;
	}

	/**
	 * @param meanIntervalTime
	 *            the meanIntervalTime to set
	 */
	public void setMeanIntervalTime(Long meanIntervalTime) {
		meanIntervalTime_ = meanIntervalTime;
	}

}
