package com.example.demo.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SimpleServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("=====================SimpleServerHandler.channelRead============================");
        ByteBuf result = (ByteBuf) msg;

        byte[] result1 = new byte[result.readableBytes()];

        result.readBytes(result1);
        String resultString = new String(result1);

        System.out.println("Client said: " + resultString);

        result.release();

        String response = "Hello, I am Server!";
        ByteBuf encodedBuf = ctx.alloc().buffer(4 * response.length());
        encodedBuf.writeBytes(response.getBytes());
        ctx.write(encodedBuf);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable causeThrowable) throws Exception {
        causeThrowable.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
