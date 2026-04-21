package com.devsenior.nmanja.user_login.model.entity;

import java.time.LocalDate;

import com.devsenior.nmanja.user_login.model.shared.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder //Genera un Builder, se requiere un constructor con todos los argumentos
@AllArgsConstructor //Para que funcione Builder
@NoArgsConstructor  //Para que funcione JPA
@Data
@Entity
@Table(name = "users")
public class User {
    
    @Id
    private String username;

    private String name;

    private String email;

    private String password;

    private LocalDate hireDate;

    private boolean isActive;

    private Role role;


}
