package com.example.payment.mapper.impl;

import com.example.payment.dto.BankDto;
import com.example.payment.entity.Bank;
import com.example.payment.mapper.BankMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultBankMapper implements BankMapper {
    @Override
    public BankDto toBankDto(Bank bank) {
        BankDto bankDto = new BankDto();

        bankDto.setId(bank.getId());
        bankDto.setName(bank.getName());

        return bankDto;
    }
}