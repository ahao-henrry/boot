package com.ahao.spring.boot.core.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author ahao
 * @since 2019/9/23 下午10:43
 */
public class ChannelTest {
    public static void main(String[] args) {
        String src = "sea.jpeg";
        String dst = "sea3.jpeg";
        // copyImage(src, dst);
        // copyImageDirect(src, dst);
        copyImageDirectChannel(src, dst);
    }

    /**
     * 使用直接缓冲区通过通道复制文件
     * @param src
     * @param dst
     */
    private static void copyImageDirectChannel(String src, String dst) {
        try (FileChannel inChannel = FileChannel.open(Paths.get(src), StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(Paths.get(dst),
                     StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE)) {
            inChannel.transferTo(0, inChannel.size(), outChannel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用直接缓冲区复制文件
     * @param src
     * @param dst
     */
    private static void copyImageDirect(String src, String dst) {
        try (FileChannel inChannel = FileChannel.open(Paths.get(src), StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(Paths.get(dst),
                     StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE)) {
            MappedByteBuffer inMappedBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
            byte[] bytes = new byte[inMappedBuffer.limit()];
            inMappedBuffer.get(bytes);
            outMappedBuffer.put(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用非直接缓冲区复制文件
     * @param src
     * @param dst
     */
    private static void copyImage(String src, String dst) {
        try (FileInputStream fileInputStream = new FileInputStream(src);
             FileOutputStream fileOutputStream = new FileOutputStream(dst);
             FileChannel inputStreamChannel = fileInputStream.getChannel();
             FileChannel outputStreamChannel = fileOutputStream.getChannel()) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (inputStreamChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                outputStreamChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
