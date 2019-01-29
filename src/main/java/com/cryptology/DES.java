package com.cryptology;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

//对称加密算法，加密和解密使用相同的秘钥算法
//DES加密解密，秘钥长度必须是8的倍数,password必须为8位
public class DES {

    //可信任的随机数源
    private static SecureRandom sr = new SecureRandom();

    public byte[] encode(String date, String password) {
        try {
            DESKeySpec dks = new DESKeySpec(password.getBytes());
            //创建密匙工厂
            SecretKeyFactory keys = SecretKeyFactory.getInstance("DES");
            SecretKey key = keys.generateSecret(dks);
            //加密操作
            Cipher c = Cipher.getInstance("DES");
            //秘钥初始化Cipher对象，ENCRYPT_MODE初始化加密模式常量
            c.init(Cipher.ENCRYPT_MODE, key, sr);
            //获取数据并加密
            return c.doFinal(date.getBytes());
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] decode(byte[] s, String password) {
        try {
            //创建DESKeySpec对象
            DESKeySpec dks = new DESKeySpec(password.getBytes());
            //创建秘钥工厂
            SecretKeyFactory keys = SecretKeyFactory.getInstance("DES");
            //将DESKeySpec对象，转成SecretKey对象
            SecretKey key = keys.generateSecret(dks);
            //Cipher对象完成解密操作
            Cipher c = Cipher.getInstance("DES");
            //密匙初始化Cipher对象
            c.init(Cipher.DECRYPT_MODE, key, sr);
            return c.doFinal(s);
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String pass = "12345678";
        String user = "crypt";

        //加密
        byte[] encode = new DES().encode(user, pass);
        System.out.println(encode);
        //解密
        byte[] decode = new DES().decode(encode, pass);
        System.out.println(new String(decode));
    }
}
