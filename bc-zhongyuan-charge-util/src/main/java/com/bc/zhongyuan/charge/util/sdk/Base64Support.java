//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.bc.zhongyuan.charge.util.sdk;

import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Base64Support {
    public Base64Support() {
    }

    public static String toUrlStr(byte[] bytes) {
        Encoder encoder = Base64.getEncoder();
        String str = encoder.encodeToString(bytes);
        if (str == null) {
            return "";
        } else {
            str = str.replaceAll("\\+", "_");
            str = str.replaceAll("/", "-");
            str = str.replaceAll("=", ".");
            str = str.replaceAll("\\s", "");
            return str;
        }
    }

    public static byte[] fromUrlStr(String str) throws IOException {
        if (str == null) {
            return null;
        } else {
            str = str.replaceAll("_", "+");
            str = str.replaceAll("-", "/");
            str = str.replaceAll("\\.", "=");
            Decoder decoder = Base64.getDecoder();
            byte[] dec = decoder.decode(str);
            return dec;
        }
    }
}
