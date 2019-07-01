package com.bc.zhongyuan.charge.dao;

import com.bc.zhongyuan.charge.dao.condition.VerifyOrderCondition;
import com.bc.zhongyuan.charge.model.VerifyOrder;
import com.bc.zhongyuan.charge.dao.abs.BaseDao;

/**
 * <p>VerifyOrder的基础操作Dao</p>
 * @ClassName: VerifyOrderDao
 * @Description: VerifyOrder基础操作的Dao
 * @author Generator
 * @date 2019年06月28日 15时07分18秒
 */
public interface VerifyOrderDao extends BaseDao<VerifyOrder,VerifyOrderCondition>{

    VerifyOrder selectByOrderNo(String orderNo);
}
