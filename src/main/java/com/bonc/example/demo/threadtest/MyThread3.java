package com.bonc.example.demo.threadtest;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author luoaojin
 * @CreateTime 2020-05-22
 * @Description
 */
public class MyThread3 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(()->{
            boolean a= true;
            if (a){
                System.out.println("keytabThread");
                countDownLatch.countDown();
            }else{
//                Map<Thread, StackTraceElement[]> allThread = Thread.getAllStackTraces();
//                List<Thread> ss = allThread.keySet().stream().collect(Collectors.toList());
//                for (Thread s : ss) {
//                    if ("keystoreThread".equals(s.getName())) {
//                        s.interrupt();
//                       break;
//                    }
//                }
//                Thread.currentThread().interrupt();
            }

        },"keytabThread").start();

        new Thread(()->{
            boolean b= true;
//            if (b){
//                System.out.println("keytabThread");
//                countDownLatch.countDown();
//            }else{
//
//            }
            while (true){
                System.out.println("keystoreThread----------------------");
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"keystoreThread").start();
        countDownLatch.await();
        System.out.println("MyThread3.main");

        System.out.println("MyThread3.main");
    }
}
