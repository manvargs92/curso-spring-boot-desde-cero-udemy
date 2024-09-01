package com.manvargs.curso.springboot.error.springboot_error.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/app")
    public String index() {
        // int value = 100 / 0;
        int value = Integer.parseInt("10abc");
        System.out.println(value);
        return "OK 200";
    }

}
