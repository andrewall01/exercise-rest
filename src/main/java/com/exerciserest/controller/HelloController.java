package com.exerciserest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.message}")
    String message;

    @GetMapping("/")
    public String saludar(){
        System.out.println(message);
        return "Esta es la página principal de Hello Controller desde el proyecto Laptop";
    }

}
