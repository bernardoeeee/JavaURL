package com.bvf.JavaURL.service;

import com.bvf.JavaURL.domain.Url;
import com.bvf.JavaURL.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JavaUrlService {

    private final UrlRepository urlRepository;

    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int TAMANHO_CODIGO = 7;
    private static final SecureRandom RANDOM = new SecureRandom();

    private String gerarCodigoAleatorio() {
        StringBuilder codigo = new StringBuilder();

        for (int i = 0; i < TAMANHO_CODIGO; i++) {
            int posicao = RANDOM.nextInt(BASE62.length());
            char letra = BASE62.charAt(posicao);
            codigo.append(letra);
        }

        return codigo.toString();
    }

    private String generateShortUrl() {
        String codigo;

        do {
            codigo = gerarCodigoAleatorio();
        } while (urlRepository.findByUrlShort(codigo).isPresent());

        return codigo;
    }

    @Transactional
    public Url encurtar(String urlDefault) {
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