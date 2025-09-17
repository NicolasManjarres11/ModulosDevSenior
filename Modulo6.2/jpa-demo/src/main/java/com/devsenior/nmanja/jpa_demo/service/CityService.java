package com.devsenior.nmanja.jpa_demo.service;

import java.util.List;

import com.devsenior.nmanja.jpa_demo.model.DTO.CityUpdateRequest;
import com.devsenior.nmanja.jpa_demo.model.entity.City;

public interface CityService {

    List<City> getAll();

    List<City> findByDepartment(String name);

    City save( City city);

    City update(String city, CityUpdateRequest data);
    
}
