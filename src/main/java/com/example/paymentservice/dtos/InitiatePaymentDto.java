package com.example.paymentservice.dtos;

import lombok.Data;

@Data
public class InitiatePaymentDto {
    private Long amount;
    private String orderId;
    private String phoneNumber;
    private String name;
    private String email;
}
