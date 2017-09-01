package com.example;

import com.google.common.cache.CacheBuilder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableCaching
@EnableScheduling
public class ApplicationConfig {

    @Bean
    public CacheManager cacheManager() {
        GuavaCacheManager cacheManager = new GuavaCacheManager();
        cacheManager.setCacheBuilder(
                CacheBuilder.
                        newBuilder().
                        expireAfterWrite(10, TimeUnit.SECONDS).
                        maximumSize(100));
        return cacheManager;
    }
}
