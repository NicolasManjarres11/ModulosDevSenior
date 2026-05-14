package com.devsenior.nmanja.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class ConsumerService {

        private static final Logger LOG = LoggerFactory.getLogger(ConsumerService.class);

        @KafkaListener(topics = "topic-notifications", groupId = "notification-group-1")
        public void readFromKafka(String message){
            
            LOG.info("Evento recibido desde Kafka con extio: {}", message);
        }

    
}
