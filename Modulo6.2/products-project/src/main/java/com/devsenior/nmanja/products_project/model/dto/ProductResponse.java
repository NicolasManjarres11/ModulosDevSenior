package com.devsenior.nmanja.products_project.model.dto;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductResponse {
    
    private String name;

    private Double price;

    private String description;

    private List<String> tags;

    private Map<String, Object> specifications;

}
