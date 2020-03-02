package com.algorithm.string.com.cryptology;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import static com.cryptology.Base64.decryptBASE64;
import static com.cryptology.Base64.encryptBASE64;

public class RSA {

    private static final String ALGORITHM = "RSA";

    private static final String SIGNATURE = "MD5withRSA";

    private static final String PUBLIC_KEY = "RSAPublicKey";

    private static final String PRIVATE_KEY = "RSAPrivateKey";

    /**
     * 对私钥信息生成数字签名
     *
     * @param data
     * @param privateKey
     * @return
     */
    public static String sign(byte[] data, String privateKey) {
        //解密base64编码私匙
        byte[] keyBytes = decryptBASE64(privateKey);
        //构造PCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec pcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);

        KeyFactory keyFactory = null;
        PrivateKey privatekey = null;
        Signature signature = null;
        String result = null;
        try {
            //指定加密算法
            keyFactory = KeyFactory.getInstance(ALGORITHM);
            //取私钥对象
            privatekey = keyFactory.generatePrivate(pcs8KeySpec);
            //使用私钥生成数字签名
            signature = Signature.getInstance(SIGNATURE);
            signature.initSign(privatekey);
            signature.update(data);
            result = encryptBASE64(signature.sign());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 验证数字签名
     */

    public static boolean verify(byte data[], String publicKey, String sign) {
        boolean isVerify = false;
        KeyFactory keyFactory = null;
        PublicKey pubKey = null;
        Signature signature = null;
        //解密有base64编码公钥
        byte[] keyBytes = decryptBASE64(publicKey);
        // 构造X509EncodedKeySpec对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        try {
            // 指定的加密算法
            keyFactory = KeyFactory.getInstance(ALGORITHM);
            // 取公钥匙对象
            pubKey = keyFactory.generatePublic(keySpec);
            signature = Signature.getInstance(SIGNATURE);
            signature.initVerify(pubKey);
            signature.update(data);
            isVerify = signature.verify(decryptBASE64(sign));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isVerify;
    }

    /**
     * 公匙加密
     */
    public static byte[] encryptByPublicKey(byte[] data, String key)
            throws Exception {
        // 对公钥解密
        byte[] keyBytes = decryptBASE64(key);

        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);

        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        return cipher.doFinal(data);
    }

    /**
     * 私匙加密
     */
    public static byte[] encryptByPrivateKey(byte[] data, String key)
            throws Exception {
        // 对密钥解密
        byte[] keyBytes = decryptBASE64(key);

        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return cipher.doFinal(data);
    }


    /**
     * 私钥解密
     */
    public static byte[] decryptByPrivateKey(byte[] data, String key)
            throws Exception {
        // 对密钥解密
        byte[] keyBytes = decryptBASE64(key);

        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        return cipher.doFinal(data);
    }

    /**
     * 公匙解密
     */

    public static byte[] decryptByPublicKey(byte[] data, String key)
            throws Exception {
        // 对密钥解密
        byte[] keyBytes = decryptBASE64(key);

        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);

        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        return cipher.doFinal(data);
    }

    /**
     * 获取私匙
     */
    public static String getPrivateKey(Map<String, Key> keyMap)
            throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);

        return encryptBASE64(key.getEncoded());
    }

    /**
     * 获取公钥
     */
    public static String getPublicKey(Map<String, Key> keyMap)
            throws Exception {
        Key key = (Key) keyMap.get(PUBLIC_KEY);

        return encryptBASE64(key.getEncoded());
    }

    /**
     * 初始化密匙
     */
    public static Map<String, Key> initKey() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator
                .getInstance(ALGORITHM);
        keyPairGen.initialize(1024);

        KeyPair keyPair = keyPairGen.generateKeyPair();

        // 公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

        // 私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        Map<String, Key> keyMap = new HashMap<>(2);

        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Key> keyMap = null;
        try {
            keyMap = initKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String publicKey = getPublicKey(keyMap);
        String privateKey = getPrivateKey(keyMap);

        System.out.println(keyMap);
        System.out.println("-----------------------------------");
        System.out.println("公钥: " + publicKey);
        System.out.println("-----------------------------------");
        System.out.println("私钥: " + privateKey);
        System.out.println("-----------------------------------");
        byte[] encryptByPrivateKey = new byte[0];
        try {
            encryptByPrivateKey = encryptByPrivateKey("123456".getBytes(), privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] encryptByPublicKey = encryptByPublicKey("123456".getBytes(), publicKey);
        System.out.println(encryptByPrivateKey);
        System.out.println("-----------------------------------");
        System.out.println(encryptByPublicKey);
        System.out.println("-----------------------------------");
        String sign = sign(encryptByPrivateKey, privateKey);
        System.out.println(sign);
        System.out.println("-----------------------------------");
        boolean verify = verify(encryptByPrivateKey, publicKey, sign);
        System.out.println(verify);
        System.out.println("-----------------------------------");
        byte[] decryptByPublicKey = new byte[0];
        try {
            decryptByPublicKey = decryptByPublicKey(encryptByPrivateKey, publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] decryptByPrivateKey = new byte[0];
        try {
            decryptByPrivateKey = decryptByPrivateKey(encryptByPublicKey, privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(decryptByPublicKey);
        System.out.println("-----------------------------------");
        System.out.println(decryptByPrivateKey);
    }
}
