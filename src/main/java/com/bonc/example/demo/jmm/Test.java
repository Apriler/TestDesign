package com.bonc.example.demo.jmm;

/**
 * @author luoaojin
 * @CreateTime 2020-07-10
 * @Description
 */
public class Test {

    static  int a = 10;

    static void up(){
        a = 200;
    }

    public static void main(String[] args) {
//        Test t = new Test();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Test.up();
        }).start();
        while (Test.a == 10){

        }
        System.out.println("Test.main");
    }
}
