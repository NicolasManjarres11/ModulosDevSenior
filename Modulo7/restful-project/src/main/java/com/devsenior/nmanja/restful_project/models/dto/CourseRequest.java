package com.devsenior.nmanja.restful_project.models.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class CourseRequest {

    @NotNull    
    private String name;

    @NotNull    

    private String code;

    private String description;

    @NotNull
    private String initialDate;

    private String finalDate;

    private Integer creditsNum;
    
}
