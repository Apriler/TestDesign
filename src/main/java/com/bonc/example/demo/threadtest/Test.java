package com.bonc.example.demo.threadtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.logging.Handler;

/**
 * @author luoaojin
 * @CreateTime 2019-03-01
 * @Description
 */
public class Test {

    public static final Map<String, Vo> cache = new HashMap<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        String  name ="aaa";
//        new Thread(()->{
//            String name ="a";
//            for (int i = 0; i < 20; i++) {
//                System.out.println(name +"---"+i);
//            }
//        }).start();
//        new Thread(()->{
//            String name ="b";
//            for (int i = 0; i < 20; i++) {
//                System.out.println(name +"---"+i);
//            }
//        }).start();
//        new MyThread("s").start();
        cache.put("aaa",new Vo(1));
        CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(new Thread1(latch)).start();
        }
        new Thread(new Thread2()).start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class Thread1 implements Runnable{
        CountDownLatch latch;

        public Thread1(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            Vo aaa = cache.get("aaa");
            Integer num = aaa.getNum();
            num +=1;
            latch.countDown();
        }
    }
    static class Thread2 implements Runnable{

        @Override
        public void run() {

            while (true){
                try {

                    Thread.sleep(1000);
                    System.out.println(cache.get("aaa").num);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Vo{
        private Integer num;

        public Vo(Integer num) {
            this.num = num;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }
    }
}
