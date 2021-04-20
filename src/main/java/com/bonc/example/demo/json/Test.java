package com.bonc.example.demo.json;

import java.text.DecimalFormat;

/**
 * @Author luoaojin
 * @Date 2021/3/16 11:14
 * @Description
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
//        String a =  "{\"pearl-3.bonc.com:9866\":{\"infoAddr\":\"172.16.15.230:0\",\"infoSecureAddr\":\"172.16.15.230:9865\",\"xferaddr\":\"172.16.15.230:9866\",\"lastContact\":1,\"usedSpace\":8192,\"adminState\":\"In Service\",\"nonDfsUsedSpace\":16937734144,\"capacity\":47003049984,\"numBlocks\":0,\"version\":\"3.3.0\",\"used\":8192,\"remaining\":30065307648,\"blockScheduled\":0,\"blockPoolUsed\":8192,\"blockPoolUsedPercent\":1.7428656E-5,\"volfails\":0,\"lastBlockReport\":173},\"pearl-2.bonc.com:9866\":{\"infoAddr\":\"172.16.15.229:0\",\"infoSecureAddr\":\"172.16.15.229:9865\",\"xferaddr\":\"172.16.15.229:9866\",\"lastContact\":1,\"usedSpace\":8192,\"adminState\":\"In Service\",\"nonDfsUsedSpace\":17662988288,\"capacity\":47003049984,\"numBlocks\":0,\"version\":\"3.3.0\",\"used\":8192,\"remaining\":29340053504,\"blockScheduled\":0,\"blockPoolUsed\":8192,\"blockPoolUsedPercent\":1.7428656E-5,\"volfails\":0,\"lastBlockReport\":318},\"pearl-1.bonc.com:9866\":{\"infoAddr\":\"172.16.15.228:0\",\"infoSecureAddr\":\"172.16.15.228:9865\",\"xferaddr\":\"172.16.15.228:9866\",\"lastContact\":1,\"usedSpace\":8192,\"adminState\":\"In Service\",\"nonDfsUsedSpace\":27824209920,\"capacity\":47003049984,\"numBlocks\":0,\"version\":\"3.3.0\",\"used\":8192,\"remaining\":19178831872,\"blockScheduled\":0,\"blockPoolUsed\":8192,\"blockPoolUsedPercent\":1.7428656E-5,\"volfails\":0,\"lastBlockReport\":164}}\"\n";
        System.out.println(getNetFileSizeDescription(141009L));

    }

    public static String getNetFileSizeDescription(long size) {
        StringBuffer bytes = new StringBuffer();
        DecimalFormat format = new DecimalFormat("###.00");
        if (size >= 1024L * 1024 * 1024 * 1024) {
            double i = (size / (1024.0 * 1024.0 * 1024.0 * 1024.0));
            bytes.append(format.format(i)).append("TB");
        } else if (size >= 1024L * 1024L * 1024L) {
            double i = (size / (1024.0 * 1024.0 * 1024.0));
            bytes.append(format.format(i)).append("GB");
        } else if (size >= 1024L * 1024L) {
            double i = (size / (1024.0 * 1024.0));
            bytes.append(format.format(i)).append("MB");
        } else if (size >= 1024L) {
            double i = (size / (1024.0));
            bytes.append(format.format(i)).append("KB");
        } else if (size < 1024L) {
            bytes.append("0B");
        }
        return bytes.toString();
    }

}
