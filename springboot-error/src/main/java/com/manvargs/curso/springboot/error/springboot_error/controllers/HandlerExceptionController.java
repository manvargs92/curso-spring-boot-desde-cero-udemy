package com.manvargs.curso.springboot.error.springboot_error.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.manvargs.curso.springboot.error.springboot_error.models.Error;

@RestControllerAdvice // indica que es una clase controladora para manejar las excepciones
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class) // en vez de una ruta, el el tipo de excepción que va a capturar
    // public ResponseEntity<?> divisionByCero(Exception ex) { // ResponseEntity - es una entidad que va en el body de la respuesta; <?> valor genérico (cualquier tipo)
    public ResponseEntity<Error> divisionByCero(Exception ex) { // ResponseEntity - es una entidad que va en el body de la respuesta; <?> valor genérico (cualquier tipo)
        Error error = new Error();

        error.setDate(new Date());
        error.setError("Error: ¡División entre 0!");
        error.setMessage(ex.getMessage());

        // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
        
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value()); // HttpStatus.INTERNAL_SERVER_ERROR - 500
        return ResponseEntity.internalServerError().body(error); // internalServerError - error 500


    }
}
