package com.bonc.example.demo.threadtest;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author luoaojin
 * @Date 2021/6/15 10:04
 * @Description
 * @Version 1.0
 */
public class TestPool {

    public static void main(String[] args) throws InterruptedException {
        ThreadFactory threadFactory  = new ThreadFactoryBuilder().setNameFormat("bdds-%d").build();
//        ThreadPoolExecutor monitorExecutor = new ThreadPoolExecutor(5, Integer.MAX_VALUE,
//                6L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<>(),threadFactory);
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2000);
        ThreadPoolExecutor monitorExecutor2 = new ThreadPoolExecutor(2, Integer.MAX_VALUE,
                6L, TimeUnit.SECONDS,
                workQueue,threadFactory);
        for (int i = 1; i < 7000; i++) {
            //Thread.sleep(500);
            monitorExecutor2.execute(new task(i * 2000));
        }
        while (true){
            Thread.sleep(1000);
            System.out.println("-----------------" + monitorExecutor2.getActiveCount());
        }
    }
    static class task implements Runnable{
        long i;

        public task(long i) {
            this.i = i;
        }

        public task() {
        }

        @Override
        public void run() {
            while (i > 0){
                try {
                    Thread.sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread ---- name : " + Thread.currentThread().getName());
                i = 0;
            }
        }
    }
}
