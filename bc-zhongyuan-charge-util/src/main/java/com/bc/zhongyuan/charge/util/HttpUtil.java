package com.bc.zhongyuan.charge.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Http 工具类
 *
 * @ClassName: HttpUtil.java
 * @Description: Http 工具类
 * @author: f.hu@i-vpoints.com
 * @date: 2017-10-11 11:22
 */
public class HttpUtil {

    /**
     * 发送get请求
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String get(String url) throws IOException {
        return get(url, null);
    }

    /**
     * 发送get请求
     *
     * @param url
     * @param headers
     * @return
     * @throws IOException
     */
    public static String get(String url, Map<String, String> headers) throws IOException {
        return fetch("GET", url, null, headers);
    }

    public static String post(String url, String body, Map<String, String> headers) throws IOException {
        return fetch("POST", url, body, headers);
    }

    public static String post(String url, String body) throws IOException {
        return post(url, body, null);
    }

    public static String postJSON(String url, String body) throws IOException {
        Map headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        return post(url, body, headers);
    }

    public static String postForm(String url, Map<String, String> params) throws IOException {
        return postForm(url, params, null);
    }

    public static String postForm(String url, Map<String, String> params, Map<String, String> headers) throws IOException {
        if (headers == null) {
            headers = new HashMap<String, String>();
        }
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        String body = "";
        if (params != null) {
            boolean first = true;
            for (String param : params.keySet()) {
                if (first) {
                    first = false;
                } else {
                    body += "&";
                }
                String value = params.get(param);
                body += URLEncoder.encode(param, "UTF-8") + "=";
                body += URLEncoder.encode(value, "UTF-8");
            }
        }
        return post(url, body, headers);
    }

    public static String put(String url, String body, Map<String, String> headers) throws IOException {
        return fetch("PUT", url, body, headers);
    }

    public static String put(String url, String body) throws IOException {
        return put(url, body, null);
    }

    public static String delete(String url, Map<String, String> headers) throws IOException {
        return fetch("DELETE", url, null, headers);
    }

    public static String delete(String url) throws IOException {
        return delete(url, null);
    }

    public static String fetch(String method, String url, String body, Map<String, String> headers) throws IOException {
        URL u = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();
        conn.setConnectTimeout(10000);
        conn.setReadTimeout(10000);

        if (method != null) {
            conn.setRequestMethod(method);
        }
        if (headers != null) {
            for (String key : headers.keySet()) {
                conn.addRequestProperty(key, headers.get(key));
            }
        }

        if (body != null) {
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            os.write(body.getBytes());
            os.flush();
            os.close();
        }

        InputStream is = conn.getInputStream();
        String response = streamToString(is);
        is.close();

        if (conn.getResponseCode() == 301) {
            String location = conn.getHeaderField("Location");
            return fetch(method, location, body, headers);
        }
        return response;
    }

    public static String streamToString(InputStream in) throws IOException {
        StringBuffer out = new StringBuffer();
        InputStreamReader reader = new InputStreamReader(in, "UTF-8");
        char[] b = new char[64];
        for (int n; (n = reader.read(b)) != -1; ) {
            out.append(new String(b, 0, n));
        }
        return out.toString();
    }
}
