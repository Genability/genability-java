package com.genability.client.api.request;

import java.io.Serializable;
import java.util.List;

import org.apache.http.NameValuePair;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.genability.client.types.ClipBy;
import com.genability.client.types.GroupBy;

public class GetProfileRequest extends AbstractGetNRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String profileId;
	private String providerProfileId;

	private DateTime fromDateTime;
	private DateTime toDateTime;

	private Boolean populateReadings;
	private Boolean populateBaseline;

	private Boolean deriveDemand;
	private Boolean deriveConsumption;
	private Long demandInterval;

	private GroupBy groupBy;
	private ClipBy clipBy;

	private Boolean autoBaseline;
	private Boolean useIntelligentBaselining;


	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public void setFromDateTime(DateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public DateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setToDateTime(DateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	public DateTime getToDateTime() {
		return toDateTime;
	}

	public Boolean getPopulateReadings() {
		return populateReadings;
	}

	public void setPopulateReadings(Boolean populateReadings) {
		this.populateReadings = populateReadings;
	}
	
	public Boolean getPopulateBaseline() {
		return populateBaseline;
	}

	public void setPopulateBaseline(Boolean populateBaseline) {
		this.populateBaseline = populateBaseline;
	}

	public Boolean getDeriveDemand() {
		return deriveDemand;
	}

	public void setDeriveDemand(Boolean deriveDemand) {
		this.deriveDemand = deriveDemand;
	}

	public Boolean getDeriveConsumption() {
		return deriveConsumption;
	}

	public void setDeriveConsumption(Boolean deriveConsumption) {
		this.deriveConsumption = deriveConsumption;
	}

	public Long getDemandInterval() {
		return demandInterval;
	}

	public void setDemandInterval(Long demandInterval) {
		this.demandInterval = demandInterval;
	}

	public GroupBy getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(GroupBy groupBy) {
		this.groupBy = groupBy;
	}

	public ClipBy getClipBy() {
		return clipBy;
	}

	public void setClipBy(ClipBy clipBy) {
		this.clipBy = clipBy;
	}

	public String getProviderProfileId() {
		return providerProfileId;
	}

	public void setProviderProfileId(String providerProfileId) {
		this.providerProfileId = providerProfileId;
	}

	public Boolean getAutoBaseline() {
		return autoBaseline;
	}

	public void setAutoBaseline(Boolean autoBaseline) {
		this.autoBaseline = autoBaseline;
	}

	public Boolean getUseIntelligentBaselining() {
		return useIntelligentBaselining;
	}

	public void setUseIntelligentBaselining(Boolean useIntelligentBaselining) {
		this.useIntelligentBaselining = useIntelligentBaselining;
	}

	@Override
	@JsonIgnore
	public List<NameValuePair> getQueryParams() {
		List<NameValuePair> qparams = super.getQueryParams();
		
		addParam(qparams,"fromDateTime", fromDateTime);
		addParam(qparams,"toDateTime",toDateTime);
		addParam(qparams,"populateReadings",populateReadings);
		addParam(qparams,"populateBaseline",populateBaseline);
		addParam(qparams,"groupBy",groupBy);
		addParam(qparams,"clipBy",clipBy);
		addParam(qparams, "autoBaseline", autoBaseline);
		addParam(qparams, "useIntelligentBaselining", useIntelligentBaselining);
		return qparams;
	}
}
