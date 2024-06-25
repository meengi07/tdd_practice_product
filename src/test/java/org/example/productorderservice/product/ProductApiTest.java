package org.example.productorderservice.product;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.example.productorderservice.ApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class ProductApiTest extends ApiTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void 상품등록() {
        var request = ProductSteps.상품등록요청_생성();

        var extract = ProductSteps.상품등록요청(request);

        assertThat(extract.statusCode()).isEqualTo(201);
    }

    @Test
    void 상품조회() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        Long productId = 1L;

        ExtractableResponse<Response> response = ProductSteps.상품조회요청(productId);

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
    }

    @Test
    void 상품수정() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        Long productId = 1L;

        ExtractableResponse<Response> response = 상품수정요청(productId);

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(productRepository.findById(1L).get().getName()).isEqualTo("상품 수정");
    }

    private ExtractableResponse<Response> 상품수정요청(Long productId) {
        return RestAssured.given().log().all()
            .contentType("application/json")
            .body(ProductSteps.상품수정요청_생성())
            .when()
            .patch("/products/{productId}", productId)
            .then()
            .log().all()
            .extract();
    }

}
