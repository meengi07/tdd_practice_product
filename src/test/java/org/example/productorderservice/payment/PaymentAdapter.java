package org.example.productorderservice.payment;

import org.example.productorderservice.order.Order;
import org.example.productorderservice.product.DiscountPolicy;
import org.example.productorderservice.product.Product;
import org.springframework.stereotype.Component;

@Component
public class PaymentAdapter implements PaymentPort {

    private PaymentGateway paymentGateway;
    private PaymentRepository paymentRepository;

    public PaymentAdapter(PaymentGateway paymentGateway, PaymentRepository paymentRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Order getOrder(Long orderId) {
        return new Order(new Product("상품", 1000, DiscountPolicy.NONE), 2);
    }

    @Override
    public void pay(int totalPrice, String cardNumber) {
        paymentGateway.excute(totalPrice, cardNumber);
    }

    @Override
    public void save(Payment payment) {
        paymentRepository.save(payment);
    }
}
