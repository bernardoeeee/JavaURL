package com.bvf.JavaURL.repository;

import com.bvf.JavaURL.domain.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByUrlEncurtada(String urlEncurtada);
}
