package com.devsenior.nmanja.user_login.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.user_login.model.dto.LoginRequest;
import com.devsenior.nmanja.user_login.model.dto.LoginResponse;
import com.devsenior.nmanja.user_login.model.dto.RegisterRequest;
import com.devsenior.nmanja.user_login.model.dto.RegisterResponse;
import com.devsenior.nmanja.user_login.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    
    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest body){
        return authService.login(body);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/register")
    public RegisterResponse register(@RequestBody @Valid RegisterRequest body){
        return authService.register(body);
    }
}
