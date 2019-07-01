package com.bc.zhongyuan.charge.service;

import com.bc.zhongyuan.charge.model.RechargeNotifyParams;
import com.bc.zhongyuan.charge.model.VerifyOrder;
import com.bc.zhongyuan.charge.util.ResponseModel;

/**
 * @author js.ding
 * @Title: RechargeService
 * @ProjectName bc-zhongyuan-charge
 * @Description: TODO
 * @date 2019/6/2813:55
 */
public interface RechargeService {

    ResponseModel rechargeCharge(VerifyOrder verifyOrder);

    Boolean check(RechargeNotifyParams params);
}
