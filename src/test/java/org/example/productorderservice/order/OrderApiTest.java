package org.example.productorderservice.order;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.example.productorderservice.ApiTest;
import org.example.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class OrderApiTest extends ApiTest {

    @Test
    void 상품주문() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        var request = OrderSteps.상품주문요청_생성();

        var extract = OrderSteps.상품주문요청(request);

        assertThat(extract.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }
}
