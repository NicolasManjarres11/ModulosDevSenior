package com.devsenior.nmanja.demo_tutoria1_modulo6.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.demo_tutoria1_modulo6.model.dto.ProductDto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class ProductController {

    private List<ProductDto> products = new ArrayList<>(Arrays.asList(
        new ProductDto("Laptop", 1000),
        new ProductDto("Mouse", 20),
        new ProductDto("Keyboard", 30),
        new ProductDto("Monitor", 150)
    ));


    @GetMapping("/products")
    public List<ProductDto> getAll(){
        return products;
    }

    @GetMapping("/products/{id}")
    public ProductDto getById(@PathVariable int id){
        return products.get(id);
    }

    @PostMapping("/products")
    public ProductDto create(@RequestBody ProductDto product){
        products.add(product);
        return product;
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable int id){
        products.remove(id);
    }

    @PutMapping("/products/{id}")
    public ProductDto update(@PathVariable int id, @RequestBody ProductDto product){
        products.set(id, product);
        return product;
    }
}
