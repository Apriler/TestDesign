package com.bonc.example.demo.PCTest;

/**
 * @author luoaojin
 * @CreateTime 2019-03-04
 * @Description
 */
public class Tst {
    public static void main(String[] args) {
//        Message msg = new Message();
//        new Thread(new Producer(msg)).start();
//        new Thread(new Consumer(msg)).start();

//        StringBuffer sb=new StringBuffer("sss");
//        System.out.println("sss".contentEquals(sb));
        Runtime.getRuntime().gc();
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
        System.gc();
    }
}
