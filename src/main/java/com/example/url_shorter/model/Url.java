package com.example.url_shorter.model;

import com.google.common.hash.Hashing;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Url {

    private String id;
    private String url;
    private LocalDateTime created;

    public Url(String url) {
        this.id = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
        this.url = url;
        this.created = LocalDateTime.now();
    }
}
