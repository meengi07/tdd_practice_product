package org.example.productorderservice.product;

interface ProductPort {

    void save(Product product);

    Product getProduct(Long id);
}
