package com.ahao.spring.boot.core.netty.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ahao
 * @since 2019/8/26 22:19
 **/
public class Test {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);
    }
}
