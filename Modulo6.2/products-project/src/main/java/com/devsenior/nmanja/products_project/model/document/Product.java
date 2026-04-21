package com.devsenior.nmanja.products_project.model.document;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "productos")
public class Product {
    
    @Id
    private String id;

    @Field("nombre")
    private String name;

    @Field("precio")
    private Double price;

    @Field("descripcion")
    private String description;

    @Field("tags")
    private List<String> tags;

    @Field("especificaciones")
    private Map<String, Object> specifications;
}
