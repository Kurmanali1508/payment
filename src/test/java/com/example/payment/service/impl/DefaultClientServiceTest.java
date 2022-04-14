package com.example.payment.service.impl;

import com.example.payment.entity.Bank;
import com.example.payment.entity.Client;
import com.example.payment.repository.ClientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class DefaultClientServiceTest {
    @InjectMocks
    private DefaultClientService defaultClientService;

    @Mock
    private ClientRepository clientRepository;

    private Client client;
    private Bank bank;

    private String string;
    private BigDecimal decimal;

    @BeforeEach
    void setUp() {
        defaultClientService = new DefaultClientService(clientRepository);

        string = "some";
        decimal = new BigDecimal(10);

        bank = new Bank();
        bank.setId(1L);
        bank.setName(string);

        client = new Client();
        client.setId(1L);
        client.setUsername(string);
        client.setAccountNumber(string);
        client.setPassword(string);
        client.setCurrentBalance(decimal);
        client.setBank(bank);
    }

    @AfterEach
    void tearDown() {
        client = null;
        bank = null;
        decimal = null;
    }

    @Test
    void getById_withValidId_shouldReturnClient() {
        when(clientRepository.findById(1L)).thenReturn(Optional.ofNullable(client));

        Client client = defaultClientService.getById(1L);

        assertEquals(1L, client.getId());
        assertEquals(string, client.getUsername());
        assertEquals(string, client.getPassword());
        assertEquals(string, client.getAccountNumber());
        assertEquals(decimal, client.getCurrentBalance());
        assertEquals(bank, client.getBank());

        verify(clientRepository, times(1)).findById(1L);
    }

    @Test
    void getAll_withValidData_shouldReturnClientList() {
        when(clientRepository.findAll()).thenReturn(Collections.singletonList(client));

        List<Client> clients = defaultClientService.getAll();

        assertThat(clients).hasSize(1);
        verify(clientRepository, times(1)).findAll();
    }

    @Test
    void save_withValidUser_shouldReturnClient() {
        when(clientRepository.save(any())).thenReturn(client);

        Client response = defaultClientService.save(client);

        assertEquals(1L, response.getId());
        assertEquals(string, response.getUsername());
        assertEquals(string, response.getPassword());
        assertEquals(string, response.getAccountNumber());
        assertEquals(decimal, response.getCurrentBalance());
        assertEquals(bank, response.getBank());

        verify(clientRepository, times(1)).save(any());
    }
}