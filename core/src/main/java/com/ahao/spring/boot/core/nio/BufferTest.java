package com.ahao.spring.boot.core.nio;

import java.nio.ByteBuffer;

/**
 * @author ahao
 * @since 2019/9/22 下午7:23
 */
public class BufferTest {
    public static void main(String[] args) {
        // ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        System.out.println("---------------init------------------");
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        System.out.println("----------------put-----------------");
        byteBuffer.put("abcde".getBytes());
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        System.out.println("----------------flip-----------------");
        byteBuffer.flip();
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        System.out.println("----------------get-----------------");
        byte[] dst = new byte[byteBuffer.limit()];
        byteBuffer.get(dst);
        System.out.println("--content is : " + new String(dst, 0, dst.length));
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        System.out.println("----------------rewind-----------------");
        byteBuffer.rewind();
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        System.out.println("----------------clear-----------------");
        // 数据并没有被清空
        byteBuffer.clear();
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());
    }
}
