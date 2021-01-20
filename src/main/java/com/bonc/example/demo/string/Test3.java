package com.bonc.example.demo.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author luoaojin
 * @Date 2020/8/18 15:22
 * @Description
 * @Version 1.0
 */
public class Test3 {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("111");
        a.add("12");
        a.add("13");
        a.add("14,234");
        System.out.println(String.join(",", a));
    }
}
