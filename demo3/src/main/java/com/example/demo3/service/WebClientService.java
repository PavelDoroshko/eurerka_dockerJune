package com.example.demo3.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebClientService {


    public String getWebClient() {
        WebClient webClient = WebClient.create();
        Mono<String> mono = webClient.get().uri("http://localhost:8003/demo/client/client").retrieve().bodyToMono(String.class);
        return mono.block();
    }
}
