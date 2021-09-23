package com.github.shymega.graal.minimalexample;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPResponse;

import java.util.UUID;

public class App implements RequestHandler<APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse> {
    @Override
    public APIGatewayV2HTTPResponse handleRequest(APIGatewayV2HTTPEvent evt, Context ctx) {

        Transaction tx = new Transaction();
        tx.setAmount(43);
        tx.setSource("current_account");
        tx.setTxUuid(UUID.randomUUID().toString());

        // don't send tx back, we're just demonstrating the annotation issue!

        return APIGatewayV2HTTPResponse.builder().withBody("{}") // send empty JSON object
                .withStatusCode(200).build();
    }
}
