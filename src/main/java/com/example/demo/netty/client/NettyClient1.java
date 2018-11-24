package com.example.demo.netty.client;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class NettyClient1 {

	private final String host;

	private final int port;

	public void start() throws InterruptedException {
		EventLoopGroup group = new NioEventLoopGroup();
		try {

			Bootstrap bootstrap = new Bootstrap();

			bootstrap.group(group).channel(NioSocketChannel.class).remoteAddress(new InetSocketAddress(host, port))
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel channel) throws Exception {
							channel.pipeline().addLast(new NettyClientHandler());
						}
					});

			ChannelFuture future = bootstrap.connect().sync();

			future.channel().closeFuture().sync();
		} finally {
			group.shutdownGracefully().sync();
		}
	}

	public static void main(String[] args) throws Exception {

		new NettyClient1("127.0.0.1", 9999).start();
		log.info("----------------------------------");
		new NettyClient1("127.0.0.1", 9999).start();
		log.info("----------------------------------");
		new NettyClient1("127.0.0.1", 9999).start();
		log.info("----------------------------------");
	}

}
