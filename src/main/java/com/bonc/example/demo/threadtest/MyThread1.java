package com.bonc.example.demo.threadtest;



import java.util.concurrent.Callable;

/**
 * @author luoaojin
 * @CreateTime 2019-03-01
 * @Description
 */
public class MyThread1 implements Callable<String> {
    int ticket =5;
    @Override
    public  String call() throws Exception {
        synchronized(this){
            for (int i = 0; i < 20; i++) {
                if (ticket > 0) {
                    Thread.sleep(1000);
                    System.out.println("销售一张，还剩" + ticket--);
                }
            }

        return "没票了";
        }
    }
}
