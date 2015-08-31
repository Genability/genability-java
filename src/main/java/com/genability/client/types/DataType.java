package com.genability.client.types;

import java.util.EnumMap;

public enum DataType {

	STRING(1),
	CHOICE(2),
	BOOLEAN(4),
	DATE(8),
	DECIMAL(16),
	INTEGER(32),
	FORMULA(64),
	LOOKUP(128),
	DEMAND(256);
	
	private int id;

	/**
	 * Constructor, which takes an int value so that this enum's values can be
	 * flags (in other words support bit operations).
	 * 
	 * @param id The id.
	 */
	DataType(int id) {
		this.id = id;
	}

	/**
	 * Accessor method for getting at the current bit number of this enum.
	 * 
	 * @return The return value.
	 */
	public int getId() {
		return (this.id);
	}

	/**
	 * Converts the int value passed in into a valid Enum value, or returns null
	 * if the int value passed in doesn't yield a match.
	 * 
	 * @param id The id.
	 *            to convert
	 * @return Enum value converted
	 */
	public static DataType convert(final int id) {
		for (DataType e : DataType.values()) {
			if (e.id == id) {
				return e;
			}
		}
		return null;
	}

	/**
	 * This method returns a map of messages suitable for display purposes. The
	 * maps key is the enumeration value, and the maps value is the
	 * corresponding display string.
	 * 
	 * @return EnumMap of messages
	 */
	public static EnumMap<DataType, String> getMessages() {

		EnumMap<DataType, String> messages = new EnumMap<DataType, String>(
				DataType.class);
		messages.put(DataType.STRING, "STRING");
		messages.put(DataType.CHOICE, "CHOICE");
		messages.put(DataType.BOOLEAN, "BOOLEAN");
		messages.put(DataType.DATE, "DATE");
		messages.put(DataType.DECIMAL, "DECIMAL");
		messages.put(DataType.INTEGER, "INTEGER");
		messages.put(DataType.FORMULA, "FORMULA");
		messages.put(DataType.LOOKUP, "LOOKUP");
		messages.put(DataType.DEMAND, "DEMAND");
		return messages;
	}

}
