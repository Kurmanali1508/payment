package com.example.payment.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreatePaymentDto {
    private BigDecimal amount;
    private Long clientId;
}