package com.bonc.example.demo.error;

/**
 * @Author luoaojin
 * @Date 2020/12/17 9:51
 * @Description
 * @Version 1.0
 */
public class TestStackOverflowError {
    public static void main(String[] args) {
        a();
    }

    private static void a() {
        b();
    }

    private static void b() {
        a();
    }
}
