package com.devsenior.nmanja.user_register_demo.models.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_name", length = 20)
    private String userName;

    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "phone",  length = 15)
    private String phoneNumber;

    @Column(name = "city",  length = 100)
    private String city;
    
    @Column(name = "hire_date", nullable = false)
    private LocalDateTime hireDate;
}
