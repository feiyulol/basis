package com.bc.zhongyuan.charge.util.constant;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * <p>
 * Redis 常量值，用于维护redis key集合
 * </p>
 * 
 * @ClassName: RedisConstant
 * @Description: Redis 常量值，用于维护redis key集合
 * @author g.yang@i-vpoints.com
 * @date 2018年9月5日 下午3:51:50
 */
public class RedisConstants {

	/**
	 * 渠道配置信息key
	 * 
	 * CONFIG:[饿了么appid] = { JSONObject.toJsonString(ElemeConfig) }
	 * 
	 * CONFIG:eleme_bc_cgb = { XXXXXXXXXXXX }
	 */
	private static final String BC_ELEME_CONFIG_KEY = "CONFIG:";
	/**
	 * 订单序列
	 * 
	 * ORDER:SEQ = 10000001
	 */
	private static final String BC_ELEME_ORDER_SEQ = "ORDER:SEQ";
	/**
	 * 伯乔订单详情，key为伯乔订单号，value为伯乔订单详情，用于存储所有的订单，其他所有的list或map，只存伯乔订单号的订单号，需要详情时，自己到当前map下去找详情
	 * 
	 * ORDER:BC:DETAIL = { 伯乔订单  = JSONObject.toJsonString(ElemeOrder) }
	 */
	private static final String BC_ELEME_ORDER_BC_DETAIL_MAP = "ORDER:BC:DETAIL";
	/**
	 * 新创建的订单 - 伯乔饿了么平台有，伯乔支付没有，银行没有
	 * 
	 * 饿了么订单号 - 伯乔饿了么平台订单号
	 * 
	 * ORDER:BC:ORDER:NEW = { [伯乔订单，伯乔订单，伯乔订单...] }
	 * 
	 * key值唯一，如果有继续支付动作，可以到继续支付的hash里找
	 */
	private static final String BC_ELEME_ORDER_NEW_LIST = "ORDER:BC:ORDER:NEW";
	/**
	 * 确认订单 - 伯乔饿了么平台有，伯乔支付也有，银行也有
	 * 
	 * 饿了么订单号 - 伯乔饿了么平台订单号
	 * 
	 * ORDER:BC:ORDER:CONFIRM = { 伯乔订单号  = 饿了么订单号 }
	 * 
	 * key值唯一，如果有继续支付动作，可以到支付历史里找
	 */
	private static final String BC_ELEME_ORDER_CONFIRM_MAP = "ORDER:BC:ORDER:CONFIRM";
	/**
	 * 终结的订单 - 订单状态不会再变更的订单
	 * 
	 * ORDER:BC:ORDER:FINISHED = { [伯乔订单，伯乔订单，伯乔订单...] }
	 * 
	 * key值唯一
	 */
	private static final String BC_ELEME_ORDER_FINISHED_LIST = "ORDER:BC:ORDER:FINISHED";
	/**
	 * 饿了么订单支付历史记录（只有finish的订单写入数据库后，再考虑删除该记录）
	 * 
	 * ORDER:BC:ORDER:PAY:HISTORY:[饿了么订单号]
	 * 
	 * ORDER:BC:ORDER:PAY:HISTORY:123456  = { [伯乔订单，伯乔订单，伯乔订单...] } 
	 * ORDER:BC:ORDER:PAY:HISTORY:456789  = { [伯乔订单，伯乔订单，伯乔订单...] } 
	 * ORDER:BC:ORDER:PAY:HISTORY:789123  = { [伯乔订单，伯乔订单，伯乔订单...] } 
	 */
	private static final String BC_ELEME_ORDER_PAY_HISTORY_LIST = "ORDER:BC:ORDER:PAY:HISTORY";
	/**
	 * 饿了么订单：饿了么订单号 - 伯乔饿了么平台订单号
	 * 
	 * ORDER:ELEME:ORDER = { 饿了么订单号  = 伯乔订单号 }
	 */
	private static final String BC_ELEME_ORDER_MAP = "ORDER:ELEME:ORDER";
	/**
	 * 某一日的订单集合
	 * 
	 * ORDER:LIST:DAY:[Date(yyyyMMdd)]
	 * 
	 * ORDER:LIST:DAY:20180907 = { [伯乔订单，伯乔订单，伯乔订单...] }
	 * ORDER:LIST:DAY:20180908 = { [伯乔订单，伯乔订单，伯乔订单...] }
	 * ORDER:LIST:DAY:20180909 = { [伯乔订单，伯乔订单，伯乔订单...] }
	 */
	private static final String DAY_OF_ORDER_LIST = "ORDER:LIST:DAY:";
	
	/**
	 * 存放订单号集合，用户实时同步存入数据库中
	 * 
	 * 方便用于快速持久化即问题排查
	 */
	private static final String ORDER_HISTORY_LIST = "ORDER:LIST:HISTORY";

