package com.bc.zhongyuan.charge.util.pay.sdk.sign.api.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * <<HMAC 各类加密实现类。>>
 * Version     : 1.0
 * Created By  : vigo
 * Created Date: 2017年8月1日 上午11:14:18
 */
public class HMAC {

	/**
	 * @param secretKey
	 * 
	 * @param src
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @throws InvalidKeyException
	 */
	public static byte[] getHmacSHA256(String src, String secretKey) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
		Mac mac = Mac.getInstance("HMacSha256");
		SecretKeySpec secret = new SecretKeySpec(secretKey.getBytes("UTF-8"), mac.getAlgorithm());
		mac.init(secret);
		return mac.doFinal(src.getBytes());
	}

	/**
	 * @param secretKey
	 * @param src
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @throws InvalidKeyException
	 */
	public static byte[] getHmacSHA1(String src, String secretKey) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
		Mac mac = Mac.getInstance("HMacSha1");
		SecretKeySpec secret = new SecretKeySpec(secretKey.getBytes("UTF-8"), mac.getAlgorithm());
		mac.init(secret);
		return mac.doFinal(src.getBytes());
	}

	/**
	 * @param secretKey
	 * @param src
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @throws InvalidKeyException
	 */
	public static byte[] getHmacMD5(String src, String secretKey) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
		Mac mac = Mac.getInstance("HmacMD5");
		SecretKeySpec secret = new SecretKeySpec(secretKey.getBytes("UTF-8"), mac.getAlgorithm());
		mac.init(secret);
		return mac.doFinal(src.getBytes());
	}
	
	/**
	 * <p>Hmac md5 字符串输出<p>
	 * @Title: getHmacMD5String
	 * @Description: Hmac md5 字符串输出
	 * @param src 只要数据源
	 * @param secretKey 摘要密钥
	 * @author g.yang@i-vpoints.com
	 * @date 2017年11月29日 下午7:18:49
	 * @return String 
	 */
	public static String getHmacMD5String(String src, String secretKey) throws NoSuchAlgorithmException, UnsupportedEncodingException,InvalidKeyException {
		return HexUtils.encodeHexStr(getHmacMD5(src, secretKey),false);
	}

}
