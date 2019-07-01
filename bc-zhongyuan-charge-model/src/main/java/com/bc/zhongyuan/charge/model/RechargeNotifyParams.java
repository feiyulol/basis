package com.bc.zhongyuan.charge.model;

/**
 * @author js.ding
 * @Title: RechargeNotifyParams
 * @ProjectName bc-moblike-platform
 * @Description: TODO
 * @date 2019/6/617:52
 */
public class RechargeNotifyParams {
    /**
     * 直冲appId
     */
    private String appId;

    /**
     * 直冲完成时间
     */
    private String finishTime;

    /**
     * 直冲订单
     */
    private String orderNo;

    /**
     * 直冲标记位置
     */
    private String remark;

    /**
     * 直冲返回码
     */
    private String retCode;

    /**
     * 直冲返回信息
     */
    private String retMsg;

    /**
     * 订单状态
     */
    private String orderStatus;

    /**
     * 直冲交易流水号
     */
    private String transNo;

    /**
     * 直冲签名
     */
    private String sign;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "RechargeNotifyParams{" +
                "appId='" + appId + '\'' +
                ", finishTime='" + finishTime + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", remark='" + remark + '\'' +
                ", retCode='" + retCode + '\'' +
                ", retMsg='" + retMsg + '\'' +
                ", transNo='" + transNo + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
