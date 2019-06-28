package com.bc.zhonghang.charge.util.annotation;

import org.springframework.core.annotation.Order;

import java.lang.annotation.*;


/**
 *
 * @Title: Valid
 * @Package com.bc.mgt.util.annotation
 * @Description: 自定义注解(验证使用)
 * @author cy.wang@i-vpoints.com
 * @date 2017年10月26日 上午10:58:41
 * @version V1.0
 *
 */
@Documented
@Target(ElementType.ANNOTATION_TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Order(101)
public @interface Valid {
    /**是否必填  默认为false*/
    boolean required() default false;

    /**数值类型支持  最大值*/
    double maxValue() default Double.MAX_VALUE;

    /**数值类型支持  最小值*/
    double minValue() default Double.MIN_VALUE;

    /**String类型支持  正则匹配*/
    String regex() default "";

    /**String类型支持  特定长度*/
    long length() default -1;

    /**String类型支持  最大长度*/
    long maxLength() default -1;

    /**String类型支持  最小长度*/
    long minLength() default -1;

    /**验证参数名*/
    String name();

    /**备注中文描述*/
    String remark();

}

