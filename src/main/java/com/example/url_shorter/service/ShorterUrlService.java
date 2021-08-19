package com.example.url_shorter.service;

import com.example.url_shorter.dto.OriginalUrl;
import com.example.url_shorter.exception.NullableParamException;
import com.example.url_shorter.exception.ValidationException;
import com.example.url_shorter.model.Url;

public interface ShorterUrlService {

    Url createShortUrl(String url) throws ValidationException;

    OriginalUrl getOriginalUrl(String id) throws ValidationException, NullableParamException;
}
