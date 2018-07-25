package com.zhihuishu.athomework.redis;

import com.zhihuishu.toolkit.jedis.template.JedisExecutor;
import com.zhihuishu.toolkit.jedis.template.JedisTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.net.URI;

@Configuration
public class RedisConfig {

    @Value("${redis.athomework.max}")
    private int max;
    @Value("${redis.athomework.min}")
    private int min;

    @Value("${redis.athomework.uri}")
    private String athomeworkRedisUri;

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(max);
        jedisPoolConfig.setMaxIdle(max);
        jedisPoolConfig.setMinIdle(min);
        jedisPoolConfig.setMaxWaitMillis(1000);
        jedisPoolConfig.setTestWhileIdle(true);
        return jedisPoolConfig;
    }

    @Bean
    public JedisPool jedisPool(JedisPoolConfig config) {
        return new JedisPool(config, URI.create(athomeworkRedisUri));
    }

    @Bean
    public JedisTemplate jedisTemplate(JedisPool jedisPool) {
        return new JedisTemplate(jedisPool);
    }

    @Bean
    public JedisExecutor jedisExecutor(JedisPool jedisPool) {
        return new JedisExecutor(jedisPool);
    }
}