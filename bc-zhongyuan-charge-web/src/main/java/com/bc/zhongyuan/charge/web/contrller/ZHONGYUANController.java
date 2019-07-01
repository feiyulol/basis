package com.bc.zhongyuan.charge.web.contrller;

import com.alibaba.fastjson.JSON;
import com.bc.zhongyuan.charge.model.VerifyOrder;
import com.bc.zhongyuan.charge.model.dto.verifyDTO;
import com.bc.zhongyuan.charge.service.RechargeService;
import com.bc.zhongyuan.charge.service.VerifyService;
import com.bc.zhongyuan.charge.util.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author js.ding
 * @Title: ZHONGYUANChargeController
 * @ProjectName bc-zhongyuan-charge
 * @Description: TODO
 * @date 2019/6/2811:58
 */
@RestController
@RequestMapping("zhongyuan")
public class ZHONGYUANController {

    private Logger logger = LoggerFactory.getLogger(ZHONGYUANController.class);

    @Autowired
    private VerifyService verifyService;

    @Autowired
    private RechargeService rechargeService;

    @RequestMapping("charge")
    public String charge(@RequestBody verifyDTO verifyDTO) {
        logger.info("中原话费核销充值,手机号:{},核销码:{}", verifyDTO.getPhone(), verifyDTO.getCode());
        //先核销码
        ResponseModel verifyResponse = verifyService.verifyCode(verifyDTO.getCode(),verifyDTO.getPhone());
        //判断码是否核销成功
        if (!verifyResponse.getCode().equals("000")) {
            return JSON.toJSONString(verifyResponse);
        }
        VerifyOrder verifyOrder =(VerifyOrder)verifyResponse.getContent();
        //调用直冲给用户充值话费
        ResponseModel rechargeResponse = rechargeService.rechargeCharge(verifyOrder);
        return JSON.toJSONString(rechargeResponse);
    }
}
