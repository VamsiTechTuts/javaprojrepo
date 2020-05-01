package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "orders-status";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String jsonData) {
        logger.info(String.format("#### -> Producing message -> %s", jsonData));
        this.kafkaTemplate.send(TOPIC, jsonData);
    }
}