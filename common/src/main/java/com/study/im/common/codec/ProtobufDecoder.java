package com.study.im.common.codec;

import com.study.im.common.bean.msg.ProtoMsg;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * ProtobufEncoder解码器
 */
public class ProtobufDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        in.markReaderIndex();
        if (in.readableBytes() < 2) {
            return;
        }
        int length = in.readShort();
        if (length < 0) {
            ctx.close();
        }
        if (length > in.readableBytes()) {
            in.resetReaderIndex();
            return;
        }
        byte[] bytes;
        if (in.hasArray()) {
            ByteBuf slice = in.slice();
            bytes = slice.array();
        } else {
            bytes = new byte[length];
            in.readBytes(bytes, 0,  length);
        }
        ProtoMsg.Message message = ProtoMsg.Message.parseFrom(bytes);
        if (message != null) {
            out.add(message);
        }
    }
}
