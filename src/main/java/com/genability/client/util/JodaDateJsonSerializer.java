package com.genability.client.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

/**
 * This is a custom serializer for serializing java.sql.DateTime into JSON.
 * This is used by all requests containing DateTimes.
 *
 * {code}
 * {@literal @}JsonSerialize(using=SqlDateJsonSerializer.class)
 * {code}
 *
 */
public class JodaDateJsonSerializer extends JsonSerializer<DateTime> {
	
	public static final String ISO_8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZZ";

	@Override
	public void serialize(DateTime dateTime, JsonGenerator jgen, SerializerProvider provider) throws IOException {

		if (dateTime != null) {
			DateTimeFormatter fmt = DateTimeFormat.forPattern(ISO_8601_DATE_FORMAT);
			jgen.writeString(fmt.print(dateTime));
		}
	}

}
