package com.bc.zhongyuan.charge.dao.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * 
 * @Title: RedisConfig
 * @Package com.bc.jiangbei.o2o.portal.web.config
 * @Description: Redis配置
 * @author cy.wang@i-vpoints.com
 * @date 2018年3月5日 下午3:48:11
 * @version V1.0
 *
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {
	/**
	 * 注入 RedisConnectionFactory
	 */
	@Autowired
    RedisConnectionFactory redisConnectionFactory;

	/**
	 * 实例化 RedisTemplate 对象
	 *
	 * @return
	 */
	@Bean
	public RedisTemplate<String, Object> functionDomainRedisTemplate() {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
		return redisTemplate;
	}

	/**
	 * 实例化 ValueOperations 对象,可以使用 String 操作
	 *
	 * @param redisTemplate
	 * @return
	 */
	@Bean
	public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate) {
		return redisTemplate.opsForValue();
	}

	/**
	 * 实例化 ListOperations 对象,可以使用 List 操作
	 *
	 * @param redisTemplate
	 * @return
	 */
	@Bean
	public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
		return redisTemplate.opsForList();
	}

	/**
	 * 设置数据存入 redis 的序列化方式
	 *
	 * @param redisTemplate
	 * @param factory
	 */
	private void initDomainRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory) {
		FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
		redisTemplate.setValueSerializer(fastJsonRedisSerializer);
		redisTemplate.setConnectionFactory(factory);
		redisTemplate.afterPropertiesSet();
	}

	/**
	 * 实例化 HashOperations 对象,可以使用 Hash 类型操作
	 *
	 * @param redisTemplate
	 * @return
	 */
	@Bean
	public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
		return redisTemplate.opsForHash();
	}

	/**
	 * 实例化 ZSetOperations 对象,可以使用 ZSet 操作
	 *
	 * @param redisTemplate
	 * @return
	 */
	@Bean
	public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
		return redisTemplate.opsForZSet();
	}

	/**
	 * 实例化 SetOperations 对象,可以使用 Set 操作
	 *
	 * @param redisTemplate
	 * @return
	 */
	@Bean
	public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
		return redisTemplate.opsForSet();
	}

}