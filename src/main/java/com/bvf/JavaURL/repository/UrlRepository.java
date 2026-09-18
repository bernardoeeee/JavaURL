package com.bvf.JavaURL.repository;

import com.bvf.JavaURL.domain.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UrlRepository extends JpaRepository<Url, UUID> {

    Optional<Url> findByUrlDefault(String urlDefault);
    Optional<Url> findByUrlShort(String urlShort);

    boolean existsByUrlShort(String urlShort);
}
