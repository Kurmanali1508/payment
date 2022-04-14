package com.example.payment.controller;

import com.example.payment.dto.BankDto;
import com.example.payment.dto.CreateBankDto;
import com.example.payment.dto.UpdateBankDto;
import com.example.payment.dtoService.BankDtoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {
    private final BankDtoService bankDtoService;

    public BankController(BankDtoService bankDtoService) {
        this.bankDtoService = bankDtoService;
    }

    @GetMapping("/{id}")
    public BankDto getById(@PathVariable("id") Long id) {
        return bankDtoService.getById(id);
    }

    @GetMapping
    public List<BankDto> getAll() {
        return bankDtoService.getAll();
    }

    @PostMapping
    public BankDto create(@RequestBody CreateBankDto createBankDto) {
        return bankDtoService.create(createBankDto);
    }

    @PutMapping("/{bankId}")
    public BankDto update(@PathVariable("bankId") Long id, @RequestBody UpdateBankDto updateBankDto) {
        return bankDtoService.update(id, updateBankDto);
    }
}