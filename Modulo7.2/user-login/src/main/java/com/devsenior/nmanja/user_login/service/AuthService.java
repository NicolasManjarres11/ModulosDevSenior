package com.devsenior.nmanja.user_login.service;

import com.devsenior.nmanja.user_login.model.dto.LoginRequest;
import com.devsenior.nmanja.user_login.model.dto.LoginResponse;
import com.devsenior.nmanja.user_login.model.dto.RegisterRequest;
import com.devsenior.nmanja.user_login.model.dto.RegisterResponse;


public interface AuthService {
    
    RegisterResponse register(RegisterRequest userInfo);

    LoginResponse login(LoginRequest body);

}
