package com.devsenior.nmanja.user_register_demo.mapper;

import org.springframework.stereotype.Component;

import com.devsenior.nmanja.user_register_demo.models.dto.UserRegisterRequest;
import com.devsenior.nmanja.user_register_demo.models.entities.User;


@Component
public class UserMapper {

    public User toEntity(UserRegisterRequest user){

        var response = new User();

        response.setUserName(user.getUserName());
        response.setPassword(user.getPassword());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setCity(user.getCity());


        return response;
    }

    public User toResponse(User user){

        var response = new User();

        response.setUserName(user.getUserName());
        response.setPassword(user.getPassword());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setCity(user.getCity());


        return response;
    }
    
}
