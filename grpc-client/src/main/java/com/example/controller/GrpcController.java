package com.example.controller;

import com.example.service.GrpcConnect;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GrpcController {

private final GrpcConnect grpcConnect;

    @GetMapping("/grpc/{world}")
    public String getGrpc(@PathVariable("world") String world) {
        return grpcConnect.getConnect(world);
    }

    @GetMapping("/grpc/stream/{world}")
    public List<String> getGrpcStream(@PathVariable("world") String world) {
        return grpcConnect.getConnectStream(world);
    }
}
