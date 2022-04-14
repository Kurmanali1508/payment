package com.example.payment.dtoService.impl;

import com.example.payment.dto.CreatePaymentDto;
import com.example.payment.dto.PaymentDto;
import com.example.payment.dto.ResponsePaymentDto;
import com.example.payment.dtoService.PaymentDtoService;
import com.example.payment.entity.Client;
import com.example.payment.entity.Payment;
import com.example.payment.entity.enums.Status;
import com.example.payment.exception.PaymentIsCancelled;
import com.example.payment.mapper.PaymentMapper;
import com.example.payment.service.ClientService;
import com.example.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultPaymentDtoService implements PaymentDtoService {
    private final PaymentMapper paymentMapper;
    private final PaymentService paymentService;
    private final ClientService clientService;

    public DefaultPaymentDtoService(PaymentMapper paymentMapper, PaymentService paymentService, ClientService clientService) {
        this.paymentMapper = paymentMapper;
        this.paymentService = paymentService;
        this.clientService = clientService;
    }

    @Override
    public ResponsePaymentDto getById(Long id) {
        return paymentMapper.toResponsePaymentDto(paymentService.getById(id));
    }

    @Override
    public List<PaymentDto> getAll() {
        return paymentService.getAll()
                .stream()
                .map(paymentMapper::toPaymentDto)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentDto create(CreatePaymentDto createPaymentDto) {
        Payment payment = new Payment();

        Client client = clientService.getById(createPaymentDto.getClientId());

        if (client.getCurrentBalance().compareTo(createPaymentDto.getAmount()) >= 0) {
            client.setCurrentBalance((client.getCurrentBalance()).subtract(createPaymentDto.getAmount()));

            clientService.save(client);

            payment.setStatus(Status.SUCCESS);
        } else {
            payment.setStatus(Status.FAILED);
        }

        payment.setAmount(createPaymentDto.getAmount());
        payment.setCreatedDate(new Date());

        if (createPaymentDto.getClientId() != null) {
            payment.setClient(clientService.getById(createPaymentDto.getClientId()));
        }

        return paymentMapper.toPaymentDto(paymentService.save(payment));
    }

    @Override
    public Status cancel(Long id) {
        Payment payment = paymentService.getById(id);

        if (payment.getStatus().compareTo(Status.CANCELLED) != 0) {
            payment.setStatus(Status.CANCELLED);

            Client client = clientService.getById(payment.getClient().getId());

            client.setCurrentBalance(client.getCurrentBalance().add(payment.getAmount()));

            paymentService.save(payment);
            clientService.save(client);

            return payment.getStatus();
        } else {
            throw new PaymentIsCancelled("The payment has already been canceled!");
        }
    }
}