
package com.bc.zhongyuan.charge.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bc.zhongyuan.charge.dao.condition.SkuMappingCondition;
import com.bc.zhongyuan.charge.dao.mapper.SkuMappingMapper;
import com.bc.zhongyuan.charge.model.SkuMapping;
import com.bc.zhongyuan.charge.dao.abs.BaseMapper;
import com.bc.zhongyuan.charge.dao.abs.AbstractDaoImpl;
import com.bc.zhongyuan.charge.dao.SkuMappingDao;

@Service
public class SkuMappingDaoImpl extends AbstractDaoImpl<SkuMapping, SkuMappingCondition, BaseMapper<SkuMapping,SkuMappingCondition>> implements SkuMappingDao{
	
	@Resource
	private SkuMappingMapper skuMappingMapper;
	
	@Override
	protected BaseMapper<SkuMapping, SkuMappingCondition> daoSupport() {
		return skuMappingMapper;
	}

	@Override
	protected SkuMappingCondition blankCondition() {
		return new SkuMappingCondition();
	}

}
