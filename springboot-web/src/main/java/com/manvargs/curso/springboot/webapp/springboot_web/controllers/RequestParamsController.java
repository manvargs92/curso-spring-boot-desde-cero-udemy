package com.manvargs.curso.springboot.webapp.springboot_web.controllers;

import com.manvargs.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-params")
public class RequestParamsController {

    @GetMapping("/send-one-parameter")
    public ParamDto getParam(
            @RequestParam( // @RequestParam pasar parámetros a través de la ruta url con url?parámetro=valor
                    required = false, // setear si el parámetro es requerido o no
                    defaultValue = "Sin mensaje.", // setear un valor (mensaje) por defecto
                    name = "Mensajito") String message) { // setear el nombre del parámetro
        ParamDto paramDto = new ParamDto();

        paramDto.setMessage(message);
//        paramDto.setMessage(message != null ? message : "Sin mensaje."); // setear un mensaje por default

        return paramDto;
    }

    @GetMapping("/send-parameters")
    public ParamDto getParams(@RequestParam String text, @RequestParam int code) { // pasar múltiples parámetros con url?parámetro=valor&parámetro=valor
        ParamDto paramsDto = new ParamDto();

        paramsDto.setMessage(text);
        paramsDto.setCode(code);

        return paramsDto;
    }

    @GetMapping("/request")
    public ParamDto requestFromHttpServlet(HttpServletRequest request) { // inyectamos el objeto HttpServletRequest en vez de usar anotaciones
        int code = 0;

        try {
            Integer.parseInt( request.getParameter("code") ); // .getParameter siempre recive un String
        }
        catch (NumberFormatException exc) {}

        ParamDto paramDto = new ParamDto();

        paramDto.setCode(code);
        paramDto.setMessage(request.getParameter("message"));

        return paramDto;
    }

}
