package com.bonc.example.demo.hearbeat;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author luoaojin
 * @CreateTime 2020-04-26
 * @Description
 */
public class ThreadTest {

     static class HeartbeatProcessingTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                String heartbeat = pollHeartbeat();
                if (heartbeat == null) {

                        Thread.sleep(1000);

                    System.out.println("睡眠中----------");
                }else {
                    System.out.println("处理中----------");
                }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String pollHeartbeat() {
        return heartBeatsQueue.poll();
    }


    private static ConcurrentLinkedQueue<String> heartBeatsQueue = new ConcurrentLinkedQueue<>();
    public static void addHeartbeat() {
        heartBeatsQueue.add("heartBeat ");
    }

    public static void main(String[] args) throws InterruptedException {
//        Thread t = new Thread(new HeartbeatProcessingTask());
//        t.start();

        while (true) {
            int a = 0;
            for (int i = 0; i < 10; i++) {
//                addHeartbeat();
                a++;
                System.out.println(a);
            }
            if (a == 10) {
                System.out.println("return");
                aa();
            }

        }

    }

    public static void aa(){
        return;
    }

}
