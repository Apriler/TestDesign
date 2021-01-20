package com.bonc.example.demo.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author luoaojin
 * @Date 2020/8/17 16:41
 * @Description
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> a= new ArrayList<>();
        a.add("NameNode-Identity");a.add( "1001");
        a.add("name");a.add( "张三");

        map.put("aa",a);
        List<String> a1 = map.get("aa");
        a1.add("age");a1.add( "22");
        a1.add("hobby");a1.add( "篮球");
        for (String s : map.keySet()) {
            map.get(s).forEach(System.out::println);
        }



    }
}
