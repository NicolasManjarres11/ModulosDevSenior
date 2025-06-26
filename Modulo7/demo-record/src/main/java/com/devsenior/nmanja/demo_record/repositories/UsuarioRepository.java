package com.devsenior.nmanja.demo_record.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.nmanja.demo_record.model.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
}
