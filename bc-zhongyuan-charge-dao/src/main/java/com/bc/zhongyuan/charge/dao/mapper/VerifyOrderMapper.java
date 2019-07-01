
package com.bc.zhongyuan.charge.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bc.zhongyuan.charge.dao.condition.VerifyOrderCondition;
import com.bc.zhongyuan.charge.model.VerifyOrder;
import com.bc.zhongyuan.charge.dao.abs.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>VerifyOrder数据层的基础操作</p>
 * @ClassName: VerifyOrderMapper
 * @Description: VerifyOrder数据层的基础操作
 * @author Generator
 * @date 2019年06月28日 15时07分18秒
 */
@Mapper
public interface VerifyOrderMapper extends BaseMapper<VerifyOrder, VerifyOrderCondition>{

    VerifyOrder selectByOrderNo(@Param("orderNo") String orderNo);
}
