package com.devsenior.nmanja.demo_record.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.devsenior.nmanja.demo_record.model.dto.UsuarioRequest;
import com.devsenior.nmanja.demo_record.model.dto.UsuarioResponse;
import com.devsenior.nmanja.demo_record.model.entities.Usuario;

@Mapper(componentModel = "spring") //Con esta instruccion simulamos un Bean
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    
    @Mapping(target = "id", ignore = true)
    Usuario toEntity(UsuarioRequest request);


    UsuarioResponse toResponse(Usuario usuario);


}