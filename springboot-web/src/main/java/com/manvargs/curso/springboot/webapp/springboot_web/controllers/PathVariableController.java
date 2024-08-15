package com.manvargs.curso.springboot.webapp.springboot_web.controllers;

import com.manvargs.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
