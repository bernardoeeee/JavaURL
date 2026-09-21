package com.bvf.JavaURL.controller;

import com.bvf.JavaURL.domain.Url;
import com.bvf.JavaURL.service.JavaUrlService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
// @RestController -> @Controller, @RespondeBody
@RequestMapping("/javaUrl")
public class JavaUrlController {

    @Autowired
    // @Autowired nao precisa criar contrutores
    private JavaUrlService javaUrlService;

    @GetMapping
    public String index() {
        return "asdasd";
    }

    @PostMapping
    public ResponseEntity<Url> criarUrl(@Valid @RequestBody Url body) {
        Url salva = javaUrlService.encurtar(body.getUrlDefault(), body.getUrlShort());
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Url> getUrl(@PathVariable UUID id) {
        Optional<Url> buscar = javaUrlService.getUrl(id);

        if (buscar.isPresent()) {
            return ResponseEntity.ok(buscar.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
