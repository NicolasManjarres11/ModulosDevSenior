package com.devsenior.nmanja.products_project.mapper;

import com.devsenior.nmanja.products_project.model.document.Product;
import com.devsenior.nmanja.products_project.model.dto.ProductRequest;
import com.devsenior.nmanja.products_project.model.dto.ProductResponse;

public class ProductMapper {
    

    public Product toDocument(ProductRequest product){

        var response = new Product();

        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setDescription(product.getDescription());
        response.setTags(product.getTags());
        response.setSpecifications(product.getSpecifications());

        return response;
    }

    public ProductResponse toResponse(Product product){

        var response = new ProductResponse(
        product.getName(),
        product.getPrice(),
        product.getDescription(),
        product.getTags(),
        product.getSpecifications()
        );

        return response;
        
    }
}
