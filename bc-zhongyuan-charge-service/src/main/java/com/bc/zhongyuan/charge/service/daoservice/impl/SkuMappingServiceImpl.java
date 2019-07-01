package com.bc.zhongyuan.charge.service.daoservice.impl;

import com.bc.zhongyuan.charge.dao.SkuMappingDao;
import com.bc.zhongyuan.charge.dao.VerifyOrderDao;
import com.bc.zhongyuan.charge.dao.condition.SkuMappingCondition;
import com.bc.zhongyuan.charge.model.SkuMapping;
import com.bc.zhongyuan.charge.service.daoservice.SkuMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author js.ding
 * @Title: SkuMappingServiceImpl
 * @ProjectName bc-zhongyuan-charge
 * @Description: TODO
 * @date 2019/7/113:35
 */
@Service
public class SkuMappingServiceImpl implements SkuMappingService {

    @Autowired
    private SkuMappingDao skuMappingDao;

    @Override
    public int insert(SkuMapping record) {
        return skuMappingDao.insert(record);
    }

    @Override
    public int updateById(SkuMapping record) {
        return skuMappingDao.updateById(record);
    }

    @Override
    public SkuMapping selectFirst(SkuMappingCondition condition) {
        return skuMappingDao.selectFirst(condition);
    }

    @Override
    public List<SkuMapping> selectAll() {
        return skuMappingDao.selectAll();
    }
}
