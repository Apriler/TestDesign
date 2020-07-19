package com.bonc.example.demo.enumtest;

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

}
