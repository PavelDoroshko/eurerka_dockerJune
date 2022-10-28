package com.example.demo3.service;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HystrixService {

 //  @HystrixCommand(fallbackMethod = "defaultGetName")
    public String getName(String name) {
        return new RestTemplate()
                .getForObject("http://localhost:8003/demo/hystrix/{name}", String.class, name);

    }

    private String defaultGetName(String name) {
        return "Hello" + name;
    }

}
