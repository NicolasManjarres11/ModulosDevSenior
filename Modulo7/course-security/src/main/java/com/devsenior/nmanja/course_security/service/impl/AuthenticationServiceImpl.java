package com.devsenior.nmanja.course_security.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.devsenior.nmanja.course_security.model.dto.AuthenticationRequest;
import com.devsenior.nmanja.course_security.model.dto.AuthenticationResponse;
import com.devsenior.nmanja.course_security.repository.UserRepository;
import com.devsenior.nmanja.course_security.service.AuthenticationService;
import com.devsenior.nmanja.course_security.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService{



    private final AuthenticationManager authenticationManager; //Gesto de autenticación
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    /* private final UserRepository userRepository; */

    @Override
    public AuthenticationResponse login(AuthenticationRequest credentials) {

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword())
        );

        var userdetails = userDetailsService.loadUserByUsername(credentials.getUsername());

        var jwt = jwtUtil.generateToken(userdetails);


        return new AuthenticationResponse(jwt);
    }
    
}
