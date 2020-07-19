package com.bonc.example.demo.threadtest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luoaojin
 * @CreateTime 2020-07-07
 * @Description
 */
public class MyThread5 {

    public static Map<String,Condition> map = new HashMap<>();
    //互斥锁
    private static ReentrantLock r = new ReentrantLock();


    static class runnable implements Runnable{
        private Condition c1 = r.newCondition();
        private int cout = 0;
        @Override
        public void run() {
            r.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"----");
                try {
                    map.put(Thread.currentThread().getName(),c1);
                    c1.await(1,TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"   wake---");
            }catch (Exception e){

            }finally {
                r.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Runnable r1 = new runnable();
        Runnable r2 = new runnable();

        new Thread(r1,"r1").start();
        new Thread(r2,"r2").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.lock();
        try {
            map.get("r1").signal();
        }finally {
            r.unlock();
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.lock();
        try {
            map.get("r2").signal();
        }finally {
            r.unlock();
        }
    }
}
