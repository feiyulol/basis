package com.bc.zhongyuan.charge.dao.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.bc.zhongyuan.charge.dao.mapper")
@AutoConfigureAfter(com.bc.zhongyuan.charge.dao.config.MyBatisConfig.class)
public class MyBatisMapperScannerConfig {
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer
				.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage("com.bc.zhongyuan.charge.dao.mapper");
		return mapperScannerConfigurer;
	}
}
