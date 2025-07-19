package com.devsenior.nmanja.service_layer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.service_layer.model.User;
import com.devsenior.nmanja.service_layer.service.LibraryService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private LibraryService libraryService;
    
    @GetMapping
    public List<User> getAllUsers() {
        return libraryService.findAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return libraryService.findUserById(id);
    }
}
