package com.devsenior.nmanja.spring_security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/hello")
public class HelloWorldController {
    

    @GetMapping
    public Map<String, Object> getHelloWorld() {
        return Map.of("message", "Hello World!");
    }

    @PostMapping
    public Map<String, Object> postHelloWorld(@RequestBody Map<String, Object> body) {
        return Map.of("message", "Hello "+body.get("name"));
    }

    
    
}
