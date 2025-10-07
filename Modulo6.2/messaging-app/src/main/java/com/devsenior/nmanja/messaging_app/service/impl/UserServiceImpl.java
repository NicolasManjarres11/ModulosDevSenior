package com.devsenior.nmanja.messaging_app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.nmanja.messaging_app.exception.ValidationException;
import com.devsenior.nmanja.messaging_app.exception.NotFoundException;
import com.devsenior.nmanja.messaging_app.mapper.UserMapper;
import com.devsenior.nmanja.messaging_app.model.dto.UserRequest;
import com.devsenior.nmanja.messaging_app.model.dto.UserResponse;
import com.devsenior.nmanja.messaging_app.repository.UserRepository;
import com.devsenior.nmanja.messaging_app.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse create(UserRequest userInfo) {
        // TODO Auto-generated method stub

        if(userInfo.getUsername() == null 
        || userInfo.getUsername().isBlank()){
            throw new ValidationException("El username es obligatorio");
        }

        //...

        var user = userMapper.toDocument(userInfo);
        user = userRepository.save(user);
        return userMapper.toResponse(user);
    }

    @Override
    public void delete(String username) {
        // TODO Auto-generated method stub

        if(!userRepository.existsById(username)){
            throw new NotFoundException("El usuario no existe");
        }

        userRepository.deleteById(username);
        
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll().stream()
        .filter(u -> u.getActive())
        .map(userMapper::toResponse)
        .toList();
    }

    @Override
    public UserResponse getByUsername(String username) {
        return userRepository.findById(username)
                .map(userMapper::toResponse)
                .orElseThrow(() -> new NotFoundException("El usuario no existe"));
    }

    @Override
    public UserResponse update(String username, UserRequest userInfo) {
        // TODO Auto-generated method stub
        if(userInfo.getUsername() == null 
        || userInfo.getUsername().isBlank()){
            throw new ValidationException("El username es obligatorio");
        }

        if(!userRepository.existsById(username)){
            throw new NotFoundException("El usuario no existe");
        }

        //...

        var user =userMapper.toDocument(userInfo);
        user.setUsername(username);
        user = userRepository.save(user);

        return userMapper.toResponse(user);
    }

    
    
}
