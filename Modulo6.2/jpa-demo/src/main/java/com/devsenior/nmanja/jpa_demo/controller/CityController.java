package com.devsenior.nmanja.jpa_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.jpa_demo.model.DTO.CityUpdateRequest;
import com.devsenior.nmanja.jpa_demo.model.entity.City;
import com.devsenior.nmanja.jpa_demo.service.CityService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> getAll() {
        return cityService.getAll();
    }

    @GetMapping("/by_department/{name}")
    public List<City> getByDepartment(@PathVariable String name) {
        return cityService.findByDepartment(name);
    }
    

    @PostMapping
    public City postMethodName(@RequestBody City city) {
        
        return cityService.save(city);
    }

    @PutMapping("/{city}")
    public City update(@PathVariable String city, @RequestBody CityUpdateRequest data) {
        //TODO: process PUT request
        
        return cityService.update(city, data);
    }
    
    
    
}
