package com.example.url_shorter.service;

import com.example.url_shorter.dto.OriginalUrl;
import com.example.url_shorter.model.Url;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.ValidatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static com.example.url_shorter.util.UrlValidation.validateObject;
import static com.example.url_shorter.util.UrlValidation.validateUrl;


@Slf4j
@Service
public class ShorterService implements ShorterUrlService {

    @Value("${redis.ttl}")
    private Long ttl;

    @Autowired
    private RedisTemplate<String, Url> redisTemplate;

    @Override
    public Url createShortUrl(String url) throws ValidatorException {

        log.info("Creating a new short URL for the original url");
        validateUrl(url);

        Url shortUrl = new Url(url);

        redisTemplate.opsForValue().set(shortUrl.getId(), shortUrl, ttl, TimeUnit.SECONDS);

        return shortUrl;
    }

    @Override
    public OriginalUrl getOriginalUrl(String id) throws ValidatorException {

        validateObject(id);
        log.info("Receive an original URL by its id = {}", id);

        Url url = redisTemplate.opsForValue().get(id);

        validateObject(url);
        validateUrl(url.getUrl());

        return new OriginalUrl(url.getUrl());
    }
}
