package com.manvargs.curso.springboot.error.springboot_error.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // indica que es una clase controladora para manejar las excepciones
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class) // en vez de una ruta, el el tipo de excepción que va a capturar
    public ResponseEntity<?> divisionByCero(Exception ex) { // ResponseEntity - es una entidad que va en el body de la respuesta; <?> valor genérico (cualquier tipo)
        return ResponseEntity.internalServerError().body("Error 500"); // internalServerError - error 500
    }
}
