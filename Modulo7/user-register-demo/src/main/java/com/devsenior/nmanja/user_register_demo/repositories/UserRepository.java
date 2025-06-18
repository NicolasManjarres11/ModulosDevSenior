package com.devsenior.nmanja.user_register_demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.nmanja.user_register_demo.models.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
    
}
