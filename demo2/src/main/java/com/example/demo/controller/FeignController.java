package com.example.demo.controller;


import com.example.demo.dto.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feign")
@RequiredArgsConstructor
public class FeignController {

    @GetMapping("/feign")
    public String getFeign() {

        String forObject = "feign hello";
        return forObject;
    }

    @GetMapping("/feignEurika")
    public String getFeignEurika() {

        String forObject = "feign + eurika  hello";
        return forObject;
    }

    @PostMapping("/feignPostEurika")
    public String getFeignPostEurika(@RequestBody Message message) {

        String forObject = message.getUserName() + " " + message.getHeader() + " " + message.getBody();
        return forObject;
    }
}
