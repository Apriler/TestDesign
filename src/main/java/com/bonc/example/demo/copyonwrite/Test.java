package com.bonc.example.demo.copyonwrite;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author luoaojin
 * @CreateTime 2020-05-19
 * @Description
 */
public class Test {

    public static void main(String[] args) {
        List list = new Vector();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }).start();
        }
    }
}
