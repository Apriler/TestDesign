package com.bonc.example.demo.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luoaojin
 * @CreateTime 2020-03-31
 * @Description
 */
public class test {

    public static void main(String[] args) {
        long n=System.currentTimeMillis();
        List<String> a = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            a.add("--"+i);
        }
        ListPageUtil ab = new ListPageUtil(a,2,100);
        List list = ab.getData();
//        List list = PageUtil.startPage(a, 0, 100);

        long n2=System.currentTimeMillis();
//        System.out.println(n2-n);
        System.out.println(list.size());
    }
}
