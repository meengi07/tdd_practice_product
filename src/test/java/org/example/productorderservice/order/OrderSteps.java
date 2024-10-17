package org.example.productorderservice.order;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class OrderSteps {

    public static CreateOrderRequest 상품주문요청_생성() {
        Long productId = 1L;
        int quantity = 2;
        return new CreateOrderRequest(productId, quantity);
    }

    public static ExtractableResponse<Response> 상품주문요청(CreateOrderRequest request) {
        return RestAssured.given().log().all()
            .contentType("application/json")
            .body(request)
            .when()
            .post("/orders")
            .then()
            .log().all()
            .extract();
    }
}
