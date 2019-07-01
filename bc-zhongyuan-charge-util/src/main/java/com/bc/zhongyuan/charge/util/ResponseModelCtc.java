package com.bc.zhongyuan.charge.util;

import com.bc.zhongyuan.charge.util.enums.CtcCallResult;

/**
 * @author js.ding
 * @Title: ResponseModelCtc
 * @ProjectName bc-ctc-platform
 * @Description: TODO
 * @date 2019/4/1015:55
 */
public class ResponseModelCtc {
    private String resultCode;

    private String reusltMsg;

    private Object data;

    public String getResultCode() {
        return resultCode;
    }

    public ResponseModelCtc setResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public String getReusltMsg() {
        return reusltMsg;
    }

    public ResponseModelCtc setReusltMsg(String reusltMsg) {
        this.reusltMsg = reusltMsg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseModelCtc setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "ResponseModelCtc{" +
                "resultCode='" + resultCode + '\'' +
                ", reusltMsg='" + reusltMsg + '\'' +
                ", data=" + data +
                '}';
    }

    public ResponseModelCtc() {
    }

    public ResponseModelCtc(Object data) {
        this.data = data;
    }
    public ResponseModelCtc warpSuccess() {
        return this.setResultCode(CtcCallResult.SUCCESS.getResultCode()).setReusltMsg(
                CtcCallResult.SUCCESS.getReusltMsg());
    }
}
