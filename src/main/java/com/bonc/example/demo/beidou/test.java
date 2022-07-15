package com.bonc.example.demo.beidou;

import org.apache.hadoop.hbase.util.Bytes;

import java.io.File;

/**
 * @author luoaojin
 * @CreateTime 2019-12-26
 * @Description
 */
public class test {
    public static void main(String[] args) {

        byte[] time = Bytes.toBytes(System.nanoTime());
        System.out.println(time.length);
        System.out.println(new File("G://BeidouNI-1.58/BeidouNI/bin/1_2987035.dat").exists());
    }

}
