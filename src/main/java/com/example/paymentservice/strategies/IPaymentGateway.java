package com.example.paymentservice.strategies;

public interface IPaymentGateway {

    String createStandardPaymentLink(Long amount, String orderId, String phoneNumber, String name, String email);
}
