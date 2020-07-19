package com.bonc.example.demo.executer;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author luoaojin
 * @CreateTime 2020-07-08
 * @Description
 */
public class Test {
    public static void main(String[] args) {

//        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("bdds-batch-startAgent-%d").build();
        ThreadFactory threadFactory = new NamedThreadFactoryBuilder("batch-startAgent-%d").build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 15,
                1000L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10),threadFactory);

        for (int i = 0; i < 70; i++) {
            long andIncrement = i;
            executor.execute(()->{
                String name = "aa";
                String format = String.format(name, andIncrement);
                Thread.currentThread().setName(format);
                System.out.println("Test.main --->"+Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }



//        while (true){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("executor.isTerminated()===" + executor.isTerminated());
//            System.out.println("executor.getActiveCount()===" + executor.getActiveCount());
//        }
    }
}
