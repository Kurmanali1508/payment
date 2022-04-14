package com.example.payment.mapper.impl;

import com.example.payment.dto.PaymentDto;
import com.example.payment.dto.ResponsePaymentDto;
import com.example.payment.entity.Payment;
import com.example.payment.mapper.ClientMapper;
import com.example.payment.mapper.PaymentMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultPaymentMapper implements PaymentMapper {
    private final ClientMapper clientMapper;

    public DefaultPaymentMapper(ClientMapper clientMapper) {
        this.clientMapper = clientMapper;
    }

    @Override
    public PaymentDto toPaymentDto(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();

        paymentDto.setId(payment.getId());
        paymentDto.setAmount(payment.getAmount());
        paymentDto.setCreatedDate(payment.getCreatedDate());
        paymentDto.setStatus(payment.getStatus());

        if (payment.getClient() != null) {
            paymentDto.setClientDto(clientMapper.toClientDto(payment.getClient()));
        }

        return paymentDto;
    }

    @Override
    public ResponsePaymentDto toResponsePaymentDto(Payment payment) {
        ResponsePaymentDto responsePaymentDto = new ResponsePaymentDto();

        responsePaymentDto.setCreatedDate(payment.getCreatedDate());
        responsePaymentDto.setAmount(payment.getAmount());
        responsePaymentDto.setStatus(payment.getStatus());

        return responsePaymentDto;
    }
}