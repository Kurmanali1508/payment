package com.example.payment.service;

import com.example.payment.entity.Client;

import java.util.List;

public interface ClientService {
    Client getById(Long id);
    List<Client> getAll();
    Client save(Client client);
}