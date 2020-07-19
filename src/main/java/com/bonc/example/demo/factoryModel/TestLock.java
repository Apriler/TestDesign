package com.bonc.example.demo.factoryModel;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luoaojin
 * @CreateTime 2020-05-26
 * @Description
 */
public class TestLock {
    static class airConditioning{
        //温度
        public int  temperature = 0;
        Lock lock =new ReentrantLock();
        Condition condition = lock.newCondition();

        public void increase() throws InterruptedException {
            lock.lock();
            try {
                while (temperature != 0){
                    condition.await();
                }
                temperature ++;
                System.out.println(Thread.currentThread().getName() +" airConditioning.increase " + temperature);
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
        public void decrease() throws InterruptedException {
            lock.lock();
            try {
                while (temperature == 0){
                    condition.await();
                }
                temperature --;
                System.out.println(Thread.currentThread().getName() +" airConditioning.increase " + temperature);
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) {
        Test.airConditioning a = new Test.airConditioning();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    a.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    a.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }
}
