package com.manvargs.curso.springboot.error.springboot_error.exceptions;

import com.manvargs.curso.springboot.error.springboot_error.models.domain.User;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

}
