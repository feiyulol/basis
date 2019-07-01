package com.bc.zhongyuan.charge.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bc.sdk.java.util.Encrypter;
import com.bc.sdk.java.util.ExceptionWrapper;
import com.bc.sdk.java.util.RandomUtils;
import com.bc.sdk.java.verify.VerifyApiHandler;
import com.bc.sdk.java.verify.dto.RevokeDTO;
import com.bc.sdk.java.verify.dto.VerifyDTO;
import com.bc.zhongyuan.charge.model.VerifyOrder;
import com.bc.zhongyuan.charge.model.dto.verifyDTO;
import com.bc.zhongyuan.charge.model.enums.OrderStatus;
import com.bc.zhongyuan.charge.service.VerifyService;
import com.bc.zhongyuan.charge.service.daoservice.VerifyOrderService;
import com.bc.zhongyuan.charge.util.RandomNumberGenerator;
import com.bc.zhongyuan.charge.util.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author js.ding
 * @Title: VerifyServiceImpl
 * @ProjectName bc-zhongyuan-charge
 * @Description: TODO
 * @date 2019/6/2813:50
 */
@Service
public class VerifyServiceImpl implements VerifyService {

    @Autowired
    private VerifyOrderService verifyOrderService;

    private Logger logger = LoggerFactory.getLogger(VerifyServiceImpl.class);

    @Autowired
    private VerifyService verifyService;

    @Value("${verify.appId}")
    private String appId;

    @Value("${verify.merchantId}")
    private String merchantId;

    @Value("${verify.storeId}")
    private String storeId;

    @Value("${verify.terminalId}")
    private String terminalId;

    @Value("${verify.appSignKey}")
    private String appSignKey;

    @Value("${verify.appDesKey}")
    private String appDesKey;

    @Value("${verify.url}")
    private String URI;

    @Value("${revoke.url}")
    private String revokeUrl;
    /**
     * 串码核销
     * @param couponNo
     * @return
     */
    @Override
    public ResponseModel verifyCode(String couponNo,String phone) {
        String code = "";
        String desc = "";
        String outTradeNo = RandomNumberGenerator.generatorOrderNumber(6);
        VerifyDTO verifyDTO = new VerifyDTO();
        verifyDTO.setCouponNo(couponNo);
        verifyDTO.setOutTradeNo(outTradeNo);
        // 随机数
        verifyDTO.setNonce(RandomUtils.getRandomStr(16));
        // 商户编号
        verifyDTO.setMerchantId(merchantId);
        // 应用编号 appId
        verifyDTO.setAppId(appId);
        verifyDTO.setStoreId(storeId);
        verifyDTO.setTerminalId(terminalId);
        long timestamp = System.currentTimeMillis();
        verifyDTO.setTimestamp(String.valueOf(timestamp / 1000));
        VerifyOrder verifyOrder = new VerifyOrder();
        // 调用核销API
        try {
            String str = VerifyApiHandler.verify(verifyDTO, appSignKey,
                    appDesKey, URI);
            JSONObject jsonObject = JSONObject.parseObject(str);
            code = jsonObject.getString("code");
            desc = jsonObject.getString("desc");
            if (!code.equals("000")) {
                verifyOrder.setOrderNo(outTradeNo);
                verifyOrder.setOrderStatus(OrderStatus.ORDER_STATUS_FAILED.getOrderStatus());
                verifyOrder.setRechargeStatus(OrderStatus.RECHARGE_STATUS_FAILED.getOrderStatus());
                verifyOrder.setRechargeStatusDesc(OrderStatus.RECHARGE_STATUS_FAILED.getOrderDesc());
                verifyOrder.setVerifyDesc(OrderStatus.VERIFY_STATUS_FAILED.getOrderDesc());
                verifyOrder.setVerifyStatus(OrderStatus.VERIFY_STATUS_FAILED.getOrderStatus());
                verifyOrder.setCreateTime(new Date());
                verifyOrder.setUpdateTime(new Date());
                verifyOrderService.insert(verifyOrder);
                return new ResponseModel().setCode(code).setDesc(desc);
            }
            JSONObject content = (JSONObject) jsonObject.get("content");
            String bcTradeNo = content.getString("bcTradeNo");
            String price = content.getString("price");
            String orderNo = content.getString("outTradeNo");
            String activityName = content.getString("activityName");
            String activityNo = content.getString("activityNo");
            String productName = content.getString("productName");
            String customerName = content.getString("customerName");
            String productNo = content.getString("productNo");
            verifyOrder.setActivityName(activityName);
            verifyOrder.setBcTradeNo(bcTradeNo);
            verifyOrder.setPrice(price);
            verifyOrder.setOrderNo(orderNo);
            verifyOrder.setActivityNo(activityNo);
            verifyOrder.setProductName(productName);
            verifyOrder.setCustomerName(customerName);
            verifyOrder.setProductNo(productNo);
            verifyOrder.setPhone(phone);
            verifyOrder.setCouponNo(Encrypter.encrypt(appDesKey, couponNo));
            verifyOrder.setCreateTime(new Date());
            verifyOrder.setUpdateTime(new Date());
            verifyOrder.setOrderStatus(OrderStatus.ORDER_STATUS_ING.getOrderStatus());
            verifyOrder.setRechargeStatus(OrderStatus.RECHARGE_STATUS_ING.getOrderStatus());
            verifyOrder.setRechargeStatusDesc(OrderStatus.RECHARGE_STATUS_ING.getOrderDesc());
            verifyOrder.setVerifyDesc(OrderStatus.VERIFY_STATUS_SUCCESS.getOrderDesc());
            verifyOrder.setVerifyStatus(OrderStatus.VERIFY_STATUS_SUCCESS.getOrderStatus());
            verifyOrderService.insert(verifyOrder);
        } catch (ExceptionWrapper e) {
            e.printStackTrace();
        }
        return new ResponseModel(verifyOrder).setCode(code).setDesc(desc);
    }

