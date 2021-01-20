package com.bonc.example.demo.lock;

/**
 * @Author luoaojin
 * @Date 2020/9/29 15:33
 * @Description
 * @Version 1.0
 */
public class Test2 {

    public synchronized void helloA(){
        System.out.println("hello A");
    }
    public synchronized void helloB(){
        System.out.println("hello B");
        helloA();
    }
}
