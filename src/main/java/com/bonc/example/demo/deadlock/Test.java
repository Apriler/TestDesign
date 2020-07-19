package com.bonc.example.demo.deadlock;

/**
 * @author luoaojin
 * @CreateTime 2019-03-04
 * @Description
 */
public class Test {
    public static A a = new A();
    public static B b = new B();
    public static void main(String[] args) {
       Thread t1 = new Thread(()->{
            a.say(b);
        });

        Thread t2 =new Thread(()->{
            b.say(a);
        });
        t1.start();
        t2.start();
    }

}
