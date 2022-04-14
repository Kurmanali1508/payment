package com.example.payment.controller;

import com.example.payment.dto.ClientDto;
import com.example.payment.dto.CreateClientDto;
import com.example.payment.dto.ResponseClientDto;
import com.example.payment.dtoService.ClientDtoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientDtoService clientDtoService;

    public ClientController(ClientDtoService clientDtoService) {
        this.clientDtoService = clientDtoService;
    }

    @GetMapping("/{id}")
    public ResponseClientDto getById(@PathVariable("id") Long id) {
        return clientDtoService.getById(id);
    }

    @GetMapping
    public List<ClientDto> getAll() {
        return clientDtoService.getAll();
    }

    @PostMapping
    public ClientDto create(@RequestBody CreateClientDto createClientDto) {
        return clientDtoService.create(createClientDto);
    }
}