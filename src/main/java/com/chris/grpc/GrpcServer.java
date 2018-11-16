package com.chris.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;


public class GrpcServer {

    private Server server;

    private void start() throws Exception {
        this.server = ServerBuilder.forPort(8899).addService(new StudentServiceImpl()).build().start();

        System.out.println("server start ok!");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("关闭jvm");
            GrpcServer.this.stop();
        }));
    }

    private void stop() {
        if (null != server) {
            server.shutdown();
        }
    }

    private void awaitTermination () throws Exception {
        if (null != server) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws Exception {
        GrpcServer server = new GrpcServer();
            server.start();
            server.awaitTermination();
    }

}
