package com.bc.zhongyuan.charge.util.constant;

/**
 * <p>系统常量</p>
 * @ClassName: SystemConstants
 * @Description: 系统常量
 * @author g.yang@i-vpoints.com
 * @date 2018年8月22日 下午5:56:42
 */
public class SystemConstants {
	
	/**
	 * 字符集
	 */
	public static final String SYSTEM_CHARSET_UTF8 = "UTF-8";
	/**
	 * 数据库数据是否被删除：0，未被删除
	 */
	public static final int DB_DATA_IS_DELETE_FALSE = 0;
	/**
	 * 数据库数据是否被删除：1，已被删除
	 */
	public static final int DB_DATA_IS_DELETE_TRUE = 1;
	/**
	 * 排序字段默认值
	 */
	public static final int DB_ORDER_BY_DEFAULT_VALUE = 0;
	/**
	 * 系统默认操作记录人名称
	 */
	public static final String SYSTEM_DEFAULT_OPERATOR_NAME = "SYSTEM";
	/**
	 * 1: 饿了么响应成功
	 */
	public static final String ELEME_RESPONSE_SUCCESS_CODE = "1";
	/**
	 * 1: 饿了么响应失败（响应失败，饿了么会重试）
	 */
	public static final String ELEME_RESPONSE_FAILED_CODE = "2";
	
}
