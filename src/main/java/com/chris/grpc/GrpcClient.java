package com.chris.grpc;

import com.chris.proto.MyRequest;
import com.chris.proto.MyResponse;
import com.chris.proto.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8899).usePlaintext(true).build();

        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);

        MyResponse myResponse= blockingStub.getRealNameByName(MyRequest.newBuilder().setName("Chris").build());
        System.out.println(myResponse.getRealName());

    }
}
