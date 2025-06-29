package com.devsenior.nmanja.course_security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.nmanja.course_security.model.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByUsername(String username);
    
    
}
