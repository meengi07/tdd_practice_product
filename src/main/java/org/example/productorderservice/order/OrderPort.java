package org.example.productorderservice.order;

import org.example.productorderservice.product.Product;

public interface OrderPort {

    Product getProductById(Long productId);

    void save(Order order);
}