    /**
     * 券码撤销
     * @param remark
     * @return
     */
    @Override
    public ResponseModel revoke(String remark,VerifyOrder verifyOrder) {
        String code = "";
        String desc = "";
        String outTradeNo = RandomNumberGenerator.generatorOrderNumber(6);
        RevokeDTO revokeDTO = new RevokeDTO();
        revokeDTO.setCouponNo(verifyOrder.getCouponNo());
        // 随机数
        revokeDTO.setNonce(RandomUtils.getRandomStr(16));
        // 商户编号
        revokeDTO.setMerchantId(merchantId);
        // 应用编号 appId
        revokeDTO.setAppId(appId);
        revokeDTO.setStoreId(storeId);
        revokeDTO.setTerminalId(terminalId);
        revokeDTO.setBcTradeNo(remark);
        long timestamp = System.currentTimeMillis();
        revokeDTO.setTimestamp(String.valueOf(timestamp / 1000));
        try {
            String str = VerifyApiHandler.revoke(revokeDTO, appSignKey,
                    appDesKey, URI);
            JSONObject jsonObject = JSONObject.parseObject(str);
            code = jsonObject.getString("code");
            desc = jsonObject.getString("desc");
            if (!code.equals("000")) {
                verifyOrder.setOrderNo(outTradeNo);
                verifyOrder.setOrderStatus(OrderStatus.ORDER_STATUS_FAILED.getOrderStatus());
                verifyOrder.setRechargeStatus(OrderStatus.RECHARGE_STATUS_FAILED.getOrderStatus());
                verifyOrder.setRechargeStatusDesc(OrderStatus.RECHARGE_STATUS_FAILED.getOrderDesc());
                verifyOrder.setVerifyDesc(OrderStatus.REVOKE_STATUS_FAILED.getOrderDesc());
                verifyOrder.setVerifyStatus(OrderStatus.REVOKE_STATUS_FAILED.getOrderStatus());
                verifyOrder.setCreateTime(new Date());
                verifyOrder.setUpdateTime(new Date());
                verifyOrderService.insert(verifyOrder);
                return new ResponseModel().setCode(code).setDesc(desc);
            }
            JSONObject content = (JSONObject) jsonObject.get("content");
            String bcTradeNo = content.getString("bcTradeNo");
            verifyOrder.setOrderNo(outTradeNo);
            verifyOrder.setBcTradeNo(bcTradeNo);
            verifyOrder.setOrderStatus(OrderStatus.ORDER_STATUS_FAILED.getOrderStatus());
            verifyOrder.setRechargeStatus(OrderStatus.RECHARGE_STATUS_FAILED.getOrderStatus());
            verifyOrder.setRechargeStatusDesc(OrderStatus.RECHARGE_STATUS_FAILED.getOrderDesc());
            verifyOrder.setVerifyDesc(OrderStatus.REVOKE_STATUS_SUCCESS.getOrderDesc());
            verifyOrder.setVerifyStatus(OrderStatus.REVOKE_STATUS_SUCCESS.getOrderStatus());
            verifyOrder.setCreateTime(new Date());
            verifyOrder.setUpdateTime(new Date());
            verifyOrderService.insert(verifyOrder);
        } catch (ExceptionWrapper e) {
            e.printStackTrace();
        }
        return null;
    }

}
