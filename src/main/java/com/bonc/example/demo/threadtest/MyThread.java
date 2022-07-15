package com.bonc.example.demo.threadtest;

import org.apache.spark.internal.config.R;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author luoaojin
 * @CreateTime 2019-03-01
 * @Description
 */
public class MyThread extends Thread {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(4,10,10, TimeUnit.SECONDS,new LinkedBlockingDeque<>(20));
//        pool.allowCoreThreadTimeOut(true);
        int a = 10;

        for (int i = 1; i <= a; i++) {
            int j = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        if(j == 2){
                            throw new RuntimeException();
                        }
                        //获取线程名称
                        Thread thread = Thread.currentThread();
                        String name = thread.getName();
                        //输出
                        int activeCount = pool.getActiveCount();
                        System.out.println("任务："+j+"-----,线程名称:"+name+"-----活跃线程数:"+activeCount+"-----线程数"+pool.getPoolSize());
                        Thread.sleep(13000);

                    }catch (RuntimeException r){

                        Thread thread = Thread.currentThread();
                        String name = thread.getName();
                        int activeCount = pool.getActiveCount();
                        System.out.println("中断前任务："+j+"-----,线程名称:"+name+"-----活跃线程数:"+activeCount+"-----线程数"+pool.getPoolSize());
                        currentThread().stop();
                        int activeCount2 = pool.getActiveCount();
                        System.out.println("中断后 任务："+j+"-----,线程名称:"+name+"-----活跃线程数:"+activeCount2+"-----线程数"+pool.getPoolSize());
                    }
                    catch (Exception e){
                        pool.execute(this);
                    }
                }
            });
        }
        Thread.sleep(6000);//一定要大于KeepAliveTime的值
        System.out.println("线程数"+pool.getPoolSize()+"-----,活跃线程数"+pool.getActiveCount());
//        for (int i = 1; i <= a; i++) {
//            int j = i;
//            pool.submit(new Runnable() {
//                @Override
//                public void run() {
//                    if(j == 10){
//                        throw new RuntimeException();
//                    }
//                    //获取线程名称
//                    Thread thread = Thread.currentThread();
//                    String name = thread.getName();
//                    //输出
//                    int activeCount = pool.getActiveCount();
//                    System.out.println("任务："+j+"-----,线程名称:"+name+"-----活跃线程数:"+activeCount+"-----线程数"+pool.getPoolSize());
//                }
//            });
//        }
    }
}
