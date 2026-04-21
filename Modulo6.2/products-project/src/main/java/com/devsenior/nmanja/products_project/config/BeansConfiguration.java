package com.devsenior.nmanja.products_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.devsenior.nmanja.products_project.mapper.ProductMapper;

@Configuration
public class BeansConfiguration {
    
    @Bean
    ProductMapper productMapper(){
        return new ProductMapper();
    }
}
