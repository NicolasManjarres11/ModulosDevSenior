package com.devsenior.nmanja.jpa_demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.nmanja.jpa_demo.model.entity.City;

public interface CityRepository extends JpaRepository<City, String>{

    // 'A%' -> Empieza con A
    // '%A' -> Termina con A
    // '%A% - > Contiene una A en su contenido
    // '% A %' -> espacio + A + espacio
    // '_A%' -> Empieza con cualquier digito y le procede la A
    //SELECT * FROM ciudad WHERE LOWER(departamento) LIKE LOWER('%A%')
    
    List<City> findByDepartment(String department);
    
}
