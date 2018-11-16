package com.chris.grpc;

import com.chris.proto.*;
import io.grpc.stub.StreamObserver;

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {
    @Override
    public void getRealNameByName(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("接收端客户端的信息 ： " + request.getName());

        responseObserver.onNext(MyResponse.newBuilder().setRealName("Kris").build());
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        super.getStudentsByAge(request, responseObserver);
    }
}
