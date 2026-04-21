package com.devsenior.nmanja.actuator_postgresql.mapper;

import org.springframework.stereotype.Component;

import com.devsenior.nmanja.actuator_postgresql.model.dto.ProductRequestDTO;
import com.devsenior.nmanja.actuator_postgresql.model.dto.ProductResponseDTO;
import com.devsenior.nmanja.actuator_postgresql.model.entity.Product;

@Component
public class ProductMapper {

    public ProductResponseDTO toResponseDTO(Product product) {
        if (product == null) {
            return null;
        }

        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .imageUrl(product.getImageUrl())
                .build();
    }

    public Product toEntity(ProductRequestDTO productRequestDTO) {
        if (productRequestDTO == null) {
            return null;
        }

        return Product.builder()
                .name(productRequestDTO.getName())
                .description(productRequestDTO.getDescription())
                .price(productRequestDTO.getPrice())
                .imageUrl(productRequestDTO.getImageUrl())
                .build();
    }

    public void updateEntityFromRequest(Product product, ProductRequestDTO productRequestDTO) {
        if (product == null || productRequestDTO == null) {
            return;
        }

        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setImageUrl(productRequestDTO.getImageUrl());
    }
}