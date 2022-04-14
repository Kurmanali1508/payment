package com.example.payment.dtoService.impl;

import com.example.payment.dto.BankDto;
import com.example.payment.dto.CreateBankDto;
import com.example.payment.dto.UpdateBankDto;
import com.example.payment.dtoService.BankDtoService;
import com.example.payment.entity.Bank;
import com.example.payment.mapper.BankMapper;
import com.example.payment.service.BankService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultBankDtoService implements BankDtoService {
    private final BankService bankService;
    private final BankMapper bankMapper;

    public DefaultBankDtoService(BankService bankService, BankMapper bankMapper) {
        this.bankService = bankService;
        this.bankMapper = bankMapper;
    }

    @Override
    public BankDto getById(Long id) {
        return bankMapper.toBankDto(bankService.getById(id));
    }

    @Override
    public List<BankDto> getAll() {
        return bankService.getAll()
                .stream()
                .map(bankMapper::toBankDto)
                .collect(Collectors.toList());
    }

    @Override
    public BankDto create(CreateBankDto createBankDto) {
        Bank bank = new Bank();

        bank.setName(createBankDto.getName());

        return bankMapper.toBankDto(bankService.save(bank));
    }

    @Override
    public BankDto update(Long id, UpdateBankDto updateBankDto) {
        Bank bank = bankService.getById(id);

        bank.setName(updateBankDto.getName());

        return bankMapper.toBankDto(bankService.save(bank));
    }
}