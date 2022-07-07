package com.example.grpc.grpc;

import com.example.grpc.ProfileDescriptorOuterClass;
import com.example.grpc.ProfileServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class GrpcProfileService extends ProfileServiceGrpc.ProfileServiceImplBase {
    @Override
    public void getCurrentProfile(Empty request, StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> responseObserver) {
        System.out.println("getCurrentProfile");
        responseObserver.onNext(ProfileDescriptorOuterClass.ProfileDescriptor
                .newBuilder()
                .setProfileId(1)
                .setName("test")
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteCurrentProfile(Empty request, StreamObserver<Empty> responseObserver) {
        System.out.println("getCurrentProfile");
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> clientStream(StreamObserver<Empty> responseObserver) {
        return new StreamObserver<>() {

            @Override
            public void onNext(ProfileDescriptorOuterClass.ProfileDescriptor profileDescriptor) {
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void serverStream(Empty request, StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> responseObserver) {
        for (int i = 0; i < 5; i++) {
            responseObserver.onNext(ProfileDescriptorOuterClass.ProfileDescriptor
                    .newBuilder()
                    .setProfileId(i)
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> biDirectionalStream(
            StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> responseObserver) {

        return new StreamObserver<>() {
            int pointCount = 0;

            @Override
            public void onNext(ProfileDescriptorOuterClass.ProfileDescriptor profileDescriptor) {
                responseObserver.onNext(ProfileDescriptorOuterClass.ProfileDescriptor
                        .newBuilder()
                        .setProfileId(pointCount++)
                        .build());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
