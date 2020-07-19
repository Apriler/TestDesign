package com.bonc.example.demo.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author luoaojin
 * @CreateTime 2020-01-14
 * @Description
 */
public class Test {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {

            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getId()+" 线程开始执行---");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程结束执行---");
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
            System.out.println("主线程开始执行----");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
