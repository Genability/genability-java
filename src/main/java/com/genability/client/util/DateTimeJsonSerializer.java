package com.genability.client.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * This is a custom serializer for serializing Joda DateTime into JSON. To use
 * this annotate the getter method with:
 * 
 * {code}
 * 
 * @JsonSerialize(using=DateTimeJsonSerializer.class) 
 * 
 * {code}
 * 
 */
public class DateTimeJsonSerializer extends JsonSerializer<DateTime> {

	
	public static final String ISO_8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ";
	
	public static final String ISO_8601_DATE_FORMAT_NO_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ss.SSS";
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.codehaus.jackson.map.JsonSerializer#serialize(java.lang.Object,
	 * org.codehaus.jackson.JsonGenerator,
	 * org.codehaus.jackson.map.SerializerProvider)
	 */
	@Override
	public void serialize(DateTime dateTime, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		
		if (dateTime != null) {
			DateTimeFormatter fmt = DateTimeFormat.forPattern(ISO_8601_DATE_FORMAT);

			jgen.writeString(fmt.print(dateTime));
		}

	} // end of method serialize

}
