package com.devsenior.nmanja.demo_record.controller;

import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.demo_record.model.dto.UsuarioRequest;
import com.devsenior.nmanja.demo_record.model.dto.UsuarioResponse;
import com.devsenior.nmanja.demo_record.service.UsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public UsuarioResponse postMethodName(@Valid @RequestBody UsuarioRequest body) {
        //TODO: process POST request
        
        return usuarioService.guardarUsuario(body);
    }
    
    
}
