package com.ahao.spring.boot.core.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;

/**
 * @author ahao
 * @since 2019/7/29 22:57
 **/
public class Server {
    private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        LOGGER.info("--**initChannel...");
                        ch.pipeline().addLast(new InboundHandlerA());
                    }
                });
        try {
            ChannelFuture future = serverBootstrap.bind(18888).sync();
            future.channel().closeFuture().addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    bossGroup.shutdownGracefully();
                    workGroup.shutdownGracefully();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Ordered ordered = new Ordered() {
            @Override
            public int getOrder() {
                return 0;
            }
        };
    }
}
