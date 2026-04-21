package com.devsenior.java.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.java.hr.model.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String>{
    
}
