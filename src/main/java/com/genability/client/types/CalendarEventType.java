package com.genability.client.types;

public enum CalendarEventType {

	HOLIDAY(1),
	BILLING(2),
	PRICING_PERIOD(4);

	private int id_;

	/**
	 * Constructor, which takes an int value so that this enum's values can be
	 * flags (in other words support bit operations).
	 * 
	 * @param id
	 */
	CalendarEventType(int id) {
		this.id_ = id;
	}

	/**
	 * Accessor method for getting at the current bit number of this enum.
	 * 
	 * @return
	 */
	public int getId() {
		return (this.id_);
	}

	/**
	 * Converts the int value passed in into a valid Enum value, or returns null
	 * if the int value passed in doesn't yield a match.
	 * 
	 * @param id
	 *            to convert
	 * @return Enum value converted
	 */
	public static CalendarEventType convert(final int id) {
		for (CalendarEventType e : CalendarEventType.values()) {
			if (e.id_ == id) {
				return e;
			}
		}
		return null;
	}
}
