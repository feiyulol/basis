package com.bc.zhonghang.charge.util.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @ClassName: AuthMethod.java
 * @author: f.hu@i-vpoints.com
 * @date: 2018-07-04 15:06
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface AuthMethod {

    public String serviceName();
}
