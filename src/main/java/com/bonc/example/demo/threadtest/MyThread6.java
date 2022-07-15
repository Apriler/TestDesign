package com.bonc.example.demo.threadtest;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author luoaojin
 * @Date 2021/4/29 16:32
 * @Description
 * @Version 1.0
 */
public class MyThread6 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        BddWarehouseDistributeV2ServiceImpl distributeThread = new BddWarehouseDistributeV2ServiceImpl(latch);
        ThreadFactory threadFactory  = new ThreadFactoryBuilder().setNameFormat("bdds-%d").build();
        ThreadPoolExecutor monitorExecutor = new ThreadPoolExecutor(4, 4,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),threadFactory);
        for (int i = 0; i < 3; i++) {
            monitorExecutor.submit(distributeThread);

        }
        latch.await();
        System.out.println("all is down");
    }
    static class BddWarehouseDistributeV2ServiceImpl implements Callable<Boolean> {


        CountDownLatch latch;

        public BddWarehouseDistributeV2ServiceImpl(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public Boolean call() {
            try {
                System.out.println(Thread.currentThread().getName()+"=============");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+"=============down");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            return true;
        }
    }
}
