package com.example.payment.mapper.impl;

import com.example.payment.dto.ClientDto;
import com.example.payment.dto.ResponseClientDto;
import com.example.payment.entity.Client;
import com.example.payment.mapper.BankMapper;
import com.example.payment.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultClientMapper implements ClientMapper {
    private final BankMapper bankMapper;

    @Autowired
    public DefaultClientMapper(BankMapper bankMapper) {
        this.bankMapper = bankMapper;
    }

    @Override
    public ClientDto toClientDto(Client client) {
        ClientDto clientDto = new ClientDto();

        clientDto.setId(client.getId());
        clientDto.setAccountNumber(client.getAccountNumber());
        clientDto.setCurrentBalance(client.getCurrentBalance());
        clientDto.setPassword(client.getPassword());
        clientDto.setUsername(client.getUsername());

        if (client.getBank() != null) {
            clientDto.setBankDto(bankMapper.toBankDto(client.getBank()));
        }

        return clientDto;
    }

    @Override
    public ResponseClientDto toResponseClientDto(Client client) {
        ResponseClientDto responseClientDto = new ResponseClientDto();

        responseClientDto.setAccountNumber(client.getAccountNumber());
        responseClientDto.setCurrentBalance(client.getCurrentBalance());

        return responseClientDto;
    }
}