//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.bc.zhonghang.charge.util.sdk;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HmacBase64 {
    public HmacBase64() {
    }

    public static String getBase64ByHmacSHA256(String secretKey, String src) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        return Base64Support.toUrlStr(HMAC.getHmacSHA256(secretKey, src));
    }

    public static String getBase64ByHmacSHA1(String secretKey, String src) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        return Base64Support.toUrlStr(HMAC.getHmacSHA1(secretKey, src));
    }

    public static String getBase64ByHmacMD5(String secretKey, String src) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        return Base64Support.toUrlStr(HMAC.getHmacMD5(secretKey, src));
    }
}
