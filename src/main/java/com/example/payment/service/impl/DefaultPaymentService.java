package com.example.payment.service.impl;

import com.example.payment.entity.Payment;
import com.example.payment.repository.PaymentRepository;
import com.example.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultPaymentService implements PaymentService {
    private final PaymentRepository paymentRepository;

    public DefaultPaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment getById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Payment with id " + id + " is not found!"));
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }
}