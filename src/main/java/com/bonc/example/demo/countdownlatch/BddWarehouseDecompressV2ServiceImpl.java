package com.bonc.example.demo.countdownlatch;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class BddWarehouseDecompressV2ServiceImpl implements Callable<Boolean> {


    private CountDownLatch latch;
    private int i;

    public BddWarehouseDecompressV2ServiceImpl(CountDownLatch latch, int i) {
        this.latch = latch;
        this.i = i;
    }

    @Override
    public Boolean call() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (i == 2) {
            return false;
        }else {
            return true;
        }

    }
}