package com.example.payment.mapper;

import com.example.payment.dto.PaymentDto;
import com.example.payment.dto.ResponsePaymentDto;
import com.example.payment.entity.Payment;

public interface PaymentMapper {
    PaymentDto toPaymentDto(Payment payment);
    ResponsePaymentDto toResponsePaymentDto(Payment payment);
}