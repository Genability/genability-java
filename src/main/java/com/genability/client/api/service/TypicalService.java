package com.genability.client.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.genability.client.api.request.BaselineRequest;
import com.genability.client.types.Baseline;
import com.genability.client.types.Response;

public class TypicalService extends BaseService {

    private static final TypeReference<Response<Baseline>> BASELINE_RESPONSE_TYPEREF = new TypeReference<Response<Baseline>>() {};

    private static final String BEST_BASELINE_PATH = "v1/typicals/baselines/best";

    public Response<Baseline> getBestBaseline(final BaselineRequest request) {
        return this.callGet(BEST_BASELINE_PATH, request.getQueryParams(), BASELINE_RESPONSE_TYPEREF);
    }

}
