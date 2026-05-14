package com.devsenior.nmanja.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.devsenior.nmanja.reactive.model.SensorData;

public interface SensorRepository extends  ReactiveCrudRepository<SensorData, Long>{
    
    


}
