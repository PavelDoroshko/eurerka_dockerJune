package com.example.demo3.feign;

import com.example.demo3.dto.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "demo2")
public interface FeignEurikaService {

    @GetMapping("demo/feign/feignEurika")
    String getFeignEurika();

    @PostMapping("demo/feign/feignPostEurika")
    String getFeignPostEurika(@RequestBody Message message);
}
