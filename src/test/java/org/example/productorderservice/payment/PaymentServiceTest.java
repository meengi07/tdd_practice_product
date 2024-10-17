package org.example.productorderservice.payment;

import org.example.productorderservice.order.OrderService;
import org.example.productorderservice.order.OrderSteps;
import org.example.productorderservice.product.ProductService;
import org.example.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;


    @Test
    void 상품주문() {
        productService.addProduct(ProductSteps.상품등록요청_생성());
        orderService.createOrder(OrderSteps.상품주문요청_생성());
        PaymentRequest request = PaymentSteps.주문결제요청_생성();

        paymentService.payment(request);
    }

}
