package com.bonc.example.demo.enumtest;

import java.util.Arrays;

/**
 * @author luoaojin
 * @CreateTime 2019-02-26
 * @Description
 */
public enum Color implements Print{

//

    RED("红色"),GREEN("绿色"),BLACK("黑色"),YELLOW("黄色");

//
    private String c;

    Color(String c) {
        this.c = c;
    }

    @Override
    public void print() {
        System.out.println(c);
    }

    public static void main(String[] args) {
//        Arrays.asList(Color.values());
//        System.out.println();
        Integer a = null;
        System.out.println(null == a);
    }
}
