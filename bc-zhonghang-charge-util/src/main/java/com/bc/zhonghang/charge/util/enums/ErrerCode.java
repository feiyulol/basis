package com.bc.zhonghang.charge.util.enums;

/**
 * @author js.ding
 * @Title: ErrerCode
 * @ProjectName bc-ctc-platform
 * @Description: TODO
 * @date 2019/4/1717:58
 */
public enum ErrerCode {

    SUCCESS("000000", "000"),
    EMPTY("001", "001"),
    SIGNERROR("100004", "004"),
    COUPON_NOT_EXIST("200005", "007"),
    CODE_STATUS_ERROR("200010", "011"),
    COUPON_CODE_NOT_EXIST("200011", "012"),
    CODE_PARAMS_INVALID("100001", "600"),
    ORDER_AKREAD_TEXUSTS("103", "103"),
    ORDER_DOES_NOT_EXIST("104", "104"),
    MISSING_PARAMETER("600","600");

    private String ctcCode;

    private String bocCode;

    public String getCtcCode() {
        return ctcCode;
    }

    public void setCtcCode(String ctcCode) {
        this.ctcCode = ctcCode;
    }

    public String getBocCode() {
        return bocCode;
    }

    public void setBocCode(String bocCode) {
        this.bocCode = bocCode;
    }

    ErrerCode(String ctcCode, String bocCode) {
        this.ctcCode = ctcCode;
        this.bocCode = bocCode;
    }
    }
