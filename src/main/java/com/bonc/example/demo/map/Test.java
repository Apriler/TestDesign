package com.bonc.example.demo.map;

import org.springframework.core.io.Resource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.*;

/**
 * @Author luoaojin
 * @Date 2020/8/17 16:41
 * @Description
 * @Version 1.0
 */
public class Test {
    public static final Map<String,Map<String,String>> map = new HashMap<>();
    public static void main(String[] args) {
//        Map<String, List<String>> map = new HashMap<>();
//        List<String> a= new ArrayList<>();
//        a.add("NameNode-Identity");a.add( "1001");
//        a.add("name");a.add( "张三");
//
//        map.put("aa",a);
////        List<String> a1 = map.get("aa");
////        a1.add("age");a1.add( "22");
////        a1.add("hobby");a1.add( "篮球");
//        a.add( "篮球");
//        for (String s : map.keySet()) {
//            map.get(s).forEach(System.out::println);
//        }


        String rootDirPath = determineRootDir("com/bonc/bdev/bdds/");
//        String subPattern = locationPattern.substring(rootDirPath.length());
//        Resource[] rootDirResources = getResources(rootDirPath);
//        Set<Resource> result = new LinkedHashSet<>(16);
    }
//    private PathMatcher pathMatcher = new AntPathMatcher();
    protected static String determineRootDir(String location) {
        int prefixEnd = location.indexOf(':') + 1;
        int rootDirEnd = location.length();
        while (rootDirEnd > prefixEnd && new AntPathMatcher().isPattern(location.substring(prefixEnd, rootDirEnd))) {
            rootDirEnd = location.lastIndexOf('/', rootDirEnd - 2) + 1;
        }
        if (rootDirEnd == 0) {
            rootDirEnd = prefixEnd;
        }
        return location.substring(0, rootDirEnd);
    }
}
