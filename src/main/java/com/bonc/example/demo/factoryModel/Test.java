package com.bonc.example.demo.factoryModel;

/**
 * @author luoaojin
 * @CreateTime 2020-05-26
 * @Description
 */
public class Test {

    static class airConditioning{
        //温度
        public int  temperature = 0;

        public synchronized void increase() throws InterruptedException {
            while (temperature != 0){
                this.wait();
            }
            temperature ++;
            System.out.println(Thread.currentThread().getName() +" airConditioning.increase " + temperature);
            this.notifyAll();
        }
        public synchronized void decrease() throws InterruptedException {
            while (temperature == 0){
                this.wait();
            }
            temperature --;
            System.out.println(Thread.currentThread().getName() +" airConditioning.decrease " + temperature);
            this.notifyAll();
        }

    }

    public static void main(String[] args) {

        airConditioning a = new airConditioning();

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
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    a.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    a.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();


    }
}
