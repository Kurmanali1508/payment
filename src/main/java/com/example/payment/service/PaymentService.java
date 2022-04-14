package com.example.payment.service;

import com.example.payment.entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment getById(Long id);
    List<Payment> getAll();
    Payment save(Payment payment);
}