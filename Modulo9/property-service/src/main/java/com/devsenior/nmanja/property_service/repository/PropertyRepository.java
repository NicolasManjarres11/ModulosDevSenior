package com.devsenior.nmanja.property_service.repository;

import com.devsenior.nmanja.property_service.model.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    
    // Buscar propiedades por ciudad
    List<Property> findByCity(String city);
}
