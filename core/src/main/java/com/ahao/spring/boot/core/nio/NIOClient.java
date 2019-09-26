package com.ahao.spring.boot.core.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ahao
 * @since 2019/9/25 下午7:34
 */
public class NIOClient {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 5, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(5000));
        threadPoolExecutor.execute(new Thread(() -> {
            while (true) {
                try (SocketChannel socketChannel = SocketChannel.open()) {
                    socketChannel.connect(new InetSocketAddress("ahaoclient", 8765));
                    socketChannel.configureBlocking(false);

                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    byteBuffer.put((LocalDateTime.now() + " you hello").getBytes());
                    byteBuffer.flip();
                    socketChannel.write(byteBuffer);
                    byteBuffer.clear();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }));
    }
}
