package com.bc.zhonghang.charge.util.enums;

/**
 * @ClassName: ApiCallResult.java
 * @author: f.hu@i-vpoints.com
 * @date: 2018-03-28 11:42
 * @Description:
 */
public enum ApiCallResult {

    SUCCESS("000", "操作成功"),
    EMPTY("001", "参数缺失"),
    DBERROR("002", "持久化异常"),
    SIGNERROR("004", "签名错误"),
    NOT_FOUND("007", "未找到对应数据"),
    ORDERERROR("009", "订单状态不正确"),
    CODE_NOT_WRITE_OFF("011", "券码不可核销"),
    INFO_NOT_EXIT("012", "信息不存在"),
    ORDERTIMEOUT("105", "订单超时"),
    ORDER_ALREADY_EXIT("103", "订单已存在"),
    ORDER_NOT_EXIT("104", "订单不存在"),
    PARAMS_ERROR("600", "参数异常"),
    USER_QUOTA("991", "本月你已参加过此活动,原价购买!"),
    ACTIVITY_END("992", "名额已耗尽，活动结束"),
    NOT_COMPLETE_ORDER("993", "有未完成的订单,请先支付或取消"),
    SMS_SENDAGAIN("994", "短信发送过快，请稍后再试"),
    NORIGHT("995", "没有权限"),
    VERIFICATIONCODE_EORR("996", "验证码失效或错误"),
    SMS_SENDERR("997", "短信发送失败"),
    FAILURE("999", "操作失败"),
    ;


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
