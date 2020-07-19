package com.bonc.example.demo.PCTest;

/**
 * @author luoaojin
 * @CreateTime 2019-03-04
 * @Description
 */
public class Consumer implements Runnable {

    private Message msg;

    public Consumer(Message msg) {
        this.msg = msg;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            msg.get();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
