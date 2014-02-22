package com.genability.client.types;

public enum SortOrder {

  ASCENDING("ASC"), DESCENDING("DESC");

  private final String value;

  private SortOrder(final String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

}
