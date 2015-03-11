package com.genability.client.types;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeasonGroup {

	private Long lseId;
	private Long seasonGroupId;
	private List<Season> seasons;

	public Long getLseId() {
		return lseId;
	}

	public void setLseId(final Long lseId) {
		this.lseId = lseId;
	}

	public Long getSeasonGroupId() {
		return seasonGroupId;
	}

	public void setSeasonGroupId(final Long seasonGroupId) {
		this.seasonGroupId = seasonGroupId;
	}

	public List<Season> getSeasons() {
		return seasons;
	}

	public void setSeasons(final List<Season> seasons) {
		this.seasons = seasons;
	}

}
