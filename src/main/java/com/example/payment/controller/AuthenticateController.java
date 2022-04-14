package com.example.payment.controller;

import com.example.payment.entity.AuthenticationRequest;
import com.example.payment.security.GenerateToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticateController {
    private final AuthenticationManager authenticationManager;
    private final GenerateToken generateToken;

    @Autowired
    public AuthenticateController(AuthenticationManager authenticationManager, GenerateToken generateToken) {
        this.authenticationManager = authenticationManager;
        this.generateToken = generateToken;
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthenticationRequest authRequest) throws Exception {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return generateToken.generateJwtTokent(authentication);
    }
}