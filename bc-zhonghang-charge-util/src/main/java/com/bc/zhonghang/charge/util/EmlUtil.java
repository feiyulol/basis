package com.bc.zhonghang.charge.util;



import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

public class EmlUtil {

    public static String target_url;

    private static String concatParams(Map<String, String> params2) throws UnsupportedEncodingException {
        Object[] key_arr = params2.keySet().toArray();
        Arrays.sort(key_arr);
        String str = "";

        for (Object key : key_arr) {
            String val = params2.get(key);
            key = URLEncoder.encode(key.toString(), "UTF-8");
            val = URLEncoder.encode(val, "UTF-8");
            str += "&" + key + "=" + val;
        }

        return str.replaceFirst("&", "");
    }

    private static String byte2hex(byte[] b) {
        StringBuffer buf = new StringBuffer();
        int i;

        for (int offset = 0; offset < b.length; offset++) {
            i = b[offset];
            if (i < 0)
                i += 256;
            if (i < 16)
                buf.append("0");
            buf.append(Integer.toHexString(i));
        }

        return buf.toString();
    }

    private static String byteArrayToHexString(byte[] b) {  
        StringBuilder hs = new StringBuilder();     
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {   
               stmp = Integer.toHexString(b[n] & 0XFF);    
               if (stmp.length() == 1)           
               hs.append('0');     
               hs.append(stmp);    
          }
         return hs.toString().toLowerCase();   
       }

    public static String genSig(String pathUrl, Map<String, String> params,
                                String consumerSecret) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String str = concatParams(params);
        target_url = pathUrl + "?" + str;
        str = pathUrl + "&" + str;
        System.out.println(str);

        String hash = "";
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        try {
            SecretKeySpec secret_key = new SecretKeySpec(consumerSecret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(str.getBytes());   
            hash = byteArrayToHexString(bytes);
        } catch (Exception e) {
                System.out.println(e.getStackTrace());
        }
        return hash;
    }
}