package com.genability.client.api.request.signal.util;


import com.genability.client.types.PropertyData;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.List;


public final class CondensedInput {

    public static PropertyData create(DateTime fromDateTime, List<BigDecimal> usage, Long duration) {
        PropertyData propertyData = new PropertyData();

        propertyData.setKeyName("consumption");
        propertyData.setFromDateTime(fromDateTime);
        propertyData.addDataSeries(usage);
        propertyData.setDuration(duration);
        propertyData.setUnit("kWh");

        return propertyData;
    }

}
