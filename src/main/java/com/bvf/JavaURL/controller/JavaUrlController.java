package com.bvf.JavaURL.controller;

import com.bvf.JavaURL.domain.Url;
import com.bvf.JavaURL.service.JavaUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RestController -> @Controller, @RespondeBody
@RequestMapping("/javaUrl")
public class JavaUrlController {

    @Autowired
//    @Autowired nao precisa criar contrutores
    private JavaUrlService javaUrlService;

    @GetMapping("/{id}")
    public String getUrl(@PathVariable String id){
        return "asd";
    }

    @PostMapping
    public ResponseEntity<Url> criarUrl(@RequestBody Url body) {
        Url salva = javaUrlService.encurtar(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }
}
