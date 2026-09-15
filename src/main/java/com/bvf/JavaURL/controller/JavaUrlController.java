package com.bvf.JavaURL.controller;

import com.bvf.JavaURL.domain.Url;
import com.bvf.JavaURL.service.JavaUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@RestController -> @Controller, @RespondeBody
@RequestMapping("/javaUrl")
public class JavaUrlController {

    @Autowired
//    @Autowired nao precisa criar contrutores
    private JavaUrlService javaUrlService;


    @PostMapping
    public ResponseEntity<Url> criarUrl(@RequestBody Url body) {
        Url salva = javaUrlService.encurtar(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Url> getUrl(@PathVariable Long id) {
        Optional<Url> buscar = javaUrlService.getUrl(id);

        if (buscar.isPresent()) {
            return ResponseEntity.ok(buscar.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
