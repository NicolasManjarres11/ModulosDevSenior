package com.devsenior.nmanja.course_security.service;

import com.devsenior.nmanja.course_security.model.dto.AuthenticationRequest;
import com.devsenior.nmanja.course_security.model.dto.AuthenticationResponse;

public interface AuthenticationService {

    AuthenticationResponse login(AuthenticationRequest credentials);
    
}
