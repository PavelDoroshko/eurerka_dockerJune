package com.example.demo6.service;

import lombok.RequiredArgsConstructor;
import org.apache.activemq.artemis.api.core.RoutingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.io.Serializable;

@Service
@RequiredArgsConstructor
public class JMSService  {

    @Autowired
    private  JmsTemplate jms;

    public  void sendOder( Object oder){



        jms.send("sssss",new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage("dddd");
               // ObjectMessage objectMessage = session.createObjectMessage((Serializable) oder);

                return objectMessage;
            }
        });


    }

}
