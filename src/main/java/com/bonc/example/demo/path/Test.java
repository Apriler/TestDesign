package com.bonc.example.demo.path;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author luoaojin
 * @Date 2021/5/26 9:41
 * @Description
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        Path absRubySrc = Paths.get("../../../../$HBASE_HOME/",
                "lib/ruby/").toAbsolutePath();

//        System.out.println("Home:" + hbaseHome);
//        System.out.println("Ruby Src:" + rubySrc);

        File f = absRubySrc.toFile();
        if (!f.exists() || !f.isDirectory()) {
            System.out.println("HBase ruby sources is not available at '" + absRubySrc
                    + "'");
        }
    }
}
