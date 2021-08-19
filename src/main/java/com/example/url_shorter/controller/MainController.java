package com.example.url_shorter.controller;

import com.example.url_shorter.dto.OriginalUrl;
import com.example.url_shorter.exception.NullableParamException;
import com.example.url_shorter.exception.ValidationException;
import com.example.url_shorter.model.Url;
import com.example.url_shorter.service.ShorterUrlService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.ValidatorException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/urlshorter")
public class MainController {

    private final ShorterUrlService urlService;

    @PostMapping("/url")
    public ResponseEntity<Url> create(@RequestBody OriginalUrl url)
                                                        throws ValidationException {
        Url shortUrl = urlService.createShortUrl(url.getUrl());

        return ResponseEntity.ok(shortUrl);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OriginalUrl> getOriginalUrl(@PathVariable("id") String id)
                                                        throws ValidationException, NullableParamException {
        OriginalUrl originalUrl = urlService.getOriginalUrl(id);

        return ResponseEntity.ok(originalUrl);
    }
}