package com.devsenior.nmanja.evaluation_backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devsenior.nmanja.evaluation_backend.model.entity.Role;
import com.devsenior.nmanja.evaluation_backend.model.entity.User;

public interface UserRepository extends MongoRepository<User, String>{

    /**
     * Busca un usuario por su código
     */
    Optional<User> findByCode(Long code);
    
    /**
     * Verifica si existe un usuario con el código especificado
     */
    boolean existsByCode(Long code);
    
    /**
     * Verifica si existe un usuario con el username especificado
     */
    boolean existsByUsername(String username);
    
    /**
     * Busca un usuario por username
     */
    Optional<User> findByUsername(String username);

    List<User> findAllByRole(Role role);
    
}
