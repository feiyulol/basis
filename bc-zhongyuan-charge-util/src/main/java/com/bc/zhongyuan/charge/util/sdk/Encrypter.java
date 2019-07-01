package com.bc.zhongyuan.charge.util.sdk;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class Encrypter {
    private static Cipher ecipher;
    private static Cipher dcipher;
    private static final String key = "*:@1$7!b*:@1$8!a*:@1$7!a";
    private static final String alg = "DESede";
    private static final String codeType = "UTF-8";
    static Logger LOGGER = Logger.getLogger(Encrypter.class.getName());

    public Encrypter() {
    }

    public static String encrypt(String str) {
        if (str == null) {
            return "";
        } else {
            try {
                byte[] utf8 = str.getBytes("UTF-8");
                byte[] enc = ecipher.doFinal(utf8);
                return Base64Support.toUrlStr(enc);
            } catch (Exception var3) {
                LOGGER.error("encrypt", var3);
                return "";
            }
        }
    }

    public static String encrypt(String desKey, String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        } else {
            try {
                if (null == desKey || desKey.isEmpty()) {
                    desKey = "*:@1$7!b*:@1$8!a*:@1$7!a";
                }

                SecretKey skey = new SecretKeySpec(desKey.getBytes(), "DESede");
                Cipher ecipher = Cipher.getInstance("DESede");
                ecipher.init(1, skey);
                byte[] utf8 = str.getBytes("UTF-8");
                byte[] enc = ecipher.doFinal(utf8);
                return Base64Support.toUrlStr(enc);
            } catch (Exception var6) {
                LOGGER.error("encrypt", var6);
                return "";
            }
        }
    }

    public static String decrypt(String str) {
        if (str == null) {
            return "";
        } else {
            try {
                byte[] dec = Base64Support.fromUrlStr(str);
                byte[] utf8 = dcipher.doFinal(dec);
                return new String(utf8, "UTF-8");
            } catch (Exception var3) {
                LOGGER.error("decrypt", var3);
                return "";
            }
        }
    }

    public static String decrypt(String desKey, String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        } else {
            try {
                if (null == desKey || desKey.isEmpty()) {
                    desKey = "*:@1$7!b*:@1$8!a*:@1$7!a";
                }

                SecretKey skey = new SecretKeySpec(desKey.getBytes(), "DESede");
                Cipher dcipher = Cipher.getInstance("DESede");
                dcipher.init(2, skey);
                byte[] dec = Base64Support.fromUrlStr(str);
                byte[] utf8 = dcipher.doFinal(dec);
                return new String(utf8, "UTF-8");
            } catch (Exception var6) {
                LOGGER.error("decrypt", var6);
                return "";
            }
        }
    }

    public static void main(String[] args) {
        String key = "67ytrfde435edswe345rde43";
        String text = "g5oUY2-79zrOUbdmw7Oba4gIcDpS_cM0";
        String ss = decrypt(key, text);
        System.out.println(ss);
        key = "2gtr5r45re45rdft654re345";
        System.out.println(encrypt(key, "00001013584745074432"));
    }

    static {
        try {
            SecretKey skey = new SecretKeySpec("*:@1$7!b*:@1$8!a*:@1$7!a".getBytes(), "DESede");
            ecipher = Cipher.getInstance("DESede");
            dcipher = Cipher.getInstance("DESede");
            ecipher.init(1, skey);
            dcipher.init(2, skey);
        } catch (Exception var1) {
            LOGGER.error("SecretKeySpec", var1);
        }

    }
}
