package com.bonc.example.demo.deadlock;

/**
 * @author luoaojin
 * @CreateTime 2019-03-04
 * @Description
 */
public class B {
    public  synchronized void say(A a){
        System.out.println("lalal");
        a.get();
    }
    public synchronized void get(){
        System.out.println("lalal");
    }
}
