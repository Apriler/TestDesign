package com.bonc.example.demo.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author luoaojin
 * @Date 2020/9/7 17:54
 * @Description
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        List<String> a =new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        List<String> b =new ArrayList<>();
        b.add("x");
        b.add("b");
        System.out.println(Collections.disjoint(a,b));
//        if(!a.contains("aaa")){
//            System.out.println("ffffffffff");
//        }
    }
}
