package com.example.payment.service.impl;

import com.example.payment.entity.Bank;
import com.example.payment.repository.BankRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class DefaultBankServiceTest {
    @InjectMocks
    private DefaultBankService defaultBankService;

    @Mock
    private BankRepository bankRepository;

    private Bank bank;

    private String name;

    @BeforeEach
    void setUp() {
        defaultBankService = new DefaultBankService(bankRepository);

        name = "Optima";

        bank = new Bank();
        bank.setId(1L);
        bank.setName(name);
    }

    @AfterEach
    void tearDown() {
        name = null;
        bank = null;
    }

    @Test
    void getById_withValidId_shouldReturnBank() {
        when(bankRepository.findById(1L)).thenReturn(Optional.ofNullable(bank));

        Bank response = defaultBankService.getById(1L);

        assertEquals(1L, response.getId());
        assertEquals(name, response.getName());

        verify(bankRepository, times(1)).findById(1L);
    }

    @Test
    void getAll_withValidData_shouldReturnBankList() {
        when(bankRepository.findAll()).thenReturn(Collections.singletonList(bank));

        List<Bank> bankList = defaultBankService.getAll();

        assertThat(bankList).hasSize(1);
        verify(bankRepository, times(1)).findAll();
    }

    @Test
    void save_withValidUser_shouldReturnBank() {
        when(bankRepository.save(any())).thenReturn(bank);

        Bank response = defaultBankService.save(bank);

        assertEquals(1L, response.getId());
        assertEquals(name, response.getName());

        verify(bankRepository, times(1)).save(any());
    }
}