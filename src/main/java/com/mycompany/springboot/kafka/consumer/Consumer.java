package com.mycompany.springboot.kafka.consumer;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Component
public class Consumer {


    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    private CountDownLatch countDownLatch = new CountDownLatch(1);


    @KafkaListener(topics = "${kafka.topic.messages}")
    public void receive(ConsumerRecord<?,?> consumerRecord){

        logger.info("Received payload : ", consumerRecord.toString());

        countDownLatch.countDown();
    }


    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }
}
