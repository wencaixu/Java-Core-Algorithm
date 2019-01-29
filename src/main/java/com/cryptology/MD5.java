package com.cryptology;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    //默认生成256bit,32位字符串
    public String getMD5Code(String message) {
        StringBuilder sb = new StringBuilder();
        try {
            //创建MD5消息摘要
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //生成HASH值字节数组
            byte[] digest = md5.digest(message.getBytes());
            //二进制转换成十六进制
            int TMP = 0;
            for (int i = 0; i < digest.length; i++) {
                TMP = digest[i];
                if (TMP < 0) {
                    TMP += 256;
                }
                if (TMP < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(TMP));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MD5().getMD5Code("西湖，最美").length());
    }
}
