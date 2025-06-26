package com.devsenior.nmanja.demo_record.service;

import org.springframework.stereotype.Service;

import com.devsenior.nmanja.demo_record.mapper.UsuarioMapper;
import com.devsenior.nmanja.demo_record.model.dto.UsuarioRequest;
import com.devsenior.nmanja.demo_record.model.dto.UsuarioResponse;
import com.devsenior.nmanja.demo_record.model.entities.Usuario;
import com.devsenior.nmanja.demo_record.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioResponse guardarUsuario (UsuarioRequest user){
        //Guardar usuario em BD

        var entity = usuarioMapper.toEntity(user);

        entity = usuarioRepository.save(entity);

        var response = usuarioMapper.toResponse(entity);

        return response;
    }
    
}
