package com.cc.bookmanager.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Configuration;

/**
 * @author duong
 * customer config when redis server down
 */
@Slf4j
@EnableCaching
@Configuration
public class CacheConfiguration extends CachingConfigurerSupport {
    @Override
    public CacheErrorHandler errorHandler() {
        return new CacheErrorHandler() {
            @Override
            public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
                log.info("Failure getting from cache: " + cache.getName() + ", exception: " + exception);
            }

            @Override
            public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
                log.info("Failure putting into cache: " + cache.getName() + ", exception: " + exception);
            }

            @Override
            public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
                log.info("Failure evicting from cache: " + cache.getName() + ", exception: " + exception);
            }

            @Override
            public void handleCacheClearError(RuntimeException exception, Cache cache) {
                log.info("Failure clearing cache: " + cache.getName() + ", exception: " + exception);
            }
        };
    }
}