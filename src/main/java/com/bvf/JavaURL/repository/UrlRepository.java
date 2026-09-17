package com.bvf.JavaURL.repository;

import com.bvf.JavaURL.domain.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    // save() e findById() ja vem prontos do JpaRepository

    // busca pela url original -> evita encurtar a mesma url duas vezes
    Optional<Url> findByUrlDefault(String urlDefault);

    // busca pelo codigo encurtado -> usado no redirect e para checar colisao do
    // Base62
    Optional<Url> findByUrlShort(String urlShort);
}
