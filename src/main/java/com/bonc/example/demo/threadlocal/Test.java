package com.bonc.example.demo.threadlocal;

/**
 * @author luoaojin
 * @CreateTime 2020-07-20
 * @Description
 */
public class Test {

    static ThreadLocal<String> tl = new ThreadLocal<>();
    public static void main(String[] args) {
        new Thread(()->{
            tl.set("aaa");
            System.out.println(Thread.currentThread().getName() +"  "+ tl.get());
        },"1").start();
        new Thread(()->{
            tl.set("bbb");
            System.out.println(Thread.currentThread().getName() +"  "+tl.get());
        },"2").start();
    }
}
