package com.devsenior.nmanja.demo_tutoria1_modulo6.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.devsenior.nmanja.demo_tutoria1_modulo6.model.dto.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



//Clase controladora para el recurso usuario
@RestController //Controlador de tipo REST
public class UserController {

    private List<UserDto> users = new ArrayList<>(Arrays.asList(
        new UserDto("John Smith", "john.smith@email.com", "pass123", true),
        new UserDto("Maria Garcia", "maria.garcia@email.com", "pass456", true), 
        new UserDto("James Wilson", "james.wilson@email.com", "pass789", true),
        new UserDto("Sarah Johnson", "sarah.j@email.com", "pass321", false),
        new UserDto("Michael Brown", "michael.b@email.com", "pass654", true),
        new UserDto("Emma Davis", "emma.davis@email.com", "pass987", true),
        new UserDto("David Miller", "david.m@email.com", "pass147", true),
        new UserDto("Lisa Anderson", "lisa.a@email.com", "pass258", false),
        new UserDto("Robert Taylor", "robert.t@email.com", "pass369", true),
        new UserDto("Jennifer White", "jennifer.w@email.com", "pass741", true)
    ));

    @GetMapping("/users")

    public List<UserDto> getAll() {
        return users;
    }

    @GetMapping("/users/{id}")
    public UserDto getById(@PathVariable int id) {
        return users.get(id); //No se busca a partir de los datos sino a partir de la posisicón en la lista
    }

    @PostMapping("/users")
    public UserDto create(@RequestBody UserDto user){
        users.add(user);
        return user;
    }

    @DeleteMapping("/users/{id}")

    public void delete(@PathVariable int id){
        users.remove(id);
    }

    
}
