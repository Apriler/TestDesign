package com.bonc.example.demo.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author luoaojin
 * @Date 2020/12/5 16:08
 * @Description
 * @Version 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        Map<String, Map<String,String>> instanceStatusCacheMap = new ConcurrentHashMap<>();
        Map<String,String> a = new HashMap<>();
        a.put("zk","aaa");
        a.put("z3k","aaa1");
        a.put("z5k","aaa2");
        instanceStatusCacheMap.put("a",a);
        Map<String, String> a1 = instanceStatusCacheMap.get("a");
        for (String s : a1.keySet()) {
            a1.put(s,"b");
        }

        System.out.println(instanceStatusCacheMap);
    }
}
