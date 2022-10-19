package com.example.kafkaproject.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    public static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String, String> stringStringKafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> stringStringKafkaTemplate) {
        this.stringStringKafkaTemplate = stringStringKafkaTemplate;
    }

    public void sendingMessage(String message) {
        stringStringKafkaTemplate.send("JaswanthKafka", message);

    }
}
