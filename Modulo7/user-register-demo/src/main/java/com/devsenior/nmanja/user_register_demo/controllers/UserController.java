package com.devsenior.nmanja.user_register_demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.user_register_demo.exception.UserAlreadyExitsException;
import com.devsenior.nmanja.user_register_demo.models.dto.UserRegisterRequest;
import com.devsenior.nmanja.user_register_demo.services.UserRegisterServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@RequiredArgsConstructor
@RequestMapping
@RestController
public class UserController {

    private final UserRegisterServices userRegisterServices;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/api/user/register")

    public void register(@Valid @RequestBody UserRegisterRequest userData){


            userRegisterServices.register(userData);
    }
    
}
