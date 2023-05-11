package com.simple.im.protocol;

import java.io.ByteArrayOutputStream;

public class Test {

    public static void main(String[] args) throws Exception{
        MsgProtos.Msg message = buildMsg();
        //将Protobuf对象序列化成二进制字节数组
        byte[] data = message.toByteArray();
        //可以用于网络传输，保存到内存或外存
        ByteArrayOutputStream outputStream = new
                ByteArrayOutputStream();
        outputStream.write(data);
        data = outputStream.toByteArray();
        //二进制字节数组反序列化成Protobuf对象
        MsgProtos.Msg inMsg = MsgProtos.Msg.parseFrom(data);
        System.out.println(inMsg.getId());
        System.out.println(inMsg.getContent());
    }

    public static MsgProtos.Msg buildMsg() {
        MsgProtos.Msg.Builder personBuilder =
                MsgProtos.Msg.newBuilder();
        personBuilder.setId(1000);
        personBuilder.setContent("疯狂创客圈:高性能学习社群");
        MsgProtos.Msg message = personBuilder.build();
        return message;
    }
}
