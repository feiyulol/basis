package com.bc.zhonghang.charge.util.exception;

/**
 * 
* @Title: IllegalParamException 
* @Package com.bc.demo.util.exception 
* @Description: 非法参数异常
* @author cy.wang@i-vpoints.com
* @date 2017年10月26日 上午10:43:37
* @version V1.0 
*
 */
public class IllegalParamException extends RuntimeException {
	
	private static final long serialVersionUID = 6659275682706729478L;
	
	public IllegalParamException(String msg) {
		super("illegal param: " + msg);
	}
}
