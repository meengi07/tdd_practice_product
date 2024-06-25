package org.example.productorderservice.product;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    void update() {
        Product product = new Product("상품명", 1000, DiscountPolicy.NONE);

        product.update("수정된 상품명", 2000, DiscountPolicy.NONE);

        assertEquals("수정된 상품명", product.getName());
        assertEquals(2000, product.getPrice());
    }
}