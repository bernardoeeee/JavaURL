package com.bvf.JavaURL.service;

import com.bvf.JavaURL.domain.Url;
import com.bvf.JavaURL.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JavaUrlService {

    private final UrlRepository urlRepository;

    private String base62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private Url urlCodigoUrl(String urlDefault) {
        String codigo = urlDefault.substring(urlDefault.lastIndexOf("/") + 1);
        codigo = codigo.split("\\?")[0];
        return urlRepository.findByUrlShort(codigo).orElse(null);
    }

    private String generateShortUrl() {
        long randomValue = (long) (Math.random() * Long.MAX_VALUE);
        return urlCodigoUrl(randomValue);
    }

    @Transactional
    public Url encurtar(String urlDefault, String urlShort) {
        return urlRepository.findByUrlDefault(urlDefault)
                .orElseGet(() -> {
                    Url url = new Url();
                    url.setUrlDefault(urlDefault);
                    url.setUrlShort(generateShortUrl());
                    return urlRepository.save(url);
                });
    }

    @Transactional(readOnly = true)
    public Optional<Url> getUrl(UUID id) {
        return urlRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Url> getByCodigo(String urlShort) {
        return urlRepository.findByUrlShort(urlShort);
    }

}