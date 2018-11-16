package com.chris.netty.protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyDataInfo.MyMessage myMessage = null;

        int random = new Random().nextInt(3);

        if (0 == random) {
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.dataType.personType).setPerson(MyDataInfo.Person.newBuilder()
                    .setName("李林梽")
                    .setAge(20)
                    .setAddress("北京").build()).build();
        } else if (1 == random) {
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.dataType.dogType).setDog(MyDataInfo.Dog.newBuilder()
                    .setName("二毛")
                    .setAge(2).build()).build();
        } else {
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.dataType.catType).setCat(MyDataInfo.Cat.newBuilder()
                    .setName("滴滴")
                    .setCity("北京").build()).build();
        }

        ctx.writeAndFlush(myMessage);
    }
}
