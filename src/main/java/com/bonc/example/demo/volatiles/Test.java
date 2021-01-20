package com.bonc.example.demo.volatiles;

/**
 * @Author luoaojin
 * @Date 2020/9/14 16:16
 * @Description 测试指令重排
 * @Version 1.0
 */
public class Test {

     static int num = 0;
     static boolean ready = false;

    static class Read extends Thread{
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                if (ready) {
                    System.out.println(num + num);
                    break;
                }
            }
        }
    }
    static class Write extends Thread{
        @Override
        public void run() {
            ready = true;
            num = 2;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Read read= new Read();
        read.start();
        Write write= new Write();
        write.start();

        Thread.sleep(10);
        read.interrupt();

    }
}
