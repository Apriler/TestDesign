package com.bonc.example.demo.three;

/**
 * @Author luoaojin
 * @Date 2021/6/8 15:08
 * @Description
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        Object o1 = (true ? new Integer(2) : new Short((short) 1));
        Object o2;
        if (true) {o2 = new Integer(1);
        } else {
            o2 = new Double(2.0);
        }
        System.out.print(o1);
        System.out.print(" ");
        System.out.print(o2);
    }
}
