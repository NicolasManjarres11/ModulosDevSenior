package com.devsenior.nmanja.jwt_exercise.service;

import com.devsenior.nmanja.jwt_exercise.model.dto.AuthenticationRequest;
import com.devsenior.nmanja.jwt_exercise.model.dto.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse login(AuthenticationRequest credentials);
}
