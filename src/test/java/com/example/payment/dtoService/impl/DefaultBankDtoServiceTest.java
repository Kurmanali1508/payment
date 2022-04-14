package com.example.payment.dtoService.impl;

import com.example.payment.dto.BankDto;
import com.example.payment.dto.CreateBankDto;
import com.example.payment.dto.UpdateBankDto;
import com.example.payment.entity.Bank;
import com.example.payment.mapper.BankMapper;
import com.example.payment.service.BankService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class DefaultBankDtoServiceTest {
    @InjectMocks
    private DefaultBankDtoService defaultBankDtoService;

    @Mock
    private BankService bankService;

    @Mock
    private BankMapper bankMapper;

    private CreateBankDto createBankDto;
    private UpdateBankDto updateBankDto;
    private BankDto bankDto;
    private Bank bank;

    private String string;

    @BeforeEach
    void setUp() {
        defaultBankDtoService = new DefaultBankDtoService(bankService, bankMapper);

        string = "some";

        createBankDto = new CreateBankDto();
        createBankDto.setName(string);

        updateBankDto = new UpdateBankDto();
        updateBankDto.setName(string);

        bankDto = new BankDto();
        bankDto.setId(1L);
        bankDto.setName(string);

        bank = new Bank();
        bank.setId(1L);
        bank.setName(string);
    }

    @AfterEach
    void tearDown() {
        createBankDto = null;
        updateBankDto = null;
        bankDto = null;
    }

    @Test
    void getById_withValidId_shouldReturnBankDto() {
        when(bankService.getById(1L)).thenReturn(bank);
        when(bankMapper.toBankDto(bank)).thenReturn(bankDto);

        BankDto response = defaultBankDtoService.getById(1L);

        assertEquals(1L, response.getId());
        assertEquals(string, response.getName());

        verify(bankService, times(1)).getById(1L);
    }

    @Test
    void getAll_withValidData_shouldReturnBankDtoList() {
        when(bankService.getAll()).thenReturn(Collections.singletonList(bank));
        when(bankMapper.toBankDto(bank)).thenReturn(bankDto);

        List<BankDto> bankDtos = defaultBankDtoService.getAll();

        assertThat(bankDtos).hasSize(1);
        verify(bankService, times(1)).getAll();
    }

    @Test
    void create_withValidData_shouldReturnBankDto() {
        when(bankService.save(any())).thenReturn(bank);
        when(bankMapper.toBankDto(bank)).thenReturn(bankDto);

        BankDto response = defaultBankDtoService.create(createBankDto);

        assertEquals(1L, response.getId());
        assertEquals(string, response.getName());

        verify(bankService, times(1)).save(any());
    }

    @Test
    void update_withValidData_shouldReturnBankDto() {
        when(bankService.getById(1L)).thenReturn(bank);
        when(bankService.save(any())).thenReturn(bank);
        when(bankMapper.toBankDto(bank)).thenReturn(bankDto);

        BankDto response = defaultBankDtoService.update(1L, updateBankDto);

        assertEquals(1L, response.getId());
        assertEquals(string, response.getName());

        verify(bankService, times(1)).save(any());
    }
}