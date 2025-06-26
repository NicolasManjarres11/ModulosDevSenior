package com.devsenior.nmanja.demo_record.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UsuarioResponse(

    Long id,
    
    @JsonProperty("first_name")
    String name, 
    
    @JsonProperty("last_name")
    String lastname, 
    
    String phonenumber, 

    @JsonProperty("email")
    String email,

    @JsonProperty("age")
    Integer age

) {


} 
