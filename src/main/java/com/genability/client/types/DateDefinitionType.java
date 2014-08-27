package com.genability.client.types;

public enum DateDefinitionType {
	/**
	 * Indicates an FIXED_DATE value.
	 */
	FIXED_DATE(1),
	/**
	 * Indicates an MANUAL value.
	 */
	MANUAL(2),
	/**
	 * Indicates an FLOATING_DATE value.
	 */
	FLOATING_DATE(4),
	/**
	 * Indicates an EASTER_DATE value.
	 */
	EASTER_DATE(8);

	private int id_;

	/**
	 * Constructor, which takes an int value so that this enum's values can be
	 * flags (in other words support bit operations).
	 */
	DateDefinitionType(int id) {
		this.id_ = id;
	}

	/**
	 * Accessor method for getting at the current bit number of this enum.
	 */
	public int getId() {
		return (this.id_);
	}
}
