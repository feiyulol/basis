//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.bc.zhonghang.charge.util;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Conver {
    public Conver() {
    }

    public static String IntToAsc(int i) {
        return String.valueOf(i);
    }

    public static String AscToHex(String s) {
        return BinToHex(s.getBytes());
    }

    public static int AscToInt(String s) {
        return Integer.parseInt(s);
    }

    public static int BinToInt(byte[] arr) {
        int ret = 0;

        for(int i = 0; i < arr.length; ++i) {
            ret = ret * 256 + (arr[i] > 0 ? arr[i] : arr[i] + 256);
        }

        return ret;
    }

    public static byte[] HexToBin(String hexString) {
        ArrayList<Byte> list = new ArrayList();

        for(int i = 0; i < hexString.length(); i += 2) {
            char a = hexString.charAt(i);
            char b = hexString.charAt(i + 1);
            int ia = getIntValue(a);
            int ib = getIntValue(b);
            list.add(Integer.valueOf(ia * 16 + ib).byteValue());
        }

        list.trimToSize();
        byte[] ret = new byte[list.size()];

        for(int i = 0; i < list.size(); ++i) {
            ret[i] = (Byte)list.get(i);
        }

        return ret;
    }

    public static String BinToHex(byte[] arr) {
        ArrayList<Character> list = new ArrayList();

        for(int i = 0; i < arr.length; ++i) {
            i = arr[i];
            if (i < 0) {
                i += 256;
            }

            int a = i / 16;
            int b = i % 16;
            list.add(getHexValue(a));
            list.add(getHexValue(b));
        }

        list.trimToSize();
        char[] cArr = new char[list.size()];

        for(int i = 0; i < list.size(); ++i) {
            cArr[i] = (Character)list.get(i);
        }

        String ret = new String(cArr);
        return ret;
    }

    private static int getIntValue(char c) {
        switch(c) {
        case 'A':
        case 'a':
            return 10;
        case 'B':
        case 'b':
            return 11;
        case 'C':
        case 'c':
            return 12;
        case 'D':
        case 'd':
            return 13;
        case 'E':
        case 'e':
            return 14;
        case 'F':
        case 'f':
            return 15;
        default:
            return c - 48;
        }
    }

    private static char getHexValue(int c) {
        String s = Integer.toHexString(c).toUpperCase();
        return s.charAt(0);
    }

    public static byte[] getHeadBuff(int dylen, int len, String type) {
        if (dylen == 0) {
            return new byte[0];
        } else if (!"NUM".equals(type)) {
            return new byte[0];
        } else {
            StringBuilder lStr = new StringBuilder();
            lStr.append(len);
            lStr.trimToSize();
            lStr.reverse();
            int i = 0;

            for(int j = dylen - lStr.length(); i < j; ++i) {
                lStr.append('0');
            }

            lStr.trimToSize();
            return lStr.reverse().toString().getBytes();
        }
    }

    public static String encodeBase64(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

    public static byte[] decodeBase64(String conent) {
        Object var1 = null;

        byte[] bytes;
        try {
            bytes = conent.getBytes("utf-8");
        } catch (UnsupportedEncodingException var3) {
            bytes = conent.getBytes(Charset.defaultCharset());
        }

        bytes = Base64.decodeBase64(bytes);
        return bytes;
    }

    public static String getString(String str) {
        return str == null ? null : str;
    }

    public static String replaceBaseStr(String arg) {
        return getString(arg).replaceAll("[\\n\\r]", "");
    }
}
