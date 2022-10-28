package com.example.demo3.controller;

import com.example.demo3.service.HystrixService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HystrixController {

    private final HystrixService hystrixService;

    @GetMapping("/hystrix/{name}")
    String getName(@PathVariable("name") String name) {
        return hystrixService.getName(name);
    }
}
