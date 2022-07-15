package com.bonc.example.demo.lock;



import java.util.concurrent.TimeUnit;

/**
 * @author luoaojin
 * @CreateTime 2020-05-21
 * @Description
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        Phone phone = new Phone();
        Phone phone2 = new Phone();


        new Thread(() -> {
            try {
                phone.sendEmail();
//                phone.sendMsg();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
//        TimeUnit.MILLISECONDS.sleep(300);
        new Thread(() -> {
            try {
                phone.sendMsg();
//                phone.sayHello();
//                phone2.sendMsg();
//                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }


}

class Phone {

    public static synchronized void sendEmail() throws InterruptedException {
        System.out.println("Paaa");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Phone.sendEmail");
    }

    public synchronized void sendMsg() throws InterruptedException {
        System.out.println("Phone.sendMsg");
    }

    public void sayHello() {
        System.out.println("Phone.sayHello");
    }


}
