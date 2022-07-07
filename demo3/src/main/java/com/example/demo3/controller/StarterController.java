package com.example.demo3.controller;

import com.example.demo3.dto.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarterController {

    private static  final Logger LOG = LoggerFactory.getLogger(StarterController.class);


    @PostMapping("/starter")
    public  String getSignedMessage(@RequestBody Message message){
        LOG.info("метод контроллера стартера" + message.getUserName());
        return message.getHeader() + "\n\n" + message.getBody() + "\n\n" +message.getUserName();
    }
}
