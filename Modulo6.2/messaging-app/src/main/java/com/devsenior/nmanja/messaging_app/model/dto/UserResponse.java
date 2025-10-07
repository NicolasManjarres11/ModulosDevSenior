package com.devsenior.nmanja.messaging_app.model.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    
    private String username;
    private String fullName;
    private String email;
    private String phone;
    private Set<String> intereses;
    private String profile;
    private String school;
    private String program;
    private String company;
    private String position;
    public String seniority;
}

