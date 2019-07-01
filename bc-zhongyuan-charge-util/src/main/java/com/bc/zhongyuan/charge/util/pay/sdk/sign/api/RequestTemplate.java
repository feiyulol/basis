package com.bc.zhongyuan.charge.util.pay.sdk.sign.api;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class RequestTemplate {
	
	private Map<String, String> me = new HashMap<String, String>();

	/**
	 * 请求订单号 长度20-50
	 */
	public String getOrderNo() {
		return me.get("orderNo");
	}

	/**
	 * 请求订单号 长度20-50
	 */
	public void setOrderNo(String orderNo) {
		me.put("orderNo", orderNo);
	}

	/**
	 * 交易金额 单位元
	 */
	public String getAmount() {
		return me.get("amount");
	}

	/**
	 * 交易金额 单位元
	 */
	public void setAmount(BigDecimal amount) {
		me.put("amount", amount == null ? null : amount.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
	}

	/**
	 * 订单主题 长度32
	 */
	public String getOrderSubject() {
		return me.get("orderSubject");
	}

	/**
	 * 订单主题 长度32
	 */
	public void setOrderSubject(String orderSubject) {
		me.put("orderSubject", orderSubject);
	}

	/**
	 * 订单描述 长度100
	 */
	public String getOrderDescription() {
		return me.get("orderDescription");
	}

	/**
	 * 订单描述 长度100
	 */
	public void setOrderDescription(String orderDescription) {
		me.put("orderDescription", orderDescription);
	}

	/**
	 * 应用id 长度50
	 */
	public String getAppId() {
		return me.get("appId");
	}

	/**
	 * 应用id 长度50
	 */
	public void setAppId(String appId) {
		me.put("appId", appId);
	}

	/**
	 * 签名类型 ：HMAC-MD5，RSA
	 */
	public String getSignType() {
		return me.get("signType");
	}

	/**
	 * 签名类型 ：HMAC-MD5，RSA
	 */
	public void setSignType(SignType signType) {
		me.put("signType", signType.getValue());
	}

	/**
	 * 签名结果
	 */
	public String getSignResult() {
		return me.get("signResult");
	}

	/**
	 * 签名结果
	 */
	public void setSignResult(String signResult) {
		me.put("signResult", signResult);
	}

	/**
	 * 回显地址 长度200
	 */
	public String getRedirectUrl() {
		return me.get("redirectUrl");
	}

	/**
	 * 回显地址 长度200
	 */
	public void setRedirectUrl(String redirectUrl) {
		me.put("redirectUrl", redirectUrl);
	}
	
	/**
	 * 失败前端跳转url
	 */
	public String getFailedBackRedirectUrl() {
		return me.get("failedBackRedirectUrl");
	}
	
	/**
	 * 失败前端跳转url
	 */
	public void setFailedBackRedirectUrl(String failedBackRedirectUrl) {
		me.put("failedBackRedirectUrl", failedBackRedirectUrl);
	}

	/**
	 * 回调通知地址 长度200
	 */
	public String getNotifyUrl() {
		return me.get("notifyUrl");
	}

	/**
	 * 回调通知地址 长度200
	 */
	public void setNotifyUrl(String notifyUrl) {
		me.put("notifyUrl", notifyUrl);
	}

	/**
	 * 回传字段 长度500
	 */
	public String getFieldBack() {
		return me.get("fieldBack");
	}

	/**
	 * 回传字段 长度500
	 */
	public void setFieldBack(String fieldBack) {
		me.put("fieldBack", fieldBack);
	}

	/**
	 * 支付编码 长度100
	 */
	public String getTradeMethodCode() {
		return me.get("tradeMethodCode");
	}

	/**
	 * 支付编码 长度100
	 */
	public void setTradeMethodCode(String tradeMethodCode) {
		me.put("tradeMethodCode", tradeMethodCode);
	}

	/**
	 * 设备类型
	 */
	public String getDeviceType() {
		return me.get("deviceType");
	}

	/**
	 * 设备类型
	 */
	public void setDeviceType(String deviceType) {
		me.put("deviceType", deviceType);
	}

	/**
	 * 联系方式 长度100
	 */
	public String getContact() {
		return me.get("contact");
	}

	/**
	 * 联系方式 长度100
	 */
	public void setContact(String contact) {
		me.put("contact", contact);
	}

	/**
	 * 支付号码 长度100
	 */
	public String getPayId() {
		return me.get("payId");
	}

	/**
	 * 支付号码 长度100
	 */
	public void setPayId(String payId) {
		me.put("payId", payId);
	}
	
	public String getTradeSerialNo() {
		return me.get("tradeSerialNo");
	}
	
	/**
	 * 伯乔交易流水号，客户端不传
	 */
	public void setTradeSerialNo(String tradeSerialNo) {
		me.put("tradeSerialNo", tradeSerialNo);
	}

	/**
	 * 请求参数
	 */
	public Map<String, String> params(){
		Map<String, String> map = new HashMap<String, String>(me);
		map.remove("signResult");
		return map;
	}
	
	/**
	 * 订单创建时间，客户端不传
	 */
	public void setCreateTime(String createTime) {
		me.put("createTime", createTime);
	}
	
	/**
	 * 订单创建时间，客户端不传
	 */
	public String getCreateTime() {
		return me.get("createTime");
	}
	
	/**
	 * 订单支付时间，客户端不传
	 */
	public void setPaymentTime(String paymentTime) {
		me.put("paymentTime", paymentTime);
	}
	
	/**
	 * 订单支付时间，客户端不传
	 */
	public String getPaymentTime() {
		return me.get("paymentTime");
	}
	
	/**
	 * 订单退款时间，客户端不传
	 */
	public void setRefundTime(String refundTime) {
		me.put("refundTime", refundTime);
	}
	
	/**
	 * 订单退款时间，客户端不传
	 */
	public String getRefundTime() {
		return me.get("refundTime");
	}
	
	/**
	 * 订单状态
	 */
	public String getOrderStatus() {
		return me.get("orderStatus");
	}
	
	/**
	 * 订单状态
	 */
	public void setOrderStatus(String orderStatus) {
		me.put("orderStatus", orderStatus);
	}
	
	/**
	 * 订单状态描述
	 */
	public String getOrderStatusDesc() {
		return me.get("orderStatusDesc");
	}
	
	/**
	 * 订单状态描述
	 */
	public void setOrderStatusDesc(String orderStatusDesc) {
		me.put("orderStatusDesc", orderStatusDesc);
	}
	
	/**
	 * 设置扩展业务字段
	 */
	public void setExtBizContent(String extBizContent) {
		me.put("extBizContent", extBizContent);
	}
	
	/**
	 * 获取业务扩展字段
	 */
	public String getExtBizContent() {
		return me.get("extBizContent");
	}

	/**
	 * 当前用户openId
	 */
	public void setOpenId(String openId) {
		me.put("openId", openId);
	}
	
	/**
	 * 当前用户openId
	 */
	public String getOpenId() {
		return me.get("openId");
	}
	
	public String doSign(String signKey) {
		String signResult = RechargeSignUtil.doSign(params(), SignType.valueOf(getSignType()), signKey);
		return signResult;
	}
	
	/**
	 * <p>获取form表单<p>
	 * @Title: getForm
	 * @Description: 获取form表单
	 * @param apiAddress 接口地址
	 * @param signKey 签名密钥
	 * @author g.yang@i-vpoints.com
	 * @date 2018年5月3日 下午4:01:10
	 * @return String form表单
	 */
	public String getForm(String apiAddress, String signKey) {
		Map<String, String> map = params();
		map.put("signResult", doSign(signKey));
		StringBuilder form = new StringBuilder();
		form.append(String.format("<form action='%s' method='post'>", apiAddress));
		for(Map.Entry<String, String> entry:map.entrySet()) {
			form.append(String.format("<input type='hidden' name='%s' value='%s' />", entry.getKey(), entry.getValue()));
		}
		form.append("</form>");
		form.append("<script>document.forms[0].submit();</script>");
		return form.toString();
	}

	@Override
	public String toString() {
		return "RequestTemplate [me=" + me + "]";
	}

}
