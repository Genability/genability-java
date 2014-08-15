package com.genability.client.types;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TimeOfUse {

  private Integer touId;
  private Integer touGroupId;
  private Long lseId;
  private String touName;
  private Integer calendarId;
  private Boolean isDynamic;
  private Season season;
  private String touType;
  private List<TimeOfUsePeriod> touPeriods;
  
  public Integer getTouId() {
    return touId;
  }
  
  public void setTouId(Integer touId) {
    this.touId = touId;
  }
  
  public Integer getTouGroupId() {
    return touGroupId;
  }
  
  public void setTouGroupId(Integer touGroupId) {
    this.touGroupId = touGroupId;
  }
  
  public Long getLseId() {
    return lseId;
  }
  
  public void setLseId(Long lseId) {
    this.lseId = lseId;
  }
  
  public String getTouName() {
    return touName;
  }
  
  public void setTouName(String touName) {
    this.touName = touName;
  }
  
  public Integer getCalendarId() {
    return calendarId;
  }
  
  public void setCalendarId(Integer calendarId) {
    this.calendarId = calendarId;
  }
  
  public Boolean getIsDynamic() {
    return isDynamic;
  }
  
  public void setIsDynamic(Boolean isDynamic) {
    this.isDynamic = isDynamic;
  }
  
  public Season getSeason() {
    return season;
  }
  
  public void setSeason(Season season) {
    this.season = season;
  }
  
  public String getTouType() {
    return touType;
  }
  
  public void setTouType(String touType) {
    this.touType = touType;
  }
  
  public List<TimeOfUsePeriod> getTouPeriods() {
    return touPeriods;
  }
  
  public void setTouPeriods(List<TimeOfUsePeriod> touPeriods) {
    this.touPeriods = touPeriods;
  }
  
}
