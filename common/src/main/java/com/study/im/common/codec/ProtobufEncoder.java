package com.study.im.common.codec;

import com.study.im.common.bean.msg.ProtoMsg;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * ProtobufEncoder编码器
 */
public class ProtobufEncoder extends MessageToByteEncoder<ProtoMsg.Message> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ProtoMsg.Message message, ByteBuf out) throws Exception {
        byte[] bytes = message.toByteArray();
        int length = bytes.length;
        out.writeShort(length);
        out.writeBytes(bytes);
    }
}