	/**
	 * <p>获取redis存储数据key<p>
	 * @Title: getBcElemeConfigKey
	 * @Description: 获取redis存储数据key
	 * @param suffix key的后缀，eleme的appid
	 * @author g.yang@i-vpoints.com
	 * @date 2018年9月6日 下午1:45:54
	 * @return String key值
	 */
	public static String getBcElemeConfigKey(String suffix) {
		return BC_ELEME_CONFIG_KEY.concat(suffix);
	}

	/**
	 * <p>获取存放订单序列的key<p>
	 * @Title: getBcElemeOrderSeq
	 * @Description: 获取存放订单序列的key
	 * @author g.yang@i-vpoints.com
	 * @date 2018年9月6日 下午1:46:37
	 * @return String key值
	 */
	public static String getBcElemeOrderSeq() {
		return BC_ELEME_ORDER_SEQ;
	}
	
	/**
	 * <p>饿了么订单详情key<p>
	 * @Title: getBcElemeOrderMap
	 * @Description: 饿了么订单详情key
	 * @author g.yang@i-vpoints.com
	 * @date 2018年9月6日 下午3:00:04
	 * @return String 
	 */
	public static String getBcElemeOrderMap() {
		return BC_ELEME_ORDER_MAP;
	}
	
	/**
	 * <p>伯乔订单详情hash key<p>
	 * @Title: getBcElemeOrderBcDetailMap
	 * @Description: 伯乔订单详情hash key
	 * @author g.yang@i-vpoints.com
	 * @date 2018年9月6日 下午3:23:36
	 * @return String 
	 */
	public static String getBcElemeOrderBcDetailMap() {
		return BC_ELEME_ORDER_BC_DETAIL_MAP;
	}

	/**
	 * <p>获取当天的伯乔订单的list的key<p>
	 * @Title: getDayOfOrderList
	 * @Description: 获取当天的伯乔订单的list的key
	 * @author g.yang@i-vpoints.com
	 * @date 2018年9月6日 下午3:46:10
	 */
	public static String getDayOfOrderList() {
		return DAY_OF_ORDER_LIST.concat(DateFormatUtils.format(new Date(), "yyyyMMdd"));
	}
	
	/**
	 * <p>获取制定日期日的订单列表key<p>
	 * @Title: getDayOfOrderList
	 * @Description: 获取制定日期日的订单列表key
	 * @param targetDate 目标日期
	 * @author g.yang@i-vpoints.com
	 * @date 2018年9月6日 下午3:47:24
	 * @return String 
	 */
	public static String getDayOfOrderList(Date targetDate) {
		return DAY_OF_ORDER_LIST.concat(DateFormatUtils.format(targetDate, "yyyyMMdd"));
	}

	/**
	 * <p>订单历史支付记录的key<p>
	 * @Title: getBcElemeOrderPayHistoryList
	 * @Description: 订单历史支付记录的key
	 * @param elemeTransactionId 饿了么交易单号
	 * @author g.yang@i-vpoints.com
	 * @date 2018年9月6日 下午4:23:29
	 * @return String 
	 */
	public static String getBcElemeOrderPayHistoryList(String elemeTransactionId) {
		return BC_ELEME_ORDER_PAY_HISTORY_LIST.concat(elemeTransactionId);
	}

	/**
	 * <p>瞬时订单列表key，饿了么有，伯乔饿了么平台有，伯乔支付没有，数据库没有<p>
	 * @Title: getBcElemeOrderNewList
	 * @Description: 瞬时订单列表key
	 * @author g.yang@i-vpoints.com
	 * @date 2018年9月7日 下午3:01:35
	 * @return String 
	 */
	public static String getBcElemeOrderNewList() {
		return BC_ELEME_ORDER_NEW_LIST;
	}

	/**
	 * <p>游离对象列表key，饿了么有，伯乔饿了么平台有，伯乔支付有，数据库没有<p>
	 * @Title: getBcElemeOrderConfirmMap
	 * @Description: 游离对象列表key
	 * @author g.yang@i-vpoints.com
	 * @date 2018年9月7日 下午3:02:59
	 * @return String 
	 */
	public static String getBcElemeOrderConfirmMap() {
		return BC_ELEME_ORDER_CONFIRM_MAP;
	}

	/**
	 * <p>终结订单对象列表key，饿了么有，伯乔饿了么平台有，伯乔支付可能有，数据库有；随着时间的增长，该列表应该为空<p>
	 * @Title: getBcElemeOrderFinishedList
	 * @Description: 终结订单对象列表key
	 * @author g.yang@i-vpoints.com
	 * @date 2018年9月7日 下午3:03:50
	 * @return String 
	 */
	public static String getBcElemeOrderFinishedList() {
		return BC_ELEME_ORDER_FINISHED_LIST;
	}

	/**
	 * <p>用于存放订单号的集合，用于快速持久化数据使用<p>
	 * @Title: getOrderHistoryList
	 * @Description: 用于存放订单号的集合，用于快速持久化数据使用
	 * @author g.yang@i-vpoints.com
	 * @date 2018年10月10日 上午9:47:22
	 * @return String 
	 */
	public static String getOrderHistoryList() {
		return ORDER_HISTORY_LIST;
	}

}
