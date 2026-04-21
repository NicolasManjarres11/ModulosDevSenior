package com.devsenior.nmanja.products_project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.nmanja.products_project.mapper.ProductMapper;
import com.devsenior.nmanja.products_project.model.dto.ProductRequest;
import com.devsenior.nmanja.products_project.model.dto.ProductResponse;
import com.devsenior.nmanja.products_project.repository.ProductRepository;
import com.devsenior.nmanja.products_project.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductResponse> getAll() {

        var products = productRepository.findAll().stream()
            .map(productMapper::toResponse)
            .toList();
        return products;
    }

    @Override
    public ProductResponse getBtId(String id) {
        var response = productRepository.findById(id).orElseThrow();
        return productMapper.toResponse(response);
    }

    @Override
    public List<ProductResponse> searchByText(String search) {

        if (search == null || search.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        var products = productRepository.findByTextSearch(search.trim());
        
        return products.stream()
            .map(productMapper::toResponse)
            .toList();

    }

    @Override
    public List<ProductResponse> searchByTags(String tag) {

        if (tag == null || tag.trim().isEmpty()) {
            return new ArrayList<>();
        }

        var products = productRepository.findByTagsContainingIgnoringCase(tag).stream()
            .map(productMapper::toResponse)
            .toList();

        return products;
    }

    @Override
    public List<ProductResponse> searchByspecifications(String key, String value) {
        
        var product = productRepository.findBySpecification(key, value).stream()
            .map(productMapper::toResponse)
            .toList();
    
        return product;
    }


    @Override
    public ProductResponse save(ProductRequest product) {

        var newProduct = productMapper.toDocument(product);

        newProduct = productRepository.save(newProduct);

        return productMapper.toResponse(newProduct);
    }

    @Override
    public ProductResponse update(String id, ProductRequest product) {

        var documentOptional = productRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró el producto."));

        var document = productMapper.toDocument(product);
        document.setId(documentOptional.getId());

        var updateDocument = productRepository.save(document); 


        return productMapper.toResponse(updateDocument);
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
        
    }
    
}
