package com.bonc.example.demo.threadtest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author luoaojin
 * @CreateTime 2019-03-01
 * @Description
 */
public class Test {
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
        MyThread1 t1 = new MyThread1();
//        MyThread1 t2 = new MyThread1();
        FutureTask<String> task1 = new FutureTask<String>(t1);
        FutureTask<String> task2 = new FutureTask<String>(t1);
//
        new Thread(task1).start();
        new Thread(task2).start();
//        System.out.println(task1.get());
//        System.out.println(task2.get());
//        MyThread2 a = new MyThread2();
//        a.run();
//        new Thread(a).start();


    }
}
