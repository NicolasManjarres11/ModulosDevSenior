package com.devsenior.nmanja.user_login.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.nmanja.user_login.mapper.UserMapper;
import com.devsenior.nmanja.user_login.model.dto.RegisterRequest;
import com.devsenior.nmanja.user_login.model.dto.UserRequest;
import com.devsenior.nmanja.user_login.model.dto.UserResponse;
import com.devsenior.nmanja.user_login.model.entity.User;
import com.devsenior.nmanja.user_login.repository.UserRepository;
import com.devsenior.nmanja.user_login.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> getAll() {
        // TODO Auto-generated method stub
        return userRepository.findAll().stream()
                .map(u -> UserResponse.builder()
                        .name(u.getName())
                        .username(u.getUsername())
                        .hireDate(u.getHireDate())
                        .isActive(u.isActive())
                        .email(u.getEmail())
                        .role(u.getRole())
                .build())
                .toList();
    }


    @Override
    public UserResponse create(UserRequest entity) {
        var user = User.builder()
        .name(entity.getName())
        .username(entity.getUsername())
        .hireDate(LocalDate.now())
        .isActive(true)
        .email(entity.getEmail())
        .role(entity.getRole())
        
        
        .build();

        user = userRepository.save(user);



        return UserResponse.builder()
        .name(user.getName())
        .username(user.getUsername())
        .hireDate(user.getHireDate())
        .isActive(user.isActive())
        .email(user.getEmail())
        .role(user.getRole())
        .build();
    }
    
}
