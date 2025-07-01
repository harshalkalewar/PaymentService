package com.example.paymentservice.services;

import com.example.paymentservice.strategies.IPaymentGateway;
import com.example.paymentservice.strategies.PaymentGatewayStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private PaymentGatewayStrategy paymentGatewayStrategy;

    @Override
    public String initiatePayment(Long amount, String orderId, String phoneNumber, String name, String email) {
        IPaymentGateway paymentGateway = paymentGatewayStrategy.getBestPaymentGateway();
        return paymentGateway.createStandardPaymentLink(amount, orderId, phoneNumber, name, email);

    }
}
