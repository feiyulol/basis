package com.bc.zhongyuan.charge.model.dto;

/**
 * @author js.ding
 * @Title: verifyDTO
 * @ProjectName bc-zhongyuan-charge
 * @Description: TODO
 * @date 2019/7/114:40
 */
public class verifyDTO {

    private String phone;

    private String code;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "verifyDTO{" +
                "phone='" + phone + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
