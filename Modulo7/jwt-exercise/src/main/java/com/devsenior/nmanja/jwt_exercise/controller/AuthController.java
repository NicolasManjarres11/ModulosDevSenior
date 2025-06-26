package com.devsenior.nmanja.jwt_exercise.controller;

import com.devsenior.nmanja.jwt_exercise.model.dto.AuthenticationRequest;
import com.devsenior.nmanja.jwt_exercise.model.dto.AuthenticationResponse;
import com.devsenior.nmanja.jwt_exercise.service.AuthenticationService;
import com.devsenior.nmanja.jwt_exercise.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor
@RestController
public class AuthController {


    private final AuthenticationService authenticationService;


    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest body) {
        //TODO: process POST request
        
        return authenticationService.login(body);
    }
    
    
}
