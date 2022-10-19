package com.example.kafkaproject.newTopic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {
    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder.name("JaswanthKafka").build();
    }


    @Bean
    public NewTopic javaguidesJsonTopic() {
        return TopicBuilder.name(topicJsonName)
                .build();
    }

}
