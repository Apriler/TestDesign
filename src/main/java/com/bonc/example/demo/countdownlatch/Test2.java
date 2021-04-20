package com.bonc.example.demo.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author luoaojin
 * @CreateTime 2020-01-14
 * @Description
 */
public class Test2 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            try {
                Boolean aBoolean = executorService.submit(new BddWarehouseDecompressV2ServiceImpl(countDownLatch,i)).get();
                if (aBoolean){
                    System.out.println(" i = "+i +"  res = " +aBoolean);
                }else {
                    System.out.println(" i = "+i +"  res = " +aBoolean);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }

        }
        try {
            countDownLatch.await();
            System.out.println("主线程开始执行----");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
