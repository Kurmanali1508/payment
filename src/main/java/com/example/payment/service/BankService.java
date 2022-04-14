package com.example.payment.service;

import com.example.payment.entity.Bank;

import java.util.List;

public interface BankService {
    Bank getById(Long id);
    List<Bank> getAll();
    Bank save(Bank bank);
}