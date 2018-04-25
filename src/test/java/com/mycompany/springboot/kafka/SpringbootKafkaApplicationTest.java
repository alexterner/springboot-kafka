package com.mycompany.springboot.kafka;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.mycompany.springboot.kafka.consumer.Consumer;
import com.mycompany.springboot.kafka.producer.Producer;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple SpringbootKafkaApplication.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootKafkaApplicationTest
{

    private static String TOPIC = "messages.t";

    @Autowired
    private Producer producer;

    @Autowired
    private Consumer consumer;


    @ClassRule
    public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, TOPIC);

    @Test
    public void kafkaTest() throws InterruptedException {

        producer.send(TOPIC, "Hello, World.");

        consumer.getCountDownLatch().await(10, TimeUnit.SECONDS);

        assertEquals(0L, consumer.getCountDownLatch().getCount());
    }
}
