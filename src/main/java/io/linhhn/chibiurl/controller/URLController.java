package io.linhhn.chibiurl.controller;

import io.linhhn.chibiurl.service.URLService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLController {
    private final URLService urlService;

    public URLController(URLService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<String> shorten(@RequestParam("rawUrl") String rawUrl) {
        return new ResponseEntity<>(urlService.shortenURL(rawUrl), HttpStatus.OK);
    }
}
