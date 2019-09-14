package com.ahao.spring.boot.core.thread;

import java.util.concurrent.*;

/**
 * @author ahao
 * @since 2019/8/19 18:30
 **/

class DataOperation implements Runnable {
    private Object lock1;
    private Object lock2;

    public DataOperation(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("--** hold " + lock1);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                System.out.println("--** hold " + lock2);
            }
        }
    }
}

public class DeadLock {
    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();

    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(4,
                4,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        try {
            pool.execute(new DataOperation(LOCK1, LOCK2));
            pool.execute(new DataOperation(LOCK2, LOCK1));
        } finally {
            pool.shutdown();
        }
    }

}
