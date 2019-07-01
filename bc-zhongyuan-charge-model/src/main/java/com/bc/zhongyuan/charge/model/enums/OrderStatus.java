package com.bc.zhongyuan.charge.model.enums;

/**
 * @author js.ding
 * @Title: OrderStatus
 * @ProjectName bc-moblike-platform
 * @Description: TODO
 * @date 2019/6/616:48
 */
public enum OrderStatus {
    RECHARGE_STATUS_SUCCESS("1", "直冲成功"),
    RECHARGE_STATUS_FAILED("-1", "直冲失败"),
    RECHARGE_STATUS_ING("0", "直冲中"),
    RECHARGE_STATUS_COMMIT("8", "直冲提交成功"),
    RECHARGE_STATUS_RESPONSE("9", "直冲响应中"),
    RECHARGE_STATUS_NOTPAY("7", "订单未支付"),
    VERIFY_STATUS_SUCCESS("1", "核销成功"),
    VERIFY_STATUS_ING("0", "核销中"),
    VERIFY_STATUS_FAILED("-1", "核销失败"),
    REVOKE_STATUS_SUCCESS("2", "撤销成功"),
    REVOKE_STATUS_FAILED("-2", "撤销失败"),
    ORDER_STATUS_SUCCESS("1", "订单成功"),
    ORDER_STATUS_ING("0", "订单处理中"),
    ORDER_STATUS_FAILED("-1", "订单失败"),
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
