package com.devsenior.nmanja.products_project.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.devsenior.nmanja.products_project.model.document.Product;

public interface ProductRepository extends MongoRepository<Product,String>{
    
    @Query("{'$or': [{'nombre': {'$regex': ?0, '$options': 'i'}}, {'descripcion': {'$regex': ?0, '$options': 'i'}}]}")
    List<Product> findByTextSearch(String searchText);

    List<Product> findByTagsContainingIgnoringCase(String tag);

    @Query("{'especificaciones.?0': ?1}")
    List<Product> findBySpecification(String key, String value);
}
