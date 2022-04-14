package com.example.payment.service.impl;

import com.example.payment.entity.Client;
import com.example.payment.exception.ClientNotFoundException;
import com.example.payment.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DefaultUserDetailService implements UserDetailsService {
    private final ClientRepository clientRepository;

    @Autowired
    public DefaultUserDetailService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByUsername(username);

        if (client == null) {
            throw new ClientNotFoundException("Client with username " + username + " is not found!");
        }

        return new org.springframework.security.core.userdetails.User(client.getUsername(), client.getPassword(), new ArrayList<>());
    }
}