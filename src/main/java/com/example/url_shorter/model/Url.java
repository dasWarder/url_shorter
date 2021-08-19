package com.example.url_shorter.model;

import com.google.common.hash.Hashing;
import lombok.Data;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Data
public class Url {

    private final String id;
    private final String url;
    private final LocalDateTime created;

    public Url(String url) {
        this.id = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
        this.url = url;
        this.created = LocalDateTime.now();
    }
}
