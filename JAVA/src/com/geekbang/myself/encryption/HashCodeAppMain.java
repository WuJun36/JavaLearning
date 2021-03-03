package com.geekbang.myself.encryption;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Arrays;

/**
 * @author ：wujun
 * @date ：Created in 2021/2/5
 * @description：hash算法
 */
public class HashCodeAppMain {

    public static void main(String[] args) throws Exception {
        // todo 相同的输入一定会得到相同的输出
        // todo 不同的输入大概率会得到不同的输出
        // todo
        System.out.println("hello".hashCode());
        System.out.println("hello".hashCode());
        System.out.println("JaeMin".hashCode());

        // todo 创建一个“MD5”算法的MessageDigest实例
        MessageDigest digest = MessageDigest.getInstance("MD5");
        // todo 不断update输入数据
        digest.update("Hello".getBytes(StandardCharsets.UTF_8));
        digest.update("World".getBytes(StandardCharsets.UTF_8));
        byte[] res = digest.digest();
        // todo 转成16进制的字符串
        System.out.println(new BigInteger(1,res).toString(16));

        System.out.println("---------------BouncyCastle-------------------");
        // 采用BouncyCastle提供的算法
        // TODO 注册BouncyCastle
        Security.addProvider(new BouncyCastleProvider());
        // TODO 创建一个MessageDigest算法，可以使用BouncyCastle的算法
        MessageDigest messageDigest = MessageDigest.getInstance("RipeMD160");
        messageDigest.update("HelloWorld".getBytes(StandardCharsets.UTF_8));
        byte[] res2 = messageDigest.digest();
        System.out.println(new BigInteger(1,res2).toString(16));

        System.out.println("----------------Hmac算法---------------------");
        // TODO Hmac算法
        // TODO 通过Java标准库的KeyGenerator生成一个安全的随机的key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] encoded = secretKey.getEncoded();
//        System.out.println(Arrays.toString(encoded));
        System.out.println(new BigInteger(1,encoded).toString(16));
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(secretKey);
        mac.update("HelloWorld".getBytes("UTF-8"));
        byte[] bytes = mac.doFinal();
//        System.out.println(Arrays.toString(bytes));
        System.out.println(new BigInteger(1,bytes).toString(16));

        byte[] hkey = new byte[] { 106, 70, -110, 125, 39, -20, 52, 56, 85, 9, -19, -72, 52, -53, 52, -45, -6, 119, -63,
                30, 20, -83, -28, 77, 98, 109, -32, -76, 121, -106, 0, -74, -107, -114, -45, 104, -104, -8, 2, 121, 6,
                97, -18, -13, -63, -30, -125, -103, -80, -46, 113, -14, 68, 32, -46, 101, -116, -104, -81, -108, 122,
                89, -106, -109 };

        SecretKey key = new SecretKeySpec(encoded, "HmacMD5");  //根据之前secretKey加密编译后的byte[]形式来重新恢复
        Mac mac2 = Mac.getInstance("HmacMD5");
        mac2.init(key);
        mac2.update("HelloWorld".getBytes("UTF-8"));
        byte[] result = mac2.doFinal();
//        System.out.println(Arrays.toString(result));
        System.out.println(new BigInteger(1,result).toString(16));


    }
}
