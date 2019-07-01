package com.bc.zhongyuan.charge.service.daoservice;

import com.bc.zhongyuan.charge.dao.condition.VerifyOrderCondition;
import com.bc.zhongyuan.charge.model.VerifyOrder;

import java.util.List;


/**
 * @author js.ding
 * @Title: VerifyOrderService
 * @ProjectName bc-zhongyuan-charge
 * @Description: TODO
 * @date 2019/6/2815:21
 */
public interface VerifyOrderService {
    int insert(VerifyOrder record);

    int updateById(VerifyOrder record);

    VerifyOrder selectFirst(VerifyOrderCondition condition);

    List<VerifyOrder> selectAll();

    VerifyOrder selectByOrderNo(String orderNo);
}
