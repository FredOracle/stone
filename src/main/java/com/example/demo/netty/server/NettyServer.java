package com.example.demo.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyServer {

	private static final Integer LISTENER_PORT = 9999;

	private int port;

	private NettyServer(int port) {
		this.port = port;
	}

	EventLoopGroup boss = null;
	EventLoopGroup worker = null;
	ServerBootstrap serverBootstrap = null;

	public static NettyServer NETTYSERVER = null;

	public static NettyServer getInstance() {
		if (NETTYSERVER == null) {
			synchronized (NettyServer.class) {
				if (NETTYSERVER == null) {
					NETTYSERVER = new NettyServer(LISTENER_PORT == null ? 9999 : LISTENER_PORT);
				}
			}
		}
		return NETTYSERVER;
	}

	/**
	 * 绑定
	 * 
	 * @throws InterruptedException
	 */
	public void init() throws InterruptedException {
		try {

			// 创建两个线程池
			// 目前服务器CPU为单核8线程，调整线程为8
			boss = new NioEventLoopGroup(8);
			worker = new NioEventLoopGroup(8);

			serverBootstrap = new ServerBootstrap();

			serverBootstrap.group(boss, worker);// 两个工作线程
			serverBootstrap.channel(NioServerSocketChannel.class);

			// 重用缓冲区
			serverBootstrap.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
			serverBootstrap.childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);

			// 自动调整下一次缓冲区建立时分配的空间大小，避免内存的浪费
//			serverBootstrap.option(ChannelOption.RCVBUF_ALLOCATOR, AdaptiveRecvByteBufAllocator.DEFAULT);

			// 当服务器请求处理线程全满时，用于临时存放已完成三次握手的请求的队列的最大长度,默认值50。
			serverBootstrap.option(ChannelOption.SO_BACKLOG, 1024);

			// 用于启用或关于Nagle算法。如果要求高实时性，有数据发送时就马上发送，就将该选项设置为true关闭Nagle算法；如果要减少发送次数减少网络交互，就设置为false等累积一定大小后再发送。默认为false。
			serverBootstrap.option(ChannelOption.TCP_NODELAY, true);

			 //是否启用心跳保活机制
			serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);

			// 支持tcp协议
//			 serverBootstrap.childHandler(new TcpChannelInitializer());
			
			serverBootstrap.childHandler(new SimpleServerHandler());

			// 支持webSocket协议
//			 serverBootstrap.childHandler(new WebSocketChannelInitializer());

			ChannelFuture future = serverBootstrap.bind(port).sync();
			if (future.isSuccess()) {
				log.info("Netty Server start.......");
			}

			//等到服务端监听端口关闭
			future.channel().closeFuture().sync();
		} finally {
			//优雅释放线程资源
			boss.shutdownGracefully().sync();
			worker.shutdownGracefully().sync();
		}
	}

	/**
	 * 销毁netty相关资源
	 */
	public void destory() {
		try {
			if (boss != null) {
				boss.shutdownGracefully();
			}

			if (worker != null) {
				worker.shutdownGracefully();
			}

			if (serverBootstrap != null) {
				serverBootstrap = null;
			}
		} catch (Exception e) {
			log.error("Netty Close Error: " + e.getMessage());
		}
	}

	public static void main(String[] args) throws Exception {
		NettyServer.getInstance().init();
	}

}
