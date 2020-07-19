package com.bonc.example.demo.extend;

/**
 * @author luoaojin
 * @CreateTime 2020-05-27
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        Father f = new Son();
        Son s = new Son();
        System.out.println(s.aa());

//        System.out.println(f.toString());
    }

}
