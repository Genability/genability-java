package com.genability.client.types;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Fields {

	DEFAULT("std"), MIN("min"), EXT("ext");


  private final String value;

  private Fields(final String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }


	private static final Map<String, Fields> LOOKUP;

	static {
		final Map<String, Fields> _lookup = new HashMap<String, Fields>();
		for (Fields fields : Fields.values()) {
			_lookup.put(fields.getValue(), fields);
		}
		LOOKUP = Collections.unmodifiableMap(_lookup);
	}

  @JsonCreator
  public static Fields forValue(String value) {
  	Fields fields = LOOKUP.get(value.toLowerCase());
  	if (fields == null) {
  		fields = Fields.valueOf(value);
  	}
  	return fields;
  }

}
