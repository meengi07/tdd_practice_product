package org.example.productorderservice.payment;

import org.example.productorderservice.order.Order;

public interface PaymentPort {

     Order getOrder(Long orderId);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
