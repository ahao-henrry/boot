package com.ahao.spring.boot.core.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author ahao
 * @since 2019/8/19 9:00
 **/
public class MyThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Long> futureTask = new FutureTask<>(new MyCallable());
        new Thread(futureTask, "sleepT").start();

        AtomicLong resultAll = new AtomicLong();
        for (int i = 0; i < 5; i++) {
            FutureTask<Long> futureTaskI = new FutureTask<>(new MyCallable());
            new Thread(futureTaskI, "noSleep" + i).start();
            while (!futureTaskI.isDone()) {
            }
            Long resultThread = futureTaskI.get();
            System.out.println("--**resultThread " + resultThread);
            resultAll.getAndAdd(resultThread);
        }

        while (!futureTask.isDone()) {
        }
        Long resultMain = futureTask.get();
        System.out.println("--**resultMain " + resultMain);
        resultAll.getAndAdd(resultMain);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("--*****************"+resultAll);
    }

}

class MyCallable implements Callable<Long> {

    @Override
    public Long call() throws Exception {
        Long id = Thread.currentThread().getId();
        String name = Thread.currentThread().getName();
        if ("sleepT".equals(name)) {
            TimeUnit.SECONDS.sleep(3);
        }
        return id;
    }
}
