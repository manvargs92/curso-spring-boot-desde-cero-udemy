package com.manvargs.curso.springboot.webapp.springboot_web.controllers;

/* Un controlador es una clase común que maneja métodos del request conocidos como "Métodos Handler" */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // indica a Spring que es una clase controladora
public class UserMvcController {

    @GetMapping("/mvc/details") // indica que es una petición GET
    public String details(Model model) { // Model se utiliza para pasarle datos a la vista
        model.addAttribute("title", "Hola, Mundo con Spring Boot!!");
        model.addAttribute("name", "Manuel");
        model.addAttribute("lastName", "Vargas");

        return "details"; // si trabajamos con el modelo MVC los controladores deben retornar vistas o plantillas HTML del lado del servidor
    }

}
