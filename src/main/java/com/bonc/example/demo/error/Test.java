package com.bonc.example.demo.error;

import org.springframework.util.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author luoaojin
 * @Date 2021/9/16 15:27
 * @Description
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        StringBuilder zkAddressSb = new StringBuilder();
        String port = "";
        zkAddressSb.append("beh-1.bonc.com").append(":")
                .append(StringUtils.isEmpty(port) ? "2181" : port)
                .append("/")
                .append("kafka");
        System.out.println(zkAddressSb.toString());
    }
}
