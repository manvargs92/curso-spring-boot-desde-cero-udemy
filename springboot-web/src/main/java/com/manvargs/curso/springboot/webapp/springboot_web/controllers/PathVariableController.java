package com.manvargs.curso.springboot.webapp.springboot_web.controllers;

import com.manvargs.curso.springboot.webapp.springboot_web.models.User;
import com.manvargs.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PathVariableController {

    // inyecta como atributos de la clase, valores que se encuentran el application.properties
    @Value("${config.code}")
    private int code;
    @Value("${config.username}")
    private String username;
//    @Value("${config.message}")
//    private String message;
    @Value("${config.listOfValues}")
    private String[] listOfValues;


    @GetMapping("/request-with-pathvariable/{message}")
    public ParamDto requestWithPathVariable(@PathVariable String message) { // el parámetro con @PathVariable siempre es requerido
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/several-pathvariables/{code}/{message}/{product}")
    public Map<String, Object> severalPathVariables(@PathVariable int code, @PathVariable String message, @PathVariable String product) {
        Map<String, Object> variables = new HashMap<>();

        variables.put("code", code);
        variables.put("message", message);
        variables.put("product", product);

        return variables;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) { // pasar un body al request
        // aquí se haría algo con el usuario p.ej. guardar en la BD
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> inyectedValues(@Value("${config.message}") String message) { // también se pueden inyectar como argumentos
        Map<String, Object> json = new HashMap<>();

        json.put("code", code);
        json.put("username", username);
        json.put("message", message);
        json.put("listOfValues", listOfValues);

        return json;
    }
}
