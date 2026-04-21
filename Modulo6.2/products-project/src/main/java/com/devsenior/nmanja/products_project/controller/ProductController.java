package com.devsenior.nmanja.products_project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.products_project.model.dto.ProductRequest;
import com.devsenior.nmanja.products_project.model.dto.ProductResponse;
import com.devsenior.nmanja.products_project.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RequiredArgsConstructor
@RestController
@RequestMapping("/api/productos")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductResponse> getAll() {
        return productService.getAll();
    }

    @GetMapping("/especificaciones")
    public List<ProductResponse> searchBySpecifications(
        @RequestParam("key") String key, 
        @RequestParam("value") String value) {
        return productService.searchByspecifications(key,value);
    }
    

    @GetMapping("/por-tag")
    public List<ProductResponse> searchByTag(@RequestParam("tag") String tag) {
        return productService.searchByTags(tag);
    }

    @GetMapping("/buscar")
    public List<ProductResponse> searchByText(@RequestParam String text) {
        return productService.searchByText(text);
    }


    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable String id) {
        return productService.getBtId(id);
    }




    
    

    @PostMapping
    public ProductResponse save(@Valid @RequestBody ProductRequest product) {
        
        return productService.save(product);
    }
    
    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable String id, @RequestBody ProductRequest product) {
        
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        productService.delete(id);
    }
    
    
    
}
