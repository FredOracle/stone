package com.example.demo.netty.client;

import java.io.RandomAccessFile;

import org.springframework.beans.factory.annotation.Autowired;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

	@Autowired
	protected void messageReceived(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		log.info("Client" + ctx.channel().remoteAddress() + " connected.");
		log.info(msg.toString(CharsetUtil.UTF_8));
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
		ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rock!", CharsetUtil.UTF_8));
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		super.exceptionCaught(ctx, cause);
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	protected void channelRead0(ChannelHandlerContext arg0, ByteBuf msg) throws Exception {
		System.out.println("=================SimpleClientHandler.channelRead========================");
		RandomAccessFile i;
		ByteBuf resultBuf = (ByteBuf) msg;
		byte[] result = new byte[resultBuf.readableBytes()];

		resultBuf.readBytes(result);
		System.out.println("Message from Server: " + new String(result));

		resultBuf.release();

	}

}
