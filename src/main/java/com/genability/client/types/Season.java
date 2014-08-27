package com.genability.client.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Season {

  private Long seasonId;
  private Long lseId;
  private Long seasonGroupId;
  private String seasonName;
  private Integer seasonFromMonth;
  private Integer seasonFromDay;
  private Integer seasonToMonth;
  private Integer seasonToDay;
  
  public Long getSeasonId() {
    return seasonId;
  }
  
  public void setSeasonId(Long seasonId) {
    this.seasonId = seasonId;
  }
  
  public Long getLseId() {
    return lseId;
  }
  
  public void setLseId(Long lseId) {
    this.lseId = lseId;
  }
  
  public Long getSeasonGroupId() {
    return seasonGroupId;
  }
  
  public void setSeasonGroupId(Long seasonGroupId) {
    this.seasonGroupId = seasonGroupId;
  }
  
  public String getSeasonName() {
    return seasonName;
  }
  
  public void setSeasonName(String seasonName) {
    this.seasonName = seasonName;
  }
  
  public Integer getSeasonFromMonth() {
    return seasonFromMonth;
  }
  
  public void setSeasonFromMonth(Integer seasonFromMonth) {
    this.seasonFromMonth = seasonFromMonth;
  }
  
  public Integer getSeasonFromDay() {
    return seasonFromDay;
  }
  
  public void setSeasonFromDay(Integer seasonFromDay) {
    this.seasonFromDay = seasonFromDay;
  }
  
  public Integer getSeasonToMonth() {
    return seasonToMonth;
  }
  
  public void setSeasonToMonth(Integer seasonToMonth) {
    this.seasonToMonth = seasonToMonth;
  }
  
  public Integer getSeasonToDay() {
    return seasonToDay;
  }
  
  public void setSeasonToDay(Integer seasonToDay) {
    this.seasonToDay = seasonToDay;
  }

  
}
