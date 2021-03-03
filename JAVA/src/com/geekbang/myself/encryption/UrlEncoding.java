package com.geekbang.myself.encryption;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author ：wujun
 * @date ：Created in 2021/2/4
 * @description：URL编码
 */
public class UrlEncoding {

    public static void main(String[] args) throws UnsupportedEncodingException {
        // 考虑到兼容性，某些服务器可能只能识别ASCII字符，不能识别中文字符等
        // TODO URL的编码规则：
        //  如果字符是A~Z，a~z，0~9以及-、_、.、*，则保持不变；
        //  如果是其他字符，先转换为UTF-8编码，然后对每个字节以%XX表示。
        String encode = URLEncoder.encode("中文!", StandardCharsets.UTF_8.toString());
        System.out.println(encode);
        String decode = URLDecoder.decode(encode, StandardCharsets.UTF_8.toString());
        System.out.println(decode);


        //TODO Base64编码 把二进制数据编码为纯文本格式
        //TODO byte字节：一个字节存储8位无符号数
        byte[] input = new byte[]{(byte) 0xe4, (byte) 0xb8, (byte) 0xad };
        String base64Encode = Base64.getEncoder().encodeToString(input);
        System.out.println(base64Encode);

        byte[] base64Decode = Base64.getDecoder().decode(base64Encode);
        System.out.println(Arrays.toString(base64Decode));
    }
}
