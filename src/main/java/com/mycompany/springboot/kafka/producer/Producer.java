package com.mycompany.springboot.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, String>  kafkaTemplate;


    public void send(String topic, String payload){

        logger.info("Send to topic :" + topic + ", payload : " + payload);

        kafkaTemplate.send(topic, payload);
    }

}
