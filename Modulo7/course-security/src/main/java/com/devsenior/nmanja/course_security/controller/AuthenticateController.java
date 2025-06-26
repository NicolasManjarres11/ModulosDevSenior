package com.devsenior.nmanja.course_security.controller;

import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.course_security.model.dto.AuthenticationRequest;
import com.devsenior.nmanja.course_security.model.dto.AuthenticationResponse;
import com.devsenior.nmanja.course_security.service.AuthenticationService;
import com.devsenior.nmanja.course_security.service.impl.AuthenticationServiceImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor
@RestController
public class AuthenticateController {

    public final AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(@Valid @RequestBody AuthenticationRequest body) {
        //TODO: process POST request
        
        return authenticationService.login(body);
    }
    
    
}
