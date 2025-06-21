package com.devsenior.nmanja.course_security.service.impl;

import com.devsenior.nmanja.course_security.model.dto.AuthenticationRequest;
import com.devsenior.nmanja.course_security.model.dto.AuthenticationResponse;
import com.devsenior.nmanja.course_security.repository.UserRepository;
import com.devsenior.nmanja.course_security.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

    private final UserRepository userRepository;

    @Override
    public AuthenticationResponse login(AuthenticationRequest credentials) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
