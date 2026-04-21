package com.devsenior.nmanja.spring_security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/public")
public class PublicController {
    

    @GetMapping
    public String getPublicData() {
        return "Este es un endpoing público";
    }
    
}
