package org.example.productorderservice.order;


import org.example.productorderservice.product.Product;
import org.example.productorderservice.product.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderAdapter implements OrderPort {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    private OrderAdapter(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Product getProductById(Long aLong) {
        return productRepository.findById(aLong).orElseThrow();
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}
