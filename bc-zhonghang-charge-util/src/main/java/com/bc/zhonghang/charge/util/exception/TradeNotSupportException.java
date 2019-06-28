package com.bc.zhonghang.charge.util.exception;

/**
 * @ClassName: TradeNotSupportException.java
 * @author: f.hu@i-vpoints.com
 * @date: 2018-07-17 16:33
 * @Description:
 */
public class TradeNotSupportException extends RuntimeException {

    public TradeNotSupportException() {
        super();
    }

    public TradeNotSupportException(String msg) {
        super(msg);
    }
}
