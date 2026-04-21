package com.devsenior.nmanja.evaluation_backend.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "usuarios")
public class User {
    
    @Id
    private String id;
    private Long code;
    private String name;
    private Role role;
    private String username;
    private String password;

}
