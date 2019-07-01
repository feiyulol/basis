package com.bc.zhongyuan.charge.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用于进行同步请求的post请求工具类
 *
 * @author g.yang@i-vpoints.com
 * @ClassName: Post
 * @Description: 用于进行同步请求的post请求工具类
 * @date 2015年12月31日 下午4:27:44
 */
public class Post {

    private static Logger logger = LoggerFactory.getLogger(Post.class);

    /**
     * 用于进行同步请求的post请求工具类
     *
     * @param contentType application/x-www-form-urlencoded;charset=utf-8
     * @return String
     * 接收到信息的字符串形式
     * @throws Exception
     * @Title: post
     * @author g.yang@i-vpoints.com
     * @date 2015年12月31日 下午4:26:57
     */
    public static final String post(String url, Map<String, String> params, String contentType) throws IOException {
        String result = "";
        Protocol https = new Protocol("https", new HTTPSSecureProtocolSocketFactory(), 443);
        Protocol.registerProtocol("https", https);
        PostMethod post = new PostMethod(url);
        HttpClient client = new HttpClient();
        HttpClientParams clientParams = new HttpClientParams();
        client.setParams(clientParams);
        try {
            post.setRequestHeader("Content-Type", contentType);
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            NameValuePair nvp = null;
            for (Map.Entry<String, String> entry : params.entrySet()) {
                nvp = new NameValuePair();
                nvp.setName(entry.getKey());
                nvp.setValue(entry.getValue());
                list.add(nvp);
            }
            post.setRequestBody(list.toArray(new NameValuePair[]{}));
            client.executeMethod(post);
            result = post.getResponseBodyAsString();
            Protocol.unregisterProtocol("https");
        } catch (HttpException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public static String get(String url) {
        String result = "";
        Protocol https = new Protocol("https", new HTTPSSecureProtocolSocketFactory(), 443);
        Protocol.registerProtocol("https", https);
        GetMethod get = new GetMethod(url);
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(get);
            result = get.getResponseBodyAsString();
            Protocol.unregisterProtocol("https");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String postJson(String url, String jsonString) throws IOException {
        String result = "";
        Protocol https = new Protocol("https", new HTTPSSecureProtocolSocketFactory(), 443);
        Protocol.registerProtocol("https", https);
        PostMethod post = new PostMethod(url);
        HttpClient client = new HttpClient();
        HttpClientParams clientParams = new HttpClientParams();
        client.setParams(clientParams);
        try {
            post.setRequestHeader("Content-Type", "application/json;charset=utf-8");
            RequestEntity re = new StringRequestEntity(jsonString, "application/json", "utf-8");
            post.setRequestEntity(re);
            client.executeMethod(post);
            result = post.getResponseBodyAsString();
            Protocol.unregisterProtocol("https");
        } catch (HttpException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * post请求工具类
     *
     * @param url
     * @param param post请求参数,a=a&b=b格式
     * @return
     * @throws UnsupportedEncodingException
     * @date 2017年7月27日下午4:01:09
     * @author jq.yin@i-vpoints.com
     */
    public static String post(String url, String param) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);
        // 设置参数
        StringEntity stringEntity = new StringEntity(param, "UTF-8");
        // 正文是URLEncoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
        stringEntity.setContentType("application/x-www-form-urlencoded");
        httpPost.setEntity(stringEntity);

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        HttpEntity entity = null;
        String responseContent = null;
        try {
            // 创建默认的httpClient实例
            httpClient = HttpClients.createDefault();
//			httpPost.setConfig(config);	// timeout时间等设置
            // 执行请求
            httpResponse = httpClient.execute(httpPost);
//			log.debug("请求起始行:" + httpResponse.getStatusLine().toString());
//			// 获得首部信息
//			log.debug("【获取响应头信息】");
//			Header[] hs = httpResponse.getAllHeaders();
//			for (Header h : hs) {
//				log.debug(h.getName() + "\t" + h.getValue());
//			}
            entity = httpResponse.getEntity();
            if (null != entity) {
                responseContent = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭相关资源
            try {
                /*
                 * 关闭资源，底层的流,以下代码即:
                 * InputStream inputStream = entity.getContent();
                 * inputStream.close();
                 */
                EntityUtils.consume(entity);

                if (httpResponse != null) {
                    httpResponse.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }

    /**
     * 广发Http Post请求
     *
     * @param url
     * @param param
     * @param code
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String cgbPost(String url, String param, String code) throws UnsupportedEncodingException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        HttpPost httpPost = new HttpPost(url);
        //设置参数
        StringEntity stringEntity = new StringEntity(param, "UTF-8");
        //设置xml传输格式
        stringEntity.setContentType("application/xml;charset=utf-8");
        httpPost.setEntity(stringEntity);

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        HttpEntity result = null;
        String responseContent = null;
        try {
            ConnectionKeepAliveStrategy keepAliveStrategy = new ConnectionKeepAliveStrategy() {
                @Override
                public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
                    //tomcat默认keep alive timeout为20s
                    return 20 * 1000;
                }
            };

            SSLContext sslcontext = SSLContexts.custom()
                    //忽略掉对服务器端证书的校验
                    //加载服务端提供的truststore(如果服务器提供truststore的话就不用忽略对服务器端证书的校验了)
                    .loadTrustMaterial(new File("/home/bc-bcpay_jar/tms.cgbchina.com.cn.store"), "password1!".toCharArray(), new TrustSelfSignedStrategy())
                    .build();

            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(
                    sslcontext
            );

            //创建默认的httpclient实例
            httpClient = HttpClients.custom()
                    .setKeepAliveStrategy(keepAliveStrategy)
                    .setDefaultRequestConfig(RequestConfig.custom().setStaleConnectionCheckEnabled(true).build())
                    .setSSLSocketFactory(sslConnectionSocketFactory)
                    .build();
            //必填，长度4位，取值为报文格式，8583、XML、FIXD
            httpPost.setHeader("MsgType", "XML");
            //必填，长度4位，取值为源系统标识，（商户可自行赋值，前两位商户拼音简称，后两位值为ZF，例：约好商户：YHZF；）
            httpPost.setHeader("SourceId", "BQZF");
            //必填，长度8位，取值为操作代码，取值为后台交易类型
            httpPost.setHeader("TrxCode", code);
            //长度3位，交易渠道,可填空
            httpPost.setHeader("TrxChnlID", "");
            //长度3位，交易来源， 可填空
            httpPost.setHeader("TrxSysID", "");
            //必填，长度2位，业务场景，填：00
            httpPost.setHeader("TrxBusiness", "00");
            //必填，长度1位，取值为操作代码分类标识 （填2：POSP）
            httpPost.setHeader("TrxClass", "2");

            httpResponse = httpClient.execute(httpPost);
            result = httpResponse.getEntity();
            if (null != result) {
                responseContent = EntityUtils.toString(result, "UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                EntityUtils.consume(result);
                if (httpResponse != null) {
                    httpResponse.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }

    public static String postXml(String url, String xmlString) throws IOException {
        String result = "";
        Protocol https = new Protocol("https", new HTTPSSecureProtocolSocketFactory(), 443);
        Protocol.registerProtocol("https", https);
        PostMethod post = new PostMethod(url);
        HttpClient client = new HttpClient();
        HttpClientParams clientParams = new HttpClientParams();
        client.setParams(clientParams);
        try {
            post.setRequestHeader("Content-Type", "application/xml; charset=utf-8");
            post.setRequestHeader("Content-Length", String.valueOf(xmlString.length()));
            RequestEntity re = new StringRequestEntity(xmlString);
            post.setRequestEntity(re);
            client.executeMethod(post);
            result = post.getResponseBodyAsString();
            Protocol.unregisterProtocol("https");
        } catch (HttpException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 发送非K-V形式参数的post请求
     *
     * @return String
     * @throws IOException
     * @throws ClientProtocolException
     * @Title: notKvPost
     * @author g.yang@i-vpoints.com
     * @date 2016年7月19日 上午11:38:54
     */
    public static String notKvPost(String url, String content) throws ClientProtocolException, IOException {
        return notKvPost(url, content, null);
    }

    /**
     * 发送非K-V形式参数的post请求
     *
     * @return String
     * @throws IOException
     * @throws ClientProtocolException
     * @Title: notKvPost
     * @author g.yang@i-vpoints.com
     * @date 2016年7月19日 上午11:38:54
     */
    public static String notKvPost(String url, String content, String contentType) throws ClientProtocolException, IOException {
        StringBuilder responseContent = new StringBuilder();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            StringEntity se = new StringEntity(content, "utf-8");
            if (!StringUtils.isBlank(contentType)) {
                se.setContentType(contentType);
            }
            httpPost.setEntity(se);
            response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            BufferedReader br = new BufferedReader(new InputStreamReader(httpEntity.getContent()));
            String line = br.readLine();
            while (null != line) {
                responseContent.append(line);
                line = br.readLine();
            }
        } finally {
            try {
                if (null != response)
                    response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null != httpClient)
                    httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent.toString();
    }
//    中国银行Http Post请求
    public static String bocPost(String url, String param) throws UnsupportedEncodingException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        HttpPost httpPost = new HttpPost(url);
        //设置参数
        StringEntity stringEntity = new StringEntity(param, "UTF-8");
        //设置xml传输格式
        stringEntity.setContentType("application/xml;charset=utf-8");
        httpPost.setEntity(stringEntity);

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        HttpEntity result = null;
        String responseContent = null;
        try {
            ConnectionKeepAliveStrategy keepAliveStrategy = new ConnectionKeepAliveStrategy() {
                @Override
                public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
                    //tomcat默认keep alive timeout为20s
                    return 20 * 1000;
                }
            };

            SSLContext sslcontext = SSLContexts.custom()
                    //忽略掉对服务器端证书的校验
                    //加载服务端提供的truststore(如果服务器提供truststore的话就不用忽略对服务器端证书的校验了)
                    .loadTrustMaterial(new File("C:\\Users\\js.ding\\Desktop\\中行测试\\最新B2B,B2C测试环境（T4）公钥.cer"))
                    .build();

            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(
                    sslcontext
            );

            //创建默认的httpclient实例
            httpClient = HttpClients.custom()
                    .setKeepAliveStrategy(keepAliveStrategy)
                    .setDefaultRequestConfig(RequestConfig.custom().setStaleConnectionCheckEnabled(true).build())
                    .setSSLSocketFactory(sslConnectionSocketFactory)
                    .build();
           /* //必填，长度4位，取值为报文格式，8583、XML、FIXD
            httpPost.setHeader("MsgType", "XML");
            //必填，长度4位，取值为源系统标识，（商户可自行赋值，前两位商户拼音简称，后两位值为ZF，例：约好商户：YHZF；）
            httpPost.setHeader("SourceId", "BQZF");
            //必填，长度8位，取值为操作代码，取值为后台交易类型
            httpPost.setHeader("TrxCode", code);
            //长度3位，交易渠道,可填空
            httpPost.setHeader("TrxChnlID", "");
            //长度3位，交易来源， 可填空
            httpPost.setHeader("TrxSysID", "");
            //必填，长度2位，业务场景，填：00
            httpPost.setHeader("TrxBusiness", "00");
            //必填，长度1位，取值为操作代码分类标识 （填2：POSP）
            httpPost.setHeader("TrxClass", "2");*/

            httpResponse = httpClient.execute(httpPost);
            result = httpResponse.getEntity();
            if (null != result) {
                responseContent = EntityUtils.toString(result, "UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                EntityUtils.consume(result);
                if (httpResponse != null) {
                    httpResponse.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }

}
