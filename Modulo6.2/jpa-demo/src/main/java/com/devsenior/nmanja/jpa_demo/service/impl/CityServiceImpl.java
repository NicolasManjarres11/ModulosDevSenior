package com.devsenior.nmanja.jpa_demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.nmanja.jpa_demo.model.DTO.CityUpdateRequest;
import com.devsenior.nmanja.jpa_demo.model.entity.City;
import com.devsenior.nmanja.jpa_demo.repository.CityRepository;
import com.devsenior.nmanja.jpa_demo.service.CityService;

@Service

public class CityServiceImpl implements CityService{

    private final CityRepository cityRepository;

    //Inyección de dependencia
    public CityServiceImpl(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getAll() {
        var city = cityRepository.findAll();
        return city;
    }

    @Override
    public List<City> findByDepartment(String name) {
        // TODO Auto-generated method stub
        return cityRepository.findByDepartment(name);
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }
    
    @Override
    public City update(String city, CityUpdateRequest data) {

        return cityRepository.save(new City(city, data.getDepartment()));
    }
}
