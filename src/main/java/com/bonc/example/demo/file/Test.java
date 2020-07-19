package com.bonc.example.demo.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author luoaojin
 * @CreateTime 2020-06-05
 * @Description
 */
public class Test {
    public static void main(String[] args) throws IOException {
        byte[] bytes = FileUtils.readFileToByteArray(new File("C:\\Users\\Administrator\\Desktop\\c.sh"));
        String address = "C:\\Users\\Administrator\\Desktop";
        StringBuffer sb = new StringBuffer();
        //文件存放目录为 ../beh-director/tmp/{clusterId}/hadoop.keytab
        sb.append(address)
                .append("\\tmp")
                .append("\\d.sh");

        FileUtils.writeByteArrayToFile(new File(sb.toString()),bytes);


    }
}
