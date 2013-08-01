package com.genability.client.types;

public enum Fields {

  DEFAULT(null), MIN("min"), EXT("ext");
  
  private final String value;

  private Fields(final String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}
