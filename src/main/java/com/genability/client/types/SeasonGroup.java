package com.genability.client.types;

import java.util.List;

public class SeasonGroup {

  private Long seasonGroupId;
  private List<Season> seasons;
  
  public Long getSeasonGroupId() {
    return seasonGroupId;
  }
  
  public void setSeasonGroupId(Long seasonGroupId) {
    this.seasonGroupId = seasonGroupId;
  }
  
  public List<Season> getSeasons() {
    return seasons;
  }
  
  public void setSeasons(List<Season> seasons) {
    this.seasons = seasons;
  }
  
}
