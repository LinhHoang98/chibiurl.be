package io.linhhn.chibiurl.service;

import io.linhhn.chibiurl.model.URLModel;
import io.linhhn.chibiurl.repository.URLRepository;
import org.springframework.stereotype.Service;

@Service
public class URLService {
    private final URLRepository urlRepository;

    private long counter = 1000000; // Starting counter to ensure minimum key length
    private static final int KEY_LENGTH = 7;
    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public URLService(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String shortenURL(String rawUrl) {
        counter++;
        String shortKey = encode(counter, KEY_LENGTH);
        urlRepository.save(new URLModel(shortKey, rawUrl));
        return shortKey;
    }

    public static String encode(long num, int length) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            int remainder = (int) (num % 62);
            sb.append(BASE62.charAt(remainder));
            num /= 62;
        }

        while (sb.length() < length) {
            sb.append('0');
        }

        return sb.reverse().toString();
    }
}
