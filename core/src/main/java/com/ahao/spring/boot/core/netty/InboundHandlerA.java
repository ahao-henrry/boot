package com.ahao.spring.boot.core.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ahao
 * @since 2019/7/29 23:15
 **/
public class InboundHandlerA extends ChannelInboundHandlerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(InboundHandlerA.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LOGGER.info("--**channelActive...");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.fireChannelRead(msg);
        ByteBuf byteBuf = Unpooled.directBuffer(1024);
        LOGGER.info("--**received message from client : {}", msg);
    }
}
