package com.example.service;

import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.GreetingServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class GrpcConnect {

    public static String HOST = "localhost:8079";

    public String getConnect(String world) {

        ManagedChannel channel = ManagedChannelBuilder.forTarget(HOST)
                .usePlaintext().build();
        GreetingServiceGrpc.GreetingServiceBlockingStub stub =
                GreetingServiceGrpc.newBlockingStub(channel);
        GreetingServiceOuterClass.HelloRequest request = GreetingServiceOuterClass.HelloRequest
                .newBuilder().setName("Pasha" + " " + world).build();

        GreetingServiceOuterClass.HelloResponse response = stub.greeting(request);
        System.out.println(response);
        channel.shutdownNow();
        return response.getGreeting();
    }

    public List<String> getConnectStream(String world) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget(HOST)
                .usePlaintext().build();
        GreetingServiceGrpc.GreetingServiceBlockingStub stub =
                GreetingServiceGrpc.newBlockingStub(channel);
        GreetingServiceOuterClass.HelloRequest request = GreetingServiceOuterClass.HelloRequest
                .newBuilder().setName("Pasha" + " " + world).build();

        Iterator<GreetingServiceOuterClass.HelloResponse> response = stub.greetingStream(request);
        List<String> stringList = new ArrayList<>();
        while (response.hasNext()) {
            System.out.println(response.next());
            stringList.add(response.next().getGreeting());
        }

        channel.shutdownNow();
        return stringList;

    }
}
