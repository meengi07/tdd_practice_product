package org.example.productorderservice.payment;

import org.example.productorderservice.order.Order;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    private final PaymentPort paymentPort;

    PaymentService(PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    public void payment(PaymentRequest request) {
        Order order = paymentPort.getOrder(request.orderId());

        Payment payment = new Payment(order, request.cardNumber());

        paymentPort.pay(payment.getPrice(), payment.getCardNumber());

        paymentPort.save(payment);
    }

}
