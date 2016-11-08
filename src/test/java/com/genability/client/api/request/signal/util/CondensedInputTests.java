package com.genability.client.api.request.signal.util;


import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import com.genability.client.types.PropertyData;
import org.joda.time.DateTime;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


public class CondensedInputTests {

    @Test
    public void testCondensedInputCreation() {
        DateTime fromDateTime = new DateTime("2016-01-01T00:00:00.000-08:00");
        List<BigDecimal> usage = Arrays.asList(
                BigDecimal.valueOf(1.0),
                BigDecimal.valueOf(2.0),
                BigDecimal.valueOf(3.0)
        );

        PropertyData condensedInputs = CondensedInput.create(fromDateTime, usage, 15L * 60L * 1000L);

        assertThat(condensedInputs.getKeyName(), equalTo("consumption"));
        assertThat(condensedInputs.getFromDateTime(), equalTo(fromDateTime));
        assertThat(condensedInputs.getDataSeries().size(), equalTo(3));
        assertThat(condensedInputs.getDataSeries(), equalTo(usage));
        assertThat(condensedInputs.getDuration(), equalTo(15L * 60L * 1000L));
        assertThat(condensedInputs.getUnit(), equalTo("kWh"));
    }
}
