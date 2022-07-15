package com.bonc.example.demo.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author luoaojin
 * @Date 2020/12/5 16:08
 * @Description
 * @Version 1.0
 */
public class Test3 {
    public static void main(String[] args) {
        Map<String, List<String>> instanceStatusCacheMap = new ConcurrentHashMap<>();
        System.out.println(null == instanceStatusCacheMap.get("aaa"));
//        List<String> a = new ArrayList<>();
//        instanceStatusCacheMap.put("a",a);
//        a.add("aaa");
//        a.add("aaa1");
//        a.add("aaa2");

//        List<String> a1 = instanceStatusCacheMap.get("a");
//        a.forEach(System.out::println);

//        System.out.println(instanceStatusCacheMap);
    }
}
