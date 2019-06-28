//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.bc.zhonghang.charge.util.sdk;

import java.util.*;

public class CollectionUtils {
    public CollectionUtils() {
    }

    public static Map<String, String> paraFilter(Map<String, String> sArray) {
        Map<String, String> result = new HashMap();
        if (sArray != null && sArray.size() > 0) {
            Iterator var2 = sArray.keySet().iterator();

            while(var2.hasNext()) {
                String key = (String)var2.next();
                String value = (String)sArray.get(key);
                if (value != null && !value.trim().equals("") && !value.equalsIgnoreCase("null") && !key.equalsIgnoreCase("sign") && !key.equalsIgnoreCase("sign_type") && !key.equalsIgnoreCase("is_success")) {
                    result.put(key, value);
                }
            }

            return result;
        } else {
            return result;
        }
    }

    public static String createOrgSignString(Map<String, String> params) {
        List<String> keys = new ArrayList(params.keySet());
        Collections.sort(keys);
        StringBuffer prestr = new StringBuffer();

        for(int i = 0; i < keys.size(); ++i) {
            String key = (String)keys.get(i);
            String value = (String)params.get(key);
            if (i == keys.size() - 1) {
                prestr.append(key).append("=").append(value);
            } else {
                prestr.append(key).append("=").append(value).append("&");
            }
        }

        return prestr.toString();
    }
}
