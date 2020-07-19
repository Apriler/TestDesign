package com.bonc.example.demo.threadtest;

/**
 * @author luoaojin
 * @CreateTime 2019-03-04
 * @Description
 */
public class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
