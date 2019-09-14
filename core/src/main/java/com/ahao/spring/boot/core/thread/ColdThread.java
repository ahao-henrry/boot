package com.ahao.spring.boot.core.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ahao
 * @since 2019/7/23 23:23
 **/
public class ColdThread {
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public static void main(String[] args) {
        Executors.newFixedThreadPool(4);
        Executors.newCachedThreadPool();
        lock.writeLock().lock();
        try {

        } finally {
            lock.writeLock().unlock();
        }
        new Thread().start();
    }
}
