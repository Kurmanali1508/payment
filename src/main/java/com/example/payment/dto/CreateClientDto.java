package com.example.payment.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateClientDto {
    private String username;
    private String password;
    private BigDecimal currentBalance;
    private String accountNumber;
    private Long bankId;
}