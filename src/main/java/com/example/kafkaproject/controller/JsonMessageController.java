package com.example.kafkaproject.controller;

import com.example.kafkaproject.kafka.JsonKafkaProducer;
import com.example.kafkaproject.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    public static final Logger LOGGER = LoggerFactory.getLogger(JsonMessageController.class);


    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer JsonkafkaProducer) {
        this.kafkaProducer = JsonkafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        LOGGER.debug("the user date value is %s", user.toString());
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
