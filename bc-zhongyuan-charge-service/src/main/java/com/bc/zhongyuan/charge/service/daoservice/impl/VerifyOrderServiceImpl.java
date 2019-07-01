package com.bc.zhongyuan.charge.service.daoservice.impl;

import com.bc.zhongyuan.charge.dao.VerifyOrderDao;
import com.bc.zhongyuan.charge.dao.condition.VerifyOrderCondition;
import com.bc.zhongyuan.charge.model.VerifyOrder;
import com.bc.zhongyuan.charge.service.daoservice.VerifyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author js.ding
 * @Title: VerifyOrderServiceImpl
 * @ProjectName bc-zhongyuan-charge
 * @Description: TODO
 * @date 2019/6/2815:21
 */
@Service
public class VerifyOrderServiceImpl implements VerifyOrderService {

    @Autowired
    private VerifyOrderDao verifyOrderDao;

    @Override
    public int insert(VerifyOrder record) {
        return verifyOrderDao.insert(record);
    }

    @Override
    public int updateById(VerifyOrder record) {
        return verifyOrderDao.updateById(record);
    }

    @Override
    public VerifyOrder selectFirst(VerifyOrderCondition condition) {
        return verifyOrderDao.selectFirst(condition);
    }

    @Override
    public List<VerifyOrder> selectAll() {
        return verifyOrderDao.selectAll();
    }

    @Override
    public VerifyOrder selectByOrderNo(String orderNo) {
        return verifyOrderDao.selectByOrderNo(orderNo);
    }
}
