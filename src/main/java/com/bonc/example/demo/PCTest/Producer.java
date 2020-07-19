package com.bonc.example.demo.PCTest;

/**
 * @author luoaojin
 * @CreateTime 2019-03-04
 * @Description
 */
public class Producer implements Runnable{

    private Message msg;

    public Producer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {

        for (int i = 0; i < 50; i++) {
            if (i %2 ==0){
//                msg.setContext("aa");
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                msg.setTitle("aaa");
                msg.set("aaa","aa");
            }else {
//                msg.setContext("bb");
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                msg.setTitle("bbb");
                msg.set("bbb","bb");
            }
        }
    }
}
