package com.genability.client.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TimeOfUseType {
	ON_PEAK,
	OFF_PEAK,
	PARTIAL_PEAK,
	CRITICAL_PEAK;
	
	@JsonValue
	public final String getName() {
		return name();
	}
	
	@JsonCreator
	public static TimeOfUseType getTouType(String value) throws IllegalArgumentException {
		for (TimeOfUseType t : TimeOfUseType.values()) {
			if (t.name().equals(value)) {
				return t;
			}
		}
		
		throw new IllegalArgumentException("Couldn't find a valid TimeOfUseType corresponding to " + value);
	}
}
