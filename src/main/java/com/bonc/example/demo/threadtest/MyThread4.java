package com.bonc.example.demo.threadtest;

import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author luoaojin
 * @CreateTime 2020-06-09
 * @Description
 */
public class MyThread4 {


    public static void main(String[] args) {

        new Thread(() -> {
//            customer.heartBeatsQueue.add("aaa");
        }).start();
    }
}

class customer {
    public static ConcurrentLinkedQueue<String> heartBeatsQueue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) throws IOException {
//        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("heartbeat-monitor-%d").build();
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {

            int count = 0;
            int sum = 0;
            while (true) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                if (count == 101) {
//                    break;
//                }
                if (count == 20) {
                    sum = sum + count;
                    count++;
                    System.out.println("error---------------");
//                    throw new RuntimeException("我是异常");
                    try {

                        System.out.println(1/0);
                    }catch (Exception ex){
                        executor.execute(Thread.currentThread());
                    }
                }
                System.out.println("customer.main");
                count++;


            }
        });

        System.in.read();

    }
}
