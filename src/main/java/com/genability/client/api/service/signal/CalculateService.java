package com.genability.client.api.service.signal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.signal.GetCalculatedCostRequest;
import com.genability.client.api.request.signal.GetMassCalculatedCostRequest;
import com.genability.client.api.service.BaseService;
import com.genability.client.types.Response;
import com.genability.client.types.signal.CalculatedCost;
import com.genability.client.types.signal.MassCalculation;


public class CalculateService extends BaseService {

    private static final TypeReference<Response<CalculatedCost>> CALCULATEDCOST_RESPONSE_TYPEREF =
            new TypeReference<Response<CalculatedCost>>() { };
    private static final TypeReference<Response<MassCalculation>> MASSCALCULATION_RESPONSE_TYPEREF =
            new TypeReference<Response<MassCalculation>>() { };


    public Response<CalculatedCost> getCalculatedCost(GetCalculatedCostRequest request) {
        if (log.isDebugEnabled()) {
            log.debug("getCalculatedCost called");
        }

        String uri = "v1/ondemand/calculate";

        Response<CalculatedCost> response = this.callPost(
                uri,
                request,
                CALCULATEDCOST_RESPONSE_TYPEREF);

        if (log.isDebugEnabled()) {
            log.debug("getCalculatedCost completed");
        }

        return response;
    }

    public Response<MassCalculation> getMassCalculatedCost(GetMassCalculatedCostRequest request) {
        if (log.isDebugEnabled()) {
            log.debug("getMassCalculatedCost");
        }

        String uri = "v1/ondemand/calculate/mass";

        Response<MassCalculation> response = this.callPost(
                uri,
                request,
                MASSCALCULATION_RESPONSE_TYPEREF
        );

        if (log.isDebugEnabled()) {
            log.debug("getMassCalculatedCost completed");
        }

        return response;
    }
}
