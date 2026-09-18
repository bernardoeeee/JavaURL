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

    @Transactional
    public Url encurtar(String urlDefault) {
        return urlRepository.findByUrlDefault(urlDefault)
                .orElseGet(() -> {
                    Url url = new Url();
                    url.setUrlDefault(urlDefault);
//                    url.setUrlShort(gerarCodigoUnico());
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