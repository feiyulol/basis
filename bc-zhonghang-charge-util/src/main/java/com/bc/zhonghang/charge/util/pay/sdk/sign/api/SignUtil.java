package com.bc.zhonghang.charge.util.pay.sdk.sign.api;


import com.bc.zhonghang.charge.util.pay.sdk.sign.api.util.HMAC;
import com.bc.zhonghang.charge.util.pay.sdk.sign.api.util.RSASignature;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

public final class SignUtil {
	
	private static Logger log = LoggerFactory.getLogger(RechargeSignUtil.class);
	
	/**
	 * <p>计算签名<p>
	 * @Title: doSign
	 * @Description: 计算签名
	 * @param signable 可签名对象
	 * @param signKey 签名密钥
	 * @author g.yang@i-vpoints.com
	 * @date 2018年5月2日 下午1:29:30
	 * @return String 签名结果
	 */
	public static String doSign(Map<String, String> signMap, SignType signType, String key) {
		String result = "";
		if(SignType.RSA == signType) {
			result = doRsaSign(signMap, key);
		} else if(SignType.HMACMD5 == signType) {
			result = doHmacMd5Sign(signMap, key);
		} 
		return result;
	}
	
	/**
	 * <p>签名验证<p>
	 * @Title: checkSign
	 * @Description: 签名验证
	 * @param signMap 签名参数源数据
	 * @param signType 签名类型
	 * @param sign 期待结果
	 * @author g.yang@i-vpoints.com
	 * @date 2018年5月2日 下午2:49:22
	 * @return boolean 验签结果
	 */
	public static boolean checkSign(Map<String, String> signMap, SignType signType, String key, String sign) {
		boolean result = false;
		if(SignType.RSA == signType) {
			result = doRsaCheck(signMap, key, sign);
		} else if(SignType.HMACMD5 == signType) {
			result = doHmacMd5Check(signMap, key, sign);
		} 
		return result;
	}

	/**
	 * <p>RSA 签名计算<p>
	 * @Title: doRsaSign
	 * @Description: RSA 签名计算
	 * @param signMap 签名数据源
	 * @param privateKey 加密密钥
	 * @author g.yang@i-vpoints.com
	 * @date 2018年5月2日 下午1:30:37
	 * @return String 签名结果
	 */
	private static String doRsaSign(Map<String, String> signMap, String privateKey) {
		String signSrcStr = signSrcEncodeStr(signMap);
		log.debug("[doRsaSign] signSrcStr：".concat(signSrcStr));
		String signSrcStrMd5 = DigestUtils.md5Hex(signSrcStr);
		log.debug("[doRsaSign] signSrcStrMd5：".concat(signSrcStrMd5));
		String rsaSignResult = RSASignature.sign(signSrcStrMd5, privateKey, "utf-8");
		return rsaSignResult;
	}

	/**
	 * <p>RSA签名验证<p>
	 * @Title: doRsaCheck
	 * @Description: RSA签名验证
	 * @param signMap 签名源数据信息
	 * @param publicKey 解密公钥
	 * @param sign 期望结果
	 * @author g.yang@i-vpoints.com
	 * @date 2018年5月2日 下午2:50:13
	 * @return boolean 验签结果
	 */
	private static boolean doRsaCheck(Map<String, String> signMap, String publicKey, String sign) {
		String signSrcStr = signSrcEncodeStr(signMap);
		log.debug("[doRsaCheck] signSrcStr：".concat(signSrcStr));
		String signSrcStrMd5 = DigestUtils.md5Hex(signSrcStr);
		log.debug("[doRsaCheck] signSrcStrMd5：".concat(signSrcStrMd5));
		boolean checkSignResult = RSASignature.doCheck(signSrcStrMd5, sign, publicKey);
		return checkSignResult;
	}
	
	/**
	 * <p>HMAC-MD5 签名计算<p>
	 * @Title: doHmacMd5Sign
	 * @Description: HMAC-MD5 签名计算
	 * @param signMap 签名数据源
	 * @param key 密钥
	 * @author g.yang@i-vpoints.com
	 * @date 2018年5月2日 下午1:32:02
	 * @return String 
	 */
	private static String doHmacMd5Sign(Map<String, String> signMap, String key) {
		String signResult = "";
		String signSrcStr = signSrcEncodeStr(signMap);
		try {
			signResult = HMAC.getHmacMD5String(signSrcStr, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return signResult;
	}
	
	/**
	 * <p>HMAC-MD5签名验证<p>
	 * @Title: doHmacMd5Check
	 * @Description: HMAC-MD5签名验证
	 * @param signMap 验签源数据
	 * @param key 加密密钥
	 * @param sign 期望结果
	 * @author g.yang@i-vpoints.com
	 * @date 2018年5月2日 下午2:51:42
	 * @return boolean 验签结果
	 */
	private static boolean doHmacMd5Check(Map<String, String> signMap, String key, String sign) {
		String signResult = doHmacMd5Sign(signMap, key);
		return StringUtils.equalsIgnoreCase(signResult, sign);
	}
	
	/**
	 * <p>签名源字符串<p>
	 * @Title: signSrcStr
	 * @Description: 签名源字符串
	 * @param signMap 签名数据源
	 * @author g.yang@i-vpoints.com
	 * @date 2018年5月2日 下午1:34:18
	 * @return String 签名源数据结果
	 */
	private static String signSrcStr(Map<String, String> signMap) {
		StringBuilder sb = new StringBuilder();
		Map<String, String> treeMap = new TreeMap<String, String>(signMap);
		for(Map.Entry<String, String> entry:treeMap.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			if(StringUtils.isNotBlank(value)) {
				sb.append(key).append("=").append(value).append("&");
			}
		}
		if(sb.length() > 1) {
			sb.delete(sb.length()-1, sb.length()).toString();
		}
		return sb.toString();
	}
	
	private static String signSrcEncodeStr(Map<String, String> signMap) {
		String signSrcStr = signSrcStr(signMap);
		String signSrcEncodeStr = "";
		try {
			signSrcEncodeStr = URLEncoder.encode(signSrcStr, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return signSrcEncodeStr;
	}
	
}
