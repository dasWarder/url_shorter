package com.example.url_shorter.service;

import com.example.url_shorter.dto.OriginalUrl;
import com.example.url_shorter.model.Url;
import org.apache.commons.validator.ValidatorException;

public interface ShorterUrlService {

    Url createShortUrl(String url) throws ValidatorException;

    OriginalUrl getOriginalUrl(String id) throws ValidatorException;
}
