package com.genability.client.types;

import java.io.Serializable;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
	private String profileId;

	/**
	 * private member variable for QuantityUnit.
	 */
	private String quantityUnit;

	/**
	 * private member variable for fromDateTime.
	 */
	private DateTime fromDateTime;

	/**
	 * private member variable for toDateTime.
	 */
	private DateTime toDateTime;

	/**
	 * private member variable for NumberOfReadings.
	 */
	private Integer numberOfReadings;

	/**
	 * private member variable for MeanIntervalTime.
	 */
	private Long meanIntervalTime;

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
		return profileId;
	}

	/**
	 * Mutator for ProfileId.
	 */
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	/**
	 * Access method for QuantityUnit.
	 */
	public String getQuantityUnit() {
		return quantityUnit;
	}

	/**
	 * Mutator for QuantityUnit.
	 */
	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	/**
	 * @return the fromDateTime
	 */
	@JsonIgnore
	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	/**
	 * @param fromDateTime
	 *            the fromDateTime to set
	 */
	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	/**
	 * @return the toDateTime
	 */
	@JsonIgnore
	public DateTime getToDateTime() {
		return toDateTime;
	}

	/**
	 * @param toDateTime
	 *            the toDateTime to set
	 */
	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	/**
	 * @return the numberOfReadings
	 */
	public Integer getNumberOfReadings() {
		return numberOfReadings;
	}

	/**
	 * @param numberOfReadings
	 *            the numberOfReadings to set
	 */
	public void setNumberOfReadings(Integer numberOfReadings) {
		this.numberOfReadings = numberOfReadings;
	}

	/**
	 * @return the meanIntervalTime
	 */
	@JsonIgnore
	public Long getMeanIntervalTime() {
		return meanIntervalTime;
	}

	/**
	 * @param meanIntervalTime
	 *            the meanIntervalTime to set
	 */
	public void setMeanIntervalTime(Long meanIntervalTime) {
		this.meanIntervalTime = meanIntervalTime;
	}

}
