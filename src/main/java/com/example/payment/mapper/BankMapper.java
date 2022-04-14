package com.example.payment.mapper;

import com.example.payment.dto.BankDto;
import com.example.payment.entity.Bank;

public interface BankMapper {
    BankDto toBankDto(Bank bank);
}