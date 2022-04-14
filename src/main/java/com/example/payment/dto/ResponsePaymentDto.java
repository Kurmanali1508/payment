package com.example.payment.dto;

import com.example.payment.entity.enums.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ResponsePaymentDto {
    private Date createdDate;
    private BigDecimal amount;
    private Status status;
}