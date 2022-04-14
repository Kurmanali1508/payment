package com.example.payment.dtoService;

import com.example.payment.dto.CreatePaymentDto;
import com.example.payment.dto.PaymentDto;
import com.example.payment.dto.ResponsePaymentDto;
import com.example.payment.entity.enums.Status;

import java.util.List;

public interface PaymentDtoService {
    ResponsePaymentDto getById(Long id);
    List<PaymentDto> getAll();
    PaymentDto create(CreatePaymentDto createPaymentDto);
    Status cancel(Long id);
}