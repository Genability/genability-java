package com.genability.client.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Choice {

  private String value;
  private String displayValue;
  
  public String getValue() {
    return value;
  }
  
  public void setValue(String value) {
    this.value = value;
  }
  
  public String getDisplayValue() {
    return displayValue;
  }
  
  public void setDisplayValue(String displayValue) {
    this.displayValue = displayValue;
  }
 
}
