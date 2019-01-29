package com.cryptology;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//生成40位
public class SHA1 {

    public char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String getSHA1(String message) {
        if (message == null || 0 == message.length()) {
            return null;
        }
        try {
            //创建SHA1算法消息摘要对象
            MessageDigest SHA = MessageDigest.getInstance("SHA1");
            //字节数组更新摘要
            SHA.update(message.getBytes());
            //生成HASH值数组
            byte[] digest = SHA.digest();
            //SHA1算法生成摘要信息
            int len = digest.length, k = 0;
            char[] buf = new char[len * 2];
            for (int i = 0; i < len; i++) {
                byte b = digest[i];
                buf[k++] = hexDigits[b >>> 4 & 0xf];
                buf[k++] = hexDigits[b & 0xf];
            }
            return new String(buf);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "0";
    }

    public static void main(String[] args) {
        System.out.println(new SHA1().getSHA1("美丽的姑娘"));
    }
}
