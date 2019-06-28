package com.bc.zhonghang.charge.model.enums;

/**
 * @author js.ding
 * @Title: OrderStatus
 * @ProjectName bc-moblike-platform
 * @Description: TODO
 * @date 2019/6/616:48
 */
public enum OrderStatus {
    ORDER_STATUS_PAY_WAITTING("0", "待支付"),
    ORDER_STATUS_PAY_SUCCESS("1", "支付成功"),
    ORDER_STATUS_PAY_TIMEOUT("2", "超时未支付"),
    ORDER_STATUS_PAY_FAILED("3", "支付失败"),
    ORDER_STATUS_PAY_INVALID("6", "订单作废"),
    RECHARGE_STATUS_SUCCESS("1", "直冲成功"),
    RECHARGE_STATUS_FAILED("-1", "直冲失败"),
    RECHARGE_STATUS_ING("0", "直冲中"),
    RECHARGE_STATUS_COMMIT("8", "直冲提交成功"),
    RECHARGE_STATUS_RESPONSE("9", "直冲响应中"),
    RECHARGE_STATUS_NOTPAY("7", "订单未支付"),
    ;

    private String orderStatus;

    private String orderDesc;

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    OrderStatus(String orderStatus, String orderDesc) {
        this.orderStatus = orderStatus;
        this.orderDesc = orderDesc;
    }
}
