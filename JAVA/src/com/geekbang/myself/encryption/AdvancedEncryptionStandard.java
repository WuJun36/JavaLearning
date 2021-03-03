package com.geekbang.myself.encryption;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @author ：wujun
 * @date ：Created in 2021/2/9
 * @description：AES算法的使用
 */
public class AdvancedEncryptionStandard {

    public static void main(String[] args) throws Exception {
        String message = "Hello, world!";
        System.out.println("Message: " + message);
        // 128位密钥 = 16 bytes key:
        byte[] key = "1234567890abcdef".getBytes("UTF-8");
        // 加密
        byte[] data = message.getBytes("UTF-8");
        System.out.println("-------------ECB模式----------------");
        byte[] encrypted = encrypt(key, data);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
        // 解密
        byte[] decrypted = decrypt(key, encrypted);
        System.out.println("Decrypted: " + new String(decrypted, "UTF-8"));

        System.out.println("-------------CBC模式--------------");
        byte[] encryptedCBC = encryptedByCBC(key, data);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encryptedCBC));
        byte[] decryptedCBC = decryptedByCBC(key, encryptedCBC);
        System.out.println("Decrypted: " + new String(decryptedCBC, "UTF-8"));


    }


    // TODO ECB模式加密，固定的明文会得到固定的密文
    public static byte[] encrypt(byte[] key, byte[] message) throws GeneralSecurityException {
        //todo 根据算法名称/工作模式/填充模式获取Cipher实例
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        //todo 根据算法名称，初始化一个SecretKey实例，密钥必须是指定长度
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        //todo 使用得到的SecretKey初始化Cipher实例，并设置加密模式
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        //todo 传入明文，获得加密后的密文
        return cipher.doFinal(message);
    }

    public static byte[] decrypt(byte[] key, byte[] secret) throws GeneralSecurityException {
        // 根据算法名称/工作模式/填充模式获取Cipher实例
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        // 根据算法名称，初始化一个SecretKey实例
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        // 根据SecretKey初始化Cipher实例，并设置解密模式
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        // 传入密文，获得明文
        return cipher.doFinal(secret);

    }

    // TODO CBC模式加密，每次加密时输入一个随机数作为VI参数，同一份明文可以得到不同的密文
    public static byte[] encryptedByCBC(byte[] key, byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        // todo CBC模式需要生成一个16 bytes的initialization vector:
        // todo x在CBC模式下，需要一个随机生成的16字节IV参数，必须使用SecureRandom生成。
        SecureRandom sr = SecureRandom.getInstanceStrong();
        byte[] iv = sr.generateSeed(16);
        IvParameterSpec ivps = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivps);
        byte[] data = cipher.doFinal(input);
        //todo iv也需要一起返回
        return join(iv, data);
    }

    public static byte[] decryptedByCBC(byte[] key, byte[] input) throws GeneralSecurityException {
        // 将input分割成iv和data
        byte[] iv = new byte[16];
        byte[] data = new byte[input.length - 16];
        System.arraycopy(input, 0, iv, 0, 16);
        System.arraycopy(input, 16, data, 0, data.length);
        // 解密
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivps = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE,secretKeySpec,ivps);
        return cipher.doFinal(data);

    }


    public static byte[] join(byte[] input1, byte[] input2) {
        byte[] res = new byte[input1.length + input2.length];
        System.arraycopy(input1, 0, res, 0, input1.length);
        System.arraycopy(input2, 0, res, input1.length, input2.length);
        return res;

    }
}
