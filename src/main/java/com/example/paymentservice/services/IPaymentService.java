package com.example.paymentservice.services;

public interface IPaymentService {
    String initiatePayment(Long amount, String orderId, String phoneNumber, String name, String email);
}
