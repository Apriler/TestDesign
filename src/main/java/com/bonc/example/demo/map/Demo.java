package com.bonc.example.demo.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author luoaojin
 * @CreateTime 2020-01-16
 * @Description
 */
public class Demo {
    public static void main(String[] args) {
//        Map<String, HashSet<String>> a  =new HashMap<>();
//        HashSet<String> b = new HashSet<>();
//        b.add("1111111111");
//        b.add("11asf1");
//        a.put("key",b);
//
//        for (Map.Entry<String, HashSet<String>> stringHashSetEntry : a.entrySet()) {
//            System.out.println(stringHashSetEntry.getKey());
//            System.out.println(stringHashSetEntry.getValue());
//        }
        Map<String, Object> map = new HashMap<String, Object>(){{
            put("NameNode-Identity", 1001);
            put("name", "张三");
            put("age", 22);
            put("hobby", "篮球");
        }};
        map.put("NameNode-Identity",1231231);
        for (String s : map.keySet()) {
            System.out.println(map.get(s));
        }

    }
}
