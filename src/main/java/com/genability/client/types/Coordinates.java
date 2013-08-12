package com.genability.client.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Coordinates {
  
  private double latitude;
  private double longitude;
  
  public double getLatitude() {
    return latitude;
  }
  
  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }
  
  public double getLongitude() {
    return longitude;
  }
  
  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }
  
  @Override
  public String toString() {
    return "[lat:" + latitude + ", lon:" + longitude + "]";
  }
  
}
