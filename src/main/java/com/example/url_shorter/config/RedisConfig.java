package com.example.url_shorter.config;


import com.example.url_shorter.model.Url;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@RequiredArgsConstructor
public class RedisConfig {

    private final ObjectMapper mapper;

    private final RedisConnectionFactory factory;

    @Bean
    public RedisTemplate<String, Url> redisTemplate() {

        RedisTemplate<String, Url> template = new RedisTemplate<>();
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Url.class);
        serializer.setObjectMapper(mapper);
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);

        return template;
    }
}
