package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@RestController
@RequestMapping("/eureka")
@RequiredArgsConstructor
public class DiscoveryController {

    private final RestTemplate restTemplate;
    private final DiscoveryClient client;

    @GetMapping("demo2/dogdog")
    public String dog() {
        ServiceInstance serviceInstance = client.getInstances("demo3").get(0);
        URI homeUrl = serviceInstance.getUri();
        System.out.println(homeUrl);
        System.out.println(homeUrl.getHost());
        System.out.println(homeUrl.getPort());
        String forObject = restTemplate.getForObject(homeUrl + "/demo3/dog", String.class);
        return forObject;
    }
}
