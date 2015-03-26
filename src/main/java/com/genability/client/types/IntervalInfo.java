package com.genability.client.types;

import java.util.LinkedHashMap;
import java.util.Map;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IntervalInfo {

	private String id;
	private String profileId;
	private Measure total;
	private Measure kWh;
	private Measure kW;
	private Map<String, Measure> measures;
	private DateTime fromDateTime;
	private DateTime toDateTime;
	private Long duration;

	public IntervalInfo() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public DateTime getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	public Measure getTotal() {
		return total;
	}

	public Measure getkWh() {
		return kWh;
	}

	public void setkWh(Measure kWh) {
		this.kWh = kWh;
	}

	public Measure getkW() {
		return kW;
	}

	public void setkW(Measure kW) {
		this.kW = kW;
	}

	public Map<String, Measure> getMeasures() {
		return measures;
	}

	public void setMeasures(Map<String, Measure> measures) {
		this.measures = measures;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}


	/*************************************************************************
	 * Helper methods below here
	 *************************************************************************/

	/**
	 * Helper method that will populate the measures map with the measure passed
	 * in. If you pass in a kWh, kW or total measure, it will set those specific
	 * fields instead.
	 * 
	 * @param key
	 * @param value
	 */
	public void putMeasure(String key, Measure value) {

		if (key == null || value == null)
			throw new IllegalArgumentException("key or value cannot be null");

		if (ReadingData.KWH_UNIT.equals(key)) {
			this.kWh = value;
		} else if (ReadingData.KW_UNIT.equals(key)) {
			this.kW = value;
		} else {
			if (this.measures == null)
				this.measures = new LinkedHashMap<String, Measure>();
			this.measures.put(key, value);
		}

	} // end of helper putMeasure

	/**
	 * Helper method that will return the measures that matches the key,
	 * including if the key is 'kWh", "kW" or "total". If not found it will
	 * return null.
	 * 
	 * @param key
	 * @return
	 */
	public Measure getMeasure(String key) {

		if (key == null)
			return null;

		if (ReadingData.KWH_UNIT.equals(key)) {
			return this.kWh;
		} else if (ReadingData.KW_UNIT.equals(key)) {
			return this.kW;
		} else if (this.measures == null) {
			return null;
		} else {
			return this.measures.get(key);
		}

	}
}
