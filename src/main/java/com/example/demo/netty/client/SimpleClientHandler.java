package com.example.demo.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SimpleClientHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
		System.out.println("=================SimpleClientHandler.channelRead========================");
		
		
		ByteBuf resultBuf = (ByteBuf)msg;
		byte[] result = new byte[resultBuf.readableBytes()];

		resultBuf.readBytes(result);
		System.out.println("Message from Server: " + new String(result));
		
		resultBuf.release();
	}
	
	@Override
	public void exceptionCaught ( ChannelHandlerContext ctx, Throwable causeThrowable) throws Exception{
		causeThrowable.printStackTrace();
		ctx.close();
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception{
		String msg = "Hello Server! I am client.";
		ByteBuf encodedBuf = ctx.alloc().buffer(4*msg.length());
		encodedBuf.writeBytes(msg.getBytes());
		ctx.write(encodedBuf);
		ctx.flush();
	}
}
