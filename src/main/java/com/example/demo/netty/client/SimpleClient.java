package com.example.demo.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class SimpleClient {

	public void connect(String host, int port) throws Exception{
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try{
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(workerGroup);
			bootstrap.channel(NioSocketChannel.class);
			bootstrap.option(ChannelOption.SO_KEEPALIVE, Boolean.TRUE);
			bootstrap.handler(new ChannelInitializer<SocketChannel>() {
				@Override
				public void initChannel(SocketChannel channel) throws Exception{
					channel.pipeline().addLast(new SimpleClientHandler());
				}
			});
			
			
			ChannelFuture future = bootstrap.connect(host, port).sync();
			
			future.channel().closeFuture().sync();
		}finally {
			workerGroup.shutdownGracefully();
		}
	}
	
	public static void main(String[] argsStrings) throws Exception{
		SimpleClient client = new SimpleClient();
		client.connect("localhost", 9999);
	}
}
