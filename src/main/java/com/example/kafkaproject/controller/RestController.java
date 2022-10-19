package com.example.kafkaproject.controller;


import com.example.kafkaproject.kafka.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1/kafka")
public class RestController {
    public static final Logger LOGGER = LoggerFactory.getLogger(RestController.class);
    private KafkaProducer kafkaProducer;


    public RestController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    //
    @GetMapping("/publish")
    public ResponseEntity<String> stringResponseEntity(@RequestParam("Message") String message) {
        kafkaProducer.sendingMessage(message);
        LOGGER.debug("the message value is %s", message);
        return ResponseEntity.ok("Message sent to the topic succesfully");
    }
}
