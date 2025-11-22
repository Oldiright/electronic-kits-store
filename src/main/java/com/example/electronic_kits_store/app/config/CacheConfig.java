package com.example.electronic_kits_store.app.config;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

import java.time.Duration;

@Configuration
public class CacheConfig {
    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(60)) // <--- TTL за замовчуванням: 60 хвилин
                .disableCachingNullValues();
        // Також можна додати налаштування серіалізації (наприклад, JSON)
    }

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return (builder) -> builder
                // Встановлення TTL для конкретного кешу "products"
                .withCacheConfiguration("products",
                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(30))); // <--- Кеш "products" житиме 30 хвилин

                // Встановлення TTL для іншого кешу "categories"
//                .withCacheConfiguration("categories",
//                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)));
    }
}
