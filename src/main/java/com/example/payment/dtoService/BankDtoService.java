package com.example.payment.dtoService;

import com.example.payment.dto.BankDto;
import com.example.payment.dto.CreateBankDto;
import com.example.payment.dto.UpdateBankDto;

import java.util.List;

public interface BankDtoService {
    BankDto getById(Long id);
    List<BankDto> getAll();
    BankDto create(CreateBankDto createBankDto);
    BankDto update(Long id, UpdateBankDto updateBankDto);
}