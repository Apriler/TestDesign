package com.bonc.example.demo;

/**
 * @author luoaojin
 * @CreateTime 2019-01-29
 * @Description
 */
public class TestMsg {
    public static void main(String[] args) {
//        Message a = new Message("12");
        String a=new String("bb");
        change(a);
//        String text = a.getText();
        System.out.println(a);
    }
    public static  void change(String m){
        System.out.println(m);
        m = new String("ssss");
    }
}
