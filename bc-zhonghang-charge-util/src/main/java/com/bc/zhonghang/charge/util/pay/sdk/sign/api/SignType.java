package com.bc.zhonghang.charge.util.pay.sdk.sign.api;

import org.apache.commons.lang3.StringUtils;

public enum SignType {

	/**
	 * HMAC-MD5
	 */
	HMACMD5("HMACMD5"),

	/**
	 * RSA
	 */
	RSA("RSA");

	private String value;

	SignType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static final SignType forInstance(String signType) {
		SignType result = null;
		if(StringUtils.equalsIgnoreCase(RSA.getValue(), signType)) {
			result = RSA;
		} else if(StringUtils.equalsIgnoreCase(HMACMD5.getValue(), signType) || StringUtils.equalsIgnoreCase("HMAC-MD5", signType)) {
			result = HMACMD5;
		}
		return result;
	}

}
