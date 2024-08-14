package com.manvargs.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController // indica a Spring Boot que es una clase controladora Rest
@RequestMapping("/api/rest") // dar una ruta principal al controlador
public class UserRestController {

    @GetMapping("/details") // indica que es una petición GET
    public Map<String, Object> details() {
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola, Mundo con Spring Boot!!");
        body.put("name", "Manuel");
        body.put("lastName", "Vargas");

        return body; // si trabajamos con servicios Rest, los controladores deben retornar JSON
    }

    @RequestMapping(path="/moredetails", method=RequestMethod.GET) // anotación cuyos parámetros indican manualmente el path y el método de la petición
    public Map<String, Object> moreDetails() {
        Map<String, Object> body = new HashMap<>();

        body.put("example", "Un ejemplo usando @RequestMapping en el método.");

        return body;
    }

}
