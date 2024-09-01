package com.manvargs.curso.springboot.error.springboot_error.controllers;

import com.manvargs.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.manvargs.curso.springboot.error.springboot_error.models.domain.User;
import com.manvargs.curso.springboot.error.springboot_error.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private IUserService service;

    @GetMapping
    public String index() {
        // int value = 100 / 0;
        int value = Integer.parseInt("10abc");
        System.out.println(value);
        return "OK 200";
    }

    // con el uso de Optional
    @GetMapping("/show/{id}")
    public User show(@PathVariable Long id) {

        User user = service.findById(id).orElseThrow(() -> new UserNotFoundException("Error: el usuario no existe."));

//        User user = service.findById(id);

//        if (user == null) {
//            throw new UserNotFoundException("Error: el usuario no existe.");
//        }

        System.out.println(user.getLastName());
        return user;
    }

}
