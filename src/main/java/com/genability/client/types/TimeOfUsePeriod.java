package com.genability.client.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeOfUsePeriod {

  private Integer touPeriodId;
  private Integer touId;
  private Integer fromDayOfWeek;
  private Integer fromHour;
  private Integer fromMinute;
  private Integer toDayOfWeek;
  private Integer toHour;
  private Integer toMinute;
  
  public Integer getTouPeriodId() {
    return touPeriodId;
  }
  
  public void setTouPeriodId(Integer touPeriodId) {
    this.touPeriodId = touPeriodId;
  }
  
  public Integer getTouId() {
    return touId;
  }
  
  public void setTouId(Integer touId) {
    this.touId = touId;
  }
  
  public Integer getFromDayOfWeek() {
    return fromDayOfWeek;
  }
  
  public void setFromDayOfWeek(Integer fromDayOfWeek) {
    this.fromDayOfWeek = fromDayOfWeek;
  }
  
  public Integer getFromHour() {
    return fromHour;
  }
  
  public void setFromHour(Integer fromHour) {
    this.fromHour = fromHour;
  }
  
  public Integer getFromMinute() {
    return fromMinute;
  }
  
  public void setFromMinute(Integer fromMinute) {
    this.fromMinute = fromMinute;
  }
  
  public Integer getToDayOfWeek() {
    return toDayOfWeek;
  }
  
  public void setToDayOfWeek(Integer toDayOfWeek) {
    this.toDayOfWeek = toDayOfWeek;
  }
  
  public Integer getToHour() {
    return toHour;
  }
  
  public void setToHour(Integer toHour) {
    this.toHour = toHour;
  }
  
  public Integer getToMinute() {
    return toMinute;
  }
  
  public void setToMinute(Integer toMinute) {
    this.toMinute = toMinute;
  }

}
