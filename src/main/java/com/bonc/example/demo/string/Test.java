package com.bonc.example.demo.string;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author luoaojin
 * @CreateTime 2020-07-08
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        String a = "badiu-%d";
        String.format(a, 0);
        final AtomicLong count = (a != null) ? new AtomicLong(0) : null;
        String.format(a, count.getAndIncrement());
        System.out.println(a);

    }
}
