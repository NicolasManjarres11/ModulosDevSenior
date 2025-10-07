package com.devsenior.nmanja.messaging_app.service;

import java.util.List;

import com.devsenior.nmanja.messaging_app.model.dto.UserRequest;
import com.devsenior.nmanja.messaging_app.model.dto.UserResponse;

public interface UserService {

    List<UserResponse> getAll();
    UserResponse getByUsername(String username);
    UserResponse create(UserRequest userInfo);
    UserResponse update(String username, UserRequest userInfo);
    void delete(String username);
    
}
