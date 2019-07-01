package com.bc.zhongyuan.charge.util.constant;

import org.apache.commons.lang3.time.DateUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class CgbDayActivityConstants {

	private int normalMaxCount;
	private int vipMaxCount;
	private String activityStartTime;
	private String activityEndTime;
	private int vipPayAmount;
	private int vipReduceAmount;
	private int normalPayAmount;
	private int normalReduceAmount;
	private int orderQueryTimeoutMillis;
	private BigDecimal cgbDayElemeRate;
	private BigDecimal cgbNormalElemeRate;
	private BigDecimal cgbDayCommission;
	private BigDecimal cgbRate;	//广发手续费
	private BigDecimal cgbTaxRate;
	
	public int getNormalMaxCount() {
		return normalMaxCount;
	}

	public void setNormalMaxCount(int normalMaxCount) {
		this.normalMaxCount = normalMaxCount;
	}

	public int getVipMaxCount() {
		return vipMaxCount;
	}

	public void setVipMaxCount(int vipMaxCount) {
		this.vipMaxCount = vipMaxCount;
	}

	public Date getActivityStartTime() {
		Date date = null;
		try {
			date = DateUtils.parseDate(this.activityStartTime, "yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public void setActivityStartTime(String activityStartTime) {
		this.activityStartTime = activityStartTime;
	}

	public Date getActivityEndTime() {
		Date date = null;
		try {
			date = DateUtils.parseDate(this.activityEndTime, "yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public void setActivityEndTime(String activityEndTime) {
		this.activityEndTime = activityEndTime;
	}

	public int getVipPayAmount() {
		return vipPayAmount;
	}

	public void setVipPayAmount(int vipPayAmount) {
		this.vipPayAmount = vipPayAmount;
	}

	public int getNormalPayAmount() {
		return normalPayAmount;
	}

	public void setNormalPayAmount(int normalPayAmount) {
		this.normalPayAmount = normalPayAmount;
	}

	public int getVipReduceAmount() {
		return vipReduceAmount;
	}

	public void setVipReduceAmount(int vipReduceAmount) {
		this.vipReduceAmount = vipReduceAmount;
	}

	public int getNormalReduceAmount() {
		return normalReduceAmount;
	}

	public void setNormalReduceAmount(int normalReduceAmount) {
		this.normalReduceAmount = normalReduceAmount;
	}

	public int getOrderQueryTimeoutMillis() {
		return orderQueryTimeoutMillis;
	}

	public void setOrderQueryTimeoutMillis(int orderQueryTimeoutMillis) {
		this.orderQueryTimeoutMillis = orderQueryTimeoutMillis;
	}

	public BigDecimal getCgbDayElemeRate() {
		return cgbDayElemeRate;
	}

	public void setCgbDayElemeRate(BigDecimal cgbDayElemeRate) {
		this.cgbDayElemeRate = cgbDayElemeRate;
	}

	public BigDecimal getCgbNormalElemeRate() {
		return cgbNormalElemeRate;
	}

	public void setCgbNormalElemeRate(BigDecimal cgbNormalElemeRate) {
		this.cgbNormalElemeRate = cgbNormalElemeRate;
	}

	/**
	 * <p>获取饿了么手续费率<p>
	 * @Title: getElemeRate
	 * @Description: 获取饿了么手续费率
	 * @param formatDate 所属日期，yyyyMMdd
	 * @author g.yang@i-vpoints.com
	 * @date 2018年10月24日 下午1:32:42
	 * @return BigDecimal 费率
	 */
	public BigDecimal getElemeRate(String formatDate) {
		BigDecimal elemeRate = null;
		try {
			Date targetDate = DateUtils.parseDate(formatDate, "yyyyMMdd");
			Calendar target = Calendar.getInstance();	// 目标日期
			target.setTime(targetDate);
			//判断目标日期是否为周五，如果是周五，则使用广发日的费率
			if(Calendar.FRIDAY == target.get(Calendar.DAY_OF_WEEK)) {
				elemeRate = getCgbDayElemeRate();
			} else {
				elemeRate = getCgbNormalElemeRate();
			}
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return elemeRate;
	}

	public BigDecimal getCgbDayCommission() {
		return cgbDayCommission;
	}

	public void setCgbDayCommission(BigDecimal cgbDayCommission) {
		this.cgbDayCommission = cgbDayCommission;
	}

	public BigDecimal getCgbRate() {
		return cgbRate;
	}

	public void setCgbRate(BigDecimal cgbRate) {
		this.cgbRate = cgbRate;
	}

	public BigDecimal getCgbTaxRate() {
		return cgbTaxRate;
	}

	public void setCgbTaxRate(BigDecimal cgbTaxRate) {
		this.cgbTaxRate = cgbTaxRate;
	}

}
