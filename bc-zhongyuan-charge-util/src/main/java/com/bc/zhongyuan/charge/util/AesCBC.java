//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.bc.zhongyuan.charge.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

public class AesCBC {
    private static final String CIPHER_MODE = "AES/CBC/PKCS5Padding";
    private static final String KEY_ALGORITHM = "AES";
    private static final String VI_STR = "6DA0557C5119454A";

    public AesCBC() {
    }

    public static String createSecretKey() throws UnsupportedEncodingException {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        StringBuilder sb = new StringBuilder();
        sb.append(uuid);

        while(sb.length() < 16) {
            sb.append("0");
        }

        if (sb.length() > 16) {
            sb.setLength(16);
        }

        return sb.toString();
    }

    public static IvParameterSpec createIVSpec(String ivStr) {
        byte[] data = null;
        if (ivStr == null) {
            ivStr = "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ivStr);

        while(sb.length() < 16) {
            sb.append("0");
        }

        if (sb.length() > 16) {
            sb.setLength(16);
        }

        try {
            data = sb.toString().getBytes("utf-8");
        } catch (Exception var4) {
            return null;
        }

        return new IvParameterSpec(data);
    }

    public static String encryptAES(byte[] content, String key) {
        String result = null;

        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, new SecretKeySpec(key.getBytes("utf-8"), "AES"), createIVSpec("6DA0557C5119454A"));
            byte[] bytes = cipher.doFinal(content);
            result = encodeBase64(bytes);
            return result;
        } catch (Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public static byte[] decryptAES(String content, String key) {
        Object var2 = null;

        try {
            content = Conver.replaceBaseStr(content);
            byte[] data = decodeBase64(content);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(key.getBytes("utf-8"), "AES"), createIVSpec("6DA0557C5119454A"));
            byte[] result = cipher.doFinal(data);
            return result;
        } catch (Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public static String encodeBase64(byte[] conent) {
        Base64 base64 = new Base64();
        byte[] bytes = base64.encode(conent);
        String s = null;

        try {
            s = new String(bytes, "utf-8");
        } catch (UnsupportedEncodingException var5) {
            var5.printStackTrace();
        }

        return s;
    }

    public static byte[] decodeBase64(String conent) {
        byte[] bytes = null;

        try {
            bytes = conent.getBytes("utf-8");
        } catch (UnsupportedEncodingException var3) {
            var3.printStackTrace();
        }

        Base64 base64 = new Base64();
        bytes = base64.decode(bytes);
        return bytes;
    }
}
