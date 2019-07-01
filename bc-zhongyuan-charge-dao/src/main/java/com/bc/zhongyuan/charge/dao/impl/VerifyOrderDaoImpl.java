
package com.bc.zhongyuan.charge.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bc.zhongyuan.charge.dao.condition.VerifyOrderCondition;
import com.bc.zhongyuan.charge.dao.mapper.VerifyOrderMapper;
import com.bc.zhongyuan.charge.model.VerifyOrder;
import com.bc.zhongyuan.charge.dao.abs.BaseMapper;
import com.bc.zhongyuan.charge.dao.abs.AbstractDaoImpl;
import com.bc.zhongyuan.charge.dao.VerifyOrderDao;

@Service
public class VerifyOrderDaoImpl extends AbstractDaoImpl<VerifyOrder, VerifyOrderCondition, BaseMapper<VerifyOrder,VerifyOrderCondition>> implements VerifyOrderDao{
	
	@Resource
	private VerifyOrderMapper verifyOrderMapper;
	
	@Override
	protected BaseMapper<VerifyOrder, VerifyOrderCondition> daoSupport() {
		return verifyOrderMapper;
	}

	@Override
	protected VerifyOrderCondition blankCondition() {
		return new VerifyOrderCondition();
	}

	@Override
	public VerifyOrder selectByOrderNo(String orderNo) {
		return verifyOrderMapper.selectByOrderNo(orderNo);
	}
}
