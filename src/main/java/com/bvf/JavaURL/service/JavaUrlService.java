package com.bvf.JavaURL.service;

import com.bvf.JavaURL.domain.Url;
import com.bvf.JavaURL.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JavaUrlService {
    @Autowired
    private UrlRepository urlRepository;

    public Url encurtar(Url url) {
        return urlRepository.save(url);
    }

    public Optional<Url> getUrl(Long id) {
        return urlRepository.findById(id);
    }
}
