package com.bc.zhongyuan.charge.util;

/**
 *
 * @Title: RedisKeys
 * @Package com.bc.jiangbei.portal.util
 * @Description: RedisKey
 * @author cy.wang@i-vpoints.com
 * @date 2018年4月23日 下午7:28:52
 * @version V1.0
 *
 */
public class RedisKeys {

	/** 一天 (秒) */
	public static final long ONE_DAY = 86400;

	/** 10天 */
	public static final long TEN_DAY = 864000;

	/** 半小时 (秒) */
	public static final long HALF_HOUR = 1800;

	/** 一小时 (秒) */
	public static final long ONE_HOUR = 3600;

	/** 三分钟 (秒) */
	public static final long THREE_MINUTES = 180;

	/**
	 * 权益数量 redis key
	 */
	public static final String BOC_MOBIKE_PLATFORM_COUNT = "BOC:MOBIKE:PLATFORM:COUNT";

	/**
	 * 已享受权益用户表
	 */
	public static final String BOC_MOBIKE_PLATFORM_ACCOUNT = "BOC:MOBIKE:PLATFORM:ACCOUNT";

	/**
	 * 用户短信
	 */
	public static final String BOC_MOBIKE_PLATFORM_PHONE = "BOC:MOBIKE:PLATFORM:PHONE";

}
