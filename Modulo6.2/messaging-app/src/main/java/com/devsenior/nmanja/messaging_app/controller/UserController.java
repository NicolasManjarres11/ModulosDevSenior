package com.devsenior.nmanja.messaging_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.messaging_app.model.dto.UserRequest;
import com.devsenior.nmanja.messaging_app.model.dto.UserResponse;
import com.devsenior.nmanja.messaging_app.service.UserService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    @PostMapping()
    public UserResponse create(@RequestBody UserRequest user) {
        //TODO: process POST request
        
        return userService.create(user);
    }

    @PutMapping("/{username}")
    public UserResponse update(@PathVariable String username, @RequestBody UserRequest user) {
        //TODO: process PUT request
        
        return userService.update(username, user);
    }

    @DeleteMapping("/username")
    public void delete(@PathVariable String username){
        userService.delete(username);
    }
    
    
    
}
