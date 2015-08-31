package com.genability.client.types;

public enum DateDefinitionType {

	FIXED_DATE(1),
	MANUAL(2),
	FLOATING_DATE(4),
	EASTER_DATE(8);

	private int id_;

	/**
	 * Constructor, which takes an int value so that this enum's values can be
	 * flags (in other words support bit operations).
	 * 
	 * @param id The id.
	 */
	DateDefinitionType(int id) {
		this.id_ = id;
	}

	/**
	 * Accessor method for getting at the current bit number of this enum.
	 * 
	 * @return The return value.
	 */
	public int getId() {
		return (this.id_);
	}
}
