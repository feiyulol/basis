package com.bc.zhongyuan.charge.service.daoservice;

import com.bc.zhongyuan.charge.dao.condition.SkuMappingCondition;
import com.bc.zhongyuan.charge.dao.condition.VerifyOrderCondition;
import com.bc.zhongyuan.charge.model.SkuMapping;
import com.bc.zhongyuan.charge.model.VerifyOrder;

import java.util.List;

/**
 * @author js.ding
 * @Title: SkuMappingService
 * @ProjectName bc-zhongyuan-charge
 * @Description: TODO
 * @date 2019/7/113:35
 */
public interface SkuMappingService {

    int insert(SkuMapping record);

    int updateById(SkuMapping record);

    SkuMapping selectFirst(SkuMappingCondition condition);

    List<SkuMapping> selectAll();

}
