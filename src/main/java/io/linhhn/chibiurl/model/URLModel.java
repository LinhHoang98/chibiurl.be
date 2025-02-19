package io.linhhn.chibiurl.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class URLModel {
    @Id
    private String hash;
    private String rawUrl;

    public URLModel(String hash, String rawUrl) {
        this.hash = hash;
        this.rawUrl = rawUrl;
    }

    public URLModel() {

    }
}
