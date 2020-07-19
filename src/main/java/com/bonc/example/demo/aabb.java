package com.bonc.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author luoaojin
 * @CreateTime 2019-01-02
 * @Description
 */
public class aabb {
    public static void main(String[] args) {
        System.out.println(" " + formateTime(1546398014261L));


    }
    /**
     * 处理时间格式
     * @param time
     * @return
     */
    public static String formateTime(Long time) {
        TimeZone tz=TimeZone.getTimeZone("ETC/GMT-8");
        TimeZone.setDefault(tz);
        Date date = new Date(time);
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return sdf.format(date);
    }
}
