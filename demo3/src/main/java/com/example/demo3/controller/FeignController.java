package com.example.demo3.controller;

import com.example.demo3.dto.Message;
import com.example.demo3.feign.FeignEurikaService;
import com.example.demo3.feign.FeignService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FeignController {

   @Autowired
    private  FeignService feignService;
    @Autowired
    private  FeignEurikaService feignEurikaService;


    @GetMapping("/feign")
    public String getFeign() {

        return feignService.getFeign();
    }

    @GetMapping("/feignEurika")
    public String getFeignEurika() {

        return feignEurikaService.getFeignEurika();
    }

    @PostMapping("/postFeign")
    public String getFeignPostEurika(@RequestBody Message message) {

        return feignEurikaService.getFeignPostEurika(message);
    }
}
