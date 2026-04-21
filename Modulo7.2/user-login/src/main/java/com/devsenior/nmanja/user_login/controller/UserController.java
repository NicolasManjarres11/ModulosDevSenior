package com.devsenior.nmanja.user_login.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.user_login.model.dto.RegisterRequest;
import com.devsenior.nmanja.user_login.model.dto.RegisterResponse;
import com.devsenior.nmanja.user_login.model.dto.UserRequest;
import com.devsenior.nmanja.user_login.model.dto.UserResponse;
import com.devsenior.nmanja.user_login.service.UserService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAll();
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public UserResponse create(@RequestBody UserRequest entity) {
        //TODO: process POST request
        
        return userService.create(entity);
    }

    @PreAuthorize("hasRole('ADMIN') or principal.username == #username")
    @PutMapping("{id}")
    public UserResponse update(@PathVariable String username, @RequestBody UserRequest entity) {
        //TODO: process PUT request
        
        return null;
    }

    @PreAuthorize("hasRole('ADMIN') or principal.username == #username")
    @PatchMapping("/{username}/inactivate")
    public void inactivate(@PathVariable String username){

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete (@PathVariable String id){

    }
    
    
}
