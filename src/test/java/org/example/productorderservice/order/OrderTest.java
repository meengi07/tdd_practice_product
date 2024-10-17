package org.example.productorderservice.order;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.productorderservice.product.DiscountPolicy;
import org.example.productorderservice.product.Product;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void getTotalPrice() {
        final Order order = new Order(new Product("상품1", 1000, DiscountPolicy.FIX_1000_AMOUNT), 2);

        int totalPrice = order.getTotalPrice();

        assertEquals(2000, totalPrice);
    }
}