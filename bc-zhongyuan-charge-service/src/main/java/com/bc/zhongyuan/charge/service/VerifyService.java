package com.bc.zhongyuan.charge.service;

import com.bc.zhongyuan.charge.model.VerifyOrder;
import com.bc.zhongyuan.charge.util.ResponseModel;

/**
 * @author js.ding
 * @Title: VerifyService
 * @ProjectName bc-zhongyuan-charge
 * @Description: TODO
 * @date 2019/6/2813:49
 */
public interface VerifyService {

    ResponseModel verifyCode(String code,String phone);

    ResponseModel revoke(String remark, VerifyOrder verifyOrder);
}
