package com.devsenior.nmanja.reactive.controller;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.reactive.model.SensorData;
import com.devsenior.nmanja.reactive.service.SensorService;

import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/api/sensor")
@CrossOrigin("http://localhost:4200")
public class SensorController {

    private final SensorService sensorService;
    
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping(value="/stream", produces= MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<SensorData> getTemperatures() {
        return sensorService.getLiveSensorData();
    }
    
}
