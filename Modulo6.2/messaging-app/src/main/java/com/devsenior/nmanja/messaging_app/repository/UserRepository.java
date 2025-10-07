package com.devsenior.nmanja.messaging_app.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devsenior.nmanja.messaging_app.model.document.User;

public interface UserRepository extends MongoRepository<User, String>{
    
    Optional<User> findByEmail(String email);

}
