package com.ogutcenali.config.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import java.time.Duration;
@Configuration
@EnableCaching
@EnableRedisRepositories
public class RedisConfig {

    @Value("${redis.host}")
    private String redisHostName;
    @Value("${redis.port}")
    private Integer redisPort;

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(
                new RedisStandaloneConfiguration(redisHostName, redisPort));
    }
    @Bean
    public RedisCacheManager cacheManager() {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                // cache entries for 30 minutes
                .entryTtl(Duration.ofMinutes(30));
        return RedisCacheManager.builder(redisConnectionFactory())
                .cacheDefaults(redisCacheConfiguration)
                .build();
    }
}
