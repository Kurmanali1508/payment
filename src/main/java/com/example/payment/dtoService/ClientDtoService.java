package com.example.payment.dtoService;

import com.example.payment.dto.ClientDto;
import com.example.payment.dto.CreateClientDto;
import com.example.payment.dto.ResponseClientDto;

import java.util.List;

public interface ClientDtoService {
    ResponseClientDto getById(Long id);
    List<ClientDto> getAll();
    ClientDto create(CreateClientDto createClientDto);
}