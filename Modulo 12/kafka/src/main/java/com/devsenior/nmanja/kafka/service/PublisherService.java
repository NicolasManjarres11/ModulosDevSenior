package com.devsenior.nmanja.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class PublisherService {

    private static final Logger LOG = LoggerFactory.getLogger(PublisherService.class);
    
    private final KafkaTemplate<String, String> kafkaTemplate;

    public PublisherService(KafkaTemplate<String, String> kafkaTemplate){

        this.kafkaTemplate = kafkaTemplate;

    }


    public void sendToKafka(String message){
        LOG.info("Publicando evento hacia Kafka: {}", message);
        kafkaTemplate.send("topic-notifications", message);
    }


}
