package com.example.payment.service.impl;

import com.example.payment.entity.Client;
import com.example.payment.repository.ClientRepository;
import com.example.payment.service.ClientService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultClientService implements ClientService {
    private final ClientRepository clientRepository;

    public DefaultClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client with id " + id + " is not found!"));
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }
}