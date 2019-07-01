package com.bc.zhongyuan.charge.web.contrller;

import com.bc.zhongyuan.charge.model.RechargeNotifyParams;
import com.bc.zhongyuan.charge.model.VerifyOrder;
import com.bc.zhongyuan.charge.model.enums.OrderStatus;
import com.bc.zhongyuan.charge.service.RechargeService;
import com.bc.zhongyuan.charge.service.VerifyService;
import com.bc.zhongyuan.charge.service.daoservice.VerifyOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author js.ding
 * @Title: RechargeNotify
 * @ProjectName bc-zhongyuan-charge
 * @Description: TODO
 * @date 2019/7/111:55
 */
@RestController
@RequestMapping("recharge")
public class RechargeNotify {

    private Logger logger = LoggerFactory.getLogger(RechargeNotify.class);

    @Autowired
    private VerifyOrderService verifyOrderService;

    @Autowired
    private RechargeService rechargeService;

    @Autowired
    private VerifyService verifyService;

    @RequestMapping("notify")
    public String notify(RechargeNotifyParams params) {
        String result = "";
        logger.info("中原话费直冲收到异步回调 参数为{}", params);
        Boolean checkBoolean = rechargeService.check(params);
        if (checkBoolean) {
            //直冲验签通过
            VerifyOrder verifyOrder = verifyOrderService.selectByOrderNo(params.getOrderNo());
            if (verifyOrder == null) {
                logger.info("订单不存在,订单号为{}", verifyOrder);
            }
            switch (params.getOrderStatus()) {
                case "1":
                    logger.info("订单{}直冲成功", verifyOrder.getOrderNo());
                    verifyOrder.setRechargeStatus(OrderStatus.RECHARGE_STATUS_SUCCESS.getOrderStatus());
                    verifyOrder.setRechargeStatusDesc(OrderStatus.RECHARGE_STATUS_SUCCESS.getOrderDesc());
                    verifyOrder.setOrderStatus(OrderStatus.ORDER_STATUS_SUCCESS.getOrderStatus());
                    verifyOrder.setUpdateTime(new Date());
                    verifyOrderService.updateById(verifyOrder);
                    result = "SUCCESS";
                    break;
                case "0":
                    logger.info("订单{}下单成功", verifyOrder.getOrderNo());
                    verifyOrder.setRechargeStatusDesc(OrderStatus.RECHARGE_STATUS_ING.getOrderDesc());
                    verifyOrder.setRechargeStatus(OrderStatus.RECHARGE_STATUS_ING.getOrderStatus());
                    verifyOrder.setOrderStatus(OrderStatus.ORDER_STATUS_ING.getOrderStatus());
                    verifyOrder.setUpdateTime(new Date());
                    verifyOrderService.updateById(verifyOrder);
                    break;
                case "8":
                    logger.info("订单{}订单提交成功", verifyOrder.getOrderNo());
                    verifyOrder.setRechargeStatusDesc(OrderStatus.RECHARGE_STATUS_COMMIT.getOrderDesc());
                    verifyOrder.setRechargeStatus(OrderStatus.RECHARGE_STATUS_COMMIT.getOrderStatus());
                    verifyOrder.setOrderStatus(OrderStatus.ORDER_STATUS_ING.getOrderStatus());
                    verifyOrder.setUpdateTime(new Date());
                    verifyOrderService.updateById(verifyOrder);
                    break;
                case "9":
                    logger.info("订单{}直冲响应中", verifyOrder.getOrderNo());
                    verifyOrder.setRechargeStatusDesc(OrderStatus.RECHARGE_STATUS_RESPONSE.getOrderDesc());
                    verifyOrder.setRechargeStatus(OrderStatus.RECHARGE_STATUS_RESPONSE.getOrderStatus());
                    verifyOrder.setOrderStatus(OrderStatus.ORDER_STATUS_ING.getOrderStatus());
                    verifyOrder.setUpdateTime(new Date());
                    verifyOrderService.updateById(verifyOrder);
                    break;
                case "-1":
                    //直冲失败 返还权益 权益数量减一 自动调用退款
                    logger.info("订单{}直冲失败", verifyOrder.getOrderNo());
                    verifyOrder.setRechargeStatusDesc(OrderStatus.RECHARGE_STATUS_FAILED.getOrderDesc());
                    verifyOrder.setRechargeStatus(OrderStatus.RECHARGE_STATUS_FAILED.getOrderStatus());
                    verifyOrder.setOrderStatus(OrderStatus.ORDER_STATUS_FAILED.getOrderStatus());
                    verifyOrder.setUpdateTime(new Date());
                    verifyOrderService.updateById(verifyOrder);
                    //直冲失败撤销核销
                    verifyService.revoke(params.getRemark(),verifyOrder.getCouponNo());
                    result = "SUCCESS";
                    break;
            }
        } else {
            logger.info("直冲验签不通过", params.getOrderNo());
            result = "FAILED";
        }
        return result;
    }
}
