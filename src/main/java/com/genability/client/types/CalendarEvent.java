package com.genability.client.types;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class CalendarEvent {

	/**
	 * private member variable for CalendarEventId.
	 */
	private Long calendarEventId;

	/**
	 * private member variable for CalendarEventName.
	 */
	private String calendarEventName;

	/**
	 * private member variable for LseId.
	 */
	private Long lseId;

	/**
	 * private member variable for CalendarEventType.
	 */
	private CalendarEventType calendarEventType;

	/**
	 * private member variable for DateDefinitionType.
	 */
	private DateDefinitionType dateDefinitionType;

	/**
	 * private member variable for Locale.
	 */
	private String locale;

	/**
	 * private member variable for SeededUntil.
	 */
	private Date seededUntil;

	/**
	 * private member variable for FixedMonth.
	 */
	private Integer fixedMonth;

	/**
	 * private member variable for FixedDay.
	 */
	private Integer fixedDay;

	/**
	 * private member variable for DayOfWeek.
	 */
	private Integer dayOfWeek;

	/**
	 * private member variable for WeekOfMonth.
	 */
	private Integer weekOfMonth;

	/**
	 * private member variable for Adjustment.
	 */
	private Integer adjustment;


	public Long getCalendarEventId() {
		return calendarEventId;
	}

	public void setCalendarEventId(Long calendarEventId) {
		this.calendarEventId = calendarEventId;
	}

	public String getCalendarEventName() {
		return calendarEventName;
	}

	public void setCalendarEventName(String calendarEventName) {
		this.calendarEventName = calendarEventName;
	}

	public Long getLseId() {
		return lseId;
	}

	public void setLseId(Long lseId) {
		this.lseId = lseId;
	}

	public CalendarEventType getCalendarEventType() {
		return calendarEventType;
	}

	public void setCalendarEventType(CalendarEventType calendarEventType) {
		this.calendarEventType = calendarEventType;
	}

	public DateDefinitionType getDateDefinitionType() {
		return dateDefinitionType;
	}

	public void setDateDefinitionType(DateDefinitionType dateDefinitionType) {
		this.dateDefinitionType = dateDefinitionType;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Date getSeededUntil() {
		return seededUntil;
	}

	public void setSeededUntil(Date seededUntil) {
		this.seededUntil = seededUntil;
	}

	public Integer getFixedMonth() {
		return fixedMonth;
	}

	public void setFixedMonth(Integer fixedMonth) {
		this.fixedMonth = fixedMonth;
	}

	public Integer getFixedDay() {
		return fixedDay;
	}

	public void setFixedDay(Integer fixedDay) {
		this.fixedDay = fixedDay;
	}

	public Integer getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Integer getWeekOfMonth() {
		return weekOfMonth;
	}

	public void setWeekOfMonth(Integer weekOfMonth) {
		this.weekOfMonth = weekOfMonth;
	}

	public Integer getAdjustment() {
		return adjustment;
	}

	public void setAdjustment(Integer adjustment) {
		this.adjustment = adjustment;
	}

}
