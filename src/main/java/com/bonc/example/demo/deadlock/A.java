package com.bonc.example.demo.deadlock;

/**
 * @author luoaojin
 * @CreateTime 2019-03-04
 * @Description
 */
public class A {
    public  synchronized void say(B b){
        System.out.println("lalal");
        b.get();
    }
    public synchronized void get(){
        System.out.println("lalal");
    }
}
