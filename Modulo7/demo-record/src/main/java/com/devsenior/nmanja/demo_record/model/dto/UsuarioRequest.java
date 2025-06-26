package com.devsenior.nmanja.demo_record.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

//Clase inmutable, no hay forma de cambiar los valores de los atributos asignados
public record UsuarioRequest(
    @NotBlank(message = "El nombre es obligatorio")
    @JsonProperty("first_name")
    String name, 

    @NotBlank(message = "El apellido es obligatorio")
    @JsonProperty("last_name")
    String lastname, 


    @JsonProperty("phone_number")
    String phonenumber, 

    @Email(message = "El correo no tiene un formato válido")
    @JsonProperty("email")
    String email,

    @Min(value = 0, message="La edad no puede ser menos que 0")
    @Max(value = 120, message="La edad no puede ser mayor que 120")
    @JsonProperty("age")
    Integer age
    ) {

        public String nombreCompleto(){

            return name + " " + lastname;
        }

        //Constructor compacto
        //Condicionales para inicializar los atributos de la clase
/*         public Usuario {

            if(age < 0){
                age = 0;
            } else if (age > 120){
                age = 120;
            }
        } */

        public UsuarioRequest(String name, String lastname){
            this(name, lastname, "", "sin email", -1);
        }
    
}
