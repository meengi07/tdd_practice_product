package org.example.productorderservice.payment;

import org.springframework.stereotype.Component;

@Component
public class ConsolePaymentGateway implements PaymentGateway {

    @Override
    public void excute(int totalPrice, String cardNumber) {
        System.out.println("결제가 완료되었습니다. ");
    }
}
