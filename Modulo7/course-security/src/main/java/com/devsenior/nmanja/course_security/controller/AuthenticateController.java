package com.devsenior.nmanja.course_security.controller;

import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.course_security.model.dto.AuthenticationRequest;
import com.devsenior.nmanja.course_security.model.dto.AuthenticationResponse;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AuthenticateController {

    @PostMapping("/authenticate")
    public AuthenticationResponse postMethodName(@Valid @RequestBody AuthenticationRequest body) {
        //TODO: process POST request
        
        return null;
    }
    
    
}
