package com.manvargs.curso.springboot.webapp.springboot_web.controllers;

import com.manvargs.curso.springboot.webapp.springboot_web.models.User;
import com.manvargs.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PathVariableController {

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
}
