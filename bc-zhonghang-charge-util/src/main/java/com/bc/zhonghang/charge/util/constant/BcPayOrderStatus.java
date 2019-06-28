package com.bc.zhonghang.charge.util.constant;

public enum BcPayOrderStatus {
	 //订单状态（0，初始状态；1，成功；-1，失败；99，下单未支付）
    /**
     * -1	支付失败
     */
    ORDER_FAILED(-1, "支付失败"),
    /**
     * 0	下单成功
     */
    ORDER_INIT(0, "下单成功"),
    /**
     * 1	支付成功
     */
    ORDER_SUCCESS(1, "支付成功"),
    /**
     * 2	订单退款
     */
    ORDER_REFUND_SUCCESS(2, "退款成功"),
    
    /**
     * 3  	已撤销
     */
    ORDER_REVOKED(3, "已撤销"),
    
    /**
     * 4  	用户支付中
     */
    ORDER_USERPAYING(4, "用户支付中"),

    /**
     * 5	退款失败
     */
    ORDER_REFUND_FAIL(5, "退款失败"),
    
    /**
     * 6	部分退款成功
     */
    ORDER_PART_REFUND_SUCCESS(6, "部分退款成功"),
    
    /**
     * 9 	订单关闭
     */
    ORDER_CLOSED(9, "已关闭"),

    /**
     * 99	订单超时未支付
     */
    ORDER_NOT_PAY(99, "支付超时");

    private int orderStatus;
    private String orderStatusDesc;

    BcPayOrderStatus(int orderStatus, String orderStatusDesc) {
        this.orderStatus = orderStatus;
        this.orderStatusDesc = orderStatusDesc;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusDesc() {
        return orderStatusDesc;
    }

    public void setOrderStatusDesc(String orderStatusDesc) {
        this.orderStatusDesc = orderStatusDesc;
    }

}
