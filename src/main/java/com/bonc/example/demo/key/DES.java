package com.bonc.example.demo.key;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Hex;
public class DES {
	
	static String string = "wen-min--=+.*wen-min--=+.*wen-min--=+.*wen-min--=+.*wen-min--=+.*wen-min--=+.*";
	public static void main(String[] args) {
		DES.jdkDES();
	}
	
	public static void jdkDES() {
		
		try {			
	
			// 生成key//返回生成指定算法密钥的KeyGenerator对象
	        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
	        keyGenerator.init(56);//初始化此密钥生成器,使其具有确定的密钥大小
	        SecretKey secretKey = keyGenerator.generateKey();//生成一个密钥
	        byte[] bs = secretKey.getEncoded();
	
	        // key转换
	        DESKeySpec desKeySpec = new DESKeySpec(bs); //实例化DES密钥规则
	        SecretKeyFactory factory = SecretKeyFactory.getInstance("DES"); //实例化密钥工厂
	        Key convertSecretKey = factory.generateSecret(desKeySpec); //生成密钥
	
	        // 加密
	        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
	        byte[] result = cipher.doFinal(string.getBytes());
	        System.out.println("jdk des encrypt:" + Hex.encodeHexString(result));
	        
	        // 解密
	        cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
	        result = cipher.doFinal(result);
	        System.out.println("jdk des decrypt:" + new String(result));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}