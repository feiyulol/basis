package com.bc.zhonghang.charge.util.exception;

/**
 * 
* @Title: ParamAbsentException 
* @Package com.bc.demo.util.exception 
* @Description: 自定义异常(参数缺失异常) 
* @author cy.wang@i-vpoints.com
* @date 2017年10月26日 上午10:44:06
* @version V1.0 
*
 */
public class ParamAbsentException extends RuntimeException{

	private static final long serialVersionUID = 7177686802412227432L;

	public ParamAbsentException(String msg){
		super(msg);
	}
}
