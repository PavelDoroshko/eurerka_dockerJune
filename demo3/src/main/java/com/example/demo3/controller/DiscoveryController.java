package com.example.demo3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscoveryController {

    @GetMapping("/dog")
    public  String dog(){
        return "dog dog dog";
    }
}
