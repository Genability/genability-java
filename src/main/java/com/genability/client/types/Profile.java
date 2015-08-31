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
	private String description;
	private Source source;
	private List<ReadingDataSummary> readingDataSummaries;
	private List<ReadingData> readingData;
	private List<BaselineMeasure> baselineMeasures;
	private PagedList<IntervalInfo> intervals;
	private PagedList<ReadingData> readings;
	private Map<String, PropertyData> properties;
	//private PagedList<Bill> bills; // TODO: implement this

	private Integer dataStatus;
	private Boolean isDefault;
	private String serviceTypes;

	public Profile() {
		// no-op
	}

	public Profile(final String profileId) {
		this.profileId = profileId;

	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(final String profileId) {
		this.profileId = profileId;
	}

	public String getProviderProfileId() {
		return providerProfileId;
	}

	public void setProviderProfileId(final String providerProfileId) {
		this.providerProfileId = providerProfileId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(final String profileName) {
		this.profileName = profileName;
	}

	public String getDescription() {
		return description;
	}

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

	public List<ReadingDataSummary> getReadingDataSummaries() {
		return readingDataSummaries;
	}

	public void setReadingDataSummaries(
			List<ReadingDataSummary> readingDataSummaries) {
		this.readingDataSummaries = readingDataSummaries;
	}

	public List<ReadingData> getReadingData() {
		return readingData;
	}

	public void setReadingData(final List<ReadingData> readingData) {
		this.readingData = readingData;
	}

	public List<BaselineMeasure> getBaselineMeasures() {
		return baselineMeasures;
	}

	public void setBaselineMeasures(final List<BaselineMeasure> baselineMeasures) {
		this.baselineMeasures = baselineMeasures;
	}

	public PagedList<ReadingData> getReadings() {
		return readings;
	}

	public void setReadings(final PagedList<ReadingData> readings) {
		this.readings = readings;
	}

	public PagedList<IntervalInfo> getIntervals() {
		return intervals;
	}

	public void setIntervals(final PagedList<IntervalInfo> intervals) {
		this.intervals = intervals;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(final String accountId) {
		this.accountId = accountId;
	}

	public String getProviderAccountId() {
		return providerAccountId;
	}

	public void setProviderAccountId(final String providerAccountId) {
		this.providerAccountId = providerAccountId;
	}

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
	 * @param quantityUnit The quantityUnit.
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
	 * @param anotherClass The anotherClass.
	 * @return The return value.
	 */
	public int compareTo(Object anotherClass) {

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
	 * @param toCopyToProfile The toCopyToProfile.
	 *            to copy data into
	 */
	public void copy(Profile toCopyToProfile) {
		toCopyToProfile.setProfileId(this.profileId);
		toCopyToProfile.setProviderProfileId(this.providerProfileId);
		toCopyToProfile.setProfileName(this.profileName);
		toCopyToProfile.setAccountId(this.accountId);
		toCopyToProfile.setProviderAccountId(this.providerAccountId);
		toCopyToProfile.setDescription(this.description);
		toCopyToProfile.setSource(this.source);
		toCopyToProfile.setIsDefault(this.isDefault);
		toCopyToProfile.setMeterId(this.meterId);
	}
}

