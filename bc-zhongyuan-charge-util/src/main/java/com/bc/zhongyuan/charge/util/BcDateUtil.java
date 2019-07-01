package com.bc.zhongyuan.charge.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

public class BcDateUtil {
	
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String dateTime(){
		return date14(new Date());
	}

	public static final String currentTime(){
		return dateTime(new Date());
	}
	
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String dateTime(Date date){
		return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * yyMMdd
	 */
	public static final String date6(){
		return date6(new Date());
	}
	
	/**
	 * yyMMdd
	 */
	public static final String date6(Date date){
		return DateFormatUtils.format(date, "yyMMdd");
	}
	
	/**
	 * MMdd
	 */
	public static final String monthDay(){
		return DateFormatUtils.format(new Date(), "MMdd");
	}
	
	/**
	 * yyyyMMddHHmmss
	 */
	public static final String date14(Date date){
		return DateFormatUtils.format(date, "yyyyMMddHHmmss");
	}
}
