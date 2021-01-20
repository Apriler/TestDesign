package com.bonc.example.demo.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author luoaojin
 * @Date 2020/8/7 14:17
 * @Description
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        String a = "beh[1-4]56";

        Pattern p = Pattern.compile("(\\[[^]]*])");
        Matcher m = p.matcher(a);
        while (m.find()){
            String substring = m.group().substring(1, m.group().length() - 1);
            String[] split = substring.split("-");
            Integer first = Integer.valueOf(split[0]);
            Integer end = Integer.valueOf(split[1]);

            StringBuilder sb = new StringBuilder(a);
//            sb.insert()
//            a.replace(m.group(),first.toString())

        }
    }
}
