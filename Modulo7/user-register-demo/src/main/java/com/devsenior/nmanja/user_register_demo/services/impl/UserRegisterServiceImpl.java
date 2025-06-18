package com.devsenior.nmanja.user_register_demo.services.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.devsenior.nmanja.user_register_demo.exception.UserAlreadyExitsException;
import com.devsenior.nmanja.user_register_demo.mapper.UserMapper;
import com.devsenior.nmanja.user_register_demo.models.dto.UserRegisterRequest;
import com.devsenior.nmanja.user_register_demo.repositories.UserRepository;
import com.devsenior.nmanja.user_register_demo.services.UserRegisterServices;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class UserRegisterServiceImpl implements UserRegisterServices{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void register(UserRegisterRequest user) {

        var oldUser = userRepository.findById(user.getUserName());

        if(oldUser.isPresent()){
            throw new UserAlreadyExitsException();
        }

        var entity = userMapper.toEntity(user);
        entity.setHireDate(LocalDateTime.now());
        
        userRepository.save(entity);
        
    }
    
}
