package com.devsenior.nmanja.records.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BookDto(

    @NotBlank(message ="El titulo es un campo obligatorio")
    @Size(min = 5, message="El titulo debe tener por lo menos 5 letras")
    String title,
    
    @NotBlank(message = "El autor es un campo obligatorio")
    String author,


    String description

) {


    public String reference(int type){
        return switch (type) {
            case 1 ->String.format("%s %s", title,author);
            case 2 -> String.format("%s %s", author,title);
            default -> "Error en el tipo";
    };
}

}
