package com.genability.client.types;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeOfUseGroup {

	private Long touGroupId;
	private Long lseId;
	private List<TimeOfUse> timeOfUses;

	public Long getTouGroupId() {
		return touGroupId;
	}

	public void setTouGroupId(Long timeOfUseGroupId) {
		touGroupId = timeOfUseGroupId;
	}

	public Long getLseId() {
    	return lseId;
    }

    public void setLseId(Long lseId) {
    	this.lseId = lseId;
    }

	public List<TimeOfUse> getTimeOfUses() {
		return timeOfUses;
	}

	public void setTimeOfUses(List<TimeOfUse> timeOfUses) {
		this.timeOfUses = timeOfUses;
	}
}