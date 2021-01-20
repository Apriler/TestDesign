package com.bonc.example.demo.key;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * @Author luoaojin
 * @Date 2020/12/23 15:37
 * @Description
 * @Version 1.0
 */
public class AES {
    private static String src = "wen-m,s.[]@boaASDin--=+.*";

    public static void main(String[] args) {
        jdkAES();
    }

    public static void jdkAES() {

        try {
            // 生成key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] keybytes = secretKey.getEncoded();
            // key的转换
            Key key = new SecretKeySpec(keybytes, "AES");
            // 加密
            // AES/工作模式/填充方式
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk aes encrypt : " + Hex.encodeHexString(result));

            // 解密
            cipher.init(Cipher.DECRYPT_MODE, key);
            result = cipher.doFinal(Hex.decodeHex(Hex.encodeHexString(result)));
            System.out.println("jdk aes decrypt : " + new String(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
