package com.bc.zhongyuan.charge.util.annotation;

import org.springframework.core.annotation.Order;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @Title: Valids
 * @Package com.bc.mgt.util.annotation
 * @Description: 自定义注解(验证使用)
 * @author cy.wang@i-vpoints.com
 * @date 2017年10月26日 上午10:59:19
 * @version V1.0
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Order(100)
public @interface Valids {
    Valid[] value();
}
