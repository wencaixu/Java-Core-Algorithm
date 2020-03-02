package com.algorithm.string.com.cryptology;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public final class Base64 {
    public static byte[] decryptBASE64(String key) {
        byte[] decoder = null;
        try {
            decoder = (new BASE64Decoder()).decodeBuffer(key);
            return decoder;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encryptBASE64(byte[] key) {
        return (new BASE64Encoder()).encodeBuffer(key);
    }
}
