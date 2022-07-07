package com.example.grpc.rpc;

import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.GreetingServiceOuterClass;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    public void greeting(GreetingServiceOuterClass.HelloRequest request,
                         StreamObserver<GreetingServiceOuterClass.HelloResponse> responseStreamObserver) {
        System.out.println(request);
        GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass.HelloResponse
                .newBuilder()
                .setGreeting("hello" + request.getName())
                .build();
        responseStreamObserver.onNext(response);

        responseStreamObserver.onCompleted();
    }

    public void greetingStream(GreetingServiceOuterClass.HelloRequest request,
                               StreamObserver<GreetingServiceOuterClass.HelloResponse> responseStreamObserver) {

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(request);
            GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass.HelloResponse
                    .newBuilder()
                    .setGreeting("hello" + request.getName())
                    .build();
            responseStreamObserver.onNext(response);
        }

        responseStreamObserver.onCompleted();
    }
}
