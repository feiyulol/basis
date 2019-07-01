package com.bc.zhongyuan.charge.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;

/**
 * @author js.ding
 * @Title: Application
 * @ProjectName bc-zhongyuan-charge
 * @Description: TODO
 * @date 2019/6/2719:02
 */
@ServletComponentScan
@SpringBootApplication
@EnableEurekaClient
@EnableRetry
@ComponentScan("com.bc.zhongyuan.charge")
public class Application {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
