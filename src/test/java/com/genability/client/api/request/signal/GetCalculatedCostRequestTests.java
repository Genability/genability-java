package com.genability.client.api.request.signal;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GetCalculatedCostRequestTests {
    @Test
    public void testGetAutoBaseline_getterSetter() {
        GetCalculatedCostRequest request = new GetAccountCalculatedCostRequest();
        request.setAutoBaseline(Boolean.TRUE);

        assertTrue("Got no/incorrect autoBaseline", request.getAutoBaseline());
    }

    @Test
    public void testGetUseIntelligentBaselining_getterSetter() {
        GetCalculatedCostRequest request = new GetAccountCalculatedCostRequest();
        request.setUseIntelligentBaselining(Boolean.TRUE);

        assertTrue("Got no/incorrect useIntelligentBaselining", request.getUseIntelligentBaselining());
    }
}
