package com.devsenior.nmanja.user_login.service;

import java.util.List;

import com.devsenior.nmanja.user_login.model.dto.RegisterRequest;
import com.devsenior.nmanja.user_login.model.dto.UserRequest;
import com.devsenior.nmanja.user_login.model.dto.UserResponse;

public interface UserService {
    
    List<UserResponse> getAll();

    UserResponse create(UserRequest entity);
}
