package com.ahao.spring.boot.core.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ahao
 * @since 2019/8/11 16:59
 **/
public class JvmMonitor {
    public static void main(String[] args) {
        List<OOMClass> list = new ArrayList<>();
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new OOMClass());
        }
    }

    public static class OOMClass {
        byte[] bytes = new byte[10 * 1024];
    }
}
