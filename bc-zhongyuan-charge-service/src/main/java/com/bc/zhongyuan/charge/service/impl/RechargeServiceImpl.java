package com.bc.zhongyuan.charge.service.impl;

import com.bc.zhongyuan.charge.dao.condition.SkuMappingCondition;
import com.bc.zhongyuan.charge.model.RechargeNotifyParams;
import com.bc.zhongyuan.charge.model.SkuMapping;
import com.bc.zhongyuan.charge.model.VerifyOrder;
import com.bc.zhongyuan.charge.service.RechargeService;
import com.bc.zhongyuan.charge.service.daoservice.SkuMappingService;
import com.bc.zhongyuan.charge.util.Post;
import com.bc.zhongyuan.charge.util.ResponseModel;
import com.bc.zhongyuan.charge.util.pay.sdk.sign.api.RechargeSignUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author js.ding
 * @Title: RechargeServiceImpl
 * @ProjectName bc-zhongyuan-charge
 * @Description: TODO
 * @date 2019/6/2813:55
 */
@Service
public class RechargeServiceImpl implements RechargeService {

    private Logger logger = LoggerFactory.getLogger(RechargeServiceImpl.class);

    @Autowired
    private SkuMappingService skuMappingService;

    @Value("${recharge.appId}")
    private String rechargeAppId;

    @Value("${recharge.notifyUrl}")
    private String rechargeNotifyUrl;

    @Value("${recharge.signKey}")
    private String rechargeSignKey;

    //直冲地址
    @Value("${recharge.url}")
    private String rechargePayUrl;

    /**
     * 调用麻袋氪话费直充
     *
     * @param verifyOrder
     * @return
     */
    @Override
    public ResponseModel rechargeCharge(VerifyOrder verifyOrder) {
        SkuMappingCondition skuMappingCondition = new SkuMappingCondition();
        skuMappingCondition.setProductId(verifyOrder.getProductNo());
        SkuMapping skuMapping = skuMappingService.selectFirst(skuMappingCondition);
        if (skuMapping == null) {
            logger.info("商品{}映射不存在",verifyOrder.getProductNo());
        }
        //调用直冲
        Map<String, String> rechargeParams = new HashMap<>();
        rechargeParams.put("appId", rechargeAppId);
        rechargeParams.put("orderNo", verifyOrder.getOrderNo());
        rechargeParams.put("account", verifyOrder.getPhone());
        rechargeParams.put("notifyRemark", verifyOrder.getBcTradeNo());
        rechargeParams.put("orderTime", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        //直冲回调地址
        rechargeParams.put("notifyUrl", rechargeNotifyUrl);
        rechargeParams.put("sku", skuMapping.getSku());
        rechargeParams.put("sign", RechargeSignUtil.sign(rechargeParams, rechargeSignKey));
        logger.info("订单[{}]直冲提交参数 : {}", verifyOrder.getOrderNo(), rechargeParams);
        try {
            String rechargeResult = Post.post(rechargePayUrl, rechargeParams, "application/x-www-form-urlencoded;charset=gbk");
            logger.info("直冲结果 : {}", rechargeResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseModel().warpSuccess();
    }
    public Boolean check(RechargeNotifyParams params) {
        HashMap<String, String> map = new HashMap<>();
        map.put("appId", params.getAppId());
        map.put("finishTime", params.getFinishTime());
        map.put("orderNo", params.getOrderNo());
        map.put("remark", params.getRemark());
        map.put("retCode", params.getRetCode());
        map.put("retMsg", params.getRetMsg());
        map.put("orderStatus", params.getOrderStatus());
        map.put("transNo", params.getTransNo());
        String sign = RechargeSignUtil.sign(map, rechargeSignKey);
        logger.info("直冲回调参数:{}", params);
        //直冲回调验签
        if (!sign.equals(params.getSign())) {
            return false;
        }
        return true;
    }
}
