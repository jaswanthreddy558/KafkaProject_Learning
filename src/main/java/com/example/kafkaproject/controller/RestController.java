package com.example.kafkaproject.controller;


import com.example.kafkaproject.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1/kafka")
public class RestController {
    private KafkaProducer kafkaProducer;


    public RestController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

// localhost:8080/api/v1/kafka/publish?helloworld
    @GetMapping("/publish")
    public ResponseEntity<String> stringResponseEntity(@RequestParam("Message") String message) {
        kafkaProducer.sendingMessage(message);
        return ResponseEntity.ok("Message sent to the topic succesfully");
    }
}
