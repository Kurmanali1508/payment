package com.example.payment.dto;

import com.example.payment.entity.enums.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PaymentDto {
    private Long id;
    private Date createdDate;
    private BigDecimal amount;
    private ClientDto clientDto;
    private Status status;
}