package com.bvf.JavaURL.controller;

import com.bvf.JavaURL.domain.User;
import com.bvf.JavaURL.service.JavaURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RestController -> @Controller, @RespondeBody
@RequestMapping("/hello-world")
public class JavaURLController {

    @Autowired
//    @Autowired nao precisa criar contrutores
    private JavaURLService javaURLService;

    @GetMapping
    public String helloWorld(){
        return javaURLService.helloWorld("Bernardo");
    }

    @PostMapping("/{id}")
    public String helloWorldPost(@PathVariable String id,@RequestBody User body){
        return "Oi " + body.getName() + " mandamos uma mensagem para o e-mail " + body.getEmail() + id;

    }
}
