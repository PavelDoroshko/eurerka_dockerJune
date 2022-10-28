package com.example.demo5.model;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.kafka.annotation.KafkaListener;

public class Reciver {

    @JmsListener(destination = "sssss")
    public void receive(String message) {

        System.out.println(message+" Demo5");
    }

    @KafkaListener(topics = "helloworld.t")
    public void receiveKafka(String payload) {
        System.out.println(payload);
    }

    }

