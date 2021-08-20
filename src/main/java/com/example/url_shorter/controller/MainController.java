package com.example.url_shorter.controller;

import com.example.url_shorter.dto.OriginalUrl;
import com.example.url_shorter.exception.NullableParamException;
import com.example.url_shorter.exception.ValidationException;
import com.example.url_shorter.model.Url;
import com.example.url_shorter.service.ShorterUrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/urlshorter")
@CrossOrigin(origins = "http://localhost:3000")
public class MainController {

    private final ShorterUrlService urlService;

    @PostMapping("/url")
    public ResponseEntity<Url> create(@RequestBody OriginalUrl url)
                                                        throws ValidationException {
        log.info("URL info: ", url.toString());
        Url shortUrl = urlService.createShortUrl(url.getUrl());

        return ResponseEntity.ok(shortUrl);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> getOriginalUrl(@PathVariable("id") String id)
                                                        throws ValidationException, NullableParamException {
        String originalUrl = urlService.getOriginalUrl(id);

        return ResponseEntity
                            .status(HttpStatus.FOUND)
                            .location(URI.create(originalUrl))
                            .build();
    }
}
