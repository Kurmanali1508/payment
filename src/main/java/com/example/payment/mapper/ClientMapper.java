package com.example.payment.mapper;

import com.example.payment.dto.ClientDto;
import com.example.payment.dto.ResponseClientDto;
import com.example.payment.entity.Client;

public interface ClientMapper {
    ClientDto toClientDto(Client client);
    ResponseClientDto toResponseClientDto(Client client);
}