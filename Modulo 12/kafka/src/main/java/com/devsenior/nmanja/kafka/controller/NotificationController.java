package com.devsenior.nmanja.kafka.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.kafka.service.PublisherService;


@RestController
@RequestMapping("/api")
public class NotificationController {

    private final PublisherService publisherService;

    public NotificationController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping("/notification")
    public String sendNotification(@RequestBody String notification) {

        publisherService.sendToKafka(notification);
        
        return "Evento publicado con exito: %s".formatted(notification);
    }
    
    
}
