package com.example.demo6.model;

import io.netty.buffer.ByteBuf;
import org.apache.activemq.artemis.api.core.*;
import org.apache.activemq.artemis.core.persistence.CoreMessageObjectPools;
import org.apache.activemq.artemis.core.persistence.Persister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Set;

public class Sender {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void send(String message) {

            jmsTemplate.convertAndSend("helloworld.q", message);


    }

    public void sendKafka(String payload) {
        kafkaTemplate.send("helloworld.t", payload);
    }

}
