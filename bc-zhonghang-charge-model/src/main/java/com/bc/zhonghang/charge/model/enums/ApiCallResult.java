package com.bc.zhonghang.charge.model.enums;

/**
 * 
* @Title: ApiCallResult 
* @Package com.bc.jiangbei.portal.util.enums 
* @Description: 返回码枚举
* @author cy.wang@i-vpoints.com
* @date 2018年5月3日 下午4:08:18
* @version V1.0 
*
 */
public enum ApiCallResult {
	SUCCESS("000", "操作成功"),
	EMPTY("001", "参数缺失"),
	DBERROR("002", "持久化异常"),
	UNSUPPORTED("003", "格式不支持"),
	SIGNERROR("004", "签名错误"),
	OUTRANGE("005", "文件过大"),
	ILLEGAL_ARGUMENT("006","参数异常"),
	CANNOT_FIND_DATA("007","未找到对应数据"),
	REPEAT_OPERATION("008","重复操作"),
	CACHE_FAILURE("009","缓存异常"),
	ALREADY_EXISTS("011","对象已存在"),
	OVERLAPPING_TIME("012","时间重叠"),
	CANNOT_FIND_SERVICE("013","未找到对应服务"),
	PARAMETERS_CONTAIN_SENSITIVE_WORDS("014","参数包含敏感词汇"),
	VERIFICATION_CODE_ERROR("016","短信验证码错误"),
	INVALID_INFO("016","无效信息"),
	DATA_ERROR("052","数据异常"),
	STOCK_SHORTAGE("055","库存不足"),
	FREQUEN_OPERATION("101","频繁操作"),
	NOT_ALLOWED_OPERATION("102","不允许的操作"),
	PAYMENT_METHOD_DOES_NOT_SUPPORT("103","不支持的支付方式"),
	GROUP_ALREADY_FULL("104","拼团已满"),
	LIMIT_EXCEEDED("105","超出限制"),
	ALREADY_BIND("106","已经绑定"),
	FILE_SAVE_ERROR("301","文件保存时出现错误"),
	UNAUTHORIZED("401","未经授权"),
	VALIDATION_FAILED("402","验证失败"),
	ACCOUNT_LOCKOUT("403","账户锁定"),
	IDENTITY_OVERDUE("991","TOKEN失效"),
	SIGNED_IN_ON_ANOTHER_DEVICE("992","已在其他设备登录"),
	NORIGHT("995", "没有权限"),
	PHANTOM("996", "数据幻读"),
	DEFECT("997", "缺失票据"),
	OVERDUE("998", "票据过期"),
	FAILURE("999", "操作失败"),
	BLEND_PAY_EXCEPTION("501","混合支付金额必须大于20元人民币"),
	EXCEPTION("1001","系统异常");

	private String code;
	private String desc;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private ApiCallResult(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

}
