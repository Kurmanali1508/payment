package com.example.payment.controller;

import com.example.payment.dto.CreatePaymentDto;
import com.example.payment.dto.PaymentDto;
import com.example.payment.dto.ResponsePaymentDto;
import com.example.payment.dtoService.PaymentDtoService;
import com.example.payment.entity.enums.Status;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentDtoService paymentDtoService;

    public PaymentController(PaymentDtoService paymentDtoService) {
        this.paymentDtoService = paymentDtoService;
    }

    @GetMapping("/{id}")
    public ResponsePaymentDto getById(@PathVariable("id") Long id) {
        return paymentDtoService.getById(id);
    }

    @GetMapping
    public List<PaymentDto> getAll() {
        return paymentDtoService.getAll();
    }

    @GetMapping("/status/{id}")
    public Status getStatus(@PathVariable("id") Long id) {
        return paymentDtoService.getStatus(id);
    }

    @PostMapping
    public PaymentDto create(@RequestBody CreatePaymentDto createPaymentDto) {
        return paymentDtoService.create(createPaymentDto);
    }

    @PutMapping("cancel/{id}")
    public Status cancel(@PathVariable("id") Long id) {
        return paymentDtoService.cancel(id);
    }
}