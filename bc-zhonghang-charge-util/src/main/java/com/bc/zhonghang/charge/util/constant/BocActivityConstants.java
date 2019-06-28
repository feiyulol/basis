package com.bc.zhonghang.charge.util.constant;

/**
 * @ClassName: BocActivityConstants.java
 * @author: f.hu@i-vpoints.com
 * @date: 2019-03-14 19:36
 * @Description:
 */
public class BocActivityConstants {

    private int reduceAmount;

    private double taxRate;

    private double serviceCharge;

    public int getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(int reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }
}
