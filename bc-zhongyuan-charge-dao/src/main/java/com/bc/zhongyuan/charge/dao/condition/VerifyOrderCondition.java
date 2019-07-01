
package com.bc.zhongyuan.charge.dao.condition;

import com.bc.zhongyuan.charge.dao.abs.DaoCondition;

/**
 * <p>用于封装查询条件</p>
 * <p>默认条件下仅生成数据表字段的查询条件，更多条件，请自行添加</p>
 * @author Generator
 * @date 2019年07月01日 15时16分20秒
 */
public class VerifyOrderCondition implements DaoCondition{

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 订单编号
	 */
	private String orderNo;
	/**
	 * 伯乔流水号
	 */
	private String bcTradeNo;
	/**
	 * 商品价格
	 */
	private String price;
	/**
	 * 活动名称
	 */
	private String activityName;
	/**
	 * 活动编号
	 */
	private String activityNo;
	/**
	 * 商品名称
	 */
	private String productName;
	/**
	 * 客户名称
	 */
	private String customerName;
	/**
	 * 商品Id
	 */
	private String productNo;
	/**
	 * 创建时间
	 */
	private java.util.Date createTime;
	/**
	 * 更改时间
	 */
	private java.util.Date updateTime;
	/**
	 * 订单状态 0订单处理中 订单成功 1 订单失败
	 */
	private String orderStatus;
	/**
	 * 充值状态 1 直充成功
-1 直冲失败
0 直冲中
8 直冲提交成功
9 直冲响应中
7 未支付
	 */
	private String rechargeStatus;
	/**
	 * 充值状态描述
	 */
	private String rechargeStatusDesc;
	/**
	 * 核销状态 核销成功 1 核销失败-1 核销中 0
	 */
	private String verifyStatus;
	/**
	 * 核销描述
	 */
	private String verifyDesc;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 串码号3DES加密
	 */
	private String couponNo;
	
	/**
	 * 
	 */
	public Integer getId(){
		return id;
	}
	
	/**
	 * 
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
	/**
	 * 订单编号
	 */
	public String getOrderNo(){
		return orderNo;
	}
	
	/**
	 * 订单编号
	 */
	public void setOrderNo(String orderNo){
		this.orderNo = orderNo;
	}
	
	/**
	 * 伯乔流水号
	 */
	public String getBcTradeNo(){
		return bcTradeNo;
	}
	
	/**
	 * 伯乔流水号
	 */
	public void setBcTradeNo(String bcTradeNo){
		this.bcTradeNo = bcTradeNo;
	}
	
	/**
	 * 商品价格
	 */
	public String getPrice(){
		return price;
	}
	
	/**
	 * 商品价格
	 */
	public void setPrice(String price){
		this.price = price;
	}
	
	/**
	 * 活动名称
	 */
	public String getActivityName(){
		return activityName;
	}
	
	/**
	 * 活动名称
	 */
	public void setActivityName(String activityName){
		this.activityName = activityName;
	}
	
	/**
	 * 活动编号
	 */
	public String getActivityNo(){
		return activityNo;
	}
	
	/**
	 * 活动编号
	 */
	public void setActivityNo(String activityNo){
		this.activityNo = activityNo;
	}
	
	/**
	 * 商品名称
	 */
	public String getProductName(){
		return productName;
	}
	
	/**
	 * 商品名称
	 */
	public void setProductName(String productName){
		this.productName = productName;
	}
	
	/**
	 * 客户名称
	 */
	public String getCustomerName(){
		return customerName;
	}
	
	/**
	 * 客户名称
	 */
	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}
	
	/**
	 * 商品Id
	 */
	public String getProductNo(){
		return productNo;
	}
	
	/**
	 * 商品Id
	 */
	public void setProductNo(String productNo){
		this.productNo = productNo;
	}
	
	/**
	 * 创建时间
	 */
	public java.util.Date getCreateTime(){
		return createTime;
	}
	
	/**
	 * 创建时间
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	
	/**
	 * 更改时间
	 */
	public java.util.Date getUpdateTime(){
		return updateTime;
	}
	
	/**
	 * 更改时间
	 */
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
	
	/**
	 * 订单状态 0订单处理中 订单成功 1 订单失败
	 */
	public String getOrderStatus(){
		return orderStatus;
	}
	
	/**
	 * 订单状态 0订单处理中 订单成功 1 订单失败
	 */
	public void setOrderStatus(String orderStatus){
		this.orderStatus = orderStatus;
	}
	
	/**
	 * 充值状态 1 直充成功
-1 直冲失败
0 直冲中
8 直冲提交成功
9 直冲响应中
7 未支付
	 */
	public String getRechargeStatus(){
		return rechargeStatus;
	}
	
	/**
	 * 充值状态 1 直充成功
-1 直冲失败
0 直冲中
8 直冲提交成功
9 直冲响应中
7 未支付
	 */
	public void setRechargeStatus(String rechargeStatus){
		this.rechargeStatus = rechargeStatus;
	}
	
	/**
	 * 充值状态描述
	 */
	public String getRechargeStatusDesc(){
		return rechargeStatusDesc;
	}
	
	/**
	 * 充值状态描述
	 */
	public void setRechargeStatusDesc(String rechargeStatusDesc){
		this.rechargeStatusDesc = rechargeStatusDesc;
	}
	
	/**
	 * 核销状态 核销成功 1 核销失败-1 核销中 0
	 */
	public String getVerifyStatus(){
		return verifyStatus;
	}
	
	/**
	 * 核销状态 核销成功 1 核销失败-1 核销中 0
	 */
	public void setVerifyStatus(String verifyStatus){
		this.verifyStatus = verifyStatus;
	}
	
	/**
	 * 核销描述
	 */
	public String getVerifyDesc(){
		return verifyDesc;
	}
	
	/**
	 * 核销描述
	 */
	public void setVerifyDesc(String verifyDesc){
		this.verifyDesc = verifyDesc;
	}
	
	/**
	 * 手机号
	 */
	public String getPhone(){
		return phone;
	}
	
	/**
	 * 手机号
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	/**
	 * 串码号3DES加密
	 */
	public String getCouponNo(){
		return couponNo;
	}
	
	/**
	 * 串码号3DES加密
	 */
	public void setCouponNo(String couponNo){
		this.couponNo = couponNo;
	}

}