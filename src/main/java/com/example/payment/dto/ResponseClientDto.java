package com.example.payment.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ResponseClientDto {
    private BigDecimal currentBalance;
    private String accountNumber;
}