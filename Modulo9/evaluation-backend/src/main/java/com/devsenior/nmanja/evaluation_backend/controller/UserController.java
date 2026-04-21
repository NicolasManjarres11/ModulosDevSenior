package com.devsenior.nmanja.evaluation_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.evaluation_backend.model.dto.UserRequestDto;
import com.devsenior.nmanja.evaluation_backend.model.dto.UserResponseDto;
import com.devsenior.nmanja.evaluation_backend.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


//RestFul Service -> GET, POST, PUT, DELETE
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{code}")
    public UserResponseDto findByCode(@PathVariable @Valid Long code) {
        return userService.getByCode(code);
    }

    @PostMapping
    public UserResponseDto create(@RequestBody @Valid UserRequestDto user) {
        return userService.create(user);
    }

    @PutMapping("/{code}")
    public UserResponseDto updateUser(@PathVariable Long code, @RequestBody 
    @Valid UserRequestDto user) {
        return userService.update(code, user);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{code}")
    public void deleteUser(@PathVariable Long code) {
        userService.delete(code);
    }
    
}
