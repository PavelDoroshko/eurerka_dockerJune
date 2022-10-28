package com.example.demo3.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "firstFeign", url = "http://localhost:8003/demo/feign")
public interface FeignService {

    @GetMapping("/feign")
    String getFeign();


}
