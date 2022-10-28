package com.example.demo6.controller;

import com.example.demo6.dao.IOderDao;
import com.example.demo6.model.Oder;
import com.example.demo6.model.Sender;
import com.example.demo6.service.JMSService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/oder")
//@RequiredArgsConstructor
public class OderController {
        @Autowired
        private  JMSService jmsService;
        @Autowired
        private  IOderDao iOderDao;

        @PostMapping("/post")
        public Oder postOder (@RequestBody Oder oder){
           jmsService.sendOder(oder);
            return iOderDao.save(oder);

        }
    @Autowired
    private Sender sender;

    @GetMapping("/get")
        public String get (){

        LocalDateTime now = LocalDateTime.now();

        sender.send("now-"+now);
        return "get ok";
}
    @GetMapping("/kafka")
    public String getKafka(){
        System.out.println("hhhh");
        sender.sendKafka("wwwwwwwwwwwwwwwwwwww");
        return "kafka ok";
    }



}

