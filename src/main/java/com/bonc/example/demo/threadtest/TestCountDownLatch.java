package com.bonc.example.demo.threadtest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author luoaojin
 * @CreateTime 2020-06-05
 * @Description
 */
public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            int i =3;
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("---1--");
                    i--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i == 0){
                    return;
//                    System.out.println("Thread -------------------");
                }

            }
//            countDownLatch.countDown();
//
        }).start();
        new Thread(() -> {
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("---2--");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }
        }).start();

        countDownLatch.await();
        System.out.println("TestCountDownLatch.main");

    }
}
