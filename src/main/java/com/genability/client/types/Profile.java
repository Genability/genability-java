package com.genability.client.types;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile implements Serializable {

	public static final String REST_TYPE = "UsageProfile";
	private static final long serialVersionUID = 1L;

	private String profileId;
	private String providerProfileId;
	private String profileName;
	private String providerAccountId;
	private String accountId;
	private String meterId;
	private String providerOrgId;
	private String description;
	private Source source;
	private List<ReadingDataSummary> readingDataSummaries;
	private List<ReadingData> readingData;
	private List<BaselineMeasure> baselineMeasures;
	private PagedList<IntervalInfo> intervals;
	private PagedList<ReadingData> readings;
	private Map<String, PropertyData> properties;
	//private PagedList<Bill> bills; // TODO: implement this

	/**
	 * Private member indicating if this profiles interval and other
	 * pre-calculated/cached data is current.
	 */
	private Integer dataStatus;
	private Boolean isDefault;
	private String serviceTypes;

	/**
	 * This is the default constructor.
	 */
	public Profile() {
		// no-op

	} // end of constructor

	/**
	 * This is the constructor that sets the primary key information on
	 * construction. In other words, it sets the property.
	 */
	public Profile(final String profileId) {
		this.profileId = profileId;

	} // end of constructor

	/**
	 * Access method for ProfileId.
	 */
	public String getProfileId() {
		return profileId;
	}

	/**
	 * Mutator for ProfileId.
	 */
	public void setProfileId(final String profileId) {
		this.profileId = profileId;
	}

	/**
	 * Access method for ProviderProfileId.
	 */
	public String getProviderProfileId() {
		return providerProfileId;
	}

	/**
	 * Mutator for ProviderProfileId.
	 */
	public void setProviderProfileId(final String providerProfileId) {
		this.providerProfileId = providerProfileId;
	}

	/**
	 * Access method for ProfileName.
	 */
	public String getProfileName() {
		return profileName;
	}

	/**
	 * Mutator for ProfileName.
	 */
	public void setProfileName(final String profileName) {
		this.profileName = profileName;
	}

	/**
	 * Access method for Description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Mutator for Description.
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	@JsonIgnore
	public String getSourceString() {
		return source.getSourceId();
	}
	
	@JsonIgnore
	public void setSourceString(final String sourceId) {
		Source newSource = new Source();
		newSource.setSourceId(sourceId);
		
		this.source = newSource;
	}

	public Source getSource() {
		return source;
	}
	
	public void setSource(final Source source) {
		this.source = source;
	}

	/**
	 * @return the readingDataSummaries
	 */
	public List<ReadingDataSummary> getReadingDataSummaries() {
		return readingDataSummaries;
	}

	/**
	 * @param readingDataSummaries
	 *            the readingDataSummaries to set
	 */
	public void setReadingDataSummaries(
			List<ReadingDataSummary> readingDataSummaries) {
		this.readingDataSummaries = readingDataSummaries;
	}

	/**
	 * Access method for ReadingData.
	 */
	public List<ReadingData> getReadingData() {
		return readingData;
	}

	/**
	 * Mutator method for ReadingData.
	 */
	public void setReadingData(final List<ReadingData> readingData) {
		this.readingData = readingData;
	}

	public List<BaselineMeasure> getBaselineMeasures() {
		return baselineMeasures;
	}

	public void setBaselineMeasures(final List<BaselineMeasure> baselineMeasures) {
		this.baselineMeasures = baselineMeasures;
	}

	/**
	 * Access method for Readings.
	 * 
	 * @return
	 */
	public PagedList<ReadingData> getReadings() {
		return readings;
	}

	/**
	 * Mutator method for Readings.
	 */
	public void setReadings(final PagedList<ReadingData> readings) {
		this.readings = readings;
	}

	/**
	 * Access method for Intervals.
	 * 
	 * @return
	 */
	public PagedList<IntervalInfo> getIntervals() {
		return intervals;
	}

	/**
	 * Mutator method for Intervals.
	 */
	public void setIntervals(final PagedList<IntervalInfo> intervals) {
		this.intervals = intervals;
	}

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 *            the accountId to set
	 */
	public void setAccountId(final String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the accountId
	 */
	public String getProviderAccountId() {
		return providerAccountId;
	}

	/**
	 * @param accountId
	 *            the accountId to set
	 */
	public void setProviderAccountId(final String providerAccountId) {
		this.providerAccountId = providerAccountId;
	}

	/**
	 * This is the Genability ID of the provider of this account.
	 * 
	 * @return
	 */
	@JsonIgnore
	public String getProviderOrgId() {
		return providerOrgId;
	}

	/**
	 * Use this to set the Genability ID of the provider of this account. This
	 * field is maintained (or at least validated) by server side code so that
	 * it cannot be populated erroneously by a different provider.
	 * 
	 * @param providerOrgId
	 */
	public void setProviderOrgId(final String providerOrgId) {
		this.providerOrgId = providerOrgId;
	}

	/**
	 * This holds the status of the cached/pre-calculated interval data.
	 * 
	 * @return
	 */
	@JsonIgnore
	public Integer getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(final Integer dataStatus) {
		this.dataStatus = dataStatus;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(final Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public String getServiceTypes() {
		return serviceTypes;
	}

	public void setServiceTypes(final String serviceTypes) {
		this.serviceTypes = serviceTypes;
	}

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(final String meterId) {
		this.meterId = meterId;
	}

	public Map<String, PropertyData> getProperties() {
		return properties;
	}

	public void setProperties(final Map<String, PropertyData> properties) {
		this.properties = properties;
	}

	/**
	 * Pass in a quantityUnit value and this will tell you whether there is 1 or
	 * more readings for it.
	 * 
	 * @param quantityUnit
	 * @return true if has readings, false otherwise
	 */
	public boolean hasReadingsFor(String quantityUnit) {

		if (quantityUnit == null || quantityUnit.isEmpty())
			return false;
		if (this.readingDataSummaries == null)
			return false;

		for (ReadingDataSummary summary : this.getReadingDataSummaries()) {
			if (quantityUnit.equals(summary.getQuantityUnit())
					&& summary.getNumberOfReadings() != null
					&& summary.getNumberOfReadings() > 0)
				return true;
		}
		return false;

	} // end of hasReadingsFor

	/**
	 * Implementation of the compareTo.
	 * 
	 * @param anotherClass
	 * @return
	 * @throws ClassCastException
	 */
	public int compareTo(Object anotherClass) throws ClassCastException {

		if (!(anotherClass instanceof Profile)) {
			throw new ClassCastException("Object is not Profile expected.");
		}
		return this.profileId
				.compareTo(((Profile) anotherClass).getProfileId());

	}

	/**
	 * Helper method to make a copy of the profile. Note it doesn't make a copy
	 * of the readings, reading summaries, or properties
	 * 
	 * @param anotherProfile
	 *            to copy data into
	 * @return void
	 */
	public void copy(Profile toCopyToProfile) {
		toCopyToProfile.setProfileId(this.profileId);
		toCopyToProfile.setProviderProfileId(this.providerProfileId);
		toCopyToProfile.setProfileName(this.profileName);
		toCopyToProfile.setAccountId(this.accountId);
		toCopyToProfile.setProviderAccountId(this.providerAccountId);
		toCopyToProfile.setProviderOrgId(this.providerOrgId);
		toCopyToProfile.setDescription(this.description);
		toCopyToProfile.setSource(this.source);
		toCopyToProfile.setIsDefault(this.isDefault);
		toCopyToProfile.setMeterId(this.meterId);
	}

} // end of class Profile

