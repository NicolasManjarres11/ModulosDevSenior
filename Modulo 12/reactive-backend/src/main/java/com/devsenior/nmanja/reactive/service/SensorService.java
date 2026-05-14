package com.devsenior.nmanja.reactive.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.devsenior.nmanja.reactive.model.SensorData;
import com.devsenior.nmanja.reactive.repository.SensorRepository;

import reactor.core.publisher.Flux;


@Service
public class SensorService {
    
    private final Logger log;
    private final Random random;
    private final SensorRepository sensorRepository;

    


    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
        this.random = new Random();
        this.log = LoggerFactory.getLogger(SensorService.class);

    }




    public Flux<SensorData> getLiveSensorData(){

        return Flux.interval(Duration.ofSeconds(1))
            .map(tick -> new SensorData(
                null,
                "Motor principal",
                60.0 + (random.nextDouble() - 20),
                LocalDateTime.now()
            ))
            .flatMap(sensorRepository::save)
            .doOnNext(savedData -> log.info("Guardando y emitiendo: {}", savedData.getTemperature()))
            .share();

    }

}
