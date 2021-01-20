package com.bonc.example.demo.cache;

/**
 * @Author luoaojin
 * @Date 2020/9/15 10:20
 * @Description
 * @Version 1.0
 */
public class TestForContent2 {

    static final int LINE_NUM = 1024;
    static final int COLUM_NUM = 1024;

    public static void main(String[] args) {
        long [] [] array = new long[LINE_NUM][COLUM_NUM];

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < LINE_NUM; i++) {
            for (int j = 0; j < COLUM_NUM; j++) {
                array[j][i] = i*2+j;
            }

        }
        long endTime = System.currentTimeMillis();
        long cacheTime = endTime-startTime;
        System.out.println(cacheTime);
    }
}
