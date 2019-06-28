package com.bc.zhonghang.charge.util.enums;

/**
 * @author js.ding
 * @Title: CtcCallResult
 * @ProjectName bc-ctc-platform
 * @Description: TODO
 * @date 2019/4/1016:06
 */
public enum CtcCallResult {

    DBERROR("002", "持久化异常"),
    UNSUPPORTED("003", "格式不支持"),
    NORIGHT("995", "没有权限"),
    FAILURE("999", "操作失败"),
    EXCEPTION("1001","系统异常"),
    ORDER_AKREAD_TEXUSTS("103","订单已存在"),
    ORDER_DOES_NOT_EXIST("104", "订单不存在"),
    MISSING_PARAMETER("001","参数缺失"),
    //正常处理完成
    SUCCESS("000000", "RETURN_CODE_SUCCESS"),

    //参数错误
    EMPTY("100001", "RETURN_CODE_PARAMS_INVALID"),
    //签名错误
    SIGNERROR("100004", "签名错误"),

    //APP不存在
    APPNOTEXIST("100003", "RETURN_CODE_APP_NOT_EXIST"),

    //TRANSCODE已经存在（请求发码）
    TRANSCODE_ALREADY_EXIST("200001", "RETURN_CODE_TRANSCODE_ALREADY_EXIST"),

    //TRANSCODE不存在（请求重发）
    TRANSCODE_NOT_EXIST("200002", "RETURN_CODE_TRANSCODE_NOT_EXIST"),

    //活动卷类型不存在
    COUPON_NOT_EXIST("200005", "RETURN_CODE_COUPON_NOT_EXIST"),

    //券码已用完
    COUPON_CODE_HAS_USE_UP("200006", "RETURN_CODE_COUPON_CODE_HAS_USE_UP"),

    //代金券已下架
    COUPON_STATUS_INVALID("200007", "RETURN_CODE_COUPON_STATUS_INVALID"),

    //代金券还未上线
    COUPON_NOT_ONLINE("200008", "RETURN_CODE_COUPON_NOT_ONLINE"),

    //代金券已下线
    COUPON_ALREAY_OFFLINE("200009", "RETURN_CODE_COUPON_ALREAY_OFFLINE"),

    //码券号状态不支持该操作
    CODE_STATUS_ERROR("200010", "RETURN_CODE_COUPON_CODE_STATUS_ERROR"),

    //码券号不存在
    COUPON_CODE_NOT_EXIST("200011", "RETURN_CODE_COUPON_CODE_NOT_EXIST"),

    //码券号不属于原用户（码券转赠）
    NOT_BELONG_TO_ORGUSER("200012", "RETURN_CODE_COUPON_CODE_NOT_BELONG_TO_ORGUSER"),

    //App没有该couponId的该操作权限
    APP_NO_AUTH("200013", "RETURN_CODE_APP_NO_AUTH"),

    //超出数量限制
    OVER_COUNT_LIMIT("200014", "RETURN_CODE_OVER_COUNT_LIMIT"),

    //Coupon不允许外部导入码券
    NOT_SUPPORT_IMPORT_CODE("200015", "RETURN_CODE_NOT_SUPPORT_IMPORT_CODE"),

    //Coupon不允许外部核销
    NOT_SUPPORT_EXTERNAL_CAV("200016", "RETURN_CODE_NOT_SUPPORT_EXTERNAL_CAV"),

    //电子券未到使用日期
    COUPON_CODE_EXPIREDATE_NOT_START("200017", "RETURN_CODE_COUPON_CODE_EXPIREDATE_NOT_START"),

    //电子券已过期
    COUPON_CODE_EXPIREDATE_END("200018", "RETURN_CODE_COUPON_CODE_EXPIREDATE_END"),

    //不允许该渠道核销
    THIS_CHANNEL_NOT_ALLOW_CAV("200019", "RETURN_CODE_THIS_CHANNEL_NOT_ALLOW_CAV"),

    //电子券已经使用
    COUPON_CODE_HAS_USED("200020", "RETURN_CODE_COUPON_CODE_HAS_USED"),

    //电子券已作废
    COUPON_CODE_HAS_CANCELED("200021", "RETURN_CODE_COUPON_CODE_HAS_CANCELED"),

    //电子券已过期
    COUPON_CODE_HAS_EXPIRED("200022", "RETURN_CODE_COUPON_CODE_HAS_EXPIRED"),

    //外部系统故障（如外部系统有明确错误信息，则返回外部系统的错误描述）
    EXTERNAL_SYSTEM_ERROR("999998", "RETURN_CODE_EXTERNAL_SYSTEM_ERROR"),

    //外部系统故障（如外部系统有明确错误信息，则返回外部系统的错误描述）
    SYSTEM_ERROR("999999", "RETURN_CODE_SYSTEM_ERROR");

    private String resultCode;

    private String reusltMsg;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getReusltMsg() {
        return reusltMsg;
    }

    public void setReusltMsg(String reusltMsg) {
        this.reusltMsg = reusltMsg;
    }

    CtcCallResult(String resultCode, String reusltMsg) {
        this.resultCode = resultCode;
        this.reusltMsg = reusltMsg;
    }
}
