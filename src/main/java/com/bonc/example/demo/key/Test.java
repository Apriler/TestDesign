package com.bonc.example.demo.key;

/**
 * @Author luoaojin
 * @Date 2020/12/23 16:21
 * @Description
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws Exception{
        String pwd = "bdc123";
        String encrypt = AESUtil.encrypt(pwd);
        System.out.println(encrypt);
//        System.out.println(AESUtil.encrypt(pwd));
        String decode = AESUtil.decrypt(encrypt);
        System.out.println(decode);
        System.out.println(pwd.equals(decode));
    }
}
