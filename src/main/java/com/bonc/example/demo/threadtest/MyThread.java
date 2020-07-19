package com.bonc.example.demo.threadtest;

/**
 * @author luoaojin
 * @CreateTime 2019-03-01
 * @Description
 */
public class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(name +"---ssss");
        }
    }
}
