package com.example.payment.dtoService.impl;

import com.example.payment.dto.ClientDto;
import com.example.payment.dto.CreateClientDto;
import com.example.payment.dto.ResponseClientDto;
import com.example.payment.dtoService.ClientDtoService;
import com.example.payment.entity.Client;
import com.example.payment.mapper.ClientMapper;
import com.example.payment.service.BankService;
import com.example.payment.service.ClientService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultClientDtoService implements ClientDtoService {
    private final ClientMapper clientMapper;
    private final ClientService clientService;
    private final BankService bankService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public DefaultClientDtoService(ClientMapper clientMapper, ClientService clientService, BankService bankService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.clientMapper = clientMapper;
        this.clientService = clientService;
        this.bankService = bankService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public ResponseClientDto getById(Long id) {
        return clientMapper.toResponseClientDto(clientService.getById(id));
    }

    @Override
    public List<ClientDto> getAll() {
        return clientService.getAll()
                .stream()
                .map(clientMapper::toClientDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto create(CreateClientDto createClientDto) {
        Client client = new Client();

        client.setUsername(createClientDto.getUsername());
        client.setAccountNumber(createClientDto.getAccountNumber());
        client.setCurrentBalance(createClientDto.getCurrentBalance());
        client.setPassword(bCryptPasswordEncoder.encode(createClientDto.getPassword()));

        if (createClientDto.getBankId() != null) {
            client.setBank(bankService.getById(createClientDto.getBankId()));
        }

        return clientMapper.toClientDto(clientService.save(client));
    }
}