package com.bvf.JavaURL.service;

import org.springframework.stereotype.Service;

@Service
public class JavaURLService {
    public String helloWorld(String name){
        return "Hello World " + name;
    }
}
