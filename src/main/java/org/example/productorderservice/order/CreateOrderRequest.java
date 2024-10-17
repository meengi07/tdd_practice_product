package org.example.productorderservice.order;

import org.springframework.util.Assert;

record CreateOrderRequest(Long productId, int quantity) {

    CreateOrderRequest {
        Assert.notNull(productId, "productId must be provided");
        Assert.isTrue(productId > 0, "productId must be greater than 0");
    }
}
